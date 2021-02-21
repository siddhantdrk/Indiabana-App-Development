package com.indiabana.Data;

public class MyShoppingRvItem {
    int shoppingImgId;
    String productTitle, price, amount, status;

    public MyShoppingRvItem(int shoppingImgId, String productTitle, String price, String amount, String status) {
        this.shoppingImgId = shoppingImgId;
        this.productTitle = productTitle;
        this.price = price;
        this.amount = amount;
        this.status = status;
    }

    public int getShoppingImgId() {
        return shoppingImgId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public String getPrice() {
        return price;
    }

    public String getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }
}
