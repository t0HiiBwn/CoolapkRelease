package com.bytedance.sdk.openadsdk.core.c;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.i;
import com.bytedance.sdk.openadsdk.h.d;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ak;

/* compiled from: InteractionExpressBackupView */
class a extends BackupView {
    private static i[] k = {new i(1, 1.0f, 300, 300), new i(2, 0.6666667f, 300, 450), new i(3, 1.5f, 300, 200)};

    /* renamed from: l  reason: collision with root package name */
    private View f1301l;
    private NativeExpressView m;
    private com.bytedance.sdk.openadsdk.downloadnew.core.a n;
    private int o = 1;
    private Dialog p;

    public a(Context context) {
        super(context);
        this.a = context;
    }

    public void a(Dialog dialog) {
        this.p = dialog;
    }

    void a(l lVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        setBackgroundColor(-1);
        this.b = lVar;
        this.m = nativeExpressView;
        this.n = aVar;
        this.e = "interaction";
        a(this.h);
        this.m.addView(this, new ViewGroup.LayoutParams(-2, -2));
        b();
    }

    private void b() {
        i a = a(this.m.getExpectExpressWidth(), this.m.getExpectExpressHeight());
        if (this.m.getExpectExpressWidth() <= 0 || this.m.getExpectExpressHeight() <= 0) {
            this.f = ak.c(this.a, (float) a.d);
            this.g = ak.c(this.a, (float) a.e);
        } else if (this.m.getExpectExpressWidth() > this.m.getExpectExpressHeight()) {
            this.f = ak.c(this.a, ((float) this.m.getExpectExpressHeight()) * a.c);
            this.g = ak.c(this.a, (float) this.m.getExpectExpressHeight());
        } else {
            this.f = ak.c(this.a, (float) this.m.getExpectExpressWidth());
            this.g = ak.c(this.a, ((float) this.m.getExpectExpressWidth()) / a.c);
        }
        if (this.f > 0 && this.f > ak.c(this.a)) {
            float c = ((float) ak.c(this.a)) / ((float) this.f);
            this.f = ak.c(this.a);
            this.g = Float.valueOf(((float) this.g) * c).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f, this.g);
        }
        layoutParams.width = this.f;
        layoutParams.height = this.g;
        setLayoutParams(layoutParams);
        if (a.a == 1) {
            c();
        } else if (a.a == 2) {
            d();
        } else if (a.a == 3) {
            e();
        } else {
            c();
        }
    }

    private void a(ImageView imageView) {
        d.a(this.a).a(this.b.Z().get(0).a(), imageView);
    }

    private void c() {
        View inflate = LayoutInflater.from(this.a).inflate(ac.f(this.a, "tt_backup_insert_layout1"), (ViewGroup) this, true);
        this.f1301l = inflate;
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(ac.e(this.a, "tt_ad_container"));
        ImageView imageView = (ImageView) this.f1301l.findViewById(ac.e(this.a, "tt_bu_img"));
        View findViewById = this.f1301l.findViewById(ac.e(this.a, "tt_bu_close"));
        ImageView imageView2 = (ImageView) this.f1301l.findViewById(ac.e(this.a, "tt_bu_icon"));
        TextView textView = (TextView) this.f1301l.findViewById(ac.e(this.a, "tt_bu_title"));
        TextView textView2 = (TextView) this.f1301l.findViewById(ac.e(this.a, "tt_bu_desc"));
        TextView textView3 = (TextView) this.f1301l.findViewById(ac.e(this.a, "tt_bu_download"));
        TextView textView4 = (TextView) this.f1301l.findViewById(ac.e(this.a, "tt_bu_dislike"));
        int a = (int) ak.a(this.a, 15.0f);
        ak.a(findViewById, a, a, a, a);
        b(findViewById);
        textView4.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.c.a.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a();
            }
        });
        if (!TextUtils.isEmpty(this.b.af())) {
            textView3.setText(this.b.af());
        }
        if (this.b.R() != null) {
            View videoView = getVideoView();
            if (videoView != null) {
                frameLayout.removeAllViews();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f, (this.f * 9) / 16);
                layoutParams.gravity = 17;
                frameLayout.addView(videoView, 0, layoutParams);
            }
            ak.a((View) imageView, 8);
            ak.a((View) frameLayout, 0);
        } else {
            a(imageView);
            ak.a((View) imageView, 0);
            ak.a((View) frameLayout, 8);
        }
        d.a(this.a).a(this.b.U().a(), imageView2);
        textView.setText(getTitle());
        textView2.setText(getDescription());
        a((View) this, true);
        a((View) textView3, true);
        a((View) textView4, true);
        a(frameLayout);
    }

    private void b(View view) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.core.c.a.AnonymousClass2 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.p != null) {
                        a.this.p.dismiss();
                    }
                }
            });
        }
    }

    private void d() {
        View inflate = LayoutInflater.from(this.a).inflate(ac.f(this.a, "tt_backup_insert_layout2"), (ViewGroup) this, true);
        this.f1301l = inflate;
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(ac.e(this.a, "tt_ad_container"));
        ImageView imageView = (ImageView) this.f1301l.findViewById(ac.e(this.a, "tt_bu_img"));
        View findViewById = this.f1301l.findViewById(ac.e(this.a, "tt_bu_close"));
        ImageView imageView2 = (ImageView) this.f1301l.findViewById(ac.e(this.a, "tt_bu_icon"));
        TextView textView = (TextView) this.f1301l.findViewById(ac.e(this.a, "tt_bu_title"));
        TextView textView2 = (TextView) this.f1301l.findViewById(ac.e(this.a, "tt_bu_desc"));
        TextView textView3 = (TextView) this.f1301l.findViewById(ac.e(this.a, "tt_bu_download"));
        TextView textView4 = (TextView) this.f1301l.findViewById(ac.e(this.a, "tt_bu_dislike"));
        int a = (int) ak.a(this.a, 15.0f);
        ak.a(findViewById, a, a, a, a);
        b(findViewById);
        textView4.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.c.a.AnonymousClass3 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a();
            }
        });
        if (!TextUtils.isEmpty(this.b.af())) {
            textView3.setText(this.b.af());
        }
        if (this.b.R() != null) {
            View videoView = getVideoView();
            if (videoView != null) {
                frameLayout.removeAllViews();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f, (this.f * 9) / 16);
                layoutParams.gravity = 17;
                frameLayout.addView(videoView, 0, layoutParams);
            }
            ak.a((View) imageView, 8);
            ak.a((View) frameLayout, 0);
        } else {
            a(imageView);
            ak.a((View) imageView, 0);
            ak.a((View) frameLayout, 8);
        }
        d.a(this.a).a(this.b.U().a(), imageView2);
        textView.setText(getTitle());
        textView2.setText(getDescription());
        a((View) this, true);
        a((View) textView3, true);
        a((View) textView4, true);
        a(frameLayout);
    }

    private void e() {
        View inflate = LayoutInflater.from(this.a).inflate(ac.f(this.a, "tt_backup_insert_layout3"), (ViewGroup) this, true);
        this.f1301l = inflate;
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(ac.e(this.a, "tt_ad_container"));
        ImageView imageView = (ImageView) this.f1301l.findViewById(ac.e(this.a, "tt_bu_img"));
        View findViewById = this.f1301l.findViewById(ac.e(this.a, "tt_bu_close"));
        TextView textView = (TextView) this.f1301l.findViewById(ac.e(this.a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.f1301l.findViewById(ac.e(this.a, "tt_bu_dislike"));
        int a = (int) ak.a(this.a, 15.0f);
        ak.a(findViewById, a, a, a, a);
        b(findViewById);
        textView2.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.c.a.AnonymousClass4 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a();
            }
        });
        if (this.b.R() != null) {
            View videoView = getVideoView();
            if (videoView != null) {
                frameLayout.removeAllViews();
                int c = this.f - ak.c(this.a, 12.0f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c, (c * 9) / 16);
                layoutParams.gravity = 17;
                frameLayout.addView(videoView, 0, layoutParams);
            }
            ak.a((View) imageView, 8);
            ak.a((View) frameLayout, 0);
        } else {
            a(imageView);
            ak.a((View) imageView, 0);
            ak.a((View) frameLayout, 8);
        }
        textView.setText(getDescription());
        a((View) this, true);
        a(this.f1301l, true);
        a((View) textView2, true);
        a(frameLayout);
    }

    private i a(int i, int i2) {
        try {
            float floatValue = Float.valueOf((float) i).floatValue() / Float.valueOf((float) i2).floatValue();
            i[] iVarArr = k;
            i iVar = iVarArr[0];
            float f = Float.MAX_VALUE;
            for (i iVar2 : iVarArr) {
                float abs = Math.abs(iVar2.c - floatValue);
                if (abs <= f) {
                    iVar = iVar2;
                    f = abs;
                }
            }
            return iVar;
        } catch (Throwable unused) {
            return k[0];
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void a(int i, j jVar) {
        NativeExpressView nativeExpressView = this.m;
        if (nativeExpressView != null) {
            nativeExpressView.a(i, jVar);
        }
    }
}
