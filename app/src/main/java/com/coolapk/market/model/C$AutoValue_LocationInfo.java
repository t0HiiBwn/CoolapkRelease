package com.coolapk.market.model;

import com.coolapk.market.model.LocationInfo;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$AutoValue_LocationInfo  reason: invalid class name */
abstract class C$AutoValue_LocationInfo extends LocationInfo {
    private final String adCode;
    private final String address;
    private final String aoiName;
    private final String businessArea;
    private final String city;
    private final String cityCode;
    private final String country;
    private final Long dateline;
    private final String description;
    private final String district;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityType;
    private final String extraData;
    private final String feedType;
    private final String id;
    private final boolean isChecked;
    private final boolean isHideLocation;
    private final Long lastUpdate;
    private final Double latitude;
    private final String logo;
    private final String longAddress;
    private final Double longitude;
    private final String pic;
    private final String poiName;
    private final String province;
    private final String road;
    private final String snippet;
    private final String street;
    private final String streetNum;
    private final String subTitle;
    private final String title;
    private final String url;

    C$AutoValue_LocationInfo(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Long l2, Long l3, String str12, String str13, Double d, Double d2, String str14, String str15, String str16, boolean z, boolean z2, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27) {
        Objects.requireNonNull(str, "Null entityType");
        this.entityType = str;
        this.entityTemplate = str2;
        this.entityId = str3;
        this.entityFixed = num;
        this.title = str4;
        this.url = str5;
        this.description = str6;
        this.pic = str7;
        this.logo = str8;
        this.subTitle = str9;
        this.id = str10;
        this.extraData = str11;
        this.dateline = l2;
        this.lastUpdate = l3;
        this.feedType = str12;
        Objects.requireNonNull(str13, "Null address");
        this.address = str13;
        Objects.requireNonNull(d, "Null latitude");
        this.latitude = d;
        Objects.requireNonNull(d2, "Null longitude");
        this.longitude = d2;
        this.businessArea = str14;
        this.snippet = str15;
        this.longAddress = str16;
        this.isChecked = z;
        this.isHideLocation = z2;
        this.city = str17;
        this.country = str18;
        this.province = str19;
        this.district = str20;
        this.cityCode = str21;
        this.adCode = str22;
        this.road = str23;
        this.poiName = str24;
        this.street = str25;
        this.streetNum = str26;
        this.aoiName = str27;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityType")
    public String getEntityType() {
        return this.entityType;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityTemplate")
    public String getEntityTemplate() {
        return this.entityTemplate;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityId")
    public String getEntityId() {
        return this.entityId;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityFixed")
    public Integer getEntityFixed() {
        return this.entityFixed;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("title")
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("url")
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("description")
    public String getDescription() {
        return this.description;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("pic")
    public String getPic() {
        return this.pic;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("logo")
    public String getLogo() {
        return this.logo;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("subTitle")
    public String getSubTitle() {
        return this.subTitle;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("id")
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("extraData")
    public String getExtraData() {
        return this.extraData;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("dateline")
    public Long getDateline() {
        return this.dateline;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("lastupdate")
    public Long getLastUpdate() {
        return this.lastUpdate;
    }

    @Override // com.coolapk.market.model.LocationInfo
    public String getFeedType() {
        return this.feedType;
    }

    @Override // com.coolapk.market.model.LocationInfo
    public String getAddress() {
        return this.address;
    }

    @Override // com.coolapk.market.model.LocationInfo
    public Double getLatitude() {
        return this.latitude;
    }

    @Override // com.coolapk.market.model.LocationInfo
    public Double getLongitude() {
        return this.longitude;
    }

    @Override // com.coolapk.market.model.LocationInfo
    public String getBusinessArea() {
        return this.businessArea;
    }

    @Override // com.coolapk.market.model.LocationInfo
    public String getSnippet() {
        return this.snippet;
    }

    @Override // com.coolapk.market.model.LocationInfo
    public String getLongAddress() {
        return this.longAddress;
    }

    @Override // com.coolapk.market.model.LocationInfo
    public boolean getIsChecked() {
        return this.isChecked;
    }

    @Override // com.coolapk.market.model.LocationInfo
    public boolean getIsHideLocation() {
        return this.isHideLocation;
    }

    @Override // com.coolapk.market.model.LocationInfo
    public String getCity() {
        return this.city;
    }

    @Override // com.coolapk.market.model.LocationInfo
    public String getCountry() {
        return this.country;
    }

    @Override // com.coolapk.market.model.LocationInfo
    public String getProvince() {
        return this.province;
    }

    @Override // com.coolapk.market.model.LocationInfo
    public String getDistrict() {
        return this.district;
    }

    @Override // com.coolapk.market.model.LocationInfo
    public String getCityCode() {
        return this.cityCode;
    }

    @Override // com.coolapk.market.model.LocationInfo
    public String getAdCode() {
        return this.adCode;
    }

    @Override // com.coolapk.market.model.LocationInfo
    public String getRoad() {
        return this.road;
    }

    @Override // com.coolapk.market.model.LocationInfo
    public String getPoiName() {
        return this.poiName;
    }

    @Override // com.coolapk.market.model.LocationInfo
    public String getStreet() {
        return this.street;
    }

    @Override // com.coolapk.market.model.LocationInfo
    public String getStreetNum() {
        return this.streetNum;
    }

    @Override // com.coolapk.market.model.LocationInfo
    public String getAoiName() {
        return this.aoiName;
    }

    @Override // java.lang.Object
    public String toString() {
        return "LocationInfo{entityType=" + this.entityType + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", feedType=" + this.feedType + ", address=" + this.address + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", businessArea=" + this.businessArea + ", snippet=" + this.snippet + ", longAddress=" + this.longAddress + ", isChecked=" + this.isChecked + ", isHideLocation=" + this.isHideLocation + ", city=" + this.city + ", country=" + this.country + ", province=" + this.province + ", district=" + this.district + ", cityCode=" + this.cityCode + ", adCode=" + this.adCode + ", road=" + this.road + ", poiName=" + this.poiName + ", street=" + this.street + ", streetNum=" + this.streetNum + ", aoiName=" + this.aoiName + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        Integer num;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        Long l2;
        Long l3;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocationInfo)) {
            return false;
        }
        LocationInfo locationInfo = (LocationInfo) obj;
        if (this.entityType.equals(locationInfo.getEntityType()) && ((str = this.entityTemplate) != null ? str.equals(locationInfo.getEntityTemplate()) : locationInfo.getEntityTemplate() == null) && ((str2 = this.entityId) != null ? str2.equals(locationInfo.getEntityId()) : locationInfo.getEntityId() == null) && ((num = this.entityFixed) != null ? num.equals(locationInfo.getEntityFixed()) : locationInfo.getEntityFixed() == null) && ((str3 = this.title) != null ? str3.equals(locationInfo.getTitle()) : locationInfo.getTitle() == null) && ((str4 = this.url) != null ? str4.equals(locationInfo.getUrl()) : locationInfo.getUrl() == null) && ((str5 = this.description) != null ? str5.equals(locationInfo.getDescription()) : locationInfo.getDescription() == null) && ((str6 = this.pic) != null ? str6.equals(locationInfo.getPic()) : locationInfo.getPic() == null) && ((str7 = this.logo) != null ? str7.equals(locationInfo.getLogo()) : locationInfo.getLogo() == null) && ((str8 = this.subTitle) != null ? str8.equals(locationInfo.getSubTitle()) : locationInfo.getSubTitle() == null) && ((str9 = this.id) != null ? str9.equals(locationInfo.getId()) : locationInfo.getId() == null) && ((str10 = this.extraData) != null ? str10.equals(locationInfo.getExtraData()) : locationInfo.getExtraData() == null) && ((l2 = this.dateline) != null ? l2.equals(locationInfo.getDateline()) : locationInfo.getDateline() == null) && ((l3 = this.lastUpdate) != null ? l3.equals(locationInfo.getLastUpdate()) : locationInfo.getLastUpdate() == null) && ((str11 = this.feedType) != null ? str11.equals(locationInfo.getFeedType()) : locationInfo.getFeedType() == null) && this.address.equals(locationInfo.getAddress()) && this.latitude.equals(locationInfo.getLatitude()) && this.longitude.equals(locationInfo.getLongitude()) && ((str12 = this.businessArea) != null ? str12.equals(locationInfo.getBusinessArea()) : locationInfo.getBusinessArea() == null) && ((str13 = this.snippet) != null ? str13.equals(locationInfo.getSnippet()) : locationInfo.getSnippet() == null) && ((str14 = this.longAddress) != null ? str14.equals(locationInfo.getLongAddress()) : locationInfo.getLongAddress() == null) && this.isChecked == locationInfo.getIsChecked() && this.isHideLocation == locationInfo.getIsHideLocation() && ((str15 = this.city) != null ? str15.equals(locationInfo.getCity()) : locationInfo.getCity() == null) && ((str16 = this.country) != null ? str16.equals(locationInfo.getCountry()) : locationInfo.getCountry() == null) && ((str17 = this.province) != null ? str17.equals(locationInfo.getProvince()) : locationInfo.getProvince() == null) && ((str18 = this.district) != null ? str18.equals(locationInfo.getDistrict()) : locationInfo.getDistrict() == null) && ((str19 = this.cityCode) != null ? str19.equals(locationInfo.getCityCode()) : locationInfo.getCityCode() == null) && ((str20 = this.adCode) != null ? str20.equals(locationInfo.getAdCode()) : locationInfo.getAdCode() == null) && ((str21 = this.road) != null ? str21.equals(locationInfo.getRoad()) : locationInfo.getRoad() == null) && ((str22 = this.poiName) != null ? str22.equals(locationInfo.getPoiName()) : locationInfo.getPoiName() == null) && ((str23 = this.street) != null ? str23.equals(locationInfo.getStreet()) : locationInfo.getStreet() == null) && ((str24 = this.streetNum) != null ? str24.equals(locationInfo.getStreetNum()) : locationInfo.getStreetNum() == null)) {
            String str25 = this.aoiName;
            if (str25 == null) {
                if (locationInfo.getAoiName() == null) {
                    return true;
                }
            } else if (str25.equals(locationInfo.getAoiName())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int hashCode = (this.entityType.hashCode() ^ 1000003) * 1000003;
        String str = this.entityTemplate;
        int i = 0;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.entityId;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        Integer num = this.entityFixed;
        int hashCode4 = (hashCode3 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str3 = this.title;
        int hashCode5 = (hashCode4 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.url;
        int hashCode6 = (hashCode5 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.description;
        int hashCode7 = (hashCode6 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.pic;
        int hashCode8 = (hashCode7 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.logo;
        int hashCode9 = (hashCode8 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.subTitle;
        int hashCode10 = (hashCode9 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.id;
        int hashCode11 = (hashCode10 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.extraData;
        int hashCode12 = (hashCode11 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        Long l2 = this.dateline;
        int hashCode13 = (hashCode12 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        Long l3 = this.lastUpdate;
        int hashCode14 = (hashCode13 ^ (l3 == null ? 0 : l3.hashCode())) * 1000003;
        String str11 = this.feedType;
        int hashCode15 = (((((((hashCode14 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003) ^ this.address.hashCode()) * 1000003) ^ this.latitude.hashCode()) * 1000003) ^ this.longitude.hashCode()) * 1000003;
        String str12 = this.businessArea;
        int hashCode16 = (hashCode15 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.snippet;
        int hashCode17 = (hashCode16 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.longAddress;
        int i2 = 1231;
        int hashCode18 = (((hashCode17 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003) ^ (this.isChecked ? 1231 : 1237)) * 1000003;
        if (!this.isHideLocation) {
            i2 = 1237;
        }
        int i3 = (hashCode18 ^ i2) * 1000003;
        String str15 = this.city;
        int hashCode19 = (i3 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
        String str16 = this.country;
        int hashCode20 = (hashCode19 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003;
        String str17 = this.province;
        int hashCode21 = (hashCode20 ^ (str17 == null ? 0 : str17.hashCode())) * 1000003;
        String str18 = this.district;
        int hashCode22 = (hashCode21 ^ (str18 == null ? 0 : str18.hashCode())) * 1000003;
        String str19 = this.cityCode;
        int hashCode23 = (hashCode22 ^ (str19 == null ? 0 : str19.hashCode())) * 1000003;
        String str20 = this.adCode;
        int hashCode24 = (hashCode23 ^ (str20 == null ? 0 : str20.hashCode())) * 1000003;
        String str21 = this.road;
        int hashCode25 = (hashCode24 ^ (str21 == null ? 0 : str21.hashCode())) * 1000003;
        String str22 = this.poiName;
        int hashCode26 = (hashCode25 ^ (str22 == null ? 0 : str22.hashCode())) * 1000003;
        String str23 = this.street;
        int hashCode27 = (hashCode26 ^ (str23 == null ? 0 : str23.hashCode())) * 1000003;
        String str24 = this.streetNum;
        int hashCode28 = (hashCode27 ^ (str24 == null ? 0 : str24.hashCode())) * 1000003;
        String str25 = this.aoiName;
        if (str25 != null) {
            i = str25.hashCode();
        }
        return hashCode28 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_LocationInfo$Builder */
    static final class Builder extends LocationInfo.Builder {
        private String adCode;
        private String address;
        private String aoiName;
        private String businessArea;
        private String city;
        private String cityCode;
        private String country;
        private Long dateline;
        private String description;
        private String district;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
        private String entityType;
        private String extraData;
        private String feedType;
        private String id;
        private Boolean isChecked;
        private Boolean isHideLocation;
        private Long lastUpdate;
        private Double latitude;
        private String logo;
        private String longAddress;
        private Double longitude;
        private String pic;
        private String poiName;
        private String province;
        private String road;
        private String snippet;
        private String street;
        private String streetNum;
        private String subTitle;
        private String title;
        private String url;

        Builder() {
        }

        Builder(LocationInfo locationInfo) {
            this.entityType = locationInfo.getEntityType();
            this.entityTemplate = locationInfo.getEntityTemplate();
            this.entityId = locationInfo.getEntityId();
            this.entityFixed = locationInfo.getEntityFixed();
            this.title = locationInfo.getTitle();
            this.url = locationInfo.getUrl();
            this.description = locationInfo.getDescription();
            this.pic = locationInfo.getPic();
            this.logo = locationInfo.getLogo();
            this.subTitle = locationInfo.getSubTitle();
            this.id = locationInfo.getId();
            this.extraData = locationInfo.getExtraData();
            this.dateline = locationInfo.getDateline();
            this.lastUpdate = locationInfo.getLastUpdate();
            this.feedType = locationInfo.getFeedType();
            this.address = locationInfo.getAddress();
            this.latitude = locationInfo.getLatitude();
            this.longitude = locationInfo.getLongitude();
            this.businessArea = locationInfo.getBusinessArea();
            this.snippet = locationInfo.getSnippet();
            this.longAddress = locationInfo.getLongAddress();
            this.isChecked = Boolean.valueOf(locationInfo.getIsChecked());
            this.isHideLocation = Boolean.valueOf(locationInfo.getIsHideLocation());
            this.city = locationInfo.getCity();
            this.country = locationInfo.getCountry();
            this.province = locationInfo.getProvince();
            this.district = locationInfo.getDistrict();
            this.cityCode = locationInfo.getCityCode();
            this.adCode = locationInfo.getAdCode();
            this.road = locationInfo.getRoad();
            this.poiName = locationInfo.getPoiName();
            this.street = locationInfo.getStreet();
            this.streetNum = locationInfo.getStreetNum();
            this.aoiName = locationInfo.getAoiName();
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setEntityType(String str) {
            this.entityType = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setEntityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setEntityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setEntityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setPic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setLogo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setSubTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setId(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setDateline(Long l2) {
            this.dateline = l2;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setLastUpdate(Long l2) {
            this.lastUpdate = l2;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setFeedType(String str) {
            this.feedType = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setAddress(String str) {
            this.address = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setLatitude(Double d) {
            this.latitude = d;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setLongitude(Double d) {
            this.longitude = d;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setBusinessArea(String str) {
            this.businessArea = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setSnippet(String str) {
            this.snippet = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setLongAddress(String str) {
            this.longAddress = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setIsChecked(boolean z) {
            this.isChecked = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setIsHideLocation(boolean z) {
            this.isHideLocation = Boolean.valueOf(z);
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setCity(String str) {
            this.city = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setCountry(String str) {
            this.country = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setProvince(String str) {
            this.province = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setDistrict(String str) {
            this.district = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setCityCode(String str) {
            this.cityCode = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setAdCode(String str) {
            this.adCode = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setRoad(String str) {
            this.road = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setPoiName(String str) {
            this.poiName = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setStreet(String str) {
            this.street = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setStreetNum(String str) {
            this.streetNum = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo.Builder setAoiName(String str) {
            this.aoiName = str;
            return this;
        }

        @Override // com.coolapk.market.model.LocationInfo.Builder
        public LocationInfo build() {
            String str = "";
            if (this.entityType == null) {
                str = str + " entityType";
            }
            if (this.address == null) {
                str = str + " address";
            }
            if (this.latitude == null) {
                str = str + " latitude";
            }
            if (this.longitude == null) {
                str = str + " longitude";
            }
            if (this.isChecked == null) {
                str = str + " isChecked";
            }
            if (this.isHideLocation == null) {
                str = str + " isHideLocation";
            }
            if (str.isEmpty()) {
                return new AutoValue_LocationInfo(this.entityType, this.entityTemplate, this.entityId, this.entityFixed, this.title, this.url, this.description, this.pic, this.logo, this.subTitle, this.id, this.extraData, this.dateline, this.lastUpdate, this.feedType, this.address, this.latitude, this.longitude, this.businessArea, this.snippet, this.longAddress, this.isChecked.booleanValue(), this.isHideLocation.booleanValue(), this.city, this.country, this.province, this.district, this.cityCode, this.adCode, this.road, this.poiName, this.street, this.streetNum, this.aoiName);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
