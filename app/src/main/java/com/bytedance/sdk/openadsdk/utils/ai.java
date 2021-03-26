package com.bytedance.sdk.openadsdk.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.bytedance.sdk.openadsdk.core.i;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* compiled from: TestHelperUtils */
public class ai {
    private static String a;

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0062 A[SYNTHETIC, Splitter:B:32:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0069 A[SYNTHETIC, Splitter:B:36:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0075 A[SYNTHETIC, Splitter:B:44:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x007c A[SYNTHETIC, Splitter:B:48:0x007c] */
    public static String a(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader;
        Exception e;
        StringBuilder sb = new StringBuilder();
        FileReader fileReader2 = null;
        try {
            File file = new File("data/data/com.union_test.toutiao/" + str);
            if (!file.exists()) {
                return null;
            }
            fileReader = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            e.printStackTrace();
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Throwable unused) {
                                }
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable unused2) {
                                }
                            }
                            return sb.toString();
                        } catch (Throwable th2) {
                            th = th2;
                            fileReader2 = fileReader;
                            if (fileReader2 != null) {
                                try {
                                    fileReader2.close();
                                } catch (Throwable unused3) {
                                }
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable unused4) {
                                }
                            }
                            throw th;
                        }
                    }
                }
                String sb2 = sb.toString();
                try {
                    fileReader.close();
                } catch (Throwable unused5) {
                }
                try {
                    bufferedReader.close();
                } catch (Throwable unused6) {
                }
                return sb2;
            } catch (Exception e3) {
                bufferedReader = null;
                e = e3;
                e.printStackTrace();
                if (fileReader != null) {
                }
                if (bufferedReader != null) {
                }
                return sb.toString();
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                fileReader2 = fileReader;
                if (fileReader2 != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
        } catch (Exception e4) {
            bufferedReader = null;
            e = e4;
            fileReader = null;
            e.printStackTrace();
            if (fileReader != null) {
            }
            if (bufferedReader != null) {
            }
            return sb.toString();
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            if (fileReader2 != null) {
            }
            if (bufferedReader != null) {
            }
            throw th;
        }
    }

    public static boolean a() {
        if (u.c() && i.d().v() && i.d().w()) {
            return true;
        }
        return false;
    }

    public static String a(String str, String str2) {
        if (str.contains("https://pangolin.snssdk.com")) {
            return str.replace("https://pangolin.snssdk.com", str2);
        }
        if (str.contains("https://is.snssdk.com")) {
            return str.replace("https://is.snssdk.com", str2);
        }
        if (str.contains("https://pangolin16.snssdk.com")) {
            return str.replace("https://pangolin16.snssdk.com", str2);
        }
        return str.contains("https://api-access.pangolin-sdk-toutiao.com") ? str.replace("https://api-access.pangolin-sdk-toutiao.com", str2) : str;
    }

    public static String b(String str) {
        try {
            if (!a()) {
                return str;
            }
            String x = i.d().x();
            if (TextUtils.isEmpty(x)) {
                return str;
            }
            Log.d("TestHelperUtils", "AnyDoorId=" + x);
            return Uri.parse(str).buildUpon().appendQueryParameter(b(), x).appendQueryParameter("aid", "5001121").toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String b() {
        if (TextUtils.isEmpty(a)) {
            a = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return a;
    }
}
