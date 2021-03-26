package com.ss.android.socialbase.appdownloader.d;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.socialbase.appdownloader.c.b;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.c.l;

/* compiled from: DefaultAlertDialogBuilder */
public class a extends b {
    private AlertDialog.Builder a;

    public a(Context context) {
        this.a = new AlertDialog.Builder(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l a(int i) {
        AlertDialog.Builder builder = this.a;
        if (builder != null) {
            builder.setTitle(i);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l a(String str) {
        AlertDialog.Builder builder = this.a;
        if (builder != null) {
            builder.setMessage(str);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l a(int i, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.a;
        if (builder != null) {
            builder.setPositiveButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l b(int i, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.a;
        if (builder != null) {
            builder.setNegativeButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public l a(DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = this.a;
        if (builder != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.l
    public k a() {
        return new C0090a(this.a);
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.d.a$a  reason: collision with other inner class name */
    /* compiled from: DefaultAlertDialogBuilder */
    private static class C0090a implements k {
        private AlertDialog a;

        public C0090a(AlertDialog.Builder builder) {
            if (builder != null) {
                this.a = builder.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public void a() {
            AlertDialog alertDialog = this.a;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public boolean b() {
            AlertDialog alertDialog = this.a;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }
    }
}
