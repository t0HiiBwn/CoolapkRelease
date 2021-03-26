package com.huawei.hms.common.internal;

import android.app.Activity;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.HashMap;
import java.util.Map;

public class ConnectionErrorMessages {
    private static final Map<String, String> a = new HashMap();

    public static String getErrorTitle(Activity activity, int i) {
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(activity.getApplicationContext());
        }
        if (i == 1) {
            return ResourceLoaderUtil.getString("hms_install_message");
        }
        if (i == 2) {
            return ResourceLoaderUtil.getString("hms_update_message");
        }
        if (i == 3) {
            return ResourceLoaderUtil.getString("hms_bindfaildlg_message");
        }
        if (i != 9) {
            HMSLog.e("HuaweiApiAvailability", "Unexpected error code " + i);
            return null;
        }
        HMSLog.e("HuaweiApiAvailability", "Huawei Mobile Services is invalid. Cannot recover.");
        return null;
    }

    public static String getErrorDialogButtonMessage(Activity activity, int i) {
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(activity.getApplicationContext());
        }
        if (i == 1) {
            return ResourceLoaderUtil.getString("hms_install");
        }
        if (i != 2) {
            return ResourceLoaderUtil.getString("hms_confirm");
        }
        return ResourceLoaderUtil.getString("hms_update");
    }

    public static String getErrorMessage(Activity activity, int i) {
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(activity.getApplicationContext());
        }
        String string = ResourceLoaderUtil.getString("hms_update_title");
        if (i == 1 || i == 2) {
            return string;
        }
        return null;
    }
}
