package com.xiaomi.b.c;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.b.a.c;
import com.xiaomi.b.a.d;
import com.xiaomi.push.jg;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class g {
    private static c a(c cVar, String str) {
        long[] a;
        if (cVar == null || (a = a(str)) == null) {
            return null;
        }
        cVar.b = a[0];
        cVar.c = a[1];
        return cVar;
    }

    public static String a(c cVar) {
        return cVar.e + "#" + cVar.f + "#" + cVar.g + "#" + cVar.a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v10, resolved type: java.io.BufferedReader */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00d5, code lost:
        if (r1 == null) goto L_0x00da;
     */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f4  */
    public static List<String> a(Context context, String str) {
        Throwable th;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        File file;
        Exception e;
        RandomAccessFile randomAccessFile3;
        FileLock lock;
        RandomAccessFile randomAccessFile4;
        RandomAccessFile randomAccessFile5;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return arrayList;
        }
        FileLock fileLock = null;
        try {
            file = new File(str + ".lock");
            try {
                jg.c(file);
                randomAccessFile2 = new RandomAccessFile(file, "rw");
            } catch (Exception e2) {
                e = e2;
                randomAccessFile2 = null;
                randomAccessFile3 = randomAccessFile2;
                try {
                    com.xiaomi.a.a.a.c.a(e);
                    try {
                        fileLock.release();
                    } catch (IOException e3) {
                        com.xiaomi.a.a.a.c.a(e3);
                    }
                    jg.a(randomAccessFile2);
                    jg.a(randomAccessFile3);
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile = randomAccessFile3;
                    try {
                        fileLock.release();
                    } catch (IOException e4) {
                        com.xiaomi.a.a.a.c.a(e4);
                    }
                    jg.a(randomAccessFile2);
                    jg.a(randomAccessFile);
                    if (file != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile2 = null;
                randomAccessFile = randomAccessFile2;
                fileLock.release();
                jg.a(randomAccessFile2);
                jg.a(randomAccessFile);
                if (file != null) {
                }
                throw th;
            }
            try {
                lock = randomAccessFile2.getChannel().lock();
            } catch (Exception e5) {
                e = e5;
                randomAccessFile3 = null;
                com.xiaomi.a.a.a.c.a(e);
                fileLock.release();
                jg.a(randomAccessFile2);
                jg.a(randomAccessFile3);
            } catch (Throwable th4) {
                th = th4;
                randomAccessFile = null;
                fileLock.release();
                jg.a(randomAccessFile2);
                jg.a(randomAccessFile);
                if (file != null) {
                }
                throw th;
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = readLine.split("%%%");
                        if (split.length >= 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                            c a = a(d(split[0]), split[1]);
                            if (a != null) {
                                arrayList.add(a.b());
                            }
                        }
                    } catch (Exception e6) {
                        e = e6;
                        randomAccessFile4 = bufferedReader;
                        fileLock = lock;
                        randomAccessFile3 = randomAccessFile4;
                        com.xiaomi.a.a.a.c.a(e);
                        fileLock.release();
                        jg.a(randomAccessFile2);
                        jg.a(randomAccessFile3);
                    } catch (Throwable th5) {
                        th = th5;
                        randomAccessFile5 = bufferedReader;
                        fileLock = lock;
                        randomAccessFile = randomAccessFile5;
                        fileLock.release();
                        jg.a(randomAccessFile2);
                        jg.a(randomAccessFile);
                        if (file != null) {
                        }
                        throw th;
                    }
                }
                if (lock != null && lock.isValid()) {
                    try {
                        lock.release();
                    } catch (IOException e7) {
                        com.xiaomi.a.a.a.c.a(e7);
                    }
                }
                jg.a(randomAccessFile2);
                jg.a(bufferedReader);
            } catch (Exception e8) {
                e = e8;
                randomAccessFile4 = null;
                fileLock = lock;
                randomAccessFile3 = randomAccessFile4;
                com.xiaomi.a.a.a.c.a(e);
                fileLock.release();
                jg.a(randomAccessFile2);
                jg.a(randomAccessFile3);
            } catch (Throwable th6) {
                th = th6;
                randomAccessFile5 = null;
                fileLock = lock;
                randomAccessFile = randomAccessFile5;
                fileLock.release();
                jg.a(randomAccessFile2);
                jg.a(randomAccessFile);
                if (file != null) {
                }
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            file = null;
            randomAccessFile2 = null;
            randomAccessFile3 = randomAccessFile2;
            com.xiaomi.a.a.a.c.a(e);
            if (fileLock != null && fileLock.isValid()) {
                fileLock.release();
            }
            jg.a(randomAccessFile2);
            jg.a(randomAccessFile3);
        } catch (Throwable th7) {
            th = th7;
            file = null;
            randomAccessFile2 = null;
            randomAccessFile = randomAccessFile2;
            if (fileLock != null && fileLock.isValid()) {
                fileLock.release();
            }
            jg.a(randomAccessFile2);
            jg.a(randomAccessFile);
            if (file != null) {
                file.delete();
            }
            throw th;
        }
        file.delete();
        return arrayList;
    }

    private static void a(String str, HashMap<String, String> hashMap) {
        Throwable th;
        BufferedWriter bufferedWriter;
        Exception e;
        if (!(TextUtils.isEmpty(str) || hashMap == null || hashMap.size() == 0)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file));
                try {
                    for (String str2 : hashMap.keySet()) {
                        bufferedWriter.write(str2 + "%%%" + hashMap.get(str2));
                        bufferedWriter.newLine();
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        com.xiaomi.a.a.a.c.a(e);
                        jg.a(bufferedWriter);
                    } catch (Throwable th2) {
                        th = th2;
                        jg.a(bufferedWriter);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                bufferedWriter = null;
                e = e3;
                com.xiaomi.a.a.a.c.a(e);
                jg.a(bufferedWriter);
            } catch (Throwable th3) {
                bufferedWriter = null;
                th = th3;
                jg.a(bufferedWriter);
                throw th;
            }
            jg.a(bufferedWriter);
        }
    }

    public static void a(String str, d[] dVarArr) {
        RandomAccessFile randomAccessFile;
        if (!(dVarArr == null || dVarArr.length <= 0 || TextUtils.isEmpty(str))) {
            FileLock fileLock = null;
            try {
                File file = new File(str + ".lock");
                jg.c(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    FileLock lock = randomAccessFile.getChannel().lock();
                    HashMap<String, String> b = b(str);
                    for (d dVar : dVarArr) {
                        if (dVar != null) {
                            String a = a((c) dVar);
                            long j = ((c) dVar).b;
                            long j2 = ((c) dVar).c;
                            if (!TextUtils.isEmpty(a) && j > 0) {
                                if (j2 >= 0) {
                                    a(b, a, j, j2);
                                }
                            }
                        }
                    }
                    a(str, b);
                    if (lock != null && lock.isValid()) {
                        try {
                            lock.release();
                        } catch (IOException e) {
                            IOException e2 = e;
                        }
                    }
                } catch (Throwable unused) {
                    try {
                        com.xiaomi.a.a.a.c.c("failed to write perf to file ");
                    } finally {
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e3) {
                                com.xiaomi.a.a.a.c.a(e3);
                            }
                        }
                        jg.a(randomAccessFile);
                    }
                }
            } catch (Throwable unused2) {
                randomAccessFile = null;
                com.xiaomi.a.a.a.c.c("failed to write perf to file ");
            }
        }
    }

    private static void a(HashMap<String, String> hashMap, String str, long j, long j2) {
        StringBuilder sb;
        String str2 = hashMap.get(str);
        if (TextUtils.isEmpty(str2)) {
            sb = new StringBuilder();
        } else {
            long[] a = a(str2);
            if (a == null || a[0] <= 0 || a[1] < 0) {
                sb = new StringBuilder();
            } else {
                j += a[0];
                j2 += a[1];
                sb = new StringBuilder();
            }
        }
        sb.append(j);
        sb.append("#");
        sb.append(j2);
        hashMap.put(str, sb.toString());
    }

    protected static long[] a(String str) {
        long[] jArr = new long[2];
        try {
            String[] split = str.split("#");
            if (split.length >= 2) {
                jArr[0] = Long.parseLong(split[0].trim());
                jArr[1] = Long.parseLong(split[1].trim());
            }
            return jArr;
        } catch (Exception e) {
            com.xiaomi.a.a.a.c.a(e);
            return null;
        }
    }

    private static HashMap<String, String> b(String str) {
        Throwable th;
        Exception e;
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return hashMap;
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split("%%%");
                    if (split.length >= 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                        hashMap.put(split[0], split[1]);
                    }
                } catch (Exception e2) {
                    e = e2;
                    bufferedReader = bufferedReader2;
                    try {
                        com.xiaomi.a.a.a.c.a(e);
                        jg.a(bufferedReader);
                        return hashMap;
                    } catch (Throwable th2) {
                        th = th2;
                        jg.a(bufferedReader);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader2;
                    jg.a(bufferedReader);
                    throw th;
                }
            }
            jg.a(bufferedReader2);
        } catch (Exception e3) {
            e = e3;
            com.xiaomi.a.a.a.c.a(e);
            jg.a(bufferedReader);
            return hashMap;
        }
        return hashMap;
    }

    private static String[] c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split("#");
    }

    private static c d(String str) {
        try {
            String[] c = c(str);
            if (c == null || c.length < 4 || TextUtils.isEmpty(c[0]) || TextUtils.isEmpty(c[1]) || TextUtils.isEmpty(c[2]) || TextUtils.isEmpty(c[3])) {
                return null;
            }
            c c2 = c.c();
            c2.e = Integer.parseInt(c[0]);
            c2.f = c[1];
            c2.g = Integer.parseInt(c[2]);
            c2.a = Integer.parseInt(c[3]);
            return c2;
        } catch (Exception unused) {
            com.xiaomi.a.a.a.c.c("parse per key error");
            return null;
        }
    }
}
