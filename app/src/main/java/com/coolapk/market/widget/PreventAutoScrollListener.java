package com.coolapk.market.widget;

import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.util.UiUtils;

public class PreventAutoScrollListener extends RecyclerView.OnScrollListener {
    private boolean isDragBefore;

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(final RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        if (i == 1) {
            this.isDragBefore = true;
            recyclerView.post(new Runnable() {
                /* class com.coolapk.market.widget.PreventAutoScrollListener.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    recyclerView.removeOnScrollListener(PreventAutoScrollListener.this);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        if (i2 > 0 && !this.isDragBefore) {
            UiUtils.fastScrollToTop(recyclerView);
        }
    }
}
