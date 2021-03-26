package com.loc;

import android.os.Bundle;
import com.amap.api.fence.DistrictItem;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.PoiItem;
import com.amap.api.location.DPoint;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: GeoFenceSearchResultParser */
public final class c {
    private static long a;

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x00d2: INVOKE  (r8v2 long) =  type: STATIC call: com.loc.c.a():long)] */
    public static int a(String str, List<GeoFence> list, Bundle bundle) {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("status", 0);
            int optInt2 = jSONObject.optInt("infocode", 0);
            if (optInt != 1 || (optJSONArray = jSONObject.optJSONArray("pois")) == null) {
                return optInt2;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                GeoFence geoFence = new GeoFence();
                PoiItem poiItem = new PoiItem();
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                poiItem.setPoiId(jSONObject2.optString("id"));
                poiItem.setPoiName(jSONObject2.optString("name"));
                poiItem.setPoiType(jSONObject2.optString("type"));
                poiItem.setTypeCode(jSONObject2.optString("typecode"));
                poiItem.setAddress(jSONObject2.optString("address"));
                String optString = jSONObject2.optString("location");
                if (optString != null) {
                    String[] split = optString.split(",");
                    poiItem.setLongitude(Double.parseDouble(split[0]));
                    poiItem.setLatitude(Double.parseDouble(split[1]));
                    List<List<DPoint>> arrayList = new ArrayList<>();
                    ArrayList arrayList2 = new ArrayList();
                    DPoint dPoint = new DPoint(poiItem.getLatitude(), poiItem.getLongitude());
                    arrayList2.add(dPoint);
                    arrayList.add(arrayList2);
                    geoFence.setPointList(arrayList);
                    geoFence.setCenter(dPoint);
                }
                poiItem.setTel(jSONObject2.optString("tel"));
                poiItem.setProvince(jSONObject2.optString("pname"));
                poiItem.setCity(jSONObject2.optString("cityname"));
                poiItem.setAdname(jSONObject2.optString("adname"));
                geoFence.setPoiItem(poiItem);
                StringBuilder sb = new StringBuilder();
                sb.append(a());
                geoFence.setFenceId(sb.toString());
                geoFence.setCustomId(bundle.getString("customId"));
                geoFence.setPendingIntentAction(bundle.getString("pendingIntentAction"));
                geoFence.setType(2);
                geoFence.setRadius(bundle.getFloat("fenceRadius"));
                geoFence.setExpiration(bundle.getLong("expiration"));
                geoFence.setActivatesAction(bundle.getInt("activatesAction", 1));
                list.add(geoFence);
            }
            return optInt2;
        } catch (Throwable unused) {
            return 5;
        }
    }

    public static synchronized long a() {
        long j;
        synchronized (c.class) {
            long b = ep.b();
            long j2 = a;
            if (b > j2) {
                a = b;
            } else {
                a = j2 + 1;
            }
            j = a;
        }
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ec A[SYNTHETIC] */
    private List<DPoint> a(List<DPoint> list, float f) {
        DPoint dPoint;
        double d;
        double d2;
        double a2;
        double d3;
        double d4;
        List<DPoint> list2 = list;
        if (list2 == null) {
            return null;
        }
        if (list.size() <= 2) {
            return list2;
        }
        ArrayList arrayList = new ArrayList();
        DPoint dPoint2 = list2.get(0);
        int i = 1;
        DPoint dPoint3 = list2.get(list.size() - 1);
        double d5 = 0.0d;
        double d6 = 0.0d;
        int i2 = 1;
        int i3 = 0;
        while (i2 < list.size() - i) {
            DPoint dPoint4 = list2.get(i2);
            double longitude = dPoint4.getLongitude() - dPoint2.getLongitude();
            double latitude = dPoint4.getLatitude() - dPoint2.getLatitude();
            double longitude2 = dPoint3.getLongitude() - dPoint2.getLongitude();
            double latitude2 = dPoint3.getLatitude() - dPoint2.getLatitude();
            double d7 = ((longitude * longitude2) + (latitude * latitude2)) / ((longitude2 * longitude2) + (latitude2 * latitude2));
            boolean z = dPoint2.getLongitude() == dPoint3.getLongitude() && dPoint2.getLatitude() == dPoint3.getLatitude();
            if (d7 < d5 || z) {
                d4 = dPoint2.getLongitude();
                d3 = dPoint2.getLatitude();
            } else if (d7 > 1.0d) {
                d4 = dPoint3.getLongitude();
                d3 = dPoint3.getLatitude();
            } else {
                d = dPoint2.getLongitude() + (longitude2 * d7);
                dPoint = dPoint2;
                d2 = dPoint2.getLatitude() + (d7 * latitude2);
                a2 = (double) ep.a(new DPoint(dPoint4.getLatitude(), dPoint4.getLongitude()), new DPoint(d2, d));
                if (a2 <= d6) {
                    d6 = a2;
                    i3 = i2;
                }
                i2++;
                list2 = list;
                dPoint2 = dPoint;
                i = 1;
                d5 = 0.0d;
            }
            d = d4;
            dPoint = dPoint2;
            d2 = d3;
            a2 = (double) ep.a(new DPoint(dPoint4.getLatitude(), dPoint4.getLongitude()), new DPoint(d2, d));
            if (a2 <= d6) {
            }
            i2++;
            list2 = list;
            dPoint2 = dPoint;
            i = 1;
            d5 = 0.0d;
        }
        if (d6 < ((double) f)) {
            arrayList.add(dPoint2);
            arrayList.add(dPoint3);
            return arrayList;
        }
        List<DPoint> a3 = a(list.subList(0, i3 + 1), f);
        List<DPoint> a4 = a(list.subList(i3, list.size()), f);
        arrayList.addAll(a3);
        arrayList.remove(arrayList.size() - 1);
        arrayList.addAll(a4);
        return arrayList;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x00bd: INVOKE  (r10v3 long) =  type: STATIC call: com.loc.c.a():long)] */
    public final int b(String str, List<GeoFence> list, Bundle bundle) {
        JSONArray optJSONArray;
        String str2;
        ArrayList arrayList;
        long j;
        float f;
        String str3;
        String str4;
        int i;
        int i2;
        long j2;
        String str5;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("status", 0);
            int optInt2 = jSONObject.optInt("infocode", 0);
            String string = bundle.getString("customId");
            String string2 = bundle.getString("pendingIntentAction");
            float f2 = bundle.getFloat("fenceRadius");
            long j3 = bundle.getLong("expiration");
            int i3 = bundle.getInt("activatesAction", 1);
            if (optInt == 1 && (optJSONArray = jSONObject.optJSONArray("districts")) != null) {
                int i4 = 0;
                while (i4 < optJSONArray.length()) {
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    GeoFence geoFence = new GeoFence();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i4);
                    String optString = jSONObject2.optString("citycode");
                    String optString2 = jSONObject2.optString("adcode");
                    String optString3 = jSONObject2.optString("name");
                    String string3 = jSONObject2.getString("center");
                    DPoint dPoint = new DPoint();
                    String str6 = ",";
                    if (string3 != null) {
                        String[] split = string3.split(str6);
                        arrayList = arrayList2;
                        str2 = optString3;
                        dPoint.setLatitude(Double.parseDouble(split[1]));
                        dPoint.setLongitude(Double.parseDouble(split[0]));
                        geoFence.setCenter(dPoint);
                    } else {
                        arrayList = arrayList2;
                        str2 = optString3;
                    }
                    geoFence.setCustomId(string);
                    geoFence.setPendingIntentAction(string2);
                    geoFence.setType(3);
                    geoFence.setRadius(f2);
                    geoFence.setExpiration(j3);
                    geoFence.setActivatesAction(i3);
                    StringBuilder sb = new StringBuilder();
                    sb.append(a());
                    geoFence.setFenceId(sb.toString());
                    String optString4 = jSONObject2.optString("polyline");
                    if (optString4 != null) {
                        String[] split2 = optString4.split("\\|");
                        int length = split2.length;
                        i = i3;
                        float f3 = Float.MAX_VALUE;
                        int i5 = 0;
                        float f4 = Float.MIN_VALUE;
                        while (i5 < length) {
                            String str7 = split2[i5];
                            DistrictItem districtItem = new DistrictItem();
                            List<DPoint> arrayList4 = new ArrayList<>();
                            districtItem.setCitycode(optString);
                            districtItem.setAdcode(optString2);
                            districtItem.setDistrictName(str2);
                            str2 = str2;
                            String[] split3 = str7.split(";");
                            int i6 = 0;
                            while (i6 < split3.length) {
                                String[] split4 = split3[i6].split(str6);
                                if (split4.length > 1) {
                                    String str8 = split4[1];
                                    String str9 = split4[0];
                                    j2 = j3;
                                    double parseDouble = Double.parseDouble(str8);
                                    i2 = length;
                                    str5 = optString;
                                    arrayList4.add(new DPoint(parseDouble, Double.parseDouble(str9)));
                                } else {
                                    j2 = j3;
                                    i2 = length;
                                    str5 = optString;
                                }
                                i6++;
                                optString = str5;
                                str6 = str6;
                                split3 = split3;
                                j3 = j2;
                                length = i2;
                            }
                            if (((float) arrayList4.size()) > 100.0f) {
                                try {
                                    arrayList4 = a(arrayList4, 100.0f);
                                } catch (Throwable unused) {
                                    return 5;
                                }
                            }
                            arrayList3.add(arrayList4);
                            districtItem.setPolyline(arrayList4);
                            arrayList.add(districtItem);
                            f4 = Math.max(f4, a.b(dPoint, arrayList4));
                            f3 = Math.min(f3, a.a(dPoint, arrayList4));
                            i5++;
                            optString = optString;
                            arrayList = arrayList;
                            string = string;
                            split2 = split2;
                            string2 = string2;
                            optString2 = optString2;
                            f2 = f2;
                            str6 = str6;
                            j3 = j3;
                            length = length;
                        }
                        str4 = string;
                        str3 = string2;
                        f = f2;
                        j = j3;
                        geoFence.setMaxDis2Center(f4);
                        geoFence.setMinDis2Center(f3);
                        geoFence.setDistrictItemList(arrayList);
                        geoFence.setPointList(arrayList3);
                        list.add(geoFence);
                    } else {
                        i = i3;
                        str4 = string;
                        str3 = string2;
                        f = f2;
                        j = j3;
                    }
                    i4++;
                    optJSONArray = optJSONArray;
                    optInt2 = optInt2;
                    i3 = i;
                    string = str4;
                    string2 = str3;
                    f2 = f;
                    j3 = j;
                }
            }
            return optInt2;
        } catch (Throwable unused2) {
            return 5;
        }
    }
}
