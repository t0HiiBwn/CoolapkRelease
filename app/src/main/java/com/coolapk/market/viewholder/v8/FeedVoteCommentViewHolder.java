package com.coolapk.market.viewholder.v8;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemFeedVoteCommentBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.uri.FeedUriAction;
import com.coolapk.market.view.cardlist.EntityDataHelper;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.feed.vote.VoteCommentListViewPart;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.iview.Recyclable;
import com.coolapk.market.widget.hotplug.BaseFeedRelativeHotPlug;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001eB\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016R\u000e\u0010\n\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedVoteCommentViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemFeedVoteCommentBinding;", "Lcom/coolapk/market/model/Feed;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "feed", "headerViewPart", "Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "getHeaderViewPart", "()Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "headerViewPart$delegate", "Lkotlin/Lazy;", "relativeInfoHotPlug", "Lcom/coolapk/market/widget/hotplug/BaseFeedRelativeHotPlug;", "voteCommentViewPart", "Lcom/coolapk/market/view/feed/vote/VoteCommentListViewPart;", "getVoteCommentViewPart", "()Lcom/coolapk/market/view/feed/vote/VoteCommentListViewPart;", "voteCommentViewPart$delegate", "bindToContent", "", "data", "onClick", "view", "onRecycled", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedVoteCommentViewHolder.kt */
public final class FeedVoteCommentViewHolder extends GenericBindHolder<ItemFeedVoteCommentBinding, Feed> implements Recyclable {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558736;
    private Feed feed;
    private final Lazy headerViewPart$delegate;
    private final BaseFeedRelativeHotPlug relativeInfoHotPlug;
    private final Lazy voteCommentViewPart$delegate;

    private final FeedIntegratedHeaderViewPart getHeaderViewPart() {
        return (FeedIntegratedHeaderViewPart) this.headerViewPart$delegate.getValue();
    }

    private final VoteCommentListViewPart getVoteCommentViewPart() {
        return (VoteCommentListViewPart) this.voteCommentViewPart$delegate.getValue();
    }

    public static final /* synthetic */ Feed access$getFeed$p(FeedVoteCommentViewHolder feedVoteCommentViewHolder) {
        Feed feed2 = feedVoteCommentViewHolder.feed;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        return feed2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedVoteCommentViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ItemFeedVoteCommentBinding itemFeedVoteCommentBinding = (ItemFeedVoteCommentBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedVoteCommentBinding, "binding");
        itemFeedVoteCommentBinding.setClick(this);
        itemFeedVoteCommentBinding.cardView.setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.coolapk.market.viewholder.v8.FeedVoteCommentViewHolder.AnonymousClass1 */
            final /* synthetic */ FeedVoteCommentViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                Feed access$getFeed$p = FeedVoteCommentViewHolder.access$getFeed$p(this.this$0);
                Context context = this.this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                EntityExtendsKt.showItemDialog(access$getFeed$p, context);
                return true;
            }
        });
        this.headerViewPart$delegate = LazyKt.lazy(new FeedVoteCommentViewHolder$headerViewPart$2(this, dataBindingComponent));
        Space space = ((ItemFeedVoteCommentBinding) getBinding()).relativeSpaceView;
        Intrinsics.checkNotNullExpressionValue(space, "binding.relativeSpaceView");
        this.relativeInfoHotPlug = new BaseFeedRelativeHotPlug(space, dataBindingComponent, null, false, 12, null);
        this.voteCommentViewPart$delegate = LazyKt.lazy(new FeedVoteCommentViewHolder$voteCommentViewPart$2(this, dataBindingComponent));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedVoteCommentViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedVoteCommentViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(Feed feed2) {
        EntityDataHelper.BaseAssistData baseAssistData;
        EntityDataHelper entityDataHelper$presentation_coolapkAppRelease;
        Intrinsics.checkNotNullParameter(feed2, "data");
        ItemFeedVoteCommentBinding itemFeedVoteCommentBinding = (ItemFeedVoteCommentBinding) getBinding();
        this.feed = feed2;
        Intrinsics.checkNotNullExpressionValue(itemFeedVoteCommentBinding, "binding");
        itemFeedVoteCommentBinding.setModel(feed2);
        getHeaderViewPart().bindTo(feed2);
        this.relativeInfoHotPlug.bindTo(feed2);
        getVoteCommentViewPart().bindToContent(feed2);
        itemFeedVoteCommentBinding.executePendingBindings();
        DataBindingComponent component = getComponent();
        Intrinsics.checkNotNullExpressionValue(component, "component");
        EntityListFragment entityListFragment = KotlinExtendKt.getEntityListFragment(component);
        EntityDataHelper.FeedAssistData feedAssistData = null;
        if (entityListFragment == null || (entityDataHelper$presentation_coolapkAppRelease = entityListFragment.getEntityDataHelper$presentation_coolapkAppRelease()) == null) {
            baseAssistData = null;
        } else {
            Feed feed3 = this.feed;
            if (feed3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
            }
            baseAssistData = entityDataHelper$presentation_coolapkAppRelease.obtainAssistData(feed3);
        }
        if (baseAssistData instanceof EntityDataHelper.FeedAssistData) {
            feedAssistData = baseAssistData;
        }
        EntityDataHelper.FeedAssistData feedAssistData2 = feedAssistData;
        if (feedAssistData2 != null) {
            TextView textView = itemFeedVoteCommentBinding.textView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
            textView.setText(feedAssistData2.getBriefMessage());
            TextView textView2 = itemFeedVoteCommentBinding.textView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.textView");
            ViewExtendsKt.makeSpanClickable(textView2);
        } else {
            TextView textView3 = itemFeedVoteCommentBinding.textView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.textView");
            Feed feed4 = this.feed;
            if (feed4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
            }
            String message = feed4.getMessage();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getContext().getString(2131886656));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(AppHolder.getAppTheme().getColorAccent()), 0, spannableStringBuilder.length(), 33);
            Unit unit = Unit.INSTANCE;
            ViewExtendsKt.setBriefMessage(textView3, 90, message, spannableStringBuilder);
        }
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        View root = itemFeedVoteCommentBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        Feed feed5 = this.feed;
        if (feed5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        instance.traceFeedStayInList(root, feed5.getFeedTypeName());
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() != 2131362200) {
            super.onClick(view);
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        FeedUriAction.Companion companion = FeedUriAction.Companion;
        Feed feed2 = this.feed;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        ActionManagerCompat.startActivityByUrl$default(context, companion.buildUrl(feed2), null, null, 12, null);
    }

    @Override // com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        this.relativeInfoHotPlug.onRecycled();
    }
}
