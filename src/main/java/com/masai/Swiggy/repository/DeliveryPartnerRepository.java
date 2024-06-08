package com.masai.Swiggy.repository;

import com.masai.Swiggy.entity.DeliveryPartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryPartnerRepository extends JpaRepository<DeliveryPartner,String> {
    DeliveryPartner findByDeliveryPartnerId(String deliveryPartnerId);
}
