package com.alibaba.baichuan.trade.biz.core.a;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.baichuan.trade.biz.core.jsbridge.AlibcJsCallbackContext;
import com.alibaba.baichuan.trade.biz.core.jsbridge.AlibcJsResult;
import com.alibaba.baichuan.trade.biz.core.jsbridge.plugin.AlibcApiPlugin;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.baichuan.trade.common.utils.JSONUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends AlibcApiPlugin {
    public static String a = "AliBCBase";

    private void a(AlibcJsCallbackContext alibcJsCallbackContext) {
        AlibcJsResult alibcJsResult = new AlibcJsResult();
        alibcJsResult.setSuccess();
        alibcJsResult.addData("model", Build.MODEL);
        alibcJsResult.addData("brand", Build.BRAND);
        alibcJsCallbackContext.success(alibcJsResult);
    }

    private void a(AlibcJsCallbackContext alibcJsCallbackContext, String str) {
        String[] strArr;
        try {
            strArr = JSONUtils.toStringArray(new JSONObject(str).getJSONArray("apps"));
        } catch (JSONException unused) {
            AlibcLogger.e("Base", "isInstall parse params error, params: " + str);
            strArr = null;
        }
        AlibcJsResult alibcJsResult = new AlibcJsResult();
        if (strArr == null) {
            alibcJsCallbackContext.error(alibcJsResult);
            return;
        }
        for (String str2 : strArr) {
            alibcJsResult.addData(str2, Boolean.valueOf(a(AlibcTradeCommon.context, str2)));
        }
        alibcJsResult.setSuccess();
        alibcJsCallbackContext.success(alibcJsResult);
    }

    private static boolean a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                return (packageManager == null || packageManager.getPackageInfo(str, 0) == null) ? false : true;
            } catch (PackageManager.NameNotFoundException e) {
                AlibcLogger.e("AlibcBasePlugin", "isAppInstalled", e);
            }
        }
        return false;
    }

    private void b(AlibcJsCallbackContext alibcJsCallbackContext) {
        Activity activity = (Activity) this.mWebView.getContext();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.alibaba.baichuan.trade.biz.core.jsbridge.plugin.AlibcApiPlugin
    public boolean execute(String str, String str2, AlibcJsCallbackContext alibcJsCallbackContext) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || alibcJsCallbackContext == null) {
            AlibcJsResult alibcJsResult = new AlibcJsResult("6");
            alibcJsResult.setResultCode("2");
            if (alibcJsCallbackContext == null) {
                return false;
            }
            alibcJsCallbackContext.error(alibcJsResult);
            return false;
        } else if ("getDeviceInfo".equals(str)) {
            a(alibcJsCallbackContext);
            return true;
        } else if ("isInstalled".equals(str)) {
            a(alibcJsCallbackContext, str2);
            return true;
        } else if (!"closeWebView".equals(str)) {
            return true;
        } else {
            b(alibcJsCallbackContext);
            return true;
        }
    }
}
