package com.bytedance.sdk.openadsdk.dislike;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.dislike.c;
import com.bytedance.sdk.openadsdk.dislike.d;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.z;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TTAdDislikeImpl */
public class b implements TTAdDislike {
    private String a;
    private final Context b;
    private l c;
    private d d;
    private c e;
    private String f;
    private Boolean g;
    private AtomicBoolean h;
    private boolean i;
    private TTAdDislike.DislikeInteractionCallback j;

    public b(Context context, l lVar) {
        this(context, lVar, null);
    }

    public b(Context context, l lVar, String str) {
        this.g = false;
        this.h = new AtomicBoolean(false);
        this.i = false;
        this.a = str;
        z.a(context, "Dislike 初始化必须使用activity,请在TTAdManager.createAdNative(activity)中传入");
        this.b = context;
        lVar.c("other");
        this.c = lVar;
        a();
    }

    private void a() {
        d dVar = new d(this.b, this.c, this.a);
        this.d = dVar;
        dVar.a(new d.a() {
            /* class com.bytedance.sdk.openadsdk.dislike.b.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.dislike.d.a
            public void a() {
                u.b("TTAdDislikeImpl", "onDislikeShow: ");
            }

            @Override // com.bytedance.sdk.openadsdk.dislike.d.a
            public void a(int i, FilterWord filterWord) {
                try {
                    if (!filterWord.hasSecondOptions()) {
                        if (b.this.j != null) {
                            b.this.j.onSelected(i, filterWord.getName());
                        }
                        b.this.h.set(true);
                    }
                    u.f("TTAdDislikeImpl", "onDislikeSelected: " + i + ", " + String.valueOf(filterWord.getName()));
                } catch (Throwable th) {
                    u.c("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.dislike.d.a
            public void a(boolean z) {
                u.f("TTAdDislikeImpl", "onDislikeCancel: ");
                try {
                    if (b.this.j != null && !z) {
                        b.this.j.onCancel();
                    }
                } catch (Throwable th) {
                    u.c("TTAdDislikeImpl", "dislike callback cancel error: ", th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.dislike.d.a
            public void b() {
                b.this.b();
            }
        });
        c cVar = new c(this.b, this.c);
        this.e = cVar;
        cVar.a(new c.a() {
            /* class com.bytedance.sdk.openadsdk.dislike.b.AnonymousClass2 */

            @Override // com.bytedance.sdk.openadsdk.dislike.c.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.dislike.c.a
            public void b() {
                try {
                    if (!b.this.g.booleanValue()) {
                        b.this.d.show();
                    }
                } catch (Throwable th) {
                    u.c("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.dislike.c.a
            public void a(int i, FilterWord filterWord) {
                try {
                    if (!filterWord.hasSecondOptions()) {
                        if (b.this.j != null) {
                            b.this.j.onSelected(i, filterWord.getName());
                        }
                        b.this.h.set(true);
                        b.this.g = true;
                    }
                } catch (Throwable th) {
                    u.c("TTAdDislikeImpl", "comment callback selected error: ", th);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void sendDislikeSource(String str) {
        this.c.c(str);
        this.f = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog() {
        Context context = this.b;
        if (!((context instanceof Activity) && !((Activity) context).isFinishing()) || this.d.isShowing() || this.e.isShowing()) {
            TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback = this.j;
            if (dislikeInteractionCallback != null) {
                dislikeInteractionCallback.onRefuse();
                return;
            }
            return;
        }
        this.d.show();
        this.h.set(false);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog(int i2) {
        if (this.i) {
            showDislikeDialog();
            return;
        }
        Context context = this.b;
        if (!((context instanceof Activity) && !((Activity) context).isFinishing()) || this.d.isShowing() || this.e.isShowing()) {
            TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback = this.j;
            if (dislikeInteractionCallback != null) {
                dislikeInteractionCallback.onRefuse();
                return;
            }
            return;
        }
        this.d.a(this.f);
        this.d.show();
        this.h.set(false);
    }

    /* access modifiers changed from: private */
    public void b() {
        Context context = this.b;
        if (((context instanceof Activity) && !((Activity) context).isFinishing()) && !this.d.isShowing() && !this.e.isShowing()) {
            this.e.show();
        }
    }

    public void a(l lVar) {
        this.d.a(lVar);
        this.e.a(lVar);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        this.j = dislikeInteractionCallback;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setIsInteractionAd() {
        this.i = true;
    }
}
