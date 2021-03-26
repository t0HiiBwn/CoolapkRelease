package com.coolapk.market.view.video;

import android.app.Activity;
import android.os.Bundle;
import android.text.style.URLSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.coolapk.market.databinding.FeedCommentCountViewPartBinding;
import com.coolapk.market.databinding.ItemFeedReplyBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.DropDownListener;
import com.coolapk.market.util.RecyclerViewDropDownListener;
import com.coolapk.market.view.feed.dialog.DefaultSheetGroupListFactory;
import com.coolapk.market.view.feed.dialog.SheetDataKt;
import com.coolapk.market.view.feed.dialog.SheetDialogWrapper;
import com.coolapk.market.view.feed.dialog.SheetFactoryOptions;
import com.coolapk.market.view.feed.dialog.SheetGroup;
import com.coolapk.market.view.feed.dialog.SheetGroupType;
import com.coolapk.market.view.feed.dialog.reply.ReplyUserSheetGroupFactory;
import com.coolapk.market.view.feed.reply.FeedDetailFragmentV8;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.MultiFeedReplyViewHolder;
import com.coolapk.market.widget.PreventAutoScrollRecyclerView;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0003\u0017\u0018\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001a\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0003J\b\u0010\u0016\u001a\u00020\nH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/view/video/VideoDetailReplyListFragment;", "Lcom/coolapk/market/view/feed/reply/FeedDetailFragmentV8;", "()V", "callback", "Lcom/coolapk/market/view/video/VideoDetailReplyListFragment$Callback;", "getCallback", "()Lcom/coolapk/market/view/video/VideoDetailReplyListFragment$Callback;", "setCallback", "(Lcom/coolapk/market/view/video/VideoDetailReplyListFragment$Callback;)V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onRequestViewReplyDetail", "reply", "Lcom/coolapk/market/model/FeedReply;", "onViewCreated", "view", "Landroid/view/View;", "scrollToCommentPosition", "", "setupVideoUIChange", "updateHeaderData", "Callback", "Companion", "VideoMultiFeedReplyViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VideoDetailReplyListFragment.kt */
public final class VideoDetailReplyListFragment extends FeedDetailFragmentV8 {
    public static final Companion Companion = new Companion(null);
    private Callback callback;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/video/VideoDetailReplyListFragment$Callback;", "", "requestExitCommentView", "", "requestRestoreCommentView", "setDropOffset", "offset", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VideoDetailReplyListFragment.kt */
    public interface Callback {
        void requestExitCommentView();

        void requestRestoreCommentView();

        void setDropOffset(int i);
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8
    public void updateHeaderData() {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/video/VideoDetailReplyListFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/video/VideoDetailReplyListFragment;", "feed", "Lcom/coolapk/market/model/Feed;", "flag", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VideoDetailReplyListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ VideoDetailReplyListFragment newInstance$default(Companion companion, Feed feed, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.newInstance(feed, i);
        }

