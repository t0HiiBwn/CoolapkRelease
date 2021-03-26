package rx;

import rx.exceptions.MissingBackpressureException;

public final class BackpressureOverflow {
    public static final Strategy ON_OVERFLOW_DEFAULT;
    public static final Strategy ON_OVERFLOW_DROP_LATEST = DropLatest.INSTANCE;
    public static final Strategy ON_OVERFLOW_DROP_OLDEST = DropOldest.INSTANCE;
    public static final Strategy ON_OVERFLOW_ERROR;

    public interface Strategy {
        boolean mayAttemptDrop() throws MissingBackpressureException;
    }

    private BackpressureOverflow() {
        throw new IllegalStateException("No instances!");
    }

    static {
        Error error = Error.INSTANCE;
        ON_OVERFLOW_ERROR = error;
        ON_OVERFLOW_DEFAULT = error;
    }

    static final class DropOldest implements Strategy {
        static final DropOldest INSTANCE = new DropOldest();

        @Override // rx.BackpressureOverflow.Strategy
        public boolean mayAttemptDrop() {
            return true;
        }

        private DropOldest() {
        }
    }

    static final class DropLatest implements Strategy {
        static final DropLatest INSTANCE = new DropLatest();

        @Override // rx.BackpressureOverflow.Strategy
        public boolean mayAttemptDrop() {
            return false;
        }

        private DropLatest() {
        }
    }

    static final class Error implements Strategy {
        static final Error INSTANCE = new Error();

        private Error() {
        }

        @Override // rx.BackpressureOverflow.Strategy
        public boolean mayAttemptDrop() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
