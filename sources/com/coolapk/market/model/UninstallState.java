package com.coolapk.market.model;

import com.coolapk.market.model.AutoValue_UninstallState;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class UninstallState extends State {
    public static final int ERROR_CODE_NONE = 0;
    public static final int ERROR_CODE_UNKNOWN = 1;
    public static final int STATE_COMPLETE = 3;
    public static final int STATE_NONE = 0;
    public static final int STATE_START = 2;
    public static final int STATE_WAIT = 1;

    public static abstract class Builder {
        public abstract UninstallState build();

        public abstract Builder errorCode(int i);

        public abstract Builder packageName(String str);

        public abstract Builder startTime(long j);

        public abstract Builder state(int i);

        public abstract Builder title(String str);

        public abstract Builder updateTime(long j);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorCode {
    }

    public abstract int getErrorCode();

    public abstract String getPackageName();

    @Override // com.coolapk.market.model.State
    public abstract long getStartTime();

    public abstract int getState();

    public abstract String getTitle();

    public abstract long getUpdateTime();

    @Override // com.coolapk.market.model.State
    public String getKey() {
        return getPackageName();
    }

    public boolean hasError() {
        return getErrorCode() != 0;
    }

    public static Builder newBuilder() {
        return new AutoValue_UninstallState.Builder().errorCode(0);
    }

    public static Builder newBuilder(UninstallState uninstallState) {
        return new AutoValue_UninstallState.Builder(uninstallState).errorCode(uninstallState.getErrorCode());
    }
}
