package com.loc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import org.json.JSONObject;

/* compiled from: H5LocationClient */
public final class h {
    Object a = new Object();
    AMapLocationClientOption b = null;
    a c = null;
    private Context d;
    private AMapLocationClient e = null;
    private WebView f = null;
    private String g = "AMap.Geolocation.cbk";
    private volatile boolean h = false;

    /* compiled from: H5LocationClient */
    class a implements AMapLocationListener {
        a() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            if (h.this.h) {
                h.a(h.this, h.b(aMapLocation));
            }
        }
    }

    public h(Context context, WebView webView) {
        this.d = context.getApplicationContext();
        this.f = webView;
        this.c = new a();
    }

    static /* synthetic */ void a(h hVar, final String str) {
        try {
            if (hVar.f == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                WebView webView = hVar.f;
                webView.evaluateJavascript("javascript:" + hVar.g + "('" + str + "')", new ValueCallback<String>() {
                    /* class com.loc.h.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // android.webkit.ValueCallback
                    public final /* bridge */ /* synthetic */ void onReceiveValue(String str) {
                    }
                });
                return;
            }
            hVar.f.post(new Runnable() {
                /* class com.loc.h.AnonymousClass2 */

                @Override // java.lang.Runnable
                public final void run() {
                    WebView webView = h.this.f;
                    webView.loadUrl("javascript:" + h.this.g + "('" + str + "')");
                }
            });
        } catch (Throwable th) {
            ej.a(th, "H5LocationClient", "callbackJs()");
        }
    }

    /* access modifiers changed from: private */
    public static String b(AMapLocation aMapLocation) {
        String locationDetail;
        JSONObject jSONObject = new JSONObject();
        String str = "errorInfo";
        if (aMapLocation == null) {
            try {
                jSONObject.put("errorCode", -1);
                locationDetail = "unknownError";
            } catch (Throwable unused) {
            }
        } else if (aMapLocation.getErrorCode() == 0) {
            jSONObject.put("errorCode", 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("x", aMapLocation.getLongitude());
            jSONObject2.put("y", aMapLocation.getLatitude());
            jSONObject2.put("precision", (double) aMapLocation.getAccuracy());
            jSONObject2.put("type", aMapLocation.getLocationType());
            jSONObject2.put("country", aMapLocation.getCountry());
            jSONObject2.put("province", aMapLocation.getProvince());
            jSONObject2.put("city", aMapLocation.getCity());
            jSONObject2.put("cityCode", aMapLocation.getCityCode());
            jSONObject2.put("district", aMapLocation.getDistrict());
            jSONObject2.put("adCode", aMapLocation.getAdCode());
            jSONObject2.put("street", aMapLocation.getStreet());
            jSONObject2.put("streetNum", aMapLocation.getStreetNum());
            jSONObject2.put("floor", aMapLocation.getFloor());
            jSONObject2.put("address", aMapLocation.getAddress());
            jSONObject.put("result", jSONObject2);
            return jSONObject.toString();
        } else {
            jSONObject.put("errorCode", aMapLocation.getErrorCode());
            jSONObject.put(str, aMapLocation.getErrorInfo());
            str = "locationDetail";
            locationDetail = aMapLocation.getLocationDetail();
        }
        jSONObject.put(str, locationDetail);
        return jSONObject.toString();
    }

    public final void a() {
        if (this.f != null && this.d != null && Build.VERSION.SDK_INT >= 17 && !this.h) {
            try {
                this.f.getSettings().setJavaScriptEnabled(true);
                this.f.addJavascriptInterface(this, "AMapAndroidLoc");
                if (!TextUtils.isEmpty(this.f.getUrl())) {
                    this.f.reload();
                }
                if (this.e == null) {
                    AMapLocationClient aMapLocationClient = new AMapLocationClient(this.d);
                    this.e = aMapLocationClient;
                    aMapLocationClient.setLocationListener(this.c);
                }
                this.h = true;
            } catch (Throwable unused) {
            }
        }
    }

    public final void b() {
        synchronized (this.a) {
            this.h = false;
            AMapLocationClient aMapLocationClient = this.e;
            if (aMapLocationClient != null) {
                aMapLocationClient.unRegisterLocationListener(this.c);
                this.e.stopLocation();
                this.e.onDestroy();
                this.e = null;
            }
            this.b = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x005c A[Catch:{ all -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0064 A[Catch:{ all -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x006d A[Catch:{ all -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x006e A[Catch:{ all -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0074 A[Catch:{ all -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0080  */
    @JavascriptInterface
    public final void getLocation(String str) {
        boolean z;
        boolean z2;
        AMapLocationClient aMapLocationClient;
        AMapLocationClientOption aMapLocationClientOption;
        AMapLocationClientOption.AMapLocationMode aMapLocationMode;
        synchronized (this.a) {
            if (this.h) {
                if (this.b == null) {
                    this.b = new AMapLocationClientOption();
                }
                int i = 5;
                long j = 30000;
                boolean z3 = true;
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    j = jSONObject.optLong("to", 30000);
                    z = jSONObject.optInt("useGPS", 1) == 1;
                    try {
                        z2 = jSONObject.optInt("watch", 0) == 1;
                        try {
                            i = jSONObject.optInt("interval", 5);
                            String optString = jSONObject.optString("callback", null);
                            if (TextUtils.isEmpty(optString)) {
                                optString = "AMap.Geolocation.cbk";
                            }
                            this.g = optString;
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable unused2) {
                        z2 = false;
                        this.b.setHttpTimeOut(j);
                        if (z) {
                        }
                        aMapLocationClientOption.setLocationMode(aMapLocationMode);
                        AMapLocationClientOption aMapLocationClientOption2 = this.b;
                        if (z2) {
                        }
                        aMapLocationClientOption2.setOnceLocation(z3);
                        if (z2) {
                        }
                        aMapLocationClient = this.e;
                        if (aMapLocationClient != null) {
                        }
                    }
                } catch (Throwable unused3) {
                    z = false;
                    z2 = false;
                    this.b.setHttpTimeOut(j);
                    if (z) {
                    }
                    aMapLocationClientOption.setLocationMode(aMapLocationMode);
                    AMapLocationClientOption aMapLocationClientOption2 = this.b;
                    if (z2) {
                    }
                    aMapLocationClientOption2.setOnceLocation(z3);
                    if (z2) {
                    }
                    aMapLocationClient = this.e;
                    if (aMapLocationClient != null) {
                    }
                }
                try {
                    this.b.setHttpTimeOut(j);
                    if (z) {
                        aMapLocationClientOption = this.b;
                        aMapLocationMode = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
                    } else {
                        aMapLocationClientOption = this.b;
                        aMapLocationMode = AMapLocationClientOption.AMapLocationMode.Battery_Saving;
                    }
                    aMapLocationClientOption.setLocationMode(aMapLocationMode);
                    AMapLocationClientOption aMapLocationClientOption2 = this.b;
                    if (z2) {
                        z3 = false;
                    }
                    aMapLocationClientOption2.setOnceLocation(z3);
                    if (z2) {
                        this.b.setInterval((long) (i * 1000));
                    }
                } catch (Throwable unused4) {
                }
                aMapLocationClient = this.e;
                if (aMapLocationClient != null) {
                    aMapLocationClient.setLocationOption(this.b);
                    this.e.stopLocation();
                    this.e.startLocation();
                }
            }
        }
    }

    @JavascriptInterface
    public final void stopLocation() {
        AMapLocationClient aMapLocationClient;
        if (this.h && (aMapLocationClient = this.e) != null) {
            aMapLocationClient.stopLocation();
        }
    }
}
