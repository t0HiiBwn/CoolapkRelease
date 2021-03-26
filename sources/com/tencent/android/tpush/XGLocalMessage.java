package com.tencent.android.tpush;

import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.logging.TLogger;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class XGLocalMessage {
    private long A = (System.currentTimeMillis() + (((long) this.z) * 1000));
    private int B = 0;
    private int C = 2;
    private String D = "";
    private int a = 1;
    private String b = "";
    private String c = "";
    private String d = "";
    private String e = "00";
    private String f = "00";
    private int g = 1;
    private int h = 1;
    private int i = 1;
    private int j = 0;
    private int k = 1;
    private String l = "";
    private String m = "";
    private String n = "";
    public String nGroupId = "";
    private int o = 1;
    private String p = "";
    public int pushChannel = 99;
    public long pushTime = 0;
    private String q = "";
    private String r = "";
    private String s = "";
    public long source = 0;
    private String t = "";
    public long targetType = 0;
    private String u = "{}";
    private long v;
    private int w = 0;
    private long x = (System.currentTimeMillis() * -1);
    private long y = 0;
    private int z = 2592000;

    public long getExpirationTimeMs() {
        return this.A;
    }

    public void setColor(int i2) {
        this.B = i2;
    }

    public int getColor() {
        return this.B;
    }

    public void setExpirationTimeMs(long j2) {
        if (j2 > System.currentTimeMillis()) {
            int currentTimeMillis = (int) ((j2 - System.currentTimeMillis()) / 1000);
            this.z = currentTimeMillis;
            if (currentTimeMillis < 0) {
                this.z = Integer.MAX_VALUE;
            }
            this.A = j2;
        }
    }

    public int getNsModel() {
        return this.C;
    }

    public int getTtl() {
        return this.z;
    }

    public int getType() {
        return this.a;
    }

    public void setType(int i2) {
        this.a = i2;
    }

    public String getTitle() {
        return this.b;
    }

    public void setTitle(String str) {
        this.b = str;
    }

    public String getContent() {
        return this.c;
    }

    public void setContent(String str) {
        this.c = str;
    }

    public void setNsModel(int i2) {
        this.C = i2;
    }

    public void setCustomContent(HashMap<String, Object> hashMap) {
        this.u = new JSONObject(hashMap).toString();
    }

    public String getCustom_content() {
        return this.u;
    }

    public String getHour() {
        if (this.e.length() < 1) {
            return "00";
        }
        if (this.e.length() <= 0 || this.e.length() >= 2) {
            return this.e;
        }
        return "0" + this.e;
    }

    public void setHour(String str) {
        this.e = str;
    }

    public String getMin() {
        if (this.f.length() < 1) {
            return "00";
        }
        if (this.f.length() <= 0 || this.f.length() >= 2) {
            return this.f;
        }
        return "0" + this.f;
    }

    public void setMin(String str) {
        this.f = str;
    }

    public long getBuilderId() {
        return this.v;
    }

    public void setBuilderId(long j2) {
        this.v = j2;
    }

    public String getDate() {
        if (!j.b(this.d)) {
            try {
                String substring = this.d.substring(0, 8);
                this.d = substring;
                Long.parseLong(substring);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                simpleDateFormat.setLenient(false);
                simpleDateFormat.parse(this.d);
            } catch (ParseException e2) {
                TLogger.e("XGLocalMessage", "XGLocalMessage.getDate()", e2);
                return new SimpleDateFormat("yyyyMMdd").format(new Date());
            } catch (Throwable th) {
                TLogger.e("XGLocalMessage", "XGLocalMessage.getDate()", th);
                return new SimpleDateFormat("yyyyMMdd").format(new Date());
            }
        }
        return this.d;
    }

    public void setDate(String str) {
        this.d = str;
    }

    public void setRing(int i2) {
        this.g = i2;
    }

    public int getRing() {
        return this.g;
    }

    public void setVibrate(int i2) {
        this.h = i2;
    }

    public int getVibrate() {
        return this.h;
    }

    public void setLights(int i2) {
        this.i = i2;
    }

    public int getLights() {
        return this.i;
    }

    public void setIcon_type(int i2) {
        this.j = i2;
    }

    public int getIcon_type() {
        return this.j;
    }

    public void setStyle_id(int i2) {
        this.k = i2;
    }

    public int getStyle_id() {
        return this.k;
    }

    public void setRing_raw(String str) {
        this.l = str;
    }

    public String getRing_raw() {
        return this.l;
    }

    public void setIcon_res(String str) {
        this.m = str;
    }

    public String getIcon_res() {
        return this.m;
    }

    public void setTpns_media_resources(String str) {
        this.D = str;
    }

    public String getTpns_media_resources() {
        return this.D;
    }

    public void setSmall_icon(String str) {
        this.n = str;
    }

    public String getSmall_icon() {
        return this.n;
    }

    public void setAction_type(int i2) {
        this.o = i2;
    }

    public int getAction_type() {
        return this.o;
    }

    public void setActivity(String str) {
        this.p = str;
    }

    public String getActivity() {
        return this.p;
    }

    public void setUrl(String str) {
        this.q = str;
    }

    public String getUrl() {
        return this.q;
    }

    public void setIntent(String str) {
        String str2;
        try {
            str2 = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            str2 = "";
        }
        this.r = str2;
    }

    public String getIntent() {
        return this.r;
    }

    public void setPackageDownloadUrl(String str) {
        this.s = str;
    }

    public String getPackageDownloadUrl() {
        return this.s;
    }

    public void setPackageName(String str) {
        this.t = str;
    }

    public String getPackageName() {
        return this.t;
    }

    public int getNotificationId() {
        return this.w;
    }

    public void setNotificationId(int i2) {
        this.w = i2;
    }

    public long getMsgId() {
        return this.x;
    }

    public void setMsgId(long j2) {
        this.x = j2;
    }

    public long getBusiMsgId() {
        return this.y;
    }

    public void setBusiMsgId(long j2) {
        this.y = j2;
    }

    public String toString() {
        return "XGLocalMessage [type=" + this.a + ", title=" + this.b + ", content=" + this.c + ", date=" + this.d + ", hour=" + this.e + ", min=" + this.f + ", builderId=" + this.v + ", msgid=" + this.x + ", busiMsgId=" + this.y + "]";
    }
}
