package ex01;

import static ex01.Program.printError;

public class User {

    private  int idUser;
    private String name;
    private long balanc;

    User(String name, long balanc) {
        this.idUser = UserIdsGenerator.getInstance().generatorId();
        setName(name);
        if (balanc > 0) {
            this.balanc = balanc;
        } else {
            printError("negative balance cannot be");
        }
    }

    public String getName() {
        return name;
    }

    public long getBalanc() {
        return balanc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalanc(long balanc) {
        this.balanc = balanc;
    }

    public int getIdUser() {
        return idUser;
    }

    public void printUserData() {
        System.out.println("-----------------------------------------\n" +
                "User\n" +
                "User ID: " + getIdUser() + "\n" +
                "Name User: " + getName() + "\n" +
                "Balanc: " + getBalanc() + "\n" +
                "-----------------------------------------\n");
    }
}
