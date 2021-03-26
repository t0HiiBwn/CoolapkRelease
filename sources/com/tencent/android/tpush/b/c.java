package com.tencent.android.tpush.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.common.f;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.data.CachedMessageIntent;
import com.tencent.android.tpush.data.MessageId;
import com.tencent.android.tpush.e.a;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.PushMd5Pref;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class c {
    private static c a = new c();
    private static final byte[] b = new byte[0];

    private c() {
    }

    public static c a() {
        return a;
    }

    public ArrayList<MessageId> a(Context context, String str) {
        Object a2;
        ArrayList<MessageId> arrayList = (context == null || j.b(str) || (a2 = a(context, str, ".tpns.msg.id")) == null) ? null : (ArrayList) a2;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public void a(Context context, String str, ArrayList<MessageId> arrayList) {
        synchronized (b) {
            if (!(context == null || arrayList == null)) {
                a(context, str, ".tpns.msg.id", arrayList);
            }
        }
    }

    public ArrayList<Intent> a(Context context) {
        if (context != null) {
            return a.c(context);
        }
        return null;
    }

    public void a(Context context, Intent intent) {
        if (context != null) {
            a.a(context, intent);
        }
    }

    public void b(Context context) {
        if (context != null) {
            a.a(context);
        }
    }

    public void a(Context context, long j) {
        if (context != null) {
            a.f(context, j);
        }
    }

    public void b(Context context, long j) {
        if (context != null) {
            a.e(context, j);
        }
    }

    public void c(Context context, long j) {
        if (context != null) {
            a.a(context, j);
        }
    }

    public void d(Context context, long j) {
        if (context != null) {
            a.b(context, j);
        }
    }

    public void e(Context context, long j) {
        if (context != null) {
            a.c(context, j);
        }
    }

    public void f(Context context, long j) {
        if (context != null) {
            a.d(context, j);
        }
    }

    public void c(Context context) {
        if (context != null) {
            a.b(context);
        }
    }

    public void a(Context context, String str, MessageId messageId) {
        synchronized (b) {
            if (context != null) {
                if (!j.b(str) && messageId != null) {
                    ArrayList<MessageId> a2 = a(context, str);
                    if (a2 == null) {
                        a2 = new ArrayList<>();
                    } else {
                        int i = 0;
                        while (true) {
                            if (i >= a2.size()) {
                                break;
                            } else if (a2.get(i).id == messageId.id) {
                                a2.remove(i);
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                    a2.add(messageId);
                    a(context, str, a2);
                }
            }
        }
    }

    public MessageId a(Context context, String str, long j) {
        ArrayList<MessageId> a2;
        if (context == null || j.b(str) || j <= 0 || (a2 = a(context, str)) == null || a2.size() <= 0) {
            return null;
        }
        for (MessageId messageId : a2) {
            if (messageId.id == j) {
                return messageId;
            }
        }
        return null;
    }

    public boolean b(Context context, String str, long j) {
        ArrayList<MessageId> a2;
        if (context == null || j.b(str) || j <= 0 || (a2 = a(context, str)) == null || a2.size() <= 0) {
            return false;
        }
        for (MessageId messageId : a2) {
            if (messageId.id == j) {
                return messageId.isMsgAcked();
            }
        }
        return false;
    }

    public void b(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("action", 2);
            boolean z = false;
            if (optInt == 1) {
                for (String str2 : jSONObject.optString("pushIdList", "").split(",")) {
                    a(context, Long.valueOf(str2).longValue());
                }
            } else if (optInt == 2) {
                b(context);
            } else if (optInt == 3) {
                int optInt2 = jSONObject.optInt("enabled", -1);
                TLogger.ii("MessageManager", "setLogToFile with cmd = " + optInt2);
                if (optInt2 != -1) {
                    if (optInt2 > 0) {
                        z = true;
                    }
                    TLogger.enableDebug(context, z);
                }
            }
        } catch (Throwable th) {
            TLogger.e("MessageManager", "onCrtlMsgHandle", th);
        }
    }

    public static String g(Context context, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(PushMd5Pref.getString(context, "tpush_msgId_" + j, true));
        String sb2 = sb.toString();
        if (sb2 != null && sb2.length() > 20480) {
            sb2 = sb2.substring(0, sb2.indexOf("@@", 5120));
        }
        if (sb2 != null) {
            return sb2;
        }
        return "";
    }

    private void a(Context context, String str, String str2, ArrayList<?> arrayList) {
        try {
            if (arrayList.size() > 50) {
                arrayList.subList(0, 10).clear();
            }
            String encrypt = Rijndael.encrypt(f.a(arrayList));
            PushPreferences.putString(context, str + str2, encrypt);
        } catch (Throwable th) {
            TLogger.e("MessageManager", "putSettings", th);
        }
    }

    private Object a(Context context, String str, String str2) {
        try {
            return f.a(Rijndael.decrypt(PushPreferences.getString(context, str + str2, null)));
        } catch (Throwable th) {
            TLogger.e("MessageManager", "getSettings", th);
            return null;
        }
    }

    public ArrayList<CachedMessageIntent> c(Context context, String str) {
        Object a2;
        ArrayList<CachedMessageIntent> arrayList = null;
        if (context != null) {
            try {
                if (!j.b(str) && (a2 = a(context, str, ".tpns.msg.id.cached")) != null) {
                    arrayList = (ArrayList) a2;
                }
            } catch (Throwable unused) {
                return new ArrayList<>();
            }
        }
        if (arrayList == null) {
            return new ArrayList<>();
        }
        return arrayList;
    }

    public void a(Context context, String str, Intent intent) {
        int size;
        synchronized (b) {
            if (context != null) {
                if (!j.b(str) && intent != null) {
                    CachedMessageIntent cachedMessageIntent = new CachedMessageIntent();
                    cachedMessageIntent.pkgName = str;
                    cachedMessageIntent.msgId = intent.getLongExtra("msgId", -1);
                    cachedMessageIntent.intent = Rijndael.encrypt(intent.toUri(1));
                    ArrayList<CachedMessageIntent> c = c(context, str);
                    if (c == null) {
                        c = new ArrayList<>();
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < c.size(); i++) {
                            CachedMessageIntent cachedMessageIntent2 = c.get(i);
                            if (cachedMessageIntent2.equals(cachedMessageIntent)) {
                                arrayList.add(cachedMessageIntent2);
                            }
                        }
                        c.removeAll(arrayList);
                    }
                    if (c != null && c.size() > 45 && (size = c.size() - 45) >= 0) {
                        TLogger.w("MessageManager", "too much cache msg, try to cut " + size + " list.size: " + c.size());
                        c.subList(0, size).clear();
                    }
                    c.add(cachedMessageIntent);
                    b(context, str, c);
                }
            }
        }
    }

    public void b(Context context, String str, ArrayList<CachedMessageIntent> arrayList) {
        synchronized (b) {
            if (!(context == null || arrayList == null)) {
                TLogger.v("MessageManager", "updateCachedMsgIntentByPkgName, size: " + arrayList.size());
                a(context, str, ".tpns.msg.id.cached", arrayList);
            }
        }
    }

    public void d(Context context, String str) {
        synchronized (b) {
            if (context != null) {
                b(context, str, new ArrayList<>());
            }
        }
    }
}
