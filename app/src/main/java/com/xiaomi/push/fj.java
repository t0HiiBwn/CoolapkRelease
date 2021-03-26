package com.xiaomi.push;

import java.util.Map;

public class fj implements Cloneable {
    public static String a = "wcc-ml-test10.bj";
    public static final String b = ae.a;
    public static String c;

    /* renamed from: a  reason: collision with other field name */
    private int f473a;

    /* renamed from: a  reason: collision with other field name */
    private fm f474a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f475a = fi.f458a;

    /* renamed from: b  reason: collision with other field name */
    private boolean f476b = true;
    private String d;
    private String e;
    private String f;

    public fj(Map<String, Integer> map, int i, String str, fm fmVar) {
        a(map, i, str, fmVar);
    }

    public static final String a() {
        String str = c;
        return str != null ? str : ab.m101a() ? "sandbox.xmpush.xiaomi.com" : ab.b() ? b : "app.chat.xiaomi.net";
    }

    public static final void a(String str) {
        c = str;
    }

    private void a(Map<String, Integer> map, int i, String str, fm fmVar) {
        this.f473a = i;
        this.d = str;
        this.f474a = fmVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int mo337a() {
        return this.f473a;
    }

    public void a(boolean z) {
        this.f475a = z;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m338a() {
        return this.f475a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m339a() {
        return null;
    }

    public String b() {
        return this.f;
    }

    public void b(String str) {
        this.f = str;
    }

    public String c() {
        if (this.e == null) {
            this.e = a();
        }
        return this.e;
    }

    public void c(String str) {
        this.e = str;
    }
}
