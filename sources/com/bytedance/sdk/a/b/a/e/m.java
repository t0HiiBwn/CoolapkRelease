package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.a.e;
import java.io.IOException;
import java.util.List;

/* compiled from: PushObserver */
public interface m {
    public static final m a = new m() {
        /* class com.bytedance.sdk.a.b.a.e.m.AnonymousClass1 */

        @Override // com.bytedance.sdk.a.b.a.e.m
        public void a(int i, b bVar) {
        }

        @Override // com.bytedance.sdk.a.b.a.e.m
        public boolean a(int i, List<c> list) {
            return true;
        }

        @Override // com.bytedance.sdk.a.b.a.e.m
        public boolean a(int i, List<c> list, boolean z) {
            return true;
        }

        @Override // com.bytedance.sdk.a.b.a.e.m
        public boolean a(int i, e eVar, int i2, boolean z) throws IOException {
            eVar.h((long) i2);
            return true;
        }
    };

    void a(int i, b bVar);

    boolean a(int i, e eVar, int i2, boolean z) throws IOException;

    boolean a(int i, List<c> list);

    boolean a(int i, List<c> list, boolean z);
}
