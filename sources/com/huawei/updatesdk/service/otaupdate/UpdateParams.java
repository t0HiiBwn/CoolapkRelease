package com.huawei.updatesdk.service.otaupdate;

import java.util.List;

public class UpdateParams {
    private String appStorePkgName;
    private boolean isShowImmediate;
    private int minIntervalDay;
    private boolean mustBtnOne;
    private List<String> packageList;
    private String serviceZone;
    private String targetPkgName;

    public static final class Builder {
        private String appStorePkgName = "com.huawei.appmarket";
        private boolean isShowImmediate;
        private int minIntervalDay;
        private boolean mustBtnOne;
        private List<String> packageList;
        private String serviceZone;
        private String targetPkgName;

        public UpdateParams build() {
            return new UpdateParams(this);
        }

        public Builder setAppStorePkgName(String str) {
            this.appStorePkgName = str;
            return this;
        }

        public Builder setIsShowImmediate(boolean z) {
            this.isShowImmediate = z;
            return this;
        }

        public Builder setMinIntervalDay(int i) {
            this.minIntervalDay = i;
            return this;
        }

        public Builder setMustBtnOne(boolean z) {
            this.mustBtnOne = z;
            return this;
        }

        public Builder setPackageList(List<String> list) {
            this.packageList = list;
            return this;
        }

        public Builder setServiceZone(String str) {
            this.serviceZone = str;
            return this;
        }

        public Builder setTargetPkgName(String str) {
            this.targetPkgName = str;
            return this;
        }
    }

    private UpdateParams(Builder builder) {
        this.appStorePkgName = "com.huawei.appmarket";
        this.isShowImmediate = false;
        this.minIntervalDay = 0;
        this.mustBtnOne = false;
        this.serviceZone = builder.serviceZone;
        this.appStorePkgName = builder.appStorePkgName;
        this.targetPkgName = builder.targetPkgName;
        this.isShowImmediate = builder.isShowImmediate;
        this.minIntervalDay = builder.minIntervalDay;
        this.mustBtnOne = builder.mustBtnOne;
        this.packageList = builder.packageList;
    }

    public String getAppStorePkgName() {
        return this.appStorePkgName;
    }

    public int getMinIntervalDay() {
        return this.minIntervalDay;
    }

    public List<String> getPackageList() {
        return this.packageList;
    }

    public String getServiceZone() {
        return this.serviceZone;
    }

    public String getTargetPkgName() {
        return this.targetPkgName;
    }

    public boolean isMustBtnOne() {
        return this.mustBtnOne;
    }

    public boolean isShowImmediate() {
        return this.isShowImmediate;
    }
}
