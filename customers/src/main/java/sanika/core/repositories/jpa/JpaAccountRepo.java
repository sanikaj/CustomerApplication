package sanika.core.repositories.jpa;


import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import sanika.core.model.entities.Account;
import sanika.core.model.entities.Customer;
import sanika.core.repositories.AccountRepository;

/**
 * Kenzan JpaAccountRepo.java
 * 
 * @author Sanika Joshi
 *
 * 
 */
@Repository
public class JpaAccountRepo implements AccountRepository {
	private static Logger mylogger = LoggerFactory.getLogger(JpaAccountRepo.class);
	private ApplicationContext ctx;
	private MongoOperations mongoOperation;

	public JpaAccountRepo() {
		ctx = new GenericXmlApplicationContext("mongo-context.xml");
		mongoOperation = (MongoOperations) ctx.getBean("customermongoTemplate");
	}

	@Override
	public Account createAccount(Account account) {
		Account account1 = new Account();
		account1.setEmail(account.getEmail());
		account1.setPassword(account.getPassword());
		mongoOperation.insert(account1);
		return account;
	}

	@Override
	public ArrayList<Account> findAll() {
		ArrayList<Account> list = (ArrayList) mongoOperation.findAll(Account.class);
		return list;
	}

	@Override
	public Boolean updateAccount(String email, String password) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));
		Account account = mongoOperation.findOne(query, Account.class);

		account.setPassword(password);
		mongoOperation.save(account);
		return true;
	}

	@Override
	public Account findAccountByEmailAndPass(String email,String password) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email).and("password").is(password));
		Account account = mongoOperation.findOne(query, Account.class);
		return account;
	}

	@Override
	public Account findAccountByEmail(String email) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));
		Account account = mongoOperation.findOne(query, Account.class);
		return account;
	}

	@Override
	public Account findOne(String accountId) {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(accountId));

		Account account = mongoOperation.findOne(query, Account.class);
		return account;
	}

	@Override
	public boolean createCustomer(String accountId, Customer customer) {
		customer.setAccountId(accountId);
		mongoOperation.insert(customer);
		return true;
	}

	@Override
	public Customer findCustomer(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomer(String id, Customer infoData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer deleteCustomer(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
