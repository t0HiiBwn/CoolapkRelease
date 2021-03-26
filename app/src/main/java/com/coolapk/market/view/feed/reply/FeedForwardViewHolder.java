package com.coolapk.market.view.feed.reply;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemFeedForwardViewBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.ForwardFeed;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.viewholder.GenericBindHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005H\u0016R\u000e\u0010\t\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedForwardViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemFeedForwardViewBinding;", "Lcom/coolapk/market/model/ForwardFeed;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "data", "bindToContent", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedForwardViewHolder.kt */
public final class FeedForwardViewHolder extends GenericBindHolder<ItemFeedForwardViewBinding, ForwardFeed> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558701;
    private ForwardFeed data;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedForwardViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedForwardViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedForwardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(ForwardFeed forwardFeed) {
        Intrinsics.checkNotNullParameter(forwardFeed, "data");
        this.data = forwardFeed;
        ItemFeedForwardViewBinding itemFeedForwardViewBinding = (ItemFeedForwardViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedForwardViewBinding, "binding");
        itemFeedForwardViewBinding.setModel(forwardFeed);
        ItemFeedForwardViewBinding itemFeedForwardViewBinding2 = (ItemFeedForwardViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedForwardViewBinding2, "binding");
        itemFeedForwardViewBinding2.setClick(this);
        ((ItemFeedForwardViewBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        int id = view.getId();
        String str = null;
        if (id == 2131362200) {
            Context context = getContext();
            ForwardFeed forwardFeed = this.data;
            if (forwardFeed == null) {
                Intrinsics.throwUninitializedPropertyAccessException("data");
            }
            ActionManager.startFeedDetailActivity(context, forwardFeed.getId(), (String) null);
        } else if (id == 2131362672 || id == 2131363582) {
            ForwardFeed forwardFeed2 = this.data;
            if (forwardFeed2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("data");
            }
            UserInfo userInfo = forwardFeed2.getUserInfo();
            if (userInfo != null) {
                str = userInfo.getUid();
            }
            if (str != null) {
                Intrinsics.checkNotNullExpressionValue(str, "data.userInfo?.uid.elvis { return }");
                ImageView imageView = ((ItemFeedForwardViewBinding) getBinding()).iconView;
                ForwardFeed forwardFeed3 = this.data;
                if (forwardFeed3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("data");
                }
                ActionManager.startUserSpaceActivity(imageView, str, forwardFeed3.getUserAvatar());
            }
        }
    }
}
