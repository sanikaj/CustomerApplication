package sanika.rest.mvc.resources;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import sanika.core.model.entities.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.hateoas.ResourceSupport;


public class AccountResource extends ResourceSupport {
    private String email;
    private String password;

    private static Logger mylogger = LoggerFactory.getLogger(AccountResource.class);
    
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public Account toAccount() {
        Account account = new Account();
        account.setEmail(email);
        account.setPassword(password);
        mylogger.info("Email" + email + "password" + password);
        return account;
    }
    
    public String toJSONString(AccountResource accountresource) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString= "";
		try {
			jsonInString = mapper.writeValueAsString(accountresource);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonInString; 
	}
}
