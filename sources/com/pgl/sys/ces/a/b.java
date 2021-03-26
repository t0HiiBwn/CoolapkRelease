package com.pgl.sys.ces.a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class b {
    private static final FileFilter a = new FileFilter() {
        /* class com.pgl.sys.ces.a.b.AnonymousClass1 */

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    };

    public static String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap<String, String> b = b();
            jSONObject.put("core", c());
            jSONObject.put("hw", a(b, "Hardware"));
            jSONObject.put("max", a("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"));
            jSONObject.put("min", a("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"));
            jSONObject.put("ft", a(b, "Features"));
        } catch (Throwable unused) {
        }
        String jSONObject2 = jSONObject.toString();
        return jSONObject2 == null ? "{}" : jSONObject2.trim();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0025, code lost:
        if (r1 == null) goto L_0x0028;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0020 A[SYNTHETIC, Splitter:B:19:0x0020] */
    private static String a(String str) {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String str2 = null;
        try {
            fileReader = new FileReader(str);
            try {
                bufferedReader = new BufferedReader(fileReader);
            } catch (Throwable unused) {
                bufferedReader = null;
                if (bufferedReader != null) {
                }
            }
            try {
                str2 = bufferedReader.readLine();
                try {
                    bufferedReader.close();
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused4) {
                    }
                }
            }
        } catch (Throwable unused5) {
            bufferedReader = null;
            fileReader = null;
            if (bufferedReader != null) {
            }
        }
        try {
            fileReader.close();
        } catch (Throwable unused6) {
        }
        return str2 == null ? "0" : str2.trim();
    }

    private static String a(HashMap<String, String> hashMap, String str) {
        String str2;
        try {
            str2 = hashMap.get(str);
        } catch (Throwable unused) {
            str2 = null;
        }
        return str2 == null ? "" : str2.trim();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004f, code lost:
        if (r2 == null) goto L_0x0052;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004a A[SYNTHETIC, Splitter:B:24:0x004a] */
    private static HashMap<String, String> b() {
        FileReader fileReader;
        HashMap<String, String> hashMap = new HashMap<>();
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("/proc/cpuinfo");
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader);
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            try {
                                break;
                            } catch (Throwable unused) {
                            }
                        } else {
                            String[] split = readLine.split(":", 2);
                            if (split.length >= 2) {
                                String trim = split[0].trim();
                                String trim2 = split[1].trim();
                                if (hashMap.get(trim) == null) {
                                    hashMap.put(trim, trim2);
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable unused3) {
                            }
                        }
                    }
                }
                bufferedReader2.close();
            } catch (Throwable unused4) {
                if (bufferedReader != null) {
                }
            }
        } catch (Throwable unused5) {
            fileReader = null;
            if (bufferedReader != null) {
            }
        }
        try {
            fileReader.close();
        } catch (Throwable unused6) {
        }
        return hashMap;
    }

    private static int c() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(a).length;
        } catch (Throwable unused) {
            return -1;
        }
    }
}
