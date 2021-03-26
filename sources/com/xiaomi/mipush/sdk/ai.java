package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.Cif;
import com.xiaomi.push.bi;
import com.xiaomi.push.bs;
import com.xiaomi.push.cw;
import com.xiaomi.push.em;
import com.xiaomi.push.en;
import com.xiaomi.push.ew;
import com.xiaomi.push.hc;
import com.xiaomi.push.hh;
import com.xiaomi.push.hm;
import com.xiaomi.push.ho;
import com.xiaomi.push.hp;
import com.xiaomi.push.hq;
import com.xiaomi.push.hs;
import com.xiaomi.push.ht;
import com.xiaomi.push.hx;
import com.xiaomi.push.hy;
import com.xiaomi.push.hz;
import com.xiaomi.push.i;
import com.xiaomi.push.ia;
import com.xiaomi.push.ib;
import com.xiaomi.push.id;
import com.xiaomi.push.ih;
import com.xiaomi.push.ij;
import com.xiaomi.push.il;
import com.xiaomi.push.im;
import com.xiaomi.push.in;
import com.xiaomi.push.is;
import com.xiaomi.push.r;
import com.xiaomi.push.service.ab;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.ao;
import com.xiaomi.push.service.aw;
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

public class ai {
    private static ai a;

    /* renamed from: a  reason: collision with other field name */
    private static Object f143a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static Queue<String> f144a;

    /* renamed from: a  reason: collision with other field name */
    private Context f145a;

    private ai(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f145a = applicationContext;
        if (applicationContext == null) {
            this.f145a = context;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x013b  */
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
                b.d("Cause by intent_flag: " + e3.getMessage());
            }
            if (aw.a.equals(str4)) {
                try {
                    intent = context.getPackageManager().getLaunchIntentForPackage(str);
                } catch (Exception e4) {
                    b.d("Cause: " + e4.getMessage());
                }
            } else {
                if (aw.b.equals(str4)) {
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
                                b.d(sb.toString());
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
                    if (aw.c.equals(str4) && (str3 = map.get("web_uri")) != null) {
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
                            b.d(sb.toString());
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
                    b.m41a("not resolve activity:" + intent);
                } catch (Exception e9) {
                    b.d("Cause: " + e9.getMessage());
                }
            }
        }
        return null;
    }

