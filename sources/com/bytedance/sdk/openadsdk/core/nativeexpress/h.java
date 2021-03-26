package com.bytedance.sdk.openadsdk.core.nativeexpress;

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
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.h.d;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Locale;

/* compiled from: FeedExpressBackupView */
class h extends BackupView {
    private static i[] k = {new i(2, 3.0241935f, 375, 124), new i(3, 1.25f, 375, 300), new i(4, 1.4044944f, 375, 267), new i(16, 1.25f, 375, 300), new i(5, 1.25f, 375, 300), new i(15, 1.25f, 375, 300)};
    private int l;
    private View m;
    private NativeExpressView n;
    private a o;

    public h(Context context) {
        super(context);
        this.a = context;
    }

    void a(l lVar, NativeExpressView nativeExpressView, a aVar) {
        u.b("FeedExpressBackupView", "show backup view");
        setBackgroundColor(-1);
        this.b = lVar;
        this.n = nativeExpressView;
        this.o = aVar;
        int d = aj.d(this.b.aj());
        this.l = d;
        a(d);
        b();
        this.n.addView(this, new ViewGroup.LayoutParams(-2, -2));
    }

    private void b() {
        i b = b(this.b.ak());
        this.f = ak.c(this.a, (float) this.n.getExpectExpressWidth());
        this.g = ak.c(this.a, (float) this.n.getExpectExpressHeight());
        if (this.f <= 0) {
            this.f = ak.c(this.a);
        }
        if (this.g <= 0) {
            this.g = Float.valueOf(((float) this.f) / b.c).intValue();
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
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        if (aj.c(this.b.aj()) == 9) {
            this.e = "draw_ad";
            g();
            return;
        }
        this.e = "embeded_ad";
        int ak = this.b.ak();
        if (ak == 2) {
            c();
        } else if (ak == 3) {
            e();
        } else if (ak == 4) {
            d();
        } else if (ak == 5) {
            h();
        } else if (ak == 15) {
            f();
        } else if (ak == 16) {
            i();
        }
    }

    private i b(int i) {
        i[] iVarArr = k;
        i iVar = iVarArr[0];
        try {
            for (i iVar2 : iVarArr) {
                if (iVar2.a == i) {
                    return iVar2;
                }
            }
            return iVar;
        } catch (Throwable unused) {
            return iVar;
        }
    }

    private void a(ImageView imageView) {
        d.a(this.a).a(this.b.Z().get(0).a(), imageView);
    }

    private void c() {
        View inflate = LayoutInflater.from(this.a).inflate(ac.f(this.a, "tt_backup_feed_img_small"), (ViewGroup) this, true);
        this.m = inflate;
        a((ImageView) inflate.findViewById(ac.e(this.a, "tt_bu_img")));
        ((TextView) this.m.findViewById(ac.e(this.a, "tt_bu_desc"))).setText(getDescription());
        ((TextView) this.m.findViewById(ac.e(this.a, "tt_bu_title"))).setText(getTitle());
        ((ImageView) this.m.findViewById(ac.e(this.a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.nativeexpress.h.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        a((View) this, true);
    }

    private void d() {
        View inflate = LayoutInflater.from(this.a).inflate(ac.f(this.a, "tt_backup_feed_img_group"), (ViewGroup) this, true);
        this.m = inflate;
        TextView textView = (TextView) this.m.findViewById(ac.e(this.a, "tt_bu_download"));
        String a = this.b.Z().get(0).a();
        String a2 = this.b.Z().get(1).a();
        String a3 = this.b.Z().get(2).a();
        d.a(this.a).a(a, (ImageView) inflate.findViewById(ac.e(this.a, "tt_bu_img_1")));
        d.a(this.a).a(a2, (ImageView) this.m.findViewById(ac.e(this.a, "tt_bu_img_2")));
        d.a(this.a).a(a3, (ImageView) this.m.findViewById(ac.e(this.a, "tt_bu_img_3")));
        d.a(this.a).a(this.b.U().a(), (ImageView) this.m.findViewById(ac.e(this.a, "tt_bu_icon")));
        ((ImageView) this.m.findViewById(ac.e(this.a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.nativeexpress.h.AnonymousClass2 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        ((TextView) this.m.findViewById(ac.e(this.a, "tt_bu_desc"))).setText(getDescription());
        ((TextView) this.m.findViewById(ac.e(this.a, "tt_bu_title"))).setText(getTitle());
        if (!TextUtils.isEmpty(this.b.af())) {
            textView.setText(this.b.af());
        }
        a((View) this, false);
        a((View) textView, true);
    }

    private void e() {
        View inflate = LayoutInflater.from(this.a).inflate(ac.f(this.a, "tt_backup_feed_horizontal"), (ViewGroup) this, true);
        this.m = inflate;
        inflate.findViewById(ac.e(this.a, "tt_bu_video_container")).setVisibility(8);
        this.m.findViewById(ac.e(this.a, "tt_bu_img_container")).setVisibility(0);
        ImageView imageView = (ImageView) this.m.findViewById(ac.e(this.a, "tt_bu_img"));
        TextView textView = (TextView) this.m.findViewById(ac.e(this.a, "tt_bu_download"));
        imageView.setAdjustViewBounds(true);
        imageView.setMaxHeight(this.g);
        a(imageView);
        ((ImageView) this.m.findViewById(ac.e(this.a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.nativeexpress.h.AnonymousClass3 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        ((TextView) this.m.findViewById(ac.e(this.a, "tt_bu_desc"))).setText(getDescription());
        ((TextView) this.m.findViewById(ac.e(this.a, "tt_bu_title"))).setText(getTitle());
        if (!TextUtils.isEmpty(this.b.af())) {
            textView.setText(this.b.af());
        }
        a((View) this, false);
        a((View) textView, true);
    }

    private void f() {
        View inflate = LayoutInflater.from(this.a).inflate(ac.f(this.a, "tt_backup_feed_vertical"), (ViewGroup) this, true);
        this.m = inflate;
        inflate.findViewById(ac.e(this.a, "tt_bu_video_container")).setVisibility(0);
        this.m.findViewById(ac.e(this.a, "tt_bu_img_container")).setVisibility(8);
        FrameLayout frameLayout = (FrameLayout) this.m.findViewById(ac.e(this.a, "tt_bu_video_container_inner"));
        TextView textView = (TextView) this.m.findViewById(ac.e(this.a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.m.findViewById(ac.e(this.a, "tt_bu_title"));
        TextView textView3 = (TextView) this.m.findViewById(ac.e(this.a, "tt_bu_video_name1"));
        TextView textView4 = (TextView) this.m.findViewById(ac.e(this.a, "tt_bu_video_name2"));
        TextView textView5 = (TextView) this.m.findViewById(ac.e(this.a, "tt_bu_download"));
        TextView textView6 = (TextView) this.m.findViewById(ac.e(this.a, "tt_bu_video_score"));
        TTRatingBar tTRatingBar = (TTRatingBar) this.m.findViewById(ac.e(this.a, "tt_bu_video_score_bar"));
        d.a(this.a).a(this.b.U().a(), (ImageView) this.m.findViewById(ac.e(this.a, "tt_bu_video_icon")));
        ((ImageView) this.m.findViewById(ac.e(this.a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.nativeexpress.h.AnonymousClass4 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        int e = this.b.ah() != null ? this.b.ah().e() : 4;
        textView6.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf((float) e)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(e);
        tTRatingBar.setStarImageWidth((float) ak.c(this.a, 15.0f));
        tTRatingBar.setStarImageHeight((float) ak.c(this.a, 14.0f));
        tTRatingBar.setStarImagePadding((float) ak.c(this.a, 4.0f));
        tTRatingBar.a();
        textView3.setText(getNameOrSource());
        textView4.setText(getTitle());
        textView.setText(getDescription());
        textView2.setText(getTitle());
        if (!TextUtils.isEmpty(this.b.af())) {
            textView5.setText(this.b.af());
        }
        View videoView = getVideoView();
        if (videoView != null) {
            int i = (this.f * 123) / 375;
            frameLayout.removeAllViews();
            frameLayout.addView(videoView, new ViewGroup.LayoutParams(i, (i * 16) / 9));
        }
        a((View) this, false);
        a((View) textView5, true);
    }

    private void g() {
        View inflate = LayoutInflater.from(this.a).inflate(ac.f(this.a, "tt_backup_draw"), (ViewGroup) this, true);
        this.m = inflate;
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(ac.e(this.a, "tt_bu_video_container"));
        TextView textView = (TextView) this.m.findViewById(ac.e(this.a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.m.findViewById(ac.e(this.a, "tt_bu_title"));
        TextView textView3 = (TextView) this.m.findViewById(ac.e(this.a, "tt_bu_download"));
        textView.setText(getDescription());
        textView2.setText(getTitle());
        if (!TextUtils.isEmpty(this.b.af())) {
            textView3.setText(this.b.af());
        }
        View videoView = getVideoView();
        if (videoView != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(videoView, new ViewGroup.LayoutParams(-1, -1));
        }
        a((View) textView2, false);
        a((View) textView, false);
        a((View) textView3, true);
    }

    private void h() {
        View inflate = LayoutInflater.from(this.a).inflate(ac.f(this.a, "tt_backup_feed_horizontal"), (ViewGroup) this, true);
        this.m = inflate;
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(ac.e(this.a, "tt_bu_video_container"));
        frameLayout.setVisibility(0);
        this.m.findViewById(ac.e(this.a, "tt_bu_img_container")).setVisibility(8);
        TextView textView = (TextView) this.m.findViewById(ac.e(this.a, "tt_bu_download"));
        ((ImageView) this.m.findViewById(ac.e(this.a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.nativeexpress.h.AnonymousClass5 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        ((TextView) this.m.findViewById(ac.e(this.a, "tt_bu_desc"))).setText(getDescription());
        ((TextView) this.m.findViewById(ac.e(this.a, "tt_bu_title"))).setText(getTitle());
        if (!TextUtils.isEmpty(this.b.af())) {
            textView.setText(this.b.af());
        }
        View videoView = getVideoView();
        if (videoView != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(videoView, new ViewGroup.LayoutParams(this.f, (this.f * 9) / 16));
        }
        a((View) this, false);
        a((View) textView, true);
    }

    private void i() {
        View inflate = LayoutInflater.from(this.a).inflate(ac.f(this.a, "tt_backup_feed_vertical"), (ViewGroup) this, true);
        this.m = inflate;
        inflate.findViewById(ac.e(this.a, "tt_bu_video_container")).setVisibility(8);
        this.m.findViewById(ac.e(this.a, "tt_bu_img_container")).setVisibility(0);
        TextView textView = (TextView) this.m.findViewById(ac.e(this.a, "tt_bu_download"));
        a((ImageView) this.m.findViewById(ac.e(this.a, "tt_bu_img")));
        ((ImageView) this.m.findViewById(ac.e(this.a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.nativeexpress.h.AnonymousClass6 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        ((TextView) this.m.findViewById(ac.e(this.a, "tt_bu_desc"))).setText(getDescription());
        ((TextView) this.m.findViewById(ac.e(this.a, "tt_bu_title"))).setText(getTitle());
        if (!TextUtils.isEmpty(this.b.af())) {
            textView.setText(this.b.af());
        }
        a((View) this, false);
        a((View) textView, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void a(int i, j jVar) {
        NativeExpressView nativeExpressView = this.n;
        if (nativeExpressView != null) {
            nativeExpressView.a(i, jVar);
        }
    }
}
