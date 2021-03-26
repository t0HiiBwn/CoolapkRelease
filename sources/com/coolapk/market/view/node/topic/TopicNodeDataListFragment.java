package com.coolapk.market.view.node.topic;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.event.FeedPostEvent;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.node.NodeHelper;
import com.coolapk.market.viewholder.NodeTopContentViewHolder;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J$\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006%"}, d2 = {"Lcom/coolapk/market/view/node/topic/TopicNodeDataListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "configPage", "Lcom/coolapk/market/model/ConfigPage;", "getConfigPage", "()Lcom/coolapk/market/model/ConfigPage;", "configPage$delegate", "Lkotlin/Lazy;", "presenter", "Lcom/coolapk/market/view/node/topic/TopicVXPresenter;", "getPresenter$presentation_coolapkAppRelease", "()Lcom/coolapk/market/view/node/topic/TopicVXPresenter;", "setPresenter$presentation_coolapkAppRelease", "(Lcom/coolapk/market/view/node/topic/TopicVXPresenter;)V", "viewModel", "Lcom/coolapk/market/view/node/topic/TopicVXViewModel;", "getViewModel$presentation_coolapkAppRelease", "()Lcom/coolapk/market/view/node/topic/TopicVXViewModel;", "setViewModel$presentation_coolapkAppRelease", "(Lcom/coolapk/market/view/node/topic/TopicVXViewModel;)V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "", "shouldInterceptFeedEvent", "event", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TopicNodeDataListFragment.kt */
public final class TopicNodeDataListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_CONFIG_PAGE = "EXTRA_CONFIG_PAGE";
    private final Lazy configPage$delegate = LazyKt.lazy(new TopicNodeDataListFragment$configPage$2(this));
    public TopicVXPresenter presenter;
    public TopicVXViewModel viewModel;

    private final ConfigPage getConfigPage() {
        return (ConfigPage) this.configPage$delegate.getValue();
    }

    @JvmStatic
    public static final TopicNodeDataListFragment newInstance(ConfigPage configPage) {
        return Companion.newInstance(configPage);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/node/topic/TopicNodeDataListFragment$Companion;", "", "()V", "EXTRA_CONFIG_PAGE", "", "newInstance", "Lcom/coolapk/market/view/node/topic/TopicNodeDataListFragment;", "api", "Lcom/coolapk/market/model/ConfigPage;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TopicNodeDataListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final TopicNodeDataListFragment newInstance(ConfigPage configPage) {
            Intrinsics.checkNotNullParameter(configPage, "api");
            TopicNodeDataListFragment topicNodeDataListFragment = new TopicNodeDataListFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("EXTRA_CONFIG_PAGE", configPage);
            Unit unit = Unit.INSTANCE;
            topicNodeDataListFragment.setArguments(bundle);
            return topicNodeDataListFragment;
        }
    }

    public final TopicVXViewModel getViewModel$presentation_coolapkAppRelease() {
        TopicVXViewModel topicVXViewModel = this.viewModel;
        if (topicVXViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return topicVXViewModel;
    }

    public final void setViewModel$presentation_coolapkAppRelease(TopicVXViewModel topicVXViewModel) {
        Intrinsics.checkNotNullParameter(topicVXViewModel, "<set-?>");
        this.viewModel = topicVXViewModel;
    }

    public final TopicVXPresenter getPresenter$presentation_coolapkAppRelease() {
        TopicVXPresenter topicVXPresenter = this.presenter;
        if (topicVXPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return topicVXPresenter;
    }

    public final void setPresenter$presentation_coolapkAppRelease(TopicVXPresenter topicVXPresenter) {
        Intrinsics.checkNotNullParameter(topicVXPresenter, "<set-?>");
        this.presenter = topicVXPresenter;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new NodeHelper.NodeDividerRule());
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558963).constructor(new TopicNodeDataListFragment$onActivityCreated$1(this)).suitedMethod(TopicNodeDataListFragment$onActivityCreated$2.INSTANCE).resetItemViewType(NodeTopContentViewHolder.Companion.getVIEW_TYPE()).build(), 0, 2, null);
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        RecyclerView recyclerView2 = recyclerView;
        recyclerView2.setPadding(recyclerView2.getPaddingLeft(), recyclerView2.getPaddingTop(), recyclerView2.getPaddingRight(), NumberExtendsKt.getDp((Number) 64));
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067  */
    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        String str;
        String str2;
        Entity findLastEntity$default;
        String str3;
        String str4;
        Pair<String, String> nodeListApiFirstLastItem = NodeHelper.INSTANCE.getNodeListApiFirstLastItem(getDataList());
        String str5 = null;
        if (z) {
            if (nodeListApiFirstLastItem == null) {
                Entity findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null);
                if (findFirstEntity$default != null) {
                    str4 = findFirstEntity$default.getEntityId();
                }
            } else {
                str4 = nodeListApiFirstLastItem.getFirst();
            }
            str = str4;
            if (!z) {
                if (nodeListApiFirstLastItem == null) {
                    Entity findLastEntity$default2 = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
                    if (findLastEntity$default2 != null) {
                        str3 = findLastEntity$default2.getEntityId();
                    }
                } else {
                    str3 = nodeListApiFirstLastItem.getSecond();
                }
                str2 = str3;
                DataManager instance = DataManager.getInstance();
                ConfigPage configPage = getConfigPage();
                Intrinsics.checkNotNullExpressionValue(configPage, "configPage");
                String url = configPage.getUrl();
                ConfigPage configPage2 = getConfigPage();
                Intrinsics.checkNotNullExpressionValue(configPage2, "configPage");
                String title = configPage2.getTitle();
                findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
                if (findLastEntity$default != null) {
                    str5 = EntityExtendsKt.getPageContext(findLastEntity$default);
                }
                Observable<R> map = instance.getDataList(url, title, "", i, str, str2, str5).map(RxUtils.checkResultToData());
                Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…tils.checkResultToData())");
                return map;
            }
            str2 = null;
            DataManager instance = DataManager.getInstance();
            ConfigPage configPage = getConfigPage();
            Intrinsics.checkNotNullExpressionValue(configPage, "configPage");
            String url = configPage.getUrl();
            ConfigPage configPage2 = getConfigPage();
            Intrinsics.checkNotNullExpressionValue(configPage2, "configPage");
            String title = configPage2.getTitle();
            findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
            if (findLastEntity$default != null) {
            }
            Observable<R> map = instance.getDataList(url, title, "", i, str, str2, str5).map(RxUtils.checkResultToData());
            Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…tils.checkResultToData())");
            return map;
        }
        str = null;
        if (!z) {
        }
        str2 = null;
        DataManager instance = DataManager.getInstance();
        ConfigPage configPage = getConfigPage();
        Intrinsics.checkNotNullExpressionValue(configPage, "configPage");
        String url = configPage.getUrl();
        ConfigPage configPage2 = getConfigPage();
        Intrinsics.checkNotNullExpressionValue(configPage2, "configPage");
        String title = configPage2.getTitle();
        findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
        if (findLastEntity$default != null) {
        }
        Observable<R> map = instance.getDataList(url, title, "", i, str, str2, str5).map(RxUtils.checkResultToData());
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…tils.checkResultToData())");
        return map;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.feed.FeedEventProcessor.EventInterceptor
    public boolean shouldInterceptFeedEvent(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "event");
        if (obj instanceof FeedPostEvent) {
            String boundTopicID = EntityExtendsKt.getBoundTopicID(((FeedPostEvent) obj).getFeed());
            TopicVXViewModel topicVXViewModel = this.viewModel;
            if (topicVXViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            if (Intrinsics.areEqual(boundTopicID, topicVXViewModel.getModel().getId())) {
                refreshDataOnNextResumed();
                return true;
            }
        }
        return super.shouldInterceptFeedEvent(obj);
    }
}
