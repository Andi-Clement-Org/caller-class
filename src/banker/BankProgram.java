package banker;

import banker.models.Account;
import banker.models.Bank;
import banker.models.Customer;
import banker.models.CustomerIdentity;
import banker.services.Constants;
import banker.services.Operations;
import banker.services.Utils;

import java.util.ArrayList;

/**
 * //TODO
 * - Make the application interactive
 */

@SuppressWarnings({"unused", "Duplicates"})
public class BankProgram {


    private final ArrayList<Customer> allCustomers = new ArrayList<>();
    private final ArrayList<Bank> allBanks = new ArrayList<>();
    private final ArrayList<Account> accounts = new ArrayList<>();

    private Operations operations;
    private final Utils utils;

    private CustomerIdentity gbCustomerIdentity;

    public BankProgram() {
        operations = new Operations();
        utils = new Utils();
    }

    public static void main(String[] args) {
        BankProgram program = new BankProgram();
        program.program();
    }

    public void program() {
        System.out.printf("""
                Hi, I am %s, I will be assisting you today.
                What would you like to to do?
                1.\tSeed Dummy Data (Bank & Customer).
                2.\tCreate Customer Data.
                3.\tAccess Restricted Space.
                0.\tTo Exit the program.

                """, Constants.PROGRAM_ASSISTANTS_NAME);
        try {
            chosenOptions();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.err.printf("You just encountered an error %s \n", ex.getMessage());
            program();
        }
    }

    private void restricted(boolean newVisitor) throws Exception {
        if (newVisitor) {
            System.out.println("Please Enter your name or Email address to access restricted space");
            gbCustomerIdentity = getCustomer();
        }

        System.out.printf("""
                Hi, I am %s, I will be assisting you today.
                What would you like to to do?
                1.\tCreate Account Information.
                2.\tView Customer Information.
                3.\tDeposit to Customer Account.
                4.\tWithdraw from Customer Account.
                5.\tTo Return.
                0.\tTo Exit the program.

                """, Constants.PROGRAM_ASSISTANTS_NAME);
        try {
            chosenOptionsRestricted();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.err.printf("You just encountered an error %s \n", ex.getMessage());
            program();
        }
    }

    private void chosenOptions() throws Exception {
        int selectedOption = utils.scanner().nextInt();
        switch (selectedOption) {
            case 0 -> System.exit(0);
            case 1 -> {
                seed();
                program();
            }
            case 2 -> processCustomerCreation();
            case 3 -> restricted(true);
            default -> {
            }
        }
    }

    private void chosenOptionsRestricted() throws Exception {
        int selectedOption = utils.scanner().nextInt();
        switch (selectedOption) {
            case 0 -> System.exit(0);
            case 1 -> processAccountInfo();
            case 2 -> viewCustomerInformation();
            case 3 -> depositToCustomer();
            case 4 -> withdrawFromCustomer();
            case 5 -> program();
            default -> {
            }
        }
    }

    private void processCustomerCreation() throws Exception {
        System.out.println("Enter Full Name");
        String scannedName = utils.scanner().nextLine();
        if ("".equals(scannedName)) {
            throw new Exception("Please enter a valid name");
        }
        operations = new Operations(allCustomers, allBanks, accounts);
        Customer newCustomer = operations.newCustomer(getFreshUuid(), scannedName, Utils.generateCustomerEmailAddress(scannedName, Utils.pickEmailProvider()));
        allCustomers.add(newCustomer);
        System.out.printf("%s was added successfully.\n", newCustomer.getFull_name());
        processAccountInfo();
        // show message and back to program
        Thread.sleep(1000);
        program();
    }

    private void processAccountInfo() throws Exception {

        System.out.println("Please Select banks from options below:");

        for (int i = 0; i < allBanks.size(); i++) {
            System.out.printf("%d %s \n", i+1, allBanks.get(i).getName());
        }
        System.out.println();

        int input = utils.scanner().nextInt();
        operations = new Operations(allCustomers, allBanks, accounts);
        // verify if the bank index
        accounts.add(createAccount(allBanks.get(input-1), gbCustomerIdentity.getCustomer()));

        restricted(false);
    }

