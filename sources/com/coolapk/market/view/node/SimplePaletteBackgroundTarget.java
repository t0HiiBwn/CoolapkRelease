package com.coolapk.market.view.node;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.coolapk.market.imageloader.PaletteBitmap;
import com.coolapk.market.util.ColorUtil2;
import com.coolapk.market.util.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00022\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/view/node/SimplePaletteBackgroundTarget;", "Lcom/bumptech/glide/request/target/CustomTarget;", "Lcom/coolapk/market/imageloader/PaletteBitmap;", "topView", "Landroid/view/View;", "(Landroid/view/View;)V", "onLoadCleared", "", "placeholder", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "errorDrawable", "onResourceReady", "resource", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "setBackground", "color", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SimplePaletteBackgroundTarget.kt */
public final class SimplePaletteBackgroundTarget extends CustomTarget<PaletteBitmap> {
    public static final Companion Companion = new Companion(null);
    public static final int DURATION = 200;
    private final View topView;

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimplePaletteBackgroundTarget(View view) {
        super(24, 24);
        Intrinsics.checkNotNullParameter(view, "topView");
        this.topView = view;
    }

    @Override // com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
        onResourceReady((PaletteBitmap) obj, (Transition<? super PaletteBitmap>) transition);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/node/SimplePaletteBackgroundTarget$Companion;", "", "()V", "DURATION", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SimplePaletteBackgroundTarget.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
    public void onLoadFailed(Drawable drawable) {
        LogUtils.e("SimplePaletteBackgroundTarget load failed", new Object[0]);
    }

    public void onResourceReady(PaletteBitmap paletteBitmap, Transition<? super PaletteBitmap> transition) {
        Intrinsics.checkNotNullParameter(paletteBitmap, "resource");
        setBackground(ColorUtil2.getThemeColor$default(ColorUtil2.INSTANCE, paletteBitmap.getPalette(), 0, 2, null));
    }

    private final void setBackground(int i) {
        this.topView.setBackground(new ColorDrawable(ColorUtil2.INSTANCE.getDarkenColor(i, 0.23f)));
    }
}
