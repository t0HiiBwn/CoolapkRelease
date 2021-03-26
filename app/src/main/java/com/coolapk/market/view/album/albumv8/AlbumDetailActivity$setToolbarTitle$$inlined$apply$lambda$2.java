package com.coolapk.market.view.album.albumv8;

import android.animation.ValueAnimator;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import androidx.appcompat.widget.Toolbar;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.ColorUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "ani", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/coolapk/market/view/album/albumv8/AlbumDetailActivity$setToolbarTitle$1$2"}, k = 3, mv = {1, 4, 2})
/* compiled from: AlbumDetailActivity.kt */
final class AlbumDetailActivity$setToolbarTitle$$inlined$apply$lambda$2 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ Ref.ObjectRef $newTitle$inlined;
    final /* synthetic */ String $title$inlined;
    final /* synthetic */ AlbumDetailActivity this$0;

    AlbumDetailActivity$setToolbarTitle$$inlined$apply$lambda$2(AlbumDetailActivity albumDetailActivity, String str, Ref.ObjectRef objectRef) {
        this.this$0 = albumDetailActivity;
        this.$title$inlined = str;
        this.$newTitle$inlined = objectRef;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "ani");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        SpannableString spannableString = new SpannableString(this.$newTitle$inlined.element);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ColorUtils.adjustAlpha(AppHolder.getAppTheme().getMainTextColor(), floatValue));
        T t = this.$newTitle$inlined.element;
        Intrinsics.checkNotNull(t);
        spannableString.setSpan(foregroundColorSpan, 0, t.length(), 33);
        Toolbar toolbar = AlbumDetailActivity.access$getBinding$p(this.this$0).toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "binding.toolbar");
        toolbar.setTitle(spannableString);
    }
}
