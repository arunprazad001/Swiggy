package com.masai.Swiggy.service;

import com.masai.Swiggy.dao.DeliveryPartnerDAO;
import com.masai.Swiggy.entity.DeliveryPartner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class DeliveryPartnerService {
    @Autowired
    private DeliveryPartnerDAO deliveryPartnerDAO;

    public List<DeliveryPartner> getAllDeliveryPartners(int pageNo, int pageSize, String sortBy) {
        return deliveryPartnerDAO.findAll(pageNo,pageSize,sortBy);
    }

    public void addDeliveryPartner(DeliveryPartner deliveryPartner) {
        deliveryPartnerDAO.save(deliveryPartner);
    }

    public DeliveryPartner getDeliveryPartnerById(String deliveryPartnerId) {
        return deliveryPartnerDAO.findById(deliveryPartnerId);
    }
    public List<DeliveryPartner>getAllPartners(){
        return deliveryPartnerDAO.getAllPartners();
    }
}
