package com.amap.api.col.s;

import android.text.TextUtils;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.district.DistrictItem;
import com.amap.api.services.geocoder.AoiItem;
import com.amap.api.services.geocoder.BusinessArea;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeRoad;
import com.amap.api.services.geocoder.StreetNumber;
import com.amap.api.services.help.Tip;
import com.amap.api.services.nearby.NearbyInfo;
import com.amap.api.services.poisearch.IndoorData;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiItemExtension;
import com.amap.api.services.poisearch.SubPoiItem;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.route.BusPath;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.BusStep;
import com.amap.api.services.route.DistanceItem;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.District;
import com.amap.api.services.route.Doorway;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DrivePlanPath;
import com.amap.api.services.route.DrivePlanStep;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveStep;
import com.amap.api.services.route.Path;
import com.amap.api.services.route.Railway;
import com.amap.api.services.route.RailwaySpace;
import com.amap.api.services.route.RailwayStationItem;
import com.amap.api.services.route.RidePath;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RideStep;
import com.amap.api.services.route.RouteBusLineItem;
import com.amap.api.services.route.RouteBusWalkItem;
import com.amap.api.services.route.RouteRailwayItem;
import com.amap.api.services.route.RouteSearchCity;
import com.amap.api.services.route.TMC;
import com.amap.api.services.route.TaxiItem;
import com.amap.api.services.route.TimeInfo;
import com.amap.api.services.route.TimeInfosElement;
import com.amap.api.services.route.TruckPath;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.TruckStep;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkStep;
import com.amap.api.services.routepoisearch.RoutePOIItem;
import com.amap.api.services.weather.LocalDayWeatherForecast;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.LocalWeatherLive;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JSONHelper */
public final class p {
    private static String[] a = {"010", "021", "022", "023", "1852", "1853"};

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x007c  */
    public static ArrayList<NearbyInfo> a(JSONObject jSONObject, boolean z) throws JSONException {
        double d;
        JSONArray optJSONArray = jSONObject.optJSONArray("datas");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return new ArrayList<>();
        }
        ArrayList<NearbyInfo> arrayList = new ArrayList<>();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            String a2 = a(optJSONObject, "userid");
            String a3 = a(optJSONObject, "location");
            double d2 = 0.0d;
            if (a3 != null) {
                String[] split = a3.split(",");
                if (split.length == 2) {
                    double p = p(split[0]);
                    d2 = p(split[1]);
                    d = p;
                    String a4 = a(optJSONObject, "distance");
                    long q = q(a(optJSONObject, "updatetime"));
                    int n = n(a4);
                    LatLonPoint latLonPoint = new LatLonPoint(d2, d);
                    NearbyInfo nearbyInfo = new NearbyInfo();
                    nearbyInfo.setUserID(a2);
                    nearbyInfo.setTimeStamp(q);
                    nearbyInfo.setPoint(latLonPoint);
                    if (!z) {
                        nearbyInfo.setDrivingDistance(n);
                    } else {
                        nearbyInfo.setDistance(n);
                    }
                    arrayList.add(nearbyInfo);
                }
            }
            d = 0.0d;
            String a4 = a(optJSONObject, "distance");
            long q = q(a(optJSONObject, "updatetime"));
            int n = n(a4);
            LatLonPoint latLonPoint = new LatLonPoint(d2, d);
            NearbyInfo nearbyInfo = new NearbyInfo();
            nearbyInfo.setUserID(a2);
            nearbyInfo.setTimeStamp(q);
            nearbyInfo.setPoint(latLonPoint);
            if (!z) {
            }
            arrayList.add(nearbyInfo);
        }
        return arrayList;
    }

    public static ArrayList<SuggestionCity> a(JSONObject jSONObject) throws JSONException, NumberFormatException {
        JSONArray optJSONArray;
        ArrayList<SuggestionCity> arrayList = new ArrayList<>();
        if (!jSONObject.has("cities") || (optJSONArray = jSONObject.optJSONArray("cities")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new SuggestionCity(a(optJSONObject, "name"), a(optJSONObject, "citycode"), a(optJSONObject, "adcode"), n(a(optJSONObject, "num"))));
            }
        }
        return arrayList;
    }

    public static ArrayList<String> b(JSONObject jSONObject) throws JSONException {
        ArrayList<String> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("keywords");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.optString(i));
        }
        return arrayList;
    }

    public static ArrayList<PoiItem> c(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList<PoiItem> arrayList = new ArrayList<>();
        if (!(jSONObject == null || (optJSONArray = jSONObject.optJSONArray("pois")) == null || optJSONArray.length() == 0)) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(d(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    public static PoiItem d(JSONObject jSONObject) throws JSONException {
        String str;
        String str2;
        String str3;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        PoiItem poiItem = new PoiItem(a(jSONObject, "id"), b(jSONObject, "location"), a(jSONObject, "name"), a(jSONObject, "address"));
        poiItem.setAdCode(a(jSONObject, "adcode"));
        poiItem.setProvinceName(a(jSONObject, "pname"));
        poiItem.setCityName(a(jSONObject, "cityname"));
        poiItem.setAdName(a(jSONObject, "adname"));
        poiItem.setCityCode(a(jSONObject, "citycode"));
        poiItem.setProvinceCode(a(jSONObject, "pcode"));
        poiItem.setDirection(a(jSONObject, "direction"));
        if (jSONObject.has("distance")) {
            String a2 = a(jSONObject, "distance");
            if (!f(a2)) {
                try {
                    poiItem.setDistance((int) Float.parseFloat(a2));
                } catch (NumberFormatException e) {
                    i.a(e, "JSONHelper", "parseBasePoi");
                } catch (Exception e2) {
                    i.a(e2, "JSONHelper", "parseBasePoi");
                }
            }
        }
        poiItem.setTel(a(jSONObject, "tel"));
        poiItem.setTypeDes(a(jSONObject, "type"));
        poiItem.setEnter(b(jSONObject, "entr_location"));
        poiItem.setExit(b(jSONObject, "exit_location"));
        poiItem.setWebsite(a(jSONObject, "website"));
        poiItem.setPostcode(a(jSONObject, "postcode"));
        String a3 = a(jSONObject, "business_area");
        if (f(a3)) {
            a3 = a(jSONObject, "businessarea");
        }
        poiItem.setBusinessArea(a3);
        poiItem.setEmail(a(jSONObject, "email"));
        String a4 = a(jSONObject, "indoor_map");
        int i = 0;
        String str4 = "";
        if (a4 == null || a4.equals(str4) || a4.equals("0")) {
            poiItem.setIndoorMap(false);
        } else {
            poiItem.setIndoorMap(true);
        }
        poiItem.setParkingType(a(jSONObject, "parking_type"));
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i2);
                    if (optJSONObject3 != null) {
                        arrayList.add(j(optJSONObject3));
                    }
                }
            }
            poiItem.setSubPois(arrayList);
        }
        if (!jSONObject.has("indoor_data") || (optJSONObject2 = jSONObject.optJSONObject("indoor_data")) == null || !optJSONObject2.has("cpid") || !optJSONObject2.has("floor")) {
            str2 = str4;
            str = str2;
        } else {
            str = a(optJSONObject2, "cpid");
            i = n(a(optJSONObject2, "floor"));
            str2 = a(optJSONObject2, "truefloor");
        }
        poiItem.setIndoorDate(new IndoorData(str, i, str2));
        if (!jSONObject.has("biz_ext") || (optJSONObject = jSONObject.optJSONObject("biz_ext")) == null) {
            str3 = str4;
        } else {
            str4 = a(optJSONObject, "open_time");
            str3 = a(optJSONObject, "rating");
        }
        poiItem.setPoiExtension(new PoiItemExtension(str4, str3));
        poiItem.setTypeCode(a(jSONObject, "typecode"));
        poiItem.setShopID(a(jSONObject, "shopid"));
        List<Photo> x = x(jSONObject.optJSONObject("deep_info"));
        if (x.size() == 0) {
            x = x(jSONObject);
        }
        poiItem.setPhotos(x);
        return poiItem;
    }

    private static SubPoiItem j(JSONObject jSONObject) throws JSONException {
        SubPoiItem subPoiItem = new SubPoiItem(a(jSONObject, "id"), b(jSONObject, "location"), a(jSONObject, "name"), a(jSONObject, "address"));
        subPoiItem.setSubName(a(jSONObject, "sname"));
        subPoiItem.setSubTypeDes(a(jSONObject, "subtype"));
        if (jSONObject.has("distance")) {
            String a2 = a(jSONObject, "distance");
            if (!f(a2)) {
                try {
                    subPoiItem.setDistance((int) Float.parseFloat(a2));
                } catch (NumberFormatException e) {
                    i.a(e, "JSONHelper", "parseSubPoiItem");
                } catch (Exception e2) {
                    i.a(e2, "JSONHelper", "parseSubPoiItem");
                }
            }
        }
        return subPoiItem;
    }

    public static ArrayList<BusStationItem> e(JSONObject jSONObject) throws JSONException {
        ArrayList<BusStationItem> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("busstops");
        if (!(optJSONArray == null || optJSONArray.length() == 0)) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(k(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    private static BusStationItem k(JSONObject jSONObject) throws JSONException {
        BusStationItem l = l(jSONObject);
        l.setAdCode(a(jSONObject, "adcode"));
        l.setCityCode(a(jSONObject, "citycode"));
        JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray == null) {
            l.setBusLineItems(arrayList);
            return l;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(m(optJSONObject));
            }
        }
        l.setBusLineItems(arrayList);
        return l;
    }

    private static BusStationItem l(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationId(a(jSONObject, "id"));
        busStationItem.setLatLonPoint(b(jSONObject, "location"));
        busStationItem.setBusStationName(a(jSONObject, "name"));
        return busStationItem;
    }

    private static BusLineItem m(JSONObject jSONObject) throws JSONException {
        BusLineItem busLineItem = new BusLineItem();
        busLineItem.setBusLineId(a(jSONObject, "id"));
        busLineItem.setBusLineType(a(jSONObject, "type"));
        busLineItem.setBusLineName(a(jSONObject, "name"));
        busLineItem.setDirectionsCoordinates(c(jSONObject, "polyline"));
        busLineItem.setCityCode(a(jSONObject, "citycode"));
        busLineItem.setOriginatingStation(a(jSONObject, "start_stop"));
        busLineItem.setTerminalStation(a(jSONObject, "end_stop"));
        return busLineItem;
    }

    public static ArrayList<BusLineItem> f(JSONObject jSONObject) throws JSONException {
        ArrayList<BusLineItem> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(n(optJSONObject));
            }
        }
        return arrayList;
    }

    private static BusLineItem n(JSONObject jSONObject) throws JSONException {
        BusLineItem m = m(jSONObject);
        m.setFirstBusTime(i.d(a(jSONObject, "start_time")));
        m.setLastBusTime(i.d(a(jSONObject, "end_time")));
        m.setBusCompany(a(jSONObject, "company"));
        m.setDistance(o(a(jSONObject, "distance")));
        m.setBasicPrice(o(a(jSONObject, "basic_price")));
        m.setTotalPrice(o(a(jSONObject, "total_price")));
        m.setBounds(c(jSONObject, "bounds"));
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("busstops");
        if (optJSONArray == null) {
            m.setBusStations(arrayList);
            return m;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(l(optJSONObject));
            }
        }
        m.setBusStations(arrayList);
        return m;
    }

    public static void a(JSONArray jSONArray, ArrayList<DistrictItem> arrayList, DistrictItem districtItem) throws JSONException {
        String optString;
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    DistrictItem districtItem2 = new DistrictItem();
                    districtItem2.setCitycode(a(optJSONObject, "citycode"));
                    districtItem2.setAdcode(a(optJSONObject, "adcode"));
                    districtItem2.setName(a(optJSONObject, "name"));
                    districtItem2.setLevel(a(optJSONObject, "level"));
                    districtItem2.setCenter(b(optJSONObject, "center"));
                    if (optJSONObject.has("polyline") && (optString = optJSONObject.optString("polyline")) != null && optString.length() > 0) {
                        districtItem2.setDistrictBoundary(optString.split("\\|"));
                    }
                    a(optJSONObject.optJSONArray("districts"), new ArrayList(), districtItem2);
                    arrayList.add(districtItem2);
                }
            }
            if (districtItem != null) {
                districtItem.setSubDistrict(arrayList);
            }
        }
    }

    public static ArrayList<GeocodeAddress> g(JSONObject jSONObject) throws JSONException {
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("geocodes");
        if (!(optJSONArray == null || optJSONArray.length() == 0)) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    GeocodeAddress geocodeAddress = new GeocodeAddress();
                    geocodeAddress.setFormatAddress(a(optJSONObject, "formatted_address"));
                    geocodeAddress.setProvince(a(optJSONObject, "province"));
                    geocodeAddress.setCity(a(optJSONObject, "city"));
                    geocodeAddress.setDistrict(a(optJSONObject, "district"));
                    geocodeAddress.setTownship(a(optJSONObject, "township"));
                    geocodeAddress.setNeighborhood(a(optJSONObject.optJSONObject("neighborhood"), "name"));
                    geocodeAddress.setBuilding(a(optJSONObject.optJSONObject("building"), "name"));
                    geocodeAddress.setAdcode(a(optJSONObject, "adcode"));
                    geocodeAddress.setLatLonPoint(b(optJSONObject, "location"));
                    geocodeAddress.setLevel(a(optJSONObject, "level"));
                    geocodeAddress.setCountry(a(optJSONObject, "country"));
                    geocodeAddress.setPostcode(a(optJSONObject, "postcode"));
                    arrayList.add(geocodeAddress);
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<Tip> h(JSONObject jSONObject) throws JSONException {
        ArrayList<Tip> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("tips");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            Tip tip = new Tip();
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                tip.setName(a(optJSONObject, "name"));
                tip.setDistrict(a(optJSONObject, "district"));
                tip.setAdcode(a(optJSONObject, "adcode"));
                tip.setID(a(optJSONObject, "id"));
                tip.setAddress(a(optJSONObject, "address"));
                tip.setTypeCode(a(optJSONObject, "typecode"));
                String a2 = a(optJSONObject, "location");
                if (!TextUtils.isEmpty(a2)) {
                    String[] split = a2.split(",");
                    if (split.length == 2) {
                        tip.setPostion(new LatLonPoint(Double.parseDouble(split[1]), Double.parseDouble(split[0])));
                    }
                }
                arrayList.add(tip);
            }
        }
        return arrayList;
    }

    public static void a(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Crossroad crossroad = new Crossroad();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                crossroad.setId(a(optJSONObject, "id"));
                crossroad.setDirection(a(optJSONObject, "direction"));
                crossroad.setDistance(o(a(optJSONObject, "distance")));
                crossroad.setCenterPoint(b(optJSONObject, "location"));
                crossroad.setFirstRoadId(a(optJSONObject, "first_id"));
                crossroad.setFirstRoadName(a(optJSONObject, "first_name"));
                crossroad.setSecondRoadId(a(optJSONObject, "second_id"));
                crossroad.setSecondRoadName(a(optJSONObject, "second_name"));
                arrayList.add(crossroad);
            }
        }
        regeocodeAddress.setCrossroads(arrayList);
    }

    public static void b(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            RegeocodeRoad regeocodeRoad = new RegeocodeRoad();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                regeocodeRoad.setId(a(optJSONObject, "id"));
                regeocodeRoad.setName(a(optJSONObject, "name"));
                regeocodeRoad.setLatLngPoint(b(optJSONObject, "location"));
                regeocodeRoad.setDirection(a(optJSONObject, "direction"));
                regeocodeRoad.setDistance(o(a(optJSONObject, "distance")));
                arrayList.add(regeocodeRoad);
            }
        }
        regeocodeAddress.setRoads(arrayList);
    }

    public static void a(JSONObject jSONObject, RegeocodeAddress regeocodeAddress) throws JSONException {
        regeocodeAddress.setCountry(a(jSONObject, "country"));
        regeocodeAddress.setCountryCode(a(jSONObject, "countrycode"));
        regeocodeAddress.setProvince(a(jSONObject, "province"));
        regeocodeAddress.setCity(a(jSONObject, "city"));
        regeocodeAddress.setCityCode(a(jSONObject, "citycode"));
        regeocodeAddress.setAdCode(a(jSONObject, "adcode"));
        regeocodeAddress.setDistrict(a(jSONObject, "district"));
        regeocodeAddress.setTownship(a(jSONObject, "township"));
        regeocodeAddress.setNeighborhood(a(jSONObject.optJSONObject("neighborhood"), "name"));
        regeocodeAddress.setBuilding(a(jSONObject.optJSONObject("building"), "name"));
        StreetNumber streetNumber = new StreetNumber();
        JSONObject optJSONObject = jSONObject.optJSONObject("streetNumber");
        streetNumber.setStreet(a(optJSONObject, "street"));
        streetNumber.setNumber(a(optJSONObject, "number"));
        streetNumber.setLatLonPoint(b(optJSONObject, "location"));
        streetNumber.setDirection(a(optJSONObject, "direction"));
        streetNumber.setDistance(o(a(optJSONObject, "distance")));
        regeocodeAddress.setStreetNumber(streetNumber);
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("businessAreas");
        if (!(optJSONArray == null || optJSONArray.length() == 0)) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                BusinessArea businessArea = new BusinessArea();
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    businessArea.setCenterPoint(b(optJSONObject2, "location"));
                    businessArea.setName(a(optJSONObject2, "name"));
                    arrayList.add(businessArea);
                }
            }
        }
        regeocodeAddress.setBusinessAreas(arrayList);
        regeocodeAddress.setTowncode(a(jSONObject, "towncode"));
        if ((regeocodeAddress.getCity() == null || regeocodeAddress.getCity().length() <= 0) && k(regeocodeAddress.getCityCode())) {
            regeocodeAddress.setCity(regeocodeAddress.getProvince());
        }
    }

    private static boolean k(String str) {
        if (str != null && str.length() > 0) {
            for (String str2 : a) {
                if (str.trim().equals(str2.trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static BusRouteResult a(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            BusRouteResult busRouteResult = new BusRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            if (optJSONObject == null) {
                return busRouteResult;
            }
            busRouteResult.setStartPos(b(optJSONObject, "origin"));
            busRouteResult.setTargetPos(b(optJSONObject, "destination"));
            busRouteResult.setTaxiCost(o(a(optJSONObject, "taxi_cost")));
            if (!optJSONObject.has("transits") || (optJSONArray = optJSONObject.optJSONArray("transits")) == null) {
                return busRouteResult;
            }
            busRouteResult.setPaths(a(optJSONArray));
            return busRouteResult;
        } catch (JSONException unused) {
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x01c5  */
    private static List<BusPath> a(JSONArray jSONArray) throws JSONException {
        BusStep busStep;
        TaxiItem taxiItem;
        RouteRailwayItem routeRailwayItem;
        JSONArray jSONArray2 = jSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONArray2 == null) {
            return arrayList;
        }
        int i = 0;
        while (i < jSONArray.length()) {
            BusPath busPath = new BusPath();
            JSONObject optJSONObject = jSONArray2.optJSONObject(i);
            if (optJSONObject != null) {
                busPath.setCost(o(a(optJSONObject, "cost")));
                busPath.setDuration(q(a(optJSONObject, "duration")));
                busPath.setNightBus(r(a(optJSONObject, "nightflag")));
                busPath.setWalkDistance(o(a(optJSONObject, "walking_distance")));
                busPath.setDistance(o(a(optJSONObject, "distance")));
                JSONArray optJSONArray = optJSONObject.optJSONArray("segments");
                if (optJSONArray != null) {
                    ArrayList arrayList2 = new ArrayList();
                    float f = 0.0f;
                    float f2 = 0.0f;
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject2 != null) {
                            if (optJSONObject2 != null) {
                                BusStep busStep2 = new BusStep();
                                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("walking");
                                if (optJSONObject3 != null) {
                                    busStep2.setWalk(o(optJSONObject3));
                                }
                                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("bus");
                                if (optJSONObject4 != null) {
                                    busStep2.setBusLines(p(optJSONObject4));
                                }
                                JSONObject optJSONObject5 = optJSONObject2.optJSONObject("entrance");
                                if (optJSONObject5 != null) {
                                    busStep2.setEntrance(q(optJSONObject5));
                                }
                                JSONObject optJSONObject6 = optJSONObject2.optJSONObject("exit");
                                if (optJSONObject6 != null) {
                                    busStep2.setExit(q(optJSONObject6));
                                }
                                JSONObject optJSONObject7 = optJSONObject2.optJSONObject("railway");
                                if (optJSONObject7 != null) {
                                    if (optJSONObject7 != null && optJSONObject7.has("id") && optJSONObject7.has("name")) {
                                        routeRailwayItem = new RouteRailwayItem();
                                        routeRailwayItem.setID(a(optJSONObject7, "id"));
                                        routeRailwayItem.setName(a(optJSONObject7, "name"));
                                        routeRailwayItem.setTime(a(optJSONObject7, "time"));
                                        routeRailwayItem.setTrip(a(optJSONObject7, "trip"));
                                        routeRailwayItem.setDistance(o(a(optJSONObject7, "distance")));
                                        routeRailwayItem.setType(a(optJSONObject7, "type"));
                                        routeRailwayItem.setDeparturestop(t(optJSONObject7.optJSONObject("departure_stop")));
                                        routeRailwayItem.setArrivalstop(t(optJSONObject7.optJSONObject("arrival_stop")));
                                        routeRailwayItem.setViastops(u(optJSONObject7));
                                        routeRailwayItem.setAlters(v(optJSONObject7));
                                        routeRailwayItem.setSpaces(w(optJSONObject7));
                                    } else {
                                        routeRailwayItem = null;
                                    }
                                    busStep2.setRailway(routeRailwayItem);
                                }
                                JSONObject optJSONObject8 = optJSONObject2.optJSONObject("taxi");
                                if (optJSONObject8 != null) {
                                    if (optJSONObject8 == null) {
                                        taxiItem = null;
                                    } else {
                                        taxiItem = new TaxiItem();
                                        taxiItem.setOrigin(b(optJSONObject8, "origin"));
                                        taxiItem.setDestination(b(optJSONObject8, "destination"));
                                        taxiItem.setDistance(o(a(optJSONObject8, "distance")));
                                        taxiItem.setDuration(o(a(optJSONObject8, "duration")));
                                        taxiItem.setSname(a(optJSONObject8, "sname"));
                                        taxiItem.setTname(a(optJSONObject8, "tname"));
                                    }
                                    busStep2.setTaxi(taxiItem);
                                }
                                if (!((busStep2.getWalk() == null || busStep2.getWalk().getSteps().size() == 0) && busStep2.getBusLines().size() == 0 && busStep2.getRailway() == null && busStep2.getTaxi() == null)) {
                                    busStep = busStep2;
                                    if (busStep != null) {
                                        arrayList2.add(busStep);
                                        if (busStep.getWalk() != null) {
                                            f2 += busStep.getWalk().getDistance();
                                        }
                                        if (busStep.getBusLines() != null && busStep.getBusLines().size() > 0) {
                                            f += busStep.getBusLines().get(0).getDistance();
                                        }
                                    }
                                }
                            }
                            busStep = null;
                            if (busStep != null) {
                            }
                        }
                    }
                    busPath.setSteps(arrayList2);
                    busPath.setBusDistance(f);
                    busPath.setWalkDistance(f2);
                    arrayList.add(busPath);
                    i++;
                    jSONArray2 = jSONArray;
                }
            }
            i++;
            jSONArray2 = jSONArray;
        }
        return arrayList;
    }

    private static RouteBusWalkItem o(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            return null;
        }
        RouteBusWalkItem routeBusWalkItem = new RouteBusWalkItem();
        routeBusWalkItem.setOrigin(b(jSONObject, "origin"));
        routeBusWalkItem.setDestination(b(jSONObject, "destination"));
        routeBusWalkItem.setDistance(o(a(jSONObject, "distance")));
        routeBusWalkItem.setDuration(q(a(jSONObject, "duration")));
        if (!jSONObject.has("steps") || (optJSONArray = jSONObject.optJSONArray("steps")) == null) {
            return routeBusWalkItem;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                WalkStep walkStep = new WalkStep();
                walkStep.setInstruction(a(optJSONObject, "instruction"));
                walkStep.setOrientation(a(optJSONObject, "orientation"));
                walkStep.setRoad(a(optJSONObject, "road"));
                walkStep.setDistance(o(a(optJSONObject, "distance")));
                walkStep.setDuration(o(a(optJSONObject, "duration")));
                walkStep.setPolyline(c(optJSONObject, "polyline"));
                walkStep.setAction(a(optJSONObject, "action"));
                walkStep.setAssistantAction(a(optJSONObject, "assistant_action"));
                arrayList.add(walkStep);
            }
        }
        routeBusWalkItem.setSteps(arrayList);
        a(routeBusWalkItem, arrayList);
        return routeBusWalkItem;
    }

    private static List<RouteBusLineItem> p(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        RouteBusLineItem routeBusLineItem;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("buslines")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                if (optJSONObject == null) {
                    routeBusLineItem = null;
                } else {
                    RouteBusLineItem routeBusLineItem2 = new RouteBusLineItem();
                    routeBusLineItem2.setDepartureBusStation(s(optJSONObject.optJSONObject("departure_stop")));
                    routeBusLineItem2.setArrivalBusStation(s(optJSONObject.optJSONObject("arrival_stop")));
                    routeBusLineItem2.setBusLineName(a(optJSONObject, "name"));
                    routeBusLineItem2.setBusLineId(a(optJSONObject, "id"));
                    routeBusLineItem2.setBusLineType(a(optJSONObject, "type"));
                    routeBusLineItem2.setDistance(o(a(optJSONObject, "distance")));
                    routeBusLineItem2.setDuration(o(a(optJSONObject, "duration")));
                    routeBusLineItem2.setPolyline(c(optJSONObject, "polyline"));
                    routeBusLineItem2.setFirstBusTime(i.d(a(optJSONObject, "start_time")));
                    routeBusLineItem2.setLastBusTime(i.d(a(optJSONObject, "end_time")));
                    routeBusLineItem2.setPassStationNum(n(a(optJSONObject, "via_num")));
                    routeBusLineItem2.setPassStations(r(optJSONObject));
                    routeBusLineItem = routeBusLineItem2;
                }
                arrayList.add(routeBusLineItem);
            }
        }
        return arrayList;
    }

    private static Doorway q(JSONObject jSONObject) throws JSONException {
        Doorway doorway = new Doorway();
        doorway.setName(a(jSONObject, "name"));
        doorway.setLatLonPoint(b(jSONObject, "location"));
        return doorway;
    }

    private static List<BusStationItem> r(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("via_stops")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(s(optJSONObject));
            }
        }
        return arrayList;
    }

    private static BusStationItem s(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationName(a(jSONObject, "name"));
        busStationItem.setBusStationId(a(jSONObject, "id"));
        busStationItem.setLatLonPoint(b(jSONObject, "location"));
        return busStationItem;
    }

    private static RailwayStationItem t(JSONObject jSONObject) throws JSONException {
        RailwayStationItem railwayStationItem = new RailwayStationItem();
        railwayStationItem.setID(a(jSONObject, "id"));
        railwayStationItem.setName(a(jSONObject, "name"));
        railwayStationItem.setLocation(b(jSONObject, "location"));
        railwayStationItem.setAdcode(a(jSONObject, "adcode"));
        railwayStationItem.setTime(a(jSONObject, "time"));
        railwayStationItem.setisStart(r(a(jSONObject, "start")));
        railwayStationItem.setisEnd(r(a(jSONObject, "end")));
        railwayStationItem.setWait(o(a(jSONObject, "wait")));
        return railwayStationItem;
    }

    private static List<RailwayStationItem> u(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("via_stops")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(t(optJSONObject));
            }
        }
        return arrayList;
    }

    private static List<Railway> v(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("alters")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                Railway railway = new Railway();
                railway.setID(a(optJSONObject, "id"));
                railway.setName(a(optJSONObject, "name"));
                arrayList.add(railway);
            }
        }
        return arrayList;
    }

    private static List<RailwaySpace> w(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("spaces")) == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new RailwaySpace(a(optJSONObject, "code"), o(a(optJSONObject, "cost"))));
            }
        }
        return arrayList;
    }

    public static DriveRouteResult b(String str) throws AMapException {
        JSONArray optJSONArray;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            DriveRouteResult driveRouteResult = new DriveRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            if (optJSONObject == null) {
                return driveRouteResult;
            }
            driveRouteResult.setStartPos(b(optJSONObject, "origin"));
            driveRouteResult.setTargetPos(b(optJSONObject, "destination"));
            driveRouteResult.setTaxiCost(o(a(optJSONObject, "taxi_cost")));
            if (!optJSONObject.has("paths") || (optJSONArray = optJSONObject.optJSONArray("paths")) == null) {
                return driveRouteResult;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i < optJSONArray.length()) {
                DrivePath drivePath = new DrivePath();
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    drivePath.setDistance(o(a(optJSONObject2, "distance")));
                    drivePath.setDuration(q(a(optJSONObject2, "duration")));
                    drivePath.setStrategy(a(optJSONObject2, "strategy"));
                    drivePath.setTolls(o(a(optJSONObject2, "tolls")));
                    drivePath.setTollDistance(o(a(optJSONObject2, "toll_distance")));
                    drivePath.setTotalTrafficlights(n(a(optJSONObject2, "traffic_lights")));
                    drivePath.setRestriction(n(a(optJSONObject2, "restriction")));
                    JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                    if (optJSONArray2 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        int i2 = 0;
                        while (i2 < optJSONArray2.length()) {
                            DriveStep driveStep = new DriveStep();
                            JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                            if (optJSONObject3 != null) {
                                jSONArray2 = optJSONArray;
                                driveStep.setInstruction(a(optJSONObject3, "instruction"));
                                driveStep.setOrientation(a(optJSONObject3, "orientation"));
                                driveStep.setRoad(a(optJSONObject3, "road"));
                                driveStep.setDistance(o(a(optJSONObject3, "distance")));
                                driveStep.setTolls(o(a(optJSONObject3, "tolls")));
                                driveStep.setTollDistance(o(a(optJSONObject3, "toll_distance")));
                                driveStep.setTollRoad(a(optJSONObject3, "toll_road"));
                                driveStep.setDuration(o(a(optJSONObject3, "duration")));
                                driveStep.setPolyline(c(optJSONObject3, "polyline"));
                                driveStep.setAction(a(optJSONObject3, "action"));
                                driveStep.setAssistantAction(a(optJSONObject3, "assistant_action"));
                                b(driveStep, optJSONObject3);
                                a(driveStep, optJSONObject3);
                                arrayList2.add(driveStep);
                            } else {
                                jSONArray2 = optJSONArray;
                            }
                            i2++;
                            optJSONArray = jSONArray2;
                        }
                        jSONArray = optJSONArray;
                        drivePath.setSteps(arrayList2);
                        b(drivePath, arrayList2);
                        arrayList.add(drivePath);
                        i++;
                        optJSONArray = jSONArray;
                    }
                }
                jSONArray = optJSONArray;
                i++;
                optJSONArray = jSONArray;
            }
            driveRouteResult.setPaths(arrayList);
            return driveRouteResult;
        } catch (JSONException e) {
            i.a(e, "JSONHelper", "parseDriveRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        } catch (Throwable th) {
            i.a(th, "JSONHelper", "parseDriveRouteThrowable");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void a(DriveStep driveStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("tmcs");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    TMC tmc = new TMC();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        tmc.setDistance(n(a(optJSONObject, "distance")));
                        tmc.setStatus(a(optJSONObject, "status"));
                        tmc.setPolyline(c(optJSONObject, "polyline"));
                        arrayList.add(tmc);
                    }
                }
                driveStep.setTMCs(arrayList);
            }
        } catch (JSONException e) {
            i.a(e, "JSONHelper", "parseTMCs");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void b(DriveStep driveStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("cities");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    RouteSearchCity routeSearchCity = new RouteSearchCity();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        routeSearchCity.setSearchCityName(a(optJSONObject, "name"));
                        routeSearchCity.setSearchCitycode(a(optJSONObject, "citycode"));
                        routeSearchCity.setSearchCityhAdCode(a(optJSONObject, "adcode"));
                        a(routeSearchCity, optJSONObject);
                        arrayList.add(routeSearchCity);
                    }
                }
                driveStep.setRouteSearchCityList(arrayList);
            }
        } catch (JSONException e) {
            i.a(e, "JSONHelper", "parseCrossCity");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void a(RouteSearchCity routeSearchCity, JSONObject jSONObject) throws AMapException {
        if (jSONObject.has("districts")) {
            try {
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("districts");
                if (optJSONArray == null) {
                    routeSearchCity.setDistricts(arrayList);
                    return;
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    District district = new District();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        district.setDistrictName(a(optJSONObject, "name"));
                        district.setDistrictAdcode(a(optJSONObject, "adcode"));
                        arrayList.add(district);
                    }
                }
                routeSearchCity.setDistricts(arrayList);
            } catch (JSONException e) {
                i.a(e, "JSONHelper", "parseCrossDistricts");
                throw new AMapException("协议解析错误 - ProtocolException");
            }
        }
    }

    public static WalkRouteResult c(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            WalkRouteResult walkRouteResult = new WalkRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            walkRouteResult.setStartPos(b(optJSONObject, "origin"));
            walkRouteResult.setTargetPos(b(optJSONObject, "destination"));
            if (!optJSONObject.has("paths")) {
                return walkRouteResult;
            }
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
            if (optJSONArray == null) {
                walkRouteResult.setPaths(arrayList);
                return walkRouteResult;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                WalkPath walkPath = new WalkPath();
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    walkPath.setDistance(o(a(optJSONObject2, "distance")));
                    walkPath.setDuration(q(a(optJSONObject2, "duration")));
                    if (optJSONObject2.has("steps")) {
                        JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                        ArrayList arrayList2 = new ArrayList();
                        if (optJSONArray2 != null) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                WalkStep walkStep = new WalkStep();
                                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                                if (optJSONObject3 != null) {
                                    walkStep.setInstruction(a(optJSONObject3, "instruction"));
                                    walkStep.setOrientation(a(optJSONObject3, "orientation"));
                                    walkStep.setRoad(a(optJSONObject3, "road"));
                                    walkStep.setDistance(o(a(optJSONObject3, "distance")));
                                    walkStep.setDuration(o(a(optJSONObject3, "duration")));
                                    walkStep.setPolyline(c(optJSONObject3, "polyline"));
                                    walkStep.setAction(a(optJSONObject3, "action"));
                                    walkStep.setAssistantAction(a(optJSONObject3, "assistant_action"));
                                    arrayList2.add(walkStep);
                                }
                            }
                            walkPath.setSteps(arrayList2);
                            a(walkPath, arrayList2);
                        }
                    }
                    arrayList.add(walkPath);
                }
            }
            walkRouteResult.setPaths(arrayList);
            return walkRouteResult;
        } catch (JSONException e) {
            i.a(e, "JSONHelper", "parseWalkRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static LocalWeatherLive d(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("lives")) {
                return null;
            }
            LocalWeatherLive localWeatherLive = new LocalWeatherLive();
            JSONArray optJSONArray = jSONObject.optJSONArray("lives");
            if (optJSONArray != null) {
                if (optJSONArray.length() > 0) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(0);
                    if (optJSONObject == null) {
                        return localWeatherLive;
                    }
                    localWeatherLive.setAdCode(a(optJSONObject, "adcode"));
                    localWeatherLive.setProvince(a(optJSONObject, "province"));
                    localWeatherLive.setCity(a(optJSONObject, "city"));
                    localWeatherLive.setWeather(a(optJSONObject, "weather"));
                    localWeatherLive.setTemperature(a(optJSONObject, "temperature"));
                    localWeatherLive.setWindDirection(a(optJSONObject, "winddirection"));
                    localWeatherLive.setWindPower(a(optJSONObject, "windpower"));
                    localWeatherLive.setHumidity(a(optJSONObject, "humidity"));
                    localWeatherLive.setReportTime(a(optJSONObject, "reporttime"));
                }
            }
            return localWeatherLive;
        } catch (JSONException e) {
            i.a(e, "JSONHelper", "WeatherForecastResult");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static LocalWeatherForecast e(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("forecasts")) {
                return null;
            }
            LocalWeatherForecast localWeatherForecast = new LocalWeatherForecast();
            JSONArray jSONArray = jSONObject.getJSONArray("forecasts");
            if (jSONArray != null) {
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    if (optJSONObject == null) {
                        return localWeatherForecast;
                    }
                    localWeatherForecast.setCity(a(optJSONObject, "city"));
                    localWeatherForecast.setAdCode(a(optJSONObject, "adcode"));
                    localWeatherForecast.setProvince(a(optJSONObject, "province"));
                    localWeatherForecast.setReportTime(a(optJSONObject, "reporttime"));
                    if (!optJSONObject.has("casts")) {
                        return localWeatherForecast;
                    }
                    ArrayList arrayList = new ArrayList();
                    JSONArray optJSONArray = optJSONObject.optJSONArray("casts");
                    if (optJSONArray != null) {
                        if (optJSONArray.length() > 0) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                LocalDayWeatherForecast localDayWeatherForecast = new LocalDayWeatherForecast();
                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                                if (optJSONObject2 != null) {
                                    localDayWeatherForecast.setDate(a(optJSONObject2, "date"));
                                    localDayWeatherForecast.setWeek(a(optJSONObject2, "week"));
                                    localDayWeatherForecast.setDayWeather(a(optJSONObject2, "dayweather"));
                                    localDayWeatherForecast.setNightWeather(a(optJSONObject2, "nightweather"));
                                    localDayWeatherForecast.setDayTemp(a(optJSONObject2, "daytemp"));
                                    localDayWeatherForecast.setNightTemp(a(optJSONObject2, "nighttemp"));
                                    localDayWeatherForecast.setDayWindDirection(a(optJSONObject2, "daywind"));
                                    localDayWeatherForecast.setNightWindDirection(a(optJSONObject2, "nightwind"));
                                    localDayWeatherForecast.setDayWindPower(a(optJSONObject2, "daypower"));
                                    localDayWeatherForecast.setNightWindPower(a(optJSONObject2, "nightpower"));
                                    arrayList.add(localDayWeatherForecast);
                                }
                            }
                            localWeatherForecast.setWeatherForecast(arrayList);
                            return localWeatherForecast;
                        }
                    }
                    localWeatherForecast.setWeatherForecast(arrayList);
                }
            }
            return localWeatherForecast;
        } catch (JSONException e) {
            i.a(e, "JSONHelper", "WeatherForecastResult");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static String a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str) && !jSONObject.optString(str).equals("[]")) {
            return jSONObject.optString(str).trim();
        }
        return "";
    }

    private static LatLonPoint b(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str)) {
            return m(jSONObject.optString(str));
        }
        return null;
    }

    private static ArrayList<LatLonPoint> c(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return l(jSONObject.optString(str));
        }
        return null;
    }

    private static ArrayList<LatLonPoint> l(String str) {
        String[] split;
        ArrayList<LatLonPoint> arrayList = new ArrayList<>();
        for (String str2 : str.split(";")) {
            arrayList.add(m(str2));
        }
        return arrayList;
    }

    private static LatLonPoint m(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return null;
        }
        String[] split = str.split(",| ");
        if (split.length != 2) {
            return null;
        }
        return new LatLonPoint(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
    }

    public static boolean f(String str) {
        return str == null || str.equals("");
    }

    private static int n(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            i.a(e, "JSONHelper", "str2int");
            return 0;
        }
    }

    private static float o(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            i.a(e, "JSONHelper", "str2float");
            return 0.0f;
        }
    }

    private static double p(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0.0d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            i.a(e, "JSONHelper", "str2float");
            return 0.0d;
        }
    }

    private static long q(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            i.a(e, "JSONHelper", "str2long");
            return 0;
        }
    }

    private static boolean r(String str) {
        if (str == null || str.equals("") || str.equals("[]") || str.equals("0") || !str.equals("1")) {
            return false;
        }
        return true;
    }

    public static void c(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            AoiItem aoiItem = new AoiItem();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                aoiItem.setId(a(optJSONObject, "id"));
                aoiItem.setName(a(optJSONObject, "name"));
                aoiItem.setAdcode(a(optJSONObject, "adcode"));
                aoiItem.setLocation(b(optJSONObject, "location"));
                aoiItem.setArea(Float.valueOf(o(a(optJSONObject, "area"))));
                arrayList.add(aoiItem);
            }
        }
        regeocodeAddress.setAois(arrayList);
    }

    private static List<Photo> x(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || !jSONObject.has("photos")) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("photos");
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            Photo photo = new Photo();
            photo.setTitle(a(optJSONObject, "title"));
            photo.setUrl(a(optJSONObject, "url"));
            arrayList.add(photo);
        }
        return arrayList;
    }

    public static ArrayList<RoutePOIItem> i(JSONObject jSONObject) throws JSONException {
        ArrayList<RoutePOIItem> arrayList = new ArrayList<>();
        Object opt = jSONObject.opt("pois");
        if (opt instanceof JSONArray) {
            JSONArray optJSONArray = jSONObject.optJSONArray("pois");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return arrayList;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(y(optJSONObject));
                }
            }
        } else if (opt instanceof JSONObject) {
            arrayList.add(y(((JSONObject) opt).optJSONObject("poi")));
        }
        return arrayList;
    }

    private static RoutePOIItem y(JSONObject jSONObject) throws JSONException {
        RoutePOIItem routePOIItem = new RoutePOIItem();
        routePOIItem.setID(a(jSONObject, "id"));
        routePOIItem.setTitle(a(jSONObject, "name"));
        routePOIItem.setPoint(b(jSONObject, "location"));
        routePOIItem.setDistance(o(a(jSONObject, "distance")));
        routePOIItem.setDuration(o(a(jSONObject, "duration")));
        return routePOIItem;
    }

    public static RideRouteResult g(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("data")) {
                return null;
            }
            RideRouteResult rideRouteResult = new RideRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            rideRouteResult.setStartPos(b(optJSONObject, "origin"));
            rideRouteResult.setTargetPos(b(optJSONObject, "destination"));
            ArrayList arrayList = new ArrayList();
            Object opt = optJSONObject.opt("paths");
            if (opt == null) {
                rideRouteResult.setPaths(arrayList);
                return rideRouteResult;
            }
            if (opt instanceof JSONArray) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    RidePath z = z(optJSONArray.optJSONObject(i));
                    if (z != null) {
                        arrayList.add(z);
                    }
                }
            } else if (opt instanceof JSONObject) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("paths");
                if (!optJSONObject2.has("path")) {
                    rideRouteResult.setPaths(arrayList);
                    return rideRouteResult;
                }
                RidePath z2 = z(optJSONObject2.optJSONObject("path"));
                if (z2 != null) {
                    arrayList.add(z2);
                }
            }
            rideRouteResult.setPaths(arrayList);
            return rideRouteResult;
        } catch (JSONException e) {
            i.a(e, "JSONHelper", "parseRideRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static RidePath z(JSONObject jSONObject) throws AMapException {
        RidePath ridePath = new RidePath();
        if (jSONObject == null) {
            return null;
        }
        try {
            ridePath.setDistance(o(a(jSONObject, "distance")));
            ridePath.setDuration(q(a(jSONObject, "duration")));
            if (jSONObject.has("steps")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("steps");
                ArrayList arrayList = new ArrayList();
                if (optJSONArray == null) {
                    return null;
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    RideStep rideStep = new RideStep();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        rideStep.setInstruction(a(optJSONObject, "instruction"));
                        rideStep.setOrientation(a(optJSONObject, "orientation"));
                        rideStep.setRoad(a(optJSONObject, "road"));
                        rideStep.setDistance(o(a(optJSONObject, "distance")));
                        rideStep.setDuration(o(a(optJSONObject, "duration")));
                        rideStep.setPolyline(c(optJSONObject, "polyline"));
                        rideStep.setAction(a(optJSONObject, "action"));
                        rideStep.setAssistantAction(a(optJSONObject, "assistant_action"));
                        arrayList.add(rideStep);
                    }
                }
                ridePath.setSteps(arrayList);
                c(ridePath, arrayList);
            }
            return ridePath;
        } catch (JSONException e) {
            i.a(e, "JSONHelper", "parseRidePath");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static DistanceResult h(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("results")) {
                return null;
            }
            DistanceResult distanceResult = new DistanceResult();
            JSONArray optJSONArray = jSONObject.optJSONArray("results");
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                DistanceItem distanceItem = new DistanceItem();
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                distanceItem.setOriginId(n(a(jSONObject2, "origin_id")));
                distanceItem.setDestId(n(a(jSONObject2, "dest_id")));
                distanceItem.setDistance(o(a(jSONObject2, "distance")));
                distanceItem.setDuration(o(a(jSONObject2, "duration")));
                String a2 = a(jSONObject2, "info");
                if (!TextUtils.isEmpty(a2)) {
                    distanceItem.setErrorInfo(a2);
                    distanceItem.setErrorCode(n(a(jSONObject2, "code")));
                }
                arrayList.add(distanceItem);
            }
            distanceResult.setDistanceResults(arrayList);
            return distanceResult;
        } catch (JSONException e) {
            i.a(e, "JSONHelper", "parseRouteDistance");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static TruckRouteRestult i(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("data")) {
                return null;
            }
            TruckRouteRestult truckRouteRestult = new TruckRouteRestult();
            JSONObject optJSONObject = jSONObject.optJSONObject("data").optJSONObject("route");
            truckRouteRestult.setStartPos(b(optJSONObject, "origin"));
            truckRouteRestult.setTargetPos(b(optJSONObject, "destination"));
            if (!optJSONObject.has("paths") || (optJSONArray = optJSONObject.optJSONArray("paths")) == null) {
                return truckRouteRestult;
            }
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                TruckPath truckPath = new TruckPath();
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                truckPath.setDistance(o(a(jSONObject2, "distance")));
                truckPath.setDuration(q(a(jSONObject2, "duration")));
                truckPath.setStrategy(a(jSONObject2, "strategy"));
                truckPath.setTolls(o(a(jSONObject2, "tolls")));
                truckPath.setTollDistance(o(a(jSONObject2, "toll_distance")));
                truckPath.setTotalTrafficlights(n(a(jSONObject2, "traffic_lights")));
                truckPath.setRestriction(n(a(jSONObject2, "restriction")));
                JSONArray optJSONArray2 = jSONObject2.optJSONArray("steps");
                if (optJSONArray2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        TruckStep truckStep = new TruckStep();
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                        if (optJSONObject2 != null) {
                            truckStep.setInstruction(a(optJSONObject2, "instruction"));
                            truckStep.setOrientation(a(optJSONObject2, "orientation"));
                            truckStep.setRoad(a(optJSONObject2, "road"));
                            truckStep.setDistance(o(a(optJSONObject2, "distance")));
                            truckStep.setTolls(o(a(optJSONObject2, "tolls")));
                            truckStep.setTollDistance(o(a(optJSONObject2, "toll_distance")));
                            truckStep.setTollRoad(a(optJSONObject2, "toll_road"));
                            truckStep.setDuration(o(a(optJSONObject2, "duration")));
                            truckStep.setPolyline(c(optJSONObject2, "polyline"));
                            truckStep.setAction(a(optJSONObject2, "action"));
                            truckStep.setAssistantAction(a(optJSONObject2, "assistant_action"));
                            a(truckStep, optJSONObject2);
                            b(truckStep, optJSONObject2);
                            arrayList2.add(truckStep);
                        }
                    }
                    truckPath.setSteps(arrayList2);
                    arrayList.add(truckPath);
                }
            }
            truckRouteRestult.setPaths(arrayList);
            return truckRouteRestult;
        } catch (JSONException e) {
            i.a(e, "JSONHelper", "parseTruckRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void a(TruckStep truckStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("cities");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    RouteSearchCity routeSearchCity = new RouteSearchCity();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        routeSearchCity.setSearchCityName(a(optJSONObject, "name"));
                        routeSearchCity.setSearchCitycode(a(optJSONObject, "citycode"));
                        routeSearchCity.setSearchCityhAdCode(a(optJSONObject, "adcode"));
                        a(routeSearchCity, optJSONObject);
                        arrayList.add(routeSearchCity);
                    }
                }
                truckStep.setRouteSearchCityList(arrayList);
            }
        } catch (JSONException e) {
            i.a(e, "JSONHelper", "parseCrossCity");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void b(TruckStep truckStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("tmcs");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    TMC tmc = new TMC();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        tmc.setDistance(n(a(optJSONObject, "distance")));
                        tmc.setStatus(a(optJSONObject, "status"));
                        tmc.setPolyline(c(optJSONObject, "polyline"));
                        arrayList.add(tmc);
                    }
                }
                truckStep.setTMCs(arrayList);
            }
        } catch (JSONException e) {
            i.a(e, "JSONHelper", "parseTMCs");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:71:0x01a4 A[Catch:{ JSONException -> 0x021d, all -> 0x021b }] */
    public static DriveRoutePlanResult j(String str) throws AMapException {
        String str2;
        JSONException e;
        String str3;
        Throwable th;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        JSONArray jSONArray;
        String str4;
        JSONArray jSONArray2;
        String str5;
        int i;
        JSONArray optJSONArray3;
        JSONArray jSONArray3;
        String str6;
        JSONArray jSONArray4;
        JSONArray jSONArray5;
        String str7 = "starttime";
        String str8 = "协议解析错误 - ProtocolException";
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                jSONObject.optInt("errcode");
                jSONObject.optString("errmsg");
                jSONObject.optString("errdetail");
            }
            if (!jSONObject.has("data")) {
                return null;
            }
            DriveRoutePlanResult driveRoutePlanResult = new DriveRoutePlanResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null || !optJSONObject.has("paths") || (optJSONArray = optJSONObject.optJSONArray("paths")) == null) {
                return driveRoutePlanResult;
            }
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < optJSONArray.length()) {
                DrivePlanPath drivePlanPath = new DrivePlanPath();
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                if (optJSONObject2 != null) {
                    drivePlanPath.setDistance(o(a(optJSONObject2, "distance")));
                    drivePlanPath.setTrafficLights(n(a(optJSONObject2, "traffic_lights")));
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("steps");
                    if (optJSONArray4 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        int i3 = 0;
                        while (i3 < optJSONArray4.length()) {
                            DrivePlanStep drivePlanStep = new DrivePlanStep();
                            JSONObject optJSONObject3 = optJSONArray4.optJSONObject(i3);
                            if (optJSONObject3 != null) {
                                jSONArray5 = optJSONArray4;
                                drivePlanStep.setAdCode(a(optJSONObject3, "adcode"));
                                drivePlanStep.setRoad(a(optJSONObject3, "road"));
                                drivePlanStep.setDistance(o(a(optJSONObject3, "distance")));
                                str3 = str8;
                                try {
                                    drivePlanStep.setToll(n(a(optJSONObject3, "toll")) == 1);
                                    drivePlanStep.setPolyline(c(optJSONObject3, "polyline"));
                                    arrayList2.add(drivePlanStep);
                                } catch (JSONException e2) {
                                    e = e2;
                                    str2 = str3;
                                    i.a(e, "JSONHelper", "parseDriveRoute");
                                    throw new AMapException(str2);
                                } catch (Throwable th2) {
                                    th = th2;
                                    i.a(th, "JSONHelper", "parseDriveRouteThrowable");
                                    throw new AMapException(str3);
                                }
                            } else {
                                str3 = str8;
                                jSONArray5 = optJSONArray4;
                            }
                            i3++;
                            optJSONArray = optJSONArray;
                            optJSONArray4 = jSONArray5;
                            str8 = str3;
                        }
                        jSONArray4 = optJSONArray;
                        str6 = str8;
                        drivePlanPath.setSteps(arrayList2);
                        arrayList.add(drivePlanPath);
                        i2++;
                        optJSONArray = jSONArray4;
                        str8 = str6;
                    }
                }
                jSONArray4 = optJSONArray;
                str6 = str8;
                i2++;
                optJSONArray = jSONArray4;
                str8 = str6;
            }
            driveRoutePlanResult.setPaths(arrayList);
            if (!optJSONObject.has("time_infos") || (optJSONArray2 = optJSONObject.optJSONArray("time_infos")) == null) {
                return driveRoutePlanResult;
            }
            ArrayList arrayList3 = new ArrayList();
            int i4 = 0;
            while (i4 < optJSONArray2.length()) {
                TimeInfo timeInfo = new TimeInfo();
                JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i4);
                if (optJSONObject4 != null) {
                    if (!optJSONObject4.has(str7)) {
                        return driveRoutePlanResult;
                    }
                    timeInfo.setStartTime(q(a(optJSONObject4, str7)));
                    JSONArray optJSONArray5 = optJSONObject4.optJSONArray("elements");
                    if (optJSONArray5 != null) {
                        ArrayList arrayList4 = new ArrayList();
                        int i5 = 0;
                        while (i5 < optJSONArray5.length()) {
                            TimeInfosElement timeInfosElement = new TimeInfosElement();
                            JSONObject optJSONObject5 = optJSONArray5.optJSONObject(i5);
                            if (optJSONObject5 != null) {
                                timeInfosElement.setPathindex(n(a(optJSONObject5, "pathindex")));
                                timeInfosElement.setDuration(o(a(optJSONObject5, "duration")));
                                timeInfosElement.setTolls(o(a(optJSONObject5, "tolls")));
                                int n = n(a(optJSONObject5, "restriction"));
                                if (n != 2) {
                                    if (n != -1) {
                                        i = 1;
                                        timeInfosElement.setRestriction(i);
                                        optJSONArray3 = optJSONObject5.optJSONArray("tmcs");
                                        if (optJSONArray3 != null) {
                                            ArrayList arrayList5 = new ArrayList();
                                            str5 = str7;
                                            int i6 = 0;
                                            while (i6 < optJSONArray3.length()) {
                                                TMC tmc = new TMC();
                                                JSONObject optJSONObject6 = optJSONArray3.optJSONObject(i6);
                                                if (optJSONObject6 != null) {
                                                    jSONArray3 = optJSONArray3;
                                                    tmc.setStatus(a(optJSONObject6, "status"));
                                                    tmc.setDistance(n(a(optJSONObject6, "distance")));
                                                    tmc.setPolyline(c(optJSONObject6, "polyline"));
                                                    arrayList5.add(tmc);
                                                } else {
                                                    jSONArray3 = optJSONArray3;
                                                }
                                                i6++;
                                                optJSONArray2 = optJSONArray2;
                                                optJSONArray3 = jSONArray3;
                                            }
                                            jSONArray2 = optJSONArray2;
                                            timeInfosElement.setTMCs(arrayList5);
                                            arrayList4.add(timeInfosElement);
                                            i5++;
                                            str7 = str5;
                                            optJSONArray2 = jSONArray2;
                                        }
                                    }
                                }
                                i = 0;
                                timeInfosElement.setRestriction(i);
                                optJSONArray3 = optJSONObject5.optJSONArray("tmcs");
                                if (optJSONArray3 != null) {
                                }
                            }
                            str5 = str7;
                            jSONArray2 = optJSONArray2;
                            i5++;
                            str7 = str5;
                            optJSONArray2 = jSONArray2;
                        }
                        str4 = str7;
                        jSONArray = optJSONArray2;
                        timeInfo.setElements(arrayList4);
                        arrayList3.add(timeInfo);
                        i4++;
                        str7 = str4;
                        optJSONArray2 = jSONArray;
                    }
                }
                str4 = str7;
                jSONArray = optJSONArray2;
                i4++;
                str7 = str4;
                optJSONArray2 = jSONArray;
            }
            driveRoutePlanResult.setTimeInfos(arrayList3);
            return driveRoutePlanResult;
        } catch (JSONException e3) {
            e = e3;
            str2 = str8;
            i.a(e, "JSONHelper", "parseDriveRoute");
            throw new AMapException(str2);
        } catch (Throwable th3) {
            th = th3;
            str3 = str8;
            i.a(th, "JSONHelper", "parseDriveRouteThrowable");
            throw new AMapException(str3);
        }
    }

    private static void a(Path path, List<WalkStep> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (WalkStep walkStep : list) {
            if (!(walkStep == null || walkStep.getPolyline() == null)) {
                polyline.addAll(walkStep.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }

    private static void b(Path path, List<DriveStep> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (DriveStep driveStep : list) {
            if (!(driveStep == null || driveStep.getPolyline() == null)) {
                polyline.addAll(driveStep.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }

    private static void c(Path path, List<RideStep> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        if (polyline == null) {
            polyline = new ArrayList<>();
        }
        for (RideStep rideStep : list) {
            if (!(rideStep == null || rideStep.getPolyline() == null)) {
                polyline.addAll(rideStep.getPolyline());
            }
        }
        path.setPolyline(polyline);
    }
}
