package com.coolapk.market.view.node.rating;

import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.coolapk.market.databinding.ItemLoginUserNodeRatingSelectorBinding;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.view.base.refresh.BasePopMenu;
import com.coolapk.market.viewholder.GenericBindHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/view/node/rating/LoginUserNodeRatingSelectorViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemLoginUserNodeRatingSelectorBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "presenter", "Lcom/coolapk/market/view/node/rating/NodeRatingPresenter;", "(Landroid/view/View;Lcom/coolapk/market/view/node/rating/NodeRatingPresenter;)V", "getPresenter", "()Lcom/coolapk/market/view/node/rating/NodeRatingPresenter;", "bindToContent", "", "data", "onClick", "view", "showPopMenu", "target", "updateArgs", "args", "Lcom/coolapk/market/view/node/rating/NodeRatingArgs;", "updateUIWithArgs", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LoginUserNodeRatingSelectorViewHolder.kt */
public final class LoginUserNodeRatingSelectorViewHolder extends GenericBindHolder<ItemLoginUserNodeRatingSelectorBinding, HolderItem> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558816;
    private final NodeRatingPresenter presenter;

    public final NodeRatingPresenter getPresenter() {
        return this.presenter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoginUserNodeRatingSelectorViewHolder(View view, NodeRatingPresenter nodeRatingPresenter) {
        super(view, null, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(nodeRatingPresenter, "presenter");
        this.presenter = nodeRatingPresenter;
        ItemLoginUserNodeRatingSelectorBinding itemLoginUserNodeRatingSelectorBinding = (ItemLoginUserNodeRatingSelectorBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemLoginUserNodeRatingSelectorBinding, "binding");
        itemLoginUserNodeRatingSelectorBinding.setClick(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/node/rating/LoginUserNodeRatingSelectorViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LoginUserNodeRatingSelectorViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(HolderItem holderItem) {
        Intrinsics.checkNotNullParameter(holderItem, "data");
        updateUIWithArgs(this.presenter.getArgs());
    }

    /* access modifiers changed from: private */
    public final void updateArgs(NodeRatingArgs nodeRatingArgs) {
        this.presenter.setArgs(nodeRatingArgs);
        updateUIWithArgs(nodeRatingArgs);
    }

    private final void updateUIWithArgs(NodeRatingArgs nodeRatingArgs) {
        String str;
        String targetType = nodeRatingArgs.getTargetType();
        if (targetType != null) {
            int hashCode = targetType.hashCode();
            if (hashCode != 49) {
                if (hashCode == 55 && targetType.equals("7")) {
                    str = "数码";
                    TextView textView = ((ItemLoginUserNodeRatingSelectorBinding) getBinding()).orderText;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.orderText");
                    textView.setText(str);
                }
            } else if (targetType.equals("1")) {
                str = "应用";
                TextView textView = ((ItemLoginUserNodeRatingSelectorBinding) getBinding()).orderText;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.orderText");
                textView.setText(str);
            }
        }
        str = "全部";
        TextView textView = ((ItemLoginUserNodeRatingSelectorBinding) getBinding()).orderText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.orderText");
        textView.setText(str);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        if (view.getId() == 2131363058) {
            ImageView imageView = ((ItemLoginUserNodeRatingSelectorBinding) getBinding()).orderImage;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.orderImage");
            showPopMenu(imageView);
        }
    }

    private final void showPopMenu(View view) {
        NodeRatingArgs args = this.presenter.getArgs();
        BasePopMenu basePopMenu = new BasePopMenu(getContext(), view);
        Menu menu = basePopMenu.getMenu();
        Intrinsics.checkNotNullExpressionValue(menu, "popupMenu.menu");
        menu.add(0, 0, 0, "全部");
        menu.add(0, 1, 0, "数码");
        menu.add(0, 2, 0, "应用");
        basePopMenu.setOnMenuItemClickListener(new LoginUserNodeRatingSelectorViewHolder$showPopMenu$1(this, args));
        basePopMenu.show();
    }
}
