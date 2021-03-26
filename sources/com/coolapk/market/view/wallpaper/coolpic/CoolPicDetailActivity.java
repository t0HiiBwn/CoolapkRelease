package com.coolapk.market.view.wallpaper.coolpic;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import com.coolapk.market.app.TranslucentActivity;
import com.coolapk.market.databinding.CoolPicFullScreenBinding;
import com.coolapk.market.manager.AppPictureSizeManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.feedv8.FakeStatusBarActivity;
import com.coolapk.market.widget.view.SwipeScaleView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0007J\b\u0010\u001d\u001a\u00020\tH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u0012\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020\u001fH\u0014J\b\u0010$\u001a\u00020\u001fH\u0002J\b\u0010%\u001a\u00020\u001fH\u0014J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u0012H\u0014J\u0010\u0010(\u001a\u00020\u001f2\b\b\u0002\u0010)\u001a\u00020\u0007J\u0006\u0010*\u001a\u00020\u001fJ\b\u0010+\u001a\u00020\u001fH\u0002J6\u0010,\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010-\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/coolapk/market/view/wallpaper/coolpic/CoolPicDetailActivity;", "Lcom/coolapk/market/view/feedv8/FakeStatusBarActivity;", "Lcom/coolapk/market/app/TranslucentActivity;", "()V", "binding", "Lcom/coolapk/market/databinding/CoolPicFullScreenBinding;", "direction", "", "donotCompress", "", "getDonotCompress", "()Z", "setDonotCompress", "(Z)V", "feed", "Lcom/coolapk/market/model/Feed;", "id", "index", "", "isLoading", "listIndex", "listType", "params", "subscription", "Lrx/Subscription;", "getFragment", "Lcom/coolapk/market/view/wallpaper/coolpic/CoolPicListFragment;", "isCompressUrl", "source", "isNavigationBarTranslucent", "loadFeedInfo", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEmptyViewClick", "onSetStatusBarColor", "onSetStatusBarDarkMode", "delay", "setLoadingError", "errorText", "setLoadingFinished", "setLoadingStart", "setupFragment", "picIndex", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolPicDetailActivity.kt */
public final class CoolPicDetailActivity extends FakeStatusBarActivity implements TranslucentActivity {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_DIRECTION = "direction";
    public static final String KEY_FEED = "feed";
    public static final String KEY_ID = "id";
    public static final String KEY_INDEX = "index";
    public static final String KEY_LIST = "dataList";
    public static final String KEY_LIST_INDEX = "list_index";
    public static final String KEY_LIST_TYPE = "listType";
    public static final String KEY_PARAMS = "params";
    public static final int REQUEST_CODE = 66666;
    private CoolPicFullScreenBinding binding;
    private String direction;
    private boolean donotCompress;
    private Feed feed;
    private String id;
    private int index;
    private boolean isLoading;
    private int listIndex;
    private String listType;
    private String params;
    private Subscription subscription;

    @Override // com.coolapk.market.app.TranslucentActivity
    public boolean isNavigationBarTranslucent() {
        return false;
    }

