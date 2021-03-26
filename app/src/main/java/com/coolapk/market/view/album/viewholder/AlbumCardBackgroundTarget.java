package com.coolapk.market.view.album.viewholder;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.widget.ImageView;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.coolapk.market.AppHolder;
import com.coolapk.market.imageloader.PaletteBitmap;
import com.coolapk.market.util.ColorUtil2;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.ResourceUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0016J\"\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00022\u0010\u0010\u0017\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u000f0\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/view/album/viewholder/AlbumCardBackgroundTarget;", "Lcom/bumptech/glide/request/target/CustomTarget;", "Lcom/coolapk/market/imageloader/PaletteBitmap;", "bgView", "Landroid/widget/ImageView;", "buttonView", "usePureColor", "", "(Landroid/widget/ImageView;Landroid/widget/ImageView;Z)V", "contentBackground", "", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "windowsBackground", "Landroid/graphics/drawable/Drawable;", "onLoadCleared", "", "placeholder", "onLoadFailed", "errorDrawable", "onResourceReady", "resource", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "setBackground", "color", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumCardBackgroundTarget.kt */
public final class AlbumCardBackgroundTarget extends CustomTarget<PaletteBitmap> {
    public static final Companion Companion = new Companion(null);
    public static final int DURATION = 0;
    private final ImageView bgView;
    private final ImageView buttonView;
    private final int contentBackground;
    private final Context context;
    private final boolean usePureColor;
    private final Drawable windowsBackground;

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
        onResourceReady((PaletteBitmap) obj, (Transition<? super PaletteBitmap>) transition);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AlbumCardBackgroundTarget(ImageView imageView, ImageView imageView2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageView, (i & 2) != 0 ? null : imageView2, (i & 4) != 0 ? false : z);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlbumCardBackgroundTarget(ImageView imageView, ImageView imageView2, boolean z) {
        super(24, 24);
        Intrinsics.checkNotNullParameter(imageView, "bgView");
        this.bgView = imageView;
        this.buttonView = imageView2;
        this.usePureColor = z;
        Context context2 = imageView.getContext();
        this.context = context2;
        this.windowsBackground = ResourceUtils.getDrawable(context2, 2131100010);
        this.contentBackground = ResourceUtils.getColorInt(context2, 2131100007);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/album/viewholder/AlbumCardBackgroundTarget$Companion;", "", "()V", "DURATION", "", "createShapeDrawable", "Landroid/graphics/drawable/GradientDrawable;", "startColor", "endColor", "getNodeColors", "Lkotlin/Pair;", "color", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AlbumCardBackgroundTarget.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Pair<Integer, Integer> getNodeColors(int i) {
            if (AppHolder.getAppTheme().isAmoledTheme() || AppHolder.getAppTheme().isNightTheme()) {
                return TuplesKt.to(Integer.valueOf(ColorUtil2.INSTANCE.getDarkenColor(i, 0.15f)), Integer.valueOf(ColorUtil2.INSTANCE.getDarkenColor(i, 0.23f)));
            }
            return TuplesKt.to(Integer.valueOf(ColorUtil2.INSTANCE.getDarkenColor(i, 0.01f)), Integer.valueOf(ColorUtil2.INSTANCE.getDarkenColor(i, 0.02f)));
        }

        public final GradientDrawable createShapeDrawable(int i, int i2) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setGradientType(0);
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            gradientDrawable.setColors(new int[]{i, i2});
            return gradientDrawable;
        }
    }

    @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
    public void onLoadFailed(Drawable drawable) {
        LogUtils.e("AlbumCardBackgroundTarget load failed", new Object[0]);
        setBackground(this.contentBackground);
    }

    public void onResourceReady(PaletteBitmap paletteBitmap, Transition<? super PaletteBitmap> transition) {
        Intrinsics.checkNotNullParameter(paletteBitmap, "resource");
        setBackground(ColorUtil2.INSTANCE.getThemeColor(paletteBitmap.getPalette(), this.contentBackground));
    }

    private final void setBackground(int i) {
        Companion companion = Companion;
        Pair<Integer, Integer> nodeColors = companion.getNodeColors(i);
        int intValue = nodeColors.component1().intValue();
        int intValue2 = nodeColors.component2().intValue();
        GradientDrawable colorDrawable = this.usePureColor ? new ColorDrawable(intValue2) : companion.createShapeDrawable(intValue, intValue2);
        ImageView imageView = this.buttonView;
        if (imageView != null) {
            imageView.setImageDrawable(colorDrawable);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{this.windowsBackground.mutate(), colorDrawable});
        this.bgView.setImageDrawable(transitionDrawable);
        transitionDrawable.startTransition(0);
    }
}
