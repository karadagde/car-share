package carsharing.utils;import carsharing.model.entity.Car;import carsharing.model.entity.Company;import carsharing.model.entity.Customer;import java.util.List;public class PrintList {    private PrintList() {    }    public static void printCompanies(List<Company> companies) {        if (companies.isEmpty()) {            System.out.println("The company list is empty!\n");        } else {            System.out.println("Choose the company:");            for (int i = 0; i < companies.size(); i++) {                System.out.println(i + 1 + ". " + companies.get(i).getName());            }            System.out.println("0. Back\n");        }    }    public static void printCars(List<Car> cars) {        if (cars.isEmpty()) {            System.out.println("The car list is empty!\n");        } else {            System.out.println("Car list:");            for (int i = 0; i < cars.size(); i++) {                if (i != cars.size() - 1) {                    System.out.println(i + 1 + ". " + cars.get(i).getName());                } else {                    System.out.println(                            i + 1 + ". " + cars.get(i).getName() + "\n");                }            }        }    }    public static void printCustomers(List<Customer> customers) {        if (customers.isEmpty()) {            System.out.println("The customer list is empty!\n");        } else {            System.out.println("Customer list:");            for (int i = 0; i < customers.size(); i++) {                System.out.println(                        i + 1 + ". " + customers.get(i).getName() + "id: " +                        customers.get(i).getId());            }            System.out.println("0. Back\n");        }    }    public static void printRentedCar(Car car) {        System.out.println("You rented '" + car.getName() + "'");    }    public static void printNoRentedCar() {        System.out.println("You didn't rent a car!");    }    public static void printRentableCars(List<Car> cars) {        if (cars.isEmpty()) {            System.out.println("No available cars!\n");        } else {            System.out.println("Choose a car:");            for (int i = 0; i < cars.size(); i++) {                System.out.println(i + 1 + ". " + cars.get(i).getName());            }            System.out.println("0. Back\n");        }    }    public static void printMyRentedCar(Car car, Company company) {        System.out.println("Your rented car:");        System.out.println(car.getName());        System.out.println("Company:");        System.out.println(company.getName() + "\n");    }    public static void printCarReturned() {        System.out.println("You've returned a rented car!\n");    }}