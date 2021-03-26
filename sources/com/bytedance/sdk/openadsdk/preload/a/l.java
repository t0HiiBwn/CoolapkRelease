package com.bytedance.sdk.openadsdk.preload.a;

import com.bytedance.sdk.openadsdk.preload.a.d.c;
import java.io.IOException;
import java.io.StringWriter;

/* compiled from: JsonElement */
public abstract class l {
    public boolean g() {
        return this instanceof i;
    }

    public boolean h() {
        return this instanceof o;
    }

    public boolean i() {
        return this instanceof q;
    }

    public boolean j() {
        return this instanceof n;
    }

    public o k() {
        if (h()) {
            return (o) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public i l() {
        if (g()) {
            return (i) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public q m() {
        if (i()) {
            return (q) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public boolean f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            c cVar = new c(stringWriter);
            cVar.b(true);
            com.bytedance.sdk.openadsdk.preload.a.b.l.a(this, cVar);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
