package sanika.rest.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sanika.core.model.entities.Customer;
import sanika.core.services.CustomerService;
import sanika.rest.mvc.resources.CustomerResource;
import sanika.rest.mvc.resources.asm.CustomerServiceAsm;

@Controller
@RequestMapping("/rest/customers")
public class CustomersController {

	private CustomerService service;

	public CustomersController() {
		
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public @ResponseBody Customer showHome(@RequestBody Customer customer) {
		customer.setName("testname");
		return customer;
	}

	
	// @Autowired
	public CustomersController(CustomerService service) {
		this.service = service;
	}

	/*
	 * used a path variable to allow to bind a variable in the url to the Java
	 * variable
	 */
	@RequestMapping(value = "/cust-entries/{customer_id}", method = RequestMethod.GET)
	public ResponseEntity<CustomerResource> getCustomerEntry(@PathVariable("customer_id") String customer_id) {
		Customer custEntry = service.findCustomer(customer_id);
		if (custEntry != null) {
			CustomerResource resource = new CustomerServiceAsm().toResource(custEntry);
			return new ResponseEntity<CustomerResource>(resource, HttpStatus.OK);
		} else {
			return new ResponseEntity<CustomerResource>(HttpStatus.NOT_FOUND);
		}
	}

}
