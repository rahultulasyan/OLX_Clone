package com.olx.app.offer_service.service;


import com.olx.app.offer_service.DTO.OfferDTO;
import com.olx.app.offer_service.entity.Offer;
import com.olx.app.offer_service.repository.OfferRepository;
import com.sun.xml.bind.v2.schemagen.episode.SchemaBindings;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    ModelMapper modelMapper;

    public ResponseEntity<List> getAllOffer(Long user_id) {

        List<Offer> offerInfo  = offerRepository.findByIdAll(user_id);
        List<OfferDTO> offerDTOInfo  = new ArrayList<>();

        for (Offer offer: offerInfo){
            OfferDTO offerDTO = new OfferDTO();
            modelMapper.map(offer, offerDTO);
            offerDTOInfo.add(offerDTO);
        }


        ResponseEntity<List> responseEntity =  new ResponseEntity<>(offerDTOInfo, HttpStatus.OK);
        return responseEntity;
    }

    public ResponseEntity<OfferDTO> getAnOffer(Long item_id, Long user_id){

        OfferDTO offerDTO = new OfferDTO();
        List<Offer> offerInfo = offerRepository.findAll();
        for (Offer offer: offerInfo){
            if (offer.getItem_id().equals(item_id) && offer.getUser_id().equals(user_id)) {

                modelMapper.map(offer, offerDTO);

                ResponseEntity<OfferDTO> responseEntity = new ResponseEntity<>(offerDTO, HttpStatus.OK);
                return responseEntity;
            }
        }
        return new ResponseEntity<OfferDTO>((OfferDTO) null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> addOffer(Offer offer) {

        List<Offer> offerInfo = offerRepository.findAll();
        for (Offer offer1: offerInfo){
            if (offer1.getItem_id().equals(offer.getItem_id()) && offer1.getUser_id().equals(offer.getUser_id())) {
                ResponseEntity<String> responseEntity = new ResponseEntity<>("Offer already exists", HttpStatus.BAD_REQUEST);
                return responseEntity;
            }
        }

        Offer offer1 = offerRepository.save(offer);
        ResponseEntity<String> responseEntity = new ResponseEntity<>("Offer Added Successfully", HttpStatus.OK);
        return responseEntity;

    }

    public ResponseEntity<String> updateCrossOffer(Long item_id, Long user_id, Long price) {

        List<Offer> offerInfo = offerRepository.findAll();
        for (Offer offer1: offerInfo){
            if (offer1.getItem_id().equals(item_id) && offer1.getUser_id().equals(user_id)) {

                offer1.setCounter_offer(price);

                offerRepository.save(offer1);
                ResponseEntity<String> responseEntity = new ResponseEntity<>("Offer updated Successfully", HttpStatus.OK);
                return responseEntity;
            }
        }

        ResponseEntity<String> responseEntity = new ResponseEntity<>("Offer Not Found !", HttpStatus.NOT_FOUND);
        return responseEntity;


    }

    public ResponseEntity<String> updateOfferPrice(Long item_id, Long user_id, Long price) {

        List<Offer> offerInfo = offerRepository.findAll();
        for (Offer offer1: offerInfo){
            if (offer1.getItem_id().equals(item_id) && offer1.getUser_id().equals(user_id)) {

                offer1.setOffer_price(price);
                offerRepository.save(offer1);
                ResponseEntity<String> responseEntity = new ResponseEntity<>("Offer updated Successfully", HttpStatus.OK);
                return responseEntity;
            }
        }

        ResponseEntity<String> responseEntity = new ResponseEntity<>("Offer Not Found !", HttpStatus.NOT_FOUND);
        return responseEntity;

    }

    public ResponseEntity<String> updateInterest(Long item_id, Long user_id, boolean answer) {

        List<Offer> offerInfo = offerRepository.findAll();
        for (Offer offer1: offerInfo){
            if (offer1.getItem_id().equals(item_id) && offer1.getUser_id().equals(user_id)) {

                offer1.setInterested(answer);
                offerRepository.save(offer1);
                ResponseEntity<String> responseEntity = new ResponseEntity<>("Offer updated Successfully", HttpStatus.OK);
                return responseEntity;
            }
        }

        ResponseEntity<String> responseEntity = new ResponseEntity<>("Offer Not Found !", HttpStatus.NOT_FOUND);
        return responseEntity;

    }


}
