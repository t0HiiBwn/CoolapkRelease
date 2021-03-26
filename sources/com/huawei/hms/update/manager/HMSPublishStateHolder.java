package com.huawei.hms.update.manager;

public class HMSPublishStateHolder {
    public static final int NOT_CHECKED = 0;
    public static final int NOT_PUBLISHED_YET = 2;
    public static final int PUBLISHED = 1;
    private static int a;
    private static final Object b = new Object();

    public static int getPublishState() {
        int i;
        synchronized (b) {
            i = a;
        }
        return i;
    }

    public static void setPublishState(int i) {
        synchronized (b) {
            a = i;
        }
    }
}
