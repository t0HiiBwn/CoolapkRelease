package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.b.b;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.t;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: RewardVideoCache */
public class e {
    private static volatile e a;
    private final Context b;
    private final h c;
    private Map<l, Long> d = Collections.synchronizedMap(new HashMap());

    /* compiled from: RewardVideoCache */
    interface a<T> {
        void a(boolean z, T t);
    }

    public void a(String str) {
        this.c.d(str);
    }

    public void a() {
        File file;
        File[] listFiles;
        File file2;
        File[] listFiles2;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                file2 = new File(this.b.getDataDir(), "shared_prefs");
            } else {
                file2 = new File(this.b.getDatabasePath("1").getParentFile().getParentFile(), "shared_prefs");
            }
            if (file2.exists() && file2.isDirectory() && (listFiles2 = file2.listFiles(new FileFilter() {
                /* class com.bytedance.sdk.openadsdk.component.reward.e.AnonymousClass1 */

                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    if (file != null) {
                        return file.getName().contains("sp_reward_video");
                    }
                    return false;
                }
            })) != null) {
                for (File file3 : listFiles2) {
                    try {
                        String replace = file3.getName().replace(".xml", "");
                        if (Build.VERSION.SDK_INT >= 24) {
                            this.b.deleteSharedPreferences(replace);
                        } else {
                            this.b.getSharedPreferences(replace, 0).edit().clear().apply();
                            com.bytedance.sdk.openadsdk.utils.l.c(file3);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && this.b.getExternalCacheDir() != null) {
                file = this.b.getExternalCacheDir();
            } else {
                file = this.b.getCacheDir();
            }
            if (file != null && file.exists() && file.isDirectory() && (listFiles = file.listFiles(new FileFilter() {
                /* class com.bytedance.sdk.openadsdk.component.reward.e.AnonymousClass2 */

                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    if (file != null) {
                        return file.getName().contains("reward_video_cache");
                    }
                    return false;
                }
            })) != null && listFiles.length > 0) {
                for (File file4 : listFiles) {
                    try {
                        com.bytedance.sdk.openadsdk.utils.l.c(file4);
                    } catch (Throwable unused3) {
                    }
                }
            }
        } catch (Throwable unused4) {
        }
    }

    public void a(AdSlot adSlot, l lVar) {
        a(adSlot);
        if (lVar != null) {
            try {
                this.c.a(adSlot.getCodeId(), lVar.aF().toString());
            } catch (Throwable unused) {
            }
        }
    }

    public AdSlot b(String str) {
        return this.c.e(str);
    }

    public void a(AdSlot adSlot) {
        this.c.a(adSlot);
    }

    public void b(AdSlot adSlot) {
        this.c.b(adSlot);
    }

    public AdSlot b() {
        return this.c.a();
    }

    public static e a(Context context) {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e(context);
                }
            }
        }
        return a;
    }

    private e(Context context) {
        Context a2 = context == null ? p.a() : context.getApplicationContext();
        this.b = a2;
        this.c = new h(a2, "sp_reward_video");
    }

    public String a(l lVar) {
        if (lVar == null || lVar.R() == null || TextUtils.isEmpty(lVar.R().i())) {
            return null;
        }
        return a(lVar.R().i(), lVar.R().l(), String.valueOf(aj.d(lVar.aj())));
    }

    public String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = j.a(str);
        }
        File a2 = a(this.b, a(String.valueOf(str3), b.b()), str2);
        if (a2 == null || !a2.exists() || !a2.isFile()) {
            return null;
        }
        return a2.getAbsolutePath();
    }

    public l c(String str) {
        l a2;
        long b2 = this.c.b(str);
        boolean c2 = this.c.c(str);
        if (!(System.currentTimeMillis() - b2 < 10800000) || c2) {
            return null;
        }
        try {
            String a3 = this.c.a(str);
            if (TextUtils.isEmpty(a3) || (a2 = c.a(new JSONObject(a3))) == null) {
                return null;
            }
            if (a2.D()) {
                return a2;
            }
            if (a2.R() == null) {
                return null;
            }
            t R = a2.R();
            if (!TextUtils.isEmpty(a(R.i(), R.l(), str))) {
                return a2;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private String a(String str, boolean z) {
        if (z) {
            return "reward_video_cache_" + str + "/";
        }
        return "/reward_video_cache_" + str + "/";
    }

    /* access modifiers changed from: private */
    public void a(boolean z, l lVar, long j, m mVar) {
        long j2;
        Long remove = this.d.remove(lVar);
        if (remove == null) {
            j2 = 0;
        } else {
            j2 = SystemClock.elapsedRealtime() - remove.longValue();
        }
        d.f(this.b, lVar, "rewarded_video", z ? "load_video_success" : "load_video_error", aj.a(z, lVar, j2, j, (z || mVar == null || mVar.c == null) ? null : mVar.c.getMessage()));
    }

    public void a(final l lVar, final a<Object> aVar) {
        this.d.put(lVar, Long.valueOf(SystemClock.elapsedRealtime()));
        if (lVar == null || lVar.R() == null || TextUtils.isEmpty(lVar.R().i())) {
            if (aVar != null) {
                aVar.a(false, null);
            }
            a(false, lVar, -1, null);
            return;
        }
        String i = lVar.R().i();
        final String l2 = lVar.R().l();
        if (TextUtils.isEmpty(l2)) {
            l2 = j.a(i);
        }
        int d2 = aj.d(lVar.aj());
        String a2 = a(String.valueOf(d2), b.b());
        u.f("wzj", "ritId:" + d2 + ",cacheDirPath=" + a2);
        final File a3 = a(this.b, a2, l2);
        StringBuilder sb = new StringBuilder();
        sb.append("RewardVideoCache downloadVideo target.getPath() ");
        sb.append(a3.getPath());
        u.b("splashLoadAd", sb.toString());
        com.bytedance.sdk.openadsdk.h.d.a(this.b).a(i, new b.a() {
            /* class com.bytedance.sdk.openadsdk.component.reward.e.AnonymousClass3 */

            @Override // com.bytedance.sdk.adnet.b.c.a
            public void a(long j, long j2) {
            }

            @Override // com.bytedance.sdk.adnet.b.b.a
            public File a(String str) {
                try {
                    File parentFile = a3.getParentFile();
                    if (parentFile == null || !parentFile.exists()) {
                        return null;
                    }
                    return i.d().p().a(l2, parentFile);
                } catch (IOException e2) {
                    u.f("RewardVideoCache", "datastoreGet throw IOException : " + e2.toString());
                    return null;
                }
            }

            @Override // com.bytedance.sdk.adnet.b.b.a
            public void a(String str, File file) {
                if (file != null) {
                    e.this.a(file);
                }
            }

            @Override // com.bytedance.sdk.adnet.b.b.a
            public File b(String str) {
                return a3;
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void a(m<File> mVar) {
                if (mVar == null || mVar.a == null) {
                    a aVar = aVar;
                    if (aVar != null) {
                        aVar.a(false, null);
                    }
                    e.this.a(false, lVar, mVar == null ? -3 : mVar.h, mVar);
                    return;
                }
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(true, null);
                }
                e.this.a(true, lVar, 0, mVar);
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void b(m<File> mVar) {
                a aVar = aVar;
                if (aVar != null) {
                    aVar.a(false, null);
                }
                e.this.a(false, lVar, mVar == null ? -2 : mVar.h, mVar);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(File file) {
        try {
            i.d().p().a(file);
        } catch (IOException e) {
            u.f("RewardVideoCache", "trimFileCache IOException:" + e.toString());
        }
    }

    private File a(Context context, String str, String str2) {
        if (p.h().B() == 1) {
            u.f("splashLoadAd", "RewardVideoCache getDiskCacheDir 视频存储使用内部存储");
            return com.bytedance.sdk.openadsdk.utils.l.b(context, com.bytedance.sdk.openadsdk.multipro.b.b(), str, str2);
        }
        u.f("splashLoadAd", "RewardVideoCache getDiskCacheDir 视频存储使用外存储");
        return com.bytedance.sdk.openadsdk.utils.l.a(context, com.bytedance.sdk.openadsdk.multipro.b.b(), str, str2);
    }
}
