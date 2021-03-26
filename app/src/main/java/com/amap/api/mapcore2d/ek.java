package com.amap.api.mapcore2d;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.mapcore2d.eb;
import com.amap.api.mapcore2d.ee;
import com.amap.api.mapcore2d.eg;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.Date;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: DynamicLoader */
class ek extends ei {
    private PublicKey i = null;

    ek(Context context, da daVar, boolean z) throws Exception {
        super(context, daVar, z);
        String b = eb.b(context, daVar.a(), daVar.b());
        String a = eb.a(context);
        b(b, a);
        File file = new File(b);
        if (eg.b().a(this.e).b) {
            throw new Exception("file is downloading");
        } else if (z) {
            a(b, a + File.separator + eb.a(file.getName()));
            b(context, b, a);
        }
    }

    @Override // java.lang.ClassLoader
    protected Class<?> findClass(String str) throws ClassNotFoundException {
        Class<?> cls;
        Throwable th;
        try {
            if (this.c != null) {
                try {
                    synchronized (this.b) {
                        try {
                            cls = (Class) this.b.get(str);
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    cls = null;
                    th = th4;
                    eh.a(th, "dLoader", "findCl");
                    if (cls != null) {
                        this.h = false;
                        return cls;
                    } else if (!this.g) {
                        this.h = true;
                        Class<?> loadClass = this.c.loadClass(str, this);
                        synchronized (this.c) {
                            this.c.notify();
                        }
                        this.h = false;
                        if (loadClass != null) {
                            try {
                                synchronized (this.b) {
                                    this.b.put(str, loadClass);
                                }
                            } catch (Throwable th5) {
                                eh.a(th5, "dLoader", "findCl");
                            }
                            this.h = false;
                            return loadClass;
                        }
                        throw new ClassNotFoundException(str);
                    } else {
                        throw new ClassNotFoundException(str);
                    }
                }
            } else {
                throw new ClassNotFoundException(str);
            }
        } catch (ClassNotFoundException e) {
            throw e;
        } catch (Throwable th6) {
            this.h = false;
            throw th6;
        }
    }

    void a(String str, String str2) throws Exception {
        eg.a aVar = null;
        try {
            if (this.c == null) {
                eg.a a = eg.b().a(this.e);
                if (a != null) {
                    a.a = true;
                }
                b();
                if (!a.b) {
                    this.c = DexFile.loadDex(str, str2, 0);
                    if (a != null) {
                        try {
                            a.a = false;
                            synchronized (a) {
                                a.notify();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                } else {
                    throw new Exception("file is downloading");
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    aVar.a = false;
                    synchronized (aVar) {
                        aVar.notify();
                    }
                } catch (Throwable unused2) {
                }
            }
            throw th;
        }
    }

    private void c() {
        if (this.i == null) {
            this.i = eh.a();
        }
    }

    private void a(JarFile jarFile, JarEntry jarEntry) throws IOException {
        Throwable th;
        InputStream inputStream;
        try {
            inputStream = jarFile.getInputStream(jarEntry);
            try {
                do {
                } while (inputStream.read(new byte[8192]) > 0);
                try {
                    eh.a(inputStream);
                    return;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    return;
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    eh.a(th, "DyLoader", "loadJa");
                    eh.a(inputStream);
                    return;
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            eh.a(th, "DyLoader", "loadJa");
            eh.a(inputStream);
            return;
        }
        throw th;
    }

    private boolean a(File file, Certificate[] certificateArr) {
        int length;
        try {
            if (certificateArr.length <= 0 || (length = certificateArr.length - 1) < 0) {
                return false;
            }
            certificateArr[length].verify(this.i);
            return true;
        } catch (Exception e) {
            eh.a(e, "DyLoader", "check");
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0038 A[SYNTHETIC, Splitter:B:29:0x0038] */
    private boolean a(File file) {
        Throwable th;
        JarFile jarFile = null;
        try {
            c();
            JarFile jarFile2 = new JarFile(file);
            try {
                JarEntry jarEntry = jarFile2.getJarEntry("classes.dex");
                if (jarEntry == null) {
                    try {
                        jarFile2.close();
                    } catch (Throwable unused) {
                    }
                    return false;
                }
                a(jarFile2, jarEntry);
                Certificate[] certificates = jarEntry.getCertificates();
                if (certificates == null) {
                    try {
                        jarFile2.close();
                    } catch (Throwable unused2) {
                    }
                    return false;
                }
                boolean a = a(file, certificates);
                try {
                    jarFile2.close();
                } catch (Throwable unused3) {
                }
                return a;
            } catch (Throwable th2) {
                th = th2;
                jarFile = jarFile2;
                try {
                    eh.a(th, "DyLoader", "verify");
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    return false;
                } catch (Throwable unused5) {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            eh.a(th, "DyLoader", "verify");
            if (jarFile != null) {
            }
            return false;
        }
        throw th;
    }

    private boolean a(dt dtVar, da daVar, String str) {
        if (a(new File(str))) {
            return eh.a(dtVar, eb.a(this.a, daVar.a(), daVar.b()), str, daVar);
        }
        return false;
    }

    private boolean a(dt dtVar, String str, String str2) {
        String a = eb.a(this.a, str);
        if (eh.a(dtVar, str, a, this.e)) {
            return true;
        }
        if (eb.a.a(dtVar, str) != null) {
            return false;
        }
        if (!TextUtils.isEmpty(this.f)) {
            eb.a.a(dtVar, new ee.a(str, cx.a(a), this.e.a(), this.e.b(), str2).a("useod").a(), ee.b(str));
        }
        return true;
    }

    private void b(String str, String str2) throws Exception {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new Exception("dexPath or dexOutputDir is null.");
        }
    }

    private void b(final Context context, final String str, final String str2) {
        try {
            eg.b().a().submit(new Runnable() {
                /* class com.amap.api.mapcore2d.ek.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ek.this.a(context, str, str2);
                    } catch (Throwable th) {
                        eh.a(th, "dLoader", "run()");
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    private void a(dt dtVar, File file) {
        ee a = eb.a.a(dtVar, file.getName());
        if (a != null) {
            this.f = a.e();
        }
    }

    private void b(dt dtVar, File file) {
        this.d = false;
        eb.a(this.a, dtVar, file.getName());
        String a = eb.a(this.a, dtVar, this.e);
        if (!TextUtils.isEmpty(a)) {
            this.f = a;
            eb.a(this.a, this.e);
        }
    }

    void a(Context context, String str, String str2) throws Exception {
        new Date().getTime();
        try {
            dt dtVar = new dt(context, ed.c());
            File file = new File(str);
            a(dtVar, file);
            if (!a(dtVar, this.e, file.getAbsolutePath())) {
                b(dtVar, file);
            }
            if (file.exists()) {
                if (new File(str2 + File.separator + eb.a(file.getName())).exists()) {
                    if (!a(dtVar, eb.a(file.getName()), this.f)) {
                        eb.a(this.a, this.e);
                    }
                }
                new Date().getTime();
            }
        } catch (Throwable th) {
            eh.a(th, "dLoader", "verifyD()");
        }
    }
}
