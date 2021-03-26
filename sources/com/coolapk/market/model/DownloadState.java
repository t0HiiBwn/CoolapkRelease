package com.coolapk.market.model;

import android.text.TextUtils;
import com.coolapk.market.model.AutoValue_DownloadState;
import com.coolapk.market.util.StringUtils;

public abstract class DownloadState extends State {
    public static final int STATE_CANCEL = 5;
    public static final int STATE_ERROR = 6;
    public static final int STATE_NONE = 0;
    public static final int STATE_RUNNING = 3;
    public static final int STATE_START = 2;
    public static final int STATE_SUCCESS = 4;
    public static final int STATE_WAIT = 1;
    private String filePathMd5;
    private String key;

    public static abstract class Builder {
        public abstract DownloadState build();

        public abstract Builder currentLength(long j);

        public abstract Builder dbId(Long l);

        public abstract Builder diffLength(long j);

        public abstract Builder diffTime(long j);

        public abstract Builder error(Throwable th);

        public abstract Builder extra(Extra extra);

        public abstract Builder fileName(String str);

        public abstract Builder filePath(String str);

        public abstract Builder mimeType(String str);

        public abstract Builder startTime(long j);

        public abstract Builder state(int i);

        public abstract Builder totalLength(long j);

        public abstract Builder updateTime(long j);

        public abstract Builder url(String str);
    }

    public static String getStateString(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "NONE" : "CANCEL" : "SUCCESS" : "RUNNING" : "START" : "WAIT";
    }

    public abstract long getCurrentLength();

    public abstract Long getDbId();

    public abstract long getDiffLength();

    public abstract long getDiffTime();

    public abstract Throwable getError();

    public abstract Extra getExtra();

    public abstract String getFileName();

    public abstract String getFilePath();

    public abstract String getMimeType();

    @Override // com.coolapk.market.model.State
    public abstract long getStartTime();

    public abstract int getState();

    public abstract long getTotalLength();

    public abstract long getUpdateTime();

    public abstract String getUrl();

    public static String generateUriKey(String str) {
        return StringUtils.toMd5(str);
    }

    @Override // com.coolapk.market.model.State
    public String getKey() {
        if (this.key == null) {
            this.key = StringUtils.toMd5(getUrl());
        }
        return this.key;
    }

    public String getFilePathMd5() {
        if (this.filePathMd5 == null && !TextUtils.isEmpty(getFilePath())) {
            this.filePathMd5 = StringUtils.toMd5(getFilePath());
        }
        return this.filePathMd5;
    }

    public boolean isFinish() {
        return isSuccess() || getState() == 5 || getState() == 6;
    }

    public boolean isRunning() {
        return getState() == 1 || getState() == 2 || getState() == 3;
    }

    public boolean isSuccess() {
        return getState() == 4 || (getState() == 0 && getTotalLength() > 0 && getCurrentLength() == getTotalLength());
    }

    public static Builder newBuilder(String str) {
        return new AutoValue_DownloadState.Builder().url(str).diffTime(0).diffLength(0);
    }

    public static Builder newBuilder(DownloadState downloadState) {
        return new AutoValue_DownloadState.Builder(downloadState);
    }
}
