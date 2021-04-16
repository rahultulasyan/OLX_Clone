package com.olx.app.offer_service.DTO;

import lombok.Data;

@Data
public class OfferDTO {

    private Long original_price;
    private Long counter_offer;
    private Long offer_price;
    private Boolean interested;

}

