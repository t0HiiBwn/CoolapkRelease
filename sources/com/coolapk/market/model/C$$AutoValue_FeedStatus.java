package com.coolapk.market.model;

import com.coolapk.market.model.FeedStatus;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_FeedStatus  reason: invalid class name */
abstract class C$$AutoValue_FeedStatus extends FeedStatus {
    private final int blockStatus;
    private final String blockStatusText;
    private final int isHeadlineV8;
    private final int messageStatus;
    private final String messageStatusText;
    private final int recommend;
    private final int status;
    private final String statusText;

    C$$AutoValue_FeedStatus(int i, int i2, int i3, int i4, int i5, String str, String str2, String str3) {
        this.recommend = i;
        this.status = i2;
        this.messageStatus = i3;
        this.blockStatus = i4;
        this.isHeadlineV8 = i5;
        Objects.requireNonNull(str, "Null statusText");
        this.statusText = str;
        Objects.requireNonNull(str2, "Null messageStatusText");
        this.messageStatusText = str2;
        Objects.requireNonNull(str3, "Null blockStatusText");
        this.blockStatusText = str3;
    }

    @Override // com.coolapk.market.model.FeedStatus
    public int getRecommend() {
        return this.recommend;
    }

    @Override // com.coolapk.market.model.FeedStatus
    public int getStatus() {
        return this.status;
    }

    @Override // com.coolapk.market.model.FeedStatus
    @SerializedName("message_status")
    public int getMessageStatus() {
        return this.messageStatus;
    }

    @Override // com.coolapk.market.model.FeedStatus
    @SerializedName("block_status")
    public int getBlockStatus() {
        return this.blockStatus;
    }

    @Override // com.coolapk.market.model.FeedStatus
    public int getIsHeadlineV8() {
        return this.isHeadlineV8;
    }

    @Override // com.coolapk.market.model.FeedStatus
    public String getStatusText() {
        return this.statusText;
    }

    @Override // com.coolapk.market.model.FeedStatus
    public String getMessageStatusText() {
        return this.messageStatusText;
    }

    @Override // com.coolapk.market.model.FeedStatus
    public String getBlockStatusText() {
        return this.blockStatusText;
    }

    @Override // java.lang.Object
    public String toString() {
        return "FeedStatus{recommend=" + this.recommend + ", status=" + this.status + ", messageStatus=" + this.messageStatus + ", blockStatus=" + this.blockStatus + ", isHeadlineV8=" + this.isHeadlineV8 + ", statusText=" + this.statusText + ", messageStatusText=" + this.messageStatusText + ", blockStatusText=" + this.blockStatusText + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeedStatus)) {
            return false;
        }
        FeedStatus feedStatus = (FeedStatus) obj;
        if (this.recommend == feedStatus.getRecommend() && this.status == feedStatus.getStatus() && this.messageStatus == feedStatus.getMessageStatus() && this.blockStatus == feedStatus.getBlockStatus() && this.isHeadlineV8 == feedStatus.getIsHeadlineV8() && this.statusText.equals(feedStatus.getStatusText()) && this.messageStatusText.equals(feedStatus.getMessageStatusText()) && this.blockStatusText.equals(feedStatus.getBlockStatusText())) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((((((((((((((this.recommend ^ 1000003) * 1000003) ^ this.status) * 1000003) ^ this.messageStatus) * 1000003) ^ this.blockStatus) * 1000003) ^ this.isHeadlineV8) * 1000003) ^ this.statusText.hashCode()) * 1000003) ^ this.messageStatusText.hashCode()) * 1000003) ^ this.blockStatusText.hashCode();
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_FeedStatus$Builder */
    /* compiled from: $$AutoValue_FeedStatus */
    static final class Builder extends FeedStatus.Builder {
        private Integer blockStatus;
        private String blockStatusText;
        private Integer isHeadlineV8;
        private Integer messageStatus;
        private String messageStatusText;
        private Integer recommend;
        private Integer status;
        private String statusText;

        Builder() {
        }

        Builder(FeedStatus feedStatus) {
            this.recommend = Integer.valueOf(feedStatus.getRecommend());
            this.status = Integer.valueOf(feedStatus.getStatus());
            this.messageStatus = Integer.valueOf(feedStatus.getMessageStatus());
            this.blockStatus = Integer.valueOf(feedStatus.getBlockStatus());
            this.isHeadlineV8 = Integer.valueOf(feedStatus.getIsHeadlineV8());
            this.statusText = feedStatus.getStatusText();
            this.messageStatusText = feedStatus.getMessageStatusText();
            this.blockStatusText = feedStatus.getBlockStatusText();
        }

        @Override // com.coolapk.market.model.FeedStatus.Builder
        public FeedStatus.Builder recommend(int i) {
            this.recommend = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedStatus.Builder
        public FeedStatus.Builder status(int i) {
            this.status = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedStatus.Builder
        public FeedStatus.Builder messageStatus(int i) {
            this.messageStatus = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedStatus.Builder
        public FeedStatus.Builder blockStatus(int i) {
            this.blockStatus = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedStatus.Builder
        public FeedStatus.Builder isHeadlineV8(int i) {
            this.isHeadlineV8 = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.FeedStatus.Builder
        public FeedStatus.Builder statusText(String str) {
            this.statusText = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedStatus.Builder
        public FeedStatus.Builder messageStatusText(String str) {
            this.messageStatusText = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedStatus.Builder
        public FeedStatus.Builder blockStatusText(String str) {
            this.blockStatusText = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedStatus.Builder
        public FeedStatus build() {
            String str = "";
            if (this.recommend == null) {
                str = str + " recommend";
            }
            if (this.status == null) {
                str = str + " status";
            }
            if (this.messageStatus == null) {
                str = str + " messageStatus";
            }
            if (this.blockStatus == null) {
                str = str + " blockStatus";
            }
            if (this.isHeadlineV8 == null) {
                str = str + " isHeadlineV8";
            }
            if (this.statusText == null) {
                str = str + " statusText";
            }
            if (this.messageStatusText == null) {
                str = str + " messageStatusText";
            }
            if (this.blockStatusText == null) {
                str = str + " blockStatusText";
            }
            if (str.isEmpty()) {
                return new AutoValue_FeedStatus(this.recommend.intValue(), this.status.intValue(), this.messageStatus.intValue(), this.blockStatus.intValue(), this.isHeadlineV8.intValue(), this.statusText, this.messageStatusText, this.blockStatusText);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
