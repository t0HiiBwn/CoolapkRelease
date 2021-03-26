package com.coolapk.market.view.feed.vote;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.ItemFeedVoteCommentViewPartBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.Vote;
import com.coolapk.market.model.VoteOption;
import com.coolapk.market.util.ShapeUtils;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 52\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00015B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0003H\u0014J\u0010\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020(H\u0016J\u001a\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\b\u0010.\u001a\u00020$H\u0014J\u0015\u0010/\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0003H\u0010¢\u0006\u0002\b0J\u0015\u00101\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0003H\u0000¢\u0006\u0002\b2J\u0010\u00103\u001a\u00020$2\u0006\u00104\u001a\u00020(H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158@X\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001a\u001a\u00020\u001b8@X\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001c\u0010\u001d¨\u00066"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VoteCommentDetailViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemFeedVoteCommentViewPartBinding;", "Lcom/coolapk/market/model/Feed;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "getComponent", "()Landroidx/databinding/DataBindingComponent;", "feed", "getFeed$presentation_coolapkAppRelease", "()Lcom/coolapk/market/model/Feed;", "setFeed$presentation_coolapkAppRelease", "(Lcom/coolapk/market/model/Feed;)V", "haveShownAnimation", "", "getHaveShownAnimation$presentation_coolapkAppRelease", "()Z", "setHaveShownAnimation$presentation_coolapkAppRelease", "(Z)V", "voteMultiView", "Lcom/coolapk/market/widget/LinearAdapterLayout;", "getVoteMultiView$presentation_coolapkAppRelease", "()Lcom/coolapk/market/widget/LinearAdapterLayout;", "voteMultiView$delegate", "Lkotlin/Lazy;", "votePKViewPart", "Lcom/coolapk/market/view/feed/vote/VotePKViewPart;", "getVotePKViewPart$presentation_coolapkAppRelease", "()Lcom/coolapk/market/view/feed/vote/VotePKViewPart;", "votePKViewPart$delegate", "generateRemainTimeText", "", "endTime", "", "onBindToContent", "", "data", "onClick", "v", "Landroid/view/View;", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "populateMultiVote", "populateMultiVote$presentation_coolapkAppRelease", "populatePKVote", "populatePKVote$presentation_coolapkAppRelease", "setVoteView", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VoteCommentDetailViewPart.kt */
public class VoteCommentDetailViewPart extends BindingViewPart<ItemFeedVoteCommentViewPartBinding, Feed> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558746;
    private final DataBindingComponent component;
    private Feed feed;
    private boolean haveShownAnimation;
    private final Lazy voteMultiView$delegate = LazyKt.lazy(new VoteCommentDetailViewPart$voteMultiView$2(this));
    private final Lazy votePKViewPart$delegate = LazyKt.lazy(new VoteCommentDetailViewPart$votePKViewPart$2(this));

    public final LinearAdapterLayout getVoteMultiView$presentation_coolapkAppRelease() {
        return (LinearAdapterLayout) this.voteMultiView$delegate.getValue();
    }

    public final VotePKViewPart getVotePKViewPart$presentation_coolapkAppRelease() {
        return (VotePKViewPart) this.votePKViewPart$delegate.getValue();
    }

    public VoteCommentDetailViewPart(DataBindingComponent dataBindingComponent) {
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.component = dataBindingComponent;
    }

    public final DataBindingComponent getComponent() {
        return this.component;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VoteCommentDetailViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VoteCommentDetailViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final Feed getFeed$presentation_coolapkAppRelease() {
        return this.feed;
    }

    public final void setFeed$presentation_coolapkAppRelease(Feed feed2) {
        this.feed = feed2;
    }

    public final boolean getHaveShownAnimation$presentation_coolapkAppRelease() {
        return this.haveShownAnimation;
    }

    public final void setHaveShownAnimation$presentation_coolapkAppRelease(boolean z) {
        this.haveShownAnimation = z;
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
        VoteCommentDetailViewPart voteCommentDetailViewPart = this;
        ((ItemFeedVoteCommentViewPartBinding) getBinding()).setClick(voteCommentDetailViewPart);
        ((ItemFeedVoteCommentViewPartBinding) getBinding()).rootView.setOnClickListener(voteCommentDetailViewPart);
        LinearLayout linearLayout = ((ItemFeedVoteCommentViewPartBinding) getBinding()).rootView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.rootView");
        ViewExtendsKt.setCompatForeground(linearLayout, ShapeUtils.createSelectableItemBackground(getContext()));
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(Feed feed2) {
        Intrinsics.checkNotNullParameter(feed2, "data");
        super.onBindToContent((VoteCommentDetailViewPart) feed2);
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
            populatePKVote$presentation_coolapkAppRelease(feed2);
        } else if (type == 1) {
            populateMultiVote$presentation_coolapkAppRelease(feed2);
        }
    }

    private final void setVoteView(View view) {
        if (!Intrinsics.areEqual(((ItemFeedVoteCommentViewPartBinding) getBinding()).voteContainer.getChildAt(0), view)) {
            ((ItemFeedVoteCommentViewPartBinding) getBinding()).voteContainer.removeAllViews();
            ((ItemFeedVoteCommentViewPartBinding) getBinding()).voteContainer.addView(view);
        }
    }

    public final void populatePKVote$presentation_coolapkAppRelease(Feed feed2) {
        Intrinsics.checkNotNullParameter(feed2, "data");
        TextView textView = ((ItemFeedVoteCommentViewPartBinding) getBinding()).subTitleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.subTitleView");
        textView.setVisibility(8);
        setVoteView(getVotePKViewPart$presentation_coolapkAppRelease().getView());
        getVotePKViewPart$presentation_coolapkAppRelease().bindUserVoteComment(feed2);
    }

    public void populateMultiVote$presentation_coolapkAppRelease(Feed feed2) {
        Intrinsics.checkNotNullParameter(feed2, "data");
        setVoteView(getVoteMultiView$presentation_coolapkAppRelease());
        Vote vote = feed2.getVote();
        Intrinsics.checkNotNull(vote);
        Intrinsics.checkNotNullExpressionValue(vote, "data.vote!!");
        List<String> feedUserVoteIds = EntityExtendsKt.getFeedUserVoteIds(feed2);
        List<VoteOption> voteOptions = vote.getVoteOptions();
        Intrinsics.checkNotNullExpressionValue(voteOptions, "vote.voteOptions");
        int i = 0;
        for (T t : voteOptions) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            i += t.getTotalSelectNum();
        }
        TextView textView = ((ItemFeedVoteCommentViewPartBinding) getBinding()).subTitleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.subTitleView");
        textView.setVisibility(0);
        String uid = feed2.getUid();
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        String str = Intrinsics.areEqual(uid, loginSession.getUid()) ? "我" : "他";
        TextView textView2 = ((ItemFeedVoteCommentViewPartBinding) getBinding()).subTitleView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.subTitleView");
        textView2.setText(str + "选了" + feedUserVoteIds.size() + (char) 39033);
        getVoteMultiView$presentation_coolapkAppRelease().setAdapter(new VoteCommentDetailViewPart$populateMultiVote$1(this, vote, feed2, i, feedUserVoteIds, getContext(), 0, feedUserVoteIds));
        this.haveShownAnimation = true;
        getVoteMultiView$presentation_coolapkAppRelease().notifyDataSetChange();
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        Feed feed2 = this.feed;
        if (feed2 != null) {
            int id = view.getId();
            if (id == 2131363274 || id == 2131363607) {
                Context context = getContext();
                Vote vote = feed2.getVote();
                Intrinsics.checkNotNull(vote);
                Intrinsics.checkNotNullExpressionValue(vote, "feed.vote!!");
                ActionManager.startFeedDetailActivity(context, vote.getId(), (String) null);
                return;
            }
            super.onClick(view);
        }
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
