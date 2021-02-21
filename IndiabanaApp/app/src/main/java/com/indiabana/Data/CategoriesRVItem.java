package com.indiabana.Data;

public class CategoriesRVItem {
    String category,image_url,id;
    public CategoriesRVItem(String id, String category, String image_url){
        this.id=id;
        this.category=category;
        this.image_url=image_url;
    }

    public String getCategory() {
        return category;
    }

    public String getId() {
        return id;
    }

    public String getImage_url() {
        return image_url;
    }
}
