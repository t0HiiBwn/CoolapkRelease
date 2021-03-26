package com.coolapk.market.view.collectionList;

import com.coolapk.market.model.Collection;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J)\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&¢\u0006\u0002\u0010\rJ)\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&¢\u0006\u0002\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/collectionList/CollectionDetailView;", "", "onCollectionUpdate", "", "collection", "Lcom/coolapk/market/model/Collection;", "onFollowCollectionResult", "following", "", "result", "", "error", "", "(ZLjava/lang/Integer;Ljava/lang/Throwable;)V", "onLikeResult", "like", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CollectionDetailPresenter.kt */
public interface CollectionDetailView {
    void onCollectionUpdate(Collection collection);

    void onFollowCollectionResult(boolean z, Integer num, Throwable th);

    void onLikeResult(boolean z, Integer num, Throwable th);
}
