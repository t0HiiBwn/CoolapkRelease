package com.bytedance.sdk.openadsdk.preload.geckox.j;

import android.util.Pair;
import com.bytedance.sdk.openadsdk.preload.b.b;
import com.bytedance.sdk.openadsdk.preload.b.h;
import com.bytedance.sdk.openadsdk.preload.b.l;
import com.bytedance.sdk.openadsdk.preload.geckox.d.a.b.d;
import com.bytedance.sdk.openadsdk.preload.geckox.d.c;
import com.bytedance.sdk.openadsdk.preload.geckox.d.e;
import com.bytedance.sdk.openadsdk.preload.geckox.d.f;
import com.bytedance.sdk.openadsdk.preload.geckox.d.g;
import com.bytedance.sdk.openadsdk.preload.geckox.d.i;
import com.bytedance.sdk.openadsdk.preload.geckox.model.CheckRequestBodyModel;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GeckoPipeline */
public class a {
    public static b<Object> a(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar, File file, com.bytedance.sdk.openadsdk.preload.geckox.b bVar, com.bytedance.sdk.openadsdk.preload.geckox.e.b bVar2, Map<String, Map<String, Object>> map, Map<String, List<CheckRequestBodyModel.TargetChannel>> map2, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(h.a.a().a(e.class).a(file, bVar.d()).a(bVar2.a(e.class)).b());
        arrayList.add(h.a.a().a(c.class).a(bVar, map, map2, aVar, str).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(f(aVar), bVar2.a(c.class))).b());
        arrayList.add(h.a.a().a(f.class).a(bVar.f()).a(a(aVar)).b());
        l.b bVar3 = new l.b();
        bVar3.a("branch_zip").a(d(aVar, file, bVar, bVar2)).a(h.a.a().a(com.bytedance.sdk.openadsdk.preload.b.f.class).b());
        bVar3.a("branch_single_file").a(a(aVar, file, bVar, bVar2)).a(h.a.a().a(com.bytedance.sdk.openadsdk.preload.b.f.class).b());
        bVar3.a("branch_myarchive_file").a(g(aVar, file, bVar, bVar2)).a(h.a.a().a(com.bytedance.sdk.openadsdk.preload.b.f.class).b());
        arrayList.add(bVar3.a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.class));
        arrayList.add(h.a.a().a(i.class).a(b(aVar)).b());
        return com.bytedance.sdk.openadsdk.preload.b.c.a(arrayList, null);
    }

    private static h a(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar, File file, com.bytedance.sdk.openadsdk.preload.geckox.b bVar, com.bytedance.sdk.openadsdk.preload.geckox.e.b bVar2) {
        l.b bVar3 = new l.b();
        bVar3.a("patch").a(c(aVar, file, bVar, bVar2));
        bVar3.a("full").a(b(aVar, file, bVar, bVar2));
        return bVar3.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.class);
    }

    private static List<h> b(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar, File file, com.bytedance.sdk.openadsdk.preload.geckox.b bVar, com.bytedance.sdk.openadsdk.preload.geckox.e.b bVar2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(h.a.a().a(g.class).b());
        arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.a.b.class).a(bVar, file).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(e(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.a.b.class))).b());
        arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.a.a.class).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(d(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.a.a.class))).b());
        arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.a.c.class).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(c(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.a.c.class))).b());
        return arrayList;
    }

    private static List<h> c(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar, File file, com.bytedance.sdk.openadsdk.preload.geckox.b bVar, com.bytedance.sdk.openadsdk.preload.geckox.e.b bVar2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.h.class).b());
        arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.b.c.class).a(bVar, file).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(e(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.b.c.class))).b());
        arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.b.b.class).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(d(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.b.b.class))).b());
        arrayList.add(h.a.a().a(d.class).a(bVar).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(d(aVar), bVar2.a(d.class))).b());
        arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.b.a.class).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(d(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.b.a.class))).b());
        arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.b.e.class).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(c(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.b.e.class))).b());
        return arrayList;
    }

    private static h d(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar, File file, com.bytedance.sdk.openadsdk.preload.geckox.b bVar, com.bytedance.sdk.openadsdk.preload.geckox.e.b bVar2) {
        l.b bVar3 = new l.b();
        bVar3.a("patch").a(f(aVar, file, bVar, bVar2));
        bVar3.a("full").a(e(aVar, file, bVar, bVar2));
        return bVar3.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.class);
    }

    private static List<h> e(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar, File file, com.bytedance.sdk.openadsdk.preload.geckox.b bVar, com.bytedance.sdk.openadsdk.preload.geckox.e.b bVar2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(h.a.a().a(g.class).b());
        arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.a.b.class).a(bVar, file).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(e(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.a.b.class))).b());
        arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.a.a.class).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(d(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.a.a.class))).b());
        arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.a.d.class).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(d(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.a.d.class))).b());
        arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.a.c.class).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(c(aVar))).b());
        return arrayList;
    }

    private static List<h> f(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar, File file, com.bytedance.sdk.openadsdk.preload.geckox.b bVar, com.bytedance.sdk.openadsdk.preload.geckox.e.b bVar2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.h.class).b());
        arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.b.c.class).a(bVar, file).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(e(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.b.c.class))).b());
        arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.b.b.class).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(d(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.b.b.class))).b());
        arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.b.d.class).a(bVar).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(d(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.b.d.class))).b());
        arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.b.a.class).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(d(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.b.a.class))).b());
        arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.b.f.class).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(d(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.b.f.class))).b());
        arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.b.e.class).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(c(aVar))).b());
        return arrayList;
    }

    private static h g(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar, File file, com.bytedance.sdk.openadsdk.preload.geckox.b bVar, com.bytedance.sdk.openadsdk.preload.geckox.e.b bVar2) {
        l.b bVar3 = new l.b();
        bVar3.a("patch").a(b(aVar, file, bVar));
        bVar3.a("full").a(a(aVar, file, bVar));
        return bVar3.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.class);
    }

    private static List<h> a(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar, File file, com.bytedance.sdk.openadsdk.preload.geckox.b bVar) {
        return Collections.emptyList();
    }

    private static List<h> b(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar, File file, com.bytedance.sdk.openadsdk.preload.geckox.b bVar) {
        return Collections.emptyList();
    }

    private static com.bytedance.sdk.openadsdk.preload.b.b.a a(final com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.preload.b.b.a() {
            /* class com.bytedance.sdk.openadsdk.preload.geckox.j.a.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                aVar.a(((UpdatePackage) bVar.b(f.class)).getChannel(), th);
            }
        };
    }

    private static com.bytedance.sdk.openadsdk.preload.b.b.a b(final com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.preload.b.b.a() {
            /* class com.bytedance.sdk.openadsdk.preload.geckox.j.a.AnonymousClass2 */

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.a(bVar, dVar);
                Pair pair = (Pair) bVar.a(i.class);
                aVar.a((String) pair.first, ((Long) pair.second).longValue());
            }
        };
    }

    private static com.bytedance.sdk.openadsdk.preload.b.b.a c(final com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.preload.b.b.a() {
            /* class com.bytedance.sdk.openadsdk.preload.geckox.j.a.AnonymousClass3 */

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.b(bVar, dVar);
                aVar.b((UpdatePackage) bVar.b(com.bytedance.sdk.openadsdk.preload.geckox.d.b.class));
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                aVar.a((UpdatePackage) bVar.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.class), th);
            }
        };
    }

    private static com.bytedance.sdk.openadsdk.preload.b.b.a d(final com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.preload.b.b.a() {
            /* class com.bytedance.sdk.openadsdk.preload.geckox.j.a.AnonymousClass4 */

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                aVar.a((UpdatePackage) bVar.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.class), th);
            }
        };
    }

    private static com.bytedance.sdk.openadsdk.preload.b.b.a e(final com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.preload.b.b.a() {
            /* class com.bytedance.sdk.openadsdk.preload.geckox.j.a.AnonymousClass5 */

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void c(b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.c(bVar, dVar);
                aVar.a((UpdatePackage) bVar.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.class));
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.b(bVar, dVar);
                aVar.c((UpdatePackage) bVar.b(com.bytedance.sdk.openadsdk.preload.geckox.d.b.class));
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                aVar.b((UpdatePackage) bVar.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.class), th);
            }
        };
    }

    private static com.bytedance.sdk.openadsdk.preload.b.b.a f(final com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.preload.b.b.a() {
            /* class com.bytedance.sdk.openadsdk.preload.geckox.j.a.AnonymousClass6 */

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                super.b(bVar, dVar);
                Map<String, List<Pair<String, Long>>> map = (Map) bVar.a(c.class);
                HashMap hashMap = new HashMap();
                for (UpdatePackage updatePackage : (List) bVar.b(c.class)) {
                    String accessKey = updatePackage.getAccessKey();
                    List list = (List) hashMap.get(accessKey);
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(updatePackage);
                    hashMap.put(accessKey, list);
                }
                aVar.a(map, hashMap);
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                aVar.a((Map) bVar.a(c.class), th);
            }
        };
    }
}
