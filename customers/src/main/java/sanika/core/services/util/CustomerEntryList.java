/**
 * 
 */
package sanika.core.services.util;

import java.util.ArrayList;
import java.util.List;

import sanika.core.model.entities.Customer; 

/**
 * Kenzan CustomerEntryList.java
 * 
 * @author Sanika Joshi
 *
 * 
 */
public class CustomerEntryList {
	private List<Customer> entries = new ArrayList<Customer>();
	private Long customer_id;

	public List<Customer> getEntries() {
		return entries;
	}

	public void setEntries(List<Customer> entries) {
		this.entries = entries;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

}
