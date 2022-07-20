package ex04;

public class Program {
    public static void main(String[] args) {
        TransactionsService service = new TransactionsService();
        User biba = new User("Biba", 500);
        User boba = new User("Boba", 1000);
        User lupa = new User("Lupa", 1500);
        User pupa = new User("Pupa", 2000);

        service.addUsers(biba);
        service.addUsers(boba);
        service.addUsers(lupa);
        service.addUsers(pupa);

        System.out.println("Biba balanc: " + service.getBalancOfUsersForId(biba.getIdUser()));
        System.out.println("Boba balanc: " + service.getBalancOfUsersForId(boba.getIdUser()));
        System.out.println("Lupa balanc: " + service.getBalancOfUsersForId(lupa.getIdUser()));
        System.out.println("Pupa balanc: " + service.getBalancOfUsersForId(pupa.getIdUser()));

        service.performingTransferTransaction(biba.getIdUser(), boba.getIdUser(), 250);
        service.performingTransferTransaction(lupa.getIdUser(), pupa.getIdUser(), -250);
        service.performingTransferTransaction(boba.getIdUser(), biba.getIdUser(), 250);
        service.performingTransferTransaction(pupa.getIdUser(), lupa.getIdUser(), 250);
        service.performingTransferTransaction(pupa.getIdUser(), lupa.getIdUser(), 400);
        service.performingTransferTransaction(pupa.getIdUser(), lupa.getIdUser(), 100);

        Transaction[] transactions = service.retrievingTransfersOfSpecificUser(pupa.getIdUser());

        service.removeTransaction(transactions[0].getIdentifier(), pupa.getIdUser());
        System.out.println("Biba list: \n" + biba.getList());
        System.out.println("Boba list: \n" + boba.getList());
        System.out.println("Lupa list: \n" + lupa.getList());
        System.out.println("Pupa list: \n" + pupa.getList());


    }

    public static void printError(String massage) {
        System.out.println(massage);
        System.exit(-1);
    }
}
