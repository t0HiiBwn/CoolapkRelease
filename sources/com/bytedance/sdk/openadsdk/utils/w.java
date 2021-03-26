package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: MimeDetector */
public class w {
    private static volatile w c;
    private Map<String, String> a;
    private volatile boolean b = false;
    private Context d;

    public static String a(Context context, String str) {
        if (str != null) {
            try {
                if (str.startsWith("http") && str.contains("?")) {
                    str = str.split("\\?")[0];
                    if (str.endsWith("/")) {
                        str = str.substring(0, str.length() - 1);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return a(context).a(str);
    }

    static w a(Context context) {
        if (c == null) {
            synchronized (w.class) {
                if (c == null) {
                    c = new w(context);
                }
            }
        }
        return c;
    }

    private w(Context context) {
        if (context != null && this.d == null) {
            this.d = context.getApplicationContext();
            a();
        }
        this.d = context;
    }

    public final String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String d2 = d(str);
        if (TextUtils.isEmpty(d2)) {
            return null;
        }
        return b(d2);
    }

    private static String b(String str) {
        String str2;
        int indexOf = str.indexOf(47);
        int indexOf2 = str.indexOf(59);
        if (indexOf < 0) {
            return null;
        }
        String lowerCase = str.substring(0, indexOf).trim().toLowerCase(Locale.ENGLISH);
        if (!c(lowerCase)) {
            return null;
        }
        int i = indexOf + 1;
        if (indexOf2 < 0) {
            str2 = str.substring(i);
        } else {
            str2 = str.substring(i, indexOf2);
        }
        String lowerCase2 = str2.trim().toLowerCase(Locale.ENGLISH);
        if (!c(lowerCase2)) {
            return null;
        }
        StringBuilder sb = new StringBuilder(lowerCase.length() + lowerCase2.length() + 1);
        sb.append(lowerCase);
        sb.append('/');
        sb.append(lowerCase2);
        return sb.toString();
    }

    private static boolean a(char c2) {
        return c2 > ' ' && c2 < 127 && "()<>@,;:/[]?=\\\"".indexOf(c2) < 0;
    }

    private static boolean c(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (!a(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private String d(String str) {
        String str2;
        String e = e(str);
        if (e.isEmpty()) {
            return null;
        }
        a();
        Map<String, String> map = this.a;
        if (map == null || map.isEmpty()) {
            return null;
        }
        do {
            str2 = this.a.get(e);
            if (str2 == null) {
                e = e(e);
            }
            if (str2 != null) {
                break;
            }
        } while (!e.isEmpty());
        return str2;
    }

    private static String e(String str) {
        int indexOf;
        return (str == null || str.isEmpty() || (indexOf = str.indexOf(46)) < 0 || indexOf >= str.length() + -1) ? "" : str.substring(indexOf + 1);
    }

    private void a() {
        if (this.d != null && !this.b) {
            synchronized (this) {
                if (!this.b) {
                    List list = (List) AccessController.doPrivileged(new PrivilegedAction<List<String>>() {
                        /* class com.bytedance.sdk.openadsdk.utils.w.AnonymousClass1 */

                        /* JADX WARNING: Removed duplicated region for block: B:28:0x0043 A[SYNTHETIC, Splitter:B:28:0x0043] */
                        /* JADX WARNING: Removed duplicated region for block: B:32:0x004a A[SYNTHETIC, Splitter:B:32:0x004a] */
                        /* renamed from: a */
                        public List<String> run() {
                            BufferedReader bufferedReader;
                            InputStream inputStream = null;
                            try {
                                ArrayList arrayList = new ArrayList();
                                InputStream open = w.this.d.getAssets().open("tt_mime_type.pro");
                                try {
                                    bufferedReader = new BufferedReader(new InputStreamReader(open));
                                    while (true) {
                                        try {
                                            String readLine = bufferedReader.readLine();
                                            if (readLine == null) {
                                                break;
                                            } else if (!TextUtils.isEmpty(readLine)) {
                                                arrayList.add(readLine);
                                            }
                                        } catch (Throwable unused) {
                                            inputStream = open;
                                            try {
                                                List<String> emptyList = Collections.emptyList();
                                                if (inputStream != null) {
                                                }
                                                if (bufferedReader != null) {
                                                }
                                                return emptyList;
                                            } catch (Throwable unused2) {
                                            }
                                        }
                                    }
                                    if (open != null) {
                                        try {
                                            open.close();
                                        } catch (Throwable unused3) {
                                        }
                                    }
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable unused4) {
                                    }
                                    return arrayList;
                                } catch (Throwable unused5) {
                                    bufferedReader = null;
                                    inputStream = open;
                                    List<String> emptyList = Collections.emptyList();
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable unused6) {
                                        }
                                    }
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Throwable unused7) {
                                        }
                                    }
                                    return emptyList;
                                }
                            } catch (Throwable unused8) {
                                bufferedReader = null;
                                List<String> emptyList = Collections.emptyList();
                                if (inputStream != null) {
                                }
                                if (bufferedReader != null) {
                                }
                                return emptyList;
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th;
                            throw th;
                        }
                    });
                    this.a = new HashMap(list.size());
                    String str = "";
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        String str2 = str + ((String) it2.next());
                        if (str2.endsWith("\\")) {
                            str = str2.substring(0, str2.length() - 1);
                        } else {
                            f(str2);
                            str = "";
                        }
                    }
                    if (!str.isEmpty()) {
                        f(str);
                    }
                    this.b = true;
                }
            }
        }
    }

    private void f(String str) {
        String trim = str.trim();
        if (!trim.isEmpty()) {
            if (trim.charAt(0) != '#') {
                String replaceAll = trim.replaceAll("\\s*#.*", "");
                if (replaceAll.indexOf(61) > 0) {
                    Matcher matcher = Pattern.compile("\\btype=(\"\\p{Graph}+?/\\p{Graph}+?\"|\\p{Graph}+/\\p{Graph}+\\b)").matcher(replaceAll);
                    if (matcher.find()) {
                        String substring = matcher.group().substring(5);
                        if (substring.charAt(0) == '\"') {
                            substring = substring.substring(1, substring.length() - 1);
                        }
                        Matcher matcher2 = Pattern.compile("\\bexts=(\"[\\p{Graph}|\\p{Blank}]+?\"|\\p{Graph}+\\b)").matcher(replaceAll);
                        if (matcher2.find()) {
                            String substring2 = matcher2.group().substring(5);
                            if (substring2.charAt(0) == '\"') {
                                substring2 = substring2.substring(1, substring2.length() - 1);
                            }
                            for (String str2 : substring2.split("[\\p{Blank}|\\p{Punct}]+")) {
                                a(str2, substring);
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                String[] split = replaceAll.split("\\s+");
                for (int i = 1; i < split.length; i++) {
                    a(split[i], split[0]);
                }
            }
        }
    }

    private void a(String str, String str2) {
        if (str != null && !str.isEmpty() && str2 != null && !str2.isEmpty() && !this.a.containsKey(str)) {
            this.a.put(str, str2);
        }
    }
}
