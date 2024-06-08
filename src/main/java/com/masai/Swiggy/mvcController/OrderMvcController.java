package com.masai.Swiggy.mvcController;

import com.masai.Swiggy.entity.Order;
import com.masai.Swiggy.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderMvcController {

    @Autowired
    private OrderService orderService;

    private static final Logger logger = LoggerFactory.getLogger(OrderMvcController.class);

    @GetMapping("/getAll")
    public String getAllOrders(Model model) {
        logger.info("Fetching all orders");
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "order-list";
    }

    @GetMapping("/show")
    public String showPlaceOrderForm(Model model) {
        logger.info("Showing place order form");
        model.addAttribute("order", new Order());
        return "order-form";
    }

    @PostMapping("/add")
    public String placeOrder(@ModelAttribute("order") @Validated Order order) {
        logger.info("Received request to place order: {}", order);
        orderService.placeOrder(order);
        return "redirect:/restaurants/getAll";
    }
}
