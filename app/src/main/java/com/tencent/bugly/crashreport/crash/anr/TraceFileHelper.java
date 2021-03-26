package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: BUGLY */
public class TraceFileHelper {

    /* compiled from: BUGLY */
    public static class a {
        public long a;
        public String b;
        public long c;
        public Map<String, String[]> d;
    }

    /* compiled from: BUGLY */
    public interface b {
        boolean a(long j);

        boolean a(long j, long j2, String str);

        boolean a(String str, int i, String str2, String str3);
    }

    public static a readTargetDumpInfo(final String str, String str2, final boolean z) {
        if (!(str == null || str2 == null)) {
            final a aVar = new a();
            readTraceFile(str2, new b() {
                /* class com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.AnonymousClass1 */

                /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r9v0 int)] */
                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(String str, int i, String str2, String str3) {
                    x.c("new thread %s", str);
                    if (aVar.a > 0 && aVar.c > 0 && aVar.b != null) {
                        if (aVar.d == null) {
                            aVar.d = new HashMap();
                        }
                        Map<String, String[]> map = aVar.d;
                        StringBuilder sb = new StringBuilder();
                        sb.append(i);
                        map.put(str, new String[]{str2, str3, sb.toString()});
                    }
                    return true;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(long j, long j2, String str) {
                    x.c("new process %s", str);
                    if (!str.equals(str)) {
                        return true;
                    }
                    aVar.a = j;
                    aVar.b = str;
                    aVar.c = j2;
                    return z;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(long j) {
                    x.c("process end %d", Long.valueOf(j));
                    return aVar.a <= 0 || aVar.c <= 0 || aVar.b == null;
                }
            });
            if (aVar.a > 0 && aVar.c > 0 && aVar.b != null) {
                return aVar;
            }
        }
        return null;
    }

    public static a readFirstDumpInfo(String str, final boolean z) {
        if (str == null) {
            x.e("path:%s", str);
            return null;
        }
        final a aVar = new a();
        readTraceFile(str, new b() {
            /* class com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.AnonymousClass2 */

            /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r6v0 int)] */
            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(String str, int i, String str2, String str3) {
                x.c("new thread %s", str);
                if (aVar.d == null) {
                    aVar.d = new HashMap();
                }
                Map<String, String[]> map = aVar.d;
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                map.put(str, new String[]{str2, str3, sb.toString()});
                return true;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(long j, long j2, String str) {
                x.c("new process %s", str);
                aVar.a = j;
                aVar.b = str;
                aVar.c = j2;
                return z;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(long j) {
                x.c("process end %d", Long.valueOf(j));
                return false;
            }
        });
        if (aVar.a > 0 && aVar.c > 0 && aVar.b != null) {
            return aVar;
        }
        x.e("first dump error %s", aVar.a + " " + aVar.c + " " + aVar.b);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x017f A[Catch:{ all -> 0x0175 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01a7 A[SYNTHETIC, Splitter:B:67:0x01a7] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b9 A[SYNTHETIC, Splitter:B:75:0x01b9] */
    /* JADX WARNING: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    public static void readTraceFile(String str, b bVar) {
        Throwable th;
        Exception e;
        if (str != null && bVar != null) {
            File file = new File(str);
            if (file.exists()) {
                file.lastModified();
                file.length();
                BufferedReader bufferedReader = null;
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                    try {
                        Pattern compile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                        Pattern compile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                        Pattern compile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                        Pattern compile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                        while (true) {
                            Object[] a2 = a(bufferedReader2, compile);
                            if (a2 != null) {
                                String[] split = a2[1].toString().split("\\s");
                                long parseLong = Long.parseLong(split[2]);
                                long time = simpleDateFormat.parse(split[4] + " " + split[5]).getTime();
                                Object[] a3 = a(bufferedReader2, compile3);
                                if (a3 == null) {
                                    try {
                                        bufferedReader2.close();
                                        return;
                                    } catch (IOException e2) {
                                        if (!x.a(e2)) {
                                            e2.printStackTrace();
                                            return;
                                        }
                                        return;
                                    }
                                } else {
                                    Matcher matcher = compile3.matcher(a3[1].toString());
                                    matcher.find();
                                    matcher.group(1);
                                    if (!bVar.a(parseLong, time, matcher.group(1))) {
                                        try {
                                            bufferedReader2.close();
                                            return;
                                        } catch (IOException e3) {
                                            if (!x.a(e3)) {
                                                e3.printStackTrace();
                                                return;
                                            }
                                            return;
                                        }
                                    } else {
                                        while (true) {
                                            Object[] a4 = a(bufferedReader2, compile4, compile2);
                                            if (a4 == null) {
                                                break;
                                            } else if (a4[0] == compile4) {
                                                String obj = a4[1].toString();
                                                Matcher matcher2 = Pattern.compile("\".+\"").matcher(obj);
                                                matcher2.find();
                                                String group2 = matcher2.group();
                                                String substring = group2.substring(1, group2.length() - 1);
                                                obj.contains("NATIVE");
                                                Matcher matcher3 = Pattern.compile("tid=\\d+").matcher(obj);
                                                matcher3.find();
                                                String group3 = matcher3.group();
                                                bVar.a(substring, Integer.parseInt(group3.substring(group3.indexOf("=") + 1)), a(bufferedReader2), b(bufferedReader2));
                                            } else if (!bVar.a(Long.parseLong(a4[1].toString().split("\\s")[2]))) {
                                                try {
                                                    bufferedReader2.close();
                                                    return;
                                                } catch (IOException e4) {
                                                    if (!x.a(e4)) {
                                                        e4.printStackTrace();
                                                        return;
                                                    }
                                                    return;
                                                }
                                            }
                                        }
                                        simpleDateFormat = simpleDateFormat;
                                    }
                                }
                            } else {
                                try {
                                    bufferedReader2.close();
                                    return;
                                } catch (IOException e5) {
                                    if (!x.a(e5)) {
                                        e5.printStackTrace();
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                    } catch (Exception e6) {
                        e = e6;
                        bufferedReader = bufferedReader2;
                        try {
                            if (!x.a(e)) {
                                e.printStackTrace();
                            }
                            x.d("trace open fail:%s : %s", e.getClass().getName(), e.getMessage());
                            if (bufferedReader == null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e7) {
                                    if (!x.a(e7)) {
                                        e7.printStackTrace();
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e8) {
                                    if (!x.a(e8)) {
                                        e8.printStackTrace();
                                    }
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                        }
                        throw th;
                    }
                } catch (Exception e9) {
                    e = e9;
                    if (!x.a(e)) {
                    }
                    x.d("trace open fail:%s : %s", e.getClass().getName(), e.getMessage());
                    if (bufferedReader == null) {
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        return new java.lang.Object[]{r5, r1};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        if (r8 != null) goto L_0x0006;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r1 = r7.readLine();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        if (r1 == null) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        r2 = r8.length;
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        if (r4 >= r2) goto L_0x0006;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
        r5 = r8[r4];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        if (r5.matcher(r1).matches() == false) goto L_0x0026;
     */
    private static Object[] a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        if (bufferedReader != null) {
        }
        return null;
    }

    private static String a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }

    private static String b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.trim().length() <= 0) {
                break;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }
}
