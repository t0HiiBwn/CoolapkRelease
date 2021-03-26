package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.f.b;
import com.ss.android.socialbase.downloader.g.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* compiled from: VbiDevicePlan */
public class m extends a {
    public m(Context context, a aVar, String str) {
        super(context, aVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        String c = this.b.c("s");
        String a = b.a(this.b.c("bb"), c);
        if (!TextUtils.isEmpty(a) && a.split(",").length == 2) {
            String a2 = b.a(this.b.c("bc"), c);
            if (!TextUtils.isEmpty(a2) && a2.split(",").length == 2) {
                String[] split = a.split(",");
                String[] split2 = a2.split(",");
                String a3 = b.a(this.b.c("bd"), c);
                String a4 = b.a(this.b.c("be"), c);
                String a5 = b.a(this.b.c("bf"), c);
                HashMap hashMap = new HashMap();
                hashMap.put(split[0], split[1]);
                hashMap.put(split2[0], split2[1]);
                hashMap.put(a3, this.c);
                Intent intent = new Intent();
                intent.setAction(a5);
                intent.setData(Uri.parse(a4 + a(hashMap)));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }

    public static String a(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey());
            stringBuffer.append("=");
            stringBuffer.append(URLEncoder.encode(entry.getValue()));
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.endsWith("&") ? stringBuffer2.substring(0, stringBuffer2.length() - 1) : stringBuffer2;
    }
}
