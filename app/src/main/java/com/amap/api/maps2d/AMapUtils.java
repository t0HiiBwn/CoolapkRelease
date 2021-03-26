package com.amap.api.maps2d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.amap.api.mapcore2d.cp;
import com.amap.api.mapcore2d.cq;
import com.amap.api.mapcore2d.cs;
import com.amap.api.mapcore2d.da;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.NaviPara;
import com.amap.api.maps2d.model.PoiPara;
import com.amap.api.maps2d.model.RoutePara;
import java.util.Locale;

public class AMapUtils {
    public static final int BUS_COMFORT = 4;
    public static final int BUS_MONEY_LITTLE = 1;
    public static final int BUS_NO_SUBWAY = 5;
    public static final int BUS_TIME_FIRST = 0;
    public static final int BUS_TRANSFER_LITTLE = 2;
    public static final int BUS_WALK_LITTLE = 3;
    public static final int DRIVING_AVOID_CONGESTION = 4;
    public static final int DRIVING_DEFAULT = 0;
    public static final int DRIVING_NO_HIGHWAY = 3;
    public static final int DRIVING_NO_HIGHWAY_AVOID_CONGESTION = 6;
    public static final int DRIVING_NO_HIGHWAY_AVOID_SHORT_MONEY = 5;
    public static final int DRIVING_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 8;
    public static final int DRIVING_SAVE_MONEY = 1;
    public static final int DRIVING_SAVE_MONEY_AVOID_CONGESTION = 7;
    public static final int DRIVING_SHORT_DISTANCE = 2;

