package com.coolapk.market.model;

import com.coolapk.market.model.FeedDraft;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$AutoValue_FeedDraft  reason: invalid class name */
abstract class C$AutoValue_FeedDraft extends FeedDraft {
    private final String extraData;
    private final String extraId;
    private final List<ImageUrl> imageUriList;
    private final String message;
    private final String type;

    C$AutoValue_FeedDraft(String str, String str2, String str3, List<ImageUrl> list, String str4) {
        Objects.requireNonNull(str, "Null type");
        this.type = str;
        this.extraId = str2;
        this.extraData = str3;
        Objects.requireNonNull(list, "Null imageUriList");
        this.imageUriList = list;
        this.message = str4;
    }

    @Override // com.coolapk.market.model.FeedDraft
    public String getType() {
        return this.type;
    }

    @Override // com.coolapk.market.model.FeedDraft
    public String getExtraId() {
        return this.extraId;
    }

    @Override // com.coolapk.market.model.FeedDraft
    public String getExtraData() {
        return this.extraData;
    }

    @Override // com.coolapk.market.model.FeedDraft
    public List<ImageUrl> getImageUriList() {
        return this.imageUriList;
    }

    @Override // com.coolapk.market.model.FeedDraft
    public String getMessage() {
        return this.message;
    }

    @Override // java.lang.Object
    public String toString() {
        return "FeedDraft{type=" + this.type + ", extraId=" + this.extraId + ", extraData=" + this.extraData + ", imageUriList=" + this.imageUriList + ", message=" + this.message + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeedDraft)) {
            return false;
        }
        FeedDraft feedDraft = (FeedDraft) obj;
        if (this.type.equals(feedDraft.getType()) && ((str = this.extraId) != null ? str.equals(feedDraft.getExtraId()) : feedDraft.getExtraId() == null) && ((str2 = this.extraData) != null ? str2.equals(feedDraft.getExtraData()) : feedDraft.getExtraData() == null) && this.imageUriList.equals(feedDraft.getImageUriList())) {
            String str3 = this.message;
            if (str3 == null) {
                if (feedDraft.getMessage() == null) {
                    return true;
                }
            } else if (str3.equals(feedDraft.getMessage())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int hashCode = (this.type.hashCode() ^ 1000003) * 1000003;
        String str = this.extraId;
        int i = 0;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.extraData;
        int hashCode3 = (((hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003) ^ this.imageUriList.hashCode()) * 1000003;
        String str3 = this.message;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$AutoValue_FeedDraft$Builder */
    static final class Builder extends FeedDraft.Builder {
        private String extraData;
        private String extraId;
        private List<ImageUrl> imageUriList;
        private String message;
        private String type;

        Builder() {
        }

        Builder(FeedDraft feedDraft) {
            this.type = feedDraft.getType();
            this.extraId = feedDraft.getExtraId();
            this.extraData = feedDraft.getExtraData();
            this.imageUriList = feedDraft.getImageUriList();
            this.message = feedDraft.getMessage();
        }

        @Override // com.coolapk.market.model.FeedDraft.Builder
        public FeedDraft.Builder setType(String str) {
            this.type = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedDraft.Builder
        public FeedDraft.Builder setExtraId(String str) {
            this.extraId = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedDraft.Builder
        public FeedDraft.Builder setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedDraft.Builder
        public FeedDraft.Builder setImageUriList(List<ImageUrl> list) {
            this.imageUriList = list;
            return this;
        }

        @Override // com.coolapk.market.model.FeedDraft.Builder
        public FeedDraft.Builder setMessage(String str) {
            this.message = str;
            return this;
        }

        @Override // com.coolapk.market.model.FeedDraft.Builder
        public FeedDraft build() {
            String str = "";
            if (this.type == null) {
                str = str + " type";
            }
            if (this.imageUriList == null) {
                str = str + " imageUriList";
            }
            if (str.isEmpty()) {
                return new AutoValue_FeedDraft(this.type, this.extraId, this.extraData, this.imageUriList, this.message);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
