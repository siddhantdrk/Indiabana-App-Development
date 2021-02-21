package com.indiabana.Data;

public class NotificationFragmentRvItem {
    String title, description;
    int NotificationImgId;

    public NotificationFragmentRvItem(String title, String description, int notificationImgId) {
        this.title = title;
        this.description = description;
        NotificationImgId = notificationImgId;
    }

    public int getNotificationImgId() {
        return NotificationImgId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
