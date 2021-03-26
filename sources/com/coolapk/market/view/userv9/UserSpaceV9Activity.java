package com.coolapk.market.view.userv9;

import android.animation.FloatEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.ImageLoaderOptions;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.app.TranslucentActivity;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.ItemUserInfoPartBinding;
import com.coolapk.market.databinding.UserSpaceV9Binding;
import com.coolapk.market.event.AlbumDeleteEvent;
import com.coolapk.market.event.FeedDeleteEvent;
import com.coolapk.market.event.UserBlockedEvent;
import com.coolapk.market.event.UserProfileEvent;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideContextImageLoader;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.base.MultiItemDialogFragment;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.IgnoreInsetFrameLayout;
import com.coolapk.market.widget.view.TabLayout;
import com.google.android.material.appbar.AppBarLayout;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.Subscribe;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 P2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002OPB\u0005¢\u0006\u0002\u0010\u0005J\u0012\u0010\u001d\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\rH\u0016J\b\u0010#\u001a\u00020!H\u0002J\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020&H\u0007J\u0010\u0010'\u001a\u00020!2\u0006\u0010%\u001a\u00020(H\u0007J\u0010\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0016J\u0012\u0010,\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\u0010\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020!H\u0014J\u0010\u00103\u001a\u00020!2\u0006\u0010%\u001a\u000204H\u0007J\u0010\u00105\u001a\u00020\r2\u0006\u00106\u001a\u000207H\u0016J\u001a\u00108\u001a\u00020!2\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020\u0012H\u0002J\u0010\u0010<\u001a\u00020!2\u0006\u0010=\u001a\u00020.H\u0014J\b\u0010>\u001a\u00020!H\u0014J\u0010\u0010?\u001a\u00020!2\u0006\u0010@\u001a\u00020\u0012H\u0014J\u0010\u0010A\u001a\u00020!2\u0006\u0010%\u001a\u00020(H\u0007J\u0010\u0010B\u001a\u00020!2\u0006\u0010%\u001a\u00020CH\u0007J\b\u0010D\u001a\u00020!H\u0016J\u0010\u0010E\u001a\u00020!2\u0006\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u00020!H\u0002J\b\u0010I\u001a\u00020!H\u0002J\b\u0010J\u001a\u00020!H\u0002J\b\u0010K\u001a\u00020!H\u0002J\b\u0010L\u001a\u00020!H\u0002J\b\u0010M\u001a\u00020!H\u0002J\b\u0010N\u001a\u00020!H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\f\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/coolapk/market/view/userv9/UserSpaceV9Activity;", "Lcom/coolapk/market/view/base/BaseActivity;", "Lcom/coolapk/market/view/userv9/UserSpaceView;", "Landroid/view/View$OnClickListener;", "Lcom/coolapk/market/app/TranslucentActivity;", "()V", "behavior", "Lcom/coolapk/market/view/userv9/UserSpaceAppBarBehavior;", "binding", "Lcom/coolapk/market/databinding/UserSpaceV9Binding;", "headerInfoViewPart", "Lcom/coolapk/market/view/userv9/UserHeaderInfoViewPart;", "isInBlackList", "", "()Z", "isInBlackList$delegate", "Lkotlin/Lazy;", "paddingBottom", "", "getPaddingBottom", "()I", "setPaddingBottom", "(I)V", "presenter", "Lcom/coolapk/market/view/userv9/UserSpaceV9Presenter;", "tabHelper", "Lcom/coolapk/market/view/userv9/UserSpaceV9TabHelper;", "viewModel", "Lcom/coolapk/market/view/userv9/UserSpaceV9ViewModel;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "initUI", "", "isNavigationBarTranslucent", "onActionButtonClick", "onAlbumDeleted", "event", "Lcom/coolapk/market/event/AlbumDeleteEvent;", "onBlackListEvent", "Lcom/coolapk/market/event/UserBlockedEvent;", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onDestroy", "onFeedDeleted", "Lcom/coolapk/market/event/FeedDeleteEvent;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPropertyChanged", "sender", "Landroidx/databinding/Observable;", "propertyId", "onSaveInstanceState", "outState", "onSetStatusBarColor", "onSetStatusBarDarkMode", "delay", "onUserBlockedEvent", "onUserProfileEvent", "Lcom/coolapk/market/event/UserProfileEvent;", "onUserProfileLoaded", "onUserProfileLoadedWithUrlResult", "url", "", "setActionViewState", "setupBackgroundImage", "setupHeaderView", "setupMenu", "setupTabsView", "showChangeCoverDialog", "updateContainerHeight", "ChangeUserCoverFragment", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserSpaceV9Activity.kt */
public final class UserSpaceV9Activity extends BaseActivity implements UserSpaceView, View.OnClickListener, TranslucentActivity {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_MODEL = "extra_model";
    public static final String KEY_USER_ID = "key_uid";
    private UserSpaceAppBarBehavior behavior;
    private UserSpaceV9Binding binding;
    private UserHeaderInfoViewPart headerInfoViewPart;
    private final Lazy isInBlackList$delegate = LazyKt.lazy(new UserSpaceV9Activity$isInBlackList$2(this));
    private int paddingBottom;
    private final UserSpaceV9Presenter presenter;
    private UserSpaceV9TabHelper tabHelper;
    private final UserSpaceV9ViewModel viewModel;

