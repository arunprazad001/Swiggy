package com.masai.Swiggy.dao;

import com.masai.Swiggy.entity.DeliveryPartner;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class DeliveryPartnerDAO {
    private List<DeliveryPartner> deliveryPartners = new ArrayList<>();

    public List<DeliveryPartner> findAll() {
        return deliveryPartners;
    }

    public void save(DeliveryPartner deliveryPartner) {
        deliveryPartners.add(deliveryPartner);
    }

    public DeliveryPartner findById(String deliveryPartnerId) {
        return deliveryPartners.stream()
                .filter(d -> d.getDeliveryPartnerId().equals(deliveryPartnerId))
                .findFirst()
                .orElse(null);
    }
}
