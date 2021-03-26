package com.huawei.hms.update.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: AbstractDialog */
public abstract class b {
    private AlertDialog a;
    private a b;

    protected abstract AlertDialog a();

    private static int a(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
    }

    public void a(a aVar) {
        this.b = aVar;
        if (f() == null || f().isFinishing()) {
            HMSLog.e("AbstractDialog", "In show, The activity is null or finishing.");
            return;
        }
        AlertDialog a2 = a();
        this.a = a2;
        a2.setCanceledOnTouchOutside(false);
        this.a.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.huawei.hms.update.ui.b.AnonymousClass1 */

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                b.this.d();
            }
        });
        this.a.show();
    }

    public void b() {
        AlertDialog alertDialog = this.a;
        if (alertDialog != null) {
            alertDialog.cancel();
        }
    }

    public void c() {
        AlertDialog alertDialog = this.a;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    protected void d() {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    protected void e() {
        a aVar = this.b;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    protected Activity f() {
        a aVar = this.b;
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    protected int g() {
        return (a(f()) == 0 || Build.VERSION.SDK_INT < 16) ? 3 : 0;
    }
}
