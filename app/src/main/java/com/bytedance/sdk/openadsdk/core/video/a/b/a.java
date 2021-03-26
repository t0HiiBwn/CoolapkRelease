package com.bytedance.sdk.openadsdk.core.video.a.b;

import android.content.Context;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.y;
import com.bytedance.sdk.openadsdk.core.video.a.a.c;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.j.g;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;

/* compiled from: VideoPreload */
public class a {
    private static final HashSet<String> e = new HashSet<>();
    private Context a;
    private long b;
    private String c;
    private String d;

    public a(Context context, String str, String str2, long j) {
        this.a = context;
        this.b = j;
        this.c = str;
        this.d = str2;
    }

    public boolean a() {
        return c.a(this.a, this.d).exists();
    }

    public void b() {
        if (a()) {
            u.c("VideoPreload", "Cache file is exist");
            return;
        }
        HashSet<String> hashSet = e;
        synchronized (hashSet) {
            if (com.bytedance.sdk.openadsdk.core.video.a.a.a(this.d) == null) {
                if (!hashSet.contains(this.d)) {
                    hashSet.add(this.d);
                    e.a(new g() {
                        /* class com.bytedance.sdk.openadsdk.core.video.a.b.a.AnonymousClass1 */

                        /* JADX WARNING: Removed duplicated region for block: B:103:0x01e1  */
                        /* JADX WARNING: Removed duplicated region for block: B:106:0x01e9  */
                        /* JADX WARNING: Removed duplicated region for block: B:108:0x01ee  */
                        /* JADX WARNING: Removed duplicated region for block: B:110:0x01f3  */
                        /* JADX WARNING: Removed duplicated region for block: B:113:0x01fb A[SYNTHETIC] */
                        @Override // java.lang.Runnable
                        public void run() {
                            Throwable th;
                            InputStream inputStream;
                            ab abVar;
                            aa aaVar;
                            v vVar = new v();
                            y d = new y.a().a("RANGE", "bytes=0-" + a.this.b).a(a.this.c).a().d();
                            File b = c.b(a.this.a, a.this.d);
                            FileOutputStream fileOutputStream = null;
                            try {
                                aaVar = vVar.a(d).a();
                                try {
                                    if (!aaVar.d()) {
                                        if (aaVar != null) {
                                            try {
                                                aaVar.close();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                                return;
                                            }
                                        }
                                        synchronized (a.e) {
                                            a.e.remove(a.this.d);
                                        }
                                        if (com.bytedance.sdk.openadsdk.core.video.a.a.a(a.this.d) == null) {
                                            if (!b.renameTo(c.a(a.this.a, a.this.d))) {
                                                b.delete();
                                            }
                                            u.c("VideoPreload", "preload success md5 = " + a.this.d);
                                            return;
                                        }
                                        b.delete();
                                        return;
                                    }
                                    abVar = aaVar.h();
                                    try {
                                        inputStream = abVar.c();
                                        if (inputStream == null) {
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (IOException e2) {
                                                    e2.printStackTrace();
                                                    return;
                                                }
                                            }
                                            if (abVar != null) {
                                                abVar.close();
                                            }
                                            if (aaVar != null) {
                                                aaVar.close();
                                            }
                                            synchronized (a.e) {
                                                a.e.remove(a.this.d);
                                            }
                                            if (com.bytedance.sdk.openadsdk.core.video.a.a.a(a.this.d) == null) {
                                                if (!b.renameTo(c.a(a.this.a, a.this.d))) {
                                                    b.delete();
                                                }
                                                u.c("VideoPreload", "preload success md5 = " + a.this.d);
                                                return;
                                            }
                                            b.delete();
                                            return;
                                        }
                                        try {
                                            if (b.exists()) {
                                                b.delete();
                                            }
                                            FileOutputStream fileOutputStream2 = new FileOutputStream(b);
                                            try {
                                                byte[] bArr = new byte[16384];
                                                while (true) {
                                                    int read = inputStream.read(bArr);
                                                    if (read == -1) {
                                                        break;
                                                    }
                                                    fileOutputStream2.write(bArr, 0, read);
                                                }
                                                fileOutputStream2.flush();
                                                try {
                                                    fileOutputStream2.close();
                                                    if (inputStream != null) {
                                                        inputStream.close();
                                                    }
                                                    if (abVar != null) {
                                                        abVar.close();
                                                    }
                                                    if (aaVar != null) {
                                                        aaVar.close();
                                                    }
                                                    synchronized (a.e) {
                                                        a.e.remove(a.this.d);
                                                    }
                                                    if (com.bytedance.sdk.openadsdk.core.video.a.a.a(a.this.d) == null) {
                                                        if (!b.renameTo(c.a(a.this.a, a.this.d))) {
                                                            b.delete();
                                                        }
                                                        u.c("VideoPreload", "preload success md5 = " + a.this.d);
                                                        return;
                                                    }
                                                    b.delete();
                                                } catch (IOException e3) {
                                                    e3.printStackTrace();
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                fileOutputStream = fileOutputStream2;
                                                try {
                                                    th.printStackTrace();
                                                    if (fileOutputStream != null) {
                                                    }
                                                    if (inputStream != null) {
                                                    }
                                                    if (abVar != null) {
                                                    }
                                                    if (aaVar != null) {
                                                    }
                                                    synchronized (a.e) {
                                                    }
                                                } catch (Throwable th3) {
                                                    if (fileOutputStream != null) {
                                                        try {
                                                            fileOutputStream.close();
                                                        } catch (IOException e4) {
                                                            e4.printStackTrace();
                                                            throw th3;
                                                        }
                                                    }
                                                    if (inputStream != null) {
                                                        inputStream.close();
                                                    }
                                                    if (abVar != null) {
                                                        abVar.close();
                                                    }
                                                    if (aaVar != null) {
                                                        aaVar.close();
                                                    }
                                                    synchronized (a.e) {
                                                        a.e.remove(a.this.d);
                                                        if (com.bytedance.sdk.openadsdk.core.video.a.a.a(a.this.d) == null) {
                                                            if (!b.renameTo(c.a(a.this.a, a.this.d))) {
                                                                b.delete();
                                                            }
                                                            u.c("VideoPreload", "preload success md5 = " + a.this.d);
                                                        } else {
                                                            b.delete();
                                                        }
                                                        throw th3;
                                                    }
                                                }
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            th.printStackTrace();
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            if (abVar != null) {
                                                abVar.close();
                                            }
                                            if (aaVar != null) {
                                                aaVar.close();
                                            }
                                            synchronized (a.e) {
                                                a.e.remove(a.this.d);
                                            }
                                            if (com.bytedance.sdk.openadsdk.core.video.a.a.a(a.this.d) == null) {
                                                if (!b.renameTo(c.a(a.this.a, a.this.d))) {
                                                    b.delete();
                                                }
                                                u.c("VideoPreload", "preload success md5 = " + a.this.d);
                                                return;
                                            }
                                            b.delete();
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        inputStream = null;
                                        th.printStackTrace();
                                        if (fileOutputStream != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (abVar != null) {
                                        }
                                        if (aaVar != null) {
                                        }
                                        synchronized (a.e) {
                                        }
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    abVar = null;
                                    inputStream = abVar;
                                    th.printStackTrace();
                                    if (fileOutputStream != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (abVar != null) {
                                    }
                                    if (aaVar != null) {
                                    }
                                    synchronized (a.e) {
                                    }
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                aaVar = null;
                                abVar = null;
                                inputStream = abVar;
                                th.printStackTrace();
                                if (fileOutputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (abVar != null) {
                                }
                                if (aaVar != null) {
                                }
                                synchronized (a.e) {
                                }
                            }
                        }
                    });
                    return;
                }
            }
            u.c("VideoPreload", "Cache file is downloading ...");
        }
    }
}
