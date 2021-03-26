package com.coolapk.market.view.feed.vote;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemFeedVoteHeaderBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.Vote;
import com.coolapk.market.model.VoteOption;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.feedv8.FeedArgsFactory;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import com.coolapk.market.widget.LinearAdapterLayout;
import com.coolapk.market.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 J2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001JB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-J\u0010\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u000200H\u0002J\u000e\u00101\u001a\u00020+2\u0006\u00102\u001a\u000203J\u0010\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020\u0003H\u0014J\u0010\u00106\u001a\u00020+2\u0006\u00107\u001a\u000208H\u0016J\u001a\u00109\u001a\u00020\u00022\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0014J\b\u0010>\u001a\u00020+H\u0014J\u0018\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u00152\u0006\u0010A\u001a\u00020\u0010H\u0002J\u0010\u0010B\u001a\u00020+2\u0006\u00105\u001a\u00020\u0003H\u0002J\u0010\u0010C\u001a\u00020+2\u0006\u00105\u001a\u00020\u0003H\u0002J\u0010\u0010D\u001a\u00020+2\u0006\u00105\u001a\u00020\u0003H\u0002J\u0010\u0010E\u001a\u00020+2\u0006\u00105\u001a\u00020\u0003H\u0002J\u0010\u0010F\u001a\u00020+2\u0006\u00105\u001a\u00020\u0003H\u0002J\b\u0010G\u001a\u00020+H\u0002J\u0010\u0010H\u001a\u00020+2\u0006\u0010I\u001a\u000208H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020&8BX\u0002¢\u0006\f\n\u0004\b)\u0010\u001f\u001a\u0004\b'\u0010(¨\u0006K"}, d2 = {"Lcom/coolapk/market/view/feed/vote/FeedVoteHeaderViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemFeedVoteHeaderBinding;", "Lcom/coolapk/market/model/Feed;", "bindingComponent", "Lcom/coolapk/market/binding/FragmentBindingComponent;", "viewModel", "Lcom/coolapk/market/view/feed/vote/FeedVoteViewModel;", "presenter", "Lcom/coolapk/market/view/feed/vote/FeedVotePresenter;", "(Lcom/coolapk/market/binding/FragmentBindingComponent;Lcom/coolapk/market/view/feed/vote/FeedVoteViewModel;Lcom/coolapk/market/view/feed/vote/FeedVotePresenter;)V", "getBindingComponent", "()Lcom/coolapk/market/binding/FragmentBindingComponent;", "currentDescriptionLength", "", "didUserCheckAnonymous", "", "feed", "haveShownAnimation", "multiVoteId", "", "", "getPresenter", "()Lcom/coolapk/market/view/feed/vote/FeedVotePresenter;", "getViewModel", "()Lcom/coolapk/market/view/feed/vote/FeedVoteViewModel;", "voteMultiView", "Lcom/coolapk/market/widget/LinearAdapterLayout;", "getVoteMultiView", "()Lcom/coolapk/market/widget/LinearAdapterLayout;", "voteMultiView$delegate", "Lkotlin/Lazy;", "votePKResultViewPart", "Lcom/coolapk/market/view/feed/vote/VotePKResultDetailViewPart;", "getVotePKResultViewPart", "()Lcom/coolapk/market/view/feed/vote/VotePKResultDetailViewPart;", "votePKResultViewPart$delegate", "votePKViewPart", "Lcom/coolapk/market/view/feed/vote/VoteDetailPKViewPart;", "getVotePKViewPart", "()Lcom/coolapk/market/view/feed/vote/VoteDetailPKViewPart;", "votePKViewPart$delegate", "applyWindowsInset", "", "inset", "Landroid/graphics/Rect;", "generateRemainTimeText", "endTime", "", "handleActionClick", "vote", "Lcom/coolapk/market/model/Vote;", "onBindToContent", "data", "onClick", "v", "Landroid/view/View;", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "onVoteOptionIDCheckEvent", "id", "check", "populateActionButtonStatus", "populateAnonymousStatus", "populateMultiVoteType", "populatePKVoteResult", "populateRunningPKVote", "setDescriptionText", "setVoteView", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedVoteHeaderViewPart.kt */
public final class FeedVoteHeaderViewPart extends BindingViewPart<ItemFeedVoteHeaderBinding, Feed> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558747;
    private final FragmentBindingComponent bindingComponent;
    private int currentDescriptionLength = 75;
    private boolean didUserCheckAnonymous;
    private Feed feed;
    private boolean haveShownAnimation;
    private Set<String> multiVoteId = new LinkedHashSet();
    private final FeedVotePresenter presenter;
    private final FeedVoteViewModel viewModel;
    private final Lazy voteMultiView$delegate = LazyKt.lazy(new FeedVoteHeaderViewPart$voteMultiView$2(this));
    private final Lazy votePKResultViewPart$delegate = LazyKt.lazy(new FeedVoteHeaderViewPart$votePKResultViewPart$2(this));
    private final Lazy votePKViewPart$delegate = LazyKt.lazy(new FeedVoteHeaderViewPart$votePKViewPart$2(this));

    private final LinearAdapterLayout getVoteMultiView() {
        return (LinearAdapterLayout) this.voteMultiView$delegate.getValue();
    }

    private final VotePKResultDetailViewPart getVotePKResultViewPart() {
        return (VotePKResultDetailViewPart) this.votePKResultViewPart$delegate.getValue();
    }

    private final VoteDetailPKViewPart getVotePKViewPart() {
        return (VoteDetailPKViewPart) this.votePKViewPart$delegate.getValue();
    }

    public final FragmentBindingComponent getBindingComponent() {
        return this.bindingComponent;
    }

    public final FeedVoteViewModel getViewModel() {
        return this.viewModel;
    }

    public FeedVoteHeaderViewPart(FragmentBindingComponent fragmentBindingComponent, FeedVoteViewModel feedVoteViewModel, FeedVotePresenter feedVotePresenter) {
        Intrinsics.checkNotNullParameter(fragmentBindingComponent, "bindingComponent");
        Intrinsics.checkNotNullParameter(feedVoteViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(feedVotePresenter, "presenter");
        this.bindingComponent = fragmentBindingComponent;
        this.viewModel = feedVoteViewModel;
        this.presenter = feedVotePresenter;
    }

    public final FeedVotePresenter getPresenter() {
        return this.presenter;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/vote/FeedVoteHeaderViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedVoteHeaderViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemFeedVoteHeaderBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558747, viewGroup, false, this.bindingComponent);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(… false, bindingComponent)");
        return (ItemFeedVoteHeaderBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        ((ItemFeedVoteHeaderBinding) getBinding()).setClick(this);
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(Feed feed2) {
        Intrinsics.checkNotNullParameter(feed2, "data");
        super.onBindToContent((FeedVoteHeaderViewPart) feed2);
        this.feed = feed2;
        Vote vote = feed2.getVote();
        Intrinsics.checkNotNull(vote);
        Intrinsics.checkNotNullExpressionValue(vote, "data.vote!!");
        ((ItemFeedVoteHeaderBinding) getBinding()).setModel(feed2);
        TextView textView = ((ItemFeedVoteHeaderBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText(vote.getMessageTitle());
        LinearLayout linearLayout = ((ItemFeedVoteHeaderBinding) getBinding()).authorView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.authorView");
        LinearLayout linearLayout2 = linearLayout;
        int i = 0;
        if (!(vote.getShowAuthor() == 1)) {
            i = 8;
        }
        linearLayout2.setVisibility(i);
        setDescriptionText();
        int type = vote.getType();
        if (type != 0) {
            if (type == 1) {
                populateMultiVoteType(feed2);
            }
        } else if (this.viewModel.getUserVotedAndNotModifying() || EntityExtendsKt.isFinished(vote)) {
            populatePKVoteResult(feed2);
        } else {
            populateRunningPKVote(feed2);
        }
        populateActionButtonStatus(feed2);
        populateAnonymousStatus(feed2);
        TextView textView2 = ((ItemFeedVoteHeaderBinding) getBinding()).timeView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.timeView");
        textView2.setText((char) 20849 + vote.getTotalVoteNum() + "人参与 " + generateRemainTimeText(vote.getEndTime()));
        ((ItemFeedVoteHeaderBinding) getBinding()).executePendingBindings();
    }

    private final void setDescriptionText() {
        Feed feed2 = this.feed;
        if (feed2 != null) {
            FrameLayout frameLayout = ((ItemFeedVoteHeaderBinding) getBinding()).descriptionViewContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.descriptionViewContainer");
            FrameLayout frameLayout2 = frameLayout;
            String message = feed2.getMessage();
            frameLayout2.setVisibility(message == null || message.length() == 0 ? 8 : 0);
            TextView textView = ((ItemFeedVoteHeaderBinding) getBinding()).descriptionView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.descriptionView");
            int i = this.currentDescriptionLength;
            String message2 = feed2.getMessage();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getContext().getString(2131886718));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(AppHolder.getAppTheme().getColorAccent()), 0, spannableStringBuilder.length(), 33);
            Unit unit = Unit.INSTANCE;
            ViewExtendsKt.setBriefMessage(textView, i, message2, spannableStringBuilder);
        }
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Vote vote;
        Intrinsics.checkNotNullParameter(view, "v");
        Feed feed2 = this.feed;
        if (feed2 != null && (vote = feed2.getVote()) != null) {
            Intrinsics.checkNotNullExpressionValue(vote, "feed.vote ?: return");
            switch (view.getId()) {
                case 2131361982:
                    handleActionClick(vote);
                    return;
                case 2131362059:
                    boolean z = false;
                    boolean z2 = EntityExtendsKt.isFinished(vote) || this.viewModel.getUserVotedAndNotModifying();
                    boolean z3 = !EntityExtendsKt.isAllowAnonymous(vote);
                    boolean z4 = z2 || z3;
                    if (z3 && !z2) {
                        z = true;
                    }
                    if (z) {
                        Toast.show$default(getContext(), "该投票不允许匿名", 0, false, 12, null);
                    }
                    if (!z4) {
                        this.didUserCheckAnonymous = !this.didUserCheckAnonymous;
                        populateAnonymousStatus(feed2);
                        return;
                    }
                    return;
                case 2131362384:
                    int i = Integer.MAX_VALUE;
                    if (this.currentDescriptionLength == Integer.MAX_VALUE) {
                        i = 75;
                    }
                    this.currentDescriptionLength = i;
                    setDescriptionText();
                    return;
                case 2131363579:
                    ActionManagerCompat actionManagerCompat = ActionManagerCompat.INSTANCE;
                    Context context = getContext();
                    String id = vote.getId();
                    Intrinsics.checkNotNullExpressionValue(id, "vote.id");
                    actionManagerCompat.startVoteUserListActivity(context, id, "");
                    return;
                case 2131363900:
                    ActionManager.startUserSpaceActivity(getView(), feed2.getUid(), feed2.getUserAvatar());
                    return;
                default:
                    super.onClick(view);
                    return;
            }
        }
    }

    public final void handleActionClick(Vote vote) {
        Intrinsics.checkNotNullParameter(vote, "vote");
        if (!ActionManager.checkLogin(getContext()).booleanValue() || this.viewModel.getUserCommented() || EntityExtendsKt.isFinished(vote)) {
            return;
        }
        if (this.viewModel.getUserVotedAndNotModifying()) {
            FeedMultiPart build = FeedArgsFactory.multiPartForVoteComment(vote).isAnonymous(EntityExtendsKt.isUserAnonymous(vote)).build();
            ActionManager.startSubmitFeedV8Activity(UiUtils.getActivityNullable(getContext()), FeedArgsFactory.uiConfigForVoteComment(getContext(), vote).build(), build);
        } else if (!(!this.multiVoteId.isEmpty())) {
        } else {
            if (this.multiVoteId.size() < vote.getMinSelectNum()) {
                Context context = getContext();
                Toast.show$default(context, "至少需要选择" + vote.getMinSelectNum() + (char) 39033, 0, false, 12, null);
            } else if (this.multiVoteId.size() > vote.getMaxSelectNum()) {
                Context context2 = getContext();
                Toast.show$default(context2, "最多只能选择" + vote.getMinSelectNum() + (char) 39033, 0, false, 12, null);
            } else {
                FeedVotePresenter feedVotePresenter = this.presenter;
                String id = vote.getId();
                Intrinsics.checkNotNullExpressionValue(id, "vote.id");
                feedVotePresenter.voteOptions(id, CollectionsKt.toList(this.multiVoteId), this.didUserCheckAnonymous);
            }
        }
    }

    private final void populateRunningPKVote(Feed feed2) {
        LinearLayout linearLayout = ((ItemFeedVoteHeaderBinding) getBinding()).voteTitleContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.voteTitleContainer");
        linearLayout.setVisibility(8);
        setVoteView(getVotePKViewPart().getView());
        getVotePKViewPart().bindVoteDetail(feed2, new FeedVoteHeaderViewPart$populateRunningPKVote$1(this, feed2));
    }

    private final void populatePKVoteResult(Feed feed2) {
        LinearLayout linearLayout = ((ItemFeedVoteHeaderBinding) getBinding()).voteTitleContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.voteTitleContainer");
        linearLayout.setVisibility(8);
        setVoteView(getVotePKResultViewPart().getView());
        getVotePKResultViewPart().bindResult(feed2);
    }

    private final void setVoteView(View view) {
        if (!Intrinsics.areEqual(((ItemFeedVoteHeaderBinding) getBinding()).voteViewContainer.getChildAt(0), view)) {
            ((ItemFeedVoteHeaderBinding) getBinding()).voteViewContainer.removeAllViews();
            ((ItemFeedVoteHeaderBinding) getBinding()).voteViewContainer.addView(view);
        }
    }

    private final void populateMultiVoteType(Feed feed2) {
        Vote vote = feed2.getVote();
        Intrinsics.checkNotNull(vote);
        Intrinsics.checkNotNullExpressionValue(vote, "data.vote!!");
        LinearLayout linearLayout = ((ItemFeedVoteHeaderBinding) getBinding()).voteTitleContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.voteTitleContainer");
        linearLayout.setVisibility(0);
        TextView textView = ((ItemFeedVoteHeaderBinding) getBinding()).voteTitleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.voteTitleView");
        textView.setText("投票选项");
        TextView textView2 = ((ItemFeedVoteHeaderBinding) getBinding()).voteSubtitleView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.voteSubtitleView");
        textView2.setText("最多选" + vote.getMaxSelectNum() + (char) 39033);
        setVoteView(getVoteMultiView());
        List<String> userVoteIds = EntityExtendsKt.getUserVoteIds(vote);
        boolean userVotedAndNotModifying = this.viewModel.getUserVotedAndNotModifying();
        boolean isFinished = EntityExtendsKt.isFinished(vote);
        List<VoteOption> voteOptions = vote.getVoteOptions();
        Intrinsics.checkNotNullExpressionValue(voteOptions, "vote.voteOptions");
        int i = 0;
        for (T t : voteOptions) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            i += t.getTotalSelectNum();
        }
        List<VoteOption> voteOptions2 = vote.getVoteOptions();
        Intrinsics.checkNotNullExpressionValue(voteOptions2, "vote.voteOptions");
        List mutableList = CollectionsKt.toMutableList((Collection) voteOptions2);
        if ((userVotedAndNotModifying || isFinished) && mutableList.size() > 1) {
            CollectionsKt.sortWith(mutableList, new FeedVoteHeaderViewPart$populateMultiVoteType$$inlined$sortByDescending$1());
        }
        getVoteMultiView().setAdapter(new FeedVoteHeaderViewPart$populateMultiVoteType$2(this, userVotedAndNotModifying, isFinished, userVoteIds, i, vote, mutableList, getContext(), 0, mutableList));
        this.haveShownAnimation = userVotedAndNotModifying || isFinished;
        getVoteMultiView().notifyDataSetChange();
    }

    /* access modifiers changed from: private */
    public final boolean onVoteOptionIDCheckEvent(String str, boolean z) {
        Feed feed2 = this.feed;
        if (feed2 == null) {
            return false;
        }
        if (z) {
            Vote vote = feed2.getVote();
            Intrinsics.checkNotNull(vote);
            Intrinsics.checkNotNullExpressionValue(vote, "feed.vote!!");
            int maxSelectNum = vote.getMaxSelectNum();
            if (this.multiVoteId.size() < maxSelectNum) {
                this.multiVoteId.add(str);
            } else if (maxSelectNum == 1) {
                this.multiVoteId.clear();
                this.multiVoteId.add(str);
                getVoteMultiView().notifyDataSetChange();
                return false;
            } else {
                Context context = getContext();
                Toast.show$default(context, "最多只能选择" + maxSelectNum + (char) 39033, 0, false, 12, null);
                return false;
            }
        } else {
            this.multiVoteId.remove(str);
        }
        populateActionButtonStatus(feed2);
        return true;
    }

    private final void populateAnonymousStatus(Feed feed2) {
        Vote vote = feed2.getVote();
        Intrinsics.checkNotNull(vote);
        Intrinsics.checkNotNullExpressionValue(vote, "data.vote!!");
        boolean userVotedAndNotModifying = this.viewModel.getUserVotedAndNotModifying();
        boolean isUserAnonymous = EntityExtendsKt.isUserAnonymous(vote);
        boolean z = EntityExtendsKt.isAllowAnonymous(vote) && !userVotedAndNotModifying && !EntityExtendsKt.isFinished(vote);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        int textColorTertiary = AppHolder.getAppTheme().getTextColorTertiary();
        int textColorSecondary = AppHolder.getAppTheme().getTextColorSecondary();
        int colorAccent = AppHolder.getAppTheme().getColorAccent();
        Drawable drawable = ResourceUtils.getDrawable(getContext(), 2131231533);
        if (z) {
            if (this.didUserCheckAnonymous) {
                ImageView imageView = ((ItemFeedVoteHeaderBinding) getBinding()).anonymousCheckView;
                Intrinsics.checkNotNullExpressionValue(drawable, "checkDrawable");
                imageView.setImageDrawable(ViewExtendsKt.tintColor(drawable, colorAccent));
            } else {
                gradientDrawable.setStroke(NumberExtendsKt.getDp((Number) 1), textColorSecondary);
                ((ItemFeedVoteHeaderBinding) getBinding()).anonymousCheckView.setImageDrawable(gradientDrawable);
            }
            ((ItemFeedVoteHeaderBinding) getBinding()).anonymousTextView.setTextColor(textColorSecondary);
            return;
        }
        if (!userVotedAndNotModifying || !isUserAnonymous) {
            gradientDrawable.setStroke(NumberExtendsKt.getDp((Number) 1), textColorTertiary);
            ((ItemFeedVoteHeaderBinding) getBinding()).anonymousCheckView.setImageDrawable(gradientDrawable);
        } else {
            ImageView imageView2 = ((ItemFeedVoteHeaderBinding) getBinding()).anonymousCheckView;
            Intrinsics.checkNotNullExpressionValue(drawable, "checkDrawable");
            imageView2.setImageDrawable(ViewExtendsKt.tintColor(drawable, textColorTertiary));
        }
        ((ItemFeedVoteHeaderBinding) getBinding()).anonymousTextView.setTextColor(textColorTertiary);
    }

    private final void populateActionButtonStatus(Feed feed2) {
        Vote vote = feed2.getVote();
        Intrinsics.checkNotNull(vote);
        Intrinsics.checkNotNullExpressionValue(vote, "data.vote!!");
        int adjustAlpha = ColorUtils.adjustAlpha(ResourceUtils.getColorInt(getContext(), 2131099898), 0.2f);
        int colorAccent = AppHolder.getAppTheme().getColorAccent();
        int textColorSecondary = AppHolder.getAppTheme().getTextColorSecondary();
        if (vote.getType() == 0) {
            if (!(EntityExtendsKt.isFinished(vote) || this.viewModel.getUserVotedAndNotModifying())) {
                TextView textView = ((ItemFeedVoteHeaderBinding) getBinding()).actionView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.actionView");
                textView.setVisibility(8);
                return;
            }
        }
        boolean z = !this.multiVoteId.isEmpty();
        TextView textView2 = ((ItemFeedVoteHeaderBinding) getBinding()).actionView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.actionView");
        textView2.setVisibility(0);
        if (EntityExtendsKt.isFinished(vote)) {
            TextView textView3 = ((ItemFeedVoteHeaderBinding) getBinding()).actionView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.actionView");
            textView3.setText("投票已结束");
            TextView textView4 = ((ItemFeedVoteHeaderBinding) getBinding()).actionView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.actionView");
            textView4.setClickable(false);
            ((ItemFeedVoteHeaderBinding) getBinding()).actionView.setBackgroundColor(adjustAlpha);
            ((ItemFeedVoteHeaderBinding) getBinding()).actionView.setTextColor(textColorSecondary);
        } else if (this.viewModel.getUserCommented()) {
            TextView textView5 = ((ItemFeedVoteHeaderBinding) getBinding()).actionView;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.actionView");
            textView5.setText("感谢你的参与");
            TextView textView6 = ((ItemFeedVoteHeaderBinding) getBinding()).actionView;
            Intrinsics.checkNotNullExpressionValue(textView6, "binding.actionView");
            textView6.setClickable(false);
            ((ItemFeedVoteHeaderBinding) getBinding()).actionView.setBackgroundColor(adjustAlpha);
            ((ItemFeedVoteHeaderBinding) getBinding()).actionView.setTextColor(textColorSecondary);
        } else if (this.viewModel.getUserVotedAndNotModifying()) {
            TextView textView7 = ((ItemFeedVoteHeaderBinding) getBinding()).actionView;
            Intrinsics.checkNotNullExpressionValue(textView7, "binding.actionView");
            textView7.setText("说说你的观点");
            TextView textView8 = ((ItemFeedVoteHeaderBinding) getBinding()).actionView;
            Intrinsics.checkNotNullExpressionValue(textView8, "binding.actionView");
            textView8.setClickable(true);
            ((ItemFeedVoteHeaderBinding) getBinding()).actionView.setBackgroundColor(colorAccent);
            ((ItemFeedVoteHeaderBinding) getBinding()).actionView.setTextColor(-1);
        } else {
            TextView textView9 = ((ItemFeedVoteHeaderBinding) getBinding()).actionView;
            Intrinsics.checkNotNullExpressionValue(textView9, "binding.actionView");
            textView9.setText("投票");
            TextView textView10 = ((ItemFeedVoteHeaderBinding) getBinding()).actionView;
            Intrinsics.checkNotNullExpressionValue(textView10, "binding.actionView");
            textView10.setClickable(z);
            TextView textView11 = ((ItemFeedVoteHeaderBinding) getBinding()).actionView;
            if (z) {
                adjustAlpha = colorAccent;
            }
            textView11.setBackgroundColor(adjustAlpha);
            TextView textView12 = ((ItemFeedVoteHeaderBinding) getBinding()).actionView;
            if (z) {
                textColorSecondary = -1;
            }
            textView12.setTextColor(textColorSecondary);
        }
    }

    public final void applyWindowsInset(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "inset");
        Space space = ((ItemFeedVoteHeaderBinding) getBinding()).appBarHolder;
        Intrinsics.checkNotNullExpressionValue(space, "binding.appBarHolder");
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(space);
        if (marginParams != null) {
            marginParams.height = UiUtils.getActionBarSize(getContext()) + rect.top;
        }
        ((ItemFeedVoteHeaderBinding) getBinding()).appBarHolder.requestLayout();
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
