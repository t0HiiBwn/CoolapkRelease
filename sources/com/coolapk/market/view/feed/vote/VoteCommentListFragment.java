package com.coolapk.market.view.feed.vote;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.coolapk.market.event.FeedPostEvent;
import com.coolapk.market.event.FeedVoteRecommendEvent;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J$\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0018\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J \u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00162\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0014J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\"H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006$"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VoteCommentListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "config", "Lcom/coolapk/market/view/feed/vote/VoteCommentConfig;", "getConfig", "()Lcom/coolapk/market/view/feed/vote/VoteCommentConfig;", "config$delegate", "Lkotlin/Lazy;", "fid", "", "getFid", "()Ljava/lang/String;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "", "onFeedVoteRecommendEvent", "event", "Lcom/coolapk/market/event/FeedVoteRecommendEvent;", "onRequestFailure", "error", "", "onRequestResponse", "data", "shouldInterceptFeedEvent", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VoteCommentListFragment.kt */
public class VoteCommentListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_CONFIG = "extra_config";
    private final Lazy config$delegate = LazyKt.lazy(new VoteCommentListFragment$config$2(this));

    public final VoteCommentConfig getConfig() {
        return (VoteCommentConfig) this.config$delegate.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VoteCommentListFragment$Companion;", "", "()V", "EXTRA_CONFIG", "", "newInstance", "Lcom/coolapk/market/view/feed/vote/VoteCommentListFragment;", "config", "Lcom/coolapk/market/view/feed/vote/VoteCommentConfig;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VoteCommentListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VoteCommentListFragment newInstance(VoteCommentConfig voteCommentConfig) {
            Intrinsics.checkNotNullParameter(voteCommentConfig, "config");
            VoteCommentListFragment voteCommentListFragment = new VoteCommentListFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_config", voteCommentConfig);
            Unit unit = Unit.INSTANCE;
            voteCommentListFragment.setArguments(bundle);
            return voteCommentListFragment;
        }
    }

    public final String getFid() {
        return getConfig().getFid();
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getRecyclerView().setPadding(NumberExtendsKt.getDp((Number) 8), NumberExtendsKt.getDp((Number) 8), NumberExtendsKt.getDp((Number) 8), NumberExtendsKt.getDp((Number) 8));
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        ViewExtendsKt.removeAllItemDecorations(recyclerView);
        getRecyclerView().addItemDecoration(new VoteCommentListFragment$onActivityCreated$1());
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        recyclerView2.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558745).constructor(new VoteCommentListFragment$onActivityCreated$2(this)).suitedMethod(VoteCommentListFragment$onActivityCreated$3.INSTANCE).build(), -1);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        String optionId = getConfig().getOptionId();
        DataManager instance = DataManager.getInstance();
        String fid = getFid();
        Entity findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null);
        String id = findFirstEntity$default != null ? findFirstEntity$default.getId() : null;
        Entity findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
        Observable<R> compose = instance.getVoteCommentList(fid, optionId, i, id, findLastEntity$default != null ? findLastEntity$default.getEntityId() : null).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        removeHintOrRefreshView();
        boolean onRequestResponse = super.onRequestResponse(z, list);
        if (!onRequestResponse && EntityListFragment.findFirstEntityIndex$default(this, "feed", null, false, false, 14, null) < 0) {
            if (getConfig().getOptionId().length() > 0) {
                setEmptyData("该选项还没有人发布观点", 0);
            } else {
                addHintView("还没有人发布观点，说说你的观点吧~", null);
            }
            updateContentUI();
        }
        return onRequestResponse;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        super.onRequestFailure(z, th);
        removeHintOrRefreshView();
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.feed.FeedEventProcessor.EventInterceptor
    public boolean shouldInterceptFeedEvent(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "event");
        if ((obj instanceof FeedPostEvent) && Intrinsics.areEqual(((FeedPostEvent) obj).getFeed().getFid(), getFid())) {
            reloadData();
        }
        return super.shouldInterceptFeedEvent(obj);
    }

    @Subscribe
    public final void onFeedVoteRecommendEvent(FeedVoteRecommendEvent feedVoteRecommendEvent) {
        Intrinsics.checkNotNullParameter(feedVoteRecommendEvent, "event");
        if (Intrinsics.areEqual(feedVoteRecommendEvent.getFid(), getFid())) {
            int i = 0;
            for (T t : getDataList()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                T t2 = t;
                if (t2 instanceof Feed) {
                    T t3 = t2;
                    if (feedVoteRecommendEvent.match(t3)) {
                        getDataList().set(i, feedVoteRecommendEvent.patch(t3));
                    }
                }
                i = i2;
            }
        }
    }
}
