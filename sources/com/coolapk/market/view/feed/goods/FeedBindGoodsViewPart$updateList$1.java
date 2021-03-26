package com.coolapk.market.view.feed.goods;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.databinding.FeedBindGoodsMainBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedBindGoodsViewPart.kt */
final class FeedBindGoodsViewPart$updateList$1 implements Runnable {
    final /* synthetic */ List $dataList;
    final /* synthetic */ boolean $moveToEnd;
    final /* synthetic */ FeedBindGoodsViewPart this$0;

    FeedBindGoodsViewPart$updateList$1(FeedBindGoodsViewPart feedBindGoodsViewPart, boolean z, List list) {
        this.this$0 = feedBindGoodsViewPart;
        this.$moveToEnd = z;
        this.$dataList = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean isEmpty = this.this$0.adapter.getCurrentList().isEmpty();
        RecyclerView recyclerView = ((FeedBindGoodsMainBinding) this.this$0.getBinding()).recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        int i = 0;
        recyclerView.setVisibility(isEmpty ^ true ? 0 : 8);
        TextView textView = ((FeedBindGoodsMainBinding) this.this$0.getBinding()).emptyTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.emptyTextView");
        TextView textView2 = textView;
        if (!isEmpty) {
            i = 8;
        }
        textView2.setVisibility(i);
        if (this.$moveToEnd) {
            ((FeedBindGoodsMainBinding) this.this$0.getBinding()).recyclerView.smoothScrollToPosition(this.$dataList.size() - 1);
        }
    }
}
