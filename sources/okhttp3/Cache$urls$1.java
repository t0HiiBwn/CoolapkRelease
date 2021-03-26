package okhttp3;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import okhttp3.internal.cache.DiskLruCache;
import okio.Okio;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0010)\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\t\u001a\u00020\u0004H\u0002J\t\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0006R\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"okhttp3/Cache$urls$1", "", "", "canRemove", "", "delegate", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "nextUrl", "hasNext", "next", "remove", "", "okhttp"}, k = 1, mv = {1, 4, 0})
/* compiled from: Cache.kt */
public final class Cache$urls$1 implements Iterator<String>, KMutableIterator {
    private boolean canRemove;
    private final Iterator<DiskLruCache.Snapshot> delegate;
    private String nextUrl;
    final /* synthetic */ Cache this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    Cache$urls$1(Cache cache) {
        this.this$0 = cache;
        this.delegate = cache.getCache$okhttp().snapshots();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        throw r4;
     */
    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nextUrl != null) {
            return true;
        }
        this.canRemove = false;
        while (this.delegate.hasNext()) {
            try {
                DiskLruCache.Snapshot next = this.delegate.next();
                Throwable th = null;
                this.nextUrl = Okio.buffer(next.getSource(0)).readUtf8LineStrict();
                CloseableKt.closeFinally(next, th);
                return true;
            } catch (IOException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public String next() {
        if (hasNext()) {
            String str = this.nextUrl;
            Intrinsics.checkNotNull(str);
            this.nextUrl = null;
            this.canRemove = true;
            return str;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        if (this.canRemove) {
            this.delegate.remove();
            return;
        }
        throw new IllegalStateException("remove() before next()".toString());
    }
}
