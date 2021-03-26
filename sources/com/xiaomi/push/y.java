package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;

public class y {
    public int a;
    public Map<String, String> b = new HashMap();
    public String c;

    public String a() {
        return this.c;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.a), this.b.toString(), this.c);
    }
}
