package com.masai.Swiggy.controller;

import com.masai.Swiggy.entity.DeliveryPartner;
import com.masai.Swiggy.service.DeliveryPartnerService;
import jakarta.validation.Valid;
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

    @GetMapping("/getAll")
    public List<DeliveryPartner> getAllDeliveryPartners() {
        return deliveryPartnerService.getAllDeliveryPartners();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDeliveryPartner(@Valid @RequestBody DeliveryPartner deliveryPartner) {
        deliveryPartnerService.addDeliveryPartner(deliveryPartner);
    }

    @GetMapping("get/{id}")
    public DeliveryPartner getDeliveryPartnerById(@PathVariable String id) {
        return deliveryPartnerService.getDeliveryPartnerById(id);
    }
}
