package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.aa;
import com.xiaomi.push.iz;
import com.xiaomi.push.j;
import com.xiaomi.push.jb;
import com.xiaomi.push.service.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class h {
    private static HashMap<String, String> a = new HashMap<>();

    public static MiPushMessage a(String str) {
        MiPushMessage miPushMessage = new MiPushMessage();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("messageId")) {
                    miPushMessage.setMessageId(jSONObject.getString("messageId"));
                }
                if (jSONObject.has("description")) {
                    miPushMessage.setDescription(jSONObject.getString("description"));
                }
                if (jSONObject.has("title")) {
                    miPushMessage.setTitle(jSONObject.getString("title"));
                }
                if (jSONObject.has("content")) {
                    miPushMessage.setContent(jSONObject.getString("content"));
                }
                if (jSONObject.has("passThrough")) {
                    miPushMessage.setPassThrough(jSONObject.getInt("passThrough"));
                }
                if (jSONObject.has("notifyType")) {
                    miPushMessage.setNotifyType(jSONObject.getInt("notifyType"));
                }
                if (jSONObject.has("messageType")) {
                    miPushMessage.setMessageType(jSONObject.getInt("messageType"));
                }
                if (jSONObject.has("alias")) {
                    miPushMessage.setAlias(jSONObject.getString("alias"));
                }
                if (jSONObject.has("topic")) {
                    miPushMessage.setTopic(jSONObject.getString("topic"));
                }
                if (jSONObject.has("user_account")) {
                    miPushMessage.setUserAccount(jSONObject.getString("user_account"));
                }
                if (jSONObject.has("notifyId")) {
                    miPushMessage.setNotifyId(jSONObject.getInt("notifyId"));
                }
                if (jSONObject.has("category")) {
                    miPushMessage.setCategory(jSONObject.getString("category"));
                }
                if (jSONObject.has("isNotified")) {
                    miPushMessage.setNotified(jSONObject.getBoolean("isNotified"));
                }
                if (jSONObject.has("extra")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("extra");
                    Iterator<String> keys = jSONObject2.keys();
                    HashMap hashMap = new HashMap();
                    while (keys != null && keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.getString(next));
                    }
                    if (hashMap.size() > 0) {
                        miPushMessage.setExtra(hashMap);
                    }
                }
            } catch (Exception e) {
                c.d(e.toString());
            }
        }
        return miPushMessage;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041 A[Catch:{ Exception -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0050 A[RETURN] */
    protected static PushMessageReceiver a(Context context) {
        ResolveInfo resolveInfo;
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                Iterator<ResolveInfo> it2 = queryBroadcastReceivers.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    resolveInfo = it2.next();
                    if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.packageName.equals(context.getPackageName())) {
                        break;
                    }
                }
                if (resolveInfo == null) {
                    return (PushMessageReceiver) jb.a(context, resolveInfo.activityInfo.name).newInstance();
                }
                return null;
            }
            resolveInfo = null;
            if (resolveInfo == null) {
            }
        } catch (Exception e) {
            c.d(e.toString());
            return null;
        }
    }

    protected static synchronized String a(Context context, String str) {
        String str2;
        synchronized (h.class) {
            str2 = a.get(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
        }
        return str2;
    }

    public static String a(d dVar) {
        int i = j.a[dVar.ordinal()];
        if (i == 1) {
            return "hms_push_token";
        }
        if (i == 2) {
            return "fcm_push_token";
        }
        if (i == 3) {
            return "cos_push_token";
        }
        if (i != 4) {
            return null;
        }
        return "ftos_push_token";
    }

    public static HashMap<String, String> a(Context context, d dVar) {
        StringBuilder sb;
        ah ahVar;
        HashMap<String, String> hashMap = new HashMap<>();
        String a2 = a(dVar);
        if (TextUtils.isEmpty(a2)) {
            return hashMap;
        }
        int i = j.a[dVar.ordinal()];
        String str = null;
        ApplicationInfo applicationInfo = null;
        if (i != 1) {
            if (i == 2) {
                sb = new StringBuilder();
                sb.append("brand:");
                ahVar = ah.FCM;
            } else if (i == 3) {
                sb = new StringBuilder();
                sb.append("brand:");
                ahVar = ah.OPPO;
            } else if (i == 4) {
                sb = new StringBuilder();
                sb.append("brand:");
                ahVar = ah.VIVO;
            }
            sb.append(ahVar.name());
            sb.append("~");
            sb.append("token");
            sb.append(":");
            sb.append(a(context, a2));
            sb.append("~");
            sb.append("package_name");
            sb.append(":");
            sb.append(context.getPackageName());
            str = sb.toString();
        } else {
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            } catch (Exception e) {
                c.d(e.toString());
            }
            int i2 = -1;
            if (applicationInfo != null) {
                i2 = applicationInfo.metaData.getInt("com.huawei.hms.client.appid");
            }
            str = "brand:" + m.a(context).name() + "~token:" + a(context, a2) + "~package_name:" + context.getPackageName() + "~app_id:" + i2;
        }
        hashMap.put("RegInfo", str);
        return hashMap;
    }

    /* renamed from: a  reason: collision with other method in class */
    static void m71a(Context context) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a2 = a(d.ASSEMBLE_PUSH_HUAWEI);
        String a3 = a(d.ASSEMBLE_PUSH_FCM);
        if (!TextUtils.isEmpty(sharedPreferences.getString(a2, "")) && TextUtils.isEmpty(sharedPreferences.getString(a3, ""))) {
            z = true;
        }
        if (z) {
            aq.a(context).a(2, a2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m72a(Context context, d dVar) {
        String a2 = a(dVar);
        if (!TextUtils.isEmpty(a2)) {
            iz.a(context.getSharedPreferences("mipush_extra", 0).edit().putString(a2, ""));
        }
    }

    public static void a(Context context, d dVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            String a2 = a(dVar);
            if (TextUtils.isEmpty(a2)) {
                c.a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                return;
            }
            String string = sharedPreferences.getString(a2, "");
            if (TextUtils.isEmpty(string) || !str.equals(string)) {
                c.a("ASSEMBLE_PUSH : send token upload");
                a(dVar, str);
                av a3 = k.a(dVar);
                if (a3 != null) {
                    aq.a(context).a((String) null, a3, dVar);
                    return;
                }
                return;
            }
            c.a("ASSEMBLE_PUSH : do not need to send token");
        }
    }

    public static void a(Intent intent) {
        Bundle extras;
        if (intent != null && (extras = intent.getExtras()) != null && extras.containsKey("pushMsg")) {
            intent.putExtra("key_message", a(extras.getString("pushMsg")));
        }
    }

    private static synchronized void a(d dVar, String str) {
        synchronized (h.class) {
            String a2 = a(dVar);
            if (TextUtils.isEmpty(a2)) {
                c.a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            } else if (TextUtils.isEmpty(str)) {
                c.a("ASSEMBLE_PUSH : token is null");
            } else {
                a.put(a2, str);
            }
        }
    }

    public static void a(String str, int i) {
        MiTinyDataClient.upload("hms_push_error", str, 1, "error code = " + i);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m73a(Context context) {
        if (context == null) {
            return false;
        }
        return aa.c(context);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m74a(Context context, d dVar) {
        if (k.m76a(dVar) != null) {
            return l.a(context).a(k.m76a(dVar).a(), true);
        }
        return false;
    }

    public static String b(d dVar) {
        int i = j.a[dVar.ordinal()];
        if (i == 1) {
            return "hms_push_error";
        }
        if (i == 2) {
            return "fcm_push_error";
        }
        if (i == 3) {
            return "cos_push_error";
        }
        if (i != 4) {
            return null;
        }
        return "ftos_push_error";
    }

    public static void b(Context context) {
        e.a(context).register();
    }

    public static void b(Context context, d dVar, String str) {
        j.a(context).a(new i(str, context, dVar));
    }

    public static void c(Context context) {
        e.a(context).unregister();
    }

    /* access modifiers changed from: private */
    public static synchronized void d(Context context, d dVar, String str) {
        synchronized (h.class) {
            String a2 = a(dVar);
            if (TextUtils.isEmpty(a2)) {
                c.a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                return;
            }
            iz.a(context.getSharedPreferences("mipush_extra", 0).edit().putString(a2, str));
            c.a("ASSEMBLE_PUSH : update sp file success!  " + str);
        }
    }
}
