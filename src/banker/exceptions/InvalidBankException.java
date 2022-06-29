package banker.exceptions;

public class InvalidBankException extends Exception {

    public InvalidBankException(String errorMessage) {
        super(("".equals(errorMessage)) ? "Invalid Bank Provided" : errorMessage);
    }

}