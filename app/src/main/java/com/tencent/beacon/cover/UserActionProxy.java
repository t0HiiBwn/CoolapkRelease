package com.tencent.beacon.cover;

import android.content.Context;
import com.tencent.beacon.upload.InitHandleListener;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.beacon.upload.UploadHandleListener;
import java.util.Map;

public class UserActionProxy {
    public void doUploadRecords() {
    }

    public void enablePagePath(boolean z) {
    }

    public void flushObjectsToDB(boolean z) {
    }

    public String getCloudParas(String str) {
        return "";
    }

    public String getQIMEI() {
        return "";
    }

    public String getSDKVersion() {
        return "";
    }

    public void initUserAction(Context context) {
    }

    public void initUserAction(Context context, boolean z) {
    }

    public void initUserAction(Context context, boolean z, long j) {
    }

    public void initUserAction(Context context, boolean z, long j, InitHandleListener initHandleListener, UploadHandleListener uploadHandleListener) {
    }

    public boolean loginEvent(boolean z, long j, Map<String, String> map) {
        return true;
    }

    public void onPageIn(String str) {
    }

    public void onPageOut(String str) {
    }

    public boolean onUserAction(String str, Map<String, String> map, boolean z, boolean z2) {
        return true;
    }

    public boolean onUserAction(String str, boolean z, long j, long j2, Map<String, String> map, boolean z2) {
        return true;
    }

    public boolean onUserAction(String str, boolean z, long j, long j2, Map<String, String> map, boolean z2, boolean z3) {
        return true;
    }

    public boolean onUserActionToTunnel(String str, String str2, Map<String, String> map, boolean z, boolean z2) {
        return true;
    }

    public boolean onUserActionToTunnel(String str, String str2, boolean z, long j, long j2, Map<String, String> map, boolean z2, boolean z3) {
        return true;
    }

    public void registerTunnel(TunnelInfo tunnelInfo) {
    }

    public void setAPPVersion(String str) {
    }

    public void setAdditionalInfo(String str, Map<String, String> map) {
    }

    public void setAdditionalInfo(Map<String, String> map) {
    }

    public void setAppKey(String str) {
    }

    public void setAppVersion(String str) {
    }

    public void setAppkey(String str) {
    }

    public void setChannelID(String str) {
    }

    public void setJsClientId(String str) {
    }

    public void setLogAble(boolean z, boolean z2) {
    }

    public void setQQ(String str) {
    }

    public void setReportDomain(String str, String str2) {
    }

    public void setSDKVersion(String str) {
    }

    public void setUploadMode(boolean z) {
    }

    public void setUserID(String str, String str2) {
    }
}
