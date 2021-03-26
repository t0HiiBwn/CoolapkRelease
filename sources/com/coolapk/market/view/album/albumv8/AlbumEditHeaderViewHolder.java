package com.coolapk.market.view.album.albumv8;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemAlbumEditHeaderBinding;
import com.coolapk.market.model.Album;
import com.coolapk.market.view.album.AlbumCreateDialog;
import com.coolapk.market.view.album.AlbumDetailViewModel;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/album/albumv8/AlbumEditHeaderViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemAlbumEditHeaderBinding;", "Lcom/coolapk/market/model/Album;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "viewModel", "Lcom/coolapk/market/view/album/AlbumDetailViewModel;", "bindToContent", "", "data", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumEditHeaderViewHolder.kt */
public final class AlbumEditHeaderViewHolder extends GenericBindHolder<ItemAlbumEditHeaderBinding, Album> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558585;
    private AlbumDetailViewModel viewModel = new AlbumDetailViewModel(getContext());

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlbumEditHeaderViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/album/albumv8/AlbumEditHeaderViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AlbumEditHeaderViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(Album album) {
        this.viewModel.setAlbum(album);
        ItemAlbumEditHeaderBinding itemAlbumEditHeaderBinding = (ItemAlbumEditHeaderBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAlbumEditHeaderBinding, "binding");
        itemAlbumEditHeaderBinding.setModel(this.viewModel);
        ItemAlbumEditHeaderBinding itemAlbumEditHeaderBinding2 = (ItemAlbumEditHeaderBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAlbumEditHeaderBinding2, "binding");
        itemAlbumEditHeaderBinding2.setClick(this);
        ((ItemAlbumEditHeaderBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        FragmentManager childFragmentManager;
        super.onClick(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if ((valueOf != null && valueOf.intValue() == 2131363596) || ((valueOf != null && valueOf.intValue() == 2131362451) || ((valueOf != null && valueOf.intValue() == 2131362444) || (valueOf != null && valueOf.intValue() == 2131362751)))) {
            DataBindingComponent component = getComponent();
            if (!(component instanceof FragmentBindingComponent)) {
                component = null;
            }
            FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
            Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
            if (!(fragment instanceof AlbumEditListFragment)) {
                fragment = null;
            }
            AlbumEditListFragment albumEditListFragment = (AlbumEditListFragment) fragment;
            if (albumEditListFragment != null && (childFragmentManager = albumEditListFragment.getChildFragmentManager()) != null) {
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "this.inFragment<AlbumEdi…FragmentManager ?: return");
                AlbumCreateDialog newInstance = AlbumCreateDialog.newInstance(this.viewModel.getAlbumId(), this.viewModel.getAlbumTitle(), this.viewModel.getAlbumIntro());
                newInstance.setViewModel(this.viewModel);
                newInstance.show(childFragmentManager, (String) null);
            }
        }
    }
}
