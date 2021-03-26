package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$AutoValue_DownloadInfo;
import com.coolapk.market.util.StringUtils;

public abstract class DownloadInfo implements Parcelable {
    private Extra extra;
    private String filePathMd5;
    private String urlMd5;

    public static abstract class Builder {
        public abstract Builder apkFilePath(String str);

        public abstract DownloadInfo build();

        public abstract Builder createTime(long j);

        public abstract Builder currentLength(long j);

        public abstract Builder dbId(long j);

        public abstract Builder extraString(String str);

        public abstract Builder fileName(String str);

        public abstract Builder filePath(String str);

        public abstract Builder mimeType(String str);

        public abstract Builder startTime(long j);

        public abstract Builder totalLength(long j);

        public abstract Builder updateTime(long j);

        public abstract Builder url(String str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract String getApkFilePath();

    public abstract long getCreateTime();

    public abstract long getCurrentLength();

    public abstract long getDbId();

    public abstract String getExtraString();

    public abstract String getFileName();

    public abstract String getFilePath();

    public abstract String getMimeType();

    public abstract long getStartTime();

    public abstract long getTotalLength();

    public abstract long getUpdateTime();

    public abstract String getUrl();

    public String getUrlMd5() {
        if (this.urlMd5 == null) {
            this.urlMd5 = StringUtils.toMd5(getUrl());
        }
        return this.urlMd5;
    }

    public String getFilePathMd5() {
        if (this.filePathMd5 == null) {
            this.filePathMd5 = StringUtils.toMd5(getFilePath());
        }
        return this.filePathMd5;
    }

    public Extra getExtra() {
        if (this.extra == null) {
            this.extra = new Extra(getExtraString());
        }
        return this.extra;
    }

    public static Builder newBuilder() {
        return new C$AutoValue_DownloadInfo.Builder();
    }
}
