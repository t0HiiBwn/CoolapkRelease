package com.coolapk.market.view.album.albumv8;

import android.text.TextUtils;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemNewAddBinding;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/view/album/albumv8/AlbumEmptyViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemNewAddBinding;", "Lcom/coolapk/market/model/Album;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "isMyAlbum", "", "mAlbum", "bindToContent", "", "data", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumEmptyViewHolder.kt */
public final class AlbumEmptyViewHolder extends GenericBindHolder<ItemNewAddBinding, Album> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558833;
    private boolean isMyAlbum;
    private Album mAlbum;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlbumEmptyViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/album/albumv8/AlbumEmptyViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AlbumEmptyViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(Album album) {
        this.mAlbum = album;
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        Album album2 = this.mAlbum;
        Intrinsics.checkNotNull(album2);
        this.isMyAlbum = TextUtils.equals(loginSession.getUid(), album2.getUid());
        ItemNewAddBinding itemNewAddBinding = (ItemNewAddBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemNewAddBinding, "binding");
        itemNewAddBinding.setTitleText(this.isMyAlbum ? "该应用集还没有添加任何应用或游戏" : "这个应用集还没添加应用或游戏");
        ItemNewAddBinding itemNewAddBinding2 = (ItemNewAddBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemNewAddBinding2, "binding");
        itemNewAddBinding2.setActionText("去添加");
        ItemNewAddBinding itemNewAddBinding3 = (ItemNewAddBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemNewAddBinding3, "binding");
        itemNewAddBinding3.setIsMyAlbum(this.isMyAlbum);
        ItemNewAddBinding itemNewAddBinding4 = (ItemNewAddBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemNewAddBinding4, "binding");
        itemNewAddBinding4.setClick(this);
        ((ItemNewAddBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == 2131361981 && this.isMyAlbum) {
            ActionManager.startAlbumPickActivity(getContext(), this.mAlbum);
        }
    }
}
