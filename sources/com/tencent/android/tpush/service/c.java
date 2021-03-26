package com.tencent.android.tpush.service;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.ReturnCode;
import com.tencent.android.tpush.common.b;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.c.a;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.channel.security.TpnsSecurity;
import com.tencent.android.tpush.service.protocol.f;
import com.tencent.android.tpush.service.protocol.g;
import com.tencent.android.tpush.service.protocol.l;
import com.tencent.android.tpush.service.protocol.n;
import com.tencent.android.tpush.service.protocol.o;
import com.tencent.android.tpush.service.protocol.p;
import com.tencent.android.tpush.service.protocol.q;
import com.tencent.android.tpush.service.protocol.r;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.Md5;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.dataacquisition.CustomDeviceInfos;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import java.util.ArrayList;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class c {
    private static c a = new c();
    private static JSONArray b = new JSONArray();
    private static final String c = Md5.md5("com.tencent.tpush.last_wifi_ts");
    private static int d = -1;
    private static int e = -1;
    private static boolean f = false;

    public static byte a(boolean z) {
        return z ? (byte) 1 : 0;
    }

    public static c a() {
        return a;
    }

    public static f a(Context context) {
        f fVar = new f();
        fVar.i = "" + b.a();
        fVar.a = CustomDeviceInfos.getFacilityIdentity(context);
        if (DeviceInfos.checkSimulator(context)) {
            fVar.h = "SIMULATOR";
            fVar.b = DeviceInfos.getSimulatorModel(context);
        } else {
            fVar.h = Build.MANUFACTURER;
            fVar.b = DeviceInfos.getDeviceModel(context);
        }
        fVar.d = DeviceInfos.getLinkedWay(context);
        fVar.c = "android";
        DisplayMetrics displayMetrics = DeviceInfos.getDisplayMetrics(context);
        fVar.g = displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(Build.VERSION.SDK_INT);
        fVar.i = sb.toString();
        fVar.e = DeviceInfos.getExternalStorageInfo(context);
        fVar.f = CustomDeviceInfos.getSimOperator(context);
        fVar.j = Build.VERSION.RELEASE;
        fVar.k = (long) DeviceInfos.hasRootAccess(context);
        fVar.n = Locale.getDefault().getLanguage();
        fVar.o = TimeZone.getDefault().getID();
        fVar.p = b.e(context);
        fVar.r = com.tencent.android.tpush.service.util.b.b(context);
        fVar.s = c(context);
        return fVar;
    }

    private static n c(Context context) {
        n nVar = new n();
        nVar.a = DeviceInfos.getBootTime();
        nVar.b = Locale.getDefault().getCountry();
        nVar.c = DeviceInfos.getDeviceName(context);
        nVar.d = DeviceInfos.getCarrierInfo(context);
        nVar.e = String.valueOf(DeviceInfos.getTotalMemory());
        nVar.f = String.valueOf(DeviceInfos.getTotalInternalMemorySize());
        nVar.g = DeviceInfos.getSysFileTime();
        return nVar;
    }

    private static String d(Context context) {
        String g = d.g();
        if (ChannelUtils.isBrandXiaoMi()) {
            return "xiaomi";
        }
        if (ChannelUtils.isBrandHuaWei()) {
            return "huawei";
        }
        if (ChannelUtils.isBrandMeiZu()) {
            return "meizu";
        }
        if ("oppo".equals(g) || "oneplus".equals(g)) {
            return "oppo";
        }
        if ("vivo".equals(g)) {
            return "vivo";
        }
        if (i.a(context).c()) {
            return "fcm";
        }
        return null;
    }

    private static g a(Context context, String str) {
        if (!e(context)) {
            return null;
        }
        g gVar = new g();
        gVar.a = XGApiConfig.getFreeVersionAccessId(context);
        gVar.b = com.tencent.android.tpush.c.b.b(context);
        if (TextUtils.isEmpty(gVar.b) || gVar.b.equals("0")) {
            gVar.b = str;
            TLogger.dd("PushServiceNetworkHandler", "FreeVersionInfo -> user channel token");
        }
        gVar.c = d(context);
        TLogger.dd("PushServiceNetworkHandler", "FreeVersionInfo ->  AccessId:" + gVar.a + ", token:" + gVar.b + ", channel:" + gVar.c);
        return gVar;
    }

    private static boolean e(Context context) {
        if (XGApiConfig.getFreeVersionAccessId(context) < 0) {
            return false;
        }
        if (f) {
            TLogger.dd("PushServiceNetworkHandler", "isNeedGetFreeVersionInfo-> hasSucessGetFreeVersionInfo");
            return false;
        }
        int i = SharePrefsUtil.getInt(context, "freeinfo.succ.count", 0);
        TLogger.dd("PushServiceNetworkHandler", "isNeedGetFreeVersionInfo-> succsssCount:" + i);
        if (i >= 7) {
            f = true;
            return false;
        }
        String string = SharePrefsUtil.getString(context, "freeinfo.last.succ.date", "");
        String a2 = j.a(System.currentTimeMillis());
        TLogger.dd("PushServiceNetworkHandler", "isNeedGetFreeVersionInfo-> lastSuccessDate:" + string + ", tody:" + a2);
        if (TextUtils.isEmpty(string) || !a2.equals(string)) {
            return true;
        }
        f = true;
        return false;
    }

    static void b(Context context) {
        if (XGApiConfig.getFreeVersionAccessId(context) >= 0 && !f) {
            String string = SharePrefsUtil.getString(context, "freeinfo.last.succ.date", "");
            String a2 = j.a(System.currentTimeMillis());
            if (TextUtils.isEmpty(string) || !a2.equals(string)) {
                SharePrefsUtil.setString(context, "freeinfo.last.succ.date", a2);
                SharePrefsUtil.setInt(context, "freeinfo.succ.count", SharePrefsUtil.getInt(context, "freeinfo.succ.count", 0) + 1);
                f = true;
                return;
            }
            f = true;
        }
    }

    public void a(long j, String str, String str2, String str3, int i, String str4, String str5, String str6, long j2, String str7, String str8, String str9, long j3, long j4, String str10, String str11, long j5, a aVar) {
        l lVar = new l();
        lVar.a = j;
        lVar.b = str;
        lVar.c = str2;
        lVar.d = str4;
        lVar.e = str3;
        lVar.f = (short) i;
        lVar.h = a(b.e());
        lVar.E = a(b.e(), str10);
        lVar.i = 4;
        lVar.r = 0;
        lVar.m = str5;
        lVar.n = str6;
        lVar.u = j2;
        lVar.v = str9;
        lVar.t = j3;
        lVar.s = j4;
        lVar.q = System.currentTimeMillis() / 1000;
        lVar.z = "1.2.3.1";
        if (!j.b(str7)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", str7);
                if (!j.b(str8)) {
                    jSONObject.put("payload", str8);
                }
            } catch (JSONException unused) {
            }
            lVar.y = jSONObject.toString();
        }
        TLogger.vv("PushServiceNetworkHandler", "Register(" + j + "," + str2 + "," + str3 + "," + i + "),payload: " + lVar.y + " channel id" + lVar.s);
        lVar.p = CacheManager.getGuid(b.e());
        if (!(str10 == null || str11 == null)) {
            lVar.A = str10;
            lVar.B = str11;
        }
        Context e2 = b.e();
        if (e2 != null) {
            lVar.C = e2.getPackageName();
        }
        if (d == -1) {
            try {
                Class.forName("com.qq.e.ads.ADActivity");
                d = 1;
            } catch (Throwable unused2) {
                TLogger.d("PushServiceNetworkHandler", "Register get tAd error, tAd not found");
                d = 0;
            }
        }
        lVar.D = d;
        lVar.F = b();
        lVar.G = j5;
        if (!Util.checkAccessId(lVar.a) || !Util.checkAccessKey(lVar.b)) {
            aVar.b(ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR.getType(), ReturnCode.errCodeToMsg(ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR.getType()), lVar);
        } else if (lVar.b(e2) || !XGApiConfig.isRegistered(e2)) {
            com.tencent.android.tpush.service.c.b.a().a(e2, lVar, aVar);
        } else {
            aVar.a(ReturnCode.CODE_SUCCESS.getType(), "", lVar);
        }
    }

    public void a(String str, String str2, long j, String str3, String str4, a aVar) {
        String str5;
        q qVar = new q();
        try {
            str5 = TpnsSecurity.getEncryptAPKSignature(b.e().createPackageContext(str4, 0));
        } catch (Throwable th) {
            TLogger.e("PushServiceNetworkHandler", ">> create context [for: " + str4 + "] fail.", th);
            str5 = "";
        }
        qVar.b = j;
        qVar.c = str3;
        qVar.d = str5;
        qVar.e = 0;
        qVar.f = 0;
        qVar.g = System.currentTimeMillis() / 1000;
        qVar.h = "1.2.3.1";
        if (!Util.checkAccessId(qVar.b) || !Util.checkAccessKey(qVar.c)) {
            aVar.b(ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR.getType(), ReturnCode.errCodeToMsg(ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR.getType()), qVar);
        } else {
            com.tencent.android.tpush.service.c.b.a().a(b.e(), qVar, aVar);
        }
    }

    public void a(long j, String str, String str2, int i, a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.android.tpush.service.protocol.a aVar2 = new com.tencent.android.tpush.service.protocol.a();
        aVar2.a = j;
        aVar2.b = str;
        aVar2.c = i;
        aVar2.d = currentTimeMillis / 1000;
        aVar2.e = "1.2.3.1";
        if (!j.b(str2)) {
            try {
                JSONArray jSONArray = new JSONArray(str2);
                ArrayList<p> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    p pVar = new p();
                    pVar.a(jSONObject.getString("account"));
                    pVar.a(jSONObject.optInt("accountType", 0));
                    arrayList.add(pVar);
                }
                aVar2.f = arrayList;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (XGPushConfig.enableDebug) {
            TLogger.vv("PushServiceNetworkHandler", "setAccount(" + j + "," + str2 + ")");
        }
        if (!Util.checkAccessId(aVar2.a) || !Util.checkAccessKey(aVar2.b)) {
            aVar.b(ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR.getType(), ReturnCode.errCodeToMsg(ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR.getType()), aVar2);
        } else {
            com.tencent.android.tpush.service.c.b.a().a(b.e(), aVar2, aVar);
        }
    }

    public void a(long j, String str, String str2, int i, String str3, a aVar) {
        o oVar = new o();
        oVar.a = j;
        oVar.b = str;
        oVar.d = i;
        oVar.c = str3;
        oVar.e = System.currentTimeMillis() / 1000;
        oVar.f = "1.2.3.1";
        if (XGPushConfig.enableDebug) {
            TLogger.d("PushServiceNetworkHandler", "Action -> sendTag to server (" + j + "," + str2 + ")");
        }
        if (!Util.checkAccessId(oVar.a) || !Util.checkAccessKey(oVar.b)) {
            aVar.b(ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR.getType(), ReturnCode.errCodeToMsg(ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR.getType()), oVar);
        } else {
            com.tencent.android.tpush.service.c.b.a().a(b.e(), oVar, aVar);
        }
    }

    public void b(long j, String str, String str2, int i, String str3, a aVar) {
        com.tencent.android.tpush.service.protocol.b bVar = new com.tencent.android.tpush.service.protocol.b();
        bVar.a = j;
        bVar.b = str;
        bVar.d = i;
        bVar.c = str3;
        bVar.e = System.currentTimeMillis() / 1000;
        bVar.f = "1.2.3.1";
        TLogger.d("PushServiceNetworkHandler", "Action -> sendAttributes to server (" + j + "," + str2 + ")");
        if (!Util.checkAccessId(bVar.a) || !Util.checkAccessKey(bVar.b)) {
            aVar.b(ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR.getType(), ReturnCode.errCodeToMsg(ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR.getType()), bVar);
        } else {
            com.tencent.android.tpush.service.c.b.a().a(b.e(), bVar, aVar);
        }
    }

    public void a(long j, String str, String str2, String str3, a aVar) {
        com.tencent.android.tpush.service.c.b.a().a(b.e(), new r(j, str, str2, str3, System.currentTimeMillis() / 1000, "1.2.3.1"), aVar);
    }

    public void a(Intent intent, a aVar) {
        com.tencent.android.tpush.service.protocol.i iVar = new com.tencent.android.tpush.service.protocol.i();
        iVar.a = intent.getLongExtra("type", 0);
        try {
            iVar.b = Long.parseLong(Rijndael.decrypt(intent.getStringExtra("accessId")));
        } catch (NumberFormatException unused) {
            TLogger.e("PushServiceNetworkHandler", "sendCommReportMessage NumberFormatException");
        }
        iVar.c = intent.getLongExtra("msgId", 0);
        iVar.d = intent.getLongExtra("broadcastId", 0);
        iVar.e = intent.getLongExtra("msgTimestamp", 0);
        iVar.f = intent.getLongExtra("clientTimestamp", 0);
        iVar.i = intent.getStringExtra("pkgName");
        String decrypt = Rijndael.decrypt(intent.getStringExtra("msg"));
        if (decrypt != null) {
            iVar.g = decrypt;
        }
        String decrypt2 = Rijndael.decrypt(intent.getStringExtra("ext"));
        if (decrypt2 != null) {
            iVar.h = decrypt2;
        }
        if (!Util.checkAccessId(iVar.b)) {
            aVar.b(ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR.getType(), ReturnCode.errCodeToMsg(ReturnCode.CODE_ACCESSKET_OR_ACCESSID_ERROR.getType()), iVar);
        } else {
            com.tencent.android.tpush.service.c.b.a().b(b.e(), iVar, aVar);
        }
    }

    private int b() {
        if (e == -1) {
            if (ChannelUtils.isBrandHuaWei() || ChannelUtils.isBrandHonor()) {
                try {
                    Class.forName("com.huawei.hms.aaid.HmsInstanceId");
                    e = 4;
                } catch (Throwable unused) {
                    e = 0;
                }
            } else {
                e = 0;
            }
        }
        return e;
    }
}
