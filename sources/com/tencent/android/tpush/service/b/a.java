package com.tencent.android.tpush.service.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.android.tpush.b.c;
import com.tencent.android.tpush.common.f;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.data.MessageId;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.inappmessage.g;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.rpc.a;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.util.d;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import java.io.PrintStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class a {
    private static a a = new a();
    private static final byte[] b = new byte[0];
    private static long c = 0;
    private static volatile boolean d = false;
    private static volatile boolean e = false;
    private static volatile boolean f = false;
    private static volatile boolean g = false;
    private static ConcurrentHashMap<Long, Map<String, List<Long>>> h = null;

    private a() {
    }

    public static a a() {
        c();
        return a;
    }

    public synchronized void a(Context context, Intent intent) {
        if (!(context == null || intent == null)) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                MessageId messageId = new MessageId();
                messageId.id = intent.getLongExtra("msgId", -1);
                if (messageId.id < 0) {
                    TLogger.v("SrvMessageManager", "@@ msgSendSDKAck: Not add LocalMsg");
                    return;
                }
                messageId.accessId = intent.getLongExtra("accId", -1);
                messageId.host = intent.getLongExtra("extra_host", -1);
                messageId.port = intent.getIntExtra("extra_port", -1);
                messageId.pact = intent.getByteExtra("extra_pact", (byte) -1);
                messageId.apn = DeviceInfos.getNetworkType(b.e());
                messageId.isp = j.o(b.e());
                messageId.serviceHost = b.e().getPackageName();
                messageId.receivedTime = currentTimeMillis;
                messageId.pkgName = intent.getPackage();
                messageId.busiMsgId = intent.getLongExtra("busiMsgId", -1);
                messageId.timestamp = intent.getLongExtra("timestamps", -1);
                messageId.msgType = intent.getLongExtra("type", -1);
                messageId.multiPkg = intent.getLongExtra("multiPkg", -1);
                messageId.date = intent.getStringExtra("date");
                messageId.channelId = intent.getLongExtra("channel_id", -1);
                String stringExtra = intent.getStringExtra("group_id");
                if (!j.b(stringExtra)) {
                    messageId.groupId = stringExtra;
                }
                String stringExtra2 = intent.getStringExtra("stat_tag");
                if (!j.b(stringExtra2)) {
                    messageId.statTag = stringExtra2;
                }
                a(context, "all", messageId);
                a(context, messageId);
            } catch (Throwable th) {
                TLogger.e("SrvMessageManager", "msgSendSDKAck", th);
            }
        }
        return;
    }

    private synchronized void a(Context context, MessageId messageId) {
    }

    public void a(Context context, String str, MessageId messageId) {
        synchronized (b) {
            if (context != null) {
                if (!j.b(str) && messageId != null) {
                    ArrayList<MessageId> a2 = a(context, str);
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < a2.size(); i++) {
                        MessageId messageId2 = a2.get(i);
                        if (messageId2.id == messageId.id) {
                            arrayList.add(messageId2);
                        }
                    }
                    a2.removeAll(arrayList);
                    a2.add(messageId);
                    a(context, str, a2);
                }
            }
        }
    }

    private ArrayList<MessageId> a(Context context, String str) {
        Object a2;
        ArrayList<MessageId> arrayList = (context == null || j.b(str) || (a2 = a(context, str, ".tpns.msg.id.send.sdk")) == null) ? null : (ArrayList) a2;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public void a(Context context, String str, ArrayList<MessageId> arrayList) {
        synchronized (b) {
            if (!(context == null || arrayList == null)) {
                a(context, str, ".tpns.msg.id.send.sdk", arrayList);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v14, types: [java.lang.String[], java.io.Serializable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private void a(com.tencent.android.tpush.service.protocol.j jVar, long j, com.tencent.android.tpush.service.channel.a aVar) {
        Context context;
        Context context2;
        Throwable th;
        TLogger.d("SrvMessageManager", "distribute2SDK: " + jVar.toString());
        Context e2 = b.e();
        Intent intent = new Intent("com.tencent.android.xg.vip.action.INTERNAL_PUSH_MESSAGE");
        intent.setPackage(jVar.g);
        intent.putExtra("msgId", jVar.a);
        intent.putExtra("title", Rijndael.encrypt(jVar.d));
        intent.putExtra("content", Rijndael.encrypt(jVar.e));
        intent.putExtra("date", jVar.j);
        intent.putExtra("type", jVar.f);
        intent.putExtra("accId", jVar.b);
        intent.putExtra("busiMsgId", jVar.c);
        intent.putExtra("timestamps", jVar.h);
        intent.putExtra("multiPkg", jVar.i);
        intent.putExtra("server_time", jVar.k);
        intent.putExtra("ttl", jVar.l);
        intent.putExtra("group_id", jVar.r);
        intent.putExtra("targetType", jVar.t);
        intent.putExtra("source", jVar.u);
        intent.putExtra("revokeId", jVar.v);
        intent.putExtra("templateId", jVar.w);
        intent.putExtra("traceId", jVar.x);
        long j2 = jVar.m;
        if (!com.tencent.android.tpush.f.a.a(e2) || jVar.g.equals(e2.getPackageName())) {
            intent.putExtra("pushChannel", 100);
        } else {
            intent.putExtra("pushChannel", com.tencent.android.tpush.f.a.a());
        }
        intent.putExtra("groupId", jVar.s);
        intent.putExtra("svrAck", true);
        intent.putExtra("svrPkgName", b.h());
        if (jVar.v > 0) {
            ServiceStat.appReportRevokeMessageServiceReceived(b.e(), intent);
        } else {
            ServiceStat.appReportServiceReceived(b.e(), intent);
        }
        int i = jVar.l;
        long j3 = jVar.k;
        long j4 = jVar.h;
        long currentTimeMillis = System.currentTimeMillis();
        long j5 = 259200000;
        if (i > 0) {
            j5 = ((long) i) * 1000;
            context = e2;
        } else {
            context = e2;
            if (jVar.a > 0 && i == 0) {
                j5 = 30000;
            }
        }
        long j6 = (j3 <= 0 || j4 <= 0) ? currentTimeMillis + j5 : ((j3 - j4) * 1000) + currentTimeMillis + j5;
        Long.signum(j3);
        intent.putExtra("time_gap", currentTimeMillis - (j3 * 1000));
        intent.putExtra("expire_time", j6);
        try {
            intent.putExtra("enKeySet", f.a((Serializable) new String[]{"title", "content"}));
        } catch (Throwable th2) {
            TLogger.e("SrvMessageManager", "distribute2SDK", th2);
        }
        intent.putExtra("extra_push_time", j);
        long j7 = jVar.i;
        long j8 = jVar.b;
        String str = null;
        if (!com.tencent.android.tpush.f.a.a(context) || jVar.g.equals(context.getPackageName())) {
            context2 = context;
            if (j7 != 0) {
                String findValidPackageByAccessid = CacheManager.findValidPackageByAccessid(j8);
                if (!j.b(findValidPackageByAccessid)) {
                    str = findValidPackageByAccessid;
                }
            } else if (jVar.g.equals(context2.getPackageName())) {
                str = jVar.g;
            } else {
                TLogger.w("SrvMessageManager", "receive message but package name is not right");
            }
        } else if (j7 == 0) {
            context2 = context;
            if (com.tencent.android.tpush.f.a.a(context2, jVar.b, jVar.g)) {
                intent.putExtra("third_app_pkgname", jVar.g);
                str = context2.getPackageName();
            }
        } else {
            context2 = context;
            String a2 = com.tencent.android.tpush.f.a.a(context2, jVar.b);
            if (a2 != null) {
                intent.putExtra("third_app_pkgname", a2);
                str = context2.getPackageName();
            }
        }
        TLogger.i("SrvMessageManager", "distribute2SDK appPkgName: " + str);
        try {
            TLogger.i("SrvMessageManager", "distribute2SDK pkgs msgid " + jVar.a + "  pkg " + jVar.g);
            if (j.b(str)) {
                TLogger.d("SrvMessageManager", ">> msg.appPkgName is null!");
                ServiceStat.reportErrCode(context2, -103, "distribute2SDK msgId:" + jVar.a, 0, "inner");
                return;
            }
            if (!com.tencent.android.tpush.f.a.a(context2)) {
                com.tencent.android.tpush.a.a.a(b.e()).a(str);
            }
            RegisterEntity registerInfoByPkgName = CacheManager.getRegisterInfoByPkgName(str);
            if (registerInfoByPkgName == null) {
                TLogger.v("SrvMessageManager", "RegInfo is null " + str);
                try {
                    a(jVar.j, intent, str);
                } catch (Throwable th3) {
                    th = th3;
                    TLogger.e("SrvMessageManager", "dispatchMessageOnTime", th);
                    ServiceStat.reportErrCode(context2, -104, "sendMsgByPkgName err:" + Util.getThrowableToString(th), 0, "inner");
                }
            } else if (registerInfoByPkgName.state > 0) {
                c.a().d(b.e(), str);
                ServiceStat.reportErrCode(context2, -104, "regInfo.state:" + registerInfoByPkgName.state, 0, "inner");
            } else {
                intent.setPackage(str);
                if (!com.tencent.android.tpush.a.a(b.e(), intent.getPackage(), intent)) {
                    a(jVar.j, intent, str);
                } else {
                    a(b.e(), intent);
                }
            }
        } catch (Throwable th4) {
            th = th4;
            TLogger.e("SrvMessageManager", "dispatchMessageOnTime", th);
            ServiceStat.reportErrCode(context2, -104, "sendMsgByPkgName err:" + Util.getThrowableToString(th), 0, "inner");
        }
    }

    public void a(String str, Intent intent, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        if (j.b(str) || (!j.b(str) && simpleDateFormat.parse(str).compareTo(simpleDateFormat.parse(simpleDateFormat.format(new Date()))) == 0)) {
            if (com.tencent.android.tpush.service.util.f.a(intent)) {
                TLogger.d("SrvMessageManager", ">> send rpc message intent:" + intent);
                a(intent);
            }
        } else if (!j.b(str) && simpleDateFormat.parse(str).compareTo(simpleDateFormat.parse(simpleDateFormat.format(new Date()))) < 0) {
            a(intent);
        }
    }

    public void a(final Intent intent) {
        CommonWorkingThread.getInstance().execute(new Runnable() {
            /* class com.tencent.android.tpush.service.b.a.AnonymousClass1 */
            private com.tencent.android.tpush.rpc.a c;
            private com.tencent.android.tpush.rpc.c d = new com.tencent.android.tpush.rpc.c();
            private ServiceConnection e = new ServiceConnection() {
                /* class com.tencent.android.tpush.service.b.a.AnonymousClass1.AnonymousClass1 */

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    try {
                        AnonymousClass1.this.c = a.AbstractBinderC0132a.a(iBinder);
                        if (AnonymousClass1.this.c != null) {
                            AnonymousClass1.this.c.a(intent.toURI(), AnonymousClass1.this.d);
                        }
                    } catch (Throwable th) {
                        TLogger.e("SrvMessageManager", "SendBroadcastByRPC", th);
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    AnonymousClass1.this.e = null;
                    AnonymousClass1.this.c = null;
                    AnonymousClass1.this.d = null;
                }
            };

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = intent;
                    intent.setAction(intent.getPackage() + ".XGVIP_PUSH_ACTION");
                    this.d.a(this.e);
                    if (!b.e().bindService(intent, this.e, 1)) {
                        TLogger.e("SrvMessageManager", "Failed Send AIDL" + intent + " failed  msgid = " + intent.getLongExtra("msgId", -1));
                        c.a().a(b.e(), intent.getPackage(), intent);
                        ServiceStat.reportErrCode(b.e(), -104, "bind aidl remote service return false", 0, "inner");
                        return;
                    }
                    TLogger.d("SrvMessageManager", "Succeed Send AIDL" + intent + " success  msgid = " + intent.getLongExtra("msgId", -1));
                    a.this.a(b.e(), intent);
                } catch (Throwable th) {
                    TLogger.e("SrvMessageManager", "SendBroadcastByRPC -> bindService", th);
                    c.a().a(b.e(), intent.getPackage(), intent);
                    Context e2 = b.e();
                    ServiceStat.reportErrCode(e2, -104, "bind aidl remote service err:" + Util.getThrowableToString(th), 0, "inner");
                }
            }
        });
    }

    public void a(ArrayList<com.tencent.android.tpush.service.protocol.j> arrayList, long j, com.tencent.android.tpush.service.channel.a aVar) {
        b(arrayList, j, aVar);
    }

    public void b(ArrayList<com.tencent.android.tpush.service.protocol.j> arrayList, long j, com.tencent.android.tpush.service.channel.a aVar) {
        if (arrayList != null && arrayList.size() > 0) {
            if (b.e() == null) {
                Context e2 = b.e();
                ServiceStat.reportErrCode(e2, -103, "context is null, msgid:" + arrayList.get(0).a, 0, "inner");
                return;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                TLogger.ii("SrvMessageManager", "receive msg from service msgId = " + arrayList.get(i).a + " pkg = " + arrayList.get(i).g + " type = " + arrayList.get(i).f);
            }
            Iterator<com.tencent.android.tpush.service.protocol.j> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                com.tencent.android.tpush.service.protocol.j next = it2.next();
                TLogger.d("SrvMessageManager", "distributeFromServer : accid=" + next.b + " ,channelId=" + next.m + ",busiId=" + next.c + ",pkg=" + next.g + ",msgId=" + next.a + ",type=" + next.f + ",ts=" + next.h + ",multi=" + next.i + ",date=" + next.j + ",serverTime=" + next.k + ",ttl=" + next.l + ", size = " + arrayList.size() + ", groupId=" + next.r + ", mgroupId=" + next.s + ", revokeId=" + next.v);
                StringBuilder sb = new StringBuilder();
                sb.append("distributeFromServer content:");
                sb.append(next.e);
                TLogger.d("SrvMessageManager", sb.toString());
                if (next.f == 3) {
                    try {
                        if (next.e != null) {
                            a(next.e);
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        TLogger.e("SrvMessageManager", "distributeFromServerInAppMsg exception: ", th);
                    }
                } else if (next.f == 6) {
                    try {
                        if (next.y != null) {
                            g.a(b.e()).a(next);
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        TLogger.e("SrvMessageManager", "distributeFromServerInAppMsg exception:" + th2.toString());
                    }
                } else if (next.f == 1000) {
                    try {
                        if (next.e != null) {
                            CloudManager.getInstance(b.e()).parseCloudConfig(new JSONObject(next.e).optString("custom_content", null), 0);
                        } else {
                            return;
                        }
                    } catch (Throwable th3) {
                        TLogger.w("SrvMessageManager", "unexpected for type:1000", th3);
                    }
                } else if (!j.b(next.g) || next.i != 0 || next.m > 0) {
                    a(next, j, aVar);
                } else {
                    TLogger.d("SrvMessageManager", ">> messageDistribute, msg.appPkgName is null!");
                    Context e3 = b.e();
                    ServiceStat.reportErrCode(e3, -103, "msgId:" + next.a, 0, "inner");
                }
            }
        }
    }

    private synchronized void a(String str) {
        if (!j.b(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str).getJSONObject("custom_content");
                JSONArray jSONArray = jSONObject.getJSONArray("config");
                int i = jSONObject.getInt("version");
                int i2 = 0;
                if (jSONArray != null && jSONArray.length() > 0) {
                    int i3 = false;
                    while (i2 < jSONArray.length()) {
                        boolean a2 = a(jSONArray.getJSONObject(i2));
                        if (a2) {
                            i3 = a2;
                        }
                        i2++;
                    }
                    i2 = i3;
                }
                if (i2 != 0) {
                    JSONArray b2 = b();
                    PushPreferences.putInt(b.e(), "GroupKeysConfigVersion", i);
                    PushPreferences.putString(b.e(), "ChannelGroupKeysConfig", b2.toString());
                }
            } catch (Throwable th) {
                TLogger.e("SrvMessageManager", "handleGroupKeysConfig", th);
            }
        }
    }

    private static JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<Long, Map<String, List<Long>>> entry : h.entrySet()) {
            JSONObject jSONObject = new JSONObject();
            PrintStream printStream = System.out;
            printStream.println("Key = " + entry.getKey());
            JSONArray jSONArray2 = new JSONArray();
            for (Map.Entry<String, List<Long>> entry2 : entry.getValue().entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(entry2.getKey(), new JSONArray((Collection) entry2.getValue()));
                jSONArray2.put(jSONObject2);
            }
            jSONObject.put(entry.getKey().toString(), jSONArray2);
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    private static synchronized void c() {
        synchronized (a.class) {
            try {
                if (h == null) {
                    h = new ConcurrentHashMap<>();
                    String string = PushPreferences.getString(b.e(), "ChannelGroupKeysConfig", null);
                    if (!j.b(string)) {
                        JSONArray jSONArray = new JSONArray(string);
                        if (jSONArray.length() > 0) {
                            for (int i = 0; i < jSONArray.length(); i++) {
                                JSONObject jSONObject = jSONArray.getJSONObject(i);
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    Long valueOf = Long.valueOf(next);
                                    JSONArray jSONArray2 = jSONObject.getJSONArray(next);
                                    if (jSONArray2 != null && jSONArray2.length() > 0) {
                                        HashMap hashMap = new HashMap();
                                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                            JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                                            Iterator<String> keys2 = jSONObject2.keys();
                                            while (keys2.hasNext()) {
                                                String next2 = keys2.next();
                                                hashMap.put(next2, a(jSONObject2.getJSONArray(next2)));
                                            }
                                        }
                                        h.put(valueOf, hashMap);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                TLogger.e("SrvMessageManager", "initChanellGroupKey", th);
            }
        }
        return;
    }

    private synchronized boolean a(JSONObject jSONObject) {
        Long valueOf = Long.valueOf(jSONObject.getLong("channelId"));
        boolean z = false;
        z = false;
        if (valueOf.longValue() <= 0) {
            return false;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("infos");
        if (jSONArray != null && jSONArray.length() > 0) {
            if (!h.containsKey(valueOf)) {
                h.put(valueOf, new HashMap());
            }
            boolean z2 = false;
            for (int i = 0; i < jSONArray.length(); i++) {
                Map<String, List<Long>> map = h.get(valueOf);
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String string = jSONObject2.getString("groupKey");
                int i2 = jSONObject2.getInt("op");
                JSONArray jSONArray2 = jSONObject2.getJSONArray("apps");
                if (jSONArray2 != null && jSONArray2.length() > 0) {
                    if (!map.containsKey(string)) {
                        map.put(string, new ArrayList());
                    }
                    List<Long> list = map.get(string);
                    List<Long> a2 = a(jSONArray2);
                    if (i2 == 1) {
                        list = a2;
                    } else if (i2 == 2) {
                        a2.removeAll(list);
                        list.addAll(a2);
                    } else if (i2 == 3) {
                        list.removeAll(a2);
                    } else {
                        TLogger.e("SrvMessageManager", "error op type " + i2);
                        map.put(string, list);
                    }
                    z2 = true;
                    map.put(string, list);
                }
                h.put(valueOf, map);
            }
            z = z2;
        }
        return z;
    }

    private static List<Long> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(Long.valueOf(jSONArray.getLong(i)));
            }
        }
        return arrayList;
    }

    private void a(Context context, String str, String str2, ArrayList<?> arrayList) {
        try {
            if (arrayList.size() > 50) {
                arrayList.subList(0, 10).clear();
            }
            String encrypt = Rijndael.encrypt(f.a(arrayList));
            d.a(context, str + str2, encrypt);
        } catch (Throwable th) {
            TLogger.e("SrvMessageManager", "putSettings", th);
        }
    }

    private Object a(Context context, String str, String str2) {
        try {
            return f.a(Rijndael.decrypt(d.a(context, str + str2)));
        } catch (Throwable th) {
            TLogger.e("SrvMessageManager", "getSettings", th);
            return null;
        }
    }
}
