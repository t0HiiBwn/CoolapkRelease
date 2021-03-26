package com.coolapk.market.viewholder.v8;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemFeedVoteBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.Vote;
import com.coolapk.market.model.VoteOption;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.uri.FeedUriAction;
import com.coolapk.market.view.cardlist.EntityDataHelper;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.feed.vote.VotePKViewPart;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.widget.LinearAdapterLayout;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\"B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003H\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003H\u0002J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003H\u0002J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0005H\u0002R\u000e\u0010\t\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedVoteViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemFeedVoteBinding;", "Lcom/coolapk/market/model/Feed;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "feed", "headerViewPart", "Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "getHeaderViewPart", "()Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "headerViewPart$delegate", "Lkotlin/Lazy;", "voteMultiView", "Lcom/coolapk/market/widget/LinearAdapterLayout;", "getVoteMultiView", "()Lcom/coolapk/market/widget/LinearAdapterLayout;", "voteMultiView$delegate", "votePKViewPart", "Lcom/coolapk/market/view/feed/vote/VotePKViewPart;", "getVotePKViewPart", "()Lcom/coolapk/market/view/feed/vote/VotePKViewPart;", "votePKViewPart$delegate", "bindToContent", "", "data", "onClick", "view", "populateMultiVoteType", "populateRunningPKVote", "setVoteView", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedVoteViewHolder.kt */
public final class FeedVoteViewHolder extends GenericBindHolder<ItemFeedVoteBinding, Feed> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558742;
    private Feed feed;
    private final Lazy headerViewPart$delegate;
    private final Lazy voteMultiView$delegate = LazyKt.lazy(new FeedVoteViewHolder$voteMultiView$2(this));
    private final Lazy votePKViewPart$delegate;

    private final FeedIntegratedHeaderViewPart getHeaderViewPart() {
        return (FeedIntegratedHeaderViewPart) this.headerViewPart$delegate.getValue();
    }

    private final LinearAdapterLayout getVoteMultiView() {
        return (LinearAdapterLayout) this.voteMultiView$delegate.getValue();
    }

    private final VotePKViewPart getVotePKViewPart() {
        return (VotePKViewPart) this.votePKViewPart$delegate.getValue();
    }

    public static final /* synthetic */ Feed access$getFeed$p(FeedVoteViewHolder feedVoteViewHolder) {
        Feed feed2 = feedVoteViewHolder.feed;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        return feed2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedVoteViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ItemFeedVoteBinding itemFeedVoteBinding = (ItemFeedVoteBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedVoteBinding, "binding");
        itemFeedVoteBinding.setClick(this);
        itemFeedVoteBinding.cardView.setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.coolapk.market.viewholder.v8.FeedVoteViewHolder.AnonymousClass1 */
            final /* synthetic */ FeedVoteViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                Feed access$getFeed$p = FeedVoteViewHolder.access$getFeed$p(this.this$0);
                Context context = this.this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                EntityExtendsKt.showItemDialog(access$getFeed$p, context);
                return true;
            }
        });
        this.headerViewPart$delegate = LazyKt.lazy(new FeedVoteViewHolder$headerViewPart$2(this, dataBindingComponent));
        this.votePKViewPart$delegate = LazyKt.lazy(new FeedVoteViewHolder$votePKViewPart$2(this, dataBindingComponent));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedVoteViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedVoteViewHolder.kt */
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
        ItemFeedVoteBinding itemFeedVoteBinding = (ItemFeedVoteBinding) getBinding();
        this.feed = feed2;
        Intrinsics.checkNotNullExpressionValue(itemFeedVoteBinding, "binding");
        itemFeedVoteBinding.setModel(feed2);
        Vote vote = feed2.getVote();
        Intrinsics.checkNotNull(vote);
        Intrinsics.checkNotNullExpressionValue(vote, "data.vote!!");
        FeedIntegratedHeaderViewPart headerViewPart = getHeaderViewPart();
        Feed feed3 = this.feed;
        if (feed3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        headerViewPart.bindTo(feed3);
        itemFeedVoteBinding.executePendingBindings();
        int type = vote.getType();
        boolean z = true;
        if (type == 0) {
            populateRunningPKVote(feed2);
        } else if (type == 1) {
            populateMultiVoteType(feed2);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("[Vote]");
        ColorDrawable colorDrawable = new ColorDrawable(0);
        colorDrawable.setBounds(0, 0, DisplayUtils.dp2px(getContext(), 38.0f), 0);
        spannableStringBuilder.setSpan(new ImageSpan(colorDrawable, "[Vote]"), 0, spannableStringBuilder.length(), 33);
        Feed feed4 = this.feed;
        if (feed4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        String messageTitle = feed4.getMessageTitle();
        if (messageTitle == null) {
            messageTitle = "";
        }
        spannableStringBuilder.append((CharSequence) messageTitle);
        TextView textView = itemFeedVoteBinding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText(spannableStringBuilder);
        Feed feed5 = this.feed;
        if (feed5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        String message = feed5.getMessage();
        if (!(message == null || message.length() == 0)) {
            z = false;
        }
        if (z) {
            TextView textView2 = itemFeedVoteBinding.textView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.textView");
            textView2.setVisibility(8);
        } else {
            TextView textView3 = itemFeedVoteBinding.textView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.textView");
            textView3.setVisibility(0);
            DataBindingComponent component = getComponent();
            Intrinsics.checkNotNullExpressionValue(component, "component");
            EntityListFragment entityListFragment = KotlinExtendKt.getEntityListFragment(component);
            EntityDataHelper.FeedAssistData feedAssistData = null;
            if (entityListFragment == null || (entityDataHelper$presentation_coolapkAppRelease = entityListFragment.getEntityDataHelper$presentation_coolapkAppRelease()) == null) {
                baseAssistData = null;
            } else {
                Feed feed6 = this.feed;
                if (feed6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feed");
                }
                baseAssistData = entityDataHelper$presentation_coolapkAppRelease.obtainAssistData(feed6);
            }
            if (baseAssistData instanceof EntityDataHelper.FeedAssistData) {
                feedAssistData = baseAssistData;
            }
            EntityDataHelper.FeedAssistData feedAssistData2 = feedAssistData;
            if (feedAssistData2 != null) {
                TextView textView4 = itemFeedVoteBinding.textView;
                Intrinsics.checkNotNullExpressionValue(textView4, "binding.textView");
                textView4.setText(feedAssistData2.getBriefMessage());
                TextView textView5 = itemFeedVoteBinding.textView;
                Intrinsics.checkNotNullExpressionValue(textView5, "binding.textView");
                ViewExtendsKt.makeSpanClickable(textView5);
            } else {
                TextView textView6 = itemFeedVoteBinding.textView;
                Intrinsics.checkNotNullExpressionValue(textView6, "binding.textView");
                Feed feed7 = this.feed;
                if (feed7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feed");
                }
                String message2 = feed7.getMessage();
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(getContext().getString(2131886718));
                spannableStringBuilder2.setSpan(new ForegroundColorSpan(AppHolder.getAppTheme().getColorAccent()), 0, spannableStringBuilder2.length(), 33);
                Unit unit = Unit.INSTANCE;
                ViewExtendsKt.setBriefMessage(textView6, 90, message2, spannableStringBuilder2);
            }
        }
        TextView textView7 = itemFeedVoteBinding.countView;
        Intrinsics.checkNotNullExpressionValue(textView7, "binding.countView");
        textView7.setText(vote.getTotalVoteNum() + "人投票 · " + vote.getTotalCommentNum() + "个观点");
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        View root = itemFeedVoteBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        Feed feed8 = this.feed;
        if (feed8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        instance.traceFeedStayInList(root, feed8.getFeedTypeName());
    }

    private final void populateRunningPKVote(Feed feed2) {
        setVoteView(getVotePKViewPart().getView());
        getVotePKViewPart().bindToDisplay(feed2);
    }

    private final void setVoteView(View view) {
        if (!Intrinsics.areEqual(((ItemFeedVoteBinding) getBinding()).voteViewContainer.getChildAt(0), view)) {
            ((ItemFeedVoteBinding) getBinding()).voteViewContainer.removeAllViews();
            ((ItemFeedVoteBinding) getBinding()).voteViewContainer.addView(view);
        }
    }

    private final void populateMultiVoteType(Feed feed2) {
        Vote vote = feed2.getVote();
        Intrinsics.checkNotNull(vote);
        Intrinsics.checkNotNullExpressionValue(vote, "data.vote!!");
        setVoteView(getVoteMultiView());
        List<VoteOption> voteOptions = vote.getVoteOptions();
        if (voteOptions.size() > 3) {
            voteOptions = voteOptions.subList(0, 3);
        }
        getVoteMultiView().setAdapter(new FeedVoteViewHolder$populateMultiVoteType$1(this, voteOptions, getContext(), 0, voteOptions));
        getVoteMultiView().notifyDataSetChange();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() != 2131362205) {
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
}
