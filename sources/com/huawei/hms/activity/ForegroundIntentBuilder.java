package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.utils.Util;

public class ForegroundIntentBuilder {
    private Activity a;
    private RequestHeader b;
    private String c;
    private ForegroundInnerHeader d;

    public ForegroundIntentBuilder(Activity activity) throws IllegalArgumentException {
        if (activity != null) {
            this.a = activity;
            RequestHeader requestHeader = new RequestHeader();
            this.b = requestHeader;
            requestHeader.setPkgName(activity.getPackageName());
            this.b.setSdkVersion(50000301);
            this.c = "";
            ForegroundInnerHeader foregroundInnerHeader = new ForegroundInnerHeader();
            this.d = foregroundInnerHeader;
            foregroundInnerHeader.setApkVersion(30000000);
            return;
        }
        throw new IllegalArgumentException("listener must not be null.");
    }

    public Intent build() {
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(this.a, a.class.getName());
        if (this.b.getAppID() == null) {
            RequestHeader requestHeader = this.b;
            requestHeader.setAppID(Util.getAppId(this.a) + "|");
        } else {
            RequestHeader requestHeader2 = this.b;
            requestHeader2.setAppID(Util.getAppId(this.a) + "|" + this.b.getAppID());
        }
        if (TextUtils.isEmpty(this.b.getTransactionId())) {
            RequestHeader requestHeader3 = this.b;
            requestHeader3.setTransactionId(TransactionIdCreater.getId(requestHeader3.getAppID(), "hub.request"));
        }
        intentStartBridgeActivity.putExtra("HMS_FOREGROUND_REQ_HEADER", this.b.toJson());
        intentStartBridgeActivity.putExtra("HMS_FOREGROUND_REQ_BODY", this.c);
        intentStartBridgeActivity.putExtra("HMS_FOREGROUND_REQ_INNER", this.d.toJson());
        return intentStartBridgeActivity;
    }

    public ForegroundIntentBuilder setSubAppId(String str) {
        this.b.setAppID(str);
        return this;
    }

    public ForegroundIntentBuilder setRequestBody(String str) {
        this.c = str;
        return this;
    }

    public ForegroundIntentBuilder setMinApkVersion(int i) {
        this.d.setApkVersion(i);
        return this;
    }

    public ForegroundIntentBuilder setResponseCallback(String str, BusResponseCallback busResponseCallback) {
        this.d.setResponseCallbackKey(str);
        ForegroundBusResponseMgr.getInstance().registerObserver(str, busResponseCallback);
        return this;
    }

    public ForegroundIntentBuilder setResponseCallback(String str) {
        this.d.setResponseCallbackKey(str);
        return this;
    }

    public ForegroundIntentBuilder setAction(String str) {
        this.b.setApiName(str);
        return this;
    }

    public ForegroundIntentBuilder setServiceName(String str) {
        this.b.setSrvName(str);
        return this;
    }

    public ForegroundIntentBuilder setTransactionId(String str) {
        this.b.setTransactionId(str);
        return this;
    }

    public ForegroundIntentBuilder setKitSdkVersion(int i) {
        this.b.setKitSdkVersion(i);
        return this;
    }

    public static void registerResponseCallback(String str, BusResponseCallback busResponseCallback) {
        ForegroundBusResponseMgr.getInstance().registerObserver(str, busResponseCallback);
    }

    public static void unregisterResponseCallback(String str) {
        ForegroundBusResponseMgr.getInstance().unRegisterObserver(str);
    }
}
