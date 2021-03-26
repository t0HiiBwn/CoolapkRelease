package com.ss.android.downloadlib.h;

import com.ss.android.downloadlib.d;
import com.ss.android.downloadlib.f;
import java.lang.ref.SoftReference;

/* compiled from: Chain */
public class c<P, R> implements Runnable {
    private P a;
    private R b;
    private int c;
    private SoftReference<a<P, R>> d;
    private c<?, P> e;
    private c<R, ?> f;

    /* compiled from: Chain */
    public interface a<PARAM, RESULT> {
        RESULT a(PARAM param);
    }

    private c(int i, a<P, R> aVar, P p) {
        this.c = i;
        this.d = new SoftReference<>(aVar);
        this.a = p;
    }

    public static <P, R> c<P, R> a(a<P, R> aVar, P p) {
        return new c<>(2, aVar, p);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.ss.android.downloadlib.h.c<P, R> */
    /* JADX WARN: Multi-variable type inference failed */
    public <NR> c<R, NR> a(int i, a<R, NR> aVar) {
        c cVar = (c<R, ?>) new c(i, aVar, null);
        this.f = cVar;
        cVar.e = this;
        return cVar;
    }

    public <NR> c<R, NR> a(a<R, NR> aVar) {
        return a(0, aVar);
    }

    public void a() {
        c<?, P> cVar = this.e;
        if (cVar != null) {
            cVar.a();
        } else {
            run();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        c<?, P> cVar;
        if (this.c == 0 && !k.a()) {
            f.a().b().post(this);
        } else if (this.c == 1 && k.a()) {
            d.a().a(this);
        } else if (this.c != 2 || !k.a()) {
            if (this.a == null && (cVar = this.e) != null) {
                this.a = cVar.b();
            }
            a<P, R> aVar = this.d.get();
            if (aVar != null) {
                this.b = aVar.a(this.a);
                c<R, ?> cVar2 = this.f;
                if (cVar2 != null) {
                    cVar2.run();
                }
            }
        } else {
            d.a().b(this);
        }
    }

    private R b() {
        return this.b;
    }
}
