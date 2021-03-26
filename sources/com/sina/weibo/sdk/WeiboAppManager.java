package com.sina.weibo.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.WbAppInfo;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.json.JSONObject;

public class WeiboAppManager {
    private static final String SDK_INT_FILE_NAME = "weibo_for_sdk.json";
    private static final String TAG = "com.sina.weibo.sdk.WeiboAppManager";
    private static final String WEIBO_4G_PACKAGENAME = "com.sina.weibog3";
    public static final String WEIBO_IDENTITY_ACTION = "com.sina.weibo.action.sdkidentity";
    private static final String WEIBO_PACKAGENAME = "com.sina.weibo";
    private static WeiboAppManager sInstance;
    private Context mContext;
    private WbAppInfo wbAppInfo;

    private WeiboAppManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static synchronized WeiboAppManager getInstance(Context context) {
        WeiboAppManager weiboAppManager;
        synchronized (WeiboAppManager.class) {
            if (sInstance == null) {
                sInstance = new WeiboAppManager(context);
            }
            weiboAppManager = sInstance;
        }
        return weiboAppManager;
    }

    public synchronized WbAppInfo getWbAppInfo() {
        return queryWbInfoInternal(this.mContext);
    }

    public static WbAppInfo queryWbInfoInternal(Context context) {
        return queryWbInfoByAsset(context);
    }

    @Deprecated
    public boolean hasWbInstall() {
        Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
        intent.addCategory("android.intent.category.DEFAULT");
        List<ResolveInfo> queryIntentServices = this.mContext.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            return false;
        }
        return true;
    }

    private static WbAppInfo queryWbInfoByAsset(Context context) {
        Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
        intent.addCategory("android.intent.category.DEFAULT");
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        WbAppInfo wbAppInfo2 = null;
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            for (ResolveInfo resolveInfo : queryIntentServices) {
                if (!(resolveInfo.serviceInfo == null || resolveInfo.serviceInfo.applicationInfo == null || TextUtils.isEmpty(resolveInfo.serviceInfo.packageName))) {
                    String str = resolveInfo.serviceInfo.packageName;
                    WbAppInfo parseWbInfoByAsset = parseWbInfoByAsset(context, str);
                    if (parseWbInfoByAsset != null) {
                        wbAppInfo2 = parseWbInfoByAsset;
                    }
                    if ("com.sina.weibo".equals(str) || "com.sina.weibog3".equals(str)) {
                        break;
                    }
                }
            }
        }
        return wbAppInfo2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0092 A[SYNTHETIC, Splitter:B:39:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009f A[SYNTHETIC, Splitter:B:47:0x009f] */
    private static WbAppInfo parseWbInfoByAsset(Context context, String str) {
        Throwable th;
        Exception e;
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArr = new byte[4096];
            inputStream = context.createPackageContext(str, 2).getAssets().open("weibo_for_sdk.json");
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = inputStream.read(bArr, 0, 4096);
                    if (read == -1) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read));
                }
                if (!TextUtils.isEmpty(sb.toString())) {
                    ApiUtils.validateWeiboSign(context, str);
                }
                JSONObject jSONObject = new JSONObject(sb.toString());
                int optInt = jSONObject.optInt("support_api", -1);
                String optString = jSONObject.optString("authActivityName", null);
                if (optInt != -1) {
                    if (!TextUtils.isEmpty(optString)) {
                        WbAppInfo wbAppInfo2 = new WbAppInfo();
                        wbAppInfo2.setPackageName(str);
                        wbAppInfo2.setSupportVersion(optInt);
                        wbAppInfo2.setAuthActivityName(optString);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        return wbAppInfo2;
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                return null;
            } catch (Exception e4) {
                e = e4;
                try {
                    LogUtil.e(TAG, e.getMessage());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            inputStream = null;
            LogUtil.e(TAG, e.getMessage());
            if (inputStream != null) {
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
            throw th;
        }
    }
}
