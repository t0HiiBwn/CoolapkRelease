package com.coolapk.market.view.wallpaper.coolpic;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.app.TranslucentActivity;
import com.coolapk.market.databinding.TipLayoutBinding;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.PreferencesUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.view.base.BaseActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\rH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/wallpaper/coolpic/TipActivity;", "Lcom/coolapk/market/view/base/BaseActivity;", "Lcom/coolapk/market/app/TranslucentActivity;", "()V", "binding", "Lcom/coolapk/market/databinding/TipLayoutBinding;", "direction", "", "isHorizontal", "", "isNavigationBarTranslucent", "isVertical", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSetStatusBarColor", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TipActivity.kt */
public final class TipActivity extends BaseActivity implements TranslucentActivity {
    public static final Companion Companion = new Companion(null);
    public static final int HORIZONTAL = 1;
    public static final String KEY_DATA = "KEY_DATA";
    public static final int VERTICAL = 0;
    private TipLayoutBinding binding;
    private int direction;

    @Override // com.coolapk.market.app.TranslucentActivity
    public boolean isNavigationBarTranslucent() {
        return true;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/wallpaper/coolpic/TipActivity$Companion;", "", "()V", "HORIZONTAL", "", "KEY_DATA", "", "VERTICAL", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TipActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        boolean z = true;
        getWindow().requestFeature(1);
        TipActivity tipActivity = this;
        ThemeUtils.setSystemBarDrawFlags(tipActivity);
        super.onCreate(bundle);
        this.direction = getIntent().getIntExtra("KEY_DATA", 0);
        ViewDataBinding contentView = DataBindingUtil.setContentView(tipActivity, 2131559198);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…his, R.layout.tip_layout)");
        TipLayoutBinding tipLayoutBinding = (TipLayoutBinding) contentView;
        this.binding = tipLayoutBinding;
        if (tipLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        tipLayoutBinding.mainContent.setOnClickListener(new TipActivity$onCreate$1(this));
        TipLayoutBinding tipLayoutBinding2 = this.binding;
        if (tipLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = tipLayoutBinding2.horizontalGuideView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.horizontalGuideView");
        int i = 8;
        imageView.setVisibility(isHorizontal() ? 0 : 8);
        TipLayoutBinding tipLayoutBinding3 = this.binding;
        if (tipLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView2 = tipLayoutBinding3.verticalGuideView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.verticalGuideView");
        if (isVertical()) {
            i = 0;
        }
        imageView2.setVisibility(i);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        PreferencesUtils.EditorHelper preferencesEditor = instance.getPreferencesEditor();
        if (this.direction != 0) {
            z = false;
        }
        preferencesEditor.putBoolean(z ? "SHOW_COOL_PIC_TIP_VERTICAL" : "SHOW_COOL_PIC_TIP_HORIZONTAL", false);
        preferencesEditor.apply();
    }

    private final boolean isHorizontal() {
        return this.direction == 1;
    }

    private final boolean isVertical() {
        return this.direction == 0;
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }
}
