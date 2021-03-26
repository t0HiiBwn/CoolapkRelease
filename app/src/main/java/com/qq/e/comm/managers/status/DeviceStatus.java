package com.qq.e.comm.managers.status;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.StringUtil;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DeviceStatus {
    private String a;
    private String b;
    private int c;
    private int d;
    private int e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private volatile String k;

    /* renamed from: l  reason: collision with root package name */
    private volatile String f1389l;
    private volatile float m;
    public final String model = Build.MODEL;
    private Context n;

    public DeviceStatus(Context context) {
        this.n = context.getApplicationContext();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.e = getVersion() > 3 ? displayMetrics.densityDpi : 120;
        this.c = getVersion() > 3 ? a(displayMetrics.density, displayMetrics.widthPixels) : displayMetrics.widthPixels;
        this.d = getVersion() > 3 ? a(displayMetrics.density, displayMetrics.heightPixels) : displayMetrics.heightPixels;
        a();
    }

    private int a(float f2, int i2) {
        return (this.n.getApplicationInfo().flags & 8192) != 0 ? (int) (((float) i2) / f2) : i2;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x0034: INVOKE  (r2v4 double) = (r0v3 android.location.Location) type: VIRTUAL call: android.location.Location.getLatitude():double)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x0046: INVOKE  (r2v5 double) = (r0v3 android.location.Location) type: VIRTUAL call: android.location.Location.getLongitude():double)] */
    private void a() {
        try {
            final LocationManager locationManager = (LocationManager) this.n.getSystemService("location");
            if (locationManager != null) {
                Criteria criteria = new Criteria();
                criteria.setAccuracy(2);
                criteria.setAltitudeRequired(false);
                criteria.setBearingRequired(false);
                criteria.setCostAllowed(true);
                criteria.setPowerRequirement(1);
                String bestProvider = locationManager.getBestProvider(criteria, true);
                Location lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);
                if (lastKnownLocation != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(lastKnownLocation.getLatitude());
                    this.k = sb.toString();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(lastKnownLocation.getLongitude());
                    this.f1389l = sb2.toString();
                    this.m = lastKnownLocation.getAccuracy();
                    return;
                }
                locationManager.requestLocationUpdates(bestProvider, 2000, 7000.0f, new LocationListener() {
                    /* class com.qq.e.comm.managers.status.DeviceStatus.AnonymousClass1 */

                    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x0007: INVOKE  (r2v0 double) = (r5v0 android.location.Location) type: VIRTUAL call: android.location.Location.getLatitude():double)] */
                    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x001c: INVOKE  (r2v1 double) = (r5v0 android.location.Location) type: VIRTUAL call: android.location.Location.getLongitude():double)] */
                    @Override // android.location.LocationListener
                    public void onLocationChanged(Location location) {
                        try {
                            DeviceStatus deviceStatus = DeviceStatus.this;
                            StringBuilder sb = new StringBuilder();
                            sb.append(location.getLatitude());
                            deviceStatus.k = sb.toString();
                            DeviceStatus deviceStatus2 = DeviceStatus.this;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(location.getLongitude());
                            deviceStatus2.f1389l = sb2.toString();
                            locationManager.removeUpdates(this);
                        } catch (Throwable unused) {
                        }
                    }

                    @Override // android.location.LocationListener
                    public void onProviderDisabled(String str) {
                    }

                    @Override // android.location.LocationListener
                    public void onProviderEnabled(String str) {
                    }

                    @Override // android.location.LocationListener
                    public void onStatusChanged(String str, int i, Bundle bundle) {
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    public Carrier getCarrier() {
        String operator = getOperator();
        if (operator != null) {
            if (operator.equals("46000") || operator.equals("46002") || operator.equals("46007") || operator.equals("46020")) {
                return Carrier.CMCC;
            }
            if (operator.equals("46001") || operator.equals("46006")) {
                return Carrier.UNICOM;
            }
            if (operator.equals("46003") || operator.equals("46005")) {
                return Carrier.TELECOM;
            }
        }
        return Carrier.UNKNOWN;
    }

    public String getDataNet() {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) this.n.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            networkInfo = null;
        }
        if (networkInfo == null) {
            return null;
        }
        int type = networkInfo.getType();
        String str = type != 0 ? type != 1 ? "unknow" : "wi" : "ed";
        this.i = str;
        return str;
    }

    public int getDeviceDensity() {
        return this.e;
    }

    public int getDeviceHeight() {
        return this.d;
    }

    public int getDeviceWidth() {
        return this.c;
    }

    public String getDid() {
        String plainDid = getPlainDid();
        return StringUtil.isEmpty(plainDid) ? "" : Md5Util.encode(plainDid.toLowerCase());
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r3v2 int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v7 int)] */
    public Map<String, String> getLacAndCeilId() {
        int i2;
        GsmCellLocation gsmCellLocation;
        String operator = getOperator();
        HashMap hashMap = new HashMap();
        if (this.n.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0 && !StringUtil.isEmpty(operator) && !"null".equalsIgnoreCase(operator)) {
            int i3 = 0;
            try {
                if (Integer.parseInt(operator.substring(0, 3)) == 460) {
                    TelephonyManager telephonyManager = (TelephonyManager) this.n.getSystemService("phone");
                    CellLocation cellLocation = telephonyManager.getCellLocation();
                    if (cellLocation instanceof CdmaCellLocation) {
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                        i3 = cdmaCellLocation.getNetworkId();
                        i2 = cdmaCellLocation.getBaseStationId();
                    } else if (!(cellLocation instanceof GsmCellLocation) || (gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation()) == null) {
                        i2 = 0;
                    } else {
                        i3 = gsmCellLocation.getLac();
                        i2 = gsmCellLocation.getCid();
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(i3);
                    hashMap.put("lac", sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i2);
                    hashMap.put("cellid", sb2.toString());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return hashMap;
    }

    public String getLanguage() {
        if (this.b == null) {
            String lowerCase = Locale.getDefault().getLanguage().toLowerCase(Locale.US);
            this.b = lowerCase;
            if (lowerCase.length() == 0) {
                this.b = "en";
            }
        }
        return this.b;
    }

    public String getLat() {
        return this.k;
    }

    public String getLng() {
        return this.f1389l;
    }

    public float getLocationAccuracy() {
        return this.m;
    }

    public NetworkType getNetworkType() {
        int i2;
        String dataNet = getDataNet();
        if (dataNet != null && dataNet.equals("wi")) {
            return NetworkType.WIFI;
        }
        try {
            i2 = Integer.parseInt(getPhoneNet());
        } catch (NumberFormatException unused) {
            i2 = 0;
        }
        switch (i2) {
            case 1:
            case 2:
            case 16:
                return NetworkType.NET_2G;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 17:
                return NetworkType.NET_3G;
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
                return NetworkType.NET_4G;
            default:
                return NetworkType.UNKNOWN;
        }
    }

    public String getOS() {
        return "android";
    }

    public String getOperator() {
        try {
            this.g = ((TelephonyManager) this.n.getSystemService("phone")).getNetworkOperator();
        } catch (Exception unused) {
        }
        return this.g;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v6 int)] */
    public String getPhoneNet() {
        Context appContext = GDTADManager.getInstance().getAppContext();
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) appContext.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
                int networkType = ((TelephonyManager) appContext.getSystemService("phone")).getNetworkType();
                if (networkType == 0) {
                    networkType = activeNetworkInfo.getSubtype();
                }
                StringBuilder sb = new StringBuilder();
                sb.append(networkType);
                this.h = sb.toString();
            }
        } catch (Exception unused) {
        }
        return this.h;
    }

    public String getPlainDid() {
        if (!StringUtil.isEmpty(this.j)) {
            return this.j;
        }
        if (this.n.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0 || GDTADManager.getInstance().getSM().getInteger("imeion", 1) != 1 || !GlobalSetting.isAgreePrivacyStrategyNonNull()) {
            return "";
        }
        try {
            this.j = ((TelephonyManager) this.n.getSystemService("phone")).getDeviceId();
        } catch (Exception e2) {
            GDTLogger.d("Get imei encounter error: " + e2.getMessage());
        }
        return StringUtil.isEmpty(this.j) ? "" : this.j;
    }

    public String getScreenOrientation() {
        this.f = this.n.getResources().getConfiguration().orientation == 2 ? "l" : "p";
        return this.f;
    }

    public String getUid() {
        String str = "";
        if (GDTADManager.getInstance().getSM().getInteger("adidon", 1) != 1) {
            return str;
        }
        if (this.a == null) {
            String string = Settings.Secure.getString(this.n.getContentResolver(), "android_id");
            if (string != null) {
                str = Md5Util.encode(string);
            }
            this.a = str;
        }
        return this.a;
    }

    public int getVersion() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Exception unused) {
            return 3;
        }
    }
}
