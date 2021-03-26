package com.tencent.msdk.dns.base.c;

import android.content.Context;
import com.tencent.msdk.dns.base.e.e;
import com.tencent.msdk.dns.base.log.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: AbsNetworkChangeObservable */
abstract class a implements b {
    private volatile int a = -1;
    private final List<c> b = Collections.synchronizedList(new ArrayList());

    a(Context context) {
    }

    @Override // com.tencent.msdk.dns.base.c.b
    public synchronized void a(c cVar) {
        if (cVar != null) {
            this.b.add(cVar);
        }
    }

    void a(Context context) {
        try {
            if (b(context)) {
                a();
            }
        } catch (Exception e) {
            b.b(e, "mayChangeNetwork exception occur", new Object[0]);
        }
    }

    private void a() {
        b.b("changeNetwork call", new Object[0]);
        synchronized (this.b) {
            for (c cVar : this.b) {
                cVar.a();
            }
        }
    }

    private boolean b(Context context) {
        if (context == null) {
            return true;
        }
        int b2 = e.b(context);
        if (this.a == -1) {
            this.a = b2;
            return false;
        } else if (this.a == b2) {
            return false;
        } else {
            this.a = b2;
            return true;
        }
    }
}
