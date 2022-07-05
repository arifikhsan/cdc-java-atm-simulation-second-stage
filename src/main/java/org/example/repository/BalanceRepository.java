package org.example.repository;

import org.example.model.BalanceInquiryModel;

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
import static org.example.repository.AccountRepository.getAccountById;
import static org.example.util.TimeUtil.getCurrentTime;

public class BalanceRepository {
    private static final Path path = Paths.get("src/main/resources/transactions/balance-inquiries.csv");

    public static List<BalanceInquiryModel> getInquiries() {
        return getInquiriesStream().toList();
    }

    private static Stream<BalanceInquiryModel> getInquiriesStream() {
        try {
            return Files.readAllLines(path)
                    .stream()
                    .skip(1)
                    .map(text -> text.split(","))
                    .map(parts -> {
                        var id = UUID.fromString(parts[0]);
                        var balance = parseInt(parts[1]);
                        var accountId = UUID.fromString(parts[2]);
                        var actorId = UUID.fromString(parts[3]);
                        var happenedAt = LocalDateTime.parse(parts[4]);
                        var account = getAccountById(accountId);
                        var actor = getAccountById(actorId);

                        return new BalanceInquiryModel(id, actor, happenedAt, balance, account);
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void save(BalanceInquiryModel inquiry) {
        inquiry.setId(UUID.randomUUID());
        inquiry.setHappenedAt(getCurrentTime());

        var row = String.format("%s,%s,%s,%s,%s",
                inquiry.getId(),
                inquiry.getBalance(),
                inquiry.getAccount().getId(),
                inquiry.getActor().getId(),
                inquiry.getHappenedAt());
        try {
            Files.writeString(path, row + "\n", APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearContents() {
        var header = "Id,Balance,AccountId,ActorId,HappenedAt";
        try {
            Files.writeString(path, header, TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
