package com.coolapk.market.view.feed.reply;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.FeedCommentCountViewPartBinding;
import com.coolapk.market.databinding.ItemFeedActionViewBinding;
import com.coolapk.market.databinding.ItemFeedReplyTitleBinding;
import com.coolapk.market.databinding.ItemFeedSmallTitleBinding;
import com.coolapk.market.databinding.ItemNoMoreDataViewBinding;
import com.coolapk.market.extend.LifeCycleExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.SimpleActivity;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.cardlist.divider.FeedListDividerRule;
import com.coolapk.market.view.feed.FeedHotReplyListFragment;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.PreventAutoScrollRecyclerView;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleHolderFactorBuilder;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.greenrobot.eventbus.Subscribe;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 ?2\u00020\u0001:\u0005?@ABCB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\u001bJ\u0006\u0010\u001f\u001a\u00020\nJ\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\r\u0010!\u001a\u00020\u001bH\u0010¢\u0006\u0002\b\"J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\nH\u0004J\u0012\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010(\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\"\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+0*2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\nJ\u0010\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u000202H\u0007J \u00103\u001a\u00020.2\u0006\u0010-\u001a\u00020.2\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+H\u0014J\b\u00105\u001a\u00020.H\u0016J\b\u00106\u001a\u00020.H\u0014J\b\u00107\u001a\u00020.H\u0014J\u000e\u00108\u001a\u00020\u001b2\u0006\u00109\u001a\u00020\nJ\b\u0010:\u001a\u00020\u001bH&J\u0010\u0010;\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020=H\u0016J\u0006\u0010>\u001a\u00020\u001bR\u001b\u0010\u0003\u001a\u00020\u00048@X\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8@X\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006D"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedReplyListFragmentV8;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "commentCountViewPart", "Lcom/coolapk/market/view/feed/reply/CommentCountViewPart;", "getCommentCountViewPart$presentation_coolapkAppRelease", "()Lcom/coolapk/market/view/feed/reply/CommentCountViewPart;", "commentCountViewPart$delegate", "Lkotlin/Lazy;", "flags", "", "getFlags$presentation_coolapkAppRelease", "()I", "flags$delegate", "presenter", "Lcom/coolapk/market/view/feed/reply/FeedReplyPresenter;", "getPresenter", "()Lcom/coolapk/market/view/feed/reply/FeedReplyPresenter;", "setPresenter", "(Lcom/coolapk/market/view/feed/reply/FeedReplyPresenter;)V", "viewModel", "Lcom/coolapk/market/view/feed/reply/FeedReplyViewModel;", "getViewModel", "()Lcom/coolapk/market/view/feed/reply/FeedReplyViewModel;", "setViewModel", "(Lcom/coolapk/market/view/feed/reply/FeedReplyViewModel;)V", "addReplyToDataList", "", "reply", "Lcom/coolapk/market/model/FeedReply;", "fadeCommentPosition", "findCommentCountPosition", "handleFeedReply", "handleReplyAction", "handleReplyAction$presentation_coolapkAppRelease", "notifyCommentCountChange", "count", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "onFeedReplyTopEvent", "event", "Lcom/coolapk/market/view/feed/reply/FeedReplyTopEvent;", "onRequestResponse", "data", "scrollToCommentPosition", "shouldShowEmptyView", "shouldShowList", "updateDataTypeChange", "dataType", "updateHeaderData", "updateRecyclerViewBottomInset", "rect", "Landroid/graphics/Rect;", "viewHotComments", "Companion", "FeedReplyActionViewViewHolder", "FeedReplyTitleViewHolder", "FeedSmallTitleViewHolder", "NoMoreDataViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedReplyListFragmentV8.kt */
public abstract class FeedReplyListFragmentV8 extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String ENTITY_TYPE_COMMENT_COUNT = "COMMENT_COUNT";
    public static final String ENTITY_TYPE_SMALL_CURRENT_TITLE = "SMALL_CURRENT_TITLE";
    public static final String ENTITY_TYPE_SMALL_HOT_TITLE = "SMALL_HOT_TITLE";
    public static final String ENTITY_TYPE_SMALL_NEWEST_TITLE = "SMALL_NEWEST_TITLE";
    public static final String ENTITY_TYPE_VIEW_MORE = "REPLY_HOT_ACTION";
    private final Lazy commentCountViewPart$delegate = LazyKt.lazy(new FeedReplyListFragmentV8$commentCountViewPart$2(this));
    private final Lazy flags$delegate = LazyKt.lazy(new FeedReplyListFragmentV8$flags$2(this));
    public FeedReplyPresenter presenter;
    public FeedReplyViewModel viewModel;

    public final CommentCountViewPart getCommentCountViewPart$presentation_coolapkAppRelease() {
        return (CommentCountViewPart) this.commentCountViewPart$delegate.getValue();
    }

    public final int getFlags$presentation_coolapkAppRelease() {
        return ((Number) this.flags$delegate.getValue()).intValue();
    }

    public abstract void updateHeaderData();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedReplyListFragmentV8$Companion;", "", "()V", "ENTITY_TYPE_COMMENT_COUNT", "", "ENTITY_TYPE_SMALL_CURRENT_TITLE", "ENTITY_TYPE_SMALL_HOT_TITLE", "ENTITY_TYPE_SMALL_NEWEST_TITLE", "ENTITY_TYPE_VIEW_MORE", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedReplyListFragmentV8.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final FeedReplyPresenter getPresenter() {
        FeedReplyPresenter feedReplyPresenter = this.presenter;
        if (feedReplyPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return feedReplyPresenter;
    }

    public final void setPresenter(FeedReplyPresenter feedReplyPresenter) {
        Intrinsics.checkNotNullParameter(feedReplyPresenter, "<set-?>");
        this.presenter = feedReplyPresenter;
    }

    public final FeedReplyViewModel getViewModel() {
        FeedReplyViewModel feedReplyViewModel = this.viewModel;
        if (feedReplyViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return feedReplyViewModel;
    }

    public final void setViewModel(FeedReplyViewModel feedReplyViewModel) {
        Intrinsics.checkNotNullParameter(feedReplyViewModel, "<set-?>");
        this.viewModel = feedReplyViewModel;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
        FeedReplyViewModel obtain = FeedReplyViewModel.Companion.obtain(appCompatActivity);
        this.viewModel = obtain;
        if (obtain == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        this.presenter = new FeedReplyPresenter(this, obtain, appCompatActivity);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getEntityAdHelper$presentation_coolapkAppRelease().setShouldDestroyADAfterRefresh(false);
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new FeedListDividerRule());
        getVxDividerDecoration$presentation_coolapkAppRelease().setDefaultNoMargin();
        getVxDividerDecoration$presentation_coolapkAppRelease().setDividerColor(AppHolder.getAppTheme().getContentBackgroundDividerColor());
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558716).suitedEntityType("feed_reply").constructor(new FeedReplyListFragmentV8$onActivityCreated$1(this)).build(), 0, 2, null);
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558716).suitedMethod(new FeedReplyListFragmentV8$onActivityCreated$2(this)).constructor(new FeedReplyListFragmentV8$onActivityCreated$3(this)).doAfterBind(FeedReplyListFragmentV8$onActivityCreated$4.INSTANCE).resetItemViewType(2131588103).build(), -1);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558721).suitedEntityType("COMMENT_COUNT").constructor(new FeedReplyListFragmentV8$onActivityCreated$5(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558728).suitedMethod(FeedReplyListFragmentV8$onActivityCreated$6.INSTANCE).constructor(new FeedReplyListFragmentV8$onActivityCreated$7(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558690).suitedEntityType("REPLY_HOT_ACTION").constructor(new FeedReplyListFragmentV8$onActivityCreated$8(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter adapter$presentation_coolapkAppRelease = getAdapter$presentation_coolapkAppRelease();
        SimpleHolderFactorBuilder constructor = SimpleViewHolderFactor.Companion.withLayoutId(2131558933).suitedEntityType("user").constructor(new FeedReplyListFragmentV8$onActivityCreated$9(this));
        Integer num = getItemViewTypeByEntityType().get("user");
        Intrinsics.checkNotNull(num);
        Intrinsics.checkNotNullExpressionValue(num, "(itemViewTypeByEntityTyp…tils.ENTITY_TYPE_USER])!!");
        BaseMultiTypeAdapter.register$default(adapter$presentation_coolapkAppRelease, constructor.resetItemViewType(num.intValue()).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558701).suitedEntityType("forwardFeed").constructor(new FeedReplyListFragmentV8$onActivityCreated$10(this)).build(), 0, 2, null);
        FeedReplyViewModel feedReplyViewModel = this.viewModel;
        if (feedReplyViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        List<Entity> loadedData = feedReplyViewModel.getLoadedDataArray().get(1).getLoadedData();
        FeedReplyViewModel feedReplyViewModel2 = this.viewModel;
        if (feedReplyViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        FeedReplyEventProcessor feedReplyEventProcessor = new FeedReplyEventProcessor(loadedData, feedReplyViewModel2.getFeedId(), FeedReplyListFragmentV8$onActivityCreated$loadedDataHandler$1.INSTANCE);
        List<Parcelable> dataList = getDataList();
        FeedReplyViewModel feedReplyViewModel3 = this.viewModel;
        if (feedReplyViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        FeedReplyEventProcessor feedReplyEventProcessor2 = new FeedReplyEventProcessor(dataList, feedReplyViewModel3.getFeedId(), new FeedReplyListFragmentV8$onActivityCreated$eventHandler$1(this));
        feedReplyEventProcessor.attach();
        feedReplyEventProcessor2.attach();
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        LifeCycleExtendsKt.oneTimeOnDestroy(lifecycle, new FeedReplyListFragmentV8$onActivityCreated$11(feedReplyEventProcessor2, feedReplyEventProcessor));
        setAutoUpdateContentUiOnDataChanged(true);
        if (bundle == null) {
            updateHeaderData();
            FeedReplyViewModel feedReplyViewModel4 = this.viewModel;
            if (feedReplyViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            if (!feedReplyViewModel4.getHideAllComments()) {
                List<Parcelable> dataList2 = getDataList();
                HolderItem commentCountHolder = FeedReplyViewModel.Companion.getCommentCountHolder();
                Intrinsics.checkNotNullExpressionValue(commentCountHolder, "FeedReplyViewModel.commentCountHolder");
                dataList2.add(commentCountHolder);
            }
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        FeedReplyViewModel feedReplyViewModel5 = this.viewModel;
        if (feedReplyViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<Integer> loadDataType = feedReplyViewModel5.getLoadDataType();
        FeedReplyPresenter feedReplyPresenter = this.presenter;
        if (feedReplyPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        loadDataType.observe(feedReplyPresenter.getLifecycleOwner(), new FeedReplyListFragmentV8$onActivityCreated$12(this, booleanRef));
        booleanRef.element = false;
        FeedReplyViewModel feedReplyViewModel6 = this.viewModel;
        if (feedReplyViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<FilterArgs> filterArgs = feedReplyViewModel6.getFilterArgs();
        FeedReplyPresenter feedReplyPresenter2 = this.presenter;
        if (feedReplyPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        filterArgs.observe(feedReplyPresenter2.getLifecycleOwner(), new FeedReplyListFragmentV8$onActivityCreated$13(this));
        if (getUserVisibleHint()) {
            setLoading(false);
        }
        int findCommentCountPosition = findCommentCountPosition();
        if (findCommentCountPosition >= 0) {
            getCommentCountViewPart$presentation_coolapkAppRelease().bindToContent(Integer.valueOf(findCommentCountPosition));
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public void updateRecyclerViewBottomInset(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        RecyclerView recyclerView2 = recyclerView;
        recyclerView2.setPadding(recyclerView2.getPaddingLeft(), recyclerView2.getPaddingTop(), recyclerView2.getPaddingRight(), rect.bottom + NumberExtendsKt.getDp((Number) 52));
    }

    @Subscribe
    public final void onFeedReplyTopEvent(FeedReplyTopEvent feedReplyTopEvent) {
        Intrinsics.checkNotNullParameter(feedReplyTopEvent, "event");
        FeedReplyPresenter feedReplyPresenter = this.presenter;
        if (feedReplyPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        feedReplyPresenter.handleFeedReplyTopEvent(feedReplyTopEvent);
        FeedReplyViewModel feedReplyViewModel = this.viewModel;
        if (feedReplyViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Integer value = feedReplyViewModel.getLoadDataType().getValue();
        if (value != null && value.intValue() == 1) {
            FeedReplyPresenter feedReplyPresenter2 = this.presenter;
            if (feedReplyPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            feedReplyPresenter2.dispatchIntoDataList(1, getDataList());
        }
    }

    public final void updateDataTypeChange(int i) {
        getRecyclerView().stopScroll();
        cancelLoadData();
        FeedReplyPresenter feedReplyPresenter = this.presenter;
        if (feedReplyPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        feedReplyPresenter.dispatchIntoDataList(i, getDataList());
        FeedReplyViewModel feedReplyViewModel = this.viewModel;
        if (feedReplyViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        setPage(feedReplyViewModel.getLoadedDataArray().get(i).getLoadedPage());
        FeedReplyViewModel feedReplyViewModel2 = this.viewModel;
        if (feedReplyViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Integer value = feedReplyViewModel2.getCommentNum().getValue();
        Intrinsics.checkNotNull(value);
        Intrinsics.checkNotNullExpressionValue(value, "viewModel.commentNum.value!!");
        notifyCommentCountChange(value.intValue());
        removeNoMoreDataView();
        if (getUserVisibleHint()) {
            reloadData();
            addRefreshView();
        }
    }

    public final void viewHotComments() {
        SimpleActivity.Builder builder = SimpleActivity.builder(getActivity());
        String key_feed_id = FeedHotReplyListFragment.Companion.getKEY_FEED_ID();
        FeedReplyViewModel feedReplyViewModel = this.viewModel;
        if (feedReplyViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        builder.addArgs(key_feed_id, feedReplyViewModel.getFeedId()).fragmentClass(FeedHotReplyListFragment.class).title(getString(2131886852)).start();
    }

    public void handleFeedReply(FeedReply feedReply) {
        Intrinsics.checkNotNullParameter(feedReply, "reply");
        String feedId = feedReply.getFeedId();
        FeedReplyViewModel feedReplyViewModel = this.viewModel;
        if (feedReplyViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        if (!(!Intrinsics.areEqual(feedId, feedReplyViewModel.getFeedId()))) {
            removeHintOrRefreshView();
            addReplyToDataList(feedReply);
            FeedReplyViewModel feedReplyViewModel2 = this.viewModel;
            if (feedReplyViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            Integer value = feedReplyViewModel2.getCommentNum().getValue();
            Intrinsics.checkNotNull(value);
            Intrinsics.checkNotNullExpressionValue(value, "viewModel.commentNum.value!!");
            notifyCommentCountChange(value.intValue());
        }
    }

    private final void addReplyToDataList(FeedReply feedReply) {
        FeedReplyPresenter feedReplyPresenter = this.presenter;
        if (feedReplyPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        feedReplyPresenter.addUserReply(feedReply);
        FeedReplyViewModel feedReplyViewModel = this.viewModel;
        if (feedReplyViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Integer value = feedReplyViewModel.getLoadDataType().getValue();
        if (value != null && value.intValue() == 1) {
            FeedReplyPresenter feedReplyPresenter2 = this.presenter;
            if (feedReplyPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            feedReplyPresenter2.dispatchIntoDataList(1, getDataList());
        }
        int indexOf = getDataList().indexOf(feedReply);
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        ViewExtendsKt.makePositionInScreen$default(recyclerView, indexOf, 0, 2, null);
    }

    protected final void notifyCommentCountChange(int i) {
        FeedReplyViewModel feedReplyViewModel = this.viewModel;
        if (feedReplyViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Integer value = feedReplyViewModel.getCommentNum().getValue();
        if (value == null || i != value.intValue()) {
            FeedReplyViewModel feedReplyViewModel2 = this.viewModel;
            if (feedReplyViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            feedReplyViewModel2.getCommentNum().setValue(Integer.valueOf(i));
        }
        getRecyclerView().post(new FeedReplyListFragmentV8$notifyCommentCountChange$1(this));
    }

    public boolean scrollToCommentPosition() {
        RecyclerView recyclerView = getRecyclerView();
        PreventAutoScrollRecyclerView preventAutoScrollRecyclerView = null;
        if (!(recyclerView instanceof PreventAutoScrollRecyclerView)) {
            recyclerView = null;
        }
        PreventAutoScrollRecyclerView preventAutoScrollRecyclerView2 = (PreventAutoScrollRecyclerView) recyclerView;
        int i = 0;
        if (preventAutoScrollRecyclerView2 != null) {
            preventAutoScrollRecyclerView2.setPreventAutoScroll(false);
        }
        int findCommentCountPosition = findCommentCountPosition();
        int findFirstEntityIndex$default = EntityListFragment.findFirstEntityIndex$default(this, "card", "sponsorCard", false, false, 12, null);
        if (findFirstEntityIndex$default >= 0 && findCommentCountPosition > findFirstEntityIndex$default) {
            findCommentCountPosition = findFirstEntityIndex$default;
        }
        boolean z = findCommentCountPosition >= 0;
        if (z) {
            RecyclerView recyclerView2 = getRecyclerView();
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
            RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
            Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            RecyclerView recyclerView3 = getRecyclerView();
            Intrinsics.checkNotNullExpressionValue(recyclerView3, "recyclerView");
            if (recyclerView3.getPaddingTop() <= 0) {
                SwipeRefreshLayout swipeRefreshLayout = getSwipeRefreshLayout();
                Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "swipeRefreshLayout");
                ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(swipeRefreshLayout);
                int valueOf = marginParams != null ? Integer.valueOf(marginParams.topMargin) : null;
                if (valueOf == null) {
                    valueOf = 0;
                }
                if (valueOf.intValue() <= 0) {
                    i = UiUtils.getActionBarSize(getActivity()) + UiUtils.getStatusBarHeight(getActivity());
                }
            }
            linearLayoutManager.scrollToPositionWithOffset(findCommentCountPosition, i);
        }
        RecyclerView recyclerView4 = getRecyclerView();
        if (recyclerView4 instanceof PreventAutoScrollRecyclerView) {
            preventAutoScrollRecyclerView = recyclerView4;
        }
        PreventAutoScrollRecyclerView preventAutoScrollRecyclerView3 = preventAutoScrollRecyclerView;
        if (preventAutoScrollRecyclerView3 != null) {
            preventAutoScrollRecyclerView3.setPreventAutoScroll(true);
        }
        return z;
    }

    public void handleReplyAction$presentation_coolapkAppRelease() {
        FragmentActivity activity = getActivity();
        FeedReplyViewModel feedReplyViewModel = this.viewModel;
        if (feedReplyViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        String feedId = feedReplyViewModel.getFeedId();
        FeedReplyViewModel feedReplyViewModel2 = this.viewModel;
        if (feedReplyViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        ActionManager.startFeedCommentActivity(activity, feedId, feedReplyViewModel2.getFeedUserName());
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public final Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        FeedReplyPresenter feedReplyPresenter = this.presenter;
        if (feedReplyPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        FeedReplyViewModel feedReplyViewModel = this.viewModel;
        if (feedReplyViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Integer value = feedReplyViewModel.getLoadDataType().getValue();
        Intrinsics.checkNotNull(value);
        Intrinsics.checkNotNullExpressionValue(value, "viewModel.loadDataType.value!!");
        return feedReplyPresenter.createRequest(value.intValue(), i);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return getDataList().size() > 0;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowEmptyView() {
        return getDataList().size() == 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        removeHintOrRefreshView();
        removeNoMoreDataView();
        if (list != null) {
            list.size();
        }
        Parcelable parcelable = (Parcelable) CollectionsKt.lastOrNull((List<? extends Object>) getDataList());
        boolean z2 = list != null && (list.isEmpty() ^ true);
        FeedReplyPresenter feedReplyPresenter = this.presenter;
        if (feedReplyPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        FeedReplyViewModel feedReplyViewModel = this.viewModel;
        if (feedReplyViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Integer value = feedReplyViewModel.getLoadDataType().getValue();
        Intrinsics.checkNotNull(value);
        Intrinsics.checkNotNullExpressionValue(value, "viewModel.loadDataType.value!!");
        feedReplyPresenter.markDataResult(value.intValue(), z ? 1 : getPage() + 1, list);
        if (z2) {
            changeDataListAndAutoCalculateDiff(new FeedReplyListFragmentV8$onRequestResponse$1(this));
        }
        FeedReplyViewModel feedReplyViewModel2 = this.viewModel;
        if (feedReplyViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Integer value2 = feedReplyViewModel2.getLoadDataType().getValue();
        if (value2 != null && value2.intValue() == 1) {
            int findCommentCountPosition = findCommentCountPosition();
            if (!z2 && EntityListFragment.findFirstEntityIndex$default(this, "feed_reply", null, false, false, 14, null) < 0) {
                FeedReplyViewModel feedReplyViewModel3 = this.viewModel;
                if (feedReplyViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                Integer value3 = feedReplyViewModel3.getBlockNum().getValue();
                Intrinsics.checkNotNull(value3);
                if (Intrinsics.compare(value3.intValue(), 0) > 0) {
                    FeedReplyViewModel feedReplyViewModel4 = this.viewModel;
                    if (feedReplyViewModel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    if (feedReplyViewModel4.getFilterArgs().getValue() != FilterArgs.FILTER_BY_BLOCK_STATUS) {
                        addNoMoreDataView();
                    }
                }
                if (findCommentCountPosition == CollectionsKt.getLastIndex(getDataList())) {
                    String string = getString(2131886865);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.str_left_a_comment)");
                    addHintView(string, new FeedReplyListFragmentV8$onRequestResponse$2(this));
                }
            } else if (!z2 && !z) {
                addNoMoreDataView();
            }
            Parcelable parcelable2 = (Parcelable) CollectionsKt.getOrNull(getDataList(), CollectionsKt.getLastIndex(getDataList()));
            if ((parcelable2 instanceof HolderItem) && Intrinsics.areEqual(((HolderItem) parcelable2).getEntityType(), "SMALL_NEWEST_TITLE")) {
                getDataList().remove(CollectionsKt.getLastIndex(getDataList()));
            }
        } else if (((value2 != null && value2.intValue() == 2) || (value2 != null && value2.intValue() == 0)) && !z2 && !z) {
            addNoMoreDataView();
        }
        if (z2 && parcelable != null) {
            getAdapter$presentation_coolapkAppRelease().notifyItemChanged(getDataList().indexOf(parcelable));
        }
        return z2;
    }

    public final void fadeCommentPosition() {
        int findFirstEntityIndex$default = EntityListFragment.findFirstEntityIndex$default(this, "SMALL_CURRENT_TITLE", null, false, false, 6, null);
        if (findFirstEntityIndex$default > 0) {
            getRecyclerView().post(new FeedReplyListFragmentV8$fadeCommentPosition$1(this, findFirstEntityIndex$default));
        }
    }

    public final int findCommentCountPosition() {
        return EntityListFragment.findFirstEntityIndex$default(this, "COMMENT_COUNT", null, false, false, 6, null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedReplyListFragmentV8$FeedSmallTitleViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemFeedSmallTitleBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Lcom/coolapk/market/binding/FragmentBindingComponent;", "presenter", "Lcom/coolapk/market/view/feed/reply/FeedReplyPresenter;", "(Landroid/view/View;Lcom/coolapk/market/binding/FragmentBindingComponent;Lcom/coolapk/market/view/feed/reply/FeedReplyPresenter;)V", "getPresenter", "()Lcom/coolapk/market/view/feed/reply/FeedReplyPresenter;", "bindToContent", "", "holderItem", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedReplyListFragmentV8.kt */
    public static final class FeedSmallTitleViewHolder extends GenericBindHolder<ItemFeedSmallTitleBinding, HolderItem> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558728;
        private final FeedReplyPresenter presenter;

        public final FeedReplyPresenter getPresenter() {
            return this.presenter;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FeedSmallTitleViewHolder(View view, FragmentBindingComponent fragmentBindingComponent, FeedReplyPresenter feedReplyPresenter) {
            super(view, fragmentBindingComponent);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(fragmentBindingComponent, "component");
            Intrinsics.checkNotNullParameter(feedReplyPresenter, "presenter");
            this.presenter = feedReplyPresenter;
        }

        public void bindToContent(HolderItem holderItem) {
            Intrinsics.checkNotNullParameter(holderItem, "holderItem");
            TextView textView = ((ItemFeedSmallTitleBinding) getBinding()).titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
            textView.setText(holderItem.getString());
            ((ItemFeedSmallTitleBinding) getBinding()).executePendingBindings();
            TextView textView2 = ((ItemFeedSmallTitleBinding) getBinding()).actionView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.actionView");
            textView2.setVisibility(8);
            if (Intrinsics.areEqual(holderItem.getEntityType(), "SMALL_CURRENT_TITLE")) {
                List<FeedReply> value = this.presenter.getViewModel().getReplyMeList().getValue();
                FeedReply feedReply = value != null ? (FeedReply) CollectionsKt.firstOrNull((List<? extends Object>) value) : null;
                if (feedReply != null && feedReply.hasParentReply()) {
                    TextView textView3 = ((ItemFeedSmallTitleBinding) getBinding()).actionView;
                    Intrinsics.checkNotNullExpressionValue(textView3, "binding.actionView");
                    textView3.setVisibility(0);
                    ((ItemFeedSmallTitleBinding) getBinding()).actionView.setOnClickListener(new FeedReplyListFragmentV8$FeedSmallTitleViewHolder$bindToContent$1(this, feedReply));
                }
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedReplyListFragmentV8$FeedSmallTitleViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: FeedReplyListFragmentV8.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedReplyListFragmentV8$FeedReplyTitleViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemFeedReplyTitleBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Lcom/coolapk/market/binding/FragmentBindingComponent;", "commentCountViewPart", "Lcom/coolapk/market/view/feed/reply/CommentCountViewPart;", "(Landroid/view/View;Lcom/coolapk/market/binding/FragmentBindingComponent;Lcom/coolapk/market/view/feed/reply/CommentCountViewPart;)V", "getCommentCountViewPart", "()Lcom/coolapk/market/view/feed/reply/CommentCountViewPart;", "bindToContent", "", "holderItem", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedReplyListFragmentV8.kt */
    public static final class FeedReplyTitleViewHolder extends GenericBindHolder<ItemFeedReplyTitleBinding, HolderItem> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558721;
        private final CommentCountViewPart commentCountViewPart;

        public final CommentCountViewPart getCommentCountViewPart() {
            return this.commentCountViewPart;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FeedReplyTitleViewHolder(View view, FragmentBindingComponent fragmentBindingComponent, CommentCountViewPart commentCountViewPart2) {
            super(view, fragmentBindingComponent);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(fragmentBindingComponent, "component");
            Intrinsics.checkNotNullParameter(commentCountViewPart2, "commentCountViewPart");
            this.commentCountViewPart = commentCountViewPart2;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedReplyListFragmentV8$FeedReplyTitleViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: FeedReplyListFragmentV8.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public void bindToContent(HolderItem holderItem) {
            Intrinsics.checkNotNullParameter(holderItem, "holderItem");
            View root = ((FeedCommentCountViewPartBinding) this.commentCountViewPart.getBinding()).getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "commentCountViewPart.binding.root");
            ViewExtendsKt.detachFromParent(root);
            ((ItemFeedReplyTitleBinding) getBinding()).cardView.addView(root);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedReplyListFragmentV8$FeedReplyActionViewViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemFeedActionViewBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "presenter", "Lcom/coolapk/market/view/feed/reply/FeedReplyPresenter;", "(Landroid/view/View;Lcom/coolapk/market/viewholder/ItemActionHandler;Lcom/coolapk/market/view/feed/reply/FeedReplyPresenter;)V", "getPresenter", "()Lcom/coolapk/market/view/feed/reply/FeedReplyPresenter;", "bindToContent", "", "holderItem", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedReplyListFragmentV8.kt */
    public static final class FeedReplyActionViewViewHolder extends GenericBindHolder<ItemFeedActionViewBinding, HolderItem> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558690;
        private final FeedReplyPresenter presenter;

        public final FeedReplyPresenter getPresenter() {
            return this.presenter;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FeedReplyActionViewViewHolder(View view, ItemActionHandler itemActionHandler, FeedReplyPresenter feedReplyPresenter) {
            super(view, itemActionHandler);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(feedReplyPresenter, "presenter");
            this.presenter = feedReplyPresenter;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedReplyListFragmentV8$FeedReplyActionViewViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: FeedReplyListFragmentV8.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public void bindToContent(HolderItem holderItem) {
            Intrinsics.checkNotNullParameter(holderItem, "holderItem");
            ItemFeedActionViewBinding itemFeedActionViewBinding = (ItemFeedActionViewBinding) getBinding();
            TextView textView = itemFeedActionViewBinding.actionView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.actionView");
            textView.setText(getContext().getString(2131886876));
            itemFeedActionViewBinding.actionView.setTextColor(AppHolder.getAppTheme().getColorAccent());
            itemFeedActionViewBinding.executePendingBindings();
            Intrinsics.checkNotNullExpressionValue(itemFeedActionViewBinding, "binding");
            itemFeedActionViewBinding.getRoot().setOnClickListener(new FeedReplyListFragmentV8$FeedReplyActionViewViewHolder$bindToContent$1(this));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedReplyListFragmentV8$NoMoreDataViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemNoMoreDataViewBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindToContent", "", "holderItem", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedReplyListFragmentV8.kt */
    public static final class NoMoreDataViewHolder extends GenericBindHolder<ItemNoMoreDataViewBinding, HolderItem> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558837;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NoMoreDataViewHolder(View view, ItemActionHandler itemActionHandler) {
            super(view, itemActionHandler);
            Intrinsics.checkNotNullParameter(view, "itemView");
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedReplyListFragmentV8$NoMoreDataViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: FeedReplyListFragmentV8.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public void bindToContent(HolderItem holderItem) {
            Intrinsics.checkNotNullParameter(holderItem, "holderItem");
            TextView textView = ((ItemNoMoreDataViewBinding) getBinding()).textView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
            textView.setText("没有更多内容了");
        }
    }
}
