package com.bytedance.sdk.openadsdk.i.g;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

/* compiled from: FileHelper */
public class a {
    static Context a;

    public static void a(Context context) {
        Objects.requireNonNull(context);
        a = context;
    }

    @Deprecated
    public static File a() {
        return b(a);
    }

    public static File b(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        return externalCacheDir == null ? context.getCacheDir() : externalCacheDir;
    }

    public static File b() {
        if (!c() || !d()) {
            return null;
        }
        File file = new File(a(), "video");
        a(file);
        return file;
    }

    public static File a(File file, String str) {
        if (!c() || !d() || TextUtils.isEmpty(str)) {
            return null;
        }
        if (file == null) {
            file = a();
        }
        File file2 = new File(file, str);
        a(file2);
        return file2;
    }

    public static void a(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static boolean c() {
        try {
            String externalStorageState = Environment.getExternalStorageState();
            return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
        } catch (Exception unused) {
            return c.a().b();
        }
    }

    public static boolean d() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0042 A[SYNTHETIC, Splitter:B:25:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004c A[SYNTHETIC, Splitter:B:30:0x004c] */
    public static String a(InputStream inputStream) {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            StringBuilder sb = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        u.a("FileHelper", "readStream error", th);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th3) {
                                u.a("FileHelper", "br error", th3);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th4) {
                                u.a("FileHelper", "is error", th4);
                            }
                        }
                        return null;
                    } catch (Throwable th5) {
                        u.a("FileHelper", "is error", th5);
                    }
                }
            }
            String sb2 = sb.toString();
            try {
                bufferedReader.close();
            } catch (Throwable th6) {
                u.a("FileHelper", "br error", th6);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th7) {
                    u.a("FileHelper", "is error", th7);
                }
            }
            return sb2;
        } catch (Throwable th8) {
            th = th8;
            bufferedReader = null;
            u.a("FileHelper", "readStream error", th);
            if (bufferedReader != null) {
            }
            if (inputStream != null) {
            }
            return null;
        }
        if (inputStream != null) {
            inputStream.close();
        }
        throw th;
        throw th;
    }
}
