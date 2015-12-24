package apples.pivotal.homework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by pasapicella on 24/12/15.
 */
@Controller
public class WelcomeController
{
    private static final Logger log = LoggerFactory.getLogger(CustomerRest.class);

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String listCustomers (Model model)
    {
        List<Customer> customers = customerRepository.findAll();

        log.info("Customers = " + customers.size());

        model.addAttribute("customers", customers);
        model.addAttribute("customerscount", customers.size());

        return "welcome";

    }
}
