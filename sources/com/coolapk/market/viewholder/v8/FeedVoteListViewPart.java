package com.coolapk.market.viewholder.v8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.ItemFeedVoteCommentViewPartBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.Vote;
import com.coolapk.market.model.VoteOption;
import com.coolapk.market.view.feed.vote.VotePKViewPart;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import com.coolapk.market.widget.LinearAdapterLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001)B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003H\u0014J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020\u001aH\u0014J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001eH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013¨\u0006*"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedVoteListViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemFeedVoteCommentViewPartBinding;", "Lcom/coolapk/market/model/Feed;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "getComponent", "()Landroidx/databinding/DataBindingComponent;", "feed", "voteMultiView", "Lcom/coolapk/market/widget/LinearAdapterLayout;", "getVoteMultiView", "()Lcom/coolapk/market/widget/LinearAdapterLayout;", "voteMultiView$delegate", "Lkotlin/Lazy;", "votePKViewPart", "Lcom/coolapk/market/view/feed/vote/VotePKViewPart;", "getVotePKViewPart", "()Lcom/coolapk/market/view/feed/vote/VotePKViewPart;", "votePKViewPart$delegate", "generateRemainTimeText", "", "endTime", "", "onBindToContent", "", "data", "onClick", "v", "Landroid/view/View;", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "populateMultiVote", "populatePKVote", "setVoteView", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedVoteListViewPart.kt */
public final class FeedVoteListViewPart extends BindingViewPart<ItemFeedVoteCommentViewPartBinding, Feed> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558746;
    private final DataBindingComponent component;
    private Feed feed;
    private final Lazy voteMultiView$delegate = LazyKt.lazy(new FeedVoteListViewPart$voteMultiView$2(this));
    private final Lazy votePKViewPart$delegate = LazyKt.lazy(new FeedVoteListViewPart$votePKViewPart$2(this));

    private final LinearAdapterLayout getVoteMultiView() {
        return (LinearAdapterLayout) this.voteMultiView$delegate.getValue();
    }

    private final VotePKViewPart getVotePKViewPart() {
        return (VotePKViewPart) this.votePKViewPart$delegate.getValue();
    }

    public FeedVoteListViewPart(DataBindingComponent dataBindingComponent) {
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.component = dataBindingComponent;
    }

    public final DataBindingComponent getComponent() {
        return this.component;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedVoteListViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedVoteListViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemFeedVoteCommentViewPartBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558746, viewGroup, false, this.component);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…wGroup, false, component)");
        return (ItemFeedVoteCommentViewPartBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        ((ItemFeedVoteCommentViewPartBinding) getBinding()).setClick(this);
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(Feed feed2) {
        Intrinsics.checkNotNullParameter(feed2, "data");
        super.onBindToContent((FeedVoteListViewPart) feed2);
        this.feed = feed2;
        ((ItemFeedVoteCommentViewPartBinding) getBinding()).executePendingBindings();
        Vote vote = feed2.getVote();
        Intrinsics.checkNotNull(vote);
        Intrinsics.checkNotNullExpressionValue(vote, "data.vote!!");
        TextView textView = ((ItemFeedVoteCommentViewPartBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText(vote.getMessageTitle());
        TextView textView2 = ((ItemFeedVoteCommentViewPartBinding) getBinding()).remainTimeView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.remainTimeView");
        textView2.setText(generateRemainTimeText(vote.getEndTime()));
        int type = vote.getType();
        if (type == 0) {
            populatePKVote(feed2);
        } else if (type == 1) {
            populateMultiVote(feed2);
        }
    }

    private final void setVoteView(View view) {
        if (!Intrinsics.areEqual(((ItemFeedVoteCommentViewPartBinding) getBinding()).voteContainer.getChildAt(0), view)) {
            ((ItemFeedVoteCommentViewPartBinding) getBinding()).voteContainer.removeAllViews();
            ((ItemFeedVoteCommentViewPartBinding) getBinding()).voteContainer.addView(view);
        }
    }

    private final void populatePKVote(Feed feed2) {
        TextView textView = ((ItemFeedVoteCommentViewPartBinding) getBinding()).subTitleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.subTitleView");
        textView.setVisibility(8);
        setVoteView(getVotePKViewPart().getView());
        getVotePKViewPart().bindToDisplay(feed2);
    }

    private final void populateMultiVote(Feed feed2) {
        setVoteView(getVoteMultiView());
        Vote vote = feed2.getVote();
        Intrinsics.checkNotNull(vote);
        Intrinsics.checkNotNullExpressionValue(vote, "data.vote!!");
        TextView textView = ((ItemFeedVoteCommentViewPartBinding) getBinding()).subTitleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.subTitleView");
        textView.setVisibility(0);
        TextView textView2 = ((ItemFeedVoteCommentViewPartBinding) getBinding()).subTitleView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.subTitleView");
        textView2.setText((char) 20849 + vote.getVoteOptions().size() + "个选项");
        List<VoteOption> voteOptions = vote.getVoteOptions();
        if (voteOptions.size() > 3) {
            voteOptions = voteOptions.subList(0, 3);
        }
        getVoteMultiView().setAdapter(new FeedVoteListViewPart$populateMultiVote$1(this, voteOptions, getContext(), 0, voteOptions));
        getVoteMultiView().notifyDataSetChange();
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        Feed feed2 = this.feed;
        if (feed2 == null) {
            return;
        }
        if (view.getId() != 2131363607) {
            super.onClick(view);
            return;
        }
        Context context = getContext();
        Vote vote = feed2.getVote();
        Intrinsics.checkNotNull(vote);
        Intrinsics.checkNotNullExpressionValue(vote, "feed.vote!!");
        ActionManager.startFeedDetailActivity(context, vote.getId(), (String) null);
    }

    private final String generateRemainTimeText(long j) {
        long j2 = (long) 1000;
        long currentTimeMillis = System.currentTimeMillis() / j2;
        if (currentTimeMillis < j) {
            long j3 = j - currentTimeMillis;
            long j4 = (long) 86400;
            if (j3 > j4) {
                return "剩余" + (j3 / j4) + (char) 22825;
            }
            long j5 = (long) 3600;
            if (j3 > j5) {
                return "剩余" + (j3 / j5) + "小时";
            }
            return "剩余" + (j3 / ((long) 60)) + "分钟";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return simpleDateFormat.format(new Date(j * j2)) + "已截止";
    }
}
