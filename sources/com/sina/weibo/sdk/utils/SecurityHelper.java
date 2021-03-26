package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import com.sina.weibo.sdk.ApiUtils;
import com.sina.weibo.sdk.auth.WbAppInfo;

public class SecurityHelper {
    public static boolean validateAppSignatureForIntent(Context context, Intent intent) {
        ResolveInfo resolveActivity;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null || (resolveActivity = packageManager.resolveActivity(intent, 0)) == null) {
            return false;
        }
        try {
            return containSign(packageManager.getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures, "18da2bf10352443a00a5e046d9fca6bd");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean checkResponseAppLegal(Context context, WbAppInfo wbAppInfo, Intent intent) {
        if ((wbAppInfo != null && wbAppInfo.getSupportVersion() <= 10352) || wbAppInfo == null) {
            return true;
        }
        String stringExtra = intent != null ? intent.getStringExtra("_weibo_appPackage") : null;
        if (stringExtra == null || intent.getStringExtra("_weibo_transaction") == null || !ApiUtils.validateWeiboSign(context, stringExtra)) {
            return false;
        }
        return true;
    }

    public static boolean containSign(Signature[] signatureArr, String str) {
        if (!(signatureArr == null || str == null)) {
            for (Signature signature : signatureArr) {
                if (str.equals(MD5.hexdigest(signature.toByteArray()))) {
                    return true;
                }
            }
        }
        return false;
    }
}
