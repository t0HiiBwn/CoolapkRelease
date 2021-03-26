package com.coolapk.market.view.feed;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.NodeRating;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.MultiItemDialogFragment;
import com.coolapk.market.view.base.WrapDialogFragmentKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

/* compiled from: NodeRatingDialog.kt */
public final class NodeRatingDialog extends MultiItemDialogFragment {
    public static final Companion Companion = new Companion(null);

    /* compiled from: NodeRatingDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NodeRatingDialog newInstance() {
            return new NodeRatingDialog();
        }
    }

    public final NodeRatingDialog initWith(NodeRating nodeRating) {
        Intrinsics.checkNotNullParameter(nodeRating, "data");
        setInitBuilder(new NodeRatingDialog$initWith$1(this, nodeRating));
        return this;
    }

    public final void confirmDeleteRating(NodeRating nodeRating) {
        String feedId = nodeRating.getFeedId();
        boolean z = false;
        boolean z2 = !(feedId == null || feedId.length() == 0) && (Intrinsics.areEqual(nodeRating.getFeedId(), "0") ^ true);
        if (nodeRating.getBuyStatus() == 1) {
            z = true;
        }
        AlertDialog create = new AlertDialog.Builder(requireActivity()).setMessage((!z2 || !z) ? z2 ? "你确定要取消点评并删除该点评动态么？" : z ? "你确定要取消评分并删除买过状态么？" : "你确定要取消评分么？" : "你确定要取消评分，并删除该点评动态和买过状态么？").setPositiveButton("确定", new NodeRatingDialog$confirmDeleteRating$1(this, nodeRating)).setNegativeButton("取消", NodeRatingDialog$confirmDeleteRating$2.INSTANCE).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(requ…                .create()");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(requireActivity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().requir…().supportFragmentManager");
        WrapDialogFragmentKt.show(create, supportFragmentManager, null);
    }

    public final void deleteNodeRating(NodeRating nodeRating, int i) {
        UserInfo userInfo = nodeRating.getUserInfo();
        if (userInfo != null) {
            Intrinsics.checkNotNullExpressionValue(userInfo, "data.userInfo ?: return");
            DataManager.getInstance().deleteRating(userInfo.getUid(), nodeRating.getTargetId(), nodeRating.getTargetType(), i).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new NodeRatingDialog$deleteNodeRating$1(this, userInfo, nodeRating));
        }
    }
}
