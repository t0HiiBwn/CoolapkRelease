package com.bytedance.sdk.openadsdk.core.g;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.adnet.b.b;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.h.d;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.utils.am;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.w;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: PlayableCache */
public class a {
    private static volatile a a;
    private String b;
    private Map<l, b> c = Collections.synchronizedMap(new HashMap());
    private Map<String, JSONObject> d = Collections.synchronizedMap(new HashMap());
    private AtomicBoolean e = new AtomicBoolean(false);
    private Set<String> f = Collections.synchronizedSet(new HashSet());
    private Handler g = new Handler(Looper.getMainLooper());

    /* renamed from: com.bytedance.sdk.openadsdk.core.g.a$a  reason: collision with other inner class name */
    /* compiled from: PlayableCache */
    public interface AbstractC0042a {
        void a(boolean z);
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    private a() {
    }

    public boolean a(l lVar) {
        if (!(!this.e.get() || lVar == null || lVar.R() == null || lVar.R().k() == null)) {
            try {
                String a2 = j.a(lVar.R().k());
                if (this.d.get(a2) == null) {
                    return false;
                }
                return c(new File(c(), a2));
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public void b() {
        if (!this.e.get()) {
            e.a(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.core.g.a.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    File[] listFiles;
                    try {
                        String c = a.this.c();
                        if (!TextUtils.isEmpty(c)) {
                            File file = new File(c);
                            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                                for (File file2 : listFiles) {
                                    try {
                                        a.this.a(new File(file2, "tt_open_ad_sdk_check_res.dat"), true);
                                    } catch (Throwable unused) {
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                    a.this.e.set(true);
                }
            }, 5);
        }
    }

    /* access modifiers changed from: private */
    public JSONObject a(File file, boolean z) {
        byte[] d2;
        if (file == null) {
            return null;
        }
        try {
            if (!file.exists() || !file.isFile() || !file.canRead() || (d2 = com.bytedance.sdk.openadsdk.utils.l.d(file)) == null || d2.length <= 0) {
                return null;
            }
            String b2 = com.bytedance.sdk.openadsdk.core.a.b(new String(d2), com.bytedance.sdk.openadsdk.core.b.d());
            if (TextUtils.isEmpty(b2)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(b2);
            if (z && jSONObject.length() > 0) {
                this.d.put(file.getParentFile().getName(), jSONObject);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public WebResourceResponse a(String str, String str2, String str3) {
        try {
            if (!this.e.get() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                if (str3.startsWith("http") && str3.contains("?")) {
                    str3 = str3.split("\\?")[0];
                    if (str3.endsWith("/")) {
                        str3 = str3.substring(0, str3.length() - 1);
                    }
                }
            } catch (Throwable unused) {
            }
            String a2 = w.a(p.a(), str3);
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            String a3 = j.a(str);
            if (TextUtils.isEmpty(a3)) {
                return null;
            }
            File file = new File(c(), a3);
            if (c(file)) {
                String a4 = a(str2);
                if (TextUtils.isEmpty(a4)) {
                    return null;
                }
                String replace = str3.replace(a4, "");
                if (TextUtils.isEmpty(replace)) {
                    return null;
                }
                File file2 = new File(file, replace);
                if (a(a3, replace, file2)) {
                    return new WebResourceResponse(a2, "utf-8", new FileInputStream(file2));
                }
            }
            return null;
        } catch (Throwable th) {
            u.c("PlayableCache", "playable intercept error: ", th);
        }
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\?");
        if (split != null && split.length == 2) {
            if (split[0] != null && split[0].endsWith("/")) {
                str = str.substring(0, split.length - 1);
            }
            if (split[0] != null && split[0].endsWith("index.html")) {
                str = split[0];
            }
        }
        return str.replace("index.html", "");
    }

    private boolean a(String str, String str2, File file) {
        JSONObject jSONObject;
        String optString;
        if (file == null || !file.exists() || (jSONObject = this.d.get(str)) == null || (optString = jSONObject.optString(str2)) == null || !optString.equalsIgnoreCase(j.a(file))) {
            return false;
        }
        return true;
    }

    public void a(final l lVar, final AbstractC0042a aVar) {
        if (lVar == null || lVar.R() == null || TextUtils.isEmpty(lVar.R().k())) {
            b.a(p.a(), lVar, -701, (String) null);
            a(aVar, false);
            return;
        }
        final String k = lVar.R().k();
        if (!this.f.contains(k)) {
            this.c.put(lVar, new b().a(System.currentTimeMillis()));
            b.a(p.a(), lVar);
            final String a2 = j.a(k);
            final File file = new File(c(), a2);
            if (c(file)) {
                b.a(p.a(), lVar, -702, (String) null);
                b(file);
                this.c.remove(lVar);
                a(aVar, true);
                return;
            }
            try {
                com.bytedance.sdk.openadsdk.utils.l.c(file);
            } catch (Throwable unused) {
            }
            this.f.add(k);
            d.a(p.a()).a(k, new b.a() {
                /* class com.bytedance.sdk.openadsdk.core.g.a.AnonymousClass2 */

                @Override // com.bytedance.sdk.adnet.b.b.a
                public File a(String str) {
                    return null;
                }

                @Override // com.bytedance.sdk.adnet.b.c.a
                public void a(long j, long j2) {
                }

                @Override // com.bytedance.sdk.adnet.b.b.a
                public void a(String str, File file) {
                }

                @Override // com.bytedance.sdk.adnet.b.b.a
                public File b(String str) {
                    String d2 = a.this.d();
                    return new File(d2, a2 + ".zip");
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void a(final m<File> mVar) {
                    a.this.f.remove(k);
                    final b bVar = (b) a.this.c.remove(lVar);
                    if (bVar != null) {
                        bVar.b(System.currentTimeMillis());
                    }
                    if (mVar == null || mVar.a == null) {
                        int i = -700;
                        if (!(mVar == null || mVar.h == 0)) {
                            i = Long.valueOf(mVar.h).intValue();
                        }
                        b.a(p.a(), lVar, i, (String) null);
                        a.this.a(aVar, false);
                        return;
                    }
                    e.a(new Runnable() {
                        /* class com.bytedance.sdk.openadsdk.core.g.a.AnonymousClass2.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            long j;
                            long j2;
                            boolean z = true;
                            try {
                                b bVar = bVar;
                                if (bVar != null) {
                                    bVar.c(System.currentTimeMillis());
                                }
                                am.a(mVar.a.getAbsolutePath(), a.this.c());
                                b bVar2 = bVar;
                                if (bVar2 != null) {
                                    bVar2.d(System.currentTimeMillis());
                                }
                                b bVar3 = bVar;
                                if (bVar3 != null) {
                                    long a2 = bVar3.a();
                                    j = bVar.b();
                                    j2 = a2;
                                } else {
                                    j = 0;
                                    j2 = 0;
                                }
                                b.a(p.a(), lVar, j2, j);
                                a.this.a(file);
                                try {
                                    a.this.a(new File(file, "tt_open_ad_sdk_check_res.dat"), true);
                                } catch (Throwable unused) {
                                }
                            } catch (Throwable th) {
                                u.c("PlayableCache", "unzip error: ", th);
                                b.a(p.a(), lVar, -704, th.getMessage());
                                z = false;
                            }
                            try {
                                mVar.a.delete();
                            } catch (Throwable unused2) {
                            }
                            a.this.a(aVar, z);
                        }
                    }, 5);
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void b(m<File> mVar) {
                    a.this.f.remove(k);
                    a.this.c.remove(lVar);
                    int i = -700;
                    String str = null;
                    if (mVar != null) {
                        if (mVar.h != 0) {
                            i = Long.valueOf(mVar.h).intValue();
                        } else if (!(mVar.c == null || mVar.c.networkResponse == null || mVar.c.networkResponse.a == 0)) {
                            i = mVar.c.networkResponse.a;
                        }
                        if (mVar.c != null) {
                            str = mVar.c.getMessage();
                        }
                    }
                    b.a(p.a(), lVar, i, str);
                    a.this.a(aVar, false);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(final AbstractC0042a aVar, final boolean z) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (aVar != null) {
                aVar.a(z);
            }
        } else if (aVar != null) {
            this.g.post(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.core.g.a.AnonymousClass3 */

                @Override // java.lang.Runnable
                public void run() {
                    AbstractC0042a aVar = aVar;
                    if (aVar != null) {
                        aVar.a(z);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(File file) {
        b(file);
        try {
            i.d().r().a(file);
        } catch (Throwable unused) {
        }
    }

    private void b(File file) {
        try {
            if (file.exists()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (!file.setLastModified(currentTimeMillis)) {
                    file.renameTo(file);
                    if (file.lastModified() < currentTimeMillis) {
                        u.d("PlayableCache", "Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private boolean c(File file) {
        String[] list;
        if (file == null || !file.isDirectory() || (list = file.list()) == null || list.length <= 0) {
            return false;
        }
        return Arrays.asList(list).contains("index.html");
    }

    /* access modifiers changed from: private */
    public String c() {
        File file = new File(d(), "games");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    /* access modifiers changed from: private */
    public String d() {
        File file;
        if (TextUtils.isEmpty(this.b)) {
            try {
                if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && p.a().getExternalCacheDir() != null) {
                    file = p.a().getExternalCacheDir();
                } else {
                    file = p.a().getCacheDir();
                }
                File file2 = new File(file, "playable");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                this.b = file2.getAbsolutePath();
            } catch (Throwable th) {
                u.f("PlayableCache", "init root path error: " + th);
            }
        }
        return this.b;
    }

    /* compiled from: PlayableCache */
    private static class b {
        long a;
        long b;
        long c;
        long d;

        private b() {
        }

        public long a() {
            return this.b - this.a;
        }

        public long b() {
            return this.d - this.c;
        }

        public b a(long j) {
            this.a = j;
            return this;
        }

        public b b(long j) {
            this.b = j;
            return this;
        }

        public b c(long j) {
            this.c = j;
            return this;
        }

        public b d(long j) {
            this.d = j;
            return this;
        }
    }
}
