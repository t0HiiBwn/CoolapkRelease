package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;

public class ba {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public String f221a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f222a = new HashMap();

    public String a() {
        return this.f221a;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.a), this.f222a.toString(), this.f221a);
    }
}
