package com.coolapk.market.view.base;

import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public abstract class OnLoadMoreListener extends RecyclerView.OnScrollListener {
    private static final boolean DEBUG = false;
    private static final String TAG = "OnLoadMoreListener";

    protected abstract void onLoadMore(int i);

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (i2 > 0) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            int itemCount = layoutManager.getItemCount();
            if (itemCount == 1) {
                onLoadMore(itemCount);
            } else if (itemCount - 1 > 0) {
                if (layoutManager instanceof LinearLayoutManager) {
                    if (((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() >= itemCount - 2) {
                        onLoadMore(itemCount);
                    }
                } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                    int[] findLastVisibleItemPositions = ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(null);
                    int length = findLastVisibleItemPositions.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        if (findLastVisibleItemPositions[i3] >= itemCount - 2) {
                            onLoadMore(itemCount);
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        int itemCount;
        if (i == 1 && !ViewCompat.canScrollVertically(recyclerView, 1) && (itemCount = recyclerView.getLayoutManager().getItemCount() - 1) > 0) {
            onLoadMore(itemCount);
        }
    }
}
