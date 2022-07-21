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

    public void performingTransferTransaction(int sending, int receiving, int amount) {
        UUID idTransaction;
        String categorySendingReceiving;
        int temp = 0;

        User sendingUser = list.retrieveUserById(sending);

        User receivingUser = list.retrieveUserById(receiving);

        if (amount > 0) {
            if (sendingUser.getBalanc() - amount < 0) {
                throw new IllegalTransactionException("Exception: insufficient funds");
            }
            sendingUser.setBalanc(sendingUser.getBalanc() - amount);
            receivingUser.setBalanc(receivingUser.getBalanc() + amount);
            Transaction transactionOne = new Transaction(sendingUser, receivingUser, amount * -1, SENDING);
            Transaction transactionTwo = new Transaction(receivingUser, sendingUser, amount, RECEIVING);
            transactionTwo.setIdentifier(transactionOne.getIdentifier());
            sendingUser.getList().addTransaction(transactionOne);
            receivingUser.getList().addTransaction(transactionTwo);
        } else {
            if (receivingUser.getBalanc() - amount < 0) {
                throw new IllegalTransactionException("Exception: insufficient funds");
            }
            amount *= -1;
            sendingUser.setBalanc(sendingUser.getBalanc() + amount);
            receivingUser.setBalanc(receivingUser.getBalanc() -amount);
            Transaction transactionOne = new Transaction(sendingUser, receivingUser, amount, RECEIVING);
            Transaction transactionTwo = new Transaction(sendingUser, receivingUser, amount * -1, SENDING);
            transactionTwo.setIdentifier(transactionOne.getIdentifier());
            sendingUser.getList().addTransaction(transactionOne);
            receivingUser.getList().addTransaction(transactionTwo);
        }
    }

    public Transaction[] retrievingTransfersOfSpecificUser(int id) {
        return list.retrieveUserById(id).getList().toArray();
    }

    public void     removeTransaction(UUID idTransaction, int idUser) {
        User user = list.retrieveUserById(idUser);
        TransactionsList transaction = user.getList();
        transactionsList.addTransaction(transaction.findTracsactionById(idTransaction));
        transaction.deleteTransaction(idTransaction);

    }

    public Transaction[] checkValidityOfTransactions() {
        return transactionsList.toArray();
    }
}
