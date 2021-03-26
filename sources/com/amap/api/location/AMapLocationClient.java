package com.amap.api.location;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.loc.d;
import com.loc.ej;
import com.loc.en;
import com.loc.n;
import org.json.JSONObject;

public class AMapLocationClient {
    Context a;
    d b;

    public AMapLocationClient(Context context) {
        if (context != null) {
            try {
                this.a = context.getApplicationContext();
                this.b = new d(context, null, null);
            } catch (Throwable th) {
                ej.a(th, "AMClt", "ne1");
            }
        } else {
            throw new IllegalArgumentException("Context参数不能为null");
        }
    }

    public AMapLocationClient(Context context, Intent intent) {
        if (context != null) {
            try {
                this.a = context.getApplicationContext();
                this.b = new d(this.a, intent, null);
            } catch (Throwable th) {
                ej.a(th, "AMClt", "ne2");
            }
        } else {
            throw new IllegalArgumentException("Context参数不能为null");
        }
    }

    public AMapLocationClient(Looper looper, Context context) {
        if (context != null) {
            try {
                this.a = context.getApplicationContext();
                this.b = new d(this.a, null, looper);
            } catch (Throwable th) {
                ej.a(th, "AMClt", "ne3");
            }
        } else {
            throw new IllegalArgumentException("Context参数不能为null");
        }
    }

    public static String getDeviceId(Context context) {
        return n.y(context);
    }

    public static void setApiKey(String str) {
        try {
            AMapLocationClientOption.a = str;
        } catch (Throwable th) {
            ej.a(th, "AMClt", "sKey");
        }
    }

    public void disableBackgroundLocation(boolean z) {
        try {
            d dVar = this.b;
            if (dVar != null) {
                dVar.a(z);
            }
        } catch (Throwable th) {
            ej.a(th, "AMClt", "dBackL");
        }
    }

    public void enableBackgroundLocation(int i, Notification notification) {
        try {
            d dVar = this.b;
            if (dVar != null) {
                dVar.a(i, notification);
            }
        } catch (Throwable th) {
            ej.a(th, "AMClt", "eBackL");
        }
    }

    public AMapLocation getLastKnownLocation() {
        try {
            d dVar = this.b;
            if (dVar != null) {
                return dVar.e();
            }
            return null;
        } catch (Throwable th) {
            ej.a(th, "AMClt", "gLastL");
            return null;
        }
    }

    public String getVersion() {
        return "5.2.0";
    }

    public boolean isStarted() {
        try {
            d dVar = this.b;
            if (dVar != null) {
                return dVar.a();
            }
            return false;
        } catch (Throwable th) {
            ej.a(th, "AMClt", "isS");
            return false;
        }
    }

    public void onDestroy() {
        try {
            d dVar = this.b;
            if (dVar != null) {
                dVar.d();
            }
        } catch (Throwable th) {
            ej.a(th, "AMClt", "onDy");
        }
    }

    public void setLocationListener(AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener != null) {
            try {
                d dVar = this.b;
                if (dVar != null) {
                    dVar.a(aMapLocationListener);
                }
            } catch (Throwable th) {
                ej.a(th, "AMClt", "sLocL");
            }
        } else {
            throw new IllegalArgumentException("listener参数不能为null");
        }
    }

    public void setLocationOption(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption != null) {
            try {
                d dVar = this.b;
                if (dVar != null) {
                    dVar.a(aMapLocationClientOption);
                }
                if (aMapLocationClientOption.b) {
                    aMapLocationClientOption.b = false;
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(aMapLocationClientOption.c)) {
                        jSONObject.put("amap_loc_scenes_type", aMapLocationClientOption.c);
                    }
                    en.a(this.a, "O019", jSONObject);
                }
            } catch (Throwable th) {
                ej.a(th, "AMClt", "sLocnO");
            }
        } else {
            throw new IllegalArgumentException("LocationManagerOption参数不能为null");
        }
    }

    public void startAssistantLocation() {
        try {
            d dVar = this.b;
            if (dVar != null) {
                dVar.f();
            }
        } catch (Throwable th) {
            ej.a(th, "AMClt", "stAssLo");
        }
    }

    public void startAssistantLocation(WebView webView) {
        try {
            d dVar = this.b;
            if (dVar != null) {
                dVar.a(webView);
            }
        } catch (Throwable th) {
            ej.a(th, "AMClt", "sttAssL1");
        }
    }

    public void startLocation() {
        try {
            d dVar = this.b;
            if (dVar != null) {
                dVar.b();
            }
        } catch (Throwable th) {
            ej.a(th, "AMClt", "stl");
        }
    }

    public void stopAssistantLocation() {
        try {
            d dVar = this.b;
            if (dVar != null) {
                dVar.g();
            }
        } catch (Throwable th) {
            ej.a(th, "AMClt", "stAssL");
        }
    }

    public void stopLocation() {
        try {
            d dVar = this.b;
            if (dVar != null) {
                dVar.c();
            }
        } catch (Throwable th) {
            ej.a(th, "AMClt", "stl");
        }
    }

    public void unRegisterLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            d dVar = this.b;
            if (dVar != null) {
                dVar.b(aMapLocationListener);
            }
        } catch (Throwable th) {
            ej.a(th, "AMClt", "unRL");
        }
    }
}
