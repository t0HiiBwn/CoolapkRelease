package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.a.f;

/* compiled from: Header */
public final class c {
    public static final f a = f.a(":");
    public static final f b = f.a(":status");
    public static final f c = f.a(":method");
    public static final f d = f.a(":path");
    public static final f e = f.a(":scheme");
    public static final f f = f.a(":authority");
    public final f g;
    public final f h;
    final int i;

    public c(String str, String str2) {
        this(f.a(str), f.a(str2));
    }

    public c(f fVar, String str) {
        this(fVar, f.a(str));
    }

    public c(f fVar, f fVar2) {
        this.g = fVar;
        this.h = fVar2;
        this.i = fVar.g() + 32 + fVar2.g();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!this.g.equals(cVar.g) || !this.h.equals(cVar.h)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((527 + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public String toString() {
        return com.bytedance.sdk.a.b.a.c.a("%s: %s", this.g.a(), this.h.a());
    }
}
