package com.bytedance.sdk.openadsdk.component.interaction;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.b.d;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTInteractionAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Map;

/* compiled from: TTInteractionAdImpl */
class b implements TTInteractionAd {
    private static boolean k;
    private final String a = "interaction";
    private final Context b;
    private final l c;
    private Dialog d;
    private com.bytedance.sdk.openadsdk.dislike.b e;
    private TTInteractionAd.AdInteractionListener f;
    private a g;
    private com.bytedance.sdk.openadsdk.core.l h;
    private ImageView i;
    private ImageView j;

    b(Context context, l lVar) {
        this.b = context;
        this.c = lVar;
    }

    void a(com.bytedance.sdk.openadsdk.core.l lVar) {
        this.h = lVar;
        d.a(this.c);
        if (getInteractionType() == 4) {
            this.g = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.b, this.c, "interaction");
        }
        this.e = new com.bytedance.sdk.openadsdk.dislike.b(this.b, this.c, "interaction");
        a();
    }

    private void a() {
        if (this.d == null) {
            n nVar = new n(this.b);
            this.d = nVar;
            nVar.setOnShowListener(new DialogInterface.OnShowListener() {
                /* class com.bytedance.sdk.openadsdk.component.interaction.b.AnonymousClass1 */

                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    if (b.this.d.isShowing()) {
                        u.e("AdEvent", "pangolin ad show " + aj.a(b.this.c, (View) null));
                        d.a(b.this.b, b.this.c, "interaction", (Map<String, Object>) null);
                        if (b.this.f != null) {
                            b.this.f.onAdShow();
                        }
                    }
                }
            });
            this.d.setOnDismissListener(new DialogInterface.OnDismissListener() {
                /* class com.bytedance.sdk.openadsdk.component.interaction.b.AnonymousClass2 */

                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (b.this.g != null) {
                        b.this.g.d();
                    }
                }
            });
            ((n) this.d).a(false, new n.a() {
                /* class com.bytedance.sdk.openadsdk.component.interaction.b.AnonymousClass3 */

                @Override // com.bytedance.sdk.openadsdk.core.n.a
                public void a(ImageView imageView, ImageView imageView2, FrameLayout frameLayout) {
                    b.this.j = imageView;
                    b.this.i = imageView2;
                    b.this.b();
                    b.this.c();
                }

                @Override // com.bytedance.sdk.openadsdk.core.n.a
                public void a(View view) {
                    b.this.d();
                    d.a(b.this.b, b.this.c, "interaction");
                    if (b.this.f != null) {
                        b.this.f.onAdDismiss();
                    }
                    u.b("TTInteractionAdImpl", "dislike事件发出");
                }

                @Override // com.bytedance.sdk.openadsdk.core.n.a
                public void b(View view) {
                    b.this.e.showDislikeDialog();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        com.bytedance.sdk.openadsdk.core.a.a aVar = new com.bytedance.sdk.openadsdk.core.a.a(this.b, this.c, "interaction", 3);
        aVar.a(this.j);
        aVar.b(this.i);
        aVar.a(this.g);
        aVar.a(new b.a() {
            /* class com.bytedance.sdk.openadsdk.component.interaction.b.AnonymousClass4 */

            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view, int i) {
                if (b.this.f != null) {
                    b.this.f.onAdClicked();
                }
                if (i == 2 || i == 3 || i == 5) {
                    b.this.d();
                    if (b.this.f != null) {
                        b.this.f.onAdDismiss();
                    }
                }
            }
        });
        this.j.setOnClickListener(aVar);
        this.j.setOnTouchListener(aVar);
    }

    /* access modifiers changed from: private */
    public void c() {
        int b2 = this.c.Z().get(0).b();
        com.bytedance.sdk.openadsdk.h.d.a(this.b).g().a(this.c.Z().get(0).a(), new d.AbstractC0032d() {
            /* class com.bytedance.sdk.openadsdk.component.interaction.b.AnonymousClass5 */

            @Override // com.bytedance.sdk.adnet.b.d.AbstractC0032d
            public void a() {
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void a(m<Bitmap> mVar) {
            }

            @Override // com.bytedance.sdk.adnet.b.d.AbstractC0032d
            public void b() {
            }

            @Override // com.bytedance.sdk.adnet.b.d.AbstractC0032d
            public void a(d.c cVar, boolean z) {
                if (cVar != null && cVar.a() != null) {
                    b.this.j.setImageBitmap(cVar.a());
                    if (b.this.h != null) {
                        b.this.h.a();
                    }
                } else if (b.this.h != null) {
                    b.this.h.b();
                }
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void b(m<Bitmap> mVar) {
                if (b.this.h != null) {
                    b.this.h.b();
                }
            }
        }, b2, b2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public void setAdInteractionListener(TTInteractionAd.AdInteractionListener adInteractionListener) {
        this.f = adInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public void setShowDislikeIcon(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback != null) {
            this.e.setDislikeInteractionCallback(dislikeInteractionCallback);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        a aVar = this.g;
        if (aVar != null) {
            aVar.a(tTAppDownloadListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public int getInteractionType() {
        l lVar = this.c;
        if (lVar == null) {
            return -1;
        }
        return lVar.T();
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public Map<String, Object> getMediaExtraInfo() {
        l lVar = this.c;
        if (lVar != null) {
            return lVar.as();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public void showInteractionAd(Activity activity) {
        if (!activity.isFinishing()) {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                throw new IllegalStateException("不能在子线程调用 TTInteractionAd.showInteractionAd");
            } else if (!k) {
                k = true;
                this.d.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        k = false;
        this.d.dismiss();
    }
}
