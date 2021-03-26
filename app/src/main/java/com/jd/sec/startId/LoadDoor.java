package com.jd.sec.startId;

import android.content.Context;

public class LoadDoor {
    private static boolean sLoadSuccess;

    private static native String getSid(Object obj);

    static {
        try {
            System.loadLibrary("CPS");
            sLoadSuccess = true;
        } catch (Throwable th) {
            th.printStackTrace();
            sLoadSuccess = false;
        }
    }

    private static class SingletonHolder {
        static LoadDoor instance = new LoadDoor();

        private SingletonHolder() {
        }
    }

    private LoadDoor() {
    }

    public static LoadDoor getInstance() {
        return SingletonHolder.instance;
    }

    public String getLocalSid(Context context) {
        if (!sLoadSuccess) {
            return "";
        }
        return getSid(context);
    }

    public boolean isLoadSuccess() {
        return sLoadSuccess;
    }
}
