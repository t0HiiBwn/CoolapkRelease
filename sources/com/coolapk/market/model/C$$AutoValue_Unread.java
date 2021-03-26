package com.coolapk.market.model;

import com.coolapk.market.model.Unread;
import com.google.gson.annotations.SerializedName;

/* renamed from: com.coolapk.market.model.$$AutoValue_Unread  reason: invalid class name */
abstract class C$$AutoValue_Unread extends Unread {
    private final int unreadNum;
    private final String unreadTitle;

    C$$AutoValue_Unread(String str, int i) {
        this.unreadTitle = str;
        this.unreadNum = i;
    }

    @Override // com.coolapk.market.model.Unread
    @SerializedName("title")
    public String getUnreadTitle() {
        return this.unreadTitle;
    }

    @Override // com.coolapk.market.model.Unread
    @SerializedName("num")
    public int getUnreadNum() {
        return this.unreadNum;
    }

    @Override // java.lang.Object
    public String toString() {
        return "Unread{unreadTitle=" + this.unreadTitle + ", unreadNum=" + this.unreadNum + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Unread)) {
            return false;
        }
        Unread unread = (Unread) obj;
        String str = this.unreadTitle;
        if (str != null ? str.equals(unread.getUnreadTitle()) : unread.getUnreadTitle() == null) {
            if (this.unreadNum == unread.getUnreadNum()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.unreadTitle;
        return (((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.unreadNum;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_Unread$Builder */
    /* compiled from: $$AutoValue_Unread */
    static final class Builder extends Unread.Builder {
        private Integer unreadNum;
        private String unreadTitle;

        Builder() {
        }

        Builder(Unread unread) {
            this.unreadTitle = unread.getUnreadTitle();
            this.unreadNum = Integer.valueOf(unread.getUnreadNum());
        }

        @Override // com.coolapk.market.model.Unread.Builder
        public Unread.Builder unreadTitle(String str) {
            this.unreadTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.Unread.Builder
        public Unread.Builder unreadNum(int i) {
            this.unreadNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Unread.Builder
        public Unread build() {
            String str = "";
            if (this.unreadNum == null) {
                str = str + " unreadNum";
            }
            if (str.isEmpty()) {
                return new AutoValue_Unread(this.unreadTitle, this.unreadNum.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
