package com.indiabana.Data;

public class RecommendedRVItem {
    public String item_id;
    public String item_name;
    public String item_rate;
    public String delivery_time;
    public String item_image_url;

    public RecommendedRVItem(String item_id, String item_name, String item_rate, String item_image_url, String delivery_time){
        this.item_id=item_id;
        this.item_name=item_name;
        this.item_rate=item_rate;
        this.item_image_url=item_image_url;
        this.delivery_time=delivery_time;
    }

    public String getDelivery_time() {
        return delivery_time;
    }

    public String getItem_id() {
        return item_id;
    }

    public String getItem_image_url() {
        return item_image_url;
    }

    public String getItem_name() {
        return item_name;
    }

    public String getItem_rate() {
        return item_rate;
    }
}
