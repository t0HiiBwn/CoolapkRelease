package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.PackageUtils;
import com.huawei.hms.framework.common.StringUtils;

public class GrsConfig {
    private String appName;
    private String countrySource;
    private String issueCountry;
    private String regCountry;
    private String serCountry;
    private String userId;
    private String versionName;

    public boolean equal(GrsConfig grsConfig) {
        return grsConfig != null && StringUtils.strEquals(this.appName, grsConfig.getAppName()) && StringUtils.strEquals(this.serCountry, grsConfig.getSerCountry()) && StringUtils.strEquals(this.regCountry, grsConfig.getRegCountry()) && StringUtils.strEquals(this.issueCountry, grsConfig.getIssueCountry()) && StringUtils.strEquals(this.userId, grsConfig.getuserId()) && StringUtils.strEquals(this.versionName, grsConfig.getVersionName()) && StringUtils.strEquals(this.countrySource, grsConfig.getCountrySource());
    }

    public String getAppName() {
        return this.appName;
    }

    public String getCountrySource() {
        return this.countrySource;
    }

    public GrsBaseInfo getGrsBaseInfo(Context context) {
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setSerCountry(this.serCountry);
        grsBaseInfo.setVersionName(TextUtils.isEmpty(this.versionName) ? PackageUtils.getVersionName(context) : this.versionName);
        grsBaseInfo.setAppName(this.appName);
        grsBaseInfo.setUid(this.userId);
        grsBaseInfo.setRegCountry(this.regCountry);
        grsBaseInfo.setIssueCountry(this.issueCountry);
        grsBaseInfo.setCountrySource(this.countrySource);
        return grsBaseInfo;
    }

    public String getIssueCountry() {
        return this.issueCountry;
    }

    public String getRegCountry() {
        return this.regCountry;
    }

    public String getSerCountry() {
        return this.serCountry;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public String getuserId() {
        return this.userId;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setCountrySource(String str) {
        this.countrySource = str;
    }

    public void setIssueCountry(String str) {
        this.issueCountry = str;
    }

    public void setRegCountry(String str) {
        this.regCountry = str;
    }

    public void setSerCountry(String str) {
        this.serCountry = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }
}
