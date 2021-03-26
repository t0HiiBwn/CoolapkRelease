package com.coolapk.market.view.app;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.ImageLoaderOptions;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.binding.TextViewBindingAdapters;
import com.coolapk.market.databinding.AppViewV8Binding;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.ClickInfo;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.MenuCard;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.State;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.model.User;
import com.coolapk.market.network.ClientException;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.RxLogin;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.TintHelper;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.app.AppViewContract;
import com.coolapk.market.view.app.AppViewListFragment;
import com.coolapk.market.view.base.AlphableToolbar;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.feedv8.FakeStatusBarActivity;
import com.coolapk.market.widget.AppExtensionBar;
import com.coolapk.market.widget.CoolMarketURLSpan;
import com.coolapk.market.widget.FastReturnView;
import com.coolapk.market.widget.RoundRectDrawableWithShadow;
import com.coolapk.market.widget.Toast;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Å\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0007*\u0001\u0014\u0018\u0000 X2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002XYB\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u000e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020\u001bJ\n\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\b\u0010#\u001a\u00020\u001bH\u0002J\"\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\"\u0010*\u001a\u00020\u001b2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u0010/\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u001eH\u0016J(\u00102\u001a\u00020\u001b2\u0014\u0010+\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020403\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0012\u00105\u001a\u00020\u001b2\b\u00106\u001a\u0004\u0018\u000107H\u0014J\u001a\u00108\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020\u00102\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020\u001bH\u0014J2\u0010?\u001a\u00020\u001b2\u0006\u0010@\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u00102\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J>\u0010B\u001a\u00020\u001b2\u0006\u0010@\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u00102\u001a\u0010C\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0D\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J1\u0010E\u001a\u00020\u001b2\u0006\u0010@\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u00102\b\u0010+\u001a\u0004\u0018\u00010&2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016¢\u0006\u0002\u0010FJ\u0018\u0010G\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010H\u001a\u00020\u00102\u0006\u0010I\u001a\u00020JH\u0016J\u0010\u0010K\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J>\u0010L\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020&2\u0006\u0010@\u001a\u00020&2\u001a\u0010C\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0D\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u0010M\u001a\u00020\u001b2\u0006\u0010N\u001a\u000207H\u0014J\b\u0010O\u001a\u00020\u001bH\u0014J6\u0010P\u001a\u00020\u001b2\u0006\u0010@\u001a\u00020&2\u001a\u0010C\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0D\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u0010Q\u001a\u00020\u001b2\u0006\u0010R\u001a\u00020SH\u0016J\u0012\u0010T\u001a\u00020\u001b2\b\u0010U\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010V\u001a\u00020\u001bH\u0002J\b\u0010W\u001a\u00020\u001bH\u0002R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0012\u0010\u0016\u001a\u00060\u0017R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/coolapk/market/view/app/AppViewV8Activity;", "Lcom/coolapk/market/view/feedv8/FakeStatusBarActivity;", "Lcom/coolapk/market/view/app/AppViewContract$View;", "Landroid/view/View$OnClickListener;", "Lcom/coolapk/market/widget/AppExtensionBar$Callback;", "Lcom/coolapk/market/view/base/AlphableToolbar;", "()V", "appPackageName", "", "appViewFragment", "Lcom/coolapk/market/view/app/AppViewListFragment;", "binding", "Lcom/coolapk/market/databinding/AppViewV8Binding;", "component", "Lcom/coolapk/market/binding/ContextBindingComponent;", "downloadOrOpenAction", "", "presenter", "Lcom/coolapk/market/view/app/AppViewContract$Presenter;", "stateEventChangedAdapter", "com/coolapk/market/view/app/AppViewV8Activity$stateEventChangedAdapter$1", "Lcom/coolapk/market/view/app/AppViewV8Activity$stateEventChangedAdapter$1;", "thumbnailListener", "Lcom/coolapk/market/view/app/AppViewV8Activity$OnThumbnailListener;", "viewModel", "Lcom/coolapk/market/view/app/AppViewViewModel;", "addAppViewFragment", "", "doActionFunction", "view", "Landroid/view/View;", "doFollowFunction", "doLoadingBgAnim", "getServiceApp", "Lcom/coolapk/market/model/ServiceApp;", "loadThumbnail", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAppLoaded", "result", "Lcom/coolapk/market/network/Result;", "error", "", "onClick", "onCommentClick", "v", "onCommentLoaded", "", "Lcom/coolapk/market/model/Feed;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateMenuTitle", "menuCard", "Lcom/coolapk/market/model/MenuCard;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onDestroy", "onFavoriteAppComplete", "oldValue", "newValue", "onFollowAppComplete", "mapResult", "", "onFollowUserComplete", "(ZZLjava/lang/Integer;Ljava/lang/Throwable;)V", "onMenuClick", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPostClick", "onRatingComplete", "onSaveInstanceState", "outState", "onSetStatusBarColor", "onUnratingComplete", "setToolbarAlpha", "alpha", "", "setToolbarTitle", "title", "shareAppMessage", "updateUI", "Companion", "OnThumbnailListener", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppViewV8Activity.kt */
public final class AppViewV8Activity extends FakeStatusBarActivity implements AppViewContract.View, View.OnClickListener, AppExtensionBar.Callback, AlphableToolbar {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_APP_NAME = "APP_NAME";
    public static final String KEY_DOWNLOAD_OR_OPEN_ACTION = "DOWNLOAD_AUTO";
    public static final String KEY_EXTRA_ANALYSIS_DATA = "EXTRA_ANALYSIS_DATA";
    public static final String KEY_FROM_API = "FROM_API";
    public static final String KEY_LOGO = "LOGO";
    public static final String KEY_PACKAGE_NAME = "PACKAGE_NAME";
    private String appPackageName;
    private AppViewListFragment appViewFragment;
    private AppViewV8Binding binding;
    private ContextBindingComponent component;
    private boolean downloadOrOpenAction;
    private AppViewContract.Presenter presenter = new AppViewPresenter(this);
    private AppViewV8Activity$stateEventChangedAdapter$1 stateEventChangedAdapter = new AppViewV8Activity$stateEventChangedAdapter$1(this);
    private OnThumbnailListener thumbnailListener = new OnThumbnailListener();
    private AppViewViewModel viewModel;

