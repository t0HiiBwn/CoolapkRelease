package com.coolapk.market.view.album.albumv8;

import android.app.Activity;
import android.view.View;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.view.album.AlbumDetailViewModel;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: AlbumV8HeaderViewHolder.kt */
final class AlbumV8HeaderViewHolder$bindToContent$1 implements View.OnClickListener {
    final /* synthetic */ AlbumDetailViewModel $model;
    final /* synthetic */ AlbumV8HeaderViewHolder this$0;

    AlbumV8HeaderViewHolder$bindToContent$1(AlbumV8HeaderViewHolder albumV8HeaderViewHolder, AlbumDetailViewModel albumDetailViewModel) {
        this.this$0 = albumV8HeaderViewHolder;
        this.$model = albumDetailViewModel;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActionManager.startUserSpaceActivity((Activity) this.this$0.getContext(), this.$model.getAlbumUserName());
    }
}
