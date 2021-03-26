package androidx.work;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "R", "run", "androidx/work/ListenableFutureKt$await$2$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: ListenableFuture.kt */
public final class CoroutineWorker$await$$inlined$suspendCancellableCoroutine$lambda$2 implements Runnable {
    final /* synthetic */ CancellableContinuation $cancellableContinuation;
    final /* synthetic */ ListenableFuture $this_await$inlined;

    public CoroutineWorker$await$$inlined$suspendCancellableCoroutine$lambda$2(CancellableContinuation cancellableContinuation, ListenableFuture listenableFuture) {
        this.$cancellableContinuation = cancellableContinuation;
        this.$this_await$inlined = listenableFuture;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Object obj = this.$this_await$inlined.get();
            Result.Companion companion = Result.Companion;
            this.$cancellableContinuation.resumeWith(Result.m687constructorimpl(obj));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                cause = th;
            }
            if (th instanceof CancellationException) {
                this.$cancellableContinuation.cancel(cause);
                return;
            }
            Result.Companion companion2 = Result.Companion;
            this.$cancellableContinuation.resumeWith(Result.m687constructorimpl(ResultKt.createFailure(cause)));
        }
    }
}
