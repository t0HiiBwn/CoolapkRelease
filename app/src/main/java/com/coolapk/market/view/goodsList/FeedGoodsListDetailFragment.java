package com.coolapk.market.view.goodsList;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.coolapk.market.event.GoodsAddedEvent;
import com.coolapk.market.event.GoodsDeleteEvent;
import com.coolapk.market.event.GoodsEditEvent;
import com.coolapk.market.event.GoodsItemEditEvent;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.GoodsListItem;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.view.base.AlphableToolbar;
import com.coolapk.market.view.feed.reply.FeedDetailFragmentV8;
import com.coolapk.market.widget.RecyclerScrollHeaderListener;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 .2\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020 H\u0007J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\"H\u0007J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020$H\u0007J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016J\u001a\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020+2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010,\u001a\u00020\u0011H\u0002J\b\u0010-\u001a\u00020\u0011H\u0016R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048DX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006/"}, d2 = {"Lcom/coolapk/market/view/goodsList/FeedGoodsListDetailFragment;", "Lcom/coolapk/market/view/feed/reply/FeedDetailFragmentV8;", "()V", "goodsList", "", "Lcom/coolapk/market/model/GoodsListItem;", "getGoodsList", "()Ljava/util/List;", "goodsList$delegate", "Lkotlin/Lazy;", "findItem", "", "targetId", "", "list", "", "notifyData", "", "feed", "Lcom/coolapk/market/model/Feed;", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onGoodsAddedEvent", "event", "Lcom/coolapk/market/event/GoodsAddedEvent;", "onGoodsDeleteEvent", "Lcom/coolapk/market/event/GoodsDeleteEvent;", "onGoodsEditEvent", "Lcom/coolapk/market/event/GoodsEditEvent;", "onGoodsItemEditEvent", "Lcom/coolapk/market/event/GoodsItemEditEvent;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onViewCreated", "view", "Landroid/view/View;", "setupAlphaToolbar", "updateContentUI", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedGoodsListDetailFragment.kt */
public class FeedGoodsListDetailFragment extends FeedDetailFragmentV8 {
    public static final Companion Companion = new Companion(null);
    private final Lazy goodsList$delegate = LazyKt.lazy(new FeedGoodsListDetailFragment$goodsList$2(this));

    protected final List<GoodsListItem> getGoodsList() {
        return (List) this.goodsList$delegate.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/goodsList/FeedGoodsListDetailFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/goodsList/FeedGoodsListDetailFragment;", "feed", "Lcom/coolapk/market/model/Feed;", "flag", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedGoodsListDetailFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ FeedGoodsListDetailFragment newInstance$default(Companion companion, Feed feed, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.newInstance(feed, i);
        }

        public final FeedGoodsListDetailFragment newInstance(Feed feed, int i) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_feed", feed);
            bundle.putInt("extra_flag", i);
            FeedGoodsListDetailFragment feedGoodsListDetailFragment = new FeedGoodsListDetailFragment();
            feedGoodsListDetailFragment.setArguments(bundle);
            return feedGoodsListDetailFragment;
        }
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    public void updateContentUI() {
        super.updateContentUI();
        if (shouldShowList()) {
            setLoading(false);
        }
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, com.coolapk.market.view.cardlist.EntityListFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (!(activity instanceof AlphableToolbar)) {
            activity = null;
        }
        AlphableToolbar alphableToolbar = (AlphableToolbar) activity;
        if (alphableToolbar != null) {
            alphableToolbar.setToolbarTitle("");
        }
        SwipeRefreshLayout swipeRefreshLayout = getSwipeRefreshLayout();
        Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "swipeRefreshLayout");
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(swipeRefreshLayout);
        if (marginParams != null) {
            marginParams.topMargin = 0;
        }
        getRecyclerView().setPadding(0, 0, 0, DisplayUtils.dp2px(getActivity(), (float) 47));
        setupAlphaToolbar();
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558754).constructor(new FeedGoodsListDetailFragment$onActivityCreated$1(this)).suitedEntityType("ENTITY_TYPE_DETAIL_TOP").resetItemViewType(2131558696).build(), 0, 2, null);
    }

    private final void setupAlphaToolbar() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof AlphableToolbar)) {
            activity = null;
        }
        AlphableToolbar alphableToolbar = (AlphableToolbar) activity;
        if (alphableToolbar != null) {
            alphableToolbar.setToolbarAlpha(0.0f);
            SwipeRefreshLayout swipeRefreshLayout = getSwipeRefreshLayout();
            Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "swipeRefreshLayout");
            ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(swipeRefreshLayout);
            if (marginParams != null) {
                marginParams.topMargin = 0;
            }
            getSwipeRefreshLayout().requestLayout();
            getRecyclerView().addOnScrollListener(new RecyclerScrollHeaderListener(NumberExtendsKt.getDp((Number) 80), new FeedGoodsListDetailFragment$setupAlphaToolbar$1(alphableToolbar)));
        }
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        MenuItem add = menu.add(0, 2131361901, 0, "编辑");
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        add.setVisible(Intrinsics.areEqual(loginSession.getUid(), getFeed$presentation_coolapkAppRelease().getUid()));
        add.setShowAsAction(2);
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 2131361901) {
            return super.onOptionsItemSelected(menuItem);
        }
        ActionManager.startFunThingsListEditActivity(getActivity(), getFeed$presentation_coolapkAppRelease());
        return true;
    }

    @Subscribe
    public final void onGoodsAddedEvent(GoodsAddedEvent goodsAddedEvent) {
        Intrinsics.checkNotNullParameter(goodsAddedEvent, "event");
        GoodsListItem goodsListItem = goodsAddedEvent.getGoodsListItem();
        ArrayList arrayList = new ArrayList();
        List<GoodsListItem> goodsListItem2 = getFeed$presentation_coolapkAppRelease().getGoodsListItem();
        Intrinsics.checkNotNullExpressionValue(goodsListItem2, "feed.goodsListItem");
        arrayList.addAll(goodsListItem2);
        if (goodsListItem != null) {
            String entityId = goodsListItem.getEntityId();
            Intrinsics.checkNotNull(entityId);
            Intrinsics.checkNotNullExpressionValue(entityId, "goodsListItem.entityId!!");
            int findItem = findItem(entityId, arrayList);
            if (findItem > -1) {
                arrayList.set(findItem, goodsListItem);
            } else {
                arrayList.add(0, goodsListItem);
            }
        }
        Feed build = Feed.newBuilder(getFeed$presentation_coolapkAppRelease()).goodsListItem(arrayList).build();
        Intrinsics.checkNotNullExpressionValue(build, "feed");
        notifyData(build);
    }

    @Subscribe
    public final void onGoodsDeleteEvent(GoodsDeleteEvent goodsDeleteEvent) {
        Intrinsics.checkNotNullParameter(goodsDeleteEvent, "event");
        GoodsListItem goodsListItem = goodsDeleteEvent.getGoodsListItem();
        List<GoodsListItem> goodsListItem2 = getFeed$presentation_coolapkAppRelease().getGoodsListItem();
        goodsListItem2.remove(goodsListItem);
        Feed build = Feed.newBuilder(getFeed$presentation_coolapkAppRelease()).goodsListItem(goodsListItem2).build();
        Intrinsics.checkNotNullExpressionValue(build, "feed");
        notifyData(build);
    }

    @Subscribe
    public final void onGoodsEditEvent(GoodsEditEvent goodsEditEvent) {
        Intrinsics.checkNotNullParameter(goodsEditEvent, "event");
        Feed goodsList = goodsEditEvent.getGoodsList();
        String extraPic = goodsList.getExtraPic();
        String title = goodsList.getTitle();
        Feed build = Feed.newBuilder(getFeed$presentation_coolapkAppRelease()).title(title).message(goodsList.getMessage()).extraPic(extraPic).build();
        Intrinsics.checkNotNullExpressionValue(build, "feed");
        notifyData(build);
    }

    @Subscribe
    public final void onGoodsItemEditEvent(GoodsItemEditEvent goodsItemEditEvent) {
        Intrinsics.checkNotNullParameter(goodsItemEditEvent, "event");
        Feed build = Feed.newBuilder(getFeed$presentation_coolapkAppRelease()).goodsListItem(goodsItemEditEvent.getGoodsListItem()).build();
        Intrinsics.checkNotNullExpressionValue(build, "feed");
        notifyData(build);
    }

    private final void notifyData(Feed feed) {
        getFeedPresenter$presentation_coolapkAppRelease().updateFeed(feed);
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = getRecyclerView().findViewHolderForAdapterPosition(0);
        if (findViewHolderForAdapterPosition instanceof GoodGoodsListHeaderViewHolder) {
            ((GoodGoodsListHeaderViewHolder) findViewHolderForAdapterPosition).notifyData();
        }
    }

    private final int findItem(String str, List<GoodsListItem> list) {
        if (list.isEmpty()) {
            return -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            GoodsListItem goodsListItem = list.get(i);
            String str2 = null;
            if (!(goodsListItem instanceof GoodsListItem)) {
                goodsListItem = null;
            }
            GoodsListItem goodsListItem2 = goodsListItem;
            if (goodsListItem2 != null) {
                str2 = goodsListItem2.getEntityId();
            }
            if (Intrinsics.areEqual(str, str2)) {
                return i;
            }
        }
        return -1;
    }
}
