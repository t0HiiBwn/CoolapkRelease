package com.coolapk.market.view.album.albumv8;

import com.coolapk.market.model.Album;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "album", "Lcom/coolapk/market/model/Album;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: AlbumDetailListFragment.kt */
final class AlbumDetailListFragment$onCreateRequest$1<T> implements Action1<Album> {
    final /* synthetic */ AlbumDetailListFragment this$0;

    AlbumDetailListFragment$onCreateRequest$1(AlbumDetailListFragment albumDetailListFragment) {
        this.this$0 = albumDetailListFragment;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: androidx.databinding.ObservableArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    public final void call(Album album) {
        this.this$0.mAlbum = album;
        AlbumDetailListFragment albumDetailListFragment = this.this$0;
        Album album2 = albumDetailListFragment.mAlbum;
        Intrinsics.checkNotNull(album2);
        albumDetailListFragment.mUid = album2.getUid();
        this.this$0.dataList.add(0, this.this$0.mAlbum);
        this.this$0.isLoadedHeader = true;
        this.this$0.updateContentUI();
    }
}
