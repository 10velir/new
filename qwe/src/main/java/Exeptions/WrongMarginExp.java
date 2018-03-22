package Exeptions;

public class WrongMarginExp extends Exception {
    public WrongMarginExp(String message) {
        super(message);
    }

    public WrongMarginExp(String message, Exception e) {
        super(message, e);
    }

    public WrongMarginExp(Exception e) {
        super(e);
    }

}
