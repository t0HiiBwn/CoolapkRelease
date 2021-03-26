package com.coolapk.market.view.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.preference.Preference;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.view.base.BasePreferenceFragment;
import com.coolapk.market.view.settings.settingsynch.SettingSynchronized;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0002J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0002J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\bH\u0002J\b\u0010\u001c\u001a\u00020\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/coolapk/market/view/settings/WaterMarkSettingsFragment;", "Lcom/coolapk/market/view/base/BasePreferenceFragment;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "()V", "listPreference", "Landroidx/preference/Preference;", "positionPreference", "summary", "", "typePreference", "getPreferencesXmlRes", "", "initPreferences", "", "init", "", "initWaterMarkSign", "onDestroy", "onPreferenceTreeClick", "preference", "onSharedPreferenceChanged", "sharedPreferences", "Landroid/content/SharedPreferences;", "key", "parsePicTypeText", "value", "parseSummaryText", "parserSummaryText", "setPhotoViewOptions", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: WaterMarkSettingsFragment.kt */
public final class WaterMarkSettingsFragment extends BasePreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final Companion Companion = new Companion(null);
    private static final String KEY = "system_config";
    private Preference listPreference;
    private Preference positionPreference;
    private String summary = "网络自适应";
    private Preference typePreference;

    @Override // com.coolapk.market.view.base.BasePreferenceFragment
    protected int getPreferencesXmlRes() {
        return 2132148250;
    }

    @Override // com.coolapk.market.view.base.BasePreferenceFragment
    protected void initPreferences(boolean z) {
        super.initPreferences(z);
        initWaterMarkSign();
        setPhotoViewOptions();
        DataManager.getInstance().registerPreferenceChangeListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        DataManager.getInstance().unregisterPreferenceChangeListener(this);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(str, "key");
        String str2 = "0";
        switch (str.hashCode()) {
            case -388415503:
                if (str.equals("photo_view_options")) {
                    String preferencesString = DataManager.getInstance().getPreferencesString(str, "AUTO");
                    Intrinsics.checkNotNullExpressionValue(preferencesString, "loadValue");
                    parserSummaryText(preferencesString);
                    Preference preference = this.listPreference;
                    if (preference != null) {
                        preference.setSummary(this.summary);
                        return;
                    }
                    return;
                }
                return;
            case 523783:
                if (str.equals("cool_picture_watermark_option")) {
                    SettingSynchronized.INSTANCE.uploadSetting(str, 0);
                    return;
                }
                return;
            case 471438219:
                if (str.equals("feed_pic_water_mark")) {
                    initWaterMarkSign();
                    boolean booleanPref = AppHolder.getAppSetting().getBooleanPref("feed_pic_water_mark");
                    String preferencesString2 = DataManager.getInstance().getPreferencesString("picture_watermark_position", "9");
                    if (booleanPref) {
                        str2 = preferencesString2;
                    }
                    SettingSynchronized settingSynchronized = SettingSynchronized.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(str2, "value");
                    settingSynchronized.uploadSetting("picture_watermark_position", str2, 1);
                    return;
                }
                return;
            case 662482821:
                if (str.equals("picture_watermark_position")) {
                    String preferencesString3 = DataManager.getInstance().getPreferencesString(str, "5");
                    Preference preference2 = this.positionPreference;
                    if (preference2 != null) {
                        Intrinsics.checkNotNullExpressionValue(preferencesString3, "loadValue");
                        preference2.setSummary(parseSummaryText(preferencesString3));
                        return;
                    }
                    return;
                }
                return;
            case 752624933:
                if (str.equals("watermark_icon_type")) {
                    String preferencesString4 = DataManager.getInstance().getPreferencesString(str, str2);
                    Preference preference3 = this.typePreference;
                    if (preference3 != null) {
                        Intrinsics.checkNotNullExpressionValue(preferencesString4, "loadValue");
                        preference3.setSummary(parsePicTypeText(preferencesString4));
                        return;
                    }
                    return;
                }
                return;
            case 1477516177:
                if (!str.equals("auto_disable_image_load")) {
                    return;
                }
                break;
            case 1557288160:
                if (!str.equals("always_load_app_icon")) {
                    return;
                }
                break;
            default:
                return;
        }
        SettingSynchronized.INSTANCE.uploadSetting(str, 0);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference preference) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        String key = preference.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case -388415503:
                    if (key.equals("photo_view_options")) {
                        ImageModeDialog newInstance = ImageModeDialog.Companion.newInstance();
                        FragmentManager childFragmentManager = getChildFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                        newInstance.show(childFragmentManager, (String) null);
                        break;
                    }
                    break;
                case 662482821:
                    if (key.equals("picture_watermark_position")) {
                        WaterMarkDialog newInstance2 = WaterMarkDialog.Companion.newInstance("position");
                        FragmentManager childFragmentManager2 = getChildFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "childFragmentManager");
                        newInstance2.show(childFragmentManager2, (String) null);
                        break;
                    }
                    break;
                case 752624933:
                    if (key.equals("watermark_icon_type")) {
                        WaterMarkDialog newInstance3 = WaterMarkDialog.Companion.newInstance("type");
                        FragmentManager childFragmentManager3 = getChildFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(childFragmentManager3, "childFragmentManager");
                        newInstance3.show(childFragmentManager3, (String) null);
                        break;
                    }
                    break;
                case 1477516177:
                    if (key.equals("auto_disable_image_load")) {
                        Preference findPreference = findPreference("always_load_app_icon");
                        boolean booleanPref = AppHolder.getAppSetting().getBooleanPref("auto_disable_image_load");
                        if (findPreference != null) {
                            findPreference.setEnabled(booleanPref);
                            break;
                        }
                    }
                    break;
            }
        }
        return super.onPreferenceTreeClick(preference);
    }

    private final void initWaterMarkSign() {
        boolean booleanPref = AppHolder.getAppSetting().getBooleanPref("feed_pic_water_mark");
        Preference findPreference = findPreference("cool_picture_watermark_option");
        if (findPreference != null) {
            findPreference.setEnabled(booleanPref);
        }
        this.positionPreference = findPreference("picture_watermark_position");
        this.typePreference = findPreference("watermark_icon_type");
        String preferencesString = DataManager.getInstance().getPreferencesString("picture_watermark_position", "9");
        Intrinsics.checkNotNullExpressionValue(preferencesString, "summaryInt");
        String parseSummaryText = parseSummaryText(preferencesString);
        Preference preference = this.positionPreference;
        if (preference != null) {
            preference.setSummary(parseSummaryText);
        }
        String preferencesString2 = DataManager.getInstance().getPreferencesString("watermark_icon_type", "0");
        Intrinsics.checkNotNullExpressionValue(preferencesString2, "type");
        String parsePicTypeText = parsePicTypeText(preferencesString2);
        Preference preference2 = this.typePreference;
        if (preference2 != null) {
            preference2.setSummary(parsePicTypeText);
        }
        Preference preference3 = this.positionPreference;
        if (preference3 != null) {
            preference3.setEnabled(booleanPref);
        }
        Preference preference4 = this.typePreference;
        if (preference4 != null) {
            preference4.setEnabled(booleanPref);
        }
    }

    private final String parseSummaryText(String str) {
        int hashCode = str.hashCode();
        if (hashCode != 48) {
            if (hashCode != 53) {
                switch (hashCode) {
                    case 55:
                        if (str.equals("7")) {
                            return "底部居左";
                        }
                        return "底部居右";
                    case 56:
                        if (str.equals("8")) {
                            return "底部居中";
                        }
                        return "底部居右";
                    case 57:
                        str.equals("9");
                        return "底部居右";
                    default:
                        return "底部居右";
                }
            } else if (str.equals("5")) {
                return "图片正中";
            } else {
                return "底部居右";
            }
        } else if (!str.equals("0")) {
            return "底部居右";
        } else {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            instance.getPreferencesEditor().putString("picture_watermark_position", "9").apply();
            return "底部居右";
        }
    }

    private final String parsePicTypeText(String str) {
        int hashCode = str.hashCode();
        if (hashCode == 48) {
            str.equals("0");
            return "文字";
        } else if (hashCode == 49 && str.equals("1")) {
            return "图标";
        } else {
            return "文字";
        }
    }

    private final void setPhotoViewOptions() {
        String preferencesString = DataManager.getInstance().getPreferencesString("photo_view_options", "AUTO");
        this.listPreference = findPreference("photo_view_options");
        Intrinsics.checkNotNullExpressionValue(preferencesString, "loadSummary");
        parserSummaryText(preferencesString);
        Preference preference = this.listPreference;
        if (preference != null) {
            preference.setSummary(this.summary);
        }
    }

    private final void parserSummaryText(String str) {
        int hashCode = str.hashCode();
        if (hashCode != -1986416409) {
            if (hashCode != -1843176421) {
                if (hashCode == 2020783 && str.equals("AUTO")) {
                    this.summary = "网络自适应";
                }
            } else if (str.equals("SOURCE")) {
                this.summary = "默认原图";
            }
        } else if (str.equals("NORMAL")) {
            this.summary = "普清";
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/settings/WaterMarkSettingsFragment$Companion;", "", "()V", "KEY", "", "newInstance", "Lcom/coolapk/market/view/settings/WaterMarkSettingsFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: WaterMarkSettingsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WaterMarkSettingsFragment newInstance() {
            Bundle bundle = new Bundle();
            WaterMarkSettingsFragment waterMarkSettingsFragment = new WaterMarkSettingsFragment();
            waterMarkSettingsFragment.setArguments(bundle);
            return waterMarkSettingsFragment;
        }
    }
}
