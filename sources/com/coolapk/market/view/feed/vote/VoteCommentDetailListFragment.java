package com.coolapk.market.view.feed.vote;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManagerCopy;
import com.coolapk.market.databinding.ItemVoteCommentEmptyBinding;
import com.coolapk.market.databinding.ItemVoteDetailSplitedTitleBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.widget.SimpleAdapterDataObserver;
import com.coolapk.market.widget.decoration.TopItemDecoration;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0004 !\"#B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\tH\u0002J \u0010\u0010\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J$\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\r0\u00182\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J \u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\rH\u0014J\b\u0010\u001f\u001a\u00020\u0014H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006$"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VoteCommentDetailListFragment;", "Lcom/coolapk/market/view/feed/vote/VoteCommentListFragment;", "()V", "needSplit", "", "getNeedSplit", "()Z", "pkOptionId", "", "", "getPkOptionId", "()[Ljava/lang/String;", "filterDataListByOptionId", "", "Lcom/coolapk/market/model/Feed;", "id", "getFirstLastItem", "Lkotlin/Pair;", "option", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "Lcom/coolapk/market/model/Entity;", "isRefresh", "page", "", "onRequestResponse", "data", "rebuildDataList", "Companion", "VoteCommentEmptyViewHolder", "VoteCommentSplitDecoration", "VoteCommentTitleViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VoteCommentDetailListFragment.kt */
public final class VoteCommentDetailListFragment extends VoteCommentListFragment {
    public static final Companion Companion = new Companion(null);
    private static final String ENTITY_TYPE_NO_COMMENT_EXIST = "entity_no_comment_exist";
    private static final String ENTITY_TYPE_TITLE = "entity_title";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VoteCommentDetailListFragment$Companion;", "", "()V", "ENTITY_TYPE_NO_COMMENT_EXIST", "", "ENTITY_TYPE_TITLE", "newInstance", "Lcom/coolapk/market/view/feed/vote/VoteCommentDetailListFragment;", "config", "Lcom/coolapk/market/view/feed/vote/VoteCommentConfig;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VoteCommentDetailListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VoteCommentDetailListFragment newInstance(VoteCommentConfig voteCommentConfig) {
            Intrinsics.checkNotNullParameter(voteCommentConfig, "config");
            VoteCommentDetailListFragment voteCommentDetailListFragment = new VoteCommentDetailListFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_config", voteCommentConfig);
            Unit unit = Unit.INSTANCE;
            voteCommentDetailListFragment.setArguments(bundle);
            return voteCommentDetailListFragment;
        }
    }

    /* access modifiers changed from: private */
    public final String[] getPkOptionId() {
        return getConfig().getPkOptionId();
    }

    private final boolean getNeedSplit() {
        return getConfig().shouldDisplayInMultiPage();
    }

    @Override // com.coolapk.market.view.feed.vote.VoteCommentListFragment, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getNeedSplit()) {
            getRecyclerView().addItemDecoration(new VoteCommentSplitDecoration());
            StaggeredGridLayoutManagerCopy staggeredGridLayoutManagerCopy = new StaggeredGridLayoutManagerCopy(2, 1);
            staggeredGridLayoutManagerCopy.setSpanIndexLookup(new VoteCommentDetailListFragment$onActivityCreated$1(this));
            RecyclerView recyclerView = getRecyclerView();
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
            recyclerView.setLayoutManager(staggeredGridLayoutManagerCopy);
            BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558995).constructor(new VoteCommentDetailListFragment$onActivityCreated$2(this)).suitedMethod(VoteCommentDetailListFragment$onActivityCreated$3.INSTANCE).build(), 0, 2, null);
            BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558994).constructor(new VoteCommentDetailListFragment$onActivityCreated$4(this)).suitedMethod(VoteCommentDetailListFragment$onActivityCreated$5.INSTANCE).build(), 0, 2, null);
        }
    }

    @Override // com.coolapk.market.view.feed.vote.VoteCommentListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        if (!getNeedSplit()) {
            return super.onCreateRequest(z, i);
        }
        Pair<String, String> firstLastItem = getFirstLastItem(getPkOptionId()[0]);
        String component2 = firstLastItem.component2();
        Observable<R> map = DataManager.getInstance().getVoteCommentList(getFid(), getPkOptionId()[0], i, firstLastItem.component1(), component2).map(RxUtils.checkResultToData());
        Pair<String, String> firstLastItem2 = getFirstLastItem(getPkOptionId()[1]);
        String component22 = firstLastItem2.component2();
        Observable<List<Entity>> compose = Observable.zip(map, DataManager.getInstance().getVoteCommentList(getFid(), getPkOptionId()[1], i, firstLastItem2.component1(), component22).map(RxUtils.checkResultToData()), VoteCommentDetailListFragment$onCreateRequest$1.INSTANCE).compose(RxUtils.applyIOSchedulers());
        Intrinsics.checkNotNullExpressionValue(compose, "Observable.zip(loadOptio…tils.applyIOSchedulers())");
        return compose;
    }

    /* access modifiers changed from: private */
    public final List<Feed> filterDataListByOptionId(String str) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : CollectionsKt.filterIsInstance(getDataList(), Feed.class)) {
            Feed feed = (Feed) obj;
            if (Intrinsics.areEqual(feed.getFeedType(), "voteComment") && Intrinsics.areEqual(feed.getExtraKey(), str)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final Pair<String, String> getFirstLastItem(String str) {
        List<Feed> filterDataListByOptionId = filterDataListByOptionId(str);
        Feed feed = (Feed) CollectionsKt.firstOrNull((List<? extends Object>) filterDataListByOptionId);
        String str2 = null;
        String id = feed != null ? feed.getId() : null;
        Feed feed2 = (Feed) CollectionsKt.lastOrNull((List<? extends Object>) filterDataListByOptionId);
        if (feed2 != null) {
            str2 = feed2.getId();
        }
        return TuplesKt.to(id, str2);
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.feed.vote.VoteCommentListFragment, com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        boolean onRequestResponse = super.onRequestResponse(z, list);
        if (onRequestResponse) {
            rebuildDataList();
        }
        return onRequestResponse;
    }

    private final void rebuildDataList() {
        if (getNeedSplit()) {
            changeDataListAndAutoCalculateDiff(new VoteCommentDetailListFragment$rebuildDataList$1(this));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VoteCommentDetailListFragment$VoteCommentTitleViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemVoteDetailSplitedTitleBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "config", "Lcom/coolapk/market/view/feed/vote/VoteCommentConfig;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/feed/vote/VoteCommentConfig;)V", "getConfig", "()Lcom/coolapk/market/view/feed/vote/VoteCommentConfig;", "bindToContent", "", "data", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VoteCommentDetailListFragment.kt */
    public static final class VoteCommentTitleViewHolder extends GenericBindHolder<ItemVoteDetailSplitedTitleBinding, HolderItem> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558995;
        private final VoteCommentConfig config;

        public final VoteCommentConfig getConfig() {
            return this.config;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public VoteCommentTitleViewHolder(View view, DataBindingComponent dataBindingComponent, VoteCommentConfig voteCommentConfig) {
            super(view, dataBindingComponent);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            Intrinsics.checkNotNullParameter(voteCommentConfig, "config");
            this.config = voteCommentConfig;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VoteCommentDetailListFragment$VoteCommentTitleViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: VoteCommentDetailListFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public void bindToContent(HolderItem holderItem) {
            Intrinsics.checkNotNullParameter(holderItem, "data");
            ItemVoteDetailSplitedTitleBinding itemVoteDetailSplitedTitleBinding = (ItemVoteDetailSplitedTitleBinding) getBinding();
            itemVoteDetailSplitedTitleBinding.pkLeftTextView.setTextColor(this.config.getPkOptionColor()[0]);
            itemVoteDetailSplitedTitleBinding.pkRightTextView.setTextColor(this.config.getPkOptionColor()[1]);
            Intrinsics.checkNotNullExpressionValue(itemVoteDetailSplitedTitleBinding, "binding");
            View root = itemVoteDetailSplitedTitleBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManagerCopy.LayoutParams");
            StaggeredGridLayoutManagerCopy.LayoutParams layoutParams2 = (StaggeredGridLayoutManagerCopy.LayoutParams) layoutParams;
            layoutParams2.setFullSpan(true);
            root.setLayoutParams(layoutParams2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VoteCommentDetailListFragment$VoteCommentEmptyViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemVoteCommentEmptyBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "config", "Lcom/coolapk/market/view/feed/vote/VoteCommentConfig;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/feed/vote/VoteCommentConfig;)V", "getConfig", "()Lcom/coolapk/market/view/feed/vote/VoteCommentConfig;", "bindToContent", "", "data", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VoteCommentDetailListFragment.kt */
    public static final class VoteCommentEmptyViewHolder extends GenericBindHolder<ItemVoteCommentEmptyBinding, HolderItem> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558994;
        private final VoteCommentConfig config;

        public final VoteCommentConfig getConfig() {
            return this.config;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public VoteCommentEmptyViewHolder(View view, DataBindingComponent dataBindingComponent, VoteCommentConfig voteCommentConfig) {
            super(view, dataBindingComponent);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            Intrinsics.checkNotNullParameter(voteCommentConfig, "config");
            this.config = voteCommentConfig;
            ((ItemVoteCommentEmptyBinding) getBinding()).cardView.setAspectRatio(1.7777778f);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VoteCommentDetailListFragment$VoteCommentEmptyViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: VoteCommentDetailListFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public void bindToContent(HolderItem holderItem) {
            Intrinsics.checkNotNullParameter(holderItem, "data");
            ItemVoteCommentEmptyBinding itemVoteCommentEmptyBinding = (ItemVoteCommentEmptyBinding) getBinding();
            Integer intValue = holderItem.getIntValue();
            Intrinsics.checkNotNullExpressionValue(itemVoteCommentEmptyBinding, "binding");
            View root = itemVoteCommentEmptyBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 4));
            int dp = NumberExtendsKt.getDp((Number) 1);
            Intrinsics.checkNotNullExpressionValue(intValue, "color");
            gradientDrawable.setStroke(dp, ColorUtils.adjustAlpha(intValue.intValue(), 0.1f));
            Unit unit = Unit.INSTANCE;
            root.setBackground(gradientDrawable);
            int adjustAlpha = ColorUtils.adjustAlpha(intValue.intValue(), 0.2f);
            Drawable drawable = ResourceUtils.getDrawable(getContext(), 2131231141);
            drawable.setTint(adjustAlpha);
            drawable.setBounds(0, 0, NumberExtendsKt.getDp((Number) 24), NumberExtendsKt.getDp((Number) 24));
            TextView textView = itemVoteCommentEmptyBinding.textView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
            textView.setText(holderItem.getTitle());
            itemVoteCommentEmptyBinding.textView.setTextColor(adjustAlpha);
            itemVoteCommentEmptyBinding.executePendingBindings();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0006\u0010\u0010\u001a\u00020\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VoteCommentDetailListFragment$VoteCommentSplitDecoration;", "Lcom/coolapk/market/widget/decoration/TopItemDecoration;", "(Lcom/coolapk/market/view/feed/vote/VoteCommentDetailListFragment;)V", "topPosition", "", "", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getTopPositions", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VoteCommentDetailListFragment.kt */
    public final class VoteCommentSplitDecoration extends TopItemDecoration {
        private final Set<Integer> topPosition = new LinkedHashSet();

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public VoteCommentSplitDecoration() {
            super(NumberExtendsKt.getDp((Number) 8), NumberExtendsKt.getDp((Number) 16));
            VoteCommentDetailListFragment.this.getAdapter$presentation_coolapkAppRelease().registerAdapterDataObserver(new SimpleAdapterDataObserver(this) {
                /* class com.coolapk.market.view.feed.vote.VoteCommentDetailListFragment.VoteCommentSplitDecoration.AnonymousClass1 */
                final /* synthetic */ VoteCommentSplitDecoration this$0;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.this$0 = r1;
                }

                @Override // com.coolapk.market.widget.SimpleAdapterDataObserver
                public void onModify() {
                    this.this$0.getTopPositions();
                }
            });
            getTopPositions();
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0049 A[LOOP:0: B:1:0x0011->B:12:0x0049, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00b2 A[LOOP:1: B:24:0x007e->B:35:0x00b2, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x004d A[EDGE_INSN: B:66:0x004d->B:14:0x004d ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x00b6 A[EDGE_INSN: B:69:0x00b6->B:37:0x00b6 ?: BREAK  , SYNTHETIC] */
        public final void getTopPositions() {
            int i;
            boolean z;
            boolean z2;
            boolean z3;
            this.topPosition.clear();
            Iterator<Parcelable> it2 = VoteCommentDetailListFragment.this.getDataList().iterator();
            int i2 = 0;
            while (true) {
                i = -1;
                z = true;
                if (!it2.hasNext()) {
                    i2 = -1;
                    break;
                }
                Parcelable next = it2.next();
                if (next instanceof Feed) {
                    Feed feed = (Feed) next;
                    if (Intrinsics.areEqual(feed.getFeedType(), "voteComment") && Intrinsics.areEqual(feed.getExtraKey(), VoteCommentDetailListFragment.this.getPkOptionId()[0])) {
                        z3 = true;
                        if (!z3) {
                            break;
                        }
                        i2++;
                    }
                }
                z3 = false;
                if (!z3) {
                }
            }
            Integer valueOf = Integer.valueOf(i2);
            Integer num = null;
            if (!(valueOf.intValue() >= 0)) {
                valueOf = null;
            }
            if (valueOf != null) {
                this.topPosition.add(Integer.valueOf(valueOf.intValue()));
            }
            Iterator<Parcelable> it3 = VoteCommentDetailListFragment.this.getDataList().iterator();
            int i3 = 0;
            while (true) {
                if (!it3.hasNext()) {
                    i3 = -1;
                    break;
                }
                Parcelable next2 = it3.next();
                if (next2 instanceof Feed) {
                    Feed feed2 = (Feed) next2;
                    if (Intrinsics.areEqual(feed2.getFeedType(), "voteComment") && Intrinsics.areEqual(feed2.getExtraKey(), VoteCommentDetailListFragment.this.getPkOptionId()[1])) {
                        z2 = true;
                        if (!z2) {
                            break;
                        }
                        i3++;
                    }
                }
                z2 = false;
                if (!z2) {
                }
            }
            Integer valueOf2 = Integer.valueOf(i3);
            if (!(valueOf2.intValue() >= 0)) {
                valueOf2 = null;
            }
            if (valueOf2 != null) {
                this.topPosition.add(Integer.valueOf(valueOf2.intValue()));
            }
            Iterator<Parcelable> it4 = VoteCommentDetailListFragment.this.getDataList().iterator();
            int i4 = 0;
            while (true) {
                if (!it4.hasNext()) {
                    break;
                }
                Parcelable next3 = it4.next();
                if ((next3 instanceof HolderItem) && Intrinsics.areEqual(((HolderItem) next3).getEntityType(), "entity_no_comment_exist")) {
                    i = i4;
                    break;
                }
                i4++;
            }
            Integer valueOf3 = Integer.valueOf(i);
            if (valueOf3.intValue() < 0) {
                z = false;
            }
            if (z) {
                num = valueOf3;
            }
            if (num != null) {
                this.topPosition.add(Integer.valueOf(num.intValue()));
            }
            this.topPosition.add(0);
        }

        @Override // com.coolapk.market.widget.decoration.TopItemDecoration, androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(rect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(recyclerView, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (this.topPosition.contains(Integer.valueOf(recyclerView.getChildLayoutPosition(view)))) {
                rect.set(0, getDividerHeight(), 0, 0);
            }
        }
    }
}
