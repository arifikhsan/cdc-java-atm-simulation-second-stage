package org.example.repository;

import org.example.model.TransferModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static org.example.util.TimeUtil.getCurrentTime;

public class TransferRepository {
    private static final Path path = Paths.get("src/main/resources/transactions/transfers.csv");

    public static List<TransferModel> getTransfers() {
        return getTransfersStream().toList();
    }

    private static Stream<TransferModel> getTransfersStream() {
        try {
            return Files.readAllLines(path)
                    .stream()
                    .skip(1)
                    .map(text -> text.split(","))
                    .map(parts -> {
                        var id = UUID.fromString(parts[0]);
                        var fromAccountId = UUID.fromString(parts[1]);
                        var toAccountId = UUID.fromString(parts[2]);
                        var amount = parseInt(parts[3]);
                        var datetime = LocalDateTime.parse(parts[4]);
                        var reference = parseInt(parts[5]);
                        var actorId = UUID.fromString(parts[6]);
                        var happenedAt = LocalDateTime.parse(parts[7]);

                        var fromAccount = AccountRepository.getAccountById(fromAccountId);
                        var toAccount = AccountRepository.getAccountById(toAccountId);
                        var actor = AccountRepository.getAccountById(actorId);

                        return new TransferModel(id, actor, happenedAt, fromAccount, toAccount, amount, datetime, reference);
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void save(TransferModel transferModel) {
        transferModel.setId(UUID.randomUUID());
        transferModel.setHappenedAt(getCurrentTime());

        var row = String.format("%s,%s,%s,%s,%s,%s,%s,%s",
                transferModel.getId(),
                transferModel.getFromAccount().getId(),
                transferModel.getToAccount().getId(),
                transferModel.getAmount(),
                transferModel.getDateTime(),
                transferModel.getReference(),
                transferModel.getActor().getId(),
                transferModel.getHappenedAt());
        try {
            Files.writeString(path, row + "\n", APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearContents() {
        var header = "Id,FromAccountId,ToAccountId,Amount,Datetime,Reference,ActorId,HappenedAt";
        try {
            Files.writeString(path, header, TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
