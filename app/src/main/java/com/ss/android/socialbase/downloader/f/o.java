package com.ss.android.socialbase.downloader.f;

import java.util.Iterator;
import java.util.List;

/* compiled from: SegmentUtils */
public class o {
    public static long a(List<i> list) {
        int size = list.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            i iVar = list.get(i);
            if (iVar.c() > j) {
                break;
            }
            if (iVar.e() > j) {
                j = iVar.e();
            }
        }
        return j;
    }

    public static long b(List<i> list) {
        long j;
        long j2;
        Iterator<i> it2 = list.iterator();
        long j3 = 0;
        loop0:
        while (true) {
            j = -1;
            j2 = -1;
            while (true) {
                if (!it2.hasNext()) {
                    break loop0;
                }
                i next = it2.next();
                if (j == -1) {
                    if (next.a() > 0) {
                        j = next.c();
                        j2 = next.d();
                    }
                } else if (next.c() > j2) {
                    j3 += j2 - j;
                    if (next.a() > 0) {
                        j = next.c();
                        j2 = next.d();
                    }
                } else if (next.d() > j2) {
                    j2 = next.d();
                }
            }
        }
        return (j < 0 || j2 <= j) ? j3 : j3 + (j2 - j);
    }
}
