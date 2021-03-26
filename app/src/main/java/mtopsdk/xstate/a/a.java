package mtopsdk.xstate.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.util.Locale;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.xstate.NetworkClassEnum;
import mtopsdk.xstate.XState;

/* compiled from: NetworkStateReceiver */
public final class a extends BroadcastReceiver {
    private static ConnectivityManager a = null;
    private static WifiManager b = null;
    private static volatile String c = "";
    private static volatile String d = "";
    private static volatile String e = "unknown";

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.NetworkStateReceiver", "[onReceive] networkStateReceiver onReceive");
        }
        MtopSDKThreadPoolExecutorFactory.submit(new b(this, context));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:74:0x017e, code lost:
        if (r0.contains(r5) != false) goto L_0x0182;
     */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01bb  */
    final void a(Context context) {
        NetworkInfo networkInfo;
        NetworkClassEnum networkClassEnum;
        String str;
        if (context != null) {
            WifiInfo wifiInfo = null;
            try {
                if (a == null) {
                    a = (ConnectivityManager) context.getSystemService("connectivity");
                }
                networkInfo = a.getActiveNetworkInfo();
            } catch (Throwable th) {
                TBSdkLog.e("mtopsdk.NetworkStateReceiver", "getNetworkInfo error.", th);
                networkInfo = null;
            }
            if (networkInfo == null || !networkInfo.isConnected()) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i("mtopsdk.NetworkStateReceiver", "[updateNetworkStatus]no network");
                }
                XState.setValue("nq", NetworkClassEnum.NET_NO.getNetClass());
                XState.setValue("netType", NetworkClassEnum.NET_NO.getNetClass());
                return;
            }
            int type = networkInfo.getType();
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.NetworkStateReceiver", "[updateNetworkStatus] NetworkInfo isConnected=" + networkInfo.isConnected() + ", isAvailable=" + networkInfo.isAvailable() + ", type=" + a(type));
            }
            if (type == 0) {
                int subtype = networkInfo.getSubtype();
                switch (subtype) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        networkClassEnum = NetworkClassEnum.NET_2G;
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
                        networkClassEnum = NetworkClassEnum.NET_3G;
                        break;
                    case 13:
                        networkClassEnum = NetworkClassEnum.NET_4G;
                        break;
                    default:
                        networkClassEnum = NetworkClassEnum.NET_UNKONWN;
                        break;
                }
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                    TBSdkLog.d("mtopsdk.NetworkStateReceiver", "[updateNetworkStatus]Mobile network," + networkClassEnum.getNetClass());
                }
                String extraInfo = networkInfo.getExtraInfo();
                String str2 = "ctnet";
                if (!TextUtils.isEmpty(extraInfo)) {
                    String lowerCase = extraInfo.toLowerCase(Locale.US);
                    if (lowerCase.contains("cmwap")) {
                        str2 = "cmwap";
                    } else if (lowerCase.contains("uniwap")) {
                        str2 = "uniwap";
                    } else if (lowerCase.contains("3gwap")) {
                        str2 = "3gwap";
                    } else if (lowerCase.contains("ctwap")) {
                        str2 = "ctwap";
                    } else if (lowerCase.contains("cmnet")) {
                        str2 = "cmnet";
                    } else if (lowerCase.contains("uninet")) {
                        str2 = "uninet";
                    } else if (lowerCase.contains("3gnet")) {
                        str2 = "3gnet";
                    }
                    e = str2;
                    XState.setValue("nq", networkClassEnum.getNetClass());
                    switch (subtype) {
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
                            str = "CDMA - EvDo rev. 0";
                            break;
                        case 6:
                            str = "CDMA - EvDo rev. A";
                            break;
                        case 7:
                            str = "CDMA - 1xRTT";
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
                            str = "iDEN";
                            break;
                        case 12:
                            str = "CDMA - EvDo rev. B";
                            break;
                        case 13:
                            str = "LTE";
                            break;
                        case 14:
                            str = "CDMA - eHRPD";
                            break;
                        case 15:
                            str = "HSPA+";
                            break;
                        default:
                            str = "UNKNOWN";
                            break;
                    }
                    XState.setValue("netType", str);
                }
                str2 = "unknown";
                e = str2;
                XState.setValue("nq", networkClassEnum.getNetClass());
                switch (subtype) {
                }
                XState.setValue("netType", str);
            } else if (type == 1) {
                try {
                    if (b == null) {
                        b = (WifiManager) context.getSystemService("wifi");
                    }
                    wifiInfo = b.getConnectionInfo();
                } catch (Throwable th2) {
                    TBSdkLog.e("mtopsdk.NetworkStateReceiver", "[updateNetworkStatus]getWifiInfo error.", th2);
                }
                if (wifiInfo != null) {
                    d = wifiInfo.getBSSID();
                    c = wifiInfo.getSSID();
                }
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i("mtopsdk.NetworkStateReceiver", "[updateNetworkStatus]WIFI network.ssid= " + c + ", bssid=" + d);
                }
                XState.setValue("nq", NetworkClassEnum.NET_WIFI.getNetClass());
                XState.setValue("netType", NetworkClassEnum.NET_WIFI.getNetClass());
            } else if (type != 9) {
                String a2 = a(type);
                XState.setValue("nq", a2);
                XState.setValue("netType", a2);
            } else {
                XState.setValue("nq", NetworkClassEnum.NET_ETHERNET.getNetClass());
                XState.setValue("netType", NetworkClassEnum.NET_ETHERNET.getNetClass());
            }
        }
    }

    private static String a(int i) {
        switch (i) {
            case 0:
                return "MOBILE";
            case 1:
                return "WIFI";
            case 2:
                return "MOBILE_MMS";
            case 3:
                return "MOBILE_SUPL";
            case 4:
                return "MOBILE_DUN";
            case 5:
                return "MOBILE_HIPRI";
            case 6:
                return "WIMAX";
            case 7:
                return "BLUETOOTH";
            case 8:
                return "DUMMY";
            case 9:
                return "ETHERNET";
            case 10:
                return "MOBILE_FOTA";
            case 11:
                return "MOBILE_IMS";
            case 12:
                return "MOBILE_CBS";
            case 13:
                return "WIFI_P2P";
            case 14:
                return "MOBILE_IA";
            case 15:
                return "MOBILE_EMERGENCY";
            case 16:
                return "PROXY";
            case 17:
                return "VPN";
            default:
                return Integer.toString(i);
        }
    }
}
