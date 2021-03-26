package com.hjq.permissions;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.util.List;

final class PermissionSettingPage {
    PermissionSettingPage() {
    }

    static Intent getSmartPermissionIntent(Context context, List<String> list) {
        if (list == null || list.isEmpty()) {
            return getApplicationDetailsIntent(context);
        }
        if (!PermissionUtils.containsSpecialPermission(list)) {
            return getApplicationDetailsIntent(context);
        }
        if (list.size() == 1) {
            String str = list.get(0);
            if ("android.permission.MANAGE_EXTERNAL_STORAGE".equals(str)) {
                return getStoragePermissionIntent(context);
            }
            if ("android.permission.REQUEST_INSTALL_PACKAGES".equals(str)) {
                return getInstallPermissionIntent(context);
            }
            if ("android.permission.SYSTEM_ALERT_WINDOW".equals(str)) {
                return getWindowPermissionIntent(context);
            }
            if ("android.permission.ACCESS_NOTIFICATION_POLICY".equals(str)) {
                return getNotifyPermissionIntent(context);
            }
            if ("android.permission.WRITE_SETTINGS".equals(str)) {
                return getSettingPermissionIntent(context);
            }
            return getApplicationDetailsIntent(context);
        } else if (list.size() != 3 || !list.contains("android.permission.MANAGE_EXTERNAL_STORAGE") || !list.contains("android.permission.READ_EXTERNAL_STORAGE") || !list.contains("android.permission.WRITE_EXTERNAL_STORAGE")) {
            return getApplicationDetailsIntent(context);
        } else {
            if (PermissionUtils.isAndroid11()) {
                return getStoragePermissionIntent(context);
            }
            return getApplicationDetailsIntent(context);
        }
    }

    static Intent getApplicationDetailsIntent(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        return intent;
    }

    static Intent getInstallPermissionIntent(Context context) {
        Intent intent;
        if (PermissionUtils.isAndroid8()) {
            intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
        } else {
            intent = null;
        }
        return (intent == null || !PermissionUtils.areActivityIntent(context, intent)) ? getApplicationDetailsIntent(context) : intent;
    }

    static Intent getWindowPermissionIntent(Context context) {
        Intent intent;
        if (PermissionUtils.isAndroid6()) {
            intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            if (!PermissionUtils.isAndroid11()) {
                intent.setData(Uri.parse("package:" + context.getPackageName()));
            }
        } else {
            intent = null;
        }
        return (intent == null || !PermissionUtils.areActivityIntent(context, intent)) ? getApplicationDetailsIntent(context) : intent;
    }

    static Intent getNotifyPermissionIntent(Context context) {
        Intent intent;
        if (PermissionUtils.isAndroid8()) {
            intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
        } else {
            intent = null;
        }
        return (intent == null || !PermissionUtils.areActivityIntent(context, intent)) ? getApplicationDetailsIntent(context) : intent;
    }

    static Intent getSettingPermissionIntent(Context context) {
        Intent intent;
        if (PermissionUtils.isAndroid6()) {
            intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
        } else {
            intent = null;
        }
        return (intent == null || !PermissionUtils.areActivityIntent(context, intent)) ? getApplicationDetailsIntent(context) : intent;
    }

    static Intent getStoragePermissionIntent(Context context) {
        Intent intent;
        if (PermissionUtils.isAndroid11()) {
            intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
        } else {
            intent = null;
        }
        return (intent == null || !PermissionUtils.areActivityIntent(context, intent)) ? getApplicationDetailsIntent(context) : intent;
    }
}
