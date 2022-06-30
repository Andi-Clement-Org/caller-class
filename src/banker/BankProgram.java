package banker;

import banker.models.Account;
import banker.models.Bank;
import banker.models.Customer;
import banker.services.Operations;
import banker.services.Utils;

import java.util.ArrayList;

public class BankProgram {

    private ArrayList<Customer> allCustomers = new ArrayList<>();
    private ArrayList<Bank> allBanks = new ArrayList<>();
    private ArrayList<Account> accounts = new ArrayList<>();

    private Operations operations;

    public BankProgram() {
        operations = new Operations();
    }

    public static void main(String[] args) {
        BankProgram program = new BankProgram();
        // seed all customers to arraylist
        program.addCustomers();

        Customer customer = program.findCustomer("name", "Philips Jones");
        System.out.printf("This is Customer %s", (customer != null) ? customer.getFull_name() : "No name");
    }

    private void addCustomers() {
        Customer customerOne = operations.newCustomer(Utils.generateUuid(), "John Miller", Utils.generateRandomAlphaNumeric() + "@gmail.com");
        Customer customerTwo = operations.newCustomer(Utils.generateUuid(), "Philips Jones", Utils.generateRandomAlphaNumeric() + "@gmail.com");
        Customer customerThree = operations.newCustomer(Utils.generateUuid(), "Kingsley Wills", Utils.generateRandomAlphaNumeric() + "@gmail.com");
        Customer customerFour = operations.newCustomer(Utils.generateUuid(), "Maria Smith", Utils.generateRandomAlphaNumeric() + "@gmail.com");
        Customer customerFive = operations.newCustomer(Utils.generateUuid(), "Darlene James", Utils.generateRandomAlphaNumeric() + "@gmail.com");
        Customer customerSix = operations.newCustomer(Utils.generateUuid(), "Matthew Tera", Utils.generateRandomAlphaNumeric() + "@gmail.com");
        allCustomers.add(customerOne);
        allCustomers.add(customerTwo);
        allCustomers.add(customerThree);
        allCustomers.add(customerFour);
        allCustomers.add(customerFive);
        allCustomers.add(customerSix);
    }

    private Customer findCustomer(String findBy, String findValue) {
        operations = new Operations(allCustomers, allBanks, accounts);
        if ("email".equals(findBy)) return operations.findCustomerByEmail(findValue);
        if ("name".equals(findBy)) return operations.findCustomerByFullName(findValue);
        return null;
    }

}
