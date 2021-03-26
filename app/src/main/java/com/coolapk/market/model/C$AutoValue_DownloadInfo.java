package com.coolapk.market.model;

import com.coolapk.market.model.DownloadInfo;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$AutoValue_DownloadInfo  reason: invalid class name */
abstract class C$AutoValue_DownloadInfo extends DownloadInfo {
    private final String apkFilePath;
    private final long createTime;
    private final long currentLength;
    private final long dbId;
    private final String extraString;
    private final String fileName;
    private final String filePath;
    private final String mimeType;
    private final long startTime;
    private final long totalLength;
    private final long updateTime;
    private final String url;

    C$AutoValue_DownloadInfo(long j, String str, String str2, String str3, String str4, long j2, long j3, String str5, String str6, long j4, long j5, long j6) {
        this.dbId = j;
        Objects.requireNonNull(str, "Null url");
        this.url = str;
        this.filePath = str2;
        this.apkFilePath = str3;
        Objects.requireNonNull(str4, "Null fileName");
        this.fileName = str4;
        this.currentLength = j2;
        this.totalLength = j3;
        this.mimeType = str5;
        this.extraString = str6;
        this.createTime = j4;
        this.startTime = j5;
        this.updateTime = j6;
    }

    @Override // com.coolapk.market.model.DownloadInfo
    public long getDbId() {
        return this.dbId;
    }

    @Override // com.coolapk.market.model.DownloadInfo
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.DownloadInfo
    public String getFilePath() {
        return this.filePath;
    }

    @Override // com.coolapk.market.model.DownloadInfo
    public String getApkFilePath() {
        return this.apkFilePath;
    }

    @Override // com.coolapk.market.model.DownloadInfo
    public String getFileName() {
        return this.fileName;
    }

    @Override // com.coolapk.market.model.DownloadInfo
    public long getCurrentLength() {
        return this.currentLength;
    }

    @Override // com.coolapk.market.model.DownloadInfo
    public long getTotalLength() {
        return this.totalLength;
    }

    @Override // com.coolapk.market.model.DownloadInfo
    public String getMimeType() {
        return this.mimeType;
    }

    @Override // com.coolapk.market.model.DownloadInfo
    public String getExtraString() {
        return this.extraString;
    }

    @Override // com.coolapk.market.model.DownloadInfo
    public long getCreateTime() {
        return this.createTime;
    }

    @Override // com.coolapk.market.model.DownloadInfo
    public long getStartTime() {
        return this.startTime;
    }

    @Override // com.coolapk.market.model.DownloadInfo
    public long getUpdateTime() {
        return this.updateTime;
    }

