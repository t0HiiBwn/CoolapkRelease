package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ac;

/* compiled from: DownloadCommonDialog */
public class d extends AlertDialog {
    private TextView a;
    private TextView b;
    private Button c;
    private TextView d;
    private TextView e;
    private TTRoundRectImageView f;
    private Context g;
    private TextView h;
    private TextView i;
    private String j;
    private String k;

    /* renamed from: l  reason: collision with root package name */
    private String f1326l;
    private String m;
    private a n;

    /* compiled from: DownloadCommonDialog */
    public interface a {
        void a(Dialog dialog);

        void b(Dialog dialog);

        void c(Dialog dialog);

        void d(Dialog dialog);
    }

    public d(Context context) {
        super(context, ac.g(context, "DialogFullscreen"));
        this.g = context;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ac.f(this.g, "tt_common_download_dialog"));
        setCanceledOnTouchOutside(false);
        a();
    }

    private void a() {
        this.a = (TextView) findViewById(ac.e(this.g, "tt_download_title"));
        this.d = (TextView) findViewById(ac.e(this.g, "tt_download_app_detail"));
        this.c = (Button) findViewById(ac.e(this.g, "tt_download_btn"));
        this.b = (TextView) findViewById(ac.e(this.g, "tt_download_app_version"));
        this.e = (TextView) findViewById(ac.e(this.g, "tt_download_cancel"));
        this.h = (TextView) findViewById(ac.e(this.g, "tt_download_app_privacy"));
        this.i = (TextView) findViewById(ac.e(this.g, "tt_download_app_developer"));
        this.f = (TTRoundRectImageView) findViewById(ac.e(this.g, "tt_download_icon"));
        this.c.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.widget.d.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.n != null) {
                    d.this.n.a(d.this);
                }
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.widget.d.AnonymousClass2 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.n != null) {
                    d.this.n.b(d.this);
                }
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.widget.d.AnonymousClass3 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.n != null) {
                    d.this.n.c(d.this);
                }
            }
        });
        this.h.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.widget.d.AnonymousClass4 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.n != null) {
                    d.this.n.d(d.this);
                }
            }
        });
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        a aVar = this.n;
        if (aVar != null) {
            aVar.c(this);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        b();
    }

    private void b() {
        String str;
        String str2;
        if (this.g == null) {
            this.g = p.a();
        }
        TextView textView = this.a;
        if (textView != null) {
            textView.setText(this.j);
        }
        if (this.f != null && !TextUtils.isEmpty(this.f1326l)) {
            com.bytedance.sdk.openadsdk.h.d.a(this.g).a(this.f1326l, this.f);
        }
        if (this.i != null) {
            String a2 = ac.a(this.g, "tt_open_app_detail_developer");
            if (TextUtils.isEmpty(this.m)) {
                str2 = String.format(a2, "补充中，可于应用官网查看");
            } else {
                str2 = String.format(a2, this.m);
            }
            this.i.setText(str2);
        }
        if (this.b != null) {
            String a3 = ac.a(this.g, "tt_open_app_version");
            if (TextUtils.isEmpty(this.k)) {
                str = String.format(a3, "暂无");
            } else {
                str = String.format(a3, this.k);
            }
            this.b.setText(str);
        }
    }

    public d a(String str) {
        this.j = str;
        return this;
    }

    public d b(String str) {
        this.k = str;
        return this;
    }

    public d c(String str) {
        this.f1326l = str;
        return this;
    }

    public d d(String str) {
        this.m = str;
        return this;
    }

    public d a(a aVar) {
        this.n = aVar;
        return this;
    }
}
