package com.loc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.loc.t;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: CoreUtil */
public final class ej {
    static String a = "http://apilocate.amap.com/mobile/binary";
    static String b = "http://dualstack.apilocate.amap.com/mobile/binary";
    static String c = "";
    static String d = "11G;11K;13J;13S;15O;15U;17J;17Y";
    public static String e = null;
    public static String f = null;
    public static int g = 30000;
    public static String h = null;
    public static String i = null;
    static String j;
    static HashMap<String, String> k;
    static boolean l = false;
    static boolean m = false;
    private static final String[] n = {"com.amap.api.location", "com.loc", "com.amap.api.fence"};
    private static t o = null;
    private static boolean p = false;
    private static boolean q = false;

    public static Bundle a(AMapLocationClientOption aMapLocationClientOption) {
        Bundle bundle = new Bundle();
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        try {
            bundle.putParcelable("opt", aMapLocationClientOption);
        } catch (Throwable th) {
            a(th, "CoreUtil", "getOptionBundle");
        }
        return bundle;
    }

    public static AMapLocation a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 == null) {
            return aMapLocation;
        }
        try {
            aMapLocation.setCountry(aMapLocation2.getCountry());
            aMapLocation.setRoad(aMapLocation2.getRoad());
            aMapLocation.setPoiName(aMapLocation2.getPoiName());
            aMapLocation.setStreet(aMapLocation2.getStreet());
            aMapLocation.setNumber(aMapLocation2.getStreetNum());
            String cityCode = aMapLocation2.getCityCode();
            String adCode = aMapLocation2.getAdCode();
            aMapLocation.setCityCode(cityCode);
            aMapLocation.setAdCode(adCode);
            aMapLocation.setCity(aMapLocation2.getCity());
            aMapLocation.setDistrict(aMapLocation2.getDistrict());
            aMapLocation.setProvince(aMapLocation2.getProvince());
            aMapLocation.setAoiName(aMapLocation2.getAoiName());
            aMapLocation.setAddress(aMapLocation2.getAddress());
            aMapLocation.setDescription(aMapLocation2.getDescription());
            if (aMapLocation.getExtras() != null) {
                aMapLocation.getExtras().putString("citycode", aMapLocation2.getCityCode());
                aMapLocation.getExtras().putString("desc", aMapLocation2.getExtras().getString("desc"));
                aMapLocation.getExtras().putString("adcode", aMapLocation2.getAdCode());
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("citycode", aMapLocation2.getCityCode());
                bundle.putString("desc", aMapLocation2.getExtras().getString("desc"));
                bundle.putString("adcode", aMapLocation2.getAdCode());
                aMapLocation.setExtras(bundle);
            }
        } catch (Throwable unused) {
        }
        return aMapLocation;
    }

    public static AMapLocationClientOption a(Bundle bundle) {
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        if (bundle == null) {
            return aMapLocationClientOption;
        }
        try {
            bundle.setClassLoader(AMapLocationClientOption.class.getClassLoader());
            return (AMapLocationClientOption) bundle.getParcelable("opt");
        } catch (Throwable th) {
            a(th, "CoreUtil", "getOptionFromBundle");
            return aMapLocationClientOption;
        }
    }

    public static String a() {
        return a;
    }

    public static void a(Context context) {
        try {
            if (u.b(context)) {
                a = "http://abroad.apilocate.amap.com/mobile/binary";
                return;
            }
            try {
                if (k == null) {
                    k = new HashMap<>(16);
                }
                k.clear();
                k.put("fe643c382e5c3b3962141f1a2e815a78", "FB923EE67A8B4032DAA517DD8CD7A26FF7C25B0C3663F92A0B61251C4FFFA858DF169D61321C3E7919CB67DF8EFEC827");
                k.put("9a571aa113ad987d626c0457828962e6", "D2FF99A88BEB04683D89470D4FA72B1749DA456AB0D0F1A476477CE5A6874F53A9106423D905F9D808C0FCE8E7F1E04AC642F01FE41D0C7D933971F45CBA72B7");
                k.put("668319f11506def6208d6afe320dfd52", "53E53D46011A6BBAEA4FAE5442E659E0577CDD336F930C28635C322FB3F51C3C63F7FBAC9EAE448DFA2E5E5D716C4807");
            } catch (Throwable th) {
                a(th, "CoreUtil", "initUrlHash");
            }
            String a2 = dy.a(k.f(context));
            j = a2;
            if (a2 != null) {
                try {
                    if (a2.length() != 0) {
                        HashMap<String, String> hashMap = k;
                        if (hashMap != null && hashMap.containsKey(a2)) {
                            String str = k.get(a2);
                            String str2 = null;
                            if (str != null && str.length() > 0) {
                                str2 = new String(dy.b(a(str), a2), "utf-8");
                            }
                            if (str2 != null && str2.length() > 0 && str2.contains("http:")) {
                                c = str2;
                                a = str2;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    a(th2, "CoreUtil", "checkUrl");
                }
            }
        } catch (Throwable th3) {
            a(th3, "CoreUtil", "checkUrl");
        }
    }

    public static void a(AMapLocation aMapLocation, JSONObject jSONObject) {
        String str;
        if (jSONObject != null && aMapLocation != null) {
            try {
                double optDouble = jSONObject.optDouble("lat", aMapLocation.getLatitude());
                double optDouble2 = jSONObject.optDouble("lon", aMapLocation.getLongitude());
                aMapLocation.setProvider(jSONObject.optString("provider", aMapLocation.getProvider()));
                aMapLocation.setLatitude(optDouble);
                aMapLocation.setLongitude(optDouble2);
                aMapLocation.setAltitude(jSONObject.optDouble("altitude", aMapLocation.getAltitude()));
                try {
                    String optString = jSONObject.optString("accuracy");
                    if (!TextUtils.isEmpty(optString)) {
                        aMapLocation.setAccuracy(Float.parseFloat(optString));
                    }
                } catch (Throwable unused) {
                }
                try {
                    String optString2 = jSONObject.optString("speed");
                    if (!TextUtils.isEmpty(optString2)) {
                        aMapLocation.setSpeed(Float.parseFloat(optString2));
                    }
                } catch (Throwable unused2) {
                }
                try {
                    String optString3 = jSONObject.optString("bearing");
                    if (!TextUtils.isEmpty(optString3)) {
                        aMapLocation.setBearing(Float.parseFloat(optString3));
                    }
                } catch (Throwable unused3) {
                }
                aMapLocation.setAdCode(jSONObject.optString("adcode", aMapLocation.getAdCode()));
                aMapLocation.setCityCode(jSONObject.optString("citycode", aMapLocation.getCityCode()));
                aMapLocation.setAddress(jSONObject.optString("address", aMapLocation.getAddress()));
                String optString4 = jSONObject.optString("desc", "");
                aMapLocation.setCountry(jSONObject.optString("country", aMapLocation.getCountry()));
                aMapLocation.setProvince(jSONObject.optString("province", aMapLocation.getProvince()));
                aMapLocation.setCity(jSONObject.optString("city", aMapLocation.getCity()));
                aMapLocation.setDistrict(jSONObject.optString("district", aMapLocation.getDistrict()));
                aMapLocation.setRoad(jSONObject.optString("road", aMapLocation.getRoad()));
                aMapLocation.setStreet(jSONObject.optString("street", aMapLocation.getStreet()));
                aMapLocation.setNumber(jSONObject.optString("number", aMapLocation.getStreetNum()));
                aMapLocation.setPoiName(jSONObject.optString("poiname", aMapLocation.getPoiName()));
                aMapLocation.setAoiName(jSONObject.optString("aoiname", aMapLocation.getAoiName()));
                aMapLocation.setErrorCode(jSONObject.optInt("errorCode", aMapLocation.getErrorCode()));
                aMapLocation.setErrorInfo(jSONObject.optString("errorInfo", aMapLocation.getErrorInfo()));
                aMapLocation.setLocationType(jSONObject.optInt("locationType", aMapLocation.getLocationType()));
                aMapLocation.setLocationDetail(jSONObject.optString("locationDetail", aMapLocation.getLocationDetail()));
                aMapLocation.setTime(jSONObject.optLong("time", aMapLocation.getTime()));
                boolean optBoolean = jSONObject.optBoolean("isOffset", aMapLocation.isOffset());
                aMapLocation.setOffset(optBoolean);
                aMapLocation.setBuildingId(jSONObject.optString("poiid", aMapLocation.getBuildingId()));
                aMapLocation.setFloor(jSONObject.optString("floor", aMapLocation.getFloor()));
                aMapLocation.setDescription(jSONObject.optString("description", aMapLocation.getDescription()));
                if (jSONObject.has("coordType")) {
                    str = jSONObject.optString("coordType", "GCJ02");
                } else if (!a(optDouble, optDouble2) || !optBoolean) {
                    str = "WGS84";
                } else {
                    aMapLocation.setCoordType("GCJ02");
                    Bundle bundle = new Bundle();
                    bundle.putString("citycode", aMapLocation.getCityCode());
                    bundle.putString("desc", optString4.toString());
                    bundle.putString("adcode", aMapLocation.getAdCode());
                    aMapLocation.setExtras(bundle);
                }
                aMapLocation.setCoordType(str);
                Bundle bundle = new Bundle();
                bundle.putString("citycode", aMapLocation.getCityCode());
                bundle.putString("desc", optString4.toString());
                bundle.putString("adcode", aMapLocation.getAdCode());
                aMapLocation.setExtras(bundle);
            } catch (Throwable th) {
                a(th, "CoreUtil", "transformLocation");
            }
        }
    }

    public static void a(Throwable th, String str, String str2) {
        if (!"reportError".equals(str2) && !(th instanceof j)) {
            try {
                ab.b(th, str, str2);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean a(double d2, double d3) {
        int i2 = (int) ((d3 - 73.0d) / 0.5d);
        int i3 = (int) ((d2 - 3.5d) / 0.5d);
        if (i3 < 0 || i3 >= 101 || i2 < 0 || i2 >= 124) {
            return false;
        }
        try {
            return "00000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000001011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011101010111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111101111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000110111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011010111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110011100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001010011100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111100110001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111000111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111110011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111000000000111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111100000000000010111110100000011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111110000000001111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111000000111111111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111101111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000101111111111111111111111111111111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000011110000000001111111111111111111111111111111111111111111110000000000000000000000000000000000000000000000000000000000011000011111100000000111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000001111111100111111111100110111111111111111111111111111111111111111111111110000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000101111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111011111000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100100000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100011100000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000111110000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110011111110000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110111111110000000000000000000000111011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000011111111111111111111111111111111111111111111111100001111111111111111111111111111111111111111111111111010000000000000000000000111111111111111111111111111111111111111111110000000000000001111111111111111111111111111111111111111111100000000000000000000011111111111111111111111111111111100000000000000000000000000001111111111111111111111111111111111111111110000000000000000000001111111111111111111111111111111100000000000000000000000000000001111111111111111111111111111111111111111000000000000000000000111111111111111111111111111111110000000000000000000000000000001111111111111111111111111111111111111111100000000000000000000111111111111111111111111111111000000000000000000000000000000000111111111111111111111111111111111111111111000000000000000000001111111111111111111111111110000000000000000000000000000000000001110011111111111111111111111111111111111111100000000000000000000011111111111111111100000000000000000000000000000000000000000000000001111111111111111111111111111111111111000000000000000000001111111111111111111000000000000000000000000000000000000000000000000011111111111111111111111111111111111100000000000000000000011111111111111111100000000000000000000000000000000000000000000000000011111111111111111111111111111111111000000000000000000001111111111111111100000000000000000000000000000000000000000000000000000000111111111111111111111111111111110000000000000000000000000111111111100000000000000000000000000000000000000000000000000111111111111111111111111111111111111111000000000000000000000000011111111100000000000000000000000000000000000000000000000000011111111111111111111111111111110001111100000000000000000000000000111110000000000000000000000000000000000000000000000000000001111111111111111111111111111111000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000011111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010110000000000000000000000".charAt((i3 * 124) + i2) == '1';
        } catch (Throwable th) {
            a(th, "CoreUtil", "isChina");
            return true;
        }
    }

    private static boolean a(double d2, double d3, double d4, double d5, double d6, double d7) {
        return Math.abs(((d4 - d2) * (d7 - d3)) - ((d6 - d2) * (d5 - d3))) < 1.0E-9d && (d2 - d4) * (d2 - d6) <= 0.0d && (d3 - d5) * (d3 - d7) <= 0.0d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f8 A[SYNTHETIC] */
    public static boolean a(DPoint dPoint, List<DPoint> list) {
        boolean z;
        double longitude = dPoint.getLongitude();
        double latitude = dPoint.getLatitude();
        double latitude2 = dPoint.getLatitude();
        if (!list.get(0).equals(list.get(list.size() - 1))) {
            list.add(list.get(0));
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < list.size() - 1) {
            double longitude2 = list.get(i2).getLongitude();
            double latitude3 = list.get(i2).getLatitude();
            int i4 = i2 + 1;
            double longitude3 = list.get(i4).getLongitude();
            double latitude4 = list.get(i4).getLatitude();
            if (a(longitude, latitude, longitude2, latitude3, longitude3, latitude4)) {
                return true;
            }
            double d2 = latitude4 - latitude3;
            if (Math.abs(d2) >= 1.0E-9d) {
                if (a(longitude2, latitude3, longitude, latitude, 180.0d, latitude2)) {
                    if (latitude3 <= latitude4) {
                    }
                } else if (!a(longitude3, latitude4, longitude, latitude, 180.0d, latitude2)) {
                    double d3 = longitude3 - longitude2;
                    double d4 = latitude2 - latitude;
                    double d5 = 180.0d - longitude;
                    double d6 = (d3 * d4) - (d2 * d5);
                    if (d6 != 0.0d) {
                        double d7 = latitude3 - latitude;
                        double d8 = longitude2 - longitude;
                        double d9 = ((d5 * d7) - (d4 * d8)) / d6;
                        double d10 = ((d7 * d3) - (d8 * d2)) / d6;
                        if (d9 >= 0.0d && d9 <= 1.0d && d10 >= 0.0d && d10 <= 1.0d) {
                            z = true;
                            if (!z) {
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                } else if (latitude4 <= latitude3) {
                }
                i3++;
            }
            i2 = i4;
        }
        return i3 % 2 != 0;
    }

    private static byte[] a(String str) {
        if (str == null || str.length() < 2) {
            return new byte[0];
        }
        String lowerCase = str.toLowerCase(Locale.US);
        int length = lowerCase.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) (ep.h(lowerCase.substring(i3, i3 + 2)) & 255);
        }
        return bArr;
    }

    public static String b() {
        return b;
    }

    public static String b(Context context) {
        return r.a(k.e(context));
    }

    public static t c() {
        try {
            if (o == null) {
                o = new t.a("loc", "5.2.0", "AMAP_Location_SDK_Android 5.2.0").a((String[]) n.clone()).a("5.2.0").a();
            }
        } catch (Throwable th) {
            a(th, "CoreUtil", "getSDKInfo");
        }
        return o;
    }

    public static void c(Context context) {
        try {
            if (u.b(context)) {
                a = "http://abroad.apilocate.amap.com/mobile/binary";
                b = "http://abroad.apilocate.amap.com/mobile/binary";
                return;
            }
            a = "http://apilocate.amap.com/mobile/binary";
            b = "http://dualstack.apilocate.amap.com/mobile/binary";
        } catch (Throwable th) {
            a(th, "CoreUtil", "changeUrl");
        }
    }

    public static String d() {
        return d;
    }
}
