package ex04;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String massege) {
        super(massege);
    }
}
