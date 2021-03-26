package com.tencent.android.tpush.b;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.common.d;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.data.MessageId;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.PushMd5Pref;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONException;

/* compiled from: ProGuard */
public class f {
    static ArrayList<Long> a;
    private static volatile f b;
    private static long c;
    private Context d = null;

    public static f a(Context context) {
        if (b == null) {
            synchronized (f.class) {
                if (b == null) {
                    b = new f();
                    b.d = context.getApplicationContext();
                    b.b(b.d);
                }
            }
        }
        return b;
    }

    public void a(Intent intent) {
        CommonWorkingThread.getInstance().execute(new a(this.d, intent, null));
    }

    protected static synchronized boolean a(Long l) {
        synchronized (f.class) {
            try {
                if (a == null) {
                    a = new ArrayList<>();
                }
                if (a.contains(l)) {
                    return false;
                }
                a.add(l);
                if (a.size() > 200) {
                    a.remove(0);
                }
                return true;
            } catch (Throwable th) {
                TLogger.e("PushMessageHandler", "addCachedmsgID", th);
            }
        }
    }

    /* compiled from: ProGuard */
    private class a implements Runnable {
        private Context b;
        private Intent c;
        private XGIOperateCallback d;

        a(Context context, Intent intent, XGIOperateCallback xGIOperateCallback) {
            this.b = context;
            this.c = intent;
            this.d = xGIOperateCallback;
        }

