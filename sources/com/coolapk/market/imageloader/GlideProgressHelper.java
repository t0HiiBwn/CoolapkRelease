package com.coolapk.market.imageloader;

import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import com.coolapk.market.event.ImageLoadEvent;
import com.coolapk.market.manager.DataManager;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
import org.greenrobot.eventbus.EventBus;

public class GlideProgressHelper {
    private static final DispatchingProgressListener sDispatchListener = new DispatchingProgressListener();

    private interface ResponseProgressListener {
        void close(HttpUrl httpUrl);

        void update(HttpUrl httpUrl, long j, long j2);
    }

    public interface UIProgressListener {
        void onClose();

        void onProgress(long j, long j2);
    }

    static OkHttpClient createOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor($$Lambda$GlideProgressHelper$Iqj8RzIZQLWXf3PPvWuEWZN3HI.INSTANCE);
        builder.addNetworkInterceptor($$Lambda$GlideProgressHelper$WwyHDMxu5jbIqQvUAMUaBTJlAA.INSTANCE);
        builder.addNetworkInterceptor(ImageLoadErrorHandler.createOkHttpErrorInterceptor());
        return builder.build();
    }

    static /* synthetic */ Response lambda$createOkHttpClient$0(Interceptor.Chain chain) throws IOException {
        Request.Builder newBuilder = chain.request().newBuilder();
        try {
            List<String> coolMarketHeaders = DataManager.getInstance().getDataConfig().getCoolMarketHeaders();
            for (int i = 0; i < coolMarketHeaders.size(); i += 2) {
                newBuilder.header(coolMarketHeaders.get(i), coolMarketHeaders.get(i + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        newBuilder.header("User-Agent", Html.escapeHtml(DataManager.getInstance().getDataConfig().getUserAgent()));
        return chain.proceed(newBuilder.build());
    }

    static /* synthetic */ Response lambda$createOkHttpClient$1(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Response proceed = chain.proceed(request);
        return proceed.newBuilder().body(new OkHttpProgressResponseBody(request.url(), proceed.body(), sDispatchListener)).build();
    }

    public static void forget(String str) {
        sDispatchListener.removeListener(str);
    }

    public static void expect(String str) {
        sDispatchListener.addListener(str);
    }

    private static class DispatchingProgressListener implements ResponseProgressListener {
        private final Map<String, Long> mDispatchedProgress = new HashMap();
        private final Handler mHandler = new Handler(Looper.getMainLooper());
        private final Map<String, Integer> mListeners = new HashMap();

        DispatchingProgressListener() {
        }

        void removeListener(String str) {
            Integer num = this.mListeners.get(str);
            if (num != null) {
                Integer valueOf = Integer.valueOf(num.intValue() - 1);
                if (valueOf.intValue() == 0) {
                    this.mListeners.remove(str);
                } else {
                    this.mListeners.put(str, valueOf);
                }
            }
        }

        void addListener(String str) {
            Integer num = this.mListeners.get(str);
            if (num != null) {
                this.mListeners.put(str, Integer.valueOf(num.intValue() + 1));
                return;
            }
            this.mListeners.put(str, 1);
        }

        @Override // com.coolapk.market.imageloader.GlideProgressHelper.ResponseProgressListener
        public void update(HttpUrl httpUrl, final long j, final long j2) {
            final String httpUrl2 = httpUrl.toString();
            Integer num = this.mListeners.get(httpUrl2);
            if (num != null && num.intValue() > 0 && needsDispatch(httpUrl2, j, j2, 1.0f)) {
                this.mHandler.post(new Runnable() {
                    /* class com.coolapk.market.imageloader.GlideProgressHelper.DispatchingProgressListener.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        EventBus.getDefault().post(new ImageLoadEvent(httpUrl2, j, j2));
                    }
                });
            }
        }

        @Override // com.coolapk.market.imageloader.GlideProgressHelper.ResponseProgressListener
        public void close(HttpUrl httpUrl) {
            final String httpUrl2 = httpUrl.toString();
            Integer num = this.mListeners.get(httpUrl2);
            if (num != null && num.intValue() > 0) {
                this.mHandler.post(new Runnable() {
                    /* class com.coolapk.market.imageloader.GlideProgressHelper.DispatchingProgressListener.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        EventBus.getDefault().post(new ImageLoadEvent(httpUrl2, true));
                    }
                });
            }
        }

        private boolean needsDispatch(String str, long j, long j2, float f) {
            if (!(f == 0.0f || j == 0 || j2 == j)) {
                long j3 = (long) (((((float) j) * 100.0f) / ((float) j2)) / f);
                Long l = this.mDispatchedProgress.get(str);
                if (l != null && j3 == l.longValue()) {
                    return false;
                }
                this.mDispatchedProgress.put(str, Long.valueOf(j3));
            }
            return true;
        }
    }

    private static class OkHttpProgressResponseBody extends ResponseBody {
        private BufferedSource bufferedSource;
        private final ResponseProgressListener progressListener;
        private final ResponseBody responseBody;
        private final HttpUrl url;

        OkHttpProgressResponseBody(HttpUrl httpUrl, ResponseBody responseBody2, ResponseProgressListener responseProgressListener) {
            this.url = httpUrl;
            this.responseBody = responseBody2;
            this.progressListener = responseProgressListener;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.responseBody.contentType();
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.responseBody.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            if (this.bufferedSource == null) {
                this.bufferedSource = Okio.buffer(source(this.responseBody.source()));
            }
            return this.bufferedSource;
        }

        private Source source(Source source) {
            this.progressListener.update(this.url, 0, Long.MAX_VALUE);
            return new ForwardingSource(source) {
                /* class com.coolapk.market.imageloader.GlideProgressHelper.OkHttpProgressResponseBody.AnonymousClass1 */
                long totalBytesRead = 0;

                @Override // okio.ForwardingSource, okio.Source
                public long read(Buffer buffer, long j) throws IOException {
                    long read = super.read(buffer, j);
                    long contentLength = OkHttpProgressResponseBody.this.responseBody.contentLength();
                    if (read == -1) {
                        this.totalBytesRead = contentLength;
                    } else {
                        this.totalBytesRead += read;
                    }
                    OkHttpProgressResponseBody.this.progressListener.update(OkHttpProgressResponseBody.this.url, this.totalBytesRead, contentLength);
                    return read;
                }
            };
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            super.close();
            this.progressListener.close(this.url);
        }
    }
}
