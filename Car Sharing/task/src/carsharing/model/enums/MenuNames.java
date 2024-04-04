package carsharing.model.enums;

public enum MenuNames {
    MAIN_MENU("mainMenu"),
    MANAGER_MENU("managerMenu"),
    CUSTOMER_MENU("customerMenu"),
    COMPANY_MENU("companyMenu"),
    SELECT_COMPANY_FOR_RENT("selectCompanyToRent"),
    SELECT_CAR_FOR_RENT("selectCarToRent");

    public final String menuName;

    private MenuNames(String menuName) {
        this.menuName = menuName;
    }
}
