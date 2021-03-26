package com.bytedance.embedapplog;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.embedapplog.util.UriConfig;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ao {
    public static JSONObject a;
    static final String[] b = {"aid", "version_code", "ab_client", "ab_version", "ab_feature", "ab_group", "iid", "device_platform"};
    public static final String[] c = {"tt_data", "device_platform"};
    private static final String[] d = {"GET", "POST"};
    private static final String[] e = {"aid", "app_version", "tt_data"};
    private static UriConfig f = UriConfig.creatUriConfig(0);

    private static String a(String str) {
        if (TextUtils.isEmpty(str) || !AppLog.getEncryptAndCompress()) {
            return str;
        }
        Uri parse = Uri.parse(str);
        String query = parse.getQuery();
        ArrayList<Pair> arrayList = new ArrayList();
        String[] strArr = e;
        for (String str2 : strArr) {
            String queryParameter = parse.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                arrayList.add(new Pair(str2, queryParameter));
            }
        }
        Uri.Builder buildUpon = parse.buildUpon();
        buildUpon.clearQuery();
        for (Pair pair : arrayList) {
            buildUpon.appendQueryParameter((String) pair.first, (String) pair.second);
        }
        buildUpon.appendQueryParameter("tt_info", new String(Base64.encode(AppLog.toEncryptByte(query), 8)));
        return buildUpon.build().toString();
    }

    public static String a(String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri parse = Uri.parse(str);
        HashMap hashMap = new HashMap(strArr.length);
        for (String str2 : strArr) {
            String queryParameter = parse.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                hashMap.put(str2, queryParameter);
            }
        }
        Uri.Builder buildUpon = parse.buildUpon();
        buildUpon.clearQuery();
        for (String str3 : hashMap.keySet()) {
            buildUpon.appendQueryParameter(str3, (String) hashMap.get(str3));
        }
        return buildUpon.build().toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:87:0x01d5 A[SYNTHETIC, Splitter:B:87:0x01d5] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01dc A[SYNTHETIC, Splitter:B:91:0x01dc] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01e4  */
    public static String a(int i, String str, HashMap<String, String> hashMap, byte[] bArr) {
        String str2;
        String str3;
        BufferedReader bufferedReader;
        DataOutputStream dataOutputStream;
        Throwable th;
        DataOutputStream dataOutputStream2;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        String str4;
        if (bo.b) {
            bo.a("http: " + str, null);
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                        bo.a("http headers key:" + entry.getKey() + " value:" + entry.getValue(), null);
                    }
                }
            }
            if (bArr != null) {
                bo.a("http data length:" + bArr.length, null);
            }
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (i == 0) {
                httpURLConnection.setDoOutput(false);
            } else if (i == 1) {
                httpURLConnection.setDoOutput(true);
            } else {
                bo.a(null);
            }
            httpURLConnection.setRequestMethod(d[i]);
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Map.Entry<String, String> entry2 : hashMap.entrySet()) {
                    if (TextUtils.isEmpty(entry2.getKey()) || TextUtils.isEmpty(entry2.getValue())) {
                        bo.a(null);
                    } else {
                        httpURLConnection.addRequestProperty(entry2.getKey(), entry2.getValue());
                    }
                }
            }
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            if (bArr == null || bArr.length <= 0) {
                dataOutputStream2 = null;
            } else {
                dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream2.write(bArr);
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                } catch (Throwable th2) {
                    bufferedReader = null;
                    str3 = null;
                    dataOutputStream = dataOutputStream2;
                    th = th2;
                    try {
                        bo.a(th);
                        str2 = str3;
                        if (bo.b) {
                        }
                        return str2;
                    } finally {
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused2) {
                            }
                        }
                    }
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                String jSONObject = new JSONObject().put("http_code", responseCode).toString();
                try {
                    new RuntimeException("HttpCode:" + responseCode).printStackTrace();
                    str2 = jSONObject;
                    bufferedReader2 = null;
                } catch (Throwable th3) {
                    str3 = jSONObject;
                    dataOutputStream = dataOutputStream2;
                    th = th3;
                    bufferedReader = null;
                    bo.a(th);
                    str2 = str3;
                    if (bo.b) {
                    }
                    return str2;
                }
            } else if (httpURLConnection.getContentLength() < 10240) {
                InputStream inputStream = httpURLConnection.getInputStream();
                if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                    bufferedReader2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(inputStream)));
                } else {
                    bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
                }
                try {
                    StringBuilder sb = new StringBuilder(inputStream.available());
                    while (true) {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append("\n");
                    }
                    try {
                        JSONObject jSONObject2 = new JSONObject(sb.toString());
                        jSONObject2.put("http_code", 200);
                        str2 = jSONObject2.toString();
                    } catch (Throwable th4) {
                        bufferedReader3 = bufferedReader2;
                        dataOutputStream = dataOutputStream2;
                        th = th4;
                        str3 = str4;
                    }
                } catch (Throwable th5) {
                    str3 = null;
                    bufferedReader3 = bufferedReader2;
                    dataOutputStream = dataOutputStream2;
                    th = th5;
                    bufferedReader = bufferedReader3;
                    bo.a(th);
                    str2 = str3;
                    if (bo.b) {
                    }
                    return str2;
                }
            } else {
                bo.a(null);
                bufferedReader2 = null;
                str2 = null;
            }
            if (dataOutputStream2 != null) {
                try {
                    dataOutputStream2.close();
                } catch (IOException unused3) {
                }
            }
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException unused4) {
                }
            }
        } catch (Throwable th6) {
            th = th6;
            dataOutputStream = null;
            bufferedReader = null;
            str3 = null;
            bo.a(th);
            str2 = str3;
            if (bo.b) {
            }
            return str2;
        }
        if (bo.b) {
            bo.a("http response: " + str2, null);
        }
        return str2;
    }

    public static void a(int i) {
        f = UriConfig.creatUriConfig(i);
    }

    public static UriConfig a() {
        return f;
    }

    public static JSONObject a(String str, JSONObject jSONObject) {
        HashMap hashMap = new HashMap(2);
        if (AppLog.getEncryptAndCompress()) {
            hashMap.put("Content-Type", "application/octet-stream;tt-data=a");
        } else {
            hashMap.put("Content-Type", "application/json; charset=utf-8");
        }
        String a2 = a(1, a(str), hashMap, AppLog.toEncryptByte(jSONObject.toString()));
        if (a2 == null) {
            return null;
        }
        try {
            return new JSONObject(a2);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean b(String str, JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder(str);
        float rawOffset = (((float) TimeZone.getDefault().getRawOffset()) * 1.0f) / 3600000.0f;
        if (rawOffset < -12.0f) {
            rawOffset = -12.0f;
        }
        if (rawOffset > 12.0f) {
            rawOffset = 12.0f;
        }
        a(sb, "timezone", rawOffset + "");
        JSONArray optJSONArray = jSONObject.optJSONArray("sim_serial_number");
        if (optJSONArray != null) {
            try {
                String optString = ((JSONObject) optJSONArray.get(0)).optString("sim_serial_number");
                for (int i = 1; i < optJSONArray.length(); i++) {
                    optString = optString + "," + ((JSONObject) optJSONArray.get(i)).optString("sim_serial_number");
                }
                a(sb, "sim_serial_number", optString);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        JSONObject jSONObject2 = null;
        String a2 = a(0, a(sb.toString()), null, null);
        if (a2 != null) {
            try {
                jSONObject2 = new JSONObject(a2);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        if (jSONObject2 == null || !"success".equals(jSONObject2.optString("message", ""))) {
            return false;
        }
        return true;
    }

    protected static void a(StringBuilder sb, String str, String str2) {
        if (sb != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (sb.toString().indexOf(63) < 0) {
                sb.append("?");
            } else {
                sb.append("&");
            }
            sb.append(str);
            sb.append("=");
            sb.append(Uri.encode(str2));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0089 A[SYNTHETIC, Splitter:B:32:0x0089] */
    public static int a(String[] strArr, byte[] bArr, z zVar) {
        JSONObject jSONObject;
        int i;
        JSONException e2;
        HashMap hashMap = new HashMap(2);
        if (AppLog.getEncryptAndCompress()) {
            hashMap.put("Content-Type", "application/octet-stream;tt-data=a");
        } else {
            hashMap.put("Content-Type", "application/json; charset=utf-8");
        }
        String str = null;
        for (String str2 : strArr) {
            str = a(1, str2, hashMap, bArr);
            if (!TextUtils.isEmpty(str)) {
                break;
            }
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject(str);
                try {
                    i = jSONObject.optInt("http_code");
                    if (i == 200) {
                        if (!"ss_app_log".equals(jSONObject.optString("magic_tag"))) {
                            i = Integer.valueOf("102").intValue();
                        } else if ("success".equals(jSONObject.optString("message"))) {
                            i = 200;
                        } else {
                            i = Integer.valueOf("101").intValue();
                        }
                    }
                } catch (JSONException e3) {
                    e2 = e3;
                    bo.a(e2);
                    i = 0;
                    if (i == 200) {
                    }
                    return i;
                }
                if (i == 200) {
                    try {
                        long optLong = jSONObject.optLong("server_time");
                        if (optLong > 0) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("server_time", optLong);
                            jSONObject2.put("local_time", System.currentTimeMillis() / 1000);
                            a = jSONObject2;
                        }
                    } catch (Exception e4) {
                        bo.a(e4);
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("blacklist");
                    if (optJSONObject != null) {
                        JSONArray optJSONArray = optJSONObject.optJSONArray("v1");
                        int length = optJSONArray != null ? optJSONArray.length() : 0;
                        HashSet<String> hashSet = new HashSet<>(length);
                        for (int i2 = 0; i2 < length; i2++) {
                            String optString = optJSONArray.optString(i2, null);
                            if (!TextUtils.isEmpty(optString)) {
                                hashSet.add(optString);
                            }
                        }
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("v3");
                        int length2 = optJSONArray2 != null ? optJSONArray2.length() : 0;
                        HashSet<String> hashSet2 = new HashSet<>(length2);
                        for (int i3 = 0; i3 < length2; i3++) {
                            String optString2 = optJSONArray2.optString(i3, null);
                            if (!TextUtils.isEmpty(optString2)) {
                                hashSet2.add(optString2);
                            }
                        }
                        zVar.a(hashSet, hashSet2);
                    }
                }
                return i;
            }
            jSONObject = null;
            i = 0;
            if (i == 200) {
            }
            return i;
        } catch (JSONException e5) {
            e2 = e5;
            jSONObject = null;
            bo.a(e2);
            i = 0;
            if (i == 200) {
            }
            return i;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038 A[RETURN] */
    public static JSONObject c(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        boolean z = true;
        String a2 = a(1, str, null, AppLog.toEncryptByte(jSONObject.toString()));
        if (a2 != null) {
            try {
                jSONObject2 = new JSONObject(a2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (jSONObject2 == null || !"ss_app_log".equals(jSONObject2.optString("magic_tag", ""))) {
                z = false;
            }
            if (!z) {
                return jSONObject2.optJSONObject("config");
            }
            return null;
        }
        jSONObject2 = null;
        z = false;
        if (!z) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038 A[RETURN] */
    public static JSONObject d(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        boolean z = true;
        String a2 = a(1, str, null, AppLog.toEncryptByte(jSONObject.toString()));
        if (a2 != null) {
            try {
                jSONObject2 = new JSONObject(a2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (jSONObject2 == null || !"success".equals(jSONObject2.optString("message", ""))) {
                z = false;
            }
            if (!z) {
                return jSONObject2.optJSONObject("data");
            }
            return null;
        }
        jSONObject2 = null;
        z = false;
        if (!z) {
        }
    }
}
