package com.masai.Swiggy.controller;

import com.masai.Swiggy.entity.DeliveryPartner;
import com.masai.Swiggy.service.DeliveryPartnerService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
@RestController
@RequestMapping("/delivery-partners")
public class DeliveryPartnerController {
    @Autowired
    private DeliveryPartnerService deliveryPartnerService;

    private static final Logger logger = LoggerFactory.getLogger(DeliveryPartnerController.class);

    @GetMapping("/getAll")
    public List<DeliveryPartner> getAllDeliveryPartners(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "10") int size,
                                                        @RequestParam(defaultValue = "name") String sortBy) {
        logger.info("Fetching all delivery partners based on parameters pageNo :{} pageSize: {} " +
                "and sortBy :{}",page,size,sortBy);
        return deliveryPartnerService.getAllDeliveryPartners(page,size,sortBy);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDeliveryPartner(@Valid @RequestBody DeliveryPartner deliveryPartner) {
       logger.info("Request received to add delivery partner: {}",deliveryPartner);
        deliveryPartnerService.addDeliveryPartner(deliveryPartner);
    }

    @GetMapping("get/{id}")
    public DeliveryPartner getDeliveryPartnerById(@PathVariable String id) {
        logger.info("Request received to get delivery partner on partnerId: {}",id);
        return deliveryPartnerService.getDeliveryPartnerById(id);
    }
}
