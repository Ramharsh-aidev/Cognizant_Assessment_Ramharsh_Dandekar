public class DITest {
    public static void main(String[] args) {
        System.out.println("Testing Dependency Injection Pattern\n");

        CustomerRepository repository = new CustomerRepositoryImpl();

        CustomerService service = new CustomerService(repository);

        service.printCustomerName("C558");
    }
}
