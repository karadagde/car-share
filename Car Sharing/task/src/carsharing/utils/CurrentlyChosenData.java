package carsharing.utils;

import carsharing.model.entity.Company;
import carsharing.model.entity.Customer;
import carsharing.model.enums.MenuNames;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class CurrentlyChosenData {
    private static final Deque<MenuNames> menuHistory = new ArrayDeque<>(
            List.of(MenuNames.MAIN_MENU));
    private static Company currentCompany;

    private static Customer currentCustomer;


    private static boolean exit = false;

    private CurrentlyChosenData() {
    }

    public static boolean isExiting() {
        return exit;
    }

    public static void setExiting(boolean exit) {
        CurrentlyChosenData.exit = exit;
    }

    public static Company getCurrentCompany() {
        return currentCompany;
    }

    public static void setCurrentCompany(Company company) {
        CurrentlyChosenData.currentCompany = company;
    }


    public static Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public static void setCurrentCustomer(Customer customer) {
        CurrentlyChosenData.currentCustomer = customer;
    }

    public static MenuNames getCurrentStep() {
        return menuHistory.getLast();
    }

    public static void setCurrentStep(MenuNames step) {
        menuHistory.addLast(step);
    }


    public static void goToPreviousStep() {
        menuHistory.removeLast();
    }
}