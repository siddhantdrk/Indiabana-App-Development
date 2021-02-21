package com.indiabana.Data;

public class BillsRvItem {
    private final String date;
    private final String saleType;
    private final String orderNumber;
    private final String money;
    private final String status;

    public BillsRvItem(String date, String saleType, String orderNumber, String money, String status) {
        this.date = date;
        this.saleType = saleType;
        this.orderNumber = orderNumber;
        this.money = money;
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public String getSaleType() {
        return saleType;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getMoney() {
        return money;
    }

    public String getStatus() {
        return status;
    }
}
