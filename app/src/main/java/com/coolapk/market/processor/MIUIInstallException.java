package com.coolapk.market.processor;

import android.text.TextUtils;
import com.coolapk.market.util.SystemUtils;

@Deprecated
public class MIUIInstallException extends Exception {
    private static boolean IS_FIRST_TIME = true;

    private MIUIInstallException(String str) {
        super(str);
    }

    public static boolean shouldBeRecognizeAsThisException(String str) {
        if (!(str.contains("INSTALL_CANCELED_BY_USER") && !TextUtils.isEmpty(SystemUtils.getSystemProperty("ro.miui.ui.version.name"))) || !IS_FIRST_TIME) {
            return false;
        }
        IS_FIRST_TIME = false;
        return true;
    }

    public static MIUIInstallException create() {
        return new MIUIInstallException("由于 MIUI 系统限制导致安装失败，请在 设置——更多设置——开发者选项 中开启 USB 安装");
    }
}
