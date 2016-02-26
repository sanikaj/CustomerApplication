package sanika.rest.mvc.resources.asm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import sanika.core.model.entities.Account;
import sanika.rest.mvc.AccountController;
import sanika.rest.mvc.resources.AccountResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;


/**
 * Created by Sanika 
 */

public class AccountResourceAsm extends ResourceAssemblerSupport<Account, AccountResource> {
	private static Logger mylogger = LoggerFactory.getLogger(AccountResourceAsm.class);
	
	public AccountResourceAsm() {
        super(AccountController.class, AccountResource.class);
    }

    @Override
    public AccountResource toResource(Account account) {
        AccountResource res = new AccountResource();
        res.setEmail(account.getEmail());
        res.setPassword(account.getPassword());
        //res.add(linkTo(methodOn(AccountController.class).getAccount(account.getId())).withSelfRel());
       //mylogger.info("Poripsa shahalalala" + res.toString());
        //res.add(linkTo(methodOn(AccountController.class).findAllBlogs(account.getId())).withRel("blogs"));
        return res;
    }
}
