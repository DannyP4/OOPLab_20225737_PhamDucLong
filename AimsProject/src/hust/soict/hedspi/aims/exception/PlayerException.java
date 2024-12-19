package hust.soict.hedspi.aims.exception;

public class PlayerException extends Exception {
    public PlayerException(String message) {
        super(message);
    }

    public void printStackTrace() {
        System.out.println("PlayerException: " + this.getMessage());
    }
}
