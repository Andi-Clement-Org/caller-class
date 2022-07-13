package banker.services;

import banker.models.Account;
import banker.models.Bank;
import banker.models.Customer;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

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
    public Customer newCustomer(Integer uuid, String full_name, String email) throws Exception {
        if (this.customers != null) {
            if (findCustomerByEmail(email) != null) throw new Exception("You cannot have duplicate email entries");
            if (findCustomerByFullName(full_name) != null) throw new Exception("You cannot have duplicate full name entries");
        }
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
        ArrayList<Customer> customer = new ArrayList<>();
        customers.forEach(customer1 -> {
            if (Objects.equals(customer1.getEmail(), email)) customer.add(customer1);
        });
        return customer.size() > 0 ? customer.get(0) : null;
    }

    @Override
    public Customer findCustomerByFullName(String fullName) {
        ArrayList<Customer> customer = new ArrayList<>();
        customers.forEach(customer1 -> {
            if (Objects.equals(customer1.getFull_name(), fullName)) customer.add(customer1);
        });
        return customer.size() > 0 ? customer.get(0) : null;
    }

    @Override
    public Customer findCustomerByUuid(Integer uuid) {
        ArrayList<Customer> customer = new ArrayList<>();
        customers.forEach(customer1 -> {
            if (Objects.equals(customer1.getUuid(), uuid)) customer.add(customer1);
        });
        return customer.size() > 0 ? customer.get(0) : null;
    }

    @Override
    public Account getUserAccountInfo(String customerEmail, String bankName) {
        return null;
    }

    @Override
    public Bank findBankByName(String name) {
        ArrayList<Bank> bank = new ArrayList<>();
        banks.forEach(bank1 -> {
            if (Objects.equals(bank1.getName(), name)) bank.add(bank1);
        });
        return bank.get(0);
    }

    @Override
    public Bank findBankByUuid(Integer uuid) {
        ArrayList<Bank> bank = new ArrayList<>();
        banks.forEach(bank1 -> {
            if (Objects.equals(bank1.getUuid(), uuid)) bank.add(bank1);
        });
        return bank.get(0);
    }

    @Override
    public ArrayList<Account> getCustomerAccountEmail(String customerEmail) {
        ArrayList<Account> localAcc = new ArrayList<>();
        accounts.forEach(account -> {
            if (Objects.equals(account.getCustomer().getEmail(), customerEmail)) localAcc.add(account);
        });
        return localAcc;
    }

    @Override
    public ArrayList<Account> getCustomerAccountName(String customerName) {
        ArrayList<Account> localAcc = new ArrayList<>();
        accounts.forEach(account -> {
            if (Objects.equals(account.getCustomer().getFull_name(), customerName)) localAcc.add(account);
        });
        return localAcc;
    }

    @Override
    public Optional<Account> getAccountByCustomer(Customer customer, Bank bank) {
        ArrayList<Account> localAcc = new ArrayList<>();
        accounts.forEach(account -> {
            if (Objects.equals(account.getCustomer(), customer) && Objects.equals(account.getBank(), bank)) localAcc.add(account);
        });
        return localAcc.size() <= 0 ? Optional.empty() : Optional.ofNullable(localAcc.get(0));
    }
}
