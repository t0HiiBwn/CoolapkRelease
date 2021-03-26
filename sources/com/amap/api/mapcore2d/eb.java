package com.amap.api.mapcore2d;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.mapcore2d.ee;
import com.amap.api.mapcore2d.eg;
import dalvik.system.DexFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.util.List;

/* compiled from: DexFileManager */
public class eb {

    /* compiled from: DexFileManager */
    public static class a {
        public static void a(dt dtVar, ee eeVar, String str) {
            dtVar.a(eeVar, str);
        }

        static ee a(dt dtVar, String str) {
            List b = dtVar.b(ee.b(str), ee.class);
            if (b == null || b.size() <= 0) {
                return null;
            }
            return (ee) b.get(0);
        }

        public static List<ee> a(dt dtVar, String str, String str2) {
            return dtVar.b(ee.b(str, str2), ee.class);
        }
    }

    static String a(String str) {
        return str + ".o";
    }

    static String a(Context context, String str, String str2) {
        String v = cu.v(context);
        return cx.b(str + str2 + v) + ".jar";
    }

    static String b(Context context, String str, String str2) {
        return a(context, a(context, str, str2));
    }

    public static String a(Context context, String str) {
        return a(context) + File.separator + str;
    }

    static String a(Context context) {
        return context.getFilesDir().getAbsolutePath() + File.separator + "pngex";
    }

    static void a(Context context, da daVar) {
        try {
            eg.a a2 = eg.b().a(daVar);
            if (a2 != null && a2.a) {
                synchronized (a2) {
                    a2.wait();
                }
            }
            a2.b = true;
            String b = b(context, daVar.a(), daVar.b());
            if (!TextUtils.isEmpty(b)) {
                File file = new File(b);
                File parentFile = file.getParentFile();
                if (file.exists()) {
                    String a3 = a(context, a(file.getName()));
                    DexFile loadDex = DexFile.loadDex(b, a3, 0);
                    if (loadDex != null) {
                        loadDex.close();
                        a(context, file, a3, daVar);
                    }
                    a2.b = false;
                } else if (parentFile != null && parentFile.exists()) {
                    c(context, daVar.a(), daVar.b());
                }
            }
        } catch (Throwable th) {
            eh.a(th, "BaseLoader", "getInstanceByThread()");
        }
    }

    static void b(Context context, String str) {
        dt dtVar = new dt(context, ed.c());
        List<ee> a2 = a.a(dtVar, str, "copy");
        eh.a(a2);
        if (a2 != null) {
            if (a2.size() > 1) {
                int size = a2.size();
                for (int i = 1; i < size; i++) {
                    c(context, dtVar, a2.get(i).a());
                }
            }
        }
    }

    static void a(Context context, dt dtVar, String str) {
        c(context, dtVar, a(str));
        c(context, dtVar, str);
    }

