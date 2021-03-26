package com.ss.android.socialbase.downloader.constants;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: DownloadConstants */
public class e {
    public static volatile String a = "";
    public static volatile String b = "";
    public static volatile String c = "";
    public static long d = 512000;
    public static long e = 50;
    public static long f = 5242880;
    public static long g = 31457280;
    public static long h = 10485760;
    public static final JSONObject i = new JSONObject();

    public static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            a = str;
        }
    }
}
