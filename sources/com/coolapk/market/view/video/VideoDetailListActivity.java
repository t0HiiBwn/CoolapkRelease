package com.coolapk.market.view.video;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blankj.utilcode.util.ScreenUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.TranslucentActivity;
import com.coolapk.market.databinding.VideoFullScreenBinding;
import com.coolapk.market.extend.ExtraExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.ActivityUtils;
import com.coolapk.market.util.NotchUtil;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.widget.ViewBounds;
import com.coolapk.market.widget.video.FloatWindowBridge;
import com.coolapk.market.widget.video.VideoModel;
import com.coolapk.market.widget.video.VideoPlayerBridge;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u0012\u0010\u001e\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0014J\b\u0010 \u001a\u00020\u000eH\u0014J\b\u0010!\u001a\u00020\u000eH\u0014J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u0013H\u0014J\b\u0010$\u001a\u00020\u000eH\u0014J\u0012\u0010%\u001a\u00020\u000e2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u000e\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\b0\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/coolapk/market/view/video/VideoDetailListActivity;", "Lcom/coolapk/market/view/base/BaseActivity;", "Lcom/coolapk/market/app/TranslucentActivity;", "()V", "binding", "Lcom/coolapk/market/databinding/VideoFullScreenBinding;", "detailViewPart", "Lcom/coolapk/market/view/video/BaseVideoDetailViewPart;", "Lcom/coolapk/market/widget/video/VideoModel;", "isAnimating", "", "isLandScape", "videoModel", "applyWindowsInset", "", "rect", "Landroid/graphics/Rect;", "finish", "getScreenOffsetComparedWithLastActivity", "", "activity", "Landroid/app/Activity;", "isNavigationBarTranslucent", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDetailViewPart", "onPause", "onResume", "onSetStatusBarColor", "onSetStatusBarDarkMode", "delay", "onStop", "startCloseAnimation", "targetBridge", "Lcom/coolapk/market/widget/video/VideoPlayerBridge;", "startCloseToFloatBridge", "floatWindowBridge", "Lcom/coolapk/market/widget/video/FloatWindowBridge;", "startOpenAnimation", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VideoDetailListActivity.kt */
public final class VideoDetailListActivity extends BaseActivity implements TranslucentActivity {
    public static final long ANIMATION_DURATION = 200;
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_VIDEO_MODEL = "extra_video_model";
    public static final String EXTRA_VIDEO_RECT = "extra_video_rect";
    public static final String EXTRA_VIDEO_SOURCE_BRIDGE_KEY = "extra_video_source_bridge_key";
    private VideoFullScreenBinding binding;
    private BaseVideoDetailViewPart<?, ? super VideoModel> detailViewPart;
    private boolean isAnimating;
    private boolean isLandScape;
    private VideoModel videoModel;

    @Override // com.coolapk.market.app.TranslucentActivity
    public boolean isNavigationBarTranslucent() {
        return false;
    }

