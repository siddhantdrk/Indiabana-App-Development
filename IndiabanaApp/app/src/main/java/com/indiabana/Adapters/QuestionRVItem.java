package com.indiabana.Data;

public class QuestionRVItem {
    String qs,ans,date,qs_id;
    public QuestionRVItem(String qs_id, String qs, String ans, String date){
        this.qs_id=qs_id;
        this.qs=qs;
        this.ans=ans;
        this.date=ans;
    }

    public String getAns() {
        return ans;
    }

    public String getDate() {
        return date;
    }

    public String getQs() {
        return qs;
    }

    public String getQs_idId() {
        return qs_id;
    }
}
