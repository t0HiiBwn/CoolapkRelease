package okhttp3.internal.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"okhttp3/internal/cache/CacheInterceptor$cacheWritingResponse$cacheWritingSource$1", "Lokio/Source;", "cacheRequestClosed", "", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "okhttp"}, k = 1, mv = {1, 4, 0})
/* compiled from: CacheInterceptor.kt */
public final class CacheInterceptor$cacheWritingResponse$cacheWritingSource$1 implements Source {
    final /* synthetic */ BufferedSink $cacheBody;
    final /* synthetic */ CacheRequest $cacheRequest;
    final /* synthetic */ BufferedSource $source;
    private boolean cacheRequestClosed;

    CacheInterceptor$cacheWritingResponse$cacheWritingSource$1(BufferedSource bufferedSource, CacheRequest cacheRequest, BufferedSink bufferedSink) {
        this.$source = bufferedSource;
        this.$cacheRequest = cacheRequest;
        this.$cacheBody = bufferedSink;
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        try {
            long read = this.$source.read(buffer, j);
            if (read == -1) {
                if (!this.cacheRequestClosed) {
                    this.cacheRequestClosed = true;
                    this.$cacheBody.close();
                }
                return -1;
            }
            buffer.copyTo(this.$cacheBody.getBuffer(), buffer.size() - read, read);
            this.$cacheBody.emitCompleteSegments();
            return read;
        } catch (IOException e) {
            if (!this.cacheRequestClosed) {
                this.cacheRequestClosed = true;
                this.$cacheRequest.abort();
            }
            throw e;
        }
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.$source.timeout();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
            this.cacheRequestClosed = true;
            this.$cacheRequest.abort();
        }
        this.$source.close();
    }
}
