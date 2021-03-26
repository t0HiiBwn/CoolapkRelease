package com.kepler.jd.login;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.jd.kepler.res.ApkResources;
import com.jd.sec.startId.LoadDoor;
import com.kepler.jd.Listener.AsyncInitListener;
import com.kepler.jd.Listener.FaceCommonCallBack;
import com.kepler.jd.Listener.OpenAppAction;
import com.kepler.jd.Listener.OpenIDCallBck;
import com.kepler.jd.Listener.OpenSchemeCallback;
import com.kepler.jd.sdk.bean.KelperTask;
import com.kepler.jd.sdk.bean.KeplerAttachParameter;
import com.kepler.sdk.af;
import com.kepler.sdk.al;
import com.kepler.sdk.e;
import com.kepler.sdk.f;
import com.kepler.sdk.g;
import com.kepler.sdk.h;
import com.kepler.sdk.i;
import com.kepler.sdk.p;
import com.kepler.sdk.x;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public class KeplerApiManager {
    public static final int KeplerApiManagerActionErr = 500;
    public static final int KeplerApiManagerActionErr_AppKeyErr = 1021;
    public static final int KeplerApiManagerActionErr_AppKeyLast = 1020;
    public static final int KeplerApiManagerActionErr_AppKeyNotExist = 1005;
    public static final int KeplerApiManagerActionErr_CartFullErr = 8969;
    public static final int KeplerApiManagerActionErr_DataErr = -2004;
    public static final int KeplerApiManagerActionErr_ParameterErr = -2002;
    public static final int KeplerApiManagerActionErr_ParserErr = -2003;
    public static final int KeplerApiManagerActionErr_TokenLast = 1022;
    public static final int KeplerApiManagerActionErr_TokenNotExist = 1003;
    public static final int KeplerApiManagerActionErr_TokenTimeOutTErr = 1004;
    public static final int KeplerApiManagerActionErr_UNLogin = -2001;
    public static final int KeplerApiManagerActionServerErr = 3000;
    public static final int NetLinker_Err_ClientProtocolException = -1001;
    public static final int NetLinker_Err_IOException = -1002;
    public static final int NetLinker_Err_NetException = -1011;
    public static final int NetLinker_Err_NoNetwork = -1100;
    public static final int NetLinker_Err_NoSuchAlgorithmException = -1003;
    public static final int NetLinker_Err_Not_200 = -1010;
    public static final int NetLinker_Err_UnsupportedEncodingException = -1000;
    static FaceCommonCallBack<OpenIDCallBck> a;
    private static volatile boolean b;
    private static Context c;
    private static String[] d = {"kepler.jd"};
    private static Class<Activity> e;

    static class a {
        private static final KeplerApiManager a = new KeplerApiManager();
    }

    public static final KeplerApiManager getWebViewService() {
        return a.a;
    }

    private KeplerApiManager() {
    }

    public Context getApplicatonContext() {
        return c;
    }

    static final void a(Application application, String str, String str2, String str3, FaceCommonCallBack<OpenIDCallBck> faceCommonCallBack, FaceCommonCallBack<Boolean> faceCommonCallBack2, AsyncInitListener asyncInitListener) {
        if (application == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            asyncInitListener.onFailure();
            return;
        }
        a = faceCommonCallBack;
        try {
            if (!b) {
                c = application.getApplicationContext();
                ApkResources.getSingleton().init(application, str3);
                e.a().a("", str, str2);
                if (e.a().a(c)) {
                    a(faceCommonCallBack2);
                    if (asyncInitListener != null) {
                        asyncInitListener.onSuccess();
                    }
                } else if (asyncInitListener != null) {
                    asyncInitListener.onFailure();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            asyncInitListener.onFailure();
        }
    }

    public static final void asyncInitSdk(Application application, String str, String str2, AsyncInitListener asyncInitListener) {
        a(application, str, str2, null, null, null, asyncInitListener);
    }

    private static void a(final FaceCommonCallBack<Boolean> faceCommonCallBack) {
        Thread thread = new Thread(new Runnable() {
            /* class com.kepler.jd.login.KeplerApiManager.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                f.a().a(faceCommonCallBack);
                p.a().a(KeplerApiManager.c);
                al.a().a(KeplerApiManager.c, "http://orbit.jd.com/upload", e.a().b());
                al.a().b();
                boolean unused = KeplerApiManager.b = true;
            }
        }, " JD init asyncTask ");
        thread.setPriority(1);
        thread.start();
    }

    public KelperTask openAppWebViewPage(Context context, String str, KeplerAttachParameter keplerAttachParameter, OpenAppAction openAppAction) {
        try {
            return openAppWebViewPage(context, str, keplerAttachParameter, openAppAction, 1, null);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public KelperTask openAppWebViewPage(Context context, String str, KeplerAttachParameter keplerAttachParameter, OpenAppAction openAppAction, OpenSchemeCallback openSchemeCallback) {
        try {
            return openAppWebViewPage(context, str, keplerAttachParameter, openAppAction, 0, openSchemeCallback);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public KelperTask openAppWebViewPage(Context context, String str, KeplerAttachParameter keplerAttachParameter, OpenAppAction openAppAction, int i, OpenSchemeCallback openSchemeCallback) throws JSONException {
        if (!(x.e(c) > 0)) {
            if (openAppAction != null) {
                openAppAction.onStatus(3, str);
            }
            return null;
        } else if (!f.a().a(str)) {
            if (openAppAction != null) {
                openAppAction.onStatus(4, str);
            }
            return null;
        } else if (i != 0) {
            return new h(context, str, keplerAttachParameter, openAppAction, 60000, openSchemeCallback).a();
        } else {
            JSONObject jSONObject = new JSONObject();
            String str2 = keplerAttachParameter.get("mopenbp5");
            String str3 = keplerAttachParameter.get("keplerCustomerInfo");
            if (!af.b(str2)) {
                jSONObject.put("mopenbp5", keplerAttachParameter.get("mopenbp5"));
            } else if (!af.b(str3)) {
                jSONObject.put("mopenbp5", keplerAttachParameter.get("keplerCustomerInfo"));
            }
            String str4 = "kpl_jd" + e.a().b();
            jSONObject.put("mopenbp7", str4);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("source", "kepler-union");
            jSONObject2.put("otherData", jSONObject);
            jSONObject2.put("channel", e.a().b());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("jda", af.a(c));
            String localSid = LoadDoor.getInstance().getLocalSid(c);
            if (TextUtils.isEmpty(localSid)) {
                if (openAppAction != null) {
                    openAppAction.onStatus(5, str);
                }
                return null;
            }
            String jSONObject4 = new JSONObject().put("category", "jump").put("des", "m").put("url", str).put("m_param", jSONObject3).put("keplerID", str4).put("keplerFrom", "1").put("kepler_param", jSONObject2).put("openflag", "kepler-open").put("union_open", "union_cps").put("unionSource", "UnionSdk").put("uawakeId", localSid).toString();
            try {
                jSONObject4 = URLEncoder.encode(jSONObject4, "utf-8");
                System.out.println("utf-8编码：" + jSONObject4);
            } catch (UnsupportedEncodingException unused) {
            }
            StringBuilder sb = new StringBuilder();
            sb.append("openapp.jdmobile://virtual?params=");
            sb.append(jSONObject4);
            String replace = sb.toString().replace("\\/", "/");
            if (openSchemeCallback != null) {
                openSchemeCallback.callback(replace);
            }
            keplerAttachParameter.reset();
            return new h(context, openAppAction, str).a(sb.toString());
        }
    }

    private String b() {
        if (c == null) {
            return null;
        }
        return g.a().a(c, "kepler_token");
    }

    public boolean isKeplerLogined() {
        return !TextUtils.isEmpty(b());
    }

    public static String getKeplerVersion() {
        return i.a.booleanValue() ? "debug_3.0.1_254" : "3.0.1_254";
    }

    public static Class<Activity> getC() {
        return e;
    }

    public static void setD(boolean z) {
        i.f1353l = z;
    }
}
