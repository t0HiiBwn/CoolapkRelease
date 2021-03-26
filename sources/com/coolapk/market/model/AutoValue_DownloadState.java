package com.coolapk.market.model;

import com.coolapk.market.model.DownloadState;

final class AutoValue_DownloadState extends DownloadState {
    private final long currentLength;
    private final Long dbId;
    private final long diffLength;
    private final long diffTime;
    private final Throwable error;
    private final Extra extra;
    private final String fileName;
    private final String filePath;
    private final String mimeType;
    private final long startTime;
    private final int state;
    private final long totalLength;
    private final long updateTime;
    private final String url;

    private AutoValue_DownloadState(Long l, String str, int i, long j, long j2, long j3, String str2, String str3, String str4, Extra extra2, long j4, long j5, long j6, Throwable th) {
        this.dbId = l;
        this.url = str;
        this.state = i;
        this.currentLength = j;
        this.totalLength = j2;
        this.diffLength = j3;
        this.filePath = str2;
        this.fileName = str3;
        this.mimeType = str4;
        this.extra = extra2;
        this.startTime = j4;
        this.updateTime = j5;
        this.diffTime = j6;
        this.error = th;
    }

    @Override // com.coolapk.market.model.DownloadState
    public Long getDbId() {
        return this.dbId;
    }

    @Override // com.coolapk.market.model.DownloadState
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.DownloadState
    public int getState() {
        return this.state;
    }

    @Override // com.coolapk.market.model.DownloadState
    public long getCurrentLength() {
        return this.currentLength;
    }

    @Override // com.coolapk.market.model.DownloadState
    public long getTotalLength() {
        return this.totalLength;
    }

    @Override // com.coolapk.market.model.DownloadState
    public long getDiffLength() {
        return this.diffLength;
    }

    @Override // com.coolapk.market.model.DownloadState
    public String getFilePath() {
        return this.filePath;
    }

    @Override // com.coolapk.market.model.DownloadState
    public String getFileName() {
        return this.fileName;
    }

    @Override // com.coolapk.market.model.DownloadState
    public String getMimeType() {
        return this.mimeType;
    }

    @Override // com.coolapk.market.model.DownloadState
    public Extra getExtra() {
        return this.extra;
    }

    @Override // com.coolapk.market.model.DownloadState, com.coolapk.market.model.State
    public long getStartTime() {
        return this.startTime;
    }

    @Override // com.coolapk.market.model.DownloadState
    public long getUpdateTime() {
        return this.updateTime;
    }

    @Override // com.coolapk.market.model.DownloadState
    public long getDiffTime() {
        return this.diffTime;
    }

    @Override // com.coolapk.market.model.DownloadState
    public Throwable getError() {
        return this.error;
    }

