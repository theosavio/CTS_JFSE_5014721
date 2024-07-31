public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(String customerId) {
        // Simulate fetching customer from a database
        return new Customer(customerId, "theo savio", "theo@example.com");
    }
}
