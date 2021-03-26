package com.coolapk.market.view.main;

import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.UserPermissionChecker;
import com.coolapk.market.view.feedv8.util.FeedGoodsHelper;
import com.coolapk.market.view.feedv8.util.FeedGoodsUrlUtils;
import com.coolapk.market.view.main.DataListFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/main/GoodsFragment;", "Lcom/coolapk/market/view/main/DataListFragment;", "()V", "value", "", "lastClipboardHashCode", "getLastClipboardHashCode", "()I", "setLastClipboardHashCode", "(I)V", "checkClipboardDialog", "", "onResume", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsFragment.kt */
public final class GoodsFragment extends DataListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_GOODS_CLIPBOARD_HASHCODE = "goods_clipboard_hashcode";
    public static final String PAGE_NAME = "V11_FIND_GOOD_GOODS_HOME";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/main/GoodsFragment$Companion;", "", "()V", "KEY_GOODS_CLIPBOARD_HASHCODE", "", "PAGE_NAME", "newInstance", "Lcom/coolapk/market/view/main/GoodsFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GoodsFragment newInstance() {
            GoodsFragment goodsFragment = new GoodsFragment();
            goodsFragment.setArguments(DataListFragment.Companion.createArguments$default(DataListFragment.Companion, "V11_FIND_GOOD_GOODS_HOME", null, null, 0, 14, null));
            return goodsFragment;
        }
    }

    private final int getLastClipboardHashCode() {
        return DataManager.getInstance().getPreferencesInt("goods_clipboard_hashcode", 0);
    }

    private final void setLastClipboardHashCode(int i) {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putInt("goods_clipboard_hashcode", i).apply();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AppHolder.getMainThreadHandler().postDelayed(new GoodsFragment$sam$java_lang_Runnable$0(new GoodsFragment$onResume$1(this)), 100);
    }

    /* access modifiers changed from: private */
    public final void checkClipboardDialog() {
        FragmentActivity activity;
        if (AppHolder.getAppSetting().getBooleanPref("share_goods_dialog") && (activity = getActivity()) != null) {
            Intrinsics.checkNotNullExpressionValue(activity, "activity ?: return");
            if (!activity.isDestroyed() && !activity.isFinishing()) {
                AppSetting appSetting = AppHolder.getAppSetting();
                Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
                String optString = appSetting.getConfigJson().optString("Goods.ClipboardLinkDialog", "");
                if (Intrinsics.areEqual(optString, "1") || Intrinsics.areEqual(optString, "true")) {
                    String clipBoardUrl = UserPermissionChecker.INSTANCE.getClipBoardUrl(activity);
                    if (FeedGoodsHelper.INSTANCE.isSupportAddGoodsUrl(clipBoardUrl) && !FeedGoodsUrlUtils.INSTANCE.isUrlPostBefore(clipBoardUrl) && !FeedGoodsUrlUtils.INSTANCE.isUrlShouldIgnore(clipBoardUrl) && clipBoardUrl.hashCode() != getLastClipboardHashCode()) {
                        setLastClipboardHashCode(clipBoardUrl.hashCode());
                        FeedGoodsHelper.INSTANCE.showUrlInClipBoardDialog(activity);
                    }
                }
            }
        }
    }
}
