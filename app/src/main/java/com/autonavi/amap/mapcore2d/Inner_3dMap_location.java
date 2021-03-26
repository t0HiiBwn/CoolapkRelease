package com.autonavi.amap.mapcore2d;

import android.location.Location;
import com.amap.api.mapcore2d.gu;
import com.amap.api.mapcore2d.gy;
import org.json.JSONObject;

public class Inner_3dMap_location extends Location implements Cloneable {
    public static final int ERROR_CODE_FAILURE_AUTH = 7;
    public static final int ERROR_CODE_FAILURE_CELL = 11;
    public static final int ERROR_CODE_FAILURE_CONNECTION = 4;
    public static final int ERROR_CODE_FAILURE_INIT = 9;
    public static final int ERROR_CODE_FAILURE_LOCATION = 6;
    public static final int ERROR_CODE_FAILURE_LOCATION_PARAMETER = 3;
    public static final int ERROR_CODE_FAILURE_LOCATION_PERMISSION = 12;
    public static final int ERROR_CODE_FAILURE_NOENOUGHSATELLITES = 14;
    public static final int ERROR_CODE_FAILURE_NOWIFIANDAP = 13;
    public static final int ERROR_CODE_FAILURE_PARSER = 5;
    public static final int ERROR_CODE_FAILURE_SIMULATION_LOCATION = 15;
    public static final int ERROR_CODE_FAILURE_WIFI_INFO = 2;
    public static final int ERROR_CODE_INVALID_PARAMETER = 1;
    public static final int ERROR_CODE_SERVICE_FAIL = 10;
    public static final int ERROR_CODE_UNKNOWN = 8;
    public static final int GPS_ACCURACY_BAD = 0;
    public static final int GPS_ACCURACY_GOOD = 1;
    public static final int GPS_ACCURACY_UNKNOWN = -1;
    public static final int LOCATION_SUCCESS = 0;
    public static final int LOCATION_TYPE_AMAP = 7;
    public static final int LOCATION_TYPE_CELL = 6;
    public static final int LOCATION_TYPE_FAST = 3;
    public static final int LOCATION_TYPE_FIX_CACHE = 4;
    public static final int LOCATION_TYPE_GPS = 1;
    public static final int LOCATION_TYPE_OFFLINE = 8;
    public static final int LOCATION_TYPE_SAME_REQ = 2;
    public static final int LOCATION_TYPE_WIFI = 5;
    private String adCode = "";
    private String address = "";
    private String aoiName = "";
    protected String buildingId = "";
    private String city = "";
    private String cityCode = "";
    private String country = "";
    protected String desc = "";
    private String district = "";
    private int errorCode = 0;
    private String errorInfo = "success";
    protected String floor = "";
    private boolean isOffset = true;
    private double latitude = 0.0d;
    private String locationDetail = "";
    private int locationType = 0;
    private double longitude = 0.0d;
    private String number = "";
    private String poiName = "";
    private String province = "";
    private String road = "";
    private int satellites = 0;
    private int signalIntensity = -1;
    private String street = "";

    public Inner_3dMap_location(Location location) {
        super(location);
        this.latitude = location.getLatitude();
        this.longitude = location.getLongitude();
    }

    public Inner_3dMap_location(String str) {
        super(str);
    }

