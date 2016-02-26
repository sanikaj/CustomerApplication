package sanika.core.model.entities;

import org.springframework.data.annotation.Id;

/**
 * Kenzan Address.java
 * 
 * @author Sanika Joshi
 *
 * 
 */

public class Address {
	@Id
	private String address_id;
	private String street;
	private String city;
	private String state;
	private String zip;

	public String getAddress_id() {
		return address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
