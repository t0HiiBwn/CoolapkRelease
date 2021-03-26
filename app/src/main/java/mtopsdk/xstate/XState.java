package mtopsdk.xstate;

import android.content.Context;
import android.os.RemoteException;
import com.ta.utdid2.device.UTDevice;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.common.util.AsyncServiceBinder;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.xstate.aidl.IXState;
import mtopsdk.xstate.util.PhoneInfo;

public class XState {
    static volatile AtomicBoolean a = new AtomicBoolean(false);
    private static final ConcurrentHashMap<String, String> b = new ConcurrentHashMap<>();
    private static AsyncServiceBinder<IXState> c;
    private static AtomicBoolean d = new AtomicBoolean(false);
    private static Context e = null;

    public static void init(Context context, HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            try {
                String str = (String) hashMap.get("deviceId");
                if (str != null) {
                    b.put("utdid", str);
                }
            } catch (Throwable unused) {
                TBSdkLog.e("mtopsdk.XState", "[init]init error, params get exception");
                return;
            }
        }
        init(context);
    }

    public static void init(Context context) {
        String utdid;
        if (context == null) {
            TBSdkLog.e("mtopsdk.XState", "[init]init error,context is null");
        } else if (d.compareAndSet(false, true)) {
            e = context.getApplicationContext();
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.XState", "[init]XState init called");
            }
            try {
                String phoneBaseInfo = PhoneInfo.getPhoneBaseInfo(context);
                if (phoneBaseInfo != null) {
                    b.put("ua", phoneBaseInfo);
                }
                ConcurrentHashMap<String, String> concurrentHashMap = b;
                if (concurrentHashMap.get("utdid") == null && (utdid = UTDevice.getUtdid(context)) != null) {
                    concurrentHashMap.put("utdid", utdid);
                }
                concurrentHashMap.put("t_offset", "0");
            } catch (Throwable th) {
                TBSdkLog.e("mtopsdk.XState", "[initPhoneInfo]initPhoneInfo error", th);
            }
            if (c == null) {
                a aVar = new a(IXState.class, XStateService.class);
                c = aVar;
                aVar.asyncBind(context);
                return;
            }
            a();
        }
    }

    public static void unInit() {
        if (b()) {
            try {
                c.getService().unInit();
            } catch (RemoteException e2) {
                TBSdkLog.e("mtopsdk.XState", "[unInit] unInit error", e2);
            }
        }
        b.clear();
        d.set(false);
    }

    public static String getTimeOffset() {
        return getValue("t_offset");
    }

    public static String getLat() {
        return getValue("lat");
    }

    public static String getLng() {
        return getValue("lng");
    }

    public static String getNetworkQuality() {
        return getValue("nq");
    }

    public static String getNetworkType() {
        return getValue("netType");
    }

    public static boolean isAppBackground() {
        String value = getValue("AppBackground");
        if (value != null) {
            try {
                return Boolean.valueOf(value).booleanValue();
            } catch (Exception unused) {
                TBSdkLog.e("mtopsdk.XState", "[isAppBackground] parse KEY_APP_BACKGROUND error");
            }
        }
        return false;
    }

    public static void setAppBackground(boolean z) {
        setValue("AppBackground", String.valueOf(z));
    }

    public static String getValue(String str) {
        return getValue(null, str);
    }

    public static String getValue(String str, String str2) {
        if (StringUtils.isBlank(str2)) {
            return null;
        }
        if (StringUtils.isNotBlank(str)) {
            str2 = StringUtils.concatStr(str, str2);
        }
        if (!b() || !a.get()) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.XState", "[getValue]Attention :Use XState Local Mode: key:" + str2);
            }
            return b.get(str2);
        }
        try {
            return c.getService().getValue(str2);
        } catch (Exception e2) {
            TBSdkLog.e("mtopsdk.XState", "[getValue] IXState.getValue(Key) failed,key:" + str2, e2);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.XState", "[getValue]Attention :Use XState Local Mode: key:" + str2);
            }
            return b.get(str2);
        }
    }

    public static String removeKey(String str) {
        return removeKey(null, str);
    }

    public static String removeKey(String str, String str2) {
        if (StringUtils.isBlank(str2)) {
            return null;
        }
        if (StringUtils.isNotBlank(str)) {
            str2 = StringUtils.concatStr(str, str2);
        }
        if (!b() || !a.get()) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.XState", "[removeKey]Attention :Use XState Local Mode: key:" + str2);
            }
            b.remove(str2);
        } else {
            try {
                return c.getService().removeKey(str2);
            } catch (Exception e2) {
                TBSdkLog.e("mtopsdk.XState", "[removeKey] IXState.removeKey(key) failed,key:" + str2, e2);
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i("mtopsdk.XState", "[removeKey]Attention :Use XState Local Mode: key:" + str2);
                }
                b.remove(str2);
            }
        }
        return null;
    }

    public static void setValue(String str, String str2) {
        setValue(null, str, str2);
    }

    public static void setValue(String str, String str2, String str3) {
        if (!StringUtils.isBlank(str2) && !StringUtils.isBlank(str3)) {
            if (StringUtils.isNotBlank(str)) {
                str2 = StringUtils.concatStr(str, str2);
            }
            if (!b() || !a.get()) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
                    TBSdkLog.i("mtopsdk.XState", "[setValue]Attention :Use XState Local Mode: key:" + str2 + ",value:" + str3);
                }
                b.put(str2, str3);
                return;
            }
            try {
                c.getService().setValue(str2, str3);
            } catch (Exception e2) {
                TBSdkLog.e("mtopsdk.XState", "[setValue] IXState.setValue(key,value) failed,key:" + str2 + ",value:" + str3, e2);
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i("mtopsdk.XState", "[setValue]Attention :Use XState Local Mode: key:" + str2 + ",value:" + str3);
                }
                b.put(str2, str3);
            }
        }
    }

    static void a() {
        if (b()) {
            IXState service = c.getService();
            try {
                service.init();
                for (Map.Entry<String, String> entry : b.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    try {
                        service.setValue(key, value);
                        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                            TBSdkLog.i("mtopsdk.XState", "[syncToRemote] sync succeed, key:" + key + ",value:" + value);
                        }
                    } catch (Exception e2) {
                        TBSdkLog.e("mtopsdk.XState", "[syncToRemote] sync error, key:" + key + ",value:" + value, e2);
                    }
                }
                a.compareAndSet(false, true);
            } catch (Throwable th) {
                TBSdkLog.e("mtopsdk.XState", "syncToRemote error.", th);
            }
        }
    }

    private static boolean b() {
        AsyncServiceBinder<IXState> asyncServiceBinder = c;
        if (asyncServiceBinder == null) {
            return false;
        }
        if (asyncServiceBinder.getService() != null) {
            return true;
        }
        c.asyncBind(e);
        return false;
    }
}
