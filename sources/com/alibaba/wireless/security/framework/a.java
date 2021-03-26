package com.alibaba.wireless.security.framework;

import android.content.pm.PackageInfo;
import com.alibaba.wireless.security.framework.utils.b;
import java.io.File;
import org.json.JSONObject;

public class a {
    public PackageInfo a = null;
    private JSONObject b = null;
    private String c;

    public a(String str) {
        this.c = str;
    }

    public String a(String str) {
        try {
            return b().getString(str);
        } catch (Exception unused) {
            return "";
        }
    }

    public boolean a() {
        try {
            return new File(this.c).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0089 A[SYNTHETIC, Splitter:B:18:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0098 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    public boolean a(PackageInfo packageInfo, String str) {
        File file;
        if (packageInfo == null || str == null) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", packageInfo.versionName);
            jSONObject.put("hasso", packageInfo.applicationInfo.metaData.getBoolean("hasso", false));
            jSONObject.put("pluginname", packageInfo.applicationInfo.metaData.getString("pluginname"));
            jSONObject.put("pluginclass", packageInfo.applicationInfo.metaData.getString("pluginclass"));
            jSONObject.put("dependencies", packageInfo.applicationInfo.metaData.getString("dependencies"));
            jSONObject.put("weakdependencies", packageInfo.applicationInfo.metaData.getString("weakdependencies"));
            jSONObject.put("reversedependencies", packageInfo.applicationInfo.metaData.getString("reversedependencies"));
            jSONObject.put("thirdpartyso", packageInfo.applicationInfo.metaData.getBoolean("thirdpartyso"));
            File file2 = null;
            try {
                file = new File(this.c);
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                } catch (Exception unused) {
                    file2 = file;
                    if (!file2.exists()) {
                    }
                    file = file2;
                    if (b.a(file, jSONObject.toString())) {
                    }
                }
            } catch (Exception unused2) {
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                    } catch (Exception unused3) {
                    }
                }
                file = file2;
                if (b.a(file, jSONObject.toString())) {
                }
            }
            return b.a(file, jSONObject.toString());
        } catch (Exception unused4) {
        }
    }

    public JSONObject b() {
        JSONObject jSONObject = this.b;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = null;
        try {
            String a2 = b.a(new File(this.c));
            if (a2 != null && a2.length() > 0) {
                jSONObject2 = new JSONObject(a2);
            }
        } catch (Exception unused) {
        }
        this.b = jSONObject2;
        return jSONObject2;
    }
}
