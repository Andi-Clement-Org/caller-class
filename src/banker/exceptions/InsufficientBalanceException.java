package banker.exceptions;

public class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String errorMessage) {
        super(("".equals(errorMessage)) ? "You have Insufficient Balance" : errorMessage);
    }

}
