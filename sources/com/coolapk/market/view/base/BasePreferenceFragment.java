package com.coolapk.market.view.base;

import android.os.Bundle;
import android.view.View;
import androidx.preference.CheckBoxPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.manager.DataManager;
import java.util.Map;

public abstract class BasePreferenceFragment extends PreferenceFragmentCompat {
    protected abstract int getPreferencesXmlRes();

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle bundle, String str) {
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getPreferenceManager().setSharedPreferencesName(DataManager.getInstance().getDataConfig().getPreferencesName());
        addPreferencesFromResource(getPreferencesXmlRes());
        initPreferences(true);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        setDividerHeight(0);
    }

    protected void initPreferences(boolean z) {
        Map<String, Boolean> defaultMap = AppSetting.getDefaultMap();
        DataManager instance = DataManager.getInstance();
        for (String str : defaultMap.keySet()) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPrefByKey(str);
            if (checkBoxPreference != null && !instance.containsInPreferences(str)) {
                checkBoxPreference.setChecked(defaultMap.get(str).booleanValue());
            }
        }
    }

    public <T extends Preference> T findPrefByKey(CharSequence charSequence) {
        return (T) findPreference(charSequence);
    }
}