    private void viewCustomerInformation() throws Exception {

        // find the account information using the customer object

        ArrayList<Account> myAccounts = getAccountInfo();

        for (Account myAccount : myAccounts) {
            System.out.printf("Bank: %s. \nCustomer: %s. \nBalance: %f \n\n", myAccount.getBank().getName(), myAccount.getCustomer().getFull_name(), myAccount.getBalance());
        }

        restricted(false);

    }

    private void depositToCustomer() throws Exception {
        System.out.println("Choose your Bank");
        ArrayList<Account> myAccounts = getAccountInfo();
        int acIndex = 1;
        for (Account myAccount : myAccounts) {
            System.out.printf("%d.\t%s. \n", acIndex++, myAccount.getBank().getName());
        }

        int bankIndex = utils.scanner().nextInt();
        Bank selBank = getSelectedBank(bankIndex, myAccounts);

        System.out.println("How much would you like to deposit");
        int amountToDeposit = utils.scanner().nextInt();

        Account getAccount = operations.getAccountByCustomer(gbCustomerIdentity.getCustomer(), selBank).orElse(null);

        assert getAccount != null;
        double updatedAmount = getAccount.getBalance() + amountToDeposit;

        updateAccountInfo(selBank, updatedAmount);

        restricted(false);
    }

    private void withdrawFromCustomer() throws Exception {
        System.out.println("Choose your Bank");
        ArrayList<Account> myAccounts = getAccountInfo();
        int acIndex = 1;
        for (Account myAccount : myAccounts) {
            System.out.printf("%d.\t%s. \n", acIndex++, myAccount.getBank().getName());
        }

        int bankIndex = utils.scanner().nextInt();
        Bank selBank = getSelectedBank(bankIndex, myAccounts);

        System.out.println("How much would you like to withdraw");
        int amountToDeposit = utils.scanner().nextInt();

        Account getAccount = operations.getAccountByCustomer(gbCustomerIdentity.getCustomer(), selBank).orElse(null);

        assert getAccount != null;

        if (amountToDeposit > getAccount.getBalance()) throw new Exception("Insufficient Balance");

        double updatedAmount = getAccount.getBalance() - amountToDeposit;
        updateAccountInfo(selBank, updatedAmount);

        restricted(false);
    }

    private CustomerIdentity getCustomer() throws Exception {
        String identification = utils.scanner().nextLine();

        Customer customerIdentity;
        operations = new Operations(allCustomers, allBanks, accounts);

        if (Utils.isEmailAddress(identification, Constants.EMAIL_REGEX)) customerIdentity = operations.findCustomerByEmail(identification);
        else customerIdentity = operations.findCustomerByFullName(identification);

        if (customerIdentity == null) throw new Exception("Cannot find this customer");
        return new CustomerIdentity(customerIdentity, identification);
    }

    private ArrayList<Account> getAccountInfo() {
        ArrayList<Account> myAccounts;
        if (Utils.isEmailAddress(gbCustomerIdentity.getIdentity(), Constants.EMAIL_REGEX)) myAccounts = operations.getCustomerAccountEmail(gbCustomerIdentity.getIdentity());
        else myAccounts = operations.getCustomerAccountName(gbCustomerIdentity.getIdentity());
        return myAccounts;
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

    private Account createAccount(Bank bank, Customer customer) throws Exception {
        // check if customer exists in account
        Account checkAccount = operations.getAccountByCustomer(customer, bank).orElse(null);
        if (checkAccount != null) throw new Exception("Cannot create duplicate account for customer");
        return new Account(bank, customer,0);
    }

    private void updateAccountInfo(Bank bank, double amount) {
        accounts.forEach(account -> {
            if (account.getCustomer().equals(gbCustomerIdentity.getCustomer()) && account.getBank().equals(bank)) account.setBalance(amount);
        });
    }

    private Bank getSelectedBank(int index, ArrayList<Account> accounts) {
        int cIndex = index - 1;
        return (accounts.size() > cIndex) ? accounts.get(cIndex).getBank() : null;
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