    public String toString() {
        return "DownloadState{dbId=" + this.dbId + ", url=" + this.url + ", state=" + this.state + ", currentLength=" + this.currentLength + ", totalLength=" + this.totalLength + ", diffLength=" + this.diffLength + ", filePath=" + this.filePath + ", fileName=" + this.fileName + ", mimeType=" + this.mimeType + ", extra=" + this.extra + ", startTime=" + this.startTime + ", updateTime=" + this.updateTime + ", diffTime=" + this.diffTime + ", error=" + this.error + "}";
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        Extra extra2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DownloadState)) {
            return false;
        }
        DownloadState downloadState = (DownloadState) obj;
        Long l = this.dbId;
        if (l != null ? l.equals(downloadState.getDbId()) : downloadState.getDbId() == null) {
            if (this.url.equals(downloadState.getUrl()) && this.state == downloadState.getState() && this.currentLength == downloadState.getCurrentLength() && this.totalLength == downloadState.getTotalLength() && this.diffLength == downloadState.getDiffLength() && ((str = this.filePath) != null ? str.equals(downloadState.getFilePath()) : downloadState.getFilePath() == null) && this.fileName.equals(downloadState.getFileName()) && ((str2 = this.mimeType) != null ? str2.equals(downloadState.getMimeType()) : downloadState.getMimeType() == null) && ((extra2 = this.extra) != null ? extra2.equals(downloadState.getExtra()) : downloadState.getExtra() == null) && this.startTime == downloadState.getStartTime() && this.updateTime == downloadState.getUpdateTime() && this.diffTime == downloadState.getDiffTime()) {
                Throwable th = this.error;
                if (th == null) {
                    if (downloadState.getError() == null) {
                        return true;
                    }
                } else if (th.equals(downloadState.getError())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Long l = this.dbId;
        int i = 0;
        int hashCode = l == null ? 0 : l.hashCode();
        long j = this.currentLength;
        long j2 = this.totalLength;
        long j3 = this.diffLength;
        int hashCode2 = ((int) (((long) (((int) (((long) (((int) (((long) ((((((hashCode ^ 1000003) * 1000003) ^ this.url.hashCode()) * 1000003) ^ this.state) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003)) ^ (j2 ^ (j2 >>> 32)))) * 1000003)) ^ (j3 ^ (j3 >>> 32)))) * 1000003;
        String str = this.filePath;
        int hashCode3 = ((((str == null ? 0 : str.hashCode()) ^ hashCode2) * 1000003) ^ this.fileName.hashCode()) * 1000003;
        String str2 = this.mimeType;
        int hashCode4 = (hashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        Extra extra2 = this.extra;
        int hashCode5 = extra2 == null ? 0 : extra2.hashCode();
        long j4 = this.startTime;
        long j5 = this.updateTime;
        long j6 = this.diffTime;
        int i2 = ((int) (((long) (((int) (((long) (((int) (((long) ((hashCode4 ^ hashCode5) * 1000003)) ^ (j4 ^ (j4 >>> 32)))) * 1000003)) ^ (j5 ^ (j5 >>> 32)))) * 1000003)) ^ (j6 ^ (j6 >>> 32)))) * 1000003;
        Throwable th = this.error;
        if (th != null) {
            i = th.hashCode();
        }
        return i2 ^ i;
    }

    static final class Builder extends DownloadState.Builder {
        private Long currentLength;
        private Long dbId;
        private Long diffLength;
        private Long diffTime;
        private Throwable error;
        private Extra extra;
        private String fileName;
        private String filePath;
        private String mimeType;
        private Long startTime;
        private Integer state;
        private Long totalLength;
        private Long updateTime;
        private String url;

        Builder() {
        }

        Builder(DownloadState downloadState) {
            this.dbId = downloadState.getDbId();
            this.url = downloadState.getUrl();
            this.state = Integer.valueOf(downloadState.getState());
            this.currentLength = Long.valueOf(downloadState.getCurrentLength());
            this.totalLength = Long.valueOf(downloadState.getTotalLength());
            this.diffLength = Long.valueOf(downloadState.getDiffLength());
            this.filePath = downloadState.getFilePath();
            this.fileName = downloadState.getFileName();
            this.mimeType = downloadState.getMimeType();
            this.extra = downloadState.getExtra();
            this.startTime = Long.valueOf(downloadState.getStartTime());
            this.updateTime = Long.valueOf(downloadState.getUpdateTime());
            this.diffTime = Long.valueOf(downloadState.getDiffTime());
            this.error = downloadState.getError();
        }

        @Override // com.coolapk.market.model.DownloadState.Builder
        public DownloadState.Builder dbId(Long l) {
            this.dbId = l;
            return this;
        }

        @Override // com.coolapk.market.model.DownloadState.Builder
        public DownloadState.Builder url(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.DownloadState.Builder
        public DownloadState.Builder state(int i) {
            this.state = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.DownloadState.Builder
        public DownloadState.Builder currentLength(long j) {
            this.currentLength = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.DownloadState.Builder
        public DownloadState.Builder totalLength(long j) {
            this.totalLength = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.DownloadState.Builder
        public DownloadState.Builder diffLength(long j) {
            this.diffLength = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.DownloadState.Builder
        public DownloadState.Builder filePath(String str) {
            this.filePath = str;
            return this;
        }

        @Override // com.coolapk.market.model.DownloadState.Builder
        public DownloadState.Builder fileName(String str) {
            this.fileName = str;
            return this;
        }

        @Override // com.coolapk.market.model.DownloadState.Builder
        public DownloadState.Builder mimeType(String str) {
            this.mimeType = str;
            return this;
        }

        @Override // com.coolapk.market.model.DownloadState.Builder
        public DownloadState.Builder extra(Extra extra2) {
            this.extra = extra2;
            return this;
        }

        @Override // com.coolapk.market.model.DownloadState.Builder
        public DownloadState.Builder startTime(long j) {
            this.startTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.DownloadState.Builder
        public DownloadState.Builder updateTime(long j) {
            this.updateTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.DownloadState.Builder
        public DownloadState.Builder diffTime(long j) {
            this.diffTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.DownloadState.Builder
        public DownloadState.Builder error(Throwable th) {
            this.error = th;
            return this;
        }

        @Override // com.coolapk.market.model.DownloadState.Builder
        public DownloadState build() {
            String str = "";
            if (this.url == null) {
                str = str + " url";
            }
            if (this.state == null) {
                str = str + " state";
            }
            if (this.currentLength == null) {
                str = str + " currentLength";
            }
            if (this.totalLength == null) {
                str = str + " totalLength";
            }
            if (this.diffLength == null) {
                str = str + " diffLength";
            }
            if (this.fileName == null) {
                str = str + " fileName";
            }
            if (this.startTime == null) {
                str = str + " startTime";
            }
            if (this.updateTime == null) {
                str = str + " updateTime";
            }
            if (this.diffTime == null) {
                str = str + " diffTime";
            }
            if (str.isEmpty()) {
                return new AutoValue_DownloadState(this.dbId, this.url, this.state.intValue(), this.currentLength.longValue(), this.totalLength.longValue(), this.diffLength.longValue(), this.filePath, this.fileName, this.mimeType, this.extra, this.startTime.longValue(), this.updateTime.longValue(), this.diffTime.longValue(), this.error);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
