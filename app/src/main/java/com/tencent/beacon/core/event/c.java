package com.tencent.beacon.core.event;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Event */
public final class c {
    public String a;
    public boolean b;
    public long c;
    public long d;
    public Map<String, String> e;
    public boolean f;
    public String g;

    public c(String str, String str2, boolean z, long j, long j2, Map<String, String> map, boolean z2) {
        this.a = str2;
        this.b = z;
        this.c = j;
        this.d = j2;
        if (map != null) {
            HashMap hashMap = new HashMap();
            this.e = hashMap;
            hashMap.putAll(map);
        }
        this.f = z2;
        this.g = str;
    }
}