    public static final /* synthetic */ VideoFullScreenBinding access$getBinding$p(VideoDetailListActivity videoDetailListActivity) {
        VideoFullScreenBinding videoFullScreenBinding = videoDetailListActivity.binding;
        if (videoFullScreenBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return videoFullScreenBinding;
    }

    public static final /* synthetic */ BaseVideoDetailViewPart access$getDetailViewPart$p(VideoDetailListActivity videoDetailListActivity) {
        BaseVideoDetailViewPart<?, ? super VideoModel> baseVideoDetailViewPart = videoDetailListActivity.detailViewPart;
        if (baseVideoDetailViewPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailViewPart");
        }
        return baseVideoDetailViewPart;
    }

    public static final /* synthetic */ VideoModel access$getVideoModel$p(VideoDetailListActivity videoDetailListActivity) {
        VideoModel videoModel2 = videoDetailListActivity.videoModel;
        if (videoModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoModel");
        }
        return videoModel2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/video/VideoDetailListActivity$Companion;", "", "()V", "ANIMATION_DURATION", "", "EXTRA_VIDEO_MODEL", "", "EXTRA_VIDEO_RECT", "EXTRA_VIDEO_SOURCE_BRIDGE_KEY", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VideoDetailListActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        ThemeUtils.setSystemBarDrawFlags(this);
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(getActivity(), 2131559292);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…layout.video_full_screen)");
        this.binding = (VideoFullScreenBinding) contentView;
        setSlidrEnable(false);
        Parcelable parcelableExtra = getIntent().getParcelableExtra("extra_video_model");
        Intrinsics.checkNotNull(parcelableExtra);
        VideoModel videoModel2 = (VideoModel) parcelableExtra;
        this.videoModel = videoModel2;
        if (this.videoModel != null) {
            if (videoModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoModel");
            }
            if (videoModel2.isValid()) {
                BaseActivity activity = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                activity.setRequestedOrientation(1);
                VideoFullScreenBinding videoFullScreenBinding = this.binding;
                if (videoFullScreenBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                videoFullScreenBinding.contentView.addOnInsetChangeListener(new VideoDetailListActivity$onCreate$2(this));
                NotchUtil notchUtil = NotchUtil.INSTANCE;
                Window window = getWindow();
                Intrinsics.checkNotNullExpressionValue(window, "window");
                notchUtil.blockStatusCutout(window);
                BaseVideoDetailViewPart<?, VideoModel> onCreateDetailViewPart = onCreateDetailViewPart();
                LayoutInflater from = LayoutInflater.from(this);
                Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(this)");
                VideoFullScreenBinding videoFullScreenBinding2 = this.binding;
                if (videoFullScreenBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                onCreateDetailViewPart.createView(from, videoFullScreenBinding2.videoContainer);
                VideoModel videoModel3 = this.videoModel;
                if (videoModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoModel");
                }
                onCreateDetailViewPart.bindToContent(videoModel3);
                VideoFullScreenBinding videoFullScreenBinding3 = this.binding;
                if (videoFullScreenBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                videoFullScreenBinding3.videoContainer.addView(onCreateDetailViewPart.getView(), new FrameLayout.LayoutParams(-1, -1));
                onCreateDetailViewPart.attachPlayerBridge$presentation_coolapkAppRelease();
                this.detailViewPart = onCreateDetailViewPart;
                VideoFullScreenBinding videoFullScreenBinding4 = this.binding;
                if (videoFullScreenBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                LinearLayout linearLayout = videoFullScreenBinding4.videoContainer;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.videoContainer");
                LinearLayout linearLayout2 = linearLayout;
                linearLayout2.getViewTreeObserver().addOnPreDrawListener(new VideoDetailListActivity$onCreate$$inlined$doOnNextPreDraw$1(linearLayout2, this));
                StatisticHelper.Companion.getInstance().recordVideoClickAction("用户点击全屏播放");
                return;
            }
        }
        throw new IllegalAccessException("video model error");
    }

    private final BaseVideoDetailViewPart<?, VideoModel> onCreateDetailViewPart() {
        VideoModel videoModel2 = this.videoModel;
        if (videoModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoModel");
        }
        Entity relatedEntity = videoModel2.getRelatedEntity();
        if (relatedEntity instanceof Feed) {
            BaseActivity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            return new FeedVideoDetailViewPart(activity);
        } else if (relatedEntity != null) {
            BaseActivity activity2 = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity2, "activity");
            return new EntityVideoDetailViewPart(activity2);
        } else {
            BaseActivity activity3 = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity3, "activity");
            return new SimpleVideoDetailViewPart(activity3);
        }
    }

    /* access modifiers changed from: private */
    public final void applyWindowsInset(Rect rect) {
        if (this.isLandScape) {
            VideoFullScreenBinding videoFullScreenBinding = this.binding;
            if (videoFullScreenBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout = videoFullScreenBinding.videoContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.videoContainer");
            ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(linearLayout);
            if (marginParams != null) {
                marginParams.leftMargin = rect.left;
            }
            VideoFullScreenBinding videoFullScreenBinding2 = this.binding;
            if (videoFullScreenBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            videoFullScreenBinding2.videoContainer.requestLayout();
        } else {
            VideoFullScreenBinding videoFullScreenBinding3 = this.binding;
            if (videoFullScreenBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout2 = videoFullScreenBinding3.videoContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.videoContainer");
            ViewGroup.MarginLayoutParams marginParams2 = ViewExtendsKt.getMarginParams(linearLayout2);
            if (marginParams2 != null) {
                marginParams2.leftMargin = 0;
            }
            VideoFullScreenBinding videoFullScreenBinding4 = this.binding;
            if (videoFullScreenBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            videoFullScreenBinding4.videoContainer.requestLayout();
        }
        BaseVideoDetailViewPart<?, ? super VideoModel> baseVideoDetailViewPart = this.detailViewPart;
        if (baseVideoDetailViewPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailViewPart");
        }
        baseVideoDetailViewPart.applyWindowsInset(rect);
    }

    /* access modifiers changed from: private */
    public final void startOpenAnimation() {
        Rect rect = (Rect) getIntent().getParcelableExtra("extra_video_rect");
        ObjectAnimator objectAnimator = null;
        if (rect != null && !rect.isEmpty()) {
            rect.offset(0, -getScreenOffsetComparedWithLastActivity(this));
            ViewBounds.Companion companion = ViewBounds.Companion;
            VideoFullScreenBinding videoFullScreenBinding = this.binding;
            if (videoFullScreenBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ViewBounds acquire = companion.acquire(videoFullScreenBinding.videoContainer);
            ViewBounds viewBounds = new ViewBounds(rect.left, rect.top, rect.width(), rect.height());
            ViewBounds.Companion companion2 = ViewBounds.Companion;
            VideoFullScreenBinding videoFullScreenBinding2 = this.binding;
            if (videoFullScreenBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout = videoFullScreenBinding2.videoContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.videoContainer");
            objectAnimator = companion2.createAnimator(linearLayout, viewBounds, acquire);
        }
        if (objectAnimator == null) {
            objectAnimator = new ValueAnimator();
            objectAnimator.setFloatValues(0.0f, 1.0f);
            objectAnimator.addUpdateListener(new VideoDetailListActivity$startOpenAnimation$$inlined$apply$lambda$1(this));
        }
        ExtraExtendsKt.addListeners$default(objectAnimator, null, new VideoDetailListActivity$startOpenAnimation$2(this), 1, null);
        objectAnimator.setDuration(200L);
        ActivityUtils activityUtils = ActivityUtils.INSTANCE;
        BaseActivity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        activityUtils.convertActivityToTranslucent(activity);
        objectAnimator.start();
        this.isAnimating = true;
        BaseVideoDetailViewPart<?, ? super VideoModel> baseVideoDetailViewPart = this.detailViewPart;
        if (baseVideoDetailViewPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailViewPart");
        }
        baseVideoDetailViewPart.onAnimationEvent(true, true);
    }

    public final void startCloseToFloatBridge(FloatWindowBridge floatWindowBridge) {
        Intrinsics.checkNotNullParameter(floatWindowBridge, "floatWindowBridge");
        String sourceKey = floatWindowBridge.getSourceKey();
        AppHolder.setWeakValue(sourceKey, floatWindowBridge);
        floatWindowBridge.setLastSourceKey(getIntent().getStringExtra("extra_video_source_bridge_key"));
        getIntent().putExtra("extra_video_source_bridge_key", sourceKey);
        startCloseAnimation(floatWindowBridge);
    }

    private final void startCloseAnimation(VideoPlayerBridge videoPlayerBridge) {
        ObjectAnimator objectAnimator = null;
        if (videoPlayerBridge != null) {
            Rect globalRect = ViewExtendsKt.getGlobalRect(videoPlayerBridge.getPlayerArg().getContainer());
            if (videoPlayerBridge instanceof FloatWindowBridge) {
                globalRect = ((FloatWindowBridge) videoPlayerBridge).getWindowsRect();
            }
            if (globalRect != null && !globalRect.isEmpty()) {
                globalRect.offset(0, -getScreenOffsetComparedWithLastActivity(this));
            }
            if (globalRect != null && !globalRect.isEmpty()) {
                ViewBounds.Companion companion = ViewBounds.Companion;
                VideoFullScreenBinding videoFullScreenBinding = this.binding;
                if (videoFullScreenBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                ViewBounds acquire = companion.acquire(videoFullScreenBinding.videoContainer);
                ViewBounds viewBounds = new ViewBounds(globalRect.left, globalRect.top, globalRect.width(), globalRect.height());
                ViewBounds.Companion companion2 = ViewBounds.Companion;
                VideoFullScreenBinding videoFullScreenBinding2 = this.binding;
                if (videoFullScreenBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                LinearLayout linearLayout = videoFullScreenBinding2.videoContainer;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.videoContainer");
                objectAnimator = companion2.createAnimator(linearLayout, acquire, viewBounds);
            }
        }
        if (objectAnimator == null) {
            objectAnimator = new ValueAnimator();
            objectAnimator.setFloatValues(1.0f, 0.0f);
            objectAnimator.addUpdateListener(new VideoDetailListActivity$startCloseAnimation$$inlined$apply$lambda$1(this));
        }
        ExtraExtendsKt.addListeners$default(objectAnimator, null, new VideoDetailListActivity$startCloseAnimation$2(this), 1, null);
        objectAnimator.addUpdateListener(new VideoDetailListActivity$startCloseAnimation$3(videoPlayerBridge));
        objectAnimator.setDuration(200L);
        objectAnimator.start();
        BaseVideoDetailViewPart<?, ? super VideoModel> baseVideoDetailViewPart = this.detailViewPart;
        if (baseVideoDetailViewPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailViewPart");
        }
        baseVideoDetailViewPart.onAnimationEvent(false, true);
        ActivityUtils activityUtils = ActivityUtils.INSTANCE;
        BaseActivity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        activityUtils.convertActivityToTranslucent(activity);
        this.isAnimating = true;
        setSlidrEnable(false);
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarDarkMode(int i) {
        ThemeUtils.setDarkStatusIconBar(getActivity(), false, i);
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        BaseVideoDetailViewPart<?, ? super VideoModel> baseVideoDetailViewPart = this.detailViewPart;
        if (baseVideoDetailViewPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailViewPart");
        }
        baseVideoDetailViewPart.handleConfigurationChanged(configuration);
        boolean z = configuration.orientation == 2;
        this.isLandScape = z;
        setSlidrEnable(!z);
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        BaseVideoDetailViewPart<?, ? super VideoModel> baseVideoDetailViewPart = this.detailViewPart;
        if (baseVideoDetailViewPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailViewPart");
        }
        baseVideoDetailViewPart.handleActivityResume();
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        BaseVideoDetailViewPart<?, ? super VideoModel> baseVideoDetailViewPart = this.detailViewPart;
        if (baseVideoDetailViewPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailViewPart");
        }
        baseVideoDetailViewPart.handleActivityPause();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        BaseVideoDetailViewPart<?, ? super VideoModel> baseVideoDetailViewPart = this.detailViewPart;
        if (baseVideoDetailViewPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailViewPart");
        }
        baseVideoDetailViewPart.handleActivityStop();
    }

    @Override // com.coolapk.market.view.base.BaseActivity, android.app.Activity
    public void finish() {
        VideoPlayerBridge videoPlayerBridge = (VideoPlayerBridge) AppHolder.getWeakValue(getIntent().getStringExtra("extra_video_source_bridge_key"));
        BaseVideoDetailViewPart<?, ? super VideoModel> baseVideoDetailViewPart = this.detailViewPart;
        if (baseVideoDetailViewPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailViewPart");
        }
        baseVideoDetailViewPart.detachPlayerBridge$presentation_coolapkAppRelease(videoPlayerBridge);
        super.finish();
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.isAnimating) {
            BaseVideoDetailViewPart<?, ? super VideoModel> baseVideoDetailViewPart = this.detailViewPart;
            if (baseVideoDetailViewPart == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailViewPart");
            }
            if (!baseVideoDetailViewPart.handleBackPress()) {
                startCloseAnimation((VideoPlayerBridge) AppHolder.getWeakValue(getIntent().getStringExtra("extra_video_source_bridge_key")));
            }
        }
    }

    private final int getScreenOffsetComparedWithLastActivity(Activity activity) {
        if (Build.VERSION.SDK_INT < 28) {
            return 0;
        }
        int screenHeight = ScreenUtils.getScreenHeight();
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "activity.window");
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        return screenHeight - decorView.getHeight();
    }
}
