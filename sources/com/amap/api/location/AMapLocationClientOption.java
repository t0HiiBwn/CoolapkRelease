package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.loc.ej;

public class AMapLocationClientOption implements Parcelable, Cloneable {
    public static final Parcelable.Creator<AMapLocationClientOption> CREATOR = new Parcelable.Creator<AMapLocationClientOption>() {
        /* class com.amap.api.location.AMapLocationClientOption.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocationClientOption createFromParcel(Parcel parcel) {
            return new AMapLocationClientOption(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AMapLocationClientOption[] newArray(int i) {
            return new AMapLocationClientOption[i];
        }
    };
    public static boolean OPEN_ALWAYS_SCAN_WIFI = true;
    public static long SCAN_WIFI_INTERVAL = 30000;
    static String a = "";
    private static int d = 0;
    private static int e = 1;
    private static int f = 2;
    private static int g = 4;
    private static AMapLocationProtocol p = AMapLocationProtocol.HTTP;
    private float A;
    private AMapLocationPurpose B;
    boolean b;
    String c;
    private long h;
    private long i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private AMapLocationMode o;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private long x;
    private long y;
    private GeoLanguage z;

    /* renamed from: com.amap.api.location.AMapLocationClientOption$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AMapLocationPurpose.values().length];
            a = iArr;
            try {
                iArr[AMapLocationPurpose.SignIn.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AMapLocationPurpose.Transport.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AMapLocationPurpose.Sport.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum AMapLocationMode {
        Battery_Saving,
        Device_Sensors,
        Hight_Accuracy
    }

    public enum AMapLocationProtocol {
        HTTP(0),
        HTTPS(1);
        
        private int a;

        private AMapLocationProtocol(int i) {
            this.a = i;
        }

        public final int getValue() {
            return this.a;
        }
    }

    public enum AMapLocationPurpose {
        SignIn,
        Transport,
        Sport
    }

    public enum GeoLanguage {
        DEFAULT,
        ZH,
        EN
    }

    public AMapLocationClientOption() {
        this.h = 2000;
        this.i = (long) ej.g;
        this.j = false;
        this.k = true;
        this.l = true;
        this.m = true;
        this.n = true;
        this.o = AMapLocationMode.Hight_Accuracy;
        this.q = false;
        this.r = false;
        this.s = true;
        this.t = true;
        this.u = false;
        this.v = false;
        this.w = true;
        this.x = 30000;
        this.y = 30000;
        this.z = GeoLanguage.DEFAULT;
        this.A = 0.0f;
        this.B = null;
        this.b = false;
        this.c = null;
    }

    protected AMapLocationClientOption(Parcel parcel) {
        this.h = 2000;
        this.i = (long) ej.g;
        boolean z2 = false;
        this.j = false;
        this.k = true;
        this.l = true;
        this.m = true;
        this.n = true;
        this.o = AMapLocationMode.Hight_Accuracy;
        this.q = false;
        this.r = false;
        this.s = true;
        this.t = true;
        this.u = false;
        this.v = false;
        this.w = true;
        this.x = 30000;
        this.y = 30000;
        this.z = GeoLanguage.DEFAULT;
        this.A = 0.0f;
        AMapLocationPurpose aMapLocationPurpose = null;
        this.B = null;
        this.b = false;
        this.c = null;
        this.h = parcel.readLong();
        this.i = parcel.readLong();
        this.j = parcel.readByte() != 0;
        this.k = parcel.readByte() != 0;
        this.l = parcel.readByte() != 0;
        this.m = parcel.readByte() != 0;
        this.n = parcel.readByte() != 0;
        int readInt = parcel.readInt();
        this.o = readInt == -1 ? AMapLocationMode.Hight_Accuracy : AMapLocationMode.values()[readInt];
        this.q = parcel.readByte() != 0;
        this.r = parcel.readByte() != 0;
        this.s = parcel.readByte() != 0;
        this.t = parcel.readByte() != 0;
        this.u = parcel.readByte() != 0;
        this.v = parcel.readByte() != 0;
        this.w = parcel.readByte() != 0;
        this.x = parcel.readLong();
        int readInt2 = parcel.readInt();
        p = readInt2 == -1 ? AMapLocationProtocol.HTTP : AMapLocationProtocol.values()[readInt2];
        int readInt3 = parcel.readInt();
        this.z = readInt3 == -1 ? GeoLanguage.DEFAULT : GeoLanguage.values()[readInt3];
        this.A = parcel.readFloat();
        int readInt4 = parcel.readInt();
        this.B = readInt4 != -1 ? AMapLocationPurpose.values()[readInt4] : aMapLocationPurpose;
        OPEN_ALWAYS_SCAN_WIFI = parcel.readByte() != 0 ? true : z2;
        this.y = parcel.readLong();
    }

    public static String getAPIKEY() {
        return a;
    }

    public static boolean isDownloadCoordinateConvertLibrary() {
        return false;
    }

    public static boolean isOpenAlwaysScanWifi() {
        return OPEN_ALWAYS_SCAN_WIFI;
    }

    public static void setDownloadCoordinateConvertLibrary(boolean z2) {
    }

    public static void setLocationProtocol(AMapLocationProtocol aMapLocationProtocol) {
        p = aMapLocationProtocol;
    }

    public static void setOpenAlwaysScanWifi(boolean z2) {
        OPEN_ALWAYS_SCAN_WIFI = z2;
    }

    public static void setScanWifiInterval(long j2) {
        SCAN_WIFI_INTERVAL = j2;
    }

    @Override // java.lang.Object
    public AMapLocationClientOption clone() {
        try {
            super.clone();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.h = this.h;
        aMapLocationClientOption.j = this.j;
        aMapLocationClientOption.o = this.o;
        aMapLocationClientOption.k = this.k;
        aMapLocationClientOption.q = this.q;
        aMapLocationClientOption.r = this.r;
        aMapLocationClientOption.l = this.l;
        aMapLocationClientOption.m = this.m;
        aMapLocationClientOption.i = this.i;
        aMapLocationClientOption.s = this.s;
        aMapLocationClientOption.t = this.t;
        aMapLocationClientOption.u = this.u;
        aMapLocationClientOption.v = isSensorEnable();
        aMapLocationClientOption.w = isWifiScan();
        aMapLocationClientOption.x = this.x;
        setLocationProtocol(getLocationProtocol());
        aMapLocationClientOption.z = this.z;
        setDownloadCoordinateConvertLibrary(isDownloadCoordinateConvertLibrary());
        aMapLocationClientOption.A = this.A;
        aMapLocationClientOption.B = this.B;
        setOpenAlwaysScanWifi(isOpenAlwaysScanWifi());
        setScanWifiInterval(getScanWifiInterval());
        aMapLocationClientOption.y = this.y;
        return aMapLocationClientOption;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDeviceModeDistanceFilter() {
        return this.A;
    }

    public GeoLanguage getGeoLanguage() {
        return this.z;
    }

    public long getGpsFirstTimeout() {
        return this.y;
    }

    public long getHttpTimeOut() {
        return this.i;
    }

    public long getInterval() {
        return this.h;
    }

    public long getLastLocationLifeCycle() {
        return this.x;
    }

    public AMapLocationMode getLocationMode() {
        return this.o;
    }

    public AMapLocationProtocol getLocationProtocol() {
        return p;
    }

    public AMapLocationPurpose getLocationPurpose() {
        return this.B;
    }

    public long getScanWifiInterval() {
        return SCAN_WIFI_INTERVAL;
    }

    public boolean isGpsFirst() {
        return this.r;
    }

    public boolean isKillProcess() {
        return this.q;
    }

    public boolean isLocationCacheEnable() {
        return this.t;
    }

    public boolean isMockEnable() {
        return this.k;
    }

    public boolean isNeedAddress() {
        return this.l;
    }

    public boolean isOffset() {
        return this.s;
    }

    public boolean isOnceLocation() {
        return this.j;
    }

    public boolean isOnceLocationLatest() {
        return this.u;
    }

    public boolean isSensorEnable() {
        return this.v;
    }

    public boolean isWifiActiveScan() {
        return this.m;
    }

    public boolean isWifiScan() {
        return this.w;
    }

    public AMapLocationClientOption setDeviceModeDistanceFilter(float f2) {
        this.A = f2;
        return this;
    }

    public AMapLocationClientOption setGeoLanguage(GeoLanguage geoLanguage) {
        this.z = geoLanguage;
        return this;
    }

    public AMapLocationClientOption setGpsFirst(boolean z2) {
        this.r = z2;
        return this;
    }

    public AMapLocationClientOption setGpsFirstTimeout(long j2) {
        if (j2 < 5000) {
            j2 = 5000;
        }
        if (j2 > 30000) {
            j2 = 30000;
        }
        this.y = j2;
        return this;
    }

    public AMapLocationClientOption setHttpTimeOut(long j2) {
        this.i = j2;
        return this;
    }

    public AMapLocationClientOption setInterval(long j2) {
        if (j2 <= 800) {
            j2 = 800;
        }
        this.h = j2;
        return this;
    }

    public AMapLocationClientOption setKillProcess(boolean z2) {
        this.q = z2;
        return this;
    }

    public AMapLocationClientOption setLastLocationLifeCycle(long j2) {
        this.x = j2;
        return this;
    }

    public AMapLocationClientOption setLocationCacheEnable(boolean z2) {
        this.t = z2;
        return this;
    }

    public AMapLocationClientOption setLocationMode(AMapLocationMode aMapLocationMode) {
        this.o = aMapLocationMode;
        return this;
    }

    public AMapLocationClientOption setLocationPurpose(AMapLocationPurpose aMapLocationPurpose) {
        String str;
        this.B = aMapLocationPurpose;
        if (aMapLocationPurpose != null) {
            int i2 = AnonymousClass2.a[aMapLocationPurpose.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    int i3 = d;
                    int i4 = f;
                    if ((i3 & i4) == 0) {
                        this.b = true;
                        d = i3 | i4;
                        str = "transport";
                    }
                    this.o = AMapLocationMode.Hight_Accuracy;
                    this.j = false;
                    this.u = false;
                    this.r = true;
                    this.k = false;
                    this.w = true;
                } else if (i2 == 3) {
                    int i5 = d;
                    int i6 = g;
                    if ((i5 & i6) == 0) {
                        this.b = true;
                        d = i5 | i6;
                        str = "sport";
                    }
                    this.o = AMapLocationMode.Hight_Accuracy;
                    this.j = false;
                    this.u = false;
                    this.r = true;
                    this.k = false;
                    this.w = true;
                }
                this.c = str;
                this.o = AMapLocationMode.Hight_Accuracy;
                this.j = false;
                this.u = false;
                this.r = true;
                this.k = false;
                this.w = true;
            } else {
                this.o = AMapLocationMode.Hight_Accuracy;
                this.j = true;
                this.u = true;
                this.r = false;
                this.k = false;
                this.w = true;
                int i7 = d;
                int i8 = e;
                if ((i7 & i8) == 0) {
                    this.b = true;
                    d = i7 | i8;
                    this.c = "signin";
                }
            }
        }
        return this;
    }

    public AMapLocationClientOption setMockEnable(boolean z2) {
        this.k = z2;
        return this;
    }

    public AMapLocationClientOption setNeedAddress(boolean z2) {
        this.l = z2;
        return this;
    }

    public AMapLocationClientOption setOffset(boolean z2) {
        this.s = z2;
        return this;
    }

    public AMapLocationClientOption setOnceLocation(boolean z2) {
        this.j = z2;
        return this;
    }

    public AMapLocationClientOption setOnceLocationLatest(boolean z2) {
        this.u = z2;
        return this;
    }

    public AMapLocationClientOption setSensorEnable(boolean z2) {
        this.v = z2;
        return this;
    }

    public AMapLocationClientOption setWifiActiveScan(boolean z2) {
        this.m = z2;
        this.n = z2;
        return this;
    }

    public AMapLocationClientOption setWifiScan(boolean z2) {
        this.w = z2;
        this.m = z2 ? this.n : false;
        return this;
    }

    @Override // java.lang.Object
    public String toString() {
        return "interval:" + String.valueOf(this.h) + "#isOnceLocation:" + String.valueOf(this.j) + "#locationMode:" + String.valueOf(this.o) + "#locationProtocol:" + String.valueOf(p) + "#isMockEnable:" + String.valueOf(this.k) + "#isKillProcess:" + String.valueOf(this.q) + "#isGpsFirst:" + String.valueOf(this.r) + "#isNeedAddress:" + String.valueOf(this.l) + "#isWifiActiveScan:" + String.valueOf(this.m) + "#wifiScan:" + String.valueOf(this.w) + "#httpTimeOut:" + String.valueOf(this.i) + "#isLocationCacheEnable:" + String.valueOf(this.t) + "#isOnceLocationLatest:" + String.valueOf(this.u) + "#sensorEnable:" + String.valueOf(this.v) + "#geoLanguage:" + String.valueOf(this.z) + "#locationPurpose:" + String.valueOf(this.B) + "#";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.h);
        parcel.writeLong(this.i);
        parcel.writeByte(this.j ? (byte) 1 : 0);
        parcel.writeByte(this.k ? (byte) 1 : 0);
        parcel.writeByte(this.l ? (byte) 1 : 0);
        parcel.writeByte(this.m ? (byte) 1 : 0);
        parcel.writeByte(this.n ? (byte) 1 : 0);
        AMapLocationMode aMapLocationMode = this.o;
        int i3 = -1;
        parcel.writeInt(aMapLocationMode == null ? -1 : aMapLocationMode.ordinal());
        parcel.writeByte(this.q ? (byte) 1 : 0);
        parcel.writeByte(this.r ? (byte) 1 : 0);
        parcel.writeByte(this.s ? (byte) 1 : 0);
        parcel.writeByte(this.t ? (byte) 1 : 0);
        parcel.writeByte(this.u ? (byte) 1 : 0);
        parcel.writeByte(this.v ? (byte) 1 : 0);
        parcel.writeByte(this.w ? (byte) 1 : 0);
        parcel.writeLong(this.x);
        parcel.writeInt(p == null ? -1 : getLocationProtocol().ordinal());
        GeoLanguage geoLanguage = this.z;
        parcel.writeInt(geoLanguage == null ? -1 : geoLanguage.ordinal());
        parcel.writeFloat(this.A);
        AMapLocationPurpose aMapLocationPurpose = this.B;
        if (aMapLocationPurpose != null) {
            i3 = aMapLocationPurpose.ordinal();
        }
        parcel.writeInt(i3);
        parcel.writeInt(OPEN_ALWAYS_SCAN_WIFI ? 1 : 0);
        parcel.writeLong(this.y);
    }
}
