package com.kepler.sdk;

import android.content.Context;
import com.kepler.jd.Listener.FaceCommonCallBack;
import java.io.File;
import java.util.HashMap;

public class p {
    private Context a;
    private l b;
    private n c;
    private File d;
    private FaceCommonCallBack<String> e;

    static class a {
        private static final p a = new p();
    }

    public static final p a() {
        return a.a;
    }

    private p() {
        this.e = new FaceCommonCallBack<String>() {
            /* class com.kepler.sdk.p.AnonymousClass1 */

            /* renamed from: a */
            public boolean callBack(String... strArr) {
                p.this.b.a(System.currentTimeMillis());
                o a2 = p.this.b.a(strArr[0]);
                if (a2 != null) {
                    p.this.a(a2);
                }
                return false;
            }
        };
    }

    public void b() {
        if (System.currentTimeMillis() - this.b.b() >= f.a().b() * 1000) {
            if (this.c == null) {
                this.c = new n();
            }
            this.c.a(this.e);
        }
    }

    public void a(Context context) {
        this.a = context;
        this.b = new l(context);
        this.d = y.c();
        o a2 = this.b.a();
        if (a2 != null) {
            a(a2);
        }
        b();
    }

    /* access modifiers changed from: private */
    public void a(o oVar) {
        HashMap<String, m> hashMap = new HashMap<>();
        for (m mVar : oVar.b) {
            hashMap.put(mVar.b, mVar);
        }
        for (m mVar2 : oVar.c) {
            mVar2.a();
        }
        for (m mVar3 : oVar.a) {
            if (mVar3.a(this.d)) {
                hashMap.put(mVar3.b, mVar3);
            } else {
                File a2 = u.a(mVar3.a, this.d, mVar3.b(), 3);
                if (a2 == null) {
                    j.b("suwg", "load err:" + mVar3.a);
                } else if (mVar3.b(a2)) {
                    hashMap.put(mVar3.b, mVar3);
                    j.b("suwg", "load ok:" + mVar3.a);
                }
            }
        }
        this.b.a(hashMap);
    }
}
