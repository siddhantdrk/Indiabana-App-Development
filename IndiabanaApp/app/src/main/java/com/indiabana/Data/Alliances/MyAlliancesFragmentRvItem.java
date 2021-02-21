package com.indiabana.Data.Alliances;

public class MyAlliancesFragmentRvItem {
    private final int itemImgId;
    private final String title;
    private final String details;
    private final String rating;
    private final float ratingValue;

    public MyAlliancesFragmentRvItem(int itemImgId, String title, String details, String rating, float ratingValue) {
        this.itemImgId = itemImgId;
        this.title = title;
        this.details = details;
        this.rating = rating;
        this.ratingValue = ratingValue;
    }

    public int getItemImgId() {
        return itemImgId;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public String getRating() {
        return rating;
    }

    public float getRatingValue() {
        return ratingValue;
    }
}
