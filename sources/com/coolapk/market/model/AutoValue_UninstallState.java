package com.coolapk.market.model;

import com.coolapk.market.model.UninstallState;

final class AutoValue_UninstallState extends UninstallState {
    private final int errorCode;
    private final String packageName;
    private final long startTime;
    private final int state;
    private final String title;
    private final long updateTime;

    private AutoValue_UninstallState(int i, String str, String str2, long j, long j2, int i2) {
        this.state = i;
        this.packageName = str;
        this.title = str2;
        this.updateTime = j;
        this.startTime = j2;
        this.errorCode = i2;
    }

    @Override // com.coolapk.market.model.UninstallState
    public int getState() {
        return this.state;
    }

    @Override // com.coolapk.market.model.UninstallState
    public String getPackageName() {
        return this.packageName;
    }

    @Override // com.coolapk.market.model.UninstallState
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.UninstallState
    public long getUpdateTime() {
        return this.updateTime;
    }

    @Override // com.coolapk.market.model.UninstallState, com.coolapk.market.model.State
    public long getStartTime() {
        return this.startTime;
    }

    @Override // com.coolapk.market.model.UninstallState
    public int getErrorCode() {
        return this.errorCode;
    }

    public String toString() {
        return "UninstallState{state=" + this.state + ", packageName=" + this.packageName + ", title=" + this.title + ", updateTime=" + this.updateTime + ", startTime=" + this.startTime + ", errorCode=" + this.errorCode + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UninstallState)) {
            return false;
        }
        UninstallState uninstallState = (UninstallState) obj;
        if (this.state == uninstallState.getState() && this.packageName.equals(uninstallState.getPackageName()) && this.title.equals(uninstallState.getTitle()) && this.updateTime == uninstallState.getUpdateTime() && this.startTime == uninstallState.getStartTime() && this.errorCode == uninstallState.getErrorCode()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.updateTime;
        long j2 = this.startTime;
        return (((int) (((long) (((int) (((long) ((((((this.state ^ 1000003) * 1000003) ^ this.packageName.hashCode()) * 1000003) ^ this.title.hashCode()) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003)) ^ (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.errorCode;
    }

    static final class Builder extends UninstallState.Builder {
        private Integer errorCode;
        private String packageName;
        private Long startTime;
        private Integer state;
        private String title;
        private Long updateTime;

        Builder() {
        }

        Builder(UninstallState uninstallState) {
            this.state = Integer.valueOf(uninstallState.getState());
            this.packageName = uninstallState.getPackageName();
            this.title = uninstallState.getTitle();
            this.updateTime = Long.valueOf(uninstallState.getUpdateTime());
            this.startTime = Long.valueOf(uninstallState.getStartTime());
            this.errorCode = Integer.valueOf(uninstallState.getErrorCode());
        }

        @Override // com.coolapk.market.model.UninstallState.Builder
        public UninstallState.Builder state(int i) {
            this.state = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UninstallState.Builder
        public UninstallState.Builder packageName(String str) {
            this.packageName = str;
            return this;
        }

        @Override // com.coolapk.market.model.UninstallState.Builder
        public UninstallState.Builder title(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.UninstallState.Builder
        public UninstallState.Builder updateTime(long j) {
            this.updateTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.UninstallState.Builder
        public UninstallState.Builder startTime(long j) {
            this.startTime = Long.valueOf(j);
            return this;
        }

        @Override // com.coolapk.market.model.UninstallState.Builder
        public UninstallState.Builder errorCode(int i) {
            this.errorCode = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.UninstallState.Builder
        public UninstallState build() {
            String str = "";
            if (this.state == null) {
                str = str + " state";
            }
            if (this.packageName == null) {
                str = str + " packageName";
            }
            if (this.title == null) {
                str = str + " title";
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
                return new AutoValue_UninstallState(this.state.intValue(), this.packageName, this.title, this.updateTime.longValue(), this.startTime.longValue(), this.errorCode.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
