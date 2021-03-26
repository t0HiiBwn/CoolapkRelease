package com.amap.api.mapcore2d;

import com.amap.api.mapcore2d.da;
import com.autonavi.amap.mapcore2d.Inner_3dMap_location;

/* compiled from: Util */
public final class gk {
    static da a = null;
    private static final String[] b = {"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core"};
    private static final String[] c = {"com.amap.api.mapcore2d", "com.amap.api.maps2d"};
    private static final String[] d = {"com.amap.trace"};

    public static da a() throws cp {
        Class<?> cls;
        Class<?> cls2;
        da a2;
        da daVar = a;
        if (daVar != null) {
            return daVar;
        }
        try {
            cls = Class.forName("com.amap.api.maps.MapsInitializer");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                String str = (String) gw.a(cls, "getVersion", (Object[]) null, (Class<?>[]) null);
                a2 = new da.a("3dmap", str, "AMAP_SDK_Android_Map_" + str).a(b).a();
            } catch (Throwable unused2) {
            }
        } else {
            cls = Class.forName("com.amap.api.maps2d.MapsInitializer");
            String str2 = (String) gw.a(cls, "getVersion", (Object[]) null, (Class<?>[]) null);
            a2 = new da.a("2dmap", str2, "AMAP_SDK_Android_2DMap_" + str2).a(c).a();
        }
        a = a2;
        if (cls == null) {
            try {
                cls2 = Class.forName("com.amap.trace.AMapTraceClient");
            } catch (Throwable unused3) {
                cls2 = null;
            }
            if (cls2 != null) {
                try {
                    String str3 = (String) gw.a(cls2, "getVersion", (Object[]) null, (Class<?>[]) null);
                    a = new da.a("trace", str3, "AMAP_TRACE_Android_" + str3).a(d).a();
                } catch (Throwable unused4) {
                }
            }
        }
        return a;
    }

    public static boolean a(gg ggVar) {
        if (ggVar != null && !ggVar.d().equals("8") && !ggVar.d().equals("5") && !ggVar.d().equals("6")) {
            return a((Inner_3dMap_location) ggVar);
        }
        return false;
    }

    public static boolean a(Inner_3dMap_location inner_3dMap_location) {
        double longitude = inner_3dMap_location.getLongitude();
        double latitude = inner_3dMap_location.getLatitude();
        return !(longitude == 0.0d && latitude == 0.0d) && longitude <= 180.0d && latitude <= 90.0d && longitude >= -180.0d && latitude >= -90.0d;
    }
}
