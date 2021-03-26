package com.tencent.beacon.cover;

import android.content.Context;
import com.tencent.beacon.event.UserAction;
import dalvik.system.DexClassLoader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CompLoad */
public final class b implements Runnable {
    private static b c;
    private Context a;
    private List<a> b = null;
    private ClassLoader d;

    private b(Context context) {
        this.a = context;
        this.b = new ArrayList();
    }

    public static b a(Context context, List<a> list) {
        if (c == null) {
            c = new b(context);
        }
        c.a(list);
        return c;
    }

    private synchronized b a(List<a> list) {
        this.b.clear();
        this.b.addAll(list);
        return this;
    }

    private synchronized boolean b() {
        Throwable th;
        boolean z = true;
        if (this.d != null) {
            return true;
        }
        List<a> list = this.b;
        if (list == null || list.size() <= 0) {
            this.d = this.a.getClassLoader();
            UserAction.onCompLoaded(this.a.getClassLoader());
            return false;
        } else if (this.a.getFilesDir() == null) {
            return false;
        } else {
            g.a("D", "start to load comps to classLoader.", new Object[0]);
            String str = this.a.getFilesDir().getAbsolutePath() + File.separator + "beacon/comp";
            String str2 = this.a.getFilesDir().getAbsolutePath() + File.separator + "beacon/odex";
            StringBuilder sb = new StringBuilder();
            for (a aVar : this.b) {
                if (aVar != null && aVar.c == g.b) {
                    sb.append(str);
                    sb.append(File.separator);
                    sb.append(aVar.d);
                    sb.append(File.pathSeparator);
                }
            }
            int c2 = c();
            if (c2 >= 3) {
                g.a("E", "load comps failed for three times, don't load again.", new Object[0]);
                return false;
            }
            int i = c2 + 1;
            try {
                a(i);
                g.a("D", "dex file path -> " + sb.toString(), new Object[0]);
                a(str2);
                DexClassLoader dexClassLoader = new DexClassLoader(sb.toString(), str2, str, getClass().getClassLoader());
                this.d = dexClassLoader;
                UserAction.onCompLoaded(dexClassLoader);
                try {
                    a(0);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                z = false;
                e.a(this.a).a(th.toString());
                if (i >= 3) {
                    e.a(this.a).a(false);
                }
                th.printStackTrace();
                return z;
            }
            return z;
        }
    }

    private static void a(String str) {
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                f fVar = null;
                try {
                    if (f.a(file2) == 1) {
                        fVar = new f(file2);
                    }
                    g.a("I", "good oat file: " + file2.getPath(), new Object[0]);
                } catch (IOException unused) {
                    g.a("E", " oat file error , try to delete: " + file2.getPath(), new Object[0]);
                    g.b(file2);
                } catch (Throwable th) {
                    g.a((Closeable) null);
                    throw th;
                }
                g.a(fVar);
            }
        }
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        if (d.a(this.a).a("load")) {
            b();
            d.a(this.a).b("load");
        }
    }

    public final void a() {
        if (this.d == null) {
            a(0);
            b();
        }
    }

    private int c() {
        try {
            return Integer.parseInt(g.b(this.a, "LOAD_RETRIES_TIMES", "0"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private void a(int i) {
        g.a(this.a, "LOAD_RETRIES_TIMES", String.valueOf(i));
    }
}
