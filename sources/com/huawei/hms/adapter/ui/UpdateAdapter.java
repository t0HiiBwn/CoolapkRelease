package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.manager.HMSPublishStateHolder;
import com.huawei.hms.update.manager.UpdateManager;
import com.huawei.hms.update.ui.UpdateBean;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.updatesdk.UpdateSdkAPI;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;
import java.io.Serializable;
import java.lang.ref.WeakReference;

public class UpdateAdapter implements IBridgeActivityDelegate {
    private WeakReference<Activity> a;
    private int b;
    private UpdateBean c;
    private String d;

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 1001;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        this.a = new WeakReference<>(activity);
        Intent intent = activity.getIntent();
        if (intent == null) {
            e();
            return;
        }
        int intExtra = intent.getIntExtra("update_version", 0);
        this.b = intExtra;
        if (intExtra == 0) {
            e();
        } else if (intent.getBooleanExtra("new_update", false)) {
            HMSLog.i("UpdateAdapter", "4.0 framework HMSCore upgrade process");
            String hMSPackageName = HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName();
            ComponentName componentName = new ComponentName(hMSPackageName, "com.huawei.hms.fwksdk.stub.UpdateStubActivity");
            Intent intent2 = new Intent();
            intent2.putExtra("kpms_key_caller_packagename", activity.getApplicationContext().getPackageName());
            intent2.putExtra("kitUpdatePackageName", hMSPackageName);
            intent2.setComponent(componentName);
            activity.startActivityForResult(intent2, 1001);
        } else {
            HMSPackageManager instance = HMSPackageManager.getInstance(activity);
            if (!PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(instance.getHMSPackageStates())) {
                this.d = instance.getHMSPackageName();
                b();
            } else if (HMSPublishStateHolder.getPublishState() == 0) {
                a();
            } else if (HMSPublishStateHolder.getPublishState() == 1) {
                this.d = "com.huawei.hms";
                b();
            } else {
                this.d = "com.huawei.hwid";
                b();
            }
        }
    }

    private void a() {
        UpdateSdkAPI.checkTargetAppUpdate(d(), "com.huawei.hms", new CheckUpdateCallBack() {
            /* class com.huawei.hms.adapter.ui.UpdateAdapter.AnonymousClass1 */

            @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
            public void onUpdateInfo(Intent intent) {
                if (intent != null) {
                    try {
                        int intExtra = intent.getIntExtra("status", -99);
                        HMSLog.i("UpdateAdapter", "CheckUpdateCallBack status is " + intExtra);
                        String stringExtra = intent.getStringExtra("failreason");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            HMSLog.e("UpdateAdapter", "checkTargetAppUpdate reason is " + stringExtra);
                        }
                        if (intExtra == 7) {
                            Serializable serializableExtra = intent.getSerializableExtra("updatesdk_update_info");
                            if (serializableExtra instanceof ApkUpgradeInfo) {
                                String package_ = ((ApkUpgradeInfo) serializableExtra).getPackage_();
                                if (package_.equalsIgnoreCase("com.huawei.hms")) {
                                    HMSLog.i("UpdateAdapter", "com.huawei.hms has already be published");
                                    UpdateAdapter.this.d = package_;
                                    HMSPublishStateHolder.setPublishState(1);
                                }
                            }
                        }
                    } catch (Exception e) {
                        HMSLog.e("UpdateAdapter", "intent has some error" + e.getMessage());
                    }
                }
                if (UpdateAdapter.this.d == null) {
                    if (HMSPublishStateHolder.getPublishState() != 1) {
                        HMSPublishStateHolder.setPublishState(2);
                    }
                    UpdateAdapter.this.d = "com.huawei.hwid";
                }
                UpdateAdapter.this.b();
            }

            @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
            public void onMarketInstallInfo(Intent intent) {
                if (HMSPublishStateHolder.getPublishState() != 1) {
                    HMSPublishStateHolder.setPublishState(2);
                }
                UpdateAdapter.this.d = "com.huawei.hwid";
                UpdateAdapter.this.b();
            }

            @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
            public void onMarketStoreError(int i) {
                HMSLog.e("UpdateAdapter", "onMarketStoreError responseCode: " + i);
                if (HMSPublishStateHolder.getPublishState() != 1) {
                    HMSPublishStateHolder.setPublishState(2);
                }
                UpdateAdapter.this.d = "com.huawei.hwid";
                UpdateAdapter.this.b();
            }

            @Override // com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack
            public void onUpdateStoreError(int i) {
                HMSLog.e("UpdateAdapter", "onUpdateStoreError responseCode: " + i);
                if (HMSPublishStateHolder.getPublishState() != 1) {
                    HMSPublishStateHolder.setPublishState(2);
                }
                UpdateAdapter.this.d = "com.huawei.hwid";
                UpdateAdapter.this.b();
            }
        });
    }

    /* access modifiers changed from: private */
    public void b() {
        Activity d2 = d();
        UpdateBean updateBean = new UpdateBean();
        updateBean.setHmsOrApkUpgrade(true);
        HMSLog.i("UpdateAdapter", "target HMS Core packageName is " + this.d);
        updateBean.setClientPackageName(this.d);
        updateBean.setClientVersionCode(this.b);
        updateBean.setClientAppId("C10132067");
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(d2.getApplicationContext());
        }
        updateBean.setClientAppName(ResourceLoaderUtil.getString("hms_update_title"));
        this.c = updateBean;
        HMSLog.i("UpdateAdapter", "old framework HMSCore upgrade process");
        UpdateManager.startUpdate(d2, 1001, updateBean);
        this.c = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.i("UpdateAdapter", "onBridgeActivityDestroy");
        this.a = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        if (i != getRequestCode()) {
            this.c = null;
            return false;
        }
        HMSLog.i("UpdateAdapter", "onBridgeActivityResult");
        if (i2 == 1214) {
            HMSLog.i("UpdateAdapter", "Enter update escape route");
            Activity d2 = d();
            if (d2 == null) {
                HMSLog.e("UpdateAdapter", "bridgeActivity is null, update escape failed ");
                this.c = null;
                return true;
            }
            UpdateManager.startUpdate(d2, 1001, this.c);
            this.c = null;
        }
        if (i2 == -1) {
            if (intent != null) {
                if (intent.getIntExtra("kit_update_result", 0) == 1) {
                    HMSLog.i("UpdateAdapter", "new framework update process,Error resolved successfully!");
                    SystemManager.getInstance().notifyUpdateResult(0);
                    this.c = null;
                    c();
                    return true;
                }
                int intExtra = intent.getIntExtra("intent.extra.RESULT", -1);
                if (intExtra == 0) {
                    HMSLog.i("UpdateAdapter", "Error resolved successfully!");
                    SystemManager.getInstance().notifyUpdateResult(0);
                } else if (intExtra == 13) {
                    HMSLog.i("UpdateAdapter", "Resolve error process canceled by user!");
                    SystemManager.getInstance().notifyUpdateResult(13);
                } else if (intExtra == 8) {
                    HMSLog.i("UpdateAdapter", "Internal error occurred, recommended retry.");
                    SystemManager.getInstance().notifyUpdateResult(8);
                } else {
                    HMSLog.i("UpdateAdapter", "Other error codes.");
                    SystemManager.getInstance().notifyUpdateResult(intExtra);
                }
            }
        } else if (i2 == 0) {
            HMSLog.i("UpdateAdapter", "Activity.RESULT_CANCELED");
            this.c = null;
            Activity d3 = d();
            if (d3 == null) {
                return true;
            }
            if (a(d3, HMSPackageManager.getInstance(d3.getApplicationContext()).getHMSPackageName(), this.b)) {
                HMSLog.i("UpdateAdapter", "Resolve error, process canceled by user clicking back button!");
                SystemManager.getInstance().notifyUpdateResult(13);
            } else {
                SystemManager.getInstance().notifyUpdateResult(0);
            }
        }
        c();
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.i("UpdateAdapter", "onBridgeConfigurationChanged");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, KeyEvent keyEvent) {
        HMSLog.i("UpdateAdapter", "On key up when resolve conn error");
    }

    private void c() {
        Activity d2 = d();
        if (d2 != null && !d2.isFinishing()) {
            d2.finish();
        }
    }

    private Activity d() {
        WeakReference<Activity> weakReference = this.a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private boolean a(Context context, String str, int i) {
        if (context == null || TextUtils.isEmpty(str) || i == 0) {
            return false;
        }
        PackageManagerHelper packageManagerHelper = new PackageManagerHelper(context);
        if (!PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(packageManagerHelper.getPackageStates(str)) && packageManagerHelper.getPackageVersionCode(str) >= i) {
            return false;
        }
        return true;
    }

    private void e() {
        SystemManager.getInstance().notifyUpdateResult(8);
        c();
    }
}
