package carsharing;

import carsharing.db.DbClient;
import carsharing.model.enums.MenuNames;
import carsharing.model.enums.MenuOptions;
import carsharing.model.menu.Menu;
import carsharing.service.DbOpsService;
import carsharing.utils.CurrentlyChosenData;
import carsharing.utils.MenuActionsOrchestrator;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MenuActionsOrchestrator menuActionsOrchestrator = new MenuActionsOrchestrator(
                new DbOpsService(new DbClient()), scanner);


        Menu menu = new Menu();
        boolean exit = CurrentlyChosenData.isExiting();
        MenuNames currentMenu = CurrentlyChosenData.getCurrentStep();
        while (!exit) {

            if (currentMenu == MenuNames.SELECT_COMPANY_FOR_RENT) {
                menuActionsOrchestrator.applyAction(
                        MenuOptions.SELECT_A_COMPANY_FOR_RENT);
                currentMenu = CurrentlyChosenData.getCurrentStep();
            } else if (currentMenu == MenuNames.SELECT_CAR_FOR_RENT) {
                menuActionsOrchestrator.applyAction(
                        MenuOptions.SELECT_A_CAR_FOR_RENT);
                currentMenu = CurrentlyChosenData.getCurrentStep();
            } else {

                Menu.printMenu(currentMenu);
                int choice = scanner.nextInt();
                String action = menu.getMenuOption(currentMenu, choice);

                menuActionsOrchestrator.applyAction(
                        MenuOptions.getOption(action));
                exit = CurrentlyChosenData.isExiting();
                currentMenu = CurrentlyChosenData.getCurrentStep();
            }
        }


    }


}