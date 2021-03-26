package com.bytedance.sdk.openadsdk.preload.geckox.statistic;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.preload.b.b.a;
import com.bytedance.sdk.openadsdk.preload.geckox.b;
import com.bytedance.sdk.openadsdk.preload.geckox.d.g;
import com.bytedance.sdk.openadsdk.preload.geckox.d.h;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.StatisticModel;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.i;

/* compiled from: UpdateListeners */
class d {
    static a a(final b bVar) {
        return new a() {
            /* class com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.a(bVar, dVar);
                e.a(bVar, b.a(dVar.c()));
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                e.a(bVar, b.a(dVar.c()));
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.b(bVar, dVar, th);
                e.a(bVar, b.a(dVar.c()));
            }
        };
    }

    static a a(final Context context) {
        return new a() {
            /* class com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.AnonymousClass4 */

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void c(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.c(bVar, dVar);
                Pair pair = (Pair) bVar.b(g.class);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) pair.second).getChannel());
                a2.v = ((Uri) pair.first).toString();
                a2.p = i.a(context);
                a2.x = SystemClock.uptimeMillis();
                a2.r = Long.valueOf(((UpdatePackage) pair.second).getFullPackage().getId());
                a2.c = ((UpdatePackage) pair.second).getChannel();
                if (!TextUtils.isEmpty(((UpdatePackage) pair.second).getAccessKey())) {
                    a2.a = ((UpdatePackage) pair.second).getAccessKey();
                }
                if (!TextUtils.isEmpty(((UpdatePackage) pair.second).getGroupName())) {
                    a2.b = ((UpdatePackage) pair.second).getGroupName();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.b(bVar, dVar);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a2.B = true;
                a2.y = SystemClock.uptimeMillis();
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                Pair pair = (Pair) bVar.b(g.class);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) pair.second).getChannel());
                String uri = ((Uri) pair.first).toString();
                a2.B = false;
                a2.y = SystemClock.uptimeMillis();
                a2.w.add(new StatisticModel.PackageStatisticModel.DownloadFailRecords(uri, th.getMessage()));
            }
        };
    }

    static a b(final Context context) {
        return new a() {
            /* class com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.AnonymousClass5 */

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void c(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.c(bVar, dVar);
                Pair pair = (Pair) bVar.b(h.class);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) pair.second).getChannel());
                a2.d = ((Uri) pair.first).toString();
                a2.p = i.a(context);
                a2.f = SystemClock.uptimeMillis();
                a2.q = Long.valueOf(((UpdatePackage) pair.second).getPatch().getId());
                a2.r = Long.valueOf(((UpdatePackage) pair.second).getFullPackage().getId());
                a2.c = ((UpdatePackage) pair.second).getChannel();
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.b(bVar, dVar);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a2.h = true;
                a2.g = SystemClock.uptimeMillis();
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                Pair pair = (Pair) bVar.b(h.class);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) pair.second).getChannel());
                String uri = ((Uri) pair.first).toString();
                a2.h = false;
                a2.g = SystemClock.uptimeMillis();
                a2.e.add(new StatisticModel.PackageStatisticModel.DownloadFailRecords(uri, th.getMessage()));
            }
        };
    }

    static a a() {
        return new a() {
            /* class com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.AnonymousClass6 */

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.b(bVar, dVar);
                b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel()).i = true;
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a.i = false;
                a.f1342l = SystemClock.uptimeMillis();
                a.s = th.getMessage();
            }
        };
    }

    static a b() {
        return new a() {
            /* class com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.AnonymousClass7 */

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.b(bVar, dVar);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a.j = true;
                a.m = SystemClock.uptimeMillis();
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a.j = false;
                a.m = SystemClock.uptimeMillis();
                a.t = th.getMessage();
            }
        };
    }

    static a c() {
        return new a() {
            /* class com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.AnonymousClass8 */

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.b(bVar, dVar);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a.j = true;
                a.n = SystemClock.uptimeMillis();
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a.j = false;
                a.n = SystemClock.uptimeMillis();
                a.t = th.getMessage();
            }
        };
    }

    static a d() {
        return new a() {
            /* class com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.AnonymousClass9 */

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.b(bVar, dVar);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a.C = true;
                a.z = SystemClock.uptimeMillis();
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a.C = false;
                a.z = SystemClock.uptimeMillis();
                a.E = th.getMessage();
            }
        };
    }

    static a e() {
        return new a() {
            /* class com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.AnonymousClass10 */

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.b(bVar, dVar);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a.D = true;
                a.A = SystemClock.uptimeMillis();
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a.D = false;
                a.A = SystemClock.uptimeMillis();
                a.F = th.getMessage();
            }
        };
    }

    static a f() {
        return new a() {
            /* class com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.AnonymousClass11 */

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.b(bVar, dVar);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a.k = true;
                a.o = SystemClock.uptimeMillis();
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a.k = false;
                a.u = th.getMessage();
                a.o = SystemClock.uptimeMillis();
            }
        };
    }

    static a g() {
        return new a() {
            /* class com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.AnonymousClass2 */

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a.D = false;
                a.A = SystemClock.uptimeMillis();
                a.F = th.getMessage();
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.b(bVar, dVar, th);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a.D = false;
                a.A = SystemClock.uptimeMillis();
                a.F = th.getMessage();
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.a(bVar, dVar);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a.D = true;
                a.A = SystemClock.uptimeMillis();
            }
        };
    }

    static a h() {
        return new a() {
            /* class com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.AnonymousClass3 */

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.b(bVar, dVar);
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a.k = false;
                a.o = SystemClock.uptimeMillis();
                a.u = th.getMessage();
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.b(bVar, dVar, th);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a.k = false;
                a.o = SystemClock.uptimeMillis();
                a.F = th.getMessage();
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.a(bVar, dVar);
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                a.k = true;
                a.o = SystemClock.uptimeMillis();
            }
        };
    }
}
