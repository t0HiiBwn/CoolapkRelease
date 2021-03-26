package com.coolapk.market.widget.slidr;

import android.animation.ArgbEvaluator;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.coolapk.market.widget.slidr.model.SlidrConfig;
import com.coolapk.market.widget.slidr.model.SlidrInterface;
import com.coolapk.market.widget.slidr.widget.SliderPanel;

public class Slidr {
    public static SlidrInterface attach(Activity activity) {
        return attach(activity, -1, -1);
    }

    public static SlidrInterface attach(final Activity activity, final int i, final int i2) {
        SliderPanel initSliderPanel = initSliderPanel(activity, null);
        initSliderPanel.setOnPanelSlideListener(new SliderPanel.OnPanelSlideListener() {
            /* class com.coolapk.market.widget.slidr.Slidr.AnonymousClass1 */
            private final ArgbEvaluator mEvaluator = new ArgbEvaluator();

            @Override // com.coolapk.market.widget.slidr.widget.SliderPanel.OnPanelSlideListener
            public void onOpened() {
            }

            @Override // com.coolapk.market.widget.slidr.widget.SliderPanel.OnPanelSlideListener
            public void onStateChanged(int i) {
            }

            @Override // com.coolapk.market.widget.slidr.widget.SliderPanel.OnPanelSlideListener
            public void onClosed() {
                activity.finish();
                activity.overridePendingTransition(0, 2130837505);
            }

            @Override // com.coolapk.market.widget.slidr.widget.SliderPanel.OnPanelSlideListener
            public void onSlideChange(float f) {
                int i;
                if (Build.VERSION.SDK_INT >= 21 && (i = i) != -1 && i2 != -1) {
                    activity.getWindow().setStatusBarColor(((Integer) this.mEvaluator.evaluate(f, Integer.valueOf(i), Integer.valueOf(i2))).intValue());
                }
            }
        });
        return initInterface(initSliderPanel);
    }

    public static SlidrInterface attach(final Activity activity, final SlidrConfig slidrConfig) {
        SliderPanel initSliderPanel = initSliderPanel(activity, slidrConfig);
        initSliderPanel.setOnPanelSlideListener(new SliderPanel.OnPanelSlideListener() {
            /* class com.coolapk.market.widget.slidr.Slidr.AnonymousClass2 */
            private final ArgbEvaluator mEvaluator = new ArgbEvaluator();

            @Override // com.coolapk.market.widget.slidr.widget.SliderPanel.OnPanelSlideListener
            public void onStateChanged(int i) {
                if (slidrConfig.getListener() != null) {
                    slidrConfig.getListener().onSlideStateChanged(i);
                }
            }

            @Override // com.coolapk.market.widget.slidr.widget.SliderPanel.OnPanelSlideListener
            public void onClosed() {
                if (slidrConfig.getListener() != null) {
                    slidrConfig.getListener().onSlideClosed();
                }
                activity.finish();
                activity.overridePendingTransition(0, 2130837505);
            }

            @Override // com.coolapk.market.widget.slidr.widget.SliderPanel.OnPanelSlideListener
            public void onOpened() {
                if (slidrConfig.getListener() != null) {
                    slidrConfig.getListener().onSlideOpened();
                }
            }

            @Override // com.coolapk.market.widget.slidr.widget.SliderPanel.OnPanelSlideListener
            public void onSlideChange(float f) {
                if (Build.VERSION.SDK_INT >= 21 && slidrConfig.areStatusBarColorsValid()) {
                    activity.getWindow().setStatusBarColor(((Integer) this.mEvaluator.evaluate(f, Integer.valueOf(slidrConfig.getPrimaryColor()), Integer.valueOf(slidrConfig.getSecondaryColor()))).intValue());
                }
                if (slidrConfig.getListener() != null) {
                    slidrConfig.getListener().onSlideChange(f);
                }
            }
        });
        return initInterface(initSliderPanel);
    }

    private static SliderPanel initSliderPanel(Activity activity, SlidrConfig slidrConfig) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View childAt = viewGroup.getChildAt(0);
        viewGroup.removeViewAt(0);
        SliderPanel sliderPanel = new SliderPanel(activity, childAt, slidrConfig);
        sliderPanel.setId(2131363371);
        childAt.setId(2131363370);
        sliderPanel.addView(childAt);
        viewGroup.addView(sliderPanel, 0);
        return sliderPanel;
    }

    private static SlidrInterface initInterface(final SliderPanel sliderPanel) {
        return new SlidrInterface() {
            /* class com.coolapk.market.widget.slidr.Slidr.AnonymousClass3 */

            @Override // com.coolapk.market.widget.slidr.model.SlidrInterface
            public void lock() {
                sliderPanel.lock();
            }

            @Override // com.coolapk.market.widget.slidr.model.SlidrInterface
            public void unlock() {
                sliderPanel.unlock();
            }
        };
    }
}
