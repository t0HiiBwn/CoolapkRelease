package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.appdownloader.f.b;
import com.ss.android.socialbase.downloader.g.a;

/* compiled from: V3DevicePlan */
public class l extends a {
    public l(Context context, a aVar, String str) {
        super(context, aVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        String c = this.b.c("s");
        String a = b.a(this.b.c("ag"), c);
        String a2 = b.a(this.b.c("ah"), c);
        String a3 = b.a(this.b.c("ai"), c);
        String a4 = b.a(this.b.c("aj"), c);
        Intent intent = new Intent();
        intent.putExtra(a, this.c);
        intent.putExtra(a2, "*/*");
        intent.putExtra(a3, true);
        intent.setAction(a4);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        return intent;
    }
}
