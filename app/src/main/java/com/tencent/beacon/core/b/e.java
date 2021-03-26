package com.tencent.beacon.core.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.d.h;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.NetworkInterface;
import java.util.Enumeration;

/* compiled from: DeviceInfo */
public final class e {
    private static e a;

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            if (a == null && context != null) {
                a = new e();
            }
            eVar = a;
        }
        return eVar;
    }

    private e() {
    }

    public static String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Android ");
        stringBuffer.append(i());
        stringBuffer.append(",level ");
        stringBuffer.append(c());
        String stringBuffer2 = stringBuffer.toString();
        b.b("[core] os version: %s", stringBuffer2);
        return stringBuffer2;
    }

    public static String b() {
        String str;
        try {
            str = Build.MODEL;
        } catch (Throwable th) {
            b.d("[core] getDeviceName error", new Object[0]);
            b.a(th);
            str = "";
        }
        b.b("[core] model name: %s", str);
        return str;
    }

    private static String i() {
        String str;
        try {
            str = Build.VERSION.RELEASE;
        } catch (Throwable th) {
            b.d("[core] getVersion error", new Object[0]);
            b.a(th);
            str = "";
        }
        b.b("[core] version: %s", str);
        return str;
    }

    public static String c() {
        String str;
        try {
            str = Build.VERSION.SDK;
        } catch (Throwable th) {
            b.d("[core] getApiLevel error", new Object[0]);
            b.a(th);
            str = "";
        }
        b.b("[core] apiLevel: %s", str);
        return str;
    }

    public static String b(Context context) {
        String deviceId;
        String str = "";
        if (context == null) {
            b.d("[core] getImei but context is null!", new Object[0]);
            return str;
        }
        try {
            if (a.f(context) && (deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId()) != null) {
                try {
                    str = deviceId.toLowerCase();
                } catch (Throwable unused) {
                    str = deviceId;
                }
            }
        } catch (Throwable unused2) {
            b.d("[core] getImei error!", new Object[0]);
            b.a("[core] IMEI:" + str, new Object[0]);
            return str;
        }
        b.a("[core] IMEI:" + str, new Object[0]);
        return str;
    }

    public static String c(Context context) {
        String subscriberId;
        String str = "";
        if (context == null) {
            b.d("[core] getImsi but context == null!", new Object[0]);
            return str;
        }
        try {
            if (a.f(context) && (subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId()) != null) {
                try {
                    str = subscriberId.toLowerCase();
                } catch (Throwable unused) {
                    str = subscriberId;
                }
            }
        } catch (Throwable unused2) {
            b.d("[core] getImsi error!", new Object[0]);
            b.b("[core] IMSI:" + str, new Object[0]);
            return str;
        }
        b.b("[core] IMSI:" + str, new Object[0]);
        return str;
    }

    public static String d(Context context) {
        String str;
        Throwable th;
        String str2 = "";
        if (context == null) {
            b.d("[core] getAndroidId but context is null!", new Object[0]);
            return str2;
        }
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (str != null) {
                try {
                    str2 = str.toLowerCase();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            str = str2;
            b.d("[core] getAndroidId error!", new Object[0]);
            b.a(th);
            str2 = str;
            b.a("[core] Android ID:" + str2, new Object[0]);
            return str2;
        }
        b.a("[core] Android ID:" + str2, new Object[0]);
        return str2;
    }

    public static String e(Context context) {
        String str;
        Throwable th;
        String str2 = "";
        if (context == null) {
            b.d("[core] getMacAddress but context is null!", new Object[0]);
            return str2;
        }
        try {
            if (Integer.valueOf(Build.VERSION.SDK).intValue() < 23) {
                String macAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
                if (macAddress != null) {
                    try {
                        str2 = macAddress.toLowerCase();
                    } catch (Throwable th2) {
                        th = th2;
                        str = macAddress;
                    }
                }
                b.b("[core] Mac Address:" + str2, new Object[0]);
                return str2;
            }
            String[] strArr = {"/sys/class/net/wlan0/address", "/sys/devices/virtual/net/wlan0/address"};
            str = str2;
            int i = 0;
            while (true) {
                if (i >= 2) {
                    break;
                }
                try {
                    str = h.b(strArr[i]).toString().trim();
                    if (str != null && str.length() > 0) {
                        str = str.toLowerCase();
                        break;
                    }
                    i++;
                } catch (Throwable th3) {
                    th = th3;
                    b.a(th);
                    str2 = str;
                    b.b("[core] Mac Address:" + str2, new Object[0]);
                    return str2;
                }
            }
            if (str2.equals(str)) {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (true) {
                    if (!networkInterfaces.hasMoreElements()) {
                        break;
                    }
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    byte[] hardwareAddress = nextElement.getHardwareAddress();
                    if ("wlan0".equals(nextElement.getName()) && hardwareAddress != null && hardwareAddress.length != 0) {
                        str2 = a(hardwareAddress).toString();
                        break;
                    }
                }
                b.b("[core] Mac Address:" + str2, new Object[0]);
                return str2;
            }
            str2 = str;
            b.b("[core] Mac Address:" + str2, new Object[0]);
            return str2;
        } catch (Throwable th4) {
            str = str2;
            th = th4;
            b.a(th);
            str2 = str;
            b.b("[core] Mac Address:" + str2, new Object[0]);
            return str2;
        }
    }

    private static StringBuilder a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02X:", Byte.valueOf(bArr[i])));
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb;
    }

    public static String f(Context context) {
        String str = "";
        if (context == null) {
            b.d("[core] getMacAddress but context is null!", new Object[0]);
            return str;
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            StringBuilder sb = new StringBuilder();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                byte[] hardwareAddress = nextElement.getHardwareAddress();
                if (!(hardwareAddress == null || hardwareAddress.length == 0)) {
                    sb.append(nextElement.getName());
                    sb.append(":");
                    sb.append((CharSequence) a(hardwareAddress));
                    sb.append(",");
                }
            }
            str = sb.toString();
        } catch (Throwable th) {
            b.a(th);
        }
        b.b("[core] Mac Address:" + str, new Object[0]);
        return str;
    }

    public static String d() {
        String b = h.b("/sys/class/net/eth0/address");
        String str = "";
        if (!b.trim().equals(str) && b.length() >= 17) {
            str = b.toLowerCase().substring(0, 17);
        }
        b.b("[core] Ethernet Mac Address:" + str, new Object[0]);
        return str;
    }

    public static String g(Context context) {
        String str = "";
        if (context == null) {
            b.d("[core] getMacAddress but context == null!", new Object[0]);
            return str;
        }
        try {
            str = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getBSSID();
        } catch (Throwable th) {
            b.a(th);
            b.d("getMacAddress error!", new Object[0]);
        }
        b.b("[core] Wifi BSSID:" + str, new Object[0]);
        return str;
    }

    public static String h(Context context) {
        String str = "";
        if (context == null) {
            b.d("[core] getWifiSSID but context == null!", new Object[0]);
            return str;
        }
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo.getBSSID() != null) {
                str = connectionInfo.getSSID();
            }
        } catch (Throwable th) {
            b.a(th);
            b.d("getWifiSSID error!", new Object[0]);
        }
        b.b("[core] Wifi SSID:" + str, new Object[0]);
        return str;
    }

    public static String e() {
        String str;
        try {
            str = Build.BRAND;
        } catch (Throwable th) {
            b.d("getBrand error!", new Object[0]);
            b.a(th);
            str = "";
        }
        b.b("[core] Brand:" + str, new Object[0]);
        return str;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0022: ARITH  (r1v10 long) = (wrap: long : 0x0021: ARITH  (r1v9 long) = (wrap: long : 0x001d: ARITH  (r1v8 long) = (wrap: long : 0x0017: CAST (r1v7 long) = (long) (wrap: int : 0x0013: INVOKE  (r1v6 int) = (r2v3 android.os.StatFs) type: VIRTUAL call: android.os.StatFs.getBlockCount():int)) * (r3v2 long)) / (1024 long)) / (1024 long))] */
    public static String f() {
        String str;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            long blockSize = (long) statFs.getBlockSize();
            StringBuilder sb = new StringBuilder();
            sb.append(((((long) statFs.getBlockCount()) * blockSize) / 1024) / 1024);
            str = sb.toString();
        } catch (Throwable th) {
            b.d("getDisplayMetrics error!", new Object[0]);
            b.a(th);
            str = null;
        }
        b.b("[core] Rom Size:" + str, new Object[0]);
        return str;
    }

    public static String i(Context context) {
        String j = a != null ? j(context) : "unknown";
        b.b("[core] NetWork Types:" + j, new Object[0]);
        return j;
    }

    public static String j(Context context) {
        TelephonyManager telephonyManager;
        String str = "unknown";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return str;
            }
            if (activeNetworkInfo.getType() != 1) {
                if (activeNetworkInfo.getType() == 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                    switch (telephonyManager.getNetworkType()) {
                        case 1:
                            str = "GPRS";
                            break;
                        case 2:
                            str = "EDGE";
                            break;
                        case 3:
                            str = "UMTS";
                            break;
                        case 4:
                            str = "CDMA";
                            break;
                        case 5:
                            str = "EVDO_0";
                            break;
                        case 6:
                            str = "EVDO_A";
                            break;
                        case 7:
                            str = "1xRTT";
                            break;
                        case 8:
                            str = "HSDPA";
                            break;
                        case 9:
                            str = "HSUPA";
                            break;
                        case 10:
                            str = "HSPA";
                            break;
                        case 11:
                            str = "iDen";
                            break;
                        case 12:
                            str = "EVDO_B";
                            break;
                        case 13:
                            str = "LTE";
                            break;
                        case 14:
                            str = "eHRPD";
                            break;
                        case 15:
                            str = "HSPA+";
                            break;
                    }
                }
            } else {
                str = "wifi";
            }
            b.b("[core] NetWork Type:" + str, new Object[0]);
            return str;
        } catch (Exception e) {
            b.a(e);
        }
    }

    public static boolean g() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static String h() {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/sys/block/mmcblk0/device/type")));
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            sb.append(readLine);
        } catch (Exception unused) {
        }
        sb.append(",");
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(new File("/sys/block/mmcblk0/device/name")));
            String readLine2 = bufferedReader2.readLine();
            bufferedReader2.close();
            sb.append(readLine2);
        } catch (Exception unused2) {
        }
        sb.append(",");
        try {
            BufferedReader bufferedReader3 = new BufferedReader(new FileReader(new File("/sys/block/mmcblk0/device/cid")));
            String readLine3 = bufferedReader3.readLine();
            bufferedReader3.close();
            sb.append(readLine3);
        } catch (Exception unused3) {
        }
        String sb2 = sb.toString();
        b.b("[core]Nand Info:" + sb2, new Object[0]);
        return sb2;
    }
}
