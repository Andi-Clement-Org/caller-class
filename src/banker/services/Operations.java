package banker.services;

import banker.models.Account;
import banker.models.Bank;
import banker.models.Customer;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class Operations extends Skeleton {

    private ArrayList<Customer> customers;
    private ArrayList<Bank> banks;
    private ArrayList<Account> accounts;

    public Operations() {
    }

    public Operations(ArrayList<Customer> customers, ArrayList<Bank> banks, ArrayList<Account> accounts) {
        this.accounts = accounts;
        this.banks = banks;
        this.customers = customers;
    }

    @Override
    public Customer newCustomer(Integer uuid, String full_name, String email) {
        return new Customer(uuid, full_name, email);
    }

    @Override
    public Bank newBank(Integer uuid, String name) {
        return new Bank(uuid, name);
    }

    @Override
    public Account saveMoney(Bank bank, Customer customer, double amount) {
        return new Account(bank, customer, amount);
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        AtomicReference<Customer> customer = null;
        customers.forEach(customer1 -> {
            if (customer1.getEmail().equals(email)) {
                assert false;
                customer.set(customer1);
            }
        });
        assert false;
        return customer.get();
    }

    @Override
    public Customer findCustomerByFullName(String fullName) {
        ArrayList<Customer> customer = new ArrayList<>();
        customers.forEach(customer1 -> {
            System.out.println("Happy to find you Mr: " + customer1.getFull_name() + " ::: " + fullName);
            if (Objects.equals(customer1.getFull_name(), fullName)) {
                System.out.println("I am here");
                customer.add(customer1);
            }
        });
        return null;
    }

    @Override
    public Customer findCustomerByUuid(String uuid) {
        return null;
    }

    @Override
    public Account getUserAccountInfo(String customerEmail, String bankName) {
        return null;
    }

    @Override
    public Bank findBankByName(String name) {
        return null;
    }

    @Override
    public Bank findBankByUuid(String uuid) {
        return null;
    }
}
