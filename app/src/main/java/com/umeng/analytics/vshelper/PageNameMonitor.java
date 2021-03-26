package com.umeng.analytics.vshelper;

public class PageNameMonitor implements a {
    private static String currentActivity;
    private static String currentCustomPage;
    private static Object lock = new Object();

    private PageNameMonitor() {
    }

    private static class a {
        private static final PageNameMonitor a = new PageNameMonitor();

        private a() {
        }
    }

    public static PageNameMonitor getInstance() {
        return a.a;
    }

    @Override // com.umeng.analytics.vshelper.a
    public void activityResume(String str) {
        synchronized (lock) {
            currentActivity = str;
        }
    }

    @Override // com.umeng.analytics.vshelper.a
    public void activityPause(String str) {
        synchronized (lock) {
            currentActivity = null;
        }
    }

    @Override // com.umeng.analytics.vshelper.a
    public void customPageBegin(String str) {
        synchronized (lock) {
            currentCustomPage = str;
        }
    }

    @Override // com.umeng.analytics.vshelper.a
    public void customPageEnd(String str) {
        synchronized (lock) {
            currentCustomPage = null;
        }
    }

    public String getCurrenPageName() {
        synchronized (lock) {
            String str = currentCustomPage;
            if (str != null) {
                return str;
            }
            String str2 = currentActivity;
            if (str2 != null) {
                return str2;
            }
            return null;
        }
    }
}
