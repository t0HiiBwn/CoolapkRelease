package com.aurelhubert.ahbottomnavigation.notification;

public final class AHNotificationHelper {
    private AHNotificationHelper() {
    }

    public static int getTextColor(AHNotification aHNotification, int i) {
        int textColor = aHNotification.getTextColor();
        return textColor == 0 ? i : textColor;
    }

    public static int getBackgroundColor(AHNotification aHNotification, int i) {
        int backgroundColor = aHNotification.getBackgroundColor();
        return backgroundColor == 0 ? i : backgroundColor;
    }
}
