package com.huawei.updatesdk.a.a.c.a;

import android.content.Context;
import com.huawei.updatesdk.a.a.c.e;
import com.huawei.updatesdk.a.b.d.a.b;
import java.util.ArrayList;
import java.util.Set;

public class a extends b {
    private String abis_;
    private String deviceFeatures_;
    private int dpi_;
    private String preferLan_;

    /* renamed from: com.huawei.updatesdk.a.a.c.a.a$a  reason: collision with other inner class name */
    public static class C0076a {
        private final Context a;
        private boolean b;
        private Set<String> c;
        private String[] d;
        private boolean e;

        public C0076a(Context context) {
            this.a = context;
        }

        private String b() {
            ArrayList arrayList = new ArrayList(b.c(this.a));
            Set<String> set = this.c;
            if (set != null) {
                for (String str : set) {
                    if (!arrayList.contains(str)) {
                        arrayList.add(str);
                    }
                }
            }
            return this.e ? e.a(b.a(arrayList, this.d), ",") : e.a(arrayList, ",");
        }

        public C0076a a(boolean z) {
            this.b = z;
            return this;
        }

        public a a() {
            a aVar = new a();
            aVar.abis_ = e.a(b.c(), ",");
            aVar.dpi_ = Integer.parseInt(b.a(this.a));
            aVar.preferLan_ = b();
            if (this.b) {
                aVar.deviceFeatures_ = b.b(this.a);
            }
            return aVar;
        }
    }

    private a() {
    }
}
