package apples.pivotal.homework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pasapicella on 24/12/15.
 */
@RestController
public class CustomerRest
{
    private static final Logger log = LoggerFactory.getLogger(CustomerRest.class);

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping("/allcustomers")
    public List<Customer> allCustomers ()
    {
        return customerRepository.findAll();
    }

    @RequestMapping("/hello")
    public String helloWorld ()
    {
        return "Hello World!!!!";
    }
}