    @Override // java.lang.Object
    public String toString() {
        return "DownloadInfo{dbId=" + this.dbId + ", url=" + this.url + ", filePath=" + this.filePath + ", apkFilePath=" + this.apkFilePath + ", fileName=" + this.fileName + ", currentLength=" + this.currentLength + ", totalLength=" + this.totalLength + ", mimeType=" + this.mimeType + ", extraString=" + this.extraString + ", createTime=" + this.createTime + ", startTime=" + this.startTime + ", updateTime=" + this.updateTime + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DownloadInfo)) {
            return false;
        }
        DownloadInfo downloadInfo = (DownloadInfo) obj;
        if (this.dbId != downloadInfo.getDbId() || !this.url.equals(downloadInfo.getUrl()) || ((str = this.filePath) != null ? !str.equals(downloadInfo.getFilePath()) : downloadInfo.getFilePath() != null) || ((str2 = this.apkFilePath) != null ? !str2.equals(downloadInfo.getApkFilePath()) : downloadInfo.getApkFilePath() != null) || !this.fileName.equals(downloadInfo.getFileName()) || this.currentLength != downloadInfo.getCurrentLength() || this.totalLength != downloadInfo.getTotalLength() || ((str3 = this.mimeType) != null ? !str3.equals(downloadInfo.getMimeType()) : downloadInfo.getMimeType() != null) || ((str4 = this.extraString) != null ? !str4.equals(downloadInfo.getExtraString()) : downloadInfo.getExtraString() != null) || this.createTime != downloadInfo.getCreateTime() || this.startTime != downloadInfo.getStartTime() || this.updateTime != downloadInfo.getUpdateTime()) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        long j = this.dbId;
        int hashCode = (this.url.hashCode() ^ (((int) (((long) 1000003) ^ (j ^ (j >>> 32)))) * 1000003)) * 1000003;
        String str = this.filePath;
        int i = 0;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.apkFilePath;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        long j2 = this.currentLength;
        long j3 = this.totalLength;
        int hashCode4 = ((int) (((long) (((int) (((long) ((((hashCode2 ^ hashCode3) * 1000003) ^ this.fileName.hashCode()) * 1000003)) ^ (j2 ^ (j2 >>> 32)))) * 1000003)) ^ (j3 ^ (j3 >>> 32)))) * 1000003;
        String str3 = this.mimeType;
        int hashCode5 = ((str3 == null ? 0 : str3.hashCode()) ^ hashCode4) * 1000003;
        String str4 = this.extraString;
        if (str4 != null) {
            i = str4.hashCode();
        }
        long j4 = this.createTime;
        long j5 = this.startTime;
        long j6 = (long) (((int) (((long) (((int) (((long) ((hashCode5 ^ i) * 1000003)) ^ (j4 ^ (j4 >>> 32)))) * 1000003)) ^ (j5 ^ (j5 >>> 32)))) * 1000003);
        long j7 = this.updateTime;
        return (int) (j6 ^ (j7 ^ (j7 >>> 32)));
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_DownloadInfo$Builder */
    static final class Builder extends DownloadInfo.Builder {
        private String apkFilePath;
        private Long createTime;
        private Long currentLength;
        private Long dbId;
        private String extraString;
        private String fileName;
        private String filePath;
        private String mimeType;
        private Long startTime;
        private Long totalLength;
        private Long updateTime;
        private String url;

        Builder() {
        }

        Builder(DownloadInfo downloadInfo) {
            this.dbId = Long.valueOf(downloadInfo.getDbId());
            this.url = downloadInfo.getUrl();
            this.filePath = downloadInfo.getFilePath();
            this.apkFilePath = downloadInfo.getApkFilePath();
            this.fileName = downloadInfo.getFileName();
            this.currentLength = Long.valueOf(downloadInfo.getCurrentLength());
            this.totalLength = Long.valueOf(downloadInfo.getTotalLength());
            this.mimeType = downloadInfo.getMimeType();
            this.extraString = downloadInfo.getExtraString();
            this.createTime = Long.valueOf(downloadInfo.getCreateTime());
            this.startTime = Long.valueOf(downloadInfo.getStartTime());
            this.updateTime = Long.valueOf(downloadInfo.getUpdateTime());
        }

        @Override // com.coolapk.market.model.DownloadInfo.Builder
        public DownloadInfo.Builder dbId(long j) {
            this.dbId = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.DownloadInfo.Builder
        public DownloadInfo.Builder url(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.DownloadInfo.Builder
        public DownloadInfo.Builder filePath(String str) {
            this.filePath = str;
            return this;
        }

        @Override // com.coolapk.market.model.DownloadInfo.Builder
        public DownloadInfo.Builder apkFilePath(String str) {
            this.apkFilePath = str;
            return this;
        }

        @Override // com.coolapk.market.model.DownloadInfo.Builder
        public DownloadInfo.Builder fileName(String str) {
            this.fileName = str;
            return this;
        }

        @Override // com.coolapk.market.model.DownloadInfo.Builder
        public DownloadInfo.Builder currentLength(long j) {
            this.currentLength = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.DownloadInfo.Builder
        public DownloadInfo.Builder totalLength(long j) {
            this.totalLength = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.DownloadInfo.Builder
        public DownloadInfo.Builder mimeType(String str) {
            this.mimeType = str;
            return this;
        }

        @Override // com.coolapk.market.model.DownloadInfo.Builder
        public DownloadInfo.Builder extraString(String str) {
            this.extraString = str;
            return this;
        }

        @Override // com.coolapk.market.model.DownloadInfo.Builder
        public DownloadInfo.Builder createTime(long j) {
            this.createTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.DownloadInfo.Builder
        public DownloadInfo.Builder startTime(long j) {
            this.startTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.DownloadInfo.Builder
        public DownloadInfo.Builder updateTime(long j) {
            this.updateTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.DownloadInfo.Builder
        public DownloadInfo build() {
            String str = "";
            if (this.dbId == null) {
                str = str + " dbId";
            }
            if (this.url == null) {
                str = str + " url";
            }
            if (this.fileName == null) {
                str = str + " fileName";
            }
            if (this.currentLength == null) {
                str = str + " currentLength";
            }
            if (this.totalLength == null) {
                str = str + " totalLength";
            }
            if (this.createTime == null) {
                str = str + " createTime";
            }
            if (this.startTime == null) {
                str = str + " startTime";
            }
            if (this.updateTime == null) {
                str = str + " updateTime";
            }
            if (str.isEmpty()) {
                return new AutoValue_DownloadInfo(this.dbId.longValue(), this.url, this.filePath, this.apkFilePath, this.fileName, this.currentLength.longValue(), this.totalLength.longValue(), this.mimeType, this.extraString, this.createTime.longValue(), this.startTime.longValue(), this.updateTime.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
