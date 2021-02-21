package com.indiabana.Data;

public class ProductPricePostTypeRvItem {
    private final int badge_img;
    private final String badge_name;
    private final String duration_value;
    private final String exposure_value;
    private final String accumulate_value;
    private final String stock_value;
    private final String percent_value;
    private final int badge_textcolor;

    public ProductPricePostTypeRvItem(int badge_img, String badge_name, String duration_value, String exposure_value, String accumulate_value, String stock_value, String percent_value, int badge_textcolor) {
        this.badge_img = badge_img;
        this.badge_name = badge_name;
        this.duration_value = duration_value;
        this.exposure_value = exposure_value;
        this.accumulate_value = accumulate_value;
        this.stock_value = stock_value;
        this.percent_value = percent_value;
        this.badge_textcolor = badge_textcolor;
    }

    public int getBadge_img() {
        return badge_img;
    }

    public String getBadge_name() {
        return badge_name;
    }

    public String getDuration_value() {
        return duration_value;
    }

    public String getExposure_value() {
        return exposure_value;
    }

    public String getAccumulate_value() {
        return accumulate_value;
    }

    public String getStock_value() {
        return stock_value;
    }

    public String getPercent_value() {
        return percent_value;
    }

    public int getBadge_textcolor() {
        return badge_textcolor;
    }
}
