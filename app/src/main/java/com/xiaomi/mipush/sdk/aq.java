package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ad;
import com.xiaomi.push.ai;
import com.xiaomi.push.bi;
import com.xiaomi.push.hh;
import com.xiaomi.push.ib;
import com.xiaomi.push.service.an;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class aq {
    public static void a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        long j = sharedPreferences.getLong("last_sync_info", -1);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long a = (long) an.a(context).a(hh.SyncInfoFrequency.a(), 1209600);
        if (j != -1) {
            if (Math.abs(currentTimeMillis - j) > a) {
                a(context, true);
            } else {
                return;
            }
        }
        sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
    }

    public static void a(Context context, ib ibVar) {
        b.m41a("need to update local info with: " + ibVar.m481a());
        String str = ibVar.m481a().get("accept_time");
        if (str != null) {
            MiPushClient.removeAcceptTime(context);
            String[] split = str.split("-");
            if (split.length == 2) {
                MiPushClient.addAcceptTime(context, split[0], split[1]);
                if (!"00:00".equals(split[0]) || !"00:00".equals(split[1])) {
                    b.m75a(context).a(false);
                } else {
                    b.m75a(context).a(true);
                }
            }
        }
        String str2 = ibVar.m481a().get("aliases");
        if (str2 != null) {
            MiPushClient.removeAllAliases(context);
            if (!"".equals(str2)) {
                for (String str3 : str2.split(",")) {
                    MiPushClient.addAlias(context, str3);
                }
            }
        }
        String str4 = ibVar.m481a().get("topics");
        if (str4 != null) {
            MiPushClient.removeAllTopics(context);
            if (!"".equals(str4)) {
                for (String str5 : str4.split(",")) {
                    MiPushClient.addTopic(context, str5);
                }
            }
        }
        String str6 = ibVar.m481a().get("user_accounts");
        if (str6 != null) {
            MiPushClient.removeAllAccounts(context);
            if (!"".equals(str6)) {
                for (String str7 : str6.split(",")) {
                    MiPushClient.addAccount(context, str7);
                }
            }
        }
    }

    public static void a(Context context, boolean z) {
        ai.a(context).a(new ar(context, z));
    }

    /* access modifiers changed from: private */
    public static String c(List<String> list) {
        String a = bi.a(d(list));
        return (TextUtils.isEmpty(a) || a.length() <= 4) ? "" : a.substring(0, 4).toLowerCase();
    }

    /* access modifiers changed from: private */
    public static String d(List<String> list) {
        String str = "";
        if (ad.a(list)) {
            return str;
        }
        ArrayList<String> arrayList = new ArrayList(list);
        Collections.sort(arrayList, Collator.getInstance(Locale.CHINA));
        for (String str2 : arrayList) {
            if (!TextUtils.isEmpty(str)) {
                str = str + ",";
            }
            str = str + str2;
        }
        return str;
    }
}
