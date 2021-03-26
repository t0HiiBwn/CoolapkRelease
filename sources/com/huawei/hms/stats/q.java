package com.huawei.hms.stats;

import android.content.Context;
import android.text.TextUtils;

public class q {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private int h = 5;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private Context o;
    private boolean p = true;
    private String q = "";
    private String r = "";

    public Context a() {
        return this.o;
    }

    public void a(Context context) {
        this.o = context;
    }

    public void a(String str) {
        this.d = str;
    }

    public int b() {
        return this.h;
    }

    public void b(String str) {
        this.n = str;
    }

    public int c() {
        return this.h * 2;
    }

    public void c(String str) {
        this.a = str;
    }

    public String d() {
        return this.d;
    }

    public void d(String str) {
        this.b = str;
    }

    public String e() {
        return this.n;
    }

    public void e(String str) {
        this.c = str;
    }

    public String f() {
        return this.a;
    }

    public void f(String str) {
        this.e = str;
    }

    public String g() {
        return this.b;
    }

    public void g(String str) {
        this.f = str;
    }

    public String h() {
        return this.c;
    }

    public void h(String str) {
        this.g = str;
    }

    public String i() {
        return this.e;
    }

    public void i(String str) {
        this.i = str;
    }

    public String j() {
        return this.f;
    }

    public void j(String str) {
        this.j = str;
    }

    public String k() {
        return TextUtils.isEmpty(this.g) ? this.f : this.g;
    }

    public void k(String str) {
        this.k = str;
    }

    public String l() {
        return this.i;
    }

    public void l(String str) {
        this.l = str;
    }

    public String m() {
        return this.k;
    }

    public void m(String str) {
        this.m = str;
    }

    public String n() {
        return this.l;
    }

    public String o() {
        return this.m;
    }
}
