package com.coolapk.market.view.feed;

import android.os.Bundle;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.cardlist.divider.FeedListDividerRule;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

/* compiled from: FeedHotReplyListFragment.kt */
public final class FeedHotReplyListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_FEED_ID = "KEY_FEED_ID";
    private String id;

    /* compiled from: FeedHotReplyListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getKEY_FEED_ID() {
            return FeedHotReplyListFragment.KEY_FEED_ID;
        }

        public final FeedHotReplyListFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "feedId");
            Bundle bundle = new Bundle();
            bundle.putString(getKEY_FEED_ID(), str);
            FeedHotReplyListFragment feedHotReplyListFragment = new FeedHotReplyListFragment();
            feedHotReplyListFragment.setArguments(bundle);
            return feedHotReplyListFragment;
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.id = requireArguments().getString(KEY_FEED_ID);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getVxDividerDecoration$presentation_coolapkAppRelease().setDefaultNoMargin();
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new FeedListDividerRule());
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        setEmptyData(getString(2131886826), 0);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558723).constructor(new FeedHotReplyListFragment$onActivityCreated$1(this)).suitedMethod(FeedHotReplyListFragment$onActivityCreated$2.INSTANCE).build(), 0, 2, null);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Entity findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null);
        String str = null;
        String entityId = findFirstEntity$default != null ? findFirstEntity$default.getEntityId() : null;
        Entity findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
        if (findLastEntity$default != null) {
            str = findLastEntity$default.getEntityId();
        }
        Observable<R> map = DataManager.getInstance().getHotFeedReplyList(this.id, i, entityId, str).map(RxUtils.checkResultToData());
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…tils.checkResultToData())");
        return map;
    }
}
