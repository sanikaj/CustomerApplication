package sanika.core.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import sanika.core.model.entities.Account;
import sanika.core.model.entities.Customer;


/*Acts as the proxy to the AccountRepository*/
public interface AccountService {
	public Account findAccount(String id);
	public Account findAccountByEmail(String email);
	public Account findAccountByEmailAndPass(String email,String password);
	
	public Account createAccount(Account data);
  
	public Account deleteAccount(String email);

	public Boolean updateAccount(String email,String password);

	public ArrayList<Account> findAllAccounts();

	// public Account deleteAccount();

	
	public List<Customer> findCustomersByAccount(String accountId);

}
