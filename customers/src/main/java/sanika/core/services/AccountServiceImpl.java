/**
 * 
 */
package sanika.core.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sanika.core.model.entities.Account;
import sanika.core.model.entities.Customer;
import sanika.core.repositories.AccountRepository;
import sanika.core.repositories.jpa.JpaAccountRepo;
import sanika.core.services.exceptions.AccountExistsException;



/**
 *  Kenzan
    AccountServiceImpl.java
	@author Sanika Joshi 
 *
 * 
 */
@Service
public class AccountServiceImpl implements AccountService{

	

	private AccountRepository accountRepo;
	public AccountServiceImpl() {
		accountRepo = new JpaAccountRepo();
	}

	
	@Override
	public Account findAccountByEmail(String email) {
		return accountRepo.findAccountByEmail(email);
	}
	
    @Override
    public Account findAccountByEmailAndPass(String email, String password) {
    	return accountRepo.findAccountByEmailAndPass(email, password);
    }
	@Override
	public Account findAccount(String accountId) {
		return accountRepo.findOne(accountId);
	}

	@Override
	public Account createAccount(Account data) {
		 Account account = accountRepo.findAccountByEmail(data.getEmail());
	        if(account != null)
	        {
	            throw new AccountExistsException();
	        }
	        return accountRepo.createAccount(data);
	}

	@Override
	public Account deleteAccount(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateAccount(String email,String password) {
		// TODO Auto-generated method stub
		accountRepo.updateAccount(email, password);
		return null;
	}

	@Override
	public ArrayList<Account> findAllAccounts() {
		// TODO Auto-generated method stub
		return (ArrayList<Account>) accountRepo.findAll();
	}

	
	@Override
	public List<Customer> findCustomersByAccount(String accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
