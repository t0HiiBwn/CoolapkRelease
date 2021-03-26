package com.coolapk.market.view.album.albumv8;

import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.view.album.albumv8.AlbumEditListFragment;
import com.coolapk.market.viewholder.AlbumItemEditViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/view/album/albumv8/AlbumEditListFragment$DataAdapter$touchCallBack$1", "Lcom/coolapk/market/viewholder/AlbumItemEditViewHolder$TouchCallBack;", "touch", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumEditListFragment.kt */
public final class AlbumEditListFragment$DataAdapter$touchCallBack$1 implements AlbumItemEditViewHolder.TouchCallBack {
    final /* synthetic */ AlbumEditListFragment.DataAdapter this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    AlbumEditListFragment$DataAdapter$touchCallBack$1(AlbumEditListFragment.DataAdapter dataAdapter) {
        this.this$0 = dataAdapter;
    }

    @Override // com.coolapk.market.viewholder.AlbumItemEditViewHolder.TouchCallBack
    public void touch(RecyclerView.ViewHolder viewHolder) {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        if (TextUtils.equals(loginSession.getUid(), AlbumEditListFragment.this.mUid) && viewHolder != null) {
            AlbumEditListFragment.DataAdapter dataAdapter = AlbumEditListFragment.this.mAdapter;
            Intrinsics.checkNotNull(dataAdapter);
            dataAdapter.onStartDrag(viewHolder);
        }
    }
}