    @Override // java.lang.Object
    public Inner_3dMap_location clone() {
        try {
            super.clone();
        } catch (Throwable unused) {
        }
        Inner_3dMap_location inner_3dMap_location = new Inner_3dMap_location(this);
        inner_3dMap_location.setProvince(this.province);
        inner_3dMap_location.setCity(this.city);
        inner_3dMap_location.setDistrict(this.district);
        inner_3dMap_location.setCityCode(this.cityCode);
        inner_3dMap_location.setAdCode(this.adCode);
        inner_3dMap_location.setAddress(this.address);
        inner_3dMap_location.setPoiName(this.poiName);
        inner_3dMap_location.setCountry(this.country);
        inner_3dMap_location.setRoad(this.road);
        inner_3dMap_location.setStreet(this.street);
        inner_3dMap_location.setNumber(this.number);
        inner_3dMap_location.setOffset(this.isOffset);
        inner_3dMap_location.setErrorCode(this.errorCode);
        inner_3dMap_location.setErrorInfo(this.errorInfo);
        inner_3dMap_location.setLocationDetail(this.locationDetail);
        inner_3dMap_location.setLocationType(this.locationType);
        inner_3dMap_location.setLatitude(this.latitude);
        inner_3dMap_location.setLongitude(this.longitude);
        inner_3dMap_location.setSatellites(this.satellites);
        inner_3dMap_location.setAoiName(this.aoiName);
        inner_3dMap_location.setBuildingId(this.buildingId);
        inner_3dMap_location.setFloor(this.floor);
        inner_3dMap_location.setGpsAccuracyStatus(this.signalIntensity);
        inner_3dMap_location.setExtras(getExtras());
        return inner_3dMap_location;
    }

    @Override // android.location.Location
    public float getAccuracy() {
        return super.getAccuracy();
    }

    public String getAdCode() {
        return this.adCode;
    }

    public String getAddress() {
        return this.address;
    }

    @Override // android.location.Location
    public double getAltitude() {
        return super.getAltitude();
    }

    public String getAoiName() {
        return this.aoiName;
    }

    @Override // android.location.Location
    public float getBearing() {
        return super.getBearing();
    }

    public String getBuildingId() {
        return this.buildingId;
    }

    public String getCity() {
        return this.city;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public String getCountry() {
        return this.country;
    }

    public String getDistrict() {
        return this.district;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.errorInfo);
        if (this.errorCode != 0) {
            sb.append(" 请到http://lbs.amap.com/api/android-location-sdk/guide/utilities/errorcode/查看错误码说明");
            sb.append(",错误详细信息:" + this.locationDetail);
        }
        String sb2 = sb.toString();
        this.errorInfo = sb2;
        return sb2;
    }

    public String getFloor() {
        return this.floor;
    }

    public int getGpsAccuracyStatus() {
        return this.signalIntensity;
    }

    @Override // android.location.Location
    public double getLatitude() {
        return this.latitude;
    }

    public String getLocationDetail() {
        return this.locationDetail;
    }

    public int getLocationType() {
        return this.locationType;
    }

    @Override // android.location.Location
    public double getLongitude() {
        return this.longitude;
    }

    public String getPoiName() {
        return this.poiName;
    }

    @Override // android.location.Location
    public String getProvider() {
        return super.getProvider();
    }

    public String getProvince() {
        return this.province;
    }

    public String getRoad() {
        return this.road;
    }

    public int getSatellites() {
        return this.satellites;
    }

    @Override // android.location.Location
    public float getSpeed() {
        return super.getSpeed();
    }

    public String getStreet() {
        return this.street;
    }

    public String getStreetNum() {
        return this.number;
    }

    public boolean isOffset() {
        return this.isOffset;
    }

