package com.coolapk.market.view.base;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.OneShotPreDrawListener;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.VxLayoutBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.feedv8.FakeStatusBarActivity;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.coolapk.market.widget.view.IgnoreInsetFrameLayout;
import com.coolapk.market.widget.view.MaxWidthFrameLayout;
import com.coolapk.market.widget.view.TabLayout;
import com.coolapk.market.widget.view.VXNestedScrollView;
import com.coolapk.market.widget.view.VXProxyFloatingView;
import com.coolapk.market.widget.view.VXScrollingStateHelper;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoolApkVXNestBaseActivity.kt */
public final class CoolApkVXNestBaseActivity extends FakeStatusBarActivity {
    private VxLayoutBinding binding;
    private final float cornerRadiusHeight = ((float) NumberExtendsKt.getDp((Number) 12));
    private VXScrollingStateHelper helper;

    public static final /* synthetic */ VxLayoutBinding access$getBinding$p(CoolApkVXNestBaseActivity coolApkVXNestBaseActivity) {
        VxLayoutBinding vxLayoutBinding = coolApkVXNestBaseActivity.binding;
        if (vxLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return vxLayoutBinding;
    }

    public static final /* synthetic */ VXScrollingStateHelper access$getHelper$p(CoolApkVXNestBaseActivity coolApkVXNestBaseActivity) {
        VXScrollingStateHelper vXScrollingStateHelper = coolApkVXNestBaseActivity.helper;
        if (vXScrollingStateHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helper");
        }
        return vXScrollingStateHelper;
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        setContentBarAlwaysTranslucent(true);
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, 2131559310);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…this, R.layout.vx_layout)");
        VxLayoutBinding vxLayoutBinding = (VxLayoutBinding) contentView;
        this.binding = vxLayoutBinding;
        if (vxLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = vxLayoutBinding.appendView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.appendView");
        VxLayoutBinding vxLayoutBinding2 = this.binding;
        if (vxLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        VXProxyFloatingView vXProxyFloatingView = vxLayoutBinding2.floatingView;
        Intrinsics.checkNotNullExpressionValue(vXProxyFloatingView, "binding.floatingView");
        VxLayoutBinding vxLayoutBinding3 = this.binding;
        if (vxLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        VXNestedScrollView vXNestedScrollView = vxLayoutBinding3.nestedBackgroundView;
        Intrinsics.checkNotNullExpressionValue(vXNestedScrollView, "binding.nestedBackgroundView");
        this.helper = new VXScrollingStateHelper(frameLayout, vXProxyFloatingView, vXNestedScrollView, (int) this.cornerRadiusHeight);
        initState();
        installBackgroundView();
        installViewAppendView();
    }

    private final void initState() {
        VxLayoutBinding vxLayoutBinding = this.binding;
        if (vxLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        DrawSystemBarFrameLayout drawSystemBarFrameLayout = vxLayoutBinding.mainContent;
        Intrinsics.checkNotNullExpressionValue(drawSystemBarFrameLayout, "binding.mainContent");
        DrawSystemBarFrameLayout drawSystemBarFrameLayout2 = drawSystemBarFrameLayout;
        Intrinsics.checkExpressionValueIsNotNull(OneShotPreDrawListener.add(drawSystemBarFrameLayout2, new CoolApkVXNestBaseActivity$initState$$inlined$doOnPreDraw$1(drawSystemBarFrameLayout2, this)), "OneShotPreDrawListener.add(this) { action(this) }");
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private final void installBackgroundView() {
        ImageView imageView = new ImageView(getActivity());
        BaseActivity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        MaxWidthFrameLayout maxWidthFrameLayout = new MaxWidthFrameLayout(activity);
        maxWidthFrameLayout.setAspectRatio(0.30353817f);
        maxWidthFrameLayout.addView(imageView, -1, -1);
        VxLayoutBinding vxLayoutBinding = this.binding;
        if (vxLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        vxLayoutBinding.backgroundView.addView(maxWidthFrameLayout, -1, -2);
        VxLayoutBinding vxLayoutBinding2 = this.binding;
        if (vxLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        IgnoreInsetFrameLayout ignoreInsetFrameLayout = vxLayoutBinding2.backgroundView;
        Intrinsics.checkNotNullExpressionValue(ignoreInsetFrameLayout, "binding.backgroundView");
        int actionBarSize = UiUtils.getActionBarSize(getActivity());
        VXScrollingStateHelper vXScrollingStateHelper = this.helper;
        if (vXScrollingStateHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helper");
        }
        ignoreInsetFrameLayout.setMinimumHeight(actionBarSize + vXScrollingStateHelper.getCornerRadiusHeight());
        GlideApp.with((FragmentActivity) getActivity()).load("http://image.coolapk.com/feed/2019/0912/14/370727_9654_8853@326x1074.png").into(imageView);
    }

    private final void installViewAppendView() {
        BaseActivity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        CoolApkVXNestBaseActivity$installViewAppendView$adapter$1 coolApkVXNestBaseActivity$installViewAppendView$adapter$1 = new CoolApkVXNestBaseActivity$installViewAppendView$adapter$1(this, new String[]{"沙雕乐园", "今日热点", "EDC"}, ContextExtendsKt.requireAppCompatActivity(activity).getSupportFragmentManager());
        VxLayoutBinding vxLayoutBinding = this.binding;
        if (vxLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager = vxLayoutBinding.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
        scrollStateViewPager.setAdapter(coolApkVXNestBaseActivity$installViewAppendView$adapter$1);
        VxLayoutBinding vxLayoutBinding2 = this.binding;
        if (vxLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        vxLayoutBinding2.viewPager.addOnPageChangeListener(new CoolApkVXNestBaseActivity$installViewAppendView$1(this, coolApkVXNestBaseActivity$installViewAppendView$adapter$1));
        VxLayoutBinding vxLayoutBinding3 = this.binding;
        if (vxLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TabLayout tabLayout = vxLayoutBinding3.tabs;
        ViewExtendsKt.setV9TabUI(tabLayout, 0);
        ViewExtendsKt.setV9TabColor(tabLayout, false);
        VxLayoutBinding vxLayoutBinding4 = this.binding;
        if (vxLayoutBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        tabLayout.setupWithViewPager(vxLayoutBinding4.viewPager);
        VxLayoutBinding vxLayoutBinding5 = this.binding;
        if (vxLayoutBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager2 = vxLayoutBinding5.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager2, "binding.viewPager");
        ViewExtendsKt.setDefaultDoubleClickListener(tabLayout, scrollStateViewPager2);
        VxLayoutBinding vxLayoutBinding6 = this.binding;
        if (vxLayoutBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = vxLayoutBinding6.contentView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.contentView");
        GradientDrawable gradientDrawable = new GradientDrawable();
        float f = this.cornerRadiusHeight;
        gradientDrawable.setCornerRadii(new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f});
        gradientDrawable.setColor(AppHolder.getAppTheme().getContentBackgroundColor());
        Unit unit = Unit.INSTANCE;
        linearLayout.setBackground(gradientDrawable);
    }
}
