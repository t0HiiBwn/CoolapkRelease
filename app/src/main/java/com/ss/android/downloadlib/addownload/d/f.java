package com.ss.android.downloadlib.addownload.d;

import android.content.Context;
import com.ss.android.downloadad.a.b.b;
import com.ss.android.downloadlib.g;
import com.ss.android.socialbase.downloader.g.a;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PauseInterceptorManager */
public class f {
    private static f a;
    private List<d> b;

    public static f a() {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f();
                }
            }
        }
        return a;
    }

    private f() {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.add(new e());
        this.b.add(new g());
        this.b.add(new b());
        this.b.add(new a());
    }

    public void a(b bVar, int i, c cVar) {
        List<d> list = this.b;
        if (list == null || list.size() == 0 || bVar == null) {
            cVar.a(bVar);
            return;
        }
        DownloadInfo a2 = g.a((Context) null).a(bVar.a());
        if (a2 == null || !"application/vnd.android.package-archive".equals(a2.getMimeType())) {
            cVar.a(bVar);
            return;
        }
        boolean z = false;
        if (a.a(bVar.s()).a("pause_optimise_switch", 0) == 1) {
            z = true;
        }
        for (d dVar : this.b) {
            if ((z || (dVar instanceof g)) && dVar.a(bVar, i, cVar)) {
                return;
            }
        }
        cVar.a(bVar);
    }
}
