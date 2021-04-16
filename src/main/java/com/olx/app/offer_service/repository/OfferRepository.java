package com.olx.app.offer_service.repository;


import com.olx.app.offer_service.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

        @Query(value = "Select * from offer where user_id=?1", nativeQuery = true)
        public List<Offer> findByIdAll(Long a);

}
