package com.coolapk.market.model;

import com.coolapk.market.model.CollectionItem;
import com.google.gson.annotations.SerializedName;

/* renamed from: com.coolapk.market.model.$$AutoValue_CollectionItem  reason: invalid class name */
abstract class C$$AutoValue_CollectionItem extends CollectionItem {
    private final String collectionId;
    private final String content;
    private final String id;
    private final int isDelete;
    private final int isTop;
    private final String targetType;
    private final String targetUid;
    private final String uid;

    C$$AutoValue_CollectionItem(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
        this.id = str;
        this.collectionId = str2;
        this.uid = str3;
        this.targetUid = str4;
        this.content = str5;
        this.targetType = str6;
        this.isTop = i;
        this.isDelete = i2;
    }

    @Override // com.coolapk.market.model.CollectionItem
    @SerializedName("id")
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.CollectionItem
    @SerializedName("collection_id")
    public String getCollectionId() {
        return this.collectionId;
    }

    @Override // com.coolapk.market.model.CollectionItem
    @SerializedName("uid")
    public String getUid() {
        return this.uid;
    }

    @Override // com.coolapk.market.model.CollectionItem
    @SerializedName("target_uid")
    public String getTargetUid() {
        return this.targetUid;
    }

    @Override // com.coolapk.market.model.CollectionItem
    public String getContent() {
        return this.content;
    }

    @Override // com.coolapk.market.model.CollectionItem
    @SerializedName("target_type")
    public String getTargetType() {
        return this.targetType;
    }

    @Override // com.coolapk.market.model.CollectionItem
    @SerializedName("is_top")
    public int getIsTop() {
        return this.isTop;
    }

    @Override // com.coolapk.market.model.CollectionItem
    @SerializedName("is_delete")
    public int getIsDelete() {
        return this.isDelete;
    }

    @Override // java.lang.Object
    public String toString() {
        return "CollectionItem{id=" + this.id + ", collectionId=" + this.collectionId + ", uid=" + this.uid + ", targetUid=" + this.targetUid + ", content=" + this.content + ", targetType=" + this.targetType + ", isTop=" + this.isTop + ", isDelete=" + this.isDelete + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CollectionItem)) {
            return false;
        }
        CollectionItem collectionItem = (CollectionItem) obj;
        String str = this.id;
        if (str != null ? str.equals(collectionItem.getId()) : collectionItem.getId() == null) {
            String str2 = this.collectionId;
            if (str2 != null ? str2.equals(collectionItem.getCollectionId()) : collectionItem.getCollectionId() == null) {
                String str3 = this.uid;
                if (str3 != null ? str3.equals(collectionItem.getUid()) : collectionItem.getUid() == null) {
                    String str4 = this.targetUid;
                    if (str4 != null ? str4.equals(collectionItem.getTargetUid()) : collectionItem.getTargetUid() == null) {
                        String str5 = this.content;
                        if (str5 != null ? str5.equals(collectionItem.getContent()) : collectionItem.getContent() == null) {
                            String str6 = this.targetType;
                            if (str6 != null ? str6.equals(collectionItem.getTargetType()) : collectionItem.getTargetType() == null) {
                                if (this.isTop == collectionItem.getIsTop() && this.isDelete == collectionItem.getIsDelete()) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.collectionId;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.uid;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.targetUid;
        int hashCode4 = (hashCode3 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.content;
        int hashCode5 = (hashCode4 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.targetType;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return ((((hashCode5 ^ i) * 1000003) ^ this.isTop) * 1000003) ^ this.isDelete;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_CollectionItem$Builder */
    /* compiled from: $$AutoValue_CollectionItem */
    static final class Builder extends CollectionItem.Builder {
        private String collectionId;
        private String content;
        private String id;
        private Integer isDelete;
        private Integer isTop;
        private String targetType;
        private String targetUid;
        private String uid;

        Builder() {
        }

        Builder(CollectionItem collectionItem) {
            this.id = collectionItem.getId();
            this.collectionId = collectionItem.getCollectionId();
            this.uid = collectionItem.getUid();
            this.targetUid = collectionItem.getTargetUid();
            this.content = collectionItem.getContent();
            this.targetType = collectionItem.getTargetType();
            this.isTop = Integer.valueOf(collectionItem.getIsTop());
            this.isDelete = Integer.valueOf(collectionItem.getIsDelete());
        }

        @Override // com.coolapk.market.model.CollectionItem.Builder
        public CollectionItem.Builder id(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.CollectionItem.Builder
        public CollectionItem.Builder collectionId(String str) {
            this.collectionId = str;
            return this;
        }

        @Override // com.coolapk.market.model.CollectionItem.Builder
        public CollectionItem.Builder uid(String str) {
            this.uid = str;
            return this;
        }

        @Override // com.coolapk.market.model.CollectionItem.Builder
        public CollectionItem.Builder targetUid(String str) {
            this.targetUid = str;
            return this;
        }

        @Override // com.coolapk.market.model.CollectionItem.Builder
        public CollectionItem.Builder content(String str) {
            this.content = str;
            return this;
        }

        @Override // com.coolapk.market.model.CollectionItem.Builder
        public CollectionItem.Builder targetType(String str) {
            this.targetType = str;
            return this;
        }

        @Override // com.coolapk.market.model.CollectionItem.Builder
        public CollectionItem.Builder isTop(int i) {
            this.isTop = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.CollectionItem.Builder
        public CollectionItem.Builder isDelete(int i) {
            this.isDelete = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.CollectionItem.Builder
        public CollectionItem build() {
            String str = "";
            if (this.isTop == null) {
                str = str + " isTop";
            }
            if (this.isDelete == null) {
                str = str + " isDelete";
            }
            if (str.isEmpty()) {
                return new AutoValue_CollectionItem(this.id, this.collectionId, this.uid, this.targetUid, this.content, this.targetType, this.isTop.intValue(), this.isDelete.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
