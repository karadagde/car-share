package carsharing.service;

import carsharing.db.DbClient;
import carsharing.model.dao.DbCarDao;
import carsharing.model.dao.DbCompanyDao;
import carsharing.model.dao.DbCustomerDao;
import carsharing.model.entity.Car;
import carsharing.model.entity.Company;
import carsharing.model.entity.Customer;

import java.util.List;

public class DbOpsService {

    DbCompanyDao dbCompanyDao;
    DbCarDao dbCarDao;
    DbCustomerDao dbCustomerDao;

    public DbOpsService(DbClient client) {
        dbCompanyDao = new DbCompanyDao(client);
        dbCarDao = new DbCarDao(client);
        dbCustomerDao = new DbCustomerDao(client);
    }

    public List<Company> getAllCompanies() {
        return dbCompanyDao.findAll();
    }

    public List<Car> getAllCars() {
        return dbCarDao.findAll();
    }

    public List<Customer> getAllCustomers() {
        return dbCustomerDao.findAll();
    }

    public List<Car> getAvailableCars(int companyId) {
        return dbCarDao.findAvailableCars(companyId);
    }

    public void addCompany(String companyName) {
        dbCompanyDao.add(new Company(companyName));
    }

    public void addCar(String carName, int companyId) {
        dbCarDao.add(new Car(carName, companyId));
    }

    public void addCustomer(String customerName) {
        dbCustomerDao.add(new Customer(customerName));
    }

    public Company getCompanyById(int companyId) {
        return dbCompanyDao.findById(companyId);
    }

    public Car getCarById(int carId) {
        return dbCarDao.findById(carId);
    }

    public Customer getCustomerById(int customerId) {
        return dbCustomerDao.findById(customerId);
    }

    public void updateCustomerRentedCar(Customer customer, int carId) {
        dbCustomerDao.update(customer, carId);
    }

    public void customerReturnCar(Customer customer) {
        dbCustomerDao.update(customer, 0);
    }

}
