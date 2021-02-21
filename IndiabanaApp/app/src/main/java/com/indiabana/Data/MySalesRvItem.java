package com.indiabana.Data;

public class MySalesRvItem {
    int shoppingImgId;
    String productTitle, price, amount, status, client;

    public MySalesRvItem(int shoppingImgId, String productTitle, String price, String amount, String status, String client) {
        this.shoppingImgId = shoppingImgId;
        this.productTitle = productTitle;
        this.price = price;
        this.amount = amount;
        this.status = status;
        this.client = client;
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

    public String getClient() {
        return client;
    }
}
