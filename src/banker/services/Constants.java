package banker.services;

public class Constants {

    public static final int STARTING_UUID = 10000;
    public static final int ENDING_UUID = 99999;

    public static final int STARTING_ACCOUNT_UUID = 100000000;
    public static final int ENDING_ACCOUNT_UUID = 999999999;

    public static final int AUTH_ACCESS_CODE = 408912;

    public static final String PROGRAM_ASSISTANTS_NAME = "Reno";

    public static final String PROGRAM_NAME = "Reno Bank Program";

    public static final String[] EMAIL_PROVIDERS = {"gmail", "yahoo", "aol", "outlook"};

    public static final String EMAIL_REGEX = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@\" \n" +
            "        + \"[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";

}