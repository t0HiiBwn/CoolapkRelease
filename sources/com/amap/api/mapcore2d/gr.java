package com.amap.api.mapcore2d;

import android.content.Context;
import java.util.Map;

/* compiled from: LocationRequest */
public final class gr extends es {
    Map<String, String> f = null;
    String g = "";
    byte[] h = null;
    byte[] i = null;
    boolean j = false;
    String k = null;

    /* renamed from: l  reason: collision with root package name */
    Map<String, String> f1238l = null;
    boolean m = false;
    private String n = "";

    public gr(Context context, da daVar) {
        super(context, daVar);
    }

    public final void a(String str) {
        this.k = str;
    }

    public final void a(Map<String, String> map) {
        this.f1238l = map;
    }

    public final void b(String str) {
        this.g = str;
    }

    public final void b(Map<String, String> map) {
        this.f = map;
    }

    public final void b(byte[] bArr) {
        this.h = bArr;
    }

    @Override // com.amap.api.mapcore2d.es
    public final byte[] b() {
        return this.h;
    }

    @Override // com.amap.api.mapcore2d.es
    public final byte[] c() {
        return this.i;
    }

    @Override // com.amap.api.mapcore2d.es
    public final boolean e() {
        return this.j;
    }

    @Override // com.amap.api.mapcore2d.ew
    public final Map<String, String> f() {
        return this.f;
    }

    @Override // com.amap.api.mapcore2d.es, com.amap.api.mapcore2d.ew
    public final Map<String, String> g() {
        return this.f1238l;
    }

    @Override // com.amap.api.mapcore2d.ew
    public final String h() {
        return this.g;
    }

    @Override // com.amap.api.mapcore2d.es
    public final String j() {
        return this.k;
    }

    @Override // com.amap.api.mapcore2d.es
    protected final boolean k() {
        return this.m;
    }

    @Override // com.amap.api.mapcore2d.ew
    protected final String m() {
        return this.n;
    }

    public final void q() {
        this.j = true;
    }

    public final void r() {
        this.m = true;
    }
}
