package com.tencent.msdk.dns.base.log;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Log */
final class c {
    private static final List<ILogNode> a;

    static {
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.add(new a());
    }

    static synchronized void a(ILogNode iLogNode) {
        synchronized (c.class) {
            if (iLogNode != null) {
                a.add(iLogNode);
            }
        }
    }

    static void a(int i, String str, String str2, Throwable th) {
        for (ILogNode iLogNode : a) {
            iLogNode.println(i, str, str2, th);
        }
    }
}
