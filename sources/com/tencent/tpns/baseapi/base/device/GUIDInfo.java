package com.tencent.tpns.baseapi.base.device;

import android.content.Context;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.Util;

/* compiled from: ProGuard */
public class GUIDInfo {
    public int encrypt = 0;
    public int errCode;
    public long expiredSeconds = 0;
    public long guid = 0;
    public long guidLastAccessid = 0;
    public String mqttPortList = "";
    public String mqttServer = "";
    public String mqttServerIP = "";
    public long mqttServerRefreshTime = 0;
    public String passWord = "";
    public long refreshTime = 0;
    public int refuseRate = 0;
    public String result = "";
    public String token = "";
    public String tokenList = "";
    public String userName = "";

    public static GUIDInfo getGuidInfoFromShar(Context context) {
        GUIDInfo gUIDInfo = new GUIDInfo();
        try {
            gUIDInfo.guid = PushPreferences.getLong(context, "XG_GUID_GUID", 0);
            gUIDInfo.expiredSeconds = PushPreferences.getLong(context, "XG_GUID_EXPIRED_SECONDS", 0);
            gUIDInfo.refreshTime = PushPreferences.getLong(context, "XG_GUID_LAST_REFRESH_TIME", 0);
            gUIDInfo.token = PushPreferences.getString(context, "XG_GUID_TOKEN", "");
            gUIDInfo.tokenList = PushPreferences.getString(context, "XG_GUID_TOKEN_LIST", "");
            gUIDInfo.mqttServer = PushPreferences.getString(context, "XG_GUID_MQTT_SERVER", "");
            gUIDInfo.userName = PushPreferences.getString(context, "XG_GUID_MQTT_USERNAME", "");
            gUIDInfo.passWord = PushPreferences.getString(context, "XG_GUID_MQTT_PASSWORD", "");
            gUIDInfo.guidLastAccessid = PushPreferences.getLong(context, "XG_GUID_LAST_ACCESSID", 0);
            gUIDInfo.mqttServerRefreshTime = PushPreferences.getLong(context, "XG_GUID_MQTT_SERVER_LAST_REFRESH_TIME", 0);
            gUIDInfo.refuseRate = PushPreferences.getInt(context, "XG_GUID_SERVER_ABANDON_RATE", 0);
            gUIDInfo.mqttPortList = PushPreferences.getString(context, "XG_GUID_MQTT_PORTLIST", "");
            gUIDInfo.encrypt = PushPreferences.getInt(context, "XG_GUID_SERVER_ENCRYPT_LEVEL", 0);
        } catch (Throwable unused) {
        }
        return gUIDInfo;
    }

    public void saveGuidToSha(Context context) {
        if (!Util.isNullOrEmptyString(this.token)) {
            PushPreferences.putString(context, "XG_GUID_TOKEN", this.token);
        }
        if (!Util.isNullOrEmptyString(this.tokenList)) {
            PushPreferences.putString(context, "XG_GUID_TOKEN_LIST", this.tokenList);
        }
        if (!Util.isNullOrEmptyString(this.mqttServer)) {
            PushPreferences.putString(context, "XG_GUID_MQTT_SERVER", this.mqttServer);
        }
        if (!Util.isNullOrEmptyString(this.userName)) {
            PushPreferences.putString(context, "XG_GUID_MQTT_USERNAME", this.userName);
        }
        if (!Util.isNullOrEmptyString(this.passWord)) {
            PushPreferences.putString(context, "XG_GUID_MQTT_PASSWORD", this.passWord);
        }
        long j = this.guid;
        if (j >= 0) {
            PushPreferences.putLong(context, "XG_GUID_GUID", j);
        }
        long j2 = this.expiredSeconds;
        if (j2 >= 0) {
            PushPreferences.putLong(context, "XG_GUID_EXPIRED_SECONDS", j2);
        }
        long j3 = this.refreshTime;
        if (j3 >= 0) {
            PushPreferences.putLong(context, "XG_GUID_LAST_REFRESH_TIME", j3);
        }
        long j4 = this.guidLastAccessid;
        if (j4 >= 0) {
            PushPreferences.putLong(context, "XG_GUID_LAST_ACCESSID", j4);
        }
        int i = this.refuseRate;
        if (((long) i) >= 0) {
            PushPreferences.putInt(context, "XG_GUID_SERVER_ABANDON_RATE", i);
        }
        int i2 = this.encrypt;
        if (i2 >= 0) {
            PushPreferences.putInt(context, "XG_GUID_SERVER_ENCRYPT_LEVEL", i2);
        }
        if (!Util.isNullOrEmptyString(this.mqttPortList)) {
            PushPreferences.putString(context, "XG_GUID_MQTT_PORTLIST", this.mqttPortList);
        }
    }

    public boolean isError() {
        if (this.errCode != 0) {
            return true;
        }
        if (!Util.isNullOrEmptyString(this.token) && !Util.isNullOrEmptyString(this.mqttServer) && !Util.isNullOrEmptyString(this.userName) && !Util.isNullOrEmptyString(this.passWord)) {
            return false;
        }
        this.errCode = -5;
        this.result = "GUID check result is null";
        return true;
    }
}
