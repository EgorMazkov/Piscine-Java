package ex00;
import static ex00.Category.RECEIVING;
import static ex00.Category.SENDING;
import static ex00.Transaction.*;

public class Program {
    public static void main(String[] args) {
        User userOne = new User("Biba", 500);
        User userTwo = new User("Boba", 1542);
        userOne.printUserData();
        userTwo.printUserData();

        Transaction transaction1 = new Transaction(userOne, userTwo, 100, SENDING);
        transaction1.printTransfer();


        Transaction transaction2 = new Transaction(userOne, userTwo, 1000, RECEIVING);
        transaction2.printTransfer();
    }

    public static void printError(String massage) {
        System.out.println(massage);
        System.exit(-1);
    }
}
