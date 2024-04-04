package carsharing.model.dao;

import carsharing.db.DbClient;
import carsharing.model.entity.Customer;

import java.util.List;

public class DbCustomerDao implements CustomerDao {

    private static final String CREATE_CUSTOMER_TABLE =
            "CREATE TABLE IF NOT EXISTS CUSTOMER " +
            "(ID INT PRIMARY KEY AUTO_INCREMENT, " +
            "NAME VARCHAR(255) UNIQUE NOT NULL, " +
            "RENTED_CAR_ID INT, " +
            "CONSTRAINT fk_rented_car_id FOREIGN KEY (RENTED_CAR_ID) REFERENCES " +
            "CAR(ID))";


    private static final String INSERT_CUSTOMER =
            "INSERT INTO CUSTOMER (NAME, RENTED_CAR_ID) " +
            "VALUES " +
            "('%s', NULL)";

    private static final String SELECT_ALL = "SELECT * FROM CUSTOMER";

    private static final String SELECT_BY_ID = "SELECT * FROM CUSTOMER WHERE " +
                                               "ID = %d";

    private static final String UPDATE_RENTED_CAR_DATA = "UPDATE CUSTOMER SET" +
                                                         " RENTED_CAR_ID = %d WHERE ID = %d";
    private static final String RETURN_RENTED_CAR = "UPDATE CUSTOMER SET " +
                                                    "RENTED_CAR_ID = NULL WHERE ID = %d";
    private final DbClient dbClient;

    public DbCustomerDao(DbClient dbClient) {
        this.dbClient = dbClient;
        dbClient.run(CREATE_CUSTOMER_TABLE);
    }


    @Override
    public List<Customer> findAll() {
        return dbClient.selectForCustomerList(SELECT_ALL);
    }

    @Override
    public void add(Customer customer) {
        dbClient.run(
                String.format(INSERT_CUSTOMER, customer.getName()));
    }

    @Override
    public void update(Customer customer, int carId) {
        if (carId == 0) {
            dbClient.run(
                    String.format(RETURN_RENTED_CAR,
                            customer.getId()));
        } else {
            dbClient.run(
                    String.format(UPDATE_RENTED_CAR_DATA, carId,
                            customer.getId()));
        }
    }

    @Override
    public Customer findById(int id) {
        return dbClient.selectCustomer(String.format(SELECT_BY_ID, id));

    }


}
