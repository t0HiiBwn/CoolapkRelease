package com.tencent.android.tpush;

/* compiled from: ProGuard */
public enum NotificationAction {
    clicked(0),
    activity(1),
    url(2),
    intent(3),
    action_package(4),
    intent_with_action(5),
    delete(2),
    open(3),
    open_cancel(4),
    download(5),
    download_cancel(6);
    
    private int type;

    private NotificationAction(int i) {
        this.type = i;
    }

    public static NotificationAction getNotificationAction(int i) {
        if (i == 0) {
            return clicked;
        }
        if (i == 1) {
            return activity;
        }
        if (i == 2) {
            return url;
        }
        if (i == 3) {
            return intent;
        }
        if (i == 4) {
            return action_package;
        }
        if (i != 5) {
            return null;
        }
        return intent_with_action;
    }

    public int getType() {
        return this.type;
    }
}
