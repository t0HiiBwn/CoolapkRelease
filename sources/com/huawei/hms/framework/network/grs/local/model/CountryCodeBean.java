package com.huawei.hms.framework.network.grs.local.model;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.SystemPropUtils;
import java.util.Locale;
import java.util.Objects;

public class CountryCodeBean {
    private static final String ANDRIOD_SYSTEMPROP = "android.os.SystemProperties";
    private static final int COUNTRYCODE_SIZE = 2;
    private static final String LOCALE_COUNTRYSYSTEMPROP = "ro.product.locale.region";
    private static final String SPECIAL_COUNTRYCODE_CN = "cn";
    private static final String SPECIAL_COUNTRYCODE_EU = "eu";
    private static final String SPECIAL_COUNTRYCODE_LA = "la";
    private static final String TAG = "CountryCodeBean";
    private static final String VENDORCOUNTRY_SYSTEMPROP = "ro.hw.country";
    private String countryCode = "UNKNOWN";
    private String countrySource = "UNKNOWN";

    public CountryCodeBean(Context context, boolean z) {
        init(context, z);
        this.countryCode = this.countryCode.toUpperCase(Locale.ENGLISH);
    }

    private void checkCodeLenth() {
        String str = this.countryCode;
        if (str == null || str.length() != 2) {
            this.countryCode = "UNKNOWN";
            this.countrySource = "UNKNOWN";
        }
    }

    private void getLocaleCountryCode() {
        String property = SystemPropUtils.getProperty("get", "ro.product.locale.region", "android.os.SystemProperties", "UNKNOWN");
        this.countryCode = property;
        this.countrySource = "LOCALE_INFO";
        if (!"cn".equalsIgnoreCase(property)) {
            Logger.w(TAG, "countryCode from system language is not reliable.");
            this.countryCode = "UNKNOWN";
            this.countrySource = "UNKNOWN";
        }
    }

    private void getSimCountryCode(Context context, boolean z) {
        String str;
        String str2;
        TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
        if (telephonyManager != null) {
            if (!z || telephonyManager.getPhoneType() == 2) {
                str2 = "SIM_COUNTRY";
                Logger.v(TAG, "getCountryCode get country code from {%s}", str2);
                str = telephonyManager.getSimCountryIso();
            } else {
                str2 = "NETWORK_COUNTRY";
                Logger.v(TAG, "getCountryCode get country code from {%s}", str2);
                str = telephonyManager.getNetworkCountryIso();
            }
            this.countryCode = str;
            this.countrySource = str2;
        }
        checkCodeLenth();
    }

    private void getVendorCountryCode() {
        this.countrySource = "VENDOR_COUNTRY";
        String property = SystemPropUtils.getProperty("get", "ro.hw.country", "android.os.SystemProperties", "UNKNOWN");
        this.countryCode = property;
        if ("eu".equalsIgnoreCase(property) || "la".equalsIgnoreCase(this.countryCode)) {
            this.countryCode = "UNKNOWN";
            this.countrySource = "UNKNOWN";
            return;
        }
        checkCodeLenth();
    }

    private void init(Context context, boolean z) {
        Objects.requireNonNull(context, "context must be not null.Please provide app's Context");
        try {
            getVendorCountryCode();
            if (isCodeValidate()) {
                Logger.v(TAG, "getCountryCode get country code from {%s}", "VENDOR_COUNTRY");
                return;
            }
            getSimCountryCode(context, z);
            if (isCodeValidate()) {
                Logger.v(TAG, "getCountryCode get country code from {%s}", "SIM_COUNTRY");
                return;
            }
            getLocaleCountryCode();
            if (isCodeValidate()) {
                Logger.v(TAG, "getCountryCode get country code from {%s}", "LOCALE_INFO");
            }
        } catch (Exception unused) {
            Logger.w(TAG, "get CountryCode error");
        }
    }

    private boolean isCodeValidate() {
        return !"UNKNOWN".equals(this.countryCode);
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getCountrySource() {
        return this.countrySource;
    }
}
