package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.a.a;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.dislike.b;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.x;

public abstract class BackupView extends FrameLayout {
    protected Context a;
    protected l b;
    protected b c;
    protected TTDislikeDialogAbstract d;
    protected String e = "embeded_ad";
    protected int f;
    protected int g;
    protected int h;
    protected boolean i = true;
    protected boolean j = true;

    protected abstract void a(int i2, j jVar);

    @Override // android.view.View
    public Object getTag() {
        return "tt_express_backup_fl_tag_26";
    }

    public BackupView(Context context) {
        super(context);
        setTag("tt_express_backup_fl_tag_26");
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag("tt_express_backup_fl_tag_26");
    }

    public void setDislikeInner(TTAdDislike tTAdDislike) {
        if (tTAdDislike instanceof b) {
            this.c = (b) tTAdDislike;
        }
    }

    public void setDislikeOuter(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        l lVar;
        if (!(tTDislikeDialogAbstract == null || (lVar = this.b) == null)) {
            tTDislikeDialogAbstract.setMaterialMeta(lVar);
        }
        this.d = tTDislikeDialogAbstract;
    }

    public void a() {
        TTDislikeDialogAbstract tTDislikeDialogAbstract = this.d;
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.show();
            return;
        }
        b bVar = this.c;
        if (bVar != null) {
            bVar.showDislikeDialog();
        } else {
            TTDelegateActivity.a(this.b);
        }
    }

    protected String getNameOrSource() {
        l lVar = this.b;
        if (lVar == null) {
            return "";
        }
        if (lVar.ah() != null && !TextUtils.isEmpty(this.b.ah().c())) {
            return this.b.ah().c();
        }
        if (!TextUtils.isEmpty(this.b.S())) {
            return this.b.S();
        }
        return "";
    }

    protected String getTitle() {
        if (this.b.ah() != null && !TextUtils.isEmpty(this.b.ah().c())) {
            return this.b.ah().c();
        }
        if (!TextUtils.isEmpty(this.b.S())) {
            return this.b.S();
        }
        return !TextUtils.isEmpty(this.b.ad()) ? this.b.ad() : "";
    }

    protected String getDescription() {
        if (!TextUtils.isEmpty(this.b.ad())) {
            return this.b.ad();
        }
        return !TextUtils.isEmpty(this.b.ae()) ? this.b.ae() : "";
    }

    public float getRealWidth() {
        return (float) ak.b(this.a, (float) this.f);
    }

    public float getRealHeight() {
        return (float) ak.b(this.a, (float) this.g);
    }

    protected void a(View view, boolean z) {
        com.bytedance.sdk.openadsdk.core.a.b bVar;
        if (view != null) {
            if (z) {
                Context context = this.a;
                l lVar = this.b;
                String str = this.e;
                bVar = new a(context, lVar, str, aj.a(str));
            } else {
                Context context2 = this.a;
                l lVar2 = this.b;
                String str2 = this.e;
                bVar = new com.bytedance.sdk.openadsdk.core.a.b(context2, lVar2, str2, aj.a(str2));
            }
            view.setOnTouchListener(bVar);
            view.setOnClickListener(bVar);
            bVar.a(new a() {
                /* class com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.AnonymousClass1 */

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a
                public void a(int i, j jVar) {
                    BackupView.this.a(i, jVar);
                }
            });
        }
    }

    protected View getVideoView() {
        NativeVideoTsView nativeVideoTsView;
        if (!(this.b == null || this.a == null)) {
            if (b()) {
                try {
                    nativeVideoTsView = new NativeVideoTsView(this.a, this.b, this.e, true, false);
                    nativeVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.a() {
                        /* class com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.AnonymousClass2 */

                        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                        public void a(boolean z, long j, long j2, long j3, boolean z2) {
                        }
                    });
                    nativeVideoTsView.setIsAutoPlay(this.i);
                    nativeVideoTsView.setIsQuiet(this.j);
                } catch (Throwable unused) {
                }
                if (!b() && nativeVideoTsView != null && nativeVideoTsView.a(0, true, false)) {
                    return nativeVideoTsView;
                }
            }
            nativeVideoTsView = null;
            if (!b()) {
            }
        }
        return null;
    }

    private boolean b() {
        l lVar = this.b;
        return lVar != null && l.c(lVar);
    }

    protected void a(int i2) {
        this.j = p.h().a(this.h);
        int c2 = p.h().c(i2);
        if (3 == c2) {
            this.i = false;
        } else if (1 == c2 && x.d(this.a)) {
            this.i = true;
        } else if (2 != c2) {
        } else {
            if (x.e(this.a) || x.d(this.a)) {
                this.i = true;
            }
        }
    }

    protected void a(View view) {
        l lVar = this.b;
        if (lVar != null && lVar.R() != null && view != null) {
            if (this.b.k() != 1 || !this.i) {
                a(view, false);
            } else {
                a(view, true);
            }
        }
    }
}
