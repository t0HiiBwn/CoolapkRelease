package rx.plugins;

import rx.exceptions.Exceptions;

public abstract class RxJavaErrorHandler {
    protected static final String ERROR_IN_RENDERING_SUFFIX = ".errorRendering";

    @Deprecated
    public void handleError(Throwable th) {
    }

    protected String render(Object obj) throws InterruptedException {
        return null;
    }

    public final String handleOnNextValueRendering(Object obj) {
        try {
            return render(obj);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + ".errorRendering";
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            return obj.getClass().getName() + ".errorRendering";
        }
    }
}
