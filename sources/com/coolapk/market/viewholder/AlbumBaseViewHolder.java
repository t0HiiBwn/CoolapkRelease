package com.coolapk.market.viewholder;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.AlbumBaseInfoBinding;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.album.AlbumDetailViewModel;

public class AlbumBaseViewHolder extends GenericBindHolder<AlbumBaseInfoBinding, HolderItem> {
    public static final int LAYOUT_ID = 2131558441;
    private AlbumBaseInfoBinding binding = ((AlbumBaseInfoBinding) getBinding());
    private AlbumDetailViewModel viewModel;

    public AlbumBaseViewHolder(AlbumDetailViewModel albumDetailViewModel, View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        this.viewModel = albumDetailViewModel;
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public void bindToContent(HolderItem holderItem) {
        this.viewModel.setAlbumIntro(holderItem.getString());
        this.binding.setViewModel(this.viewModel);
        this.binding.introduceShadowView.setMaxWords(this.viewModel.getAlbumMaxWords());
        if (holderItem.getIntValue().intValue() == 1) {
            GlideApp.with(getContext()).load((Integer) 2131231119).into(this.binding.recommendView);
            this.binding.recommendView.setVisibility(0);
        }
        this.binding.executePendingBindings();
        ViewUtil.clickListener(this.binding.introduceView, new View.OnClickListener() {
            /* class com.coolapk.market.viewholder.AlbumBaseViewHolder.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlbumBaseViewHolder.this.viewModel.setAlbumMaxWords(AlbumBaseViewHolder.this.viewModel.getAlbumMaxWords() != null ? null : 60);
                AlbumBaseViewHolder.this.binding.introduceShadowView.setMaxWords(AlbumBaseViewHolder.this.viewModel.getAlbumMaxWords());
                AlbumBaseViewHolder.this.binding.introduceShadowView.setText(AlbumBaseViewHolder.this.viewModel.getAlbumIntro());
            }
        });
        this.binding.introduceView.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.coolapk.market.viewholder.AlbumBaseViewHolder.AnonymousClass2 */

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                ActionManager.startTextViewActivity(UiUtils.getActivity(AlbumBaseViewHolder.this.getContext()), AlbumBaseViewHolder.this.viewModel.getAlbumIntro());
                return false;
            }
        });
    }
}
