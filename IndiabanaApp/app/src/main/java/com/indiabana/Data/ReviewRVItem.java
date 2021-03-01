package com.indiabana.Data;

public class ReviewRVItem {
    String name,review,id,time;
    int like,dislike;
    float rating;

    public ReviewRVItem(String id, String name, String review, String time, int like, int dislike, float rating){
        this.id=id;
        this.name=name;
        this.review=review;
        this.time=time;
        this.like=like;
        this.dislike=dislike;
        this.rating=rating;
    }

    public String getId() {
        return id;
    }

    public float getRating() {
        return rating;
    }

    public int getDislike() {
        return dislike;
    }

    public int getLike() {
        return like;
    }

    public String getName() {
        return name;
    }

    public String getReview() {
        return review;
    }

    public String getTime() {
        return time;
    }
}
