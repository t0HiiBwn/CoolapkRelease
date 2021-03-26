package com.ali.auth.third.login;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import com.ali.auth.third.core.config.AuthOption;
import com.ali.auth.third.core.config.ConfigManager;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.cookies.LoginCookieUtils;
import com.ali.auth.third.core.history.AccountHistoryManager;
import com.ali.auth.third.core.model.ApplyTokenRequest;
import com.ali.auth.third.core.model.HistoryAccount;
import com.ali.auth.third.core.model.LoginReturnData;
import com.ali.auth.third.core.model.LoginTokenResponseData;
import com.ali.auth.third.core.model.RpcRequest;
import com.ali.auth.third.core.model.RpcRequestCallbackWithCode;
import com.ali.auth.third.core.model.RpcResponse;
import com.ali.auth.third.core.rpc.protocol.RpcException;
import com.ali.auth.third.core.service.RpcService;
import com.ali.auth.third.core.service.StorageService;
import com.ali.auth.third.core.service.UserTrackerService;
import com.ali.auth.third.core.service.impl.CredentialManager;
import com.ali.auth.third.core.service.impl.ExecutorServiceImpl;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.CommonUtils;
import com.ali.auth.third.core.util.JSONUtils;
import com.ali.auth.third.core.util.RSAKey;
import com.ali.auth.third.core.util.ResourceUtils;
import com.ali.auth.third.core.util.Rsa;
import com.ali.auth.third.core.util.SystemUtils;
import com.ali.auth.third.login.a.a;
import com.ali.auth.third.ui.LoginWebViewActivity;
import com.ali.auth.third.ui.QrLoginActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginComponent {
    public static final LoginComponent INSTANCE = new LoginComponent();

    private LoginComponent() {
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = keys.next().toString();
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(jSONObject.getString(str2))) {
                    sb.append("&");
                    sb.append(str2);
                    sb.append("=");
                    sb.append(jSONObject.getString(str2));
                }
            }
        } catch (JSONException unused) {
        }
        return sb.toString();
    }

    private String a(TreeMap<String, String> treeMap) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                sb.append(key);
                sb.append(value);
            }
        }
        return sb.toString();
    }

    public static void addKey(Map<String, String> map, String str, String str2) {
        map.put(str, str2);
    }

    public static void applyToken(int i, Map<String, String> map, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = "com.taobao.mtop.mLoginTokenService.applySsoToken";
        rpcRequest.version = "1.1";
        rpcRequest.NEED_ECODE = true;
        rpcRequest.NEED_SESSION = true;
        ApplyTokenRequest applyTokenRequest = new ApplyTokenRequest();
        applyTokenRequest.appName = KernelContext.getAppKey();
        applyTokenRequest.site = i;
        applyTokenRequest.t = System.currentTimeMillis();
        applyTokenRequest.sdkVersion = KernelContext.sdkVersion;
        if (map == null) {
            new HashMap();
        }
        rpcRequest.addParam("request", "{}");
        ((RpcService) KernelContext.getService(RpcService.class)).remoteBusiness(rpcRequest, LoginTokenResponseData.class, rpcRequestCallbackWithCode);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0125, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0126, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0157, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0158, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0157 A[ExcHandler: JSONException (r0v5 'e' org.json.JSONException A[CUSTOM_DECLARE]), Splitter:B:1:0x0013] */
    public static RpcResponse<LoginReturnData> loginByRefreshToken() {
        String str;
        String deviceId;
        HistoryAccount findHistoryAccount;
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = "com.taobao.mtop.mLoginUnitService.autoLogin";
        rpcRequest.version = "1.0";
        try {
            String str2 = CredentialManager.INSTANCE.getInternalSession().user.userId;
            rpcRequest.addParam("userId", Long.valueOf(Long.parseLong(str2)));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appName", KernelContext.getAppKey());
            jSONObject.put("token", CredentialManager.INSTANCE.getInternalSession().autoLoginToken);
            jSONObject.put("sdkVersion", KernelContext.sdkVersion);
            long currentTimeMillis = System.currentTimeMillis();
            jSONObject.put("t", "" + currentTimeMillis);
            jSONObject.put("clientIp", CommonUtils.getLocalIPAddress());
            if (KernelContext.isMini) {
                str = "app_id";
                deviceId = KernelContext.getApplicationContext().getPackageName() + "|" + SystemUtils.getApkPublicKeyDigest();
            } else {
                str = "utdid";
                deviceId = ((RpcService) KernelContext.getService(RpcService.class)).getDeviceId();
            }
            jSONObject.put(str, deviceId);
            if (!TextUtils.isEmpty(str2) && (findHistoryAccount = AccountHistoryManager.getInstance().findHistoryAccount(str2)) != null) {
                String str3 = findHistoryAccount.tokenKey;
                if (!TextUtils.isEmpty(str3)) {
                    TreeMap<String, String> treeMap = new TreeMap<>();
                    addKey(treeMap, "appKey", KernelContext.getAppKey());
                    addKey(treeMap, "havanaId", findHistoryAccount.userId);
                    addKey(treeMap, "timestamp", String.valueOf(currentTimeMillis));
                    addKey(treeMap, "appVersion", CommonUtils.getAndroidAppVersion());
                    addKey(treeMap, "sdkVersion", KernelContext.sdkVersion);
                    String signMap = ((StorageService) KernelContext.getService(StorageService.class)).signMap(str3, treeMap);
                    if (!TextUtils.isEmpty(signMap)) {
                        jSONObject.put("deviceTokenSign", signMap);
                        jSONObject.put("deviceTokenKey", str3);
                        jSONObject.put("hid", findHistoryAccount.userId);
                    }
                }
            }
            JSONObject keyValues = LoginCookieUtils.getKeyValues("alimm_");
            keyValues.put("miid", LoginCookieUtils.getValue("miid"));
            keyValues.put("sdkPlatform", "baichuan_mp");
            jSONObject.put("ext", keyValues);
            rpcRequest.addParam("tokenInfo", jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("umidToken", ((StorageService) KernelContext.getService(StorageService.class)).getUmid());
            rpcRequest.addParam("riskControlInfo", jSONObject2);
            rpcRequest.addParam("ext", new JSONObject());
        } catch (JSONException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return ((RpcService) KernelContext.getService(RpcService.class)).invoke(rpcRequest, LoginReturnData.class);
    }

    public static RpcResponse<String> logout() {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = "mtop.taobao.havana.mlogin.logout";
        rpcRequest.version = "1.0";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appKey", KernelContext.getAppKey());
            jSONObject.put("sid", CredentialManager.INSTANCE.getInternalSession().sid);
            jSONObject.put("ip", CommonUtils.getLocalIPAddress());
            rpcRequest.addParam("userId", Long.valueOf(Long.parseLong(CredentialManager.INSTANCE.getInternalSession().user.userId)));
            rpcRequest.addParam("request", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ((RpcService) KernelContext.getService(RpcService.class)).invoke(rpcRequest, String.class);
    }

    public String generateTopAppLinkToken(String str) {
        ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send("GENERATE_TOPAPPLINK_TOKEN", null);
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("appKey", KernelContext.getAppKey());
        treeMap.put("apkSign", str);
        treeMap.put("apiName", "taobao.oauth.code.create");
        String a = a(treeMap);
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = "com.alibaba.havana.login.applink.generateTopAppLinkToken";
        rpcRequest.version = "1.0";
        String appKey = KernelContext.getAppKey();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appName", appKey);
            jSONObject.put("t", "" + System.currentTimeMillis());
            jSONObject.put("clientIp", CommonUtils.getLocalIPAddress());
            if (KernelContext.isMini) {
                jSONObject.put("app_id", KernelContext.getApplicationContext().getPackageName() + "|" + SystemUtils.getApkPublicKeyDigest());
            }
            jSONObject.put("sdkVersion", KernelContext.sdkVersion);
            rpcRequest.addParam("baseInfo", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rpcRequest.addParam("content", a);
        try {
            RpcResponse invoke = ((RpcService) KernelContext.getService(RpcService.class)).invoke(rpcRequest, String.class);
            if (invoke != null) {
                return invoke.returnValue;
            }
            return null;
        } catch (RpcException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void goQrCodeLogin(Activity activity, Map<String, Object> map) {
        SDKLogger.d("login", "goQrCodeLogin start");
        Class cls = QrLoginActivity.class;
        String str = "";
        if (map != null) {
            if (!TextUtils.isEmpty(map.get("userDefActivity") == null ? str : (String) map.get("userDefActivity"))) {
                try {
                    cls = Class.forName((String) map.get("userDefActivity"));
                } catch (ClassNotFoundException unused) {
                }
            }
        }
        Intent intent = new Intent(activity, cls);
        StringBuilder sb = new StringBuilder(String.format(ConfigManager.qrCodeLoginUrl, KernelContext.getAppKey()));
        if (map != null) {
            if (!TextUtils.isEmpty(map.get("domain") == null ? str : (String) map.get("domain"))) {
                sb.append("_");
                sb.append(map.get("domain"));
            }
        }
        if (map != null) {
            if (!TextUtils.isEmpty(map.get("config") == null ? str : (String) map.get("config"))) {
                String a = a((String) map.get("config"));
                if (!TextUtils.isEmpty(a)) {
                    str = a;
                }
                sb.append(str);
            }
        }
        intent.putExtra("qrCodeLoginUrl", sb.toString());
        intent.putExtra("passwordLoginUrl", ConfigManager.LOGIN_HOST);
        activity.startActivityForResult(intent, RequestCode.OPEN_QR_LOGIN);
    }

    public RpcResponse<LoginReturnData> loginByCode(String str) {
        String str2;
        String deviceId;
        try {
            ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send("TOP_TOKEN_LOGIN", null);
            RpcRequest rpcRequest = new RpcRequest();
            rpcRequest.target = "com.taobao.mtop.mloginService.topTokenLogin";
            rpcRequest.version = "1.0";
            try {
                JSONObject jSONObject = new JSONObject();
                if (KernelContext.isMini) {
                    str2 = "app_id";
                    deviceId = KernelContext.getApplicationContext().getPackageName() + "|" + SystemUtils.getApkPublicKeyDigest();
                } else {
                    str2 = "utdid";
                    deviceId = ((RpcService) KernelContext.getService(RpcService.class)).getDeviceId();
                }
                jSONObject.put(str2, deviceId);
                jSONObject.put("appName", KernelContext.getAppKey());
                jSONObject.put("token", str);
                jSONObject.put("t", "" + System.currentTimeMillis());
                jSONObject.put("sdkVersion", KernelContext.sdkVersion);
                jSONObject.put("clientIp", CommonUtils.getLocalIPAddress());
                try {
                    JSONObject keyValues = LoginCookieUtils.getKeyValues("alimm_");
                    keyValues.put("miid", LoginCookieUtils.getValue("miid"));
                    keyValues.put("sdkPlatform", "baichuan_mp");
                    jSONObject.put("ext", keyValues);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                rpcRequest.addParam("tokenInfo", jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("umidToken", ((StorageService) KernelContext.getService(StorageService.class)).getUmid());
                rpcRequest.addParam("riskControlInfo", jSONObject2);
                rpcRequest.addParam("ext", new JSONObject());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return ((RpcService) KernelContext.getService(RpcService.class)).invoke(rpcRequest, LoginReturnData.class);
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public RpcResponse<LoginReturnData> loginByIVToken(String str, String str2, String str3) {
        String str4;
        String deviceId;
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = "com.taobao.mtop.mloginService.mloginTokenLogin";
        rpcRequest.version = "1.0";
        try {
            JSONObject jSONObject = new JSONObject();
            if (KernelContext.isMini) {
                str4 = "app_id";
                deviceId = KernelContext.getApplicationContext().getPackageName() + "|" + SystemUtils.getApkPublicKeyDigest();
            } else {
                str4 = "utdid";
                deviceId = ((RpcService) KernelContext.getService(RpcService.class)).getDeviceId();
            }
            jSONObject.put(str4, deviceId);
            jSONObject.put("appName", KernelContext.getAppKey());
            jSONObject.put("token", str);
            jSONObject.put("t", "" + System.currentTimeMillis());
            jSONObject.put("scene", str2);
            jSONObject.put("sdkVersion", KernelContext.sdkVersion);
            jSONObject.put("clientIp", CommonUtils.getLocalIPAddress());
            try {
                JSONObject keyValues = LoginCookieUtils.getKeyValues("alimm_");
                keyValues.put("miid", LoginCookieUtils.getValue("miid"));
                keyValues.put("aliusersdk_h5querystring", str3);
                keyValues.put("sdkPlatform", "baichuan_mp");
                jSONObject.put("ext", keyValues);
            } catch (Exception e) {
                e.printStackTrace();
            }
            rpcRequest.addParam("tokenInfo", jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("umidToken", ((StorageService) KernelContext.getService(StorageService.class)).getUmid());
            rpcRequest.addParam("riskControlInfo", jSONObject2);
            rpcRequest.addParam("ext", JSONUtils.toJsonObject(new HashMap()));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return a.d.invoke(rpcRequest, LoginReturnData.class);
    }

    public RpcResponse<LoginReturnData> loginByQRCode(String str, long j, boolean z) {
        String str2;
        String deviceId;
        try {
            RpcRequest rpcRequest = new RpcRequest();
            rpcRequest.target = "mtop.taobao.havana.mlogin.qrcodelogin";
            rpcRequest.version = "1.0";
            try {
                JSONObject jSONObject = new JSONObject();
                if (KernelContext.isMini) {
                    str2 = "app_id";
                    deviceId = KernelContext.getApplicationContext().getPackageName() + "|" + SystemUtils.getApkPublicKeyDigest();
                } else {
                    str2 = "utdid";
                    deviceId = ((RpcService) KernelContext.getService(RpcService.class)).getDeviceId();
                }
                jSONObject.put(str2, deviceId);
                jSONObject.put("appName", KernelContext.getAppKey());
                jSONObject.put("token", str);
                jSONObject.put("t", "" + j);
                jSONObject.put("sdkVersion", KernelContext.sdkVersion);
                jSONObject.put("clientIp", CommonUtils.getLocalIPAddress());
                rpcRequest.addParam("tokenInfo", jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("umidToken", ((StorageService) KernelContext.getService(StorageService.class)).getUmid());
                rpcRequest.addParam("riskControlInfo", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("supportNativeIvOnly", z);
                jSONObject3.put("sdkPlatform", "baichuan_mp");
                rpcRequest.addParam("ext", jSONObject3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return ((RpcService) KernelContext.getService(RpcService.class)).invoke(rpcRequest, LoginReturnData.class);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public RpcResponse<LoginReturnData> loginBySsoToken(String str) {
        String str2;
        String deviceId;
        try {
            ((UserTrackerService) KernelContext.getService(UserTrackerService.class)).send("SSO_TOKEN_LOGIN", null);
            RpcRequest rpcRequest = new RpcRequest();
            rpcRequest.target = "com.taobao.mtop.mloginService.ssoLogin";
            rpcRequest.version = "1.0";
            try {
                JSONObject jSONObject = new JSONObject();
                if (KernelContext.isMini) {
                    str2 = "app_id";
                    deviceId = KernelContext.getApplicationContext().getPackageName() + "|" + SystemUtils.getApkPublicKeyDigest();
                } else {
                    str2 = "utdid";
                    deviceId = ((RpcService) KernelContext.getService(RpcService.class)).getDeviceId();
                }
                jSONObject.put(str2, deviceId);
                jSONObject.put("appName", KernelContext.getAppKey());
                jSONObject.put("token", str);
                jSONObject.put("sdkVersion", KernelContext.sdkVersion);
                jSONObject.put("tokenType", "ssoToken");
                jSONObject.put("scene", "");
                jSONObject.put("ttid", "");
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("deviceName", Build.MODEL);
                    jSONObject2.put("sdkPlatform", "baichuan_mp");
                    jSONObject.put("ext", jSONObject2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                rpcRequest.addParam("tokenInfo", jSONObject);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("umidToken", ((StorageService) KernelContext.getService(StorageService.class)).getUmid());
                rpcRequest.addParam("riskControlInfo", jSONObject3);
                rpcRequest.addParam("ext", new JSONObject());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return ((RpcService) KernelContext.getService(RpcService.class)).invoke(rpcRequest, LoginReturnData.class);
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x017f  */
    public RpcResponse<LoginReturnData> loginByUserName(String str) {
        String str2;
        String deviceId;
        String str3;
        HistoryAccount matchHistoryAccount;
        RpcRequest rpcRequest = new RpcRequest();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = JSONUtils.optString(jSONObject, "loginid");
            if (TextUtils.isEmpty(optString)) {
                optString = JSONUtils.optString(jSONObject, "loginId");
            }
            rpcRequest.target = "com.taobao.mtop.mloginService.login";
            rpcRequest.version = "1.0";
            JSONObject jSONObject2 = new JSONObject();
            if (KernelContext.isMini) {
                str2 = "app_id";
                deviceId = KernelContext.getApplicationContext().getPackageName() + "|" + SystemUtils.getApkPublicKeyDigest();
            } else {
                str2 = "utdid";
                deviceId = ((RpcService) KernelContext.getService(RpcService.class)).getDeviceId();
            }
            jSONObject2.put(str2, deviceId);
            jSONObject2.put("appName", KernelContext.getAppKey());
            jSONObject2.put("loginId", optString);
            jSONObject2.put("clientIp", CommonUtils.getLocalIPAddress());
            long currentTimeMillis = System.currentTimeMillis();
            if (!TextUtils.isEmpty(optString) && (matchHistoryAccount = AccountHistoryManager.getInstance().matchHistoryAccount(optString)) != null) {
                String str4 = matchHistoryAccount.tokenKey;
                if (!TextUtils.isEmpty(str4)) {
                    TreeMap<String, String> treeMap = new TreeMap<>();
                    str3 = "ua";
                    addKey(treeMap, "appKey", KernelContext.getAppKey());
                    addKey(treeMap, "havanaId", matchHistoryAccount.userId);
                    addKey(treeMap, "timestamp", String.valueOf(currentTimeMillis));
                    addKey(treeMap, "appVersion", CommonUtils.getAndroidAppVersion());
                    addKey(treeMap, "sdkVersion", KernelContext.sdkVersion);
                    String signMap = ((StorageService) KernelContext.getService(StorageService.class)).signMap(str4, treeMap);
                    if (!TextUtils.isEmpty(signMap)) {
                        jSONObject2.put("deviceTokenSign", signMap);
                        jSONObject2.put("deviceTokenKey", str4);
                        jSONObject2.put("hid", matchHistoryAccount.userId);
                    }
                    jSONObject2.put("password", Rsa.encrypt(JSONUtils.optString(jSONObject, "password"), RSAKey.getRsaPubkey()));
                    jSONObject2.put("pwdEncrypted", true);
                    jSONObject2.put("appVersion", CommonUtils.getAndroidAppVersion());
                    jSONObject2.put("sdkVersion", KernelContext.sdkVersion);
                    jSONObject2.put("t", currentTimeMillis + "");
                    jSONObject2.put("ccId", JSONUtils.optString(jSONObject, "checkCodeId"));
                    jSONObject2.put("checkCode", JSONUtils.optString(jSONObject, "checkCode"));
                    JSONObject keyValues = LoginCookieUtils.getKeyValues("alimm_");
                    keyValues.put("miid", LoginCookieUtils.getValue("miid"));
                    keyValues.put("sdkPlatform", "baichuan_mp");
                    jSONObject2.put("ext", keyValues);
                    rpcRequest.addParam("loginInfo", jSONObject2);
                    JSONObject jSONObject3 = new JSONObject();
                    if (!KernelContext.isMini) {
                        String optString2 = JSONUtils.optString(jSONObject, "umidtoken");
                        jSONObject3.put("umidToken", optString2);
                        ((StorageService) KernelContext.getService(StorageService.class)).setUmid(optString2);
                    } else {
                        jSONObject3.put("umidToken", ((StorageService) KernelContext.getService(StorageService.class)).getUmid());
                    }
                    jSONObject3.put(str3, JSONUtils.optString(jSONObject, str3));
                    rpcRequest.addParam("riskControlInfo", jSONObject3);
                    rpcRequest.addParam("ext", new JSONObject());
                    return ((RpcService) KernelContext.getService(RpcService.class)).invoke(rpcRequest, LoginReturnData.class);
                }
            }
            str3 = "ua";
            jSONObject2.put("password", Rsa.encrypt(JSONUtils.optString(jSONObject, "password"), RSAKey.getRsaPubkey()));
            jSONObject2.put("pwdEncrypted", true);
            jSONObject2.put("appVersion", CommonUtils.getAndroidAppVersion());
            jSONObject2.put("sdkVersion", KernelContext.sdkVersion);
            jSONObject2.put("t", currentTimeMillis + "");
            jSONObject2.put("ccId", JSONUtils.optString(jSONObject, "checkCodeId"));
            jSONObject2.put("checkCode", JSONUtils.optString(jSONObject, "checkCode"));
            try {
                JSONObject keyValues = LoginCookieUtils.getKeyValues("alimm_");
                keyValues.put("miid", LoginCookieUtils.getValue("miid"));
                keyValues.put("sdkPlatform", "baichuan_mp");
                jSONObject2.put("ext", keyValues);
            } catch (Exception e) {
                e.printStackTrace();
            }
            rpcRequest.addParam("loginInfo", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            if (!KernelContext.isMini) {
            }
            jSONObject3.put(str3, JSONUtils.optString(jSONObject, str3));
            rpcRequest.addParam("riskControlInfo", jSONObject3);
            rpcRequest.addParam("ext", new JSONObject());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return ((RpcService) KernelContext.getService(RpcService.class)).invoke(rpcRequest, LoginReturnData.class);
    }

    public void showH5Login(Activity activity) {
        SDKLogger.d("login", "open H5 login");
        Intent intent = new Intent(activity, LoginWebViewActivity.class);
        intent.putExtra("url", ConfigManager.LOGIN_HOST);
        intent.putExtra("title", ResourceUtils.getString(activity.getApplicationContext(), "com_taobao_tae_sdk_authorize_title"));
        activity.startActivityForResult(intent, RequestCode.OPEN_H5_LOGIN);
    }

    public void showLogin(final Activity activity) {
        SDKLogger.d("login", "showLogin");
        if (KernelContext.sOneTimeAuthOption == AuthOption.H5ONLY) {
            showH5Login(activity);
        } else if (KernelContext.authOption == AuthOption.H5ONLY) {
            showH5Login(activity);
        } else {
            final String apkSignNumber = SystemUtils.getApkSignNumber();
            new AsyncTask<Object, Void, String>() {
                /* class com.ali.auth.third.login.LoginComponent.AnonymousClass1 */

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public String doInBackground(Object... objArr) {
                    SDKLogger.d("login", "showLogin doInBackground");
                    if (TextUtils.isEmpty(apkSignNumber)) {
                        return "";
                    }
                    try {
                        return LoginComponent.this.generateTopAppLinkToken(apkSignNumber);
                    } catch (Exception unused) {
                        return "";
                    }
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void onPostExecute(String str) {
                    SDKLogger.d("login", "showLogin onPostExecute signResult = " + str);
                    if (!TextUtils.isEmpty(str)) {
                        Intent intent = new Intent();
                        intent.setAction("com.taobao.open.intent.action.GETWAY");
                        intent.setData(Uri.parse("tbopen://m.taobao.com/getway/oauth?&appkey=" + KernelContext.getAppKey() + "&pluginName=taobao.oauth.code.create&apkSign=" + apkSignNumber + "&sign=" + str));
                        if (activity.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
                            try {
                                activity.startActivityForResult(intent, RequestCode.OPEN_TAOBAO);
                                return;
                            } catch (Throwable th) {
                                SDKLogger.d("login", "startActivityForResult fail == " + th.getMessage());
                            }
                        }
                    }
                    LoginComponent.this.showH5Login(activity);
                }
            }.executeOnExecutor(ExecutorServiceImpl.mExecutor == null ? AsyncTask.THREAD_POOL_EXECUTOR : ExecutorServiceImpl.mExecutor, new Object[0]);
        }
    }
}
