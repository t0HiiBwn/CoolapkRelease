package com.amap.api.mapcore2d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.util.Log;
import com.amap.api.mapcore2d.da;
import com.amap.api.maps2d.MapsInitializer;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.LatLng;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/* compiled from: Util */
public class cm {
    public static double[] a = {7453.642d, 3742.9905d, 1873.333d, 936.89026d, 468.472d, 234.239d, 117.12d, 58.56d, 29.28d, 14.64d, 7.32d, 3.66d, 1.829d, 0.915d, 0.4575d, 0.228d, 0.1144d};

    public static double a(double d, double d2, double d3, double d4, double d5, double d6) {
        return ((d3 - d) * (d6 - d2)) - ((d5 - d) * (d4 - d2));
    }

    public static float a(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        if (f > 45.0f) {
            return 45.0f;
        }
        return f;
    }

    public static boolean a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = d3 - d;
        double d10 = d8 - d6;
        double d11 = d4 - d2;
        double d12 = d7 - d5;
        double d13 = (d9 * d10) - (d11 * d12);
        if (d13 != 0.0d) {
            double d14 = d2 - d6;
            double d15 = d - d5;
            double d16 = ((d12 * d14) - (d10 * d15)) / d13;
            double d17 = ((d14 * d9) - (d15 * d11)) / d13;
            if (d16 >= 0.0d && d16 <= 1.0d && d17 >= 0.0d && d17 <= 1.0d) {
                return true;
            }
        }
        return false;
    }

    public static Bitmap a(String str) {
        try {
            if (ar.a != null) {
                InputStream open = ar.a.getAssets().open(str);
                Bitmap decodeStream = BitmapFactory.decodeStream(open);
                open.close();
                return decodeStream;
            }
            InputStream resourceAsStream = BitmapDescriptorFactory.class.getResourceAsStream("/assets/" + str);
            Bitmap decodeStream2 = BitmapFactory.decodeStream(resourceAsStream);
            resourceAsStream.close();
            return decodeStream2;
        } catch (Throwable th) {
            a(th, "Util", "fromAsset");
            return null;
        }
    }

    public static String a(String str, Object obj) {
        return str + "=" + String.valueOf(obj);
    }

    public static float b(float f) {
        int i;
        if (f > ((float) q.c)) {
            i = q.c;
        } else if (f >= ((float) q.d)) {
            return f;
        } else {
            i = q.d;
        }
        return (float) i;
    }

    public static String a(String... strArr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : strArr) {
            sb.append(str);
            if (i != strArr.length - 1) {
                sb.append(",");
            }
            i++;
        }
        return sb.toString();
    }

    public static int a(Object[] objArr) {
        return Arrays.hashCode(objArr);
    }

    public static Bitmap a(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        try {
            return Bitmap.createScaledBitmap(bitmap, (int) (((float) bitmap.getWidth()) * f), (int) (((float) bitmap.getHeight()) * f), true);
        } catch (Throwable th) {
            a(th, "Util", "zoomBitmap");
            return null;
        }
    }

    public static double a(LatLng latLng, LatLng latLng2) {
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
        return Math.asin(Math.sqrt((((dArr[0] - dArr2[0]) * (dArr[0] - dArr2[0])) + ((dArr[1] - dArr2[1]) * (dArr[1] - dArr2[1]))) + ((dArr[2] - dArr2[2]) * (dArr[2] - dArr2[2]))) / 2.0d) * 1.27420015798544E7d;
    }

    public static String a(int i) {
        if (i < 1000) {
            return i + "m";
        }
        return (i / 1000) + "km";
    }

    public static w a(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return new w((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a1, code lost:
        if (r4 > r0) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00bc, code lost:
        if (r0 > r4) goto L_0x00a3;
     */
    public static boolean a(LatLng latLng, List<LatLng> list) {
        double d;
        List<LatLng> list2 = list;
        double d2 = latLng.longitude;
        double d3 = latLng.latitude;
        double d4 = latLng.latitude;
        if (list.size() < 3) {
            return false;
        }
        if (!list2.get(0).equals(list2.get(list.size() - 1))) {
            list2.add(list2.get(0));
        }
        int i = 0;
        int i2 = 0;
        while (i < list.size() - 1) {
            double d5 = list2.get(i).longitude;
            double d6 = list2.get(i).latitude;
            int i3 = i + 1;
            double d7 = list2.get(i3).longitude;
            double d8 = list2.get(i3).latitude;
            if (b(d2, d3, d5, d6, d7, d8)) {
                return true;
            }
            if (Math.abs(d8 - d6) >= 1.0E-9d) {
                if (!b(d5, d6, d2, d3, 180.0d, d4)) {
                    if (!b(d7, d8, d2, d3, 180.0d, d4)) {
                        d = d2;
                        if (a(d5, d6, d7, d8, d2, d3, 180.0d, d4)) {
                            i2++;
                        }
                        d2 = d;
                        d4 = d4;
                        d3 = d3;
                        i = i3;
                        list2 = list;
                    }
                }
                i2++;
            }
            d = d2;
            d2 = d;
            d4 = d4;
            d3 = d3;
            i = i3;
            list2 = list;
        }
        return i2 % 2 != 0;
    }

    public static boolean b(double d, double d2, double d3, double d4, double d5, double d6) {
        return Math.abs(a(d, d2, d3, d4, d5, d6)) < 1.0E-9d && (d - d3) * (d - d5) <= 0.0d && (d2 - d4) * (d2 - d6) <= 0.0d;
    }

    public static synchronized boolean a(Context context) {
        synchronized (cm.class) {
            if (context == null) {
                return false;
            }
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    return false;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return false;
                }
                NetworkInfo.State state = activeNetworkInfo.getState();
                if (state == null || state == NetworkInfo.State.DISCONNECTED || state == NetworkInfo.State.DISCONNECTING) {
                    return false;
                }
                return true;
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Throwable th, String str, String str2) {
        try {
            Cdo e = Cdo.e();
            if (e != null) {
                e.b(th, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static String b(Context context) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return context.getFilesDir().getPath();
        }
        if (MapsInitializer.sdcardDir == null || MapsInitializer.sdcardDir.equals("")) {
            File file = new File(Environment.getExternalStorageDirectory(), "AMap");
            if (!file.exists()) {
                file.mkdir();
            }
            return file.toString() + "/";
        }
        File file2 = new File(MapsInitializer.sdcardDir);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File file3 = new File(file2, "Amap");
        if (!file3.exists()) {
            file3.mkdir();
        }
        return file3.toString() + "/";
    }

    public static boolean a(File file) throws IOException, Exception {
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return true;
        }
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isFile()) {
                if (!listFiles[i].delete()) {
                    return false;
                }
            } else if (!a(listFiles[i])) {
                return false;
            } else {
                listFiles[i].delete();
            }
        }
        return true;
    }

    public static da a() {
        try {
            if (q.p == null) {
                return new da.a("2dmap", "6.0.0", "AMAP_SDK_Android_2DMap_6.0.0").a(new String[]{"com.amap.api.maps2d", "com.amap.api.mapcore2d"}).a("6.0.0").a();
            }
            return q.p;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean a(int i, int i2) {
        if (i > 0 && i2 > 0) {
            return true;
        }
        Log.w("2dmap", "the map must have a size");
        return false;
    }
}
