package com.huawei.secure.android.common.webview;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.huawei.secure.android.common.util.LogsUtil;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class UriUtil {
    private static final String TAG = "UriUtil";

    public static boolean isUrlHostInWhitelist(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            LogsUtil.e("UriUtil", "whitelist is null");
            return false;
        }
        for (String str2 : strArr) {
            if (isUrlHostMatchWhitelist(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUrlHostSameWhitelist(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return TextUtils.equals(getHostByURI(str), e(str2));
        }
        Log.e("UriUtil", "isUrlHostSameWhitelist: url or host is null");
        return false;
    }

    public static boolean isUrlHostSameWhitelist(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            LogsUtil.e("UriUtil", "whitelist is null");
            return false;
        }
        for (String str2 : strArr) {
            if (isUrlHostSameWhitelist(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUrlHostMatchWhitelist(String str, String str2) {
        String hostByURI = getHostByURI(str);
        if (TextUtils.isEmpty(hostByURI) || TextUtils.isEmpty(str2)) {
            LogsUtil.e("UriUtil", "url or whitelist is null");
            return false;
        }
        String e = e(str2);
        if (TextUtils.isEmpty(e)) {
            Log.e("UriUtil", "whitelist host is null");
            return false;
        } else if (e.equals(hostByURI)) {
            return true;
        } else {
            if (hostByURI.endsWith(e)) {
                try {
                    String substring = hostByURI.substring(0, hostByURI.length() - e.length());
                    if (!substring.endsWith(".")) {
                        return false;
                    }
                    return substring.matches("^[A-Za-z0-9.-]+$");
                } catch (IndexOutOfBoundsException e2) {
                    LogsUtil.e("UriUtil", "IndexOutOfBoundsException" + e2.getMessage());
                } catch (Exception e3) {
                    LogsUtil.e("UriUtil", "Exception : " + e3.getMessage());
                    return false;
                }
            }
            return false;
        }
    }

    public static String getHostByURI(String str) {
        if (TextUtils.isEmpty(str)) {
            LogsUtil.i("UriUtil", "url is null");
            return str;
        }
        try {
            if (!URLUtil.isNetworkUrl(str)) {
                LogsUtil.e("UriUtil", "url don't starts with http or https");
                return null;
            }
            if (!str.contains("{") && !str.contains("}") && !str.contains("[")) {
                if (!str.contains("]")) {
                    return new URI(str).getHost();
                }
            }
            return new URL(str.replaceAll("[\\\\#]", "/")).getHost();
        } catch (URISyntaxException e) {
            LogsUtil.e("UriUtil", "getHostByURI error : " + e.getMessage());
            return null;
        } catch (MalformedURLException e2) {
            LogsUtil.e("UriUtil", "getHostByURI error  MalformedURLException : " + e2.getMessage());
            return null;
        }
    }

    private static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            LogsUtil.i("UriUtil", "whiteListUrl is null");
            return null;
        } else if (!URLUtil.isNetworkUrl(str)) {
            return str;
        } else {
            return getHostByURI(str);
        }
    }

    public static boolean isUrlHostAndPathInWhitelist(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            LogsUtil.e("UriUtil", "whitelist is null");
            return false;
        }
        for (String str2 : strArr) {
            if (isUrlHostAndPathMatchWhitelist(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUrlHostAndPathMatchWhitelist(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str.contains("..") || str.contains("@")) {
                Log.e("UriUtil", "url contains unsafe char");
            } else {
                if (!str2.equals(str)) {
                    if (!str.startsWith(str2 + "?")) {
                        if (!str.startsWith(str2 + "#")) {
                            if (!str2.endsWith("/")) {
                                return false;
                            }
                            if (Uri.parse(str).getPathSegments().size() - Uri.parse(str2).getPathSegments().size() != 1) {
                                return false;
                            }
                            return str.startsWith(str2);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
}
