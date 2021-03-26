package com.coolapk.market.view.feed;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemFeedReplyBinding;
import com.coolapk.market.extend.LifeCycleExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.cardlist.divider.DividerData;
import com.coolapk.market.view.cardlist.divider.SingleDividerRule;
import com.coolapk.market.view.feed.reply.FeedReplyEventProcessor;
import com.coolapk.market.viewholder.FeedReplyViewHolder;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import rx.Observable;
import rx.schedulers.Schedulers;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0016\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00100\u0013H\u0014J,\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00100\u0013H\u0014J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000eH\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0004H\u0014J \u0010\"\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0014J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u0019H\u0016J\u0006\u0010&\u001a\u00020\u0017R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fX\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/coolapk/market/view/feed/FeedReplyDetailFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "feedReply", "Lcom/coolapk/market/model/FeedReply;", "firstReplyId", "", "getFirstReplyId$presentation_coolapkAppRelease", "()Ljava/lang/String;", "setFirstReplyId$presentation_coolapkAppRelease", "(Ljava/lang/String;)V", "userReplyList", "Ljava/util/ArrayList;", "filterDataWhenLoadMore", "", "originData", "", "index", "newDataByCardId", "", "filterDataWhenRefresh", "findLastItem", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "onFeedReplyLoaded", "onRequestResponse", "data", "onSaveInstanceState", "outState", "viewSourceFeed", "Companion", "FeedReplyDetailViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedReplyDetailFragment.kt */
public class FeedReplyDetailFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_FEED = "extra_feed";
    public static final String EXTRA_FEED_ID = "extra_feed_id";
    public static final String EXTRA_REPLY_TYPE = "extra_reply_type";
    private FeedReply feedReply;
    private String firstReplyId;
    private ArrayList<FeedReply> userReplyList = new ArrayList<>();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/feed/FeedReplyDetailFragment$Companion;", "", "()V", "EXTRA_FEED", "", "EXTRA_FEED_ID", "EXTRA_REPLY_TYPE", "newInstance", "Lcom/coolapk/market/view/feed/FeedReplyDetailFragment;", "parentReply", "Lcom/coolapk/market/model/FeedReply;", "parentReplyId", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedReplyDetailFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FeedReplyDetailFragment newInstance(FeedReply feedReply) {
            Intrinsics.checkNotNullParameter(feedReply, "parentReply");
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_feed", feedReply);
            FeedReplyDetailFragment feedReplyDetailFragment = new FeedReplyDetailFragment();
            feedReplyDetailFragment.setArguments(bundle);
            return feedReplyDetailFragment;
        }

        public final FeedReplyDetailFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "parentReplyId");
            Bundle bundle = new Bundle();
            bundle.putString("extra_feed_id", str);
            FeedReplyDetailFragment feedReplyDetailFragment = new FeedReplyDetailFragment();
            feedReplyDetailFragment.setArguments(bundle);
            return feedReplyDetailFragment;
        }
    }

    public final String getFirstReplyId$presentation_coolapkAppRelease() {
        return this.firstReplyId;
    }

    public final void setFirstReplyId$presentation_coolapkAppRelease(String str) {
        this.firstReplyId = str;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("userReplyList", this.userReplyList);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList parcelableArrayList;
        this.firstReplyId = requireArguments().getString("extra_feed_id");
        FeedReply feedReply2 = (FeedReply) requireArguments().getParcelable("extra_feed");
        String str = this.firstReplyId;
        if (str == null || str.length() == 0) {
            this.firstReplyId = feedReply2 != null ? feedReply2.getId() : null;
        }
        if (feedReply2 != null) {
            onFeedReplyLoaded(feedReply2);
        }
        if (!(bundle == null || (parcelableArrayList = bundle.getParcelableArrayList("userReplyList")) == null)) {
            this.userReplyList.addAll(parcelableArrayList);
        }
        super.onActivityCreated(bundle);
        getVxDividerDecoration$presentation_coolapkAppRelease().setDefaultNoMargin();
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new SingleDividerRule(DividerData.Companion.getEMPTY()));
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setClipToPadding(false);
        getRecyclerView().setPadding(0, 0, 0, NumberExtendsKt.getDp((Number) 48));
        setRefreshEnable(false);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558716).suitedEntityType("feed_reply").constructor(new FeedReplyDetailFragment$onActivityCreated$1(this)).build(), 0, 2, null);
    }

    protected void onFeedReplyLoaded(FeedReply feedReply2) {
        Intrinsics.checkNotNullParameter(feedReply2, "feedReply");
        this.feedReply = feedReply2;
        requireArguments().putParcelable("extra_feed", feedReply2);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(StringUtils.titleWithNum(getString(2131886791), feedReply2.getReplyNum()));
        }
        if (isAdded()) {
            List<Parcelable> dataList = getDataList();
            String feedId = feedReply2.getFeedId();
            Intrinsics.checkNotNullExpressionValue(feedId, "feedReply.feedId");
            FeedReplyEventProcessor feedReplyEventProcessor = new FeedReplyEventProcessor(dataList, feedId, new FeedReplyDetailFragment$onFeedReplyLoaded$eventHandler$1(this, feedReply2));
            feedReplyEventProcessor.attach();
            Lifecycle lifecycle = getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
            LifeCycleExtendsKt.oneTimeOnDestroy(lifecycle, new FeedReplyDetailFragment$onFeedReplyLoaded$1(feedReplyEventProcessor));
        }
    }

    public final void viewSourceFeed() {
        FeedReply feedReply2 = this.feedReply;
        if (feedReply2 == null) {
            return;
        }
        if (!TextUtils.isEmpty(feedReply2.getUrl())) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            ActionManagerCompat.startActivityByUrl(requireActivity, feedReply2.getUrl(), null, null);
        } else if (feedReply2.getFtype() == 0) {
            ActionManager.startFeedDetailActivity(requireActivity(), feedReply2.getFeedId(), (String) null);
        } else if (feedReply2.getFtype() == 1) {
            ActionManager.startDyhArticleDetailActivity(getActivity(), feedReply2.getFeedId());
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        removeNoMoreDataView();
        if (list != null) {
            list.size();
        }
        if (getDataList().isEmpty() && this.feedReply != null) {
            List<Parcelable> dataList = getDataList();
            FeedReply feedReply2 = this.feedReply;
            Intrinsics.checkNotNull(feedReply2);
            dataList.add(feedReply2);
        }
        boolean onRequestResponse = super.onRequestResponse(z, list);
        if (onRequestResponse) {
            getDataList().addAll(this.userReplyList);
        }
        if (!onRequestResponse && !z) {
            addNoMoreDataView();
        }
        return onRequestResponse;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected int filterDataWhenRefresh(Object obj, int i, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(obj, "originData");
        Intrinsics.checkNotNullParameter(map, "newDataByCardId");
        if (Intrinsics.areEqual(obj, this.feedReply)) {
            return -1;
        }
        return super.filterDataWhenRefresh(obj, i, map);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected int filterDataWhenLoadMore(Object obj, int i, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(obj, "originData");
        Intrinsics.checkNotNullParameter(map, "newDataByCardId");
        int filterDataWhenLoadMore = super.filterDataWhenLoadMore(obj, i, map);
        if (!CollectionsKt.contains(this.userReplyList, obj)) {
            return filterDataWhenLoadMore;
        }
        if (filterDataWhenLoadMore != 0) {
            return 0;
        }
        ArrayList<FeedReply> arrayList = this.userReplyList;
        Objects.requireNonNull(arrayList, "null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        TypeIntrinsics.asMutableCollection(arrayList).remove(obj);
        return 0;
    }

    public final String findLastItem() {
        List<Parcelable> dataList = getDataList();
        int size = this.userReplyList.size();
        int size2 = dataList.size();
        while (true) {
            size2--;
            FeedReply feedReply2 = null;
            if (size2 < 0) {
                return null;
            }
            Parcelable parcelable = dataList.get(size2);
            if (parcelable instanceof FeedReply) {
                feedReply2 = parcelable;
            }
            FeedReply feedReply3 = feedReply2;
            if (feedReply3 != null) {
                if (size <= 0) {
                    return feedReply3.getId();
                }
                size--;
            }
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Observable<R> observable;
        FeedReply feedReply2 = this.feedReply;
        if (feedReply2 == null) {
            observable = DataManager.getInstance().getFeedReplyDetail(this.firstReplyId).compose(RxUtils.apiCommonToData()).doOnNext(new FeedReplyDetailFragment$onCreateRequest$singleObservable$1(this));
        } else {
            Intrinsics.checkNotNull(feedReply2);
            observable = Observable.just(feedReply2);
        }
        Observable<List<Entity>> flatMap = observable.observeOn(Schedulers.io()).flatMap(new FeedReplyDetailFragment$onCreateRequest$1(this, i));
        Intrinsics.checkNotNullExpressionValue(flatMap, "singleObservable\n       …Data())\n                }");
        return flatMap;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/feed/FeedReplyDetailFragment$FeedReplyDetailViewHolder;", "Lcom/coolapk/market/viewholder/FeedReplyViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "rid", "", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Ljava/lang/String;)V", "getRid", "()Ljava/lang/String;", "bindToContent", "", "reply", "Lcom/coolapk/market/model/FeedReply;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedReplyDetailFragment.kt */
    public static class FeedReplyDetailViewHolder extends FeedReplyViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558716;
        private final String rid;

        public final String getRid() {
            return this.rid;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FeedReplyDetailViewHolder(View view, DataBindingComponent dataBindingComponent, String str) {
            super(view, dataBindingComponent, null);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            this.rid = str;
        }

        @Override // com.coolapk.market.viewholder.FeedReplyViewHolder
        public void bindToContent(FeedReply feedReply) {
            Intrinsics.checkNotNullParameter(feedReply, "reply");
            super.bindToContent(feedReply);
            if (Intrinsics.areEqual(feedReply.getId(), this.rid) && getAdapterPosition() == 0) {
                ((ItemFeedReplyBinding) getBinding()).cardView.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
                return;
            }
            LinearLayout linearLayout = ((ItemFeedReplyBinding) getBinding()).cardView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.cardView");
            linearLayout.setBackground(null);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/FeedReplyDetailFragment$FeedReplyDetailViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: FeedReplyDetailFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }
}
