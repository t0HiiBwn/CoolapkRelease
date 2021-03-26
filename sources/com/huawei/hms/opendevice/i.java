package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.entity.AAIDResult;
import java.util.concurrent.Callable;

/* compiled from: AAIDCallable */
public class i implements Callable<AAIDResult> {
    private Context a;

    public i(Context context) {
        this.a = context;
    }

    @Override // java.util.concurrent.Callable
    public AAIDResult call() throws Exception {
        Context context = this.a;
        if (context != null) {
            String b = n.b(context);
            AAIDResult aAIDResult = new AAIDResult();
            aAIDResult.setId(b);
            return aAIDResult;
        }
        throw a.a(a.ERROR_ARGUMENTS_INVALID);
    }
}
