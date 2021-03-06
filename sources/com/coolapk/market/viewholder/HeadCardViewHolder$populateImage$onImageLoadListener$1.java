package com.coolapk.market.viewholder;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.databinding.ItemHeadCardBinding;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.widget.view.ScalingImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \u0004*\u0004\u0018\u00010\f0\fH\n¢\u0006\u0002\b\r"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "drawable", "Landroid/graphics/drawable/Drawable;", "<anonymous parameter 2>", "Landroid/view/View;", "<anonymous parameter 3>", "", "<anonymous parameter 4>", "", "onLoadComplete"}, k = 3, mv = {1, 4, 2})
/* compiled from: HeadCardViewHolder.kt */
final class HeadCardViewHolder$populateImage$onImageLoadListener$1 implements OnImageLoadListener {
    final /* synthetic */ HeadCardViewHolder this$0;

    HeadCardViewHolder$populateImage$onImageLoadListener$1(HeadCardViewHolder headCardViewHolder) {
        this.this$0 = headCardViewHolder;
    }

    @Override // com.coolapk.market.app.OnImageLoadListener
    public final void onLoadComplete(String str, Drawable drawable, View view, boolean z, Throwable th) {
        ScalingImageView scalingImageView = ((ItemHeadCardBinding) this.this$0.getBinding()).topImageView;
        Intrinsics.checkNotNullExpressionValue(scalingImageView, "binding.topImageView");
        scalingImageView.setVisibility(0);
        FrameLayout frameLayout = ((ItemHeadCardBinding) this.this$0.getBinding()).topImageViewContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.topImageViewContainer");
        frameLayout.setForeground(new ColorDrawable(637534208));
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (activityNullable != null && !activityNullable.isFinishing() && drawable != null) {
            this.this$0.doCoverAnim();
        }
    }
}
