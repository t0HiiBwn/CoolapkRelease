package com.alibaba.alibclinkpartner.smartlink.manager;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.alibaba.alibclinkpartner.smartlink.util.ALSLLogUtil;
import java.util.ArrayList;
import java.util.List;

public class ALSLAppCheckManager {
    public static List<String> getInstallAppList(Context context, List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (!(context == null || list == null)) {
            try {
                for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(0)) {
                    for (String str : list) {
                        if (TextUtils.equals(packageInfo.packageName, str)) {
                            arrayList.add(str);
                        }
                    }
                }
                ALSLLogUtil.d("ALSLAppCheckManager", "getInstallAppList：", "矩阵APP匹配中的数量：" + arrayList.size());
            } catch (Exception e) {
                ALSLLogUtil.d("ALSLAppCheckManager", "getInstallAppList：", "获取矩阵APP异常：" + e.toString());
            }
        }
        return arrayList;
    }

    public static boolean isAppCanOpen(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
