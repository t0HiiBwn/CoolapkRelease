package com.tencent.msdk.dns.base.report;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ReporterFactory */
final class f {
    private static final SparseArray<IReporter> a;

    static {
        SparseArray<IReporter> sparseArray = new SparseArray<>(2);
        a = sparseArray;
        b bVar = new b();
        if (bVar.canReport()) {
            sparseArray.put(1, bVar);
        }
        if (new d().canReport()) {
            sparseArray.put(2, new d());
        }
    }

    static List<IReporter> a(int i) {
        ArrayList arrayList = null;
        int i2 = 0;
        while (true) {
            SparseArray<IReporter> sparseArray = a;
            if (i2 >= sparseArray.size()) {
                break;
            }
            int keyAt = sparseArray.keyAt(i2);
            if ((keyAt & i) != 0) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(sparseArray.get(keyAt));
            }
            i2++;
        }
        return arrayList != null ? arrayList : Collections.emptyList();
    }

    static IReporter b(int i) {
        int i2 = 0;
        while (true) {
            SparseArray<IReporter> sparseArray = a;
            if (i2 >= sparseArray.size()) {
                return null;
            }
            int keyAt = sparseArray.keyAt(i2);
            if (keyAt == i) {
                return sparseArray.get(keyAt);
            }
            i2++;
        }
    }
}
