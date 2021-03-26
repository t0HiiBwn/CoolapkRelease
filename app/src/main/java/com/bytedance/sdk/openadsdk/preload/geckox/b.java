package com.bytedance.sdk.openadsdk.preload.geckox;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: GeckoConfig */
public class b {
    private final Context a;
    private final Executor b;
    private final Executor c;
    private final com.bytedance.sdk.openadsdk.preload.geckox.k.a d;
    private final com.bytedance.sdk.openadsdk.preload.geckox.statistic.a e;
    private final com.bytedance.sdk.openadsdk.preload.geckox.i.b f;
    private final List<String> g;
    private final List<String> h;
    private final com.bytedance.sdk.openadsdk.preload.geckox.a.a.a i;
    private final Long j;
    private final String k;

    /* renamed from: l  reason: collision with root package name */
    private final String f1340l;
    private final String m;
    private final String n;
    private final String o;
    private final File p;
    private final boolean q;

    private b(a aVar) {
        Context context = aVar.d;
        this.a = context;
        if (context != null) {
            List<String> list = aVar.b;
            this.g = list;
            this.h = aVar.c;
            this.d = aVar.g;
            this.i = aVar.j;
            Long l2 = aVar.k;
            this.j = l2;
            if (TextUtils.isEmpty(aVar.f1341l)) {
                this.k = com.bytedance.sdk.openadsdk.preload.geckox.utils.a.a(context);
            } else {
                this.k = aVar.f1341l;
            }
            String str = aVar.m;
            this.f1340l = str;
            this.n = aVar.p;
            this.o = aVar.q;
            if (aVar.o == null) {
                this.p = new File(context.getFilesDir(), "gecko_offline_res_x");
            } else {
                this.p = aVar.o;
            }
            String str2 = aVar.n;
            this.m = str2;
            if (TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("host == null");
            } else if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("access key empty");
            } else if (l2 == null) {
                throw new IllegalArgumentException("appId == null");
            } else if (!TextUtils.isEmpty(str)) {
                if (aVar.e == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
                        /* class com.bytedance.sdk.openadsdk.preload.geckox.b.AnonymousClass1 */

                        @Override // java.util.concurrent.ThreadFactory
                        public Thread newThread(Runnable runnable) {
                            Thread thread = new Thread(runnable);
                            thread.setName("tt_pangle_thread_gecko_update");
                            thread.setPriority(3);
                            return thread;
                        }
                    });
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.b = threadPoolExecutor;
                } else {
                    this.b = aVar.e;
                }
                if (aVar.f == null) {
                    ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
                        /* class com.bytedance.sdk.openadsdk.preload.geckox.b.AnonymousClass2 */

                        @Override // java.util.concurrent.ThreadFactory
                        public Thread newThread(Runnable runnable) {
                            Thread thread = new Thread(runnable);
                            thread.setName("tt_pangle_thread_gecko_check_update");
                            thread.setPriority(3);
                            return thread;
                        }
                    });
                    threadPoolExecutor2.allowCoreThreadTimeOut(true);
                    this.c = threadPoolExecutor2;
                } else {
                    this.c = aVar.f;
                }
                if (aVar.a == null) {
                    this.f = new com.bytedance.sdk.openadsdk.preload.geckox.i.a();
                } else {
                    this.f = aVar.a;
                }
                this.e = aVar.h;
                this.q = aVar.i;
            } else {
                throw new IllegalArgumentException("deviceId key empty");
            }
        } else {
            throw new IllegalArgumentException("context == null");
        }
    }

    public Context a() {
        return this.a;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.a.a.a b() {
        return this.i;
    }

    public boolean c() {
        return this.q;
    }

    public List<String> d() {
        return this.h;
    }

    public List<String> e() {
        return this.g;
    }

    public Executor f() {
        return this.b;
    }

    public Executor g() {
        return this.c;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.i.b h() {
        return this.f;
    }

    public String i() {
        return this.m;
    }

    public long j() {
        return this.j.longValue();
    }

    public String k() {
        return this.o;
    }

    public String l() {
        return this.n;
    }

    public File m() {
        return this.p;
    }

    public String n() {
        return this.k;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.k.a o() {
        return this.d;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.statistic.a p() {
        return this.e;
    }

    public String q() {
        return this.f1340l;
    }

    /* compiled from: GeckoConfig */
    public static class a {
        private com.bytedance.sdk.openadsdk.preload.geckox.i.b a;
        private List<String> b;
        private List<String> c;
        private Context d;
        private Executor e;
        private Executor f;
        private com.bytedance.sdk.openadsdk.preload.geckox.k.a g;
        private com.bytedance.sdk.openadsdk.preload.geckox.statistic.a h;
        private boolean i = true;
        private com.bytedance.sdk.openadsdk.preload.geckox.a.a.a j;
        private Long k;

        /* renamed from: l  reason: collision with root package name */
        private String f1341l;
        private String m;
        private String n;
        private File o;
        private String p;
        private String q;

        public a(Context context) {
            this.d = context.getApplicationContext();
        }

        public a a(String... strArr) {
            if (strArr != null && strArr.length >= 1) {
                this.c = Arrays.asList(strArr);
            }
            return this;
        }

        public a b(String... strArr) {
            if (strArr != null && strArr.length >= 1) {
                this.b = Arrays.asList(strArr);
            }
            return this;
        }

        public a a(com.bytedance.sdk.openadsdk.preload.geckox.statistic.a aVar) {
            this.h = aVar;
            return this;
        }

        public a a(boolean z) {
            this.i = z;
            return this;
        }

        public a a(Executor executor) {
            this.e = executor;
            return this;
        }

        public a b(Executor executor) {
            this.f = executor;
            return this;
        }

        public a a(com.bytedance.sdk.openadsdk.preload.geckox.a.a.a aVar) {
            this.j = aVar;
            return this;
        }

        public a a(long j2) {
            this.k = Long.valueOf(j2);
            return this;
        }

        public a a(String str) {
            this.f1341l = str;
            return this;
        }

        public a b(String str) {
            this.m = str;
            return this;
        }

        public a c(String str) {
            this.n = str;
            return this;
        }

        public a a(File file) {
            this.o = file;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }
}
