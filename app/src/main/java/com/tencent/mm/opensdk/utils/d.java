package com.tencent.mm.opensdk.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class d {
    public static Context D;
    private static final int E;
    private static final int F;
    private static final int G;
    public static ThreadPoolExecutor H;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        E = availableProcessors;
        int i = availableProcessors + 1;
        F = i;
        int i2 = (availableProcessors * 2) + 1;
        G = i2;
        H = new ThreadPoolExecutor(i, i2, 1, TimeUnit.SECONDS, new LinkedBlockingDeque());
    }

    private static int a(ContentResolver contentResolver, Uri uri) {
        Log.i("MicroMsg.SDK.Util", "getFileSize with content url");
        if (contentResolver == null || uri == null) {
            Log.w("MicroMsg.SDK.Util", "getFileSize fail, resolver or uri is null");
            return 0;
        }
        InputStream inputStream = null;
        try {
            InputStream openInputStream = contentResolver.openInputStream(uri);
            if (openInputStream == null) {
                if (openInputStream != null) {
                    try {
                        openInputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return 0;
            }
            int available = openInputStream.available();
            if (openInputStream != null) {
                try {
                    openInputStream.close();
                } catch (IOException unused2) {
                }
            }
            return available;
        } catch (Exception e) {
            Log.w("MicroMsg.SDK.Util", "getFileSize fail, " + e.getMessage());
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            return 0;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    public static boolean a(int i) {
        return i == 36 || i == 46;
    }

    public static boolean b(String str) {
        return str == null || str.length() <= 0;
    }

    public static int c(String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    return Integer.parseInt(str);
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public static int getFileSize(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        if (D != null && str.startsWith("content")) {
            try {
                return a(D.getContentResolver(), Uri.parse(str));
            } catch (Exception unused) {
            }
        }
        return 0;
    }
}