    private PushMessageHandler.a a(hy hyVar, boolean z, byte[] bArr, String str, int i) {
        String str2;
        int i2;
        String str3;
        String str4;
        en enVar;
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
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        miPushMessage = null;
        ArrayList arrayList3 = null;
        miPushMessage = null;
        try {
            in a2 = ae.a(this.f145a, hyVar);
            if (a2 == null) {
                b.d("receiving an un-recognized message. " + hyVar.f696a);
                en.a(this.f145a).b(this.f145a.getPackageName(), em.m292a(i), str, "18");
                return null;
            }
            hc a3 = hyVar.a();
            b.m41a("processing a message, action=" + a3);
            switch (aj.a[a3.ordinal()]) {
                case 1:
                    if (!hyVar.m464b()) {
                        b.d("receiving an un-encrypt message(SendMessage).");
                        return null;
                    } else if (!b.m75a(this.f145a).m85d() || z) {
                        Cif ifVar = (Cif) a2;
                        ho a4 = ifVar.a();
                        if (a4 != null) {
                            if (z) {
                                if (ab.m607a(hyVar)) {
                                    MiPushClient.reportIgnoreRegMessageClicked(this.f145a, a4.m414a(), hyVar.m456a(), hyVar.f703b, a4.b());
                                } else {
                                    MiPushClient.reportMessageClicked(this.f145a, a4.m414a(), hyVar.m456a(), a4.b());
                                }
                            }
                            if (!z) {
                                if (!TextUtils.isEmpty(ifVar.d()) && MiPushClient.aliasSetTime(this.f145a, ifVar.d()) < 0) {
                                    MiPushClient.addAlias(this.f145a, ifVar.d());
                                } else if (!TextUtils.isEmpty(ifVar.c()) && MiPushClient.topicSubscribedTime(this.f145a, ifVar.c()) < 0) {
                                    MiPushClient.addTopic(this.f145a, ifVar.c());
                                }
                            }
                            String str5 = (hyVar.f697a == null || hyVar.f697a.m423a() == null) ? null : hyVar.f697a.f611a.get("jobkey");
                            if (TextUtils.isEmpty(str5)) {
                                str5 = a4.m414a();
                            }
                            if (z || !m59a(this.f145a, str5)) {
                                MiPushMessage generateMessage = PushMessageHelper.generateMessage(ifVar, hyVar.m456a(), z);
                                if (generateMessage.getPassThrough() != 0 || z || !ab.m608a(generateMessage.getExtra())) {
                                    b.m41a("receive a message, msgid=" + a4.m414a() + ", jobkey=" + str5);
                                    if (!z || generateMessage.getExtra() == null || !generateMessage.getExtra().containsKey("notify_effect")) {
                                        miPushMessage = generateMessage;
                                    } else {
                                        Map<String, String> extra = generateMessage.getExtra();
                                        String str6 = extra.get("notify_effect");
                                        if (ab.m607a(hyVar)) {
                                            Intent a5 = a(this.f145a, hyVar.f703b, extra);
                                            a5.putExtra("eventMessageType", i);
                                            a5.putExtra("messageId", str);
                                            a5.putExtra("jobkey", str5);
                                            if (a5 == null) {
                                                b.m41a("Getting Intent fail from ignore reg message. ");
                                                en.a(this.f145a).b(this.f145a.getPackageName(), em.m292a(i), str, "23");
                                                return null;
                                            }
                                            String c = a4.c();
                                            if (!TextUtils.isEmpty(c)) {
                                                a5.putExtra("payload", c);
                                            }
                                            this.f145a.startActivity(a5);
                                            en.a(this.f145a).a(this.f145a.getPackageName(), em.m292a(i), str, 3006, str6);
                                        } else {
                                            Context context = this.f145a;
                                            Intent a6 = a(context, context.getPackageName(), extra);
                                            if (a6 != null) {
                                                if (!str6.equals(aw.c)) {
                                                    a6.putExtra("key_message", generateMessage);
                                                    a6.putExtra("eventMessageType", i);
                                                    a6.putExtra("messageId", str);
                                                    a6.putExtra("jobkey", str5);
                                                }
                                                this.f145a.startActivity(a6);
                                                b.m41a("start activity succ");
                                                en.a(this.f145a).a(this.f145a.getPackageName(), em.m292a(i), str, 1006, str6);
                                                if (str6.equals(aw.c)) {
                                                    en.a(this.f145a).a(this.f145a.getPackageName(), em.m292a(i), str, "13");
                                                }
                                            }
                                        }
                                        return null;
                                    }
                                } else {
                                    ab.m604a(this.f145a, hyVar, bArr);
                                    return null;
                                }
                            } else {
                                b.m41a("drop a duplicate message, key=" + str5);
                                en a7 = en.a(this.f145a);
                                String packageName = this.f145a.getPackageName();
                                String a8 = em.m292a(i);
                                a7.c(packageName, a8, str, "2:" + str5);
                            }
                            if (hyVar.m456a() == null && !z) {
                                a(ifVar, hyVar);
                                break;
                            }
                        } else {
                            b.d("receive an empty message without push content, drop it");
                            en.a(this.f145a).b(this.f145a.getPackageName(), em.m292a(i), str, "22");
                            return null;
                        }
                    } else {
                        b.m41a("receive a message in pause state. drop it");
                        en.a(this.f145a).a(this.f145a.getPackageName(), em.m292a(i), str, "12");
                        return null;
                    }
                    break;
                case 2:
                    id idVar = (id) a2;
                    String str7 = b.m75a(this.f145a).f161a;
                    if (TextUtils.isEmpty(str7) || !TextUtils.equals(str7, idVar.m494a())) {
                        b.m41a("bad Registration result:");
                        en.a(this.f145a).b(this.f145a.getPackageName(), em.m292a(i), str, "21");
                        return null;
                    }
                    b.m75a(this.f145a).f161a = null;
                    int i3 = (idVar.f761a > 0 ? 1 : (idVar.f761a == 0 ? 0 : -1));
                    Context context2 = this.f145a;
                    if (i3 == 0) {
                        b.m75a(context2).b(idVar.f771e, idVar.f772f, idVar.f778l);
                        enVar = en.a(this.f145a);
                        str4 = this.f145a.getPackageName();
                        str3 = em.m292a(i);
                        i2 = 6006;
                        str2 = "1";
                    } else {
                        enVar = en.a(context2);
                        str4 = this.f145a.getPackageName();
                        str3 = em.m292a(i);
                        i2 = 6006;
                        str2 = "2";
                    }
                    enVar.a(str4, str3, str, i2, str2);
                    if (!TextUtils.isEmpty(idVar.f771e)) {
                        arrayList3 = new ArrayList();
                        arrayList3.add(idVar.f771e);
                    }
                    MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ew.COMMAND_REGISTER.f419a, arrayList3, idVar.f761a, idVar.f770d, null);
                    ak.a(this.f145a).m73d();
                    return generateCommandMessage;
                case 3:
                    if (((ij) a2).f837a == 0) {
                        b.m75a(this.f145a).m77a();
                        MiPushClient.clearExtras(this.f145a);
                    }
                    PushMessageHandler.a();
                    break;
                case 4:
                    ih ihVar = (ih) a2;
                    if (ihVar.f812a == 0) {
                        MiPushClient.addTopic(this.f145a, ihVar.b());
                    }
                    if (!TextUtils.isEmpty(ihVar.b())) {
                        arrayList2 = new ArrayList();
                        arrayList2.add(ihVar.b());
                    }
                    b.e("resp-cmd:" + ew.COMMAND_SUBSCRIBE_TOPIC + ", " + ihVar.a());
                    return PushMessageHelper.generateCommandMessage(ew.COMMAND_SUBSCRIBE_TOPIC.f419a, arrayList2, ihVar.f812a, ihVar.f818d, ihVar.c());
                case 5:
                    il ilVar = (il) a2;
                    if (ilVar.f857a == 0) {
                        MiPushClient.removeTopic(this.f145a, ilVar.b());
                    }
                    if (!TextUtils.isEmpty(ilVar.b())) {
                        arrayList = new ArrayList();
                        arrayList.add(ilVar.b());
                    }
                    b.e("resp-cmd:" + ew.COMMAND_UNSUBSCRIBE_TOPIC + ", " + ilVar.a());
                    return PushMessageHelper.generateCommandMessage(ew.COMMAND_UNSUBSCRIBE_TOPIC.f419a, arrayList, ilVar.f857a, ilVar.f863d, ilVar.c());
                case 6:
                    cw.a(this.f145a.getPackageName(), this.f145a, a2, hc.Command, bArr.length);
                    hx hxVar = (hx) a2;
                    String b = hxVar.b();
                    List<String> a9 = hxVar.m450a();
                    if (hxVar.f684a == 0) {
                        if (TextUtils.equals(b, ew.COMMAND_SET_ACCEPT_TIME.f419a) && a9 != null && a9.size() > 1) {
                            MiPushClient.addAcceptTime(this.f145a, a9.get(0), a9.get(1));
                            if (!"00:00".equals(a9.get(0)) || !"00:00".equals(a9.get(1))) {
                                b.m75a(this.f145a).a(false);
                            } else {
                                b.m75a(this.f145a).a(true);
                            }
                            a9 = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), a9);
                        } else if (TextUtils.equals(b, ew.COMMAND_SET_ALIAS.f419a) && a9 != null && a9.size() > 0) {
                            MiPushClient.addAlias(this.f145a, a9.get(0));
                        } else if (TextUtils.equals(b, ew.COMMAND_UNSET_ALIAS.f419a) && a9 != null && a9.size() > 0) {
                            MiPushClient.removeAlias(this.f145a, a9.get(0));
                        } else if (TextUtils.equals(b, ew.COMMAND_SET_ACCOUNT.f419a) && a9 != null && a9.size() > 0) {
                            MiPushClient.addAccount(this.f145a, a9.get(0));
                        } else if (TextUtils.equals(b, ew.COMMAND_UNSET_ACCOUNT.f419a) && a9 != null && a9.size() > 0) {
                            MiPushClient.removeAccount(this.f145a, a9.get(0));
                        } else if (TextUtils.equals(b, ew.COMMAND_CHK_VDEVID.f419a)) {
                            if (a9 != null && a9.size() > 0) {
                                i.a(this.f145a, a9.get(0));
                            }
                            return null;
                        }
                    }
                    b.e("resp-cmd:" + b + ", " + hxVar.a());
                    return PushMessageHelper.generateCommandMessage(b, a9, hxVar.f684a, hxVar.f692d, hxVar.c());
                case 7:
                    cw.a(this.f145a.getPackageName(), this.f145a, a2, hc.Notification, bArr.length);
                    if (!(a2 instanceof ht)) {
                        if (a2 instanceof ib) {
                            ib ibVar = (ib) a2;
                            if (!"registration id expired".equalsIgnoreCase(ibVar.f722d)) {
                                if (hm.ClientInfoUpdateOk.f576a.equalsIgnoreCase(ibVar.f722d)) {
                                    if (ibVar.m481a() != null && ibVar.m481a().containsKey("app_version")) {
                                        b.m75a(this.f145a).m78a(ibVar.m481a().get("app_version"));
                                        break;
                                    }
                                } else if (hm.AwakeApp.f576a.equalsIgnoreCase(ibVar.f722d)) {
                                    if (hyVar.m464b() && ibVar.m481a() != null && ibVar.m481a().containsKey("awake_info")) {
                                        Context context3 = this.f145a;
                                        n.a(context3, b.m75a(context3).m76a(), an.a(this.f145a).a(hh.AwakeInfoUploadWaySwitch.a(), 0), ibVar.m481a().get("awake_info"));
                                        break;
                                    }
                                } else if (!hm.NormalClientConfigUpdate.f576a.equalsIgnoreCase(ibVar.f722d)) {
                                    if (!hm.CustomClientConfigUpdate.f576a.equalsIgnoreCase(ibVar.f722d)) {
                                        if (!hm.SyncInfoResult.f576a.equalsIgnoreCase(ibVar.f722d)) {
                                            if (!hm.ForceSync.f576a.equalsIgnoreCase(ibVar.f722d)) {
                                                if (!hm.CancelPushMessage.f576a.equals(ibVar.f722d)) {
                                                    if (!hm.HybridRegisterResult.f576a.equals(ibVar.f722d)) {
                                                        if (hm.HybridUnregisterResult.f576a.equals(ibVar.f722d)) {
                                                            ij ijVar = new ij();
                                                            im.a(ijVar, ibVar.m486a());
                                                            MiPushClient4Hybrid.onReceiveUnregisterResult(this.f145a, ijVar);
                                                            break;
                                                        } else {
                                                            hm.PushLogUpload.f576a.equals(ibVar.f722d);
                                                            break;
                                                        }
                                                    } else {
                                                        try {
                                                            id idVar2 = new id();
                                                            im.a(idVar2, ibVar.m486a());
                                                            MiPushClient4Hybrid.onReceiveRegisterResult(this.f145a, idVar2);
                                                            break;
                                                        } catch (is e) {
                                                            b.a(e);
                                                            break;
                                                        }
                                                    }
                                                } else {
                                                    b.e("resp-type:" + ibVar.f722d + ", " + ibVar.m480a());
                                                    if (ibVar.m481a() != null) {
                                                        int i4 = -2;
                                                        if (ibVar.m481a().containsKey(aw.J)) {
                                                            String str8 = ibVar.m481a().get(aw.J);
                                                            if (!TextUtils.isEmpty(str8)) {
                                                                try {
                                                                    i4 = Integer.parseInt(str8);
                                                                } catch (NumberFormatException e2) {
                                                                    e2.printStackTrace();
                                                                }
                                                            }
                                                        }
                                                        if (i4 >= -1) {
                                                            MiPushClient.clearNotification(this.f145a, i4);
                                                        } else {
                                                            String str9 = "";
                                                            String str10 = "";
                                                            if (ibVar.m481a().containsKey(aw.H)) {
                                                                str9 = ibVar.m481a().get(aw.H);
                                                            }
                                                            if (ibVar.m481a().containsKey(aw.I)) {
                                                                str10 = ibVar.m481a().get(aw.I);
                                                            }
                                                            MiPushClient.clearNotification(this.f145a, str9, str10);
                                                        }
                                                    }
                                                    a(ibVar);
                                                    break;
                                                }
                                            } else {
                                                b.m41a("receive force sync notification");
                                                aq.a(this.f145a, false);
                                                break;
                                            }
                                        } else {
                                            aq.a(this.f145a, ibVar);
                                            break;
                                        }
                                    } else {
                                        hz hzVar = new hz();
                                        im.a(hzVar, ibVar.m486a());
                                        ao.a(an.a(this.f145a), hzVar);
                                        break;
                                    }
                                } else {
                                    ia iaVar = new ia();
                                    try {
                                        im.a(iaVar, ibVar.m486a());
                                        ao.a(an.a(this.f145a), iaVar);
                                        break;
                                    } catch (is unused) {
                                        break;
                                    }
                                }
                            } else {
                                List<String> allAlias = MiPushClient.getAllAlias(this.f145a);
                                List<String> allTopic = MiPushClient.getAllTopic(this.f145a);
                                List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f145a);
                                String acceptTime = MiPushClient.getAcceptTime(this.f145a);
                                b.e("resp-type:" + ibVar.f722d + ", " + ibVar.m480a());
                                MiPushClient.reInitialize(this.f145a, hq.RegIdExpired);
                                for (String str11 : allAlias) {
                                    MiPushClient.removeAlias(this.f145a, str11);
                                    MiPushClient.setAlias(this.f145a, str11, null);
                                }
                                for (String str12 : allTopic) {
                                    MiPushClient.removeTopic(this.f145a, str12);
                                    MiPushClient.subscribe(this.f145a, str12, null);
                                }
                                for (String str13 : allUserAccount) {
                                    MiPushClient.removeAccount(this.f145a, str13);
                                    MiPushClient.setUserAccount(this.f145a, str13, null);
                                }
                                String[] split = acceptTime.split(",");
                                if (split.length == 2) {
                                    MiPushClient.removeAcceptTime(this.f145a);
                                    MiPushClient.addAcceptTime(this.f145a, split[0], split[1]);
                                    break;
                                }
                            }
                        }
                    } else {
                        ht htVar = (ht) a2;
                        String a10 = htVar.a();
                        b.e("resp-type:" + htVar.b() + ", code:" + htVar.f654a + ", " + a10);
                        if (hm.DisablePushMessage.f576a.equalsIgnoreCase(htVar.f661d)) {
                            if (htVar.f654a != 0) {
                                if ("syncing".equals(ab.a(this.f145a).a(ap.DISABLE_PUSH))) {
                                    synchronized (ab.class) {
                                        if (ab.a(this.f145a).m58a(a10)) {
                                            if (ab.a(this.f145a).a(a10) < 10) {
                                                ab.a(this.f145a).b(a10);
                                                ak.a(this.f145a).a(true, a10);
                                            } else {
                                                ab.a(this.f145a).c(a10);
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else {
                                synchronized (ab.class) {
                                    if (ab.a(this.f145a).m58a(a10)) {
                                        ab.a(this.f145a).c(a10);
                                        if ("syncing".equals(ab.a(this.f145a).a(ap.DISABLE_PUSH))) {
                                            ab.a(this.f145a).a(ap.DISABLE_PUSH, "synced");
                                            MiPushClient.clearNotification(this.f145a);
                                            MiPushClient.clearLocalNotificationType(this.f145a);
                                            PushMessageHandler.a();
                                            ak.a(this.f145a).m70b();
                                        }
                                    }
                                }
                                break;
                            }
                        } else if (hm.EnablePushMessage.f576a.equalsIgnoreCase(htVar.f661d)) {
                            if (htVar.f654a != 0) {
                                if ("syncing".equals(ab.a(this.f145a).a(ap.ENABLE_PUSH))) {
                                    synchronized (ab.class) {
                                        if (ab.a(this.f145a).m58a(a10)) {
                                            if (ab.a(this.f145a).a(a10) < 10) {
                                                ab.a(this.f145a).b(a10);
                                                ak.a(this.f145a).a(false, a10);
                                            } else {
                                                ab.a(this.f145a).c(a10);
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else {
                                synchronized (ab.class) {
                                    if (ab.a(this.f145a).m58a(a10)) {
                                        ab.a(this.f145a).c(a10);
                                        if ("syncing".equals(ab.a(this.f145a).a(ap.ENABLE_PUSH))) {
                                            ab.a(this.f145a).a(ap.ENABLE_PUSH, "synced");
                                        }
                                    }
                                }
                                break;
                            }
                        } else if (!hm.ThirdPartyRegUpdate.f576a.equalsIgnoreCase(htVar.f661d)) {
                            if (hm.UploadTinyData.f576a.equalsIgnoreCase(htVar.f661d)) {
                                a(htVar);
                                break;
                            }
                        } else {
                            b(htVar);
                            break;
                        }
                        ab.a(this.f145a).c(a10);
                        break;
                    }
                    break;
            }
            return miPushMessage;
        } catch (s e3) {
            b.a(e3);
            a(hyVar);
            en.a(this.f145a).b(this.f145a.getPackageName(), em.m292a(i), str, "19");
            return null;
        } catch (is e4) {
            b.a(e4);
            b.d("receive a message which action string is not valid. is the reg expired?");
            en.a(this.f145a).b(this.f145a.getPackageName(), em.m292a(i), str, "20");
            return null;
        }
    }

    private PushMessageHandler.a a(hy hyVar, byte[] bArr) {
        String str;
        String str2 = null;
        try {
            in a2 = ae.a(this.f145a, hyVar);
            if (a2 == null) {
                b.d("message arrived: receiving an un-recognized message. " + hyVar.f696a);
                return null;
            }
            hc a3 = hyVar.a();
            b.m41a("message arrived: processing an arrived message, action=" + a3);
            if (aj.a[a3.ordinal()] != 1) {
                return null;
            }
            if (!hyVar.m464b()) {
                str = "message arrived: receiving an un-encrypt message(SendMessage).";
            } else {
                Cif ifVar = (Cif) a2;
                ho a4 = ifVar.a();
                if (a4 == null) {
                    str = "message arrived: receive an empty message without push content, drop it";
                } else {
                    if (!(hyVar.f697a == null || hyVar.f697a.m423a() == null)) {
                        str2 = hyVar.f697a.f611a.get("jobkey");
                    }
                    MiPushMessage generateMessage = PushMessageHelper.generateMessage(ifVar, hyVar.m456a(), false);
                    generateMessage.setArrivedMessage(true);
                    b.m41a("message arrived: receive a message, msgid=" + a4.m414a() + ", jobkey=" + str2);
                    return generateMessage;
                }
            }
            b.d(str);
            return null;
        } catch (s e) {
            b.a(e);
            str = "message arrived: receive a message but decrypt failed. report when click.";
        } catch (is e2) {
            b.a(e2);
            str = "message arrived: receive a message which action string is not valid. is the reg expired?";
        }
    }

    public static ai a(Context context) {
        if (a == null) {
            a = new ai(context);
        }
        return a;
    }

    private void a() {
        SharedPreferences sharedPreferences = this.f145a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong("last_reinitialize", 0)) > 1800000) {
            MiPushClient.reInitialize(this.f145a, hq.PackageUnregistered);
            sharedPreferences.edit().putLong("last_reinitialize", currentTimeMillis).commit();
        }
    }

    public static void a(Context context, String str) {
        synchronized (f143a) {
            f144a.remove(str);
            b.m75a(context);
            SharedPreferences a2 = b.a(context);
            String a3 = bi.a(f144a, ",");
            SharedPreferences.Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            r.a(edit);
        }
    }

    private void a(ht htVar) {
        String a2 = htVar.a();
        b.b("receive ack " + a2);
        Map<String, String> a3 = htVar.m437a();
        if (a3 != null) {
            String str = a3.get("real_source");
            if (!TextUtils.isEmpty(str)) {
                b.b("receive ack : messageId = " + a2 + "  realSource = " + str);
                bs.a(this.f145a).a(a2, str, Boolean.valueOf(htVar.f654a == 0));
            }
        }
    }

    private void a(hy hyVar) {
        b.m41a("receive a message but decrypt failed. report now.");
        ib ibVar = new ib(hyVar.m456a().f609a, false);
        ibVar.c(hm.DecryptMessageFail.f576a);
        ibVar.b(hyVar.m457a());
        ibVar.d(hyVar.f703b);
        ibVar.f717a = new HashMap();
        ibVar.f717a.put("regid", MiPushClient.getRegId(this.f145a));
        ak.a(this.f145a).a((ak) ibVar, hc.Notification, false, (hp) null);
    }

    private void a(ib ibVar) {
        ht htVar = new ht();
        htVar.c(hm.CancelPushMessageACK.f576a);
        htVar.a(ibVar.m480a());
        htVar.a(ibVar.a());
        htVar.b(ibVar.b());
        htVar.e(ibVar.c());
        htVar.a(0);
        htVar.d("success clear push message.");
        ak.a(this.f145a).a(htVar, hc.Notification, false, true, null, false, this.f145a.getPackageName(), b.m75a(this.f145a).m76a(), false);
    }

    private void a(Cif ifVar, hy hyVar) {
        hp a2 = hyVar.m456a();
        hs hsVar = new hs();
        hsVar.b(ifVar.b());
        hsVar.a(ifVar.m501a());
        hsVar.a(ifVar.a().a());
        if (!TextUtils.isEmpty(ifVar.c())) {
            hsVar.c(ifVar.c());
        }
        if (!TextUtils.isEmpty(ifVar.d())) {
            hsVar.d(ifVar.d());
        }
        hsVar.a(im.a(this.f145a, hyVar));
        ak.a(this.f145a).a((ak) hsVar, hc.AckMessage, a2);
    }

    private void a(String str, long j, d dVar) {
        ap a2 = k.a(dVar);
        if (a2 != null) {
            if (j == 0) {
                synchronized (ab.class) {
                    if (ab.a(this.f145a).m58a(str)) {
                        ab.a(this.f145a).c(str);
                        if ("syncing".equals(ab.a(this.f145a).a(a2))) {
                            ab.a(this.f145a).a(a2, "synced");
                        }
                    }
                }
            } else if ("syncing".equals(ab.a(this.f145a).a(a2))) {
                synchronized (ab.class) {
                    if (ab.a(this.f145a).m58a(str)) {
                        if (ab.a(this.f145a).a(str) < 10) {
                            ab.a(this.f145a).b(str);
                            ak.a(this.f145a).a(str, a2, dVar);
                        } else {
                            ab.a(this.f145a).c(str);
                        }
                    }
                }
            } else {
                ab.a(this.f145a).c(str);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m59a(Context context, String str) {
        synchronized (f143a) {
            b.m75a(context);
            SharedPreferences a2 = b.a(context);
            if (f144a == null) {
                String[] split = a2.getString("pref_msg_ids", "").split(",");
                f144a = new LinkedList();
                for (String str2 : split) {
                    f144a.add(str2);
                }
            }
            if (f144a.contains(str)) {
                return true;
            }
            f144a.add(str);
            if (f144a.size() > 25) {
                f144a.poll();
            }
            String a3 = bi.a(f144a, ",");
            SharedPreferences.Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            r.a(edit);
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m60a(hy hyVar) {
        Map<String, String> a2 = hyVar.m456a() == null ? null : hyVar.m456a().m423a();
        if (a2 == null) {
            return false;
        }
        String str = a2.get("push_server_action");
        return TextUtils.equals(str, "hybrid_message") || TextUtils.equals(str, "platform_message");
    }

    private void b(ht htVar) {
        long j;
        d dVar;
        b.c("ASSEMBLE_PUSH : " + htVar.toString());
        String a2 = htVar.a();
        Map<String, String> a3 = htVar.m437a();
        if (a3 != null) {
            String str = a3.get("RegInfo");
            if (!TextUtils.isEmpty(str)) {
                if (str.contains("brand:" + ac.FCM.name())) {
                    b.m41a("ASSEMBLE_PUSH : receive fcm token sync ack");
                    h.b(this.f145a, d.ASSEMBLE_PUSH_FCM, str);
                    j = htVar.f654a;
                    dVar = d.ASSEMBLE_PUSH_FCM;
                } else {
                    if (str.contains("brand:" + ac.HUAWEI.name())) {
                        b.m41a("ASSEMBLE_PUSH : receive hw token sync ack");
                        h.b(this.f145a, d.ASSEMBLE_PUSH_HUAWEI, str);
                        j = htVar.f654a;
                        dVar = d.ASSEMBLE_PUSH_HUAWEI;
                    } else {
                        if (str.contains("brand:" + ac.OPPO.name())) {
                            b.m41a("ASSEMBLE_PUSH : receive COS token sync ack");
                            h.b(this.f145a, d.ASSEMBLE_PUSH_COS, str);
                            j = htVar.f654a;
                            dVar = d.ASSEMBLE_PUSH_COS;
                        } else {
                            if (str.contains("brand:" + ac.VIVO.name())) {
                                b.m41a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                                h.b(this.f145a, d.ASSEMBLE_PUSH_FTOS, str);
                                j = htVar.f654a;
                                dVar = d.ASSEMBLE_PUSH_FTOS;
                            } else {
                                return;
                            }
                        }
                    }
                }
                a(a2, j, dVar);
            }
        }
    }

    private void b(hy hyVar) {
        hp a2 = hyVar.m456a();
        hs hsVar = new hs();
        hsVar.b(hyVar.m457a());
        hsVar.a(a2.m422a());
        hsVar.a(a2.m420a());
        if (!TextUtils.isEmpty(a2.m427b())) {
            hsVar.c(a2.m427b());
        }
        hsVar.a(im.a(this.f145a, hyVar));
        ak.a(this.f145a).a((ak) hsVar, hc.AckMessage, false, hyVar.m456a());
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00eb: APUT  (r2v27 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r11v6 java.lang.String) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0122: APUT  (r2v23 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r11v4 java.lang.String) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0182: APUT  (r2v19 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r11v2 java.lang.String) */
    public PushMessageHandler.a a(Intent intent) {
        String str;
        String str2;
        String str3;
        en enVar;
        Throwable e;
        en a2;
        String packageName;
        String format;
        String action = intent.getAction();
        b.m41a("receive an intent from server, action=" + action);
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
                b.d("receiving an empty message, drop");
                en.a(this.f145a).a(this.f145a.getPackageName(), intent, "12");
                return null;
            }
            hy hyVar = new hy();
            try {
                im.a(hyVar, byteArrayExtra);
                b a3 = b.m75a(this.f145a);
                hp a4 = hyVar.m456a();
                if (hyVar.a() == hc.SendMessage && a4 != null && !a3.m85d() && !booleanExtra) {
                    a4.a("mrt", stringExtra);
                    a4.a("mat", Long.toString(System.currentTimeMillis()));
                    if (!m60a(hyVar)) {
                        b(hyVar);
                    } else {
                        b.b("this is a mina's message, ack later");
                        a4.a("__hybrid_message_ts", String.valueOf(a4.m420a()));
                        a4.a("__hybrid_device_status", String.valueOf((int) im.a(this.f145a, hyVar)));
                    }
                }
                String str4 = "";
                if (hyVar.a() == hc.SendMessage && !hyVar.m464b()) {
                    if (ab.m607a(hyVar)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = hyVar.b();
                        if (a4 != null) {
                            str4 = a4.m422a();
                        }
                        objArr[1] = str4;
                        b.m41a(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                        a2 = en.a(this.f145a);
                        packageName = this.f145a.getPackageName();
                        format = String.format("13: %1$s", hyVar.b());
                    } else {
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = hyVar.b();
                        if (a4 != null) {
                            str4 = a4.m422a();
                        }
                        objArr2[1] = str4;
                        b.m41a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                        a2 = en.a(this.f145a);
                        packageName = this.f145a.getPackageName();
                        format = String.format("14: %1$s", hyVar.b());
                    }
                    a2.a(packageName, intent, format);
                    return null;
                } else if (hyVar.a() == hc.SendMessage && hyVar.m464b() && ab.m607a(hyVar) && (!booleanExtra || a4 == null || a4.m423a() == null || !a4.m423a().containsKey("notify_effect"))) {
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = hyVar.b();
                    if (a4 != null) {
                        str4 = a4.m422a();
                    }
                    objArr3[1] = str4;
                    b.m41a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                    en.a(this.f145a).a(this.f145a.getPackageName(), intent, String.format("25: %1$s", hyVar.b()));
                    return null;
                } else if (a3.m84c() || hyVar.f696a == hc.Registration) {
                    if (!a3.m84c() || !a3.m86e()) {
                        return a(hyVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra);
                    }
                    if (hyVar.f696a == hc.UnRegistration) {
                        a3.m77a();
                        MiPushClient.clearExtras(this.f145a);
                        PushMessageHandler.a();
                    } else {
                        MiPushClient.unregisterPush(this.f145a);
                    }
                } else if (ab.m607a(hyVar)) {
                    return a(hyVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra);
                } else {
                    b.d("receive message without registration. need re-register!");
                    en.a(this.f145a).a(this.f145a.getPackageName(), intent, "15");
                    a();
                }
            } catch (is e2) {
                e = e2;
                enVar = en.a(this.f145a);
                str3 = this.f145a.getPackageName();
                str2 = "16";
                enVar.a(str3, intent, str2);
                b.a(e);
                return null;
            } catch (Exception e3) {
                e = e3;
                enVar = en.a(this.f145a);
                str3 = this.f145a.getPackageName();
                str2 = "17";
                enVar.a(str3, intent, str2);
                b.a(e);
                return null;
            }
        } else if ("com.xiaomi.mipush.ERROR".equals(action)) {
            MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
            hy hyVar2 = new hy();
            try {
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra2 != null) {
                    im.a(hyVar2, byteArrayExtra2);
                }
            } catch (is unused) {
            }
            miPushCommandMessage.setCommand(String.valueOf(hyVar2.a()));
            miPushCommandMessage.setResultCode((long) intent.getIntExtra("mipush_error_code", 0));
            miPushCommandMessage.setReason(intent.getStringExtra("mipush_error_msg"));
            b.d("receive a error message. code = " + intent.getIntExtra("mipush_error_code", 0) + ", msg= " + intent.getStringExtra("mipush_error_msg"));
            return miPushCommandMessage;
        } else if ("com.xiaomi.mipush.MESSAGE_ARRIVED".equals(action)) {
            byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra3 == null) {
                b.d("message arrived: receiving an empty message, drop");
                return null;
            }
            hy hyVar3 = new hy();
            try {
                im.a(hyVar3, byteArrayExtra3);
                b a5 = b.m75a(this.f145a);
                if (ab.m607a(hyVar3)) {
                    str = "message arrived: receive ignore reg message, ignore!";
                } else if (!a5.m84c()) {
                    str = "message arrived: receive message without registration. need unregister or re-register!";
                } else if (!a5.m84c() || !a5.m86e()) {
                    return a(hyVar3, byteArrayExtra3);
                } else {
                    str = "message arrived: app info is invalidated";
                }
                b.d(str);
            } catch (Exception e4) {
                b.d("fail to deal with arrived message. " + e4);
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
