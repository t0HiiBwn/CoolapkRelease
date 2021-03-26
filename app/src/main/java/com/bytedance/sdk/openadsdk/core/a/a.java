package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.n;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.util.Map;

/* compiled from: ClickCreativeListener */
public class a extends b {
    private boolean D = false;
    private TTDrawFeedAd.DrawVideoListener E;
    private int F;
    private boolean a = true;
    private boolean b = false;

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public void a(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.E = drawVideoListener;
    }

    public a(Context context, l lVar, String str, int i) {
        super(context, lVar, str, i);
    }

    public void a(boolean z) {
        this.a = z;
    }

    public void b(boolean z) {
        this.b = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
    public void a(View view, int i, int i2, int i3, int i4) {
        View view2;
        TTDrawFeedAd.DrawVideoListener drawVideoListener;
        if (!a(2)) {
            if (!h() || !c(view) || this.D) {
                i();
                u.b("ClickCreativeListener", "走创意区域点击事件.....");
                if (this.c == null) {
                    this.c = p.a();
                }
                if (this.c != null) {
                    long j = this.w;
                    long j2 = this.x;
                    if (this.g == null) {
                        view2 = null;
                    } else {
                        view2 = (View) this.g.get();
                    }
                    this.i = a(i, i2, i3, i4, j, j2, view2, this.h == null ? null : (View) this.h.get());
                    int T = this.d.T();
                    if (T == 2 || T == 3) {
                        if (this.k != null || this.b) {
                            d.a(this.c, "click_button", this.d, this.i, this.e, true, (Map<String, Object>) this.o);
                        }
                        z.a(true);
                        boolean a2 = z.a(this.c, this.d, this.f, this.k, this.p, aj.a(this.f), this.n, true, (Map<String, Object>) this.o, this.r, a(this.e));
                        if (this.a) {
                            d.a(this.c, "click", this.d, this.i, this.e, a2, this.o);
                        }
                    } else if (T != 4) {
                        if (T != 5) {
                            T = -1;
                        } else {
                            String b2 = b(this.e);
                            if (!TextUtils.isEmpty(b2)) {
                                d.a(this.c, "click_call", this.d, this.i, b2, true, (Map<String, Object>) this.o);
                            }
                            d.a(this.c, "click", this.d, this.i, this.e, aj.d(view.getContext(), this.d.aa()), this.o);
                        }
                    } else if (!(this.k == null && this.p == null) && !"feed_video_middle_page".equals(this.e) && this.d.C() && !TextUtils.isEmpty(n.a(this.d))) {
                        boolean a3 = z.a(this.c, this.d, this.f, this.k, this.p, this.e, this.n, true, (Map<String, Object>) this.o, this.r, a(this.e));
                        if (this.a) {
                            d.a(this.c, "click", this.d, this.i, this.e, a3, this.o);
                        }
                    } else if (this.n != null) {
                        this.n.g();
                        if (this.a) {
                            d.a(this.c, "click", this.d, this.i, this.e, true, (Map<String, Object>) this.o);
                        }
                    }
                    if (this.j != null) {
                        this.j.a(view, T);
                    }
                    if (aj.b(this.d) && (drawVideoListener = this.E) != null) {
                        drawVideoListener.onClick();
                        return;
                    }
                    return;
                }
                return;
            }
            u.b("ClickCreativeListener", "拦截原生视频view走普通点击事件.....");
            super.a(view, i, i2, i3, i4);
        }
    }

    private boolean a(String str) {
        if (!TextUtils.isEmpty(str) && str.equals("feed_video_middle_page")) {
            return true;
        }
        return false;
    }

    protected boolean a() {
        if (this.d == null) {
            return true;
        }
        int c = p.h().c(aj.d(this.d.aj()));
        if (c == 1) {
            return x.d(this.c);
        }
        if (c != 2) {
            if (c != 3) {
                return true;
            }
            return false;
        } else if (x.e(this.c) || x.d(this.c)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean f() {
        return this.d != null && this.d.k() == 1 && l.c(this.d);
    }

    private boolean c(View view) {
        if (view == null) {
            return false;
        }
        if (view instanceof NativeVideoTsView) {
            u.c("ClickCreativeListener", "NativeVideoTsView....");
            return true;
        } else if (view.getId() == ac.e(this.c, "tt_video_ad_cover_center_layout") || view.getId() == ac.e(this.c, "tt_video_ad_logo_image") || view.getId() == ac.e(this.c, "tt_video_btn_ad_image_tv") || view.getId() == ac.e(this.c, "tt_video_ad_name") || view.getId() == ac.e(this.c, "tt_video_ad_button")) {
            u.c("ClickCreativeListener", "tt_video_ad_cover_center_layout....");
            return true;
        } else if (view.getId() == ac.e(this.c, "tt_root_view") || view.getId() == ac.e(this.c, "tt_video_play")) {
            u.c("ClickCreativeListener", "tt_root_view....");
            return true;
        } else if (!(view instanceof ViewGroup)) {
            return false;
        } else {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    return false;
                }
                if (c(viewGroup.getChildAt(i))) {
                    return true;
                }
                i++;
            }
        }
    }

    private boolean g() {
        return this instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.d;
    }

    private boolean h() {
        if (this.d == null || g() || !l.c(this.d)) {
            return false;
        }
        if (this.F == 0) {
            this.F = aj.c(this.d.aj());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("!isViewVisibility()=");
        sb.append(!b());
        sb.append(",isAutoPlay()=");
        sb.append(a());
        sb.append(",!isCoverPageVisibility()=");
        sb.append(!c());
        u.b("ClickCreativeListener", sb.toString());
        if (this.F == 5 && f() && a() && !b() && !c()) {
            return false;
        }
        int i = this.F;
        if (i == 1 || i == 2 || i == 5) {
            return true;
        }
        return false;
    }

    private String b(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1695837674:
                if (str.equals("banner_ad")) {
                    c = 0;
                    break;
                }
                break;
            case -712491894:
                if (str.equals("embeded_ad")) {
                    c = 1;
                    break;
                }
                break;
            case 174971131:
                if (str.equals("splash_ad")) {
                    c = 2;
                    break;
                }
                break;
            case 1844104722:
                if (str.equals("interaction")) {
                    c = 3;
                    break;
                }
                break;
            case 1912999166:
                if (str.equals("draw_ad")) {
                    c = 4;
                    break;
                }
                break;
            case 2091589896:
                if (str.equals("slide_banner_ad")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return "banner_call";
            case 1:
            case 4:
                return "feed_call";
            case 2:
                return "splash_ad";
            case 3:
                return "interaction_call";
            case 5:
                return "banner_call";
            default:
                return "";
        }
    }

    public void c(boolean z) {
        this.D = z;
    }

    private void i() {
        if (this.D && this.n != null && (this.n instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d)) {
            ((com.bytedance.sdk.openadsdk.downloadnew.a.d) this.n).f(true);
        }
    }
}
