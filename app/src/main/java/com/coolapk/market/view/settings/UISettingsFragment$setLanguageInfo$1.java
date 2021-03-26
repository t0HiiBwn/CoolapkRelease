package com.coolapk.market.view.settings;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.main.MainActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "preference", "Landroidx/preference/Preference;", "kotlin.jvm.PlatformType", "newValue", "", "onPreferenceChange"}, k = 3, mv = {1, 4, 2})
/* compiled from: UISettingsFragment.kt */
final class UISettingsFragment$setLanguageInfo$1 implements Preference.OnPreferenceChangeListener {
    final /* synthetic */ UISettingsFragment this$0;

    UISettingsFragment$setLanguageInfo$1(UISettingsFragment uISettingsFragment) {
        this.this$0 = uISettingsFragment;
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public final boolean onPreferenceChange(Preference preference, Object obj) {
        String obj2 = obj.toString();
        if (!Intrinsics.areEqual(DataManager.getInstance().getPreferencesString("language", "system"), obj2)) {
            FragmentActivity requireActivity = this.this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            UiUtils.changeLanguage(requireActivity.getApplicationContext(), obj2);
            this.this$0.requireActivity().finish();
            Intent intent = new Intent(this.this$0.getActivity(), MainActivity.class);
            intent.addFlags(32768);
            this.this$0.requireActivity().startActivity(intent);
        }
        return true;
    }
}
