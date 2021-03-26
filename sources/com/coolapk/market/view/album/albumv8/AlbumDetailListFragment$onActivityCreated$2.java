package com.coolapk.market.view.album.albumv8;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/album/albumv8/AlbumDetailListFragment$onActivityCreated$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumDetailListFragment.kt */
public final class AlbumDetailListFragment$onActivityCreated$2 extends RecyclerView.OnScrollListener {
    final /* synthetic */ AlbumDetailListFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    AlbumDetailListFragment$onActivityCreated$2(AlbumDetailListFragment albumDetailListFragment) {
        this.this$0 = albumDetailListFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        View view;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        AlbumDetailListFragment albumDetailListFragment = this.this$0;
        albumDetailListFragment.mDistanceY = albumDetailListFragment.mDistanceY + i2;
        Rect rect = new Rect();
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(0);
        if (!(findViewHolderForAdapterPosition == null || (view = findViewHolderForAdapterPosition.itemView) == null)) {
            view.getGlobalVisibleRect(rect);
        }
        if (rect.bottom != 0) {
            FragmentActivity activity = this.this$0.getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.album.albumv8.AlbumDetailActivity");
            AlbumDetailActivity albumDetailActivity = (AlbumDetailActivity) activity;
            RecyclerView recyclerView2 = this.this$0.getRecyclerView();
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "getRecyclerView()");
            RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
            Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            float f = 1.0f;
            if (findFirstVisibleItemPosition >= 1) {
                albumDetailActivity.setToolbarAlpha(1.0f);
            } else if (findFirstVisibleItemPosition == 0) {
                View childAt = linearLayoutManager.getChildAt(0);
                Intrinsics.checkNotNull(childAt);
                float abs = ((float) Math.abs(childAt.getTop())) / ((float) albumDetailActivity.getAppBar().getMeasuredHeight());
                if (abs <= ((float) 1)) {
                    f = abs;
                }
                albumDetailActivity.setToolbarAlpha(f);
            } else {
                albumDetailActivity.setToolbarAlpha(1.0f);
            }
        }
    }
}
