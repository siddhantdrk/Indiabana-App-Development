package com.indiabana.Data;

public class ReviewImageRVItem {
    String url,id;
    public ReviewImageRVItem(String id, String url){
        this.id=id;
        this.url=url;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}
