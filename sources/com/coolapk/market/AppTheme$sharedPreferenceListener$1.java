package com.coolapk.market;

import android.content.SharedPreferences;
import com.coolapk.market.manager.DataManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "key", "", "onSharedPreferenceChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppTheme.kt */
final class AppTheme$sharedPreferenceListener$1 implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ AppTheme this$0;

    AppTheme$sharedPreferenceListener$1(AppTheme appTheme) {
        this.this$0 = appTheme;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -2138219382:
                    if (str.equals("last_theme_name")) {
                        AppTheme appTheme = this.this$0;
                        String string = sharedPreferences.getString(str, "white");
                        Intrinsics.checkNotNull(string);
                        appTheme.lastWhiteThemeId = string;
                        return;
                    }
                    return;
                case 98316484:
                    if (str.equals("theme_custom_theme_dark")) {
                        this.this$0.isCustomThemeDarkMode = sharedPreferences.getBoolean(str, true);
                        return;
                    }
                    return;
                case 266738532:
                    if (str.equals("set_night_mode_to_pure_black")) {
                        this.this$0.isPureBlackNightMode = DataManager.getInstance().getPreferencesBoolean(str, false);
                        return;
                    }
                    return;
                case 549057345:
                    if (str.equals("theme_name")) {
                        AppTheme appTheme2 = this.this$0;
                        String string2 = sharedPreferences.getString(str, "white");
                        Intrinsics.checkNotNull(string2);
                        appTheme2.currentThemeId = string2;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
