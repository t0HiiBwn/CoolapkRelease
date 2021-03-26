package com.weibo.ssosdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.io.UnsupportedEncodingException;
import java.net.NetworkInterface;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;

public class MfpBuilder {
    public static final String AID_TAG = "weibo_aid_value";
    private static final String TAG = "MfpBuilder";

    private static void LogD(String str) {
    }

    private static void LogE(String str) {
    }

    public static void init(Context context) {
    }

    private static final class BatteryInfo {
        private Intent batteryInfoIntent;

        private BatteryInfo(Context context) {
            this.batteryInfoIntent = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        }

        private int getStatus() {
            return this.batteryInfoIntent.getIntExtra("status", 0);
        }

        private int getHealth() {
            return this.batteryInfoIntent.getIntExtra("health", 1);
        }

        private boolean getPresent() {
            return this.batteryInfoIntent.getBooleanExtra("present", false);
        }

        /* access modifiers changed from: private */
        public int getLevel() {
            return this.batteryInfoIntent.getIntExtra("level", 0);
        }

        /* access modifiers changed from: private */
        public int getScale() {
            return this.batteryInfoIntent.getIntExtra("scale", 0);
        }

        private int getPlugged() {
            return this.batteryInfoIntent.getIntExtra("plugged", 0);
        }

        /* access modifiers changed from: private */
        public int getVoltage() {
            return this.batteryInfoIntent.getIntExtra("voltage", 0);
        }

        /* access modifiers changed from: private */
        public int getTemperature() {
            return this.batteryInfoIntent.getIntExtra("temperature", 0);
        }

        private String getTechnology() {
            return this.batteryInfoIntent.getStringExtra("technology");
        }
    }

