package com.masai.Swiggy.mvcController;

import com.masai.Swiggy.entity.DeliveryPartner;
import com.masai.Swiggy.service.DeliveryPartnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/delivery")
public class DeliveryPartnerMvcController {

    @Autowired
    private DeliveryPartnerService deliveryPartnerService;

    private static final Logger logger = LoggerFactory.getLogger(DeliveryPartnerMvcController.class);

    @GetMapping("/getAll")
    public String getAllDeliveryPartners(Model model) {
        logger.info("Fetching all delivery partners");
        List<DeliveryPartner> deliveryPartners = deliveryPartnerService.getAllPartners();
        model.addAttribute("deliveryPartners", deliveryPartners);
        return "delivery-partner-list";
    }

    @GetMapping("/show")
    public String showAddDeliveryPartnerForm(Model model) {
        logger.info("Showing add delivery partner form");
        model.addAttribute("deliveryPartner", new DeliveryPartner());
        return "delivery-partner-form.jsp";
    }

    @PostMapping("/add")
    public String addDeliveryPartner(@ModelAttribute("deliveryPartner") @Validated DeliveryPartner deliveryPartner) {
        logger.info("Received request to add delivery partner: {}", deliveryPartner);
        deliveryPartnerService.addDeliveryPartner(deliveryPartner);
        return "redirect:/delivery-partners/getAll";
    }
}
