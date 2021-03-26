package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d.q;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONObject;

/* compiled from: Version */
public class f {
    private static q a;

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    public static void a() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            File file = new File(b.e(), "temp_pkg_info.json");
            Long valueOf = Long.valueOf(file.length());
            if (valueOf.longValue() <= 0 || !file.exists() || !file.isFile()) {
                u.b("Version", "version pkg json file does not exist");
            } else {
                byte[] bArr = new byte[valueOf.intValue()];
                fileInputStream = new FileInputStream(file);
                try {
                    fileInputStream.read(bArr);
                    q a2 = q.a(new JSONObject(new String(bArr, "utf-8")));
                    if (a2 != null) {
                        a = a2;
                        u.b("Version", "old version read success: " + a.b());
                    }
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        u.c("Version", "version init error", th);
                        if (fileInputStream == null) {
                        }
                    } catch (Throwable th3) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th3;
                    }
                }
            }
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused2) {
                }
            }
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            u.c("Version", "version init error", th);
            if (fileInputStream == null) {
                fileInputStream.close();
            }
        }
    }

    public static synchronized q b() {
        q qVar;
        synchronized (f.class) {
            qVar = a;
        }
        return qVar;
    }

    public static synchronized void a(q qVar) {
        synchronized (f.class) {
            if (qVar != null) {
                if (qVar.f()) {
                    a = qVar;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    public static void c() {
        Throwable th;
        q qVar = a;
        if (qVar == null) {
            u.b("Version", "version save error1");
            return;
        }
        String g = qVar.g();
        if (TextUtils.isEmpty(g)) {
            u.b("Version", "version save error2");
            return;
        }
        File file = new File(b.e(), "temp_pkg_info.json");
        File file2 = new File(file + ".tmp");
        if (file2.exists()) {
            file2.delete();
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
            try {
                fileOutputStream2.write(g.getBytes("utf-8"));
                if (file.exists()) {
                    file.delete();
                }
                file2.renameTo(file);
                try {
                    fileOutputStream2.close();
                } catch (IOException unused) {
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                try {
                    u.c("Version", "version save error3", th);
                    if (fileOutputStream == null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th3) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            u.c("Version", "version save error3", th);
            if (fileOutputStream == null) {
            }
        }
    }

    public static q.a a(String str) {
        if (!TextUtils.isEmpty(str) && b() != null && b().e() != null && b().f()) {
            for (q.a aVar : b().e()) {
                if (aVar.a() != null && aVar.a().equals(str)) {
                    return aVar;
                }
            }
        }
        return null;
    }

    public static boolean b(String str) {
        try {
            if (b() != null) {
                if (!TextUtils.isEmpty(b().b())) {
                    if (TextUtils.isEmpty(str)) {
                        return false;
                    }
                    String b = b().b();
                    String[] split = str.split("\\.");
                    String[] split2 = b.split("\\.");
                    int min = Math.min(split.length, split2.length);
                    for (int i = 0; i < min; i++) {
                        int length = split[i].length() - split2[i].length();
                        if (length == 0) {
                            int compareTo = split[i].compareTo(split2[i]);
                            if (compareTo > 0) {
                                return true;
                            }
                            if (compareTo < 0) {
                                return false;
                            }
                            if (i == min - 1) {
                                if (split.length > split2.length) {
                                    return true;
                                } else {
                                    return false;
                                }
                            }
                        } else if (length > 0) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
        }
    }

    public static void d() {
        q b = b();
        if (b != null) {
            File e = b.e();
            try {
                new File(e, "temp_pkg_info.json").delete();
            } catch (Throwable unused) {
            }
            if (b.e() != null) {
                for (q.a aVar : b.e()) {
                    try {
                        new File(e, j.a(aVar.a())).delete();
                    } catch (Throwable unused2) {
                    }
                }
            }
            a = null;
        }
    }
}
