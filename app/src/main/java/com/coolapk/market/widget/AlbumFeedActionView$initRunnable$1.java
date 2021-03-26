package com.coolapk.market.widget;

import android.view.LayoutInflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: AlbumFeedActionView.kt */
final class AlbumFeedActionView$initRunnable$1 implements Runnable {
    final /* synthetic */ AlbumFeedActionView this$0;

    AlbumFeedActionView$initRunnable$1(AlbumFeedActionView albumFeedActionView) {
        this.this$0 = albumFeedActionView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.this$0.holderArray.size() == 0) {
            LayoutInflater from = LayoutInflater.from(this.this$0.getContext());
            AlbumFeedActionView albumFeedActionView = this.this$0;
            Intrinsics.checkNotNullExpressionValue(from, "inflater");
            albumFeedActionView.addView(albumFeedActionView.newItemView(from, AlbumFeedActionView.Companion.getLIKE()));
            AlbumFeedActionView albumFeedActionView2 = this.this$0;
            albumFeedActionView2.addView(albumFeedActionView2.newItemView(from, AlbumFeedActionView.Companion.getREPLY()));
            AlbumFeedActionView albumFeedActionView3 = this.this$0;
            albumFeedActionView3.addView(albumFeedActionView3.newItemView(from, AlbumFeedActionView.Companion.getSHARE()));
        }
        if (this.this$0.feed != null) {
            AlbumFeedActionView albumFeedActionView4 = this.this$0;
            albumFeedActionView4.updateFeed(albumFeedActionView4.feed);
        }
    }
}
