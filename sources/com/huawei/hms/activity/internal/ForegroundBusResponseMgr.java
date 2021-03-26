package com.huawei.hms.activity.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class ForegroundBusResponseMgr {
    private static final ForegroundBusResponseMgr a = new ForegroundBusResponseMgr();
    private final Map<String, BusResponseCallback> b = new HashMap();

    public static ForegroundBusResponseMgr getInstance() {
        return a;
    }

    public void registerObserver(String str, BusResponseCallback busResponseCallback) {
        if (!TextUtils.isEmpty(str) && busResponseCallback != null) {
            synchronized (this.b) {
                if (!this.b.containsKey(str)) {
                    this.b.put(str, busResponseCallback);
                }
            }
        }
    }

    public void unRegisterObserver(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.b) {
                this.b.remove(str);
            }
        }
    }

    public BusResponseCallback get(String str) {
        BusResponseCallback busResponseCallback;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.b) {
            busResponseCallback = this.b.get(str);
        }
        return busResponseCallback;
    }
}
