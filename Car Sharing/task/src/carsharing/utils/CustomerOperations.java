package carsharing.utils;

import carsharing.model.entity.Car;
import carsharing.model.entity.Company;
import carsharing.model.entity.Customer;
import carsharing.model.enums.MenuNames;
import carsharing.service.DbOpsService;

import java.util.List;
import java.util.Scanner;

public class CustomerOperations {

    Scanner scanner;

    DbOpsService service;

    public CustomerOperations(Scanner scanner, DbOpsService service) {
        this.scanner = scanner;
        this.service = service;
    }

    public void logInAsCustomer() {

        customerList();
    }

    public void customerList() {
        List<Customer> customers = service.getAllCustomers();
        PrintList.printCustomers(customers);
        if (!customers.isEmpty()) {
            int customerId = scanner.nextInt();
            if (customerId == 0) {
                return;
            }
            CurrentlyChosenData.setCurrentCustomer(
                    customers.get(customerId - 1));
            System.out.println("Hello, " +
                               CurrentlyChosenData.getCurrentCustomer()
                                       .getName() + "!\n");
            CurrentlyChosenData.setCurrentStep(MenuNames.CUSTOMER_MENU);
        }
    }

    public void createCustomer() {
        System.out.println("Enter the customer name:");
        scanner.nextLine();
        String customerName = scanner.nextLine();
        service.addCustomer(customerName);
        System.out.println("The customer was created!\n");
    }

    public void rentCarMenu() {
        if (CurrentlyChosenData.getCurrentCustomer() != null) {
            int isCustomerRented = CurrentlyChosenData.getCurrentCustomer()
                    .getRentedCarId();
            if (isCustomerRented > 0) {
                System.out.println("You've already rented a car!");
                CurrentlyChosenData.setCurrentStep(MenuNames.CUSTOMER_MENU);
            } else {

                CurrentlyChosenData.setCurrentStep(
                        MenuNames.SELECT_COMPANY_FOR_RENT);
            }
        }
    }


    public void returnRentedCar() {
        if (CurrentlyChosenData.getCurrentCustomer() != null) {
            int isCustomerRented = CurrentlyChosenData.getCurrentCustomer()
                    .getRentedCarId();
            if (isCustomerRented > 0) {
                service.customerReturnCar(
                        CurrentlyChosenData.getCurrentCustomer());
                CurrentlyChosenData.setCurrentCustomer(service.getCustomerById(
                        CurrentlyChosenData.getCurrentCustomer().getId()));
                PrintList.printCarReturned();
            } else {
                PrintList.printNoRentedCar();

            }
        }
    }

    public void myRentedCar() {
        if (CurrentlyChosenData.getCurrentCustomer() != null) {
            Customer customer = CurrentlyChosenData.getCurrentCustomer();
            int rentedCarId = customer.getRentedCarId();
            if (rentedCarId > 0) {
                Car rentedCar = service.getCarById(rentedCarId);
                Company company = service.getCompanyById(
                        rentedCar.getCompanyId());
                PrintList.printMyRentedCar(rentedCar, company);
            } else {
                PrintList.printNoRentedCar();
            }
        }
    }

    public void selectCar() {
        if (CurrentlyChosenData.getCurrentCompany() != null) {
            int companyId = CurrentlyChosenData.getCurrentCompany().getId();
            List<Car> cars = service.getAvailableCars(companyId);
            PrintList.printRentableCars(cars);
            if (!cars.isEmpty()) {
                int carId = scanner.nextInt();
                if (carId == 0) {
                    CurrentlyChosenData.goToPreviousStep();
                    return;
                }
                Car selectedCar = cars.get(carId - 1);
                rentCar(selectedCar);
            }
        }
    }

    public void rentCar(Car car) {
        Customer customer = CurrentlyChosenData.getCurrentCustomer();
        service.updateCustomerRentedCar(customer, car.getId());
        CurrentlyChosenData.setCurrentCustomer(service.getCustomerById(
                CurrentlyChosenData.getCurrentCustomer().getId()));
        PrintList.printRentedCar(car);
        CurrentlyChosenData.goToPreviousStep();
        CurrentlyChosenData.goToPreviousStep();
    }

    public void showCompanyListToRent() {
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
            CurrentlyChosenData.setCurrentStep(
                    MenuNames.SELECT_CAR_FOR_RENT);
        }
    }
}