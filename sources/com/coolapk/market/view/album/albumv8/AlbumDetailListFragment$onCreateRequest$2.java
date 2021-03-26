package com.coolapk.market.view.album.albumv8;

import com.coolapk.market.model.Album;
import com.coolapk.market.model.AlbumItem;
import java.util.List;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lrx/Observable;", "", "Lcom/coolapk/market/model/AlbumItem;", "kotlin.jvm.PlatformType", "it", "Lcom/coolapk/market/model/Album;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: AlbumDetailListFragment.kt */
final class AlbumDetailListFragment$onCreateRequest$2<T, R> implements Func1<Album, Observable<? extends List<? extends AlbumItem>>> {
    final /* synthetic */ Observable $loadApkRows;

    AlbumDetailListFragment$onCreateRequest$2(Observable observable) {
        this.$loadApkRows = observable;
    }

    public final Observable<? extends List<AlbumItem>> call(Album album) {
        return this.$loadApkRows;
    }
}
