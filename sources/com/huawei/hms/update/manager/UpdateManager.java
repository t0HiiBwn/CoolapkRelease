package com.huawei.hms.update.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.ui.UpdateBean;
import com.huawei.hms.update.ui.a;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UpdateManager {
    private static boolean a(Context context, String str) {
        PackageManagerHelper.PackageStates packageStates = new PackageManagerHelper(context).getPackageStates(str);
        HMSLog.i("UpdateManager", "app is: " + str + ";status is:" + packageStates);
        return PackageManagerHelper.PackageStates.ENABLED == packageStates;
    }

    private static boolean a(Context context) {
        return a(context, "com.android.vending") && b(context);
    }

    private static boolean b(Context context) {
        ResourceLoaderUtil.setmContext(context);
        boolean a = new a().a(1000, TimeUnit.MILLISECONDS, ResourceLoaderUtil.getString("hms_base_google"));
        HMSLog.i("UpdateManager", "ping google status is:" + a);
        return a;
    }

    public static void startUpdate(Activity activity, int i, UpdateBean updateBean) {
        Intent startUpdateIntent = getStartUpdateIntent(activity, updateBean);
        if (startUpdateIntent != null) {
            activity.startActivityForResult(startUpdateIntent, i);
        }
    }

    public static Intent getStartUpdateIntent(Activity activity, UpdateBean updateBean) {
        if (activity == null || updateBean == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(updateBean.getClientAppName())) {
            a(activity, (ArrayList<Integer>) arrayList);
        } else {
            b(activity, (ArrayList<Integer>) arrayList);
        }
        updateBean.setTypeList(arrayList);
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, a.a(((Integer) arrayList.get(0)).intValue()));
        intentStartBridgeActivity.putExtra("intent.extra.update.info", updateBean);
        return intentStartBridgeActivity;
    }

    public static Intent getStartUpdateIntent(Context context, UpdateBean updateBean) {
        if (context == null || updateBean == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(updateBean.getClientAppName())) {
            a(context, arrayList);
        } else {
            b(context, arrayList);
        }
        updateBean.setTypeList(arrayList);
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(context, a.a(((Integer) arrayList.get(0)).intValue()));
        intentStartBridgeActivity.putExtra("intent.extra.update.info", updateBean);
        return intentStartBridgeActivity;
    }

    public static Intent startUpdateIntent(Activity activity) {
        Intent intent;
        if (activity == null) {
            return null;
        }
        UpdateBean updateBean = new UpdateBean();
        updateBean.setHmsOrApkUpgrade(true);
        updateBean.setClientPackageName(HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName());
        updateBean.setClientVersionCode(HMSPackageManager.getInstance(activity.getApplicationContext()).getHmsVersionCode());
        updateBean.setClientAppId("C10132067");
        updateBean.setNeedConfirm(false);
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(activity.getApplicationContext());
        }
        updateBean.setClientAppName(ResourceLoaderUtil.getString("hms_update_title"));
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(updateBean.getClientAppName())) {
            a(activity, (ArrayList<Integer>) arrayList);
        } else {
            b(activity, (ArrayList<Integer>) arrayList);
        }
        updateBean.setTypeList(arrayList);
        if (arrayList.size() > 1) {
            intent = BridgeActivity.getIntentStartBridgeActivity(activity, a.a(((Integer) arrayList.get(1)).intValue()));
        } else {
            intent = BridgeActivity.getIntentStartBridgeActivity(activity, a.a(((Integer) arrayList.get(0)).intValue()));
        }
        intent.putExtra("intent.extra.update.info", updateBean);
        return intent;
    }

    private static void a(Activity activity, ArrayList<Integer> arrayList) {
        if (SystemUtils.isTVDevice()) {
            arrayList.add(5);
        } else if (SystemUtils.isEMUI()) {
            if (SystemUtils.isChinaROM()) {
                c(activity, arrayList);
            } else {
                d(activity, arrayList);
            }
        } else if (SystemUtils.isChinaROM()) {
            f(activity, arrayList);
        } else {
            e(activity, arrayList);
        }
    }

    private static void a(Context context, ArrayList<Integer> arrayList) {
        if (SystemUtils.isTVDevice()) {
            arrayList.add(5);
        } else if (!SystemUtils.isEMUI() || !SystemUtils.isChinaROM()) {
            if (a(context, "com.huawei.appmarket") && !"com.huawei.appmarket".equals(context.getPackageName())) {
                arrayList.add(5);
            } else if (a(context)) {
                arrayList.add(2);
            } else {
                arrayList.add(6);
            }
        } else if (!a(context, "com.huawei.appmarket") || !c(context)) {
            arrayList.add(6);
        } else {
            arrayList.add(0);
            arrayList.add(6);
        }
    }

    private static void b(Activity activity, ArrayList<Integer> arrayList) {
        if (!a(activity, "com.huawei.appmarket") || "com.huawei.appmarket".equals(activity.getPackageName())) {
            arrayList.add(4);
        } else {
            arrayList.add(5);
        }
    }

    private static void b(Context context, ArrayList<Integer> arrayList) {
        if (!a(context, "com.huawei.appmarket") || "com.huawei.appmarket".equals(context.getPackageName())) {
            arrayList.add(4);
        } else {
            arrayList.add(5);
        }
    }

    private static void c(Activity activity, ArrayList<Integer> arrayList) {
        if (!a(activity, "com.huawei.appmarket") || !c(activity)) {
            arrayList.add(6);
            return;
        }
        arrayList.add(0);
        arrayList.add(6);
    }

    private static void d(Activity activity, ArrayList<Integer> arrayList) {
        if (a(activity, "com.huawei.appmarket") && !"com.huawei.appmarket".equals(activity.getPackageName())) {
            arrayList.add(5);
        } else if (d(activity)) {
            arrayList.add(7);
        } else if (a(activity)) {
            arrayList.add(2);
        } else {
            arrayList.add(6);
        }
    }

    private static void e(Activity activity, ArrayList<Integer> arrayList) {
        if (d(activity)) {
            arrayList.add(7);
        } else if (a(activity, "com.huawei.appmarket") && !"com.huawei.appmarket".equals(activity.getPackageName()) && SystemUtils.isSystemApp(activity, "com.huawei.appmarket")) {
            arrayList.add(5);
        } else if (a(activity)) {
            arrayList.add(2);
        } else {
            arrayList.add(6);
        }
    }

    private static void f(Activity activity, ArrayList<Integer> arrayList) {
        if (a(activity, "com.huawei.appmarket") && !"com.huawei.appmarket".equals(activity.getPackageName())) {
            arrayList.add(5);
        } else if (a(activity)) {
            arrayList.add(2);
        } else {
            arrayList.add(6);
        }
    }

    private static boolean c(Context context) {
        int packageVersionCode = new PackageManagerHelper(context).getPackageVersionCode("com.huawei.appmarket");
        HMSLog.i("UpdateManager", "getHiappVersion is " + packageVersionCode);
        return ((long) packageVersionCode) >= 70203000;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    private static boolean d(Context context) {
        String str;
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent("com.apptouch.intent.action.update_hms"), 0);
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            Iterator<ResolveInfo> it2 = queryIntentServices.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                ServiceInfo serviceInfo = it2.next().serviceInfo;
                if (serviceInfo != null) {
                    str = serviceInfo.packageName;
                    if (!TextUtils.isEmpty(str) && SystemUtils.isSystemApp(context.getApplicationContext(), str)) {
                        break;
                    }
                }
            }
            if (str == null) {
                return true;
            }
            return false;
        }
        str = null;
        if (str == null) {
        }
    }
}
