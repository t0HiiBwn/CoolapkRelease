package com.coolapk.market.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class ShellUtils {
    public static final String COMMAND_EXIT = "exit 0";
    public static final String COMMAND_LINE_END = "\n";
    public static final String COMMAND_SH = "sh";
    public static final String COMMAND_SU = "su";

    public interface Callback {
        void onOutput(String str);
    }

    public static Integer execCommand(String str, boolean z, long j, Callback callback) throws IOException, InterruptedException, TimeoutException {
        return execCommand(new String[]{str}, z, j, callback);
    }

    public static Integer execCommand(String str, boolean z, Callback callback) throws IOException, InterruptedException {
        try {
            return execCommand(new String[]{str}, z, 0, callback);
        } catch (TimeoutException unused) {
            return null;
        }
    }

    public static Integer execCommand(List<String> list, boolean z, long j, Callback callback) throws IOException, InterruptedException, TimeoutException {
        return execCommand((String[]) list.toArray(new String[list.size()]), z, j, callback);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0035: APUT  (r3v6 java.lang.String[]), (0 ??[int, short, byte, char]), (r7v0 java.lang.String) */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0114 A[Catch:{ IOException -> 0x0118 }] */
    public static Integer execCommand(String[] strArr, boolean z, long j, Callback callback) throws IOException, InterruptedException, TimeoutException {
        Throwable th;
        InterruptedException e;
        LogUtils.v("Execute command on root: %s, %s, timeout: %d", Boolean.valueOf(z), Thread.currentThread().getName(), Long.valueOf(j));
        ProcessBuilder processBuilder = new ProcessBuilder(new String[0]);
        String[] strArr2 = new String[1];
        strArr2[0] = z ? "su" : "sh";
        Process start = processBuilder.command(strArr2).redirectErrorStream(true).start();
        BufferedReader bufferedReader = null;
        Worker worker = new Worker(start);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(start.getOutputStream(), StandardCharsets.UTF_8);
        try {
            boolean z2 = false;
            for (String str : strArr) {
                if (str != null) {
                    if (!z2 && str.startsWith("logcat")) {
                        z2 = true;
                    }
                    if (!z2) {
                        LogUtils.v("CMD IN: %s", str);
                    }
                    outputStreamWriter.write(str);
                    outputStreamWriter.write("\n");
                    outputStreamWriter.flush();
                }
            }
            outputStreamWriter.write("exit 0");
            outputStreamWriter.write("\n");
            outputStreamWriter.flush();
            worker.start();
            worker.join(j);
            if (worker.exit == null) {
                if (!z2) {
                    LogUtils.w("CMD timeout", new Object[0]);
                }
                throw new TimeoutException();
            }
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(start.getInputStream()));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        if (!z2) {
                            LogUtils.v("CMD OUT: %s", readLine);
                        }
                        if (callback != null) {
                            callback.onOutput(readLine);
                        }
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (InterruptedException e3) {
                    e = e3;
                    bufferedReader = bufferedReader2;
                    try {
                        worker.interrupt();
                        Thread.currentThread().interrupt();
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            outputStreamWriter.close();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        start.destroy();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader2;
                    outputStreamWriter.close();
                    if (bufferedReader != null) {
                    }
                    start.destroy();
                    throw th;
                }
            }
            outputStreamWriter.close();
            bufferedReader2.close();
            start.destroy();
            LogUtils.v("Destroy process on root: %s, %s", Boolean.valueOf(z), Thread.currentThread().getName());
            return worker.exit;
        } catch (InterruptedException e5) {
            e = e5;
            worker.interrupt();
            Thread.currentThread().interrupt();
            throw e;
        }
    }

    private static class Worker extends Thread {
        private Integer exit;
        private final Process process;

        private Worker(Process process2) {
            this.process = process2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.exit = Integer.valueOf(this.process.waitFor());
            } catch (InterruptedException unused) {
            }
        }
    }
}
