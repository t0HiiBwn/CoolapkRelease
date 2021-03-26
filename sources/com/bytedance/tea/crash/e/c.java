package com.bytedance.tea.crash.e;

import com.bytedance.tea.crash.e.i;
import com.bytedance.tea.crash.g.d;

/* compiled from: CpuInfo */
public class c {
    public static long a(int i) {
        String[] d = d.d("/proc/self/task/" + i + "/stat");
        if (d == null) {
            return -1;
        }
        return (Long.parseLong(d[11]) * i.a.a()) + (Long.parseLong(d[12]) * i.a.a());
    }
}
