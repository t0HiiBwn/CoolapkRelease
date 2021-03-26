package com.coolapk.market.model;

import com.coolapk.market.model.InstallState;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$AutoValue_InstallState  reason: invalid class name */
abstract class C$AutoValue_InstallState extends InstallState {
    private final String apkFilePath;
    private final int errorCode;
    private final String errorMessage;
    private final Extra extra;
    private final String from;
    private final String path;
    private final long startTime;
    private final int state;
    private final long updateTime;

    C$AutoValue_InstallState(String str, int i, String str2, Extra extra2, long j, long j2, int i2, String str3, String str4) {
        this.from = str;
        this.state = i;
        Objects.requireNonNull(str2, "Null path");
        this.path = str2;
        this.extra = extra2;
        this.updateTime = j;
        this.startTime = j2;
        this.errorCode = i2;
        this.errorMessage = str3;
        this.apkFilePath = str4;
    }

    @Override // com.coolapk.market.model.InstallState
    public String getFrom() {
        return this.from;
    }

    @Override // com.coolapk.market.model.InstallState
    public int getState() {
        return this.state;
    }

    @Override // com.coolapk.market.model.InstallState
    public String getPath() {
        return this.path;
    }

    @Override // com.coolapk.market.model.InstallState
    public Extra getExtra() {
        return this.extra;
    }

    @Override // com.coolapk.market.model.InstallState
    public long getUpdateTime() {
        return this.updateTime;
    }

    @Override // com.coolapk.market.model.InstallState, com.coolapk.market.model.State
    public long getStartTime() {
        return this.startTime;
    }

    @Override // com.coolapk.market.model.InstallState
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override // com.coolapk.market.model.InstallState
    public String getErrorMessage() {
        return this.errorMessage;
    }

    @Override // com.coolapk.market.model.InstallState
    public String getApkFilePath() {
        return this.apkFilePath;
    }

    @Override // java.lang.Object
    public String toString() {
        return "InstallState{from=" + this.from + ", state=" + this.state + ", path=" + this.path + ", extra=" + this.extra + ", updateTime=" + this.updateTime + ", startTime=" + this.startTime + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", apkFilePath=" + this.apkFilePath + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        Extra extra2;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallState)) {
            return false;
        }
        InstallState installState = (InstallState) obj;
        String str2 = this.from;
        if (str2 != null ? str2.equals(installState.getFrom()) : installState.getFrom() == null) {
            if (this.state == installState.getState() && this.path.equals(installState.getPath()) && ((extra2 = this.extra) != null ? extra2.equals(installState.getExtra()) : installState.getExtra() == null) && this.updateTime == installState.getUpdateTime() && this.startTime == installState.getStartTime() && this.errorCode == installState.getErrorCode() && ((str = this.errorMessage) != null ? str.equals(installState.getErrorMessage()) : installState.getErrorMessage() == null)) {
                String str3 = this.apkFilePath;
                if (str3 == null) {
                    if (installState.getApkFilePath() == null) {
                        return true;
                    }
                } else if (str3.equals(installState.getApkFilePath())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.from;
        int i = 0;
        int hashCode = ((((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.state) * 1000003) ^ this.path.hashCode()) * 1000003;
        Extra extra2 = this.extra;
        int hashCode2 = extra2 == null ? 0 : extra2.hashCode();
        long j = this.updateTime;
        long j2 = this.startTime;
        int i2 = ((((int) (((long) (((int) (((long) ((hashCode ^ hashCode2) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003)) ^ (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.errorCode) * 1000003;
        String str2 = this.errorMessage;
        int hashCode3 = (i2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.apkFilePath;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_InstallState$Builder */
    static final class Builder extends InstallState.Builder {
        private String apkFilePath;
        private Integer errorCode;
        private String errorMessage;
        private Extra extra;
        private String from;
        private String path;
        private Long startTime;
        private Integer state;
        private Long updateTime;

        Builder() {
        }

        Builder(InstallState installState) {
            this.from = installState.getFrom();
            this.state = Integer.valueOf(installState.getState());
            this.path = installState.getPath();
            this.extra = installState.getExtra();
            this.updateTime = Long.valueOf(installState.getUpdateTime());
            this.startTime = Long.valueOf(installState.getStartTime());
            this.errorCode = Integer.valueOf(installState.getErrorCode());
            this.errorMessage = installState.getErrorMessage();
            this.apkFilePath = installState.getApkFilePath();
        }

        @Override // com.coolapk.market.model.InstallState.Builder
        public InstallState.Builder from(String str) {
            this.from = str;
            return this;
        }

        @Override // com.coolapk.market.model.InstallState.Builder
        public InstallState.Builder state(int i) {
            this.state = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.InstallState.Builder
        public InstallState.Builder path(String str) {
            this.path = str;
            return this;
        }

        @Override // com.coolapk.market.model.InstallState.Builder
        public InstallState.Builder extra(Extra extra2) {
            this.extra = extra2;
            return this;
        }

        @Override // com.coolapk.market.model.InstallState.Builder
        public InstallState.Builder updateTime(long j) {
            this.updateTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.InstallState.Builder
        public InstallState.Builder startTime(long j) {
            this.startTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.InstallState.Builder
        public InstallState.Builder errorCode(int i) {
            this.errorCode = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.InstallState.Builder
        public InstallState.Builder errorMessage(String str) {
            this.errorMessage = str;
            return this;
        }

        @Override // com.coolapk.market.model.InstallState.Builder
        public InstallState.Builder apkFilePath(String str) {
            this.apkFilePath = str;
            return this;
        }

        @Override // com.coolapk.market.model.InstallState.Builder
        public InstallState build() {
            String str = "";
            if (this.state == null) {
                str = str + " state";
            }
            if (this.path == null) {
                str = str + " path";
            }
            if (this.updateTime == null) {
                str = str + " updateTime";
            }
            if (this.startTime == null) {
                str = str + " startTime";
            }
            if (this.errorCode == null) {
                str = str + " errorCode";
            }
            if (str.isEmpty()) {
                return new AutoValue_InstallState(this.from, this.state.intValue(), this.path, this.extra, this.updateTime.longValue(), this.startTime.longValue(), this.errorCode.intValue(), this.errorMessage, this.apkFilePath);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
