package com.indiabana.Data;

public class QuestionFragmentRvItem {
    public String productName;
    public String productDetail;
    public int rightArrowBtn;

    public QuestionFragmentRvItem(String productName, String productDetail, int rightArrowBtn) {
        this.productName = productName;
        this.productDetail = productDetail;
        this.rightArrowBtn = rightArrowBtn;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public int getRightArrowBtn() {
        return rightArrowBtn;
    }

    public void setRightArrowBtn(int rightArrowBtn) {
        this.rightArrowBtn = rightArrowBtn;
    }
}
