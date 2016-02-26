package sanika.core.services;


import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sanika.core.model.entities.Customer;
import sanika.core.repositories.CustomerRepository;
import sanika.core.repositories.jpa.JpaCustomerRepo;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
  @Autowired
  private CustomerRepository custRepo;
	
	
	public CustomerServiceImpl() {
		this.custRepo = new JpaCustomerRepo();
	}

   @Override
   public boolean createCustomer(String accountId, Customer data) {
        custRepo.createCustomer(accountId, data);
        return true;
   }
   
   @Override
   public Customer findCustomer(String email) {
        return custRepo.findCustomer(email);
   }

   @Override
   public boolean updateCustomer(String account_id, Customer infoData) {
        custRepo.updateCustomer(account_id, infoData);
        return true;
   }

   @Override
   public boolean deleteCustomer(Customer customer) {
        custRepo.deleteCustomer(customer);
        return true;
   }

   @Override
   public List<Customer> findAllCustomers(String accountId) {
       return custRepo.findAllCustomers(accountId);
   }
   
}
