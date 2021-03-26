package com.coolapk.market.util;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RomUtils {
    private static final String KEY_EMUI_VERSION_CODE = "ro.build.hw_emui_api_level";
    private static final String KEY_FLYME_FLYME = "ro.meizu.setupwizard.flyme";
    private static final String KEY_FLYME_ICON_FALG = "persist.sys.use.flyme.icon";
    private static final String KEY_FLYME_PUBLISHED = "ro.flyme.published";
    private static final String KEY_FLYME_PUBLISH_FALG = "ro.flyme.published";
    private static final String KEY_FLYME_SETUP_FALG = "ro.meizu.setupwizard.flyme";
    private static final String KEY_MIUI_HANDY_MODE_SF = "ro.miui.has_handy_mode_sf";
    private static final String KEY_MIUI_REAL_BLUR = "ro.miui.has_real_blur";
    private static final String KEY_MIUI_VERSION_CODE = "ro.miui.ui.version.code";
    private static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    private static final String KEY_VERSION_FLYME = "ro.build.display.id";
    private static final String KEY_VERSION_GIONEE = "ro.gn.sv.version";
    private static final String KEY_VERSION_LENOVO = "ro.lenovo.lvp.version";
    private static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final String KEY_VERSION_OPPO = "ro.build.version.opporom";
    private static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    private static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
    private static final String KEY_VIVO_OS_NAME = "ro.vivo.os.name";
    private static final String KEY_VIVO_OS_VERSION = "ro.vivo.os.version";
    private static final String KEY_VIVO_ROM_VERSION = "ro.vivo.rom.version";
    public static final String ROM_EMUI = "EMUI";
    public static final String ROM_FLYME = "FLYME";
    public static final String ROM_LENOVO = "LENOVO";
    public static final String ROM_MIUI = "MIUI";
    public static final String ROM_OPPO = "OPPO";
    public static final String ROM_QIKU = "QIKU";
    public static final String ROM_SAMSUNG = "SAMSUNG";
    public static final String ROM_SMARTISAN = "SMARTISAN";
    public static final String ROM_VIVO = "VIVO";
    private static final String TAG = "RomUtil";
    private static Integer sFlymeVersion;
    private static String sName;
    private static String sVersion;

    public static boolean isEmui() {
        return check("EMUI");
    }

    public static boolean isMiui() {
        return check("MIUI");
    }

    public static boolean isMIUI() {
        return check("MIUI");
    }

    public static boolean isVivo() {
        return check("VIVO");
    }

    public static boolean isOppo() {
        return check("OPPO");
    }

    public static boolean isFlyme() {
        return check("FLYME");
    }

    public static boolean isQiku() {
        return check("QIKU") || check("360");
    }

    public static boolean isSmartisan() {
        return check("SMARTISAN");
    }

    public static String getName() {
        if (sName == null) {
            check("");
        }
        return sName;
    }

    public static String getVersion() {
        if (sVersion == null) {
            check("");
        }
        return sVersion;
    }

    public static boolean check(String str) {
        String str2 = sName;
        if (str2 != null) {
            return str2.equals(str);
        }
        String prop = getProp("ro.miui.ui.version.name");
        sVersion = prop;
        if (!TextUtils.isEmpty(prop)) {
            sName = "MIUI";
        } else {
            String prop2 = getProp("ro.build.version.emui");
            sVersion = prop2;
            if (!TextUtils.isEmpty(prop2)) {
                sName = "EMUI";
            } else {
                String prop3 = getProp("ro.build.version.opporom");
                sVersion = prop3;
                if (!TextUtils.isEmpty(prop3)) {
                    sName = "OPPO";
                } else {
                    String prop4 = getProp("ro.vivo.os.version");
                    sVersion = prop4;
                    if (!TextUtils.isEmpty(prop4)) {
                        sName = "VIVO";
                    } else {
                        String prop5 = getProp("ro.smartisan.version");
                        sVersion = prop5;
                        if (!TextUtils.isEmpty(prop5)) {
                            sName = "SMARTISAN";
                        } else {
                            String str3 = Build.DISPLAY;
                            sVersion = str3;
                            if (str3.toUpperCase().contains("FLYME")) {
                                sName = "FLYME";
                            } else {
                                sVersion = "unknown";
                                sName = Build.MANUFACTURER.toUpperCase();
                            }
                        }
                    }
                }
            }
        }
        return sName.equals(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058 A[SYNTHETIC, Splitter:B:18:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065 A[SYNTHETIC, Splitter:B:26:0x0065] */
    public static String getProp(String str) {
        Throwable th;
        BufferedReader bufferedReader;
        IOException e;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return readLine;
            } catch (IOException e3) {
                e = e3;
                try {
                    Log.e("RomUtil", "Unable to read prop " + str, e);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e6) {
            e = e6;
            bufferedReader = null;
            Log.e("RomUtil", "Unable to read prop " + str, e);
            if (bufferedReader != null) {
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
    }

    public static int getFlymeVersion() {
        Integer num = sFlymeVersion;
        if (num != null) {
            return num.intValue();
        }
        String prop = getProp("ro.build.flyme.version");
        if (prop != null) {
            try {
                sFlymeVersion = Integer.valueOf(Integer.parseInt(prop));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (sFlymeVersion == null) {
            sFlymeVersion = 0;
        }
        return sFlymeVersion.intValue();
    }
}
