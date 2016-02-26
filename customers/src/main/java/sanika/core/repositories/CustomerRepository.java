package sanika.core.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import sanika.core.model.entities.Customer;
import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {
	   public Customer findCustomer(String email);
	   public Customer findCustomerByName(String name);
	   public List<Customer> findAllCustomers(String accountId);
	   public boolean updateCustomer(String account_id, Customer infoData);
	   public Customer deleteCustomer(Customer customer);
	   public Customer createCustomer(String accountId, Customer data);
}
