package com.ss.android.downloadlib.addownload.a;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ss.android.downloadlib.R;

/* compiled from: SelectOperationDialog */
public class d extends Dialog {
    private TextView a;
    private TextView b;
    private TextView c;
    private c d;
    private boolean e;
    private Activity f;
    private String g;
    private String h;
    private String i;

    public d(Activity activity, String str, String str2, String str3, boolean z, c cVar) {
        super(activity, R.style.ttdownloader_translucent_dialog);
        this.f = activity;
        this.d = cVar;
        this.g = str;
        this.h = str2;
        this.i = str3;
        setCanceledOnTouchOutside(z);
        d();
    }

    private void d() {
        setContentView(LayoutInflater.from(this.f.getApplicationContext()).inflate(a(), (ViewGroup) null));
        this.a = (TextView) findViewById(b());
        this.b = (TextView) findViewById(c());
        this.c = (TextView) findViewById(R.id.message_tv);
        if (!TextUtils.isEmpty(this.h)) {
            this.a.setText(this.h);
        }
        if (!TextUtils.isEmpty(this.i)) {
            this.b.setText(this.i);
        }
        if (!TextUtils.isEmpty(this.g)) {
            this.c.setText(this.g);
        }
        this.a.setOnClickListener(new View.OnClickListener() {
            /* class com.ss.android.downloadlib.addownload.a.d.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.e();
            }
        });
        this.b.setOnClickListener(new View.OnClickListener() {
            /* class com.ss.android.downloadlib.addownload.a.d.AnonymousClass2 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.f();
            }
        });
    }

    public int a() {
        return R.layout.ttdownloader_dialog_select_operation;
    }

    public int b() {
        return R.id.confirm_tv;
    }

    public int c() {
        return R.id.cancel_tv;
    }

    /* access modifiers changed from: private */
    public void e() {
        this.e = true;
        dismiss();
    }

    /* access modifiers changed from: private */
    public void f() {
        dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.f.isFinishing()) {
            this.f.finish();
        }
        if (this.e) {
            this.d.a();
        } else {
            this.d.b();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* compiled from: SelectOperationDialog */
    public static class a {
        private Activity a;
        private String b;
        private String c;
        private String d;
        private boolean e;
        private c f;

        public a(Activity activity) {
            this.a = activity;
        }

        public a a(String str) {
            this.b = str;
            return this;
        }

        public a b(String str) {
            this.c = str;
            return this;
        }

        public a c(String str) {
            this.d = str;
            return this;
        }

        public a a(boolean z) {
            this.e = z;
            return this;
        }

        public a a(c cVar) {
            this.f = cVar;
            return this;
        }

        public d a() {
            return new d(this.a, this.b, this.c, this.d, this.e, this.f);
        }
    }
}
