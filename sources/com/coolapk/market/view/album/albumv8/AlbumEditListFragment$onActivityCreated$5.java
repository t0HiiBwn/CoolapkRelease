package com.coolapk.market.view.album.albumv8;

import android.view.View;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.widget.Toast;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: AlbumEditListFragment.kt */
final class AlbumEditListFragment$onActivityCreated$5 implements View.OnClickListener {
    final /* synthetic */ AlbumEditListFragment this$0;

    AlbumEditListFragment$onActivityCreated$5(AlbumEditListFragment albumEditListFragment) {
        this.this$0 = albumEditListFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Album album = this.this$0.mAlbum;
        List<AlbumItem> list = null;
        if (CollectionUtils.safeSize(album != null ? album.getAlbumItems() : null) < 200) {
            if (CollectionUtils.safeSize(this.this$0.dataList) > 1) {
                AlbumEditListFragment albumEditListFragment = this.this$0;
                Album.Builder newBuilder = Album.newBuilder(albumEditListFragment.mAlbum);
                List<AlbumItem> subList = this.this$0.dataList.subList(1, this.this$0.dataList.size() - 1);
                if (TypeIntrinsics.isMutableList(subList)) {
                    list = subList;
                }
                albumEditListFragment.mAlbum = newBuilder.albumItems(list).build();
            }
            ActionManager.startAlbumPickActivity(this.this$0.getActivity(), this.this$0.mAlbum);
            return;
        }
        Toast.show$default(this.this$0.getActivity(), this.this$0.getString(2131886649), 0, false, 12, null);
    }
}
