package com.tencent.android.tpush;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import java.util.Set;

/* compiled from: ProGuard */
public class XGPush4Msdk {
    private static long a = 0;
    private static long b = 0;
    private static String c = "";

    private static boolean a(long j, long j2, long j3) {
        return j >= j2 && j < j3;
    }

    public static void setQQAppKey(Context context, String str) {
    }

    /* access modifiers changed from: private */
    public static String b(Context context) {
        return context.getPackageName() + ":XG_DEBUG_SERVER_INFO";
    }

    public static void setDebugServerInfo(final Context context, String str, int i) {
        if (!j.b(str)) {
            String b2 = b(context);
            PushPreferences.putString(context, b2, str + "," + i);
            return;
        }
        CommonWorkingThread.getInstance().execute(new Runnable() {
            /* class com.tencent.android.tpush.XGPush4Msdk.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                Context context = context;
                if (!j.b(PushPreferences.getString(context, XGPush4Msdk.b(context), null))) {
                    Context context2 = context;
                    PushPreferences.remove(context2, XGPush4Msdk.b(context2));
                }
            }
        });
    }

    public static String getDebugServerInfo(Context context) {
        return PushPreferences.getString(context, b(context), null);
    }

    public static boolean isDebugServerInfoStrategyItem(Context context) {
        try {
            String debugServerInfo = getDebugServerInfo(b.e());
            if (!j.b(debugServerInfo)) {
                String[] split = debugServerInfo.split(",");
                if (split.length == 2 && split[0].length() > 4) {
                    return true;
                }
            }
        } catch (Throwable th) {
            TLogger.e("XGPush4Msdk", " .isDebugServerInfoStrategyItem", th);
        }
        return false;
    }

    public static void setQQAppId(Context context, long j) {
        long j2 = 0;
        if (a(j, 0, 200000)) {
            j2 = 90000000;
        } else if (!a(j, 99000000, 100000000)) {
            if (a(j, 100200000, 100600000)) {
                j2 = -10000000;
            } else if (a(j, 101000000, 101400000)) {
                j2 = -10400000;
            } else if (a(j, 900000000, 900100000)) {
                j2 = -809000000;
            } else if (a(j, 1000000000, 1000100000)) {
                j2 = -908900000;
            } else if (a(j, 1101000000, 1104500000)) {
                j2 = -1009800000;
            } else if (a(j, 1150000000, 1150100000)) {
                j2 = -1055300000;
            } else if (a(j, 100600000, 101000000)) {
                j2 = -5800000;
            } else if (a(j, 1104500000, 1109300000)) {
                j2 = -1009300000;
            } else if (a(j, 1109300000, 1119300000)) {
                j2 = -1029300000;
            } else if (a(j, 1119300000, 1120000000)) {
                j2 = -1049300000;
            } else {
                TLogger.e("XGPush4Msdk", "手Q的appid：" + j + " 不在固定的范围，请联系msdk和信鸽的同事解决之。");
            }
        }
        long j3 = j2 + 2100000000 + j;
        a = j;
        b = j3;
        PushPreferences.putLong(context, "TPUSH_QQ_ACCESS_ID", j3);
        PushPreferences.remove(context, "TPUSH_QQ_APP_ID");
        String str = "MSDK_" + j;
        c = str;
        PushPreferences.putString(context, "__en__TPUSH_QQ_ACCESS_KEY", Rijndael.encrypt(str));
        PushPreferences.remove(context, "TPUSH_QQ_ACCESS_KEY");
    }

    public static long getQQAccessId(Context context) {
        long j = b;
        if (j <= 0) {
            b = PushPreferences.getLong(context, "TPUSH_QQ_ACCESS_ID", j);
        }
        return b;
    }

    public static String getQQAppKey(Context context) {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        String string = PushPreferences.getString(context, "__en__TPUSH_QQ_ACCESS_KEY", c);
        if (!TextUtils.isEmpty(string)) {
            c = Rijndael.decrypt(string);
        } else {
            c = PushPreferences.getString(context, "TPUSH_QQ_ACCESS_KEY", "");
            PushPreferences.putString(context, "TPUSH_QQ_ACCESS_KEY", "");
        }
        return c;
    }

    public static void setTag(Context context, String str) {
        TLogger.d("XGPush4Msdk", "setTag: tagName=" + str + ",qqAppid=" + a + ",xg_accessid=" + getQQAccessId(context));
        XGPushManager.a(context, str, 1, getQQAccessId(context), getQQAppKey(context), str);
    }

    public static void deleteTag(Context context, String str) {
        if (XGPushConfig.enableDebug) {
            TLogger.d("XGPush4Msdk", "deleteTag: tagName=" + str + ",qqAppid=" + a + ",xg_accessid=" + getQQAccessId(context));
        }
        XGPushManager.a(context, str, 2, getQQAccessId(context), getQQAppKey(context), str);
    }

    public static void setTags(Context context, String str, Set<String> set) {
        if (XGPushConfig.enableDebug) {
            TLogger.d("XGPush4Msdk", "setTags: operateName=" + str + ",qqAppid=" + a + ",xg_accessid=" + getQQAccessId(context));
        }
        if (context == null || set == null || set.isEmpty()) {
            TLogger.ee("XGPush4Msdk", "the parameter context or tags of setTags is invalid.");
            return;
        }
        String a2 = XGPushManager.a(set, "setTags");
        if (a2 == null) {
            TLogger.ee("XGPush4Msdk", "setTags -> getTagsFromSet return null!!!");
            return;
        }
        TLogger.ii("XGPush4Msdk", "Action -> setTags with all tags = " + a2);
        XGPushManager.a(context, a2, 6, getQQAccessId(context), getQQAppKey(context), str);
    }

    public static void addTags(Context context, String str, Set<String> set) {
        if (XGPushConfig.enableDebug) {
            TLogger.d("XGPush4Msdk", "addTags: operateName=" + str + ",qqAppid=" + a + ",xg_accessid=" + getQQAccessId(context));
        }
        if (context == null || set == null || set.isEmpty()) {
            TLogger.ee("XGPush4Msdk", "the parameter context or tags of addTags is invalid.");
            return;
        }
        String a2 = XGPushManager.a(set, "addTags");
        if (a2 == null) {
            TLogger.ee("XGPush4Msdk", "addTags -> getTagsFromSet return null!!!");
            return;
        }
        if (XGPushConfig.enableDebug) {
            TLogger.ii("XGPush4Msdk", "addTags -> setTags with all tags = " + a2);
        }
        XGPushManager.a(context, a2, 5, getQQAccessId(context), getQQAppKey(context), str);
    }

    public static void deleteTags(Context context, String str, Set<String> set) {
        if (XGPushConfig.enableDebug) {
            TLogger.d("XGPush4Msdk", "deleteTags: operateName=" + str + ",qqAppid=" + a + ",xg_accessid=" + getQQAccessId(context));
        }
        if (context == null || set == null || set.isEmpty()) {
            TLogger.ee("XGPush4Msdk", "the parameter context or tags of deleteTags is invalid.");
            return;
        }
        String a2 = XGPushManager.a(set, "deleteTags");
        if (a2 == null) {
            TLogger.ee("XGPush4Msdk", "deleteTags -> getTagsFromSet return null!!!");
            return;
        }
        if (XGPushConfig.enableDebug) {
            TLogger.ii("XGPush4Msdk", "deleteTags -> setTags with all tags = " + a2);
        }
        XGPushManager.a(context, a2, 7, getQQAccessId(context), getQQAppKey(context), str);
    }

    public static void cleanTags(Context context, String str) {
        if (XGPushConfig.enableDebug) {
            TLogger.d("XGPush4Msdk", "cleanTags: operateName=" + str + ",qqAppid=" + a + ",xg_accessid=" + getQQAccessId(context));
        }
        if (context == null) {
            TLogger.ee("XGPush4Msdk", "the parameter context of cleanTags is invalid");
            return;
        }
        if (XGPushConfig.enableDebug) {
            TLogger.ii("XGPush4Msdk", "Action -> cleanTags");
        }
        XGPushManager.a(context, "*", 8, getQQAccessId(context), getQQAppKey(context), str);
    }

    public static void registerPush(Context context, XGIOperateCallback xGIOperateCallback) {
        if (XGPushConfig.enableDebug) {
            TLogger.i("XGPush4Msdk", "registerPush=,qqAppid=" + a + ",xg_accessid=" + getQQAccessId(context));
        }
        if (xGIOperateCallback == null) {
            xGIOperateCallback = new XGIOperateCallback() {
                /* class com.tencent.android.tpush.XGPush4Msdk.AnonymousClass2 */

                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onSuccess(Object obj, int i) {
                    TLogger.i("XGPush4Msdk", "xg register push onSuccess. token:" + obj);
                }

                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onFail(Object obj, int i, String str) {
                    TLogger.e("XGPush4Msdk", "xg register push onFail. token:" + obj + ", errCode:" + i + ",msg:" + str);
                }
            };
        }
        XGPushManager.a(context, null, -1, null, xGIOperateCallback, getQQAccessId(context), getQQAppKey(context), null, null, null);
    }

