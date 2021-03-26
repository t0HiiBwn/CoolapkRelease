package com.coolapk.market.view.base;

import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import com.coolapk.market.app.TranslucentActivity;
import com.coolapk.market.databinding.AlphaToolbarBinding;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.feedv8.FakeStatusBarActivity;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.FastReturnView;
import com.coolapk.market.widget.view.AlphableAppBarLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\b&\u0018\u0000 <2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001<B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010\u001c\u001a\u00020\fJ\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u000eH\u0016J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\n\u0010$\u001a\u0004\u0018\u00010\u001bH&J\b\u0010%\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u001bH\u0014J\u0010\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020#H\u0014J\b\u0010*\u001a\u00020!H\u0014J\u0010\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020\fH\u0014J\u0006\u0010-\u001a\u00020!J\u0006\u0010.\u001a\u00020!J\u0010\u0010/\u001a\u00020!2\b\b\u0002\u00100\u001a\u000201J\u0006\u00102\u001a\u00020!J\u0006\u00103\u001a\u00020!J\u0010\u00104\u001a\u00020!2\u0006\u00105\u001a\u000206H\u0016J\u000e\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020\u000eJ\u0012\u00109\u001a\u00020!2\b\u0010:\u001a\u0004\u0018\u000101H\u0016J\u0010\u0010;\u001a\u00020!2\u0006\u0010'\u001a\u00020\u001bH\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006="}, d2 = {"Lcom/coolapk/market/view/base/AlphaToolbarActivity;", "Lcom/coolapk/market/view/feedv8/FakeStatusBarActivity;", "Lcom/coolapk/market/view/base/AlphableToolbar;", "Lcom/coolapk/market/app/TranslucentActivity;", "()V", "binding", "Lcom/coolapk/market/databinding/AlphaToolbarBinding;", "getBinding", "()Lcom/coolapk/market/databinding/AlphaToolbarBinding;", "setBinding", "(Lcom/coolapk/market/databinding/AlphaToolbarBinding;)V", "bottom", "", "isLoading", "", "()Z", "setLoading", "(Z)V", "rect", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "setRect", "(Landroid/graphics/Rect;)V", "getAppBar", "Lcom/coolapk/market/widget/view/AlphableAppBarLayout;", "getFragment", "Landroidx/fragment/app/Fragment;", "getNavigationBarHeight", "getToolbar", "Landroidx/appcompat/widget/Toolbar;", "isNavigationBarTranslucent", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateFragment", "onEmptyViewClick", "onFragmentCreated", "fragment", "onSaveInstanceState", "outState", "onSetStatusBarColor", "onSetStatusBarDarkMode", "delay", "requestCreateFragment", "setLightElevation", "setLoadingError", "errorText", "", "setLoadingFinished", "setLoadingStart", "setToolbarAlpha", "alpha", "", "setToolbarElevationVisible", "visible", "setToolbarTitle", "title", "setupFastReturnView", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlphaToolbarActivity.kt */
public abstract class AlphaToolbarActivity extends FakeStatusBarActivity implements AlphableToolbar, TranslucentActivity {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_ALPHA = "alpha_key";
    private static final String KEY_TITLE = "title_key";
    public AlphaToolbarBinding binding;
    private int bottom;
    private boolean isLoading;
    private Rect rect;

    @Override // com.coolapk.market.app.TranslucentActivity
    public boolean isNavigationBarTranslucent() {
        return true;
    }

    public abstract Fragment onCreateFragment();

    public void onEmptyViewClick() {
    }

    protected void onFragmentCreated(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/base/AlphaToolbarActivity$Companion;", "", "()V", "KEY_ALPHA", "", "getKEY_ALPHA", "()Ljava/lang/String;", "KEY_TITLE", "getKEY_TITLE", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AlphaToolbarActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getKEY_TITLE() {
            return AlphaToolbarActivity.KEY_TITLE;
        }

