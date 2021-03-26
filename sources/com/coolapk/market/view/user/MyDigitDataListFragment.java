package com.coolapk.market.view.user;

import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Product;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.MultiItemDialogFragment;
import com.coolapk.market.view.base.WrapDialogFragmentKt;
import com.coolapk.market.view.main.DataListFragment;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.Subscriber;

/* compiled from: MyDigitTabListActivity.kt */
public final class MyDigitDataListFragment extends DataListFragment {
    public static final Companion Companion = new Companion(null);

    /* compiled from: MyDigitTabListActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DataListFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "action");
            MyDigitDataListFragment myDigitDataListFragment = new MyDigitDataListFragment();
            myDigitDataListFragment.setArguments(DataListFragment.Companion.createArguments$default(DataListFragment.Companion, str, null, null, 0, 14, null));
            return myDigitDataListFragment;
        }
    }

    @Override // com.coolapk.market.view.main.DataListFragment, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558882).constructor(new MyDigitDataListFragment$onActivityCreated$1(this)).suitedMethod(MyDigitDataListFragment$onActivityCreated$2.INSTANCE).doAfterBind(new MyDigitDataListFragment$onActivityCreated$3(this)).build(), -1);
    }

    public final void showCancelDialog(Product product) {
        UserAction userAction = product.getUserAction();
        Intrinsics.checkNotNullExpressionValue(userAction, "data.userAction");
        if (userAction.getBuy() <= 0) {
            UserAction userAction2 = product.getUserAction();
            Intrinsics.checkNotNullExpressionValue(userAction2, "data.userAction");
            if (userAction2.getWish() <= 0) {
                return;
            }
        }
        MultiItemDialogFragment initBuilder = MultiItemDialogFragment.Companion.newInstance().setInitBuilder(new MyDigitDataListFragment$showCancelDialog$1(this, product));
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        initBuilder.show(childFragmentManager, (String) null);
    }

    public final void confirmCancelBuy(Product product) {
        UserAction userAction = product.getUserAction();
        Intrinsics.checkNotNullExpressionValue(userAction, "data.userAction");
        String ratingFeedUrl = userAction.getRatingFeedUrl();
        AlertDialog create = new AlertDialog.Builder(requireActivity()).setMessage(ratingFeedUrl == null || ratingFeedUrl.length() == 0 ? "确定要取消买过，并删除该数码的评分么？" : "确定要取消买过，并删除该数码的点评动态?").setPositiveButton("确定", new MyDigitDataListFragment$confirmCancelBuy$1(this, product)).setNegativeButton("取消", MyDigitDataListFragment$confirmCancelBuy$2.INSTANCE).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(requ…                .create()");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        WrapDialogFragmentKt.show(create, childFragmentManager, null);
    }

    public final void doCancelBuy(Product product) {
        UserAction userAction = product.getUserAction();
        Intrinsics.checkNotNullExpressionValue(userAction, "data.userAction");
        String ratingFeedUrl = userAction.getRatingFeedUrl();
        if (ratingFeedUrl == null || ratingFeedUrl.length() == 0) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            LoginSession loginSession = instance.getLoginSession();
            Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
            String uid = loginSession.getUid();
            DataManager.getInstance().deleteRating(uid, product.getId(), "7", 0).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new MyDigitDataListFragment$doCancelBuy$1(this, uid, product));
            return;
        }
        UserAction userAction2 = product.getUserAction();
        Intrinsics.checkNotNullExpressionValue(userAction2, "data.userAction");
        String ratingFeedUrl2 = userAction2.getRatingFeedUrl();
        if (ratingFeedUrl2 == null) {
            ratingFeedUrl2 = "";
        }
        int length = ratingFeedUrl2.length();
        Objects.requireNonNull(ratingFeedUrl2, "null cannot be cast to non-null type java.lang.String");
        String substring = ratingFeedUrl2.substring(StringsKt.lastIndexOf$default((CharSequence) ratingFeedUrl2, "/", 0, false, 6, (Object) null) + 1, length);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        DataManager.getInstance().deleteFeed(substring).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new MyDigitDataListFragment$doCancelBuy$2(this, substring, product));
    }

    public final void confirmCancelWish(Product product) {
        AlertDialog create = new AlertDialog.Builder(requireActivity()).setMessage("确定要取消想买么？").setPositiveButton("确定", new MyDigitDataListFragment$confirmCancelWish$1(this, product)).setNegativeButton("取消", MyDigitDataListFragment$confirmCancelWish$2.INSTANCE).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(requ…                .create()");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        WrapDialogFragmentKt.show$default(create, childFragmentManager, null, 2, null);
    }

    public final void doCancelWish(Product product) {
        DataManager.getInstance().changeProductWishStatus(product.getId(), false).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new MyDigitDataListFragment$doCancelWish$1(this, product));
    }
}
