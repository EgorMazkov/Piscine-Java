package ex04;

public class UsersArrayList implements UsersList {
    private static int NUMBERUSER = 10;
    User[] arrUser = new User[NUMBERUSER];
    private static int numberUsers = 0;

    @Override
    public void addUser(User user) {
        if (numberUsers == NUMBERUSER) {
            User[] newMass = arrUser;
            System.out.println(newMass.length);
            NUMBERUSER *= 2;
            arrUser = new User[NUMBERUSER];
            for (int i = 0; i != numberUsers; i++) {
                arrUser[i] = newMass[i];
            }
        }
        arrUser[numberUsers] = user;
        numberUsers++;
    }

    public int getNumberUsers() {
        return numberUsers;
    }

    @Override
    public User retrieveUserById(int id)  {
        for (int i = 0; i != arrUser.length; i++) {
            if (arrUser[i].getIdUser() == id) {
                arrUser[i].printUserData();
                return arrUser[i];
            }
        }
        throw new UserNotFoundException("Exception: id:" + id + " not found");
    }
    @Override
    public User retrieveUserByIndex(int index) {
        return arrUser[index];
    }

    @Override
    public int retrieveTheNumberOfUsers() {
        return numberUsers;
    }
}
