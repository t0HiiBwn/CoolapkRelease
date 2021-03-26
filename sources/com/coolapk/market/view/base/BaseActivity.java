package com.coolapk.market.view.base;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.app.TranslucentActivity;
import com.coolapk.market.event.SettingEvent;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.SaveInstanceHelper;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.widget.slidr.Slidr;
import com.coolapk.market.widget.slidr.model.SlidrConfig;
import com.coolapk.market.widget.slidr.model.SlidrInterface;
import com.coolapk.market.widget.slidr.model.SlidrListenerAdapter;
import com.coolapk.market.widget.slidr.model.SlidrPosition;
import com.coolapk.market.widget.slidr.widget.CanvasProxyView;
import com.coolapk.market.widget.slidr.widget.SliderPanel;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public abstract class BaseActivity extends BaseVideoActivity {
    private boolean isActivityTranslucent = false;
    private boolean isCallingOnConfigurationChanged = false;
    private boolean isResume = true;
    private boolean mFragmentStateSaved = false;
    private OnBackPressListener mOnBackPressListener;
    protected SliderPanel mPanelView;
    private SlidrInterface mSlidrControler;
    private boolean shouldInitSlidr = true;

    public interface OnBackPressListener {
        boolean onBackKeyPressed();
    }

    public BaseActivity getActivity() {
        return this;
    }

    protected void initSearchMenu() {
    }

    protected void onSlideClosed() {
    }

    public boolean shouldReturnToMainActivity() {
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        TypedArray obtainStyledAttributes = getTheme().obtainStyledAttributes(new int[]{16842840});
        this.isActivityTranslucent = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        SaveInstanceHelper.getsInstance().restoreSaveInstanceState(bundle, true);
        UiUtils.changeLanguage(this, DataManager.getInstance().getPreferencesString("language", "system"));
        if (bundle == null) {
            AppHolder.getAppTheme().checkAutoTheme(this, AppHolder.getApplication().getResources().getConfiguration());
        }
        AppHolder.getAppTheme().initActivityTheme(this);
        onSetStatusBarColor();
        setNavigationBarColor();
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
        ThemeUtils.setTaskDescription(this, null, AppHolder.getAppTheme().getColorPrimary());
        onSetStatusBarDarkMode();
        initSlidr();
        initSearchMenu();
        this.mFragmentStateSaved = false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void setContentView(int i) {
        UiUtils.fixContentViewInitFailError(this);
        super.setContentView(i);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle, PersistableBundle persistableBundle) {
        SaveInstanceHelper.getsInstance().restoreSaveInstanceState(bundle, true);
        super.onPostCreate(bundle, persistableBundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        SaveInstanceHelper.getsInstance().restoreSaveInstanceState(bundle, true);
        super.onRestoreInstanceState(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mFragmentStateSaved = false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        this.mFragmentStateSaved = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStateNotSaved() {
        super.onStateNotSaved();
        this.mFragmentStateSaved = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.mFragmentStateSaved = false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mFragmentStateSaved = true;
        SaveInstanceHelper.getsInstance().saveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        try {
            super.setRequestedOrientation(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void setInitSlidrDisable() {
        if (this.mSlidrControler == null) {
            this.shouldInitSlidr = false;
            return;
        }
        throw new RuntimeException("As the slidr init in onCreate Method. Subclass must call it before super.onCreate(Bundle)");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        SliderPanel sliderPanel;
        super.onResume();
        if (AppHolder.getCurrentActivity() == this) {
            AppHolder.getAppTheme().checkAutoTheme(this, AppHolder.getApplication().getResources().getConfiguration());
        }
        this.isResume = true;
        recordResumeEvent();
        this.mFragmentStateSaved = false;
        if (this.isActivityTranslucent && (sliderPanel = this.mPanelView) != null) {
            CanvasProxyView canvasProxyView = sliderPanel.getCanvasProxyView();
            if (canvasProxyView.hasProxyView()) {
                canvasProxyView.setProxyView(null);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        Activity activityUnder;
        super.onPause();
        this.isResume = false;
        recordPauseEvent();
        if (this.isActivityTranslucent && this.mPanelView != null && !isFinishing()) {
            CanvasProxyView canvasProxyView = this.mPanelView.getCanvasProxyView();
            if (!canvasProxyView.hasProxyView() && (activityUnder = AppHolder.getActivityStackManager().getActivityUnder(this, true)) != null) {
                canvasProxyView.setProxyView(activityUnder.getWindow().getDecorView());
            }
        }
    }

    public boolean isResume() {
        return this.isResume;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (!this.isCallingOnConfigurationChanged) {
            this.isCallingOnConfigurationChanged = true;
            super.onConfigurationChanged(configuration);
            this.isCallingOnConfigurationChanged = false;
            AppHolder.getAppTheme().checkAutoTheme(getActivity(), configuration);
        }
    }

    protected void recordResumeEvent() {
        AppHolder.getThirdStatUtils().recordResumeEvent(this, getClass().getSimpleName());
    }

    protected void recordPauseEvent() {
        AppHolder.getThirdStatUtils().recordPauseEvent(this, getClass().getSimpleName());
    }

    public void postEvent(Object obj) {
        EventBus.getDefault().post(obj);
    }

    @Subscribe
    public void onAppThemeChange(AppTheme appTheme) {
        recreate();
    }

    public void changeBaseTheme() {
        AppHolder.getAppTheme().initActivityTheme(this);
        setNavigationBarColor(150);
        onSetStatusBarDarkMode(150);
    }

    @Subscribe
    public void onSettingEvent(SettingEvent settingEvent) {
        String str = settingEvent.key;
        str.hashCode();
        if (str.equals("transparent_status_bar")) {
            onSetStatusBarDarkMode();
        } else if (str.equals("navigation_bar_color")) {
            setNavigationBarColor();
        }
    }

    private void initSlidr() {
        if (this.shouldInitSlidr) {
            this.mSlidrControler = Slidr.attach(this, new SlidrConfig.Builder().position(SlidrPosition.LEFT).sensitivity(1.0f).scrimColor(-16777216).scrimStartAlpha(0.8f).scrimEndAlpha(0.0f).listener(new SlidrListenerAdapter() {
                /* class com.coolapk.market.view.base.BaseActivity.AnonymousClass1 */

                @Override // com.coolapk.market.widget.slidr.model.SlidrListenerAdapter, com.coolapk.market.widget.slidr.model.SlidrListener
                public void onSlideChange(float f) {
                    super.onSlideChange(f);
                    BaseActivity.this.onSlideChange(f);
                }

                @Override // com.coolapk.market.widget.slidr.model.SlidrListenerAdapter, com.coolapk.market.widget.slidr.model.SlidrListener
                public void onSlideClosed() {
                    super.onSlideClosed();
                    BaseActivity.this.onSlideClosed();
                }
            }).velocityThreshold(2400.0f).distanceThreshold(0.1f).edge(true).edgeSize(0.1f).build());
            if (this.mPanelView == null) {
                this.mPanelView = (SliderPanel) UiUtils.findFirstChildViewByType((ViewGroup) getWindow().getDecorView(), SliderPanel.class);
            }
            SliderPanel sliderPanel = this.mPanelView;
            if (sliderPanel != null) {
                sliderPanel.getDimView().setVisibility(4);
            }
        }
    }

    protected void onSlideChange(float f) {
        Activity activityUnder;
        SliderPanel sliderPanel = this.mPanelView;
        if (sliderPanel != null) {
            if (!this.isActivityTranslucent) {
                CanvasProxyView canvasProxyView = sliderPanel.getCanvasProxyView();
                if (f == 1.0f && canvasProxyView.hasProxyView()) {
                    canvasProxyView.setProxyView(null);
                    canvasProxyView.setX(0.0f);
                } else if (f < 1.0f) {
                    canvasProxyView.setX(getResources().getFraction(2131296258, 0, canvasProxyView.getWidth()) * f);
                    if (!canvasProxyView.hasProxyView() && (activityUnder = AppHolder.getActivityStackManager().getActivityUnder(this, true)) != null) {
                        canvasProxyView.setProxyView(activityUnder.getWindow().getDecorView());
                    }
                }
            }
            if (f == 1.0f) {
                this.mPanelView.getDimView().setVisibility(4);
            } else if (f < 1.0f) {
                this.mPanelView.getDimView().setVisibility(0);
            }
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        if (i2 == 0) {
            i2 = 2130837505;
        }
        super.overridePendingTransition(i, i2);
    }

    public void setSlidrEnable(boolean z) {
        SlidrInterface slidrInterface = this.mSlidrControler;
        if (slidrInterface != null) {
            slidrInterface.unlock();
            if (!z) {
                this.mSlidrControler.lock();
            }
        }
    }

    protected void onSetStatusBarColor() {
        ThemeUtils.setStatusBarColor(getActivity(), AppHolder.getAppTheme().getColorPrimary());
    }

    @Override // android.app.Activity
    public void finish() {
        ActionManager.checkShouldReturnToMainActivity(this);
        super.finish();
    }

    protected void onSetStatusBarDarkMode() {
        onSetStatusBarDarkMode(0);
    }

    public final void checkStatusBarDarkMode() {
        onSetStatusBarDarkMode(150);
    }

    protected void onSetStatusBarDarkMode(int i) {
        if (AppHolder.getAppSetting().getBooleanPref("transparent_status_bar")) {
            ThemeUtils.setDarkStatusIconBar(getActivity(), AppHolder.getAppTheme().isLightColorTheme(), i);
        } else {
            ThemeUtils.setDarkStatusIconBar(getActivity(), false, i);
        }
    }

    public final void setNavigationBarColor() {
        setNavigationBarColor(0);
    }

    public final void setNavigationBarColor(int i) {
        int contentBackgroundColor = AppHolder.getAppTheme().getContentBackgroundColor();
        if (this instanceof TranslucentActivity) {
            TranslucentActivity translucentActivity = (TranslucentActivity) this;
            if (ViewExtents2Kt.canHandleActivity(translucentActivity)) {
                ThemeUtils.setTranslucentNavigationBar(this);
                ViewExtents2Kt.updateNavigationBar(translucentActivity);
                return;
            }
        }
        if (AppHolder.getAppSetting().getBooleanPref("navigation_bar_color")) {
            AppTheme appTheme = AppHolder.getAppTheme();
            if (Build.VERSION.SDK_INT >= 26) {
                ThemeUtils.setNavigationBarColor(getActivity(), appTheme.getColorPrimary());
                if (i > 0) {
                    AppHolder.getMainThreadHandler().postDelayed(new Runnable() {
                        /* class com.coolapk.market.view.base.BaseActivity.AnonymousClass2 */

                        @Override // java.lang.Runnable
                        public void run() {
                            ThemeUtils.setNavigationBarLightIcon(BaseActivity.this.getActivity(), AppHolder.getAppTheme().isLightColorTheme());
                        }
                    }, (long) i);
                } else {
                    ThemeUtils.setNavigationBarLightIcon(getActivity(), appTheme.isLightColorTheme());
                }
            } else {
                ThemeUtils.setNavigationBarColor(getActivity(), appTheme.getColorPrimaryDark());
            }
        } else if (Build.VERSION.SDK_INT >= 26) {
            ThemeUtils.setNavigationBarColor(getActivity(), contentBackgroundColor);
            if (i > 0) {
                AppHolder.getMainThreadHandler().postDelayed(new Runnable() {
                    /* class com.coolapk.market.view.base.BaseActivity.AnonymousClass3 */

                    @Override // java.lang.Runnable
                    public void run() {
                        ThemeUtils.setNavigationBarLightIcon(BaseActivity.this.getActivity(), !AppHolder.getAppTheme().isDarkTheme());
                    }
                }, (long) i);
            } else {
                ThemeUtils.setNavigationBarLightIcon(getActivity(), !AppHolder.getAppTheme().isDarkTheme());
            }
        } else if (AppHolder.getAppTheme().isDarkTheme()) {
            ThemeUtils.setNavigationBarColor(getActivity(), contentBackgroundColor);
        } else {
            ThemeUtils.setNavigationBarColor(getActivity(), ResourceUtils.resolveData(getActivity(), 16843858));
        }
    }

    public void setOnBackPressListener(OnBackPressListener onBackPressListener) {
        this.mOnBackPressListener = onBackPressListener;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        OnBackPressListener onBackPressListener;
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1 || (onBackPressListener = this.mOnBackPressListener) == null || !onBackPressListener.onBackKeyPressed()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.mFragmentStateSaved) {
            super.onBackPressed();
        }
    }
}
