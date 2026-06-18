public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void printCustomerName(String id) {
        String customerName = customerRepository.findCustomerById(id);
        System.out.println("Service layer received: " + customerName);
    }
}
