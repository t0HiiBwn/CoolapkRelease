package com.bytedance.sdk.openadsdk.e.a;

import android.net.Uri;
import com.bytedance.sdk.openadsdk.e.a.k;
import com.bytedance.sdk.openadsdk.e.a.u;
import com.bytedance.sdk.openadsdk.e.a.v;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: PermissionChecker */
class t {
    private final Set<String> a;
    private final Set<String> b;
    private final v c = q.a;
    private final u d;
    private k.b e;

    t(u uVar, Set<String> set, Set<String> set2) {
        this.d = uVar;
        this.a = new LinkedHashSet(set);
        this.b = new LinkedHashSet(set2);
    }

    final synchronized w a(boolean z, String str, b bVar) throws u.a {
        w wVar;
        k.b bVar2;
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        if (host == null) {
            return null;
        }
        w wVar2 = this.b.contains(bVar.a()) ? w.PUBLIC : null;
        Iterator<String> it2 = this.a.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            String next = it2.next();
            if (parse.getHost().equals(next)) {
                break;
            }
            if (host.endsWith("." + next)) {
                break;
            }
        }
        wVar2 = w.PRIVATE;
        if (wVar2 == null && (bVar2 = this.e) != null && bVar2.a(str)) {
            if (this.e.a(str, bVar.a())) {
                return null;
            }
            wVar2 = w.PRIVATE;
        }
        if (z) {
            wVar = a(str, bVar);
        } else {
            wVar = b(str, bVar);
        }
        if (wVar != null) {
            return wVar;
        }
        return wVar2;
    }

    final synchronized w a(String str, b bVar) throws u.a {
        return a(str, bVar, true);
    }

    final synchronized w b(String str, b bVar) {
        return a(str, bVar, false);
    }

    void a(k.b bVar) {
        this.e = bVar;
    }

    void a(v.a aVar) {
        v vVar = this.c;
        if (vVar != null) {
            vVar.a(aVar);
        }
    }

    private w a(String str, b bVar, boolean z) {
        u uVar;
        if (!z || (uVar = this.d) == null) {
            return null;
        }
        u.c a2 = uVar.a(str, this.a);
        if (a2.c.contains(bVar.a())) {
            return null;
        }
        if (a2.b.contains(bVar.a())) {
            return w.PRIVATE;
        }
        if (a2.a.compareTo(bVar.b()) < 0) {
            return null;
        }
        return a2.a;
    }
}
