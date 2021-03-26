package com.coolapk.market.view.album.albumv8;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.event.AlbumLikeEvent;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.LikeResult;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/album/albumv8/AlbumDetailActivity$onLikeClick$1", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/model/LikeResult;", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumDetailActivity.kt */
public final class AlbumDetailActivity$onLikeClick$1 extends EmptySubscriber<LikeResult> {
    final /* synthetic */ Album $album;
    final /* synthetic */ AlbumDetailActivity this$0;

    AlbumDetailActivity$onLikeClick$1(AlbumDetailActivity albumDetailActivity, Album album) {
        this.this$0 = albumDetailActivity;
        this.$album = album;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        super.onError(th);
        Toast.error(this.this$0.getActivity(), th);
        this.this$0.isPostingLike = false;
    }

    public void onNext(LikeResult likeResult) {
        Intrinsics.checkNotNullParameter(likeResult, "t");
        super.onNext((AlbumDetailActivity$onLikeClick$1) likeResult);
        EventBus.getDefault().post(new AlbumLikeEvent(this.$album.getAlbumId(), false, likeResult));
        this.this$0.isPostingLike = false;
    }
}
