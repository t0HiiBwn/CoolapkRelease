package com.coolapk.market.view.app;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.view.app.AppViewViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \u0004*\u0004\u0018\u00010\f0\fH\n¢\u0006\u0002\b\r"}, d2 = {"<anonymous>", "", "uri", "", "kotlin.jvm.PlatformType", "drawable", "Landroid/graphics/drawable/Drawable;", "<anonymous parameter 2>", "Landroid/view/View;", "<anonymous parameter 3>", "", "<anonymous parameter 4>", "", "onLoadComplete"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppViewBaseInfoViewHolder.kt */
final class AppViewBaseInfoViewHolder$onPhotoImageLoadListener$1 implements OnImageLoadListener {
    final /* synthetic */ AppViewBaseInfoViewHolder this$0;

    AppViewBaseInfoViewHolder$onPhotoImageLoadListener$1(AppViewBaseInfoViewHolder appViewBaseInfoViewHolder) {
        this.this$0 = appViewBaseInfoViewHolder;
    }

    @Override // com.coolapk.market.app.OnImageLoadListener
    public final void onLoadComplete(String str, Drawable drawable, View view, boolean z, Throwable th) {
        if (drawable != null) {
            try {
                AppViewViewModel.ImageSize thumbnailSize = this.this$0.viewModel.getThumbnailSize(str);
                Intrinsics.checkNotNull(thumbnailSize);
                if (thumbnailSize.width != drawable.getIntrinsicWidth() || thumbnailSize.height != drawable.getIntrinsicHeight()) {
                    this.this$0.viewModel.setThumbnailSize(str, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                }
            } catch (Exception e) {
                LogUtils.e(e, "Unexpected", new Object[0]);
            }
        }
    }
}
