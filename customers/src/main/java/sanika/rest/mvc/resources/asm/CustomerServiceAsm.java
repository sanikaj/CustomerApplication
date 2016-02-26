package sanika.rest.mvc.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;


import sanika.core.model.entities.Customer;
import sanika.rest.mvc.CustomersController;
import sanika.rest.mvc.resources.CustomerResource;



public class CustomerServiceAsm extends ResourceAssemblerSupport<Customer, CustomerResource>{

	public CustomerServiceAsm() {
		super(CustomersController.class, CustomerResource.class);
	}

	@Override
	public CustomerResource toResource(Customer entity) {
		CustomerResource custRes = new CustomerResource();
		custRes.setName(entity.getName());
		/*TODO Implement email, address and other fields*/
		//Link link = linkTo(methodOn(CustomersController.class).getCustomerEntry(entity.getCustomer_id())).withSelfRel();
		//custRes.add(link.withSelfRel());
		return custRes;
	}

}
