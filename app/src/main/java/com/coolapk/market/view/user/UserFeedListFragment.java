package com.coolapk.market.view.user;

import android.os.Bundle;
import android.os.Parcelable;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.view.cardlist.divider.DividerData;
import com.coolapk.market.view.cardlist.divider.TopBottomDividerRule;
import com.coolapk.market.view.userv9.UserSpaceV9FeedListFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0014¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/user/UserFeedListFragment;", "Lcom/coolapk/market/view/userv9/UserSpaceV9FeedListFragment;", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onRequestResponse", "", "isRefresh", "data", "", "Lcom/coolapk/market/model/Entity;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserFeedListActivity.kt */
public final class UserFeedListFragment extends UserSpaceV9FeedListFragment {
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/user/UserFeedListFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/user/UserFeedListFragment;", "uid", "", "num", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserFeedListActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UserFeedListFragment newInstance(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "uid");
            UserFeedListFragment userFeedListFragment = new UserFeedListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("UID", str);
            bundle.putInt("NUM", i);
            Unit unit = Unit.INSTANCE;
            userFeedListFragment.setArguments(bundle);
            return userFeedListFragment;
        }
    }

    @Override // com.coolapk.market.view.userv9.UserSpaceV9FeedListFragment, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new TopBottomDividerRule(DividerData.Companion.getH12DP(), null));
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.userv9.UserSpaceV9FeedListFragment, com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        boolean onRequestResponse = super.onRequestResponse(z, list);
        Parcelable parcelable = (Parcelable) CollectionsKt.firstOrNull((List<? extends Object>) getDataList());
        if (parcelable instanceof HolderItem) {
            getDataList().remove(parcelable);
        }
        return onRequestResponse;
    }
}
