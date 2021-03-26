package com.coolapk.market.view.album.albumv8;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: AlbumDetailListFragment.kt */
final class AlbumDetailListFragment$onActivityCreated$1$onInterceptTouchEvent$1 implements Runnable {
    final /* synthetic */ AlbumDetailListFragment$onActivityCreated$1 this$0;

    AlbumDetailListFragment$onActivityCreated$1$onInterceptTouchEvent$1(AlbumDetailListFragment$onActivityCreated$1 albumDetailListFragment$onActivityCreated$1) {
        this.this$0 = albumDetailListFragment$onActivityCreated$1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Rect rect = new Rect();
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.this$0.this$0.getRecyclerView().findViewHolderForAdapterPosition(1);
        if (findViewHolderForAdapterPosition != null) {
            Intrinsics.checkNotNull(findViewHolderForAdapterPosition);
            findViewHolderForAdapterPosition.itemView.getGlobalVisibleRect(rect);
            RecyclerView.ViewHolder findViewHolderForAdapterPosition2 = this.this$0.this$0.getRecyclerView().findViewHolderForAdapterPosition(0);
            if (findViewHolderForAdapterPosition2 != null) {
                View view = findViewHolderForAdapterPosition2.itemView;
                Intrinsics.checkNotNullExpressionValue(view, "viewholder.itemView");
                int height = view.getHeight();
                if (this.this$0.getToolbarHeight() <= rect.top) {
                    this.this$0.this$0.getRecyclerView().smoothScrollBy(0, (-height) + rect.top);
                }
            }
        }
    }
}
