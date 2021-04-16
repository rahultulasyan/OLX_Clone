package com.olx.app.offer_service.controller;


import com.olx.app.offer_service.entity.Offer;
import com.olx.app.offer_service.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OfferController {

    @Autowired
    private OfferService offerService;

    /**
     * Description: Gets an offer using itemId and UserId
     * @param item_id : unique Primary key of the Item Table
     * @param user_id : unique primary key of the User Table
     * @return An object of type class OFFER
     */
    @GetMapping("/api/v1/getAllOffer/{user_id}")
    private ResponseEntity<List> getAllOffer (@PathVariable("user_id") Long user_id){

        return  offerService.getAllOffer(user_id);

    }


    /**
     * Description: Gets an offer using itemId and UserId
     * @param item_id : unique Primary key of the Item Table
     * @param user_id : unique primary key of the User Table
     * @return An object of type class OFFER
     */
    @GetMapping("/api/v1/{item_id}/{user_id}")
    private ResponseEntity<Offer> getAnOffer(@PathVariable Long item_id, @PathVariable Long user_id){

        return  offerService.getAnOffer(item_id, user_id);
    }

    /**
     * Description: Posts a new offer using the object into Offer Table
     * @param offer : An object of class Offer
     * @return A DTO with status Code and message
     */
    @PostMapping("/api/v1/create")
    public ResponseEntity<String> addOffer(@RequestBody Offer offer){
        System.out.println("adding offer");
        return offerService.addOffer(offer);


    }

    //    Update an Offer (Seller)
    /**
     * Description: Updates the counter_offer section in the Offer Table
     * @param item_id : unique Primary key of the Item Table
     * @param user_id : unique primary key of the User Table
     * @param price : Seller's new parameter with which counter_offer is to be updated
     * @return A DTO with status Code and message
     */
    @PutMapping("/api/v1/updateSeller/{itemId}/{userId}/{price}")
    public ResponseEntity<String> updateCrossOffer(@PathVariable("itemId") Long item_id, @PathVariable("userId") Long user_id, @PathVariable("price") Long price){
        return offerService.updateCrossOffer(item_id, user_id, price);
    }



    //    Update an Offer (Buyer)
    /**
     * Description : Updates the offer_price section in the Offer Table
     * @param item_id : unique Primary key of the Item Table
     * @param user_id : unique primary key of the User Table
     * @param price : Buyer's new parameter with which offer_price is to be updated
     * @return A DTO with status Code and message
     */
    @PutMapping("/api/v1/updateBuyer/{itemId}/{userId}")
    public ResponseEntity<String> updateOfferPrice(@PathVariable("itemId") Long item_id, @PathVariable("userId") Long user_id, @RequestBody Long price){

        return offerService.updateOfferPrice(item_id, user_id, price);

    }


    //    Update Interest
    /**
     * Description : Updates the interest of Buyer/Seller in the interest section in the Offer Table
     * @param item_id : unique Primary key of the Item Table
     * @param user_id : unique primary key of the User Table
     * @param answer : It is Boolean Variable, Seller or Buyer provides the answer whether they are interested or not
     * @return A DTO with status Code and message
     */
    @PutMapping("/api/v1/updateInterest/{itemId}/{userId}/{answer}")
    public ResponseEntity<String> updateInterest(@PathVariable("itemId") Long item_id, @PathVariable("userId") Long user_id, @PathVariable("answer") boolean answer){

        return offerService.updateInterest(item_id, user_id, answer);

    }


}
