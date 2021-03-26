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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\fH\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0010H\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/view/feed/pick/NodePickDataListFragment;", "Lcom/coolapk/market/view/main/DataListFragment;", "()V", "keywords", "", "getKeywords", "()Ljava/lang/String;", "searchType", "getSearchType", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "", "onSaveInstanceState", "outState", "pickAndFinish", "data", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: NodePickDataListFragment.kt */
public final class NodePickDataListFragment extends DataListFragment {
    public static final Companion Companion = new Companion(null);
    private static final String EXTRA_KEY_WORD = "key_word";
    private static final String EXTRA_SEARCH_TYPE = "search_type";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/feed/pick/NodePickDataListFragment$Companion;", "", "()V", "EXTRA_KEY_WORD", "", "EXTRA_SEARCH_TYPE", "newInstance", "Lcom/coolapk/market/view/feed/pick/NodePickDataListFragment;", "keywords", "searchType", "defaultUrl", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: NodePickDataListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NodePickDataListFragment newInstance(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "keywords");
            Intrinsics.checkNotNullParameter(str2, "searchType");
            Intrinsics.checkNotNullParameter(str3, "defaultUrl");
            NodePickDataListFragment nodePickDataListFragment = new NodePickDataListFragment();
            Bundle createArguments$default = DataListFragment.Companion.createArguments$default(DataListFragment.Companion, str3, null, null, 0, 14, null);
            createArguments$default.putString("key_word", str);
            createArguments$default.putString("search_type", str2);
            Unit unit = Unit.INSTANCE;
            nodePickDataListFragment.setArguments(createArguments$default);
            return nodePickDataListFragment;
        }
    }

    private final String getKeywords() {
        return requireArguments().getString("key_word");
    }

    private final String getSearchType() {
        return requireArguments().getString("search_type");
    }

    @Override // com.coolapk.market.view.main.DataListFragment, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558924).suitedMethod(NodePickDataListFragment$onActivityCreated$1.INSTANCE).constructor(new NodePickDataListFragment$onActivityCreated$2(this)).doAfterBind(NodePickDataListFragment$onActivityCreated$3.INSTANCE).resetItemViewType(2131558924).build(), -1);
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558882).suitedMethod(NodePickDataListFragment$onActivityCreated$4.INSTANCE).constructor(new NodePickDataListFragment$onActivityCreated$5(this)).doAfterBind(new NodePickDataListFragment$onActivityCreated$6(this)).resetItemViewType(2131558882).build(), -1);
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new SingleDividerRule(DividerData.Companion.getEMPTY()));
        getDataBindingInterceptor$presentation_coolapkAppRelease().addCardStyleRule(new GroupListCardStyleRule());
        boolean z = true;
        if (bundle != null && (Intrinsics.areEqual(bundle.getString("key_word"), getKeywords()) ^ true)) {
            getDataList().clear();
            setPage(1);
            reloadData(true);
        }
        String keywords = getKeywords();
        if (!(keywords == null || keywords.length() == 0)) {
            z = false;
        }
        if (z) {
            setEmptyData("你最近还没有参与过任何数码或者应用讨论哦", 0);
        }
    }

    @Override // com.coolapk.market.view.main.DataListFragment, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        requireArguments().putString("key_word", getKeywords());
    }

    @Override // com.coolapk.market.view.main.DataListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        String keywords = getKeywords();
        if (keywords == null || keywords.length() == 0) {
            return super.onCreateRequest(z, i);
        }
        DataManager instance = DataManager.getInstance();
        String searchType = getSearchType();
        String keywords2 = getKeywords();
        Entity findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null);
        String entityId = findFirstEntity$default != null ? findFirstEntity$default.getEntityId() : null;
        Entity findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
        Observable<R> compose = instance.appSearch(searchType, null, null, keywords2, i, entityId, findLastEntity$default != null ? findLastEntity$default.getEntityId() : null, null).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }

    /* access modifiers changed from: private */
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
