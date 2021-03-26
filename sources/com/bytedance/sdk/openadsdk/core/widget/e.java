package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ak;

/* compiled from: InstallDialog */
public class e extends AlertDialog {
    private TextView a;
    private TextView b;
    private Button c;
    private Button d;
    private Context e;
    private String f;
    private String g;
    private String h;
    private String i;
    private Drawable j;
    private a k;

    /* compiled from: InstallDialog */
    public interface a {
        void a(Dialog dialog);

        void b(Dialog dialog);
    }

    public e(Context context) {
        super(context, ac.g(context, "tt_custom_dialog"));
        this.e = context;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ac.f(this.e, "tt_install_dialog_layout"));
        setCanceledOnTouchOutside(true);
        a();
    }

    private void a() {
        this.a = (TextView) findViewById(ac.e(this.e, "tt_install_title"));
        this.b = (TextView) findViewById(ac.e(this.e, "tt_install_content"));
        this.c = (Button) findViewById(ac.e(this.e, "tt_install_btn_yes"));
        this.d = (Button) findViewById(ac.e(this.e, "tt_install_btn_no"));
        this.c.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.widget.e.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.dismiss();
                if (e.this.k != null) {
                    e.this.k.a(e.this);
                }
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.widget.e.AnonymousClass2 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.dismiss();
                if (e.this.k != null) {
                    e.this.k.b(e.this);
                }
            }
        });
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        b();
    }

    private void b() {
        TextView textView = this.a;
        if (textView != null) {
            textView.setText(this.f);
            Drawable drawable = this.j;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.j.getIntrinsicHeight();
                int c2 = ak.c(this.e, 45.0f);
                if (intrinsicWidth > c2 || intrinsicWidth < c2) {
                    intrinsicWidth = c2;
                }
                if (intrinsicHeight > c2 || intrinsicHeight < c2) {
                    intrinsicHeight = c2;
                }
                this.j.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                this.a.setCompoundDrawables(this.j, null, null, null);
                this.a.setCompoundDrawablePadding(ak.c(this.e, 10.0f));
            }
        }
        TextView textView2 = this.b;
        if (textView2 != null) {
            textView2.setText(this.g);
        }
        Button button = this.c;
        if (button != null) {
            button.setText(this.h);
        }
        Button button2 = this.d;
        if (button2 != null) {
            button2.setText(this.i);
        }
    }

    public e a(String str) {
        this.f = str;
        return this;
    }

    public e b(String str) {
        this.g = str;
        return this;
    }

    public e c(String str) {
        this.h = str;
        return this;
    }

    public e d(String str) {
        this.i = str;
        return this;
    }

    public e a(Drawable drawable) {
        this.j = drawable;
        return this;
    }

    public e a(a aVar) {
        this.k = aVar;
        return this;
    }

    public e a(DialogInterface.OnCancelListener onCancelListener) {
        setOnCancelListener(onCancelListener);
        return this;
    }
}
