package com.coolapk.market.model;

import com.coolapk.market.model.ClickInfo;
import java.util.List;

final class AutoValue_ClickInfo extends ClickInfo {
    private final ClickInfo.ClickHandleListener clickHandleListener;
    private final List<String> downloadKeys;
    private final String packageName;
    private final Extra targetExtra;
    private final int targetFlag;
    private final String targetUrl;
    private final String uninstallKey;

    private AutoValue_ClickInfo(String str, String str2, Extra extra, int i, String str3, List<String> list, ClickInfo.ClickHandleListener clickHandleListener2) {
        this.packageName = str;
        this.targetUrl = str2;
        this.targetExtra = extra;
        this.targetFlag = i;
        this.uninstallKey = str3;
        this.downloadKeys = list;
        this.clickHandleListener = clickHandleListener2;
    }

    @Override // com.coolapk.market.model.ClickInfo
    public String getPackageName() {
        return this.packageName;
    }

    @Override // com.coolapk.market.model.ClickInfo
    public String getTargetUrl() {
        return this.targetUrl;
    }

    @Override // com.coolapk.market.model.ClickInfo
    public Extra getTargetExtra() {
        return this.targetExtra;
    }

    @Override // com.coolapk.market.model.ClickInfo
    public int getTargetFlag() {
        return this.targetFlag;
    }

    @Override // com.coolapk.market.model.ClickInfo
    public String getUninstallKey() {
        return this.uninstallKey;
    }

    @Override // com.coolapk.market.model.ClickInfo
    List<String> getDownloadKeys() {
        return this.downloadKeys;
    }

    @Override // com.coolapk.market.model.ClickInfo
    public ClickInfo.ClickHandleListener getClickHandleListener() {
        return this.clickHandleListener;
    }

    public String toString() {
        return "ClickInfo{packageName=" + this.packageName + ", targetUrl=" + this.targetUrl + ", targetExtra=" + this.targetExtra + ", targetFlag=" + this.targetFlag + ", uninstallKey=" + this.uninstallKey + ", downloadKeys=" + this.downloadKeys + ", clickHandleListener=" + this.clickHandleListener + "}";
    }

    public boolean equals(Object obj) {
        Extra extra;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClickInfo)) {
            return false;
        }
        ClickInfo clickInfo = (ClickInfo) obj;
        String str2 = this.packageName;
        if (str2 != null ? str2.equals(clickInfo.getPackageName()) : clickInfo.getPackageName() == null) {
            if (this.targetUrl.equals(clickInfo.getTargetUrl()) && ((extra = this.targetExtra) != null ? extra.equals(clickInfo.getTargetExtra()) : clickInfo.getTargetExtra() == null) && this.targetFlag == clickInfo.getTargetFlag() && ((str = this.uninstallKey) != null ? str.equals(clickInfo.getUninstallKey()) : clickInfo.getUninstallKey() == null) && this.downloadKeys.equals(clickInfo.getDownloadKeys())) {
                ClickInfo.ClickHandleListener clickHandleListener2 = this.clickHandleListener;
                if (clickHandleListener2 == null) {
                    if (clickInfo.getClickHandleListener() == null) {
                        return true;
                    }
                } else if (clickHandleListener2.equals(clickInfo.getClickHandleListener())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.packageName;
        int i = 0;
        int hashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.targetUrl.hashCode()) * 1000003;
        Extra extra = this.targetExtra;
        int hashCode2 = (((hashCode ^ (extra == null ? 0 : extra.hashCode())) * 1000003) ^ this.targetFlag) * 1000003;
        String str2 = this.uninstallKey;
        int hashCode3 = (((hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003) ^ this.downloadKeys.hashCode()) * 1000003;
        ClickInfo.ClickHandleListener clickHandleListener2 = this.clickHandleListener;
        if (clickHandleListener2 != null) {
            i = clickHandleListener2.hashCode();
        }
        return hashCode3 ^ i;
    }

    static final class Builder extends ClickInfo.Builder {
        private ClickInfo.ClickHandleListener clickHandleListener;
        private List<String> downloadKeys;
        private String packageName;
        private Extra targetExtra;
        private Integer targetFlag;
        private String targetUrl;
        private String uninstallKey;

        Builder() {
        }

        Builder(ClickInfo clickInfo) {
            this.packageName = clickInfo.getPackageName();
            this.targetUrl = clickInfo.getTargetUrl();
            this.targetExtra = clickInfo.getTargetExtra();
            this.targetFlag = Integer.valueOf(clickInfo.getTargetFlag());
            this.uninstallKey = clickInfo.getUninstallKey();
            this.downloadKeys = clickInfo.getDownloadKeys();
            this.clickHandleListener = clickInfo.getClickHandleListener();
        }

        @Override // com.coolapk.market.model.ClickInfo.Builder
        public ClickInfo.Builder packageName(String str) {
            this.packageName = str;
            return this;
        }

        @Override // com.coolapk.market.model.ClickInfo.Builder
        public ClickInfo.Builder targetUrl(String str) {
            this.targetUrl = str;
            return this;
        }

        @Override // com.coolapk.market.model.ClickInfo.Builder
        public ClickInfo.Builder targetExtra(Extra extra) {
            this.targetExtra = extra;
            return this;
        }

        @Override // com.coolapk.market.model.ClickInfo.Builder
        public ClickInfo.Builder targetFlag(int i) {
            this.targetFlag = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.ClickInfo.Builder
        public ClickInfo.Builder uninstallKey(String str) {
            this.uninstallKey = str;
            return this;
        }

        @Override // com.coolapk.market.model.ClickInfo.Builder
        public ClickInfo.Builder downloadKeys(List<String> list) {
            this.downloadKeys = list;
            return this;
        }

        @Override // com.coolapk.market.model.ClickInfo.Builder
        public ClickInfo.Builder clickHandleListener(ClickInfo.ClickHandleListener clickHandleListener2) {
            this.clickHandleListener = clickHandleListener2;
            return this;
        }

        @Override // com.coolapk.market.model.ClickInfo.Builder
        public ClickInfo build() {
            String str = "";
            if (this.targetUrl == null) {
                str = str + " targetUrl";
            }
            if (this.targetFlag == null) {
                str = str + " targetFlag";
            }
            if (this.downloadKeys == null) {
                str = str + " downloadKeys";
            }
            if (str.isEmpty()) {
                return new AutoValue_ClickInfo(this.packageName, this.targetUrl, this.targetExtra, this.targetFlag.intValue(), this.uninstallKey, this.downloadKeys, this.clickHandleListener);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
