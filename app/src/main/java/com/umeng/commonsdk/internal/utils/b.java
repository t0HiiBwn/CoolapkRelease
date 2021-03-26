package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.common.ULog;

/* compiled from: BaseStationUtils */
public class b {
    private static final String b = "BaseStationUtils";
    private static boolean c;
    private static Context d;
    PhoneStateListener a;
    private TelephonyManager e;

    private b(Context context) {
        this.a = new PhoneStateListener() {
            /* class com.umeng.commonsdk.internal.utils.b.AnonymousClass1 */

            @Override // android.telephony.PhoneStateListener
            public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                String str;
                super.onSignalStrengthsChanged(signalStrength);
                ULog.e("BaseStationUtils", "base station onSignalStrengthsChanged");
                try {
                    b.this.e = (TelephonyManager) b.d.getSystemService("phone");
                    String[] split = signalStrength.toString().split(" ");
                    String str2 = null;
                    if (b.this.e != null && b.this.e.getNetworkType() == 13) {
                        str = "" + Integer.parseInt(split[9]);
                    } else if (b.this.e == null || !(b.this.e.getNetworkType() == 8 || b.this.e.getNetworkType() == 10 || b.this.e.getNetworkType() == 9 || b.this.e.getNetworkType() == 3)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append((signalStrength.getGsmSignalStrength() * 2) - 113);
                        sb.append("");
                        str = sb.toString();
                    } else {
                        String e = b.this.e();
                        if (!TextUtils.isEmpty(e) && e.equals("中国移动")) {
                            str2 = "0";
                        } else if (!TextUtils.isEmpty(e) && e.equals("中国联通")) {
                            str2 = signalStrength.getCdmaDbm() + "";
                        } else if (!TextUtils.isEmpty(e) && e.equals("中国电信")) {
                            str2 = signalStrength.getEvdoDbm() + "";
                        }
                        str = str2;
                    }
                    ULog.e("BaseStationUtils", "stationStrength is " + str);
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            UMWorkDispatch.sendEvent(b.d, 32772, com.umeng.commonsdk.internal.b.a(b.d).a(), str);
                        } catch (Throwable unused) {
                        }
                    }
                    b.this.c();
                } catch (Exception unused2) {
                }
            }
        };
        if (context != null) {
            try {
                this.e = (TelephonyManager) context.getSystemService("phone");
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: BaseStationUtils */
    private static class a {
        private static final b a = new b(b.d);

        private a() {
        }
    }

    public static b a(Context context) {
        if (d == null && context != null) {
            d = context.getApplicationContext();
        }
        return a.a;
    }

    public synchronized boolean a() {
        return c;
    }

    /* access modifiers changed from: private */
    public String e() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) d.getSystemService("phone");
            if (telephonyManager == null) {
                return null;
            }
            String simOperator = telephonyManager.getSimOperator();
            if (TextUtils.isEmpty(simOperator)) {
                return null;
            }
            if (!simOperator.equals("46000")) {
                if (!simOperator.equals("46002")) {
                    if (simOperator.equals("46001")) {
                        return "中国联通";
                    }
                    if (simOperator.equals("46003")) {
                        return "中国电信";
                    }
                    return null;
                }
            }
            return "中国移动";
        } catch (Throwable unused) {
            return null;
        }
    }

    public synchronized void b() {
        ULog.e("BaseStationUtils", "base station registerListener");
        try {
            TelephonyManager telephonyManager = this.e;
            if (telephonyManager != null) {
                telephonyManager.listen(this.a, 256);
            }
            c = true;
        } catch (Throwable unused) {
        }
    }

    public synchronized void c() {
        ULog.e("BaseStationUtils", "base station unRegisterListener");
        try {
            TelephonyManager telephonyManager = this.e;
            if (telephonyManager != null) {
                telephonyManager.listen(this.a, 0);
            }
            c = false;
        } catch (Throwable unused) {
        }
    }
}
