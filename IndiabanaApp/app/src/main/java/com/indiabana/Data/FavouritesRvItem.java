package com.indiabana.Data;

public class FavouritesRvItem {
    private final int imgId;
    private final String itemType;
    private final String title;
    private final String deliveryTime;
    private final String price;

    public FavouritesRvItem(int imgId, String itemType, String title, String deliveryTime, String price) {
        this.imgId = imgId;
        this.itemType = itemType;
        this.title = title;
        this.deliveryTime = deliveryTime;
        this.price = price;
    }

    public int getImgId() {
        return imgId;
    }

    public String getItemType() {
        return itemType;
    }

    public String getTitle() {
        return title;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public String getPrice() {
        return price;
    }
}
