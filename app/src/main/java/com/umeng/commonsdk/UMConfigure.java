package com.umeng.commonsdk;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.umeng.analytics.pro.ar;
import com.umeng.analytics.pro.k;
import com.umeng.cconfig.UMRemoteConfig;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.a;
import com.umeng.commonsdk.statistics.b;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UMConfigure {
    public static final int DEVICE_TYPE_BOX = 2;
    public static final int DEVICE_TYPE_PHONE = 1;
    private static final String KEY_FILE_NAME_APPKEY = "APPKEY";
    private static final String KEY_FILE_NAME_LOG = "LOG";
    private static final String KEY_METHOD_NAME_PUSH_SETCHANNEL = "setMessageChannel";
    private static final String KEY_METHOD_NAME_PUSH_SET_SECRET = "setSecret";
    private static final String KEY_METHOD_NAME_SETAPPKEY = "setAppkey";
    private static final String KEY_METHOD_NAME_SETCHANNEL = "setChannel";
    private static final String KEY_METHOD_NAME_SETDEBUGMODE = "setDebugMode";
    private static Object PreInitLock = new Object();
    private static final String TAG = "UMConfigure";
    private static final String WRAPER_TYPE_COCOS2DX_X = "Cocos2d-x";
    private static final String WRAPER_TYPE_COCOS2DX_XLUA = "Cocos2d-x_lua";
    private static final String WRAPER_TYPE_FLUTTER = "flutter";
    private static final String WRAPER_TYPE_HYBRID = "hybrid";
    private static final String WRAPER_TYPE_NATIVE = "native";
    private static final String WRAPER_TYPE_PHONEGAP = "phonegap";
    private static final String WRAPER_TYPE_REACTNATIVE = "react-native";
    private static final String WRAPER_TYPE_UNITY = "Unity";
    private static final String WRAPER_TYPE_WEEX = "weex";
    private static boolean debugLog;
    private static boolean isFinish = false;
    public static boolean isInit = false;
    private static Object lockObject = new Object();
    private static OnGetOaidListener mOnGetOaidListener;
    private static boolean preInitComplete = false;
    public static String sAppkey = "";
    public static String sChannel = "";
    private static boolean sShouldCollectZData = true;
    public static UMLog umDebugLog = new UMLog();

    private static Class<?> getClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static Object getDecInstanceObject(Class<?> cls) {
        Constructor<?> constructor;
        if (cls == null) {
            return null;
        }
        try {
            constructor = cls.getDeclaredConstructor(new Class[0]);
        } catch (NoSuchMethodException unused) {
            constructor = null;
        }
        if (constructor == null) {
            return null;
        }
        constructor.setAccessible(true);
        try {
            return constructor.newInstance(new Object[0]);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused2) {
            return null;
        }
    }

    private static Method getDecMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        Method method = null;
        if (cls != null) {
            try {
                method = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
            }
            if (method != null) {
                method.setAccessible(true);
            }
        }
        return method;
    }

    private static void invoke(Method method, Object obj, Object[] objArr) {
        if (method != null && obj != null) {
            try {
                method.invoke(obj, objArr);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    private static void invoke(Method method, Object[] objArr) {
        if (method != null) {
            try {
                method.invoke(null, objArr);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    private static void setFile(Class<?> cls, String str, String str2) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, str2);
            } catch (Exception unused) {
            }
        }
    }

    private static void setFile(Class<?> cls, String str, boolean z) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, Boolean.valueOf(z));
            } catch (Exception unused) {
            }
        }
    }

    public static boolean getInitStatus() {
        boolean z;
        synchronized (lockObject) {
            z = isFinish;
        }
        return z;
    }

    private static boolean checkShareSdk(Class<?> cls) {
        try {
            return cls.getDeclaredField("isZyb") != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean shouldCollectZData() {
        return sShouldCollectZData;
    }

    public static void init(Context context, int i, String str) {
        init(context, null, null, i, str);
    }

    private static boolean isPreInit() {
        boolean z;
        synchronized (PreInitLock) {
            z = preInitComplete;
        }
        return z;
    }

    public static void preInit(Context context, String str, String str2) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            if (TextUtils.isEmpty(str)) {
                str = UMUtils.getAppkeyByXML(applicationContext);
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = UMUtils.getChannelByXML(applicationContext);
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "Unknown";
            }
            if (!TextUtils.isEmpty(str)) {
                sAppkey = str;
                sChannel = str2;
                UMGlobalContext.getInstance(applicationContext);
                k.a(applicationContext);
                if (!needSendZcfgEnv(applicationContext)) {
                    FieldManager.a().a(applicationContext);
                }
                synchronized (PreInitLock) {
                    preInitComplete = true;
                }
            }
        } else if (debugLog) {
            Log.e("UMConfigure", "preInit: context is null, pls check!");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:186:0x03f4, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x03f7, code lost:
        if (com.umeng.commonsdk.UMConfigure.debugLog != false) goto L_0x03f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x03f9, code lost:
        android.util.Log.e("UMConfigure", "init e is " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0410, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0413, code lost:
        if (com.umeng.commonsdk.UMConfigure.debugLog != false) goto L_0x0415;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0415, code lost:
        android.util.Log.e("UMConfigure", "init e is " + r11);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x03f4 A[ExcHandler: all (r11v4 'th' java.lang.Object A[CUSTOM_DECLARE]), Splitter:B:1:0x0001] */
    public static void init(Context context, String str, String str2, int i, String str3) {
        Method declaredMethod;
        Method declaredMethod2;
        Method declaredMethod3;
        Method declaredMethod4;
        Object invoke;
        Class<?> cls;
        Method declaredMethod5;
        Method declaredMethod6;
        try {
            if (debugLog) {
                Log.i("UMConfigure", "common version is 9.3.3");
                Log.i("UMConfigure", "common type is " + SdkVersion.SDK_TYPE);
            }
            if (context == null) {
                if (debugLog) {
                    Log.e("UMConfigure", "context is null !!!");
                }
            } else if (!isInit) {
                final Context applicationContext = context.getApplicationContext();
                try {
                    if (getClass("com.umeng.umzid.Spy") == null) {
                        Log.e("UMConfigure", "--->>> SDK 初始化失败，请检查是否集成umeng-asms-x.x.x.aar库。<<<--- ");
                        new Thread() {
                            /* class com.umeng.commonsdk.UMConfigure.AnonymousClass1 */

                            @Override // java.lang.Thread, java.lang.Runnable
                            public void run() {
                                try {
                                    Looper.prepare();
                                    Toast.makeText(applicationContext, "SDK 初始化失败，请检查是否集成umeng-asms-x.x.X.aar库。", 1).show();
                                    Looper.loop();
                                } catch (Throwable unused) {
                                }
                            }
                        }.start();
                        return;
                    }
                } catch (Throwable unused) {
                }
                try {
                    Class<?> cls2 = getClass("com.umeng.message.PushAgent");
                    if (cls2 != null && !checkShareSdk(cls2)) {
                        Log.e("UMLog", "基础组件库9.4.0版本仅支持6.2.0及更高版本推送SDK、7.1.0及更高版本分享SDK。");
                        new Thread() {
                            /* class com.umeng.commonsdk.UMConfigure.AnonymousClass2 */

                            @Override // java.lang.Thread, java.lang.Runnable
                            public void run() {
                                try {
                                    Looper.prepare();
                                    Toast.makeText(applicationContext, "基础组件库9.4.0版本仅支持6.2.0及更高版本推送SDK、7.1.0及更高版本分享SDK。", 1).show();
                                    Looper.loop();
                                } catch (Throwable unused) {
                                }
                            }
                        }.start();
                    }
                } catch (Throwable unused2) {
                }
                try {
                    Class<?> cls3 = getClass("com.umeng.socialize.UMShareAPI");
                    if (cls3 != null && !checkShareSdk(cls3)) {
                        Log.e("UMLog", "基础组件库9.4.0版本仅支持6.2.0及更高版本推送SDK、7.1.0及更高版本分享SDK。");
                        new Thread() {
                            /* class com.umeng.commonsdk.UMConfigure.AnonymousClass3 */

                            @Override // java.lang.Thread, java.lang.Runnable
                            public void run() {
                                try {
                                    Looper.prepare();
                                    Toast.makeText(applicationContext, "基础组件库9.4.0版本仅支持6.2.0及更高版本推送SDK、7.1.0及更高版本分享SDK。", 1).show();
                                    Looper.loop();
                                } catch (Throwable unused) {
                                }
                            }
                        }.start();
                    }
                } catch (Throwable unused3) {
                }
                if (!isPreInit()) {
                    preInit(applicationContext, str, str2);
                    if (!isPreInit()) {
                        return;
                    }
                }
                UMUtils.setAppkey(applicationContext, sAppkey);
                String lastAppkey = UMUtils.getLastAppkey(applicationContext);
                if (!TextUtils.isEmpty(sAppkey) && !sAppkey.equals(lastAppkey)) {
                    if (!TextUtils.isEmpty(lastAppkey) && debugLog) {
                        UMLog.mutlInfo("AppKey改变!!!", 2, "");
                    }
                    UMUtils.setLastAppkey(applicationContext, sAppkey);
                }
                if (debugLog) {
                    Log.i("UMConfigure", "current appkey is " + sAppkey + ", last appkey is " + lastAppkey);
                }
                if (debugLog) {
                    String appkeyByXML = UMUtils.getAppkeyByXML(applicationContext);
                    if (!TextUtils.isEmpty(sAppkey) && !TextUtils.isEmpty(appkeyByXML) && !sAppkey.equals(appkeyByXML)) {
                        UMLog.mutlInfo("请注意：您init接口中设置的AppKey是@，manifest中设置的AppKey是#，init接口设置的AppKey会覆盖manifest中设置的AppKey", 3, "", new String[]{"@", "#"}, new String[]{sAppkey, appkeyByXML});
                    }
                }
                UMUtils.setChannel(applicationContext, sChannel);
                if (debugLog) {
                    Log.i("UMConfigure", "channel is " + sChannel);
                }
                if (sShouldCollectZData) {
                    readZData(applicationContext);
                }
                try {
                    Class<?> cls4 = Class.forName("com.umeng.analytics.MobclickAgent");
                    if (cls4 != null) {
                        Method declaredMethod7 = cls4.getDeclaredMethod("init", Context.class);
                        if (declaredMethod7 != null) {
                            declaredMethod7.setAccessible(true);
                            declaredMethod7.invoke(cls4, applicationContext);
                            if (FieldManager.allow("header_first_resume")) {
                                UMRTLog.i("MobclickRT", "--->>> FirstResumeTrigger enabled.");
                                k.a(applicationContext).b(applicationContext);
                            } else {
                                UMRTLog.i("MobclickRT", "--->>> FirstResumeTrigger disabled.");
                            }
                            if (debugLog) {
                                UMLog.mutlInfo("统计SDK初始化成功", 2, "");
                            }
                        }
                        if (!(Class.forName("com.umeng.analytics.game.UMGameAgent") == null || (declaredMethod6 = cls4.getDeclaredMethod("setGameScenarioType", Context.class)) == null)) {
                            declaredMethod6.setAccessible(true);
                            declaredMethod6.invoke(cls4, applicationContext);
                        }
                    }
                    if (!(b.a.indexOf("e") < 0 || (cls = Class.forName("com.umeng.analytics.MobclickAgent")) == null || (declaredMethod5 = cls.getDeclaredMethod("disableExceptionCatch", new Class[0])) == null)) {
                        declaredMethod5.setAccessible(true);
                        declaredMethod5.invoke(cls, new Object[0]);
                    }
                } catch (Throwable unused4) {
                }
                Class<?> cls5 = Class.forName("com.umeng.message.MessageSharedPrefs");
                if (!(cls5 == null || (declaredMethod4 = cls5.getDeclaredMethod("getInstance", Context.class)) == null || (invoke = declaredMethod4.invoke(cls5, applicationContext)) == null)) {
                    Method declaredMethod8 = cls5.getDeclaredMethod("setMessageAppKey", String.class);
                    if (declaredMethod8 != null) {
                        declaredMethod8.setAccessible(true);
                        declaredMethod8.invoke(invoke, sAppkey);
                        if (debugLog) {
                            UMLog.mutlInfo("PUSH AppKey设置成功", 2, "");
                        }
                    }
                    Method declaredMethod9 = cls5.getDeclaredMethod("setMessageChannel", String.class);
                    if (declaredMethod9 != null) {
                        declaredMethod9.setAccessible(true);
                        declaredMethod9.invoke(invoke, sChannel);
                        if (debugLog) {
                            UMLog.mutlInfo("PUSH Channel设置成功", 2, "");
                        }
                    }
                    if (TextUtils.isEmpty(str3)) {
                        boolean z = debugLog;
                    } else {
                        if (debugLog) {
                            Log.i("UMConfigure", "push secret is " + str3);
                        }
                        Method declaredMethod10 = cls5.getDeclaredMethod("setMessageAppSecret", String.class);
                        if (declaredMethod10 != null) {
                            declaredMethod10.setAccessible(true);
                            declaredMethod10.invoke(invoke, str3);
                            if (debugLog) {
                                UMLog.mutlInfo("PUSH Secret设置成功", 2, "");
                            }
                        }
                    }
                }
                try {
                    Class<?> cls6 = getClass("com.umeng.socialize.UMShareAPI");
                    setFile(cls6, "APPKEY", sAppkey);
                    if (!(cls6 == null || (declaredMethod3 = cls6.getDeclaredMethod("init", Context.class, String.class)) == null)) {
                        declaredMethod3.setAccessible(true);
                        declaredMethod3.invoke(cls6, applicationContext, sAppkey);
                        if (debugLog) {
                            UMLog.mutlInfo("Share AppKey设置成功", 2, "");
                        }
                    }
                } catch (Throwable unused5) {
                }
                AnalyticsConstants.setDeviceType(i);
                try {
                    Class<?> cls7 = Class.forName("com.umeng.error.UMError");
                    if (!(cls7 == null || (declaredMethod2 = cls7.getDeclaredMethod("init", Context.class)) == null)) {
                        declaredMethod2.setAccessible(true);
                        declaredMethod2.invoke(cls7, applicationContext);
                        if (debugLog) {
                            UMLog.mutlInfo("错误分析SDK初始化成功", 2, "");
                        }
                    }
                } catch (Throwable unused6) {
                }
                try {
                    Class<?> cls8 = Class.forName("com.umeng.umcrash.UMCrash");
                    if (!(cls8 == null || (declaredMethod = cls8.getDeclaredMethod("init", Context.class, String.class, String.class)) == null)) {
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(cls8, applicationContext, sAppkey, sChannel);
                        if (debugLog) {
                            UMLog.mutlInfo("APM SDK初始化成功", 2, "");
                        }
                    }
                } catch (Throwable unused7) {
                }
                try {
                    Method declaredMethod11 = Class.forName("com.umeng.vt.facade.EventFacade").getDeclaredMethod("init", Application.class, String.class, String.class, Integer.TYPE, String.class);
                    if (declaredMethod11 != null) {
                        declaredMethod11.invoke(null, applicationContext, sAppkey, sChannel, Integer.valueOf(i), str3);
                        UMRTLog.i("MobclickRT", "--->>>初始化 EventFacade 成功.");
                    }
                } catch (ClassNotFoundException unused8) {
                }
                try {
                    Method declaredMethod12 = Class.forName("com.umeng.vt.common.VTTracker").getDeclaredMethod("init", Application.class, String.class);
                    if (declaredMethod12 != null) {
                        declaredMethod12.invoke(null, applicationContext, sAppkey);
                        UMRTLog.i("MobclickRT", "--->>>初始化 VTTracker 成功.");
                    }
                } catch (ClassNotFoundException unused9) {
                }
                synchronized (lockObject) {
                    isFinish = true;
                }
                if (needSendZcfgEnv(applicationContext)) {
                    UMRTLog.e("MobclickRT", "--->>> 走零号报文发送逻辑");
                    UMWorkDispatch.sendEvent(applicationContext, 32781, com.umeng.commonsdk.internal.b.a(applicationContext).a(), null);
                } else {
                    UMRTLog.e("MobclickRT", "--->>> 走正常逻辑.");
                    if (FieldManager.b()) {
                        UMWorkDispatch.sendEvent(applicationContext, 32791, com.umeng.commonsdk.internal.b.a(applicationContext).a(), null);
                    }
                }
                if (isDebugLog()) {
                    UMConfigureInternation.doSelfCheck(applicationContext);
                }
                try {
                    UMRemoteConfig.getInstance().init(context);
                } catch (Exception unused10) {
                }
                if (!isInit) {
                    isInit = true;
                }
            } else if (debugLog) {
                Log.e("UMConfigure", "has inited !!!");
            }
        } catch (Exception unused11) {
        } catch (Throwable th) {
        }
    }

    public static boolean needSendZcfgEnv(Context context) {
        File filesDir = context.getFilesDir();
        StringBuilder sb = new StringBuilder();
        sb.append(filesDir.getAbsolutePath());
        sb.append(File.separator);
        sb.append("umeng_zcfg_flag");
        return !new File(sb.toString()).exists();
    }

    public static boolean isDebugLog() {
        return debugLog;
    }

    public static void setLogEnabled(boolean z) {
        try {
            debugLog = z;
            MLog.DEBUG = z;
            Class<?> cls = getClass("com.umeng.message.PushAgent");
            invoke(getDecMethod(cls, "setDebugMode", new Class[]{Boolean.TYPE}), getDecInstanceObject(cls), new Object[]{Boolean.valueOf(z)});
            setFile(getClass("com.umeng.socialize.Config"), "DEBUG", z);
            invoke(getDecMethod(getClass("com.umeng.umcrash.UMCrash"), "setDebug", new Class[]{Boolean.TYPE}), new Object[]{Boolean.valueOf(z)});
        } catch (Exception e) {
            if (debugLog) {
                Log.e("UMConfigure", "set log enabled e is " + e);
            }
        } catch (Throwable th) {
            if (debugLog) {
                Log.e("UMConfigure", "set log enabled e is " + th);
            }
        }
    }

    public static void setEncryptEnabled(boolean z) {
        b.a(z);
    }

    public static String getUMIDString(Context context) {
        if (context != null) {
            return UMUtils.getUMId(context.getApplicationContext());
        }
        return null;
    }

    public static String getUmengToken(Context context) {
        if (context != null) {
            return UMUtils.getUmengToken(context.getApplicationContext());
        }
        return null;
    }

    public static void setProcessEvent(boolean z) {
        AnalyticsConstants.SUB_PROCESS_EVENT = z;
    }

    private static void setLatencyWindow(long j) {
        a.c = ((int) j) * 1000;
    }

    private static void setCheckDevice(boolean z) {
        AnalyticsConstants.CHECK_DEVICE = z;
    }

    private static void setWraperType(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("native")) {
                com.umeng.commonsdk.stateless.a.a = "native";
                a.a = "native";
            } else if (str.equals("Cocos2d-x")) {
                com.umeng.commonsdk.stateless.a.a = "Cocos2d-x";
                a.a = "Cocos2d-x";
            } else if (str.equals("Cocos2d-x_lua")) {
                com.umeng.commonsdk.stateless.a.a = "Cocos2d-x_lua";
                a.a = "Cocos2d-x_lua";
            } else if (str.equals("Unity")) {
                com.umeng.commonsdk.stateless.a.a = "Unity";
                a.a = "Unity";
            } else if (str.equals("react-native")) {
                com.umeng.commonsdk.stateless.a.a = "react-native";
                a.a = "react-native";
            } else if (str.equals("phonegap")) {
                com.umeng.commonsdk.stateless.a.a = "phonegap";
                a.a = "phonegap";
            } else if (str.equals("weex")) {
                com.umeng.commonsdk.stateless.a.a = "weex";
                a.a = "weex";
            } else if (str.equals("hybrid")) {
                com.umeng.commonsdk.stateless.a.a = "hybrid";
                a.a = "hybrid";
            } else if (str.equals("flutter")) {
                com.umeng.commonsdk.stateless.a.a = "flutter";
                a.a = "flutter";
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            com.umeng.commonsdk.stateless.a.b = str2;
            a.b = str2;
        }
    }

    public static String[] getTestDeviceInfo(Context context) {
        String[] strArr = new String[2];
        if (context != null) {
            try {
                strArr[0] = DeviceConfig.getDeviceIdForGeneral(context);
                strArr[1] = DeviceConfig.getMac(context);
            } catch (Exception unused) {
            }
        }
        return strArr;
    }

    private static void readZData(Context context) {
        UMWorkDispatch.sendEvent(context, 32778, com.umeng.commonsdk.internal.b.a(context).a(), null);
    }

    public static void getOaid(Context context, OnGetOaidListener onGetOaidListener) {
        if (context != null) {
            final Context applicationContext = context.getApplicationContext();
            mOnGetOaidListener = onGetOaidListener;
            new Thread(new Runnable() {
                /* class com.umeng.commonsdk.UMConfigure.AnonymousClass4 */

                @Override // java.lang.Runnable
                public void run() {
                    String a2 = ar.a(applicationContext);
                    if (UMConfigure.mOnGetOaidListener != null) {
                        UMConfigure.mOnGetOaidListener.onGetOaid(a2);
                    }
                }
            }).start();
        } else if (debugLog) {
            Log.e("UMConfigure", "context is null !!!");
        }
    }
}
