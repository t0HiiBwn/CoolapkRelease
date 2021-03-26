package com.coolapk.market.view.node;

import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.OneShotPreDrawListener;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.TranslucentActivity;
import com.coolapk.market.databinding.TopicNodePageBinding;
import com.coolapk.market.event.TabEvent;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.base.refresh.ScrollableFragment;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.feedv8.FakeStatusBarActivity;
import com.coolapk.market.view.main.DataListViewPagerConverter;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.TabLayout;
import com.coolapk.market.widget.view.VXNestedScrollView;
import com.coolapk.market.widget.view.VXProxyFloatingView;
import com.coolapk.market.widget.view.VXScrollingStateHelper;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020'H\u0002J>\u0010,\u001a\u00020'2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u00100\u001a\u00020\u001c2\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000203\u0018\u0001022\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0010\u00106\u001a\u00020'2\u0006\u0010)\u001a\u00020*H\u0016J\b\u00107\u001a\u00020\u0017H\u0016J\u0012\u00108\u001a\u00020'2\b\u00109\u001a\u0004\u0018\u00010:H\u0014J\b\u0010;\u001a\u00020'H\u0014J\b\u0010<\u001a\u00020'H\u0016J\u0010\u0010=\u001a\u00020'2\u0006\u0010>\u001a\u00020\rH\u0016J\u0010\u0010?\u001a\u00020'2\u0006\u0010@\u001a\u00020AH\u0016J\u0010\u0010B\u001a\u00020'2\u0006\u0010C\u001a\u00020\u001cH\u0014J\u0010\u0010D\u001a\u00020'2\u0006\u0010E\u001a\u00020FH\u0007J\u0006\u0010G\u001a\u00020'J\u0012\u0010H\u001a\u00020'2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u0010\u0010K\u001a\u00020'2\b\b\u0002\u0010L\u001a\u00020MJ\u0006\u0010N\u001a\u00020'J\u0006\u0010O\u001a\u00020'J\u0010\u0010P\u001a\u00020'2\u0006\u0010Q\u001a\u00020\u001cH\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001e\"\u0004\b%\u0010 ¨\u0006R"}, d2 = {"Lcom/coolapk/market/view/node/BaseNodePageActivity;", "Lcom/coolapk/market/view/feedv8/FakeStatusBarActivity;", "Lcom/coolapk/market/widget/DrawSystemBarFrameLayout$OnInsetChangeListener;", "Lcom/coolapk/market/view/node/NodeActivityBehavior;", "Lcom/coolapk/market/app/TranslucentActivity;", "()V", "binding", "Lcom/coolapk/market/databinding/TopicNodePageBinding;", "getBinding$presentation_coolapkAppRelease", "()Lcom/coolapk/market/databinding/TopicNodePageBinding;", "setBinding$presentation_coolapkAppRelease", "(Lcom/coolapk/market/databinding/TopicNodePageBinding;)V", "cornerRadiusHeight", "", "getCornerRadiusHeight$presentation_coolapkAppRelease", "()F", "helper", "Lcom/coolapk/market/widget/view/VXScrollingStateHelper;", "getHelper$presentation_coolapkAppRelease", "()Lcom/coolapk/market/widget/view/VXScrollingStateHelper;", "setHelper$presentation_coolapkAppRelease", "(Lcom/coolapk/market/widget/view/VXScrollingStateHelper;)V", "<set-?>", "", "isLoading", "isLoading$presentation_coolapkAppRelease", "()Z", "pendingAppBarBackgroundAlpha", "", "getPendingAppBarBackgroundAlpha$presentation_coolapkAppRelease", "()I", "setPendingAppBarBackgroundAlpha$presentation_coolapkAppRelease", "(I)V", "subscription", "Lrx/Subscription;", "toolbarAlphaScrollYStartThreshold", "getToolbarAlphaScrollYStartThreshold$presentation_coolapkAppRelease", "setToolbarAlphaScrollYStartThreshold$presentation_coolapkAppRelease", "initUIState", "", "installBackgroundView", "view", "Landroid/view/View;", "installFloatingButton", "installFloatingView", "tabApiList", "", "Lcom/coolapk/market/model/ConfigPage;", "selectedTab", "factor", "Lkotlin/Function1;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "pageChangedListener", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "installToolbarContentView", "isNavigationBarTranslucent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEmptyViewClick", "onFloatingButtonAction", "transitionY", "onInsetChange", "rect", "Landroid/graphics/Rect;", "onSetStatusBarDarkMode", "delay", "onTabEventChanged", "tabEvent", "Lcom/coolapk/market/event/TabEvent;", "refreshAndScrollToTop", "setAppBarBackground", "drawable", "Landroid/graphics/drawable/Drawable;", "setLoadingError", "errorText", "", "setLoadingFinished", "setLoadingStart", "setToolbarAlphaScrollYStartThreshold", "value", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseNodePageActivity.kt */
public class BaseNodePageActivity extends FakeStatusBarActivity implements DrawSystemBarFrameLayout.OnInsetChangeListener, NodeActivityBehavior, TranslucentActivity {
    public TopicNodePageBinding binding;
    private final float cornerRadiusHeight = ((float) NumberExtendsKt.getDp((Number) 12));
    public VXScrollingStateHelper helper;
    private boolean isLoading;
    private int pendingAppBarBackgroundAlpha;
    private Subscription subscription;
    private int toolbarAlphaScrollYStartThreshold = NumberExtendsKt.getDp((Number) 116);

    @Override // com.coolapk.market.app.TranslucentActivity
    public boolean isNavigationBarTranslucent() {
        return true;
    }

    public void onEmptyViewClick() {
    }

    public void onFloatingButtonAction(float f) {
    }

    public final TopicNodePageBinding getBinding$presentation_coolapkAppRelease() {
        TopicNodePageBinding topicNodePageBinding = this.binding;
        if (topicNodePageBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return topicNodePageBinding;
    }

    public final void setBinding$presentation_coolapkAppRelease(TopicNodePageBinding topicNodePageBinding) {
        Intrinsics.checkNotNullParameter(topicNodePageBinding, "<set-?>");
        this.binding = topicNodePageBinding;
    }

    public final VXScrollingStateHelper getHelper$presentation_coolapkAppRelease() {
        VXScrollingStateHelper vXScrollingStateHelper = this.helper;
        if (vXScrollingStateHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helper");
        }
        return vXScrollingStateHelper;
    }

    public final void setHelper$presentation_coolapkAppRelease(VXScrollingStateHelper vXScrollingStateHelper) {
        Intrinsics.checkNotNullParameter(vXScrollingStateHelper, "<set-?>");
        this.helper = vXScrollingStateHelper;
    }

    public final float getCornerRadiusHeight$presentation_coolapkAppRelease() {
        return this.cornerRadiusHeight;
    }

    public final int getToolbarAlphaScrollYStartThreshold$presentation_coolapkAppRelease() {
        return this.toolbarAlphaScrollYStartThreshold;
    }

    public final void setToolbarAlphaScrollYStartThreshold$presentation_coolapkAppRelease(int i) {
        this.toolbarAlphaScrollYStartThreshold = i;
    }

    public final int getPendingAppBarBackgroundAlpha$presentation_coolapkAppRelease() {
        return this.pendingAppBarBackgroundAlpha;
    }

    public final void setPendingAppBarBackgroundAlpha$presentation_coolapkAppRelease(int i) {
        this.pendingAppBarBackgroundAlpha = i;
    }

    public final boolean isLoading$presentation_coolapkAppRelease() {
        return this.isLoading;
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        setContentBarAlwaysTranslucent(true);
        super.onCreate(bundle);
        getWindow().setBackgroundDrawableResource(AppHolder.getAppTheme().isDarkTheme() ? 2131100010 : 2131100009);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, 2131559204);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…R.layout.topic_node_page)");
        TopicNodePageBinding topicNodePageBinding = (TopicNodePageBinding) contentView;
        this.binding = topicNodePageBinding;
        if (topicNodePageBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = topicNodePageBinding.appendView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.appendView");
        TopicNodePageBinding topicNodePageBinding2 = this.binding;
        if (topicNodePageBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        VXProxyFloatingView vXProxyFloatingView = topicNodePageBinding2.floatingView;
        Intrinsics.checkNotNullExpressionValue(vXProxyFloatingView, "binding.floatingView");
        TopicNodePageBinding topicNodePageBinding3 = this.binding;
        if (topicNodePageBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        VXNestedScrollView vXNestedScrollView = topicNodePageBinding3.nestedBackgroundView;
        Intrinsics.checkNotNullExpressionValue(vXNestedScrollView, "binding.nestedBackgroundView");
        this.helper = new VXScrollingStateHelper(frameLayout, vXProxyFloatingView, vXNestedScrollView, (int) this.cornerRadiusHeight);
        initUIState();
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarDarkMode(int i) {
        ThemeUtils.setDarkStatusIconBar(getActivity(), false, i);
    }

    private final void initUIState() {
        TopicNodePageBinding topicNodePageBinding = this.binding;
        if (topicNodePageBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        topicNodePageBinding.loadingContainer.setBackgroundResource(AppHolder.getAppTheme().isDarkTheme() ? 2131100010 : 2131100009);
        TopicNodePageBinding topicNodePageBinding2 = this.binding;
        if (topicNodePageBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        Toolbar toolbar = topicNodePageBinding2.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "binding.toolbar");
        toolbar.setPopupTheme(AppHolder.getAppTheme().isDarkTheme() ? 2131952176 : 2131952182);
        TopicNodePageBinding topicNodePageBinding3 = this.binding;
        if (topicNodePageBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        DrawSystemBarFrameLayout drawSystemBarFrameLayout = topicNodePageBinding3.mainContent;
        Intrinsics.checkNotNullExpressionValue(drawSystemBarFrameLayout, "binding.mainContent");
        DrawSystemBarFrameLayout drawSystemBarFrameLayout2 = drawSystemBarFrameLayout;
        Intrinsics.checkExpressionValueIsNotNull(OneShotPreDrawListener.add(drawSystemBarFrameLayout2, new BaseNodePageActivity$initUIState$$inlined$doOnPreDraw$1(drawSystemBarFrameLayout2, this)), "OneShotPreDrawListener.add(this) { action(this) }");
        TopicNodePageBinding topicNodePageBinding4 = this.binding;
        if (topicNodePageBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        setSupportActionBar(topicNodePageBinding4.toolbar);
        setTitle(" ");
        TopicNodePageBinding topicNodePageBinding5 = this.binding;
        if (topicNodePageBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        Toolbar toolbar2 = topicNodePageBinding5.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar2, "binding.toolbar");
        ViewExtendsKt.setTintColor(toolbar2, -1);
        TopicNodePageBinding topicNodePageBinding6 = this.binding;
        if (topicNodePageBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        topicNodePageBinding6.toolbar.setTitleTextColor(-1);
        TopicNodePageBinding topicNodePageBinding7 = this.binding;
        if (topicNodePageBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        topicNodePageBinding7.toolbar.setNavigationOnClickListener(new BaseNodePageActivity$initUIState$2(this));
        BaseNodePageActivity$initUIState$toolbarContentListener$1 baseNodePageActivity$initUIState$toolbarContentListener$1 = new BaseNodePageActivity$initUIState$toolbarContentListener$1(this);
        TopicNodePageBinding topicNodePageBinding8 = this.binding;
        if (topicNodePageBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        topicNodePageBinding8.nestedBackgroundView.addOnScrollYChangedListener(baseNodePageActivity$initUIState$toolbarContentListener$1);
        VXScrollingStateHelper vXScrollingStateHelper = this.helper;
        if (vXScrollingStateHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helper");
        }
        vXScrollingStateHelper.addFloatingTopChangeListener(new BaseNodePageActivity$initUIState$3(baseNodePageActivity$initUIState$toolbarContentListener$1));
        TopicNodePageBinding topicNodePageBinding9 = this.binding;
        if (topicNodePageBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        topicNodePageBinding9.mainContent.addOnLayoutChangeListener(new BaseNodePageActivity$initUIState$4(this));
        TopicNodePageBinding topicNodePageBinding10 = this.binding;
        if (topicNodePageBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        topicNodePageBinding10.backgroundView.addOnLayoutChangeListener(new BaseNodePageActivity$initUIState$5(this));
        TopicNodePageBinding topicNodePageBinding11 = this.binding;
        if (topicNodePageBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        Toolbar toolbar3 = topicNodePageBinding11.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar3, "binding.toolbar");
        ViewExtendsKt.setOnDoubleClickListener(toolbar3, new BaseNodePageActivity$initUIState$6(this));
    }

    @Override // com.coolapk.market.view.node.NodeActivityBehavior
    public void setAppBarBackground(Drawable drawable) {
        if (drawable != null) {
            drawable.setAlpha(this.pendingAppBarBackgroundAlpha);
        }
        TopicNodePageBinding topicNodePageBinding = this.binding;
        if (topicNodePageBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = topicNodePageBinding.appBar;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.appBar");
        frameLayout.setBackground(drawable);
    }

    @Override // com.coolapk.market.view.node.NodeActivityBehavior
    public void setToolbarAlphaScrollYStartThreshold(int i) {
        this.toolbarAlphaScrollYStartThreshold = i;
    }

    @Override // com.coolapk.market.widget.DrawSystemBarFrameLayout.OnInsetChangeListener
    public void onInsetChange(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        int actionBarSize = rect.top + UiUtils.getActionBarSize(getActivity()) + ((int) this.cornerRadiusHeight);
        VXScrollingStateHelper vXScrollingStateHelper = this.helper;
        if (vXScrollingStateHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helper");
        }
        vXScrollingStateHelper.syncUIState(actionBarSize, rect.bottom);
        TopicNodePageBinding topicNodePageBinding = this.binding;
        if (topicNodePageBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = topicNodePageBinding.appBar;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.appBar");
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setPadding(frameLayout2.getPaddingLeft(), rect.top, frameLayout2.getPaddingRight(), frameLayout2.getPaddingBottom());
    }

    public final void setLoadingStart() {
        TopicNodePageBinding topicNodePageBinding = this.binding;
        if (topicNodePageBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = topicNodePageBinding.loadingContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingContainer");
        frameLayout.setVisibility(0);
        TopicNodePageBinding topicNodePageBinding2 = this.binding;
        if (topicNodePageBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ProgressBar progressBar = topicNodePageBinding2.loadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
        progressBar.setVisibility(0);
        TopicNodePageBinding topicNodePageBinding3 = this.binding;
        if (topicNodePageBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = topicNodePageBinding3.hintView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.hintView");
        textView.setVisibility(8);
        this.isLoading = true;
    }

    public final void setLoadingFinished() {
        TopicNodePageBinding topicNodePageBinding = this.binding;
        if (topicNodePageBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ProgressBar progressBar = topicNodePageBinding.loadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
        progressBar.setVisibility(8);
        TopicNodePageBinding topicNodePageBinding2 = this.binding;
        if (topicNodePageBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = topicNodePageBinding2.hintView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.hintView");
        textView.setVisibility(8);
        TopicNodePageBinding topicNodePageBinding3 = this.binding;
        if (topicNodePageBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(topicNodePageBinding3.loadingContainer, View.ALPHA, 1.0f, 0.0f).setDuration(0L);
        duration.addListener(new BaseNodePageActivity$setLoadingFinished$$inlined$also$lambda$1(this));
        duration.start();
    }

    public static /* synthetic */ void setLoadingError$default(BaseNodePageActivity baseNodePageActivity, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = "";
            }
            baseNodePageActivity.setLoadingError(str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setLoadingError");
    }

    public final void setLoadingError(String str) {
        Intrinsics.checkNotNullParameter(str, "errorText");
        TopicNodePageBinding topicNodePageBinding = this.binding;
        if (topicNodePageBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = topicNodePageBinding.loadingContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingContainer");
        frameLayout.setVisibility(0);
        TopicNodePageBinding topicNodePageBinding2 = this.binding;
        if (topicNodePageBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ProgressBar progressBar = topicNodePageBinding2.loadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
        progressBar.setVisibility(8);
        TopicNodePageBinding topicNodePageBinding3 = this.binding;
        if (topicNodePageBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = topicNodePageBinding3.hintView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.hintView");
        textView.setVisibility(0);
        TopicNodePageBinding topicNodePageBinding4 = this.binding;
        if (topicNodePageBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView2 = topicNodePageBinding4.hintView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.hintView");
        textView2.setText(str);
        TopicNodePageBinding topicNodePageBinding5 = this.binding;
        if (topicNodePageBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        topicNodePageBinding5.loadingContainer.setOnClickListener(new BaseNodePageActivity$setLoadingError$1(this));
        this.isLoading = false;
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

    public final void refreshAndScrollToTop() {
        VXScrollingStateHelper vXScrollingStateHelper = this.helper;
        if (vXScrollingStateHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helper");
        }
        if (!vXScrollingStateHelper.isFloatingViewExpandedOrAppendingExpanded()) {
            TopicNodePageBinding topicNodePageBinding = this.binding;
            if (topicNodePageBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            topicNodePageBinding.nestedBackgroundView.smoothScrollTo(0, 0);
        }
        TopicNodePageBinding topicNodePageBinding2 = this.binding;
        if (topicNodePageBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager = topicNodePageBinding2.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
        PagerAdapter adapter = scrollStateViewPager.getAdapter();
        Object instantiateItem = adapter != null ? adapter.instantiateItem((ViewGroup) scrollStateViewPager, scrollStateViewPager.getCurrentItem()) : null;
        if ((instantiateItem instanceof BaseFragment) && (instantiateItem instanceof ScrollableFragment) && ((BaseFragment) instantiateItem).isVisible()) {
            ((ScrollableFragment) instantiateItem).scrollToTop(true);
        }
    }

    @Override // com.coolapk.market.view.node.NodeActivityBehavior
    public void installBackgroundView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        TopicNodePageBinding topicNodePageBinding = this.binding;
        if (topicNodePageBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        topicNodePageBinding.backgroundView.removeAllViews();
        TopicNodePageBinding topicNodePageBinding2 = this.binding;
        if (topicNodePageBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        topicNodePageBinding2.backgroundView.addView(view, 0, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.coolapk.market.view.node.NodeActivityBehavior
    public void installToolbarContentView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        TopicNodePageBinding topicNodePageBinding = this.binding;
        if (topicNodePageBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        topicNodePageBinding.toolbarContent.removeAllViews();
        TopicNodePageBinding topicNodePageBinding2 = this.binding;
        if (topicNodePageBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        topicNodePageBinding2.toolbarContent.addView(view);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onTabEventChanged(TabEvent tabEvent) {
        boolean z;
        Intrinsics.checkNotNullParameter(tabEvent, "tabEvent");
        TopicNodePageBinding topicNodePageBinding = this.binding;
        if (topicNodePageBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager = topicNodePageBinding.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
        Object tag = scrollStateViewPager.getTag();
        Object obj = null;
        if (!(tag instanceof List)) {
            tag = null;
        }
        List list = (List) tag;
        if (list != null) {
            Iterator it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (!(next instanceof ConfigPage) || !Intrinsics.areEqual(((ConfigPage) next).getPageName(), tabEvent.getName())) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    obj = next;
                    break;
                }
            }
            if (obj != null) {
                TopicNodePageBinding topicNodePageBinding2 = this.binding;
                if (topicNodePageBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                ScrollStateViewPager scrollStateViewPager2 = topicNodePageBinding2.viewPager;
                Intrinsics.checkNotNullExpressionValue(scrollStateViewPager2, "binding.viewPager");
                scrollStateViewPager2.setCurrentItem(CollectionsKt.indexOf((List<? extends Object>) list, obj));
            }
        }
    }

    @Override // com.coolapk.market.view.node.NodeActivityBehavior
    public void installFloatingView(List<? extends ConfigPage> list, int i, Function1<? super ConfigPage, ? extends EntityListFragment> function1, ViewPager.OnPageChangeListener onPageChangeListener) {
        Intrinsics.checkNotNullParameter(list, "tabApiList");
        BaseNodePageActivity$installFloatingView$adapter$1 baseNodePageActivity$installFloatingView$adapter$1 = new BaseNodePageActivity$installFloatingView$adapter$1(this, list, function1, getSupportFragmentManager());
        TopicNodePageBinding topicNodePageBinding = this.binding;
        if (topicNodePageBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager = topicNodePageBinding.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
        scrollStateViewPager.setTag(list);
        TopicNodePageBinding topicNodePageBinding2 = this.binding;
        if (topicNodePageBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager2 = topicNodePageBinding2.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager2, "binding.viewPager");
        scrollStateViewPager2.setVisibility(0);
        TopicNodePageBinding topicNodePageBinding3 = this.binding;
        if (topicNodePageBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager3 = topicNodePageBinding3.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager3, "binding.viewPager");
        scrollStateViewPager3.setAdapter(baseNodePageActivity$installFloatingView$adapter$1);
        TopicNodePageBinding topicNodePageBinding4 = this.binding;
        if (topicNodePageBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TabLayout tabLayout = topicNodePageBinding4.tabs;
        ViewExtendsKt.setV9TabUI(tabLayout, 0);
        ViewExtendsKt.setV9TabColor(tabLayout, false);
        TopicNodePageBinding topicNodePageBinding5 = this.binding;
        if (topicNodePageBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        tabLayout.setupWithViewPager(topicNodePageBinding5.viewPager);
        TopicNodePageBinding topicNodePageBinding6 = this.binding;
        if (topicNodePageBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager4 = topicNodePageBinding6.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager4, "binding.viewPager");
        ViewExtendsKt.setDefaultDoubleClickListener(tabLayout, scrollStateViewPager4);
        BaseActivity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        BaseActivity baseActivity = activity;
        TopicNodePageBinding topicNodePageBinding7 = this.binding;
        if (topicNodePageBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager5 = topicNodePageBinding7.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager5, "binding.viewPager");
        List<? extends ConfigPage> list2 = list;
        Object[] array = list2.toArray(new ConfigPage[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        ViewExtendsKt.setDefaultSubTabConfigListener(tabLayout, baseActivity, scrollStateViewPager5, (ConfigPage[]) array);
        tabLayout.setTabIndicatorMarginBottom(NumberExtendsKt.getDp(Double.valueOf(7.5d)));
        if (onPageChangeListener != null) {
            TopicNodePageBinding topicNodePageBinding8 = this.binding;
            if (topicNodePageBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            topicNodePageBinding8.viewPager.addOnPageChangeListener(onPageChangeListener);
        }
        TopicNodePageBinding topicNodePageBinding9 = this.binding;
        if (topicNodePageBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager6 = topicNodePageBinding9.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager6, "binding.viewPager");
        scrollStateViewPager6.setCurrentItem(KotlinExtendKt.constrain(i, list.size() - 1, 0));
        TopicNodePageBinding topicNodePageBinding10 = this.binding;
        if (topicNodePageBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        topicNodePageBinding10.viewPager.addOnPageChangeListener(new BaseNodePageActivity$installFloatingView$3(this, baseNodePageActivity$installFloatingView$adapter$1));
        BaseActivity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        BaseActivity baseActivity2 = activity2;
        TopicNodePageBinding topicNodePageBinding11 = this.binding;
        if (topicNodePageBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager7 = topicNodePageBinding11.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager7, "binding.viewPager");
        Object[] array2 = list2.toArray(new ConfigPage[0]);
        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
        DataListViewPagerConverter.SubConfigPageTabListener subConfigPageTabListener = new DataListViewPagerConverter.SubConfigPageTabListener(baseActivity2, scrollStateViewPager7, (ConfigPage[]) array2);
        TopicNodePageBinding topicNodePageBinding12 = this.binding;
        if (topicNodePageBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        topicNodePageBinding12.tabs.addOnTabSelectedListener(subConfigPageTabListener);
        TopicNodePageBinding topicNodePageBinding13 = this.binding;
        if (topicNodePageBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TabLayout tabLayout2 = topicNodePageBinding13.tabs;
        TopicNodePageBinding topicNodePageBinding14 = this.binding;
        if (topicNodePageBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager8 = topicNodePageBinding14.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager8, "binding.viewPager");
        TabLayout.Tab tabAt = tabLayout2.getTabAt(scrollStateViewPager8.getCurrentItem());
        if (tabAt != null) {
            Intrinsics.checkNotNullExpressionValue(tabAt, "this");
            subConfigPageTabListener.onTabSelected(tabAt);
        }
        TopicNodePageBinding topicNodePageBinding15 = this.binding;
        if (topicNodePageBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        topicNodePageBinding15.tabs.addOnTabSelectedListener(new BaseNodePageActivity$installFloatingView$5(this));
        TopicNodePageBinding topicNodePageBinding16 = this.binding;
        if (topicNodePageBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = topicNodePageBinding16.contentView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.contentView");
        GradientDrawable gradientDrawable = new GradientDrawable();
        float f = this.cornerRadiusHeight;
        gradientDrawable.setCornerRadii(new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f});
        gradientDrawable.setColor(AppHolder.getAppTheme().getContentBackgroundColor());
        Unit unit = Unit.INSTANCE;
        linearLayout.setBackground(gradientDrawable);
        TopicNodePageBinding topicNodePageBinding17 = this.binding;
        if (topicNodePageBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View view = topicNodePageBinding17.divider;
        Intrinsics.checkNotNullExpressionValue(view, "binding.divider");
        view.setBackground(ResourceUtils.getDrawable(this, AppHolder.getAppTheme().isDarkTheme() ? 2131099924 : 2131099925));
        installFloatingButton();
    }

    private final void installFloatingButton() {
        BaseNodePageActivity$installFloatingButton$floatingActionButtonListener$1 baseNodePageActivity$installFloatingButton$floatingActionButtonListener$1 = new BaseNodePageActivity$installFloatingButton$floatingActionButtonListener$1(this);
        TopicNodePageBinding topicNodePageBinding = this.binding;
        if (topicNodePageBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        topicNodePageBinding.viewPager.addOnPageChangeListener(baseNodePageActivity$installFloatingButton$floatingActionButtonListener$1);
        VXScrollingStateHelper vXScrollingStateHelper = this.helper;
        if (vXScrollingStateHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helper");
        }
        vXScrollingStateHelper.addFloatingTopChangeListener(new BaseNodePageActivity$installFloatingButton$1(baseNodePageActivity$installFloatingButton$floatingActionButtonListener$1));
        TopicNodePageBinding topicNodePageBinding2 = this.binding;
        if (topicNodePageBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        topicNodePageBinding2.viewPager.post(new BaseNodePageActivity$installFloatingButton$2(this, baseNodePageActivity$installFloatingButton$floatingActionButtonListener$1));
    }
}
