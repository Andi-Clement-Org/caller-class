package banker;

import banker.models.Account;
import banker.models.Bank;
import banker.models.Customer;
import banker.services.Constants;
import banker.services.Operations;
import banker.services.Utils;

import java.util.ArrayList;

/**
 * //TODO
 * - Make the application interactive
 */

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
        // seed all banks to arraylist
        program.addBanks();

        Customer customer = program.findCustomer("name", "Philips Jones");
        Bank bank = program.findBank("name", "Bank of America");

        Account customerAccount = program.createAccount(bank, customer);

        System.out.printf("This is the new account Information \n %s", customerAccount.toString());

    }

    private void addCustomers() {
        Customer customerOne = operations.newCustomer(Utils.generateUuid(Constants.STARTING_UUID, Constants.ENDING_UUID), "John Miller", Utils.generateRandomAlphaNumeric() + "@gmail.com");
        Customer customerTwo = operations.newCustomer(Utils.generateUuid(Constants.STARTING_UUID, Constants.ENDING_UUID), "Philips Jones", Utils.generateRandomAlphaNumeric() + "@gmail.com");
        Customer customerThree = operations.newCustomer(Utils.generateUuid(Constants.STARTING_UUID, Constants.ENDING_UUID), "Kingsley Wills", Utils.generateRandomAlphaNumeric() + "@gmail.com");
        Customer customerFour = operations.newCustomer(Utils.generateUuid(Constants.STARTING_UUID, Constants.ENDING_UUID), "Maria Smith", Utils.generateRandomAlphaNumeric() + "@gmail.com");
        Customer customerFive = operations.newCustomer(Utils.generateUuid(Constants.STARTING_UUID, Constants.ENDING_UUID), "Darlene James", Utils.generateRandomAlphaNumeric() + "@gmail.com");
        Customer customerSix = operations.newCustomer(Utils.generateUuid(Constants.STARTING_UUID, Constants.ENDING_UUID), "Matthew Tera", Utils.generateRandomAlphaNumeric() + "@gmail.com");
        allCustomers.add(customerOne);
        allCustomers.add(customerTwo);
        allCustomers.add(customerThree);
        allCustomers.add(customerFour);
        allCustomers.add(customerFive);
        allCustomers.add(customerSix);
    }

    public void addBanks() {
        Bank bankOne = operations.newBank(Utils.generateUuid(Constants.STARTING_UUID, Constants.ENDING_UUID), "Zenith Bank");
        Bank bankTwo = operations.newBank(Utils.generateUuid(Constants.STARTING_UUID, Constants.ENDING_UUID), "Wema Bank");
        Bank bankThree = operations.newBank(Utils.generateUuid(Constants.STARTING_UUID, Constants.ENDING_UUID), "GT Bank");
        Bank bankFour = operations.newBank(Utils.generateUuid(Constants.STARTING_UUID, Constants.ENDING_UUID), "UBA");
        Bank bankFive = operations.newBank(Utils.generateUuid(Constants.STARTING_UUID, Constants.ENDING_UUID), "First Bank");
        Bank bankSix = operations.newBank(Utils.generateUuid(Constants.STARTING_UUID, Constants.ENDING_UUID), "Bank of America");
        Bank bankSeven = operations.newBank(Utils.generateUuid(Constants.STARTING_UUID, Constants.ENDING_UUID), "Fidelity Bank");
        allBanks.add(bankOne);
        allBanks.add(bankTwo);
        allBanks.add(bankThree);
        allBanks.add(bankFour);
        allBanks.add(bankFive);
        allBanks.add(bankSix);
        allBanks.add(bankSeven);
    }

    public Account createAccount(Bank bank, Customer customer) {
        return new Account(bank, customer, 0);
    }

    private Customer findCustomer(String findBy, String findValue) {
        operations = new Operations(allCustomers, allBanks, accounts);
        if ("email".equals(findBy)) return operations.findCustomerByEmail(findValue);
        if ("name".equals(findBy)) return operations.findCustomerByFullName(findValue);
        return null;
    }

    private Bank findBank(String findBy, String findValue) {
        operations = new Operations(allCustomers, allBanks, accounts);
        if ("uuid".equals(findBy)) return operations.findBankByUuid(Integer.parseInt(findValue));
        if ("name".equals(findBy)) return operations.findBankByName(findValue);
        return null;
    }

}
