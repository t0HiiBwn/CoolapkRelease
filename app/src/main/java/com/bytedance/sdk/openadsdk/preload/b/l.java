package com.bytedance.sdk.openadsdk.preload.b;

import com.bytedance.sdk.openadsdk.preload.b.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: SubBranchInterceptor */
abstract class l<IN, OUT> extends d<IN, OUT> {
    private Map<String, a> d;

    l() {
    }

    Map<String, a> a() {
        return this.d;
    }

    boolean a(List<h> list) {
        if (!list.isEmpty() && list.get(list.size() - 1).a == f.class) {
            return true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    protected final void a(Object... objArr) {
        super.a(objArr);
        if (objArr == null || objArr.length != 1 || objArr[0] == null) {
            throw new IllegalStateException("args error");
        }
        try {
            this.d = (Map) objArr[0];
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* compiled from: SubBranchInterceptor */
    public static final class b {
        private Map<String, a> a = new HashMap();
        private com.bytedance.sdk.openadsdk.preload.b.b.a b;

        public a a(String str) {
            if (!this.a.containsKey(str)) {
                a aVar = new a();
                this.a.put(str, aVar);
                return aVar;
            }
            throw new IllegalArgumentException("duplicated branch name");
        }

        public h a(Class<? extends l> cls) {
            return h.a.a().a(cls).a(this.a).a(this.b).b();
        }
    }

    /* compiled from: SubBranchInterceptor */
    public static final class a {
        List<h> a = new ArrayList();

        public a a(h hVar) {
            this.a.add(hVar);
            return this;
        }

        public a a(List<h> list) {
            this.a.addAll(list);
            return this;
        }
    }
}
