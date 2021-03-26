package com.ss.android.socialbase.downloader.f;

import android.util.Log;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Segment */
public final class i {
    volatile m a;
    int b;
    private final long c;
    private final AtomicLong d;
    private volatile long e;
    private long f;
    private int g;

    public i(long j, long j2) {
        AtomicLong atomicLong = new AtomicLong();
        this.d = atomicLong;
        this.b = 0;
        this.c = j;
        atomicLong.set(j);
        this.e = j;
        if (j2 >= j) {
            this.f = j2;
        } else {
            this.f = -1;
        }
    }

    public i(i iVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.d = atomicLong;
        this.b = 0;
        this.c = iVar.c;
        atomicLong.set(iVar.d.get());
        this.e = atomicLong.get();
        this.f = iVar.f;
        this.g = iVar.g;
    }

    public i(JSONObject jSONObject) {
        this.d = new AtomicLong();
        this.b = 0;
        this.c = jSONObject.optLong("st");
        c(jSONObject.optLong("en"));
        a(jSONObject.optLong("cu"));
        d(d());
    }

    public long a() {
        return this.d.get() - this.c;
    }

    public long b() {
        long j = this.f;
        if (j >= this.c) {
            return (j - e()) + 1;
        }
        return -1;
    }

    public long c() {
        return this.c;
    }

    public long d() {
        return this.d.get();
    }

    public long e() {
        m mVar = this.a;
        if (mVar != null) {
            long d2 = mVar.d();
            if (d2 > this.e) {
                return d2;
            }
        }
        return this.e;
    }

    public void a(long j) {
        if (j >= this.c) {
            this.d.set(j);
        }
    }

    void b(long j) {
        this.d.addAndGet(j);
    }

    public long f() {
        return this.f;
    }

    void c(long j) {
        if (j >= this.c) {
            this.f = j;
            return;
        }
        Log.w("Segment", "setEndOffset: endOffset = " + j + ", segment = " + this);
        if (j == -1) {
            this.f = j;
        }
    }

    public void d(long j) {
        if (j >= this.d.get()) {
            this.e = j;
        }
    }

    public int g() {
        return this.g;
    }

    void a(int i) {
        this.g = i;
    }

    void h() {
        this.b++;
    }

    void i() {
        this.b--;
    }

    int j() {
        return this.b;
    }

    void b(int i) {
        this.b = i;
    }

    public String toString() {
        return "Segment{startOffset=" + this.c + ",\t currentOffset=" + this.d + ",\t currentOffsetRead=" + e() + ",\t endOffset=" + this.f + '}';
    }

    public JSONObject k() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("st", c());
        jSONObject.put("cu", d());
        jSONObject.put("en", f());
        return jSONObject;
    }
}
