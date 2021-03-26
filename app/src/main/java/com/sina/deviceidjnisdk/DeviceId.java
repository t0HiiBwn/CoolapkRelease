package com.sina.deviceidjnisdk;

import android.content.Context;

public class DeviceId implements IDeviceId {
    private Context mContext;

    private native String getDeviceIdNative(Context context, String str, String str2, String str3);

    static {
        System.loadLibrary("weibosdkcore");
    }

    protected DeviceId(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override // com.sina.deviceidjnisdk.IDeviceId
    public String getDeviceId() {
        Context context = this.mContext;
        return getDeviceIdNative(context, DeviceInfo.getImei(context), DeviceInfo.getImsi(this.mContext), DeviceInfo.getMacAddress(this.mContext));
    }

    private String genCheckId(String str, String str2, String str3) {
        return str + str2 + str3;
    }
}
