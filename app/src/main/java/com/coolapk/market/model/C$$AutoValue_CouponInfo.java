package com.coolapk.market.model;

import com.coolapk.market.model.CouponInfo;
import com.google.gson.annotations.SerializedName;

/* renamed from: com.coolapk.market.model.$$AutoValue_CouponInfo  reason: invalid class name */
abstract class C$$AutoValue_CouponInfo extends CouponInfo {
    private final String adApplink;
    private final String adH5url;
    private final String adText;
    private final String couponId;
    private final int couponType;
    private final long endTime;
    private final boolean isClicked;
    private final long startTime;
    private final String title;

    C$$AutoValue_CouponInfo(String str, String str2, String str3, String str4, int i, long j, long j2, String str5, boolean z) {
        this.adApplink = str;
        this.adH5url = str2;
        this.adText = str3;
        this.couponId = str4;
        this.couponType = i;
        this.startTime = j;
        this.endTime = j2;
        this.title = str5;
        this.isClicked = z;
    }

    @Override // com.coolapk.market.model.CouponInfo
    @SerializedName("ad_applink")
    public String getAdApplink() {
        return this.adApplink;
    }

    @Override // com.coolapk.market.model.CouponInfo
    @SerializedName("ad_h5url")
    public String getAdH5url() {
        return this.adH5url;
    }

    @Override // com.coolapk.market.model.CouponInfo
    @SerializedName("ad_text")
    public String getAdText() {
        return this.adText;
    }

    @Override // com.coolapk.market.model.CouponInfo
    public String getCouponId() {
        return this.couponId;
    }

    @Override // com.coolapk.market.model.CouponInfo
    public int getCouponType() {
        return this.couponType;
    }

    @Override // com.coolapk.market.model.CouponInfo
    @SerializedName("start_time")
    public long getStartTime() {
        return this.startTime;
    }

    @Override // com.coolapk.market.model.CouponInfo
    @SerializedName("end_time")
    public long getEndTime() {
        return this.endTime;
    }

    @Override // com.coolapk.market.model.CouponInfo
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.CouponInfo
    @SerializedName("is_clicked")
    public boolean getIsClicked() {
        return this.isClicked;
    }

    @Override // java.lang.Object
    public String toString() {
        return "CouponInfo{adApplink=" + this.adApplink + ", adH5url=" + this.adH5url + ", adText=" + this.adText + ", couponId=" + this.couponId + ", couponType=" + this.couponType + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", title=" + this.title + ", isClicked=" + this.isClicked + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CouponInfo)) {
            return false;
        }
        CouponInfo couponInfo = (CouponInfo) obj;
        String str2 = this.adApplink;
        if (str2 != null ? str2.equals(couponInfo.getAdApplink()) : couponInfo.getAdApplink() == null) {
            String str3 = this.adH5url;
            if (str3 != null ? str3.equals(couponInfo.getAdH5url()) : couponInfo.getAdH5url() == null) {
                String str4 = this.adText;
                if (str4 != null ? str4.equals(couponInfo.getAdText()) : couponInfo.getAdText() == null) {
                    String str5 = this.couponId;
                    if (str5 != null ? str5.equals(couponInfo.getCouponId()) : couponInfo.getCouponId() == null) {
                        if (this.couponType == couponInfo.getCouponType() && this.startTime == couponInfo.getStartTime() && this.endTime == couponInfo.getEndTime() && ((str = this.title) != null ? str.equals(couponInfo.getTitle()) : couponInfo.getTitle() == null) && this.isClicked == couponInfo.getIsClicked()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.adApplink;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.adH5url;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.adText;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.couponId;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        long j = this.startTime;
        long j2 = this.endTime;
        int i2 = ((int) (((long) (((int) (((long) ((((hashCode3 ^ hashCode4) * 1000003) ^ this.couponType) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003)) ^ (j2 ^ (j2 >>> 32)))) * 1000003;
        String str5 = this.title;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return ((i2 ^ i) * 1000003) ^ (this.isClicked ? 1231 : 1237);
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_CouponInfo$Builder */
    /* compiled from: $$AutoValue_CouponInfo */
    static final class Builder extends CouponInfo.Builder {
        private String adApplink;
        private String adH5url;
        private String adText;
        private String couponId;
        private Integer couponType;
        private Long endTime;
        private Boolean isClicked;
        private Long startTime;
        private String title;

        Builder() {
        }

        Builder(CouponInfo couponInfo) {
            this.adApplink = couponInfo.getAdApplink();
            this.adH5url = couponInfo.getAdH5url();
            this.adText = couponInfo.getAdText();
            this.couponId = couponInfo.getCouponId();
            this.couponType = Integer.valueOf(couponInfo.getCouponType());
            this.startTime = Long.valueOf(couponInfo.getStartTime());
            this.endTime = Long.valueOf(couponInfo.getEndTime());
            this.title = couponInfo.getTitle();
            this.isClicked = Boolean.valueOf(couponInfo.getIsClicked());
        }

        @Override // com.coolapk.market.model.CouponInfo.Builder
        public CouponInfo.Builder setAdApplink(String str) {
            this.adApplink = str;
            return this;
        }

        @Override // com.coolapk.market.model.CouponInfo.Builder
        public CouponInfo.Builder setAdH5url(String str) {
            this.adH5url = str;
            return this;
        }

        @Override // com.coolapk.market.model.CouponInfo.Builder
        public CouponInfo.Builder setAdText(String str) {
            this.adText = str;
            return this;
        }

        @Override // com.coolapk.market.model.CouponInfo.Builder
        public CouponInfo.Builder setCouponId(String str) {
            this.couponId = str;
            return this;
        }

        @Override // com.coolapk.market.model.CouponInfo.Builder
        public CouponInfo.Builder setCouponType(int i) {
            this.couponType = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.CouponInfo.Builder
        public CouponInfo.Builder setStartTime(long j) {
            this.startTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.CouponInfo.Builder
        public CouponInfo.Builder setEndTime(long j) {
            this.endTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.CouponInfo.Builder
        public CouponInfo.Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.CouponInfo.Builder
        public CouponInfo.Builder setIsClicked(boolean z) {
            this.isClicked = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.CouponInfo.Builder
        public CouponInfo build() {
            String str = "";
            if (this.couponType == null) {
                str = str + " couponType";
            }
            if (this.startTime == null) {
                str = str + " startTime";
            }
            if (this.endTime == null) {
                str = str + " endTime";
            }
            if (this.isClicked == null) {
                str = str + " isClicked";
            }
            if (str.isEmpty()) {
                return new AutoValue_CouponInfo(this.adApplink, this.adH5url, this.adText, this.couponId, this.couponType.intValue(), this.startTime.longValue(), this.endTime.longValue(), this.title, this.isClicked.booleanValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
