package com.tencent.imsdk.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.tencent.imsdk.log.QLog;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.List;

public class NetConnectInfoCenter extends BroadcastReceiver {
    private static final int NETWORK_1xRTT = 107;
    private static final int NETWORK_2G3G = 2;
    private static final int NETWORK_CDMA = 104;
    private static final int NETWORK_CDMA1X = 98;
    private static final int NETWORK_EDGE = 102;
    private static final int NETWORK_EHRPD = 114;
    private static final int NETWORK_EVDO_0 = 105;
    private static final int NETWORK_EVDO_A = 106;
    private static final int NETWORK_EVDO_B = 112;
    private static final int NETWORK_GPRS = 101;
    private static final int NETWORK_HSDPA = 108;
    private static final int NETWORK_HSPA = 110;
    private static final int NETWORK_HSPAP = 115;
    private static final int NETWORK_HSUPA = 109;
    private static final int NETWORK_IDEN = 111;
    private static final int NETWORK_LTE = 113;
    private static final int NETWORK_UMTS = 103;
    private static final int NETWORK_UNDEFINED = 0;
    private static final int NETWORK_WCDMA = 99;
    private static final int NETWORK_WIFI = 1;
    private static final String TAG = "NetConnectInfoCenter";
    final int IPVX_IPV4_ONLY = 1;
    final int IPVX_IPV6_DUAL = 3;
    final int IPVX_IPV6_ONLY = 2;
    final int IPVX_UNKNOWN = 0;
    private int ipvxType = 0;
    private boolean isNetworkConnected = false;
    private ConnectivityManager mConnectivityManager;
    private Context mContext = null;
    private String mNetworkSSID;
    private int mNetworkType = 0;
    private String mServiceProvider;
    private TelephonyManager mTelephonyManager;
    private WifiManager mWifiManager;

    private static class Holder {
        static NetConnectInfoCenter instance = new NetConnectInfoCenter();

        private Holder() {
        }
    }

    public static NetConnectInfoCenter getInstance() {
        return Holder.instance;
    }

