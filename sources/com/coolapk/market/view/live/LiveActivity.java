package com.coolapk.market.view.live;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.TranslucentActivity;
import com.coolapk.market.databinding.LiveActivityBinding;
import com.coolapk.market.event.LiveFollowEvent;
import com.coolapk.market.extend.EventBusExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Live;
import com.coolapk.market.model.LiveMessage;
import com.coolapk.market.model.LiveProduct;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.NotchUtil;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.base.FragmentStatePagerAdapter;
import com.coolapk.market.view.danmaku.DanmakuManager;
import com.coolapk.market.view.danmaku.DanmakuText;
import com.coolapk.market.view.danmaku.DanmakuTextStyle;
import com.coolapk.market.view.live.LiveContract;
import com.coolapk.market.view.live.LiveOptionsDialog;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.view.TabLayout;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ï\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0003\b\r\u001c\u0018\u0000 s2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0003stuB\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020&H\u0016J\n\u0010*\u001a\u0004\u0018\u00010+H\u0002J\b\u0010,\u001a\u00020\u001fH\u0016J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u001aH\u0016J\b\u00100\u001a\u00020$H\u0016J\u0006\u00101\u001a\u00020.J\b\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u00020.H\u0002J\b\u00107\u001a\u00020&H\u0002J\b\u00108\u001a\u00020\u0010H\u0016J\b\u00109\u001a\u00020&H\u0002J\"\u0010:\u001a\u00020&2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010?\u001a\u00020&H\u0016J\"\u0010@\u001a\u00020&2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\"\u0010A\u001a\u00020&2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J*\u0010B\u001a\u00020&2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010C\u001a\u00020\u0015H\u0016J*\u0010D\u001a\u00020&2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010C\u001a\u00020\u0015H\u0016J\"\u0010E\u001a\u00020&2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0010\u0010F\u001a\u00020&2\u0006\u0010G\u001a\u00020HH\u0016J\u0012\u0010I\u001a\u00020&2\b\u0010J\u001a\u0004\u0018\u00010KH\u0014J\b\u0010L\u001a\u00020&H\u0014J\u0010\u0010M\u001a\u00020&2\u0006\u0010N\u001a\u00020OH\u0007J*\u0010P\u001a\u00020&2\u0006\u0010Q\u001a\u00020\u00102\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\"\u0010R\u001a\u00020&2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0010\u0010S\u001a\u00020&2\u0006\u0010T\u001a\u00020UH\u0016J\u0010\u0010V\u001a\u00020&2\u0006\u0010N\u001a\u00020WH\u0007J\u0010\u0010X\u001a\u00020&2\u0006\u0010T\u001a\u00020UH\u0016J\u0010\u0010Y\u001a\u00020&2\u0006\u0010Z\u001a\u00020[H\u0007J*\u0010\\\u001a\u00020&2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010]\u001a\u00020\u0015H\u0016J\b\u0010^\u001a\u00020&H\u0014J\b\u0010_\u001a\u00020&H\u0014J\u0010\u0010`\u001a\u00020&2\u0006\u0010a\u001a\u00020KH\u0014J\b\u0010b\u001a\u00020&H\u0014J\u0010\u0010c\u001a\u00020&2\u0006\u0010d\u001a\u00020.H\u0014J\b\u0010e\u001a\u00020&H\u0014J\u0014\u0010f\u001a\u00020&2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010UH\u0002J\b\u0010g\u001a\u00020&H\u0014J\u000e\u0010h\u001a\u00020\u00102\u0006\u0010i\u001a\u00020\u0010J\b\u0010j\u001a\u00020&H\u0002J\u0006\u0010k\u001a\u00020&J\b\u0010l\u001a\u00020&H\u0002J\b\u0010m\u001a\u00020&H\u0002J7\u0010n\u001a\u00020.\"\u0004\b\u0000\u0010o*\b\u0012\u0004\u0012\u0002Ho0!2\b\b\u0002\u0010p\u001a\u00020.2\u0012\u0010q\u001a\u000e\u0012\u0004\u0012\u0002Ho\u0012\u0004\u0012\u00020\u00100rH\bR\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000f\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X.¢\u0006\u0002\n\u0000¨\u0006v"}, d2 = {"Lcom/coolapk/market/view/live/LiveActivity;", "Lcom/coolapk/market/view/base/BaseActivity;", "Lcom/coolapk/market/view/live/LiveContract$View;", "Lcom/coolapk/market/view/live/LiveContext;", "Landroid/view/View$OnClickListener;", "Lcom/coolapk/market/app/TranslucentActivity;", "()V", "appImStateListener", "com/coolapk/market/view/live/LiveActivity$appImStateListener$1", "Lcom/coolapk/market/view/live/LiveActivity$appImStateListener$1;", "binding", "Lcom/coolapk/market/databinding/LiveActivityBinding;", "groupMessageListener", "com/coolapk/market/view/live/LiveActivity$groupMessageListener$1", "Lcom/coolapk/market/view/live/LiveActivity$groupMessageListener$1;", "isPresenter", "", "()Z", "isPresenter$delegate", "Lkotlin/Lazy;", "liveId", "", "getLiveId", "()Ljava/lang/String;", "liveId$delegate", "liveVideoViewPart", "Lcom/coolapk/market/view/live/LiveVideoViewPart;", "onPageChangeListener", "com/coolapk/market/view/live/LiveActivity$onPageChangeListener$1", "Lcom/coolapk/market/view/live/LiveActivity$onPageChangeListener$1;", "presenter", "Lcom/coolapk/market/view/live/LivePresenter;", "tabs", "", "Lcom/coolapk/market/view/live/LiveActivity$Tab;", "viewModel", "Lcom/coolapk/market/view/live/LiveViewModel;", "applyWindowsInset", "", "rect", "Landroid/graphics/Rect;", "finish", "getLive", "Lcom/coolapk/market/model/Live;", "getLivePresenter", "getLiveVideoHeight", "", "getLiveVideoViewPart", "getLiveViewModel", "getNavigationBarHeight", "getViewPagerAdapter", "Lcom/coolapk/market/view/live/LiveActivity$DataAdapter;", "getViewPagerFragment", "Landroidx/fragment/app/Fragment;", "position", "initUI", "isNavigationBarTranslucent", "joinIMGroup", "onAddToBroadcast", "result", "Lcom/coolapk/market/network/Result;", "error", "", "onBackPressed", "onBanAllPost", "onBanAllPostPic", "onBanUser", "uid", "onBanUserAndClean", "onChangeLiveStatus", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onLiveDiscussNumEventChanged", "event", "Lcom/coolapk/market/view/live/LiveNumEvent;", "onLiveFollowed", "follow", "onLiveLoaded", "onLiveMessageClick", "liveMessage", "Lcom/coolapk/market/model/LiveMessage;", "onLiveMessageEventChanged", "Lcom/coolapk/market/view/live/LiveMessageEvent;", "onLiveMessageLongClick", "onLoginEvent", "session", "Lcom/coolapk/market/local/LoginSession;", "onMessageDeleted", "messageId", "onPause", "onResume", "onSaveInstanceState", "outState", "onSetStatusBarColor", "onSetStatusBarDarkMode", "delay", "onStart", "onStartLivePostMessageActivity", "onStop", "requireToggleVideoFullScreen", "withAnimation", "updateAppbarScrollable", "updateLiveVideoViewPart", "updatePostView", "updateUI", "indexOfFirst", "T", "default", "predicate", "Lkotlin/Function1;", "Companion", "DataAdapter", "Tab", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveActivity.kt */
public final class LiveActivity extends BaseActivity implements LiveContract.View, LiveContext, View.OnClickListener, TranslucentActivity {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_LIVE_ID = "LIVE_ID";
    private final LiveActivity$appImStateListener$1 appImStateListener = new LiveActivity$appImStateListener$1(this);
    private LiveActivityBinding binding;
    private final LiveActivity$groupMessageListener$1 groupMessageListener = new LiveActivity$groupMessageListener$1(this);
    private final Lazy isPresenter$delegate = LazyKt.lazy(new LiveActivity$isPresenter$2(this));
    private final Lazy liveId$delegate = LazyKt.lazy(new LiveActivity$liveId$2(this));
    private LiveVideoViewPart liveVideoViewPart;
    private final LiveActivity$onPageChangeListener$1 onPageChangeListener = new LiveActivity$onPageChangeListener$1(this);
    private LivePresenter presenter;
    private List<Tab> tabs;
    private LiveViewModel viewModel;

    /* access modifiers changed from: private */
    public final String getLiveId() {
        return (String) this.liveId$delegate.getValue();
    }

    private final boolean isPresenter() {
        return ((Boolean) this.isPresenter$delegate.getValue()).booleanValue();
    }

    @Override // com.coolapk.market.app.TranslucentActivity
    public boolean isNavigationBarTranslucent() {
        return true;
    }

    public static final /* synthetic */ LiveActivityBinding access$getBinding$p(LiveActivity liveActivity) {
        LiveActivityBinding liveActivityBinding = liveActivity.binding;
        if (liveActivityBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return liveActivityBinding;
    }

    public static final /* synthetic */ LiveVideoViewPart access$getLiveVideoViewPart$p(LiveActivity liveActivity) {
        LiveVideoViewPart liveVideoViewPart2 = liveActivity.liveVideoViewPart;
        if (liveVideoViewPart2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveVideoViewPart");
        }
        return liveVideoViewPart2;
    }

    public static final /* synthetic */ LivePresenter access$getPresenter$p(LiveActivity liveActivity) {
        LivePresenter livePresenter = liveActivity.presenter;
        if (livePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return livePresenter;
    }

    public static final /* synthetic */ LiveViewModel access$getViewModel$p(LiveActivity liveActivity) {
        LiveViewModel liveViewModel = liveActivity.viewModel;
        if (liveViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return liveViewModel;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/live/LiveActivity$Companion;", "", "()V", "KEY_LIVE_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, 2131559016);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…, R.layout.live_activity)");
        LiveActivityBinding liveActivityBinding = (LiveActivityBinding) contentView;
        this.binding = liveActivityBinding;
        if (liveActivityBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        liveActivityBinding.contentView.addOnInsetChangeListener(new LiveActivity$onCreate$1(this));
        String liveId = getLiveId();
        Intrinsics.checkNotNullExpressionValue(liveId, "liveId");
        LivePresenter livePresenter = new LivePresenter(this, liveId);
        this.presenter = livePresenter;
        if (livePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        livePresenter.onInitPresenterState(bundle);
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        LivePresenter livePresenter2 = this.presenter;
        if (livePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        LiveViewModel liveViewModel = new LiveViewModel(applicationContext, livePresenter2);
        this.viewModel = liveViewModel;
        if (liveViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        liveViewModel.onInitPresenterState(bundle);
        LivePresenter livePresenter3 = this.presenter;
        if (livePresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        livePresenter3.loadLive();
        initUI();
        AppHolder.getAppIMManager().addStateListener(this.appImStateListener);
        AppHolder.getAppIMManager().addGroupMessageListener(this.groupMessageListener);
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeRegister(eventBus, this);
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        LiveViewModel liveViewModel = this.viewModel;
        if (liveViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        liveViewModel.onSaveInstanceState(bundle);
        LivePresenter livePresenter = this.presenter;
        if (livePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        livePresenter.onSaveInstanceState(bundle);
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    private final void initUI() {
        LiveActivityBinding liveActivityBinding = this.binding;
        if (liveActivityBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TabLayout tabLayout = liveActivityBinding.tabLayout;
        LiveActivityBinding liveActivityBinding2 = this.binding;
        if (liveActivityBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        tabLayout.setupWithViewPager(liveActivityBinding2.viewPager);
        LiveActivityBinding liveActivityBinding3 = this.binding;
        if (liveActivityBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        liveActivityBinding3.viewPager.addOnPageChangeListener(this.onPageChangeListener);
        LiveActivityBinding liveActivityBinding4 = this.binding;
        if (liveActivityBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = liveActivityBinding4.postView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.postView");
        frameLayout.setVisibility(8);
        LiveActivityBinding liveActivityBinding5 = this.binding;
        if (liveActivityBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        liveActivityBinding5.postView.setOnClickListener(this);
        LiveActivityBinding liveActivityBinding6 = this.binding;
        if (liveActivityBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TabLayout tabLayout2 = liveActivityBinding6.tabLayout;
        Intrinsics.checkNotNullExpressionValue(tabLayout2, "binding.tabLayout");
        ViewExtendsKt.setV9TabColor(tabLayout2, false);
        LiveActivityBinding liveActivityBinding7 = this.binding;
        if (liveActivityBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TabLayout tabLayout3 = liveActivityBinding7.tabLayout;
        Intrinsics.checkNotNullExpressionValue(tabLayout3, "binding.tabLayout");
        ViewExtendsKt.setV9TabUI(tabLayout3, 1);
        BaseActivity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        activity.setRequestedOrientation(1);
        LiveViewModel liveViewModel = this.viewModel;
        if (liveViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LivePresenter livePresenter = this.presenter;
        if (livePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        LiveVideoViewPart liveVideoViewPart2 = new LiveVideoViewPart(this, liveViewModel, livePresenter);
        LayoutInflater from = LayoutInflater.from(this);
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(this)");
        LiveActivityBinding liveActivityBinding8 = this.binding;
        if (liveActivityBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        liveVideoViewPart2.createView(from, liveActivityBinding8.playerHolder);
        liveVideoViewPart2.bindToContent(null);
        LiveActivityBinding liveActivityBinding9 = this.binding;
        if (liveActivityBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        liveActivityBinding9.playerHolder.addView(liveVideoViewPart2.getView(), new FrameLayout.LayoutParams(-1, -1));
        this.liveVideoViewPart = liveVideoViewPart2;
        LiveActivityBinding liveActivityBinding10 = this.binding;
        if (liveActivityBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        DrawSystemBarFrameLayout drawSystemBarFrameLayout = liveActivityBinding10.contentView;
        LiveActivityBinding liveActivityBinding11 = this.binding;
        if (liveActivityBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        drawSystemBarFrameLayout.setConsumeInsetChild(liveActivityBinding11.contentView.getChildAt(0));
        LiveActivityBinding liveActivityBinding12 = this.binding;
        if (liveActivityBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        liveActivityBinding12.contentView.addOnInsetChangeListener(new LiveActivity$initUI$1(this));
        NotchUtil notchUtil = NotchUtil.INSTANCE;
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "window");
        notchUtil.blockStatusCutout(window);
        updateUI();
    }

    private final void updateAppbarScrollable() {
        LiveActivityBinding liveActivityBinding = this.binding;
        if (liveActivityBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = liveActivityBinding.collapsingToolbar;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.collapsingToolbar");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
        AppBarLayout.LayoutParams layoutParams2 = (AppBarLayout.LayoutParams) layoutParams;
        layoutParams2.setScrollFlags(3);
        LiveActivityBinding liveActivityBinding2 = this.binding;
        if (liveActivityBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout2 = liveActivityBinding2.collapsingToolbar;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.collapsingToolbar");
        frameLayout2.setLayoutParams(layoutParams2);
    }

    private final void updateUI() {
        Live live = getLive();
        if (live == null) {
            return;
        }
        if (this.tabs == null) {
            ArrayList arrayList = new ArrayList();
            LiveViewModel liveViewModel = this.viewModel;
            if (liveViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            String[] viewPageTitles = liveViewModel.getViewPageTitles();
            int i = 0;
            arrayList.add(new Tab("intro", viewPageTitles[0], LiveActivity$updateUI$1.INSTANCE));
            arrayList.add(new Tab("live", viewPageTitles[1], new LiveActivity$updateUI$2(this)));
            if (live.isDiscussTabEnable()) {
                arrayList.add(new Tab("discuss", viewPageTitles[2], new LiveActivity$updateUI$3(this)));
            }
            LiveProduct relationProduct = live.getRelationProduct();
            if (relationProduct != null) {
                arrayList.add(new Tab("product", viewPageTitles[3], new LiveActivity$updateUI$4(this, relationProduct)));
            }
            String relationTag = live.getRelationTag();
            if (!TextUtils.isEmpty(relationTag)) {
                arrayList.add(new Tab("topic", viewPageTitles[4], new LiveActivity$updateUI$5(this, relationTag)));
            }
            String relationPageName = live.getRelationPageName();
            if (!TextUtils.isEmpty(relationPageName)) {
                arrayList.add(new Tab("page", viewPageTitles[5], new LiveActivity$updateUI$6(relationPageName)));
            }
            LiveActivityBinding liveActivityBinding = this.binding;
            if (liveActivityBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ViewPager viewPager = liveActivityBinding.viewPager;
            Intrinsics.checkNotNullExpressionValue(viewPager, "binding.viewPager");
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            ArrayList arrayList2 = arrayList;
            viewPager.setAdapter(new DataAdapter(supportFragmentManager, arrayList2));
            LiveVideoViewPart liveVideoViewPart2 = this.liveVideoViewPart;
            if (liveVideoViewPart2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("liveVideoViewPart");
            }
            liveVideoViewPart2.bindToContent(live);
            LiveActivityBinding liveActivityBinding2 = this.binding;
            if (liveActivityBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ViewPager viewPager2 = liveActivityBinding2.viewPager;
            Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.viewPager");
            Iterator it2 = arrayList2.iterator();
            int i2 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    break;
                } else if (Intrinsics.areEqual(((Tab) it2.next()).getIndex(), live.getShowTab())) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            viewPager2.setCurrentItem(i);
            this.tabs = arrayList2;
            return;
        }
        LiveActivityBinding liveActivityBinding3 = this.binding;
        if (liveActivityBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewPager viewPager3 = liveActivityBinding3.viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager3, "binding.viewPager");
        PagerAdapter adapter = viewPager3.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        LiveVideoViewPart liveVideoViewPart3 = this.liveVideoViewPart;
        if (liveVideoViewPart3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveVideoViewPart");
        }
        liveVideoViewPart3.bindToContent(live);
    }

    private final <T> int indexOfFirst(List<? extends T> list, int i, Function1<? super T, Boolean> function1) {
        int i2 = 0;
        for (T t : list) {
            if (function1.invoke(t).booleanValue()) {
                return i2;
            }
            i2++;
        }
        return i;
    }

    static /* synthetic */ int indexOfFirst$default(LiveActivity liveActivity, List list, int i, Function1 function1, int i2, Object obj) {
        int i3 = i2 & 1;
        int i4 = 0;
        if (i3 != 0) {
            i = 0;
        }
        for (Object obj2 : list) {
            if (((Boolean) function1.invoke(obj2)).booleanValue()) {
                return i4;
            }
            i4++;
        }
        return i;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onLiveMessageEventChanged(LiveMessageEvent liveMessageEvent) {
        List<LiveMessage> liveMessages;
        Intrinsics.checkNotNullParameter(liveMessageEvent, "event");
        if (liveMessageEvent.getAction() == 3 && (liveMessages = liveMessageEvent.getLiveMessages()) != null) {
            for (T t : liveMessages) {
                LiveViewModel liveViewModel = this.viewModel;
                if (liveViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                Live live = liveViewModel.getLive();
                if (live == null) {
                    return;
                }
                if (LiveUtilsKt.isSentByMyself(t)) {
                    if (!LiveUtilsKt.isSentByPresenter(t, live)) {
                        DanmakuManager danmakuManager = getLiveVideoViewPart().getDanmakuManager();
                        String message = t.getMessage();
                        Intrinsics.checkNotNullExpressionValue(message, "liveMessage.message");
                        danmakuManager.addDanmaku(new DanmakuText(message, DanmakuTextStyle.MYSELF, null, 4, null));
                    } else if (t.getIsBroadcast() == 0) {
                        DanmakuManager danmakuManager2 = getLiveVideoViewPart().getDanmakuManager();
                        String message2 = t.getMessage();
                        Intrinsics.checkNotNullExpressionValue(message2, "liveMessage.message");
                        danmakuManager2.addDanmaku(new DanmakuText(message2, DanmakuTextStyle.ALL, t.getUserName()));
                    }
                    LiveUpdateTabHelper.Companion.onLiveUpdateTab(t);
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onLiveDiscussNumEventChanged(LiveNumEvent liveNumEvent) {
        Integer num;
        Tab tab;
        Intrinsics.checkNotNullParameter(liveNumEvent, "event");
        LiveViewModel liveViewModel = this.viewModel;
        if (liveViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        liveViewModel.setFollowNumFormat(liveNumEvent.getFollowNum(), liveNumEvent.getFollowNumFormat());
        LiveViewModel liveViewModel2 = this.viewModel;
        if (liveViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        liveViewModel2.setVisitNumFormat(liveNumEvent.getVisitNum(), liveNumEvent.getVisitNumFormat());
        LiveViewModel liveViewModel3 = this.viewModel;
        if (liveViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        liveViewModel3.setDiscussNumFormat(liveNumEvent.getDiscussNum(), liveNumEvent.getDiscussNumFormat());
        updateLiveVideoViewPart();
        List<Tab> list = this.tabs;
        if (list != null) {
            int i = 0;
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    i = -1;
                    break;
                } else if (Intrinsics.areEqual(it2.next().getIndex(), "discuss")) {
                    break;
                } else {
                    i++;
                }
            }
            num = Integer.valueOf(i);
        } else {
            num = null;
        }
        if (num != null && num.intValue() != -1) {
            LiveActivityBinding liveActivityBinding = this.binding;
            if (liveActivityBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TabLayout.Tab tabAt = liveActivityBinding.tabLayout.getTabAt(num.intValue());
            if (tabAt != null) {
                LiveViewModel liveViewModel4 = this.viewModel;
                if (liveViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                tabAt.setText(liveViewModel4.getDiscussTabTitle());
            }
            List<Tab> list2 = this.tabs;
            if (list2 != null && (tab = list2.get(num.intValue())) != null) {
                LiveViewModel liveViewModel5 = this.viewModel;
                if (liveViewModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                tab.setName(liveViewModel5.getDiscussTabTitle());
            }
        }
    }

    @Override // com.coolapk.market.view.live.LiveContract.View
    public void onLiveLoaded(Result<Live> result, Throwable th) {
        updateUI();
        updatePostView();
        joinIMGroup();
    }

    @Override // com.coolapk.market.view.live.LiveContract.View
    public void onLiveFollowed(boolean z, Result<String> result, Throwable th) {
        int i;
        if (th == null) {
            if (z) {
                LiveViewModel liveViewModel = this.viewModel;
                if (liveViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                i = liveViewModel.getFollowNum() + 1;
            } else {
                LiveViewModel liveViewModel2 = this.viewModel;
                if (liveViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                i = liveViewModel2.getFollowNum() - 1;
            }
            LiveViewModel liveViewModel3 = this.viewModel;
            if (liveViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            Intrinsics.checkNotNull(result);
            String data = result.getData();
            Intrinsics.checkNotNullExpressionValue(data, "result!!.data");
            liveViewModel3.setFollowNumFormat(i, data);
        } else {
            LiveViewModel liveViewModel4 = this.viewModel;
            if (liveViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            LiveViewModel liveViewModel5 = this.viewModel;
            if (liveViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            liveViewModel4.setFollowLive(!liveViewModel5.isFollowLive());
        }
        updateLiveVideoViewPart();
        EventBus eventBus = EventBus.getDefault();
        String liveId = getLiveId();
        Intrinsics.checkNotNullExpressionValue(liveId, "liveId");
        eventBus.post(new LiveFollowEvent(liveId, z));
    }

    @Override // com.coolapk.market.view.live.LiveContract.View
    public void onAddToBroadcast(Result<String> result, Throwable th) {
        String str;
        if (th != null) {
            Toast.error(this, th);
            return;
        }
        LiveActivity liveActivity = this;
        if (result == null || (str = result.getData()) == null) {
            str = "";
        }
        Toast.show$default(liveActivity, str, 0, false, 12, null);
        EventBus.getDefault().post(new LiveMessageEvent(1, null, "1", null, null, 26, null));
    }

    @Override // com.coolapk.market.view.live.LiveContract.View
    public void onMessageDeleted(Result<String> result, Throwable th, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "messageId");
        if (th != null) {
            Toast.error(this, th);
            return;
        }
        LiveActivity liveActivity = this;
        if (result == null || (str2 = result.getData()) == null) {
            str2 = "";
        }
        Toast.show$default(liveActivity, str2, 0, false, 12, null);
        EventBus.getDefault().post(new LiveMessageEvent(2, null, null, str, null, 22, null));
    }

    @Override // com.coolapk.market.view.live.LiveContract.View
    public void onBanUserAndClean(Result<String> result, Throwable th, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "uid");
        if (th != null) {
            Toast.error(this, th);
            return;
        }
        LiveActivity liveActivity = this;
        if (result == null || (str2 = result.getData()) == null) {
            str2 = "";
        }
        Toast.show$default(liveActivity, str2, 0, false, 12, null);
        EventBus.getDefault().post(new LiveMessageEvent(2, null, null, null, str, 14, null));
    }

    @Override // com.coolapk.market.view.live.LiveContract.View
    public void onBanUser(Result<String> result, Throwable th, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "uid");
        if (th != null) {
            Toast.error(this, th);
            return;
        }
        LiveActivity liveActivity = this;
        if (result == null || (str2 = result.getData()) == null) {
            str2 = "";
        }
        Toast.show$default(liveActivity, str2, 0, false, 12, null);
    }

    @Override // com.coolapk.market.view.live.LiveContract.View
    public void onBanAllPost(Result<String> result, Throwable th) {
        String str;
        if (th != null) {
            Toast.error(this, th);
            return;
        }
        LiveActivity liveActivity = this;
        if (result == null || (str = result.getData()) == null) {
            str = "";
        }
        Toast.show$default(liveActivity, str, 0, false, 12, null);
        LivePresenter livePresenter = this.presenter;
        if (livePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        if (!livePresenter.isLoadingLive()) {
            LivePresenter livePresenter2 = this.presenter;
            if (livePresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            livePresenter2.loadLive();
        }
    }

    @Override // com.coolapk.market.view.live.LiveContract.View
    public void onBanAllPostPic(Result<String> result, Throwable th) {
        String str;
        if (th != null) {
            Toast.error(this, th);
            return;
        }
        LiveActivity liveActivity = this;
        if (result == null || (str = result.getData()) == null) {
            str = "";
        }
        Toast.show$default(liveActivity, str, 0, false, 12, null);
        LivePresenter livePresenter = this.presenter;
        if (livePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        if (!livePresenter.isLoadingLive()) {
            LivePresenter livePresenter2 = this.presenter;
            if (livePresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            livePresenter2.loadLive();
        }
    }

    @Override // com.coolapk.market.view.live.LiveContract.View
    public void onChangeLiveStatus(Result<String> result, Throwable th) {
        String str;
        if (th != null) {
            Toast.error(this, th);
            return;
        }
        LiveActivity liveActivity = this;
        if (result == null || (str = result.getData()) == null) {
            str = "";
        }
        Toast.show$default(liveActivity, str, 0, false, 12, null);
        LivePresenter livePresenter = this.presenter;
        if (livePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        if (!livePresenter.isLoadingLive()) {
            LivePresenter livePresenter2 = this.presenter;
            if (livePresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            livePresenter2.loadLive();
        }
    }

    public final void updateLiveVideoViewPart() {
        LiveVideoViewPart liveVideoViewPart2 = this.liveVideoViewPart;
        if (liveVideoViewPart2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveVideoViewPart");
        }
        liveVideoViewPart2.updateLiveUI();
    }

    @Override // com.coolapk.market.view.live.LiveContext
    public LiveViewModel getLiveViewModel() {
        LiveViewModel liveViewModel = this.viewModel;
        if (liveViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return liveViewModel;
    }

    @Override // com.coolapk.market.view.live.LiveContext
    public LivePresenter getLivePresenter() {
        LivePresenter livePresenter = this.presenter;
        if (livePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return livePresenter;
    }

    @Override // com.coolapk.market.view.live.LiveContext
    public LiveVideoViewPart getLiveVideoViewPart() {
        LiveVideoViewPart liveVideoViewPart2 = this.liveVideoViewPart;
        if (liveVideoViewPart2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveVideoViewPart");
        }
        return liveVideoViewPart2;
    }

    @Override // com.coolapk.market.view.live.LiveContext
    public int getLiveVideoHeight() {
        LiveActivityBinding liveActivityBinding = this.binding;
        if (liveActivityBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = liveActivityBinding.playerHolder;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.playerHolder");
        return frameLayout.getHeight();
    }

    private final Live getLive() {
        LivePresenter livePresenter = this.presenter;
        if (livePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return livePresenter.getLive();
    }

    private final DataAdapter getViewPagerAdapter() {
        LiveActivityBinding liveActivityBinding = this.binding;
        if (liveActivityBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewPager viewPager = liveActivityBinding.viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager, "binding.viewPager");
        PagerAdapter adapter = viewPager.getAdapter();
        Objects.requireNonNull(adapter, "null cannot be cast to non-null type com.coolapk.market.view.live.LiveActivity.DataAdapter");
        return (DataAdapter) adapter;
    }

    /* access modifiers changed from: private */
    public final Fragment getViewPagerFragment(int i) {
        DataAdapter viewPagerAdapter = getViewPagerAdapter();
        LiveActivityBinding liveActivityBinding = this.binding;
        if (liveActivityBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        Object instantiateItem = viewPagerAdapter.instantiateItem((ViewGroup) liveActivityBinding.viewPager, i);
        Objects.requireNonNull(instantiateItem, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        return (Fragment) instantiateItem;
    }

    /* access modifiers changed from: private */
    public final void updatePostView() {
        String str;
        List<Tab> list = this.tabs;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            LiveActivityBinding liveActivityBinding = this.binding;
            if (liveActivityBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ViewPager viewPager = liveActivityBinding.viewPager;
            Intrinsics.checkNotNullExpressionValue(viewPager, "binding.viewPager");
            int i = 8;
            String index = list.get(viewPager.getCurrentItem()).getIndex();
            switch (index.hashCode()) {
                case -309474065:
                    index.equals("product");
                    break;
                case 3322092:
                    if (index.equals("live") && isPresenter()) {
                        LiveActivityBinding liveActivityBinding2 = this.binding;
                        if (liveActivityBinding2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        TextView textView = liveActivityBinding2.postTextView;
                        Intrinsics.checkNotNullExpressionValue(textView, "binding.postTextView");
                        textView.setText("发布直播内容");
                        LiveActivityBinding liveActivityBinding3 = this.binding;
                        if (liveActivityBinding3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        liveActivityBinding3.postIconView.setImageResource(2131231440);
                        i = 0;
                        break;
                    }
                case 3433103:
                    index.equals("page");
                    break;
                case 100361836:
                    index.equals("intro");
                    break;
                case 110546223:
                    index.equals("topic");
                    break;
                case 1671386080:
                    if (index.equals("discuss")) {
                        Live live = getLive();
                        if (live == null) {
                            str = "参与直播讨论";
                        } else if (live.isDiscussEnable()) {
                            String videoPlaybackUrl = live.getVideoPlaybackUrl();
                            str = videoPlaybackUrl == null || videoPlaybackUrl.length() == 0 ? "发送弹幕，参与讨论" : "参与直播回顾讨论";
                        } else {
                            str = TextUtils.isEmpty(live.getRelationTag()) ? "直播讨论已关闭" : "直播讨论已关闭，请参与话题继续讨论";
                        }
                        LiveActivityBinding liveActivityBinding4 = this.binding;
                        if (liveActivityBinding4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        TextView textView2 = liveActivityBinding4.postTextView;
                        Intrinsics.checkNotNullExpressionValue(textView2, "binding.postTextView");
                        textView2.setText(str);
                        LiveActivityBinding liveActivityBinding5 = this.binding;
                        if (liveActivityBinding5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        liveActivityBinding5.postIconView.setImageResource(2131231680);
                        i = 0;
                        break;
                    }
                    break;
            }
            LiveActivityBinding liveActivityBinding6 = this.binding;
            if (liveActivityBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            FrameLayout frameLayout = liveActivityBinding6.postView;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.postView");
            frameLayout.setVisibility(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        if (view.getId() == 2131363151) {
            List<Tab> list = this.tabs;
            Intrinsics.checkNotNull(list);
            LiveActivityBinding liveActivityBinding = this.binding;
            if (liveActivityBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ViewPager viewPager = liveActivityBinding.viewPager;
            Intrinsics.checkNotNullExpressionValue(viewPager, "binding.viewPager");
            String index = list.get(viewPager.getCurrentItem()).getIndex();
            Integer num = null;
            if (index.hashCode() == 1671386080 && index.equals("discuss")) {
                Live live = getLive();
                if (live == null) {
                    return;
                }
                if (!live.isDiscussEnable()) {
                    int i = 0;
                    if (!TextUtils.isEmpty(live.getRelationTag())) {
                        List<Tab> list2 = this.tabs;
                        if (list2 != null) {
                            Iterator<T> it2 = list2.iterator();
                            int i2 = 0;
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                } else if (Intrinsics.areEqual(it2.next().getIndex(), "topic")) {
                                    i = i2;
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                            num = Integer.valueOf(i);
                        }
                        if (num != null) {
                            LiveActivityBinding liveActivityBinding2 = this.binding;
                            if (liveActivityBinding2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                            }
                            ViewPager viewPager2 = liveActivityBinding2.viewPager;
                            Intrinsics.checkNotNullExpressionValue(viewPager2, "binding.viewPager");
                            viewPager2.setCurrentItem(num.intValue());
                        }
                    } else if (live.getRelationProduct() != null) {
                        List<Tab> list3 = this.tabs;
                        if (list3 != null) {
                            Iterator<T> it3 = list3.iterator();
                            int i3 = 0;
                            while (true) {
                                if (!it3.hasNext()) {
                                    break;
                                } else if (Intrinsics.areEqual(it3.next().getIndex(), "product")) {
                                    i = i3;
                                    break;
                                } else {
                                    i3++;
                                }
                            }
                            num = Integer.valueOf(i);
                        }
                        if (num != null) {
                            LiveActivityBinding liveActivityBinding3 = this.binding;
                            if (liveActivityBinding3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                            }
                            ViewPager viewPager3 = liveActivityBinding3.viewPager;
                            Intrinsics.checkNotNullExpressionValue(viewPager3, "binding.viewPager");
                            viewPager3.setCurrentItem(num.intValue());
                        }
                    }
                } else {
                    onStartLivePostMessageActivity$default(this, null, 1, null);
                }
            } else {
                onStartLivePostMessageActivity$default(this, null, 1, null);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void applyWindowsInset(Rect rect) {
        LiveVideoViewPart liveVideoViewPart2 = this.liveVideoViewPart;
        if (liveVideoViewPart2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveVideoViewPart");
        }
        liveVideoViewPart2.applyWindowsInset(rect);
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarDarkMode(int i) {
        ThemeUtils.setDarkStatusIconBar(getActivity(), false, i);
    }

    public final boolean requireToggleVideoFullScreen(boolean z) {
        LiveVideoViewPart liveVideoViewPart2 = this.liveVideoViewPart;
        if (liveVideoViewPart2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveVideoViewPart");
        }
        ViewParent parent = liveVideoViewPart2.getView().getParent();
        LiveActivityBinding liveActivityBinding = this.binding;
        if (liveActivityBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        boolean z2 = !Intrinsics.areEqual(parent, liveActivityBinding.videoContainer);
        if (z2) {
            LiveActivityBinding liveActivityBinding2 = this.binding;
            if (liveActivityBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            FrameLayout frameLayout = liveActivityBinding2.playerHolder;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.playerHolder");
            LiveVideoViewPart liveVideoViewPart3 = this.liveVideoViewPart;
            if (liveVideoViewPart3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("liveVideoViewPart");
            }
            frameLayout.setMinimumHeight(liveVideoViewPart3.getView().getHeight());
            LiveActivityBinding liveActivityBinding3 = this.binding;
            if (liveActivityBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout = liveActivityBinding3.videoContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.videoContainer");
            linearLayout.setVisibility(0);
            LiveVideoViewPart liveVideoViewPart4 = this.liveVideoViewPart;
            if (liveVideoViewPart4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("liveVideoViewPart");
            }
            ViewExtendsKt.detachFromParent(liveVideoViewPart4.getView());
            LiveActivityBinding liveActivityBinding4 = this.binding;
            if (liveActivityBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout2 = liveActivityBinding4.videoContainer;
            LiveVideoViewPart liveVideoViewPart5 = this.liveVideoViewPart;
            if (liveVideoViewPart5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("liveVideoViewPart");
            }
            linearLayout2.addView(liveVideoViewPart5.getView(), new FrameLayout.LayoutParams(-1, -1));
            if (z) {
                LiveActivityBinding liveActivityBinding5 = this.binding;
                if (liveActivityBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                TransitionManager.beginDelayedTransition(liveActivityBinding5.videoContainer);
                LiveVideoViewPart liveVideoViewPart6 = this.liveVideoViewPart;
                if (liveVideoViewPart6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("liveVideoViewPart");
                }
                liveVideoViewPart6.setItemViewRatio(0.0f);
            } else {
                LiveVideoViewPart liveVideoViewPart7 = this.liveVideoViewPart;
                if (liveVideoViewPart7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("liveVideoViewPart");
                }
                liveVideoViewPart7.setItemViewRatio(0.0f);
            }
        } else {
            LiveActivityBinding liveActivityBinding6 = this.binding;
            if (liveActivityBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            FrameLayout frameLayout2 = liveActivityBinding6.playerHolder;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.playerHolder");
            frameLayout2.setMinimumHeight(0);
            if (z) {
                LiveActivityBinding liveActivityBinding7 = this.binding;
                if (liveActivityBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                TransitionManager.beginDelayedTransition(liveActivityBinding7.videoContainer);
                LiveVideoViewPart liveVideoViewPart8 = this.liveVideoViewPart;
                if (liveVideoViewPart8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("liveVideoViewPart");
                }
                liveVideoViewPart8.setItemViewRatio(1.7777778f);
                LiveActivityBinding liveActivityBinding8 = this.binding;
                if (liveActivityBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                View root = liveActivityBinding8.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                root.postDelayed(new LiveActivity$requireToggleVideoFullScreen$$inlined$postDelayed$1(this), 300);
            } else {
                LiveActivityBinding liveActivityBinding9 = this.binding;
                if (liveActivityBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                LinearLayout linearLayout3 = liveActivityBinding9.videoContainer;
                Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.videoContainer");
                linearLayout3.setVisibility(8);
                LiveVideoViewPart liveVideoViewPart9 = this.liveVideoViewPart;
                if (liveVideoViewPart9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("liveVideoViewPart");
                }
                ViewExtendsKt.detachFromParent(liveVideoViewPart9.getView());
                LiveActivityBinding liveActivityBinding10 = this.binding;
                if (liveActivityBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                FrameLayout frameLayout3 = liveActivityBinding10.playerHolder;
                LiveVideoViewPart liveVideoViewPart10 = this.liveVideoViewPart;
                if (liveVideoViewPart10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("liveVideoViewPart");
                }
                frameLayout3.addView(liveVideoViewPart10.getView(), new FrameLayout.LayoutParams(-1, -1));
                LiveVideoViewPart liveVideoViewPart11 = this.liveVideoViewPart;
                if (liveVideoViewPart11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("liveVideoViewPart");
                }
                liveVideoViewPart11.setItemViewRatio(1.7777778f);
            }
        }
        setSlidrEnable(!z2);
        return z2;
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        LiveVideoViewPart liveVideoViewPart2 = this.liveVideoViewPart;
        if (liveVideoViewPart2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveVideoViewPart");
        }
        if (!liveVideoViewPart2.handleBackPress()) {
            super.onBackPressed();
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        LiveVideoViewPart liveVideoViewPart2 = this.liveVideoViewPart;
        if (liveVideoViewPart2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveVideoViewPart");
        }
        liveVideoViewPart2.handleActivityResume();
        LiveViewModel liveViewModel = this.viewModel;
        if (liveViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        if (liveViewModel.getLive() != null && !AppHolder.getAppIMManager().isInit()) {
            joinIMGroup();
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        LiveVideoViewPart liveVideoViewPart2 = this.liveVideoViewPart;
        if (liveVideoViewPart2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveVideoViewPart");
        }
        liveVideoViewPart2.handleActivityPause();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        LiveVideoViewPart liveVideoViewPart2 = this.liveVideoViewPart;
        if (liveVideoViewPart2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveVideoViewPart");
        }
        liveVideoViewPart2.handleActivityStop();
    }

    @Override // com.coolapk.market.view.base.BaseActivity, android.app.Activity
    public void finish() {
        LiveVideoViewPart liveVideoViewPart2 = this.liveVideoViewPart;
        if (liveVideoViewPart2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveVideoViewPart");
        }
        liveVideoViewPart2.detachVideoWhenFinish();
        super.finish();
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        String relationGroupId;
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        LiveVideoViewPart liveVideoViewPart2 = this.liveVideoViewPart;
        if (liveVideoViewPart2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveVideoViewPart");
        }
        liveVideoViewPart2.handleActivityDestroy();
        LiveActivityBinding liveActivityBinding = this.binding;
        if (liveActivityBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        liveActivityBinding.viewPager.removeOnPageChangeListener(this.onPageChangeListener);
        AppHolder.getAppIMManager().removeGroupMessageListener(this.groupMessageListener);
        AppHolder.getAppIMManager().removeStateListener(this.appImStateListener);
        LiveViewModel liveViewModel = this.viewModel;
        if (liveViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Live live = liveViewModel.getLive();
        if (live != null && (relationGroupId = live.getRelationGroupId()) != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new LiveActivity$onDestroy$1$1(relationGroupId, null), 3, null);
        }
    }

    @Override // com.coolapk.market.view.live.LiveContext
    public void onLiveMessageClick(LiveMessage liveMessage) {
        Intrinsics.checkNotNullParameter(liveMessage, "liveMessage");
        onStartLivePostMessageActivity(liveMessage);
    }

    @Override // com.coolapk.market.view.live.LiveContext
    public void onLiveMessageLongClick(LiveMessage liveMessage) {
        Intrinsics.checkNotNullParameter(liveMessage, "liveMessage");
        LiveOptionsDialog.Companion companion = LiveOptionsDialog.Companion;
        LiveViewModel liveViewModel = this.viewModel;
        if (liveViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LiveOptionsDialog newInstance = companion.newInstance(liveMessage, liveViewModel.currentUserIsPresenter());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
    }

    static /* synthetic */ void onStartLivePostMessageActivity$default(LiveActivity liveActivity, LiveMessage liveMessage, int i, Object obj) {
        if ((i & 1) != 0) {
            liveMessage = null;
        }
        liveActivity.onStartLivePostMessageActivity(liveMessage);
    }

    private final void onStartLivePostMessageActivity(LiveMessage liveMessage) {
        List<Tab> list = this.tabs;
        Intrinsics.checkNotNull(list);
        LiveActivityBinding liveActivityBinding = this.binding;
        if (liveActivityBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewPager viewPager = liveActivityBinding.viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager, "binding.viewPager");
        Tab tab = list.get(viewPager.getCurrentItem());
        LiveViewModel liveViewModel = this.viewModel;
        if (liveViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Live live = liveViewModel.getLive();
        String relationGroupId = live != null ? live.getRelationGroupId() : null;
        String index = tab.getIndex();
        int hashCode = index.hashCode();
        if (hashCode != 3322092) {
            if (hashCode == 1671386080 && index.equals("discuss")) {
                ActionManager.startLivePostMessageActivity(getActivity(), "live_discuss", getLiveId(), relationGroupId, liveMessage, isPresenter());
            }
        } else if (index.equals("live")) {
            ActionManager.startLivePostMessageActivity(getActivity(), "live_message", getLiveId(), relationGroupId, liveMessage, isPresenter());
        }
    }

    public final int getNavigationBarHeight() {
        LiveActivityBinding liveActivityBinding = this.binding;
        if (liveActivityBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        DrawSystemBarFrameLayout drawSystemBarFrameLayout = liveActivityBinding.contentView;
        Intrinsics.checkNotNullExpressionValue(drawSystemBarFrameLayout, "binding.contentView");
        return drawSystemBarFrameLayout.getLastInsetsRect().height();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000bH\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/view/live/LiveActivity$DataAdapter;", "Lcom/coolapk/market/view/base/FragmentStatePagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "tabs", "", "Lcom/coolapk/market/view/live/LiveActivity$Tab;", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;)V", "getTabs", "()Ljava/util/List;", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getItemPosition", "object", "", "getItemTag", "", "getPageTitle", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveActivity.kt */
    private static final class DataAdapter extends FragmentStatePagerAdapter {
        private final List<Tab> tabs;

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "object");
            return -2;
        }

        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public String getItemTag(int i) {
            return null;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataAdapter(FragmentManager fragmentManager, List<Tab> list) {
            super(fragmentManager);
            Intrinsics.checkNotNullParameter(fragmentManager, "fm");
            Intrinsics.checkNotNullParameter(list, "tabs");
            this.tabs = list;
        }

        public final List<Tab> getTabs() {
            return this.tabs;
        }

        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return this.tabs.get(i).getCreateFragment().invoke();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.tabs.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.tabs.get(i).getName();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\f\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/coolapk/market/view/live/LiveActivity$Tab;", "", "index", "", "name", "createFragment", "Lkotlin/Function0;", "Landroidx/fragment/app/Fragment;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getCreateFragment", "()Lkotlin/jvm/functions/Function0;", "getIndex", "()Ljava/lang/String;", "getName", "setName", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveActivity.kt */
    private static final class Tab {
        public static final Companion Companion = new Companion(null);
        public static final String INDEX_DISCUSS = "discuss";
        public static final String INDEX_INTRODUCE = "intro";
        public static final String INDEX_LIVE = "live";
        public static final String INDEX_PRODUCT = "product";
        public static final String INDEX_RELATIVE = "page";
        public static final String INDEX_TOPIC = "topic";
        private final Function0<Fragment> createFragment;
        private final String index;
        private String name;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.coolapk.market.view.live.LiveActivity$Tab */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Tab copy$default(Tab tab, String str, String str2, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tab.index;
            }
            if ((i & 2) != 0) {
                str2 = tab.name;
            }
            if ((i & 4) != 0) {
                function0 = tab.createFragment;
            }
            return tab.copy(str, str2, function0);
        }

        public final String component1() {
            return this.index;
        }

        public final String component2() {
            return this.name;
        }

        public final Function0<Fragment> component3() {
            return this.createFragment;
        }

        public final Tab copy(String str, String str2, Function0<? extends Fragment> function0) {
            Intrinsics.checkNotNullParameter(str, "index");
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(function0, "createFragment");
            return new Tab(str, str2, function0);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Tab)) {
                return false;
            }
            Tab tab = (Tab) obj;
            return Intrinsics.areEqual(this.index, tab.index) && Intrinsics.areEqual(this.name, tab.name) && Intrinsics.areEqual(this.createFragment, tab.createFragment);
        }

        public int hashCode() {
            String str = this.index;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.name;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Function0<Fragment> function0 = this.createFragment;
            if (function0 != null) {
                i = function0.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "Tab(index=" + this.index + ", name=" + this.name + ", createFragment=" + this.createFragment + ")";
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/live/LiveActivity$Tab$Companion;", "", "()V", "INDEX_DISCUSS", "", "INDEX_INTRODUCE", "INDEX_LIVE", "INDEX_PRODUCT", "INDEX_RELATIVE", "INDEX_TOPIC", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: LiveActivity.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function0<? extends androidx.fragment.app.Fragment> */
        /* JADX WARN: Multi-variable type inference failed */
        public Tab(String str, String str2, Function0<? extends Fragment> function0) {
            Intrinsics.checkNotNullParameter(str, "index");
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(function0, "createFragment");
            this.index = str;
            this.name = str2;
            this.createFragment = function0;
        }

        public final Function0<Fragment> getCreateFragment() {
            return this.createFragment;
        }

        public final String getIndex() {
            return this.index;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }
    }

    /* access modifiers changed from: private */
    public final void joinIMGroup() {
        LiveViewModel liveViewModel = this.viewModel;
        if (liveViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Live live = liveViewModel.getLive();
        if (live != null) {
            String relationGroupId = live.getRelationGroupId();
            Intrinsics.checkNotNullExpressionValue(relationGroupId, "groupId");
            if (relationGroupId.length() > 0) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new LiveActivity$joinIMGroup$$inlined$let$lambda$1(relationGroupId, null, this), 3, null);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onLoginEvent(LoginSession loginSession) {
        Intrinsics.checkNotNullParameter(loginSession, "session");
        joinIMGroup();
    }
}
