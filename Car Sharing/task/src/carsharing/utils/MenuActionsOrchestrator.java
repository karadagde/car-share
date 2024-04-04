package carsharing.utils;

import carsharing.model.enums.MenuOptions;
import carsharing.service.DbOpsService;

import java.util.Scanner;

public class MenuActionsOrchestrator {


    private final ManagerOperations managerOperations;
    private final CustomerOperations customerOperations;

    public MenuActionsOrchestrator(DbOpsService dbOpsService, Scanner scanner) {
        this.managerOperations = new ManagerOperations(scanner, dbOpsService);
        this.customerOperations = new CustomerOperations(scanner, dbOpsService);
    }


    public void applyAction(MenuOptions action) {
        switch (action) {
            case EXIT:
                exit();
                break;
            case BACK:
                CurrentlyChosenData.goToPreviousStep();
                break;
            case LOGIN_AS_MANAGER:
                logInAsManager();
                break;
            case LOGIN_AS_CUSTOMER:
                logInAsCustomer();
                break;
            case CREATE_A_CUSTOMER:
                createCustomer();
                break;
            case COMPANY_LIST:
                companyList();
                break;
            case CREATE_A_COMPANY:
                createCompany();
                break;
            case CAR_LIST:
                carList();
                break;
            case CREATE_A_CAR:
                createCar();
                break;
            case RENT_A_CAR:
                rentCar();
                break;
            case SELECT_A_COMPANY_FOR_RENT:
                selectCompany();
                break;
            case SELECT_A_CAR_FOR_RENT:
                selectCar();
                break;
            case RETURN_A_RENTED_CAR:
                returnRentedCar();
                break;
            case MY_RENTED_CAR:
                myRentedCar();
                break;
            default:
                System.out.println("Invalid choice");


        }
    }

    private void selectCar() {
        customerOperations.selectCar();
    }

    private void selectCompany() {
        customerOperations.showCompanyListToRent();
    }

    private void myRentedCar() {
        customerOperations.myRentedCar();
    }

    private void returnRentedCar() {

        customerOperations.returnRentedCar();
    }

    private void createCar() {
        managerOperations.createCar();
    }

    private void carList() {
        managerOperations.showCarList();
    }

    private void createCompany() {
        managerOperations.createCompany();
    }

    private void companyList() {
        managerOperations.showCompanyList();
    }

    private void createCustomer() {
        customerOperations.createCustomer();
    }

    private void rentCar() {
        customerOperations.rentCarMenu();
    }

    private void logInAsCustomer() {
        customerOperations.logInAsCustomer();
    }

    private void logInAsManager() {
        managerOperations.logInAsManager();
    }

    private void exit() {
        CurrentlyChosenData.setExiting(true);
    }


}
