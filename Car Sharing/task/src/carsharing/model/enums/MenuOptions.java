package carsharing.model.enums;

import java.util.Arrays;

public enum MenuOptions {
    LOGIN_AS_CUSTOMER("Log in as a customer"),
    LOGIN_AS_MANAGER("Log in as a manager"),
    CREATE_A_CUSTOMER("Create a customer"),
    COMPANY_LIST("Company list"),
    CREATE_A_COMPANY("Create a company"),
    CAR_LIST("Car list"),
    CREATE_A_CAR("Create a car"),
    RENT_A_CAR("Rent a car"),
    SELECT_A_COMPANY_FOR_RENT("Choose a company"),
    SELECT_A_CAR_FOR_RENT("Choose a car"),
    RETURN_A_RENTED_CAR("Return a rented car"),
    MY_RENTED_CAR("My rented car"),
    EXIT("Exit"),

    BACK("Back");

    public final String option;

    private MenuOptions(String option) {
        this.option = option;
    }

    public static MenuOptions getOption(String option) {
        return Arrays.stream(MenuOptions.values())
                .filter(en -> en.option.equals(option))
                .findFirst().orElse(MenuOptions.BACK);
    }
}
