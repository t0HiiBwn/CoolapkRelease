package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.a.a;
import com.bytedance.sdk.openadsdk.core.d.f;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.utils.ak;

/* compiled from: ExpressClickCreativeListener */
public class d extends a {
    private j a;

    public d(Context context, l lVar, String str, int i) {
        super(context, lVar, str, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.b
    protected f a(int i, int i2, int i3, int i4, long j, long j2, View view, View view2) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        long j3;
        int i11;
        long j4;
        this.y = 1;
        this.z = 0;
        this.A = 0;
        int[] a2 = ak.a(view);
        if (a2 == null || a2.length != 2) {
            i8 = i;
            i7 = i2;
            i6 = i3;
            i5 = i4;
            i10 = 0;
            i9 = 0;
        } else {
            i10 = a2[0];
            i9 = a2[1];
            i8 = ((int) ak.a(this.c, (float) i)) + i10;
            i7 = ((int) ak.a(this.c, (float) i2)) + i9;
            i6 = ((int) ak.a(this.c, (float) i3)) + i10;
            i5 = ((int) ak.a(this.c, (float) i4)) + i9;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        j jVar = this.a;
        if (jVar != null) {
            j3 = jVar.e;
            j4 = this.a.f;
            iArr[0] = ((int) ak.a(this.c, (float) this.a.g)) + i10;
            iArr[1] = ((int) ak.a(this.c, (float) this.a.h)) + i9;
            int a3 = (int) ak.a(this.c, (float) this.a.i);
            int a4 = (int) ak.a(this.c, (float) this.a.j);
            iArr2[0] = a3;
            i11 = 1;
            iArr2[1] = a4;
            if (a3 == 0 && a4 == 0) {
                iArr = ak.a(view2);
                iArr2 = ak.c(view2);
            }
        } else {
            i11 = 1;
            j3 = j;
            j4 = j2;
        }
        f.a h = new f.a().e(i8).d(i7).c(i6).b(i5).b(j3).a(j4).b(a2).a(iArr).c(ak.c(view)).d(iArr2).f(this.y).g(this.z).h(this.A);
        if (!i.d().b()) {
            i11 = 2;
        }
        return h.a(i11).a(this.C).a();
    }

    public void a(j jVar) {
        this.a = jVar;
    }
}
