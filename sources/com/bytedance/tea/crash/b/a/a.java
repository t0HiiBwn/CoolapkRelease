package com.bytedance.tea.crash.b.a;

/* compiled from: DuplicateLog */
public class a {
    public String a;
    public long b;

    public static a a(String str) {
        a aVar = new a();
        aVar.a = str;
        aVar.b = System.currentTimeMillis();
        return aVar;
    }
}
