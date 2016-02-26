package sanika.rest.mvc.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import sanika.core.model.entities.Account;
import sanika.rest.mvc.AccountController;
import sanika.rest.mvc.resources.AccountListResource;
import sanika.rest.mvc.resources.AccountResource;
import sanika.rest.mvc.resources.asm.AccountResourceAsm;

import java.util.List;

public class AccountListResourceAsm extends ResourceAssemblerSupport<List<Account>, AccountListResource> {


    public AccountListResourceAsm() {
        super(AccountController.class, AccountListResource.class);
    }

    @Override
    public AccountListResource toResource(List<Account> accountList) {
        List<AccountResource> resList = new AccountResourceAsm().toResources(accountList);
        AccountListResource finalRes = new AccountListResource();
        finalRes.setAccountsConvertJson(resList);
        return finalRes;
    }
}
