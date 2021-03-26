package com.coolapk.market.view.theme;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.databinding.ThemePickerListItemBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.util.ATEUtil;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.FragmentUtils;
import com.coolapk.market.util.NightModeHelper;
import com.coolapk.market.util.StatusBarUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.AlphaToolbarActivity;
import com.coolapk.market.view.base.WrapDialogFragment;
import com.coolapk.market.view.base.refresh.LocalMultiTypeFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import kotlin.jvm.functions.Function1;
import rx.functions.Action4;

public class ThemeListActivity extends AlphaToolbarActivity {
    @Override // com.coolapk.market.view.base.BaseActivity
    public void onAppThemeChange(AppTheme appTheme) {
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setToolbarTitle(getString(2131887303));
        this.binding.mainContent.addOnInsetChangeListener(new DrawSystemBarFrameLayout.OnInsetChangeListener() {
            /* class com.coolapk.market.view.theme.$$Lambda$ThemeListActivity$r6eiCtv2ZrSRFVxQiwZQf5tvLaY */

            @Override // com.coolapk.market.widget.DrawSystemBarFrameLayout.OnInsetChangeListener
            public final void onInsetChange(Rect rect) {
                ThemeListActivity.this.lambda$onCreate$0$ThemeListActivity(rect);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$ThemeListActivity(Rect rect) {
        this.binding.contentView.setPadding(0, UiUtils.getActionBarSize(this) + rect.top, 0, 0);
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity
    public Fragment onCreateFragment() {
        return new ThemePickerFragment();
    }

    public static class ThemePickerFragment extends LocalMultiTypeFragment<AppTheme.ThemeItem> {
        private int oldColor;

        @Override // com.coolapk.market.view.base.refresh.LocalMultiTypeFragment, androidx.fragment.app.Fragment
        public void onViewCreated(View view, Bundle bundle) {
            super.onViewCreated(view, bundle);
            getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        }

        @Override // com.coolapk.market.view.base.refresh.LocalMultiTypeFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            if (getActivity() instanceof AlphaToolbarActivity) {
                int navigationBarHeight = ((AlphaToolbarActivity) getActivity()).getNavigationBarHeight();
                if (navigationBarHeight == 0) {
                    navigationBarHeight = DisplayUtils.dp2px(getActivity(), 64.0f);
                }
                getRecyclerView().setPadding(0, 0, 0, navigationBarHeight);
            }
            getRecyclerView().setPadding(0, 0, 0, ((ThemeListActivity) getActivity()).getNavigationBarHeight() + DisplayUtils.dp2px(getActivity(), 16.0f));
            getRecyclerView().setClipChildren(false);
            getRecyclerView().setClipToPadding(false);
            getAdapter().register(SimpleViewHolderFactor.withLayoutId(2131559196).constructor(new Function1<View, RecyclerView.ViewHolder>() {
                /* class com.coolapk.market.view.theme.ThemeListActivity.ThemePickerFragment.AnonymousClass1 */

                public RecyclerView.ViewHolder invoke(View view) {
                    return new ThemeViewHolder(view, new ItemActionHandler() {
                        /* class com.coolapk.market.view.theme.ThemeListActivity.ThemePickerFragment.AnonymousClass1.AnonymousClass1 */

                        @Override // com.coolapk.market.viewholder.ItemActionHandler
                        public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                            super.onItemClick(viewHolder, view);
                            if (!UiUtils.isInvalidPosition(viewHolder.getAdapterPosition())) {
                                ThemePickerFragment.this.selectTheme((AppTheme.ThemeItem) ThemePickerFragment.this.getDataList().get(viewHolder.getAdapterPosition()), view);
                            }
                        }
                    });
                }
            }).suitedClass(AppTheme.ThemeItem.class).build());
            initData();
        }

        /* access modifiers changed from: private */
        public void selectTheme(final AppTheme.ThemeItem themeItem, final View view) {
            boolean isNightTheme = AppTheme.isNightTheme(AppHolder.getAppTheme().getCurrentThemeId());
            boolean isNightTheme2 = AppTheme.isNightTheme(themeItem.getThemeId());
            boolean booleanPref = AppHolder.getAppSetting().getBooleanPref("follow_system_day_night_mode");
            if (!booleanPref || isNightTheme2 == isNightTheme) {
                if (booleanPref && themeItem.getThemeId().equals("amoled")) {
                    DataManager.getInstance().getPreferencesEditor().putBoolean("set_night_mode_to_pure_black", true).apply();
                }
                if (themeItem.isCustomTheme()) {
                    showColorPicker(themeItem);
                    return;
                }
                this.oldColor = AppHolder.getAppTheme().getColorPrimary();
                AppHolder.getAppTheme().setThemeId((AppCompatActivity) requireActivity(), themeItem.getThemeId(), true);
                onThemeChange(view.findViewById(2131363533));
            } else if (NightModeHelper.isThisRomSupportSystemTheme()) {
                AlertDialog create = new AlertDialog.Builder(getActivity()).setMessage("当前夜间主题跟随系统设置，手动切换日夜模式需要关闭跟随系统，确定要取消跟随么？").setPositiveButton("取消跟随", new DialogInterface.OnClickListener() {
                    /* class com.coolapk.market.view.theme.ThemeListActivity.ThemePickerFragment.AnonymousClass2 */

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DataManager.getInstance().getPreferencesEditor().putBoolean("follow_system_day_night_mode", false).apply();
                        ThemePickerFragment.this.selectTheme(themeItem, view);
                    }
                }).setNegativeButton("保持跟随", (DialogInterface.OnClickListener) null).create();
                WrapDialogFragment wrapDialogFragment = new WrapDialogFragment();
                wrapDialogFragment.setPendingDialog(create);
                wrapDialogFragment.show(requireActivity().getSupportFragmentManager(), (String) null);
            } else {
                DataManager.getInstance().getPreferencesEditor().putBoolean("follow_system_day_night_mode", false).apply();
                selectTheme(themeItem, view);
            }
        }

        @Override // com.coolapk.market.app.InitBehavior
        public void initData() {
            getDataList().addAll(AppHolder.getAppTheme().getColorPickerThemeList());
        }

        private void showColorPicker(AppTheme.ThemeItem themeItem) {
            CustomThemeFragment customThemeFragment = new CustomThemeFragment();
            int[] customThemeColor = AppHolder.getAppTheme().getCustomThemeColor(requireActivity());
            customThemeFragment.setInitValue(Integer.valueOf(customThemeColor[0]), Integer.valueOf(customThemeColor[1]), AppHolder.getAppTheme().isCustomThemeDarkMode());
            customThemeFragment.setResultListener(new Action4<Integer, Integer, Boolean, View>() {
                /* class com.coolapk.market.view.theme.ThemeListActivity.ThemePickerFragment.AnonymousClass3 */

                public void call(Integer num, Integer num2, Boolean bool, View view) {
                    ThemePickerFragment.this.oldColor = AppHolder.getAppTheme().getColorPrimary();
                    AppHolder.getAppTheme().setCustomTheme((AppCompatActivity) ThemePickerFragment.this.requireActivity(), num.intValue(), num2.intValue(), bool.booleanValue());
                    ThemePickerFragment.this.onThemeChange(view);
                }
            });
            customThemeFragment.show(getChildFragmentManager(), (String) null);
        }

        /* access modifiers changed from: private */
        public void onThemeChange(View view) {
            if (view == null) {
                AppTheme appTheme = AppHolder.getAppTheme();
                if (AppTheme.isDarkTheme(appTheme.getLastResourceThemeId()) || AppTheme.isDarkTheme(appTheme.getCurrentThemeId())) {
                    startAlphaViewAnimation();
                } else {
                    startGradientColorAnimation();
                }
            } else {
                startRevealAnimation(view);
            }
            StatisticHelper.getInstance().recordThemeEvent(StringUtils.emptyIfNull(AppHolder.getAppTheme().getThemItemById(AppHolder.getAppTheme().getCurrentThemeId()).getLabel()));
        }

        private void startRevealAnimation(View view) {
            AppTheme appTheme = AppHolder.getAppTheme();
            ThemeListActivity themeListActivity = (ThemeListActivity) getActivity();
            ThemeUtils.startThemeChangeRevealAnimation(getActivity(), view);
            themeListActivity.getAppBar().setBackgroundColor(appTheme.getColorPrimary());
            themeListActivity.setupStatusBar();
            themeListActivity.setNavigationBarColor(150);
            ViewExtendsKt.setTintColor(themeListActivity.getToolbar());
            FragmentUtils.cloneFragment(themeListActivity.getSupportFragmentManager(), 2131362316, null);
            themeListActivity.getSupportFragmentManager().executePendingTransactions();
        }

        private void startAlphaViewAnimation() {
            AppTheme appTheme = AppHolder.getAppTheme();
            ThemeListActivity themeListActivity = (ThemeListActivity) getActivity();
            ThemeUtils.startThemeChangeAlphaAnimation(getActivity());
            themeListActivity.getAppBar().setBackgroundColor(appTheme.getColorPrimary());
            themeListActivity.setupStatusBar();
            themeListActivity.setNavigationBarColor(150);
            ViewExtendsKt.setTintColor(themeListActivity.getToolbar());
            FragmentUtils.cloneFragment(themeListActivity.getSupportFragmentManager(), 2131362316, null);
            themeListActivity.getSupportFragmentManager().executePendingTransactions();
        }

        private void startGradientColorAnimation() {
            getAdapter().notifyDataSetChanged();
            AppTheme appTheme = AppHolder.getAppTheme();
            final ThemeListActivity themeListActivity = (ThemeListActivity) getActivity();
            final Toolbar toolbar = themeListActivity.getToolbar();
            themeListActivity.setupStatusBar();
            final View fakeContentStatusBarView = StatusBarUtils.getFakeContentStatusBarView(getActivity());
            ViewExtendsKt.setTintColor(themeListActivity.getToolbar());
            final boolean z = !AppHolder.getAppSetting().getBooleanPref("transparent_status_bar");
            int color = appTheme.getThemItemById(appTheme.getCurrentThemeId()).getColor();
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setDuration(400L);
            valueAnimator.setIntValues(this.oldColor, color);
            valueAnimator.setEvaluator(new ArgbEvaluator());
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.coolapk.market.view.theme.ThemeListActivity.ThemePickerFragment.AnonymousClass4 */

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    toolbar.setBackgroundColor(intValue);
                    if (z) {
                        fakeContentStatusBarView.setBackgroundColor(ColorUtils.darkerColor(intValue, 0.85f));
                    } else {
                        fakeContentStatusBarView.setBackgroundColor(intValue);
                    }
                    if (AppHolder.getAppSetting().getBooleanPref("navigation_bar_color") && ThemePickerFragment.this.isAdded()) {
                        themeListActivity.setNavigationBarColor(150);
                    }
                }
            });
            valueAnimator.addListener(new AnimatorListenerAdapter() {
                /* class com.coolapk.market.view.theme.ThemeListActivity.ThemePickerFragment.AnonymousClass5 */

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                }
            });
            valueAnimator.start();
        }

        public static class ThemeViewHolder extends BindingViewHolder {
            public static final int LAYOUT_ID = 2131559196;

            public ThemeViewHolder(View view, ItemActionHandler itemActionHandler) {
                super(view, itemActionHandler);
            }

            @Override // com.coolapk.market.viewholder.BindingViewHolder
            public void bindTo(Object obj) {
                ThemePickerListItemBinding themePickerListItemBinding = (ThemePickerListItemBinding) getBinding();
                AppTheme.ThemeItem themeItem = (AppTheme.ThemeItem) obj;
                themePickerListItemBinding.setThemeItem(themeItem);
                themePickerListItemBinding.setViewHolder(this);
                if (themeItem.isCustomTheme()) {
                    themePickerListItemBinding.checkIndicator.setImageResource(2131231210);
                } else if (themeItem.isCurrentTheme()) {
                    themePickerListItemBinding.checkIndicator.setImageResource(2131231256);
                } else {
                    themePickerListItemBinding.checkIndicator.setImageDrawable(null);
                }
                themePickerListItemBinding.checkIndicator.setBackgroundResource(2131231885);
                themePickerListItemBinding.checkIndicator.setBackgroundTintList(ColorStateList.valueOf(getIndicatorColor(themeItem)));
                themePickerListItemBinding.textView.setTextColor(getBackgroundTintColor(themeItem));
                themePickerListItemBinding.textView.setBackgroundTintList(ColorStateList.valueOf(getBackgroundTintColor(themeItem)));
                themePickerListItemBinding.colorText.setTextColor(getIndicatorColor(themeItem));
                themePickerListItemBinding.executePendingBindings();
            }

            private int getIndicatorColor(AppTheme.ThemeItem themeItem) {
                int color = themeItem.getColor();
                if (!themeItem.getThemeId().equals("orange") && ATEUtil.isColorLight(color)) {
                    return ColorUtils.darkerColor(color, 0.5f);
                }
                if (color == -16777216) {
                    return -13421773;
                }
                return color;
            }

            public int getBackgroundTintColor(AppTheme.ThemeItem themeItem) {
                if (themeItem.isCurrentTheme()) {
                    return getIndicatorColor(themeItem);
                }
                return -7829368;
            }
        }
    }
}
