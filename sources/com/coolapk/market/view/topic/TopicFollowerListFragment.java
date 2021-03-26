package com.coolapk.market.view.topic;

import android.os.Bundle;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.User;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.cardlist.divider.DividerData;
import com.coolapk.market.view.cardlist.divider.SingleDividerRule;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleHolderFactorBuilder;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/topic/TopicFollowerListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TopicFollowerListFragment.kt */
public final class TopicFollowerListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_TAG = "TAG";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/topic/TopicFollowerListFragment$Companion;", "", "()V", "EXTRA_TAG", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TopicFollowerListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new SingleDividerRule(DividerData.Companion.getH1DP()));
        getVxDividerDecoration$presentation_coolapkAppRelease().setDefaultNoMargin();
        getVxDividerDecoration$presentation_coolapkAppRelease().setDividerColor(AppHolder.getAppTheme().getContentBackgroundDividerColor());
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        BaseMultiTypeAdapter adapter$presentation_coolapkAppRelease = getAdapter$presentation_coolapkAppRelease();
        SimpleHolderFactorBuilder constructor = SimpleViewHolderFactor.Companion.withLayoutId(2131558940).suitedEntityType("user").constructor(new TopicFollowerListFragment$onActivityCreated$1(this));
        Integer num = getItemViewTypeByEntityType().get("user");
        Intrinsics.checkNotNull(num);
        Intrinsics.checkNotNullExpressionValue(num, "(itemViewTypeByEntityTyp…tils.ENTITY_TYPE_USER])!!");
        BaseMultiTypeAdapter.register$default(adapter$presentation_coolapkAppRelease, constructor.resetItemViewType(num.intValue()).build(), 0, 2, null);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Bundle arguments = getArguments();
        String str = null;
        String string = arguments != null ? arguments.getString("TAG") : null;
        if (string == null) {
            string = "";
        }
        DataManager instance = DataManager.getInstance();
        Entity findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null);
        if (!(findFirstEntity$default instanceof User)) {
            findFirstEntity$default = null;
        }
        User user = (User) findFirstEntity$default;
        String uid = user != null ? user.getUid() : null;
        Entity findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
        if (!(findLastEntity$default instanceof User)) {
            findLastEntity$default = null;
        }
        User user2 = (User) findLastEntity$default;
        if (user2 != null) {
            str = user2.getUid();
        }
        Observable<R> compose = instance.getTopicFollowList(string, i, uid, str).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }
}
