package com.coolapk.market.util;

import android.view.View;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.ImageUrl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedTextUtils.kt */
final class FeedTextUtils$buildPhotoSpanText$1<T1, T2> implements Action2<String, View> {
    final /* synthetic */ ImageUrl $imageUrl;

    FeedTextUtils$buildPhotoSpanText$1(ImageUrl imageUrl) {
        this.$imageUrl = imageUrl;
    }

    public final void call(String str, View view) {
        Intrinsics.checkNotNullExpressionValue(view, "view");
        ActionManager.startPhotoViewActivity(UiUtils.getActivity(view.getContext()), new String[]{this.$imageUrl.getSourceUrl()}, new String[]{this.$imageUrl.getCompressedUrl()}, 0);
    }
}
