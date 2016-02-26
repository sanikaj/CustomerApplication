/*package test.java;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.Mongo;
import com.sanika.spring.web.core.model.entities.Account;
import com.sanika.spring.web.core.repositories.AccountRepository;
import com.sanika.spring.web.core.repositories.jpa.JpaAccountRepo;
import com.sanika.spring.web.rest.mvc.SpringMongoConfig;

import java.util.ArrayList;
import java.util.List;

public class MongoApp {

	private static final Log log = LogFactory.getLog(MongoApp.class);

	@Autowired
	static JpaAccountRepo repos;

	public static void main(String[] args) throws Exception {
        repos = new JpaAccountRepo();
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");
		//MongoOperations mongoOperation = (MongoOperations) ctx.getBean("customermongoTemplate");

		List<Account> accounts = new ArrayList<Account>();
		Account user1 = new Account("google@google.com", "1001");
		Account user2 = new Account("jammie@gmail.com", "1234");
		accounts.add(user1);
		accounts.add(user2);
		mongoOperation.insert(accounts,Account.class);
		repos.createAccount(user1);
		
		BasicQuery query1 = new BasicQuery("{ email :'google@google.com'}");
		Account accountTest1 = mongoOperation.findOne(query1, Account.class);

		System.out.println("query1 - " + query1.toString());
		System.out.println("userTest1 - " + accountTest1.toString());
	}
}
*/