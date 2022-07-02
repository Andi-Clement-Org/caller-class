package banker;

import banker.models.Account;
import banker.models.Bank;
import banker.models.Customer;
import banker.services.Constants;
import banker.services.Operations;
import banker.services.Utils;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * //TODO
 * - Make the application interactive
 */

public class BankProgram {


    private final ArrayList<Customer> allCustomers = new ArrayList<>();
    private final ArrayList<Bank> allBanks = new ArrayList<>();
    private final ArrayList<Account> accounts = new ArrayList<>();

    private Operations operations;
    private final Utils utils;

    public BankProgram() {
        operations = new Operations();
        utils = new Utils();
    }

    public static void main(String[] args) {

        BankProgram program = new BankProgram();
        program.program();

//        System.out.println("Input a name: ");
//        Scanner scan = new Scanner(System.in);
//        String input = scan.nextLine();
//        Customer customer = program.findCustomer("name", input);
//        System.out.println("Input a bank: ");
//        String secInput = scan.nextLine();
//        Bank bank = program.findBank("name", secInput);
//
//        Account customerAccount = program.createAccount(bank, customer);
//
//        System.out.printf("This is the new account Information \n %s", customerAccount.toString());

    }

    public void program() {
        System.out.printf("Hi, I am %s, I will be assisting you today." +
                "\nWhat would you like to to do?" +
                "\n1.\tSeed Bank Data." +
                "\n2.\tCreate Customer Data." +
                "\n3.\tCreate Account Information." +
                "\n0.\tTo Exit the program.\n\n", Constants.PROGRAM_ASSISTANTS_NAME);
        try {
            chosenOptions();
        }
        catch (Exception ex) {
            System.err.printf("You just encountered an error %s \n", ex.getMessage());
            program();
        }
    }

    private void chosenOptions() throws Exception {
        int selectedOption = utils.scanner().nextInt();
        switch (selectedOption) {
            case 0:
                System.exit(0);
                break;
            case 1:
                seed();
                program();
                break;
            case 2:
                processCustomerCreation();
                break;
            case 3:
                // process and handle customer creation
                break;
            default:
                break;
        }
    }

    private void processCustomerCreation() throws Exception {
        System.out.println("Enter Full Name");
        String scannedName = utils.scanner().nextLine();
        if ("".equals(scannedName)) {
            throw new Exception("Please enter a valid name");
        }

        Customer newCustomer = operations.newCustomer(getFreshUuid(), scannedName, Utils.generateCustomerEmailAddress(scannedName, Utils.pickEmailProvider()));
        allCustomers.add(newCustomer);
        System.out.printf("%s was added successfully.\n", newCustomer.getFull_name());
        // show message and back to program
        Thread.sleep(1000);
        program();
    }

    private void seed() throws Exception {
        addCustomers();
        addBanks();
    }

    private void addCustomers() throws Exception {
        Customer customerOne = operations.newCustomer(getFreshUuid(), "John Miller", Utils.generateCustomerEmailAddress("John Miller", Utils.pickEmailProvider()));
        Customer customerTwo = operations.newCustomer(getFreshUuid(), "Philips Jones", Utils.generateCustomerEmailAddress("Philip Jones", Utils.pickEmailProvider()));
        Customer customerThree = operations.newCustomer(getFreshUuid(), "Kingsley Wills", Utils.generateCustomerEmailAddress("Kingsley Wills", Utils.pickEmailProvider()));
        Customer customerFour = operations.newCustomer(getFreshUuid(), "Maria Smith", Utils.generateCustomerEmailAddress("Maria Smith", Utils.pickEmailProvider()));
        Customer customerFive = operations.newCustomer(getFreshUuid(), "Darlene James", Utils.generateCustomerEmailAddress("Darlene James", Utils.pickEmailProvider()));
        Customer customerSix = operations.newCustomer(getFreshUuid(), "Matthew Tera", Utils.generateCustomerEmailAddress("Matthew Tera", Utils.pickEmailProvider()));
        allCustomers.add(customerOne);
        allCustomers.add(customerTwo);
        allCustomers.add(customerThree);
        allCustomers.add(customerFour);
        allCustomers.add(customerFive);
        allCustomers.add(customerSix);
    }

    public void addBanks() {
        Bank bankOne = operations.newBank(getFreshUuid(), "Zenith Bank");
        Bank bankTwo = operations.newBank(getFreshUuid(), "Wema Bank");
        Bank bankThree = operations.newBank(getFreshUuid(), "GT Bank");
        Bank bankFour = operations.newBank(getFreshUuid(), "UBA");
        Bank bankFive = operations.newBank(getFreshUuid(), "First Bank");
        Bank bankSix = operations.newBank(getFreshUuid(), "Bank of America");
        Bank bankSeven = operations.newBank(getFreshUuid(), "Fidelity Bank");
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

    private Integer getFreshUuid () {
        return Utils.generateUuid(Constants.STARTING_UUID, Constants.ENDING_UUID);
    }

}