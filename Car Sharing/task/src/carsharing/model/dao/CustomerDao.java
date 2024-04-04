package carsharing.model.dao;

import carsharing.model.entity.Customer;

public interface CustomerDao extends CarShareDAO<Customer> {

    void update(Customer customer, int carId);


}
