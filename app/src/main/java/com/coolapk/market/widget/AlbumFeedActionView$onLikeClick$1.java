package com.coolapk.market.widget;

import com.coolapk.market.event.AlbumLikeEvent;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.LikeResult;
import com.coolapk.market.network.Result;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/coolapk/market/widget/AlbumFeedActionView$onLikeClick$1", "Lrx/Subscriber;", "Lcom/coolapk/market/network/Result;", "Lcom/coolapk/market/model/LikeResult;", "onCompleted", "", "onError", "e", "", "onNext", "result", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumFeedActionView.kt */
public final class AlbumFeedActionView$onLikeClick$1 extends Subscriber<Result<LikeResult>> {
    final /* synthetic */ Album $current;
    final /* synthetic */ AlbumFeedActionView this$0;

    @Override // rx.Observer
    public void onCompleted() {
    }

    AlbumFeedActionView$onLikeClick$1(AlbumFeedActionView albumFeedActionView, Album album) {
        this.this$0 = albumFeedActionView;
        this.$current = album;
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        if (this.$current == this.this$0.feed) {
            Toast.error(this.this$0.getContext(), th);
            this.this$0.updateFeed(this.$current);
        }
    }

    public void onNext(Result<LikeResult> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (this.$current == this.this$0.feed) {
            EventBus.getDefault().post(new AlbumLikeEvent(this.$current.getId(), true, result.getData()));
        }
    }
}
