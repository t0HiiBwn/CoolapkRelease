package com.coolapk.market.view.feed.pick;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.cardlist.divider.DividerData;
import com.coolapk.market.view.cardlist.divider.GroupListCardStyleRule;
import com.coolapk.market.view.cardlist.divider.SingleDividerRule;
import com.coolapk.market.view.main.DataListFragment;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

/* compiled from: NodePickRecentListFragment.kt */
public final class NodePickRecentListFragment extends DataListFragment {
    public static final Companion Companion = new Companion(null);
    private static final String EXTRA_KEY_WORD = "key_word";

    /* compiled from: NodePickRecentListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NodePickRecentListFragment newInstance(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "keywords");
            Intrinsics.checkNotNullParameter(str2, "defaultUrl");
            NodePickRecentListFragment nodePickRecentListFragment = new NodePickRecentListFragment();
            Bundle createArguments$default = DataListFragment.Companion.createArguments$default(DataListFragment.Companion, str2, null, null, 0, 14, null);
            createArguments$default.putString("key_word", str);
            Unit unit = Unit.INSTANCE;
            nodePickRecentListFragment.setArguments(createArguments$default);
            return nodePickRecentListFragment;
        }
    }

    private final String getKeywords() {
        return requireArguments().getString("key_word");
    }

    @Override // com.coolapk.market.view.main.DataListFragment, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558845).constructor(new NodePickRecentListFragment$onActivityCreated$1(this)).suitedMethod(NodePickRecentListFragment$onActivityCreated$2.INSTANCE).doAfterBind(new NodePickRecentListFragment$onActivityCreated$3(this)).build(), -1);
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new SingleDividerRule(DividerData.Companion.getEMPTY()));
        getDataBindingInterceptor$presentation_coolapkAppRelease().addCardStyleRule(new GroupListCardStyleRule());
        if (bundle != null && (Intrinsics.areEqual(bundle.getString("key_word"), getKeywords()) ^ true)) {
            getDataList().clear();
            setPage(1);
            reloadData(true);
        }
    }

    @Override // com.coolapk.market.view.main.DataListFragment, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putString("key_word", getKeywords());
    }

    @Override // com.coolapk.market.view.main.DataListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        String keywords = getKeywords();
        if (keywords == null || keywords.length() == 0) {
            return super.onCreateRequest(z, i);
        }
        DataManager instance = DataManager.getInstance();
        String keywords2 = getKeywords();
        Entity findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null);
        String entityId = findFirstEntity$default != null ? findFirstEntity$default.getEntityId() : null;
        Entity findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
        Observable<R> compose = instance.appSearch("apkAndProduct", null, null, keywords2, i, entityId, findLastEntity$default != null ? findLastEntity$default.getEntityId() : null, null).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }

    public final void pickAndFinish(Entity entity) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intrinsics.checkNotNullExpressionValue(activity, "activity ?: return");
            Intent intent = new Intent();
            intent.putExtra("DATA", entity);
            intent.putExtra("TYPE", entity.getEntityType());
            activity.setResult(-1, intent);
            activity.finish();
        }
    }
}
