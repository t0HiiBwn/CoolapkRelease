package com.coolapk.market.view.video;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemFeedVideoDetailViewPartBinding;
import com.coolapk.market.event.FeedFavoriteEvent;
import com.coolapk.market.event.FeedLikeEvent;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.EventBusExtendsKt;
import com.coolapk.market.extend.ExtraExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.LikeResult;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.feed.reply.FeedDetailPresenter;
import com.coolapk.market.view.feed.reply.FeedDetailView;
import com.coolapk.market.view.video.VideoDetailReplyListFragment;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.UserAvatarView;
import com.coolapk.market.widget.ViewBounds;
import com.coolapk.market.widget.video.PlayerArg;
import com.coolapk.market.widget.video.VideoModel;
import com.coolapk.market.widget.video.VideoPlayerBridge;
import com.coolapk.market.widget.video.cover.BaseControlCover;
import com.kk.taurus.playerbase.assist.RelationAssist;
import com.kk.taurus.playerbase.receiver.IReceiverGroup;
import com.kk.taurus.playerbase.render.AspectRatio;
import java.util.Objects;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

/* compiled from: FeedVideoDetailViewPart.kt */
public final class FeedVideoDetailViewPart extends BaseVideoDetailViewPart<ItemFeedVideoDetailViewPartBinding, VideoModel> implements FeedDetailView {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558734;
    private final FeedVideoDetailViewPart$callback$1 callback = new FeedVideoDetailViewPart$callback$1(this);
    private DetailControlCover detailControlCover;
    private FeedDetailPresenter feedPresenter;
    private boolean hasEnterCommentView;
    private boolean isExitingCommentView;
    private Rect lastWindowsRect;
    private ValueAnimator viewAnimator;

