package com.coolapk.market.view.feedv8;

import android.os.Bundle;
import android.view.View;
import com.coolapk.market.AppHolder;
import com.coolapk.market.event.SettingEvent;
import com.coolapk.market.util.DarkStatusBarHandler;
import com.coolapk.market.util.StatusBarUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.view.base.BaseActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0012H\u0014J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020\u0012H\u0014J\b\u0010!\u001a\u00020\u0012H\u0004R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000e¨\u0006\""}, d2 = {"Lcom/coolapk/market/view/feedv8/FakeStatusBarActivity;", "Lcom/coolapk/market/view/base/BaseActivity;", "()V", "<set-?>", "Landroid/view/View;", "contentStatusView", "getContentStatusView", "()Landroid/view/View;", "decorStatusView", "getDecorStatusView", "isContentBarAlwaysTranslucent", "", "()Z", "setContentBarAlwaysTranslucent", "(Z)V", "isToolbarColorEqualContentColor", "setToolbarColorEqualContentColor", "changeBaseTheme", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSetStatusBarColor", "onSetStatusBarDarkMode", "delay", "", "onSettingEvent", "event", "Lcom/coolapk/market/event/SettingEvent;", "onSlideChange", "percent", "", "onStart", "setupStatusBar", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FakeStatusBarActivity.kt */
public class FakeStatusBarActivity extends BaseActivity {
    private View contentStatusView;
    private View decorStatusView;
    private boolean isContentBarAlwaysTranslucent;
    private boolean isToolbarColorEqualContentColor;

    public final View getContentStatusView() {
        return this.contentStatusView;
    }

    public final View getDecorStatusView() {
        return this.decorStatusView;
    }

    protected final boolean isToolbarColorEqualContentColor() {
        return this.isToolbarColorEqualContentColor;
    }

    protected final void setToolbarColorEqualContentColor(boolean z) {
        this.isToolbarColorEqualContentColor = z;
    }

    protected final boolean isContentBarAlwaysTranslucent() {
        return this.isContentBarAlwaysTranslucent;
    }

    protected final void setContentBarAlwaysTranslucent(boolean z) {
        this.isContentBarAlwaysTranslucent = z;
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        getWindow().requestFeature(1);
        ThemeUtils.setSystemBarDrawFlags(this);
        super.onCreate(bundle);
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        setupStatusBar();
    }

    /* access modifiers changed from: protected */
    public final void setupStatusBar() {
        if (this.contentStatusView == null) {
            this.contentStatusView = StatusBarUtils.getFakeContentStatusBarView(getActivity());
            this.decorStatusView = StatusBarUtils.getFakeDecorStatusBarView(getActivity());
        }
        boolean z = true;
        if (!(this.isToolbarColorEqualContentColor || AppHolder.getAppTheme().isLightColorTheme()) || DarkStatusBarHandler.getInstance().canHandleDarkMode()) {
            z = false;
        }
        boolean booleanPref = AppHolder.getAppSetting().getBooleanPref("transparent_status_bar");
        if (this.isContentBarAlwaysTranslucent) {
            View view = this.contentStatusView;
            if (view != null) {
                view.setBackgroundColor(0);
            }
            if (z || !booleanPref) {
                View view2 = this.decorStatusView;
                if (view2 != null) {
                    view2.setBackgroundColor(ThemeUtils.getStatusBarOverlayColor());
                    return;
                }
                return;
            }
            View view3 = this.decorStatusView;
            if (view3 != null) {
                view3.setBackgroundColor(0);
            }
        } else if (this.isToolbarColorEqualContentColor) {
            View view4 = this.contentStatusView;
            if (view4 != null) {
                view4.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
            }
            if (z || !booleanPref) {
                View view5 = this.decorStatusView;
                if (view5 != null) {
                    view5.setBackgroundColor(ThemeUtils.getStatusBarOverlayColor());
                    return;
                }
                return;
            }
            View view6 = this.decorStatusView;
            if (view6 != null) {
                view6.setBackgroundColor(0);
            }
        } else {
            View view7 = this.contentStatusView;
            if (view7 != null) {
                view7.setBackgroundColor(AppHolder.getAppTheme().getColorPrimary());
            }
            if (z || !booleanPref) {
                View view8 = this.decorStatusView;
                if (view8 != null) {
                    view8.setBackgroundColor(ThemeUtils.getStatusBarOverlayColor());
                    return;
                }
                return;
            }
            View view9 = this.decorStatusView;
            if (view9 != null) {
                view9.setBackgroundColor(0);
            }
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarDarkMode(int i) {
        boolean z = this.isToolbarColorEqualContentColor || AppHolder.getAppTheme().isLightColorTheme();
        if (AppHolder.getAppSetting().getBooleanPref("transparent_status_bar")) {
            ThemeUtils.setDarkStatusIconBar(getActivity(), z ? !AppHolder.getAppTheme().isDarkTheme() : AppHolder.getAppTheme().isLightColorTheme(), i);
        } else {
            ThemeUtils.setDarkStatusIconBar(getActivity(), false, i);
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    public void changeBaseTheme() {
        super.changeBaseTheme();
        setupStatusBar();
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSlideChange(float f) {
        super.onSlideChange(f);
        View view = this.decorStatusView;
        if (view != null) {
            view.setAlpha(f);
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    public void onSettingEvent(SettingEvent settingEvent) {
        Intrinsics.checkNotNullParameter(settingEvent, "event");
        super.onSettingEvent(settingEvent);
        String str = settingEvent.key;
        if (str != null && str.hashCode() == 755630931 && str.equals("transparent_status_bar")) {
            setupStatusBar();
        }
    }
}
