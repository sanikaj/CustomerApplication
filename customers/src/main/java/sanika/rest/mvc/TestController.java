package sanika.rest.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class TestController {

	private static Logger mylogger = LoggerFactory.getLogger(TestController.class);
		
   @RequestMapping(value = "/test", method = RequestMethod.GET)
   public String test() {
	 mylogger.info("Work shalalalalalala"); 
	 System.out.println("Please work!!!!!");
	 return "index";
   }
}
