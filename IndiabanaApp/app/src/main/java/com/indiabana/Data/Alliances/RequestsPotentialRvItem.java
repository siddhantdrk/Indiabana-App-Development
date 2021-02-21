package com.indiabana.Data.Alliances;

public class RequestsPotentialRvItem {
    private final int itemImgId;
    private final String title;
    private final String details;
    private final String rating;
    private final String commonProductNum;
    private final float ratingValue;

    public RequestsPotentialRvItem(int itemImgId, String title, String details, String rating, String commonProductNum, float ratingValue) {
        this.itemImgId = itemImgId;
        this.title = title;
        this.details = details;
        this.rating = rating;
        this.commonProductNum = commonProductNum;
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

    public String getCommonProductNum() {
        return commonProductNum;
    }

    public float getRatingValue() {
        return ratingValue;
    }
}
