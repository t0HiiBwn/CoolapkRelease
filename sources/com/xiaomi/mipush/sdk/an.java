package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.ah;
import com.xiaomi.push.ar;
import com.xiaomi.push.bx;
import com.xiaomi.push.du;
import com.xiaomi.push.dv;
import com.xiaomi.push.ea;
import com.xiaomi.push.gi;
import com.xiaomi.push.gn;
import com.xiaomi.push.gs;
import com.xiaomi.push.gu;
import com.xiaomi.push.gv;
import com.xiaomi.push.gw;
import com.xiaomi.push.gx;
import com.xiaomi.push.gz;
import com.xiaomi.push.ha;
import com.xiaomi.push.he;
import com.xiaomi.push.hf;
import com.xiaomi.push.hg;
import com.xiaomi.push.hh;
import com.xiaomi.push.hi;
import com.xiaomi.push.hk;
import com.xiaomi.push.hm;
import com.xiaomi.push.ho;
import com.xiaomi.push.hq;
import com.xiaomi.push.hs;
import com.xiaomi.push.ht;
import com.xiaomi.push.hu;
import com.xiaomi.push.ia;
import com.xiaomi.push.iz;
import com.xiaomi.push.j;
import com.xiaomi.push.service.b;
import com.xiaomi.push.service.l;
import com.xiaomi.push.service.m;
import com.xiaomi.push.service.u;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;

public class an {
    private static an a;

    /* renamed from: a  reason: collision with other field name */
    private static Object f123a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static Queue<String> f124a;

    /* renamed from: a  reason: collision with other field name */
    private Context f125a;

