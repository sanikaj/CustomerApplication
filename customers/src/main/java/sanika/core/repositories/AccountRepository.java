package sanika.core.repositories;


import java.math.BigInteger;
import java.util.ArrayList;


import org.springframework.data.mongodb.repository.MongoRepository;

import sanika.core.model.entities.Account;
import sanika.core.model.entities.Customer;

public interface AccountRepository  {
    public Account findAccountByEmailAndPass(String email,String password);
    public Account findAccountByEmail(String email);
    
    public ArrayList<Account> findAll();
	public Account createAccount(Account data);
    //public Account deleteAccount(String email);
	public Boolean updateAccount(String email,String password); 
	//public Account deleteAccount();
       
	public Account findOne(String accountId);
	public boolean createCustomer(String accountId, Customer info);
	
	public Customer findCustomer(String id);
	public Customer updateCustomer(String id, Customer infoData);
	public Customer deleteCustomer(String id);
	
	
}
