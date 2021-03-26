package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"okio/Pipe$sink$1", "Lokio/Sink;", "timeout", "Lokio/Timeout;", "close", "", "flush", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k = 1, mv = {1, 4, 0})
/* compiled from: Pipe.kt */
public final class Pipe$sink$1 implements Sink {
    final /* synthetic */ Pipe this$0;
    private final Timeout timeout = new Timeout();

    /* JADX WARN: Incorrect args count in method signature: ()V */
    Pipe$sink$1(Pipe pipe) {
        this.this$0 = pipe;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "source");
        Sink sink = null;
        synchronized (this.this$0.getBuffer$okio()) {
            if (!(!this.this$0.getSinkClosed$okio())) {
                throw new IllegalStateException("closed".toString());
            } else if (!this.this$0.getCanceled$okio()) {
                while (true) {
                    if (j <= 0) {
                        break;
                    }
                    Sink foldedSink$okio = this.this$0.getFoldedSink$okio();
                    if (foldedSink$okio != null) {
                        sink = foldedSink$okio;
                        break;
                    } else if (!this.this$0.getSourceClosed$okio()) {
                        long maxBufferSize$okio = this.this$0.getMaxBufferSize$okio() - this.this$0.getBuffer$okio().size();
                        if (maxBufferSize$okio == 0) {
                            this.timeout.waitUntilNotified(this.this$0.getBuffer$okio());
                            if (this.this$0.getCanceled$okio()) {
                                throw new IOException("canceled");
                            }
                        } else {
                            long min = Math.min(maxBufferSize$okio, j);
                            this.this$0.getBuffer$okio().write(buffer, min);
                            j -= min;
                            Buffer buffer$okio = this.this$0.getBuffer$okio();
                            if (buffer$okio != null) {
                                buffer$okio.notifyAll();
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                            }
                        }
                    } else {
                        throw new IOException("source is closed");
                    }
                }
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IOException("canceled");
            }
        }
        if (sink != null) {
            Pipe pipe = this.this$0;
            Timeout timeout2 = sink.timeout();
            Timeout timeout3 = pipe.sink().timeout();
            long timeoutNanos = timeout2.timeoutNanos();
            timeout2.timeout(Timeout.Companion.minTimeout(timeout3.timeoutNanos(), timeout2.timeoutNanos()), TimeUnit.NANOSECONDS);
            if (timeout2.hasDeadline()) {
                long deadlineNanoTime = timeout2.deadlineNanoTime();
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(Math.min(timeout2.deadlineNanoTime(), timeout3.deadlineNanoTime()));
                }
                try {
                    sink.write(buffer, j);
                } finally {
                    timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout3.hasDeadline()) {
                        timeout2.deadlineNanoTime(deadlineNanoTime);
                    }
                }
            } else {
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(timeout3.deadlineNanoTime());
                }
                try {
                    sink.write(buffer, j);
                } finally {
                    timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout3.hasDeadline()) {
                        timeout2.clearDeadline();
                    }
                }
            }
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        Sink sink = null;
        synchronized (this.this$0.getBuffer$okio()) {
            if (!(!this.this$0.getSinkClosed$okio())) {
                throw new IllegalStateException("closed".toString());
            } else if (!this.this$0.getCanceled$okio()) {
                Sink foldedSink$okio = this.this$0.getFoldedSink$okio();
                if (foldedSink$okio != null) {
                    sink = foldedSink$okio;
                } else if (this.this$0.getSourceClosed$okio()) {
                    if (this.this$0.getBuffer$okio().size() > 0) {
                        throw new IOException("source is closed");
                    }
                }
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IOException("canceled");
            }
        }
        if (sink != null) {
            Pipe pipe = this.this$0;
            Timeout timeout2 = sink.timeout();
            Timeout timeout3 = pipe.sink().timeout();
            long timeoutNanos = timeout2.timeoutNanos();
            timeout2.timeout(Timeout.Companion.minTimeout(timeout3.timeoutNanos(), timeout2.timeoutNanos()), TimeUnit.NANOSECONDS);
            if (timeout2.hasDeadline()) {
                long deadlineNanoTime = timeout2.deadlineNanoTime();
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(Math.min(timeout2.deadlineNanoTime(), timeout3.deadlineNanoTime()));
                }
                try {
                    sink.flush();
                } finally {
                    timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout3.hasDeadline()) {
                        timeout2.deadlineNanoTime(deadlineNanoTime);
                    }
                }
            } else {
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(timeout3.deadlineNanoTime());
                }
                try {
                    sink.flush();
                } finally {
                    timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout3.hasDeadline()) {
                        timeout2.clearDeadline();
                    }
                }
            }
        }
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Sink sink = null;
        synchronized (this.this$0.getBuffer$okio()) {
            if (!this.this$0.getSinkClosed$okio()) {
                Sink foldedSink$okio = this.this$0.getFoldedSink$okio();
                if (foldedSink$okio != null) {
                    sink = foldedSink$okio;
                } else if (!this.this$0.getSourceClosed$okio() || this.this$0.getBuffer$okio().size() <= 0) {
                    this.this$0.setSinkClosed$okio(true);
                    Buffer buffer$okio = this.this$0.getBuffer$okio();
                    if (buffer$okio != null) {
                        buffer$okio.notifyAll();
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                    }
                } else {
                    throw new IOException("source is closed");
                }
                Unit unit = Unit.INSTANCE;
            } else {
                return;
            }
        }
        if (sink != null) {
            Pipe pipe = this.this$0;
            Timeout timeout2 = sink.timeout();
            Timeout timeout3 = pipe.sink().timeout();
            long timeoutNanos = timeout2.timeoutNanos();
            timeout2.timeout(Timeout.Companion.minTimeout(timeout3.timeoutNanos(), timeout2.timeoutNanos()), TimeUnit.NANOSECONDS);
            if (timeout2.hasDeadline()) {
                long deadlineNanoTime = timeout2.deadlineNanoTime();
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(Math.min(timeout2.deadlineNanoTime(), timeout3.deadlineNanoTime()));
                }
                try {
                    sink.close();
                } finally {
                    timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout3.hasDeadline()) {
                        timeout2.deadlineNanoTime(deadlineNanoTime);
                    }
                }
            } else {
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(timeout3.deadlineNanoTime());
                }
                try {
                    sink.close();
                } finally {
                    timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout3.hasDeadline()) {
                        timeout2.clearDeadline();
                    }
                }
            }
        }
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.timeout;
    }
}
