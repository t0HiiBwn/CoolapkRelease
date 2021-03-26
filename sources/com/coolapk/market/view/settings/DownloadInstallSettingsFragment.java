package com.coolapk.market.view.settings;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.preference.CheckBoxPreference;
import androidx.preference.Preference;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.service.autoinstall.AutoInstallServiceV10;
import com.coolapk.market.util.RomUtils;
import com.coolapk.market.util.SystemUtils;
import com.coolapk.market.view.base.BasePreferenceFragment;
import com.coolapk.market.view.feed.ConfirmDialog;
import com.coolapk.market.widget.Toast;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0014J\"\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/view/settings/DownloadInstallSettingsFragment;", "Lcom/coolapk/market/view/base/BasePreferenceFragment;", "()V", "checkAutoInstallService", "", "getPreferencesXmlRes", "", "initPreferences", "init", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onPreferenceTreeClick", "preference", "Landroidx/preference/Preference;", "onResume", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DownloadInstallSettingsFragment.kt */
public final class DownloadInstallSettingsFragment extends BasePreferenceFragment {
    public static final String COOL_INSTALLER_ACCESSIBILITY_SERVICE = "com.coolapk.autoinstaller/com.coolapk.autoinstaller.services.AutoInstallAccessibilityServices";
    public static final Companion Companion = new Companion(null);
    private static final int REQUEST_CODE = 233;

    @Override // com.coolapk.market.view.base.BasePreferenceFragment
    protected int getPreferencesXmlRes() {
        return 2132148229;
    }

    @Override // com.coolapk.market.view.base.BasePreferenceFragment
    protected void initPreferences(boolean z) {
        super.initPreferences(z);
        Preference findPrefByKey = findPrefByKey("download_dir");
        Intrinsics.checkNotNullExpressionValue(findPrefByKey, "downloadDir");
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        findPrefByKey.setSummary(appSetting.getDownloadDir());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0046, code lost:
        if (r0.equals("download_only_when_wifi") != false) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00be, code lost:
        if (r0.equals("download_filename_cn_enabled") != false) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00c7, code lost:
        if (r0.equals("delete_file_on_installed") != false) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c9, code lost:
        r0 = com.coolapk.market.view.settings.settingsynch.SettingSynchronized.INSTANCE;
        r1 = r13.getKey();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "preference.key");
        r0.uploadSetting(r1, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002b, code lost:
        if (r0.equals("auto_install_on_downloaded") != false) goto L_0x00c9;
     */
    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference preference) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        String key = preference.getKey();
        if (key != null) {
            switch (key.hashCode()) {
                case -1809440112:
                    if (key.equals("auto_install_accessibility_service")) {
                        if (RomUtils.isMIUI()) {
                            ConfirmDialog newInstance = ConfirmDialog.newInstance("无法使用免ROOT省心装", "抱歉，酷安的免ROOT省心装服务被MIUI系统屏蔽，暂时无法在MIUI环境生效，\n建议您ROOT您的手机或使用其他的ROM以实现自动安装。", "知道了", "");
                            FragmentManager childFragmentManager = getChildFragmentManager();
                            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                            newInstance.show(childFragmentManager, (String) null);
                            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPrefByKey("auto_install_accessibility_service");
                            Intrinsics.checkNotNullExpressionValue(checkBoxPreference, "checkBoxPreference");
                            checkBoxPreference.setChecked(false);
                            return false;
                        }
                        ActionManager.startAccessibilitySettingsActivity(getActivity());
                        return true;
                    }
                    break;
                case -1541640855:
                    break;
                case -442257810:
                    break;
                case -101299028:
                    if (key.equals("global_auto_install_accessibility_service")) {
                        StringBuilder sb = new StringBuilder();
                        FragmentActivity requireActivity = requireActivity();
                        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                        sb.append(requireActivity.getPackageName());
                        sb.append("/");
                        sb.append(AutoInstallServiceV10.class.getName());
                        String sb2 = sb.toString();
                        if (RomUtils.isMIUI()) {
                            ConfirmDialog newInstance2 = ConfirmDialog.newInstance("无法使用免ROOT省心装", "抱歉，酷安的免ROOT省心装服务被MIUI系统屏蔽，暂时无法在MIUI环境生效，\n建议您ROOT您的手机或使用其他的ROM以实现自动安装。", "知道了", "");
                            FragmentManager childFragmentManager2 = getChildFragmentManager();
                            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "childFragmentManager");
                            newInstance2.show(childFragmentManager2, (String) null);
                            CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) findPrefByKey("global_auto_install_accessibility_service");
                            Intrinsics.checkNotNullExpressionValue(checkBoxPreference2, "checkBoxPreference");
                            checkBoxPreference2.setChecked(false);
                            return false;
                        }
                        if (!SystemUtils.isAccessibilitySettingsOn(getActivity(), sb2)) {
                            FragmentActivity requireActivity2 = requireActivity();
                            Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
                            Toast.show(requireActivity2, 2131886600);
                        }
                        return true;
                    }
                    break;
                case 670017726:
                    break;
                case 1109391446:
                    if (key.equals("download_dir")) {
                        ActionManager.startFileViewActivity(this, 233);
                        return true;
                    }
                    break;
                case 1954592595:
                    break;
            }
        }
        return super.onPreferenceTreeClick(preference);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 233 && i2 == -1 && intent != null) {
            String stringExtra = intent.getStringExtra("directory");
            File file = new File(stringExtra);
            if (file.exists() && file.isDirectory() && file.canRead() && file.canWrite()) {
                AppSetting appSetting = AppHolder.getAppSetting();
                Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
                appSetting.setDownloadDir(stringExtra);
                Preference findPrefByKey = findPrefByKey("download_dir");
                Intrinsics.checkNotNullExpressionValue(findPrefByKey, "findPrefByKey<Preference…t.Keys.PREF_DOWNLOAD_DIR)");
                findPrefByKey.setSummary(stringExtra);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    private final void checkAutoInstallService() {
        StringBuilder sb = new StringBuilder();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        sb.append(requireActivity.getPackageName());
        sb.append("/");
        sb.append(AutoInstallServiceV10.class.getName());
        boolean isAccessibilitySettingsOn = SystemUtils.isAccessibilitySettingsOn(getActivity(), sb.toString());
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPrefByKey("auto_install_accessibility_service");
        Intrinsics.checkNotNullExpressionValue(checkBoxPreference, "autoInstall");
        checkBoxPreference.setChecked(isAccessibilitySettingsOn);
        boolean isAccessibilitySettingsOn2 = SystemUtils.isAccessibilitySettingsOn(getActivity(), "com.coolapk.autoinstaller/com.coolapk.autoinstaller.services.AutoInstallAccessibilityServices");
        if (isAccessibilitySettingsOn && isAccessibilitySettingsOn2) {
            FragmentActivity requireActivity2 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
            Toast.show(requireActivity2, 2131886599);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/settings/DownloadInstallSettingsFragment$Companion;", "", "()V", "COOL_INSTALLER_ACCESSIBILITY_SERVICE", "", "REQUEST_CODE", "", "newInstance", "Lcom/coolapk/market/view/settings/DownloadInstallSettingsFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DownloadInstallSettingsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadInstallSettingsFragment newInstance() {
            Bundle bundle = new Bundle();
            DownloadInstallSettingsFragment downloadInstallSettingsFragment = new DownloadInstallSettingsFragment();
            downloadInstallSettingsFragment.setArguments(bundle);
            return downloadInstallSettingsFragment;
        }
    }
}