        public final VideoDetailReplyListFragment newInstance(Feed feed, int i) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_feed", feed);
            bundle.putInt("extra_flag", i);
            VideoDetailReplyListFragment videoDetailReplyListFragment = new VideoDetailReplyListFragment();
            videoDetailReplyListFragment.setArguments(bundle);
            return videoDetailReplyListFragment;
        }
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final void setCallback(Callback callback2) {
        this.callback = callback2;
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, com.coolapk.market.view.cardlist.EntityListFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        SwipeRefreshLayout swipeRefreshLayout = getSwipeRefreshLayout();
        Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "swipeRefreshLayout");
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(swipeRefreshLayout);
        if (marginParams != null) {
            marginParams.topMargin = 0;
        }
        getRecyclerView().setPadding(0, 0, 0, DisplayUtils.dp2px(getActivity(), (float) 47));
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailFragmentV8, com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558723).suitedEntityType("feed_reply").constructor(new VideoDetailReplyListFragment$onActivityCreated$1(this)).build(), 0, 2, null);
        setupVideoUIChange();
    }

    private final void setupVideoUIChange() {
        FeedCommentCountViewPartBinding feedCommentCountViewPartBinding = (FeedCommentCountViewPartBinding) getCommentCountViewPart$presentation_coolapkAppRelease().getBinding();
        ImageView imageView = feedCommentCountViewPartBinding.closeView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.closeView");
        imageView.setVisibility(0);
        ImageView imageView2 = feedCommentCountViewPartBinding.closeView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.closeView");
        ViewExtendsKt.setUtilClickListener(imageView2, new VideoDetailReplyListFragment$setupVideoUIChange$1(this));
        feedCommentCountViewPartBinding.closeView.postDelayed(new VideoDetailReplyListFragment$setupVideoUIChange$2(this), 300);
        VideoDetailReplyListFragment$setupVideoUIChange$dropDownCallback$1 videoDetailReplyListFragment$setupVideoUIChange$dropDownCallback$1 = new VideoDetailReplyListFragment$setupVideoUIChange$dropDownCallback$1(this);
        LinearLayout linearLayout = feedCommentCountViewPartBinding.actionContainer;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        VideoDetailReplyListFragment$setupVideoUIChange$dropDownCallback$1 videoDetailReplyListFragment$setupVideoUIChange$dropDownCallback$12 = videoDetailReplyListFragment$setupVideoUIChange$dropDownCallback$1;
        linearLayout.setOnTouchListener(new DropDownListener(requireActivity, videoDetailReplyListFragment$setupVideoUIChange$dropDownCallback$12));
        RecyclerView recyclerView = getRecyclerView();
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
        recyclerView.addOnItemTouchListener(new RecyclerViewDropDownListener(requireActivity2, videoDetailReplyListFragment$setupVideoUIChange$dropDownCallback$12));
    }

    /* access modifiers changed from: private */
    public final void onRequestViewReplyDetail(FeedReply feedReply) {
        View view = getView();
        FrameLayout frameLayout = null;
        ViewParent parent = view != null ? view.getParent() : null;
        if (parent instanceof FrameLayout) {
            frameLayout = parent;
        }
        FrameLayout frameLayout2 = frameLayout;
        if (frameLayout2 != null) {
            VideoReplyDetailHeaderFragment newInstance = VideoReplyDetailHeaderFragment.Companion.newInstance(feedReply);
            newInstance.setUserVisibleHint(false);
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            ContextExtendsKt.requireAppCompatActivity(requireActivity).getSupportFragmentManager().beginTransaction().add(frameLayout2.getId(), newInstance).commitAllowingStateLoss();
            FragmentActivity requireActivity2 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
            ContextExtendsKt.requireAppCompatActivity(requireActivity2).getSupportFragmentManager().executePendingTransactions();
            FrameLayout frameLayout3 = frameLayout2;
            frameLayout3.getViewTreeObserver().addOnPreDrawListener(new VideoDetailReplyListFragment$onRequestViewReplyDetail$$inlined$doOnNextPreDraw$1(frameLayout3, newInstance));
        }
    }

    @Override // com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8
    public boolean scrollToCommentPosition() {
        RecyclerView recyclerView = getRecyclerView();
        PreventAutoScrollRecyclerView preventAutoScrollRecyclerView = null;
        if (!(recyclerView instanceof PreventAutoScrollRecyclerView)) {
            recyclerView = null;
        }
        PreventAutoScrollRecyclerView preventAutoScrollRecyclerView2 = (PreventAutoScrollRecyclerView) recyclerView;
        if (preventAutoScrollRecyclerView2 != null) {
            preventAutoScrollRecyclerView2.setPreventAutoScroll(false);
        }
        int findCommentCountPosition = findCommentCountPosition();
        boolean z = findCommentCountPosition >= 0;
        if (z) {
            RecyclerView recyclerView2 = getRecyclerView();
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
            RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
            Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(findCommentCountPosition, 0);
        }
        RecyclerView recyclerView3 = getRecyclerView();
        if (recyclerView3 instanceof PreventAutoScrollRecyclerView) {
            preventAutoScrollRecyclerView = recyclerView3;
        }
        PreventAutoScrollRecyclerView preventAutoScrollRecyclerView3 = preventAutoScrollRecyclerView;
        if (preventAutoScrollRecyclerView3 != null) {
            preventAutoScrollRecyclerView3.setPreventAutoScroll(true);
        }
        return z;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0014J%\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u000f2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0014¢\u0006\u0002\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/coolapk/market/view/video/VideoDetailReplyListFragment$VideoMultiFeedReplyViewHolder;", "Lcom/coolapk/market/viewholder/MultiFeedReplyViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "feedType", "", "(Lcom/coolapk/market/view/video/VideoDetailReplyListFragment;Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;Ljava/lang/String;)V", "createSheetGroupListOuter", "", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "data", "Lcom/coolapk/market/model/FeedReply;", "activity", "Landroid/app/Activity;", "options", "Lcom/coolapk/market/view/feed/dialog/SheetFactoryOptions;", "onPopulateSubReplyView", "", "reply", "showItemDialog", "feedReply", "spans", "", "Landroid/text/style/URLSpan;", "(Lcom/coolapk/market/model/FeedReply;[Landroid/text/style/URLSpan;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VideoDetailReplyListFragment.kt */
    public final class VideoMultiFeedReplyViewHolder extends MultiFeedReplyViewHolder {
        final /* synthetic */ VideoDetailReplyListFragment this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public VideoMultiFeedReplyViewHolder(VideoDetailReplyListFragment videoDetailReplyListFragment, View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, String str) {
            super(view, dataBindingComponent, itemActionHandler, str);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            Intrinsics.checkNotNullParameter(str, "feedType");
            this.this$0 = videoDetailReplyListFragment;
        }

        @Override // com.coolapk.market.viewholder.MultiFeedReplyViewHolder, com.coolapk.market.viewholder.FeedReplyViewHolder
        protected void onPopulateSubReplyView(FeedReply feedReply) {
            Intrinsics.checkNotNullParameter(feedReply, "reply");
            super.onPopulateSubReplyView(feedReply);
            ((ItemFeedReplyBinding) getBinding()).moreSubReplyView.setOnClickListener(new VideoDetailReplyListFragment$VideoMultiFeedReplyViewHolder$onPopulateSubReplyView$1(this, feedReply));
        }

        @Override // com.coolapk.market.viewholder.FeedReplyViewHolder
        protected void showItemDialog(FeedReply feedReply, URLSpan[] uRLSpanArr) {
            Intrinsics.checkNotNullParameter(feedReply, "feedReply");
            SheetDialogWrapper create$default = SheetDialogWrapper.Companion.create$default(SheetDialogWrapper.Companion, feedReply, new VideoDetailReplyListFragment$VideoMultiFeedReplyViewHolder$showItemDialog$1(this), null, 4, null);
            FragmentActivity requireActivity = this.this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            create$default.showDialog(requireActivity);
        }

        /* access modifiers changed from: private */
        public final List<SheetGroup> createSheetGroupListOuter(FeedReply feedReply, Activity activity, SheetFactoryOptions sheetFactoryOptions) {
            List<SheetGroup> createSheetGroupListFor = DefaultSheetGroupListFactory.INSTANCE.createSheetGroupListFor(feedReply, activity, sheetFactoryOptions);
            SheetDataKt.findAndIndex(createSheetGroupListFor, SheetGroupType.ReplyUser, ReplyUserSheetGroupFactory.ReplyAction.ViewChat, new VideoDetailReplyListFragment$VideoMultiFeedReplyViewHolder$createSheetGroupListOuter$$inlined$apply$lambda$1(this));
            return createSheetGroupListFor;
        }
    }
}
