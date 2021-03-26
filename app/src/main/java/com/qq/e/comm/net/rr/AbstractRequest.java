package com.qq.e.comm.net.rr;

import android.net.Uri;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.util.StringUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractRequest implements Request {
    private boolean a = true;
    private int b;
    private int c;
    private int d;
    private String e;
    private Map<String, String> f = new HashMap();
    private Map<String, String> g = new HashMap();
    private Map<String, String> h = Collections.unmodifiableMap(this.f);
    private Map<String, String> i = Collections.unmodifiableMap(this.g);
    private Request.Method j;
    private byte[] k;

    public AbstractRequest(String str, Request.Method method, byte[] bArr) {
        this.e = str;
        this.j = method;
        this.k = bArr == null ? null : (byte[]) bArr.clone();
    }

    public AbstractRequest(String str, Map<String, String> map, Request.Method method) {
        this.e = str;
        this.j = method;
        if (Request.Method.POST == method) {
            StringBuilder sb = new StringBuilder();
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String encode = URLEncoder.encode(entry.getKey(), "utf-8");
                    String encode2 = URLEncoder.encode(entry.getValue(), "utf-8");
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append(encode);
                    sb.append("=");
                    sb.append(encode2);
                }
                if (sb.length() > 0) {
                    this.k = sb.toString().getBytes("utf-8");
                    addHeader("Content-Type", "application/x-www-form-urlencoded");
                }
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
    }

    @Override // com.qq.e.comm.net.rr.Request
    public void addHeader(String str, String str2) {
        if (!StringUtil.isEmpty(str) && !StringUtil.isEmpty(str2)) {
            this.f.put(str, str2);
        }
    }

    @Override // com.qq.e.comm.net.rr.Request
    public void addQuery(String str, String str2) {
        this.g.put(str, str2);
    }

    @Override // com.qq.e.comm.net.rr.Request
    public int getConnectionTimeOut() {
        return this.c;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public Map<String, String> getHeaders() {
        return this.h;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public Request.Method getMethod() {
        return this.j;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public byte[] getPostData() throws Exception {
        return this.k;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public int getPriority() {
        return this.b;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public Map<String, String> getQuerys() {
        return this.i;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public int getSocketTimeOut() {
        return this.d;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public String getUrl() {
        return this.e;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public String getUrlWithParas() {
        if (getQuerys().isEmpty()) {
            return getUrl();
        }
        Uri.Builder buildUpon = Uri.parse(getUrl()).buildUpon();
        for (Map.Entry<String, String> entry : getQuerys().entrySet()) {
            buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return buildUpon.build().toString();
    }

    @Override // com.qq.e.comm.net.rr.Request
    public boolean isAutoClose() {
        return this.a;
    }

    public void setAutoClose(boolean z) {
        this.a = z;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public void setConnectionTimeOut(int i2) {
        this.c = i2;
    }

    public void setPriority(int i2) {
        this.b = i2;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public void setSocketTimeOut(int i2) {
        this.d = i2;
    }
}
