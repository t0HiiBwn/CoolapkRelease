package com.qq.e.comm.net;

import com.qq.e.comm.net.NetworkClient;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.util.GDTLogger;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NetworkClientImpl implements NetworkClient {
    private static final NetworkClient a = new NetworkClientImpl();
    private final ExecutorService b = new ThreadPoolExecutor(5, 10, 180, TimeUnit.SECONDS, this.c);
    private PriorityBlockingQueue<Runnable> c = new PriorityBlockingQueue<>(15);

    /* renamed from: com.qq.e.comm.net.NetworkClientImpl$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Request.Method.values().length];
            a = iArr;
            try {
                iArr[Request.Method.POST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Request.Method.GET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static class NetFutureTask<T> extends FutureTask<T> implements Comparable<NetFutureTask<T>> {
        private final NetworkClient.Priority a;

        public NetFutureTask(Callable<T> callable, NetworkClient.Priority priority) {
            super(callable);
            this.a = priority;
        }

        public int compareTo(NetFutureTask<T> netFutureTask) {
            if (netFutureTask == null) {
                return 1;
            }
            return this.a.value() - netFutureTask.a.value();
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return compareTo((NetFutureTask) ((NetFutureTask) obj));
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            return obj != null && obj.getClass() == getClass() && compareTo((NetFutureTask) obj) == 0;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.a.value();
        }
    }

    private static class TaskCallable implements Callable<Response> {
        private Request a;
        private NetworkCallBack b;

        public TaskCallable(Request request) {
            this(request, null);
        }

        public TaskCallable(Request request, NetworkCallBack networkCallBack) {
            this.a = request;
            this.b = networkCallBack;
        }

        private void a(HttpURLConnection httpURLConnection) {
            for (Map.Entry<String, String> entry : this.a.getHeaders().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            httpURLConnection.setRequestProperty("User-Agent", "GDTADNetClient-[" + System.getProperty("http.agent") + "]");
            if (this.a.getConnectionTimeOut() > 0) {
                httpURLConnection.setConnectTimeout(this.a.getConnectionTimeOut());
            } else {
                httpURLConnection.setConnectTimeout(30000);
            }
            if (this.a.getSocketTimeOut() > 0) {
                httpURLConnection.setReadTimeout(this.a.getSocketTimeOut());
            } else {
                httpURLConnection.setReadTimeout(30000);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x006b, code lost:
            if (r6.a.isAutoClose() != false) goto L_0x006d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x007f, code lost:
            if (r1 != null) goto L_0x006d;
         */
        @Override // java.util.concurrent.Callable
        public Response call() throws Exception {
            Response response;
            Exception exc = null;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.a.getUrlWithParas()).openConnection();
                a(httpURLConnection);
                if (AnonymousClass1.a[this.a.getMethod().ordinal()] == 1) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setChunkedStreamingMode(0);
                    byte[] postData = this.a.getPostData();
                    if (postData != null && postData.length > 0) {
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                        bufferedOutputStream.write(postData);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                    }
                }
                response = this.a.initResponse(NetworkClientImpl.followRedirect(httpURLConnection));
            } catch (Exception e) {
                response = null;
                exc = e;
            }
            if (exc == null) {
                NetworkCallBack networkCallBack = this.b;
                if (networkCallBack != null) {
                    networkCallBack.onResponse(this.a, response);
                }
            } else if (this.b != null) {
                GDTLogger.w("NetworkClientException", exc);
                this.b.onException(exc);
            } else {
                throw exc;
            }
            response.close();
            return response;
        }
    }

    private NetworkClientImpl() {
    }

    public static HttpURLConnection followRedirect(HttpURLConnection httpURLConnection) throws IOException {
        String str = null;
        if (httpURLConnection == null) {
            return null;
        }
        int i = 0;
        int connectTimeout = httpURLConnection.getConnectTimeout();
        int readTimeout = httpURLConnection.getReadTimeout();
        try {
            str = httpURLConnection.getRequestProperty("User-Agent");
        } catch (Exception unused) {
        }
        while (i < 3) {
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 302 && responseCode != 301 && responseCode != 303) {
                break;
            }
            String headerField = httpURLConnection.getHeaderField("location");
            httpURLConnection.disconnect();
            httpURLConnection = (HttpURLConnection) new URL(headerField).openConnection();
            httpURLConnection.setConnectTimeout(connectTimeout);
            httpURLConnection.setReadTimeout(readTimeout);
            if (str != null) {
                httpURLConnection.setRequestProperty("User-Agent", str);
            }
            i++;
        }
        if (i != 3) {
            return httpURLConnection;
        }
        throw new IOException("HttpURLConnection exceed max redirect 3 " + httpURLConnection.getURL());
    }

    public static NetworkClient getInstance() {
        return a;
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public Future<Response> submit(Request request) {
        return submit(request, NetworkClient.Priority.Mid);
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public Future<Response> submit(Request request, NetworkClient.Priority priority) {
        NetFutureTask netFutureTask = new NetFutureTask(new TaskCallable(request), priority);
        this.b.execute(netFutureTask);
        GDTLogger.d("QueueSize:" + this.c.size());
        return netFutureTask;
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public void submit(Request request, NetworkCallBack networkCallBack) {
        submit(request, NetworkClient.Priority.Mid, networkCallBack);
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public void submit(Request request, NetworkClient.Priority priority, NetworkCallBack networkCallBack) {
        submit(request, priority, networkCallBack, this.b);
    }

    @Override // com.qq.e.comm.net.NetworkClient
    public void submit(Request request, NetworkClient.Priority priority, NetworkCallBack networkCallBack, Executor executor) {
        if (executor == null) {
            GDTLogger.e("Submit failed for no executor");
            return;
        }
        executor.execute(new NetFutureTask(new TaskCallable(request, networkCallBack), priority));
        GDTLogger.d("QueueSize:" + this.c.size());
    }
}
