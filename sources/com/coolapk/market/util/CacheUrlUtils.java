package com.coolapk.market.util;

import android.net.Uri;
import android.text.TextUtils;
import com.coolapk.market.manager.DataManager;

public class CacheUrlUtils {
    public static final int COOLMARKET_MIME_TYPE_APK = 1;
    public static final int COOLMARKET_MIME_TYPE_EXTRA = 3;
    private static final int COOLMARKET_MIME_TYPE_HISTORY = 4;
    public static final int COOLMARKET_MIME_TYPE_PATCH = 2;
    public static final int COOLMARKET_MIME_TYPE_UNKNOWN = -1;
    public static final String SCHEME_HTTP = "http";

    public static String getApkDownloadUrl(String str, String str2, int i, boolean z) {
        return Uri.parse(DataManager.getInstance().getDataConfig().getApiEndpoint()).buildUpon().appendEncodedPath("apk/download").appendQueryParameter("pn", str).appendQueryParameter("aid", str2).appendQueryParameter("vc", String.valueOf(i)).appendQueryParameter("extra", z ? "1" : "").build().toString();
    }

    public static String getApkDownloadPatchUrl(String str, String str2, String str3) {
        return Uri.parse(DataManager.getInstance().getDataConfig().getApiEndpoint()).buildUpon().appendEncodedPath("apk/downloadPatch").appendQueryParameter("pn", str).appendQueryParameter("aid", str2).appendQueryParameter("patchKey", str3).build().toString();
    }

    public static String getApkVersionDownloadUrl(String str, String str2, String str3, String str4) {
        return Uri.parse(DataManager.getInstance().getDataConfig().getApiEndpoint()).buildUpon().appendEncodedPath("apk/downloadHistory").appendQueryParameter("pn", str).appendQueryParameter("aid", str2).appendQueryParameter("versionId", str3).appendQueryParameter("downloadFrom", str4).build().toString();
    }

    public static String getLastPathSegment(String str) {
        if (str == null) {
            return null;
        }
        return Uri.parse(str).getLastPathSegment();
    }

    public static boolean isCoolMarketHost(String str) {
        return TextUtils.equals(Uri.parse(str).getHost(), DataManager.getInstance().getDataConfig().getApiHost());
    }

    public static boolean isCoolMarketApkOrPatchMimeType(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        if (parse.getScheme() != null && parse.getScheme().startsWith("http") && TextUtils.equals(parse.getHost(), DataManager.getInstance().getDataConfig().getApiHost())) {
            String lastPathSegment = parse.getLastPathSegment();
            lastPathSegment.hashCode();
            if (lastPathSegment.equals("downloadPatch")) {
                return true;
            }
            if (lastPathSegment.equals("download")) {
                return !TextUtils.equals(parse.getQueryParameter("extra"), "1");
            }
        }
        return false;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static int getCoolMarketMimeType(String str) {
        char c;
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            if (parse.getScheme() != null && parse.getScheme().startsWith("http") && TextUtils.equals(parse.getHost(), DataManager.getInstance().getDataConfig().getApiHost())) {
                String lastPathSegment = parse.getLastPathSegment();
                lastPathSegment.hashCode();
                switch (lastPathSegment.hashCode()) {
                    case 17464480:
                        if (lastPathSegment.equals("downloadPatch")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1322027756:
                        if (lastPathSegment.equals("downloadHistory")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1427818632:
                        if (lastPathSegment.equals("download")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        return 2;
                    case 1:
                        return 4;
                    case 2:
                        if (TextUtils.equals(parse.getQueryParameter("extra"), "1")) {
                            return 3;
                        }
                        return 1;
                }
            }
        }
        return -1;
    }
}
