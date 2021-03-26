package com.tencent.msdk.dns.core.rest.share;

import com.tencent.msdk.dns.core.LookupResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/* compiled from: AsyncLookupResultQueue */
public final class c {
    private static final List<LookupResult> a = new Vector();

    public static void a(LookupResult lookupResult) {
        a.add(lookupResult);
    }

    public static List<LookupResult> a() {
        List<LookupResult> list;
        List<LookupResult> list2 = a;
        synchronized (list2) {
            if (list2.isEmpty()) {
                list = Collections.emptyList();
            } else {
                list = new ArrayList<>(list2);
                list2.clear();
            }
        }
        return list;
    }
}
