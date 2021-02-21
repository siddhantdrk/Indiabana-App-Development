package com.indiabana.Data;

public class FeaturedSellersRVItem {

    String id,logo_url,name,background_url;

    public FeaturedSellersRVItem(String id,String name,String logo_url,String background_url){
        this.id=id;
        this.name=name;
        this.logo_url=logo_url;
        this.background_url=background_url;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBackground_url() {
        return background_url;
    }

    public String getLogo_url() {
        return logo_url;
    }
}
