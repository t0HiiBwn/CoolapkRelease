package com.coolapk.market.viewholder;

import android.view.View;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemAlbumBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Album;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.widget.binding.BindingExtensionKt;

public class AlbumViewHolder extends BindingViewHolder {
    public static final int LAYOUT_ID = 2131558578;
    private Album album;

    public AlbumViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        ItemAlbumBinding itemAlbumBinding = (ItemAlbumBinding) getBinding();
        itemAlbumBinding.setViewHolder(this);
        Album album2 = (Album) obj;
        this.album = album2;
        itemAlbumBinding.setAlbum(album2);
        itemAlbumBinding.iconView.setBorderWidth(DisplayUtils.dp2pxf(getContext(), 1.0f));
        itemAlbumBinding.iconView.setBorderColor(AppHolder.getAppTheme().getContentBackgroundDividerColor());
        itemAlbumBinding.recommendView.setVisibility(this.album.getRecommend() > 0 ? 0 : 8);
        itemAlbumBinding.setViewHolder(this);
        itemAlbumBinding.itemAlbumView.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.coolapk.market.viewholder.AlbumViewHolder.AnonymousClass1 */

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                EntityExtendsKt.showItemDialog(AlbumViewHolder.this.album, UiUtils.getActivity(AlbumViewHolder.this.getContext()));
                return true;
            }
        });
        BindingExtensionKt.updateInfo(itemAlbumBinding.topView, this.album.getTopInfo(), this.album.isTop());
        itemAlbumBinding.topDivider.setVisibility(itemAlbumBinding.topView.getRoot().getVisibility());
        itemAlbumBinding.executePendingBindings();
    }

    @Bindable
    public String getUserName() {
        return String.format(getContext().getString(2131886581), this.album.getUserName(), Integer.valueOf(this.album.getTotalApkNum()));
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == 2131362752) {
            ActionManagerCompat.startActivityByUrl(getContext(), this.album.getUrl(), this.album.getTitle(), this.album.getSubTitle());
        }
    }
}
