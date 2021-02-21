package com.indiabana.Data;

public class CartRvItem {

    private final int imgId;
    private final String itemName;
    private final String itemPrice;
    private final String itemQty;
    private final String itemColor;
    private final String itemCategory;

    public CartRvItem(int imgId, String itemName, String itemPrice, String itemQty, String itemColor, String itemCategory) {
        this.imgId = imgId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQty = itemQty;
        this.itemColor = itemColor;
        this.itemCategory = itemCategory;
    }

    public int getImgId() {
        return imgId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public String getItemQty() {
        return itemQty;
    }

    public String getItemColor() {
        return itemColor;
    }

    public String getItemCategory() {
        return itemCategory;
    }
}
