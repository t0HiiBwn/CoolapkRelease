package com.ypz.bangscreentools;

import android.os.Build;
import android.text.TextUtils;

public class PhoneManufacturersJudgeTools {
    private static PhoneManufacturersJudgeTools PMJTools;

    public static PhoneManufacturersJudgeTools getPMJTools() {
        if (PMJTools == null) {
            synchronized (PhoneManufacturersJudgeTools.class) {
                PMJTools = new PhoneManufacturersJudgeTools();
            }
        }
        return PMJTools;
    }

    public final boolean isHuaWei() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.contains("HUAWEI");
    }

    public final boolean isMiui() {
        return !TextUtils.isEmpty(getSystemProperty("ro.miui.ui.version.name"));
    }

    public final boolean isOppo() {
        return !TextUtils.isEmpty(getSystemProperty("ro.product.brand"));
    }

    public final boolean isVivo() {
        return !TextUtils.isEmpty(getSystemProperty("ro.vivo.os.name"));
    }

    private String getSystemProperty(String str) {
        return SystemProperties.getSingle().get(str);
    }
}
