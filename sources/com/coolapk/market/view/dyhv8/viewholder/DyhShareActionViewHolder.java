package com.coolapk.market.view.dyhv8.viewholder;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemFeedShareActionViewBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.view.dyhv8.DyhArticleDetailPresenter;
import com.coolapk.market.view.sharev8.ShareUtils;
import com.coolapk.market.viewholder.GenericBindHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/dyhv8/viewholder/DyhShareActionViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemFeedShareActionViewBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/dyhv8/DyhArticleDetailPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/dyhv8/DyhArticleDetailPresenter;)V", "getPresenter", "()Lcom/coolapk/market/view/dyhv8/DyhArticleDetailPresenter;", "bindToContent", "", "data", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhShareActionViewHolder.kt */
public final class DyhShareActionViewHolder extends GenericBindHolder<ItemFeedShareActionViewBinding, HolderItem> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558726;
    private final DyhArticleDetailPresenter presenter;

    public final DyhArticleDetailPresenter getPresenter() {
        return this.presenter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DyhShareActionViewHolder(View view, DataBindingComponent dataBindingComponent, DyhArticleDetailPresenter dyhArticleDetailPresenter) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(dyhArticleDetailPresenter, "presenter");
        this.presenter = dyhArticleDetailPresenter;
        ItemFeedShareActionViewBinding itemFeedShareActionViewBinding = (ItemFeedShareActionViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedShareActionViewBinding, "binding");
        itemFeedShareActionViewBinding.setClick(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/dyhv8/viewholder/DyhShareActionViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhShareActionViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(HolderItem holderItem) {
        Intrinsics.checkNotNullParameter(holderItem, "data");
        ((ItemFeedShareActionViewBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        DyhArticle dyhArticle = this.presenter.getDyhArticle();
        switch (view.getId()) {
            case 2131362519:
                Activity currentActivity = AppHolder.getCurrentActivity();
                if (currentActivity != null) {
                    Boolean checkLogin = ActionManager.checkLogin(currentActivity);
                    Intrinsics.checkNotNullExpressionValue(checkLogin, "ActionManager.checkLogin(it)");
                    if (checkLogin.booleanValue()) {
                        ActionManager.startCollectionSelectActivity(getContext(), dyhArticle.getId(), "article");
                        return;
                    }
                    return;
                }
                return;
            case 2131362970:
                ActionManager.startForwardEntityActivity(getContext(), dyhArticle);
                return;
            case 2131363153:
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ShareUtils.shareToQQ(context, dyhArticle);
                return;
            case 2131363964:
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                ShareUtils.shareToWechatUrl(context2, dyhArticle, true);
                return;
            case 2131363965:
                Context context3 = getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "context");
                ShareUtils.shareToWechatUrl(context3, dyhArticle, false);
                return;
            default:
                return;
        }
    }
}
