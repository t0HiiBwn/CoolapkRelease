package com.amap.api.location;

import android.content.Context;
import android.text.TextUtils;
import com.loc.ej;
import com.loc.el;
import com.loc.en;
import com.loc.ep;
import org.json.JSONObject;

public class CoordinateConverter {
    private static int b = 0;
    private static int c = 1;
    private static int d = 2;
    private static int e = 4;
    private static int f = 8;
    private static int g = 16;
    private static int h = 32;
    private static int i = 64;
    DPoint a = null;
    private Context j;
    private CoordType k = null;
    private DPoint l = null;

    /* renamed from: com.amap.api.location.CoordinateConverter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CoordType.values().length];
            a = iArr;
            try {
                iArr[CoordType.BAIDU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[CoordType.MAPBAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[CoordType.MAPABC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[CoordType.SOSOMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[CoordType.ALIYUN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[CoordType.GOOGLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[CoordType.GPS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public enum CoordType {
        BAIDU,
        MAPBAR,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE,
        GPS
    }

    public CoordinateConverter(Context context) {
        this.j = context;
    }

    public static float calculateLineDistance(DPoint dPoint, DPoint dPoint2) {
        try {
            return ep.a(dPoint, dPoint2);
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    public static boolean isAMapDataAvailable(double d2, double d3) {
        return ej.a(d2, d3);
    }

    public synchronized DPoint convert() throws Exception {
        int i2;
        int i3;
        DPoint dPoint;
        if (this.k != null) {
            DPoint dPoint2 = this.l;
            if (dPoint2 == null) {
                throw new IllegalArgumentException("转换坐标源不能为空");
            } else if (dPoint2.getLongitude() > 180.0d || this.l.getLongitude() < -180.0d) {
                throw new IllegalArgumentException("请传入合理经度");
            } else if (this.l.getLatitude() > 90.0d || this.l.getLatitude() < -90.0d) {
                throw new IllegalArgumentException("请传入合理纬度");
            } else {
                boolean z = false;
                String str = null;
                switch (AnonymousClass1.a[this.k.ordinal()]) {
                    case 1:
                        this.a = el.a(this.l);
                        i3 = b;
                        i2 = c;
                        if ((i3 & i2) == 0) {
                            str = "baidu";
                            b = i3 | i2;
                            z = true;
                            break;
                        }
                        break;
                    case 2:
                        this.a = el.b(this.j, this.l);
                        i3 = b;
                        i2 = d;
                        if ((i3 & i2) == 0) {
                            str = "mapbar";
                            b = i3 | i2;
                            z = true;
                            break;
                        }
                        break;
                    case 3:
                        int i4 = b;
                        int i5 = e;
                        if ((i4 & i5) == 0) {
                            str = "mapabc";
                            b = i4 | i5;
                            z = true;
                        }
                        dPoint = this.l;
                        this.a = dPoint;
                        break;
                    case 4:
                        int i6 = b;
                        int i7 = f;
                        if ((i6 & i7) == 0) {
                            str = "sosomap";
                            b = i6 | i7;
                            z = true;
                        }
                        dPoint = this.l;
                        this.a = dPoint;
                        break;
                    case 5:
                        int i8 = b;
                        int i9 = g;
                        if ((i8 & i9) == 0) {
                            str = "aliyun";
                            b = i8 | i9;
                            z = true;
                        }
                        dPoint = this.l;
                        this.a = dPoint;
                        break;
                    case 6:
                        int i10 = b;
                        int i11 = h;
                        if ((i10 & i11) == 0) {
                            str = "google";
                            b = i10 | i11;
                            z = true;
                        }
                        dPoint = this.l;
                        this.a = dPoint;
                        break;
                    case 7:
                        int i12 = b;
                        int i13 = i;
                        if ((i12 & i13) == 0) {
                            str = "gps";
                            b = i12 | i13;
                            z = true;
                        }
                        dPoint = el.a(this.j, this.l);
                        this.a = dPoint;
                        break;
                }
                if (z) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("amap_loc_coordinate", str);
                    }
                    en.a(this.j, "O021", jSONObject);
                }
            }
        } else {
            throw new IllegalArgumentException("转换坐标类型不能为空");
        }
        return this.a;
    }

    public synchronized CoordinateConverter coord(DPoint dPoint) throws Exception {
        if (dPoint == null) {
            throw new IllegalArgumentException("传入经纬度对象为空");
        } else if (dPoint.getLongitude() > 180.0d || dPoint.getLongitude() < -180.0d) {
            throw new IllegalArgumentException("请传入合理经度");
        } else if (dPoint.getLatitude() > 90.0d || dPoint.getLatitude() < -90.0d) {
            throw new IllegalArgumentException("请传入合理纬度");
        } else {
            this.l = dPoint;
        }
        return this;
    }

    public synchronized CoordinateConverter from(CoordType coordType) {
        this.k = coordType;
        return this;
    }
}
