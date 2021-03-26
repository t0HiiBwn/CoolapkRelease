package com.coolapk.market.view.album.albumv8;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.coolapk.market.util.DisplayUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: AlbumV8HeaderViewHolder.kt */
final class AlbumV8HeaderViewHolder$bindToContent$5 implements Runnable {
    final /* synthetic */ AlbumV8HeaderViewHolder this$0;

    AlbumV8HeaderViewHolder$bindToContent$5(AlbumV8HeaderViewHolder albumV8HeaderViewHolder) {
        this.this$0 = albumV8HeaderViewHolder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageView imageView = this.this$0.mBinding.recommendView;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.recommendView");
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        LinearLayout linearLayout = this.this$0.mBinding.introduceView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.introduceView");
        layoutParams2.setMargins(0, linearLayout.getTop() - DisplayUtils.dp2px(this.this$0.getContext(), 18.0f), DisplayUtils.dp2px(this.this$0.getContext(), 12.0f), 0);
        ImageView imageView2 = this.this$0.mBinding.recommendView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "mBinding.recommendView");
        imageView2.setLayoutParams(layoutParams2);
    }
}
