package ex04;

import java.util.UUID;

public interface TransactionsList {
    void addTransaction(Transaction transaction);
    void deleteTransaction(UUID i);
    Transaction[] toArray();
    Transaction findTracsactionById(UUID id);
}
