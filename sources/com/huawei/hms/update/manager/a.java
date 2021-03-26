package com.huawei.hms.update.manager;

import android.content.Context;
import android.os.AsyncTask;
import com.huawei.hms.support.log.HMSLog;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: PingTask */
public final class a {
    private static boolean a;
    private CountDownLatch b;

    public boolean a(long j, TimeUnit timeUnit, String str) {
        if (a) {
            HMSLog.i("PingTask", "ping google return cache");
            return true;
        }
        HMSLog.i("PingTask", "start ping goole");
        this.b = new CountDownLatch(1);
        new AsyncTaskC0075a(str).execute(new Context[0]);
        try {
            if (!this.b.await(j, timeUnit)) {
                HMSLog.i("PingTask", "await time out");
                return false;
            }
            HMSLog.i("PingTask", "await:isReachable:" + a);
            return a;
        } catch (InterruptedException unused) {
            HMSLog.e("PingTask", "await:InterruptedException:");
            return false;
        }
    }

    /* renamed from: com.huawei.hms.update.manager.a$a  reason: collision with other inner class name */
    /* compiled from: PingTask */
    private class AsyncTaskC0075a extends AsyncTask<Context, Integer, Boolean> {
        private String b;

        public AsyncTaskC0075a(String str) {
            this.b = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Boolean doInBackground(Context... contextArr) {
            boolean z = false;
            try {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(this.b).openConnection();
                if (httpsURLConnection != null) {
                    httpsURLConnection.setRequestMethod("GET");
                    httpsURLConnection.setConnectTimeout(30000);
                    httpsURLConnection.setReadTimeout(30000);
                    httpsURLConnection.setUseCaches(false);
                    httpsURLConnection.setInstanceFollowRedirects(true);
                    int responseCode = httpsURLConnection.getResponseCode();
                    HMSLog.i("PingTask", "GET google result:" + responseCode);
                    z = true;
                }
            } catch (RuntimeException unused) {
                HMSLog.e("PingTask", "GET google result:RuntimeException");
            } catch (IOException unused2) {
                HMSLog.e("PingTask", "GET google result:safe exception");
            } catch (Exception unused3) {
                HMSLog.e("PingTask", "GET google result:Exception");
            }
            boolean unused4 = a.a = z;
            a.this.b.countDown();
            return Boolean.valueOf(z);
        }
    }
}
