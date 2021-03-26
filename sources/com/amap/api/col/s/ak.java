package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ShareUrlSearchHandler */
public final class ak extends a<String, String> {
    private String j;

    @Override // com.amap.api.col.s.a
    protected final String a() {
        return null;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.amap.api.col.s.a
    protected final /* synthetic */ String a(String str) throws AMapException {
        return b(str);
    }

    public ak(Context context, String str) {
        super(context, str);
        this.j = str;
    }

    @Override // com.amap.api.col.s.a, com.amap.api.col.s.cy
    public final Map<String, String> e() {
        byte[] bArr;
        StringBuilder sb = new StringBuilder();
        sb.append("channel=open_api&flag=1");
        sb.append("&address=" + URLEncoder.encode(this.j));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("open_api1");
        stringBuffer.append(this.j);
        stringBuffer.append("@8UbJH6N2szojnTHONAWzB6K7N1kaj7Y0iUMarxac");
        String a = bq.a(stringBuffer.toString());
        sb.append("&sign=");
        sb.append(a.toUpperCase(Locale.US));
        sb.append("&output=json");
        try {
            bArr = at.a(sb.toString().getBytes("utf-8"), "Yaynpa84IKOfasFx".getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            i.a(e, "ShareUrlSearchHandler", "getParams");
            bArr = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ent", "2");
        hashMap.put("in", bn.b(bArr));
        hashMap.put("keyt", "openapi");
        return hashMap;
    }

    private static String b(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String a = p.a(jSONObject, "code");
            String a2 = p.a(jSONObject, "message");
            if ("1".equals(a)) {
                return p.a(jSONObject, "transfer_url");
            }
            if ("0".equals(a)) {
                throw new AMapException("其他未知错误", 0, a2);
            } else if ("2".equals(a)) {
                throw new AMapException("短串请求失败", 0, a2);
            } else if ("3".equals(a)) {
                throw new AMapException("请求参数非法", 0, a2);
            } else if ("4".equals(a)) {
                throw new AMapException("用户签名未通过", 0, a2);
            } else if (!"5".equals(a)) {
                return null;
            } else {
                throw new AMapException("短串分享认证失败", 0, a2);
            }
        } catch (JSONException e) {
            i.a(e, "ShareUrlSearchHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        return h.e();
    }
}
