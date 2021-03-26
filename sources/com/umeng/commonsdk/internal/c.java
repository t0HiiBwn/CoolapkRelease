package com.umeng.commonsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.ar;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.k;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.UMConfigureImpl;
import com.umeng.commonsdk.a;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.SelfChecker;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.stateless.d;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.b;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.onMessageSendListener;
import com.umeng.commonsdk.vchannel.Sender;
import java.io.File;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* compiled from: UMInternalDataProtocol */
public class c implements UMLogDataProtocol {
    public static final String a = "umeng_sp_zdata";
    public static final String b = "umeng_zdata";
    public static final String c = "umeng_zdata_req_ts";
    private static int e = 1;
    private static final String f = "info";
    private static final String g = "stat";
    private static Class<?> h = null;
    private static Method i = null;
    private static Method j = null;
    private static final String k = "com.umeng.umzid.Spy";

    /* renamed from: l  reason: collision with root package name */
    private static boolean f1484l;
    private Context d;

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j2) {
        return null;
    }

    static {
        b();
        UMUtils.VALUE_ASMS_VERSION = a();
    }

    private static void b() {
        if (UMConfigure.shouldCollectZData()) {
            e++;
            try {
                Class<?> cls = Class.forName("com.umeng.umzid.Spy");
                if (cls != null) {
                    h = cls;
                    Method declaredMethod = cls.getDeclaredMethod("getID", new Class[0]);
                    if (declaredMethod != null) {
                        i = declaredMethod;
                    }
                    Method declaredMethod2 = h.getDeclaredMethod("getVersion", new Class[0]);
                    if (declaredMethod2 != null) {
                        j = declaredMethod2;
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static String c() {
        Method method;
        Class<?> cls = h;
        if (!(cls == null || (method = i) == null)) {
            try {
                return (String) method.invoke(cls, new Object[0]);
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static String a() {
        Method method;
        Class<?> cls = h;
        if (!(cls == null || (method = j) == null)) {
            try {
                return (String) method.invoke(cls, new Object[0]);
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public c(Context context) {
        if (context != null) {
            this.d = context.getApplicationContext();
        }
    }

    private void a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put("app_version", UMGlobalContext.getInstance(context).getAppVersion());
            jSONObject.put("os", "Android");
            JSONObject buildZeroEnvelopeWithExtHeader = UMEnvelopeBuild.buildZeroEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.ZCFG_PATH);
            if (buildZeroEnvelopeWithExtHeader == null || !buildZeroEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e("MobclickRT", "--->>> 构建零号报文 成功!!!");
            } else {
                UMRTLog.e("MobclickRT", "--->>> 构建零号报文失败.");
            }
        } catch (Throwable unused) {
        }
    }

    private void d() {
        bc a2 = bc.a(this.d);
        bd a3 = a2.a("stf");
        if (a3 != null) {
            UMRTLog.e("MobclickRT", "--->>> [有状态]二级缓存记录构建成真正信封。");
            try {
                String str = a3.a;
                String str2 = a3.b;
                JSONObject a4 = new b().a(this.d.getApplicationContext(), new JSONObject(a3.c), new JSONObject(a3.d), a3.e, str2, a3.f);
                if (a4 == null || !a4.has("exception")) {
                    UMRTLog.e("MobclickRT", "--->>> [有状态]二级缓存记录构建真正信封 成功! 删除二级缓存记录。");
                } else {
                    UMRTLog.e("MobclickRT", "--->>> [有状态]二级缓存记录构建真正信封 失败。删除二级缓存记录");
                }
                a2.a("stf", str);
                a2.b();
            } catch (Throwable unused) {
            }
        }
    }

    private static void b(final Context context) {
        new Thread(new Runnable() {
            /* class com.umeng.commonsdk.internal.c.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_sp_oaid", 0);
                    long currentTimeMillis = System.currentTimeMillis();
                    String a2 = ar.a(context);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (!TextUtils.isEmpty(a2) && sharedPreferences != null) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString("key_umeng_sp_oaid_required_time", (currentTimeMillis2 - currentTimeMillis) + "");
                        edit.commit();
                    }
                    if (sharedPreferences != null) {
                        SharedPreferences.Editor edit2 = sharedPreferences.edit();
                        edit2.putString("key_umeng_sp_oaid", a2);
                        edit2.commit();
                    }
                    if (Build.VERSION.SDK_INT > 28) {
                        UMConfigureImpl.removeInterruptFlag();
                    }
                } catch (Exception unused) {
                }
            }
        }).start();
    }

    private static void a(Context context, final OnGetOaidListener onGetOaidListener) {
        if (context != null) {
            final Context applicationContext = context.getApplicationContext();
            new Thread(new Runnable() {
                /* class com.umeng.commonsdk.internal.c.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    String a2 = ar.a(applicationContext);
                    OnGetOaidListener onGetOaidListener = onGetOaidListener;
                    if (onGetOaidListener != null) {
                        onGetOaidListener.onGetOaid(a2);
                    }
                }
            }).start();
        }
    }

    private static void c(final Context context) {
        if (FieldManager.allow("header_device_oaid") && Build.VERSION.SDK_INT > 28) {
            a(context, new OnGetOaidListener() {
                /* class com.umeng.commonsdk.internal.c.AnonymousClass3 */

                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            SharedPreferences sharedPreferences = context.getSharedPreferences("umeng_sp_oaid", 0);
                            if (sharedPreferences != null && !sharedPreferences.getString("key_umeng_sp_oaid", "").equalsIgnoreCase(str)) {
                                UMRTLog.e("MobclickRT", "--->>> 更新本地缓存OAID");
                                SharedPreferences.Editor edit = sharedPreferences.edit();
                                edit.putString("key_umeng_sp_oaid", str);
                                edit.commit();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        }
    }

    private void e() {
        if (!f1484l) {
            if (FieldManager.allow("header_device_oaid") && Build.VERSION.SDK_INT > 28) {
                f1484l = true;
                a(this.d, new OnGetOaidListener() {
                    /* class com.umeng.commonsdk.internal.c.AnonymousClass4 */

                    @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                    public void onGetOaid(String str) {
                        UMRTLog.e("MobclickRT", "--->>> OAID云控参数更新(不采集->采集)：采集完成");
                        if (TextUtils.isEmpty(str)) {
                            UMRTLog.e("MobclickRT", "--->>> oaid返回null或者空串，不需要 伪冷启动。");
                            return;
                        }
                        try {
                            SharedPreferences sharedPreferences = c.this.d.getSharedPreferences("umeng_sp_oaid", 0);
                            if (sharedPreferences != null) {
                                SharedPreferences.Editor edit = sharedPreferences.edit();
                                edit.putString("key_umeng_sp_oaid", str);
                                edit.commit();
                            }
                        } catch (Throwable unused) {
                        }
                        UMWorkDispatch.sendEvent(c.this.d, 32788, b.a(c.this.d).a(), null);
                    }
                });
            }
        } else if (!FieldManager.allow("header_device_oaid")) {
            f1484l = false;
        }
    }

    private void f() {
        if (FieldManager.allow("header_device_oaid") && Build.VERSION.SDK_INT > 28) {
            f1484l = true;
            UMConfigureImpl.registerInterruptFlag();
            UMConfigureImpl.init(this.d);
            e++;
            UMRTLog.e("MobclickRT", "--->>> 要读取 oaid，需等待读取结果.");
            UMConfigureImpl.registerMessageSendListener(new onMessageSendListener() {
                /* class com.umeng.commonsdk.internal.c.AnonymousClass5 */

                @Override // com.umeng.commonsdk.utils.onMessageSendListener
                public void onMessageSend() {
                    if (c.this.d != null) {
                        UMWorkDispatch.sendEvent(c.this.d, 32790, b.a(c.this.d).a(), null);
                    }
                    UMConfigureImpl.removeMessageSendListener(this);
                }
            });
            b(this.d);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e2, code lost:
        if (r13.isDirectory() != false) goto L_0x00e6;
     */
    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void workEvent(Object obj, int i2) {
        boolean z = true;
        boolean z2 = false;
        ULog.i("walle", "[internal] workEvent");
        if (i2 == 32769) {
            ULog.i("walle", "[internal] workEvent send envelope");
            Class<?> cls = Class.forName("com.umeng.commonsdk.internal.UMInternalManagerAgent");
            if (cls != null) {
                cls.getMethod("sendInternalEnvelopeByStateful2", Context.class).invoke(cls, this.d);
            }
        } else if (i2 != 32781) {
            if (i2 != 32801) {
                switch (i2) {
                    case 32771:
                        ULog.i("walle", "[internal] workEvent cache battery, event is " + obj.toString());
                        Class<?> cls2 = Class.forName("com.umeng.commonsdk.internal.utils.UMInternalUtilsAgent");
                        if (cls2 != null) {
                            cls2.getMethod("saveBattery", Context.class, String.class).invoke(cls2, this.d, (String) obj);
                            return;
                        }
                        return;
                    case 32772:
                        ULog.i("walle", "[internal] workEvent cache station, event is " + obj.toString());
                        Class<?> cls3 = Class.forName("com.umeng.commonsdk.internal.utils.UMInternalUtilsAgent");
                        if (cls3 != null) {
                            cls3.getMethod("saveBaseStationStrength", Context.class, String.class).invoke(cls3, this.d, (String) obj);
                            return;
                        }
                        return;
                    default:
                        switch (i2) {
                            case 32774:
                                Class<?> cls4 = Class.forName("com.umeng.commonsdk.internal.utils.ApplicationLayerUtilAgent");
                                if (cls4 != null) {
                                    cls4.getMethod("wifiChange", Context.class).invoke(cls4, this.d);
                                    return;
                                }
                                return;
                            case 32775:
                                try {
                                    Class<?> cls5 = Class.forName("com.umeng.commonsdk.internal.utils.InfoPreferenceAgent");
                                    if (cls5 != null) {
                                        cls5.getMethod("saveUA", Context.class, String.class).invoke(cls5, this.d, (String) obj);
                                        return;
                                    }
                                    return;
                                } catch (Throwable unused) {
                                    return;
                                }
                            case 32776:
                                SharedPreferences sharedPreferences = this.d.getApplicationContext().getSharedPreferences("info", 0);
                                if (sharedPreferences != null) {
                                    sharedPreferences.edit().putString("stat", (String) obj).commit();
                                    return;
                                }
                                return;
                            case 32777:
                                ULog.i("walle", "[internal] workEvent send envelope");
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("i_sdk_v", "1.2.0");
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("inner", new JSONObject());
                                JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(this.d, jSONObject, jSONObject2);
                                if (buildEnvelopeWithExtHeader != null && !buildEnvelopeWithExtHeader.has("exception")) {
                                    ULog.i("walle", "[internal] workEvent send envelope back, result is ok");
                                    return;
                                }
                                return;
                            case 32778:
                                Context context = this.d;
                                if (context != null) {
                                    try {
                                        SharedPreferences sharedPreferences2 = context.getSharedPreferences("umeng_sp_zdata", 0);
                                        long currentTimeMillis = System.currentTimeMillis();
                                        String c2 = c();
                                        long currentTimeMillis2 = System.currentTimeMillis();
                                        if (!TextUtils.isEmpty(c2) && sharedPreferences2 != null) {
                                            SharedPreferences.Editor edit = sharedPreferences2.edit();
                                            edit.putString("umeng_zdata", c2);
                                            edit.putLong("umeng_zdata_req_ts", currentTimeMillis2 - currentTimeMillis);
                                            edit.commit();
                                        }
                                    } catch (Throwable unused2) {
                                    }
                                    Context context2 = this.d;
                                    UMWorkDispatch.sendEvent(context2, 32789, b.a(context2).a(), null);
                                    return;
                                }
                                return;
                            case 32779:
                                Sender.handleEvent(this.d, (com.umeng.commonsdk.vchannel.b) obj);
                                return;
                            default:
                                switch (i2) {
                                    case 32784:
                                        UMRTLog.e("MobclickRT", "--->>> 零号报文流程，接收到云控配置加载成功通知(成功收到零号报文应答)。");
                                        f();
                                        e--;
                                        g();
                                        return;
                                    case 32785:
                                        UMRTLog.e("MobclickRT", "--->>> [有状态]接收到消费二级缓存数据通知.");
                                        if (bc.a(this.d).c()) {
                                            UMRTLog.e("MobclickRT", "--->>> [有状态]已消费完毕,二级缓存数据库为空.");
                                            return;
                                        }
                                        d();
                                        if (!UMWorkDispatch.eventHasExist(32785)) {
                                            Context context3 = this.d;
                                            UMWorkDispatch.sendEvent(context3, 32785, b.a(context3).a(), null);
                                            return;
                                        }
                                        return;
                                    case 32786:
                                        UMCrashManager.buildEnvelope(this.d, obj);
                                        return;
                                    case 32787:
                                        UMRTLog.e("MobclickRT", "--->>> 触发2号仓遗留信封检查动作。");
                                        String a2 = d.a(this.d, false);
                                        String a3 = d.a(this.d, true);
                                        if (!TextUtils.isEmpty(a2)) {
                                            File file = new File(a2);
                                            if (file.exists() && file.isDirectory()) {
                                                z2 = true;
                                            }
                                        }
                                        if (!TextUtils.isEmpty(a3)) {
                                            File file2 = new File(a3);
                                            if (file2.exists()) {
                                                break;
                                            }
                                        }
                                        z = z2;
                                        if (!z) {
                                            UMRTLog.e("MobclickRT", "--->>> 触发2号仓遗留信封检查，没有需要处理的目录，不需要处理。");
                                            return;
                                        } else if (!com.umeng.commonsdk.stateless.b.a()) {
                                            new com.umeng.commonsdk.stateless.b(this.d);
                                            com.umeng.commonsdk.stateless.b.b();
                                            return;
                                        } else {
                                            UMRTLog.e("MobclickRT", "--->>> 触发2号仓遗留信封检查，Sender已创建，不需要处理。");
                                            return;
                                        }
                                    case 32788:
                                        UMRTLog.e("MobclickRT", "--->>> 云控下发参数更新，触发 伪冷启动。");
                                        b.a();
                                        e();
                                        if (FieldManager.allow("header_foreground_count") && !UMWorkDispatch.eventHasExist()) {
                                            UMRTLog.e("MobclickRT", "--->>> 云控下发参数更新 前台计数器功能 打开，触发 5秒周期检查机制");
                                            Context context4 = this.d;
                                            UMWorkDispatch.sendEventEx(context4, 8213, CoreProtocol.getInstance(context4), null, 5000);
                                        }
                                        if (FieldManager.allow("header_first_resume")) {
                                            UMRTLog.e("MobclickRT", "--->>> 云控下发参数更新 FirstResume功能 打开，触发 trigger");
                                            k.a(this.d).b(this.d);
                                            return;
                                        }
                                        return;
                                    case 32789:
                                        UMRTLog.e("MobclickRT", "--->>> 成功接收到(ZDATA)读取结束通知。");
                                        e--;
                                        g();
                                        return;
                                    case 32790:
                                        UMRTLog.e("MobclickRT", "--->>> 成功接收到(OAID)读取结束通知。");
                                        e--;
                                        g();
                                        return;
                                    case 32791:
                                        UMRTLog.e("MobclickRT", "--->>> 正常冷启动流程，接收到云控配置加载成功通知。");
                                        c(this.d);
                                        a.a(this.d);
                                        return;
                                    default:
                                        return;
                                }
                        }
                }
            } else {
                SelfChecker.doCheck(this.d);
            }
        } else if (!UMFrUtils.hasEnvelopeFile(this.d, UMLogDataProtocol.UMBusinessType.U_ZeroEnv)) {
            UMRTLog.e("MobclickRT", "--->>> 构建零号报文");
            a(this.d);
        } else {
            UMRTLog.e("MobclickRT", "--->>> 零号报文信封文件已存在，尝试发送之!");
        }
    }

    private void g() {
        if (e <= 0) {
            h();
        }
    }

    private static void d(Context context) {
        File filesDir = context.getFilesDir();
        File file = new File(filesDir.getAbsolutePath() + File.separator + "umeng_zcfg_flag");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable unused) {
            }
        }
    }

    private void h() {
        UMRTLog.e("MobclickRT", "--->>> 真实构建条件满足，开始构建业务信封。");
        if (UMUtils.isMainProgress(this.d)) {
            d(this.d);
            a.a(this.d);
            Context context = this.d;
            UMWorkDispatch.sendEvent(context, 8208, CoreProtocol.getInstance(context), null);
            Context context2 = this.d;
            UMWorkDispatch.sendEvent(context2, 32785, b.a(context2).a(), null);
        }
    }
}
