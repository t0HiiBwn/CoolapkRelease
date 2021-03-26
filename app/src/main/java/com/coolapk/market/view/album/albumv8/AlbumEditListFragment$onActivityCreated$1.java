package com.coolapk.market.view.album.albumv8;

import com.coolapk.market.widget.touchhelper.ItemTouchHelperAdapter;
import com.coolapk.market.widget.touchhelper.SimpleItemTouchHelperCallback;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/coolapk/market/view/album/albumv8/AlbumEditListFragment$onActivityCreated$1", "Lcom/coolapk/market/widget/touchhelper/SimpleItemTouchHelperCallback;", "isLongPressDragEnabled", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumEditListFragment.kt */
public final class AlbumEditListFragment$onActivityCreated$1 extends SimpleItemTouchHelperCallback {
    final /* synthetic */ AlbumEditListFragment this$0;

    @Override // com.coolapk.market.widget.touchhelper.SimpleItemTouchHelperCallback, androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlbumEditListFragment$onActivityCreated$1(AlbumEditListFragment albumEditListFragment, ItemTouchHelperAdapter itemTouchHelperAdapter) {
        super(itemTouchHelperAdapter);
        this.this$0 = albumEditListFragment;
    }
}
