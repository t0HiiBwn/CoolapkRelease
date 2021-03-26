package com.bytedance.sdk.openadsdk.core;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ak;

/* compiled from: InsertAdDialog */
public class n extends Dialog {
    private View a;
    private Context b;
    private ImageView c;
    private ImageView d;
    private ImageView e;
    private TextView f;
    private FrameLayout g;
    private a h;
    private boolean i;

    /* compiled from: InsertAdDialog */
    public interface a {
        void a(View view);

        void a(ImageView imageView, ImageView imageView2, FrameLayout frameLayout);

        void b(View view);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    public n(Context context) {
        this(context, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(Context context, int i2) {
        super(context, i2 == 0 ? ac.g(context, "tt_wg_insert_dialog") : i2);
        this.i = false;
        this.b = context;
    }

    public void a(boolean z, a aVar) {
        this.i = z;
        this.h = aVar;
        a();
        a aVar2 = this.h;
        if (aVar2 != null) {
            aVar2.a(this.c, this.d, this.g);
        }
    }

    private void a() {
        int i2 = 0;
        setCancelable(false);
        View inflate = LayoutInflater.from(this.b).inflate(ac.f(this.b, "tt_insert_ad_layout"), (ViewGroup) null);
        this.a = inflate;
        setContentView(inflate);
        this.c = (ImageView) this.a.findViewById(ac.e(this.b, "tt_insert_ad_img"));
        this.d = (ImageView) this.a.findViewById(ac.e(this.b, "tt_insert_dislike_icon_img"));
        this.e = (ImageView) this.a.findViewById(ac.e(this.b, "tt_insert_ad_logo"));
        this.f = (TextView) this.a.findViewById(ac.e(this.b, "tt_insert_ad_text"));
        this.g = (FrameLayout) this.a.findViewById(ac.e(this.b, "tt_insert_express_ad_fl"));
        int c2 = ak.c(this.b);
        int i3 = c2 / 3;
        this.c.setMaxWidth(c2);
        this.c.setMinimumWidth(i3);
        this.c.setMinimumHeight(i3);
        this.g.setMinimumWidth(i3);
        this.g.setMinimumHeight(i3);
        this.c.setVisibility(this.i ? 8 : 0);
        this.d.setVisibility(0);
        this.e.setVisibility(this.i ? 8 : 0);
        this.f.setVisibility(this.i ? 8 : 0);
        FrameLayout frameLayout = this.g;
        if (!this.i) {
            i2 = 8;
        }
        frameLayout.setVisibility(i2);
        int a2 = (int) ak.a(this.b, 15.0f);
        ak.a(this.d, a2, a2, a2, a2);
        this.d.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.n.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.h != null) {
                    n.this.h.a(view);
                }
            }
        });
        this.f.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.n.AnonymousClass2 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.h != null) {
                    n.this.h.b(view);
                }
            }
        });
    }

    @Override // android.app.Dialog
    public void show() {
        b();
        super.show();
    }

    private void b() {
        try {
            FrameLayout frameLayout = this.g;
            if (frameLayout == null) {
                return;
            }
            if (frameLayout.getChildCount() > 0) {
                View childAt = this.g.getChildAt(0);
                if (childAt instanceof NativeExpressView) {
                    NativeExpressView nativeExpressView = (NativeExpressView) childAt;
                    if (nativeExpressView.m()) {
                        this.g.setVisibility(0);
                        this.c.setVisibility(8);
                        this.d.setVisibility(8);
                        this.e.setVisibility(8);
                        this.f.setVisibility(8);
                        final View findViewById = nativeExpressView.findViewById(ac.e(this.b, "tt_bu_close"));
                        if (findViewById != null) {
                            findViewById.setOnClickListener(new View.OnClickListener() {
                                /* class com.bytedance.sdk.openadsdk.core.n.AnonymousClass3 */

                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (n.this.h != null) {
                                        n.this.h.a(findViewById);
                                    }
                                }
                            });
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
