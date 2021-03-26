package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.sso.WeiboSsoManager;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Locale;
import java.util.UUID;

public class Utility {
    private static final String DEFAULT_CHARSET = "UTF-8";

    public static Bundle parseUrl(String str) {
        try {
            URL url = new URL(str);
            Bundle decodeUrl = decodeUrl(url.getQuery());
            decodeUrl.putAll(decodeUrl(url.getRef()));
            return decodeUrl;
        } catch (MalformedURLException unused) {
            return new Bundle();
        }
    }

    public static Bundle decodeUrl(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                try {
                    if (split.length == 2) {
                        bundle.putString(URLDecoder.decode(split[0], "UTF-8"), URLDecoder.decode(split[1], "UTF-8"));
                    } else if (split.length == 1) {
                        bundle.putString(URLDecoder.decode(split[0], "UTF-8"), "");
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return bundle;
    }

    public static boolean isChineseLocale(Context context) {
        try {
            Locale locale = context.getResources().getConfiguration().locale;
            if (Locale.CHINA.equals(locale) || Locale.CHINESE.equals(locale) || Locale.SIMPLIFIED_CHINESE.equals(locale) || Locale.TAIWAN.equals(locale)) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }

    public static String generateGUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String getSign(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            for (int i = 0; i < packageInfo.signatures.length; i++) {
                byte[] byteArray = packageInfo.signatures[i].toByteArray();
                if (byteArray != null) {
                    return MD5.hexdigest(byteArray);
                }
            }
        } catch (PackageManager.NameNotFoundException | Exception unused) {
        }
        return null;
    }

    public static String safeString(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static String getAid(Context context, String str) {
        return context == null ? "" : WeiboSsoManager.getInstance().getAid(context, str);
    }

    public static String generateUAAid(Context context) {
        StringBuilder sb = new StringBuilder();
        String packageName = context.getPackageName();
        String str = (TextUtils.isEmpty(packageName) || !packageName.contains("com.sina.weibo")) ? "weibosdk" : "weibo";
        sb.append(Build.MANUFACTURER);
        sb.append("-");
        sb.append(Build.MODEL);
        sb.append("__");
        sb.append(str);
        sb.append("__");
        try {
            sb.append("0041005000".replaceAll("\\s+", "_"));
        } catch (Exception unused) {
            sb.append("unknown");
        }
        sb.append("__");
        sb.append("android");
        sb.append("__android");
        sb.append(Build.VERSION.RELEASE);
        return sb.toString();
    }

    public static String getWeiBoVersion(Context context) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
        if (packageInfo == null) {
            return null;
        }
        return packageInfo.versionName;
    }
}
