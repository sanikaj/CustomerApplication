/**
 * 
 */
package sanika.rest.mvc.resources;

import java.math.BigInteger;

import org.springframework.hateoas.ResourceSupport;

/**
 *  Assignment 1
    CustomerResource.java
	@author Sanika Joshi 
 *
 * 
 */
public class CustomerResource extends ResourceSupport {
	private String customer_id;
	private String name;
	private String email;
	private int telephone;
	private int address_id;

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}


}
