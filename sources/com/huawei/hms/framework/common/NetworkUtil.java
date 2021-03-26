package com.huawei.hms.framework.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.LinkedList;

public class NetworkUtil {
    private static final String TAG = "NetworkUtil";
    private static final int TYPE_WIFI_P2P = 13;

    public static final class NetType {
        public static final int TYPE_2G = 2;
        public static final int TYPE_3G = 3;
        public static final int TYPE_4G = 4;
        public static final int TYPE_NO_NETWORK = -1;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WIFI = 1;
    }

    public static String getDnsServerIps(Context context) {
        return Arrays.toString(getDnsServerIpsFromConnectionManager(context));
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0055  */
    private static String[] getDnsServerIpsFromConnectionManager(Context context) {
        ConnectivityManager connectivityManager;
        Object e;
        StringBuilder sb;
        String str;
        LinkedList<String> linkedList = new LinkedList<>();
        if (!(Build.VERSION.SDK_INT < 21 || context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null)) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    linkedList = getDnsServerIpsFromLinkProperties(connectivityManager, activeNetworkInfo);
                }
            } catch (SecurityException e2) {
                e = e2;
                str = TAG;
                sb = new StringBuilder();
                sb.append("getActiveNetworkInfo failed, exception:");
                sb.append(e.getClass().getSimpleName());
                Logger.i(str, sb.toString());
                if (linkedList.isEmpty()) {
                }
            } catch (RuntimeException e3) {
                e = e3;
                str = TAG;
                sb = new StringBuilder();
                sb.append("getActiveNetworkInfo failed, exception:");
                sb.append(e.getClass().getSimpleName());
                Logger.i(str, sb.toString());
                if (linkedList.isEmpty()) {
                }
            }
        }
        return linkedList.isEmpty() ? new String[0] : (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    private static LinkedList<String> getDnsServerIpsFromLinkProperties(ConnectivityManager connectivityManager, NetworkInfo networkInfo) {
        NetworkInfo networkInfo2;
        LinkProperties linkProperties;
        LinkedList<String> linkedList = new LinkedList<>();
        Network[] allNetworks = connectivityManager.getAllNetworks();
        if (!(allNetworks == null || allNetworks.length == 0)) {
            for (Network network : allNetworks) {
                if (!(network == null || (networkInfo2 = connectivityManager.getNetworkInfo(network)) == null || networkInfo2.getType() != networkInfo.getType() || (linkProperties = connectivityManager.getLinkProperties(network)) == null)) {
                    for (InetAddress inetAddress : linkProperties.getDnsServers()) {
                        linkedList.add(inetAddress.getHostAddress());
                    }
                }
            }
        }
        return linkedList;
    }

    public static NetworkInfo getNetworkInfo(Context context) {
        ConnectivityManager connectivityManager;
        if (!(context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null)) {
            try {
                return connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        return null;
    }

    public static int getNetworkType(Context context) {
        if (context != null) {
            return getNetworkType(getNetworkInfo(context));
        }
        return 0;
    }

    public static int getNetworkType(NetworkInfo networkInfo) {
        int i;
        if (networkInfo == null || !networkInfo.isConnected()) {
            return -1;
        }
        int type = networkInfo.getType();
        if (1 == type || 13 == type) {
            return 1;
        }
        if (type == 0) {
            int subtype = networkInfo.getSubtype();
            switch (subtype) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    i = 2;
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
                    i = 3;
                    break;
                case 13:
                    i = 4;
                    break;
                default:
                    i = 0;
                    break;
            }
            if (i != 0 || Build.VERSION.SDK_INT < 25) {
                return i;
            }
            if (subtype == 16) {
                return 2;
            }
            if (subtype == 17) {
                return 3;
            }
        }
        return 0;
    }

    public static String getSSIDByNetWorkId(Context context) {
        return "";
    }
}
