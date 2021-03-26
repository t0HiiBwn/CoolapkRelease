package com.xiaomi.push;

import android.content.Context;
import java.io.File;

final class je extends jd {
    final /* synthetic */ Runnable a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    je(Context context, File file, Runnable runnable) {
        super(context, file, null);
        this.a = runnable;
    }

    @Override // com.xiaomi.push.jd
    protected void a(Context context) {
        Runnable runnable = this.a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
