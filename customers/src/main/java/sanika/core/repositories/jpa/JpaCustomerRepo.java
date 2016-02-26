package sanika.core.repositories.jpa;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import sanika.core.model.entities.Customer;
import sanika.core.repositories.CustomerRepository;

/**
 * Kenzan JpaCustomerRepo.java
 * 
 * @author Sanika Joshi
 *
 * 
 */
@Repository
public class JpaCustomerRepo implements CustomerRepository {
	/*
	 * @Override public Account findAccount(Long id) { return null; }
	 */
	private static Logger mylogger = LoggerFactory.getLogger(JpaCustomerRepo.class);
	private ApplicationContext ctx;
	private MongoOperations mongoOperation;

	public JpaCustomerRepo() {
		ctx = new GenericXmlApplicationContext("mongo-context.xml");
		mongoOperation = (MongoOperations) ctx.getBean("customermongoTemplate");
	}

	@Override
	public ArrayList<Customer> findAll() {
		ArrayList<Customer> list = (ArrayList) mongoOperation.findAll(Customer.class);
		return list;
	}

	/** TODO Implement the address part of the customer **/
	@Override
	public boolean updateCustomer(String account_id, Customer info) {
		Query query = new Query();
		query.addCriteria(Criteria.where("account_id").is(account_id).and("email").is(info.getEmail()));
		Customer customer = mongoOperation.findOne(query, Customer.class);
		customer.setAddress(info.getAddress());
		customer.setEmail(info.getEmail());
		customer.setName(info.getName());
		customer.setTelephone(info.getTelephone());
		mongoOperation.save(customer);
		return true;
	}

	@Override
	public Customer findCustomerByName(String name) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		Customer customer = mongoOperation.findOne(query, Customer.class);
		return customer;
	}

	@Override
	public Customer findOne(String accountId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(accountId));
		Customer customer = mongoOperation.findOne(query, Customer.class);
		return customer;
	}

	@Override
	public List<Customer> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Customer> S insert(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Customer> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean exists(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Customer> List<S> insert(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Customer> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Customer arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Customer> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Customer> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findCustomer(String email) {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));
		Customer customer = mongoOperation.findOne(query, Customer.class);
		return customer;
	}

	@Override
	public Iterable<Customer> findAll(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer deleteCustomer(Customer customer) {
		if(customer != null) {
			Query query = new Query();
			query.addCriteria(Criteria.where("email").is(customer.getEmail()));
			Customer customer_to_del = mongoOperation.findOne(query, Customer.class); 
			mongoOperation.remove(customer_to_del);
		}
		return customer;
	}

	@Override
	public Customer createCustomer(String accountId, Customer customer) {
		customer.setAccountId(accountId);
		mongoOperation.insert(customer);
		return customer;
	}

    @Override
	public List<Customer> findAllCustomers(String accountId) {
        Query query = new Query();
		query.addCriteria(Criteria.where("account_id").is(accountId));
		List<Customer> listOfCustomers = mongoOperation.find(query, Customer.class);
		return listOfCustomers; 
	}

}