    public static final /* synthetic */ CoolPicFullScreenBinding access$getBinding$p(CoolPicDetailActivity coolPicDetailActivity) {
        CoolPicFullScreenBinding coolPicFullScreenBinding = coolPicDetailActivity.binding;
        if (coolPicFullScreenBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return coolPicFullScreenBinding;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/wallpaper/coolpic/CoolPicDetailActivity$Companion;", "", "()V", "KEY_DIRECTION", "", "KEY_FEED", "KEY_ID", "KEY_INDEX", "KEY_LIST", "KEY_LIST_INDEX", "KEY_LIST_TYPE", "KEY_PARAMS", "REQUEST_CODE", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CoolPicDetailActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final boolean getDonotCompress() {
        return this.donotCompress;
    }

    public final void setDonotCompress(boolean z) {
        this.donotCompress = z;
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        setContentBarAlwaysTranslucent(true);
        super.onCreate(bundle);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        Bundle extras = intent.getExtras();
        String str = null;
        String string = extras != null ? extras.getString("listType") : null;
        if (string == null) {
            string = "list";
        }
        this.listType = string;
        Intent intent2 = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent2, "intent");
        Bundle extras2 = intent2.getExtras();
        String string2 = extras2 != null ? extras2.getString("direction") : null;
        if (string2 == null) {
            string2 = "old";
        }
        this.direction = string2;
        Intent intent3 = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent3, "intent");
        Bundle extras3 = intent3.getExtras();
        String string3 = extras3 != null ? extras3.getString("params") : null;
        if (string3 == null) {
            string3 = "";
        }
        this.params = string3;
        this.feed = (Feed) getIntent().getParcelableExtra("feed");
        this.id = getIntent().getStringExtra("id");
        this.index = getIntent().getIntExtra("index", 0);
        this.listIndex = getIntent().getIntExtra("list_index", 0);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, 2131558487);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…out.cool_pic_full_screen)");
        this.binding = (CoolPicFullScreenBinding) contentView;
        if (this.feed != null || TextUtils.isEmpty(this.id)) {
            Feed feed2 = this.feed;
            if (feed2 != null) {
                str = feed2.getId();
            }
            Intrinsics.checkNotNull(str);
            Intrinsics.checkNotNullExpressionValue(str, "feed?.id!!");
            loadFeedInfo(str);
        } else {
            String str2 = this.id;
            Intrinsics.checkNotNull(str2);
            loadFeedInfo(str2);
        }
        CoolPicFullScreenBinding coolPicFullScreenBinding = this.binding;
        if (coolPicFullScreenBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        coolPicFullScreenBinding.contentView.addOnInsetChangeListener(new CoolPicDetailActivity$onCreate$4(this));
        CoolPicFullScreenBinding coolPicFullScreenBinding2 = this.binding;
        if (coolPicFullScreenBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        SwipeScaleView swipeScaleView = coolPicFullScreenBinding2.swipeScaleView;
        Intrinsics.checkNotNullExpressionValue(swipeScaleView, "binding.swipeScaleView");
        swipeScaleView.setOnGestureListener(new CoolPicDetailActivity$onCreate$5(this));
        swipeScaleView.setOnSwipeListener(new CoolPicDetailActivity$onCreate$6(this));
        StatisticHelper.Companion.getInstance().recordFeedClickAction("酷图");
    }

    public final boolean isCompressUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "source");
        AppPictureSizeManager.PictureSize size = AppPictureSizeManager.getInstance().getSize(str);
        if (size == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(size, "AppPictureSizeManager.ge…e(source) ?: return false");
        int height = size.getHeight();
        int width = size.getWidth();
        BaseActivity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        Resources resources = activity.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "activity.resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (!(((float) Math.max(height, width)) >= ((float) Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels)) * 2.0f || ((float) Math.min(height, width)) >= ((float) Math.min(displayMetrics.heightPixels, displayMetrics.widthPixels)) * 2.0f) || this.donotCompress) {
            return false;
        }
        return true;
    }

    public final CoolPicListFragment getFragment() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(2131362318);
        if (!(findFragmentById instanceof CoolPicListFragment)) {
            findFragmentById = null;
        }
        return (CoolPicListFragment) findFragmentById;
    }

    static /* synthetic */ void setupFragment$default(CoolPicDetailActivity coolPicDetailActivity, Feed feed2, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "list";
        }
        if ((i2 & 4) != 0) {
            str2 = "old";
        }
        coolPicDetailActivity.setupFragment(feed2, str, str2, str3, (i2 & 16) != 0 ? 0 : i);
    }

    /* access modifiers changed from: private */
    public final void setupFragment(Feed feed2, String str, String str2, String str3, int i) {
        CoolPicListFragment findFragmentById = getSupportFragmentManager().findFragmentById(2131362318);
        if (findFragmentById == null) {
            findFragmentById = CoolPicListFragment.Companion.newInstance(feed2, str, str2, str3, i, this.listIndex);
        }
        if (findFragmentById != null && !findFragmentById.isAdded()) {
            getSupportFragmentManager().beginTransaction().add(2131362318, findFragmentById).commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Subscription subscription2 = this.subscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        this.subscription = null;
    }

    private final void loadFeedInfo(String str) {
        if (!this.isLoading) {
            setLoadingStart();
            this.subscription = DataManager.getInstance().getFeedDetail(str, "", "", "").compose(RxUtils.apiCommonToData()).compose(RxUtils.retryWhenEmitNull()).subscribe((Subscriber<? super R>) new CoolPicDetailActivity$loadFeedInfo$1(this));
        }
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarDarkMode(int i) {
        ThemeUtils.setDarkStatusIconBar(getActivity(), false, i);
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    private final void setLoadingStart() {
        CoolPicFullScreenBinding coolPicFullScreenBinding = this.binding;
        if (coolPicFullScreenBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = coolPicFullScreenBinding.loadingContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingContainer");
        frameLayout.setVisibility(0);
        CoolPicFullScreenBinding coolPicFullScreenBinding2 = this.binding;
        if (coolPicFullScreenBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ProgressBar progressBar = coolPicFullScreenBinding2.loadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
        progressBar.setVisibility(0);
        CoolPicFullScreenBinding coolPicFullScreenBinding3 = this.binding;
        if (coolPicFullScreenBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = coolPicFullScreenBinding3.hintView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.hintView");
        textView.setVisibility(8);
        this.isLoading = true;
    }

    public final void setLoadingFinished() {
        CoolPicFullScreenBinding coolPicFullScreenBinding = this.binding;
        if (coolPicFullScreenBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ProgressBar progressBar = coolPicFullScreenBinding.loadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
        progressBar.setVisibility(8);
        CoolPicFullScreenBinding coolPicFullScreenBinding2 = this.binding;
        if (coolPicFullScreenBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = coolPicFullScreenBinding2.hintView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.hintView");
        textView.setVisibility(8);
        CoolPicFullScreenBinding coolPicFullScreenBinding3 = this.binding;
        if (coolPicFullScreenBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(coolPicFullScreenBinding3.loadingContainer, View.ALPHA, 1.0f, 0.0f);
        ofFloat.addListener(new CoolPicDetailActivity$setLoadingFinished$$inlined$also$lambda$1(this));
        ofFloat.start();
    }

    public static /* synthetic */ void setLoadingError$default(CoolPicDetailActivity coolPicDetailActivity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        coolPicDetailActivity.setLoadingError(str);
    }

    public final void setLoadingError(String str) {
        Intrinsics.checkNotNullParameter(str, "errorText");
        CoolPicFullScreenBinding coolPicFullScreenBinding = this.binding;
        if (coolPicFullScreenBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = coolPicFullScreenBinding.loadingContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingContainer");
        frameLayout.setVisibility(0);
        CoolPicFullScreenBinding coolPicFullScreenBinding2 = this.binding;
        if (coolPicFullScreenBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ProgressBar progressBar = coolPicFullScreenBinding2.loadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
        progressBar.setVisibility(8);
        CoolPicFullScreenBinding coolPicFullScreenBinding3 = this.binding;
        if (coolPicFullScreenBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = coolPicFullScreenBinding3.hintView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.hintView");
        textView.setVisibility(0);
        CoolPicFullScreenBinding coolPicFullScreenBinding4 = this.binding;
        if (coolPicFullScreenBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView2 = coolPicFullScreenBinding4.hintView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.hintView");
        textView2.setText(str);
        CoolPicFullScreenBinding coolPicFullScreenBinding5 = this.binding;
        if (coolPicFullScreenBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        coolPicFullScreenBinding5.loadingContainer.setOnClickListener(new CoolPicDetailActivity$setLoadingError$1(this));
        this.isLoading = false;
    }

    /* access modifiers changed from: private */
    public final void onEmptyViewClick() {
        if (this.feed != null || TextUtils.isEmpty(this.id)) {
            Feed feed2 = this.feed;
            String id2 = feed2 != null ? feed2.getId() : null;
            Intrinsics.checkNotNull(id2);
            Intrinsics.checkNotNullExpressionValue(id2, "feed?.id!!");
            loadFeedInfo(id2);
            return;
        }
        String str = this.id;
        Intrinsics.checkNotNull(str);
        loadFeedInfo(str);
    }
}
