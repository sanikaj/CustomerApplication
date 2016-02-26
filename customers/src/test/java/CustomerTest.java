/*package test.java;

import java.math.BigInteger;

import org.hamcrest.core.Is;

import static org.hamcrest.Matchers.hasItem;

import org.junit.Test;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.sanika.spring.web.core.model.entities.Customer;
import com.sanika.spring.web.core.services.CustomerService;
import com.sanika.spring.web.rest.mvc.CustomersController;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.Assert.*;

public class CustomerTest {
	//@Mock
	//private Customer customer;
	 @Mock
	 private CustomerService service; 
	 
	 @InjectMocks 
     private CustomersController custcontroller; 
	 private MockMvc mockmvc;
	 Before executes before each and every test 
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockmvc = MockMvcBuilders.standaloneSetup(custcontroller).build();
		
	}

	test that our requests are being sent
	@Test
	public void test() throws Exception {
		// assertEquals(expected parameter,your parameter)
		mockmvc.perform(get("/")).andDo(print());
	}
	
	@Test
	public void test2() throws Exception {
		// assertEquals(expected parameter,your parameter)
		mockmvc.perform(post("/")
				.content("{\title\":\"Test Blog Entry\"}")
				.contentType(MediaType.APPLICATION_JSON)
				).andExpect(jsonPath("$.title", Is.is("Test Blog Entry")))
				.andDo(print());
	}
	
	@Test
	public void getExistingCustomerEntry() throws Exception {
		// assertEquals(expected parameter,your parameter)
		Customer cust = new Customer();
		cust.setCustomer_id(new BigInteger("1"));
		cust.setName("sanika");
		when(service.findCustomer(new BigInteger("1"))).thenReturn(cust);
		try {
		mockmvc.perform(get("/rest/cust-entries/1"))
		.andExpect((jsonPath("$.name", Is.is(cust.getName()))))
		//.andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/cust-entries/1"))))
		.andExpect(status().isOk())
		.andDo(print());
		} catch(Exception e) {
			throw e;
		}
	}
	
	public void getNonExistingCustomerEntry() throws Exception {
		// assertEquals(expected parameter,your parameter)
		when(service.findCustomer(new BigInteger("1"))).thenReturn(null);
		try {
		mockmvc.perform(get("/rest/cust-entries/1"))
		.andExpect(status().isNotFound())
		.andDo(print());
		} catch(Exception e) {
			throw e;
		}
	}
}
*/