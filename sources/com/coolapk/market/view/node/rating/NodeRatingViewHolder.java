package com.coolapk.market.view.node.rating;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.databinding.ItemNodeRatingBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.NodeRating;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.MultiItemDialogFragment;
import com.coolapk.market.view.base.WrapDialogFragmentKt;
import com.coolapk.market.view.feedv8.RatingContentHelper;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.view.BadBadRatingBar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0002J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\fH\u0002¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/view/node/rating/NodeRatingViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemNodeRatingBinding;", "Lcom/coolapk/market/model/NodeRating;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindToContent", "", "data", "confirmDeleteRating", "deleteNodeRating", "notNotify", "", "onClick", "view", "showAdminDialog", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NodeRatingViewHolder.kt */
public final class NodeRatingViewHolder extends GenericBindHolder<ItemNodeRatingBinding, NodeRating> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558846;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NodeRatingViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ((ItemNodeRatingBinding) getBinding()).ratingBar.setProgressBar(NumberExtendsKt.getDp((Number) 22), false);
        NodeRatingViewHolder nodeRatingViewHolder = this;
        ((ItemNodeRatingBinding) getBinding()).itemView.setOnClickListener(nodeRatingViewHolder);
        ((ItemNodeRatingBinding) getBinding()).userAvatarView.setOnClickListener(nodeRatingViewHolder);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/node/rating/NodeRatingViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: NodeRatingViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(NodeRating nodeRating) {
        Intrinsics.checkNotNullParameter(nodeRating, "data");
        ItemNodeRatingBinding itemNodeRatingBinding = (ItemNodeRatingBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemNodeRatingBinding, "binding");
        itemNodeRatingBinding.setModel(nodeRating);
        BadBadRatingBar badBadRatingBar = itemNodeRatingBinding.ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar, "binding.ratingBar");
        badBadRatingBar.setRating((float) nodeRating.getStar());
        RatingContentHelper ratingContentHelper = RatingContentHelper.INSTANCE;
        BadBadRatingBar badBadRatingBar2 = itemNodeRatingBinding.ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar2, "binding.ratingBar");
        BadBadRatingBar badBadRatingBar3 = itemNodeRatingBinding.ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar3, "binding.ratingBar");
        ratingContentHelper.setRatingBarTintColor(badBadRatingBar2, (int) badBadRatingBar3.getRating());
        BadBadRatingBar badBadRatingBar4 = itemNodeRatingBinding.ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar4, "binding.ratingBar");
        badBadRatingBar4.setProgressBackgroundTintList(ColorStateList.valueOf((int) 4292335575L));
        itemNodeRatingBinding.executePendingBindings();
        String str = "";
        boolean z = true;
        if (nodeRating.getShowOwner() == 1) {
            if (nodeRating.getIsOwner() == 1) {
                str = "机主";
            }
        } else if (nodeRating.getBuyStatus() == 1) {
            str = "已买";
        }
        TextView textView = itemNodeRatingBinding.ownerTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.ownerTextView");
        String str2 = str;
        textView.setText(str2);
        TextView textView2 = itemNodeRatingBinding.ownerTextView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.ownerTextView");
        TextView textView3 = textView2;
        int i = 0;
        if (str2.length() <= 0) {
            z = false;
        }
        if (!z) {
            i = 8;
        }
        textView3.setVisibility(i);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        boolean isAdmin = loginSession.isAdmin();
        DataManager instance2 = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
        LoginSession loginSession2 = instance2.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession2, "DataManager.getInstance().loginSession");
        String uid = loginSession2.getUid();
        UserInfo userInfo = nodeRating.getUserInfo();
        boolean areEqual = Intrinsics.areEqual(uid, userInfo != null ? userInfo.getUid() : null);
        if (isAdmin || areEqual) {
            itemNodeRatingBinding.itemView.setOnLongClickListener(new NodeRatingViewHolder$bindToContent$1(this));
        } else {
            itemNodeRatingBinding.itemView.setOnLongClickListener(null);
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        UserInfo userInfo;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        ItemNodeRatingBinding itemNodeRatingBinding = (ItemNodeRatingBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemNodeRatingBinding, "binding");
        NodeRating model = itemNodeRatingBinding.getModel();
        if (model != null) {
            Intrinsics.checkNotNullExpressionValue(model, "binding.model ?: return");
            int id = view.getId();
            if (id == 2131362779) {
                String feedId = model.getFeedId();
                if ((feedId == null || feedId.length() == 0) || !(!Intrinsics.areEqual(model.getFeedId(), "0"))) {
                    Toast.show$default(getContext(), "TA很懒，并没有留下评语", 0, false, 12, null);
                } else {
                    ActionManager.startFeedDetailActivity(getContext(), model.getFeedId(), (String) null);
                }
            } else if (id == 2131363900 && (userInfo = model.getUserInfo()) != null) {
                Intrinsics.checkNotNullExpressionValue(userInfo, "data.userInfo ?: return");
                ActionManager.startUserSpaceActivity(getContext(), userInfo.getUid());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showAdminDialog() {
        ItemNodeRatingBinding itemNodeRatingBinding = (ItemNodeRatingBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemNodeRatingBinding, "binding");
        NodeRating model = itemNodeRatingBinding.getModel();
        if (model != null) {
            Intrinsics.checkNotNullExpressionValue(model, "binding.model ?: return");
            MultiItemDialogFragment initBuilder = MultiItemDialogFragment.Companion.newInstance().setInitBuilder(new NodeRatingViewHolder$showAdminDialog$1(this, model));
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(context).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context.requireAppCompat…().supportFragmentManager");
            initBuilder.show(supportFragmentManager, (String) null);
        }
    }

    /* access modifiers changed from: private */
    public final void confirmDeleteRating(NodeRating nodeRating) {
        String feedId = nodeRating.getFeedId();
        AlertDialog create = new AlertDialog.Builder(getContext()).setMessage(((feedId == null || feedId.length() == 0) || !(Intrinsics.areEqual(nodeRating.getFeedId(), "0") ^ true)) ? "你确定要删除该点评么？" : "你确定要删除该点评并删除该动态么？").setPositiveButton("确定", new NodeRatingViewHolder$confirmDeleteRating$1(this, nodeRating)).setNegativeButton("取消", NodeRatingViewHolder$confirmDeleteRating$2.INSTANCE).setNeutralButton("删除且不通知", new NodeRatingViewHolder$confirmDeleteRating$3(this, nodeRating)).create();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (activityNullable != null) {
            Intrinsics.checkNotNullExpressionValue(create, "dialog");
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activityNullable).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
            WrapDialogFragmentKt.show(create, supportFragmentManager, null);
        }
    }

    /* access modifiers changed from: private */
    public final void deleteNodeRating(NodeRating nodeRating, int i) {
        UserInfo userInfo = nodeRating.getUserInfo();
        if (userInfo != null) {
            Intrinsics.checkNotNullExpressionValue(userInfo, "data.userInfo ?: return");
            DataManager.getInstance().deleteRating(userInfo.getUid(), nodeRating.getTargetId(), nodeRating.getTargetType(), i).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new NodeRatingViewHolder$deleteNodeRating$1(this, userInfo, nodeRating));
        }
    }
}
