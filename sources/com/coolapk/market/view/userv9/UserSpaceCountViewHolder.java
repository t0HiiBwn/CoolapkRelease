package com.coolapk.market.view.userv9;

import android.view.View;
import android.widget.TextView;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemUserSpaceCountBinding;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.viewholder.GenericBindHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0017¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/userv9/UserSpaceCountViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemUserSpaceCountBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Lcom/coolapk/market/binding/FragmentBindingComponent;", "(Landroid/view/View;Lcom/coolapk/market/binding/FragmentBindingComponent;)V", "bindToContent", "", "holderItem", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserFeedListFragment.kt */
public final class UserSpaceCountViewHolder extends GenericBindHolder<ItemUserSpaceCountBinding, HolderItem> {
    public static final Companion Companion = new Companion(null);
    public static final String ENTITY_TYPE = "USER_SPACE_COUNT";
    public static final int LAYOUT_ID = 2131558982;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserSpaceCountViewHolder(View view, FragmentBindingComponent fragmentBindingComponent) {
        super(view, fragmentBindingComponent);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(fragmentBindingComponent, "component");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/userv9/UserSpaceCountViewHolder$Companion;", "", "()V", "ENTITY_TYPE", "", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserFeedListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(HolderItem holderItem) {
        Intrinsics.checkNotNullParameter(holderItem, "holderItem");
        TextView textView = ((ItemUserSpaceCountBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText(holderItem.getString());
    }
}
