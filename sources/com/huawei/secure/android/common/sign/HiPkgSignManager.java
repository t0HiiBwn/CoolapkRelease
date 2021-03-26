package com.huawei.secure.android.common.sign;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class HiPkgSignManager {
    private static final String TAG = "HiPkgSignManager";

    public static byte[] getInstalledAPPSignature(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            Log.e("HiPkgSignManager", "packageName is null or context is null");
            return new byte[0];
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (!(packageManager == null || (packageInfo = packageManager.getPackageInfo(str, 64)) == null)) {
                return packageInfo.signatures[0].toByteArray();
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("HiPkgSignManager", "PackageManager.NameNotFoundException : " + e.getMessage());
        }
        return new byte[0];
    }

    public static byte[] getUnInstalledAPPSignature(Context context, String str) {
        PackageInfo packageArchiveInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            Log.e("HiPkgSignManager", "archiveFilePath is null or context is null");
            return new byte[0];
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (!(packageManager == null || (packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 64)) == null)) {
                return packageArchiveInfo.signatures[0].toByteArray();
            }
        } catch (Exception e) {
            Log.e("HiPkgSignManager", "getUnInstalledAPPSignature exception : " + e.getMessage());
        }
        return new byte[0];
    }

    public static String getInstalledAppHash(Context context, String str) {
        byte[] installedAPPSignature = getInstalledAPPSignature(context, str);
        return (installedAPPSignature == null || installedAPPSignature.length <= 0) ? "" : a(installedAPPSignature);
    }

    public static String getUnInstalledAppHash(Context context, String str) {
        byte[] unInstalledAPPSignature = getUnInstalledAPPSignature(context, str);
        return (unInstalledAPPSignature == null || unInstalledAPPSignature.length <= 0) ? "" : a(unInstalledAPPSignature);
    }

    private static String a(byte[] bArr) {
        try {
            return b(MessageDigest.getInstance("SHA-256").digest(bArr));
        } catch (NoSuchAlgorithmException e) {
            Log.e("HiPkgSignManager", "NoSuchAlgorithmException" + e.getMessage());
            return "";
        }
    }

    private static String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            if ((bArr[i] & 255) < 16) {
                stringBuffer.append("0" + Integer.toHexString(bArr[i] & 255));
            } else {
                stringBuffer.append(Integer.toHexString(bArr[i] & 255));
            }
        }
        return stringBuffer.toString().toUpperCase(Locale.ENGLISH);
    }

    public static boolean doCheckInstalled(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        return str.equals(getInstalledAppHash(context, str2));
    }

    public static boolean doCheckArchiveApk(Context context, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && context != null) {
            String packageName = context.getPackageName();
            String unInstalledAppHash = getUnInstalledAppHash(context, str2);
            if (!TextUtils.isEmpty(packageName) && !TextUtils.isEmpty(unInstalledAppHash) && str.equals(unInstalledAppHash.toUpperCase(Locale.ENGLISH))) {
                return true;
            }
        }
        return false;
    }
}
