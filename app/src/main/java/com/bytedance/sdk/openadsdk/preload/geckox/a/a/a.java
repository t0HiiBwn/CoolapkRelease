package com.bytedance.sdk.openadsdk.preload.geckox.a.a;

/* compiled from: CacheConfig */
public class a {
    final int a;
    final c b;
    private final b c;

    private a(C0064a aVar) {
        this.a = aVar.a;
        this.c = aVar.b;
        this.b = aVar.c;
    }

    public b a() {
        return this.c;
    }

    public int b() {
        return this.a;
    }

    public c c() {
        return this.b;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.preload.geckox.a.a.a$a  reason: collision with other inner class name */
    /* compiled from: CacheConfig */
    public static final class C0064a {
        private int a;
        private b b = b.a;
        private c c;

        public C0064a a(int i) {
            this.a = i;
            return this;
        }

        public C0064a a(b bVar) {
            if (bVar == null) {
                bVar = b.a;
            }
            this.b = bVar;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }
}