    public static void unregisterPush(Context context, XGIOperateCallback xGIOperateCallback) {
        if (XGPushConfig.enableDebug) {
            TLogger.i("XGPush4Msdk", "unregisterPush,qqAppid=" + a + ",xg_accessid=" + getQQAccessId(context));
        }
        if (xGIOperateCallback == null) {
            xGIOperateCallback = new XGIOperateCallback() {
                /* class com.tencent.android.tpush.XGPush4Msdk.AnonymousClass3 */

                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onSuccess(Object obj, int i) {
                    TLogger.i("XGPush4Msdk", "xg unregisterPush push onSuccess. flag:" + i);
                }

                @Override // com.tencent.android.tpush.XGIOperateCallback
                public void onFail(Object obj, int i, String str) {
                    TLogger.e("XGPush4Msdk", "xg unregisterPush push onFail. token:" + obj + ", errCode:" + i + ",msg:" + str);
                }
            };
        }
        XGPushManager.a(context, xGIOperateCallback, getQQAccessId(context), getQQAppKey(context), (String) null, (String) null, (String) null);
    }

    public static long addLocalNotification(Context context, XGLocalMessage xGLocalMessage) {
        if (XGPushConfig.enableDebug) {
            TLogger.i("XGPush4Msdk", "addLocalNotification:msg=" + xGLocalMessage.toString() + ",qqAppid=" + a + ",xg_accessid=" + getQQAccessId(context));
        }
        return XGPushManager.a(context, xGLocalMessage, getQQAccessId(context));
    }

    public static void setPushNotificationBuilder(Context context, int i, XGPushNotificationBuilder xGPushNotificationBuilder) {
        if (context == null) {
            throw new IllegalArgumentException("context is null.");
        } else if (i < 5000 || i > 6000) {
            throw new IllegalArgumentException("notificationBulderId超过范围[5000, 6000].");
        } else if (xGPushNotificationBuilder != null) {
            com.tencent.android.tpush.b.b.a(context, i, xGPushNotificationBuilder);
        }
    }

    public static void setDefaultNotificationBuilder(Context context, XGPushNotificationBuilder xGPushNotificationBuilder) {
        XGPushManager.setDefaultNotificationBuilder(context, xGPushNotificationBuilder);
    }
}
