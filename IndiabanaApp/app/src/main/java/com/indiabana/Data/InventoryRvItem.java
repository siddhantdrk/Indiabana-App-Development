package com.indiabana.Data;

public class InventoryRvItem {
    private final int publicationImgId;
    private final String title;
    private final String price;
    private final String publicationType;

    public InventoryRvItem(int publicationImgId, String title, String price, String publicationType) {
        this.publicationImgId = publicationImgId;
        this.title = title;
        this.price = price;
        this.publicationType = publicationType;
    }

    public int getPublicationImgId() {
        return publicationImgId;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getPublicationType() {
        return publicationType;
    }
}
