package com.coolapk.market.view.center;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.databinding.ItemCenterUserMenuBinding;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.viewholder.GenericBindHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/view/center/MeUserMenuViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemCenterUserMenuBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/center/CenterPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/center/CenterPresenter;)V", "dataList", "", "Lcom/coolapk/market/view/center/UserMenu;", "getPresenter", "()Lcom/coolapk/market/view/center/CenterPresenter;", "bindToContent", "", "data", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MeUserMenuViewHolder.kt */
public final class MeUserMenuViewHolder extends GenericBindHolder<ItemCenterUserMenuBinding, HolderItem> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558644;
    private final List<UserMenu> dataList = new ArrayList();
    private final CenterPresenter presenter;

    public final CenterPresenter getPresenter() {
        return this.presenter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MeUserMenuViewHolder(View view, DataBindingComponent dataBindingComponent, CenterPresenter centerPresenter) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(centerPresenter, "presenter");
        this.presenter = centerPresenter;
        RecyclerView recyclerView = ((ItemCenterUserMenuBinding) getBinding()).recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/center/MeUserMenuViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MeUserMenuViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(HolderItem holderItem) {
        Intrinsics.checkNotNullParameter(holderItem, "data");
        List<UserMenu> activeUserMenu = this.presenter.getMenuPresenter().getActiveUserMenu();
        if (!Intrinsics.areEqual(activeUserMenu, this.dataList)) {
            this.dataList.clear();
            this.dataList.addAll(activeUserMenu);
            RecyclerView recyclerView = ((ItemCenterUserMenuBinding) getBinding()).recyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
            recyclerView.setAdapter(new MeUserMenuViewHolder$bindToContent$1(this));
            ((ItemCenterUserMenuBinding) getBinding()).coolapkCardView.bindWithViewHolder(this, activeUserMenu);
            ((ItemCenterUserMenuBinding) getBinding()).executePendingBindings();
        }
    }
}
