package  sanika.rest.mvc.resources;

import org.springframework.hateoas.ResourceSupport;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 7/22/14.
 */
public class AccountListResource extends ResourceSupport {
    private List<AccountResource> accounts = new ArrayList<AccountResource>();
    private List<String> jsonObjectAccounts = new ArrayList<String>();
    public List<AccountResource> getAccounts() {
       return accounts;
    }

    /*public List<String> getAccounts() {
        return jsonObjectAccounts;
     }*/
    
    public void setAccounts(List<AccountResource> accounts) {
        this.accounts = accounts;
        
    }
    public void setAccountsConvertJson(List<AccountResource> accounts) {
    	AccountResource account = new AccountResource();
    	for(int i=0 ; i< accounts.size(); i++) {
    	  jsonObjectAccounts.add(account.toJSONString(accounts.get(i)));
      }
    }

	public List<String> getJsonObjectAccounts() {
		return jsonObjectAccounts;
	}

	public void setJsonObjectAccounts(List<String> jsonObjectAccounts) {
		this.jsonObjectAccounts = jsonObjectAccounts;
	}

	@Override
	public String toString() {
		return "AccountListResource [accounts=" + accounts
				+ ", jsonObjectAccounts=" + jsonObjectAccounts + "]";
	}
    
}