    public static float calculateLineDistance(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            try {
                throw new AMapException("非法坐标值");
            } catch (AMapException e) {
                e.printStackTrace();
                return 0.0f;
            }
        } else {
            double d = latLng.longitude;
            double d2 = d * 0.01745329251994329d;
            double d3 = latLng.latitude * 0.01745329251994329d;
            double d4 = latLng2.longitude * 0.01745329251994329d;
            double d5 = latLng2.latitude * 0.01745329251994329d;
            double sin = Math.sin(d2);
            double sin2 = Math.sin(d3);
            double cos = Math.cos(d2);
            double cos2 = Math.cos(d3);
            double sin3 = Math.sin(d4);
            double sin4 = Math.sin(d5);
            double cos3 = Math.cos(d4);
            double cos4 = Math.cos(d5);
            double[] dArr = {cos * cos2, cos2 * sin, sin2};
            double[] dArr2 = {cos3 * cos4, cos4 * sin3, sin4};
            return (float) (Math.asin(Math.sqrt((((dArr[0] - dArr2[0]) * (dArr[0] - dArr2[0])) + ((dArr[1] - dArr2[1]) * (dArr[1] - dArr2[1]))) + ((dArr[2] - dArr2[2]) * (dArr[2] - dArr2[2]))) / 2.0d) * 1.27420015798544E7d);
        }
    }

    public static float calculateArea(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            try {
                throw new AMapException("非法坐标值");
            } catch (AMapException e) {
                e.printStackTrace();
                return 0.0f;
            }
        } else {
            double sin = Math.sin((latLng.latitude * 3.141592653589793d) / 180.0d) - Math.sin((latLng2.latitude * 3.141592653589793d) / 180.0d);
            double d = (latLng2.longitude - latLng.longitude) / 360.0d;
            if (d < 0.0d) {
                d += 1.0d;
            }
            return (float) (2.5560394669790553E14d * sin * d);
        }
    }

    public static void getLatestAMapApp(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(276824064);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("http://wap.amap.com/"));
            new a("glaa", context).start();
            context.startActivity(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void openAMapNavi(NaviPara naviPara, Context context) throws AMapException {
        if (!a(context)) {
            throw new AMapException("移动设备上未安装高德地图或高德地图版本较旧");
        } else if (naviPara.getTargetPoint() != null) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(276824064);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse(a(naviPara, context)));
                intent.setPackage("com.autonavi.minimap");
                new a("oan", context).start();
                context.startActivity(intent);
            } catch (Throwable unused) {
                throw new AMapException("移动设备上未安装高德地图或高德地图版本较旧");
            }
        } else {
            throw new AMapException("非法导航参数");
        }
    }

    public static void openAMapPoiNearbySearch(PoiPara poiPara, Context context) throws AMapException {
        if (!a(context)) {
            throw new AMapException("移动设备上未安装高德地图或高德地图版本较旧");
        } else if (poiPara.getKeywords() == null || poiPara.getKeywords().trim().length() <= 0) {
            throw new AMapException("非法导航参数");
        } else {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(276824064);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse(a(poiPara, context)));
                intent.setPackage("com.autonavi.minimap");
                new a("oan", context).start();
                context.startActivity(intent);
            } catch (Throwable unused) {
                throw new AMapException("移动设备上未安装高德地图或高德地图版本较旧");
            }
        }
    }

    public static void openAMapDrivingRoute(RoutePara routePara, Context context) throws AMapException {
        b(routePara, context, 2);
    }

    public static void openAMapTransitRoute(RoutePara routePara, Context context) throws AMapException {
        b(routePara, context, 1);
    }

    private static String a(PoiPara poiPara, Context context) {
        String format = String.format(Locale.US, "androidamap://arroundpoi?sourceApplication=%s&keywords=%s&dev=0", cq.b(context), poiPara.getKeywords());
        if (poiPara.getCenter() == null) {
            return format;
        }
        return format + "&lat=" + poiPara.getCenter().latitude + "&lon=" + poiPara.getCenter().longitude;
    }

    public static void openAMapWalkingRoute(RoutePara routePara, Context context) throws AMapException {
        b(routePara, context, 4);
    }

    private static String a(RoutePara routePara, Context context, int i) {
        String format = String.format(Locale.US, "androidamap://route?sourceApplication=%s&slat=%f&slon=%f&sname=%s&dlat=%f&dlon=%f&dname=%s&dev=0&t=%d", cq.b(context), Double.valueOf(routePara.getStartPoint().latitude), Double.valueOf(routePara.getStartPoint().longitude), routePara.getStartName(), Double.valueOf(routePara.getEndPoint().latitude), Double.valueOf(routePara.getEndPoint().longitude), routePara.getEndName(), Integer.valueOf(i));
        if (i == 1) {
            return format + "&m=" + routePara.getTransitRouteStyle();
        } else if (i != 2) {
            return format;
        } else {
            return format + "&m=" + routePara.getDrivingRouteStyle();
        }
    }

    private static void b(RoutePara routePara, Context context, int i) throws AMapException {
        if (!a(context)) {
            throw new AMapException("移动设备上未安装高德地图或高德地图版本较旧");
        } else if (a(routePara)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(276824064);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse(a(routePara, context, i)));
                intent.setPackage("com.autonavi.minimap");
                new a("oan", context).start();
                context.startActivity(intent);
            } catch (Throwable unused) {
                throw new AMapException("移动设备上未安装高德地图或高德地图版本较旧");
            }
        } else {
            throw new AMapException("非法导航参数");
        }
    }

    private static boolean a(RoutePara routePara) {
        return (routePara.getStartPoint() == null || routePara.getEndPoint() == null || routePara.getStartName() == null || routePara.getStartName().trim().length() <= 0 || routePara.getEndName() == null || routePara.getEndName().trim().length() <= 0) ? false : true;
    }

    static class a extends Thread {
        String a = "";
        Context b;

        public a(String str, Context context) {
            this.a = str;
            if (context != null) {
                this.b = context.getApplicationContext();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (this.b != null) {
                try {
                    cs.a(this.b, new da.a(this.a, "6.0.0", "AMAP_SDK_Android_2DMap_6.0.0").a(new String[]{"com.amap.api.maps"}).a());
                    interrupt();
                } catch (cp e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static String a(NaviPara naviPara, Context context) {
        return String.format(Locale.US, "androidamap://navi?sourceApplication=%s&lat=%f&lon=%f&dev=0&style=%d", cq.b(context), Double.valueOf(naviPara.getTargetPoint().latitude), Double.valueOf(naviPara.getTargetPoint().longitude), Integer.valueOf(naviPara.getNaviStyle()));
    }

    private static boolean a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.autonavi.minimap", 0) != null;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }
}
