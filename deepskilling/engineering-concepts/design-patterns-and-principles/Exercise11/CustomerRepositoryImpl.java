public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(String id) {
        System.out.println("Querying database for customer ID: " + id);
        return "CustomerName_For_" + id;
    }
}
