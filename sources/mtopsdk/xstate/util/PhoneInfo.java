package mtopsdk.xstate.util;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Base64;
import java.net.NetworkInterface;
import java.util.Random;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.common.util.b;

public class PhoneInfo {
    private static b a = b.a();

    private static String a() {
        StringBuilder sb = new StringBuilder();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String valueOf = String.valueOf(currentTimeMillis);
            sb.append(valueOf.substring(valueOf.length() - 5));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Build.MODEL.replaceAll(" ", ""));
            while (sb2.length() < 6) {
                sb2.append('0');
            }
            sb.append(sb2.substring(0, 6));
            Random random = new Random(currentTimeMillis);
            long j = 0;
            while (j < 4096) {
                j = random.nextLong();
            }
            sb.append(Long.toHexString(j).substring(0, 4));
        } catch (Throwable th) {
            TBSdkLog.e("mtopsdk.PhoneInfo", "[generateImei] error --->" + th.toString());
        }
        return sb.toString();
    }

    public static String getImei(Context context) {
        Throwable th;
        StringBuilder sb = new StringBuilder();
        try {
            StringBuilder sb2 = new StringBuilder(b.a(context, "MtopConfigStore", "PHONE_INFO_STORE.", "mtopsdk_imei"));
            try {
                if (StringUtils.isNotBlank(sb2.toString())) {
                    return new String(Base64.decode(sb2.toString(), 0));
                }
                StringBuilder sb3 = new StringBuilder(((TelephonyManager) context.getSystemService("phone")).getDeviceId());
                try {
                    StringBuilder sb4 = new StringBuilder((StringUtils.isBlank(sb3.toString()) ? new StringBuilder(a()) : sb3).toString().replaceAll(" ", "").trim());
                    while (sb4.length() < 15) {
                        sb4.insert(0, "0");
                    }
                    b.a(context, "MtopConfigStore", "PHONE_INFO_STORE.", "mtopsdk_imei", Base64.encodeToString(sb4.toString().getBytes(), 0));
                    return sb4.toString().trim();
                } catch (Throwable th2) {
                    th = th2;
                    sb = sb3;
                    TBSdkLog.e("mtopsdk.PhoneInfo", "[getImei] error ---" + th.toString());
                    return sb.toString();
                }
            } catch (Throwable th3) {
                th = th3;
                sb = sb2;
                TBSdkLog.e("mtopsdk.PhoneInfo", "[getImei] error ---" + th.toString());
                return sb.toString();
            }
        } catch (Throwable th4) {
            th = th4;
            TBSdkLog.e("mtopsdk.PhoneInfo", "[getImei] error ---" + th.toString());
            return sb.toString();
        }
    }

    public static String getImsi(Context context) {
        StringBuilder sb;
        Throwable th;
        StringBuilder sb2 = new StringBuilder();
        try {
            StringBuilder sb3 = new StringBuilder(b.a(context, "MtopConfigStore", "PHONE_INFO_STORE.", "mtopsdk_imsi"));
            try {
                if (StringUtils.isNotBlank(sb3.toString())) {
                    return new String(Base64.decode(sb3.toString(), 0));
                }
                StringBuilder sb4 = new StringBuilder(((TelephonyManager) context.getSystemService("phone")).getSubscriberId());
                try {
                    sb = new StringBuilder((StringUtils.isBlank(sb4.toString()) ? new StringBuilder(a()) : sb4).toString().replaceAll(" ", "").trim());
                    while (sb.length() < 15) {
                        sb.insert(0, "0");
                    }
                    b.a(context, "MtopConfigStore", "PHONE_INFO_STORE.", "mtopsdk_imsi", Base64.encodeToString(sb.toString().getBytes(), 0));
                } catch (Throwable th2) {
                    th = th2;
                    sb2 = sb4;
                    TBSdkLog.e("mtopsdk.PhoneInfo", "[getImsi]error ---" + th.toString());
                    sb = sb2;
                    return sb.toString();
                }
                return sb.toString();
            } catch (Throwable th3) {
                th = th3;
                sb2 = sb3;
                TBSdkLog.e("mtopsdk.PhoneInfo", "[getImsi]error ---" + th.toString());
                sb = sb2;
                return sb.toString();
            }
        } catch (Throwable th4) {
            th = th4;
            TBSdkLog.e("mtopsdk.PhoneInfo", "[getImsi]error ---" + th.toString());
            sb = sb2;
            return sb.toString();
        }
    }

    public static String getPhoneBaseInfo(Context context) {
        try {
            String str = Build.VERSION.RELEASE;
            String str2 = Build.MANUFACTURER;
            String str3 = Build.MODEL;
            StringBuilder sb = new StringBuilder(32);
            sb.append("MTOPSDK/3.1.1.7");
            sb.append(" (");
            sb.append("Android");
            sb.append(";");
            sb.append(str);
            sb.append(";");
            sb.append(str2);
            sb.append(";");
            sb.append(str3);
            sb.append(")");
            return sb.toString();
        } catch (Throwable th) {
            TBSdkLog.e("mtopsdk.PhoneInfo", "[getPhoneBaseInfo] error ---" + th.toString());
            return "";
        }
    }

    public static String getOriginalImei(Context context) {
        if (context == null) {
            return null;
        }
        try {
            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            if (deviceId != null) {
                return deviceId.trim();
            }
            return deviceId;
        } catch (Throwable th) {
            TBSdkLog.e("mtopsdk.PhoneInfo", "[getOriginalImei]error ---" + th.toString());
            return null;
        }
    }

    public static String getOriginalImsi(Context context) {
        if (context == null) {
            return null;
        }
        try {
            String subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
            if (subscriberId != null) {
                return subscriberId.trim();
            }
            return subscriberId;
        } catch (Throwable th) {
            TBSdkLog.e("mtopsdk.PhoneInfo", "[getOriginalImsi]error ---" + th.toString());
            return null;
        }
    }

    public static String getSerialNum() {
        if (Build.VERSION.SDK_INT > 27) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.serialno", "unknown");
        } catch (Throwable th) {
            TBSdkLog.e("mtopsdk.PhoneInfo", "[getSerialNum]error ---" + th.toString());
            return null;
        }
    }

    public static String getAndroidId(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            TBSdkLog.e("mtopsdk.PhoneInfo", "[getAndroidId]error ---" + th.toString());
            return null;
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0058: APUT  (r10v1 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r11v4 java.lang.String) */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0084  */
    public static String getLocalMacAddress(Context context) {
        Throwable th;
        String str = "";
        if (context == null) {
            return str;
        }
        try {
            String a2 = b.a(context, "MtopConfigStore", "PHONE_INFO_STORE.", "mtopsdk_mac_address");
            try {
                if (StringUtils.isNotBlank(a2)) {
                    return new String(Base64.decode(a2, 0));
                }
                if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        byte[] hardwareAddress = NetworkInterface.getByName("wlan0").getHardwareAddress();
                        StringBuilder sb = new StringBuilder();
                        int i = 0;
                        while (i < hardwareAddress.length) {
                            Object[] objArr = new Object[2];
                            objArr[0] = Byte.valueOf(hardwareAddress[i]);
                            objArr[1] = i < hardwareAddress.length - 1 ? ":" : str;
                            sb.append(String.format("%02X%s", objArr));
                            i++;
                        }
                        str = sb.toString();
                    } else {
                        WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                        if (connectionInfo != null) {
                            str = connectionInfo.getMacAddress();
                        }
                    }
                    if (StringUtils.isNotBlank(str)) {
                        b.a(context, "MtopConfigStore", "PHONE_INFO_STORE.", "mtopsdk_mac_address", Base64.encodeToString(str.getBytes(), 0));
                    }
                    return str;
                }
                str = a2;
                if (StringUtils.isNotBlank(str)) {
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                str = a2;
                TBSdkLog.e("mtopsdk.PhoneInfo", "[getLocalMacAddress]error ---" + th.toString());
                return str;
            }
        } catch (Throwable th3) {
            th = th3;
            TBSdkLog.e("mtopsdk.PhoneInfo", "[getLocalMacAddress]error ---" + th.toString());
            return str;
        }
    }
}
