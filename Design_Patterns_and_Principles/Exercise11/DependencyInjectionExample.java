// Step 2: Define Repository Interface
interface CustomerRepository {
    Customer findCustomerById(String id);
}

// Step 3: Implement Concrete Repository
class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(String id) {
        // For demonstration purposes, we are returning a dummy customer.
        // In a real application, this would interact with a database.
        if (id.equals("1")) {
            return new Customer("1", "John Doe", "johndoe@example.com");
        } else if (id.equals("2")) {
            return new Customer("2", "Jane Smith", "janesmith@example.com");
        }
        return null;
    }
}

// Step 4: Define the Model Class (Customer)
class Customer {
    private String id;
    private String name;
    private String email;

    // Constructor
    public Customer(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer ID: " + id + ", Name: " + name + ", Email: " + email;
    }
}

// Step 4: Define Service Class
class CustomerService {
    private CustomerRepository customerRepository;

    // Constructor Injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(String id) {
        return customerRepository.findCustomerById(id);
    }
}

// Step 6: Test the Dependency Injection Implementation
public class DependencyInjectionExample {
    public static void main(String[] args) {
        // Create a concrete repository instance
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject the repository into the service
        CustomerService customerService = new CustomerService(repository);

        // Find and display customer details
        Customer customer1 = customerService.getCustomerById("1");
        Customer customer2 = customerService.getCustomerById("2");
        Customer customerNotFound = customerService.getCustomerById("3");

        System.out.println("Customer 1 Details: " + (customer1 != null ? customer1 : "Customer not found"));
        System.out.println("Customer 2 Details: " + (customer2 != null ? customer2 : "Customer not found"));
        System.out.println("Customer 3 Details: " + (customerNotFound != null ? customerNotFound : "Customer not found"));
    }
}
