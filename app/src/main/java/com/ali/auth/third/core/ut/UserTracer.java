package com.ali.auth.third.core.ut;

import android.os.Build;
import android.text.TextUtils;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.model.RpcRequest;
import com.ali.auth.third.core.service.RpcService;
import com.ali.auth.third.core.service.UserTrackerService;
import com.ali.auth.third.core.service.impl.CredentialManager;
import com.ali.auth.third.core.util.CommonUtils;
import com.ali.auth.third.core.util.JSONUtils;
import com.ali.auth.third.core.util.SystemUtils;
import java.util.Map;
import org.json.JSONObject;

public class UserTracer implements UserTrackerService {
    public static JSONObject getAppInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("diskSize", CommonUtils.getSDCardSize());
            jSONObject.put("sysSize", CommonUtils.getSystemSize());
            jSONObject.put("memorySize", CommonUtils.getTotalMemory());
            jSONObject.put("deviceId", CommonUtils.getAndroidId());
            jSONObject.put("uuid", KernelContext.UUID);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("osType", "android");
            jSONObject.put("osVersion", Build.VERSION.SDK_INT + "");
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("sdkName", "alibabauth_sdk");
            jSONObject.put("sdkVersion", KernelContext.sdkVersion);
            jSONObject.put("sdkType", KernelContext.isMini ? "mini" : "std");
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("appId", KernelContext.getApplicationContext().getPackageName() + "|" + SystemUtils.getApkPublicKeyDigest());
            jSONObject.put("appKey", KernelContext.getAppKey());
            jSONObject.put("appName", CommonUtils.getAppLabel());
            jSONObject.put("appVersion", CommonUtils.getAndroidAppVersion());
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("openId", CredentialManager.INSTANCE.getInternalSession().user.openId);
        } catch (Exception unused5) {
        }
        return jSONObject;
    }

    public void init() {
    }

    @Override // com.ali.auth.third.core.service.UserTrackerService
    public void send(String str, Map<String, String> map) {
        final JSONObject appInfo = getAppInfo();
        try {
            if (!TextUtils.isEmpty(str)) {
                appInfo.put("action", str);
            }
            if (map != null) {
                appInfo.put("actionExt", JSONUtils.toJsonObject(map));
            }
            new Thread(new Runnable() {
                /* class com.ali.auth.third.core.ut.UserTracer.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    RpcRequest rpcRequest = new RpcRequest();
                    rpcRequest.target = "mtop.taobao.havana.mlogin.userTracerLog";
                    rpcRequest.version = "1.0";
                    rpcRequest.addParam("userTracerInfo", appInfo);
                    rpcRequest.addParam("ts", System.currentTimeMillis() + "");
                    ((RpcService) KernelContext.getService(RpcService.class)).invoke(rpcRequest, String.class);
                }
            }).start();
        } catch (Exception unused) {
        }
    }
}
