package com.blankj.utilcode.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.blankj.utilcode.util.Utils;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArraySet;

public final class NetworkUtils {
    private static final long SCAN_PERIOD_MILLIS = 3000;
    private static final Set<Utils.Consumer<WifiScanResults>> SCAN_RESULT_CONSUMERS = new CopyOnWriteArraySet();
    private static WifiScanResults sPreWifiScanResults;
    private static Timer sScanWifiTimer;

    public enum NetworkType {
        NETWORK_ETHERNET,
        NETWORK_WIFI,
        NETWORK_5G,
        NETWORK_4G,
        NETWORK_3G,
        NETWORK_2G,
        NETWORK_UNKNOWN,
        NETWORK_NO
    }

    public interface OnNetworkStatusChangedListener {
        void onConnected(NetworkType networkType);

        void onDisconnected();
    }

    private NetworkUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void openWirelessSettings() {
        Utils.getApp().startActivity(new Intent("android.settings.WIRELESS_SETTINGS").setFlags(268435456));
    }

    public static boolean isConnected() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static Utils.Task<Boolean> isAvailableAsync(Utils.Consumer<Boolean> consumer) {
        Objects.requireNonNull(consumer, "Argument 'consumer' of type Utils.Consumer<Boolean> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return UtilsBridge.doAsync(new Utils.Task<Boolean>(consumer) {
            /* class com.blankj.utilcode.util.NetworkUtils.AnonymousClass1 */

            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public Boolean doInBackground() {
                return Boolean.valueOf(NetworkUtils.isAvailable());
            }
        });
    }

    public static boolean isAvailable() {
        return isAvailableByDns() || isAvailableByPing(null);
    }

    public static void isAvailableByPingAsync(Utils.Consumer<Boolean> consumer) {
        isAvailableByPingAsync("", consumer);
    }

    public static Utils.Task<Boolean> isAvailableByPingAsync(final String str, Utils.Consumer<Boolean> consumer) {
        Objects.requireNonNull(consumer, "Argument 'consumer' of type Utils.Consumer<Boolean> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return UtilsBridge.doAsync(new Utils.Task<Boolean>(consumer) {
            /* class com.blankj.utilcode.util.NetworkUtils.AnonymousClass2 */

            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public Boolean doInBackground() {
                return Boolean.valueOf(NetworkUtils.isAvailableByPing(str));
            }
        });
    }

    public static boolean isAvailableByPing() {
        return isAvailableByPing("");
    }

    public static boolean isAvailableByPing(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "223.5.5.5";
        }
        if (ShellUtils.execCmd(String.format("ping -c 1 %s", str), false).result == 0) {
            return true;
        }
        return false;
    }

    public static void isAvailableByDnsAsync(Utils.Consumer<Boolean> consumer) {
        isAvailableByDnsAsync("", consumer);
    }

    public static Utils.Task isAvailableByDnsAsync(final String str, Utils.Consumer<Boolean> consumer) {
        Objects.requireNonNull(consumer, "Argument 'consumer' of type Utils.Consumer<Boolean> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return UtilsBridge.doAsync(new Utils.Task<Boolean>(consumer) {
            /* class com.blankj.utilcode.util.NetworkUtils.AnonymousClass3 */

            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public Boolean doInBackground() {
                return Boolean.valueOf(NetworkUtils.isAvailableByDns(str));
            }
        });
    }

    public static boolean isAvailableByDns() {
        return isAvailableByDns("");
    }

    public static boolean isAvailableByDns(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "www.baidu.com";
        }
        try {
            if (InetAddress.getByName(str) != null) {
                return true;
            }
            return false;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean getMobileDataEnabled() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) Utils.getApp().getSystemService("phone");
            if (telephonyManager == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                return telephonyManager.isDataEnabled();
            }
            Method declaredMethod = telephonyManager.getClass().getDeclaredMethod("getDataEnabled", new Class[0]);
            if (declaredMethod != null) {
                return ((Boolean) declaredMethod.invoke(telephonyManager, new Object[0])).booleanValue();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isMobileData() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 0;
    }

    public static boolean is4G() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getSubtype() == 13;
    }

    public static boolean is5G() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getSubtype() == 20;
    }

    public static boolean getWifiEnabled() {
        WifiManager wifiManager = (WifiManager) Utils.getApp().getSystemService("wifi");
        if (wifiManager == null) {
            return false;
        }
        return wifiManager.isWifiEnabled();
    }

    public static void setWifiEnabled(boolean z) {
        WifiManager wifiManager = (WifiManager) Utils.getApp().getSystemService("wifi");
        if (wifiManager != null && z != wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(z);
        }
    }

    public static boolean isWifiConnected() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) Utils.getApp().getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 1) {
            return false;
        }
        return true;
    }

    public static boolean isWifiAvailable() {
        return getWifiEnabled() && isAvailable();
    }

    public static Utils.Task<Boolean> isWifiAvailableAsync(Utils.Consumer<Boolean> consumer) {
        Objects.requireNonNull(consumer, "Argument 'consumer' of type Utils.Consumer<Boolean> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return UtilsBridge.doAsync(new Utils.Task<Boolean>(consumer) {
            /* class com.blankj.utilcode.util.NetworkUtils.AnonymousClass4 */

            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public Boolean doInBackground() {
                return Boolean.valueOf(NetworkUtils.isWifiAvailable());
            }
        });
    }

    public static String getNetworkOperatorName() {
        TelephonyManager telephonyManager = (TelephonyManager) Utils.getApp().getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        return telephonyManager.getNetworkOperatorName();
    }

    public static NetworkType getNetworkType() {
        if (isEthernet()) {
            return NetworkType.NETWORK_ETHERNET;
        }
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return NetworkType.NETWORK_NO;
        }
        if (activeNetworkInfo.getType() == 1) {
            return NetworkType.NETWORK_WIFI;
        }
        if (activeNetworkInfo.getType() != 0) {
            return NetworkType.NETWORK_UNKNOWN;
        }
        switch (activeNetworkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return NetworkType.NETWORK_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return NetworkType.NETWORK_3G;
            case 13:
            case 18:
                return NetworkType.NETWORK_4G;
            case 19:
            default:
                String subtypeName = activeNetworkInfo.getSubtypeName();
                if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) {
                    return NetworkType.NETWORK_3G;
                }
                return NetworkType.NETWORK_UNKNOWN;
            case 20:
                return NetworkType.NETWORK_5G;
        }
    }

    private static boolean isEthernet() {
        NetworkInfo networkInfo;
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) Utils.getApp().getSystemService("connectivity");
        if (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(9)) == null || (state = networkInfo.getState()) == null) {
            return false;
        }
        if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
            return true;
        }
        return false;
    }

    private static NetworkInfo getActiveNetworkInfo() {
        ConnectivityManager connectivityManager = (ConnectivityManager) Utils.getApp().getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    public static Utils.Task<String> getIPAddressAsync(final boolean z, Utils.Consumer<String> consumer) {
        Objects.requireNonNull(consumer, "Argument 'consumer' of type Utils.Consumer<String> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return UtilsBridge.doAsync(new Utils.Task<String>(consumer) {
            /* class com.blankj.utilcode.util.NetworkUtils.AnonymousClass5 */

            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public String doInBackground() {
                return NetworkUtils.getIPAddress(z);
            }
        });
    }

    public static String getIPAddress(boolean z) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            LinkedList linkedList = new LinkedList();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement.isUp()) {
                    if (!nextElement.isLoopback()) {
                        Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            linkedList.addFirst(inetAddresses.nextElement());
                        }
                    }
                }
            }
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                InetAddress inetAddress = (InetAddress) it2.next();
                if (!inetAddress.isLoopbackAddress()) {
                    String hostAddress = inetAddress.getHostAddress();
                    boolean z2 = hostAddress.indexOf(58) < 0;
                    if (z) {
                        if (z2) {
                            return hostAddress;
                        }
                    } else if (!z2) {
                        int indexOf = hostAddress.indexOf(37);
                        if (indexOf < 0) {
                            return hostAddress.toUpperCase();
                        }
                        return hostAddress.substring(0, indexOf).toUpperCase();
                    }
                }
            }
            return "";
        } catch (SocketException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getBroadcastIpAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            new LinkedList();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement.isUp()) {
                    if (!nextElement.isLoopback()) {
                        List<InterfaceAddress> interfaceAddresses = nextElement.getInterfaceAddresses();
                        int size = interfaceAddresses.size();
                        for (int i = 0; i < size; i++) {
                            InetAddress broadcast = interfaceAddresses.get(i).getBroadcast();
                            if (broadcast != null) {
                                return broadcast.getHostAddress();
                            }
                        }
                        continue;
                    }
                }
            }
            return "";
        } catch (SocketException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Utils.Task<String> getDomainAddressAsync(final String str, Utils.Consumer<String> consumer) {
        Objects.requireNonNull(consumer, "Argument 'consumer' of type Utils.Consumer<String> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return UtilsBridge.doAsync(new Utils.Task<String>(consumer) {
            /* class com.blankj.utilcode.util.NetworkUtils.AnonymousClass6 */

            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public String doInBackground() {
                return NetworkUtils.getDomainAddress(str);
            }
        });
    }

    public static String getDomainAddress(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getIpAddressByWifi() {
        WifiManager wifiManager = (WifiManager) Utils.getApp().getSystemService("wifi");
        if (wifiManager == null) {
            return "";
        }
        return Formatter.formatIpAddress(wifiManager.getDhcpInfo().ipAddress);
    }

    public static String getGatewayByWifi() {
        WifiManager wifiManager = (WifiManager) Utils.getApp().getSystemService("wifi");
        if (wifiManager == null) {
            return "";
        }
        return Formatter.formatIpAddress(wifiManager.getDhcpInfo().gateway);
    }

    public static String getNetMaskByWifi() {
        WifiManager wifiManager = (WifiManager) Utils.getApp().getSystemService("wifi");
        if (wifiManager == null) {
            return "";
        }
        return Formatter.formatIpAddress(wifiManager.getDhcpInfo().netmask);
    }

    public static String getServerAddressByWifi() {
        WifiManager wifiManager = (WifiManager) Utils.getApp().getSystemService("wifi");
        if (wifiManager == null) {
            return "";
        }
        return Formatter.formatIpAddress(wifiManager.getDhcpInfo().serverAddress);
    }

    public static String getSSID() {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) Utils.getApp().getApplicationContext().getSystemService("wifi");
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return "";
        }
        String ssid = connectionInfo.getSSID();
        if (TextUtils.isEmpty(ssid)) {
            return "";
        }
        return (ssid.length() > 2 && ssid.charAt(0) == '\"' && ssid.charAt(ssid.length() - 1) == '\"') ? ssid.substring(1, ssid.length() - 1) : ssid;
    }

    public static void registerNetworkStatusChangedListener(OnNetworkStatusChangedListener onNetworkStatusChangedListener) {
        NetworkChangedReceiver.getInstance().registerListener(onNetworkStatusChangedListener);
    }

    public static boolean isRegisteredNetworkStatusChangedListener(OnNetworkStatusChangedListener onNetworkStatusChangedListener) {
        return NetworkChangedReceiver.getInstance().isRegistered(onNetworkStatusChangedListener);
    }

    public static void unregisterNetworkStatusChangedListener(OnNetworkStatusChangedListener onNetworkStatusChangedListener) {
        NetworkChangedReceiver.getInstance().unregisterListener(onNetworkStatusChangedListener);
    }

    public static WifiScanResults getWifiScanResult() {
        List<ScanResult> scanResults;
        WifiScanResults wifiScanResults = new WifiScanResults();
        if (getWifiEnabled() && (scanResults = ((WifiManager) Utils.getApp().getSystemService("wifi")).getScanResults()) != null) {
            wifiScanResults.setAllResults(scanResults);
        }
        return wifiScanResults;
    }

    public static void addOnWifiChangedConsumer(final Utils.Consumer<WifiScanResults> consumer) {
        if (consumer != null) {
            UtilsBridge.runOnUiThread(new Runnable() {
                /* class com.blankj.utilcode.util.NetworkUtils.AnonymousClass7 */

                @Override // java.lang.Runnable
                public void run() {
                    if (NetworkUtils.SCAN_RESULT_CONSUMERS.isEmpty()) {
                        NetworkUtils.SCAN_RESULT_CONSUMERS.add(consumer);
                        NetworkUtils.startScanWifi();
                        return;
                    }
                    consumer.accept(NetworkUtils.sPreWifiScanResults);
                    NetworkUtils.SCAN_RESULT_CONSUMERS.add(consumer);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void startScanWifi() {
        sPreWifiScanResults = new WifiScanResults();
        Timer timer = new Timer();
        sScanWifiTimer = timer;
        timer.schedule(new TimerTask() {
            /* class com.blankj.utilcode.util.NetworkUtils.AnonymousClass8 */

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                NetworkUtils.startScanWifiIfEnabled();
                WifiScanResults wifiScanResult = NetworkUtils.getWifiScanResult();
                if (!NetworkUtils.isSameScanResults(NetworkUtils.sPreWifiScanResults.allResults, wifiScanResult.allResults)) {
                    WifiScanResults unused = NetworkUtils.sPreWifiScanResults = wifiScanResult;
                    UtilsBridge.runOnUiThread(new Runnable() {
                        /* class com.blankj.utilcode.util.NetworkUtils.AnonymousClass8.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            for (Utils.Consumer consumer : NetworkUtils.SCAN_RESULT_CONSUMERS) {
                                consumer.accept(NetworkUtils.sPreWifiScanResults);
                            }
                        }
                    });
                }
            }
        }, 0, 3000);
    }

    /* access modifiers changed from: private */
    public static void startScanWifiIfEnabled() {
        if (getWifiEnabled()) {
            ((WifiManager) Utils.getApp().getSystemService("wifi")).startScan();
        }
    }

    public static void removeOnWifiChangedConsumer(final Utils.Consumer<WifiScanResults> consumer) {
        if (consumer != null) {
            UtilsBridge.runOnUiThread(new Runnable() {
                /* class com.blankj.utilcode.util.NetworkUtils.AnonymousClass9 */

                @Override // java.lang.Runnable
                public void run() {
                    NetworkUtils.SCAN_RESULT_CONSUMERS.remove(consumer);
                    if (NetworkUtils.SCAN_RESULT_CONSUMERS.isEmpty()) {
                        NetworkUtils.stopScanWifi();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void stopScanWifi() {
        Timer timer = sScanWifiTimer;
        if (timer != null) {
            timer.cancel();
            sScanWifiTimer = null;
        }
    }

    /* access modifiers changed from: private */
    public static boolean isSameScanResults(List<ScanResult> list, List<ScanResult> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!isSameScanResultContent(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSameScanResultContent(ScanResult scanResult, ScanResult scanResult2) {
        return scanResult != null && scanResult2 != null && UtilsBridge.equals(scanResult.BSSID, scanResult2.BSSID) && UtilsBridge.equals(scanResult.SSID, scanResult2.SSID) && UtilsBridge.equals(scanResult.capabilities, scanResult2.capabilities) && scanResult.level == scanResult2.level;
    }

    public static final class NetworkChangedReceiver extends BroadcastReceiver {
        private Set<OnNetworkStatusChangedListener> mListeners = new HashSet();
        private NetworkType mType;

        /* access modifiers changed from: private */
        public static NetworkChangedReceiver getInstance() {
            return LazyHolder.INSTANCE;
        }

        void registerListener(final OnNetworkStatusChangedListener onNetworkStatusChangedListener) {
            if (onNetworkStatusChangedListener != null) {
                UtilsBridge.runOnUiThread(new Runnable() {
                    /* class com.blankj.utilcode.util.NetworkUtils.NetworkChangedReceiver.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        int size = NetworkChangedReceiver.this.mListeners.size();
                        NetworkChangedReceiver.this.mListeners.add(onNetworkStatusChangedListener);
                        if (size == 0 && NetworkChangedReceiver.this.mListeners.size() == 1) {
                            NetworkChangedReceiver.this.mType = NetworkUtils.getNetworkType();
                            Utils.getApp().registerReceiver(NetworkChangedReceiver.getInstance(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                        }
                    }
                });
            }
        }

        boolean isRegistered(OnNetworkStatusChangedListener onNetworkStatusChangedListener) {
            if (onNetworkStatusChangedListener == null) {
                return false;
            }
            return this.mListeners.contains(onNetworkStatusChangedListener);
        }

        void unregisterListener(final OnNetworkStatusChangedListener onNetworkStatusChangedListener) {
            if (onNetworkStatusChangedListener != null) {
                UtilsBridge.runOnUiThread(new Runnable() {
                    /* class com.blankj.utilcode.util.NetworkUtils.NetworkChangedReceiver.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        int size = NetworkChangedReceiver.this.mListeners.size();
                        NetworkChangedReceiver.this.mListeners.remove(onNetworkStatusChangedListener);
                        if (size == 1 && NetworkChangedReceiver.this.mListeners.size() == 0) {
                            Utils.getApp().unregisterReceiver(NetworkChangedReceiver.getInstance());
                        }
                    }
                });
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                UtilsBridge.runOnUiThreadDelayed(new Runnable() {
                    /* class com.blankj.utilcode.util.NetworkUtils.NetworkChangedReceiver.AnonymousClass3 */

                    @Override // java.lang.Runnable
                    public void run() {
                        NetworkType networkType = NetworkUtils.getNetworkType();
                        if (NetworkChangedReceiver.this.mType != networkType) {
                            NetworkChangedReceiver.this.mType = networkType;
                            if (networkType == NetworkType.NETWORK_NO) {
                                for (OnNetworkStatusChangedListener onNetworkStatusChangedListener : NetworkChangedReceiver.this.mListeners) {
                                    onNetworkStatusChangedListener.onDisconnected();
                                }
                                return;
                            }
                            for (OnNetworkStatusChangedListener onNetworkStatusChangedListener2 : NetworkChangedReceiver.this.mListeners) {
                                onNetworkStatusChangedListener2.onConnected(networkType);
                            }
                        }
                    }
                }, 1000);
            }
        }

        private static class LazyHolder {
            private static final NetworkChangedReceiver INSTANCE = new NetworkChangedReceiver();

            private LazyHolder() {
            }
        }
    }

    public static final class WifiScanResults {
        private List<ScanResult> allResults = new ArrayList();
        private List<ScanResult> filterResults = new ArrayList();

        public List<ScanResult> getAllResults() {
            return this.allResults;
        }

        public List<ScanResult> getFilterResults() {
            return this.filterResults;
        }

        public void setAllResults(List<ScanResult> list) {
            this.allResults = list;
            this.filterResults = filterScanResult(list);
        }

        private static List<ScanResult> filterScanResult(List<ScanResult> list) {
            ScanResult scanResult;
            if (list == null || list.isEmpty()) {
                return new ArrayList();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
            for (ScanResult scanResult2 : list) {
                if (!TextUtils.isEmpty(scanResult2.SSID) && ((scanResult = (ScanResult) linkedHashMap.get(scanResult2.SSID)) == null || scanResult.level < scanResult2.level)) {
                    linkedHashMap.put(scanResult2.SSID, scanResult2);
                }
            }
            return new ArrayList(linkedHashMap.values());
        }
    }
}
