package com.alibaba.mtl.log.d;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.mtl.log.a.a;
import com.alibaba.mtl.log.model.LogField;
import com.alibaba.mtl.log.sign.BaseRequestAuth;
import com.alibaba.mtl.log.sign.IRequestAuth;
import com.alibaba.mtl.log.sign.SecurityRequestAuth;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: UrlWrapper */
public class t {
    private static final String TAG = "t";

    public static String a(String str, Map<String, Object> map, Map<String, Object> map2) throws Exception {
        String str2;
        String str3 = "";
        if (map2 != null && map2.size() > 0) {
            Set<String> keySet = map2.keySet();
            String[] strArr = new String[keySet.size()];
            keySet.toArray(strArr);
            String[] a = g.a().a(strArr, true);
            for (String str4 : a) {
                str3 = str3 + str4 + j.b((byte[]) map2.get(str4));
            }
        }
        try {
            str2 = a(str, null, null, str3);
        } catch (Throwable unused) {
            str2 = a(a.g(), null, null, str3);
        }
        String str5 = a.N;
        if (TextUtils.isEmpty(str5)) {
            return str2;
        }
        return str2 + "&dk=" + URLEncoder.encode(str5, "UTF-8");
    }

    public static String b(String str, Map<String, Object> map, Map<String, Object> map2) throws Exception {
        if (map == null) {
            new HashMap();
        }
        Context context = com.alibaba.mtl.log.a.getContext();
        String appkey = b.getAppkey();
        String o = b.o();
        if (o == null) {
            o = "";
        }
        String str2 = d.a(context).get(LogField.APPVERSION.toString());
        String str3 = d.a(context).get(LogField.OS.toString());
        String str4 = d.a(context).get(LogField.UTDID.toString());
        String valueOf = String.valueOf(System.currentTimeMillis());
        IRequestAuth a = com.alibaba.mtl.log.a.a();
        String str5 = a instanceof SecurityRequestAuth ? "1" : "0";
        String sign = a.getSign(j.b((appkey + str2 + o + str3 + str4 + "2.6.4.5_for_bc" + valueOf + str5 + map.get("_b01n15") + map.get("_b01na")).getBytes()));
        return str + "?ak=" + appkey + "&av=" + str2 + "&c=" + URLEncoder.encode(o) + "&d=" + str4 + "&sv=2.6.4.5_for_bc&t=" + valueOf + "&is=" + str5 + "&_b01n15=" + map.get("_b01n15") + "&_b01na=" + map.get("_b01na") + "&s=" + sign;
    }

    private static String a(String str, String str2, String str3, String str4) throws Exception {
        String str5;
        String str6;
        String str7;
        Context context = com.alibaba.mtl.log.a.getContext();
        String appkey = b.getAppkey();
        String o = b.o();
        if (o == null) {
            o = "";
        }
        String str8 = d.a(context).get(LogField.APPVERSION.toString());
        String str9 = d.a(context).get(LogField.OS.toString());
        String str10 = d.a(context).get(LogField.UTDID.toString());
        String valueOf = String.valueOf(System.currentTimeMillis());
        IRequestAuth a = com.alibaba.mtl.log.a.a();
        String str11 = "1";
        String str12 = "0";
        if (!(a instanceof SecurityRequestAuth)) {
            if (a instanceof BaseRequestAuth) {
                if (!((BaseRequestAuth) a).isEncode()) {
                    str11 = str12;
                }
                str12 = str11;
                str11 = str12;
            } else {
                str11 = str12;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(appkey);
        sb.append(o);
        sb.append(str8);
        sb.append(str9);
        sb.append("2.6.4.5_for_bc");
        sb.append(str10);
        sb.append(valueOf);
        sb.append("3.0");
        sb.append(str11);
        if (str3 == null) {
            str5 = "";
        } else {
            str5 = str3;
        }
        sb.append(str5);
        if (str4 == null) {
            str6 = "";
        } else {
            str6 = str4;
        }
        sb.append(str6);
        String sign = a.getSign(j.b(sb.toString().getBytes()));
        if (!TextUtils.isEmpty(str2)) {
            str7 = str2 + "&";
        } else {
            str7 = "";
        }
        return String.format("%s?%sak=%s&av=%s&c=%s&v=%s&s=%s&d=%s&sv=%s&p=%s&t=%s&u=%s&is=%s&k=%s", str, str7, d(appkey), d(str8), d(o), d("3.0"), d(sign), d(str10), "2.6.4.5_for_bc", str9, valueOf, "", str11, str12);
    }

    private static String d(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
