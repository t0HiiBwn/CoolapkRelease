package com.coolapk.market.view.live;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemUserBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.LiveUser;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.ActionButtonFrameLayout;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0003H\u0016R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/view/live/BannedUserViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "handler", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "binding", "Lcom/coolapk/market/databinding/ItemUserBinding;", "kotlin.jvm.PlatformType", "getHandler", "()Lcom/coolapk/market/viewholder/ItemActionHandler;", "liveUser", "Lcom/coolapk/market/model/LiveUser;", "bindTo", "", "data", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BannedUserViewHolder.kt */
public final class BannedUserViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558974;
    private final ItemUserBinding binding = ((ItemUserBinding) getBinding());
    private final ItemActionHandler handler;
    private LiveUser liveUser;

    public final ItemActionHandler getHandler() {
        return this.handler;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BannedUserViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(itemActionHandler, "handler");
        this.handler = itemActionHandler;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/live/BannedUserViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BannedUserViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.LiveUser");
        this.liveUser = (LiveUser) obj;
        ItemUserBinding itemUserBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemUserBinding, "binding");
        LiveUser liveUser2 = this.liveUser;
        if (liveUser2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveUser");
        }
        itemUserBinding.setModel(liveUser2.getUserInfo());
        this.binding.executePendingBindings();
        TextView textView = this.binding.actionButton;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.actionButton");
        textView.setText("解除");
        ActionButtonFrameLayout actionButtonFrameLayout = this.binding.actionContainer;
        Intrinsics.checkNotNullExpressionValue(actionButtonFrameLayout, "binding.actionContainer");
        actionButtonFrameLayout.setVisibility(0);
        ActionButtonFrameLayout actionButtonFrameLayout2 = this.binding.actionContainer;
        Intrinsics.checkNotNullExpressionValue(actionButtonFrameLayout2, "binding.actionContainer");
        actionButtonFrameLayout2.setStateListAnimator(null);
        this.binding.actionContainer.setOnClickListener(this);
        this.binding.actionButton.setTextColor(AppHolder.getAppTheme().getColorAccent());
        LinearLayout linearLayout = this.binding.detailContainerView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.detailContainerView");
        linearLayout.setVisibility(8);
        TextView textView2 = this.binding.introduceView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.introduceView");
        textView2.setVisibility(8);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        LiveUser liveUser2 = this.liveUser;
        if (liveUser2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveUser");
        }
        view.setTag(liveUser2);
        if (view.getId() != 2131362205) {
            this.handler.onItemClick(this, view);
            return;
        }
        LiveUser liveUser3 = this.liveUser;
        if (liveUser3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveUser");
        }
        String uid = liveUser3.getUid();
        LiveUser liveUser4 = this.liveUser;
        if (liveUser4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveUser");
        }
        ActionManager.startUserSpaceActivity(view, uid, liveUser4.getUserAvatar());
    }
}
