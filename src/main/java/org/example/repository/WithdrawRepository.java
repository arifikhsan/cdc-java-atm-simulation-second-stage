package org.example.repository;

import org.example.model.WithdrawModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static org.example.repository.AccountRepository.getAccountById;
import static org.example.util.TimeUtil.getCurrentTime;

public class WithdrawRepository {
    private static final Path path = Paths.get("src/main/resources/transactions/withdraws.csv");

    public WithdrawRepository() {
    }

    public static List<WithdrawModel> getWithdraws() {
        return getWithdrawModelStream().toList();
    }

    private static Stream<WithdrawModel> getWithdrawModelStream() {
        try {
            return Files.readAllLines(path)
                    .stream()
                    .skip(1)
                    .map(text -> text.split(","))
                    .map(parts -> {
                        var id = UUID.fromString(parts[0]);
                        var amount = Integer.parseInt(parts[1]);
                        var balance = Integer.parseInt(parts[2]);
                        var datetime = LocalDateTime.parse(parts[3]);
                        var accountId = UUID.fromString(parts[4]);
                        var actorId = UUID.fromString(parts[5]);
                        var happenedAt = LocalDateTime.parse(parts[6]);

                        var account = getAccountById(accountId);
                        var actor = getAccountById(actorId);
                        return new WithdrawModel(id, account, happenedAt, amount, balance, datetime, actor);
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void save(WithdrawModel withdraw) {
        withdraw.setId(UUID.randomUUID());
        withdraw.setHappenedAt(getCurrentTime());

        var row = String.format("%s,%s,%s,%s,%s,%s,%s",
                withdraw.getId(),
                withdraw.getAmount(),
                withdraw.getBalance(),
                withdraw.getDatetime(),
                withdraw.getAccount().getId(),
                withdraw.getActor().getId(),
                withdraw.getHappenedAt());
        try {
            Files.writeString(path, row + "\n", APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearContents() {
        var header = "Id,Amount,Balance,Datetime,AccountId,ActorId,HappenedAt" + System.lineSeparator();
        try {
            Files.writeString(path, header, TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
