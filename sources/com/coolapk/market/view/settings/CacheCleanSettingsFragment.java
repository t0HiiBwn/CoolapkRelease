package com.coolapk.market.view.settings;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.preference.Preference;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ClearCacheHelper;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.view.ad.FeedAdUtils;
import com.coolapk.market.view.base.BasePreferenceFragment;
import com.coolapk.market.view.feed.ConfirmDialog;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0014J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0002¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/settings/CacheCleanSettingsFragment;", "Lcom/coolapk/market/view/base/BasePreferenceFragment;", "()V", "clearAll", "", "clearClosedAd", "getPreferencesXmlRes", "", "initPreferences", "init", "", "onPreferenceTreeClick", "preference", "Landroidx/preference/Preference;", "resetPreferences", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CacheCleanSettingsFragment.kt */
public final class CacheCleanSettingsFragment extends BasePreferenceFragment {
    public static final Companion Companion = new Companion(null);

    @Override // com.coolapk.market.view.base.BasePreferenceFragment
    protected int getPreferencesXmlRes() {
        return 2132148227;
    }

    @Override // com.coolapk.market.view.base.BasePreferenceFragment
    protected void initPreferences(boolean z) {
        super.initPreferences(z);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference preference) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        String key = preference.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case -1270583121:
                    if (key.equals("clear_all")) {
                        clearAll();
                        return true;
                    }
                    break;
                case -1258153200:
                    if (key.equals("clear_cache")) {
                        Companion.clearCache();
                        return true;
                    }
                    break;
                case -920069112:
                    if (key.equals("reset_preferences")) {
                        resetPreferences();
                        return true;
                    }
                    break;
                case -439747484:
                    if (key.equals("clear_closed_ad")) {
                        clearClosedAd();
                        return true;
                    }
                    break;
            }
        }
        return super.onPreferenceTreeClick(preference);
    }

    private final void resetPreferences() {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        boolean isLogin = loginSession.isLogin();
        ConfirmDialog newInstance = ConfirmDialog.newInstance("", isLogin ? "你确定要重置本地和云端的设置吗？" : "你确定要重置本地的设置吗？");
        newInstance.setOnOkRunnable(new CacheCleanSettingsFragment$resetPreferences$1(this, isLogin));
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        newInstance.show(childFragmentManager, (String) null);
    }

    private final void clearAll() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ActionManager.startApplicationDetailsActivity(getActivity(), requireActivity.getPackageName());
    }

    private final void clearClosedAd() {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().remove("BAN_ADS").apply();
        FeedAdUtils.INSTANCE.cleanBanAds();
        Toast.show$default(getActivity(), "广告记录已清除", 0, false, 12, null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/settings/CacheCleanSettingsFragment$Companion;", "", "()V", "clearCache", "", "newInstance", "Lcom/coolapk/market/view/settings/CacheCleanSettingsFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CacheCleanSettingsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CacheCleanSettingsFragment newInstance() {
            Bundle bundle = new Bundle();
            CacheCleanSettingsFragment cacheCleanSettingsFragment = new CacheCleanSettingsFragment();
            cacheCleanSettingsFragment.setArguments(bundle);
            return cacheCleanSettingsFragment;
        }

        /* access modifiers changed from: private */
        public final void clearCache() {
            ClearCacheHelper.clearDiskCacheTask();
        }
    }
}
