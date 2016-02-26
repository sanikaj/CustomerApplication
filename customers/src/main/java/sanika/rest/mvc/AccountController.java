package sanika.rest.mvc;

import java.math.BigInteger;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;


import sanika.core.model.entities.Account;
import sanika.core.model.entities.Customer;
import sanika.core.services.AccountService;
import sanika.core.services.CustomerService;
import sanika.core.services.CustomerServiceImpl;
//import sanika.core.services.CustomerService;
import sanika.core.services.exceptions.AccountExistsException;
import sanika.rest.exceptions.ConflictException;
import sanika.rest.mvc.resources.AccountListResource;
import sanika.rest.mvc.resources.AccountResource;
import sanika.rest.mvc.resources.asm.AccountListResourceAsm;
import sanika.rest.mvc.resources.asm.AccountResourceAsm;

@Controller
@RequestMapping("/rest/accounts")
public class AccountController {

	private AccountService accountService;

	private CustomerService customerService;
	private static Logger mylogger = LoggerFactory.getLogger(AccountController.class);

	/* @Autowired */
	/*
	 * public AccountController() {
	 * 
	 * }
	 */
	public AccountController() {

	}

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
		this.customerService = new CustomerServiceImpl();
	}

	/*
	 * @RequestMapping(method = RequestMethod.GET) public ResponseEntity<Object>
	 * findAllAccounts(@RequestParam(value="email", required = false) String
	 * email) { ArrayList<Account> list = null; if(email == null) { Account
	 * account1 = new Account(); account1.setEmail("porip@gmail.com");
	 * account1.setPassword("12345"); accountService.createAccount(account1);
	 * list = accountService.findAllAccounts(); } else { Account account =
	 * accountService.findAccount(email); if(account == null) { //list = new
	 * AccountList(new ArrayList<Account>());; list = new ArrayList<Account>();
	 * } else { list = (ArrayList)Arrays.asList(account); } } AccountResource
	 * res = new AccountResourceAsm().toResource(list); //Account res =
	 * (Account) list.get(0); return new
	 * ResponseEntity<AccountListResource>(res, HttpStatus.OK); // return new
	 * ResponseEntity<Object>(res.toJSONString(list.get(0)), HttpStatus.OK); }
	 */

	/*
	 * @RequestMapping(value="/all",method = RequestMethod.GET) public
	 * ResponseEntity<Object> findAllAccounts(@RequestParam(value="email",
	 * required = false) String email) { List<Account> list = null;
	 * mylogger.info("I am here shalalala"); if(email == null) { list =
	 * accountService.findAllAccounts(); } else { Account account =
	 * accountService.findAccount(email); if(account == null) { list = new
	 * ArrayList<Account>(); } else { list = Arrays.asList(account); } }
	 * AccountListResource res = new AccountListResourceAsm().toResource(list);
	 * for(int j=0; j< res.getJsonObjectAccounts().size(); j++) {
	 * mylogger.info(res.getJsonObjectAccounts().get(j));
	 * 
	 * } //return new ResponseEntity<AccountListResource>(res, HttpStatus.OK);
	 * return new
	 * ResponseEntity<Object>(res.getJsonObjectAccounts().get(0),HttpStatus.OK);
	 * }
	 */

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<Object> findAllAccounts(@RequestParam(value = "email", required = false) String email) {
		List<Account> list = null;
		if (email == null) {
			list = accountService.findAllAccounts();
		} else {
			Account account = accountService.findAccountByEmail(email);
			if (account == null) {
				list = new ArrayList<Account>();
			} else {
				list = Arrays.asList(account);
			}
		}
		AccountListResource res = new AccountListResourceAsm().toResource(list);
		/*
		 * for(int j=0; j< res.getJsonObjectAccounts().size(); j++) {
		 * mylogger.info(res.getJsonObjectAccounts().get(j));
		 * 
		 * }
		 */
		// return new ResponseEntity<AccountListResource>(res, HttpStatus.OK);
		return new ResponseEntity<Object>(res, HttpStatus.OK);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Object> findAnAccount(@RequestBody Account account) {
		Account retrievedAccount = accountService.findAccountByEmailAndPass(account.getEmail(),account.getPassword());
		if(retrievedAccount.getId() != null) { 
			return new ResponseEntity<Object>(retrievedAccount, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<AccountResource> createAccount(@RequestBody AccountResource sentAccount) {
		try {
			Account createdAccount = accountService.createAccount(sentAccount.toAccount());
			AccountResource res = new AccountResourceAsm().toResource(createdAccount);
			// HttpHeaders headers = new HttpHeaders();
			// headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<AccountResource>(res, HttpStatus.CREATED);
		} catch (AccountExistsException exception) {
			throw new ConflictException(exception);
		}
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<AccountResource> createAccount(@RequestBody Account account) {
		try {
			Account createdAccount = accountService.createAccount(account);
			AccountResource res = new AccountResourceAsm().toResource(createdAccount);
			// HttpHeaders headers = new HttpHeaders();
			// headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<AccountResource>(res, HttpStatus.CREATED);
		} catch (AccountExistsException exception) {
			throw new ConflictException(exception);
		}
	}

	/*@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<AccountResource> createAccountAll(@RequestBody AccountResource sentAccount) {
		try {
			Account createdAccount = accountService.createAccount(sentAccount.toAccount());
			AccountResource res = new AccountResourceAsm().toResource(createdAccount);
			//HttpHeaders headers = new HttpHeaders();
			//headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<AccountResource>(res, HttpStatus.CREATED);
		} catch (AccountExistsException exception) {
			throw new ConflictException(exception);
		}
	}*/

	@RequestMapping(value = "/getDetails/{accountId}", method = RequestMethod.GET)
	public ResponseEntity<AccountResource> getAccount(@PathVariable String accountId) {
		Account account = accountService.findAccount(accountId);

		if (account != null) {
			AccountResource res = new AccountResourceAsm().toResource(account);
			return new ResponseEntity<AccountResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<AccountResource>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/createCustomer/{accountId}", method = RequestMethod.POST)
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer, @PathVariable String accountId) {
		Customer customerObj = customerService.findCustomer(customer.getEmail());
		if (customerObj == null) {
			customerService.createCustomer(accountId, customer);
			return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/updateCustomer/{accountId}", method = RequestMethod.POST)
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable String accountId) {
		Customer customerObj = customerService.findCustomer(customer.getEmail());
		if (customerObj != null) {
			customerService.updateCustomer(accountId, customer);
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		} else {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.POST)
	public ResponseEntity<Customer> deleteCustomer(@RequestBody Customer customer) {
		Customer customerObj = customerService.findCustomer(customer.getEmail());
		if (customerObj != null) {
			customerService.deleteCustomer(customer);
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		} else {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/getCustomers/{accountId}", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getCustomers(@PathVariable String accountId) {
		List<Customer> listOfCustomers = customerService.findAllCustomers(accountId);
		if (listOfCustomers != null && listOfCustomers.size() != 0) {
			return new ResponseEntity<List<Customer>>(listOfCustomers, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
		}
	}

	
}
