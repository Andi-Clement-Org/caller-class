package banker.services;

import banker.models.Account;
import banker.models.Bank;
import banker.models.Customer;

import java.util.ArrayList;

public abstract class Skeleton {
    abstract Customer newCustomer(Integer uuid, String full_name, String email) throws Exception;
    abstract Bank newBank(Integer uuid, String name);
    abstract Account saveMoney(Bank bank, Customer customer, double amount);
    abstract Customer findCustomerByEmail(String email);
    abstract Customer findCustomerByFullName(String fullName);
    abstract Customer findCustomerByUuid(Integer uuid);
    abstract Account getUserAccountInfo(String customerEmail, String bankName);
    abstract Bank findBankByName(String name);
    abstract Bank findBankByUuid(Integer uuid);
    abstract ArrayList<Account> getCustomerAccountEmail(String customerEmail);
    abstract ArrayList<Account> getCustomerAccountName(String customerName);
}
