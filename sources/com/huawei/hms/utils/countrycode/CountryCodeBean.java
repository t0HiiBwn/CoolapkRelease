package com.huawei.hms.utils.countrycode;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.huawei.hms.framework.common.SystemPropUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.Locale;
import java.util.Objects;

public class CountryCodeBean {
    private String a = "UNKNOWN";
    private String b = "UNKNOWN";
    private boolean c = false;

    public CountryCodeBean(Context context, boolean z) {
        a(context, z);
        this.b = this.b.toUpperCase(Locale.ENGLISH);
    }

    public String a() {
        return this.b;
    }

    private void a(Context context, boolean z) {
        Objects.requireNonNull(context, "context must be not null.Please provide app's Context");
        try {
            d();
            if (b()) {
                HMSLog.i("CountryCodeBean", "getCountryCode get country code from VENDOR_COUNTRY");
                return;
            }
            b(context, z);
            if (b()) {
                HMSLog.i("CountryCodeBean", "getCountryCode get country code from SIM_COUNTRY");
                return;
            }
            e();
            if (b()) {
                HMSLog.i("CountryCodeBean", "getCountryCode get country code from LOCALE_INFO");
            }
        } catch (Exception unused) {
            HMSLog.w("CountryCodeBean", "get CountryCode error");
        }
    }

    private boolean b() {
        return !"UNKNOWN".equals(this.b);
    }

    private void c() {
        String str = this.b;
        if (str == null || str.length() != 2) {
            this.b = "UNKNOWN";
            this.a = "UNKNOWN";
        }
    }

    private void d() {
        this.a = "VENDOR_COUNTRY";
        String property = SystemPropUtils.getProperty("get", "ro.hw.country", "android.os.SystemProperties", "UNKNOWN");
        this.b = property;
        if ("normal".equalsIgnoreCase(property)) {
            this.c = true;
        }
        if ("eu".equalsIgnoreCase(this.b) || "la".equalsIgnoreCase(this.b)) {
            this.b = "UNKNOWN";
            this.a = "UNKNOWN";
            return;
        }
        c();
    }

    private void b(Context context, boolean z) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
        if (telephonyManager != null) {
            if (!z || telephonyManager.getPhoneType() == 2) {
                HMSLog.i("CountryCodeBean", "getCountryCode get country code from SIM_COUNTRY");
                this.b = telephonyManager.getSimCountryIso();
                this.a = "SIM_COUNTRY";
            } else {
                HMSLog.i("CountryCodeBean", "getCountryCode get country code from NETWORK_COUNTRY");
                this.b = telephonyManager.getNetworkCountryIso();
                this.a = "NETWORK_COUNTRY";
            }
        }
        c();
    }

    private void e() {
        String property = SystemPropUtils.getProperty("get", "ro.product.locale.region", "android.os.SystemProperties", "UNKNOWN");
        this.b = property;
        this.a = "LOCALE_INFO";
        if (!"cn".equalsIgnoreCase(property) && !this.c) {
            HMSLog.w("CountryCodeBean", "countryCode from system language is not reliable.");
            this.b = "UNKNOWN";
            this.a = "UNKNOWN";
        }
    }
}
