package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_LocationInfo;

public abstract class LocationInfo implements Entity {

    public static abstract class Builder {
        public abstract LocationInfo build();

        public abstract Builder setAdCode(String str);

        public abstract Builder setAddress(String str);

        public abstract Builder setAoiName(String str);

        public abstract Builder setBusinessArea(String str);

        public abstract Builder setCity(String str);

        public abstract Builder setCityCode(String str);

        public abstract Builder setCountry(String str);

        public abstract Builder setDateline(Long l);

        public abstract Builder setDescription(String str);

        public abstract Builder setDistrict(String str);

        public abstract Builder setEntityFixed(Integer num);

        public abstract Builder setEntityId(String str);

        public abstract Builder setEntityTemplate(String str);

        public abstract Builder setEntityType(String str);

        public abstract Builder setExtraData(String str);

        public abstract Builder setFeedType(String str);

        public abstract Builder setId(String str);

        public abstract Builder setIsChecked(boolean z);

        public abstract Builder setIsHideLocation(boolean z);

        public abstract Builder setLastUpdate(Long l);

        public abstract Builder setLatitude(Double d);

        public abstract Builder setLogo(String str);

        public abstract Builder setLongAddress(String str);

        public abstract Builder setLongitude(Double d);

        public abstract Builder setPic(String str);

        public abstract Builder setPoiName(String str);

        public abstract Builder setProvince(String str);

        public abstract Builder setRoad(String str);

        public abstract Builder setSnippet(String str);

        public abstract Builder setStreet(String str);

        public abstract Builder setStreetNum(String str);

        public abstract Builder setSubTitle(String str);

        public abstract Builder setTitle(String str);

        public abstract Builder setUrl(String str);
    }

    public abstract String getAdCode();

    public abstract String getAddress();

    public abstract String getAoiName();

    public abstract String getBusinessArea();

    public abstract String getCity();

    public abstract String getCityCode();

    public abstract String getCountry();

    public abstract String getDistrict();

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return 0;
    }

    @Override // com.coolapk.market.model.Entity
    public String getEntityTypeName() {
        return "location";
    }

    public abstract String getFeedType();

    public abstract boolean getIsChecked();

    public abstract boolean getIsHideLocation();

    public abstract Double getLatitude();

    public abstract String getLongAddress();

    public abstract Double getLongitude();

    public abstract String getPoiName();

    public abstract String getProvince();

    public abstract String getRoad();

    public abstract String getSnippet();

    public abstract String getStreet();

    public abstract String getStreetNum();

    public static Builder newBuilder() {
        return new C$AutoValue_LocationInfo.Builder();
    }

    public static Builder newBuilder(LocationInfo locationInfo) {
        return new C$AutoValue_LocationInfo.Builder(locationInfo);
    }
}
