package com.bytedance.tea.crash.g;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.tea.crash.c.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FileUtils */
public class d {
    public static void a(File file, String str, boolean z) throws IOException {
        Throwable th;
        if (!TextUtils.isEmpty(str)) {
            file.getParentFile().mkdirs();
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, z);
                try {
                    fileOutputStream2.write(str.getBytes());
                    fileOutputStream2.flush();
                    f.a(fileOutputStream2);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    f.a(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                f.a(fileOutputStream);
                throw th;
            }
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || !file.delete()) {
            return false;
        }
        return true;
    }

    public static boolean a(File file) {
        return file.exists() && file.delete();
    }

    public static boolean a(File file, boolean z) {
        boolean z2;
        if (!z || file.isFile()) {
            return a(file);
        }
        if (!file.isDirectory()) {
            return true;
        }
        File[] listFiles = file.listFiles();
        int i = 0;
        boolean z3 = true;
        while (listFiles != null && i < listFiles.length) {
            if (listFiles[i].isFile()) {
                z2 = a(listFiles[i]);
            } else {
                z2 = a(listFiles[i], true);
            }
            z3 &= z2;
            i++;
        }
        return z3 & a(file);
    }

    public static String a(String str, String str2) throws IOException {
        Throwable th;
        BufferedReader bufferedReader = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                        if (str2 != null) {
                            sb.append(str2);
                        }
                    } else {
                        f.a(bufferedReader2);
                        return sb.toString();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    f.a(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            f.a(bufferedReader);
            throw th;
        }
    }

    public static String b(String str) throws IOException {
        return a(str, (String) null);
    }

    public static c c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(b(str));
            c cVar = new c();
            cVar.a(jSONObject.optString("url"));
            cVar.a(jSONObject.optJSONObject("body"));
            cVar.b(jSONObject.optString("dump_file"));
            cVar.a(jSONObject.optBoolean("encrypt", false));
            return cVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(File file, String str, String str2, JSONObject jSONObject, boolean z) {
        return a(file, str, str2, jSONObject, null, z);
    }

    public static String a(File file, String str, String str2, JSONObject jSONObject, String str3, boolean z) {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("url", str2);
            jSONObject2.put("body", jSONObject);
            if (str3 == null) {
                str3 = "";
            }
            jSONObject2.put("dump_file", str3);
            jSONObject2.put("encrypt", z);
            a(file2, jSONObject2.toString(), false);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return file2.getAbsolutePath();
    }

    public static void a(Context context, String str, String str2) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            sb.append(" ");
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            sb.append(" ");
            if (str2 == null) {
                str2 = "null";
            }
            sb.append(str2);
            sb.append("\n");
            a(h.b(context), sb.toString(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] d(String str) {
        Throwable th;
        Exception e;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)), 1000);
            try {
                String readLine = bufferedReader.readLine();
                int indexOf = readLine.indexOf(")");
                if (indexOf > 0) {
                    readLine = readLine.substring(indexOf + 2);
                }
                String[] split = readLine.split(" ");
                f.a(bufferedReader);
                return split;
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    f.a(bufferedReader);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader;
                    f.a(bufferedReader2);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
            e.printStackTrace();
            f.a(bufferedReader);
            return null;
        } catch (Throwable th3) {
            th = th3;
            f.a(bufferedReader2);
            throw th;
        }
    }
}
