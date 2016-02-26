/**
 * 
 */
package sanika.core.services;

import java.math.BigInteger;

import sanika.core.model.entities.Customer;
import java.util.List;

/**
 *  Assignment 1
    CustomerService.java
	@author Sanika Joshi 
 *
 * 
 */
public interface CustomerService {

   public boolean createCustomer(String accountId, Customer data);
   public Customer findCustomer(String email);
   public boolean updateCustomer(String account_id, Customer infoData);
   public boolean deleteCustomer(Customer customer);
   public List<Customer> findAllCustomers(String accountId);
}
