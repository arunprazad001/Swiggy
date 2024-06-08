package com.masai.Swiggy.dao;

import com.masai.Swiggy.entity.Customer;
import com.masai.Swiggy.entity.DeliveryPartner;
import com.masai.Swiggy.repository.DeliveryPartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class DeliveryPartnerDAO {

    private final DeliveryPartnerRepository deliveryPartnerRepository;

    @Autowired
    public DeliveryPartnerDAO(DeliveryPartnerRepository deliveryPartnerRepository) {
        this.deliveryPartnerRepository = deliveryPartnerRepository;
    }

    public List<DeliveryPartner> findAll(int pageNo, int pageSize, String sortBy) {
        List<DeliveryPartner>deliveryPartners=deliveryPartnerRepository.findAll();
        Comparator<DeliveryPartner> comparator;
        switch (sortBy) {
            case "name":
                comparator = Comparator.comparing(DeliveryPartner::getName);
                break;
            case "phoneNumber":
                comparator = Comparator.comparing(DeliveryPartner::getPhoneNumber);
                break;
            default:
                comparator = Comparator.comparing(DeliveryPartner::getName);
                break;
        }
        return deliveryPartners.stream()
                .sorted(comparator)
                .skip((pageNo - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    public void save(DeliveryPartner deliveryPartner) {
        deliveryPartnerRepository.save(deliveryPartner);
    }

    public DeliveryPartner findById(String deliveryPartnerId) {
        return deliveryPartnerRepository.findByDeliveryPartnerId(deliveryPartnerId);
    }
    public List<DeliveryPartner>getAllPartners(){
        return deliveryPartnerRepository.findAll();
    }
}
