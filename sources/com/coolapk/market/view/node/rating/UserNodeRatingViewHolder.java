package com.coolapk.market.view.node.rating;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
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
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.MultiItemDialogFragment;
import com.coolapk.market.view.base.WrapDialogFragmentKt;
import com.coolapk.market.view.feedv8.RatingContentHelper;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.view.BadBadRatingBar;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

/* compiled from: UserNodeRatingViewHolder.kt */
public final class UserNodeRatingViewHolder extends GenericBindHolder<ItemUserNodeRatingBinding, NodeRating> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558985;

    public static final /* synthetic */ void access$deleteNodeRating(UserNodeRatingViewHolder userNodeRatingViewHolder, NodeRating nodeRating, int i) {
        userNodeRatingViewHolder.deleteNodeRating(nodeRating, i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserNodeRatingViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ((ItemUserNodeRatingBinding) getBinding()).ratingBar.setProgressBar(NumberExtendsKt.getDp((Number) 22), false);
        UserNodeRatingViewHolder userNodeRatingViewHolder = this;
        ((ItemUserNodeRatingBinding) getBinding()).itemView.setOnClickListener(userNodeRatingViewHolder);
        ((ItemUserNodeRatingBinding) getBinding()).iconView.setOnClickListener(userNodeRatingViewHolder);
    }

    /* compiled from: UserNodeRatingViewHolder.kt */
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
        boolean isAdmin = loginSession.isAdmin();
        DataManager instance2 = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
        LoginSession loginSession2 = instance2.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession2, "DataManager.getInstance().loginSession");
        String uid = loginSession2.getUid();
        UserInfo userInfo = nodeRating.getUserInfo();
        boolean areEqual = Intrinsics.areEqual(uid, userInfo != null ? userInfo.getUid() : null);
        if (isAdmin || areEqual) {
            itemUserNodeRatingBinding.itemView.setOnLongClickListener(new UserNodeRatingViewHolder$bindToContent$1(this));
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
            if (id == 2131362683) {
                NodeTargetInfo targetInfo = model.getTargetInfo();
                if (targetInfo != null) {
                    Intrinsics.checkNotNullExpressionValue(targetInfo, "data.targetInfo ?: return");
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    ActionManagerCompat.startActivityByUrl$default(context, targetInfo.getUrl(), null, null, 12, null);
                }
            } else if (id == 2131362779) {
                String feedId = model.getFeedId();
                if ((feedId == null || feedId.length() == 0) || !(!Intrinsics.areEqual(model.getFeedId(), "0"))) {
                    Toast.show$default(getContext(), "TA很懒，并没有留下评语", 0, false, 12, null);
                } else {
                    ActionManager.startFeedDetailActivity(getContext(), model.getFeedId(), (String) null);
                }
            }
        }
    }

    public final void showAdminDialog() {
        ItemUserNodeRatingBinding itemUserNodeRatingBinding = (ItemUserNodeRatingBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemUserNodeRatingBinding, "binding");
        NodeRating model = itemUserNodeRatingBinding.getModel();
        if (model != null) {
            Intrinsics.checkNotNullExpressionValue(model, "binding.model ?: return");
            MultiItemDialogFragment initBuilder = MultiItemDialogFragment.Companion.newInstance().setInitBuilder(new UserNodeRatingViewHolder$showAdminDialog$1(this, model));
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(context).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context.requireAppCompat…().supportFragmentManager");
            initBuilder.show(supportFragmentManager, (String) null);
        }
    }

    public final void confirmDeleteRating(NodeRating nodeRating) {
        String feedId = nodeRating.getFeedId();
        AlertDialog create = new AlertDialog.Builder(getContext()).setMessage(((feedId == null || feedId.length() == 0) || !(Intrinsics.areEqual(nodeRating.getFeedId(), "0") ^ true)) ? "你确定要删除该点评么？" : "你确定要删除该点评并删除该动态么？").setPositiveButton("确定", new UserNodeRatingViewHolder$confirmDeleteRating$1(this, nodeRating)).setNegativeButton("取消", UserNodeRatingViewHolder$confirmDeleteRating$2.INSTANCE).setNeutralButton("删除且不通知", new UserNodeRatingViewHolder$confirmDeleteRating$3(this, nodeRating)).create();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (activityNullable != null) {
            Intrinsics.checkNotNullExpressionValue(create, "dialog");
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activityNullable).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "it.requireAppCompatActiv…().supportFragmentManager");
            WrapDialogFragmentKt.show(create, supportFragmentManager, null);
        }
    }

    private final void deleteNodeRating(NodeRating nodeRating, int i) {
        UserInfo userInfo = nodeRating.getUserInfo();
        if (userInfo != null) {
            Intrinsics.checkNotNullExpressionValue(userInfo, "data.userInfo ?: return");
            DataManager.getInstance().deleteRating(userInfo.getUid(), nodeRating.getTargetId(), nodeRating.getTargetType(), i).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new UserNodeRatingViewHolder$deleteNodeRating$1(this, userInfo, nodeRating));
        }
    }
}