    private an(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f125a = applicationContext;
        if (applicationContext == null) {
            this.f125a = context;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x013c  */
    public static Intent a(Context context, String str, Map<String, String> map) {
        Intent intent;
        Intent intent2;
        String str2;
        StringBuilder sb;
        String str3;
        MalformedURLException e;
        URISyntaxException e2;
        if (map != null && map.containsKey("notify_effect")) {
            String str4 = map.get("notify_effect");
            int i = -1;
            String str5 = map.get("intent_flag");
            try {
                if (!TextUtils.isEmpty(str5)) {
                    i = Integer.parseInt(str5);
                }
            } catch (NumberFormatException e3) {
                c.d("Cause by intent_flag: " + e3.getMessage());
            }
            if (u.a.equals(str4)) {
                try {
                    intent = context.getPackageManager().getLaunchIntentForPackage(str);
                } catch (Exception e4) {
                    c.d("Cause: " + e4.getMessage());
                }
            } else {
                if (u.b.equals(str4)) {
                    if (map.containsKey("intent_uri")) {
                        String str6 = map.get("intent_uri");
                        if (str6 != null) {
                            try {
                                intent2 = Intent.parseUri(str6, 1);
                                try {
                                    intent2.setPackage(str);
                                } catch (URISyntaxException e5) {
                                    e2 = e5;
                                }
                            } catch (URISyntaxException e6) {
                                e2 = e6;
                                intent2 = null;
                                sb = new StringBuilder();
                                sb.append("Cause: ");
                                str2 = e2.getMessage();
                                sb.append(str2);
                                c.d(sb.toString());
                                intent = intent2;
                                if (intent != null) {
                                }
                                return null;
                            }
                        }
                    } else if (map.containsKey("class_name")) {
                        Intent intent3 = new Intent();
                        intent3.setComponent(new ComponentName(str, map.get("class_name")));
                        intent = intent3;
                    }
                    intent = null;
                } else {
                    if (u.c.equals(str4) && (str3 = map.get("web_uri")) != null) {
                        String trim = str3.trim();
                        if (!trim.startsWith("http://") && !trim.startsWith("https://")) {
                            trim = "http://" + trim;
                        }
                        try {
                            String protocol = new URL(trim).getProtocol();
                            if ("http".equals(protocol) || "https".equals(protocol)) {
                                intent2 = new Intent("android.intent.action.VIEW");
                                try {
                                    intent2.setData(Uri.parse(trim));
                                } catch (MalformedURLException e7) {
                                    e = e7;
                                }
                            }
                        } catch (MalformedURLException e8) {
                            e = e8;
                            intent2 = null;
                            sb = new StringBuilder();
                            sb.append("Cause: ");
                            str2 = e.getMessage();
                            sb.append(str2);
                            c.d(sb.toString());
                            intent = intent2;
                            if (intent != null) {
                            }
                            return null;
                        }
                    }
                    intent = null;
                }
                intent = intent2;
            }
            if (intent != null) {
                if (i >= 0) {
                    intent.setFlags(i);
                }
                intent.addFlags(268435456);
                try {
                    if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                        return intent;
                    }
                    c.a("not resolve activity:" + intent);
                } catch (Exception e9) {
                    c.d("Cause: " + e9.getMessage());
                }
            }
        }
        return null;
    }

    private PushMessageHandler.a a(hf hfVar, boolean z, byte[] bArr, String str, int i) {
        String str2;
        int i2;
        String str3;
        String str4;
        dv dvVar;
        MiPushMessage miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        miPushMessage = null;
        ArrayList arrayList3 = null;
        miPushMessage = null;
        try {
            hu a2 = aj.a(this.f125a, hfVar);
            if (a2 == null) {
                c.d("receiving an un-recognized message. " + hfVar.a);
                dv.a(this.f125a).b(this.f125a.getPackageName(), du.a(i), str, "18");
                return null;
            }
            gi a3 = hfVar.a();
            c.a("processing a message, action=" + a3);
            switch (ap.a[a3.ordinal()]) {
                case 1:
                    if (!hfVar.c()) {
                        c.d("receiving an un-encrypt message(SendMessage).");
                        return null;
                    } else if (!b.m54a(this.f125a).m64d() || z) {
                        hm hmVar = (hm) a2;
                        gu l = hmVar.l();
                        if (l != null) {
                            if (z) {
                                if (b.b(hfVar)) {
                                    MiPushClient.reportIgnoreRegMessageClicked(this.f125a, l.b(), hfVar.m(), hfVar.f, l.d());
                                } else {
                                    MiPushClient.reportMessageClicked(this.f125a, l.b(), hfVar.m(), l.d());
                                }
                            }
                            if (!z) {
                                if (!TextUtils.isEmpty(hmVar.j()) && MiPushClient.aliasSetTime(this.f125a, hmVar.j()) < 0) {
                                    MiPushClient.addAlias(this.f125a, hmVar.j());
                                } else if (!TextUtils.isEmpty(hmVar.h()) && MiPushClient.topicSubscribedTime(this.f125a, hmVar.h()) < 0) {
                                    MiPushClient.addTopic(this.f125a, hmVar.h());
                                }
                            }
                            String str5 = (hfVar.h == null || hfVar.h.s() == null) ? null : hfVar.h.j.get("jobkey");
                            if (TextUtils.isEmpty(str5)) {
                                str5 = l.b();
                            }
                            if (z || !m38a(this.f125a, str5)) {
                                MiPushMessage generateMessage = PushMessageHelper.generateMessage(hmVar, hfVar.m(), z);
                                if (generateMessage.getPassThrough() != 0 || z || !b.a(generateMessage.getExtra())) {
                                    c.a("receive a message, msgid=" + l.b() + ", jobkey=" + str5);
                                    if (!z || generateMessage.getExtra() == null || !generateMessage.getExtra().containsKey("notify_effect")) {
                                        miPushMessage = generateMessage;
                                    } else {
                                        Map<String, String> extra = generateMessage.getExtra();
                                        String str6 = extra.get("notify_effect");
                                        if (b.b(hfVar)) {
                                            Intent a4 = a(this.f125a, hfVar.f, extra);
                                            a4.putExtra("eventMessageType", i);
                                            a4.putExtra("messageId", str);
                                            if (a4 == null) {
                                                c.a("Getting Intent fail from ignore reg message. ");
                                                dv.a(this.f125a).b(this.f125a.getPackageName(), du.a(i), str, "23");
                                                return null;
                                            }
                                            String f = l.f();
                                            if (!TextUtils.isEmpty(f)) {
                                                a4.putExtra("payload", f);
                                            }
                                            this.f125a.startActivity(a4);
                                            dv.a(this.f125a).a(this.f125a.getPackageName(), du.a(i), str, 3006, str6);
                                        } else {
                                            Context context = this.f125a;
                                            Intent a5 = a(context, context.getPackageName(), extra);
                                            if (a5 != null) {
                                                if (!str6.equals(u.c)) {
                                                    a5.putExtra("key_message", generateMessage);
                                                    a5.putExtra("eventMessageType", i);
                                                    a5.putExtra("messageId", str);
                                                }
                                                this.f125a.startActivity(a5);
                                                c.a("start activity succ");
                                                dv.a(this.f125a).a(this.f125a.getPackageName(), du.a(i), str, 1006, str6);
                                                if (str6.equals(u.c)) {
                                                    dv.a(this.f125a).a(this.f125a.getPackageName(), du.a(i), str, "13");
                                                }
                                            }
                                        }
                                        return null;
                                    }
                                } else {
                                    b.a(this.f125a, hfVar, bArr);
                                    return null;
                                }
                            } else {
                                c.a("drop a duplicate message, key=" + str5);
                                dv a6 = dv.a(this.f125a);
                                String packageName = this.f125a.getPackageName();
                                String a7 = du.a(i);
                                a6.c(packageName, a7, str, "2:" + str5);
                            }
                            if (hfVar.m() == null && !z) {
                                a(hmVar, hfVar);
                                break;
                            }
                        } else {
                            c.d("receive an empty message without push content, drop it");
                            dv.a(this.f125a).b(this.f125a.getPackageName(), du.a(i), str, "22");
                            return null;
                        }
                    } else {
                        c.a("receive a message in pause state. drop it");
                        dv.a(this.f125a).a(this.f125a.getPackageName(), du.a(i), str, "12");
                        return null;
                    }
                    break;
                case 2:
                    hk hkVar = (hk) a2;
                    String str7 = b.m54a(this.f125a).f143a;
                    if (TextUtils.isEmpty(str7) || !TextUtils.equals(str7, hkVar.c())) {
                        c.a("bad Registration result:");
                        dv.a(this.f125a).b(this.f125a.getPackageName(), du.a(i), str, "21");
                        return null;
                    }
                    b.m54a(this.f125a).f143a = null;
                    int i3 = (hkVar.e > 0 ? 1 : (hkVar.e == 0 ? 0 : -1));
                    Context context2 = this.f125a;
                    if (i3 == 0) {
                        b.m54a(context2).b(hkVar.g, hkVar.h, hkVar.r);
                        dvVar = dv.a(this.f125a);
                        str4 = this.f125a.getPackageName();
                        str3 = du.a(i);
                        i2 = 6006;
                        str2 = "1";
                    } else {
                        dvVar = dv.a(context2);
                        str4 = this.f125a.getPackageName();
                        str3 = du.a(i);
                        i2 = 6006;
                        str2 = "2";
                    }
                    dvVar.a(str4, str3, str, i2, str2);
                    if (!TextUtils.isEmpty(hkVar.g)) {
                        arrayList3 = new ArrayList();
                        arrayList3.add(hkVar.g);
                    }
                    MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ea.COMMAND_REGISTER.k, arrayList3, hkVar.e, hkVar.f, null);
                    aq.a(this.f125a).m52d();
                    return generateCommandMessage;
                case 3:
                    if (((hq) a2).e == 0) {
                        b.m54a(this.f125a).m56a();
                        MiPushClient.clearExtras(this.f125a);
                    }
                    PushMessageHandler.a();
                    break;
                case 4:
                    ho hoVar = (ho) a2;
                    if (hoVar.e == 0) {
                        MiPushClient.addTopic(this.f125a, hoVar.g());
                    }
                    if (!TextUtils.isEmpty(hoVar.g())) {
                        arrayList2 = new ArrayList();
                        arrayList2.add(hoVar.g());
                    }
                    return PushMessageHelper.generateCommandMessage(ea.COMMAND_SUBSCRIBE_TOPIC.k, arrayList2, hoVar.e, hoVar.f, hoVar.j());
                case 5:
                    hs hsVar = (hs) a2;
                    if (hsVar.e == 0) {
                        MiPushClient.removeTopic(this.f125a, hsVar.g());
                    }
                    if (!TextUtils.isEmpty(hsVar.g())) {
                        arrayList = new ArrayList();
                        arrayList.add(hsVar.g());
                    }
                    return PushMessageHelper.generateCommandMessage(ea.COMMAND_UNSUBSCRIBE_TOPIC.k, arrayList, hsVar.e, hsVar.f, hsVar.j());
                case 6:
                    bx.a(this.f125a.getPackageName(), this.f125a, a2, gi.Command, bArr.length);
                    he heVar = (he) a2;
                    String d = heVar.d();
                    List<String> i4 = heVar.i();
                    if (heVar.e == 0) {
                        if (TextUtils.equals(d, ea.COMMAND_SET_ACCEPT_TIME.k) && i4 != null && i4.size() > 1) {
                            MiPushClient.addAcceptTime(this.f125a, i4.get(0), i4.get(1));
                            if (!"00:00".equals(i4.get(0)) || !"00:00".equals(i4.get(1))) {
                                b.m54a(this.f125a).a(false);
                            } else {
                                b.m54a(this.f125a).a(true);
                            }
                            i4 = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), i4);
                        } else if (TextUtils.equals(d, ea.COMMAND_SET_ALIAS.k) && i4 != null && i4.size() > 0) {
                            MiPushClient.addAlias(this.f125a, i4.get(0));
                        } else if (TextUtils.equals(d, ea.COMMAND_UNSET_ALIAS.k) && i4 != null && i4.size() > 0) {
                            MiPushClient.removeAlias(this.f125a, i4.get(0));
                        } else if (TextUtils.equals(d, ea.COMMAND_SET_ACCOUNT.k) && i4 != null && i4.size() > 0) {
                            MiPushClient.addAccount(this.f125a, i4.get(0));
                        } else if (TextUtils.equals(d, ea.COMMAND_UNSET_ACCOUNT.k) && i4 != null && i4.size() > 0) {
                            MiPushClient.removeAccount(this.f125a, i4.get(0));
                        } else if (TextUtils.equals(d, ea.COMMAND_CHK_VDEVID.k)) {
                            if (i4 != null && i4.size() > 0) {
                                gw.a(this.f125a, i4.get(0));
                            }
                            return null;
                        }
                    }
                    return PushMessageHelper.generateCommandMessage(d, i4, heVar.e, heVar.f, heVar.k());
                case 7:
                    bx.a(this.f125a.getPackageName(), this.f125a, a2, gi.Notification, bArr.length);
                    if (!(a2 instanceof ha)) {
                        if (a2 instanceof hi) {
                            hi hiVar = (hi) a2;
                            if (!"registration id expired".equalsIgnoreCase(hiVar.e)) {
                                if ("client_info_update_ok".equalsIgnoreCase(hiVar.e)) {
                                    if (hiVar.j() != null && hiVar.j().containsKey("app_version")) {
                                        b.m54a(this.f125a).m57a(hiVar.j().get("app_version"));
                                        break;
                                    }
                                } else if (gs.AwakeApp.S.equalsIgnoreCase(hiVar.e)) {
                                    if (hfVar.c() && hiVar.j() != null && hiVar.j().containsKey("awake_info")) {
                                        Context context3 = this.f125a;
                                        n.a(context3, b.m54a(context3).m55a(), l.a(this.f125a).a(gn.AwakeInfoUploadWaySwitch.a(), 0), hiVar.j().get("awake_info"));
                                        break;
                                    }
                                } else if (!gs.NormalClientConfigUpdate.S.equalsIgnoreCase(hiVar.e)) {
                                    if (!gs.CustomClientConfigUpdate.S.equalsIgnoreCase(hiVar.e)) {
                                        if (!gs.SyncInfoResult.S.equalsIgnoreCase(hiVar.e)) {
                                            if (!gs.ForceSync.S.equalsIgnoreCase(hiVar.e)) {
                                                if (gs.CancelPushMessage.S.equals(hiVar.e)) {
                                                    if (hiVar.j() != null) {
                                                        int i5 = -2;
                                                        if (hiVar.j().containsKey(u.J)) {
                                                            String str8 = hiVar.j().get(u.J);
                                                            if (!TextUtils.isEmpty(str8)) {
                                                                try {
                                                                    i5 = Integer.parseInt(str8);
                                                                } catch (NumberFormatException e) {
                                                                    e.printStackTrace();
                                                                }
                                                            }
                                                        }
                                                        if (i5 >= -1) {
                                                            MiPushClient.clearNotification(this.f125a, i5);
                                                            break;
                                                        } else {
                                                            String str9 = "";
                                                            String str10 = "";
                                                            if (hiVar.j().containsKey(u.H)) {
                                                                str9 = hiVar.j().get(u.H);
                                                            }
                                                            if (hiVar.j().containsKey(u.I)) {
                                                                str10 = hiVar.j().get(u.I);
                                                            }
                                                            MiPushClient.clearNotification(this.f125a, str9, str10);
                                                            break;
                                                        }
                                                    }
                                                } else if (!gs.HybridRegisterResult.S.equals(hiVar.e)) {
                                                    if (!gs.HybridUnregisterResult.S.equals(hiVar.e)) {
                                                        if (gs.PushLogUpload.S.equals(hiVar.e) && hiVar.j() != null && hiVar.j().containsKey("packages")) {
                                                            String[] split = hiVar.j().get("packages").split(",");
                                                            if (TextUtils.equals(this.f125a.getPackageName(), "com.xiaomi.xmsf")) {
                                                                Logger.uploadLogFile(this.f125a, true);
                                                                a(this.f125a, split);
                                                                break;
                                                            } else {
                                                                Logger.uploadLogFile(this.f125a, false);
                                                                break;
                                                            }
                                                        }
                                                    } else {
                                                        hq hqVar = new hq();
                                                        ht.a(hqVar, hiVar.q());
                                                        MiPushClient4Hybrid.onReceiveUnregisterResult(this.f125a, hqVar);
                                                        break;
                                                    }
                                                } else {
                                                    hk hkVar2 = new hk();
                                                    ht.a(hkVar2, hiVar.q());
                                                    MiPushClient4Hybrid.onReceiveRegisterResult(this.f125a, hkVar2);
                                                    break;
                                                }
                                            } else {
                                                c.a("receive force sync notification");
                                                aw.a(this.f125a, false);
                                                break;
                                            }
                                        } else {
                                            aw.a(this.f125a, hiVar);
                                            break;
                                        }
                                    } else {
                                        hg hgVar = new hg();
                                        ht.a(hgVar, hiVar.q());
                                        m.a(l.a(this.f125a), hgVar);
                                        break;
                                    }
                                } else {
                                    hh hhVar = new hh();
                                    try {
                                        ht.a(hhVar, hiVar.q());
                                        m.a(l.a(this.f125a), hhVar);
                                        break;
                                    } catch (ia e2) {
                                        c.a(e2);
                                        break;
                                    }
                                }
                            } else {
                                List<String> allAlias = MiPushClient.getAllAlias(this.f125a);
                                List<String> allTopic = MiPushClient.getAllTopic(this.f125a);
                                List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f125a);
                                String acceptTime = MiPushClient.getAcceptTime(this.f125a);
                                MiPushClient.reInitialize(this.f125a, gx.RegIdExpired);
                                for (String str11 : allAlias) {
                                    MiPushClient.removeAlias(this.f125a, str11);
                                    MiPushClient.setAlias(this.f125a, str11, null);
                                }
                                for (String str12 : allTopic) {
                                    MiPushClient.removeTopic(this.f125a, str12);
                                    MiPushClient.subscribe(this.f125a, str12, null);
                                }
                                for (String str13 : allUserAccount) {
                                    MiPushClient.removeAccount(this.f125a, str13);
                                    MiPushClient.setUserAccount(this.f125a, str13, null);
                                }
                                String[] split2 = acceptTime.split(",");
                                if (split2.length == 2) {
                                    MiPushClient.removeAcceptTime(this.f125a);
                                    MiPushClient.addAcceptTime(this.f125a, split2[0], split2[1]);
                                    break;
                                }
                            }
                        }
                    } else {
                        ha haVar = (ha) a2;
                        String c = haVar.c();
                        if (gs.DisablePushMessage.S.equalsIgnoreCase(haVar.e)) {
                            if (haVar.f != 0) {
                                if ("syncing".equals(ag.a(this.f125a).a(av.DISABLE_PUSH))) {
                                    synchronized (ag.class) {
                                        if (ag.a(this.f125a).m37a(c)) {
                                            if (ag.a(this.f125a).a(c) < 10) {
                                                ag.a(this.f125a).b(c);
                                                aq.a(this.f125a).a(true, c);
                                            } else {
                                                ag.a(this.f125a).c(c);
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else {
                                synchronized (ag.class) {
                                    if (ag.a(this.f125a).m37a(c)) {
                                        ag.a(this.f125a).c(c);
                                        if ("syncing".equals(ag.a(this.f125a).a(av.DISABLE_PUSH))) {
                                            ag.a(this.f125a).a(av.DISABLE_PUSH, "synced");
                                            MiPushClient.clearNotification(this.f125a);
                                            MiPushClient.clearLocalNotificationType(this.f125a);
                                            PushMessageHandler.a();
                                            aq.a(this.f125a).m49b();
                                        }
                                    }
                                }
                                break;
                            }
                        } else if (gs.EnablePushMessage.S.equalsIgnoreCase(haVar.e)) {
                            if (haVar.f != 0) {
                                if ("syncing".equals(ag.a(this.f125a).a(av.ENABLE_PUSH))) {
                                    synchronized (ag.class) {
                                        if (ag.a(this.f125a).m37a(c)) {
                                            if (ag.a(this.f125a).a(c) < 10) {
                                                ag.a(this.f125a).b(c);
                                                aq.a(this.f125a).a(false, c);
                                            } else {
                                                ag.a(this.f125a).c(c);
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else {
                                synchronized (ag.class) {
                                    if (ag.a(this.f125a).m37a(c)) {
                                        ag.a(this.f125a).c(c);
                                        if ("syncing".equals(ag.a(this.f125a).a(av.ENABLE_PUSH))) {
                                            ag.a(this.f125a).a(av.ENABLE_PUSH, "synced");
                                        }
                                    }
                                }
                                break;
                            }
                        } else if (!gs.ThirdPartyRegUpdate.S.equalsIgnoreCase(haVar.e)) {
                            if (gs.UploadTinyData.S.equalsIgnoreCase(haVar.e)) {
                                a(haVar);
                                break;
                            }
                        } else {
                            b(haVar);
                            break;
                        }
                        ag.a(this.f125a).c(c);
                        break;
                    }
                    break;
            }
            return miPushMessage;
        } catch (t e3) {
            c.a(e3);
            a(hfVar);
            dv.a(this.f125a).b(this.f125a.getPackageName(), du.a(i), str, "19");
            return null;
        } catch (ia e4) {
            c.a(e4);
            c.d("receive a message which action string is not valid. is the reg expired?");
            dv.a(this.f125a).b(this.f125a.getPackageName(), du.a(i), str, "20");
            return null;
        }
    }

    private PushMessageHandler.a a(hf hfVar, byte[] bArr) {
        String str;
        String str2 = null;
        try {
            hu a2 = aj.a(this.f125a, hfVar);
            if (a2 == null) {
                c.d("message arrived: receiving an un-recognized message. " + hfVar.a);
                return null;
            }
            gi a3 = hfVar.a();
            c.a("message arrived: processing an arrived message, action=" + a3);
            if (ap.a[a3.ordinal()] != 1) {
                return null;
            }
            if (!hfVar.c()) {
                str = "message arrived: receiving an un-encrypt message(SendMessage).";
            } else {
                hm hmVar = (hm) a2;
                gu l = hmVar.l();
                if (l == null) {
                    str = "message arrived: receive an empty message without push content, drop it";
                } else {
                    if (!(hfVar.h == null || hfVar.h.s() == null)) {
                        str2 = hfVar.h.j.get("jobkey");
                    }
                    MiPushMessage generateMessage = PushMessageHelper.generateMessage(hmVar, hfVar.m(), false);
                    generateMessage.setArrivedMessage(true);
                    c.a("message arrived: receive a message, msgid=" + l.b() + ", jobkey=" + str2);
                    return generateMessage;
                }
            }
            c.d(str);
            return null;
        } catch (t e) {
            c.a(e);
            str = "message arrived: receive a message but decrypt failed. report when click.";
        } catch (ia e2) {
            c.a(e2);
            str = "message arrived: receive a message which action string is not valid. is the reg expired?";
        }
    }

    public static an a(Context context) {
        if (a == null) {
            a = new an(context);
        }
        return a;
    }

    private void a() {
        SharedPreferences sharedPreferences = this.f125a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong("last_reinitialize", 0)) > 1800000) {
            MiPushClient.reInitialize(this.f125a, gx.PackageUnregistered);
            sharedPreferences.edit().putLong("last_reinitialize", currentTimeMillis).commit();
        }
    }

    /* access modifiers changed from: private */
    public void a(Context context, PackageInfo packageInfo) {
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                    try {
                        Intent intent = new Intent();
                        intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                        intent.setAction("com.xiaomi.mipush.sdk.SYNC_LOG");
                        PushMessageHandler.a(context, intent);
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
            }
        }
    }

    public static void a(Context context, String str) {
        synchronized (f123a) {
            f124a.remove(str);
            b.m54a(context);
            SharedPreferences a2 = b.a(context);
            String a3 = ah.a(f124a, ",");
            SharedPreferences.Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            iz.a(edit);
        }
    }

    private void a(Context context, String[] strArr) {
        j.a(context).a(new ao(this, strArr, context));
    }

    private void a(ha haVar) {
        String c = haVar.c();
        c.b("receive ack " + c);
        Map<String, String> i = haVar.i();
        if (i != null) {
            String str = i.get("real_source");
            if (!TextUtils.isEmpty(str)) {
                c.b("receive ack : messageId = " + c + "  realSource = " + str);
                ar.a(this.f125a).a(c, str, Boolean.valueOf(haVar.f == 0));
            }
        }
    }

    private void a(hf hfVar) {
        c.a("receive a message but decrypt failed. report now.");
        hi hiVar = new hi(hfVar.m().a, false);
        hiVar.c(gs.DecryptMessageFail.S);
        hiVar.b(hfVar.h());
        hiVar.d(hfVar.f);
        hiVar.h = new HashMap();
        hiVar.h.put("regid", MiPushClient.getRegId(this.f125a));
        aq.a(this.f125a).a((aq) hiVar, gi.Notification, false, (gv) null);
    }

    private void a(hm hmVar, hf hfVar) {
        gv m = hfVar.m();
        gz gzVar = new gz();
        gzVar.b(hmVar.e());
        gzVar.a(hmVar.c());
        gzVar.a(hmVar.l().h());
        if (!TextUtils.isEmpty(hmVar.h())) {
            gzVar.c(hmVar.h());
        }
        if (!TextUtils.isEmpty(hmVar.j())) {
            gzVar.d(hmVar.j());
        }
        gzVar.a(ht.a(this.f125a, hfVar));
        aq.a(this.f125a).a((aq) gzVar, gi.AckMessage, m);
    }

    private void a(String str, long j, d dVar) {
        av a2 = k.a(dVar);
        if (a2 != null) {
            if (j == 0) {
                synchronized (ag.class) {
                    if (ag.a(this.f125a).m37a(str)) {
                        ag.a(this.f125a).c(str);
                        if ("syncing".equals(ag.a(this.f125a).a(a2))) {
                            ag.a(this.f125a).a(a2, "synced");
                        }
                    }
                }
            } else if ("syncing".equals(ag.a(this.f125a).a(a2))) {
                synchronized (ag.class) {
                    if (ag.a(this.f125a).m37a(str)) {
                        if (ag.a(this.f125a).a(str) < 10) {
                            ag.a(this.f125a).b(str);
                            aq.a(this.f125a).a(str, a2, dVar);
                        } else {
                            ag.a(this.f125a).c(str);
                        }
                    }
                }
            } else {
                ag.a(this.f125a).c(str);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m38a(Context context, String str) {
        synchronized (f123a) {
            b.m54a(context);
            SharedPreferences a2 = b.a(context);
            if (f124a == null) {
                String[] split = a2.getString("pref_msg_ids", "").split(",");
                f124a = new LinkedList();
                for (String str2 : split) {
                    f124a.add(str2);
                }
            }
            if (f124a.contains(str)) {
                return true;
            }
            f124a.add(str);
            if (f124a.size() > 25) {
                f124a.poll();
            }
            String a3 = ah.a(f124a, ",");
            SharedPreferences.Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            iz.a(edit);
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m39a(hf hfVar) {
        if (!TextUtils.equals("com.miui.hybrid", hfVar.j()) && !TextUtils.equals("com.miui.hybrid.loader", hfVar.j())) {
            return false;
        }
        Map<String, String> s = hfVar.m() == null ? null : hfVar.m().s();
        if (s == null) {
            return false;
        }
        String str = s.get("push_server_action");
        return TextUtils.equals(str, "hybrid_message") || TextUtils.equals(str, "platform_message");
    }

    private void b(ha haVar) {
        long j;
        d dVar;
        c.c("ASSEMBLE_PUSH : " + haVar.toString());
        String c = haVar.c();
        Map<String, String> i = haVar.i();
        if (i != null) {
            String str = i.get("RegInfo");
            if (!TextUtils.isEmpty(str)) {
                if (str.contains("brand:" + ah.FCM.name())) {
                    c.a("ASSEMBLE_PUSH : receive fcm token sync ack");
                    h.b(this.f125a, d.ASSEMBLE_PUSH_FCM, str);
                    j = haVar.f;
                    dVar = d.ASSEMBLE_PUSH_FCM;
                } else {
                    if (str.contains("brand:" + ah.HUAWEI.name())) {
                        c.a("ASSEMBLE_PUSH : receive hw token sync ack");
                        h.b(this.f125a, d.ASSEMBLE_PUSH_HUAWEI, str);
                        j = haVar.f;
                        dVar = d.ASSEMBLE_PUSH_HUAWEI;
                    } else {
                        if (str.contains("brand:" + ah.OPPO.name())) {
                            c.a("ASSEMBLE_PUSH : receive COS token sync ack");
                            h.b(this.f125a, d.ASSEMBLE_PUSH_COS, str);
                            j = haVar.f;
                            dVar = d.ASSEMBLE_PUSH_COS;
                        } else {
                            if (str.contains("brand:" + ah.VIVO.name())) {
                                c.a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                                h.b(this.f125a, d.ASSEMBLE_PUSH_FTOS, str);
                                j = haVar.f;
                                dVar = d.ASSEMBLE_PUSH_FTOS;
                            } else {
                                return;
                            }
                        }
                    }
                }
                a(c, j, dVar);
            }
        }
    }

    private void b(hf hfVar) {
        gv m = hfVar.m();
        gz gzVar = new gz();
        gzVar.b(hfVar.h());
        gzVar.a(m.b());
        gzVar.a(m.d());
        if (!TextUtils.isEmpty(m.f())) {
            gzVar.c(m.f());
        }
        gzVar.a(ht.a(this.f125a, hfVar));
        aq.a(this.f125a).a((aq) gzVar, gi.AckMessage, false, hfVar.m());
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00ec: APUT  (r2v27 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r11v6 java.lang.String) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0123: APUT  (r2v23 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r11v4 java.lang.String) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0183: APUT  (r2v19 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r11v2 java.lang.String) */
    public PushMessageHandler.a a(Intent intent) {
        String str;
        String str2;
        String str3;
        dv dvVar;
        Throwable e;
        dv a2;
        String packageName;
        String format;
        String action = intent.getAction();
        c.a("receive an intent from server, action=" + action);
        String stringExtra = intent.getStringExtra("mrt");
        if (stringExtra == null) {
            stringExtra = Long.toString(System.currentTimeMillis());
        }
        String stringExtra2 = intent.getStringExtra("messageId");
        int intExtra = intent.getIntExtra("eventMessageType", -1);
        if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
            if (byteArrayExtra == null) {
                c.d("receiving an empty message, drop");
                dv.a(this.f125a).a(this.f125a.getPackageName(), intent, "12");
                return null;
            }
            hf hfVar = new hf();
            try {
                ht.a(hfVar, byteArrayExtra);
                b a3 = b.m54a(this.f125a);
                gv m = hfVar.m();
                if (hfVar.a() == gi.SendMessage && m != null && !a3.m64d() && !booleanExtra) {
                    m.a("mrt", stringExtra);
                    m.a("mat", Long.toString(System.currentTimeMillis()));
                    if (!m39a(hfVar)) {
                        b(hfVar);
                    } else {
                        c.b("this is a mina's message, ack later");
                        m.a("__hybrid_message_ts", String.valueOf(m.d()));
                        m.a("__hybrid_device_status", String.valueOf((int) ht.a(this.f125a, hfVar)));
                    }
                }
                String str4 = "";
                if (hfVar.a() == gi.SendMessage && !hfVar.c()) {
                    if (b.b(hfVar)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = hfVar.j();
                        if (m != null) {
                            str4 = m.b();
                        }
                        objArr[1] = str4;
                        c.a(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                        a2 = dv.a(this.f125a);
                        packageName = this.f125a.getPackageName();
                        format = String.format("13: %1$s", hfVar.j());
                    } else {
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = hfVar.j();
                        if (m != null) {
                            str4 = m.b();
                        }
                        objArr2[1] = str4;
                        c.a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                        a2 = dv.a(this.f125a);
                        packageName = this.f125a.getPackageName();
                        format = String.format("14: %1$s", hfVar.j());
                    }
                    a2.a(packageName, intent, format);
                    return null;
                } else if (hfVar.a() == gi.SendMessage && hfVar.c() && b.b(hfVar) && (!booleanExtra || m == null || m.s() == null || !m.s().containsKey("notify_effect"))) {
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = hfVar.j();
                    if (m != null) {
                        str4 = m.b();
                    }
                    objArr3[1] = str4;
                    c.a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                    dv.a(this.f125a).a(this.f125a.getPackageName(), intent, String.format("25: %1$s", hfVar.j()));
                    return null;
                } else if (a3.m63c() || hfVar.a == gi.Registration) {
                    if (!a3.m63c() || !a3.m65e()) {
                        return a(hfVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra);
                    }
                    if (hfVar.a == gi.UnRegistration) {
                        a3.m56a();
                        MiPushClient.clearExtras(this.f125a);
                        PushMessageHandler.a();
                    } else {
                        MiPushClient.unregisterPush(this.f125a);
                    }
                } else if (b.b(hfVar)) {
                    return a(hfVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra);
                } else {
                    c.d("receive message without registration. need re-register!");
                    dv.a(this.f125a).a(this.f125a.getPackageName(), intent, "15");
                    a();
                }
            } catch (ia e2) {
                e = e2;
                dvVar = dv.a(this.f125a);
                str3 = this.f125a.getPackageName();
                str2 = "16";
                dvVar.a(str3, intent, str2);
                c.a(e);
                return null;
            } catch (Exception e3) {
                e = e3;
                dvVar = dv.a(this.f125a);
                str3 = this.f125a.getPackageName();
                str2 = "17";
                dvVar.a(str3, intent, str2);
                c.a(e);
                return null;
            }
        } else if ("com.xiaomi.mipush.ERROR".equals(action)) {
            MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
            hf hfVar2 = new hf();
            try {
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra2 != null) {
                    ht.a(hfVar2, byteArrayExtra2);
                }
            } catch (ia unused) {
            }
            miPushCommandMessage.setCommand(String.valueOf(hfVar2.a()));
            miPushCommandMessage.setResultCode((long) intent.getIntExtra("mipush_error_code", 0));
            miPushCommandMessage.setReason(intent.getStringExtra("mipush_error_msg"));
            c.d("receive a error message. code = " + intent.getIntExtra("mipush_error_code", 0) + ", msg= " + intent.getStringExtra("mipush_error_msg"));
            return miPushCommandMessage;
        } else if ("com.xiaomi.mipush.MESSAGE_ARRIVED".equals(action)) {
            byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra3 == null) {
                c.d("message arrived: receiving an empty message, drop");
                return null;
            }
            hf hfVar3 = new hf();
            try {
                ht.a(hfVar3, byteArrayExtra3);
                b a4 = b.m54a(this.f125a);
                if (b.b(hfVar3)) {
                    str = "message arrived: receive ignore reg message, ignore!";
                } else if (!a4.m63c()) {
                    str = "message arrived: receive message without registration. need unregister or re-register!";
                } else if (!a4.m63c() || !a4.m65e()) {
                    return a(hfVar3, byteArrayExtra3);
                } else {
                    str = "message arrived: app info is invalidated";
                }
                c.d(str);
            } catch (ia | Exception e4) {
                c.a(e4);
            }
        }
        return null;
    }

    public List<String> a(TimeZone timeZone, TimeZone timeZone2, List<String> list) {
        if (timeZone.equals(timeZone2)) {
            return list;
        }
        long rawOffset = (long) (((timeZone.getRawOffset() - timeZone2.getRawOffset()) / 1000) / 60);
        long parseLong = Long.parseLong(list.get(0).split(":")[0]);
        long parseLong2 = ((((parseLong * 60) + Long.parseLong(list.get(0).split(":")[1])) - rawOffset) + 1440) % 1440;
        long parseLong3 = ((((Long.parseLong(list.get(1).split(":")[0]) * 60) + Long.parseLong(list.get(1).split(":")[1])) - rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong2 / 60), Long.valueOf(parseLong2 % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong3 / 60), Long.valueOf(parseLong3 % 60)));
        return arrayList;
    }
}
