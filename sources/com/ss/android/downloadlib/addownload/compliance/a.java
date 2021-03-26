package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ss.android.downloadlib.R;
import com.ss.android.downloadlib.addownload.b.b;
import com.ss.android.downloadlib.addownload.compliance.d;
import com.ss.android.downloadlib.guide.install.ClipImageView;
import com.ss.android.downloadlib.h.k;
import com.ss.android.socialbase.appdownloader.c;

/* compiled from: AdLpAppInfoDialog */
public class a extends Dialog {
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private ClipImageView g;
    private LinearLayout h;
    private Activity i;
    private final long j;
    private long k;
    private final b l;

    public a(Activity activity, long j2) {
        super(activity);
        this.i = activity;
        this.j = j2;
        this.l = (b) c.a().get(Long.valueOf(j2));
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.l == null) {
            dismiss();
            return;
        }
        requestWindowFeature(1);
        setContentView(R.layout.ttdownloader_dialog_appinfo);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.drawable.ttdownloader_bg_transparent);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.k = this.l.b;
        a();
        e.b("lp_app_dialog_show", this.k);
        setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.ss.android.downloadlib.addownload.compliance.a.AnonymousClass1 */

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                e.a("lp_app_dialog_cancel", a.this.k);
            }
        });
    }

    private void a() {
        this.a = (TextView) findViewById(R.id.tv_app_name);
        this.b = (TextView) findViewById(R.id.tv_app_version);
        this.c = (TextView) findViewById(R.id.tv_app_developer);
        this.d = (TextView) findViewById(R.id.tv_app_detail);
        this.e = (TextView) findViewById(R.id.tv_app_privacy);
        this.f = (TextView) findViewById(R.id.tv_give_up);
        this.g = (ClipImageView) findViewById(R.id.iv_app_icon);
        this.h = (LinearLayout) findViewById(R.id.ll_download);
        this.a.setText(k.a(this.l.e, "--"));
        TextView textView = this.b;
        textView.setText("版本号：" + k.a(this.l.f, "--"));
        TextView textView2 = this.c;
        textView2.setText("开发者：" + k.a(this.l.g, "应用信息正在完善中"));
        this.g.setRoundRadius(k.a(com.ss.android.downloadlib.addownload.k.a(), 8.0f));
        this.g.setBackgroundColor(Color.parseColor("#EBEBEB"));
        d.a().a(this.j, new d.a() {
            /* class com.ss.android.downloadlib.addownload.compliance.a.AnonymousClass2 */

            @Override // com.ss.android.downloadlib.addownload.compliance.d.a
            public void a(Bitmap bitmap) {
                if (bitmap != null) {
                    a.this.g.setImageBitmap(bitmap);
                } else {
                    e.a(8, a.this.k);
                }
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() {
            /* class com.ss.android.downloadlib.addownload.compliance.a.AnonymousClass3 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.a().a(a.this.i);
                AppDetailInfoActivity.a(a.this.i, a.this.j);
                e.a("lp_app_dialog_click_detail", a.this.k);
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() {
            /* class com.ss.android.downloadlib.addownload.compliance.a.AnonymousClass4 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.a().a(a.this.i);
                AppPrivacyPolicyActivity.a(a.this.i, a.this.j);
                e.a("lp_app_dialog_click_privacy", a.this.k);
            }
        });
        this.f.setOnClickListener(new View.OnClickListener() {
            /* class com.ss.android.downloadlib.addownload.compliance.a.AnonymousClass5 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dismiss();
                e.a("lp_app_dialog_click_giveup", a.this.k);
            }
        });
        this.h.setOnClickListener(new View.OnClickListener() {
            /* class com.ss.android.downloadlib.addownload.compliance.a.AnonymousClass6 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.a("lp_app_dialog_click_download", a.this.k);
                b.a().b(a.this.k);
                a.this.dismiss();
            }
        });
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        c.a(this.i);
    }
}
