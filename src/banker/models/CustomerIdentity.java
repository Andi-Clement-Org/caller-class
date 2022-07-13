package banker.models;

public class CustomerIdentity {
    private Customer customer;
    private String identity;

    public CustomerIdentity() {
    }

    public CustomerIdentity(Customer customer, String identity) {
        this.customer = customer;
        this.identity = identity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
