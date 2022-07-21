package ex01;

public class UserIdsGenerator {
    private static UserIdsGenerator UserIdsGenerator;
    private int idUser;

    private UserIdsGenerator(){}

    public static UserIdsGenerator getInstance() {
        if (UserIdsGenerator == null) {
            UserIdsGenerator = new UserIdsGenerator();
        }
        return UserIdsGenerator;
    }

    public int generatorId() {
        return ++idUser;
    }
}
