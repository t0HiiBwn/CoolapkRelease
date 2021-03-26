package com.coolapk.market.view.wallpaper.coolpic;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.PicReplyListBinding;
import com.coolapk.market.event.FeedFavoriteEvent;
import com.coolapk.market.event.FeedLikeEvent;
import com.coolapk.market.event.FeedReplyEvent;
import com.coolapk.market.extend.EventBusExtendsKt;
import com.coolapk.market.manager.ActivityStackManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.LikeResult;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.feed.reply.FeedCommentBarViewPart;
import com.coolapk.market.view.feed.reply.FeedDetailPresenter;
import com.coolapk.market.view.feed.reply.FeedDetailView;
import com.coolapk.market.view.wallpaper.coolpic.PictureDetailReplyListFragment;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.view.SlideUpView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0012H\u0014J)\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0007J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010 \u001a\u00020#H\u0007J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J$\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010+\u001a\u00020\u0012H\u0014J\b\u0010,\u001a\u00020\u0012H\u0002J\b\u0010-\u001a\u00020\u0012H\u0002J\b\u0010.\u001a\u00020\u0012H\u0002J\u0010\u0010/\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010¨\u00060"}, d2 = {"Lcom/coolapk/market/view/wallpaper/coolpic/PictureReplyDetailActivity;", "Lcom/coolapk/market/view/base/BaseActivity;", "Lcom/coolapk/market/view/feed/reply/FeedDetailView;", "()V", "binding", "Lcom/coolapk/market/databinding/PicReplyListBinding;", "commentBarViewPart", "Lcom/coolapk/market/view/feed/reply/FeedCommentBarViewPart;", "contentFragment", "Lcom/coolapk/market/view/wallpaper/coolpic/PictureDetailReplyListFragment;", "feed", "Lcom/coolapk/market/model/Feed;", "feedPresenter", "Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;", "isSet", "", "Ljava/lang/Boolean;", "initSearchMenu", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFavoriteResult", "favorite", "favoriteNum", "", "error", "", "(ZLjava/lang/Integer;Ljava/lang/Throwable;)V", "onFeedFavoriteChange", "event", "Lcom/coolapk/market/event/FeedFavoriteEvent;", "onFeedReply", "Lcom/coolapk/market/event/FeedReplyEvent;", "onFeedUpdate", "onFollowAuthorResult", "following", "onLikeResult", "like", "result", "Lcom/coolapk/market/model/LikeResult;", "onSetStatusBarColor", "setupCommentBar", "setupFragment", "setupSlideView", "updataFeed", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PictureReplyDetailActivity.kt */
public final class PictureReplyDetailActivity extends BaseActivity implements FeedDetailView {
    private PicReplyListBinding binding;
    private FeedCommentBarViewPart commentBarViewPart;
    private PictureDetailReplyListFragment contentFragment;
    private Feed feed;
    private FeedDetailPresenter feedPresenter;
    private Boolean isSet = false;

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void initSearchMenu() {
    }