    public static final /* synthetic */ String access$getAppPackageName$p(AppViewV8Activity appViewV8Activity) {
        String str = appViewV8Activity.appPackageName;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appPackageName");
        }
        return str;
    }

    public static final /* synthetic */ AppViewV8Binding access$getBinding$p(AppViewV8Activity appViewV8Activity) {
        AppViewV8Binding appViewV8Binding = appViewV8Activity.binding;
        if (appViewV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return appViewV8Binding;
    }

    public static final /* synthetic */ AppViewViewModel access$getViewModel$p(AppViewV8Activity appViewV8Activity) {
        AppViewViewModel appViewViewModel = appViewV8Activity.viewModel;
        if (appViewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return appViewViewModel;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/app/AppViewV8Activity$Companion;", "", "()V", "KEY_APP_NAME", "", "KEY_DOWNLOAD_OR_OPEN_ACTION", "KEY_EXTRA_ANALYSIS_DATA", "KEY_FROM_API", "KEY_LOGO", "KEY_PACKAGE_NAME", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppViewV8Activity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.base.AlphableToolbar
    public void setToolbarTitle(String str) {
        AppViewV8Binding appViewV8Binding = this.binding;
        if (appViewV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        appViewV8Binding.appBar.setToolbarTitle(str);
    }

    @Override // com.coolapk.market.view.base.AlphableToolbar
    public void setToolbarAlpha(float f) {
        AppViewV8Binding appViewV8Binding = this.binding;
        if (appViewV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        appViewV8Binding.appBar.setBackgroundAlpha(f);
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0081, code lost:
        if (r3 != null) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00aa, code lost:
        if (r10 != null) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x005c, code lost:
        if (r3 != null) goto L_0x00ad;
     */
    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        String str;
        int i = 1;
        setContentBarAlwaysTranslucent(true);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("PACKAGE_NAME");
        String stringExtra2 = getIntent().getStringExtra("EXTRA_ANALYSIS_DATA");
        String stringExtra3 = getIntent().getStringExtra("FROM_API");
        String str2 = "";
        if (TextUtils.isEmpty(stringExtra)) {
            String str3 = null;
            Intent intent = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "intent");
            Uri data = intent.getData();
            if (data != null) {
                String scheme = data.getScheme();
                if (TextUtils.equals("package", scheme)) {
                    stringExtra = data.getPath();
                } else if (TextUtils.equals("market", scheme)) {
                    String host = data.getHost();
                    if (TextUtils.equals("details", host)) {
                        stringExtra = data.getQueryParameter("id");
                    } else if (TextUtils.equals("search", host)) {
                        str = data.getQueryParameter("q");
                        if (str != null && StringsKt.startsWith$default(str, "pname:", false, 2, (Object) null)) {
                            stringExtra = str.substring(6);
                            Intrinsics.checkNotNullExpressionValue(stringExtra, "(this as java.lang.String).substring(startIndex)");
                        }
                    }
                }
                stringExtra = str2;
            }
            str = str3;
            if (!TextUtils.isEmpty(str)) {
                ActionManager.startSuperSearchResultActivity(getActivity(), str, "all", null, null, null);
                finish();
                return;
            } else if (TextUtils.isEmpty(stringExtra)) {
                Toast.show(this, 2131887250);
                finish();
                return;
            }
        }
        if (stringExtra != null) {
            str2 = stringExtra;
        }
        this.appPackageName = str2;
        this.downloadOrOpenAction = getIntent().getBooleanExtra("DOWNLOAD_AUTO", false);
        ContextBindingComponent contextBindingComponent = new ContextBindingComponent(getActivity());
        this.component = contextBindingComponent;
        AppViewV8Activity appViewV8Activity = this;
        if (contextBindingComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("component");
        }
        ViewDataBinding contentView = DataBindingUtil.setContentView(appViewV8Activity, 2131558470, contextBindingComponent);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…t.app_view_v8, component)");
        AppViewV8Binding appViewV8Binding = (AppViewV8Binding) contentView;
        this.binding = appViewV8Binding;
        if (appViewV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TintHelper.setTint(appViewV8Binding.loadingView, AppHolder.getAppTheme().getColorAccent());
        AppViewV8Binding appViewV8Binding2 = this.binding;
        if (appViewV8Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        appViewV8Binding2.appExtensionBar.setCallback(this);
        AppViewV8Binding appViewV8Binding3 = this.binding;
        if (appViewV8Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        appViewV8Binding3.mainContent.addOnInsetChangeListener(new AppViewV8Activity$onCreate$1(this));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        float f = resources.getDisplayMetrics().density;
        AppViewV8Binding appViewV8Binding4 = this.binding;
        if (appViewV8Binding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = appViewV8Binding4.bottomLayout;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.bottomLayout");
        frameLayout.setBackground(new RoundRectDrawableWithShadow(getActivity(), -16777216, 0.0f, ((float) 4) * f, (((float) 5) * f) + ((float) 1)));
        this.presenter.onInitPresenterState(bundle);
        AppViewV8Activity appViewV8Activity2 = this;
        AppViewViewModel appViewViewModel = new AppViewViewModel(appViewV8Activity2, this.presenter);
        this.viewModel = appViewViewModel;
        if (appViewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        appViewViewModel.onInitPresenterState(bundle);
        AppViewV8Binding appViewV8Binding5 = this.binding;
        if (appViewV8Binding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AppViewViewModel appViewViewModel2 = this.viewModel;
        if (appViewViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        appViewV8Binding5.setViewModel(appViewViewModel2);
        String stringExtra4 = getIntent().getStringExtra("LOGO");
        AppViewViewModel appViewViewModel3 = this.viewModel;
        if (appViewViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        appViewViewModel3.setLogo(stringExtra4);
        String stringExtra5 = getIntent().getStringExtra("APP_NAME");
        AppViewViewModel appViewViewModel4 = this.viewModel;
        if (appViewViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        appViewViewModel4.setAppName(stringExtra5);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (T) getSupportFragmentManager().findFragmentById(2131362085);
        if (objectRef.element == null) {
            AppViewListFragment.Companion companion = AppViewListFragment.Companion;
            String str4 = this.appPackageName;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appPackageName");
            }
            objectRef.element = (T) companion.newInstance(str4, stringExtra3);
        }
        T t = objectRef.element;
        Objects.requireNonNull(t, "null cannot be cast to non-null type com.coolapk.market.view.app.AppViewListFragment");
        T t2 = t;
        this.appViewFragment = t2;
        if (t2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appViewFragment");
        }
        t2.setPresenter(this.presenter);
        AppViewListFragment appViewListFragment = this.appViewFragment;
        if (appViewListFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appViewFragment");
        }
        AppViewViewModel appViewViewModel5 = this.viewModel;
        if (appViewViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        appViewListFragment.setViewModel(appViewViewModel5);
        FastReturnView fastReturnView = new FastReturnView(appViewV8Activity2);
        AppViewV8Binding appViewV8Binding6 = this.binding;
        if (appViewV8Binding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout2 = appViewV8Binding6.bottomLayout;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.bottomLayout");
        fastReturnView.dependentAboveOn(frameLayout2);
        fastReturnView.bindFragment(objectRef.element);
        AppViewV8Binding appViewV8Binding7 = this.binding;
        if (appViewV8Binding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        setSupportActionBar(appViewV8Binding7.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        Intrinsics.checkNotNull(supportActionBar);
        supportActionBar.setDisplayShowTitleEnabled(false);
        this.stateEventChangedAdapter.onAttach();
        setToolbarAlpha(0.0f);
        DataManager instance = DataManager.getInstance();
        String str5 = this.appPackageName;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appPackageName");
        }
        MobileApp mobileAppExistFast = instance.getMobileAppExistFast(str5);
        if (mobileAppExistFast != null && mobileAppExistFast.isExist()) {
            String str6 = this.appPackageName;
            if (str6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appPackageName");
            }
            ActionManager.startCheckMobileAppForUpgrade(appViewV8Activity2, str6);
        }
        if (bundle == null || this.presenter.getServiceApp() == null) {
            AppViewContract.Presenter presenter2 = this.presenter;
            String str7 = this.appPackageName;
            if (str7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appPackageName");
            }
            if (mobileAppExistFast == null || !mobileAppExistFast.isExist()) {
                i = 0;
            }
            presenter2.loadApp(str7, i, stringExtra2);
        } else {
            updateUI();
            loadThumbnail();
            doLoadingBgAnim();
        }
        AppViewV8Binding appViewV8Binding8 = this.binding;
        if (appViewV8Binding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewUtil.doubleClickListener(appViewV8Binding8.toolbar, new AppViewV8Activity$onCreate$2(this, objectRef));
        AppViewV8Binding appViewV8Binding9 = this.binding;
        if (appViewV8Binding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = appViewV8Binding9.loadingBgView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.loadingBgView");
        imageView.getViewTreeObserver().addOnGlobalLayoutListener(new AppViewV8Activity$onCreate$3(this));
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        this.presenter.onSaveInstanceState(bundle);
        AppViewViewModel appViewViewModel = this.viewModel;
        if (appViewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        appViewViewModel.onSaveInstanceState(bundle);
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.stateEventChangedAdapter.onDetach();
        this.presenter.cancelLoad();
        this.presenter.cancelLoadComment();
        this.presenter.cancelRating();
        this.presenter.cancelFollowApp();
        super.onDestroy();
    }

    private final void addAppViewFragment() {
        if (getSupportFragmentManager().findFragmentById(2131362085) == null) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            AppViewListFragment appViewListFragment = this.appViewFragment;
            if (appViewListFragment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appViewFragment");
            }
            beginTransaction.add(2131362085, appViewListFragment).commitAllowingStateLoss();
            if (getServiceApp() != null) {
                ServiceApp serviceApp = getServiceApp();
                Intrinsics.checkNotNull(serviceApp);
                if (serviceApp.getCommentStatus() != -1) {
                    AppViewV8Binding appViewV8Binding = this.binding;
                    if (appViewV8Binding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    FrameLayout frameLayout = appViewV8Binding.appViewRecycler;
                    Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.appViewRecycler");
                    ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                    Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = ConvertUtils.dp2px(40.0f);
                }
            }
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(2131623940, menu);
        MenuItem findItem = menu.findItem(2131361961);
        Intrinsics.checkNotNullExpressionValue(findItem, "menu.findItem(R.id.action_search)");
        boolean z = false;
        findItem.setVisible(getServiceApp() != null);
        DataManager instance = DataManager.getInstance();
        String str = this.appPackageName;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appPackageName");
        }
        MobileApp mobileAppExistFast = instance.getMobileAppExistFast(str);
        MenuItem findItem2 = menu.findItem(2131361939);
        Intrinsics.checkNotNullExpressionValue(findItem2, "menu.findItem(R.id.action_open)");
        findItem2.setVisible(mobileAppExistFast != null);
        MenuItem findItem3 = menu.findItem(2131361981);
        Intrinsics.checkNotNullExpressionValue(findItem3, "menu.findItem(R.id.action_uninstall)");
        findItem3.setVisible(mobileAppExistFast != null);
        MenuItem findItem4 = menu.findItem(2131361859);
        Intrinsics.checkNotNullExpressionValue(findItem4, "menu.findItem(R.id.action_apk_manage)");
        DataManager instance2 = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
        LoginSession loginSession = instance2.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        findItem4.setVisible(loginSession.isAdmin());
        MenuItem findItem5 = menu.findItem(2131361905);
        AppViewViewModel appViewViewModel = this.viewModel;
        if (appViewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        findItem5.setTitle(appViewViewModel.isFavor() ? 2131886113 : 2131886131);
        MenuItem findItem6 = menu.findItem(2131361933);
        Intrinsics.checkNotNullExpressionValue(findItem6, "menu.findItem(R.id.action_more_item)");
        findItem6.setVisible(getServiceApp() != null);
        MenuItem findItem7 = menu.findItem(2131361855);
        Intrinsics.checkNotNullExpressionValue(findItem7, "menu.findItem(R.id.action_add_album)");
        ServiceApp serviceApp = getServiceApp();
        findItem7.setVisible(serviceApp != null && serviceApp.getIsDownloadApp() == 1);
        MenuItem findItem8 = menu.findItem(2131361913);
        Intrinsics.checkNotNullExpressionValue(findItem8, "menu.findItem(R.id.action_history)");
        ServiceApp serviceApp2 = getServiceApp();
        findItem8.setVisible(serviceApp2 != null && serviceApp2.getIsDownloadApp() == 1);
        MenuItem findItem9 = menu.findItem(2131361901);
        Intrinsics.checkNotNullExpressionValue(findItem9, "menu.findItem(R.id.action_download_again)");
        ServiceApp serviceApp3 = getServiceApp();
        if (serviceApp3 != null && serviceApp3.getIsDownloadApp() == 1) {
            z = true;
        }
        findItem9.setVisible(z);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        switch (menuItem.getItemId()) {
            case 16908332:
            case 2131362670:
                supportFinishAfterTransition();
                return true;
            case 2131361855:
                ActionManager.doOnLogin(getActivity(), new AppViewV8Activity$onOptionsItemSelected$2(this));
                break;
            case 2131361859:
                BaseActivity activity = getActivity();
                AppViewViewModel appViewViewModel = this.viewModel;
                if (appViewViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                ServiceApp serviceApp = appViewViewModel.getServiceApp();
                Intrinsics.checkNotNull(serviceApp);
                Intrinsics.checkNotNullExpressionValue(serviceApp, "viewModel.serviceApp!!");
                String apkId = serviceApp.getApkId();
                Intrinsics.checkNotNullExpressionValue(apkId, "viewModel.serviceApp!!.apkId");
                ActionManager.startWebViewActivity(activity, UriUtils.getAppManageUrl(apkId));
                return true;
            case 2131361862:
                doActionFunction(null);
                return true;
            case 2131361889:
                if (getServiceApp() != null) {
                    AppCopyDialog newInstance = AppCopyDialog.Companion.newInstance(getServiceApp());
                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    newInstance.show(supportFragmentManager, (String) null);
                }
                return true;
            case 2131361901:
                if (getServiceApp() != null) {
                    ServiceApp serviceApp2 = getServiceApp();
                    Intrinsics.checkNotNull(serviceApp2);
                    if (!TextUtils.isEmpty(serviceApp2.getExtendFile())) {
                        DownloadExtendDialog newInstance2 = DownloadExtendDialog.newInstance(getServiceApp(), true);
                        FragmentManager supportFragmentManager2 = getSupportFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "supportFragmentManager");
                        newInstance2.show(supportFragmentManager2, (String) null);
                    } else {
                        ServiceApp serviceApp3 = getServiceApp();
                        Intrinsics.checkNotNull(serviceApp3);
                        if (serviceApp3.getSupportAndroidVersion() > Build.VERSION.SDK_INT) {
                            VersionLowerAlertDialog newInstance3 = VersionLowerAlertDialog.newInstance(getServiceApp(), 0, 1);
                            FragmentManager supportFragmentManager3 = getSupportFragmentManager();
                            Intrinsics.checkNotNullExpressionValue(supportFragmentManager3, "supportFragmentManager");
                            newInstance3.show(supportFragmentManager3, (String) null);
                        } else {
                            ActionManager.startDownload(this, getServiceApp(), 0, 1);
                        }
                    }
                }
                return true;
            case 2131361905:
                RxLogin.getInstance(getActivity()).requestLogin().subscribe((Subscriber<? super Boolean>) new AppViewV8Activity$onOptionsItemSelected$1(this));
                break;
            case 2131361913:
                ServiceApp serviceApp4 = getServiceApp();
                Intrinsics.checkNotNull(serviceApp4);
                String appName = serviceApp4.getAppName();
                ServiceApp serviceApp5 = getServiceApp();
                Intrinsics.checkNotNull(serviceApp5);
                String apkId2 = serviceApp5.getApkId();
                ServiceApp serviceApp6 = getServiceApp();
                Intrinsics.checkNotNull(serviceApp6);
                ActionManager.startHistoryVersionActivity(this, appName, apkId2, serviceApp6.getLogo());
                break;
            case 2131361939:
                BaseActivity activity2 = getActivity();
                String str = this.appPackageName;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("appPackageName");
                }
                ActionManager.openApp(activity2, str);
                return true;
            case 2131361941:
                AppViewViewModel appViewViewModel2 = this.viewModel;
                if (appViewViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                if (appViewViewModel2.getServiceApp() != null) {
                    AppViewViewModel appViewViewModel3 = this.viewModel;
                    if (appViewViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    ServiceApp serviceApp7 = appViewViewModel3.getServiceApp();
                    Intrinsics.checkNotNull(serviceApp7);
                    Intrinsics.checkNotNullExpressionValue(serviceApp7, "viewModel.serviceApp!!");
                    ActionManager.startExternalMarketByName(getActivity(), null, null, serviceApp7.getPackageName());
                }
                return true;
            case 2131361958:
                BaseActivity activity3 = getActivity();
                AppViewViewModel appViewViewModel4 = this.viewModel;
                if (appViewViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                ServiceApp serviceApp8 = appViewViewModel4.getServiceApp();
                Intrinsics.checkNotNull(serviceApp8);
                Intrinsics.checkNotNullExpressionValue(serviceApp8, "viewModel.serviceApp!!");
                String packageName = serviceApp8.getPackageName();
                Intrinsics.checkNotNull(packageName);
                Intrinsics.checkNotNullExpressionValue(packageName, "viewModel.serviceApp!!.packageName!!");
                ActionManager.startWebViewActivity(activity3, UriUtils.getAppReportUrl(packageName));
                return true;
            case 2131361961:
                AppViewV8Activity appViewV8Activity = this;
                AppViewViewModel appViewViewModel5 = this.viewModel;
                if (appViewViewModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                ServiceApp serviceApp9 = appViewViewModel5.getServiceApp();
                Intrinsics.checkNotNull(serviceApp9);
                Intrinsics.checkNotNullExpressionValue(serviceApp9, "viewModel.serviceApp!!");
                ActionManager.startSceneSearchActivity(appViewV8Activity, "apk", serviceApp9.getApkId());
                return true;
            case 2131361969:
                shareAppMessage();
                return true;
            case 2131361981:
                String str2 = this.appPackageName;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("appPackageName");
                }
                BaseActivity activity4 = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity4, "activity");
                if (TextUtils.equals(str2, activity4.getPackageName())) {
                    BaseActivity activity5 = getActivity();
                    Intrinsics.checkNotNullExpressionValue(activity5, "activity");
                    Toast.show(activity5, 2131887278);
                } else if (getServiceApp() != null) {
                    ServiceApp serviceApp10 = getServiceApp();
                    Intrinsics.checkNotNull(serviceApp10);
                    String packageName2 = serviceApp10.getPackageName();
                    ServiceApp serviceApp11 = getServiceApp();
                    Intrinsics.checkNotNull(serviceApp11);
                    ActionManager.uninstall(this, packageName2, serviceApp11.getAppName());
                }
                return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && intent != null && i == 6666 && intent.getExtras() != null) {
            Bundle extras = intent.getExtras();
            Intrinsics.checkNotNull(extras);
            boolean z = false;
            int i3 = extras.getInt("KEY_DATA", 0);
            AppViewViewModel appViewViewModel = this.viewModel;
            if (appViewViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            boolean isFavor = appViewViewModel.isFavor();
            if (i3 == 1) {
                z = true;
            }
            onFavoriteAppComplete(isFavor, z, null, null);
            AppViewViewModel appViewViewModel2 = this.viewModel;
            if (appViewViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            appViewViewModel2.setFavor(z);
        }
    }

    public final void doLoadingBgAnim() {
        AppViewV8Binding appViewV8Binding = this.binding;
        if (appViewV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = appViewV8Binding.loadingBgView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.loadingBgView");
        if (imageView.getVisibility() == 0) {
            AppViewV8Binding appViewV8Binding2 = this.binding;
            if (appViewV8Binding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ProgressBar progressBar = appViewV8Binding2.loadingView;
            Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
            progressBar.setAlpha(1.0f);
            AppViewV8Binding appViewV8Binding3 = this.binding;
            if (appViewV8Binding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ImageView imageView2 = appViewV8Binding3.loadingBgView;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.loadingBgView");
            imageView2.setAlpha(1.0f);
            AppViewV8Binding appViewV8Binding4 = this.binding;
            if (appViewV8Binding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            FrameLayout frameLayout = appViewV8Binding4.appViewRecycler;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.appViewRecycler");
            frameLayout.setAlpha(0.0f);
            ValueAnimator duration = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(500L);
            duration.addUpdateListener(new AppViewV8Activity$doLoadingBgAnim$$inlined$apply$lambda$1(this));
            duration.addListener(new AppViewV8Activity$doLoadingBgAnim$$inlined$apply$lambda$2(this));
            duration.start();
        }
    }

    private final void shareAppMessage() {
        if (getServiceApp() != null) {
            ActionManager.shareText(this, getServiceApp());
        }
    }

    /* access modifiers changed from: private */
    public final ServiceApp getServiceApp() {
        return this.presenter.getServiceApp();
    }

    @Override // com.coolapk.market.view.app.AppViewContract.View
    public void onAppLoaded(Result<ServiceApp> result, Throwable th) {
        if (getActivity() != null) {
            if (th != null) {
                AppViewV8Binding appViewV8Binding = this.binding;
                if (appViewV8Binding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                ProgressBar progressBar = appViewV8Binding.loadingView;
                Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
                progressBar.setVisibility(8);
                AppViewV8Binding appViewV8Binding2 = this.binding;
                if (appViewV8Binding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                TextView textView = appViewV8Binding2.emptyTextView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.emptyTextView");
                textView.setVisibility(8);
                String str = null;
                String str2 = null;
                if (th instanceof RuntimeException) {
                    if (th.getCause() instanceof ClientException) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            str = cause.getMessage();
                        }
                        str2 = str;
                    }
                } else if (th instanceof ClientException) {
                    str2 = th.getMessage();
                }
                if (str2 != null) {
                    AppViewV8Binding appViewV8Binding3 = this.binding;
                    if (appViewV8Binding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    TextViewBindingAdapters.setTextViewLinkable(appViewV8Binding3.emptyTextView, str2);
                    AppViewV8Binding appViewV8Binding4 = this.binding;
                    if (appViewV8Binding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    TextView textView2 = appViewV8Binding4.emptyTextView;
                    Intrinsics.checkNotNullExpressionValue(textView2, "binding.emptyTextView");
                    CharSequence text = textView2.getText();
                    if (text instanceof SpannableString) {
                        SpannableString spannableString = (SpannableString) text;
                        CoolMarketURLSpan[] coolMarketURLSpanArr = (CoolMarketURLSpan[]) spannableString.getSpans(0, text.length(), CoolMarketURLSpan.class);
                        int i = 0;
                        for (int length = coolMarketURLSpanArr.length; i < length; length = length) {
                            CoolMarketURLSpan coolMarketURLSpan = coolMarketURLSpanArr[i];
                            int spanStart = spannableString.getSpanStart(coolMarketURLSpan);
                            int spanEnd = spannableString.getSpanEnd(coolMarketURLSpan);
                            int spanFlags = spannableString.getSpanFlags(coolMarketURLSpan);
                            spannableString.removeSpan(coolMarketURLSpan);
                            Intrinsics.checkNotNullExpressionValue(coolMarketURLSpan, "span");
                            spannableString.setSpan(new AppViewV8Activity$onAppLoaded$1(this, coolMarketURLSpan, coolMarketURLSpan.getURL(), AppHolder.getAppTheme().getColorAccent(), false), spanStart, spanEnd, spanFlags);
                            i++;
                            coolMarketURLSpanArr = coolMarketURLSpanArr;
                        }
                        AppViewV8Binding appViewV8Binding5 = this.binding;
                        if (appViewV8Binding5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        TextView textView3 = appViewV8Binding5.emptyTextView;
                        Intrinsics.checkNotNullExpressionValue(textView3, "binding.emptyTextView");
                        textView3.setText(text);
                        AppViewV8Binding appViewV8Binding6 = this.binding;
                        if (appViewV8Binding6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        TextView textView4 = appViewV8Binding6.emptyTextView;
                        Intrinsics.checkNotNullExpressionValue(textView4, "binding.emptyTextView");
                        textView4.setVisibility(0);
                        return;
                    }
                    return;
                }
                Toast.error(getActivity(), th);
                return;
            }
            String stringExtra = getIntent().getStringExtra("LOGO");
            AppViewViewModel appViewViewModel = this.viewModel;
            if (appViewViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            if (!TextUtils.equals(stringExtra, appViewViewModel.getLogo())) {
                AppViewViewModel appViewViewModel2 = this.viewModel;
                if (appViewViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                ServiceApp serviceApp = getServiceApp();
                Intrinsics.checkNotNull(serviceApp);
                appViewViewModel2.setLogo(serviceApp.getLogo());
            }
            String stringExtra2 = getIntent().getStringExtra("APP_NAME");
            AppViewViewModel appViewViewModel3 = this.viewModel;
            if (appViewViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            if (!TextUtils.equals(stringExtra2, appViewViewModel3.getAppName())) {
                AppViewViewModel appViewViewModel4 = this.viewModel;
                if (appViewViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                ServiceApp serviceApp2 = getServiceApp();
                Intrinsics.checkNotNull(serviceApp2);
                appViewViewModel4.setAppName(serviceApp2.getAppName());
            }
            updateUI();
            loadThumbnail();
            addAppViewFragment();
            doLoadingBgAnim();
        }
    }

    private final void loadThumbnail() {
        if (this.presenter.getServiceApp() != null) {
            ServiceApp serviceApp = this.presenter.getServiceApp();
            Intrinsics.checkNotNull(serviceApp);
            if (!CollectionUtils.isEmpty(serviceApp.getThumbList())) {
                ServiceApp serviceApp2 = this.presenter.getServiceApp();
                Intrinsics.checkNotNull(serviceApp2);
                List<String> thumbList = serviceApp2.getThumbList();
                Intrinsics.checkNotNull(thumbList);
                for (String str : thumbList) {
                    AppHolder.getContextImageLoader().displayImage((Context) this, str, (ImageView) null, ImageLoaderOptions.newBuilder().placeHolderRes(2131231702).loadSource(true).build(), (OnImageLoadListener) this.thumbnailListener, (OnBitmapTransformListener) null);
                }
            }
        }
    }

    @Override // com.coolapk.market.view.app.AppViewContract.View
    public void onCommentLoaded(Result<List<Feed>> result, Throwable th) {
        if (th != null) {
            Toast.error(getActivity(), th);
        }
    }

    @Override // com.coolapk.market.view.app.AppViewContract.View
    public void onRatingComplete(int i, int i2, Result<Map<String, String>> result, Throwable th) {
        if (th != null) {
            AppViewViewModel appViewViewModel = this.viewModel;
            if (appViewViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            appViewViewModel.setMyScore(i2);
            Toast.error(getActivity(), th);
        } else if (result != null) {
            AppViewViewModel appViewViewModel2 = this.viewModel;
            if (appViewViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            appViewViewModel2.setScore(result.getData().get("score"));
            AppViewViewModel appViewViewModel3 = this.viewModel;
            if (appViewViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            String str = result.getData().get("votenum");
            Intrinsics.checkNotNull(str);
            int parseInt = Integer.parseInt(str);
            String str2 = result.getData().get("votenum1");
            Intrinsics.checkNotNull(str2);
            String str3 = result.getData().get("votenum2");
            Intrinsics.checkNotNull(str3);
            String str4 = result.getData().get("votenum3");
            Intrinsics.checkNotNull(str4);
            String str5 = result.getData().get("votenum4");
            Intrinsics.checkNotNull(str5);
            String str6 = result.getData().get("votenum5");
            Intrinsics.checkNotNull(str6);
            appViewViewModel3.setVoteNums(parseInt, new int[]{Integer.parseInt(str2), Integer.parseInt(str3), Integer.parseInt(str4), Integer.parseInt(str5), Integer.parseInt(str6)});
            BaseActivity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            Toast.show(activity, 2131887008);
        }
    }

    @Override // com.coolapk.market.view.app.AppViewContract.View
    public void onUnratingComplete(int i, Result<Map<String, String>> result, Throwable th) {
        if (th != null) {
            AppViewViewModel appViewViewModel = this.viewModel;
            if (appViewViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            appViewViewModel.setMyScore(i);
            Toast.error(getActivity(), th);
        } else if (result != null) {
            AppViewViewModel appViewViewModel2 = this.viewModel;
            if (appViewViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            appViewViewModel2.setScore(result.getData().get("score"));
            AppViewViewModel appViewViewModel3 = this.viewModel;
            if (appViewViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            String str = result.getData().get("votenum");
            Intrinsics.checkNotNull(str);
            int parseInt = Integer.parseInt(str);
            String str2 = result.getData().get("votenum1");
            Intrinsics.checkNotNull(str2);
            String str3 = result.getData().get("votenum2");
            Intrinsics.checkNotNull(str3);
            String str4 = result.getData().get("votenum3");
            Intrinsics.checkNotNull(str4);
            String str5 = result.getData().get("votenum4");
            Intrinsics.checkNotNull(str5);
            String str6 = result.getData().get("votenum5");
            Intrinsics.checkNotNull(str6);
            appViewViewModel3.setVoteNums(parseInt, new int[]{Integer.parseInt(str2), Integer.parseInt(str3), Integer.parseInt(str4), Integer.parseInt(str5), Integer.parseInt(str6)});
            BaseActivity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            Toast.show(activity, 2131887114);
        }
    }

    @Override // com.coolapk.market.view.app.AppViewContract.View
    public void onFollowAppComplete(boolean z, boolean z2, Result<Map<String, String>> result, Throwable th) {
        if (th != null) {
            AppViewViewModel appViewViewModel = this.viewModel;
            if (appViewViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            appViewViewModel.setFollowApp(z);
            Toast.error(getActivity(), th);
            return;
        }
        AppViewViewModel appViewViewModel2 = this.viewModel;
        if (appViewViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        appViewViewModel2.setFollowApp(z2);
        if (z2) {
            BaseActivity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            Toast.show(activity, 2131886877);
            return;
        }
        BaseActivity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        Toast.show(activity2, 2131887109);
    }

    @Override // com.coolapk.market.view.app.AppViewContract.View
    public void onFavoriteAppComplete(boolean z, boolean z2, Result<Integer> result, Throwable th) {
        if (th != null) {
            AppViewViewModel appViewViewModel = this.viewModel;
            if (appViewViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            appViewViewModel.setFavor(z);
            Toast.error(getActivity(), th);
        } else {
            AppViewViewModel appViewViewModel2 = this.viewModel;
            if (appViewViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            appViewViewModel2.setFavor(z2);
        }
        invalidateOptionsMenu();
    }

    @Override // com.coolapk.market.view.app.AppViewContract.View
    public void onFollowUserComplete(boolean z, boolean z2, Integer num, Throwable th) {
        if (th != null) {
            AppViewViewModel appViewViewModel = this.viewModel;
            if (appViewViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            appViewViewModel.setFollowDeveloper(z);
            Toast.error(getActivity(), th);
            return;
        }
        AppViewViewModel appViewViewModel2 = this.viewModel;
        if (appViewViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        appViewViewModel2.setFollowDeveloper(z2);
        if (z2) {
            BaseActivity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            Toast.show(activity, 2131886877);
            return;
        }
        BaseActivity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        Toast.show(activity2, 2131887109);
    }

    private final void updateUI() {
        if (getActivity() != null) {
            AppViewViewModel appViewViewModel = this.viewModel;
            if (appViewViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            appViewViewModel.updateServiceApp();
            invalidateOptionsMenu();
            if (getServiceApp() != null && this.downloadOrOpenAction) {
                this.downloadOrOpenAction = false;
                AppViewV8Activity appViewV8Activity = this;
                Toast.show(appViewV8Activity, 2131887256);
                DataManager instance = DataManager.getInstance();
                String str = this.appPackageName;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("appPackageName");
                }
                if (instance.getMobileAppExistFast(str) != null) {
                    String str2 = this.appPackageName;
                    if (str2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("appPackageName");
                    }
                    ActionManager.openApp(appViewV8Activity, str2);
                    return;
                }
                ServiceApp serviceApp = getServiceApp();
                Intrinsics.checkNotNull(serviceApp);
                if (serviceApp.getSupportAndroidVersion() > Build.VERSION.SDK_INT) {
                    VersionLowerAlertDialog newInstance = VersionLowerAlertDialog.newInstance(getServiceApp(), 0, 0);
                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    newInstance.show(supportFragmentManager, (String) null);
                    return;
                }
                ActionManager.startDownload(appViewV8Activity, getServiceApp(), 0);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (getServiceApp() != null) {
            switch (view.getId()) {
                case 2131361887:
                case 2131361982:
                case 2131361984:
                    doActionFunction(view);
                    return;
                case 2131362090:
                    ActionManager.startAppDetailActivity(this, getServiceApp());
                    return;
                case 2131362289:
                    ActionManager.startAppCommentActivity(this, getServiceApp(), null);
                    return;
                case 2131362296:
                    AppViewV8Binding appViewV8Binding = this.binding;
                    if (appViewV8Binding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    appViewV8Binding.appBar.setExpanded(false, false);
                    AppViewListFragment appViewListFragment = this.appViewFragment;
                    if (appViewListFragment == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("appViewFragment");
                    }
                    appViewListFragment.scrollToComment();
                    return;
                case 2131362590:
                    doFollowFunction(view);
                    return;
                case 2131362665:
                    ServiceApp serviceApp = getServiceApp();
                    Intrinsics.checkNotNull(serviceApp);
                    String appName = serviceApp.getAppName();
                    ServiceApp serviceApp2 = getServiceApp();
                    Intrinsics.checkNotNull(serviceApp2);
                    String apkId = serviceApp2.getApkId();
                    ServiceApp serviceApp3 = getServiceApp();
                    Intrinsics.checkNotNull(serviceApp3);
                    ActionManager.startHistoryVersionActivity(this, appName, apkId, serviceApp3.getLogo());
                    return;
                default:
                    return;
            }
        }
    }

    public final void doFollowFunction(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        RxLogin.getInstance(getActivity()).requestLogin().subscribe((Subscriber<? super Boolean>) new AppViewV8Activity$doFollowFunction$1(this));
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0050: APUT  (r4v0 java.lang.String[]), (2 ??[int, float, short, byte, char]), (r5v4 java.lang.String) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0112: APUT  (r3v3 java.lang.String[]), (2 ??[int, float, short, byte, char]), (r4v11 java.lang.String) */
    public final void doActionFunction(View view) {
        String str = null;
        UpgradeInfo upgradeInfo = null;
        DataManager instance = DataManager.getInstance();
        ServiceApp serviceApp = getServiceApp();
        Intrinsics.checkNotNull(serviceApp);
        MobileApp mobileAppExistFast = instance.getMobileAppExistFast(serviceApp.getPackageName());
        if (mobileAppExistFast != null) {
            upgradeInfo = mobileAppExistFast.getUpgradeInfo();
        }
        ServiceApp serviceApp2 = getServiceApp();
        Intrinsics.checkNotNull(serviceApp2);
        String packageName = serviceApp2.getPackageName();
        String[] strArr = new String[4];
        ServiceApp serviceApp3 = getServiceApp();
        Intrinsics.checkNotNull(serviceApp3);
        strArr[0] = serviceApp3.getDownloadUrlMd5(0);
        ServiceApp serviceApp4 = getServiceApp();
        Intrinsics.checkNotNull(serviceApp4);
        strArr[1] = serviceApp4.getDownloadUrlMd5(2);
        strArr[2] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(0) : null;
        strArr[3] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(1) : null;
        State findLatestState = StateUtils.findLatestState(packageName, strArr);
        if (findLatestState == null || ((findLatestState instanceof DownloadState) && ((DownloadState) findLatestState).getState() == 0)) {
            ServiceApp serviceApp5 = getServiceApp();
            Intrinsics.checkNotNull(serviceApp5);
            if (!TextUtils.isEmpty(serviceApp5.getExtendFile())) {
                DownloadExtendDialog newInstance = DownloadExtendDialog.newInstance(getServiceApp(), false);
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                newInstance.show(supportFragmentManager, (String) null);
                return;
            }
            ServiceApp serviceApp6 = getServiceApp();
            Intrinsics.checkNotNull(serviceApp6);
            if (serviceApp6.getSupportAndroidVersion() > Build.VERSION.SDK_INT) {
                VersionLowerAlertDialog newInstance2 = VersionLowerAlertDialog.newInstance(getServiceApp(), 0, 0);
                FragmentManager supportFragmentManager2 = getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "supportFragmentManager");
                newInstance2.show(supportFragmentManager2, (String) null);
                return;
            }
        }
        ClickInfo.Builder newBuilder = ClickInfo.newBuilder(getServiceApp());
        ServiceApp serviceApp7 = getServiceApp();
        Intrinsics.checkNotNull(serviceApp7);
        ClickInfo.Builder packageName2 = newBuilder.packageName(serviceApp7.getPackageName());
        ServiceApp serviceApp8 = getServiceApp();
        Intrinsics.checkNotNull(serviceApp8);
        ClickInfo.Builder targetUrl = packageName2.targetUrl(serviceApp8.getDownloadUrl(0));
        ServiceApp serviceApp9 = getServiceApp();
        Intrinsics.checkNotNull(serviceApp9);
        ClickInfo.Builder uninstallKey = targetUrl.uninstallKey(serviceApp9.getPackageName());
        String[] strArr2 = new String[4];
        ServiceApp serviceApp10 = getServiceApp();
        Intrinsics.checkNotNull(serviceApp10);
        strArr2[0] = serviceApp10.getDownloadUrlMd5(0);
        ServiceApp serviceApp11 = getServiceApp();
        Intrinsics.checkNotNull(serviceApp11);
        strArr2[1] = serviceApp11.getDownloadUrlMd5(2);
        strArr2[2] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(0) : null;
        if (upgradeInfo != null) {
            str = upgradeInfo.getDownloadUrlMd5(1);
        }
        strArr2[3] = str;
        StateUtils.handleClick(getActivity(), uninstallKey.downloadKeys(strArr2).build(), view);
    }

    @Override // com.coolapk.market.widget.AppExtensionBar.Callback
    public void onPostClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ActionManager.startAppCommentActivity(this, getServiceApp(), null);
    }

    @Override // com.coolapk.market.widget.AppExtensionBar.Callback
    public void onCommentClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        AppViewV8Binding appViewV8Binding = this.binding;
        if (appViewV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        appViewV8Binding.appBar.setExpanded(false, false);
        AppViewListFragment appViewListFragment = this.appViewFragment;
        if (appViewListFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appViewFragment");
        }
        appViewListFragment.scrollToComment();
    }

    @Override // com.coolapk.market.widget.AppExtensionBar.Callback
    public void onMenuClick(View view, MenuCard menuCard) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(menuCard, "menuCard");
        if (TextUtils.equals(menuCard.getUrl(), "#/apk/moreDetail")) {
            ActionManager.startAppDetailActivity(this, getServiceApp());
        } else if (TextUtils.equals(menuCard.getUrl(), "#/apk/commentBar")) {
            AppViewV8Binding appViewV8Binding = this.binding;
            if (appViewV8Binding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            appViewV8Binding.appBar.setExpanded(false, false);
            AppViewListFragment appViewListFragment = this.appViewFragment;
            if (appViewListFragment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appViewFragment");
            }
            appViewListFragment.scrollToComment();
        } else if (TextUtils.equals(menuCard.getUrl(), "#/apk/relatedAppList")) {
            BaseActivity activity = getActivity();
            AppViewViewModel appViewViewModel = this.viewModel;
            if (appViewViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            ServiceApp serviceApp = appViewViewModel.getServiceApp();
            Intrinsics.checkNotNull(serviceApp);
            Intrinsics.checkNotNullExpressionValue(serviceApp, "viewModel.serviceApp!!");
            ActionManager.startRelatedAppsActivity(activity, serviceApp.getKeywords());
        } else if (TextUtils.equals(menuCard.getUrl(), "#/apk/relatedAlbumList")) {
            BaseActivity activity2 = getActivity();
            AppViewViewModel appViewViewModel2 = this.viewModel;
            if (appViewViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            ServiceApp serviceApp2 = appViewViewModel2.getServiceApp();
            Intrinsics.checkNotNull(serviceApp2);
            Intrinsics.checkNotNullExpressionValue(serviceApp2, "viewModel.serviceApp!!");
            ActionManager.startRelatedAlbumsActivity(activity2, serviceApp2.getAppFullName());
        } else if (TextUtils.equals(menuCard.getUrl(), "#/apk/relatedDeveloperAppList")) {
            BaseActivity activity3 = getActivity();
            AppViewViewModel appViewViewModel3 = this.viewModel;
            if (appViewViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            ServiceApp serviceApp3 = appViewViewModel3.getServiceApp();
            Intrinsics.checkNotNull(serviceApp3);
            Intrinsics.checkNotNullExpressionValue(serviceApp3, "viewModel.serviceApp!!");
            ActionManager.startDeveloperAppsActivity(activity3, serviceApp3.getDeveloperName());
        } else if (TextUtils.equals(menuCard.getUrl(), "#/user/atDeveloper")) {
            ServiceApp serviceApp4 = getServiceApp();
            StringBuilder sb = new StringBuilder();
            sb.append("@");
            ServiceApp serviceApp5 = getServiceApp();
            Intrinsics.checkNotNull(serviceApp5);
            User developerProfile = serviceApp5.getDeveloperProfile();
            Intrinsics.checkNotNull(developerProfile);
            Intrinsics.checkNotNullExpressionValue(developerProfile, "getServiceApp()!!.developerProfile!!");
            sb.append(developerProfile.getUserName());
            sb.append(" ");
            ActionManager.startAppCommentActivity(getActivity(), serviceApp4, sb.toString());
        } else if (TextUtils.equals(menuCard.getUrl(), "#/user/messageToDeveloper")) {
            ServiceApp serviceApp6 = getServiceApp();
            Intrinsics.checkNotNull(serviceApp6);
            User developerProfile2 = serviceApp6.getDeveloperProfile();
            Intrinsics.checkNotNull(developerProfile2);
            Intrinsics.checkNotNullExpressionValue(developerProfile2, "getServiceApp()!!.developerProfile!!");
            String uid = developerProfile2.getUid();
            ServiceApp serviceApp7 = getServiceApp();
            Intrinsics.checkNotNull(serviceApp7);
            User developerProfile3 = serviceApp7.getDeveloperProfile();
            Intrinsics.checkNotNull(developerProfile3);
            Intrinsics.checkNotNullExpressionValue(developerProfile3, "getServiceApp()!!.developerProfile!!");
            ActionManager.startChattingActivity(getActivity(), uid, developerProfile3.getUserName());
        } else if (TextUtils.equals(menuCard.getUrl(), "#/user/followDeveloper")) {
            RxLogin.getInstance(getActivity()).requestLogin().subscribe((Subscriber<? super Boolean>) new AppViewV8Activity$onMenuClick$1(this));
        } else {
            ActionManagerCompat.startActivityByUrl(this, menuCard.getUrl(), menuCard.getTitle(), menuCard.getSubTitle());
        }
    }

    @Override // com.coolapk.market.widget.AppExtensionBar.Callback
    public String onCreateMenuTitle(View view, MenuCard menuCard) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(menuCard, "menuCard");
        if (!TextUtils.equals(menuCard.getUrl(), "#/user/followDeveloper")) {
            return null;
        }
        AppViewViewModel appViewViewModel = this.viewModel;
        if (appViewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return getString(appViewViewModel.isFollowDeveloper() ? 2131886114 : 2131886134);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/app/AppViewV8Activity$OnThumbnailListener;", "Lcom/coolapk/market/app/OnImageLoadListener;", "(Lcom/coolapk/market/view/app/AppViewV8Activity;)V", "onLoadComplete", "", "uri", "", "drawable", "Landroid/graphics/drawable/Drawable;", "view", "Landroid/view/View;", "isFromMemory", "", "error", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppViewV8Activity.kt */
    private final class OnThumbnailListener implements OnImageLoadListener {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public OnThumbnailListener() {
        }

        @Override // com.coolapk.market.app.OnImageLoadListener
        public void onLoadComplete(String str, Drawable drawable, View view, boolean z, Throwable th) {
            Intrinsics.checkNotNullParameter(str, "uri");
            if (drawable != null) {
                try {
                    AppViewV8Activity.access$getViewModel$p(AppViewV8Activity.this).setThumbnailSize(str, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                AppViewV8Activity.access$getViewModel$p(AppViewV8Activity.this).setThumbnailSize(str, 0, 0);
            }
        }
    }
}
