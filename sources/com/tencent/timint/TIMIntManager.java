package com.tencent.timint;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMManager;
import com.tencent.imsdk.TIMNetworkStatus;
import com.tencent.imsdk.TIMUser;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.common.ICallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.utils.IMErrInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TIMIntManager {
    private static int DEVICE_PAD = 3;
    private static int DEVICE_PC = 1;
    private static int DEVICE_PHONE = 2;
    private static int DISCONNECTED = 0;
    private static int NETWORK_2G = 2;
    private static int NETWORK_3G = 3;
    private static int NETWORK_4G = 4;
    private static int NETWORK_UNKNOWN = 6;
    private static int NETWORK_WAP = 1;
    private static int NETWORK_WIFI = 5;
    private static final String TAG = "TIMIntManager";
    static TIMIntManager inst = new TIMIntManager();

    private static native void nativeOpenIMRelay(int i, byte[] bArr, ICallback<byte[]> iCallback, long j);

    private static native void nativeQualityReport(int i, byte[] bArr, ICallback iCallback, long j);

    private static native void nativeRequest(String str, byte[] bArr, ICallback<byte[]> iCallback, long j);

    private static native void nativeTinyId2UserId(List<Long> list, ICallback<Map<Long, String>> iCallback, long j);

    private static native void nativeUserId2TinyId(List<String> list, ICallback<Map<String, Long>> iCallback, long j);

    private TIMIntManager() {
    }

    public static TIMIntManager getInstance() {
        return inst;
    }

    public TIMNetworkStatus getNetworkStatus() {
        return TIMManager.getInstance().getNetworkStatus();
    }

    public void request(String str, byte[] bArr, TIMValueCallBack<byte[]> tIMValueCallBack) {
        request(str, bArr, tIMValueCallBack, 0);
    }

    public void request(String str, byte[] bArr, TIMValueCallBack<byte[]> tIMValueCallBack, long j) {
        nativeRequest(str, bArr, new ICallback<byte[]>(tIMValueCallBack) {
            /* class com.tencent.timint.TIMIntManager.AnonymousClass1 */
        }, j);
    }

    public void userIdToTinyId(List<String> list, TIMValueCallBack<List<TIMUser>> tIMValueCallBack) {
        userIdToTinyId(list, tIMValueCallBack, 0);
    }

    public void userIdToTinyId(List<String> list, final TIMValueCallBack<List<TIMUser>> tIMValueCallBack, long j) {
        if (tIMValueCallBack != null) {
            nativeUserId2TinyId(list, new ICallback<Map<String, Long>>(new TIMValueCallBack<Map<String, Long>>() {
                /* class com.tencent.timint.TIMIntManager.AnonymousClass2 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    tIMValueCallBack.onError(i, str);
                }

                public void onSuccess(Map<String, Long> map) {
                    ArrayList arrayList = new ArrayList();
                    for (String str : map.keySet()) {
                        TIMUser tIMUser = new TIMUser();
                        tIMUser.setSdkAppid((long) BaseManager.getInstance().getSdkAppId());
                        tIMUser.setTinyId(map.get(str).longValue());
                        tIMUser.setIdentifier(str);
                        arrayList.add(tIMUser);
                    }
                    tIMValueCallBack.onSuccess(arrayList);
                }
            }) {
                /* class com.tencent.timint.TIMIntManager.AnonymousClass3 */
            }, j);
        }
    }

    public void tinyIdToUserId(List<Long> list, TIMValueCallBack<List<TIMUser>> tIMValueCallBack) {
        tinyIdToUserId(list, tIMValueCallBack, 0);
    }

    public void tinyIdToUserId(List<Long> list, final TIMValueCallBack<List<TIMUser>> tIMValueCallBack, long j) {
        if (tIMValueCallBack != null) {
            nativeTinyId2UserId(list, new ICallback<Map<Long, String>>(new TIMValueCallBack<Map<Long, String>>() {
                /* class com.tencent.timint.TIMIntManager.AnonymousClass4 */

                @Override // com.tencent.imsdk.TIMValueCallBack
                public void onError(int i, String str) {
                    tIMValueCallBack.onError(i, str);
                }

                public void onSuccess(Map<Long, String> map) {
                    ArrayList arrayList = new ArrayList();
                    for (Long l : map.keySet()) {
                        long longValue = l.longValue();
                        TIMUser tIMUser = new TIMUser();
                        tIMUser.setSdkAppid((long) BaseManager.getInstance().getSdkAppId());
                        tIMUser.setTinyId(longValue);
                        tIMUser.setIdentifier(map.get(Long.valueOf(longValue)));
                        arrayList.add(tIMUser);
                    }
                    tIMValueCallBack.onSuccess(arrayList);
                }
            }) {
                /* class com.tencent.timint.TIMIntManager.AnonymousClass5 */
            }, j);
        }
    }

    public void requestMultiVideoApp(byte[] bArr, TIMValueCallBack<byte[]> tIMValueCallBack) {
        requestMultiVideoApp(bArr, tIMValueCallBack, 0);
    }

    public void requestMultiVideoApp(byte[] bArr, TIMValueCallBack<byte[]> tIMValueCallBack, long j) {
        nativeOpenIMRelay(0, bArr, new ICallback<byte[]>(tIMValueCallBack) {
            /* class com.tencent.timint.TIMIntManager.AnonymousClass6 */
        }, j);
    }

    public void requestMultiVideoInfo(byte[] bArr, TIMValueCallBack<byte[]> tIMValueCallBack) {
        requestMultiVideoInfo(bArr, tIMValueCallBack, 0);
    }

    public void requestMultiVideoInfo(byte[] bArr, TIMValueCallBack<byte[]> tIMValueCallBack, long j) {
        nativeOpenIMRelay(1, bArr, new ICallback<byte[]>(tIMValueCallBack) {
            /* class com.tencent.timint.TIMIntManager.AnonymousClass7 */
        }, j);
    }

    public long getTinyId() {
        return BaseManager.getInstance().getTinyId();
    }

    int getDeviceType() {
        int i = DEVICE_PHONE;
        Context applicationContext = IMContext.getInstance().getApplicationContext();
        if (applicationContext == null) {
            return i;
        }
        if (((TelephonyManager) applicationContext.getSystemService("phone")).getPhoneType() == 0 || (applicationContext.getResources().getConfiguration().screenLayout & 15) >= 3) {
            return DEVICE_PAD;
        }
        return DEVICE_PHONE;
    }

    int getNetworkType() {
        int i = NETWORK_UNKNOWN;
        Context applicationContext = IMContext.getInstance().getApplicationContext();
        if (applicationContext == null) {
            return DISCONNECTED;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) applicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return DISCONNECTED;
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            return NETWORK_WIFI;
        }
        if (type != 0) {
            return i;
        }
        if (!TextUtils.isEmpty(Proxy.getDefaultHost())) {
            return NETWORK_WAP;
        }
        switch (activeNetworkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return NETWORK_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return NETWORK_3G;
            case 13:
                return NETWORK_4G;
            default:
                return NETWORK_UNKNOWN;
        }
    }

    public void requestQualityReport(int i, byte[] bArr, TIMCallBack tIMCallBack) {
        String str = TAG;
        QLog.d(str, "quality report, type: " + i);
        if (tIMCallBack != null) {
            if (bArr == null) {
                QLog.e(str, "invalid param");
                tIMCallBack.onError(6017, "invalid param");
                return;
            }
            IMErrInfo readyCheck = IMContext.getInstance().readyCheck();
            if (readyCheck.getCode() != 0) {
                QLog.e(str, "requestQualityReport failed, code " + readyCheck.getCode() + "|err " + readyCheck.getMsg());
                tIMCallBack.onError(readyCheck.getCode(), readyCheck.getMsg());
                return;
            }
            nativeQualityReport(i, bArr, new ICallback(tIMCallBack) {
                /* class com.tencent.timint.TIMIntManager.AnonymousClass8 */
            }, 0);
        }
    }

    public int getLogLevel() {
        return TIMManager.getInstance().getSdkConfig().getLogLevel();
    }

    public String getLogPath() {
        return TIMManager.getInstance().getSdkConfig().getLogPath();
    }

    public boolean getIsLogPrintEnabled() {
        return TIMManager.getInstance().getSdkConfig().isLogPrintEnabled();
    }
}
