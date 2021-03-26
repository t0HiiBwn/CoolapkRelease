package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;

public class h {
    public static boolean a(Context context, String str, long j) {
        Throwable th;
        RandomAccessFile randomAccessFile;
        IOException e;
        if (Build.VERSION.SDK_INT >= 23 && !eu.f(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            return true;
        }
        FileLock fileLock = null;
        try {
            File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), "lcfp.lock");
            jg.c(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
                boolean b = b(context, str, j);
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException unused) {
                    }
                }
                jg.a(randomAccessFile);
                return b;
            } catch (IOException e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException unused2) {
                        }
                    }
                    jg.a(randomAccessFile);
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException unused3) {
                        }
                    }
                    jg.a(randomAccessFile);
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            randomAccessFile = null;
            e.printStackTrace();
            fileLock.release();
            jg.a(randomAccessFile);
            return true;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            fileLock.release();
            jg.a(randomAccessFile);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d2 A[Catch:{ IOException -> 0x00e9, all -> 0x00e6 }, LOOP:1: B:43:0x00cc->B:45:0x00d2, LOOP_END] */
    private static boolean b(Context context, String str, long j) {
        BufferedWriter bufferedWriter;
        Throwable th;
        IOException e;
        BufferedWriter bufferedWriter2;
        BufferedReader bufferedReader;
        Throwable th2;
        BufferedReader bufferedReader2;
        File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), "lcfp");
        ArrayList<String> arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = str + ":" + context.getPackageName() + "," + currentTimeMillis;
        if (file.exists()) {
            try {
                bufferedReader2 = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = readLine.split(":");
                        if (split.length == 2) {
                            if (TextUtils.equals(split[0], String.valueOf(str))) {
                                String[] split2 = split[1].split(",");
                                if (split2.length == 2) {
                                    long parseLong = Long.parseLong(split2[1]);
                                    if (!TextUtils.equals(split2[0], context.getPackageName()) && ((float) Math.abs(currentTimeMillis - parseLong)) < ((float) (1000 * j)) * 0.9f) {
                                        jg.a(bufferedReader2);
                                        return false;
                                    }
                                }
                            } else {
                                arrayList.add(readLine);
                            }
                        }
                    } catch (Exception unused) {
                        try {
                            arrayList.clear();
                            jg.a(bufferedReader2);
                            arrayList.add(str2);
                            bufferedWriter2 = new BufferedWriter(new FileWriter(file));
                            while (r0.hasNext()) {
                            }
                            jg.a(bufferedWriter2);
                            return true;
                        } catch (Throwable th3) {
                            th2 = th3;
                            bufferedReader = bufferedReader2;
                            jg.a(bufferedReader);
                            throw th2;
                        }
                    }
                }
            } catch (Exception unused2) {
                bufferedReader2 = null;
                arrayList.clear();
                jg.a(bufferedReader2);
                arrayList.add(str2);
                bufferedWriter2 = new BufferedWriter(new FileWriter(file));
                while (r0.hasNext()) {
                }
                jg.a(bufferedWriter2);
                return true;
            } catch (Throwable th4) {
                th2 = th4;
                bufferedReader = null;
                jg.a(bufferedReader);
                throw th2;
            }
            jg.a(bufferedReader2);
        } else if (!jg.c(file)) {
            return true;
        }
        arrayList.add(str2);
        try {
            bufferedWriter2 = new BufferedWriter(new FileWriter(file));
            try {
                for (String str3 : arrayList) {
                    bufferedWriter2.write(str3);
                    bufferedWriter2.newLine();
                    bufferedWriter2.flush();
                }
                jg.a(bufferedWriter2);
            } catch (IOException e2) {
                e = e2;
                bufferedWriter = bufferedWriter2;
                try {
                    c.d(e.toString());
                    jg.a(bufferedWriter);
                    return true;
                } catch (Throwable th5) {
                    th = th5;
                    jg.a(bufferedWriter);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedWriter = bufferedWriter2;
                jg.a(bufferedWriter);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedWriter = null;
            c.d(e.toString());
            jg.a(bufferedWriter);
            return true;
        } catch (Throwable th7) {
            th = th7;
            bufferedWriter = null;
            jg.a(bufferedWriter);
            throw th;
        }
        return true;
    }
}
