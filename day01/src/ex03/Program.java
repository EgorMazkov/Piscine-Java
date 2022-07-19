package ex03;

public class Program {
    public static void main(String[] args) {
        User biba = new User("Biba", 500);
        User boba = new User("Boba", 1);

        Transaction transaction = new Transaction(biba, boba, 50, Category.SENDING);
        TransactionsLinkedList transactionsList = new TransactionsLinkedList();

        transactionsList.addTransaction(transaction);
    }

    public static void printError(String massage) {
        System.out.println(massage);
        System.exit(-1);
    }
}
