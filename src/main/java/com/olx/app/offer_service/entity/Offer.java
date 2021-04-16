package com.olx.app.offer_service.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.SchemaOutputResolver;

@Entity
public class Offer {

    @Id
    private Long item_id;
    private Long user_id;
    private Long original_price;
    private Long counter_offer;
    private Long offer_price;
    private Boolean interested;

    public Offer() {
    }

    public Offer(Long item_id, Long user_id, Long original_price, Long counter_offer, Long offer_price, Boolean interested) {
        this.item_id = item_id;
        this.user_id = user_id;
        this.original_price = original_price;
        this.counter_offer = counter_offer;
        this.offer_price = offer_price;
        this.interested = interested;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(Long original_price) {
        this.original_price = original_price;
    }

    public Long getCounter_offer() {
        return counter_offer;
    }

    public void setCounter_offer(Long counter_offer) {
        this.counter_offer = counter_offer;
    }

    public Long getOffer_price() {
        return offer_price;
    }

    public void setOffer_price(Long offer_price) {
        this.offer_price = offer_price;
    }

    public Boolean getInterested() {
        return interested;
    }

    public void setInterested(Boolean interested) {
        this.interested = interested;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "item_id='" + item_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", original_price=" + original_price +
                ", counter_offer=" + counter_offer +
                ", offer_price=" + offer_price +
                ", interested=" + interested +
                '}';
    }

}