        private void a() {
            Intent intent = new Intent("com.tencent.android.xg.vip.action.PUSH_MESSAGE");
            intent.putExtras(this.c);
            if (com.tencent.android.tpush.f.a.a(this.b)) {
                String stringExtra = this.c.getStringExtra("third_app_pkgname");
                if (!j.b(stringExtra)) {
                    TLogger.ii("PushMessageRunnable", "ACTION_PUSH_MESSAGE otherApp -> " + stringExtra);
                    intent.setPackage(stringExtra);
                    this.b.sendBroadcast(intent);
                } else {
                    intent.setPackage(this.b.getPackageName());
                    d.a(this.b, intent);
                }
            } else {
                intent.setPackage(this.b.getPackageName());
                d.a(this.b, intent);
            }
            String stringExtra2 = this.c.getStringExtra("svrPkgName");
            if (!j.b(stringExtra2)) {
                Intent intent2 = new Intent(this.b.getPackageName() + "com.tencent.android.xg.vip.action.ack.sdk2srv.V4");
                intent2.setPackage(stringExtra2);
                intent2.putExtras(this.c);
                d.a(this.b, intent2);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IllegalArgumentException illegalArgumentException;
            synchronized (f.this) {
                if (XGPushConfig.enableDebug) {
                    TLogger.d("PushMessageRunnable", "Action -> handlerPushMessage");
                }
                try {
                    long longExtra = this.c.getLongExtra("expire_time", 0);
                    if (longExtra <= 0) {
                        long longExtra2 = this.c.getLongExtra("server_time", -1);
                        if (longExtra2 > 0) {
                            int intExtra = this.c.getIntExtra("ttl", 0);
                            if (intExtra <= 0) {
                                intExtra = 259200;
                            }
                            try {
                                if (String.valueOf(System.currentTimeMillis()).length() - String.valueOf(longExtra2).length() == 3) {
                                    longExtra2 *= 1000;
                                }
                            } catch (Throwable th) {
                                TLogger.e("PushMessageHandler", "", th);
                            }
                            longExtra = ((long) (intExtra * 1000)) + longExtra2;
                        }
                    }
                    String str = this.c.getPackage();
                    long currentTimeMillis = System.currentTimeMillis();
                    long longExtra3 = this.c.getLongExtra("msgId", -1);
                    g a2 = g.a(this.b, this.c);
                    if (longExtra > 0 && currentTimeMillis > longExtra) {
                        TLogger.e("PushMessageHandler", "msg is expired, currentTimeMillis=" + currentTimeMillis + ", expire_time=" + longExtra + ". msgid = " + longExtra3);
                        XGPushManager.msgAck(this.b, a2);
                    } else if (!f.a(Long.valueOf(longExtra3))) {
                        XGPushManager.msgAck(this.b, a2);
                    } else {
                        long longExtra4 = this.c.getLongExtra("busiMsgId", 0);
                        long longExtra5 = this.c.getLongExtra("timestamps", 0);
                        String str2 = "@" + longExtra3 + str + "@";
                        long longExtra6 = this.c.getLongExtra("accId", -1);
                        List<Long> accessidList = XGPushConfig.getAccessidList(this.b);
                        if (com.tencent.android.tpush.f.a.a(this.b) || accessidList == null || accessidList.size() <= 0 || accessidList.contains(Long.valueOf(longExtra6))) {
                            String g = c.g(this.b, longExtra6);
                            illegalArgumentException = null;
                            if (!g.contains(str2)) {
                                PushMd5Pref.putString(this.b, "tpush_msgId_" + longExtra6, str2 + g, true);
                                String string = PushMd5Pref.getString(this.b, "tpush_msgId_" + longExtra6, true);
                                if (string == null || !string.contains(str2)) {
                                    TLogger.e("PushMessageRunnable", str2 + " flag write failed");
                                    return;
                                }
                                TLogger.i("PushMessageRunnable", "Receiver msg from server :" + a2.toString());
                                XGPushManager.msgAck(this.b, a2);
                                String stringExtra = this.c.getStringExtra("svrPkgName");
                                if (!this.b.getPackageName().equals(stringExtra)) {
                                    TLogger.ii("PushMessageRunnable", "Receiver msg from other app :" + stringExtra);
                                    ServiceStat.appReportPullupAck(this.b, this.c);
                                }
                                a m = a2.m();
                                if (m != null && !j.b(a2.f())) {
                                    try {
                                        if (new d(this.b, this.c).a(a2, longExtra5, longExtra4, longExtra3)) {
                                            a();
                                            c.a().c(this.b, a2.b());
                                            if (m.b() == 1) {
                                                a2.a();
                                            }
                                        } else {
                                            c.a().d(this.b, a2.b());
                                        }
                                    } catch (Throwable th2) {
                                        TLogger.e("PushMessageRunnable", "unknown error", th2);
                                        c.a().d(this.b, a2.b());
                                        illegalArgumentException = th2;
                                    }
                                }
                            } else {
                                this.d = null;
                            }
                            XGIOperateCallback xGIOperateCallback = this.d;
                            if (xGIOperateCallback != null) {
                                if (illegalArgumentException != null) {
                                    xGIOperateCallback.onFail("", -1, illegalArgumentException.toString());
                                } else {
                                    xGIOperateCallback.onSuccess("", 0);
                                }
                            }
                            return;
                        }
                        TLogger.ee("PushMessageRunnable", "PushMessageRunnable match accessId failed, message droped cause accessId:" + longExtra6 + " not in " + accessidList + " msgId = " + str2);
                        c.a().b(this.b, longExtra3);
                        XGPushManager.msgAck(this.b, a2);
                    }
                } catch (JSONException e) {
                    illegalArgumentException = e;
                    TLogger.e("PushMessageRunnable", "push parse error", illegalArgumentException);
                } catch (IllegalArgumentException e2) {
                    illegalArgumentException = e2;
                    TLogger.e("PushMessageRunnable", "push msg type error", illegalArgumentException);
                } catch (Throwable th3) {
                    illegalArgumentException = th3;
                    TLogger.e("PushMessageRunnable", "unknown error", illegalArgumentException);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(final Intent intent) {
        CommonWorkingThread.getInstance().execute(new Runnable() {
            /* class com.tencent.android.tpush.b.f.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                String stringExtra = intent.getStringExtra("date");
                if (intent.getLongExtra("msgId", -1) < 0) {
                    try {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                        if (!j.b(stringExtra)) {
                            if (j.b(stringExtra) || simpleDateFormat.parse(stringExtra).compareTo(simpleDateFormat.parse(simpleDateFormat.format(new Date()))) != 0) {
                                if (j.b(stringExtra) || simpleDateFormat.parse(stringExtra).compareTo(simpleDateFormat.parse(simpleDateFormat.format(new Date()))) >= 0) {
                                    TLogger.w("PushMessageHandler", "can not handle the local message because of the date");
                                    return;
                                } else {
                                    f.this.a(intent);
                                    return;
                                }
                            }
                        }
                        if (com.tencent.android.tpush.service.util.f.a(intent)) {
                            f.this.a(intent);
                        } else {
                            TLogger.w("PushMessageHandler", "can not handle the local message because of the time");
                        }
                    } catch (ParseException e) {
                        TLogger.ee("PushMessageHandler", "try to handlerPushMessage, but ParseException : " + e);
                    }
                } else if (com.tencent.android.tpush.service.util.f.a(intent)) {
                    f.this.a(intent);
                } else {
                    TLogger.w("PushMessageHandler", "can not handle the message because of the time");
                }
            }
        });
    }

    public void b(final Intent intent) {
        CommonWorkingThread.getInstance().execute(new Runnable() {
            /* class com.tencent.android.tpush.b.f.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                if (XGPushConfig.enableDebug) {
                    TLogger.d("PushMessageHandler", "Action -> handleRemotePushMessage");
                }
                long longExtra = intent.getLongExtra("msgId", 0);
                long longExtra2 = intent.getLongExtra("timestamps", 0);
                long longExtra3 = intent.getLongExtra("server_time", 0);
                int intExtra = intent.getIntExtra("ttl", 0);
                long longExtra4 = intent.getLongExtra("type", 1);
                int intExtra2 = intent.getIntExtra("revokeId", 0);
                if (intExtra2 > 0) {
                    try {
                        TLogger.i("PushMessageHandler", "message revokeId of notifyId " + intExtra2);
                        ((NotificationManager) f.this.d.getSystemService("notification")).cancel(intExtra2);
                    } catch (Throwable th) {
                        TLogger.e("PushMessageHandler", "NotificationManager.cancel error: " + th.toString());
                    }
                } else if (!XGPushConfig.isNotificationShowEnable(f.this.d)) {
                    TLogger.ii("PushMessageHandler", "XINGE NotificationShow is not enabe, so discard this notification, msgid:" + longExtra);
                } else {
                    long longExtra5 = intent.getLongExtra("accId", 0);
                    String str = intent.getPackage();
                    try {
                        RegisterEntity currentAppRegisterEntity = CacheManager.getCurrentAppRegisterEntity(f.this.d);
                        if (currentAppRegisterEntity != null && !j.b(currentAppRegisterEntity.packageName) && str.equals(currentAppRegisterEntity.packageName) && longExtra5 == currentAppRegisterEntity.accessId && currentAppRegisterEntity.state == 1) {
                            return;
                        }
                    } catch (Throwable th2) {
                        TLogger.e("PushMessageHandler", th2.toString());
                    }
                    String stringExtra = intent.getStringExtra("date");
                    long longExtra6 = intent.getLongExtra("extra_push_time", 0);
                    long longExtra7 = intent.getLongExtra("busiMsgId", 0);
                    long longExtra8 = intent.getLongExtra("multiPkg", 0);
                    long longExtra9 = intent.getLongExtra("channel_id", -1);
                    String stringExtra2 = intent.getStringExtra("group_id");
                    String stringExtra3 = intent.getStringExtra("stat_tag");
                    long currentTimeMillis = System.currentTimeMillis();
                    MessageId messageId = new MessageId();
                    messageId.id = longExtra;
                    messageId.isAck = 0;
                    messageId.accessId = longExtra5;
                    messageId.host = intent.getLongExtra("extra_host", 0);
                    messageId.port = intent.getIntExtra("extra_port", 0);
                    messageId.pact = intent.getByteExtra("extra_pact", (byte) 0);
                    messageId.apn = DeviceInfos.getNetworkType(f.this.d);
                    messageId.isp = j.o(f.this.d);
                    messageId.serviceHost = intent.getStringExtra("svrPkgName");
                    messageId.receivedTime = currentTimeMillis;
                    messageId.pkgName = str;
                    messageId.busiMsgId = longExtra7;
                    messageId.timestamp = longExtra2;
                    messageId.msgType = longExtra4;
                    messageId.multiPkg = longExtra8;
                    messageId.date = stringExtra;
                    messageId.channelId = longExtra9;
                    messageId.pushTime = intent.getLongExtra("pushTime", 0);
                    messageId.pushChannel = intent.getIntExtra("pushChannel", 100);
                    String stringExtra4 = intent.getStringExtra("groupId");
                    if (!j.b(stringExtra4)) {
                        messageId.nGroupId = stringExtra4;
                    }
                    if (!j.b(stringExtra2)) {
                        messageId.groupId = stringExtra2;
                    }
                    if (!j.b(stringExtra3)) {
                        messageId.statTag = stringExtra3;
                    }
                    TLogger.i("PushMessageHandler", ">> msg from service,  @msgId=" + messageId.id + " @accId=" + messageId.accessId + " @timeUs=" + longExtra6 + " @recTime=" + messageId.receivedTime + " @msg.date=" + stringExtra + " @msg.busiMsgId=" + longExtra7 + " @msg.timestamp=" + longExtra2 + " @msg.type=" + longExtra4 + " @msg.multiPkg=" + longExtra8 + " @msg.serverTime=" + longExtra3 + " @msg.ttl=" + intExtra + " @currentTimeMillis=" + currentTimeMillis);
                    String g = c.g(f.this.d, longExtra5);
                    StringBuilder sb = new StringBuilder();
                    sb.append("@");
                    sb.append(messageId.id);
                    sb.append(str);
                    sb.append("@");
                    String sb2 = sb.toString();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("cache msgIds:");
                    sb3.append(g);
                    sb3.append(", vs current msgIdstr:");
                    sb3.append(sb2);
                    TLogger.i("PushMessageHandler", sb3.toString());
                    if (g.contains(sb2)) {
                        TLogger.ee("PushMessageHandler", "getNotifiedMsgIds contain the msgId id:" + sb2 + ", return");
                    } else if (c.a().b(f.this.d, str, messageId.id)) {
                        TLogger.ee("PushMessageHandler", ">> msgId:" + messageId.id + " has been acked, return");
                    } else {
                        messageId.pkgName = str;
                        if (messageId.id > 0) {
                            c.a().a(f.this.d, str, messageId);
                        }
                        c.a().a(f.this.d, intent);
                        f.this.c(intent);
                    }
                }
            }
        });
    }

    public synchronized void a(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - c > 120000 || z) {
            c = currentTimeMillis;
            CommonWorkingThread.getInstance().execute(new Runnable() {
                /* class com.tencent.android.tpush.b.f.AnonymousClass3 */

                @Override // java.lang.Runnable
                public void run() {
                    ArrayList<Intent> a2;
                    if (!(f.this.d == null || j.b(f.this.d.getPackageName()) || (a2 = c.a().a(f.this.d)) == null || a2.size() <= 0)) {
                        if (XGPushConfig.enableDebug) {
                            TLogger.d("PushMessageHandler", "Action -> trySendCachedMsg with CachedMsgList size = " + a2.size());
                        }
                        for (int i = 0; i < a2.size(); i++) {
                            try {
                                f.this.c(a2.get(i));
                            } catch (Throwable th) {
                                TLogger.e("PushMessageHandler", "", th);
                            }
                        }
                    }
                }
            });
        }
    }
}