        public final String getKEY_ALPHA() {
            return AlphaToolbarActivity.KEY_ALPHA;
        }
    }

    public final AlphaToolbarBinding getBinding() {
        AlphaToolbarBinding alphaToolbarBinding = this.binding;
        if (alphaToolbarBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return alphaToolbarBinding;
    }

    public final void setBinding(AlphaToolbarBinding alphaToolbarBinding) {
        Intrinsics.checkNotNullParameter(alphaToolbarBinding, "<set-?>");
        this.binding = alphaToolbarBinding;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final void setLoading(boolean z) {
        this.isLoading = z;
    }

    public final Rect getRect() {
        return this.rect;
    }

    public final void setRect(Rect rect2) {
        this.rect = rect2;
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        boolean z = true;
        setContentBarAlwaysTranslucent(true);
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, 2131558457);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…, R.layout.alpha_toolbar)");
        AlphaToolbarBinding alphaToolbarBinding = (AlphaToolbarBinding) contentView;
        this.binding = alphaToolbarBinding;
        if (alphaToolbarBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        setSupportActionBar(alphaToolbarBinding.toolbar);
        setTitle("");
        if (bundle == null) {
            setToolbarTitle("");
            setToolbarAlpha(1.0f);
        } else {
            setToolbarTitle(bundle.getString(KEY_TITLE));
            Float valueOf = Float.valueOf(bundle.getFloat(KEY_ALPHA));
            if (valueOf.floatValue() < 0.0f) {
                z = false;
            }
            if (!Boolean.valueOf(z).booleanValue()) {
                valueOf = null;
            }
            if (valueOf == null) {
                valueOf = Float.valueOf(1.0f);
            }
            setToolbarAlpha(valueOf.floatValue());
        }
        AlphaToolbarBinding alphaToolbarBinding2 = this.binding;
        if (alphaToolbarBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        alphaToolbarBinding2.mainContent.addOnInsetChangeListener(new AlphaToolbarActivity$onCreate$3(this));
        AlphaToolbarBinding alphaToolbarBinding3 = this.binding;
        if (alphaToolbarBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewUtil.doubleClickListener(alphaToolbarBinding3.toolbar, new AlphaToolbarActivity$onCreate$4(this));
        AlphaToolbarBinding alphaToolbarBinding4 = this.binding;
        if (alphaToolbarBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        alphaToolbarBinding4.toolbar.setNavigationOnClickListener(new AlphaToolbarActivity$onCreate$5(this));
        requestCreateFragment();
    }

    public final int getNavigationBarHeight() {
        AlphaToolbarBinding alphaToolbarBinding = this.binding;
        if (alphaToolbarBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        DrawSystemBarFrameLayout drawSystemBarFrameLayout = alphaToolbarBinding.mainContent;
        Intrinsics.checkNotNullExpressionValue(drawSystemBarFrameLayout, "binding.mainContent");
        return Math.abs(drawSystemBarFrameLayout.getLastInsetsRect().height());
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarDarkMode(int i) {
        ThemeUtils.setDarkStatusIconBar(getActivity(), false, i);
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    public final void requestCreateFragment() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(2131362322);
        if (findFragmentById == null) {
            findFragmentById = onCreateFragment();
        }
        if (findFragmentById != null && !findFragmentById.isAdded()) {
            getSupportFragmentManager().beginTransaction().add(2131362322, findFragmentById).commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
            setupFastReturnView(findFragmentById);
            onFragmentCreated(findFragmentById);
        }
    }

    protected void setupFastReturnView(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FastReturnView fastReturnView = new FastReturnView(this);
        AlphaToolbarBinding alphaToolbarBinding = this.binding;
        if (alphaToolbarBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        DrawSystemBarFrameLayout drawSystemBarFrameLayout = alphaToolbarBinding.mainContent;
        Intrinsics.checkNotNullExpressionValue(drawSystemBarFrameLayout, "binding.mainContent");
        fastReturnView.addTo(drawSystemBarFrameLayout);
        fastReturnView.bindFragment(fragment);
    }

    public final Fragment getFragment() {
        return getSupportFragmentManager().findFragmentById(2131362322);
    }

    public final Toolbar getToolbar() {
        AlphaToolbarBinding alphaToolbarBinding = this.binding;
        if (alphaToolbarBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        Toolbar toolbar = alphaToolbarBinding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "binding.toolbar");
        return toolbar;
    }

    public final AlphableAppBarLayout getAppBar() {
        AlphaToolbarBinding alphaToolbarBinding = this.binding;
        if (alphaToolbarBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AlphableAppBarLayout alphableAppBarLayout = alphaToolbarBinding.appBar;
        Intrinsics.checkNotNullExpressionValue(alphableAppBarLayout, "binding.appBar");
        return alphableAppBarLayout;
    }

    @Override // com.coolapk.market.view.base.AlphableToolbar
    public void setToolbarTitle(String str) {
        AlphaToolbarBinding alphaToolbarBinding = this.binding;
        if (alphaToolbarBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        alphaToolbarBinding.appBar.setToolbarTitle(str);
    }

    @Override // com.coolapk.market.view.base.AlphableToolbar
    public void setToolbarAlpha(float f) {
        AlphaToolbarBinding alphaToolbarBinding = this.binding;
        if (alphaToolbarBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        alphaToolbarBinding.appBar.setBackgroundAlpha(f);
    }

    public final void setToolbarElevationVisible(boolean z) {
        AlphaToolbarBinding alphaToolbarBinding = this.binding;
        if (alphaToolbarBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        alphaToolbarBinding.appBar.setElevationVisible(z);
    }

    public final void setLightElevation() {
        AlphaToolbarBinding alphaToolbarBinding = this.binding;
        if (alphaToolbarBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        alphaToolbarBinding.appBar.setLightElevation();
    }

    public final void setLoadingStart() {
        AlphaToolbarBinding alphaToolbarBinding = this.binding;
        if (alphaToolbarBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = alphaToolbarBinding.loadingContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingContainer");
        frameLayout.setVisibility(0);
        AlphaToolbarBinding alphaToolbarBinding2 = this.binding;
        if (alphaToolbarBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ProgressBar progressBar = alphaToolbarBinding2.loadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
        progressBar.setVisibility(0);
        AlphaToolbarBinding alphaToolbarBinding3 = this.binding;
        if (alphaToolbarBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = alphaToolbarBinding3.hintView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.hintView");
        textView.setVisibility(8);
        this.isLoading = true;
    }

    public final void setLoadingFinished() {
        AlphaToolbarBinding alphaToolbarBinding = this.binding;
        if (alphaToolbarBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ProgressBar progressBar = alphaToolbarBinding.loadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
        progressBar.setVisibility(8);
        AlphaToolbarBinding alphaToolbarBinding2 = this.binding;
        if (alphaToolbarBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = alphaToolbarBinding2.hintView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.hintView");
        textView.setVisibility(8);
        AlphaToolbarBinding alphaToolbarBinding3 = this.binding;
        if (alphaToolbarBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(alphaToolbarBinding3.loadingContainer, View.ALPHA, 1.0f, 0.0f);
        ofFloat.addListener(new AlphaToolbarActivity$setLoadingFinished$$inlined$also$lambda$1(this));
        ofFloat.start();
    }

    public static /* synthetic */ void setLoadingError$default(AlphaToolbarActivity alphaToolbarActivity, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = "";
            }
            alphaToolbarActivity.setLoadingError(str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setLoadingError");
    }

    public final void setLoadingError(String str) {
        Intrinsics.checkNotNullParameter(str, "errorText");
        AlphaToolbarBinding alphaToolbarBinding = this.binding;
        if (alphaToolbarBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = alphaToolbarBinding.loadingContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingContainer");
        frameLayout.setVisibility(0);
        AlphaToolbarBinding alphaToolbarBinding2 = this.binding;
        if (alphaToolbarBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ProgressBar progressBar = alphaToolbarBinding2.loadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
        progressBar.setVisibility(8);
        AlphaToolbarBinding alphaToolbarBinding3 = this.binding;
        if (alphaToolbarBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = alphaToolbarBinding3.hintView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.hintView");
        textView.setVisibility(0);
        AlphaToolbarBinding alphaToolbarBinding4 = this.binding;
        if (alphaToolbarBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView2 = alphaToolbarBinding4.hintView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.hintView");
        textView2.setText(str);
        AlphaToolbarBinding alphaToolbarBinding5 = this.binding;
        if (alphaToolbarBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        alphaToolbarBinding5.loadingContainer.setOnClickListener(new AlphaToolbarActivity$setLoadingError$1(this));
        this.isLoading = false;
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        String str = KEY_TITLE;
        CharSequence title = getToolbar().getTitle();
        bundle.putString(str, title != null ? title.toString() : null);
        String str2 = KEY_ALPHA;
        AlphaToolbarBinding alphaToolbarBinding = this.binding;
        if (alphaToolbarBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        bundle.putFloat(str2, alphaToolbarBinding.appBar.getBgAlpha());
        super.onSaveInstanceState(bundle);
    }
}
