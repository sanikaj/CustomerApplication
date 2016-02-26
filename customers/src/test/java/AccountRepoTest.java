/*package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;

import com.sanika.spring.web.core.repositories.AccountRepository;
import com.sanika.spring.web.core.model.entities.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:mongo-context.xml")
public class AccountRepoTest {
	@Autowired
	private AccountRepository repo;
    private Account account;
    
	public void setup(){
      account = new Account(); 
      account.setEmail("sammy@gmail.com");
      account.setPassword("1234");
      repo.createAccount(account);
	}
	
	@Test
	public void test() {

        Account account = repo.findAccountByEmail(this.account.getEmail());
        assertNotNull(account);
        assertEquals(account.getEmail(), "sammy@gmail.com");
        assertEquals(account.getPassword(), "1234");
	}
}
*/