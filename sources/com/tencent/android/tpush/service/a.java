package com.tencent.android.tpush.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.ReturnCode;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.channel.security.TpnsSecurity;
import com.tencent.android.tpush.service.protocol.l;
import com.tencent.android.tpush.service.protocol.m;
import com.tencent.android.tpush.service.protocol.q;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.android.tpush.service.util.f;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.mqttchannel.api.MqttChannel;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class a {
    private static a a;
    private static volatile C0135a b;
    private static volatile c c;
    private static volatile d d;
    private volatile boolean e = false;
    private ArrayList<Intent> f = new ArrayList<>();

    private static boolean a(Object obj) {
        return false;
    }

    private a() {
    }

    public synchronized void a(Context context) {
        TLogger.ii("PushServiceBroadcastHandler", "handleServiceInited, beforeInitedIntents size:" + this.f.size());
        this.e = true;
        try {
            Intent intent = new Intent("com.tencent.android.xg.vip.action.SERVICE_START.V4");
            intent.putExtra("pkg", b.e().getPackageName());
            intent.putExtra("ver", "1.2.3.1");
            com.tencent.android.tpush.common.d.a(b.e(), intent);
        } catch (Throwable th) {
            TLogger.e("PushServiceBroadcastHandler", "sendBroadcast", th);
        }
        Iterator<Intent> it2 = this.f.iterator();
        while (it2.hasNext()) {
            TLogger.ii("PushServiceBroadcastHandler", "excute, beforeInitedIntents size:" + this.f.size());
            CommonWorkingThread.getInstance().execute(new b(context, it2.next()));
        }
        this.f.clear();
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public synchronized void b(Context context) {
        TLogger.d("PushServiceBroadcastHandler", "action - registerReceiver");
        if (context != null) {
            try {
                if (b == null) {
                    b = new C0135a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addDataScheme("package");
                    intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
                    intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                    com.tencent.android.tpush.common.d.a(context, b, intentFilter);
                }
            } catch (Throwable th) {
                TLogger.e("PushServiceBroadcastHandler", "registerReceiver", th);
            }
            try {
                if (c == null) {
                    c = new c();
                    IntentFilter intentFilter2 = new IntentFilter();
                    String packageName = context.getPackageName();
                    intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.REGISTER.V4");
                    intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.UNREGISTER.V4");
                    intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.ENABLE_DEBUG.V4");
                    intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.MSG_ACK.V4");
                    intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.ACCOUNT.V4");
                    intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.TAG.V4");
                    intentFilter2.addAction("com.tencent.android.xg.vip.action.PUSH_CLICK.RESULT.V4");
                    intentFilter2.addAction("com.tencent.android.xg.vip.action.PUSH_CANCELLED.RESULT.V4");
                    intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.ack.sdk2srv.V4");
                    intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.reserved.act.V4");
                    intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.UPDATE_OTHER_PUSH_TOKEN.V4");
                    intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.COMM_REPORT.V4");
                    intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.FLUSH.V4");
                    intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.ATTRIBUTE.V4");
                    com.tencent.android.tpush.common.d.a(context, c, intentFilter2);
                }
            } catch (Throwable th2) {
                TLogger.e("PushServiceBroadcastHandler", "registerReceiver", th2);
            }
            try {
                if (d == null) {
                    d = new d();
                    IntentFilter intentFilter3 = new IntentFilter();
                    intentFilter3.addAction("android.intent.action.USER_PRESENT");
                    intentFilter3.addAction("android.intent.action.SCREEN_ON");
                    intentFilter3.addAction("android.intent.action.ACTION_POWER_CONNECTED");
                    intentFilter3.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
                    intentFilter3.addAction("android.intent.action.PACKAGE_ADDED");
                    intentFilter3.addAction("android.intent.action.PACKAGE_REMOVED");
                    intentFilter3.addAction("android.intent.action.PACKAGE_REPLACED");
                    intentFilter3.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    context.getApplicationContext().registerReceiver(d, intentFilter3);
                }
            } catch (Throwable th3) {
                TLogger.e("PushServiceBroadcastHandler", "registerReceiver userPresentReceiver error:", th3);
            }
        }
    }

    public synchronized void c(Context context) {
        this.f.clear();
        if (context != null) {
            if (b != null) {
                j.a(context, b);
                b = null;
            }
            if (c != null) {
                j.a(context, c);
                c = null;
            }
            if (d != null) {
                j.a(context, d);
                d = null;
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(final Context context, Intent intent) {
        String dataString = intent.getDataString();
        if (dataString != null && context != null && f.d(context, dataString.substring(8))) {
            b.b().d();
            CommonWorkingThread.getInstance().execute(new Runnable() {
                /* class com.tencent.android.tpush.service.a.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    j.e(context);
                }
            }, 2000);
        }
    }

    /* access modifiers changed from: private */
    public void b(final Context context, Intent intent) {
        String str;
        Throwable th;
        final boolean z;
        String str2;
        if (context != null && intent != null) {
            final String decrypt = Rijndael.decrypt(intent.getStringExtra("accId"));
            String decrypt2 = Rijndael.decrypt(intent.getStringExtra("accKey"));
            final String decrypt3 = Rijndael.decrypt(intent.getStringExtra("packName"));
            String decrypt4 = Rijndael.decrypt(intent.getStringExtra("ticket"));
            int intExtra = intent.getIntExtra("ticketType", -1);
            String decrypt5 = Rijndael.decrypt(intent.getStringExtra("qua"));
            String stringExtra = intent.getStringExtra("appVer");
            String decrypt6 = Rijndael.decrypt(intent.getStringExtra("reserved"));
            TLogger.d("PushServiceBroadcastHandler", "receive intent, reserved: " + decrypt6);
            long longExtra = intent.getLongExtra("accChannel", -1);
            String stringExtra2 = intent.getStringExtra("url");
            String stringExtra3 = intent.getStringExtra("otherToken");
            String stringExtra4 = intent.getStringExtra("payload");
            long longExtra2 = intent.getLongExtra("otherPushType", -1);
            long longExtra3 = intent.getLongExtra("otherPushTokenOpType", -1);
            boolean booleanExtra = intent.getBooleanExtra("aidl", false);
            String stringExtra5 = intent.getStringExtra("channelToken");
            String stringExtra6 = intent.getStringExtra("channelType");
            long cloudVersion = CloudManager.getInstance(context).getCloudVersion();
            try {
                if (!j.b(decrypt5)) {
                    z = booleanExtra;
                    CacheManager.setQua(context, Long.parseLong(decrypt), decrypt5);
                } else {
                    z = booleanExtra;
                }
                try {
                    str2 = TpnsSecurity.getEncryptAPKSignature(context.createPackageContext(decrypt3, 0));
                } catch (Throwable unused) {
                    str2 = "";
                }
                str = "PushServiceBroadcastHandler";
                try {
                    c.a().a(Long.parseLong(decrypt), decrypt2, com.tencent.android.tpush.service.util.a.a(), decrypt4, intExtra, str2, stringExtra, decrypt6, longExtra2, stringExtra2, stringExtra4, stringExtra3, longExtra3, longExtra, stringExtra5, stringExtra6, cloudVersion, new com.tencent.android.tpush.service.c.a() {
                        /* class com.tencent.android.tpush.service.a.AnonymousClass2 */

                        @Override // com.tencent.android.tpush.service.c.a
                        public void a(int i, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                            if (i == 0) {
                                m mVar = new m();
                                try {
                                    if (j.b(str)) {
                                        str = j.e(SharePrefsUtil.getString(context, "REGISTERED_RSP", ""));
                                    } else {
                                        SharePrefsUtil.setString(context, "REGISTERED_RSP", j.f(str));
                                    }
                                    mVar.a(str);
                                    TLogger.dd("PushServiceBroadcastHandler", ">> Register onResponse [accId = " + decrypt + ", token:" + mVar.b + ", otherPushType:" + mVar.d + ", otherToken:" + mVar.e + " , packName = " + decrypt3 + "]");
                                    a.this.a(i, mVar, (l) dVar, decrypt3, z);
                                    c.b(context);
                                    XGApiConfig.setRegisterSuccess(context);
                                } catch (Throwable unused) {
                                    TLogger.ee("PushServiceBroadcastHandler", ">> Register onResponse fail, 解析返回内容格式错误 " + i);
                                    a.this.a(-101, "解析服务器返回内容失败", (l) dVar, decrypt3);
                                }
                            } else {
                                TLogger.ww("PushServiceBroadcastHandler", ">> Register ack fail, 服务器处理失败,返回错误; responseCode = " + i);
                                a.this.a(i, "服务器处理失败，返回错误", (l) dVar, decrypt3);
                            }
                        }

                        @Override // com.tencent.android.tpush.service.c.a
                        public void b(int i, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                            TLogger.ee("PushServiceBroadcastHandler", "@@ registetr onMessageSendFailed: " + i + ", " + str);
                            a.this.a(i, str, (l) dVar, decrypt3);
                        }
                    });
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                str = "PushServiceBroadcastHandler";
                TLogger.e(str, ">> register error " + th);
                TLogger.e(str, ">> register error-> " + TLogger.getStackTraceString(th));
            }
        }
    }

    private void a(int i, String str, int i2, String str2) {
        if (!j.b(str)) {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("account", str);
                jSONObject.put("accountType", i2);
                jSONArray.put(jSONObject);
                a(i, jSONArray.toString(), str, 0, str2);
            } catch (Throwable th) {
                TLogger.ww("PushServiceBroadcastHandler", "getTypeAccountsJsonArrayStr:", th);
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(Context context, Intent intent) {
        if (context != null && intent != null) {
            final long longExtra = intent.getLongExtra("accId", -1);
            String decrypt = Rijndael.decrypt(intent.getStringExtra("accKey"));
            final int intExtra = intent.getIntExtra("operateType", -1);
            final String decrypt2 = Rijndael.decrypt(intent.getStringExtra("account"));
            final String stringExtra = intent.getStringExtra("accountFeedBack");
            final String decrypt3 = Rijndael.decrypt(intent.getStringExtra("packName"));
            try {
                c.a().a(longExtra, decrypt, decrypt2, intExtra, new com.tencent.android.tpush.service.c.a() {
                    /* class com.tencent.android.tpush.service.a.AnonymousClass3 */

                    @Override // com.tencent.android.tpush.service.c.a
                    public void a(int i, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                        if (i == 0) {
                            if (XGPushConfig.enableDebug) {
                                TLogger.d("PushServiceBroadcastHandler", ">> AccountHandler [accId = " + longExtra + ", packageNme: " + decrypt3 + "]");
                            }
                            a.this.b(i, decrypt2, stringExtra, intExtra, decrypt3);
                            return;
                        }
                        TLogger.e("PushServiceBroadcastHandler", ">> AccountHandler ack fail responseCode = " + i);
                        a.this.a(i, "服务器处理失败，返回错误", decrypt2, stringExtra, intExtra, decrypt3);
                    }

                    @Override // com.tencent.android.tpush.service.c.a
                    public void b(int i, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                        TLogger.ee("PushServiceBroadcastHandler", "@@ AccountHandler onMessageSendFailed: " + i + ", " + str);
                        a.this.a(i, str, decrypt2, stringExtra, intExtra, decrypt3);
                    }
                });
            } catch (Throwable th) {
                TLogger.e("PushServiceBroadcastHandler", ">> AccountHandler error " + th);
                TLogger.e("PushServiceBroadcastHandler", ">> AccountHandler error-> " + TLogger.getStackTraceString(th));
            }
        }
    }

    /* access modifiers changed from: private */
    public void d(Context context, Intent intent) {
        if (context != null && intent != null) {
            final long longExtra = intent.getLongExtra("accId", -1);
            String decrypt = Rijndael.decrypt(intent.getStringExtra("accKey"));
            final String decrypt2 = Rijndael.decrypt(intent.getStringExtra("packName"));
            final int intExtra = intent.getIntExtra("attributesFlag", -1);
            final String decrypt3 = Rijndael.decrypt(intent.getStringExtra("attributesName"));
            final String stringExtra = intent.getStringExtra("attributesOperateName");
            try {
                c.a().b(longExtra, decrypt, decrypt2, intExtra, decrypt3, new com.tencent.android.tpush.service.c.a() {
                    /* class com.tencent.android.tpush.service.a.AnonymousClass4 */

                    @Override // com.tencent.android.tpush.service.c.a
                    public void a(int i, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                        if (i == 0) {
                            TLogger.ii("PushServiceBroadcastHandler", "Set attributes ack success  [accId = " + longExtra + " ,attributesType = " + intExtra + " ,attributesName = " + decrypt3 + " ,packName = " + decrypt2 + "]");
                            a.this.a(i, decrypt3, intExtra, decrypt2, stringExtra, str);
                            return;
                        }
                        TLogger.ee("PushServiceBroadcastHandler", "Set attributes ack failed with responseCode = " + i + " , attributesName = " + decrypt3);
                        a.this.a(i, "服务器处理失败，返回错误", decrypt3, intExtra, decrypt2, stringExtra);
                    }

                    @Override // com.tencent.android.tpush.service.c.a
                    public void b(int i, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                        TLogger.ee("PushServiceBroadcastHandler", "@@ attributesHandler onMessageSendFailed: " + i + ", " + str);
                        a.this.a(i, str, decrypt3, intExtra, decrypt2, stringExtra);
                    }
                });
            } catch (Throwable th) {
                TLogger.e("PushServiceBroadcastHandler", ">> attributes Handler error " + th);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(int i, String str, int i2, String str2, String str3, String str4) {
        Intent intent = new Intent("com.tencent.android.xg.vip.action.ATTRIBUTE.RESULT.V4");
        intent.putExtra("flag", i2);
        intent.putExtra("operation", 0);
        if (!j.b(str2)) {
            intent.setPackage(str2);
        }
        if (!j.b(str4)) {
            intent.putExtra("data", str4);
        }
        com.tencent.android.tpush.common.d.a(b.e(), intent);
        b(i, str, i2, str2, str3);
    }

    /* access modifiers changed from: private */
    public void a(int i, String str, String str2, int i2, String str3, String str4) {
        TLogger.e("PushServiceBroadcastHandler", "attributesFailHandler failed with (" + i + "," + str + "," + str3 + ")");
        Intent intent = new Intent("com.tencent.android.xg.vip.action.ATTRIBUTE.RESULT.V4");
        intent.putExtra("flag", i2);
        intent.putExtra("code", i);
        intent.putExtra("msg", str);
        intent.putExtra("operation", 1);
        if (!j.b(str3)) {
            intent.setPackage(str3);
        }
        com.tencent.android.tpush.common.d.a(b.e(), intent);
        b(i, str2, i2, str3, str4);
    }

    /* access modifiers changed from: private */
    public void e(Context context, Intent intent) {
        if (context != null && intent != null) {
            final long longExtra = intent.getLongExtra("accId", -1);
            String decrypt = Rijndael.decrypt(intent.getStringExtra("accKey"));
            final String decrypt2 = Rijndael.decrypt(intent.getStringExtra("packName"));
            final int intExtra = intent.getIntExtra("tagFlag", -1);
            final String decrypt3 = Rijndael.decrypt(intent.getStringExtra("tagName"));
            final String stringExtra = intent.getStringExtra("tagOperageName");
            try {
                c.a().a(longExtra, decrypt, decrypt2, intExtra, decrypt3, new com.tencent.android.tpush.service.c.a() {
                    /* class com.tencent.android.tpush.service.a.AnonymousClass5 */

                    @Override // com.tencent.android.tpush.service.c.a
                    public void a(int i, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                        if (i == 0) {
                            TLogger.ii("PushServiceBroadcastHandler", "Set tag ack success  [accId = " + longExtra + " , tagtype = " + intExtra + " , tagName = " + decrypt3 + ", packName = " + decrypt2 + "]");
                            a.this.c(i, decrypt3, intExtra, decrypt2, stringExtra);
                            return;
                        }
                        TLogger.ee("PushServiceBroadcastHandler", "Set tag ack failed with responseCode = " + i + " , tagName = " + decrypt3);
                        a.this.b(i, "服务器处理失败，返回错误", decrypt3, intExtra, decrypt2, stringExtra);
                    }

                    @Override // com.tencent.android.tpush.service.c.a
                    public void b(int i, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                        TLogger.ee("PushServiceBroadcastHandler", "@@ TagHandler onMessageSendFailed: " + i + ", " + str);
                        a.this.b(i, str, decrypt3, intExtra, decrypt2, stringExtra);
                    }
                });
            } catch (Throwable th) {
                TLogger.e("PushServiceBroadcastHandler", ">> TagHandler error " + th);
                TLogger.e("PushServiceBroadcastHandler", ">> TagHandler error-> " + TLogger.getStackTraceString(th));
            }
        }
    }

    /* access modifiers changed from: private */
    public void f(Context context, Intent intent) {
        if (context != null && intent != null) {
            final String decrypt = Rijndael.decrypt(intent.getStringExtra("accId"));
            String decrypt2 = Rijndael.decrypt(intent.getStringExtra("accKey"));
            final String decrypt3 = Rijndael.decrypt(intent.getStringExtra("packName"));
            String decrypt4 = Rijndael.decrypt(intent.getStringExtra("token"));
            CacheManager.UnregisterInfoByPkgName(decrypt3);
            try {
                c.a().a(decrypt4, com.tencent.android.tpush.service.util.a.a(), Long.parseLong(decrypt), decrypt2, decrypt3, new com.tencent.android.tpush.service.c.a() {
                    /* class com.tencent.android.tpush.service.a.AnonymousClass6 */

                    @Override // com.tencent.android.tpush.service.c.a
                    public void a(int i, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                        if (i == 0) {
                            TLogger.ii("PushServiceBroadcastHandler", ">> UnRegister ack with [accId = " + decrypt + " , packName = " + decrypt3 + " , rsp = ]");
                            a.this.a(i, (q) dVar, decrypt3);
                            return;
                        }
                        TLogger.e("PushServiceBroadcastHandler", ">> unregeister ack failed responseCode=" + i);
                        a.this.a(i, "服务器处理失败，返回错误", (q) dVar, decrypt3);
                    }

                    @Override // com.tencent.android.tpush.service.c.a
                    public void b(int i, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                        TLogger.e("PushServiceBroadcastHandler", "@@ unregister onMessageSendFailed " + i + "," + str);
                        a.this.a(i, str, (q) dVar, decrypt3);
                    }
                });
            } catch (Throwable th) {
                TLogger.e("PushServiceBroadcastHandler", ">>> unregister error " + th);
            }
        }
    }

    /* access modifiers changed from: private */
    public void g(final Context context, Intent intent) {
        if (context != null && intent != null) {
            final String decrypt = Rijndael.decrypt(intent.getStringExtra("accId"));
            String decrypt2 = Rijndael.decrypt(intent.getStringExtra("accKey"));
            final String decrypt3 = Rijndael.decrypt(intent.getStringExtra("token"));
            final String decrypt4 = Rijndael.decrypt(intent.getStringExtra("other_push_type"));
            final String decrypt5 = Rijndael.decrypt(intent.getStringExtra("other_push_token"));
            TLogger.i("PushServiceBroadcastHandler", "binder OtherPush token with accid = " + decrypt + "  token = " + decrypt3 + " otherPushType = " + decrypt4 + " otherPushToken = " + decrypt5);
            StringBuilder sb = new StringBuilder();
            sb.append(decrypt);
            sb.append("otherpush");
            String string = SharePrefsUtil.getString(context, sb.toString(), "");
            if (!j.b(string)) {
                long j = SharePrefsUtil.getLong(context, decrypt + "otherpushts", -1);
                if (!string.equals(decrypt3 + ":" + decrypt5) || Math.abs(System.currentTimeMillis() - j) <= 86400000) {
                    TLogger.ii("PushServiceBroadcastHandler", "OtherToken or Mid changed , go on binder");
                } else {
                    TLogger.ii("PushServiceBroadcastHandler", "Already binder OtherPush succeed token with accid = " + decrypt + "  token = " + decrypt3 + " otherPushType = " + decrypt4 + " otherPushToken = " + decrypt5);
                    return;
                }
            }
            c.a().a(Long.parseLong(decrypt), decrypt2, decrypt4, decrypt5, new com.tencent.android.tpush.service.c.a() {
                /* class com.tencent.android.tpush.service.a.AnonymousClass7 */

                @Override // com.tencent.android.tpush.service.c.a
                public void a(int i, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                    if (i == 0) {
                        TLogger.ii("PushServiceBroadcastHandler", ">> bind OtherPushToken success ack with [accId = " + decrypt + "  , rsp = " + i + "]  token = " + decrypt3 + " otherPushType = " + decrypt4 + " otherPushToken = " + decrypt5);
                        Context context = context;
                        StringBuilder sb = new StringBuilder();
                        sb.append(decrypt);
                        sb.append("otherpush");
                        String sb2 = sb.toString();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(decrypt3);
                        sb3.append(":");
                        sb3.append(decrypt5);
                        SharePrefsUtil.setString(context, sb2, sb3.toString());
                        Context context2 = context;
                        SharePrefsUtil.setLong(context2, decrypt + "ts", System.currentTimeMillis());
                        return;
                    }
                    TLogger.ee("PushServiceBroadcastHandler", ">> updateOtherPushToken ack failed responseCode=" + i);
                }

                @Override // com.tencent.android.tpush.service.c.a
                public void b(int i, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                    TLogger.ee("PushServiceBroadcastHandler", "@@ updateOtherPushToken onMessageSendFailed " + i + "," + str);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void h(final Context context, final Intent intent) {
        if (context != null && intent != null) {
            final String decrypt = Rijndael.decrypt(intent.getStringExtra("accessId"));
            final String stringExtra = intent.getStringExtra("pkgName");
            c.a().a(intent, new com.tencent.android.tpush.service.c.a() {
                /* class com.tencent.android.tpush.service.a.AnonymousClass8 */

                @Override // com.tencent.android.tpush.service.c.a
                public void a(int i, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                    if (i == 0) {
                        TLogger.ii("PushServiceBroadcastHandler", ">> sendCommReportMessage ack with [accId = " + decrypt + "  , rsp = " + i + "]");
                        com.tencent.android.tpush.a.b(context, stringExtra, intent.toURI());
                        return;
                    }
                    TLogger.ee("PushServiceBroadcastHandler", ">> sendCommReportMessage ack failed responseCode=" + i);
                }

                @Override // com.tencent.android.tpush.service.c.a
                public void b(int i, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                    TLogger.ee("PushServiceBroadcastHandler", "@@ sendCommReportMessage onMessageSendFailed " + i + "," + str);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void i(Context context, Intent intent) {
        if (intent != null && context != null) {
            boolean booleanExtra = intent.getBooleanExtra("debugMode", false);
            XGPushConfig.enableDebug = booleanExtra;
            TLogger.enableDebug(context, booleanExtra);
        }
    }

    private void a(int i, l lVar, String str, String str2, long j, String str3) {
        Intent a2 = f.a(i, str2, 1);
        a2.putExtra("accId", lVar.a);
        if (!(str == null || str.length() == 0)) {
            a2.putExtra("token", str);
        }
        if (!(lVar.e == null || lVar.e.length() == 0)) {
            a2.putExtra("ticket", lVar.e);
            a2.putExtra("ticketType", lVar.f);
        }
        if (!(lVar.c == null || lVar.c.length() == 0)) {
            a2.putExtra("deviceId", lVar.c);
        }
        if (j >= 0) {
            a2.putExtra("otherPushType", j);
            if (!j.b(str3)) {
                a2.putExtra("otherPushToken", str3);
            }
        }
        if (a(lVar)) {
            a2.putExtra("registerFromCloudControl", true);
        }
        com.tencent.android.tpush.common.d.a(b.e(), a2);
    }

    private void a(int i, String str) {
        com.tencent.android.tpush.common.d.a(b.e(), f.a(i, str, 2));
    }

    private void a(int i, String str, String str2, int i2, String str3) {
        Intent a2 = f.a(i, str3, 6);
        a2.putExtra("accountName", Rijndael.encrypt(str));
        a2.putExtra("accountFeedBack", str2);
        a2.putExtra("operateType", i2);
        com.tencent.android.tpush.common.d.a(b.e(), a2);
    }

    private void a(int i, String str, int i2, String str2, String str3) {
        Intent a2 = f.a(i, str2, 3);
        a2.putExtra("tagName", Rijndael.encrypt(str));
        a2.putExtra("tagFlag", i2);
        a2.putExtra("tagOperageName", str3);
        com.tencent.android.tpush.common.d.a(b.e(), a2);
    }

    private void b(int i, String str, int i2, String str2, String str3) {
        Intent a2 = f.a(i, str2, 7);
        a2.putExtra("attributesName", Rijndael.encrypt(str));
        a2.putExtra("attributesFlag", i2);
        a2.putExtra("attributesOperateName", str3);
        com.tencent.android.tpush.common.d.a(b.e(), a2);
    }

    /* access modifiers changed from: private */
    public void a(int i, m mVar, l lVar, String str, boolean z) {
        Intent intent = new Intent("com.tencent.android.xg.vip.action.REGISTER.RESULT.V4");
        intent.putExtra("accId", lVar.a);
        intent.putExtra("data", mVar.b);
        intent.putExtra("flag", ReturnCode.FLAG_ONLINE.getType());
        intent.putExtra("code", i);
        intent.putExtra("operation", 0);
        intent.putExtra("otherPushType", mVar.d);
        intent.putExtra("otherPushToken", mVar.e);
        RegisterEntity registerEntity = new RegisterEntity();
        registerEntity.accessId = lVar.a;
        registerEntity.accessKey = lVar.b;
        registerEntity.token = mVar.b;
        registerEntity.channelId = lVar.s;
        registerEntity.packageName = str;
        registerEntity.timestamp = System.currentTimeMillis() / 1000;
        CacheManager.addRegisterInfo(registerEntity);
        registerEntity.guid = mVar.c;
        if (!j.b(str)) {
            intent.setPackage(str);
        }
        com.tencent.android.tpush.common.d.a(b.e(), intent);
        try {
            String str2 = mVar.i;
            if (j.b(str2)) {
                a(i, lVar, mVar.b, str, mVar.d, mVar.e);
            } else {
                a(i, str2, mVar.j, str);
            }
        } catch (Throwable unused) {
            TLogger.w("PushServiceBroadcastHandler", "unexpected for registerSuccessHandler");
        }
        if (b.e() != null) {
            com.tencent.android.tpush.a.b(b.e());
        }
    }

    /* access modifiers changed from: private */
    public void a(int i, String str, l lVar, String str2) {
        Intent intent = new Intent("com.tencent.android.xg.vip.action.REGISTER.RESULT.V4");
        intent.putExtra("data", "");
        intent.putExtra("code", i);
        intent.putExtra("msg", str);
        intent.putExtra("flag", ReturnCode.FLAG_ONLINE.getType());
        intent.putExtra("operation", 1);
        if (!j.b(str2)) {
            intent.setPackage(str2);
        }
        try {
            com.tencent.android.tpush.common.d.a(b.e(), intent);
            if (lVar != null) {
                String str3 = lVar.e;
                if (j.b(str3)) {
                    a(i, lVar, GuidInfoManager.getToken(b.e()), str2, -1, (String) null);
                } else {
                    a(i, str3, lVar.f, str2);
                }
            }
        } catch (Throwable unused) {
            TLogger.w("PushServiceBroadcastHandler", "unexpected for registerFailHandler");
        }
    }

    /* access modifiers changed from: private */
    public void a(int i, q qVar, String str) {
        Intent intent = new Intent("com.tencent.android.xg.vip.action.UNREGISTER.RESULT.V4");
        intent.putExtra("flag", ReturnCode.FLAG_ONLINE.getType());
        intent.putExtra("operation", 0);
        CacheManager.UnregisterInfoSuccessByPkgName(str);
        CacheManager.removeRegisterInfos(str);
        if (!j.b(str)) {
            intent.setPackage(str);
        }
        com.tencent.android.tpush.common.d.a(b.e(), intent);
        a(i, str);
    }

    /* access modifiers changed from: private */
    public void a(int i, String str, q qVar, String str2) {
        TLogger.e("PushServiceBroadcastHandler", "unregisterFailHandler failed with (" + i + "," + str + "," + qVar + "," + str2 + ")");
        Intent intent = new Intent("com.tencent.android.xg.vip.action.UNREGISTER.RESULT.V4");
        intent.putExtra("flag", ReturnCode.FLAG_ONLINE.getType());
        intent.putExtra("code", i);
        intent.putExtra("msg", str);
        intent.putExtra("operation", 1);
        if (!j.b(str2)) {
            intent.setPackage(str2);
        }
        com.tencent.android.tpush.common.d.a(b.e(), intent);
        a(i, str2);
    }

    /* access modifiers changed from: private */
    public void b(int i, String str, String str2, int i2, String str3) {
        Intent intent = new Intent("com.tencent.android.xg.vip.action.ACCOUNT.RESULT.V4");
        intent.putExtra("flag", i2);
        intent.putExtra("operation", 0);
        if (!j.b(str3)) {
            intent.setPackage(str3);
        }
        com.tencent.android.tpush.common.d.a(b.e(), intent);
        a(i, str, str2, i2, str3);
    }

    /* access modifiers changed from: private */
    public void a(int i, String str, String str2, String str3, int i2, String str4) {
        TLogger.e("PushServiceBroadcastHandler", "accountFailHandler failed with (" + i + "," + str + "," + str4 + ")");
        Intent intent = new Intent("com.tencent.android.xg.vip.action.ACCOUNT.RESULT.V4");
        intent.putExtra("flag", i2);
        intent.putExtra("code", i);
        intent.putExtra("msg", str);
        intent.putExtra("operation", 1);
        if (!j.b(str4)) {
            intent.setPackage(str4);
        }
        com.tencent.android.tpush.common.d.a(b.e(), intent);
        a(i, str2, str3, i2, str4);
    }

    /* access modifiers changed from: private */
    public void c(int i, String str, int i2, String str2, String str3) {
        Intent intent = new Intent("com.tencent.android.xg.vip.action.TAG.RESULT.V4");
        intent.putExtra("flag", i2);
        intent.putExtra("operation", 0);
        if (!j.b(str2)) {
            intent.setPackage(str2);
        }
        com.tencent.android.tpush.common.d.a(b.e(), intent);
        a(i, str, i2, str2, str3);
    }

    /* access modifiers changed from: private */
    public void b(int i, String str, String str2, int i2, String str3, String str4) {
        TLogger.e("PushServiceBroadcastHandler", "tagFailHandler failed with (" + i + "," + str + "," + str3 + ")");
        Intent intent = new Intent("com.tencent.android.xg.vip.action.TAG.RESULT.V4");
        intent.putExtra("flag", i2);
        intent.putExtra("code", i);
        intent.putExtra("msg", str);
        intent.putExtra("operation", 1);
        if (!j.b(str3)) {
            intent.setPackage(str3);
        }
        com.tencent.android.tpush.common.d.a(b.e(), intent);
        a(i, str2, i2, str3, str4);
    }

    /* renamed from: com.tencent.android.tpush.service.a$a  reason: collision with other inner class name */
    /* compiled from: ProGuard */
    private class C0135a extends BroadcastReceiver {
        private C0135a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            TLogger.d("PushServiceBroadcastHandler", "PackageChangesReceiver - onReceiver");
            if (intent != null && context != null) {
                if (a.this.e) {
                    CommonWorkingThread.getInstance().execute(new b(context, intent));
                } else if (a.this.f.size() < 10) {
                    a.this.f.add(intent);
                    TLogger.ii("PushServiceBroadcastHandler", "PackageChangesReceiver add intend to beforeInitedIntents,action:" + intent.getAction() + ", size:" + a.this.f.size());
                } else {
                    TLogger.ee("PushServiceBroadcastHandler", "Too much beforeInitedIntents. discard it");
                }
            }
        }
    }

    /* compiled from: ProGuard */
    private class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            TLogger.d("PushServiceBroadcastHandler", "TPushAppReceiver - onReceiver");
            if (intent != null && context != null) {
                if (a.this.e) {
                    CommonWorkingThread.getInstance().execute(new b(context, intent));
                } else if (a.this.f.size() < 10) {
                    a.this.f.add(intent);
                    TLogger.ii("PushServiceBroadcastHandler", "TPushAppReceiver add intend to beforeInitedIntents,action:" + intent.getAction() + ", size:" + a.this.f.size());
                } else {
                    TLogger.ee("PushServiceBroadcastHandler", "Too much beforeInitedIntents. discard it");
                }
            }
        }
    }

    /* compiled from: ProGuard */
    private class d extends BroadcastReceiver {
        long a;

        private d() {
            this.a = 0;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context context, Intent intent) {
            if (intent != null && context != null) {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                    if (networkInfo != null) {
                        TLogger.v("PushServiceBroadcastHandler", "Connection state changed to - " + networkInfo.toString());
                        if (!intent.getBooleanExtra("noConnectivity", false)) {
                            if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                                TLogger.v("PushServiceBroadcastHandler", "Internl network connected and call MqttChannel.startConnect on 5s later");
                                CommonWorkingThread.getInstance().execute(new Runnable() {
                                    /* class com.tencent.android.tpush.service.a.d.AnonymousClass1 */

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        TLogger.dd("PushServiceBroadcastHandler", "Internl network connected, restart");
                                        MqttChannel.getInstance(context).startConnect(null);
                                    }
                                }, 5000);
                            } else if (NetworkInfo.State.DISCONNECTED == networkInfo.getState()) {
                                TLogger.v("PushServiceBroadcastHandler", "Network is disconnected.");
                                MqttChannel.getInstance(context).stopConnect(null);
                            } else {
                                TLogger.v("PushServiceBroadcastHandler", "other network state - " + networkInfo.getState() + ". Do nothing.");
                            }
                        }
                    }
                } else {
                    TLogger.d("PushServiceBroadcastHandler", "--UserPresentReceiver--");
                    if (Math.abs(System.currentTimeMillis() - this.a) > 8000) {
                        CommonWorkingThread.getInstance().execute(new Runnable() {
                            /* class com.tencent.android.tpush.service.a.d.AnonymousClass2 */

                            @Override // java.lang.Runnable
                            public void run() {
                                TLogger.dd("PushServiceBroadcastHandler", "--start Connect UserPresentReceiver--");
                                MqttChannel.getInstance(context).startConnect(null);
                                com.tencent.android.tpush.a.b(context);
                            }
                        }, 2000);
                        this.a = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    /* compiled from: ProGuard */
    private class b implements Runnable {
        private Context b = null;
        private Intent c = null;

        b(Context context, Intent intent) {
            this.b = context;
            this.c = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String action = this.c.getAction();
                if (action != null) {
                    String replace = action.replace(this.b.getPackageName(), "");
                    TLogger.d("PushServiceBroadcastHandler", "PushServiceRannable, intent action:" + replace);
                    if (!"android.intent.action.PACKAGE_ADDED".equals(replace)) {
                        if (!"android.intent.action.PACKAGE_REPLACED".equals(replace)) {
                            if (!"android.intent.action.PACKAGE_REMOVED".equals(replace)) {
                                if ("com.tencent.android.xg.vip.action.REGISTER.V4".equals(replace)) {
                                    a.this.b(this.b, this.c);
                                    return;
                                } else if ("com.tencent.android.xg.vip.action.UNREGISTER.V4".equals(replace)) {
                                    a.this.f(this.b, this.c);
                                    return;
                                } else if ("com.tencent.android.xg.vip.action.ENABLE_DEBUG.V4".equals(replace)) {
                                    a.this.i(this.b, this.c);
                                    return;
                                } else if (!"com.tencent.android.xg.vip.action.MSG_ACK.V4".equals(replace)) {
                                    if ("com.tencent.android.xg.vip.action.ACCOUNT.V4".equals(replace)) {
                                        a.this.c(this.b, this.c);
                                        return;
                                    } else if ("com.tencent.android.xg.vip.action.TAG.V4".equals(replace)) {
                                        a.this.e(this.b, this.c);
                                        return;
                                    } else if (!"com.tencent.android.xg.vip.action.PUSH_CLICK.RESULT.V4".equals(replace)) {
                                        if (!"com.tencent.android.xg.vip.action.PUSH_CANCELLED.RESULT.V4".equals(replace)) {
                                            if (!"com.tencent.android.xg.vip.action.ack.sdk2srv.V4".equals(replace)) {
                                                if ("com.tencent.android.xg.vip.action.UPDATE_OTHER_PUSH_TOKEN.V4".equals(replace)) {
                                                    a.this.g(this.b, this.c);
                                                    return;
                                                } else if ("com.tencent.android.xg.vip.action.COMM_REPORT.V4".equals(replace)) {
                                                    a.this.h(this.b, this.c);
                                                    return;
                                                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(replace)) {
                                                    NetworkInfo networkInfo = (NetworkInfo) this.c.getParcelableExtra("networkInfo");
                                                    if (networkInfo != null) {
                                                        TLogger.d("PushServiceBroadcastHandler", "Connection state changed to --- " + networkInfo.toString());
                                                        if (!this.c.getBooleanExtra("noConnectivity", false)) {
                                                            if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                                                                TLogger.v("PushServiceBroadcastHandler", "network connected and start XGService 3s later");
                                                                b.a(this.b, 3000);
                                                                return;
                                                            } else if (NetworkInfo.State.DISCONNECTED == networkInfo.getState()) {
                                                                TLogger.v("PushServiceBroadcastHandler", "Network is disconnected.");
                                                                MqttChannel.getInstance(this.b).stopConnect(null);
                                                                return;
                                                            } else {
                                                                TLogger.v("PushServiceBroadcastHandler", "other network state - " + networkInfo.getState() + ". Do nothing.");
                                                                return;
                                                            }
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        return;
                                                    }
                                                } else if ("com.tencent.android.xg.vip.action.FLUSH.V4".equals(replace)) {
                                                    TBaseLogger.flush(new TBaseLogger.WriteFileCallback() {
                                                        /* class com.tencent.android.tpush.service.a.b.AnonymousClass1 */

                                                        @Override // com.tencent.tpns.baseapi.base.logger.TBaseLogger.WriteFileCallback
                                                        public void onFinished() {
                                                            TLogger.ii("PushServiceBroadcastHandler", "xg process log flush finished");
                                                            String decrypt = Rijndael.decrypt(b.this.c.getStringExtra("packName"));
                                                            if (!TextUtils.isEmpty(decrypt) && decrypt.equals(b.this.b.getPackageName())) {
                                                                com.tencent.android.tpush.common.d.a(b.e(), new Intent("com.tencent.android.xg.vip.action.FLUSH.RESULT.V4"));
                                                            }
                                                        }
                                                    });
                                                    return;
                                                } else if ("com.tencent.android.xg.vip.action.ATTRIBUTE.V4".equals(replace)) {
                                                    a.this.d(this.b, this.c);
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                    }
                    a.this.a(this.b, this.c);
                }
            } catch (Throwable th) {
                TLogger.e("PushServiceBroadcastHandler", "PushServiceBroadcastHandler run error.", th);
            }
        }
    }
}
