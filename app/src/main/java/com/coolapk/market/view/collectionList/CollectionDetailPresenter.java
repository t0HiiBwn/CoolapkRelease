package com.coolapk.market.view.collectionList;

import android.os.Bundle;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Collection;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.BasePresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u000bJ\u0012\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003R\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/view/collectionList/CollectionDetailPresenter;", "Lcom/coolapk/market/view/base/BasePresenter;", "collection", "Lcom/coolapk/market/model/Collection;", "view", "Lcom/coolapk/market/view/collectionList/CollectionDetailView;", "(Lcom/coolapk/market/model/Collection;Lcom/coolapk/market/view/collectionList/CollectionDetailView;)V", "<set-?>", "getCollection", "()Lcom/coolapk/market/model/Collection;", "isPostingFollow", "", "isPostingLike", "getView", "()Lcom/coolapk/market/view/collectionList/CollectionDetailView;", "followCollection", "", "isFollowing", "likeCollection", "isLiking", "onInitPresenterState", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "updateCollection", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CollectionDetailPresenter.kt */
public final class CollectionDetailPresenter implements BasePresenter {
    private Collection collection;
    private boolean isPostingFollow;
    private boolean isPostingLike;
    private final CollectionDetailView view;

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onInitPresenterState(Bundle bundle) {
    }

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
    }

    public CollectionDetailPresenter(Collection collection2, CollectionDetailView collectionDetailView) {
        Intrinsics.checkNotNullParameter(collection2, "collection");
        Intrinsics.checkNotNullParameter(collectionDetailView, "view");
        this.view = collectionDetailView;
        this.collection = collection2;
    }

    public final CollectionDetailView getView() {
        return this.view;
    }

    public final Collection getCollection() {
        return this.collection;
    }

    public final void updateCollection(Collection collection2) {
        Intrinsics.checkNotNullParameter(collection2, "collection");
        this.collection = collection2;
        this.view.onCollectionUpdate(collection2);
    }

    public final void likeCollection(boolean z) {
        if (!this.isPostingLike) {
            this.isPostingLike = true;
            if (z) {
                DataManager.getInstance().unLikeCollection(this.collection.getId()).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new CollectionDetailPresenter$likeCollection$1(this, z));
            } else {
                DataManager.getInstance().likeCollection(this.collection.getId()).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new CollectionDetailPresenter$likeCollection$2(this, z));
            }
        }
    }

    public final void followCollection(boolean z) {
        if (!this.isPostingFollow) {
            this.isPostingFollow = true;
            String id = this.collection.getId();
            if (z) {
                DataManager.getInstance().unFollowCollection(id).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new CollectionDetailPresenter$followCollection$1(this, z));
            } else {
                DataManager.getInstance().followCollection(id).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new CollectionDetailPresenter$followCollection$2(this, z));
            }
        }
    }
}