    public void setAdCode(String str) {
        this.adCode = str;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAoiName(String str) {
        this.aoiName = str;
    }

    public void setBuildingId(String str) {
        this.buildingId = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCityCode(String str) {
        this.cityCode = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setDistrict(String str) {
        this.district = str;
    }

    public void setErrorCode(int i) {
        if (this.errorCode == 0) {
            this.errorInfo = gy.b(i);
            this.errorCode = i;
        }
    }

    public void setErrorInfo(String str) {
        this.errorInfo = str;
    }

    public void setFloor(String str) {
        this.floor = str;
    }

    public void setGpsAccuracyStatus(int i) {
        this.signalIntensity = i;
    }

    @Override // android.location.Location
    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLocationDetail(String str) {
        this.locationDetail = str;
    }

    public void setLocationType(int i) {
        this.locationType = i;
    }

    @Override // android.location.Location
    public void setLongitude(double d) {
        this.longitude = d;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public void setOffset(boolean z) {
        this.isOffset = z;
    }

    public void setPoiName(String str) {
        this.poiName = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setRoad(String str) {
        this.road = str;
    }

    public void setSatellites(int i) {
        this.satellites = i;
    }

    public void setStreet(String str) {
        this.street = str;
    }

    protected JSONObject toJson(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (i == 1) {
                try {
                    jSONObject.put("altitude", getAltitude());
                    jSONObject.put("speed", (double) getSpeed());
                    jSONObject.put("bearing", (double) getBearing());
                } catch (Throwable unused) {
                }
                jSONObject.put("citycode", this.cityCode);
                jSONObject.put("desc", this.desc);
                jSONObject.put("adcode", this.adCode);
                jSONObject.put("country", this.country);
                jSONObject.put("province", this.province);
                jSONObject.put("city", this.city);
                jSONObject.put("district", this.district);
                jSONObject.put("road", this.road);
                jSONObject.put("street", this.street);
                jSONObject.put("number", this.number);
                jSONObject.put("poiname", this.poiName);
                jSONObject.put("errorCode", this.errorCode);
                jSONObject.put("errorInfo", this.errorInfo);
                jSONObject.put("locationType", this.locationType);
                jSONObject.put("locationDetail", this.locationDetail);
                jSONObject.put("aoiname", this.aoiName);
                jSONObject.put("address", this.address);
                jSONObject.put("poiid", this.buildingId);
                jSONObject.put("floor", this.floor);
            } else if (i != 2) {
                if (i != 3) {
                    return jSONObject;
                }
                jSONObject.put("provider", getProvider());
                jSONObject.put("lon", getLongitude());
                jSONObject.put("lat", getLatitude());
                jSONObject.put("accuracy", (double) getAccuracy());
                jSONObject.put("isOffset", this.isOffset);
                return jSONObject;
            }
            jSONObject.put("time", getTime());
            jSONObject.put("provider", getProvider());
            jSONObject.put("lon", getLongitude());
            jSONObject.put("lat", getLatitude());
            jSONObject.put("accuracy", (double) getAccuracy());
            jSONObject.put("isOffset", this.isOffset);
            return jSONObject;
        } catch (Throwable th) {
            gu.a(th, "AmapLoc", "toStr");
            return null;
        }
    }

    public String toStr() {
        return toStr(1);
    }

    public String toStr(int i) {
        JSONObject jSONObject;
        try {
            jSONObject = toJson(i);
        } catch (Throwable th) {
            gu.a(th, "AMapLocation", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    @Override // android.location.Location, java.lang.Object
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append("latitude=" + this.latitude + "#");
            stringBuffer.append("longitude=" + this.longitude + "#");
            stringBuffer.append("province=" + this.province + "#");
            stringBuffer.append("city=" + this.city + "#");
            stringBuffer.append("district=" + this.district + "#");
            stringBuffer.append("cityCode=" + this.cityCode + "#");
            stringBuffer.append("adCode=" + this.adCode + "#");
            stringBuffer.append("address=" + this.address + "#");
            stringBuffer.append("country=" + this.country + "#");
            stringBuffer.append("road=" + this.road + "#");
            stringBuffer.append("poiName=" + this.poiName + "#");
            stringBuffer.append("street=" + this.street + "#");
            stringBuffer.append("streetNum=" + this.number + "#");
            stringBuffer.append("aoiName=" + this.aoiName + "#");
            stringBuffer.append("poiid=" + this.buildingId + "#");
            stringBuffer.append("floor=" + this.floor + "#");
            stringBuffer.append("errorCode=" + this.errorCode + "#");
            stringBuffer.append("errorInfo=" + this.errorInfo + "#");
            stringBuffer.append("locationDetail=" + this.locationDetail + "#");
            StringBuilder sb = new StringBuilder("locationType=");
            sb.append(this.locationType);
            stringBuffer.append(sb.toString());
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }
}
