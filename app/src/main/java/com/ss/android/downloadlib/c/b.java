package com.ss.android.downloadlib.c;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.ss.android.a.a.a.h;
import com.ss.android.a.a.a.q;

/* compiled from: DefaultPermissionChecker */
public class b implements h {
    private q a;

    @Override // com.ss.android.a.a.a.h
    public void a(Activity activity, String[] strArr, q qVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.a = qVar;
            activity.requestPermissions(strArr, 1);
        } else if (qVar != null) {
            qVar.a();
        }
    }

    @Override // com.ss.android.a.a.a.h
    public boolean a(Context context, String str) {
        return context != null && ContextCompat.checkSelfPermission(context, str) == 0;
    }

    @Override // com.ss.android.a.a.a.h
    public void a(Activity activity, int i, String[] strArr, int[] iArr) {
        q qVar;
        if (iArr.length > 0 && (qVar = this.a) != null) {
            if (iArr[0] == -1) {
                qVar.a(strArr[0]);
            } else if (iArr[0] == 0) {
                qVar.a();
            }
        }
    }
}
