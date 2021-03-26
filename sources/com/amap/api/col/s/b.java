package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BasicLBSRestHandler */
public abstract class b<T, V> extends a<T, V> {
    @Override // com.amap.api.col.s.a
    protected abstract V a(String str) throws AMapException;

    @Override // com.amap.api.col.s.a
    protected abstract String a();

    @Override // com.amap.api.col.s.a, com.amap.api.col.s.cy
    public Map<String, String> e() {
        return null;
    }

    public b(Context context, T t) {
        super(context, t);
    }

    @Override // com.amap.api.col.s.cy
    public byte[] g() {
        try {
            String a = a();
            StringBuffer stringBuffer = new StringBuffer();
            if (a != null) {
                stringBuffer.append(a);
                stringBuffer.append("&");
            }
            stringBuffer.append("language=");
            stringBuffer.append(ServiceSettings.getInstance().getLanguage());
            String stringBuffer2 = stringBuffer.toString();
            String c = c(stringBuffer2);
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(stringBuffer2);
            String a2 = bl.a();
            stringBuffer3.append("&ts=".concat(String.valueOf(a2)));
            stringBuffer3.append("&scode=" + bl.a(this.e, a2, c));
            return stringBuffer3.toString().getBytes("utf-8");
        } catch (Throwable th) {
            i.a(th, "ProtocalHandler", "getEntity");
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.HashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.a, com.amap.api.col.s.cy
    public Map<String, String> f() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Search 7.7.0");
        hashMap.put("X-INFO", bl.a(this.e));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "7.7.0", "sea"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    private static String c(String str) {
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            stringBuffer.append(d(str2));
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
    }

    protected static String b(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            i.a(e, "ProtocalHandler", "strEncoderUnsupportedEncodingException");
            return "";
        } catch (Exception e2) {
            i.a(e2, "ProtocalHandler", "strEncoderException");
            return "";
        }
    }

    private static String d(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            i.a(e, "ProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e2) {
            i.a(e2, "ProtocalHandler", "strReEncoderException");
            return "";
        }
    }
}
