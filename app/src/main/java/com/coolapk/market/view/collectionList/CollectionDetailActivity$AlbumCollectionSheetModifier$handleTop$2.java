package com.coolapk.market.view.collectionList;

import android.text.TextUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.event.SetTopEvent;
import com.coolapk.market.model.Album;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/collectionList/CollectionDetailActivity$AlbumCollectionSheetModifier$handleTop$2", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onError", "", "e", "", "onNext", "s", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CollectionDetailActivity.kt */
public final class CollectionDetailActivity$AlbumCollectionSheetModifier$handleTop$2 extends EmptySubscriber<String> {
    final /* synthetic */ Album $album;
    final /* synthetic */ boolean $isTop;

    CollectionDetailActivity$AlbumCollectionSheetModifier$handleTop$2(boolean z, Album album) {
        this.$isTop = z;
        this.$album = album;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        super.onError(th);
        Toast.error(AppHolder.getApplication(), th);
    }

    public void onNext(String str) {
        Intrinsics.checkNotNullParameter(str, "s");
        super.onNext((CollectionDetailActivity$AlbumCollectionSheetModifier$handleTop$2) str);
        if (!TextUtils.isEmpty(str)) {
            Toast.show$default(AppHolder.getApplication(), str, 0, false, 12, null);
            EventBus.getDefault().post(new SetTopEvent(!this.$isTop, this.$album.getId(), this.$album.getEntityType()));
        }
    }
}
