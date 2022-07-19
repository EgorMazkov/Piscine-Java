package ex02;

public class Program {
    public static void main(String[] args) {
        int sizeMassUser = 0;
        UsersArrayList list = new UsersArrayList();
        User one = new User("Bob", 500);
        list.addUser(one);
        list.retrieveUserByIndex(0).printUserData();
    }

    public static void printError(String massage) {
        System.out.println(massage);
        System.exit(-1);
    }
}
