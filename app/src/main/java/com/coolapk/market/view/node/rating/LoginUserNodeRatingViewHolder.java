package com.coolapk.market.view.node.rating;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.databinding.ItemUserNodeRatingBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.NodeRating;
import com.coolapk.market.model.NodeTargetInfo;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.view.feed.NodeRatingDialog;
import com.coolapk.market.view.feedv8.RatingContentHelper;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.view.BadBadRatingBar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\fH\u0002¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/node/rating/LoginUserNodeRatingViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemUserNodeRatingBinding;", "Lcom/coolapk/market/model/NodeRating;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindToContent", "", "data", "onClick", "view", "showAdminDialog", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LoginUserNodeRatingViewHolder.kt */
public final class LoginUserNodeRatingViewHolder extends GenericBindHolder<ItemUserNodeRatingBinding, NodeRating> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558978;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoginUserNodeRatingViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ((ItemUserNodeRatingBinding) getBinding()).ratingBar.setProgressBar(NumberExtendsKt.getDp((Number) 22), false);
        LoginUserNodeRatingViewHolder loginUserNodeRatingViewHolder = this;
        ((ItemUserNodeRatingBinding) getBinding()).itemView.setOnClickListener(loginUserNodeRatingViewHolder);
        ((ItemUserNodeRatingBinding) getBinding()).iconView.setOnClickListener(loginUserNodeRatingViewHolder);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/node/rating/LoginUserNodeRatingViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LoginUserNodeRatingViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(NodeRating nodeRating) {
        Intrinsics.checkNotNullParameter(nodeRating, "data");
        ItemUserNodeRatingBinding itemUserNodeRatingBinding = (ItemUserNodeRatingBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemUserNodeRatingBinding, "binding");
        itemUserNodeRatingBinding.setModel(nodeRating);
        BadBadRatingBar badBadRatingBar = itemUserNodeRatingBinding.ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar, "binding.ratingBar");
        badBadRatingBar.setRating((float) nodeRating.getStar());
        RatingContentHelper ratingContentHelper = RatingContentHelper.INSTANCE;
        BadBadRatingBar badBadRatingBar2 = itemUserNodeRatingBinding.ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar2, "binding.ratingBar");
        BadBadRatingBar badBadRatingBar3 = itemUserNodeRatingBinding.ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar3, "binding.ratingBar");
        ratingContentHelper.setRatingBarTintColor(badBadRatingBar2, (int) badBadRatingBar3.getRating());
        BadBadRatingBar badBadRatingBar4 = itemUserNodeRatingBinding.ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar4, "binding.ratingBar");
        badBadRatingBar4.setProgressBackgroundTintList(ColorStateList.valueOf((int) 4292335575L));
        itemUserNodeRatingBinding.executePendingBindings();
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        String uid = loginSession.getUid();
        UserInfo userInfo = nodeRating.getUserInfo();
        if (Intrinsics.areEqual(uid, userInfo != null ? userInfo.getUid() : null)) {
            itemUserNodeRatingBinding.itemView.setOnLongClickListener(new LoginUserNodeRatingViewHolder$bindToContent$1(this));
        } else {
            itemUserNodeRatingBinding.itemView.setOnLongClickListener(null);
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        ItemUserNodeRatingBinding itemUserNodeRatingBinding = (ItemUserNodeRatingBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemUserNodeRatingBinding, "binding");
        NodeRating model = itemUserNodeRatingBinding.getModel();
        if (model != null) {
            Intrinsics.checkNotNullExpressionValue(model, "binding.model ?: return");
            int id = view.getId();
            if (id == 2131362672) {
                NodeTargetInfo targetInfo = model.getTargetInfo();
                if (targetInfo != null) {
                    Intrinsics.checkNotNullExpressionValue(targetInfo, "data.targetInfo ?: return");
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    ActionManagerCompat.startActivityByUrl$default(context, targetInfo.getUrl(), null, null, 12, null);
                }
            } else if (id == 2131362768) {
                String feedId = model.getFeedId();
                if ((feedId == null || feedId.length() == 0) || !(!Intrinsics.areEqual(model.getFeedId(), "0"))) {
                    Toast.show$default(getContext(), "你真懒，居然没写评语", 0, false, 12, null);
                } else {
                    ActionManager.startFeedDetailActivity(getContext(), model.getFeedId(), (String) null);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showAdminDialog() {
        ItemUserNodeRatingBinding itemUserNodeRatingBinding = (ItemUserNodeRatingBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemUserNodeRatingBinding, "binding");
        NodeRating model = itemUserNodeRatingBinding.getModel();
        if (model != null) {
            Intrinsics.checkNotNullExpressionValue(model, "binding.model ?: return");
            NodeRatingDialog initWith = NodeRatingDialog.Companion.newInstance().initWith(model);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(context).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context.requireAppCompat…().supportFragmentManager");
            initWith.show(supportFragmentManager, (String) null);
        }
    }
}
