package com.bytedance.tea.crash.a;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.tea.crash.c.a;
import com.bytedance.tea.crash.e.a.e;
import com.bytedance.tea.crash.g.d;
import com.bytedance.tea.crash.g.f;
import com.bytedance.tea.crash.g.j;
import com.bytedance.tea.crash.g.m;
import com.bytedance.tea.crash.h;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ANRManager */
public class c {
    static volatile boolean a = true;
    private a b;
    private d c;
    private final Context d;
    private volatile long e;
    private volatile boolean f = false;
    private final SharedPreferences g;

    public c(Context context) {
        if (context == null || !(context instanceof Application)) {
            throw new IllegalArgumentException("context must not be null or not application");
        }
        this.d = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("anr_monitor_table", 0);
        this.g = sharedPreferences;
        this.e = sharedPreferences.getLong("trace_anr_happen_time", 0);
        g.a(100, 100);
    }

    public void a() {
        if (!this.f) {
            if (Build.VERSION.SDK_INT < 21) {
                a aVar = new a(this, "/data/anr/", 8);
                this.b = aVar;
                aVar.startWatching();
            } else {
                this.c = new d(this);
            }
            this.f = true;
        }
    }

    boolean a(int i, String str, int i2) {
        JSONObject jSONObject;
        JSONObject a2;
        JSONArray b2 = g.b();
        long uptimeMillis = SystemClock.uptimeMillis();
        JSONObject a3 = g.a(uptimeMillis);
        JSONArray a4 = g.a(100, uptimeMillis);
        try {
            jSONObject = e.a(a);
        } catch (JSONException e2) {
            e2.printStackTrace();
            jSONObject = null;
        }
        String a5 = e.a(this.d, i2);
        if (TextUtils.isEmpty(a5)) {
            return false;
        }
        if (i == 200 && (a2 = a(str, Process.myPid(), this.d.getPackageName())) != null && a2.length() > 0) {
            jSONObject = a2;
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                jSONObject.put("pid", Process.myPid());
                jSONObject.put("package", this.d.getPackageName());
                jSONObject.put("is_remote_process", 0);
                a aVar = new a(new JSONObject());
                aVar.a("data", jSONObject.toString());
                aVar.a("is_anr", (Object) 1);
                aVar.a("timestamp", Long.valueOf(System.currentTimeMillis()));
                aVar.a("event_type", "anr");
                aVar.a("history_message", b2);
                aVar.a("current_message", a3);
                aVar.a("pending_messages", a4);
                aVar.a("anr_time", Long.valueOf(System.currentTimeMillis()));
                aVar.a("crash_time", Long.valueOf(System.currentTimeMillis()));
                aVar.a("anr_info", a5);
                aVar.a("all_thread_stacks", m.a((String) null));
                a a6 = e.a().a(com.bytedance.tea.crash.c.ANR, aVar);
                d.a(this.d, com.bytedance.tea.crash.c.ANR.a(), (String) null);
                com.bytedance.tea.crash.upload.a.a().b(a6.a());
                a(a5);
            } catch (Throwable th) {
                j.b(th);
            }
        }
        return true;
    }

    private static void a(String str) {
        for (com.bytedance.tea.crash.e eVar : h.b().c()) {
            eVar.a(com.bytedance.tea.crash.c.ANR, str, null);
        }
    }

    public JSONObject a(String str, int i, String str2) {
        Throwable th;
        BufferedReader bufferedReader;
        Exception e2;
        int i2;
        BufferedReader bufferedReader2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.canRead()) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                Pattern compile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                Pattern compile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                Pattern compile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                Pattern compile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                boolean z = false;
                Object[] a2 = a(bufferedReader, compile);
                if (a2 == null) {
                    f.a(bufferedReader);
                    return null;
                }
                long parseLong = Long.parseLong(a2[1].toString().split("\\s")[2]);
                long time = simpleDateFormat.parse(a2[1].toString().split("\\s")[4] + " " + a2[1].toString().split("\\s")[5]).getTime();
                Object[] a3 = a(bufferedReader, compile3);
                if (a3 == null) {
                    f.a(bufferedReader);
                    return null;
                }
                String str3 = a3[1].toString().split("\\s")[2];
                if (parseLong != ((long) i) || !str3.equalsIgnoreCase(str2)) {
                    f.a(bufferedReader);
                    return null;
                } else if (this.e == 0 || Math.abs(this.e - time) >= 20000) {
                    this.e = time;
                    SharedPreferences sharedPreferences = this.g;
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putLong("trace_anr_happen_time", this.e).apply();
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("anrTime", time);
                    while (true) {
                        Object[] a4 = a(bufferedReader, compile2, compile4);
                        if (a4 == null || a4[0] != compile4) {
                            break;
                        }
                        String str4 = "";
                        Matcher matcher = Pattern.compile("\".+\"").matcher(a4[1].toString());
                        if (matcher.find()) {
                            str4 = matcher.group().substring(1, matcher.group().length() - 1);
                        }
                        Matcher matcher2 = Pattern.compile("tid=\\d+").matcher(a4[1].toString());
                        if (matcher2.find()) {
                            String group2 = matcher2.group();
                            i2 = Integer.parseInt(group2.substring(group2.indexOf("=") + 1));
                        } else {
                            i2 = -1;
                        }
                        String a5 = a(bufferedReader);
                        if (i2 != -1 && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(a5) && str4.equalsIgnoreCase("main")) {
                            jSONObject.put("mainStackFromTrace", a5);
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        f.a(bufferedReader);
                        return null;
                    }
                    jSONObject.put("thread_number", 1);
                    f.a(bufferedReader);
                    return jSONObject;
                } else {
                    f.a(bufferedReader);
                    return null;
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    e2.printStackTrace();
                    f.a(bufferedReader);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader;
                    f.a(bufferedReader2);
                    throw th;
                }
            }
        } catch (Exception e4) {
            e2 = e4;
            bufferedReader = null;
            e2.printStackTrace();
            f.a(bufferedReader);
            return null;
        } catch (Throwable th3) {
            th = th3;
            f.a(bufferedReader2);
            throw th;
        }
    }

    private Object[] a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        if (bufferedReader != null && patternArr != null && patternArr.length > 0) {
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    int length = patternArr.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            Pattern pattern = patternArr[i];
                            if (pattern.matcher(readLine).matches()) {
                                return new Object[]{pattern, readLine};
                            }
                            i++;
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return null;
    }

    private String a(BufferedReader bufferedReader) throws IOException {
        if (bufferedReader == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.trim().length() <= 0) {
                break;
            }
            sb.append(readLine);
            sb.append("\n");
        }
        return sb.toString();
    }
}
