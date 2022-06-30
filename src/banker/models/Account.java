package banker.models;

public class Account {
    private Bank bank;
    private Customer customer;
    private double balance;

    public Account() {
    }

    public Account(Bank bank, Customer customer, double balance) {
        this.bank = bank;
        this.customer = customer;
        this.balance = balance;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "bank=" + bank +
                ", customer=" + customer +
                ", balance=" + balance +
                '}';
    }
}
