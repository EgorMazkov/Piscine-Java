package ex04;

import java.util.UUID;

import static ex04.Category.RECEIVING;
import static ex04.Category.SENDING;

public class TransactionsService {
    private final UsersList list;

    private final TransactionsList transactionsList = new TransactionsLinkedList();

    public TransactionsService() {
        this.list = new UsersArrayList();
    }

    public void addUsers(User user) {
        list.addUser(user);
    }

    public long getBalancOfUsersForId(int id) {
        User user = list.retrieveUserById(id);
        return user.getBalanc();
    }

    public void performingTransferTransaction(int idUserOne, int idUserTwo, int amount) {
        UUID idTransaction;

        User userOne = list.retrieveUserById(idUserOne);

        User userTwo = list.retrieveUserById(idUserTwo);

        if (amount <= 0) {
            if (userTwo.getBalanc() + amount < 0) {
                throw new IllegalAccessException("Exception: when you try to withdraw, the balance will be negative");
            }
            userTwo.setBalanc(userTwo.getBalanc() - amount);
            userOne.setBalanc(userOne.getBalanc() - amount);
            Transaction transactionUserOne = new Transaction(userTwo, userOne, amount * -1, SENDING);
            Transaction transactionUserTwo = new Transaction(userOne, userTwo, amount, RECEIVING);
            userTwo.getList().addTransaction(transactionUserOne);
            idTransaction = transactionUserOne.getIdentifier();
            transactionUserTwo.setIdentifier(idTransaction);
            userOne.getList().addTransaction(transactionUserTwo);
            return;
        }

        if (userOne.getBalanc() - amount < 0) {
            throw new IllegalAccessException("Exception: when you try to withdraw, the balance will be negative");
        }

        userOne.setBalanc(userOne.getBalanc() - amount);
        userTwo.setBalanc(userTwo.getBalanc() + amount);
        Transaction transactionUserOne = new Transaction(userOne, userTwo, amount * -1, SENDING);
        Transaction transactionUserTwo = new Transaction(userTwo, userOne, amount, RECEIVING);
        userOne.getList().addTransaction(transactionUserOne);
        idTransaction = transactionUserOne.getIdentifier();
        transactionUserTwo.setIdentifier(idTransaction);
        userTwo.getList().addTransaction(transactionUserTwo);
    }

    public Transaction[] retrievingTransfersOfSpecificUser(int id) {
        return list.retrieveUserById(id).getList().toArray();
    }

    public void removeTransaction(UUID idTransaction, int idUser) {
        User user = list.retrieveUserById(idUser);
        TransactionsList transaction = user.getList();
        transactionsList.addTransaction(transaction.findTracsactionById(idTransaction));
        transaction.deleteTransaction(idTransaction);

    }

    public Transaction[] checkValidityOfTransactions() {
        return transactionsList.toArray();
    }
}
