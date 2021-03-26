package com.tencent.msdk.dns.core;

import com.tencent.msdk.dns.core.f.a;

/* compiled from: IDns */
public interface f<LookupExtra extends a> {

    /* compiled from: IDns */
    public interface a {
        public static final a a = new a() {
            /* class com.tencent.msdk.dns.core.f.a.AnonymousClass1 */
        };
    }

    /* compiled from: IDns */
    public interface b {

        /* compiled from: IDns */
        public interface a {
            boolean a();

            boolean b();

            boolean c();

            boolean d();

            boolean e();
        }

        void a();

        void b();

        String[] c();

        void d();

        b e();

        f f();

        boolean g();

        a h();

        c i();
    }

    /* compiled from: IDns */
    public interface c {
        boolean lookupFailed();

        boolean lookupSuccess();
    }

    LookupResult a(l<LookupExtra> lVar);

    c a();

    b a(j<LookupExtra> jVar);

    LookupResult b(l<LookupExtra> lVar);
}
