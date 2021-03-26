package com.tencent.beacon.core;

import android.content.Context;
import com.tencent.beacon.core.event.o;
import com.tencent.beacon.cover.UserActionProxy;
import com.tencent.beacon.upload.InitHandleListener;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.beacon.upload.UploadHandleListener;
import java.util.Map;

public class UserActionProxyImpl extends UserActionProxy {
    @Override // com.tencent.beacon.cover.UserActionProxy
    public void setSDKVersion(String str) {
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public void initUserAction(Context context) {
        o.a(context);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public void initUserAction(Context context, boolean z) {
        o.a(context, z);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public void initUserAction(Context context, boolean z, long j) {
        o.a(context, z, j);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public void initUserAction(Context context, boolean z, long j, InitHandleListener initHandleListener, UploadHandleListener uploadHandleListener) {
        o.a(context, z, j, initHandleListener, uploadHandleListener);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public boolean onUserAction(String str, boolean z, long j, long j2, Map<String, String> map, boolean z2) {
        return o.a(str, z, j, j2, map, z2);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public boolean onUserAction(String str, boolean z, long j, long j2, Map<String, String> map, boolean z2, boolean z3) {
        return o.a(str, z, j, j2, map, z2, z3);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public boolean onUserActionToTunnel(String str, String str2, boolean z, long j, long j2, Map<String, String> map, boolean z2, boolean z3) {
        return o.a(str, str2, z, j, j2, map, z2, z3);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public boolean onUserActionToTunnel(String str, String str2, Map<String, String> map, boolean z, boolean z2) {
        return o.a(str, str2, map, z, z2);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public boolean onUserAction(String str, Map<String, String> map, boolean z, boolean z2) {
        return o.a(str, map, z, z2);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public boolean loginEvent(boolean z, long j, Map<String, String> map) {
        return o.a(z, j, map);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public void setLogAble(boolean z, boolean z2) {
        o.a(z, z2);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public void enablePagePath(boolean z) {
        o.c(z);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public String getQIMEI() {
        return o.c();
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public void setUploadMode(boolean z) {
        o.a(z);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public String getSDKVersion() {
        return o.d();
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public void setAppKey(String str) {
        o.e(str);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public void setAppkey(String str) {
        o.j(str);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public void setAppVersion(String str) {
        o.a(str);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public void setAPPVersion(String str) {
        o.i(str);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public void setChannelID(String str) {
        o.f(str);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public void setUserID(String str, String str2) {
        o.a(str, str2);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public void setQQ(String str) {
        o.c(str);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public void setAdditionalInfo(Map<String, String> map) {
        o.a(map);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public void doUploadRecords() {
        o.b();
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public void flushObjectsToDB(boolean z) {
        o.b(z);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public String getCloudParas(String str) {
        return o.g(str);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public void setReportDomain(String str, String str2) {
        o.b(str, str2);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public void setJsClientId(String str) {
        o.h(str);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public void onPageIn(String str) {
        o.k(str);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public void onPageOut(String str) {
        o.l(str);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public void registerTunnel(TunnelInfo tunnelInfo) {
        o.a(tunnelInfo);
    }

    @Override // com.tencent.beacon.cover.UserActionProxy
    public void setAdditionalInfo(String str, Map<String, String> map) {
        o.a(str, map);
    }
}
