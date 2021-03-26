package com.huawei.hms.stats;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ab {
    private String a;
    private String b;
    private String c;
    private List<w> d;
    private String e;

    public ab(String str, String str2, String str3, List<w> list, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = list;
        this.e = str4;
    }

    private String a(String str, String str2) {
        String str3;
        String c2 = c.c(str, str2);
        if (TextUtils.isEmpty(c2)) {
            af.a("DataReportHandler", "No report address,TAG : %s,TYPE: %s ", str, str2);
            return "";
        }
        if ("oper".equals(str2)) {
            str3 = "{url}/common/hmshioperqrt";
        } else if ("maint".equals(str2)) {
            str3 = "{url}/common/hmshimaintqrt";
        } else if (!"diffprivacy".equals(str2)) {
            return "";
        } else {
            str3 = "{url}/common/common2";
        }
        return str3.replace("{url}", c2);
    }

    private byte[] a(x xVar) {
        String str;
        try {
            JSONObject c2 = xVar.c();
            if (c2 != null) {
                return ba.a(c2.toString().getBytes("UTF-8"));
            }
            af.c("DataReportHandler", "uploadEvents is null");
            return new byte[0];
        } catch (JSONException unused) {
            str = "uploadEvents to json error";
            af.c("DataReportHandler", str);
            return new byte[0];
        } catch (UnsupportedEncodingException unused2) {
            str = "sendData(): getBytes - Unsupported coding format!!";
            af.c("DataReportHandler", str);
            return new byte[0];
        }
    }

    private JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        for (w wVar : this.d) {
            try {
                jSONArray.put(wVar.d());
            } catch (JSONException unused) {
                af.b("DataReportHandler", "handleEvents: json error,Abandon this data");
            }
        }
        return jSONArray;
    }

    private void c() {
        if (ay.a(b.j(), "backup_event", 5242880)) {
            af.b("DataReportHandler", "backup file reach max limited size, discard new event ");
            return;
        }
        JSONArray b2 = b();
        String a2 = bb.a(this.a, this.b, this.e);
        af.b("DataReportHandler", "Update data cached into backup,spKey: " + a2);
        ap.a(b.j(), "backup_event", a2, b2.toString());
    }

    private x d() {
        return bk.a(this.d, this.a, this.b, this.e, this.c);
    }

    public void a() {
        aw awVar;
        av avVar;
        String str;
        String a2 = a(this.a, this.b);
        if (!TextUtils.isEmpty(a2) || "preins".equals(this.b)) {
            if (!"_hms_config_tag".equals(this.a) && !"_openness_config_tag".equals(this.a)) {
                c();
            }
            x d2 = d();
            if (d2 != null) {
                byte[] a3 = a(d2);
                if (a3.length == 0) {
                    str = "request body is empty";
                } else {
                    avVar = new ar(a3, a2, this.a, this.b, this.e, this.d);
                    awVar = aw.b();
                }
            } else {
                avVar = new au(this.d, this.a, this.e, this.b);
                awVar = aw.a();
            }
            awVar.a(avVar);
            return;
        }
        str = "collectUrl is empty";
        af.c("DataReportHandler", str);
    }
}
