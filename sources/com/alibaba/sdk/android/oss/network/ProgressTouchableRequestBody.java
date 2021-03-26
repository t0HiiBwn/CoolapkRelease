package com.alibaba.sdk.android.oss.network;

import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

public class ProgressTouchableRequestBody<T extends OSSRequest> extends RequestBody {
    private static final int SEGMENT_SIZE = 2048;
    private OSSProgressCallback callback;
    private long contentLength;
    private String contentType;
    private InputStream inputStream;
    private T request;

    public ProgressTouchableRequestBody(InputStream inputStream2, long j, String str, ExecutionContext executionContext) {
        this.inputStream = inputStream2;
        this.contentType = str;
        this.contentLength = j;
        this.callback = executionContext.getProgressCallback();
        this.request = (T) executionContext.getRequest();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return MediaType.parse(this.contentType);
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        return this.contentLength;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Source source = Okio.source(this.inputStream);
        long j = 0;
        while (true) {
            long j2 = this.contentLength;
            if (j >= j2) {
                break;
            }
            long read = source.read(bufferedSink.buffer(), Math.min(j2 - j, 2048L));
            if (read == -1) {
                break;
            }
            j += read;
            bufferedSink.flush();
            OSSProgressCallback oSSProgressCallback = this.callback;
            if (!(oSSProgressCallback == null || j == 0)) {
                oSSProgressCallback.onProgress(this.request, j, this.contentLength);
            }
        }
        if (source != null) {
            source.close();
        }
    }
}
