package carsharing.utils;

import carsharing.model.entity.Car;
import carsharing.model.entity.Company;
import carsharing.model.enums.MenuNames;
import carsharing.service.DbOpsService;

import java.util.List;
import java.util.Scanner;

public class ManagerOperations {

    Scanner scanner;

    DbOpsService service;


    public ManagerOperations(Scanner scanner, DbOpsService service) {
        this.scanner = scanner;
        this.service = service;
    }

    public void logInAsManager() {
        CurrentlyChosenData.setCurrentStep(MenuNames.MANAGER_MENU);
    }

    public void showCompanyList() {
        List<Company> companies = service.getAllCompanies();
        PrintList.printCompanies(companies);
        if (!companies.isEmpty()) {
            int companyId = scanner.nextInt();
            if (companyId == 0) {
                CurrentlyChosenData.goToPreviousStep();
                return;
            }
            CurrentlyChosenData.setCurrentCompany(
                    companies.get(companyId - 1));
            CurrentlyChosenData.setCurrentStep(MenuNames.COMPANY_MENU);
        }
    }

    public void createCompany() {
        System.out.println("Enter the company name:");
        scanner.nextLine();
        String companyName = scanner.nextLine();
        service.addCompany(companyName);
        System.out.println("The company was created!\n");
        CurrentlyChosenData.setCurrentStep(MenuNames.MANAGER_MENU);
    }

    public void showCarList() {
        if (CurrentlyChosenData.getCurrentCompany() != null) {
            int companyId = CurrentlyChosenData.getCurrentCompany().getId();
            List<Car> cars = service.getAllCars().stream().filter(
                            car -> car.getCompanyId() == companyId)
                    .toList();
            PrintList.printCars(cars);

        }
    }


    public void createCar() {
        if (CurrentlyChosenData.getCurrentCompany() != null) {
            System.out.println("Enter the car name:");
            scanner.nextLine();
            String carName = scanner.nextLine();
            service.addCar(carName,
                    CurrentlyChosenData.getCurrentCompany().getId());
            System.out.println("The car was added!\n");
        }
    }


}
