package com.ss.android.downloadlib.d;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.a.a.c.c;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.c.l;

/* compiled from: NewDownloadDepend */
public class f extends com.ss.android.socialbase.appdownloader.c.a {
    private static String a = "f";

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public boolean a() {
        return true;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public l a(Context context) {
        return new l(context) {
            /* class com.ss.android.downloadlib.d.f.AnonymousClass1 */
            final /* synthetic */ Context a;
            private c.a c;
            private DialogInterface.OnClickListener d;
            private DialogInterface.OnClickListener e;
            private DialogInterface.OnCancelListener f;

            {
                this.a = r2;
                this.c = new c.a(r2);
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(int i) {
                this.c.a(this.a.getResources().getString(i));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(String str) {
                this.c.b(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(int i, DialogInterface.OnClickListener onClickListener) {
                this.c.c(this.a.getResources().getString(i));
                this.d = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l b(int i, DialogInterface.OnClickListener onClickListener) {
                this.c.d(this.a.getResources().getString(i));
                this.e = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(DialogInterface.OnCancelListener onCancelListener) {
                this.f = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(boolean z) {
                this.c.a(z);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public k a() {
                this.c.a(new c.b() {
                    /* class com.ss.android.downloadlib.d.f.AnonymousClass1.AnonymousClass1 */

                    @Override // com.ss.android.a.a.c.c.b
                    public void a(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.d != null) {
                            AnonymousClass1.this.d.onClick(dialogInterface, -1);
                        }
                    }

                    @Override // com.ss.android.a.a.c.c.b
                    public void b(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.e != null) {
                            AnonymousClass1.this.e.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.ss.android.a.a.c.c.b
                    public void c(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f != null && dialogInterface != null) {
                            AnonymousClass1.this.f.onCancel(dialogInterface);
                        }
                    }
                });
                j.a(f.a, "getThemedAlertDlgBuilder", null);
                this.c.a(3);
                return new a(com.ss.android.downloadlib.addownload.k.d().b(this.c.a()));
            }
        };
    }

    /* compiled from: NewDownloadDepend */
    private static class a implements k {
        private Dialog a;

        public a(Dialog dialog) {
            if (dialog != null) {
                this.a = dialog;
                a();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public void a() {
            Dialog dialog = this.a;
            if (dialog != null) {
                dialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public boolean b() {
            Dialog dialog = this.a;
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }
    }
}
