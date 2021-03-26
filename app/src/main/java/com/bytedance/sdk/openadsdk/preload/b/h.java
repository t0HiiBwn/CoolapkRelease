package com.bytedance.sdk.openadsdk.preload.b;

/* compiled from: Pipe */
public final class h {
    Class<? extends d> a;
    private com.bytedance.sdk.openadsdk.preload.b.b.a b;
    private Object[] c;

    private h(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        if (this.a == null) {
            throw new IllegalArgumentException("Interceptor class == null");
        }
    }

    Class<? extends d> a() {
        return this.a;
    }

    com.bytedance.sdk.openadsdk.preload.b.b.a b() {
        return this.b;
    }

    Object[] c() {
        return this.c;
    }

    /* compiled from: Pipe */
    public static final class a {
        private Class<? extends d> a;
        private com.bytedance.sdk.openadsdk.preload.b.b.a b;
        private Object[] c;

        private a() {
        }

        public static a a() {
            return new a();
        }

        public a a(Class<? extends d> cls) {
            if (cls != null) {
                this.a = cls;
                return this;
            }
            throw new IllegalArgumentException("interceptor class == null");
        }

        public a a(com.bytedance.sdk.openadsdk.preload.b.b.a aVar) {
            this.b = aVar;
            return this;
        }

        public a a(Object... objArr) {
            if (objArr != null) {
                this.c = objArr;
                return this;
            }
            throw new IllegalArgumentException("args == null");
        }

        public h b() {
            return new h(this);
        }
    }
}
