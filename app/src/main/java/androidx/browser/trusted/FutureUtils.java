package androidx.browser.trusted;

import androidx.concurrent.futures.ResolvableFuture;
import com.google.common.util.concurrent.ListenableFuture;

class FutureUtils {
    static <T> ListenableFuture<T> immediateFailedFuture(Throwable th) {
        ResolvableFuture create = ResolvableFuture.create();
        create.setException(th);
        return create;
    }

    private FutureUtils() {
    }
}
