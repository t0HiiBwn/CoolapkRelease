package com.xiaomi.push.service;

import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.co;
import com.xiaomi.push.dv;
import com.xiaomi.push.gu;
import com.xiaomi.push.y;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class af {
    private static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static ThreadPoolExecutor f942a = new ThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a  reason: collision with other field name */
    private static final Pattern f943a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");

    private static String a(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(str)));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append("\n");
                        sb.append(readLine);
                    } else {
                        String sb2 = sb.toString();
                        y.a(bufferedReader);
                        return sb2;
                    }
                }
            } catch (Exception unused) {
                y.a(bufferedReader);
                return null;
            } catch (Throwable th2) {
                th = th2;
                y.a(bufferedReader);
                throw th;
            }
        } catch (Exception unused2) {
            bufferedReader = null;
            y.a(bufferedReader);
            return null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            y.a(bufferedReader);
            throw th;
        }
    }

    public static void a() {
        dv.a a2;
        long currentTimeMillis = System.currentTimeMillis();
        if ((f942a.getActiveCount() <= 0 || currentTimeMillis - a >= 1800000) && gu.m378a().m383a() && (a2 = bh.a().m643a()) != null && a2.e() > 0) {
            a = currentTimeMillis;
            a(a2.mo211a(), true);
        }
    }

    public static void a(List<String> list, boolean z) {
        f942a.execute(new ag(list, z));
    }

    public static void b() {
        String a2 = a("/proc/self/net/tcp");
        if (!TextUtils.isEmpty(a2)) {
            b.m41a("dump tcp for uid = " + Process.myUid());
            b.m41a(a2);
        }
        String a3 = a("/proc/self/net/tcp6");
        if (!TextUtils.isEmpty(a3)) {
            b.m41a("dump tcp6 for uid = " + Process.myUid());
            b.m41a(a3);
        }
    }

    private static boolean b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            b.m41a("ConnectivityTest: begin to connect to " + str);
            Socket socket = new Socket();
            socket.connect(co.m183a(str, 5222), 5000);
            socket.setTcpNoDelay(true);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            b.m41a("ConnectivityTest: connect to " + str + " in " + currentTimeMillis2);
            socket.close();
            return true;
        } catch (Throwable th) {
            b.d("ConnectivityTest: could not connect to:" + str + " exception: " + th.getClass().getSimpleName() + " description: " + th.getMessage());
            return false;
        }
    }
}
