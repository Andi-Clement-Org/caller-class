package banker.exceptions;

public class InvalidCustomerException extends Exception {

    public InvalidCustomerException(String errorMessage) {
        super(("".equals(errorMessage)) ? "We cannot identify this customer" : errorMessage);
    }

}
