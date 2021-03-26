package com.pgl.sys.ces.out;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import java.util.List;

public interface ISdkInfo {
    WifiInfo getConnectionInfo();

    String getDeviceId();

    String getHardwareAddress();

    String getLatitude();

    String getLongitude();

    List<ScanResult> getScanResults();

    String getSubscriberId();
}