    public static final /* synthetic */ PicReplyListBinding access$getBinding$p(PictureReplyDetailActivity pictureReplyDetailActivity) {
        PicReplyListBinding picReplyListBinding = pictureReplyDetailActivity.binding;
        if (picReplyListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return picReplyListBinding;
    }

    public static final /* synthetic */ Feed access$getFeed$p(PictureReplyDetailActivity pictureReplyDetailActivity) {
        Feed feed2 = pictureReplyDetailActivity.feed;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        return feed2;
    }

    public static final /* synthetic */ FeedDetailPresenter access$getFeedPresenter$p(PictureReplyDetailActivity pictureReplyDetailActivity) {
        FeedDetailPresenter feedDetailPresenter = pictureReplyDetailActivity.feedPresenter;
        if (feedDetailPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
        }
        return feedDetailPresenter;
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        ThemeUtils.setSystemBarDrawFlags(this);
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(getActivity(), 2131559081);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte… R.layout.pic_reply_list)");
        this.binding = (PicReplyListBinding) contentView;
        Parcelable parcelableExtra = getIntent().getParcelableExtra("feed");
        Intrinsics.checkNotNull(parcelableExtra);
        Feed feed2 = (Feed) parcelableExtra;
        this.feed = feed2;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        this.feedPresenter = new FeedDetailPresenter(feed2, this);
        PicReplyListBinding picReplyListBinding = this.binding;
        if (picReplyListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        picReplyListBinding.mainContent.setOnClickListener(new PictureReplyDetailActivity$onCreate$1(this));
        setupSlideView();
        setupFragment();
        setupCommentBar();
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeRegister(eventBus, this);
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeUnregister(eventBus, this);
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailView
    public void onFollowAuthorResult(boolean z, Throwable th) {
        if (th != null) {
            Toast.error(getActivity(), th);
            return;
        }
        FeedDetailPresenter feedDetailPresenter = this.feedPresenter;
        if (feedDetailPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
        }
        Feed feed2 = feedDetailPresenter.getFeed();
        Feed build = Feed.newBuilder(feed2).userAction(UserAction.newBuilder(feed2.getUserAction()).followAuthor(z ? 1 : 0).build()).build();
        FeedDetailPresenter feedDetailPresenter2 = this.feedPresenter;
        if (feedDetailPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
        }
        Intrinsics.checkNotNullExpressionValue(build, "newFeed");
        feedDetailPresenter2.updateFeed(build);
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailView
    public void onFavoriteResult(boolean z, Integer num, Throwable th) {
        int i;
        if (th != null) {
            Toast.error(getActivity(), th);
            return;
        }
        FeedDetailPresenter feedDetailPresenter = this.feedPresenter;
        if (feedDetailPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
        }
        Feed feed2 = feedDetailPresenter.getFeed();
        if (num != null) {
            i = num.intValue();
        } else if (z) {
            i = feed2.getFavoriteNum() + 1;
        } else {
            i = feed2.getFavoriteNum() - 1;
        }
        Feed build = Feed.newBuilder(feed2).userAction(UserAction.newBuilder(feed2.getUserAction()).favorite(z ? 1 : 0).build()).favoriteNum(i).build();
        FeedDetailPresenter feedDetailPresenter2 = this.feedPresenter;
        if (feedDetailPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
        }
        Intrinsics.checkNotNullExpressionValue(build, "newFeed");
        feedDetailPresenter2.updateFeed(build);
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailView
    public void onLikeResult(boolean z, LikeResult likeResult, Throwable th) {
        int i;
        if (th != null) {
            Toast.error(getActivity(), th);
            return;
        }
        EventBus eventBus = EventBus.getDefault();
        Feed feed2 = this.feed;
        if (feed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        eventBus.post(new FeedLikeEvent(feed2.getId(), z, likeResult));
        FeedDetailPresenter feedDetailPresenter = this.feedPresenter;
        if (feedDetailPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
        }
        Feed feed3 = feedDetailPresenter.getFeed();
        if ((likeResult != null ? Integer.valueOf(likeResult.getCount()) : null) != null) {
            i = likeResult.getCount();
        } else if (z) {
            i = feed3.getLikeNum() + 1;
        } else {
            i = feed3.getLikeNum() - 1;
        }
        Feed build = Feed.newBuilder(feed3).userAction(UserAction.newBuilder(feed3.getUserAction()).like(z ? 1 : 0).build()).likeNum(i).build();
        FeedDetailPresenter feedDetailPresenter2 = this.feedPresenter;
        if (feedDetailPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
        }
        Intrinsics.checkNotNullExpressionValue(build, "newFeed");
        feedDetailPresenter2.updateFeed(build);
    }

    @Override // com.coolapk.market.view.feed.reply.FeedDetailView
    public void onFeedUpdate(Feed feed2) {
        Intrinsics.checkNotNullParameter(feed2, "feed");
        FeedCommentBarViewPart feedCommentBarViewPart = this.commentBarViewPart;
        if (feedCommentBarViewPart != null) {
            feedCommentBarViewPart.bindToContent(feed2);
        }
        updataFeed(feed2);
    }

    @Subscribe
    public final void onFeedReply(FeedReplyEvent feedReplyEvent) {
        Intrinsics.checkNotNullParameter(feedReplyEvent, "event");
        FeedDetailPresenter feedDetailPresenter = this.feedPresenter;
        if (feedDetailPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
        }
        Feed handleEvent = feedReplyEvent.handleEvent(feedDetailPresenter.getFeed());
        FeedCommentBarViewPart feedCommentBarViewPart = this.commentBarViewPart;
        Intrinsics.checkNotNull(feedCommentBarViewPart);
        Intrinsics.checkNotNullExpressionValue(handleEvent, "feed");
        feedCommentBarViewPart.bindToContent(handleEvent);
        FeedDetailPresenter feedDetailPresenter2 = this.feedPresenter;
        if (feedDetailPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
        }
        feedDetailPresenter2.updateFeed(handleEvent);
    }

    @Subscribe
    public final void onFeedFavoriteChange(FeedFavoriteEvent feedFavoriteEvent) {
        Intrinsics.checkNotNullParameter(feedFavoriteEvent, "event");
        FeedDetailPresenter feedDetailPresenter = this.feedPresenter;
        if (feedDetailPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
        }
        Feed handleEvent = feedFavoriteEvent.handleEvent(feedDetailPresenter.getFeed());
        FeedDetailPresenter feedDetailPresenter2 = this.feedPresenter;
        if (feedDetailPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedPresenter");
        }
        Intrinsics.checkNotNullExpressionValue(handleEvent, "feed");
        feedDetailPresenter2.updateFeed(handleEvent);
    }

    private final void updataFeed(Feed feed2) {
        Activity activityUnder$default = ActivityStackManager.getActivityUnder$default(AppHolder.getActivityStackManager(), this, false, 2, null);
        if (activityUnder$default instanceof CoolPicDetailActivity) {
            Fragment findFragmentById = ((CoolPicDetailActivity) activityUnder$default).getSupportFragmentManager().findFragmentById(2131362318);
            if (findFragmentById instanceof CoolPicListFragment) {
                ((CoolPicListFragment) findFragmentById).updateFeed(feed2);
            }
        }
    }

    private final void setupCommentBar() {
        PicReplyListBinding picReplyListBinding = this.binding;
        if (picReplyListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = picReplyListBinding.getRoot();
        FrameLayout.LayoutParams layoutParams = null;
        if (!(root instanceof FrameLayout)) {
            root = null;
        }
        FrameLayout frameLayout = (FrameLayout) root;
        if (frameLayout != null) {
            FeedCommentBarViewPart.Companion companion = FeedCommentBarViewPart.Companion;
            Feed feed2 = this.feed;
            if (feed2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
            }
            FeedCommentBarViewPart newInstance = companion.newInstance(feed2, frameLayout);
            newInstance.setExternalListener(new PictureReplyDetailActivity$setupCommentBar$1(this));
            View view = newInstance.getView();
            frameLayout.addView(view);
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                layoutParams = layoutParams2;
            }
            FrameLayout.LayoutParams layoutParams3 = layoutParams;
            if (layoutParams3 != null) {
                layoutParams3.gravity = 80;
                layoutParams3.width = -1;
                layoutParams3.height = -2;
            }
            view.setElevation((float) DisplayUtils.dp2px(getActivity(), 0.5f));
            view.setVisibility(0);
            this.commentBarViewPart = newInstance;
        }
    }

    private final void setupFragment() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        PictureDetailReplyListFragment pictureDetailReplyListFragment = (PictureDetailReplyListFragment) supportFragmentManager.findFragmentById(2131362306);
        this.contentFragment = pictureDetailReplyListFragment;
        if (pictureDetailReplyListFragment == null) {
            PictureDetailReplyListFragment.Companion companion = PictureDetailReplyListFragment.Companion;
            Feed feed2 = this.feed;
            if (feed2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
            }
            this.contentFragment = PictureDetailReplyListFragment.Companion.newInstance$default(companion, feed2, 0, 2, null);
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            PictureDetailReplyListFragment pictureDetailReplyListFragment2 = this.contentFragment;
            Intrinsics.checkNotNull(pictureDetailReplyListFragment2);
            beginTransaction.add(2131362306, pictureDetailReplyListFragment2).commit();
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        super.onSetStatusBarColor();
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        PicReplyListBinding picReplyListBinding = this.binding;
        if (picReplyListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        picReplyListBinding.bottomSheet.dismissView();
    }

    private final void setupSlideView() {
        PicReplyListBinding picReplyListBinding = this.binding;
        if (picReplyListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        picReplyListBinding.bottomSheet.setInitTranslationY((float) DisplayUtils.dp2px(getActivity(), 240.0f));
        PicReplyListBinding picReplyListBinding2 = this.binding;
        if (picReplyListBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        SlideUpView slideUpView = picReplyListBinding2.bottomSheet;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(ColorStateList.valueOf(AppHolder.getAppTheme().getContentBackgroundColor()));
        float dp2px = (float) ConvertUtils.dp2px(12.0f);
        gradientDrawable.setCornerRadii(new float[]{dp2px, dp2px, dp2px, dp2px, 0.0f, 0.0f, 0.0f, 0.0f});
        Unit unit = Unit.INSTANCE;
        slideUpView.setBackground(gradientDrawable);
        slideUpView.setClickable(true);
        PicReplyListBinding picReplyListBinding3 = this.binding;
        if (picReplyListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        picReplyListBinding3.bottomSheet.setCallback(new PictureReplyDetailActivity$setupSlideView$2(this));
    }
}
