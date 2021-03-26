package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$AutoValue_InstallState;
import com.coolapk.market.util.StringUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class InstallState extends State implements Parcelable {
    public static final int ERROR_CODE_FILE_NOT_FOUND = -2;
    public static final int ERROR_CODE_MD5_NOT_MATCH = -5;
    public static final int ERROR_CODE_NONE = 0;
    public static final int ERROR_CODE_PACKAGE_NAME_NOT_MATCH = -6;
    public static final int ERROR_CODE_PACKAGE_PARSE = -3;
    public static final int ERROR_CODE_SAME_PACKAGE = -8;
    public static final int ERROR_CODE_SIGNATURES_NOT_MATCH = -4;
    public static final int ERROR_CODE_UNKNOWN = -1;
    public static final int ERROR_CODE_UNSUPPORTED_FILE = -7;
    public static final int STATE_COMPLETE = 7;
    public static final int STATE_INSTALLING = 6;
    public static final int STATE_NONE = 0;
    public static final int STATE_PATCH = 3;
    public static final int STATE_START = 2;
    public static final int STATE_UNPACKING = 4;
    public static final int STATE_VERIFY = 5;
    public static final int STATE_WAIT = 1;
    private String pathMd5;

    public static abstract class Builder {
        public abstract Builder apkFilePath(String str);

        public abstract InstallState build();

        public abstract Builder errorCode(int i);

        public abstract Builder errorMessage(String str);

        public abstract Builder extra(Extra extra);

        public abstract Builder from(String str);

        public abstract Builder path(String str);

        public abstract Builder startTime(long j);

        public abstract Builder state(int i);

        public abstract Builder updateTime(long j);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorCode {
    }

    public static String getStateString(int i) {
        switch (i) {
            case 1:
                return "WAIT";
            case 2:
                return "START";
            case 3:
                return "PATCH";
            case 4:
                return "UNPACKING";
            case 5:
                return "VERIFY";
            case 6:
                return "INSTALLING";
            case 7:
                return "COMPLETE";
            default:
                return "NONE";
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract String getApkFilePath();

    public abstract int getErrorCode();

    public abstract String getErrorMessage();

    public abstract Extra getExtra();

    public abstract String getFrom();

    public abstract String getPath();

    @Override // com.coolapk.market.model.State
    public abstract long getStartTime();

    public abstract int getState();

    public abstract long getUpdateTime();

    public static String generateUriKey(String str) {
        return StringUtils.toMd5(str);
    }

    @Override // com.coolapk.market.model.State
    public String getKey() {
        return getPathMd5();
    }

    public String getPathMd5() {
        if (this.pathMd5 == null) {
            this.pathMd5 = StringUtils.toMd5(getPath());
        }
        return this.pathMd5;
    }

    public boolean hasError() {
        return getErrorCode() != 0;
    }

    public boolean isComplete() {
        return getState() == 7;
    }

    public static Builder newBuilder() {
        return new C$AutoValue_InstallState.Builder().errorCode(0);
    }

    public static Builder newBuilder(InstallState installState) {
        return new C$AutoValue_InstallState.Builder(installState).errorCode(installState.getErrorCode());
    }
}
