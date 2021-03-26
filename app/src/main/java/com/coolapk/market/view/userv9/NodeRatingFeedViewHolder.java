package com.coolapk.market.view.userv9;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.databinding.NodeRatingFeedLikeViewBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.NodeRating;
import com.coolapk.market.model.NodeTargetInfo;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.MultiItemDialogFragment;
import com.coolapk.market.view.base.WrapDialogFragmentKt;
import com.coolapk.market.view.feedv8.RatingContentHelper;
import com.coolapk.market.view.product.ProductGlobalData;
import com.coolapk.market.viewholder.GenericBindHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\nH\u0002¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/view/userv9/NodeRatingFeedViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/NodeRatingFeedLikeViewBinding;", "Lcom/coolapk/market/model/NodeRating;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "bindToContent", "", "data", "confirmDeleteRating", "deleteNodeRating", "notNotify", "", "onClick", "view", "showAdminDialog", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NodeRatingFeedViewHolder.kt */
public final class NodeRatingFeedViewHolder extends GenericBindHolder<NodeRatingFeedLikeViewBinding, NodeRating> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131559057;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NodeRatingFeedViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        TextView textView = ((NodeRatingFeedLikeViewBinding) getBinding()).averageScoreView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.averageScoreView");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setTypeface(ProductGlobalData.getNumberTypeface(context));
        NodeRatingFeedLikeViewBinding nodeRatingFeedLikeViewBinding = (NodeRatingFeedLikeViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(nodeRatingFeedLikeViewBinding, "binding");
        nodeRatingFeedLikeViewBinding.setClick(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/userv9/NodeRatingFeedViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: NodeRatingFeedViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(NodeRating nodeRating) {
        String realScore;
        Intrinsics.checkNotNullParameter(nodeRating, "data");
        NodeRatingFeedLikeViewBinding nodeRatingFeedLikeViewBinding = (NodeRatingFeedLikeViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(nodeRatingFeedLikeViewBinding, "binding");
        nodeRatingFeedLikeViewBinding.setModel(nodeRating);
        RatingBar ratingBar = ((NodeRatingFeedLikeViewBinding) getBinding()).ratingBar;
        Intrinsics.checkNotNullExpressionValue(ratingBar, "binding.ratingBar");
        ratingBar.setRating((float) nodeRating.getStar());
        RatingContentHelper ratingContentHelper = RatingContentHelper.INSTANCE;
        RatingBar ratingBar2 = ((NodeRatingFeedLikeViewBinding) getBinding()).ratingBar;
        Intrinsics.checkNotNullExpressionValue(ratingBar2, "binding.ratingBar");
        RatingBar ratingBar3 = ((NodeRatingFeedLikeViewBinding) getBinding()).ratingBar;
        Intrinsics.checkNotNullExpressionValue(ratingBar3, "binding.ratingBar");
        ratingContentHelper.setRatingBarTintColor(ratingBar2, (int) ratingBar3.getRating());
        NodeTargetInfo targetInfo = nodeRating.getTargetInfo();
        float parseFloat = (targetInfo == null || (realScore = targetInfo.getRealScore()) == null) ? 0.0f : Float.parseFloat(realScore);
        RatingBar ratingBar4 = ((NodeRatingFeedLikeViewBinding) getBinding()).averageRatingBar;
        Intrinsics.checkNotNullExpressionValue(ratingBar4, "binding.averageRatingBar");
        ratingBar4.setRating(ProductGlobalData.INSTANCE.ratingScoreToStartScore(parseFloat));
        TextView textView = ((NodeRatingFeedLikeViewBinding) getBinding()).averageScoreView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.averageScoreView");
        textView.setText(KotlinExtendKt.toDisplayScore(parseFloat));
        TextView textView2 = ((NodeRatingFeedLikeViewBinding) getBinding()).subtitleView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.subtitleView");
        StringBuilder sb = new StringBuilder();
        NodeTargetInfo targetInfo2 = nodeRating.getTargetInfo();
        sb.append(targetInfo2 != null ? targetInfo2.getRealVoteCount() : null);
        sb.append("人点评");
        textView2.setText(sb.toString());
        ((NodeRatingFeedLikeViewBinding) getBinding()).executePendingBindings();
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        String uid = loginSession.getUid();
        UserInfo userInfo = nodeRating.getUserInfo();
        if (Intrinsics.areEqual(uid, userInfo != null ? userInfo.getUid() : null)) {
            ((NodeRatingFeedLikeViewBinding) getBinding()).cardView.setOnLongClickListener(new NodeRatingFeedViewHolder$bindToContent$1(this));
        } else {
            ((NodeRatingFeedLikeViewBinding) getBinding()).cardView.setOnLongClickListener(null);
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        NodeTargetInfo targetInfo;
        String url;
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == 2131362200) {
            NodeRatingFeedLikeViewBinding nodeRatingFeedLikeViewBinding = (NodeRatingFeedLikeViewBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(nodeRatingFeedLikeViewBinding, "binding");
            NodeRating model = nodeRatingFeedLikeViewBinding.getModel();
            if (model != null && (targetInfo = model.getTargetInfo()) != null && (url = targetInfo.getUrl()) != null) {
                Intrinsics.checkNotNullExpressionValue(url, "binding.model?.targetInfo?.url ?: return");
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ActionManagerCompat.startActivityByUrl$default(context, url, null, null, 12, null);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showAdminDialog() {
        NodeRatingFeedLikeViewBinding nodeRatingFeedLikeViewBinding = (NodeRatingFeedLikeViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(nodeRatingFeedLikeViewBinding, "binding");
        NodeRating model = nodeRatingFeedLikeViewBinding.getModel();
        if (model != null) {
            Intrinsics.checkNotNullExpressionValue(model, "binding.model ?: return");
            MultiItemDialogFragment initBuilder = MultiItemDialogFragment.Companion.newInstance().setInitBuilder(new NodeRatingFeedViewHolder$showAdminDialog$1(this, model));
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
        AlertDialog create = new AlertDialog.Builder(getContext()).setMessage(((feedId == null || feedId.length() == 0) || !(Intrinsics.areEqual(nodeRating.getFeedId(), "0") ^ true)) ? "你确定要取消评分么？" : "你确定要取消点评并删除该点评动态么？").setPositiveButton("确定", new NodeRatingFeedViewHolder$confirmDeleteRating$1(this, nodeRating)).setNegativeButton("取消", NodeRatingFeedViewHolder$confirmDeleteRating$2.INSTANCE).create();
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

    /* access modifiers changed from: private */
    public final void deleteNodeRating(NodeRating nodeRating, int i) {
        UserInfo userInfo = nodeRating.getUserInfo();
        if (userInfo != null) {
            Intrinsics.checkNotNullExpressionValue(userInfo, "data.userInfo ?: return");
            DataManager.getInstance().deleteRating(userInfo.getUid(), nodeRating.getTargetId(), nodeRating.getTargetType(), i).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new NodeRatingFeedViewHolder$deleteNodeRating$1(this, userInfo, nodeRating));
        }
    }
}
