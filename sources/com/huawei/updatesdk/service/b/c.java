package com.huawei.updatesdk.service.b;

import com.huawei.updatesdk.a.a.b.a.a.a;
import com.huawei.updatesdk.a.b.c.b;
import java.util.ArrayList;
import java.util.List;

public final class c {
    private static c a = new c();
    private static a b = new a() {
        /* class com.huawei.updatesdk.service.b.c.AnonymousClass1 */
        private final List<b> a = new ArrayList();

        @Override // com.huawei.updatesdk.service.b.a
        public void a(int i, b bVar) {
            synchronized (this.a) {
                for (b bVar2 : this.a) {
                    bVar2.a(i, bVar);
                }
            }
        }

        @Override // com.huawei.updatesdk.service.b.a
        public void a(b bVar) {
            String str;
            String str2;
            synchronized (this.a) {
                if (bVar != null) {
                    if (!this.a.contains(bVar)) {
                        try {
                            this.a.add(bVar);
                        } catch (UnsupportedOperationException unused) {
                            str = "InstallObserverManager";
                            str2 = "registerObserver UnsupportedOperationException";
                        } catch (ClassCastException unused2) {
                            str = "InstallObserverManager";
                            str2 = "registerObserver ClassCastException";
                        } catch (IllegalArgumentException unused3) {
                            str = "InstallObserverManager";
                            str2 = "registerObserver IllegalArgumentException";
                        }
                    }
                }
                return;
            }
            a.d(str, str2);
        }

        @Override // com.huawei.updatesdk.service.b.a
        public void b(b bVar) {
            synchronized (this.a) {
                try {
                    this.a.remove(bVar);
                } catch (UnsupportedOperationException unused) {
                    a.d("InstallObserverManager", "unRegisterObserver UnsupportedOperationException");
                }
            }
        }
    };

    private c() {
    }

    public static c a() {
        return a;
    }

    public static a b() {
        return b;
    }

    public void a(b bVar) {
        b.a(0, bVar);
    }

    public void b(b bVar) {
        b.a(1, bVar);
    }

    public void c(b bVar) {
        b.a(2, bVar);
    }
}
