package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.d.t;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.d;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ak;

/* compiled from: VideoTrafficTipLayout */
public class h {
    private View a;
    private TextView b;
    private Context c;
    private d d;
    private b e;
    private boolean f = false;
    private t g;
    private ViewStub h;
    private View i;

    /* compiled from: VideoTrafficTipLayout */
    public enum a {
        PAUSE_VIDEO,
        RELEASE_VIDEO,
        START_VIDEO
    }

    /* compiled from: VideoTrafficTipLayout */
    public interface b {
        boolean h();

        void j();
    }

    public void a(Context context, View view) {
        if (context != null && (view instanceof ViewGroup)) {
            this.i = view;
            this.c = p.a().getApplicationContext();
            this.h = (ViewStub) LayoutInflater.from(context).inflate(ac.f(context, "tt_video_traffic_tip"), (ViewGroup) view, true).findViewById(ac.e(context, "tt_video_traffic_tip_layout_viewStub"));
        }
    }

    private void a(Context context, View view, boolean z) {
        ViewStub viewStub;
        if (context != null && view != null && (viewStub = this.h) != null && viewStub.getParent() != null && this.a == null) {
            this.h.inflate();
            this.a = view.findViewById(ac.e(context, "tt_video_traffic_tip_layout"));
            this.b = (TextView) view.findViewById(ac.e(context, "tt_video_traffic_tip_tv"));
            View findViewById = view.findViewById(ac.e(context, "tt_video_traffic_continue_play_btn"));
            if (z) {
                findViewById.setClickable(true);
                findViewById.setOnClickListener(new View.OnClickListener() {
                    /* class com.bytedance.sdk.openadsdk.core.widget.h.AnonymousClass1 */

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        h.this.c();
                        if (h.this.d != null) {
                            h.this.d.a(a.START_VIDEO, (String) null);
                        }
                    }
                });
                return;
            }
            findViewById.setOnClickListener(null);
            findViewById.setClickable(false);
        }
    }

    public void a(d dVar, b bVar) {
        this.e = bVar;
        this.d = dVar;
    }

    private void b() {
        this.g = null;
    }

    public boolean a(int i2, t tVar, boolean z) {
        Context context = this.c;
        if (context == null || tVar == null) {
            return true;
        }
        a(context, this.i, z);
        this.g = tVar;
        if (i2 == 1 || i2 == 2) {
            return a(i2);
        }
        return true;
    }

    private boolean a(int i2) {
        b bVar;
        if (a() || this.f) {
            return true;
        }
        if (!(this.d == null || (bVar = this.e) == null)) {
            if (bVar.h()) {
                this.d.e(null, null);
            }
            this.d.a(a.PAUSE_VIDEO, (String) null);
        }
        a(this.g, true);
        return false;
    }

    /* access modifiers changed from: private */
    public void c() {
        if (this.c != null) {
            d();
        }
    }

    public void a(boolean z) {
        if (z) {
            b();
        }
        d();
    }

    public boolean a() {
        View view = this.a;
        return view != null && view.getVisibility() == 0;
    }

    private void d() {
        View view = this.a;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void a(t tVar, boolean z) {
        View view;
        String str;
        View view2;
        if (tVar != null && (view = this.a) != null && this.c != null && view.getVisibility() != 0) {
            b bVar = this.e;
            if (bVar != null) {
                bVar.j();
            }
            int ceil = (int) Math.ceil((((double) tVar.d()) * 1.0d) / 1048576.0d);
            if (z) {
                str = ac.a(this.c, "tt_video_without_wifi_tips") + ceil + ac.a(this.c, "tt_video_bytesize_MB") + ac.a(this.c, "tt_video_bytesize");
            } else {
                str = ac.a(this.c, "tt_video_without_wifi_tips") + ac.a(this.c, "tt_video_bytesize");
            }
            ak.a(this.a, 0);
            ak.a(this.b, str);
            if (ak.d(this.a) && (view2 = this.a) != null) {
                view2.bringToFront();
            }
        }
    }
}
