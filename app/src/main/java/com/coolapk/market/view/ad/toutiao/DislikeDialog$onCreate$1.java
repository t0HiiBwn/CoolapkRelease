package com.coolapk.market.view.ad.toutiao;

import android.view.View;
import android.widget.AdapterView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.coolapk.market.view.ad.toutiao.DislikeDialog;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, d2 = {"<anonymous>", "", "parent", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: DislikeDialog.kt */
final class DislikeDialog$onCreate$1 implements AdapterView.OnItemClickListener {
    final /* synthetic */ DislikeDialog this$0;

    DislikeDialog$onCreate$1(DislikeDialog dislikeDialog) {
        this.this$0 = dislikeDialog;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.this$0.dismiss();
        if (this.this$0.getOnDislikeItemClick() != null) {
            Intrinsics.checkNotNullExpressionValue(adapterView, "parent");
            Object item = adapterView.getAdapter().getItem(i);
            Objects.requireNonNull(item, "null cannot be cast to non-null type com.bytedance.sdk.openadsdk.FilterWord");
            FilterWord filterWord = (FilterWord) item;
            DislikeDialog.OnDislikeItemClick onDislikeItemClick = this.this$0.getOnDislikeItemClick();
            if (onDislikeItemClick != null) {
                onDislikeItemClick.onItemClick(filterWord);
            }
        }
    }
}
