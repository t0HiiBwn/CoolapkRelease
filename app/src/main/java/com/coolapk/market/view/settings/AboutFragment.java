package com.coolapk.market.view.settings;

import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.AboutBinding;
import com.coolapk.market.event.AppCheckForUpgradeEvent;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.base.SimpleDialog;
import com.coolapk.market.widget.Toast;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class AboutFragment extends BaseFragment implements View.OnClickListener {
    private boolean checkForUpgrade;
    private AboutBinding mBinding;
    private Long useTime = 0L;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AboutBinding aboutBinding = (AboutBinding) DataBindingUtil.inflate(layoutInflater, 2131558428, viewGroup, false);
        this.mBinding = aboutBinding;
        return aboutBinding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getActivity().setTitle(getString(2131887217));
        this.mBinding.setClick(this);
        PackageInfo packageInfo = getPackageInfo();
        boolean z = false;
        if (packageInfo != null) {
            this.mBinding.version.setText(String.format(Locale.getDefault(), "%s (%d)", packageInfo.versionName, Integer.valueOf(packageInfo.versionCode)));
        }
        this.mBinding.sloganView.setText("发现科技新生活");
        this.mBinding.infoView.setText("© 2010-" + DateUtils.getTodayDescription() + " Coolapk.com All rights reserved.");
        String str = "检查更新";
        this.mBinding.checkUpgradeView.setText(str);
        if (AppHolder.getAppMetadata().isCommunityMode()) {
            this.mBinding.titleView.setText(2131886222);
        } else {
            this.mBinding.titleView.setText(2131886221);
        }
        MobileApp mobileAppUpgradeFast = DataManager.getInstance().getMobileAppUpgradeFast(getActivity().getPackageName(), false);
        if (!(mobileAppUpgradeFast == null || mobileAppUpgradeFast.getUpgradeInfo() == null || AppHolder.getAppMetadata().getAppVersionCode() >= mobileAppUpgradeFast.getUpgradeInfo().getVersionCode())) {
            z = true;
        }
        TextView textView = this.mBinding.checkUpgradeView;
        if (z) {
            str = "有新版本更新";
        }
        textView.setText(str);
        setHasOptionsMenu(true);
        try {
            PackageInfo packageInfo2 = getPackageInfo();
            if (packageInfo2 != null) {
                this.useTime = DateUtils.getDays(Long.valueOf(packageInfo2.firstInstallTime));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (AppHolder.getAppMetadata().isCommunityMode()) {
            this.mBinding.checkUpgradeLayout.setVisibility(8);
        }
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ViewExtents2Kt.tryListenWindowsInset(view, new Function1<Rect, Unit>() {
            /* class com.coolapk.market.view.settings.AboutFragment.AnonymousClass1 */

            public Unit invoke(Rect rect) {
                AboutFragment.this.mBinding.infoView.setPadding(0, 0, 0, rect.bottom);
                return null;
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(2131623970, menu);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131361804) {
            return super.onOptionsItemSelected(menuItem);
        }
        ActionManager.startTestSettingsActivity(getActivity());
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private PackageInfo getPackageInfo() {
        try {
            return getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131362227:
                checkForUpgrade();
                return;
            case 2131362889:
                ActionManager.startAppViewActivity(getActivity(), getActivity().getPackageName());
                return;
            case 2131363049:
                ActionManager.startProjectLibraryListActivity(getActivity());
                return;
            case 2131363375:
                if (this.useTime.intValue() < 1) {
                    Toast.show(getActivity(), "💖初次见面请多关照💖");
                    return;
                }
                FragmentActivity activity = getActivity();
                Toast.show(activity, "💖酷安已经陪伴你" + this.useTime.intValue() + "天了哦💖");
                return;
            case 2131363902:
                if (Build.VERSION.SDK_INT >= 23) {
                    String str = Process.is64Bit() ? "64Bit：支持" : "64Bit：不支持";
                    int i = getActivity().getApplicationInfo().targetSdkVersion;
                    FragmentActivity activity2 = getActivity();
                    Toast.show(activity2, str + "\ntargetApi：" + i);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void checkForUpgrade() {
        if (!AppHolder.getAppMetadata().isCommunityMode() && !this.checkForUpgrade) {
            this.checkForUpgrade = true;
            this.mBinding.checkUpgradeView.setText("检查更新中");
            ActionManager.startCheckMobileAppForUpgrade(getActivity(), getActivity().getPackageName());
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAppCheckForUpgradeEventChanged(AppCheckForUpgradeEvent appCheckForUpgradeEvent) {
        if (this.checkForUpgrade) {
            this.checkForUpgrade = false;
            try {
                if (TextUtils.equals(getActivity().getPackageName(), appCheckForUpgradeEvent.getPackageName())) {
                    final MobileApp mobileAppUpgradeFast = DataManager.getInstance().getMobileAppUpgradeFast(getActivity().getPackageName(), false);
                    if (mobileAppUpgradeFast == null || mobileAppUpgradeFast.getUpgradeInfo() == null || AppHolder.getAppMetadata().getAppVersionCode() >= mobileAppUpgradeFast.getUpgradeInfo().getVersionCode()) {
                        this.mBinding.checkUpgradeView.setText("已是最新版本");
                        return;
                    }
                    this.mBinding.checkUpgradeView.setText("有新版本可用");
                    SimpleDialog newInstance = SimpleDialog.newInstance();
                    newInstance.setTitle(mobileAppUpgradeFast.getAppName() + "-" + mobileAppUpgradeFast.getUpgradeInfo().getVersionName());
                    newInstance.setMessage(mobileAppUpgradeFast.getUpgradeInfo().getChangeLog());
                    newInstance.setPositiveButton(2131886157, new DialogInterface.OnClickListener() {
                        /* class com.coolapk.market.view.settings.AboutFragment.AnonymousClass2 */

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ActionManager.startDownload(AboutFragment.this.getActivity(), mobileAppUpgradeFast, mobileAppUpgradeFast.getUpgradeInfo().getDownloadUrlTypeSmart());
                        }
                    });
                    newInstance.setNegativeButton(2131886115, new DialogInterface.OnClickListener() {
                        /* class com.coolapk.market.view.settings.AboutFragment.AnonymousClass3 */

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    newInstance.show(getChildFragmentManager(), (String) null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