    public static String getMfp(Context context) {
        try {
            return new String(genMfpString(context).getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    private static String generateUAAid(Context context) {
        StringBuilder sb = new StringBuilder();
        String packageName = context.getPackageName();
        String str = (TextUtils.isEmpty(packageName) || !packageName.contains("com.sina.weibo")) ? "ssosdk" : "weibo";
        sb.append(Build.MANUFACTURER);
        sb.append("-");
        sb.append(Build.MODEL);
        sb.append("__");
        sb.append(str);
        sb.append("__");
        try {
            sb.append("1.0".replaceAll("\\s+", "_"));
        } catch (Exception unused) {
            sb.append("unknown");
        }
        sb.append("__");
        sb.append("android");
        sb.append("__android");
        sb.append(Build.VERSION.RELEASE);
        return sb.toString();
    }

    private static String genMfpString(Context context) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            String os = getOS();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("os", os);
            }
            String imei = getImei(context);
            if (!TextUtils.isEmpty(imei)) {
                jSONObject.put("imei", imei);
            }
            String meid = getMeid(context);
            if (!TextUtils.isEmpty(meid)) {
                jSONObject.put("meid", meid);
            }
            String imsi = getImsi(context);
            if (!TextUtils.isEmpty(imsi)) {
                jSONObject.put("imsi", imsi);
            }
            String mac = getMac(context);
            if (!TextUtils.isEmpty(mac)) {
                jSONObject.put("mac", mac);
            }
            String iccid = getIccid(context);
            if (!TextUtils.isEmpty(iccid)) {
                jSONObject.put("iccid", iccid);
            }
            String serialNo = getSerialNo();
            if (!TextUtils.isEmpty(serialNo)) {
                jSONObject.put("serial", serialNo);
            }
            String androidId = getAndroidId(context);
            if (!TextUtils.isEmpty(androidId)) {
                jSONObject.put("androidid", androidId);
            }
            String cpu = getCpu();
            if (!TextUtils.isEmpty(cpu)) {
                jSONObject.put("cpu", cpu);
            }
            String model = getModel();
            if (!TextUtils.isEmpty(model)) {
                jSONObject.put("model", model);
            }
            String sdSize = getSdSize();
            if (!TextUtils.isEmpty(sdSize)) {
                jSONObject.put("sdcard", sdSize);
            }
            String resolution = getResolution(context);
            if (!TextUtils.isEmpty(resolution)) {
                jSONObject.put("resolution", resolution);
            }
            String ssid = getSsid(context);
            if (!TextUtils.isEmpty(ssid)) {
                jSONObject.put("ssid", ssid);
            }
            String wifiBssid = getWifiBssid(context);
            if (!TextUtils.isEmpty(wifiBssid)) {
                jSONObject.put("bssid", wifiBssid);
            }
            String deviceName = getDeviceName();
            if (!TextUtils.isEmpty(deviceName)) {
                jSONObject.put("deviceName", deviceName);
            }
            String connectType = getConnectType(context);
            if (!TextUtils.isEmpty(connectType)) {
                jSONObject.put("connecttype", connectType);
            }
            try {
                str = generateUAAid(context);
            } catch (Exception e) {
                e.printStackTrace();
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("ua", str);
            }
            double batteryCapacity = getBatteryCapacity(context);
            jSONObject.put("batterymaxcapacity", String.valueOf(batteryCapacity));
            jSONObject.put("batterycurrentcapacity", String.valueOf(batteryCapacity));
            BatteryInfo batteryInfo = new BatteryInfo(context);
            jSONObject.put("batterycurrentvoltage", batteryInfo.getVoltage());
            jSONObject.put("batterycurrenttemperature", batteryInfo.getTemperature());
            jSONObject.put("batterycurrentcapacity", (batteryCapacity * ((double) batteryInfo.getLevel())) / ((double) batteryInfo.getScale()));
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    private static int splite(byte[] bArr, int i, int i2) {
        if (i >= bArr.length) {
            return -1;
        }
        return Math.min(bArr.length - i, i2);
    }

    private static PublicKey getPublicKey(String str) throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes(), 2)));
    }

    private static String getOS() {
        try {
            return "Android " + Build.VERSION.RELEASE;
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getImei(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getMeid(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getImsi(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Exception unused) {
            return "";
        }
    }

    private static String bytesToString(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02X:", Byte.valueOf(bArr[i])));
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private static String getMacAddr() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getMac(Context context) {
        WifiInfo connectionInfo;
        if (Build.VERSION.SDK_INT >= 23) {
            return getMacAddr();
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                return "";
            }
            return connectionInfo.getMacAddress();
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getIccid(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getSerialNo() {
        if (Build.VERSION.SDK_INT >= 26) {
            return getSerialNoForO();
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.serialno", "unknown");
        } catch (Exception unused) {
            return "";
        }
    }

    private static double getBatteryCapacity(Context context) {
        Object obj;
        try {
            obj = Class.forName("com.android.internal.os.PowerProfile").getConstructor(Context.class).newInstance(context);
        } catch (Exception unused) {
            obj = null;
        }
        try {
            return ((Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getAveragePower", String.class).invoke(obj, "battery.capacity")).doubleValue();
        } catch (Exception unused2) {
            return 0.0d;
        }
    }

    private static String getSerialNoForO() {
        try {
            return Build.getSerial();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String getAndroidId(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getCpu() {
        try {
            return Build.CPU_ABI;
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getModel() {
        try {
            return Build.MODEL;
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getSdSize() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return Long.toString(((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()));
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getResolution(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return String.valueOf(displayMetrics.widthPixels) + "*" + String.valueOf(displayMetrics.heightPixels);
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getSsid(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getSSID() : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getWifiBssid(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getBSSID() : "";
        } catch (SecurityException unused) {
            return "";
        }
    }

    private static String getDeviceName() {
        try {
            return Build.BRAND;
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getConnectType(Context context) {
        String str;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "none";
            }
            if (activeNetworkInfo.getType() == 0) {
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        str = "2G";
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        str = "3G";
                        break;
                    case 13:
                        str = "4G";
                        break;
                    default:
                        return "none";
                }
            } else if (activeNetworkInfo.getType() != 1) {
                return "none";
            } else {
                str = "wifi";
            }
            return str;
        } catch (Exception unused) {
            return "none";
        }
    }
}
