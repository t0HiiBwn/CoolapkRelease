package com.bytedance.tea.crash.e;

import android.os.Build;
import com.bytedance.tea.crash.g.f;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/* compiled from: LogcatDump */
public class e {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0061, code lost:
        if (0 == 0) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0063, code lost:
        r4.destroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0066, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x005a, code lost:
        if (r4 != null) goto L_0x0063;
     */
    public static List<String> a(int i, int i2) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        String[] strArr = {"logcat", "-t", String.valueOf(i), a(i2)};
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(strArr);
            new a(process.getInputStream(), copyOnWriteArrayList).start();
            new a(process.getErrorStream(), copyOnWriteArrayList).start();
            new b(process, 3000).start();
            if (Build.VERSION.SDK_INT >= 26) {
                process.waitFor(3000, TimeUnit.MILLISECONDS);
            } else {
                process.waitFor();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                process.destroy();
            }
            throw th;
        }
    }

    /* compiled from: LogcatDump */
    private static class a extends Thread {
        private InputStream a;
        private List<String> b;

        a(InputStream inputStream, List<String> list) {
            this.a = inputStream;
            this.b = list;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.a));
            int i = 32768;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!readLine.startsWith("---------")) {
                        i -= readLine.getBytes("UTF-8").length;
                        if (i < 0) {
                            break;
                        }
                        this.b.add(readLine);
                    }
                } catch (IOException unused) {
                } catch (Throwable th) {
                    f.a(bufferedReader);
                    throw th;
                }
            }
            f.a(bufferedReader);
        }
    }

    /* compiled from: LogcatDump */
    private static class b extends Thread {
        private Process a;
        private long b;

        public b(Process process, long j) {
            this.a = process;
            this.b = j;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                sleep(this.b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Process process = this.a;
            if (process != null) {
                process.destroy();
            }
        }
    }

    private static String a(int i) {
        return (i < 0 || i >= 6) ? "*:V" : new String[]{"*:V", "*:D", "*:I", "*:W", "*:E", "*:F"}[i];
    }
}
