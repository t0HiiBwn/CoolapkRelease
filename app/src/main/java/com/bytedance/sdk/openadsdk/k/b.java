package com.bytedance.sdk.openadsdk.k;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.b.i;
import com.bytedance.sdk.adnet.b.j;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.core.h.g;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.h.d;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.utils.s;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import com.bytedance.sdk.openadsdk.utils.y;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/* compiled from: TrackAdUrlImpl */
public class b implements a {
    private final Context a;
    private final f b;

    @Override // com.bytedance.sdk.openadsdk.k.a
    public void a() {
    }

    public b(Context context, f fVar) {
        this.a = context;
        this.b = fVar;
    }

    public Context b() {
        Context context = this.a;
        return context == null ? p.a() : context;
    }

    @Override // com.bytedance.sdk.openadsdk.k.a
    public void a(String str, List<String> list, boolean z) {
        if (g.a() && s.b(list)) {
            for (String str2 : list) {
                new a(new e(UUID.randomUUID().toString() + "_" + System.currentTimeMillis(), str2, z, 5), str).executeOnExecutor(e.a(), new Void[0]);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.k.a
    public void a(final String str) {
        if (g.a()) {
            e.a(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.k.b.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    final List<e> a2 = b.this.b.a();
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        /* class com.bytedance.sdk.openadsdk.k.b.AnonymousClass1.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.a(a2, str);
                        }
                    });
                }
            }, 1);
        }
    }

    /* access modifiers changed from: private */
    public void a(List<e> list, String str) {
        if (s.b(list)) {
            for (e eVar : list) {
                new a(eVar, str).executeOnExecutor(e.a(), new Void[0]);
            }
        }
    }

    /* compiled from: TrackAdUrlImpl */
    private class a extends AsyncTask<Void, Void, Void> {
        private final e b;
        private final String c;

        private a(e eVar, String str) {
            this.b = eVar;
            this.c = str;
        }

        private String c(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.contains("{TS}") || str.contains("__TS__")) {
                long currentTimeMillis = System.currentTimeMillis();
                str = str.replace("{TS}", String.valueOf(currentTimeMillis)).replace("__TS__", String.valueOf(currentTimeMillis));
            }
            if ((str.contains("{UID}") || str.contains("__UID__")) && !TextUtils.isEmpty(this.c)) {
                str = str.replace("{UID}", this.c).replace("__UID__", this.c);
            }
            String a2 = y.a();
            return ((str.contains("{OAID}") || str.contains("__OAID__")) && !TextUtils.isEmpty(a2)) ? str.replace("{OAID}", a2).replace("__OAID__", a2) : str;
        }

        boolean a(String str) {
            return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
        }

        String b(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                return str.replace("[ss_random]", String.valueOf(new Random().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
            } catch (Exception e) {
                e.printStackTrace();
                return str;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            m mVar;
            if (!g.a() || !a(this.b.b())) {
                return null;
            }
            if (this.b.d() == 0) {
                b.this.b.c(this.b);
                return null;
            }
            while (true) {
                if (this.b.d() <= 0 || isCancelled()) {
                    break;
                }
                try {
                    if (this.b.d() == 5) {
                        b.this.b.a(this.b);
                    }
                    if (!x.a(b.this.b())) {
                        break;
                    }
                    String c2 = c(this.b.b());
                    if (this.b.c()) {
                        c2 = b(c2);
                    }
                    i a2 = i.a();
                    new j(0, c2, a2).setRetryPolicy(d.b().a(10000)).build(d.a(b.this.b()).d());
                    try {
                        mVar = a2.get();
                    } catch (Throwable unused) {
                        mVar = null;
                    }
                    if (mVar == null || !mVar.a()) {
                        if (u.c()) {
                            u.c("trackurl", "track fail : " + this.b.b());
                        }
                        e eVar = this.b;
                        eVar.a(eVar.d() - 1);
                        if (this.b.d() == 0) {
                            b.this.b.c(this.b);
                            if (u.c()) {
                                u.c("trackurl", "track fail and delete : " + this.b.b());
                            }
                        } else {
                            b.this.b.b(this.b);
                        }
                    } else {
                        b.this.b.c(this.b);
                        if (u.c()) {
                            u.c("trackurl", "track success : " + this.b.b());
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
            return null;
        }
    }

    public static a c() {
        return d.b();
    }
}