    public final boolean isInBlackList() {
        return ((Boolean) this.isInBlackList$delegate.getValue()).booleanValue();
    }

    @Override // com.coolapk.market.app.TranslucentActivity
    public boolean isNavigationBarTranslucent() {
        return true;
    }

    public UserSpaceV9Activity() {
        UserSpaceV9ViewModel userSpaceV9ViewModel = new UserSpaceV9ViewModel();
        this.viewModel = userSpaceV9ViewModel;
        this.presenter = new UserSpaceV9Presenter(this, this, userSpaceV9ViewModel);
    }

    public static final /* synthetic */ UserSpaceV9Binding access$getBinding$p(UserSpaceV9Activity userSpaceV9Activity) {
        UserSpaceV9Binding userSpaceV9Binding = userSpaceV9Activity.binding;
        if (userSpaceV9Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return userSpaceV9Binding;
    }

    public static final /* synthetic */ UserHeaderInfoViewPart access$getHeaderInfoViewPart$p(UserSpaceV9Activity userSpaceV9Activity) {
        UserHeaderInfoViewPart userHeaderInfoViewPart = userSpaceV9Activity.headerInfoViewPart;
        if (userHeaderInfoViewPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerInfoViewPart");
        }
        return userHeaderInfoViewPart;
    }

    public static final /* synthetic */ UserSpaceV9TabHelper access$getTabHelper$p(UserSpaceV9Activity userSpaceV9Activity) {
        UserSpaceV9TabHelper userSpaceV9TabHelper = userSpaceV9Activity.tabHelper;
        if (userSpaceV9TabHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabHelper");
        }
        return userSpaceV9TabHelper;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/view/userv9/UserSpaceV9Activity$Companion;", "", "()V", "EXTRA_MODEL", "", "KEY_USER_ID", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserSpaceV9Activity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final int getPaddingBottom() {
        return this.paddingBottom;
    }

    public final void setPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        getWindow().requestFeature(1);
        UserSpaceV9Activity userSpaceV9Activity = this;
        ThemeUtils.setSystemBarDrawFlags(userSpaceV9Activity);
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(userSpaceV9Activity, 2131559295, new ContextBindingComponent(this));
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…user_space_v9, component)");
        UserSpaceV9Binding userSpaceV9Binding = (UserSpaceV9Binding) contentView;
        this.binding = userSpaceV9Binding;
        if (userSpaceV9Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userSpaceV9Binding.setViewModel(this.viewModel);
        UserSpaceV9Binding userSpaceV9Binding2 = this.binding;
        if (userSpaceV9Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userSpaceV9Binding2.setClick(this);
        UserSpaceV9Binding userSpaceV9Binding3 = this.binding;
        if (userSpaceV9Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userSpaceV9Binding3.setTransformer(new CircleTransform(false, 0, 3, null));
        UserSpaceV9Binding userSpaceV9Binding4 = this.binding;
        if (userSpaceV9Binding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userSpaceV9Binding4.executePendingBindings();
        this.presenter.onInitPresenterState(bundle);
        if (this.viewModel.getUserProfile() == null) {
            String stringExtra = getIntent().getStringExtra("key_uid");
            if (stringExtra != null) {
                Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(KE…ption(\"provide user id \")");
                this.presenter.loadUserProfile(stringExtra);
            } else {
                throw new RuntimeException("provide user id ");
            }
        } else if (!(bundle == null || this.tabHelper == null)) {
            UserSpaceV9TabHelper userSpaceV9TabHelper = this.tabHelper;
            if (userSpaceV9TabHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabHelper");
            }
            userSpaceV9TabHelper.restorePresenter(bundle);
        }
        initUI();
        StatisticHelper.Companion.getInstance().recordNodeClickAction("个人主页");
        UserSpaceV9Binding userSpaceV9Binding5 = this.binding;
        if (userSpaceV9Binding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userSpaceV9Binding5.mainContent.addOnInsetChangeListener(new UserSpaceV9Activity$onCreate$2(this));
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarDarkMode(int i) {
        ThemeUtils.setDarkStatusIconBar(getActivity(), false, i);
    }

    private final void initUI() {
        UserSpaceV9Binding userSpaceV9Binding = this.binding;
        if (userSpaceV9Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        setSupportActionBar(userSpaceV9Binding.toolbar);
        UserSpaceV9Binding userSpaceV9Binding2 = this.binding;
        if (userSpaceV9Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        Toolbar toolbar = userSpaceV9Binding2.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "binding.toolbar");
        ViewExtendsKt.setTintColor(toolbar, -1);
        UserSpaceV9Binding userSpaceV9Binding3 = this.binding;
        if (userSpaceV9Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userSpaceV9Binding3.toolbar.setNavigationIcon(2131231166);
        UserSpaceV9Binding userSpaceV9Binding4 = this.binding;
        if (userSpaceV9Binding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userSpaceV9Binding4.toolbar.setNavigationOnClickListener(new UserSpaceV9Activity$initUI$1(this));
        UserSpaceV9Binding userSpaceV9Binding5 = this.binding;
        if (userSpaceV9Binding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        Toolbar toolbar2 = userSpaceV9Binding5.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar2, "binding.toolbar");
        toolbar2.setTitle(" ");
        setTitle(" ");
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        this.presenter.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        UserSpaceAppBarBehavior userSpaceAppBarBehavior = this.behavior;
        if (userSpaceAppBarBehavior != null) {
            userSpaceAppBarBehavior.setTouching(true);
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        UserSpaceAppBarBehavior userSpaceAppBarBehavior2 = this.behavior;
        if (userSpaceAppBarBehavior2 != null) {
            userSpaceAppBarBehavior2.setTouching(false);
        }
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(2131623973, menu);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        MenuItem findItem = menu.findItem(2131361858);
        if (findItem != null) {
            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
            if (loginSession.isAdmin()) {
                findItem.setVisible(true);
            }
        }
        if (this.viewModel.getUserProfile() != null) {
            setupMenu();
        }
        return true;
    }

    private final void setupMenu() {
        UserSpaceV9Binding userSpaceV9Binding = this.binding;
        if (userSpaceV9Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        Toolbar toolbar = userSpaceV9Binding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "binding.toolbar");
        Menu menu = toolbar.getMenu();
        if (menu != null) {
            boolean z = !this.viewModel.isLoginUser();
            MenuItem findItem = menu.findItem(2131361926);
            boolean z2 = false;
            if (findItem != null) {
                findItem.setVisible(false);
            }
            MenuItem findItem2 = menu.findItem(2131361875);
            if (findItem2 != null) {
                findItem2.setVisible(z);
                findItem2.setTitle(this.viewModel.isBlackList() ? "取消拉黑" : "加入黑名单");
            }
            MenuItem findItem3 = menu.findItem(2131361958);
            if (findItem3 != null) {
                findItem3.setVisible(z);
            }
            MenuItem findItem4 = menu.findItem(2131361969);
            if (findItem4 != null) {
                findItem4.setVisible(this.viewModel.getUserProfile() != null);
            }
            MenuItem findItem5 = menu.findItem(2131361985);
            if (findItem5 != null) {
                UserProfile userProfile = this.viewModel.getUserProfile();
                if (userProfile != null) {
                    z2 = true;
                }
                findItem5.setVisible(z2);
                if (userProfile == null) {
                    return;
                }
                if (this.viewModel.isLoginUser()) {
                    findItem5.setTitle("查看我的资料");
                } else if (userProfile.getGender() >= 1) {
                    findItem5.setTitle("查看他的资料");
                } else if (userProfile.getGender() == 0) {
                    findItem5.setTitle("查看她的资料");
                } else if (userProfile.getGender() <= -1) {
                    findItem5.setTitle("查看TA的资料");
                }
            }
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        UserProfile userProfile = this.viewModel.getUserProfile();
        switch (menuItem.getItemId()) {
            case 2131361858:
                String stringExtra = getIntent().getStringExtra("key_uid");
                Intrinsics.checkNotNull(stringExtra);
                Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(KEY_USER_ID)!!");
                ActionManager.startWebViewActivity(getActivity(), UriUtils.getUserManageUrl(stringExtra));
                return true;
            case 2131361875:
                if (userProfile == null) {
                    return false;
                }
                ActionManager.startBlackListSettingActivity(getActivity(), userProfile);
                return true;
            case 2131361926:
                if (userProfile == null) {
                    return false;
                }
                ActionManager.startChattingActivity(getActivity(), userProfile.getUid(), userProfile.getUserName());
                return true;
            case 2131361958:
                if (userProfile == null) {
                    return false;
                }
                String uid = userProfile.getUid();
                Intrinsics.checkNotNullExpressionValue(uid, "userProfile.uid");
                ActionManager.startWebViewActivity(getActivity(), UriUtils.buildUserReportUrl(uid));
                return true;
            case 2131361961:
                if (userProfile == null) {
                    return false;
                }
                ActionManager.startSceneSearchActivity(this, "user", userProfile.getUid() + "|" + userProfile.getGender());
                return true;
            case 2131361969:
                if (userProfile == null) {
                    return false;
                }
                ActionManager.shareText(getActivity(), userProfile);
                return true;
            case 2131361985:
                if (userProfile == null) {
                    return false;
                }
                ActionManagerCompat actionManagerCompat = ActionManagerCompat.INSTANCE;
                BaseActivity activity = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                actionManagerCompat.startUserDataActivity(activity, userProfile);
                return true;
            default:
                return false;
        }
    }

    @Subscribe
    public final void onUserBlockedEvent(UserBlockedEvent userBlockedEvent) {
        Intrinsics.checkNotNullParameter(userBlockedEvent, "event");
        UserProfile userProfile = this.viewModel.getUserProfile();
        if (userProfile != null && Intrinsics.areEqual(userProfile.getUid(), userBlockedEvent.getUid())) {
            UserSpaceV9ViewModel userSpaceV9ViewModel = this.viewModel;
            UserProfile build = UserProfile.builder(userProfile).setIsInBlackList(userBlockedEvent.getIsInBlackList()).build();
            Intrinsics.checkNotNullExpressionValue(build, "UserProfile.builder(oldS…                 .build()");
            userSpaceV9ViewModel.replaceModelSilently(build);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        UserProfile userProfile = this.viewModel.getUserProfile();
        if (userProfile != null) {
            switch (view.getId()) {
                case 2131361982:
                case 2131363612:
                    onActionButtonClick();
                    return;
                case 2131362454:
                    DataManager instance = DataManager.getInstance();
                    Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                    LoginSession loginSession = instance.getLoginSession();
                    Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
                    if (!loginSession.isLogin()) {
                        ActionManager.startLoginActivity(getActivity());
                        return;
                    } else {
                        ActionManager.startUserProfileActivity(getActivity(), "编辑资料");
                        return;
                    }
                case 2131362945:
                    ActionManager.startChattingActivity(getActivity(), userProfile.getUid(), userProfile.getUserName());
                    return;
                case 2131363173:
                    if (this.viewModel.isLoginUser()) {
                        BaseActivity activity = getActivity();
                        Intrinsics.checkNotNullExpressionValue(activity, "activity");
                        ActionManagerCompat.startUserQRCodeActivity(activity, userProfile);
                        return;
                    }
                    ActionManager.startChattingActivity(getActivity(), userProfile.getUid(), userProfile.getUserName());
                    return;
                case 2131363621:
                case 2131363900:
                    String userAvatar = this.viewModel.getUserAvatar();
                    if (!TextUtils.isEmpty(userAvatar)) {
                        ActionManager.startPhotoViewActivity(view, StringsKt.replace$default(StringsKt.replace$default(userAvatar, "_middle", "_big", false, 4, (Object) null), "_small", "_big", false, 4, (Object) null), userAvatar);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Subscribe
    public final void onUserProfileEvent(UserProfileEvent userProfileEvent) {
        Intrinsics.checkNotNullParameter(userProfileEvent, "event");
        UserProfile userProfile = this.viewModel.getUserProfile();
        if (userProfile != null && userProfileEvent.canMatchUpWith(userProfile)) {
            this.viewModel.replaceModelSilently(userProfileEvent.patch(userProfile));
            UserProfile userProfile2 = this.viewModel.getUserProfile();
            Intrinsics.checkNotNull(userProfile2);
            String type = userProfileEvent.getType();
            switch (type.hashCode()) {
                case -410342769:
                    if (!type.equals("address_event")) {
                        return;
                    }
                    break;
                case -348261476:
                    if (!type.equals("gender_event")) {
                        return;
                    }
                    break;
                case -288816045:
                    if (type.equals("signature_event")) {
                        UserHeaderInfoViewPart userHeaderInfoViewPart = this.headerInfoViewPart;
                        if (userHeaderInfoViewPart == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("headerInfoViewPart");
                        }
                        userHeaderInfoViewPart.setSignatureView(userProfile2);
                        updateContainerHeight();
                        return;
                    }
                    return;
                case 169100306:
                    if (type.equals("cover_event")) {
                        setupBackgroundImage();
                        return;
                    }
                    return;
                case 1872264986:
                    if (!type.equals("birth_event")) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            UserHeaderInfoViewPart userHeaderInfoViewPart2 = this.headerInfoViewPart;
            if (userHeaderInfoViewPart2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headerInfoViewPart");
            }
            userHeaderInfoViewPart2.setFlowLayoutView(userProfile2);
            updateContainerHeight();
        }
    }

    @Override // com.coolapk.market.view.userv9.UserSpaceView
    public void onUserProfileLoaded() {
        if (!isFinishing()) {
            setupMenu();
            setupTabsView();
            setupHeaderView();
            setActionViewState();
            setupBackgroundImage();
            this.viewModel.addOnPropertyChangedCallback(new UserSpaceV9Activity$onUserProfileLoaded$1(this));
        }
    }

    @Override // com.coolapk.market.view.userv9.UserSpaceView
    public void onUserProfileLoadedWithUrlResult(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        BaseActivity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        ActionManagerCompat.startActivityByUrl$default(activity, str, null, null, 12, null);
        getActivity().finish();
        getActivity().overridePendingTransition(0, 0);
    }

    private final void setupHeaderView() {
        UserSpaceV9Binding userSpaceV9Binding = this.binding;
        if (userSpaceV9Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = userSpaceV9Binding.userToolbar.toolbarActionContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.userToolbar.toolbarActionContainer");
        linearLayout.setVisibility(8);
        if (this.viewModel.isLoginUser()) {
            UserSpaceV9Binding userSpaceV9Binding2 = this.binding;
            if (userSpaceV9Binding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            userSpaceV9Binding2.qrcodeView.setImageResource(2131231513);
            UserSpaceV9Binding userSpaceV9Binding3 = this.binding;
            if (userSpaceV9Binding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView = userSpaceV9Binding3.userToolbar.toolbarActionView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.userToolbar.toolbarActionView");
            textView.setVisibility(8);
        } else {
            UserSpaceV9Binding userSpaceV9Binding4 = this.binding;
            if (userSpaceV9Binding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            userSpaceV9Binding4.qrcodeView.setImageResource(2131231287);
            UserSpaceV9Binding userSpaceV9Binding5 = this.binding;
            if (userSpaceV9Binding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView2 = userSpaceV9Binding5.userToolbar.toolbarActionView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.userToolbar.toolbarActionView");
            textView2.setVisibility(0);
        }
        UserHeaderInfoViewPart userHeaderInfoViewPart = new UserHeaderInfoViewPart(this.presenter, this.viewModel);
        LayoutInflater from = LayoutInflater.from(this);
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(this)");
        UserSpaceV9Binding userSpaceV9Binding6 = this.binding;
        if (userSpaceV9Binding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userHeaderInfoViewPart.createView(from, userSpaceV9Binding6.infoViewContainer);
        UserProfile userProfile = this.viewModel.getUserProfile();
        Intrinsics.checkNotNull(userProfile);
        userHeaderInfoViewPart.bindToContent(userProfile);
        UserSpaceV9Binding userSpaceV9Binding7 = this.binding;
        if (userSpaceV9Binding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userSpaceV9Binding7.infoViewContainer.addView(userHeaderInfoViewPart.getView());
        this.headerInfoViewPart = userHeaderInfoViewPart;
        UserSpaceV9Binding userSpaceV9Binding8 = this.binding;
        if (userSpaceV9Binding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ItemUserInfoPartBinding itemUserInfoPartBinding = userSpaceV9Binding8.userInfoView;
        View root = itemUserInfoPartBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "root");
        root.getLayoutParams().height = NumberExtendsKt.getDp((Number) 16);
        itemUserInfoPartBinding.getRoot().requestLayout();
        TextView textView3 = itemUserInfoPartBinding.textView;
        Intrinsics.checkNotNullExpressionValue(textView3, "textView");
        textView3.setTextSize(10.0f);
        itemUserInfoPartBinding.textView.requestLayout();
        int actionBarSize = UiUtils.getActionBarSize(getActivity());
        UserSpaceV9Binding userSpaceV9Binding9 = this.binding;
        if (userSpaceV9Binding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userSpaceV9Binding9.mainContent.addOnInsetChangeListener(new UserSpaceV9Activity$setupHeaderView$2(this, actionBarSize));
        UserSpaceV9Binding userSpaceV9Binding10 = this.binding;
        if (userSpaceV9Binding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userSpaceV9Binding10.toolbar.requestApplyInsets();
        UserSpaceV9Binding userSpaceV9Binding11 = this.binding;
        if (userSpaceV9Binding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = userSpaceV9Binding11.refreshView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.refreshView");
        frameLayout.setVisibility(8);
        FloatEvaluator floatEvaluator = new FloatEvaluator();
        UserSpaceV9Binding userSpaceV9Binding12 = this.binding;
        if (userSpaceV9Binding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userSpaceV9Binding12.appBar.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new UserSpaceV9Activity$setupHeaderView$3(this, floatEvaluator));
        UserSpaceV9Binding userSpaceV9Binding13 = this.binding;
        if (userSpaceV9Binding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userSpaceV9Binding13.appBar.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new UserSpaceV9Activity$setupHeaderView$4(this));
        UserSpaceV9Binding userSpaceV9Binding14 = this.binding;
        if (userSpaceV9Binding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userSpaceV9Binding14.appBar.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new UserSpaceV9Activity$setupHeaderView$5(this, floatEvaluator));
        UserSpaceV9Binding userSpaceV9Binding15 = this.binding;
        if (userSpaceV9Binding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AppBarLayout appBarLayout = userSpaceV9Binding15.appBar;
        Intrinsics.checkNotNullExpressionValue(appBarLayout, "binding.appBar");
        AppBarLayout appBarLayout2 = appBarLayout;
        appBarLayout2.getViewTreeObserver().addOnPreDrawListener(new UserSpaceV9Activity$setupHeaderView$$inlined$doOnNextPreDraw$1(appBarLayout2, this));
    }

    /* access modifiers changed from: private */
    public final void updateContainerHeight() {
        UserSpaceV9Binding userSpaceV9Binding = this.binding;
        if (userSpaceV9Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        IgnoreInsetFrameLayout ignoreInsetFrameLayout = userSpaceV9Binding.tabContainer;
        Intrinsics.checkNotNullExpressionValue(ignoreInsetFrameLayout, "binding.tabContainer");
        ViewGroup.LayoutParams layoutParams = ignoreInsetFrameLayout.getLayoutParams();
        if (layoutParams.height == -2) {
            UserSpaceV9Binding userSpaceV9Binding2 = this.binding;
            if (userSpaceV9Binding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            IgnoreInsetFrameLayout ignoreInsetFrameLayout2 = userSpaceV9Binding2.tabContainer;
            Intrinsics.checkNotNullExpressionValue(ignoreInsetFrameLayout2, "binding.tabContainer");
            ViewGroup.LayoutParams layoutParams2 = ignoreInsetFrameLayout2.getLayoutParams();
            UserSpaceV9Binding userSpaceV9Binding3 = this.binding;
            if (userSpaceV9Binding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            IgnoreInsetFrameLayout ignoreInsetFrameLayout3 = userSpaceV9Binding3.tabContainer;
            Intrinsics.checkNotNullExpressionValue(ignoreInsetFrameLayout3, "binding.tabContainer");
            layoutParams2.height = ignoreInsetFrameLayout3.getMeasuredHeight();
            UserSpaceV9Binding userSpaceV9Binding4 = this.binding;
            if (userSpaceV9Binding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            userSpaceV9Binding4.tabContainer.requestLayout();
            UserSpaceV9Binding userSpaceV9Binding5 = this.binding;
            if (userSpaceV9Binding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            IgnoreInsetFrameLayout ignoreInsetFrameLayout4 = userSpaceV9Binding5.appBarHolder;
            Intrinsics.checkNotNullExpressionValue(ignoreInsetFrameLayout4, "binding.appBarHolder");
            ViewGroup.LayoutParams layoutParams3 = ignoreInsetFrameLayout4.getLayoutParams();
            UserSpaceV9Binding userSpaceV9Binding6 = this.binding;
            if (userSpaceV9Binding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            IgnoreInsetFrameLayout ignoreInsetFrameLayout5 = userSpaceV9Binding6.tabContainer;
            Intrinsics.checkNotNullExpressionValue(ignoreInsetFrameLayout5, "binding.tabContainer");
            layoutParams3.height = ignoreInsetFrameLayout5.getMeasuredHeight();
            UserSpaceV9Binding userSpaceV9Binding7 = this.binding;
            if (userSpaceV9Binding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            userSpaceV9Binding7.appBarHolder.requestLayout();
        } else if (layoutParams.height > 0) {
            layoutParams.height = -2;
            UserSpaceV9Binding userSpaceV9Binding8 = this.binding;
            if (userSpaceV9Binding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            IgnoreInsetFrameLayout ignoreInsetFrameLayout6 = userSpaceV9Binding8.tabContainer;
            Intrinsics.checkNotNullExpressionValue(ignoreInsetFrameLayout6, "binding.tabContainer");
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(ignoreInsetFrameLayout6.getWidth(), 1073741824);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(DisplayUtils.getHeightPixels(getActivity()), 0);
            UserSpaceV9Binding userSpaceV9Binding9 = this.binding;
            if (userSpaceV9Binding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            userSpaceV9Binding9.tabContainer.measure(makeMeasureSpec, makeMeasureSpec2);
            UserSpaceV9Binding userSpaceV9Binding10 = this.binding;
            if (userSpaceV9Binding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            IgnoreInsetFrameLayout ignoreInsetFrameLayout7 = userSpaceV9Binding10.tabContainer;
            Intrinsics.checkNotNullExpressionValue(ignoreInsetFrameLayout7, "binding.tabContainer");
            layoutParams.height = ignoreInsetFrameLayout7.getMeasuredHeight();
            UserSpaceV9Binding userSpaceV9Binding11 = this.binding;
            if (userSpaceV9Binding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            IgnoreInsetFrameLayout ignoreInsetFrameLayout8 = userSpaceV9Binding11.appBarHolder;
            Intrinsics.checkNotNullExpressionValue(ignoreInsetFrameLayout8, "binding.appBarHolder");
            ViewGroup.LayoutParams layoutParams4 = ignoreInsetFrameLayout8.getLayoutParams();
            UserSpaceV9Binding userSpaceV9Binding12 = this.binding;
            if (userSpaceV9Binding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            IgnoreInsetFrameLayout ignoreInsetFrameLayout9 = userSpaceV9Binding12.tabContainer;
            Intrinsics.checkNotNullExpressionValue(ignoreInsetFrameLayout9, "binding.tabContainer");
            layoutParams4.height = ignoreInsetFrameLayout9.getMeasuredHeight();
            UserSpaceV9Binding userSpaceV9Binding13 = this.binding;
            if (userSpaceV9Binding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            userSpaceV9Binding13.appBarHolder.requestLayout();
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0047: APUT  
      (r2v0 android.widget.TextView[])
      (0 ??[int, short, byte, char])
      (wrap: android.widget.TextView : 0x0044: IGET  (r3v1 android.widget.TextView) = (r3v0 com.coolapk.market.databinding.UserSpaceV9Binding) com.coolapk.market.databinding.UserSpaceV9Binding.actionView android.widget.TextView)
     */
    private final void setActionViewState() {
        if (this.viewModel.isLoginUser()) {
            UserSpaceV9Binding userSpaceV9Binding = this.binding;
            if (userSpaceV9Binding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView = userSpaceV9Binding.actionView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.actionView");
            textView.setBackground(new ColorDrawable(1308622847));
            UserSpaceV9Binding userSpaceV9Binding2 = this.binding;
            if (userSpaceV9Binding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView2 = userSpaceV9Binding2.actionView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.actionView");
            textView2.setText("编辑资料");
            return;
        }
        TextView[] textViewArr = new TextView[2];
        UserSpaceV9Binding userSpaceV9Binding3 = this.binding;
        if (userSpaceV9Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        textViewArr[0] = userSpaceV9Binding3.actionView;
        UserSpaceV9Binding userSpaceV9Binding4 = this.binding;
        if (userSpaceV9Binding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        textViewArr[1] = userSpaceV9Binding4.userToolbar.toolbarActionView;
        for (int i = 0; i < 2; i++) {
            TextView textView3 = textViewArr[i];
            if (this.viewModel.isBlackList()) {
                textView3.setText(textView3.getContext().getString(2131886112));
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setStroke(NumberExtendsKt.getDp((Number) 1), -1);
                gradientDrawable.setColor(ColorStateList.valueOf(0));
                Intrinsics.checkNotNullExpressionValue(textView3, "it");
                gradientDrawable.setCornerRadius(((float) textView3.getLayoutParams().height) / 2.0f);
                Unit unit = Unit.INSTANCE;
                textView3.setBackground(gradientDrawable);
            } else if (this.viewModel.getFollow()) {
                textView3.setText(textView3.getContext().getString(this.viewModel.getMutualConcern() ? 2131886139 : 2131886114));
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setShape(0);
                gradientDrawable2.setStroke(NumberExtendsKt.getDp((Number) 1), -1);
                gradientDrawable2.setColor(ColorStateList.valueOf(0));
                Intrinsics.checkNotNullExpressionValue(textView3, "it");
                gradientDrawable2.setCornerRadius(((float) textView3.getLayoutParams().height) / 2.0f);
                Unit unit2 = Unit.INSTANCE;
                textView3.setBackground(gradientDrawable2);
            } else {
                textView3.setText(textView3.getContext().getString(2131886133));
                textView3.setBackgroundColor(AppHolder.getAppTheme().getColorAccent());
            }
        }
    }

    private final void setupBackgroundImage() {
        String str;
        UserProfile userProfile = this.viewModel.getUserProfile();
        if (userProfile == null || (str = userProfile.getCover()) == null) {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "viewModel.userProfile?.cover ?: \"\"");
        if (str.length() == 0) {
            UserSpaceV9Binding userSpaceV9Binding = this.binding;
            if (userSpaceV9Binding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            userSpaceV9Binding.backgroundView.setImageResource(2131232052);
            return;
        }
        GlideContextImageLoader contextImageLoader = AppHolder.getContextImageLoader();
        BaseActivity activity = getActivity();
        UserSpaceV9Binding userSpaceV9Binding2 = this.binding;
        if (userSpaceV9Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        contextImageLoader.displayImage((Context) activity, str, userSpaceV9Binding2.backgroundView, ImageLoaderOptions.newBuilder().loadSource(true).bitmapOnly(true).build(), (OnImageLoadListener) new UserSpaceV9Activity$setupBackgroundImage$1(this), (OnBitmapTransformListener) null);
    }

    private final void setupTabsView() {
        this.tabHelper = new UserSpaceV9TabHelper(this, this.viewModel);
        UserProfile userProfile = this.viewModel.getUserProfile();
        Intrinsics.checkNotNull(userProfile);
        UserSpaceV9Activity$setupTabsView$adapter$1 userSpaceV9Activity$setupTabsView$adapter$1 = new UserSpaceV9Activity$setupTabsView$adapter$1(this, getSupportFragmentManager());
        UserSpaceV9Binding userSpaceV9Binding = this.binding;
        if (userSpaceV9Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager = userSpaceV9Binding.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
        scrollStateViewPager.setAdapter(userSpaceV9Activity$setupTabsView$adapter$1);
        UserSpaceV9Binding userSpaceV9Binding2 = this.binding;
        if (userSpaceV9Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager2 = userSpaceV9Binding2.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager2, "binding.viewPager");
        UserSpaceV9TabHelper userSpaceV9TabHelper = this.tabHelper;
        if (userSpaceV9TabHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabHelper");
        }
        scrollStateViewPager2.setCurrentItem(userSpaceV9TabHelper.getPreferDisplayPage(userProfile));
        UserSpaceV9Binding userSpaceV9Binding3 = this.binding;
        if (userSpaceV9Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TabLayout tabLayout = userSpaceV9Binding3.tabs;
        Intrinsics.checkNotNullExpressionValue(tabLayout, "binding.tabs");
        ViewExtendsKt.setV9TabUI(tabLayout, 0);
        UserSpaceV9Binding userSpaceV9Binding4 = this.binding;
        if (userSpaceV9Binding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TabLayout tabLayout2 = userSpaceV9Binding4.tabs;
        Intrinsics.checkNotNullExpressionValue(tabLayout2, "binding.tabs");
        ViewExtendsKt.setV9TabColor(tabLayout2, false);
        UserSpaceV9Binding userSpaceV9Binding5 = this.binding;
        if (userSpaceV9Binding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TabLayout tabLayout3 = userSpaceV9Binding5.tabs;
        UserSpaceV9Binding userSpaceV9Binding6 = this.binding;
        if (userSpaceV9Binding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        tabLayout3.setupWithViewPager(userSpaceV9Binding6.viewPager);
        UserSpaceV9Binding userSpaceV9Binding7 = this.binding;
        if (userSpaceV9Binding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TabLayout tabLayout4 = userSpaceV9Binding7.tabs;
        Intrinsics.checkNotNullExpressionValue(tabLayout4, "binding.tabs");
        UserSpaceV9Binding userSpaceV9Binding8 = this.binding;
        if (userSpaceV9Binding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager3 = userSpaceV9Binding8.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager3, "binding.viewPager");
        ViewExtendsKt.setDefaultDoubleClickListener(tabLayout4, scrollStateViewPager3);
        float dp = (float) NumberExtendsKt.getDp((Number) 12);
        UserSpaceV9Binding userSpaceV9Binding9 = this.binding;
        if (userSpaceV9Binding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TabLayout tabLayout5 = userSpaceV9Binding9.tabs;
        Intrinsics.checkNotNullExpressionValue(tabLayout5, "binding.tabs");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(AppHolder.getAppTheme().getContentBackgroundColor());
        gradientDrawable.setCornerRadii(new float[]{dp, dp, dp, dp, 0.0f, 0.0f, 0.0f, 0.0f});
        Unit unit = Unit.INSTANCE;
        tabLayout5.setBackground(gradientDrawable);
        UserSpaceV9Binding userSpaceV9Binding10 = this.binding;
        if (userSpaceV9Binding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userSpaceV9Binding10.viewPager.addOnPageChangeListener(new UserSpaceV9Activity$setupTabsView$2(this, userSpaceV9Activity$setupTabsView$adapter$1));
    }

    private final void onActionButtonClick() {
        if (this.viewModel.isLoginUser()) {
            ActionManager.startUserProfileActivity(getActivity(), "编辑资料");
        } else {
            this.presenter.requestChangeFollowState();
        }
    }

    /* access modifiers changed from: private */
    public final void onPropertyChanged(Observable observable, int i) {
        if (i == 116) {
            setActionViewState();
            if (this.headerInfoViewPart != null) {
                UserHeaderInfoViewPart userHeaderInfoViewPart = this.headerInfoViewPart;
                if (userHeaderInfoViewPart == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headerInfoViewPart");
                }
                UserProfile userProfile = this.viewModel.getUserProfile();
                Intrinsics.checkNotNull(userProfile);
                userHeaderInfoViewPart.setFollowState(userProfile);
            }
        } else if (i == 164) {
            setActionViewState();
            invalidateOptionsMenu();
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.presenter.onDestroy();
    }

    @Subscribe
    public final void onFeedDeleted(FeedDeleteEvent feedDeleteEvent) {
        List<String> topIds;
        Intrinsics.checkNotNullParameter(feedDeleteEvent, "event");
        UserProfile userProfile = this.viewModel.getUserProfile();
        if (userProfile != null && (topIds = userProfile.getTopIds()) != null && topIds.contains(feedDeleteEvent.id)) {
            topIds.remove(feedDeleteEvent.id);
        }
    }

    @Subscribe
    public final void onAlbumDeleted(AlbumDeleteEvent albumDeleteEvent) {
        List<String> topIds;
        Intrinsics.checkNotNullParameter(albumDeleteEvent, "event");
        UserProfile userProfile = this.viewModel.getUserProfile();
        if (userProfile != null && (topIds = userProfile.getTopIds()) != null && topIds.contains(albumDeleteEvent.id)) {
            topIds.remove(albumDeleteEvent.id);
        }
    }

    @Subscribe
    public final void onBlackListEvent(UserBlockedEvent userBlockedEvent) {
        Intrinsics.checkNotNullParameter(userBlockedEvent, "event");
        String uid = userBlockedEvent.getUid();
        UserProfile userProfile = this.viewModel.getUserProfile();
        if (Intrinsics.areEqual(uid, userProfile != null ? userProfile.getUid() : null)) {
            UserSpaceV9ViewModel userSpaceV9ViewModel = this.viewModel;
            boolean z = true;
            if (userBlockedEvent.getIsInBlackList() != 1) {
                z = false;
            }
            userSpaceV9ViewModel.setBlackList(z);
        }
    }

    /* access modifiers changed from: private */
    public final void showChangeCoverDialog() {
        if (this.viewModel.isLoginUser()) {
            ChangeUserCoverFragment.Companion companion = ChangeUserCoverFragment.Companion;
            UserProfile userProfile = this.viewModel.getUserProfile();
            Intrinsics.checkNotNull(userProfile);
            ChangeUserCoverFragment newInstance = companion.newInstance(userProfile);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            newInstance.show(supportFragmentManager, (String) null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/userv9/UserSpaceV9Activity$ChangeUserCoverFragment;", "Lcom/coolapk/market/view/base/MultiItemDialogFragment;", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserSpaceV9Activity.kt */
    public static final class ChangeUserCoverFragment extends MultiItemDialogFragment {
        public static final Companion Companion = new Companion(null);

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/userv9/UserSpaceV9Activity$ChangeUserCoverFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/userv9/UserSpaceV9Activity$ChangeUserCoverFragment;", "profile", "Lcom/coolapk/market/model/UserProfile;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: UserSpaceV9Activity.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final ChangeUserCoverFragment newInstance(UserProfile userProfile) {
                Intrinsics.checkNotNullParameter(userProfile, "profile");
                ChangeUserCoverFragment changeUserCoverFragment = new ChangeUserCoverFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelable("DATA", userProfile);
                Unit unit = Unit.INSTANCE;
                changeUserCoverFragment.setArguments(bundle);
                return changeUserCoverFragment;
            }
        }

        @Override // com.coolapk.market.view.base.MultiItemDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            updateDataList(new UserSpaceV9Activity$ChangeUserCoverFragment$onActivityCreated$1(this, (UserProfile) requireArguments().getParcelable("DATA")));
        }
    }
}
