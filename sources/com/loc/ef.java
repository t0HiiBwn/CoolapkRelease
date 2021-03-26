package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

/* compiled from: LocationRequest */
public final class ef extends ar {
    Map<String, String> f = null;
    String g = "";
    String h = "";
    byte[] i = null;
    byte[] j = null;
    boolean k = false;

    /* renamed from: l  reason: collision with root package name */
    String f1373l = null;
    Map<String, String> m = null;
    boolean n = false;
    private String o = "";

    public ef(Context context, t tVar) {
        super(context, tVar);
    }

    public final void a(String str) {
        this.g = str;
    }

    @Override // com.loc.ar
    public final byte[] a_() {
        return this.i;
    }

    @Override // com.loc.av
    public final Map<String, String> b() {
        return this.f;
    }

    public final void b(String str) {
        this.h = str;
    }

    @Override // com.loc.ar, com.loc.av
    public final Map<String, String> b_() {
        return this.m;
    }

    @Override // com.loc.av
    public final String c() {
        return this.g;
    }

    public final void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.o = str;
        } else {
            this.o = "";
        }
    }

    @Override // com.loc.q, com.loc.av
    public final String d() {
        return this.h;
    }

    @Override // com.loc.ar
    public final byte[] f() {
        return this.j;
    }

    @Override // com.loc.av
    public final String h() {
        return this.o;
    }

    @Override // com.loc.ar
    public final boolean j() {
        return this.k;
    }

    @Override // com.loc.ar
    public final String k() {
        return this.f1373l;
    }

    @Override // com.loc.ar
    protected final boolean l() {
        return this.n;
    }

    @Override // com.loc.av
    public final String p() {
        return "loc";
    }
}
