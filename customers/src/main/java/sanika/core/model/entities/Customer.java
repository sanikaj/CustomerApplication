package sanika.core.model.entities;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;

/**
 * Kenzan Customer.java
 * 
 * @author Sanika Joshi
 *
 * 
 */
public class Customer {
	@Id
	private String id;
	private String name;
	private String email;
	private String telephone;
	private Address address;

	/* Link these resources to the creator of the customers */
	private String account_id;

	public String getCustomer_id() {
		return id;
	}

	public void setCustomer_id(String id) {
		this.id = id;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAccountId() {
		return account_id;
	}

	public void setAccountId(String account_id) {
		this.account_id = account_id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