    void init(Context context) {
        this.mContext = context.getApplicationContext();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        context.getApplicationContext().registerReceiver(getInstance(), intentFilter);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.mConnectivityManager = connectivityManager;
        if (connectivityManager != null) {
            NetworkInfo networkInfo = null;
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (Exception e) {
                e.printStackTrace();
            }
            updateNetworkType(networkInfo);
        }
        updateNetworkSSID();
        updateProviderName();
        updateIPvXType();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            QLog.e(TAG, "receive broadcast intent == null return");
        } else if (intent.getAction() == null) {
            QLog.e(TAG, "receive broadcast intent.getAction == null return");
        } else if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") || intent.getAction().equals("android.net.wifi.STATE_CHANGE") || intent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")) {
            onNetworkChanged(context, intent);
        }
    }

    private void onNetworkChanged(Context context, Intent intent) {
        String str = TAG;
        QLog.i(str, "network changed, action: " + intent.getAction());
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            if (this.mConnectivityManager == null) {
                this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
            }
            ConnectivityManager connectivityManager = this.mConnectivityManager;
            if (connectivityManager == null) {
                QLog.e(str, "network changed, mConnectivityManager is null");
                return;
            }
            NetworkInfo networkInfo = null;
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (networkInfo != null) {
                if (networkInfo.isConnected()) {
                    String str2 = TAG;
                    QLog.i(str2, "network connected type = " + networkInfo.getType() + ", name = " + networkInfo.getTypeName());
                    this.isNetworkConnected = true;
                } else {
                    QLog.e(TAG, "network disconnected");
                    this.isNetworkConnected = false;
                }
                updateNetworkType(networkInfo);
                updateNetworkSSID();
                updateProviderName();
                String str3 = TAG;
                QLog.i(str3, "current network: " + networkInfo.toString());
            } else {
                QLog.e(TAG, "no network connection found");
                this.isNetworkConnected = false;
            }
            if (BaseManager.getInstance().isInited()) {
                NativeManager.nativeOnNetworkChanged(this.isNetworkConnected);
            }
            updateIPvXType();
        }
    }

    private void updateNetworkType(NetworkInfo networkInfo) {
        int i;
        NetworkInfo.State state;
        if (networkInfo == null || !networkInfo.isAvailable()) {
            this.mNetworkType = 0;
            return;
        }
        if (this.mConnectivityManager == null) {
            this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        }
        ConnectivityManager connectivityManager = this.mConnectivityManager;
        if (connectivityManager == null) {
            this.mNetworkType = 0;
            return;
        }
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
        if (networkInfo2 == null || (state = networkInfo2.getState()) == null || !(state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
            TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            if (telephonyManager == null) {
                this.mNetworkType = 0;
                return;
            }
            try {
                i = telephonyManager.getNetworkType();
            } catch (Exception e) {
                e.printStackTrace();
                String str = TAG;
                QLog.w(str, "getNetworkType:" + e.getLocalizedMessage());
                i = 0;
            }
            switch (i) {
                case 1:
                    this.mNetworkType = 101;
                    return;
                case 2:
                    this.mNetworkType = 102;
                    return;
                case 3:
                    this.mNetworkType = 103;
                    return;
                case 4:
                    this.mNetworkType = 104;
                    return;
                case 5:
                    this.mNetworkType = 105;
                    return;
                case 6:
                    this.mNetworkType = 106;
                    return;
                case 7:
                    this.mNetworkType = 107;
                    return;
                case 8:
                    this.mNetworkType = 108;
                    return;
                case 9:
                    this.mNetworkType = 109;
                    return;
                case 10:
                    this.mNetworkType = 110;
                    return;
                case 11:
                    this.mNetworkType = 111;
                    return;
                case 12:
                    this.mNetworkType = 112;
                    return;
                case 13:
                    this.mNetworkType = 113;
                    return;
                case 14:
                    this.mNetworkType = 114;
                    return;
                case 15:
                    this.mNetworkType = 115;
                    return;
                default:
                    this.mNetworkType = 0;
                    return;
            }
        } else {
            this.mNetworkType = 1;
        }
    }

    int getNetworkType() {
        return this.mNetworkType;
    }

    private void updateNetworkSSID() {
        WifiInfo connectionInfo;
        if (this.mWifiManager == null) {
            this.mWifiManager = (WifiManager) this.mContext.getSystemService("wifi");
        }
        WifiManager wifiManager = this.mWifiManager;
        if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
            this.mNetworkSSID = connectionInfo.getSSID();
        }
    }

    private void updateProviderName() {
        if (this.mTelephonyManager == null) {
            this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
        }
        TelephonyManager telephonyManager = this.mTelephonyManager;
        if (telephonyManager != null) {
            this.mServiceProvider = telephonyManager.getSimOperatorName();
        }
    }

    String getNetworkSSID() {
        return this.mNetworkSSID;
    }

    String getProviderName() {
        return this.mServiceProvider;
    }

    int getIPvXType() {
        return this.ipvxType;
    }

    private void updateIPvXType() {
        if (Build.VERSION.SDK_INT >= 23) {
            this.ipvxType = 0;
            if (this.mConnectivityManager == null) {
                this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
            }
            ConnectivityManager connectivityManager = this.mConnectivityManager;
            if (connectivityManager == null) {
                QLog.e(TAG, "updateIPvXType, mConnectivityManager is null");
                return;
            }
            try {
                LinkProperties linkProperties = connectivityManager.getLinkProperties(connectivityManager.getActiveNetwork());
                if (linkProperties == null) {
                    QLog.i(TAG, "updateIPvXType, no linkProperties");
                    return;
                }
                List<LinkAddress> linkAddresses = linkProperties.getLinkAddresses();
                QLog.d(TAG, "linkAddresses:" + linkAddresses.size());
                for (LinkAddress linkAddress : linkAddresses) {
                    InetAddress address = linkAddress.getAddress();
                    if ((address instanceof Inet4Address) && !address.isLinkLocalAddress()) {
                        this.ipvxType |= 1;
                    } else if ((address instanceof Inet6Address) && !address.isLinkLocalAddress()) {
                        this.ipvxType |= 2;
                    }
                    QLog.i(TAG, "linkAddresses|address:" + linkAddress.getAddress());
                }
                QLog.i(TAG, "updateIPvXType|type:" + this.ipvxType);
            } catch (Exception e) {
                QLog.w(TAG, "updateIPvXType, e: " + e.getLocalizedMessage());
                e.printStackTrace();
            }
        }
    }

    String getNetID() {
        String str;
        int networkType = getNetworkType();
        if (1 == networkType) {
            str = (("" + networkType) + ":") + getNetworkSSID();
        } else {
            str = (("" + networkType) + ":") + getProviderName();
        }
        return (str + ":") + getIPvXType();
    }

    public boolean isNetworkConnected() {
        if (this.mConnectivityManager == null) {
            this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        }
        ConnectivityManager connectivityManager = this.mConnectivityManager;
        if (connectivityManager == null) {
            QLog.e(TAG, "isNetworkConnected, mConnectivityManager is null");
            return false;
        }
        NetworkInfo networkInfo = null;
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (networkInfo == null) {
            QLog.e(TAG, "isNetworkConnected, activeNetwork is null");
            return false;
        } else if (networkInfo.isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    void uninit() {
        this.mContext.getApplicationContext().unregisterReceiver(getInstance());
    }
}
