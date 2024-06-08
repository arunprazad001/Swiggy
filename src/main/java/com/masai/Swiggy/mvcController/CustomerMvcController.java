package com.masai.Swiggy.mvcController;

import com.masai.Swiggy.entity.Customer;
import com.masai.Swiggy.entity.Order;
import com.masai.Swiggy.service.CustomerService;
import com.masai.Swiggy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller()
@RequestMapping("/customer")
public class CustomerMvcController {


    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;


    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/getAll")
    public String getAllCustomers(Model model) {
        List<Customer> customers = customerService.getAll();
        model.addAttribute("customers", customers);
        return "customer-list";
    }

    @GetMapping("/show")
    public String showAddCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/add")
    public String addCustomer(@ModelAttribute("customer") @Validated Customer customer) {
        customerService.addCustomer(customer);
        return "redirect:/customers/getAll";
    }

    @GetMapping("/{id}/orders")
    public String getCustomerOrderHistory(@PathVariable String id, Model model) {
        List<Order> orders = orderService.getCustomerOrderHistory(id);
        model.addAttribute("orders", orders);
        return "order-history";
    }
}