    static void c(final Context context, final String str, final String str2) {
        try {
            eg.b().a().submit(new Runnable() {
                /* class com.amap.api.mapcore2d.eb.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        dt dtVar = new dt(context, ed.c());
                        List<ee> b2 = dtVar.b(ee.a(str), ee.class);
                        if (b2 != null && b2.size() > 0) {
                            for (ee eeVar : b2) {
                                if (!str2.equalsIgnoreCase(eeVar.d())) {
                                    eb.c(context, dtVar, eeVar.a());
                                }
                            }
                        }
                    } catch (Throwable th) {
                        eh.a(th, "FileManager", "clearUnSuitableV");
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    static void a(dt dtVar, Context context, String str) {
        List<ee> a2 = a.a(dtVar, str, "used");
        if (a2 != null && a2.size() > 0) {
            for (ee eeVar : a2) {
                if (eeVar != null && eeVar.c().equals(str)) {
                    a(context, dtVar, eeVar.a());
                    List b = dtVar.b(ee.a(str, eeVar.e()), ee.class);
                    if (b != null && b.size() > 0) {
                        ee eeVar2 = (ee) b.get(0);
                        eeVar2.c("errorstatus");
                        a.a(dtVar, eeVar2, ee.b(eeVar2.a()));
                        File file = new File(a(context, eeVar2.a()));
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e0 A[SYNTHETIC, Splitter:B:61:0x00e0] */
    static void a(Context context, dt dtVar, da daVar, String str, String str2) throws Throwable {
        RandomAccessFile randomAccessFile;
        eg.a aVar;
        Throwable th;
        File file;
        FileInputStream fileInputStream = null;
        try {
            String a2 = daVar.a();
            aVar = eg.b().a(daVar);
            if (aVar != null) {
                try {
                    if (aVar.a) {
                        synchronized (aVar) {
                            aVar.wait();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile = null;
                    try {
                        throw th;
                    } catch (Throwable unused) {
                    }
                }
            }
            aVar.b = true;
            String a3 = a(context, a2, daVar.b());
            a(context, dtVar, a3);
            FileInputStream fileInputStream2 = new FileInputStream(new File(str));
            try {
                fileInputStream2.read(new byte[32]);
                file = new File(b(context, a2, daVar.b()));
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                fileInputStream = fileInputStream2;
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                int i = 0;
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    if (read == 1024) {
                        randomAccessFile.seek((long) i);
                        randomAccessFile.write(bArr);
                    } else {
                        byte[] bArr2 = new byte[read];
                        System.arraycopy(bArr, 0, bArr2, 0, read);
                        randomAccessFile.seek((long) i);
                        randomAccessFile.write(bArr2);
                    }
                    i += read;
                }
                ee a4 = new ee.a(a3, cx.a(file.getAbsolutePath()), a2, daVar.b(), str2).a("used").a();
                a.a(dtVar, a4, ee.b(a4.a()));
                try {
                    eh.a(fileInputStream2);
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
                try {
                    eh.a(randomAccessFile);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                if (aVar != null) {
                    try {
                        aVar.b = false;
                        return;
                    } catch (Throwable unused2) {
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th6) {
                th = th6;
                fileInputStream = fileInputStream2;
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            aVar = null;
            randomAccessFile = null;
            throw th;
        }
        throw th;
        eh.a(randomAccessFile);
        if (aVar != null) {
            aVar.b = false;
        }
        throw th;
        if (aVar != null) {
        }
        throw th;
    }

    static String a(Context context, dt dtVar, da daVar) {
        List b = dtVar.b(ee.b(daVar.a(), "copy"), ee.class);
        String str = null;
        if (b != null && b.size() != 0) {
            eh.a(b);
            for (int i = 0; i < b.size(); i++) {
                ee eeVar = (ee) b.get(i);
                if (eh.a(context, dtVar, eeVar.a(), daVar)) {
                    try {
                        a(context, dtVar, daVar, a(context, eeVar.a()), eeVar.e());
                        str = eeVar.e();
                        break;
                    } catch (Throwable th) {
                        eh.a(th, "FileManager", "loadAvailableD");
                    }
                } else {
                    c(context, dtVar, eeVar.a());
                }
            }
        }
        return str;
    }

    static void a(Context context, File file, da daVar) {
        File parentFile = file.getParentFile();
        if (!file.exists() && parentFile != null && parentFile.exists()) {
            c(context, daVar.a(), daVar.b());
        }
    }

    /* access modifiers changed from: private */
    public static void c(Context context, dt dtVar, String str) {
        File file = new File(a(context, str));
        if (file.exists()) {
            file.delete();
        }
        dtVar.a(ee.b(str), ee.class);
    }

    private static void a(Context context, File file, String str, da daVar) {
        dt dtVar = new dt(context, ed.c());
        ee a2 = a.a(dtVar, file.getName());
        String e = a2 != null ? a2.e() : null;
        File file2 = new File(str);
        if (!TextUtils.isEmpty(e) && file2.exists()) {
            String a3 = cx.a(str);
            String name = file2.getName();
            a.a(dtVar, new ee.a(name, a3, daVar.a(), daVar.b(), e).a("useod").a(), ee.b(name));
        }
    }
}
