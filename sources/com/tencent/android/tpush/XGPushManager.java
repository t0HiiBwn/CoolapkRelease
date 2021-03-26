package com.tencent.android.tpush;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.android.tpush.b.f;
import com.tencent.android.tpush.common.ReturnCode;
import com.tencent.android.tpush.common.d;
import com.tencent.android.tpush.common.h;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.data.MessageId;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.XGVipPushService;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.android.tpush.service.util.g;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.security.Security;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.Md5;
import com.tencent.tpns.baseapi.base.util.NetworkUtil;
import com.tencent.tpns.baseapi.base.util.PushMd5Pref;
import com.tencent.tpns.baseapi.core.net.HttpRequestCallback;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class XGPushManager {
    public static final int OPERATION_FAIL = 1;
    public static final int OPERATION_REQ_REGISTER = 100;
    public static final int OPERATION_REQ_UNREGISTER = 101;
    public static final int OPERATION_SUCCESS = 0;
    private static boolean a = false;
    private static Context b = null;
    private static Long c = 0L;
    private static long d = 30000;
    private static volatile Runnable e = null;
    private static XGPushNotifactionCallback f = null;
    private static XGSysPushNotifactionCallback g = null;
    private static Map<b, c> h = new ConcurrentHashMap();
    public static Map<String, Long> lastSuccessRegisterMap = new HashMap();

    public static void onActivityStoped(Activity activity) {
        if (activity == null) {
        }
    }

    /* compiled from: ProGuard */
    public static class AccountInfo {
        public String accountName;
        public int accountType;

        public AccountInfo(int i, String str) {
            this.accountType = i;
            this.accountName = str;
        }
    }

    /* compiled from: ProGuard */
    public enum AccountType {
        UNKNOWN(0),
        CUSTOM(1),
        IMEI(1000),
        PHONE_NUMBER(1002),
        WX_OPEN_ID(1003),
        QQ_OPEN_ID(1004),
        EMAIL(1005),
        SINA_WEIBO(1006),
        ALIPAY(1007),
        TAOBAO(1008),
        DOUBAN(1009),
        FACEBOOK(1010),
        TWITTER(1011),
        GOOGLE(1012),
        BAIDU(1013),
        JINGDONG(1014),
        LINKEDIN(1015);
        
        private int value;

        private AccountType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    private XGPushManager() {
    }

    public static Context getContext() {
        return b;
    }

    public static void setContext(Context context) {
        if (b == null && context != null) {
            b = context.getApplicationContext();
        }
    }

    public static void startPushService(Context context) {
        if (context != null) {
            setContext(context);
            TLogger.ii("XGPushManager", context.getPackageName() + "call start Push Service");
            j.f(context);
            if (j.c(context) == 0) {
                j.e(context);
            }
        }
    }

    static void a(Context context) {
        if (context != null) {
            TLogger.ii("XGPushManager", context.getPackageName() + " call stop Push Service");
            Intent intent = new Intent();
            intent.setClass(context.getApplicationContext(), XGVipPushService.class);
            context.stopService(intent);
            ServiceConnection f2 = com.tencent.android.tpush.service.b.f();
            TLogger.d("XGPushManager", "vipConn:" + f2);
            if (f2 != null) {
                context.unbindService(f2);
                com.tencent.android.tpush.service.b.g();
            }
        }
    }

    public static void registerPush(Context context) {
        registerPush(context, new XGIOperateCallback() {
            /* class com.tencent.android.tpush.XGPushManager.AnonymousClass1 */

            @Override // com.tencent.android.tpush.XGIOperateCallback
            public void onSuccess(Object obj, int i) {
                TLogger.ii("XGPushManager", "TPNS register push success with token : " + obj);
            }

            @Override // com.tencent.android.tpush.XGIOperateCallback
            public void onFail(Object obj, int i, String str) {
                TLogger.ee("XGPushManager", "TPNS register push failed with token : " + obj + ", errCode : " + i + " , msg : " + str);
            }
        });
    }

    public static void registerPush(Context context, XGIOperateCallback xGIOperateCallback) {
        if (xGIOperateCallback != null) {
            a(context, null, -1, null, xGIOperateCallback, -1, null, null, null, null);
            return;
        }
        throw new IllegalArgumentException("The callback parameter can not be null!");
    }

    public static void registerPush(Context context, String str, String str2, String str3, XGIOperateCallback xGIOperateCallback) {
        if (xGIOperateCallback != null) {
            a(context, null, -1, null, xGIOperateCallback, -1, null, str, str2, str3);
            return;
        }
        throw new IllegalArgumentException("The callback parameter can not be null!");
    }

    @Deprecated
    public static void bindAccount(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        clearAndAppendAccount(context, str, xGIOperateCallback);
    }

    @Deprecated
    public static void clearAndAppendAccount(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        String a2 = a(str, 0);
        if (context == null || g.a(str) || g.a(a2)) {
            TLogger.ee("XGPushManager", "the parameter context or account of bindAccount is null.");
            if (context != null && xGIOperateCallback != null) {
                xGIOperateCallback.onFail("", ReturnCode.CODE_INVALID_ACCOUNT.getType(), ReturnCode.CODE_INVALID_ACCOUNT.getStr());
                return;
            }
            return;
        }
        b(context, a2, 0, (String) null, 0, str, xGIOperateCallback);
    }

    @Deprecated
    public static void bindAccount(Context context, String str, int i, XGIOperateCallback xGIOperateCallback) {
        clearAndAppendAccount(context, str, i, xGIOperateCallback);
    }

    @Deprecated
    public static void clearAndAppendAccount(Context context, String str, int i, XGIOperateCallback xGIOperateCallback) {
        String a2 = a(str, i);
        if (context == null || g.a(str) || g.a(a2)) {
            TLogger.ee("XGPushManager", "the parameter context or account of clearAndAppendAccount is null.");
            if (context != null && xGIOperateCallback != null) {
                xGIOperateCallback.onFail("", ReturnCode.CODE_INVALID_ACCOUNT.getType(), ReturnCode.CODE_INVALID_ACCOUNT.getStr());
                return;
            }
            return;
        }
        b(context, a2, 0, (String) null, 0, str, xGIOperateCallback);
    }

    @Deprecated
    public static void bindAccount(Context context, String str, int i) {
        clearAndAppendAccount(context, str, i);
    }

    @Deprecated
    public static void clearAndAppendAccount(Context context, final String str, int i) {
        if (context == null || g.a(str)) {
            TLogger.ee("XGPushManager", "the parameter context or account of bindAccount is null.");
        } else {
            clearAndAppendAccount(context, str, i, new XGIOperateCallback() {
                /* class com.tencent.android.tpush.XGPushManager.AnonymousClass12 */

                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onSuccess(Object obj, int i) {
                    TLogger.ii("XGPushManager", "TPNS binderAccount " + str + " success");
                }

                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onFail(Object obj, int i, String str) {
                    TLogger.ee("XGPushManager", "TPNS binderAccount " + str + " failed, errCode =  " + i + ", msg = " + str);
                }
            });
        }
    }

    @Deprecated
    public static void bindAccount(Context context, String str) {
        clearAndAppendAccount(context, str);
    }

    @Deprecated
    public static void clearAndAppendAccount(Context context, final String str) {
        if (context == null || g.a(str)) {
            TLogger.ee("XGPushManager", "the parameter context or account of bindAccount is null.");
        } else {
            clearAndAppendAccount(context, str, new XGIOperateCallback() {
                /* class com.tencent.android.tpush.XGPushManager.AnonymousClass18 */

                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onSuccess(Object obj, int i) {
                    TLogger.ii("XGPushManager", "TPNS binderAccount " + str + " success");
                }

                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onFail(Object obj, int i, String str) {
                    TLogger.ee("XGPushManager", "TPNS binderAccount " + str + " failed, errCode =  " + i + ", msg = " + str);
                }
            });
        }
    }

    @Deprecated
    public static void upsertAccounts(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        String a2 = a(str, 0);
        if (context == null || g.a(str) || g.a(a2)) {
            TLogger.ee("XGPushManager", "the parameter context or account of appendAccount is null.");
            if (context != null && xGIOperateCallback != null) {
                xGIOperateCallback.onFail("", ReturnCode.CODE_INVALID_ACCOUNT.getType(), ReturnCode.CODE_INVALID_ACCOUNT.getStr());
                return;
            }
            return;
        }
        b(context, a2, 0, (String) null, 2, str, xGIOperateCallback);
    }

    @Deprecated
    public static void upsertAccounts(Context context, String str, int i, XGIOperateCallback xGIOperateCallback) {
        String a2 = a(str, i);
        if (context == null || g.a(str) || g.a(a2)) {
            TLogger.ee("XGPushManager", "the parameter context or account of appendAccount is null.");
            if (context != null && xGIOperateCallback != null) {
                xGIOperateCallback.onFail("", ReturnCode.CODE_INVALID_ACCOUNT.getType(), ReturnCode.CODE_INVALID_ACCOUNT.getStr());
                return;
            }
            return;
        }
        b(context, a2, 0, (String) null, 2, str, xGIOperateCallback);
    }

    @Deprecated
    public static void upsertAccounts(Context context, final String str, int i) {
        if (context == null || g.a(str)) {
            TLogger.ee("XGPushManager", "the parameter context or account of appendAccount is null.");
        } else {
            upsertAccounts(context, str, i, new XGIOperateCallback() {
                /* class com.tencent.android.tpush.XGPushManager.AnonymousClass19 */

                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onSuccess(Object obj, int i) {
                    TLogger.ii("XGPushManager", "TPNS appendAccount " + str + " success");
                }

                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onFail(Object obj, int i, String str) {
                    TLogger.ee("XGPushManager", "TPNS appendAccount " + str + " failed, errCode =  " + i + ", msg = " + str);
                }
            });
        }
    }

    @Deprecated
    public static void upsertAccounts(Context context, final String str) {
        if (context == null || g.a(str)) {
            TLogger.ee("XGPushManager", "the parameter context or account of appendAccount is null.");
        } else {
            upsertAccounts(context, str, new XGIOperateCallback() {
                /* class com.tencent.android.tpush.XGPushManager.AnonymousClass20 */

                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onSuccess(Object obj, int i) {
                    TLogger.ii("XGPushManager", "TPNS appendAccount " + str + " success");
                }

                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onFail(Object obj, int i, String str) {
                    TLogger.ee("XGPushManager", "TPNS appendAccount " + str + " failed, errCode =  " + i + ", msg = " + str);
                }
            });
        }
    }

    public static void upsertAccounts(Context context, List<AccountInfo> list, XGIOperateCallback xGIOperateCallback) {
        String a2 = a(list);
        if (context == null || list == null || list.size() == 0 || TextUtils.isEmpty(a2)) {
            TLogger.ee("XGPushManager", "upsertAccounts | the parameter is illegal.");
            if (context != null && xGIOperateCallback != null) {
                xGIOperateCallback.onFail("", ReturnCode.CODE_INVALID_ACCOUNT.getType(), ReturnCode.CODE_INVALID_ACCOUNT.getStr());
                return;
            }
            return;
        }
        b(context, a2, 0, (String) null, 6, "", xGIOperateCallback);
    }

    @Deprecated
    public static void appendAccount(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        upsertAccounts(context, str, xGIOperateCallback);
    }

    @Deprecated
    public static void appendAccount(Context context, String str, int i, XGIOperateCallback xGIOperateCallback) {
        upsertAccounts(context, str, i, xGIOperateCallback);
    }

    @Deprecated
    public static void appendAccount(Context context, String str, int i) {
        upsertAccounts(context, str, i);
    }

    @Deprecated
    public static void appendAccount(Context context, String str) {
        upsertAccounts(context, str);
    }

    @Deprecated
    public static void delAccount(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        String a2 = a(str, 0);
        if (context == null || g.a(str) || g.a(a2)) {
            TLogger.ee("XGPushManager", "the parameter context or account of delAccount is null.");
            if (context != null && xGIOperateCallback != null) {
                xGIOperateCallback.onFail("", ReturnCode.CODE_INVALID_ACCOUNT.getType(), ReturnCode.CODE_INVALID_ACCOUNT.getStr());
                return;
            }
            return;
        }
        b(context, a2, 0, (String) null, 3, str, xGIOperateCallback);
    }

    @Deprecated
    public static void delAccountsByKeys(Context context, Set<Integer> set, XGIOperateCallback xGIOperateCallback) {
        delAccounts(context, set, xGIOperateCallback);
    }

    public static void delAccounts(Context context, Set<Integer> set, XGIOperateCallback xGIOperateCallback) {
        if (context == null || set == null || set.size() <= 0) {
            TLogger.ee("XGPushManager", "delAccounts | the parameter context or accounts of delAccounts is null.");
            if (context != null && xGIOperateCallback != null) {
                xGIOperateCallback.onFail("", ReturnCode.CODE_INVALID_ACCOUNT.getType(), ReturnCode.CODE_INVALID_ACCOUNT.getStr());
                return;
            }
            return;
        }
        String b2 = b(set);
        if (g.a(b2)) {
            TLogger.ee("XGPushManager", "delAccounts | accountTypeStr is empty");
            return;
        }
        TLogger.d("XGPushManager", "delAccounts | accountTypeStr : " + b2);
        b(context, b2, 0, (String) null, 7, b2, xGIOperateCallback);
    }

    @Deprecated
    public static void delAccount(Context context, String str, int i, XGIOperateCallback xGIOperateCallback) {
        String a2 = a(str, i);
        if (context == null || g.a(str) || g.a(a2)) {
            if (!(context == null || xGIOperateCallback == null)) {
                xGIOperateCallback.onFail("", ReturnCode.CODE_INVALID_ACCOUNT.getType(), ReturnCode.CODE_INVALID_ACCOUNT.getStr());
            }
            TLogger.ee("XGPushManager", "the parameter context or account of delAccount is null.");
            return;
        }
        b(context, a2, 0, (String) null, 3, str, xGIOperateCallback);
    }

    @Deprecated
    public static void delAccount(Context context, final String str) {
        if (context == null || g.a(str)) {
            TLogger.ee("XGPushManager", "the parameter context or account of delAccount is null.");
        } else {
            delAccount(context, str, new XGIOperateCallback() {
                /* class com.tencent.android.tpush.XGPushManager.AnonymousClass21 */

                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onSuccess(Object obj, int i) {
                    TLogger.ii("XGPushManager", "TPNS deleteAccount " + str + " success");
                }

                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onFail(Object obj, int i, String str) {
                    TLogger.ee("XGPushManager", "TPNS deleteAccount " + str + " failed, errCode =  " + i + ", msg = " + str);
                }
            });
        }
    }

    @Deprecated
    public static void delAllAccount(Context context) {
        clearAccounts(context);
    }

    @Deprecated
    public static void delAllAccount(Context context, XGIOperateCallback xGIOperateCallback) {
        clearAccounts(context, xGIOperateCallback);
    }

    public static void clearAccounts(Context context) {
        if (context == null) {
            TLogger.ee("XGPushManager", "the parameter context of delAllAccount is null.");
        } else {
            clearAccounts(context, new XGIOperateCallback() {
                /* class com.tencent.android.tpush.XGPushManager.AnonymousClass22 */

                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onSuccess(Object obj, int i) {
                    TLogger.ii("XGPushManager", "TPNS deleteAllAccount success" + obj);
                }

                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onFail(Object obj, int i, String str) {
                    TLogger.ee("XGPushManager", "TPNS deleteAllAccount failed, errCode =  " + i + ", msg = " + str);
                }
            });
        }
    }

    public static void clearAccounts(Context context, XGIOperateCallback xGIOperateCallback) {
        if (context == null) {
            TLogger.ee("XGPushManager", "the parameter context of delAllAccount is null.");
            if (context != null && xGIOperateCallback != null) {
                xGIOperateCallback.onFail("", ReturnCode.CODE_INVALID_ACCOUNT.getType(), ReturnCode.CODE_INVALID_ACCOUNT.getStr());
                return;
            }
            return;
        }
        b(context, (String) null, 0, (String) null, 1, "", xGIOperateCallback);
    }

    public static void unregisterPush(Context context) {
        if (context == null) {
            TLogger.e("XGPushManager", "the context of unregisterPush is null");
        } else {
            unregisterPush(context, new XGIOperateCallback() {
                /* class com.tencent.android.tpush.XGPushManager.AnonymousClass23 */

                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onSuccess(Object obj, int i) {
                    TLogger.ii("XGPushManager", "UnRegisterPush push succeed with token = " + obj + " flag = " + i);
                }

                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onFail(Object obj, int i, String str) {
                    TLogger.ee("XGPushManager", "UnRegisterPush push failed with token = " + obj + " , errCode = " + i + " , msg = " + str);
                }
            });
        }
    }

    public static void unregisterPush(Context context, String str, String str2, String str3, XGIOperateCallback xGIOperateCallback) {
        a(context, xGIOperateCallback, XGPushConfig.getAccessId(context), XGPushConfig.getAccessKey(context), str, str2, str3);
    }

    public static void unregisterPush(Context context, XGIOperateCallback xGIOperateCallback) {
        a(context, xGIOperateCallback, XGPushConfig.getAccessId(context), XGPushConfig.getAccessKey(context), (String) null, (String) null, (String) null);
    }

    static void a(Context context, final XGIOperateCallback xGIOperateCallback, final long j, final String str, String str2, String str3, String str4) {
        if (context != null) {
            final Context applicationContext = context.getApplicationContext();
            if (j.h(applicationContext)) {
                try {
                    long currentTimeMillis = System.currentTimeMillis() - c.longValue();
                    if (e != null && currentTimeMillis < d) {
                        TLogger.d("XGPushManager", "cancel dump register, registerRunnable4NewDevice:" + e);
                        CommonWorkingThread.getInstance().remove(e);
                        e = null;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                CommonWorkingThread.getInstance().execute(new Runnable() {
                    /* class com.tencent.android.tpush.XGPushManager.AnonymousClass24 */

                    @Override // java.lang.Runnable
                    public void run() {
                        XGIOperateCallback xGIOperateCallback;
                        try {
                            int a2 = j.a(applicationContext);
                            if (a2 != 0) {
                                XGIOperateCallback xGIOperateCallback2 = xGIOperateCallback;
                                if (xGIOperateCallback2 != null) {
                                    xGIOperateCallback2.onFail("", a2, "XINGE SDK config error");
                                    return;
                                }
                                return;
                            }
                            long j = j;
                            if (j <= 0) {
                                j = XGPushConfig.getAccessId(applicationContext);
                            }
                            String accessKey = j.b(str) ? XGPushConfig.getAccessKey(applicationContext) : str;
                            String token = XGPushConfig.getToken(applicationContext);
                            if ((j <= 0 || j.b(accessKey) || j.b(token)) && (xGIOperateCallback = xGIOperateCallback) != null) {
                                int type = ReturnCode.CODE_LOGIC_ILLEGAL_ARGUMENT.getType();
                                xGIOperateCallback.onFail("", type, "The accessId, accessKey or token is invalid! accessId=" + j + ",accessKey=" + accessKey + ",token=" + token);
                                throw new IllegalArgumentException("accessId, accessKey or token is invalid.");
                            }
                            Intent intent = new Intent(applicationContext.getPackageName() + "com.tencent.android.xg.vip.action.UNREGISTER.V4");
                            intent.putExtra("accId", Rijndael.encrypt("" + j));
                            intent.putExtra("accKey", Rijndael.encrypt(accessKey));
                            intent.putExtra("token", Rijndael.encrypt(token));
                            intent.putExtra("packName", Rijndael.encrypt(applicationContext.getPackageName()));
                            intent.putExtra("operation", 101);
                            intent.putExtra("opType", 1);
                            boolean b2 = i.a(applicationContext).b();
                            if (j.c(applicationContext) != 1 || b2) {
                                XGPushManager.a(applicationContext, intent, xGIOperateCallback, b2);
                            } else {
                                XGPushManager.d(applicationContext, intent, xGIOperateCallback);
                            }
                        } catch (Throwable th) {
                            TLogger.ee("XGPushManager", "unregisterPush", th);
                        }
                    }
                });
            } else if (xGIOperateCallback != null) {
                xGIOperateCallback.onSuccess("It's already unregistered", 0);
            }
        } else if (xGIOperateCallback != null) {
            xGIOperateCallback.onFail("", ReturnCode.CODE_LOGIC_ILLEGAL_ARGUMENT.getType(), "The context parameter can not be null!");
        } else {
            throw new IllegalArgumentException("The context parameter can not be null!");
        }
    }

    @Deprecated
    public static void setTag(Context context, String str) {
        if (context == null || g.a(str)) {
            TLogger.ee("XGPushManager", "the parameter context or tagName of setTag is null.");
            return;
        }
        TLogger.ii("XGPushManager", "Action -> setTag with tag = " + str);
        a(context, str, 1, -1, null, str);
    }

    @Deprecated
    public static void setTag(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        if (context == null || g.a(str)) {
            TLogger.ee("XGPushManager", "the parameter context or tagName of setTag is null.");
            if (context != null && xGIOperateCallback != null) {
                xGIOperateCallback.onFail("", ReturnCode.CODE_INVALID_TAG.getType(), ReturnCode.CODE_INVALID_TAG.getStr());
                return;
            }
            return;
        }
        TLogger.ii("XGPushManager", "Action -> setTag with tag = " + str);
        a(context, str, 1, -1, (String) null, str, xGIOperateCallback);
    }

    static String a(Set<String> set, String str) {
        if (set == null) {
            TLogger.ee("XGPushManager", str + " -> the parameter tags is null.");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        Iterator<String> it2 = set.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            String replaceAll = it2.next().replaceAll(" ", "");
            if (replaceAll.length() > 40) {
                TLogger.ww("XGPushManager", str + " -> the tag:" + replaceAll + " length is more than 40, discard it");
            } else {
                if (i >= 1000) {
                    if (!XGPushConfig.enableDebug) {
                        TLogger.ww("XGPushManager", str + " -> tags size is more than 1000, discard some tags");
                        break;
                    }
                    TLogger.ww("XGPushManager", str + " -> tags size is " + (i + 1) + ", so discard tag:" + replaceAll);
                } else {
                    if (i != 0) {
                        sb.append(" ");
                    }
                    sb.append(replaceAll);
                }
                i++;
            }
        }
        return sb.toString();
    }

    @Deprecated
    public static void setTags(Context context, String str, Set<String> set) {
        clearAndAppendTags(context, str, set);
    }

    @Deprecated
    public static void clearAndAppendTags(Context context, String str, Set<String> set) {
        if (context == null || set == null || set.isEmpty()) {
            TLogger.ee("XGPushManager", "the parameter context or tags of setTags is invalid.");
            return;
        }
        String a2 = a(set, "setTags");
        if (g.a(a2)) {
            TLogger.ee("XGPushManager", "setTags -> getTagsFromSet return null!!!");
            return;
        }
        TLogger.ii("XGPushManager", "Action -> setTags with all tags = " + a2);
        a(context, a2, 6, -1, null, str);
    }

    @Deprecated
    public static void setTags(Context context, String str, Set<String> set, XGIOperateCallback xGIOperateCallback) {
        clearAndAppendTags(context, str, set, xGIOperateCallback);
    }

    public static void clearAndAppendTags(Context context, String str, Set<String> set, XGIOperateCallback xGIOperateCallback) {
        if (context == null || set == null || set.isEmpty()) {
            TLogger.ee("XGPushManager", "the parameter context or tags of setTags is invalid.");
            if (context != null && xGIOperateCallback != null) {
                xGIOperateCallback.onFail("", ReturnCode.CODE_INVALID_TAG.getType(), ReturnCode.CODE_INVALID_TAG.getStr());
                return;
            }
            return;
        }
        String a2 = a(set, "setTags");
        if (g.a(a2)) {
            TLogger.ee("XGPushManager", "setTags -> getTagsFromSet return null!!!");
            return;
        }
        TLogger.ii("XGPushManager", "Action -> setTags with all tags = " + a2);
        a(context, a2, 6, -1, (String) null, str, xGIOperateCallback);
    }

    @Deprecated
    public static void addTags(Context context, String str, Set<String> set) {
        appendTags(context, str, set);
    }

    @Deprecated
    public static void appendTags(Context context, String str, Set<String> set) {
        if (context == null || set == null || set.isEmpty()) {
            TLogger.ee("XGPushManager", "the parameter context or tags of addTags is invalid.");
            return;
        }
        String a2 = a(set, "addTags");
        if (g.a(a2)) {
            TLogger.ee("XGPushManager", "addTags -> getTagsFromSet return null!!!");
            return;
        }
        TLogger.ii("XGPushManager", "addTags -> setTags with all tags = " + a2);
        a(context, a2, 5, -1, null, str);
    }

    @Deprecated
    public static void addTags(Context context, String str, Set<String> set, XGIOperateCallback xGIOperateCallback) {
        appendTags(context, str, set, xGIOperateCallback);
    }

    public static void appendTags(Context context, String str, Set<String> set, XGIOperateCallback xGIOperateCallback) {
        if (context == null || set == null || set.isEmpty()) {
            TLogger.ee("XGPushManager", "the parameter context or tags of addTags is invalid.");
            if (context != null && xGIOperateCallback != null) {
                xGIOperateCallback.onFail("", ReturnCode.CODE_INVALID_TAG.getType(), ReturnCode.CODE_INVALID_TAG.getStr());
                return;
            }
            return;
        }
        String a2 = a(set, "addTags");
        if (g.a(a2)) {
            TLogger.ee("XGPushManager", "addTags -> getTagsFromSet return null!!!");
            return;
        }
        TLogger.ii("XGPushManager", "addTags -> setTags with all tags = " + a2);
        a(context, a2, 5, -1, (String) null, str, xGIOperateCallback);
    }

    public static void clearAndAppendAttributes(Context context, String str, Map<String, String> map, XGIOperateCallback xGIOperateCallback) {
        if (context == null || map == null || map.isEmpty()) {
            TLogger.ee("XGPushManager", "the parameter context or attributes of clearAndAppendAttributes is invalid.");
            if (context != null && xGIOperateCallback != null) {
                xGIOperateCallback.onFail("", ReturnCode.CODE_INVALID_ATTRIBUTE.getType(), ReturnCode.CODE_INVALID_ATTRIBUTE.getStr());
                return;
            }
            return;
        }
        String a2 = a(map);
        if (a("clearAndAppendAttributes", a2)) {
            TLogger.ii("XGPushManager", "clearAndAppendAttributes with all attribute = " + a2);
            b(context, a2, 2, str, xGIOperateCallback);
        }
    }

    public static void upsertAttributes(Context context, String str, Map<String, String> map, XGIOperateCallback xGIOperateCallback) {
        if (context == null || map == null || map.isEmpty()) {
            TLogger.ee("XGPushManager", "the parameter context or attributes of upsertAttributes is invalid.");
            if (context != null && xGIOperateCallback != null) {
                xGIOperateCallback.onFail("", ReturnCode.CODE_INVALID_ATTRIBUTE.getType(), ReturnCode.CODE_INVALID_ATTRIBUTE.getStr());
                return;
            }
            return;
        }
        String a2 = a(map);
        if (a("upsertAttributes", a2)) {
            TLogger.ii("XGPushManager", "upsertAttributes with all attribute = " + a2);
            b(context, a2, 1, str, xGIOperateCallback);
        }
    }

    public static void delAttributes(Context context, String str, Set<String> set, XGIOperateCallback xGIOperateCallback) {
        if (context == null || set == null || set.isEmpty()) {
            TLogger.ee("XGPushManager", "the parameter context or attributes of delAttributes is invalid.");
            if (context != null && xGIOperateCallback != null) {
                xGIOperateCallback.onFail("", ReturnCode.CODE_INVALID_ATTRIBUTE.getType(), ReturnCode.CODE_INVALID_ATTRIBUTE.getStr());
                return;
            }
            return;
        }
        String a2 = a(set);
        if (a("delAttributes", a2)) {
            TLogger.ii("XGPushManager", "delAttributes -> attributes = " + a2);
            b(context, a2, 3, str, xGIOperateCallback);
        }
    }

    public static void clearAttributes(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        if (context == null) {
            TLogger.ee("XGPushManager", "the parameter context of clearAttributes is invalid");
            if (context != null && xGIOperateCallback != null) {
                xGIOperateCallback.onFail("", ReturnCode.CODE_INVALID_ATTRIBUTE.getType(), ReturnCode.CODE_INVALID_ATTRIBUTE.getStr());
                return;
            }
            return;
        }
        TLogger.ii("XGPushManager", "Action -> clearAttributes");
        b(context, "{}", 4, str, xGIOperateCallback);
    }

    private static void b(final Context context, final String str, final int i, final String str2, final XGIOperateCallback xGIOperateCallback) {
        if (!XGApiConfig.isRegistered(context) || !j.h(context)) {
            registerPush(context, new XGIOperateCallback() {
                /* class com.tencent.android.tpush.XGPushManager.AnonymousClass2 */

                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onSuccess(Object obj, int i) {
                    XGPushManager.c(context, str, i, str2, xGIOperateCallback);
                }

                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onFail(Object obj, int i, String str) {
                    XGIOperateCallback xGIOperateCallback = xGIOperateCallback;
                    if (xGIOperateCallback != null) {
                        xGIOperateCallback.onFail(obj, i, str);
                    }
                }
            });
        } else {
            c(context, str, i, str2, xGIOperateCallback);
        }
    }

    /* access modifiers changed from: private */
    public static void c(Context context, String str, int i, String str2, final XGIOperateCallback xGIOperateCallback) {
        if (context == null) {
            throw new IllegalArgumentException("The context parameter can not be null!");
        } else if (j.a(context) <= 0) {
            if (str != null) {
                long accessId = XGPushConfig.getAccessId(context);
                String accessKey = XGPushConfig.getAccessKey(context);
                if (accessId < 0 || g.a(accessKey)) {
                    throw new IllegalArgumentException("The accessId or accessKey not set!");
                }
                Intent intent = new Intent(context.getPackageName() + "com.tencent.android.xg.vip.action.ATTRIBUTE.V4");
                intent.putExtra("accId", accessId);
                intent.putExtra("accKey", Rijndael.encrypt(accessKey));
                intent.putExtra("packName", Rijndael.encrypt(context.getPackageName()));
                intent.putExtra("attributesFlag", i);
                intent.putExtra("attributesName", Rijndael.encrypt(str));
                intent.putExtra("attributesOperateName", str2);
                if (xGIOperateCallback != null) {
                    try {
                        d.a(context, new BroadcastReceiver() {
                            /* class com.tencent.android.tpush.XGPushManager.AnonymousClass3 */

                            @Override // android.content.BroadcastReceiver
                            public void onReceive(Context context, final Intent intent) {
                                TLogger.ii("XGPushManager", "attributes call back to " + context.getPackageName());
                                try {
                                    CommonWorkingThread.getInstance().execute(new Runnable() {
                                        /* class com.tencent.android.tpush.XGPushManager.AnonymousClass3.AnonymousClass1 */

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            int intExtra = intent.getIntExtra("operation", -1);
                                            String stringExtra = intent.getStringExtra("data");
                                            if (stringExtra == null) {
                                                stringExtra = "";
                                            }
                                            if (intExtra == 0) {
                                                xGIOperateCallback.onSuccess(stringExtra, intent.getIntExtra("flag", -1));
                                            } else if (intExtra == 1) {
                                                xGIOperateCallback.onFail(stringExtra, intent.getIntExtra("code", -1), intent.getStringExtra("msg"));
                                            }
                                        }
                                    });
                                } catch (Throwable unused) {
                                }
                                j.a(context, this);
                            }
                        }, new IntentFilter("com.tencent.android.xg.vip.action.ATTRIBUTE.RESULT.V4"));
                    } catch (Throwable unused) {
                    }
                }
                d.a(context, intent);
                return;
            }
            throw new IllegalArgumentException("The attributes parameter can not be null!");
        }
    }

    private static String a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            TLogger.ee("XGPushManager", "getAttributesFromMap -> the parameter attributes is null.");
            return null;
        } else if (map.size() > 50) {
            return "out_size";
        } else {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String value = entry.getValue();
                    if (g.a(value)) {
                        return "empty";
                    }
                    if (value.length() > 50) {
                        return "out_length";
                    }
                    jSONObject.put(entry.getKey(), value);
                }
                return jSONObject.toString();
            } catch (Throwable th) {
                TLogger.ww("XGPushManager", "unexpected for getAttributesFromMap", th);
                return null;
            }
        }
    }

    private static String a(Set<String> set) {
        if (set == null) {
            TLogger.ee("XGPushManager", "getAttributesFromSet -> the parameter attributes is null.");
            return null;
        } else if (set.size() > 50) {
            return "out_size";
        } else {
            try {
                JSONObject jSONObject = new JSONObject();
                for (String str : set) {
                    if (str.length() > 50) {
                        return "out_length";
                    }
                    jSONObject.put(str, "0");
                }
                return jSONObject.toString();
            } catch (Throwable th) {
                TLogger.ww("XGPushManager", "unexpected for getAttributesFromSet", th);
                return null;
            }
        }
    }

    private static boolean a(String str, String str2) {
        if (g.a(str2)) {
            TLogger.ee("XGPushManager", str + " -> getAttributesFromMap return null!!!");
            return false;
        } else if ("empty".equals(str2)) {
            TLogger.ee("XGPushManager", str + " -> the parameter attributes has empty value!");
            return false;
        } else if ("out_length".equals(str2)) {
            TLogger.ee("XGPushManager", str + " -> the parameter attribute_name or attribute_value length is out of limit:50");
            return false;
        } else if (!"out_size".equals(str2)) {
            return true;
        } else {
            TLogger.ee("XGPushManager", str + " -> the parameter attributes size is out of limit:50");
            return false;
        }
    }

    public static void setKeyValueTag(Context context, String str, String str2) {
        if (context == null || str == null || str.trim().length() == 0 || str2 == null || str2.trim().length() == 0) {
            TLogger.ee("XGPushManager", "setKeyValueTag context or tagKey or tagValue invalid.");
            return;
        }
        String str3 = str + "::::" + str2;
        TLogger.ii("XGPushManager", "Action -> setKeyValueTag with tag = " + str3);
        a(context, str3, 3, -1, null, str3);
    }

    public static void sendCommReport2Service(Context context, String str, String str2) {
        long accessId = XGPushConfig.getAccessId(context);
        Intent intent = new Intent(context.getPackageName() + "com.tencent.android.xg.vip.action.COMM_REPORT.V4");
        intent.putExtra("type", 1L);
        intent.putExtra("accessId", Rijndael.encrypt("" + accessId));
        intent.putExtra("msgId", 1000L);
        intent.putExtra("broadcastId", 0L);
        intent.putExtra("msgTimestamp", System.currentTimeMillis() / 1000);
        intent.putExtra("clientTimestamp", System.currentTimeMillis() / 1000);
        intent.putExtra("pkgName", context.getPackageName());
        intent.putExtra("msg", Rijndael.encrypt(str));
        intent.putExtra("ext", Rijndael.encrypt(str2));
        d.a(context, intent);
    }

    public static void deleteKeyValueTag(Context context, String str, String str2) {
        if (context == null || str == null || str.trim().length() == 0) {
            TLogger.ee("XGPushManager", "deleteKeyValueTag context or tagKey invalid.");
            return;
        }
        String str3 = str + "::::" + str2;
        TLogger.ii("XGPushManager", "Action -> deleteKeyValueTag with tag = " + str3);
        a(context, str3, 4, -1, null, str3);
    }

    @Deprecated
    public static void deleteTag(Context context, String str) {
        delTag(context, str);
    }

    @Deprecated
    public static void delTag(Context context, String str) {
        TLogger.ii("XGPushManager", "Action -> deleteTag with tag = " + str);
        if (context == null || str == null || str.trim().length() == 0) {
            TLogger.ee("XGPushManager", "context is null or tagName invalid.");
        } else {
            a(context, str, 2, -1, null, str);
        }
    }

    @Deprecated
    public static void deleteTag(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        delTag(context, str, xGIOperateCallback);
    }

    @Deprecated
    public static void delTag(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        TLogger.ii("XGPushManager", "Action -> deleteTag with tag = " + str);
        if (context == null || str == null || str.trim().length() == 0) {
            TLogger.ee("XGPushManager", "context is null or tagName invalid.");
            if (context != null && xGIOperateCallback != null) {
                xGIOperateCallback.onFail("", ReturnCode.CODE_INVALID_TAG.getType(), ReturnCode.CODE_INVALID_TAG.getStr());
                return;
            }
            return;
        }
        a(context, str, 2, -1, (String) null, str, xGIOperateCallback);
    }

    @Deprecated
    public static void deleteTags(Context context, String str, Set<String> set) {
        delTags(context, str, set);
    }

    public static void delTags(Context context, String str, Set<String> set) {
        if (context == null || set == null || set.isEmpty()) {
            TLogger.ee("XGPushManager", "the parameter context or tags of deleteTags is invalid.");
            return;
        }
        String a2 = a(set, "deleteTags");
        if (g.a(a2)) {
            TLogger.ee("XGPushManager", "deleteTags -> getTagsFromSet return null!!!");
            return;
        }
        TLogger.ii("XGPushManager", "deleteTags -> setTags with all tags = " + a2);
        a(context, a2, 7, -1, null, str);
    }

    @Deprecated
    public static void deleteTags(Context context, String str, Set<String> set, XGIOperateCallback xGIOperateCallback) {
        delTags(context, str, set, xGIOperateCallback);
    }

    public static void delTags(Context context, String str, Set<String> set, XGIOperateCallback xGIOperateCallback) {
        if (context == null || set == null || set.isEmpty()) {
            TLogger.ee("XGPushManager", "the parameter context or tags of deleteTags is invalid.");
            if (context != null && xGIOperateCallback != null) {
                xGIOperateCallback.onFail("", ReturnCode.CODE_INVALID_TAG.getType(), ReturnCode.CODE_INVALID_TAG.getStr());
                return;
            }
            return;
        }
        String a2 = a(set, "deleteTags");
        if (g.a(a2)) {
            TLogger.ee("XGPushManager", "deleteTags -> getTagsFromSet return null!!!");
            return;
        }
        TLogger.ii("XGPushManager", "deleteTags -> setTags with all tags = " + a2);
        a(context, a2, 7, -1, (String) null, str, xGIOperateCallback);
    }

    @Deprecated
    public static void cleanTags(Context context, String str) {
        clearTags(context, str);
    }

    public static void clearTags(Context context, String str) {
        if (context == null) {
            TLogger.ee("XGPushManager", "the parameter context of cleanTags is invalid");
            return;
        }
        TLogger.ii("XGPushManager", "Action -> cleanTags");
        a(context, "*", 8, -1, null, str);
    }

    @Deprecated
    public static void cleanTags(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        clearTags(context, str, xGIOperateCallback);
    }

    public static void clearTags(Context context, String str, XGIOperateCallback xGIOperateCallback) {
        if (context == null) {
            TLogger.ee("XGPushManager", "the parameter context of cleanTags is invalid");
            return;
        }
        TLogger.ii("XGPushManager", "Action -> cleanTags");
        a(context, "*", 8, -1, (String) null, str, xGIOperateCallback);
    }

    static void a(Context context, String str, int i, long j, String str2, String str3) {
        c(context, str, i, j, str2, str3, null);
    }

    static void a(Context context, String str, int i, long j, String str2, String str3, XGIOperateCallback xGIOperateCallback) {
        c(context, str, i, j, str2, str3, xGIOperateCallback);
    }

    private static void c(final Context context, final String str, final int i, final long j, final String str2, final String str3, final XGIOperateCallback xGIOperateCallback) {
        if (!XGApiConfig.isRegistered(context) || !j.h(context)) {
            registerPush(context, new XGIOperateCallback() {
                /* class com.tencent.android.tpush.XGPushManager.AnonymousClass4 */

                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onSuccess(Object obj, int i) {
                    XGPushManager.d(context, str, i, j, str2, str3, xGIOperateCallback);
                }

                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onFail(Object obj, int i, String str) {
                    XGIOperateCallback xGIOperateCallback = xGIOperateCallback;
                    if (xGIOperateCallback != null) {
                        xGIOperateCallback.onFail(obj, i, str);
                    }
                }
            });
        } else {
            d(context, str, i, j, str2, str3, xGIOperateCallback);
        }
    }

    /* access modifiers changed from: private */
    public static void d(Context context, String str, int i, long j, String str2, String str3, final XGIOperateCallback xGIOperateCallback) {
        if (context == null) {
            throw new IllegalArgumentException("The context parameter can not be null!");
        } else if (j.a(context) <= 0) {
            if (str != null) {
                if (j <= 0) {
                    j = XGPushConfig.getAccessId(context);
                }
                if (j >= 0) {
                    if (j.b(str2)) {
                        str2 = XGPushConfig.getAccessKey(context);
                    }
                    Intent intent = new Intent(context.getPackageName() + "com.tencent.android.xg.vip.action.TAG.V4");
                    intent.putExtra("accId", j);
                    intent.putExtra("accKey", Rijndael.encrypt(str2));
                    intent.putExtra("packName", Rijndael.encrypt(context.getPackageName()));
                    intent.putExtra("tagFlag", i);
                    intent.putExtra("tagName", Rijndael.encrypt(str));
                    intent.putExtra("tagOperageName", str3);
                    if (xGIOperateCallback != null) {
                        try {
                            d.a(context, new BroadcastReceiver() {
                                /* class com.tencent.android.tpush.XGPushManager.AnonymousClass5 */

                                @Override // android.content.BroadcastReceiver
                                public void onReceive(Context context, final Intent intent) {
                                    TLogger.ii("XGPushManager", "Tag call back to " + context.getPackageName());
                                    try {
                                        CommonWorkingThread.getInstance().execute(new Runnable() {
                                            /* class com.tencent.android.tpush.XGPushManager.AnonymousClass5.AnonymousClass1 */

                                            @Override // java.lang.Runnable
                                            public void run() {
                                                int intExtra = intent.getIntExtra("operation", -1);
                                                String stringExtra = intent.getStringExtra("data");
                                                if (stringExtra == null) {
                                                    stringExtra = "";
                                                }
                                                if (intExtra == 0) {
                                                    xGIOperateCallback.onSuccess(stringExtra, intent.getIntExtra("flag", -1));
                                                } else if (intExtra == 1) {
                                                    xGIOperateCallback.onFail(stringExtra, intent.getIntExtra("code", -1), intent.getStringExtra("msg"));
                                                }
                                            }
                                        });
                                    } catch (Throwable th) {
                                        TLogger.e("XGPushManager", "tagManager handle callback error " + th.toString());
                                    }
                                    j.a(context, this);
                                }
                            }, new IntentFilter("com.tencent.android.xg.vip.action.TAG.RESULT.V4"));
                        } catch (Throwable th) {
                            TLogger.e("XGPushManager", "tagManager registerReceiver error " + th.toString());
                        }
                    }
                    d.a(context, intent);
                    return;
                }
                throw new IllegalArgumentException("The accessId not set!");
            }
            throw new IllegalArgumentException("The tagName parameter can not be null!");
        }
    }

    private static void b(final Context context, final String str, final long j, final String str2, final int i, final String str3, final XGIOperateCallback xGIOperateCallback) {
        if (!XGApiConfig.isRegistered(context) || !j.h(context)) {
            registerPush(context, new XGIOperateCallback() {
                /* class com.tencent.android.tpush.XGPushManager.AnonymousClass6 */

                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onSuccess(Object obj, int i) {
                    XGPushManager.a(context, str, j, str2, i, str3, xGIOperateCallback);
                }

                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onFail(Object obj, int i, String str) {
                    XGIOperateCallback xGIOperateCallback = xGIOperateCallback;
                    if (xGIOperateCallback != null) {
                        xGIOperateCallback.onFail(obj, i, str);
                    }
                }
            });
        } else {
            a(context, str, j, str2, i, str3, xGIOperateCallback);
        }
    }

    static void a(Context context, String str, long j, String str2, int i, String str3, final XGIOperateCallback xGIOperateCallback) {
        if (context == null) {
            throw new IllegalArgumentException("The context parameter can not be null!");
        } else if (j.a(context) <= 0) {
            if (str == null) {
                str = "";
            }
            if (j <= 0) {
                j = XGPushConfig.getAccessId(context);
            }
            if (j >= 0) {
                if (j.b(str2)) {
                    str2 = XGPushConfig.getAccessKey(context);
                }
                Intent intent = new Intent(context.getPackageName() + "com.tencent.android.xg.vip.action.ACCOUNT.V4");
                intent.putExtra("accId", j);
                intent.putExtra("accKey", Rijndael.encrypt(str2));
                intent.putExtra("operateType", i);
                intent.putExtra("account", Rijndael.encrypt(str));
                intent.putExtra("accountFeedBack", str3);
                intent.putExtra("packName", Rijndael.encrypt(context.getPackageName()));
                if (xGIOperateCallback != null) {
                    try {
                        d.a(context, new BroadcastReceiver() {
                            /* class com.tencent.android.tpush.XGPushManager.AnonymousClass7 */

                            @Override // android.content.BroadcastReceiver
                            public void onReceive(Context context, final Intent intent) {
                                TLogger.ii("XGPushManager", "Account call back to " + context.getPackageName());
                                try {
                                    CommonWorkingThread.getInstance().execute(new Runnable() {
                                        /* class com.tencent.android.tpush.XGPushManager.AnonymousClass7.AnonymousClass1 */

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            int intExtra = intent.getIntExtra("operation", -1);
                                            String stringExtra = intent.getStringExtra("data");
                                            if (stringExtra == null) {
                                                stringExtra = "";
                                            }
                                            if (intExtra == 0) {
                                                xGIOperateCallback.onSuccess(stringExtra, intent.getIntExtra("flag", -1));
                                            } else if (intExtra == 1) {
                                                xGIOperateCallback.onFail(stringExtra, intent.getIntExtra("code", -1), intent.getStringExtra("msg"));
                                            }
                                        }
                                    });
                                } catch (Throwable th) {
                                    TLogger.e("XGPushManager", "accountManager handle callback error " + th.toString());
                                }
                                j.a(context, this);
                            }
                        }, new IntentFilter("com.tencent.android.xg.vip.action.ACCOUNT.RESULT.V4"));
                    } catch (Throwable th) {
                        TLogger.e("XGPushManager", "accountManager registerReceiver error " + th.toString());
                    }
                }
                d.a(context, intent);
                return;
            }
            throw new IllegalArgumentException("The accessId not set!");
        }
    }

    static XGPushClickedResult a(final Activity activity) {
        TLogger.ii("XGPushManager", ">>> onActivityStarted activity=" + activity);
        if (activity == null || activity.getIntent() == null) {
            return null;
        }
        final Intent intent = activity.getIntent();
        if (!"true".equalsIgnoreCase(intent.getStringExtra("tag.tpush.MSG")) || j.a(activity.getApplicationContext()) > 0) {
            return null;
        }
        XGPushClickedResult xGPushClickedResult = new XGPushClickedResult();
        xGPushClickedResult.parseIntent(intent);
        intent.removeExtra("tag.tpush.MSG");
        CommonWorkingThread.getInstance().execute(new Runnable() {
            /* class com.tencent.android.tpush.XGPushManager.AnonymousClass8 */

            @Override // java.lang.Runnable
            public void run() {
                XGPushManager.a(activity, intent);
                XGPushManager.c(activity, intent);
            }
        });
        return xGPushClickedResult;
    }

    public static boolean isNotificationOpened(Context context) {
        return com.tencent.android.tpush.service.util.b.a(context);
    }

    public static XGPushClickedResult onActivityStarted(Activity activity) {
        Intent intent;
        TLogger.ii("XGPushManager", ">>> onActivityStarted " + activity);
        if (!(activity == null || activity.getIntent() == null || !j.h(activity) || (intent = activity.getIntent()) == null)) {
            try {
                if (intent.hasExtra("tag.tpush.NOTIFIC")) {
                    Serializable serializableExtra = intent.getSerializableExtra("tag.tpush.NOTIFIC");
                    intent.removeExtra("tag.tpush.NOTIFIC");
                    if (serializableExtra != null && (serializableExtra instanceof XGPushClickedResult)) {
                        XGPushClickedResult xGPushClickedResult = (XGPushClickedResult) serializableExtra;
                        xGPushClickedResult.parseIntent(intent);
                        return xGPushClickedResult;
                    }
                }
            } catch (Throwable th) {
                TLogger.e("XGPushManager", "onActivityStarted", th);
            }
        }
        return null;
    }

    public static void addLocalNotificationList(final Context context, ArrayList<XGLocalMessage> arrayList) {
        Iterator<XGLocalMessage> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            final XGLocalMessage next = it2.next();
            CommonWorkingThread.getInstance().execute(new Runnable() {
                /* class com.tencent.android.tpush.XGPushManager.AnonymousClass9 */

                @Override // java.lang.Runnable
                public void run() {
                    long a2 = XGPushManager.a(context, next, -1);
                    TLogger.i("XGPushManager", "ret :" + a2 + ",msgID:" + next.getMsgId());
                }
            }, 1000);
        }
    }

    public static long addLocalNotification(Context context, XGLocalMessage xGLocalMessage) {
        return a(context, xGLocalMessage, -1);
    }

    static long a(Context context, XGLocalMessage xGLocalMessage, long j) {
        if (context == null || xGLocalMessage == null) {
            TLogger.e("XGPushManager", "addLocalNotification context == null or msg == null");
            return -1;
        }
        try {
            if (!Security.checkTpnsSecurityLibSo(context)) {
                return -1;
            }
            long accessId = j <= 0 ? XGPushConfig.getAccessId(context) : j;
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder(64);
            sb.append(accessId);
            sb.append(xGLocalMessage.getMsgId());
            sb.append(context.getPackageName());
            String str = "";
            sb.append(TextUtils.isEmpty(xGLocalMessage.getTitle()) ? str : xGLocalMessage.getTitle());
            sb.append(TextUtils.isEmpty(xGLocalMessage.getContent()) ? str : xGLocalMessage.getContent());
            String custom_content = xGLocalMessage.getCustom_content();
            if (TextUtils.isEmpty(custom_content) || new JSONObject(custom_content).length() == 0) {
                custom_content = str;
            }
            sb.append(custom_content);
            if (xGLocalMessage.getType() == 1) {
                sb.append(TextUtils.isEmpty(xGLocalMessage.getUrl()) ? str : xGLocalMessage.getUrl());
                sb.append(TextUtils.isEmpty(xGLocalMessage.getIntent()) ? str : xGLocalMessage.getIntent());
                if (!TextUtils.isEmpty(xGLocalMessage.getActivity())) {
                    str = xGLocalMessage.getActivity();
                }
                sb.append(str);
            }
            String sb2 = sb.toString();
            String str2 = "tpush.local.msg." + Md5.md5(sb2);
            long expirationTimeMs = xGLocalMessage.getExpirationTimeMs();
            PushPreferences.putLong(context, str2, expirationTimeMs);
            TLogger.i("XGPushManager", sb2 + ",tag:" + str2 + ",exp:" + expirationTimeMs);
            com.tencent.android.tpush.service.protocol.j jVar = new com.tencent.android.tpush.service.protocol.j();
            jVar.a = xGLocalMessage.getMsgId();
            jVar.b = accessId;
            jVar.g = context.getPackageName();
            jVar.c = xGLocalMessage.getBusiMsgId();
            jVar.h = currentTimeMillis / 1000;
            long j2 = -currentTimeMillis;
            jVar.k = j2;
            jVar.l = xGLocalMessage.getTtl();
            jVar.f = (long) xGLocalMessage.getType();
            jVar.i = 0;
            jVar.j = xGLocalMessage.getDate();
            jVar.e = "{\"title\":\"" + xGLocalMessage.getTitle() + "\",\"content\":\"" + a(xGLocalMessage.getContent()) + "\",\"builder_id\":" + xGLocalMessage.getBuilderId() + ",\"custom_content\":" + xGLocalMessage.getCustom_content() + ",\"ring\":" + xGLocalMessage.getRing() + ",\"vibrate\":" + xGLocalMessage.getVibrate() + ",\"lights\":" + xGLocalMessage.getLights() + ",\"n_id\":" + xGLocalMessage.getNotificationId() + ",\"is_show_type\":" + xGLocalMessage.getNsModel() + ",\"ring_raw\":\"" + xGLocalMessage.getRing_raw() + "\",\"icon_type\":" + xGLocalMessage.getIcon_type() + ",\"color\":" + xGLocalMessage.getColor() + ",\"icon_res\":\"" + xGLocalMessage.getIcon_res() + "\",\"xg_media_resources\":\"" + xGLocalMessage.getTpns_media_resources() + "\",\"style_id\":" + xGLocalMessage.getStyle_id() + ",\"small_icon\":\"" + xGLocalMessage.getSmall_icon() + "\",\"clearable\":1,\"accept_time\":[{\"start\":{\"hour\":\"" + xGLocalMessage.getHour() + "\",\"min\":\"" + xGLocalMessage.getMin() + "\"},\"end\":{\"hour\":\"23\",\"min\":\"59\"}}],\"action\":{\"action_type\":" + xGLocalMessage.getAction_type() + ",\"activity\":\"" + xGLocalMessage.getActivity() + "\",\"browser\":{\"url\":\"" + xGLocalMessage.getUrl() + "\"},\"intent\":\"" + xGLocalMessage.getIntent() + "\",\"package_name\":{\"packageDownloadUrl\":\"" + xGLocalMessage.getPackageDownloadUrl() + "\",\"packageName\":\"" + xGLocalMessage.getPackageName() + "\"}}}";
            jVar.t = xGLocalMessage.targetType;
            jVar.u = xGLocalMessage.source;
            com.tencent.android.tpush.service.channel.a aVar = new com.tencent.android.tpush.service.channel.a(0, "127.0.0.1");
            Intent intent = new Intent("com.tencent.android.xg.vip.action.INTERNAL_PUSH_MESSAGE");
            intent.setPackage(jVar.g);
            intent.putExtra("msgId", jVar.a);
            intent.putExtra("content", Rijndael.encrypt(jVar.e));
            intent.putExtra("date", jVar.j);
            intent.putExtra("type", jVar.f);
            intent.putExtra("accId", jVar.b);
            intent.putExtra("busiMsgId", jVar.c);
            intent.putExtra("timestamps", jVar.h);
            intent.putExtra("multiPkg", jVar.i);
            intent.putExtra("server_time", jVar.k * 1000);
            intent.putExtra("ttl", jVar.l);
            intent.putExtra("pushChannel", xGLocalMessage.pushChannel);
            intent.putExtra("pushTime", xGLocalMessage.pushTime);
            intent.putExtra("groupId", xGLocalMessage.nGroupId);
            intent.putExtra("svrAck", true);
            intent.putExtra("extra_host", j.d(aVar.b()));
            intent.putExtra("extra_port", aVar.c());
            intent.putExtra("extra_pact", com.tencent.android.tpush.service.c.a(aVar.a()));
            intent.putExtra("extra_push_time", currentTimeMillis);
            intent.putExtra("targetType", jVar.t);
            intent.putExtra("source", jVar.u);
            f.a(context).b(intent);
            return j2;
        } catch (Throwable th) {
            TLogger.e("XGPushManager", "addLocalNotification ", th);
            return 0;
        }
    }

    public static XGPushNotifactionCallback getNotifactionCallback() {
        return f;
    }

    public static void setNotifactionCallback(XGPushNotifactionCallback xGPushNotifactionCallback) {
        f = xGPushNotifactionCallback;
    }

    public static XGSysPushNotifactionCallback getSysNotifactionCallback() {
        return g;
    }

    public static void setSysNotifactionCallback(XGSysPushNotifactionCallback xGSysPushNotifactionCallback) {
        g = xGSysPushNotifactionCallback;
    }

    public static void clearLocalNotifications(Context context) {
        if (context == null) {
            TLogger.e("XGPushManager", "clearLocalNotifications  context==null.");
        } else if (j.a(context) <= 0) {
            final Context applicationContext = context.getApplicationContext();
            CommonWorkingThread.getInstance().execute(new Runnable() {
                /* class com.tencent.android.tpush.XGPushManager.AnonymousClass10 */

                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.android.tpush.b.c.a().c(applicationContext);
                }
            });
        }
    }

    static void a(Context context, Intent intent) {
        com.tencent.android.tpush.b.c.a().e(context, intent.getLongExtra("msgId", -1));
        Intent intent2 = new Intent("com.tencent.android.xg.vip.action.PUSH_CLICK.RESULT.V4");
        intent2.putExtras(intent);
        intent2.putExtra("packName", context.getPackageName());
        intent2.putExtra("clickTime", System.currentTimeMillis() / 1000);
        ServiceStat.appReportNotificationClicked(context, intent2);
        d.a(context, intent2);
    }

    public static void onMessageClicked(Context context, XGPushTextMessage xGPushTextMessage) {
        a(context, xGPushTextMessage.a(), "com.tencent.android.xg.vip.action.PUSH_CLICK.RESULT.V4");
    }

    public static void onMessageCleared(Context context, XGPushTextMessage xGPushTextMessage) {
        a(context, xGPushTextMessage.a(), "com.tencent.android.xg.vip.action.PUSH_CANCELLED.RESULT.V4");
    }

    private static void a(Context context, Intent intent, String str) {
        if (context != null && intent != null && str != null) {
            Intent intent2 = new Intent(str);
            intent2.putExtras(intent);
            intent2.putExtra("packName", context.getPackageName());
            intent2.putExtra("clickTime", System.currentTimeMillis() / 1000);
            if ("com.tencent.android.xg.vip.action.PUSH_CANCELLED.RESULT.V4".equals(str)) {
                intent2.putExtra("action", NotificationAction.delete.getType());
                ServiceStat.appReportNotificationCleared(context, intent2);
            } else if ("com.tencent.android.xg.vip.action.PUSH_CLICK.RESULT.V4".equals(str)) {
                intent2.putExtra("action", NotificationAction.clicked.getType());
                ServiceStat.appReportNotificationClicked(context, intent2);
            }
            d.a(context, intent2);
        }
    }

    /* access modifiers changed from: private */
    public static void c(Context context, Intent intent) {
        if (intent != null) {
            Intent intent2 = new Intent("com.tencent.android.xg.vip.action.FEEDBACK");
            intent2.setPackage(context.getPackageName());
            intent2.putExtra("TPUSH.FEEDBACK", 4);
            intent2.putExtra("TPUSH.ERRORCODE", 0);
            intent2.putExtras(intent);
            d.a(context, intent2);
        }
    }

    public static void setPushNotificationBuilder(Context context, int i, XGPushNotificationBuilder xGPushNotificationBuilder) {
        if (context == null) {
            throw new IllegalArgumentException("context is null.");
        } else if (i < 1 || i > 4096) {
            throw new IllegalArgumentException("notificationBulderId不在范围[1, 4096].");
        } else if (xGPushNotificationBuilder != null) {
            com.tencent.android.tpush.b.b.a(context, i, xGPushNotificationBuilder);
        }
    }

    public static void setDefaultNotificationBuilder(Context context, XGPushNotificationBuilder xGPushNotificationBuilder) {
        if (context != null && xGPushNotificationBuilder != null) {
            com.tencent.android.tpush.b.b.a(context, 0, xGPushNotificationBuilder);
        }
    }

    public static XGPushNotificationBuilder getDefaultNotificationBuilder(Context context) {
        XGPushNotificationBuilder notificationBuilder = getNotificationBuilder(context, 0);
        if (notificationBuilder == null) {
            com.tencent.android.tpush.b.b.a(context);
        }
        return notificationBuilder;
    }

    public static XGPushNotificationBuilder getNotificationBuilder(Context context, int i) {
        if (context != null) {
            return com.tencent.android.tpush.b.b.a(context, i);
        }
        TLogger.e("XGPushManager", "getNotificationBuilder  context == null");
        return null;
    }

    public static void cancelNotifaction(Context context, int i) {
        try {
            ((NotificationManager) context.getSystemService("notification")).cancel(i);
        } catch (Throwable th) {
            TLogger.e("XGPushManager", "cancelNotification error " + th.toString());
        }
    }

    public static void cancelAllNotifaction(Context context) {
        try {
            ((NotificationManager) context.getSystemService("notification")).cancelAll();
        } catch (Throwable th) {
            TLogger.e("XGPushManager", "cancelAllNotifaction error " + th.toString());
        }
    }

    public static void msgAck(Context context, com.tencent.android.tpush.b.g gVar) {
        if (context != null && gVar != null) {
            TLogger.v("XGPushManager", "Action -> msgAck(" + context.getPackageName() + "," + gVar.b() + ")");
            if (gVar.b() > 0) {
                MessageId a2 = com.tencent.android.tpush.b.c.a().a(context, context.getPackageName(), gVar.b());
                if (a2 == null) {
                    TLogger.ww("XGPushManager", "Action -> msgAck(" + context.getPackageName() + "," + gVar.b() + ")error, no the id: " + gVar.b());
                    return;
                }
                Intent intent = new Intent(context.getPackageName() + "com.tencent.android.xg.vip.action.MSG_ACK.V4");
                intent.putExtra("msgId", gVar.b());
                intent.putExtra("packName", context.getPackageName());
                intent.putExtra("MessageId", a2);
                intent.putExtra("channel_id", gVar.n());
                d.a(context, intent);
            }
        }
    }

    public static String getServiceTag(Context context) {
        if (!Security.checkTpnsSecurityLibSo(context)) {
            return "xg_service_enable";
        }
        return Rijndael.encrypt(XGPushConfig.getAccessId(context) + ",xg_service_enable");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public static void enableService(Context context, boolean z) {
        if (context != null) {
            if (z == 0 && j.h(context)) {
                TLogger.e("XGPushManager", "TPNS is disable.");
                a(context);
            }
            TLogger.ii("XGPushManager", "enableService=" + (z ? 1 : 0));
            PushMd5Pref.putInt(context, context.getPackageName() + ".enableService", z);
        }
    }

    static void a(Context context, String str, int i, String str2, XGIOperateCallback xGIOperateCallback, long j, String str3, String str4, String str5, String str6) {
        if (context == null) {
            xGIOperateCallback.onFail("", ReturnCode.CODE_LOGIC_ILLEGAL_ARGUMENT.getType(), "The context parameter can not be null!");
        } else if (NetworkUtil.isNetworkConnected(context) || xGIOperateCallback == null) {
            Context applicationContext = context.getApplicationContext();
            if (!PushPreferences.getBoolean(applicationContext, "start_service_by_user", false)) {
                PushPreferences.putBoolean(applicationContext, "start_service_by_user", true);
            }
            setContext(applicationContext);
            enableService(applicationContext, true);
            c(applicationContext);
            if (!a) {
                ServiceStat.reportIsCustomDataAcquisitionVersion(applicationContext);
                a = true;
            }
            c = Long.valueOf(System.currentTimeMillis());
            c(applicationContext, str, i, str2, xGIOperateCallback, j, str3, str4, str5, str6);
            if (!j.a(XGPushConfig.getToken(applicationContext))) {
                try {
                    TLogger.d("XGPushManager", "try to setup registerRunnable4NewDevice");
                    b(applicationContext, str, i, str2, xGIOperateCallback, j, str3, str4, str5, str6);
                } catch (Throwable th) {
                    TLogger.e("XGPushManager", "doDumpRegister4NewDevice exe error", th);
                }
            }
        } else {
            xGIOperateCallback.onFail("", ReturnCode.CODE_NETWORK_UNREACHABLE.getType(), "no network, please check again!");
        }
    }

    static void b(Context context, String str, int i, String str2, XGIOperateCallback xGIOperateCallback, long j, String str3, String str4, String str5, String str6) {
        a(context, str, i, str2, xGIOperateCallback, j, str3, str4, str5, str6, d);
    }

    static void a(final Context context, final String str, final int i, final String str2, XGIOperateCallback xGIOperateCallback, final long j, final String str3, final String str4, final String str5, final String str6, final long j2) {
        if (e != null) {
            TLogger.d("XGPushManager", "update registerRunnable4NewDevice");
            CommonWorkingThread.getInstance().remove(e);
        }
        e = new Runnable() {
            /* class com.tencent.android.tpush.XGPushManager.AnonymousClass11 */

            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnonymousClass1 r5 = new XGIOperateCallback() {
                        /* class com.tencent.android.tpush.XGPushManager.AnonymousClass11.AnonymousClass1 */

                        @Override // com.tencent.android.tpush.XGIOperateCallback
                        public void onSuccess(Object obj, int i) {
                            TLogger.d("XGPushManager", "registerRunnable4NewDevice success, token:" + obj + ",delayMillis:" + j2);
                        }

                        @Override // com.tencent.android.tpush.XGIOperateCallback
                        public void onFail(Object obj, int i, String str) {
                            TLogger.d("XGPushManager", "registerRunnable4NewDevice failed, token:" + obj + ",errCode:" + i + ",msg:" + str + ",delayMillis:" + j2);
                        }
                    };
                    TLogger.d("XGPushManager", "registerRunnable4NewDevice, delayMillis:" + j2 + ",registerRunnable4NewDevice:" + XGPushManager.e);
                    XGPushManager.c(context, str, i, str2, r5, j, str3, str4, str5, str6);
                } catch (Throwable th) {
                    TLogger.e("XGPushManager", "doDumpRegister4NewDevice run error", th);
                }
            }
        };
        CommonWorkingThread.getInstance().execute(e, j2);
    }

    private static void c(Context context) {
        try {
            if (CloudManager.getInstance(context).disableShareBugly()) {
                TLogger.d("XGPushManager", "disable share bugly");
                return;
            }
            SharedPreferences.Editor edit = context.getSharedPreferences("BuglySdkInfos", 0).edit();
            edit.putString("42510ae4dd", "1.2.3.1");
            edit.apply();
            d(context);
        } catch (Throwable th) {
            TLogger.e("XGPushManager", "initBugly :", th);
        }
    }

    private static void d(Context context) {
        try {
            StringBuilder sb = new StringBuilder("TPNS INFO ");
            sb.append(XGPushConfig.getToken(context));
            Class<?> cls = Class.forName("com.tencent.bugly.crashreport.BuglyLog");
            cls.getMethod("i", String.class, String.class).invoke(cls, sb.toString(), "");
            TLogger.d("XGPushManager", "reportCustomInfoToBugly | report customInfo to bugly : " + sb.toString());
        } catch (Throwable unused) {
            TLogger.w("XGPushManager", "bugly not found");
        }
    }

    /* access modifiers changed from: private */
    public static String e(Context context) {
        if (XGPushConfig.isUsedOtherPush(context) && com.tencent.android.tpush.d.d.a(context).j()) {
            com.tencent.android.tpush.d.d.a(context).c();
            long currentTimeMillis = System.currentTimeMillis();
            while (System.currentTimeMillis() - currentTimeMillis < 5000) {
                try {
                    Thread.sleep(200);
                    String f2 = com.tencent.android.tpush.d.d.a(context).f();
                    if (!j.b(f2)) {
                        TLogger.ii("XGPushManager", "get otherToken is : " + f2);
                        return f2;
                    }
                } catch (InterruptedException unused) {
                    TLogger.e("XGPushManager", "OtherPush: call getToken InterruptedException!");
                    return null;
                } catch (Throwable unused2) {
                    TLogger.e("XGPushManager", "OtherPush: call getToken Error!");
                    return null;
                }
            }
        }
        TLogger.i("XGPushManager", "Can't get otherPush token ");
        return null;
    }

    static void c(final Context context, final String str, final int i, final String str2, final XGIOperateCallback xGIOperateCallback, final long j, final String str3, final String str4, final String str5, final String str6) {
        CommonWorkingThread.getInstance().execute(new Runnable() {
            /* class com.tencent.android.tpush.XGPushManager.AnonymousClass13 */

            @Override // java.lang.Runnable
            public void run() {
                long j2;
                try {
                    int a2 = j.a(context);
                    if (a2 != 0) {
                        XGIOperateCallback xGIOperateCallback = xGIOperateCallback;
                        if (xGIOperateCallback != null) {
                            xGIOperateCallback.onFail("", a2, ReturnCode.errCodeToMsg(a2));
                            return;
                        }
                        return;
                    }
                    long j3 = j;
                    long j4 = 0;
                    if (j3 <= 0) {
                        j3 = XGPushConfig.getAccessId(context);
                    }
                    String accessKey = j.b(str3) ? XGPushConfig.getAccessKey(context) : str3;
                    if (j3 <= 0 || j.b(accessKey)) {
                        XGIOperateCallback xGIOperateCallback2 = xGIOperateCallback;
                        int type = ReturnCode.CODE_LOGIC_ILLEGAL_ARGUMENT.getType();
                        xGIOperateCallback2.onFail("", type, "The accessId or accessKey is(are) invalid!@accessId:" + j3 + ", @accessKey:" + accessKey);
                        return;
                    }
                    TLogger.ii("XGPushManager", "start other push channel register !");
                    String e2 = XGPushManager.e(context);
                    if (e2 == null && XGPushConfig.isUsedOtherPush(context) && !XGPushConfig.isNotTryFcm(context)) {
                        com.tencent.android.tpush.d.d.a((com.tencent.android.tpush.d.d) null, (com.tencent.android.tpush.d.c) null);
                        TLogger.i("XGPushManager", "tryAgain other channel !");
                        e2 = XGPushManager.e(context);
                    }
                    if (g.a(e2) && XGPushConfig.isUsedOtherPush(context)) {
                        ServiceStat.reportTokenFailed(context);
                    }
                    j.f(context);
                    Intent intent = new Intent(context.getPackageName() + "com.tencent.android.xg.vip.action.REGISTER.V4");
                    intent.putExtra("accId", Rijndael.encrypt("" + j3));
                    intent.putExtra("accChannel", XGPushConfig.getChannelId(context));
                    intent.putExtra("accKey", Rijndael.encrypt(accessKey));
                    if ((i >> 4) != 1) {
                        intent.putExtra("appVer", com.tencent.android.tpush.common.b.a(context));
                        intent.putExtra("packName", Rijndael.encrypt(context.getPackageName()));
                        if (h.a(context) != null) {
                            intent.putExtra("reserved", Rijndael.encrypt(h.a(context).a()));
                        }
                        String str = str;
                        if (str != null) {
                            intent.putExtra("ticket", Rijndael.encrypt(str));
                        }
                        String str2 = str2;
                        if (str2 != null) {
                            intent.putExtra("qua", Rijndael.encrypt(str2));
                        }
                        intent.putExtra("operation", 100);
                        intent.putExtra("aidl", j.b(context));
                    }
                    if (XGPushConfig.isUsedOtherPush(context) && com.tencent.android.tpush.d.d.a(context).j()) {
                        String i2 = com.tencent.android.tpush.d.d.a(context).i();
                        String f2 = com.tencent.android.tpush.d.d.a(context).f();
                        TLogger.ii("XGPushManager", "other push token is : " + f2 + "  other push type: " + i2);
                        if (!j.b(i2) && !j.b(f2)) {
                            intent.putExtra("channelToken", f2);
                            intent.putExtra("channelType", i2);
                        }
                    }
                    intent.putExtra("ticketType", i);
                    intent.putExtra("currentTimeMillis", System.currentTimeMillis());
                    intent.putExtra("opType", 0);
                    if (!j.b(str4)) {
                        intent.putExtra("url", str4);
                        j4 = 4;
                    }
                    if (!j.b(str6)) {
                        intent.putExtra("otherToken", str6);
                        j2 = !SharePrefsUtil.getString(context, str6, "").equals(CacheManager.getToken(context)) ? 2 : 3;
                    } else {
                        j2 = 1;
                    }
                    if (!j.b(str5)) {
                        intent.putExtra("payload", str5);
                    }
                    intent.putExtra("otherPushTokenOpType", j2);
                    intent.putExtra("otherPushType", j4);
                    TLogger.d("XGPushManager", "url = " + str4 + " payload = " + str5 + " otherPushType " + j4 + " otherPushTokenOpType " + j2);
                    boolean a3 = i.a(context).a();
                    int c2 = j.c(context);
                    boolean a4 = com.tencent.android.tpush.service.b.a();
                    StringBuilder sb = new StringBuilder();
                    sb.append("serviceStatus:");
                    sb.append(c2);
                    sb.append(", isHasBinded: ");
                    sb.append(a4);
                    TLogger.d("XGPushManager", sb.toString());
                    if (c2 != 1 || !a4) {
                        TLogger.d("XGPushManager", "startServiceAndRegisterOrUnregister:");
                        XGPushManager.a(context, intent, xGIOperateCallback, a3);
                        return;
                    }
                    TLogger.d("XGPushManager", "send boardcast to register");
                    XGPushManager.c(context, intent, xGIOperateCallback);
                } catch (Throwable th) {
                    TLogger.e("XGPushManager", "register", th);
                }
            }
        });
    }

    static void a(Context context, Intent intent, XGIOperateCallback xGIOperateCallback, boolean z) {
        j.e(context);
        b bVar = new b(context, intent, xGIOperateCallback);
        try {
            d.a(context, bVar, new IntentFilter("com.tencent.android.xg.vip.action.SERVICE_START.V4"));
        } catch (Throwable th) {
            TLogger.e("XGPushManager", "Receiver not registered exception error : ", th);
        }
        c cVar = new c(context, intent, xGIOperateCallback);
        try {
            h.put(bVar, cVar);
            CommonWorkingThread.getInstance().execute(cVar, 10000);
        } catch (Throwable th2) {
            TLogger.e("XGPushManager", "mapTimeRunnableOfMessage error", th2);
        }
    }

    /* compiled from: ProGuard */
    static class c implements Runnable {
        Context a = null;
        Intent b = null;
        XGIOperateCallback c = null;
        int d = 0;

        c(Context context, Intent intent, XGIOperateCallback xGIOperateCallback) {
            this.a = context;
            this.b = intent;
            this.c = xGIOperateCallback;
            this.d = intent.getIntExtra("opType", 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                int i = this.d;
                if (i == 0) {
                    XGPushManager.c(this.a, this.b, this.c);
                } else if (i != 1) {
                    TLogger.e("XGPushManager", "TimeoutRunnable error optype:" + this.d);
                } else {
                    XGPushManager.d(this.a, this.b, this.c);
                }
                for (b bVar : XGPushManager.h.keySet()) {
                    j.a(this.a, bVar);
                }
                XGPushManager.h.clear();
            } catch (Throwable th) {
                TLogger.e("XGPushManager", " RegisterTimeoutRunnable run error", th);
            }
        }
    }

    /* compiled from: ProGuard */
    static class b extends BroadcastReceiver {
        Context a = null;
        Intent b = null;
        XGIOperateCallback c = null;
        int d = 0;

        b(Context context, Intent intent, XGIOperateCallback xGIOperateCallback) {
            this.a = context;
            this.b = intent;
            this.c = xGIOperateCallback;
            this.d = intent.getIntExtra("opType", 0);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                CommonWorkingThread.getInstance().getHandler().removeCallbacks((c) XGPushManager.h.remove(this));
                TLogger.d("XGPushManager", "Service start from app :" + intent.getStringExtra("pkg") + " , sdk version:" + intent.getStringExtra("ver"));
                int i = this.d;
                if (i == 0) {
                    XGPushManager.c(this.a, this.b, this.c);
                } else if (i != 1) {
                    TLogger.e("XGPushManager", "RegisterStartReceiver error optype:" + this.d);
                } else {
                    XGPushManager.d(this.a, this.b, this.c);
                }
                j.a(this.a, this);
            } catch (Throwable th) {
                TLogger.e("XGPushManager", "RegisterStartReceiver error", th);
            }
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void c(Context context, Intent intent, final XGIOperateCallback xGIOperateCallback) {
        synchronized (XGPushManager.class) {
            TLogger.ii("XGPushManager", "Action -> Register to TPNS server");
            if (xGIOperateCallback != null) {
                try {
                    d.a(context, new BroadcastReceiver() {
                        /* class com.tencent.android.tpush.XGPushManager.AnonymousClass14 */

                        @Override // android.content.BroadcastReceiver
                        public void onReceive(Context context, Intent intent) {
                            TLogger.ii("XGPushManager", "Register call back to " + context.getPackageName());
                            try {
                                CommonWorkingThread.getInstance().execute(new a(xGIOperateCallback, context, intent, 1, 0));
                            } catch (Throwable th) {
                                TLogger.e("XGPushManager", "register handle callback error " + th.toString());
                            }
                            j.a(context, this);
                        }
                    }, new IntentFilter("com.tencent.android.xg.vip.action.REGISTER.RESULT.V4"));
                } catch (Throwable th) {
                    TLogger.e("XGPushManager", "register registerReceiver error " + th.toString());
                }
            }
            d.a(context, intent);
        }
    }

    /* access modifiers changed from: private */
    public static void d(Context context, Intent intent, final XGIOperateCallback xGIOperateCallback) {
        try {
            d.a(context, new BroadcastReceiver() {
                /* class com.tencent.android.tpush.XGPushManager.AnonymousClass15 */

                @Override // android.content.BroadcastReceiver
                public void onReceive(final Context context, Intent intent) {
                    j.a(context, this);
                    if (XGPushConfig.isUsedOtherPush(context) && com.tencent.android.tpush.d.d.a(context).a()) {
                        try {
                            CommonWorkingThread.getInstance().execute(new Runnable() {
                                /* class com.tencent.android.tpush.XGPushManager.AnonymousClass15.AnonymousClass1 */

                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        com.tencent.android.tpush.d.d.a(context).d();
                                    } catch (Throwable th) {
                                        TLogger.e("XGPushManager", "unregister otherPush error " + th.toString());
                                    }
                                }
                            });
                        } catch (Throwable th) {
                            TLogger.e("XGPushManager", "unregister otherPush handle callback error " + th.toString());
                        }
                    }
                    if (xGIOperateCallback != null) {
                        try {
                            CommonWorkingThread.getInstance().execute(new a(xGIOperateCallback, context, intent, 1, 1));
                        } catch (Throwable th2) {
                            TLogger.e("XGPushManager", "unregister handle callback error " + th2.toString());
                        }
                    }
                    XGApiConfig.clearRegistered(context);
                    XGPushManager.enableService(context, false);
                }
            }, new IntentFilter("com.tencent.android.xg.vip.action.UNREGISTER.RESULT.V4"));
            d.a(context, intent);
        } catch (Throwable th) {
            TLogger.e("XGPushManager", "unregister registerReceiver error " + th.toString());
        }
    }

    /* compiled from: ProGuard */
    private static class a implements Runnable {
        private Context a;
        private Intent b;
        private XGIOperateCallback c;
        private int d;
        private int e = 0;

        a(XGIOperateCallback xGIOperateCallback, Context context, Intent intent, int i, int i2) {
            this.c = xGIOperateCallback;
            this.a = context;
            this.b = intent;
            this.d = i;
            this.e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.removeExtra("storage");
                int i = this.d;
                if (i == 1) {
                    this.a.getDir("dex", 0).getAbsolutePath();
                    CommonWorkingThread.getInstance().execute(new Runnable() {
                        /* class com.tencent.android.tpush.XGPushManager.a.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                        }
                    });
                    String stringExtra = this.b.getStringExtra("data");
                    if (stringExtra == null) {
                        stringExtra = "";
                    }
                    int intExtra = this.b.getIntExtra("operation", -1);
                    TLogger.d("XGPushManager", "TYPE_RSP - operation:" + intExtra + ", opType:" + this.e);
                    if (intExtra == 0) {
                        String stringExtra2 = this.b.getStringExtra("otherPushToken");
                        Long valueOf = Long.valueOf(this.b.getLongExtra("otherPushType", -1));
                        valueOf.longValue();
                        if (valueOf.longValue() > 0) {
                            if (!j.b(stringExtra2) && !j.b(stringExtra.toString())) {
                                SharePrefsUtil.setString(this.a, stringExtra2, stringExtra.toString());
                            }
                            stringExtra = stringExtra2;
                        }
                        this.c.onSuccess(stringExtra, this.b.getIntExtra("flag", -1));
                        RegisterEntity registerEntity = new RegisterEntity();
                        if (this.e == 0) {
                            PushPreferences.putInt(this.a, ".firstregister", 0);
                            registerEntity.state = 0;
                        } else {
                            registerEntity.state = 1;
                        }
                        registerEntity.accessId = this.b.getLongExtra("accId", 0);
                        registerEntity.packageName = this.a.getPackageName();
                        registerEntity.token = stringExtra;
                        registerEntity.timestamp = System.currentTimeMillis() / 1000;
                        registerEntity.xgSDKVersion = "1.2.3.1";
                        registerEntity.appVersion = com.tencent.android.tpush.common.b.a(this.a);
                        CacheManager.setCurrentAppRegisterEntity(this.a, registerEntity);
                        if (!j.b(registerEntity.packageName)) {
                            XGPushManager.lastSuccessRegisterMap.put(registerEntity.packageName, Long.valueOf(System.currentTimeMillis() / 1000));
                        }
                        if (XGPushConfig.isUsedOtherPush(this.a) && com.tencent.android.tpush.d.d.a(this.a).j()) {
                            com.tencent.android.tpush.d.b.a(this.a);
                        }
                    } else if (intExtra == 1) {
                        this.c.onFail(stringExtra, this.b.getIntExtra("code", -1), this.b.getStringExtra("msg"));
                    }
                } else if (i == 0) {
                    int intExtra2 = this.b.getIntExtra("operation", -1);
                    TLogger.d("XGPushManager", "TYPE_REQ - operation:" + intExtra2 + ", opType:" + this.e);
                    if (intExtra2 == 100) {
                        XGPushManager.c(this.a, this.b, this.c);
                    } else if (intExtra2 == 101) {
                        XGPushManager.d(this.a, this.b, this.c);
                    }
                }
                com.tencent.android.tpush.common.a.a(this.a);
            } catch (Throwable th) {
                TLogger.e("XGPushManager", "OperateRunnable", th);
            }
        }
    }

    private static String a(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\f') {
                sb.append("\\f");
            } else if (charAt == '\r') {
                sb.append("\\r");
            } else if (charAt == '\"' || charAt == '/' || charAt == '\\') {
                sb.append('\\');
                sb.append(charAt);
            } else {
                switch (charAt) {
                    case '\b':
                        sb.append("\\b");
                        continue;
                    case '\t':
                        sb.append("\\t");
                        continue;
                    case '\n':
                        sb.append("\\n");
                        continue;
                    default:
                        if (charAt > 31) {
                            sb.append(charAt);
                            break;
                        } else {
                            sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                            continue;
                        }
                }
            }
        }
        return sb.toString();
    }

    public static void openNotification(Context context) {
        j.i(context);
    }

    public static void openNotificationSettings(Context context) {
        j.j(context);
    }

    private static String b(Set<Integer> set) {
        if (set != null && set.size() > 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (Integer num : set) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("account", "");
                    jSONObject.put("accountType", num);
                    jSONArray.put(jSONObject);
                }
                TLogger.d("XGPushManager", "getAccountTypeSetJson | " + jSONArray.toString());
                return jSONArray.toString();
            } catch (Throwable th) {
                TLogger.ww("XGPushManager", "getAccountTypeSetJson:", th);
            }
        }
        return null;
    }

    private static String a(List<AccountInfo> list) {
        if (!(list == null || list.size() == 0)) {
            JSONArray jSONArray = new JSONArray();
            try {
                for (AccountInfo accountInfo : list) {
                    if (accountInfo != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("account", accountInfo.accountName);
                        jSONObject.put("accountType", accountInfo.accountType);
                        jSONArray.put(jSONObject);
                    }
                }
                TLogger.d("XGPushManager", "getAccountInfosJsonArrayString | " + jSONArray.toString());
                return jSONArray.toString();
            } catch (Throwable th) {
                TLogger.ww("XGPushManager", "getAccountInfosJsonArrayString | ", th);
            }
        }
        return "";
    }

    private static String a(String str, int i) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("account", str);
            jSONObject.put("accountType", i);
            jSONArray.put(jSONObject);
            return jSONArray.toString();
        } catch (Throwable th) {
            TLogger.ww("XGPushManager", "getTypeAccountsJsonArrayStr:", th);
            return null;
        }
    }

    public static void uploadLogFile(final Context context, final HttpRequestCallback httpRequestCallback) {
        if (context == null || httpRequestCallback == null) {
            TLogger.ee("XGPushManager", "parameter can not be null!");
            return;
        }
        try {
            final AnonymousClass16 r1 = new BroadcastReceiver() {
                /* class com.tencent.android.tpush.XGPushManager.AnonymousClass16 */

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    TLogger.ii("XGPushManager", "action - sendFlush onReceiver");
                    j.a(context, this);
                    CommonWorkingThread.getInstance().remove(26);
                    TBaseLogger.uploadLogFile(context.getApplicationContext(), httpRequestCallback);
                }
            };
            d.a(context, r1, new IntentFilter("com.tencent.android.xg.vip.action.FLUSH.RESULT.V4"));
            CommonWorkingThread.getInstance().executeAtTime(new Runnable() {
                /* class com.tencent.android.tpush.XGPushManager.AnonymousClass17 */

                @Override // java.lang.Runnable
                public void run() {
                    TLogger.ii("XGPushManager", "action - executeAtTime");
                    TBaseLogger.uploadLogFile(context.getApplicationContext(), httpRequestCallback);
                    j.a(context, r1);
                }
            }, 26, 3000);
            Intent intent = new Intent(context.getPackageName() + "com.tencent.android.xg.vip.action.FLUSH.V4");
            intent.putExtra("packName", Rijndael.encrypt(context.getPackageName()));
            d.a(context, intent);
        } catch (Throwable th) {
            TLogger.ww("XGPushManager", "unexpected for uploadLogFile:" + th.getMessage());
        }
    }

    public static void createNotificationChannel(Context context, String str, String str2, boolean z, boolean z2, boolean z3, Uri uri) {
        if (Build.VERSION.SDK_INT < 26) {
            TLogger.ii("XGPushManager", "CreateNotificationChannel SDK < 26");
            return;
        }
        try {
            Class<?> cls = Class.forName("android.app.NotificationChannel");
            Object newInstance = cls.getConstructor(String.class, CharSequence.class, Integer.TYPE).newInstance(str, str2, 4);
            newInstance.getClass().getMethod("enableVibration", Boolean.TYPE).invoke(newInstance, Boolean.valueOf(z));
            newInstance.getClass().getMethod("enableLights", Boolean.TYPE).invoke(newInstance, Boolean.valueOf(z2));
            Method method = newInstance.getClass().getMethod("setSound", Uri.class, Class.forName("android.media.AudioAttributes"));
            if (!z3) {
                method.invoke(newInstance, null, null);
            } else if (uri != null) {
                method.invoke(newInstance, uri, null);
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            notificationManager.getClass().getMethod("createNotificationChannel", cls).invoke(notificationManager, newInstance);
            TLogger.ii("XGPushManager", "CreateNotificationChannel channelId: " + str + " success");
        } catch (Throwable th) {
            TLogger.ee("XGPushManager", "CreateNotificationChannel channelId: " + str + " Error: ", th);
            th.printStackTrace();
        }
    }

    public static void logger(int i, String str, String str2, Throwable th) {
        TBaseLogger.addThirdLog(i, str, str2, th);
    }

    public static void onEvent(Context context, String str, Properties properties) {
        ServiceStat.reportCustomData(context, str, properties);
    }
}
