package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
/**
 * 
 * 
 If you are using Maven, you can run the application using mvn spring-boot:run. 
 Or you can build the JAR file with mvn clean package and run
 the JAR by typing: java -jar target/gs-rest-service-0.1.0.jar
 * 
 */

/*
 * public Greeting greeting
 * http://localhost:8080/greeting?name=Miguel
 */



@RestController
@RequestMapping("/city/")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //http://localhost:8080/greeting?name=Miguel
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="Universo") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    // http://localhost:8080/city/Chicago
    @RequestMapping(value = "/{cityName}", method = RequestMethod.GET)
    public String getAddress(@PathVariable String cityName){
    	String result="Welcome to " +cityName;
    	return result;
    }
     
}