    @Override // com.coolapk.market.view.feed.reply.FeedDetailView
    public void onFollowAuthorResult(boolean z, Throwable th) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedVideoDetailViewPart(Activity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public static final /* synthetic */ DetailControlCover access$getDetailControlCover$p(FeedVideoDetailViewPart feedVideoDetailViewPart) {
        DetailControlCover detailControlCover2 = feedVideoDetailViewPart.detailControlCover;
        if (detailControlCover2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailControlCover");
        }
        return detailControlCover2;
    }

    /* compiled from: FeedVideoDetailViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemFeedVideoDetailViewPartBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558734, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…OUT_ID, viewGroup, false)");
        return (ItemFeedVideoDetailViewPartBinding) inflate;
    }

    @Override // com.coolapk.market.view.video.BaseVideoDetailViewPart, com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        FeedVideoDetailViewPart feedVideoDetailViewPart = this;
        ((ItemFeedVideoDetailViewPartBinding) getBinding()).setClick(feedVideoDetailViewPart);
        LinearLayout linearLayout = ((ItemFeedVideoDetailViewPartBinding) getBinding()).commentView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.commentView");
        ViewUtil.clickListener(linearLayout, feedVideoDetailViewPart);
        LinearLayout linearLayout2 = ((ItemFeedVideoDetailViewPartBinding) getBinding()).favoriteView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.favoriteView");
        ViewUtil.clickListener(linearLayout2, feedVideoDetailViewPart);
        LinearLayout linearLayout3 = ((ItemFeedVideoDetailViewPartBinding) getBinding()).shareView;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.shareView");
        ViewUtil.clickListener(linearLayout3, feedVideoDetailViewPart);
        LinearLayout linearLayout4 = ((ItemFeedVideoDetailViewPartBinding) getBinding()).likeView;
        Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.likeView");
        ViewUtil.clickListener(linearLayout4, feedVideoDetailViewPart);
        TextView textView = ((ItemFeedVideoDetailViewPartBinding) getBinding()).textView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
        ViewUtil.clickListener(textView, feedVideoDetailViewPart);
        RelativeLayout relativeLayout = ((ItemFeedVideoDetailViewPartBinding) getBinding()).feedContentView;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.feedContentView");
        ViewUtil.clickListener(relativeLayout, feedVideoDetailViewPart);
        ((ItemFeedVideoDetailViewPartBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.view.video.BaseVideoDetailViewPart
    public void attachPlayerBridge$presentation_coolapkAppRelease() {
        super.attachPlayerBridge$presentation_coolapkAppRelease();
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeRegister(eventBus, this);
    }

    @Override // com.coolapk.market.view.video.BaseVideoDetailViewPart
    public void detachPlayerBridge$presentation_coolapkAppRelease(VideoPlayerBridge videoPlayerBridge) {
        super.detachPlayerBridge$presentation_coolapkAppRelease(videoPlayerBridge);
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeUnregister(eventBus, this);
    }

    @Override // com.coolapk.market.view.video.BaseVideoDetailViewPart
    public void applyWindowsInset(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        super.applyWindowsInset(rect);
        ((ItemFeedVideoDetailViewPartBinding) getBinding()).topContainer.setPadding(0, rect.top - NumberExtendsKt.getDp((Number) 4), rect.right, 0);
        ((ItemFeedVideoDetailViewPartBinding) getBinding()).bottomContainer.setPadding(0, 0, rect.right, rect.bottom);
        this.lastWindowsRect = rect;
    }

    public void onBindToContent(VideoModel videoModel) {
        Intrinsics.checkNotNullParameter(videoModel, "data");
        super.onBindToContent((FeedVideoDetailViewPart) videoModel);
        setData$presentation_coolapkAppRelease(videoModel);
        Entity relatedEntity = videoModel.getRelatedEntity();
        Objects.requireNonNull(relatedEntity, "null cannot be cast to non-null type com.coolapk.market.model.Feed");
        this.feedPresenter = new FeedDetailPresenter((Feed) relatedEntity, this);
        setFeedContent();
        setFeedContentVisible();
    }

    @Override // com.coolapk.market.view.video.BaseVideoDetailViewPart
    public boolean handleBackPress() {
        if (!this.hasEnterCommentView) {
            return super.handleBackPress();
        }
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(getActivity()).getSupportFragmentManager();
        FrameLayout frameLayout = ((ItemFeedVideoDetailViewPartBinding) getBinding()).commentContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.commentContainer");
        Fragment findFragmentById = supportFragmentManager.findFragmentById(frameLayout.getId());
        if (findFragmentById instanceof VideoReplyDetailHeaderFragment) {
            ((VideoReplyDetailHeaderFragment) findFragmentById).requestExitCommentView();
            return true;
        }
        requestExitCommentView();
        return true;
    }

    @Override // com.coolapk.market.view.video.BaseVideoDetailViewPart
    public void handleConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        super.handleConfigurationChanged(configuration);
        setFeedContentVisible();
    }

    private final void setFeedContent() {
        FeedDetailPresenter feedDetailPresenter = this.feedPresenter;
        if (feedDetailPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
        }
        Feed feed = feedDetailPresenter.getFeed();
        UserAction userAction = feed.getUserAction();
        ((ItemFeedVideoDetailViewPartBinding) getBinding()).likeImageView.setImageResource((userAction == null || userAction.getLike() != 1) ? 2131689494 : 2131689495);
        ((ItemFeedVideoDetailViewPartBinding) getBinding()).favoriteImageView.setImageResource((userAction == null || userAction.getFavorite() != 1) ? 2131689477 : 2131689478);
        TextView textView = ((ItemFeedVideoDetailViewPartBinding) getBinding()).textView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
        int i = -1;
        textView.setText(LinkTextUtils.convert(feed.getMessage(), -1, null).toString());
        TextView textView2 = ((ItemFeedVideoDetailViewPartBinding) getBinding()).likeText;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.likeText");
        textView2.setText(feed.getLikeNum() > 0 ? String.valueOf(feed.getLikeNum()) : getActivity().getString(2131886790));
        TextView textView3 = ((ItemFeedVideoDetailViewPartBinding) getBinding()).commentText;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.commentText");
        textView3.setText(feed.getReplyNum() > 0 ? String.valueOf(feed.getReplyNum()) : getActivity().getString(2131886791));
        TextView textView4 = ((ItemFeedVideoDetailViewPartBinding) getBinding()).favoriteTextView;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.favoriteTextView");
        textView4.setText(feed.getFavoriteNum() > 0 ? String.valueOf(feed.getFavoriteNum()) : getActivity().getString(2131886786));
        TextView textView5 = ((ItemFeedVideoDetailViewPartBinding) getBinding()).shareText;
        Intrinsics.checkNotNullExpressionValue(textView5, "binding.shareText");
        textView5.setText(feed.getShareNum() > 0 ? String.valueOf(feed.getShareNum()) : getActivity().getString(2131886793));
        ((ItemFeedVideoDetailViewPartBinding) getBinding()).likeImageView.setColorFilter((userAction == null || userAction.getLike() != 1) ? -1 : AppHolder.getAppTheme().getColorAccent());
        ((ItemFeedVideoDetailViewPartBinding) getBinding()).likeText.setTextColor((userAction == null || userAction.getLike() != 1) ? -1 : AppHolder.getAppTheme().getColorAccent());
        ((ItemFeedVideoDetailViewPartBinding) getBinding()).favoriteTextView.setTextColor((userAction == null || userAction.getFavorite() != 1) ? -1 : AppHolder.getAppTheme().getColorAccent());
        ImageView imageView = ((ItemFeedVideoDetailViewPartBinding) getBinding()).favoriteImageView;
        if (userAction != null && userAction.getFavorite() == 1) {
            i = AppHolder.getAppTheme().getColorAccent();
        }
        imageView.setColorFilter(i);
        TextView textView6 = ((ItemFeedVideoDetailViewPartBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView6, "binding.titleView");
        textView6.setVisibility(8);
        RelativeLayout relativeLayout = ((ItemFeedVideoDetailViewPartBinding) getBinding()).feedContentView;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.feedContentView");
        relativeLayout.setVisibility(0);
        TextView textView7 = ((ItemFeedVideoDetailViewPartBinding) getBinding()).userNameView;
        Intrinsics.checkNotNullExpressionValue(textView7, "binding.userNameView");
        textView7.setText(feed.getUserName());
        TextView textView8 = ((ItemFeedVideoDetailViewPartBinding) getBinding()).feedTimeView;
        Intrinsics.checkNotNullExpressionValue(textView8, "binding.feedTimeView");
        textView8.setText(DateUtils.getTimeDescription(getActivity(), feed.getDateline()));
        AppHolder.getContextImageLoader().displayImage(getActivity(), feed.getUserAvatar(), ((ItemFeedVideoDetailViewPartBinding) getBinding()).userAvatarView, 2131231152);
        UserAvatarView userAvatarView = ((ItemFeedVideoDetailViewPartBinding) getBinding()).userAvatarView;
        UserInfo userInfo = feed.getUserInfo();
        UserAvatarView.bind$default(userAvatarView, userInfo != null ? userInfo.getVerifyStatusIcon() : null, false, 2, null);
    }

    private final void setFeedContentVisible() {
        int i = 0;
        if (!(!isLandScape$presentation_coolapkAppRelease() && !this.hasEnterCommentView)) {
            i = 8;
        }
        LinearLayout linearLayout = ((ItemFeedVideoDetailViewPartBinding) getBinding()).actionContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.actionContainer");
        linearLayout.setVisibility(i);
        TextView textView = ((ItemFeedVideoDetailViewPartBinding) getBinding()).textView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
        textView.setVisibility(i);
    }

    @Override // com.coolapk.market.view.video.BaseVideoDetailViewPart, com.coolapk.market.widget.video.VideoPlayerBridge
    public void onAttach(RelationAssist relationAssist) {
        Intrinsics.checkNotNullParameter(relationAssist, "assist");
        if (this.detailControlCover == null) {
            this.detailControlCover = DetailControlCover.Companion.createWith((ItemFeedVideoDetailViewPartBinding) getBinding());
        }
        IReceiverGroup receiverGroup = relationAssist.getReceiverGroup();
        DetailControlCover detailControlCover2 = this.detailControlCover;
        if (detailControlCover2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailControlCover");
        }
        receiverGroup.addReceiver("proxy_cover", detailControlCover2);
        super.onAttach(relationAssist);
        IReceiverGroup receiverGroup2 = relationAssist.getReceiverGroup();
        Intrinsics.checkNotNullExpressionValue(receiverGroup2, "assist.receiverGroup");
        receiverGroup2.getGroupValue().putBoolean("isLandscape", isLandScape$presentation_coolapkAppRelease());
        IReceiverGroup receiverGroup3 = relationAssist.getReceiverGroup();
        Intrinsics.checkNotNullExpressionValue(receiverGroup3, "assist.receiverGroup");
        receiverGroup3.getGroupValue().putBoolean("hide_frame_content", true);
    }

    @Override // com.coolapk.market.view.video.BaseVideoDetailViewPart, com.coolapk.market.widget.video.VideoPlayerBridge
    public void onEvent(int i, Bundle bundle) {
        if (i != -100) {
            super.onEvent(i, bundle);
        } else if (this.hasEnterCommentView) {
            requestExitCommentView();
        } else {
            super.onEvent(i, bundle);
        }
    }

    @Override // com.coolapk.market.widget.video.VideoPlayerBridge
    public PlayerArg getPlayerArg() {
        FrameLayout frameLayout = ((ItemFeedVideoDetailViewPartBinding) getBinding()).videoContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.videoContainer");
        return new PlayerArg(frameLayout, getData$presentation_coolapkAppRelease(), SetsKt.setOf((Object[]) new String[]{"gesture_cover", "loading_cover", "error_cover"}), false);
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        super.onClick(view);
        if (Intrinsics.areEqual(view, ((ItemFeedVideoDetailViewPartBinding) getBinding()).textView)) {
            FeedDetailPresenter feedDetailPresenter = this.feedPresenter;
            if (feedDetailPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
            }
            ActionManager.startFeedDetailActivity(getActivity(), feedDetailPresenter.getFeed(), (String) null);
        } else if (Intrinsics.areEqual(view, ((ItemFeedVideoDetailViewPartBinding) getBinding()).likeView)) {
            FeedDetailPresenter feedDetailPresenter2 = this.feedPresenter;
            if (feedDetailPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
            }
            Activity currentActivity = AppHolder.getCurrentActivity();
            if (currentActivity != null) {
                Boolean checkLogin = ActionManager.checkLogin(currentActivity);
                Intrinsics.checkNotNullExpressionValue(checkLogin, "ActionManager.checkLogin(it)");
                if (checkLogin.booleanValue()) {
                    UserAction userAction = feedDetailPresenter2.getFeed().getUserAction();
                    boolean z = true;
                    if (userAction == null || userAction.getLike() != 1) {
                        z = false;
                    }
                    feedDetailPresenter2.likeFeed(z);
                }
            }
        } else if (Intrinsics.areEqual(view, ((ItemFeedVideoDetailViewPartBinding) getBinding()).favoriteView)) {
            FeedDetailPresenter feedDetailPresenter3 = this.feedPresenter;
            if (feedDetailPresenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
            }
            Activity currentActivity2 = AppHolder.getCurrentActivity();
            if (currentActivity2 != null) {
                Boolean checkLogin2 = ActionManager.checkLogin(currentActivity2);
                Intrinsics.checkNotNullExpressionValue(checkLogin2, "ActionManager.checkLogin(it)");
                if (checkLogin2.booleanValue()) {
                    ActionManager.startCollectionSelectActivity(getActivity(), feedDetailPresenter3.getFeed().getId(), feedDetailPresenter3.getFeed().getEntityType());
                }
            }
        } else if (Intrinsics.areEqual(view, ((ItemFeedVideoDetailViewPartBinding) getBinding()).commentView)) {
            enterCommentView();
        } else if (Intrinsics.areEqual(view, ((ItemFeedVideoDetailViewPartBinding) getBinding()).shareView)) {
            Entity relatedEntity = getData$presentation_coolapkAppRelease().getRelatedEntity();
            if ((relatedEntity instanceof Feed) || (relatedEntity instanceof DyhArticle)) {
                ActionManager.startForwardEntityActivity(getActivity(), relatedEntity);
            } else {
                ActionManager.shareText(getActivity(), relatedEntity);
            }
        } else if (Intrinsics.areEqual(view, ((ItemFeedVideoDetailViewPartBinding) getBinding()).feedContentView)) {
            FeedDetailPresenter feedDetailPresenter4 = this.feedPresenter;
            if (feedDetailPresenter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
            }
            Feed feed = feedDetailPresenter4.getFeed();
            ActionManager.startUserSpaceActivity(((ItemFeedVideoDetailViewPartBinding) getBinding()).userAvatarView, feed.getUid(), feed.getUserAvatar());
        }
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailView
    public void onFeedUpdate(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        setFeedContent();
    }

    public final void onFeedFavoriteChange(FeedFavoriteEvent feedFavoriteEvent) {
        Intrinsics.checkNotNullParameter(feedFavoriteEvent, "event");
        Entity relatedEntity = getData$presentation_coolapkAppRelease().getRelatedEntity();
        if (relatedEntity instanceof Feed) {
            Feed handleEvent = feedFavoriteEvent.handleEvent((Feed) relatedEntity);
            Intrinsics.checkNotNullExpressionValue(handleEvent, "feed");
            UserAction userAction = handleEvent.getUserAction();
            Intrinsics.checkNotNull(userAction);
            Intrinsics.checkNotNullExpressionValue(userAction, "feed.userAction!!");
            boolean z = true;
            if (userAction.getCollect() != 1) {
                z = false;
            }
            onFavoriteResult(z, Integer.valueOf(handleEvent.getFavoriteNum()), null);
        }
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailView
    public void onFavoriteResult(boolean z, Integer num, Throwable th) {
        int i;
        FeedDetailPresenter feedDetailPresenter = this.feedPresenter;
        if (feedDetailPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
        }
        if (th != null) {
            Toast.error(getActivity(), th);
            return;
        }
        Feed feed = feedDetailPresenter.getFeed();
        if (num != null) {
            i = num.intValue();
        } else {
            int favoriteNum = feed.getFavoriteNum();
            i = z ? favoriteNum + 1 : favoriteNum - 1;
        }
        Feed build = Feed.newBuilder(feed).userAction(UserAction.newBuilder(feed.getUserAction()).favorite(z ? 1 : 0).build()).favoriteNum(i).build();
        Intrinsics.checkNotNullExpressionValue(build, "newFeed");
        feedDetailPresenter.updateFeed(build);
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailView
    public void onLikeResult(boolean z, LikeResult likeResult, Throwable th) {
        FeedDetailPresenter feedDetailPresenter = this.feedPresenter;
        if (feedDetailPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
        }
        if (th != null) {
            Toast.error(getActivity(), th);
            return;
        }
        Feed feed = feedDetailPresenter.getFeed();
        FeedLikeEvent feedLikeEvent = new FeedLikeEvent(feed.getId(), z, likeResult);
        Feed handleEvent = feedLikeEvent.handleEvent(feed);
        Intrinsics.checkNotNullExpressionValue(handleEvent, "event.handleEvent(oldFeed)");
        feedDetailPresenter.updateFeed(handleEvent);
        EventBus.getDefault().post(feedLikeEvent);
    }

    private final void enterCommentView() {
        if (!this.hasEnterCommentView) {
            this.hasEnterCommentView = true;
            FeedDetailPresenter feedDetailPresenter = this.feedPresenter;
            if (feedDetailPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
            }
            VideoDetailReplyListFragment newInstance$default = VideoDetailReplyListFragment.Companion.newInstance$default(VideoDetailReplyListFragment.Companion, feedDetailPresenter.getFeed(), 0, 2, null);
            newInstance$default.setUserVisibleHint(false);
            FragmentTransaction beginTransaction = ContextExtendsKt.requireAppCompatActivity(getActivity()).getSupportFragmentManager().beginTransaction();
            FrameLayout frameLayout = ((ItemFeedVideoDetailViewPartBinding) getBinding()).commentContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.commentContainer");
            beginTransaction.add(frameLayout.getId(), newInstance$default).commitAllowingStateLoss();
            ContextExtendsKt.requireAppCompatActivity(getActivity()).getSupportFragmentManager().executePendingTransactions();
            setFeedContentVisible();
            getAssist$presentation_coolapkAppRelease().setAspectRatio(AspectRatio.AspectRatio_FIT_PARENT);
            ViewBounds acquire = ViewBounds.Companion.acquire(((ItemFeedVideoDetailViewPartBinding) getBinding()).videoTopView);
            ViewBounds copy$default = ViewBounds.copy$default(acquire, 0, 0, 0, (acquire.getWidth() * 9) / 16, 7, null);
            FrameLayout frameLayout2 = ((ItemFeedVideoDetailViewPartBinding) getBinding()).commentContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.commentContainer");
            ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(frameLayout2);
            if (marginParams != null) {
                marginParams.height = -1;
                marginParams.topMargin = copy$default.getHeight();
            }
            ((ItemFeedVideoDetailViewPartBinding) getBinding()).commentContainer.requestLayout();
            setCommentViewState(true);
            ViewBounds.Companion companion = ViewBounds.Companion;
            FrameLayout frameLayout3 = ((ItemFeedVideoDetailViewPartBinding) getBinding()).videoTopView;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.videoTopView");
            this.viewAnimator = companion.createAnimator(frameLayout3, acquire, copy$default);
            FrameLayout frameLayout4 = ((ItemFeedVideoDetailViewPartBinding) getBinding()).commentContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.commentContainer");
            FrameLayout frameLayout5 = frameLayout4;
            frameLayout5.getViewTreeObserver().addOnPreDrawListener(new FeedVideoDetailViewPart$enterCommentView$$inlined$doOnNextPreDraw$1(frameLayout5, this, newInstance$default));
        }
    }

    public final void setCommentViewFraction(float f) {
        FrameLayout frameLayout = ((ItemFeedVideoDetailViewPartBinding) getBinding()).commentContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.commentContainer");
        float f2 = ((float) 1) - f;
        FrameLayout frameLayout2 = ((ItemFeedVideoDetailViewPartBinding) getBinding()).commentContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.commentContainer");
        frameLayout.setTranslationY(((float) frameLayout2.getHeight()) * f2 * 1.1f);
        if (Build.VERSION.SDK_INT >= 22) {
            ValueAnimator valueAnimator = this.viewAnimator;
            if (valueAnimator != null) {
                valueAnimator.setCurrentFraction(f);
            }
        } else {
            ValueAnimator valueAnimator2 = this.viewAnimator;
            if (valueAnimator2 != null) {
                valueAnimator2.setCurrentPlayTime((long) (f * ((float) valueAnimator2.getDuration())));
            }
        }
        Rect rect = this.lastWindowsRect;
        if (rect != null) {
            LinearLayout linearLayout = ((ItemFeedVideoDetailViewPartBinding) getBinding()).bottomContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.bottomContainer");
            LinearLayout linearLayout2 = linearLayout;
            linearLayout2.setPadding(linearLayout2.getPaddingLeft(), linearLayout2.getPaddingTop(), linearLayout2.getPaddingRight(), (int) (f2 * ((float) rect.bottom)));
        }
    }

    public final void requestExitCommentView() {
        if (!this.isExitingCommentView) {
            this.isExitingCommentView = true;
            FrameLayout frameLayout = ((ItemFeedVideoDetailViewPartBinding) getBinding()).commentContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.commentContainer");
            float translationY = frameLayout.getTranslationY();
            FrameLayout frameLayout2 = ((ItemFeedVideoDetailViewPartBinding) getBinding()).commentContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.commentContainer");
            float height = translationY / ((float) frameLayout2.getHeight());
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setInterpolator(new LinearInterpolator());
            valueAnimator.setFloatValues(((float) 1) - height, 0.0f);
            valueAnimator.setDuration(200L);
            valueAnimator.addUpdateListener(new FeedVideoDetailViewPart$requestExitCommentView$$inlined$apply$lambda$1(this, height));
            ExtraExtendsKt.addListeners$default(valueAnimator, null, new FeedVideoDetailViewPart$requestExitCommentView$$inlined$apply$lambda$2(this, height), 1, null);
            valueAnimator.start();
        }
    }

    public final void exitCommentView() {
        if (this.hasEnterCommentView) {
            this.hasEnterCommentView = false;
            setFeedContentVisible();
            getReceiverGroup$presentation_coolapkAppRelease().getGroupValue().putBoolean("screen_switch_enable", true);
            getAssist$presentation_coolapkAppRelease().setAspectRatio(AspectRatio.AspectRatio_FILL_WIDTH);
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(getActivity()).getSupportFragmentManager();
            FrameLayout frameLayout = ((ItemFeedVideoDetailViewPartBinding) getBinding()).commentContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.commentContainer");
            Fragment findFragmentById = supportFragmentManager.findFragmentById(frameLayout.getId());
            while (findFragmentById != null) {
                supportFragmentManager.beginTransaction().remove(findFragmentById).commitAllowingStateLoss();
                supportFragmentManager.executePendingTransactions();
                FrameLayout frameLayout2 = ((ItemFeedVideoDetailViewPartBinding) getBinding()).commentContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.commentContainer");
                findFragmentById = supportFragmentManager.findFragmentById(frameLayout2.getId());
            }
            this.viewAnimator = null;
            FrameLayout frameLayout3 = ((ItemFeedVideoDetailViewPartBinding) getBinding()).videoTopView;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.videoTopView");
            ViewGroup.LayoutParams layoutParams = frameLayout3.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            ((ItemFeedVideoDetailViewPartBinding) getBinding()).videoTopView.requestLayout();
            FrameLayout frameLayout4 = ((ItemFeedVideoDetailViewPartBinding) getBinding()).commentContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.commentContainer");
            frameLayout4.getLayoutParams().height = 0;
            ((ItemFeedVideoDetailViewPartBinding) getBinding()).commentContainer.requestLayout();
            setCommentViewState(false);
        }
    }

    @Override // com.coolapk.market.view.video.BaseVideoDetailViewPart
    public void onAnimationEvent(boolean z, boolean z2) {
        super.onAnimationEvent(z, z2);
        if (z && !z2) {
            getReceiverGroup$presentation_coolapkAppRelease().getGroupValue().putBoolean("hide_frame_content", false);
            DetailControlCover detailControlCover2 = this.detailControlCover;
            if (detailControlCover2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailControlCover");
            }
            BaseControlCover.setControllerState$default(detailControlCover2, true, null, 2, null);
        }
        if (!z && z2) {
            LinearLayout linearLayout = ((ItemFeedVideoDetailViewPartBinding) getBinding()).topContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.topContainer");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = ((ItemFeedVideoDetailViewPartBinding) getBinding()).bottomContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.bottomContainer");
            linearLayout2.setVisibility(8);
        }
    }

    private final void setCommentViewState(boolean z) {
        boolean z2 = getReceiverGroup$presentation_coolapkAppRelease().getGroupValue().getBoolean("can_redirect_source", true);
        int i = 8;
        int i2 = z ? 8 : 0;
        RelativeLayout relativeLayout = ((ItemFeedVideoDetailViewPartBinding) getBinding()).feedContentView;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.feedContentView");
        relativeLayout.setVisibility(i2);
        ImageView imageView = ((ItemFeedVideoDetailViewPartBinding) getBinding()).volumeView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.volumeView");
        imageView.setVisibility(i2);
        ImageView imageView2 = ((ItemFeedVideoDetailViewPartBinding) getBinding()).pipView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.pipView");
        imageView2.setVisibility(i2);
        ImageView imageView3 = ((ItemFeedVideoDetailViewPartBinding) getBinding()).moreView;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.moreView");
        if (!z && z2) {
            i = 0;
        }
        imageView3.setVisibility(i);
        ImageView imageView4 = ((ItemFeedVideoDetailViewPartBinding) getBinding()).fullScreenView;
        Intrinsics.checkNotNullExpressionValue(imageView4, "binding.fullScreenView");
        imageView4.setVisibility(i2);
    }
}
