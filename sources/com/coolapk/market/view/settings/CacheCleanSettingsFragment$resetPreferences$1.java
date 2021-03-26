package com.coolapk.market.view.settings;

import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.PreferencesUtils;
import com.coolapk.market.view.settings.settingsynch.SettingSynchronized;
import com.coolapk.market.widget.Toast;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: CacheCleanSettingsFragment.kt */
final class CacheCleanSettingsFragment$resetPreferences$1 implements Runnable {
    final /* synthetic */ boolean $isLogin;
    final /* synthetic */ CacheCleanSettingsFragment this$0;

    CacheCleanSettingsFragment$resetPreferences$1(CacheCleanSettingsFragment cacheCleanSettingsFragment, boolean z) {
        this.this$0 = cacheCleanSettingsFragment;
        this.$isLogin = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AppSetting appSetting = AppHolder.getAppSetting();
        Map<String, Boolean> defaultMap = AppSetting.getDefaultMap();
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        PreferencesUtils.EditorHelper preferencesEditor = instance.getPreferencesEditor();
        for (String str : defaultMap.keySet()) {
            Boolean bool = defaultMap.get(str);
            Intrinsics.checkNotNull(bool);
            preferencesEditor.putBoolean(str, bool.booleanValue());
        }
        preferencesEditor.apply();
        appSetting.setDefaultLanguage();
        appSetting.setDefaultWaterMarkPosition();
        appSetting.setDefaultPhotoViewOption();
        appSetting.setDefaultWaterMarkType();
        appSetting.setDefaultAotuNightTime();
        appSetting.setDefaultPostButton(this.this$0.getActivity());
        if (this.$isLogin) {
            SettingSynchronized.INSTANCE.reSetAllSettings();
        }
        AppSetting appSetting2 = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting2, "AppHolder.getAppSetting()");
        appSetting2.setDownloadDir(AppHolder.getAppMetadata().getDefaultDownloadDir().getAbsolutePath());
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Toast.show(requireActivity, 2131886522);
    }
}
