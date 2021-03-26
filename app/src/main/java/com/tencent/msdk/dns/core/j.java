package com.tencent.msdk.dns.core;

import com.tencent.msdk.dns.base.e.d;
import com.tencent.msdk.dns.core.b;
import com.tencent.msdk.dns.core.f;
import com.tencent.msdk.dns.core.f.a;
import java.nio.channels.Selector;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/* compiled from: LookupContext */
public final class j<LookupExtra extends f.a> {
    private final l<LookupExtra> a;
    private int b = -1;
    private i c;
    private IStatisticsMerge d;
    private b.c e;
    private CountDownLatch f;
    private Selector g;
    private Set<f> h;
    private List<f.b> i;

    private j(l<LookupExtra> lVar) {
        if (lVar != null) {
            this.a = lVar;
            return;
        }
        throw new IllegalArgumentException("lookupParams".concat(" can not be null"));
    }

    public static <LookupExtra extends f.a> j<LookupExtra> a(l<LookupExtra> lVar) {
        return new j<>(lVar);
    }

    public j<LookupExtra> b(l<LookupExtra> lVar) {
        return a(lVar).a(this.b).a(this.c).a(this.d).a(this.e).a(this.f).a(this.g).a(this.h).a(this.i);
    }

    public l<LookupExtra> a() {
        return this.a;
    }

    public String b() {
        return this.a.b;
    }

    public LookupExtra c() {
        return this.a.d;
    }

    public String d() {
        return this.a.e;
    }

    public int e() {
        return this.a.f;
    }

    public boolean f() {
        return this.a.h;
    }

    public int g() {
        return this.a.i;
    }

    public boolean h() {
        return this.a.j;
    }

    public boolean i() {
        return this.a.k;
    }

    public int j() {
        return this.a.f1450l;
    }

    public boolean k() {
        return this.a.m;
    }

    public j<LookupExtra> a(int i2) {
        if (!d.a(i2)) {
            this.b = i2;
            return this;
        }
        throw new IllegalArgumentException("curNetStack".concat(" is invalid"));
    }

    public int l() {
        if (!d.a(this.b)) {
            return this.b;
        }
        throw new IllegalStateException("mCurNetStack".concat(" is not initialized yet"));
    }

    public j<LookupExtra> a(i iVar) {
        if (iVar != null) {
            this.c = iVar;
            return this;
        }
        throw new IllegalArgumentException("sorter".concat(" can not be null"));
    }

    public i m() {
        i iVar = this.c;
        if (iVar != null) {
            return iVar;
        }
        throw new IllegalStateException("mSorter".concat(" is not initialized yet"));
    }

    public j<LookupExtra> a(IStatisticsMerge iStatisticsMerge) {
        if (iStatisticsMerge != null) {
            this.d = iStatisticsMerge;
            return this;
        }
        throw new IllegalArgumentException("statMerge".concat(" can not be null"));
    }

    public IStatisticsMerge n() {
        IStatisticsMerge iStatisticsMerge = this.d;
        if (iStatisticsMerge != null) {
            return iStatisticsMerge;
        }
        throw new IllegalStateException("mStatMerge".concat(" is not initialized yet"));
    }

    public j<LookupExtra> a(b.c cVar) {
        if (cVar != null) {
            this.e = cVar;
            return this;
        }
        throw new IllegalArgumentException("transaction".concat(" can not be null"));
    }

    public b.c o() {
        b.c cVar = this.e;
        if (cVar != null) {
            return cVar;
        }
        throw new IllegalStateException("mTransaction".concat(" is not initialized yet"));
    }

    public j<LookupExtra> a(CountDownLatch countDownLatch) {
        if (countDownLatch != null) {
            this.f = countDownLatch;
            return this;
        }
        throw new IllegalArgumentException("countDownLatch".concat(" can not be null"));
    }

    public j<LookupExtra> a(Selector selector) {
        this.g = selector;
        return this;
    }

    public Selector p() {
        return this.g;
    }

    public j<LookupExtra> a(Set<f> set) {
        if (set != null) {
            this.h = set;
            return this;
        }
        throw new IllegalArgumentException("dnses".concat(" can not be null"));
    }

    public Set<f> q() {
        Set<f> set = this.h;
        if (set != null) {
            return set;
        }
        throw new IllegalStateException("mDnses".concat(" is not initialized yet"));
    }

    public boolean r() {
        Set<f> set = this.h;
        if (set != null) {
            return set.isEmpty();
        }
        throw new IllegalStateException("mDnses".concat(" is not initialized yet"));
    }

    public j<LookupExtra> a(List<f.b> list) {
        if (list != null) {
            this.i = list;
            return this;
        }
        throw new IllegalArgumentException("sessions".concat(" can not be null"));
    }

    public List<f.b> s() {
        List<f.b> list = this.i;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("mSessions".concat(" is not initialized yet"));
    }

    public String toString() {
        return "LookupContext{mLookupParams=" + this.a + ", mCurNetStack=" + this.b + ", mSorter=" + this.c + ", mStatMerge=" + this.d + ", mTransaction=" + this.e + ", mCountDownLatch=" + this.f + ", mSelector=" + this.g + ", mDnses=" + this.h + ", mSessions=" + this.i + '}';
    }
}
