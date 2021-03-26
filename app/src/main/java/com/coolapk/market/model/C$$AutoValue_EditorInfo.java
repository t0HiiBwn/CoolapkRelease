package com.coolapk.market.model;

import com.coolapk.market.model.EditorInfo;

/* renamed from: com.coolapk.market.model.$$AutoValue_EditorInfo  reason: invalid class name */
abstract class C$$AutoValue_EditorInfo extends EditorInfo {
    private final String editorLevel;
    private final int newFollowNum;
    private final int newSubmitNum;

    C$$AutoValue_EditorInfo(String str, int i, int i2) {
        this.editorLevel = str;
        this.newSubmitNum = i;
        this.newFollowNum = i2;
    }

    @Override // com.coolapk.market.model.EditorInfo
    public String getEditorLevel() {
        return this.editorLevel;
    }

    @Override // com.coolapk.market.model.EditorInfo
    public int getNewSubmitNum() {
        return this.newSubmitNum;
    }

    @Override // com.coolapk.market.model.EditorInfo
    public int getNewFollowNum() {
        return this.newFollowNum;
    }

    @Override // java.lang.Object
    public String toString() {
        return "EditorInfo{editorLevel=" + this.editorLevel + ", newSubmitNum=" + this.newSubmitNum + ", newFollowNum=" + this.newFollowNum + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EditorInfo)) {
            return false;
        }
        EditorInfo editorInfo = (EditorInfo) obj;
        String str = this.editorLevel;
        if (str != null ? str.equals(editorInfo.getEditorLevel()) : editorInfo.getEditorLevel() == null) {
            if (this.newSubmitNum == editorInfo.getNewSubmitNum() && this.newFollowNum == editorInfo.getNewFollowNum()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.editorLevel;
        return (((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.newSubmitNum) * 1000003) ^ this.newFollowNum;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_EditorInfo$Builder */
    /* compiled from: $$AutoValue_EditorInfo */
    static final class Builder extends EditorInfo.Builder {
        private String editorLevel;
        private Integer newFollowNum;
        private Integer newSubmitNum;

        Builder() {
        }

        Builder(EditorInfo editorInfo) {
            this.editorLevel = editorInfo.getEditorLevel();
            this.newSubmitNum = Integer.valueOf(editorInfo.getNewSubmitNum());
            this.newFollowNum = Integer.valueOf(editorInfo.getNewFollowNum());
        }

        @Override // com.coolapk.market.model.EditorInfo.Builder
        public EditorInfo.Builder editorLevel(String str) {
            this.editorLevel = str;
            return this;
        }

        @Override // com.coolapk.market.model.EditorInfo.Builder
        public EditorInfo.Builder newSubmitNum(int i) {
            this.newSubmitNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.EditorInfo.Builder
        public EditorInfo.Builder newFollowNum(int i) {
            this.newFollowNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.EditorInfo.Builder
        public EditorInfo build() {
            String str = "";
            if (this.newSubmitNum == null) {
                str = str + " newSubmitNum";
            }
            if (this.newFollowNum == null) {
                str = str + " newFollowNum";
            }
            if (str.isEmpty()) {
                return new AutoValue_EditorInfo(this.editorLevel, this.newSubmitNum.intValue(), this.newFollowNum.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
