package com.coolapk.market.model;

import com.coolapk.market.model.RelatedData;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_RelatedData  reason: invalid class name */
abstract class C$$AutoValue_RelatedData extends RelatedData {
    private final String deprecatedUserAvatar;
    private final String deprecatedUserName;
    private final String displayUserName;
    private final String id;
    private final String uid;
    private final UserInfo userInfo;
    private final int value;

    C$$AutoValue_RelatedData(String str, UserInfo userInfo2, String str2, String str3, String str4, String str5, int i) {
        this.deprecatedUserAvatar = str;
        this.userInfo = userInfo2;
        this.deprecatedUserName = str2;
        this.displayUserName = str3;
        this.id = str4;
        Objects.requireNonNull(str5, "Null uid");
        this.uid = str5;
        this.value = i;
    }

    @Override // com.coolapk.market.model.IUser
    @SerializedName("userAvatar")
    public String getDeprecatedUserAvatar() {
        return this.deprecatedUserAvatar;
    }

    @Override // com.coolapk.market.model.IUser
    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    @Override // com.coolapk.market.model.IUser
    @SerializedName("username")
    public String getDeprecatedUserName() {
        return this.deprecatedUserName;
    }

    @Override // com.coolapk.market.model.IUser
    @SerializedName("displayUsername")
    public String getDisplayUserName() {
        return this.displayUserName;
    }

    @Override // com.coolapk.market.model.RelatedData
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.RelatedData, com.coolapk.market.model.IUser
    public String getUid() {
        return this.uid;
    }

    @Override // com.coolapk.market.model.RelatedData
    public int getValue() {
        return this.value;
    }

    @Override // java.lang.Object
    public String toString() {
        return "RelatedData{deprecatedUserAvatar=" + this.deprecatedUserAvatar + ", userInfo=" + this.userInfo + ", deprecatedUserName=" + this.deprecatedUserName + ", displayUserName=" + this.displayUserName + ", id=" + this.id + ", uid=" + this.uid + ", value=" + this.value + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RelatedData)) {
            return false;
        }
        RelatedData relatedData = (RelatedData) obj;
        String str = this.deprecatedUserAvatar;
        if (str != null ? str.equals(relatedData.getDeprecatedUserAvatar()) : relatedData.getDeprecatedUserAvatar() == null) {
            UserInfo userInfo2 = this.userInfo;
            if (userInfo2 != null ? userInfo2.equals(relatedData.getUserInfo()) : relatedData.getUserInfo() == null) {
                String str2 = this.deprecatedUserName;
                if (str2 != null ? str2.equals(relatedData.getDeprecatedUserName()) : relatedData.getDeprecatedUserName() == null) {
                    String str3 = this.displayUserName;
                    if (str3 != null ? str3.equals(relatedData.getDisplayUserName()) : relatedData.getDisplayUserName() == null) {
                        String str4 = this.id;
                        if (str4 != null ? str4.equals(relatedData.getId()) : relatedData.getId() == null) {
                            if (this.uid.equals(relatedData.getUid()) && this.value == relatedData.getValue()) {
                                return true;
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
        String str = this.deprecatedUserAvatar;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        UserInfo userInfo2 = this.userInfo;
        int hashCode2 = (hashCode ^ (userInfo2 == null ? 0 : userInfo2.hashCode())) * 1000003;
        String str2 = this.deprecatedUserName;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.displayUserName;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.id;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return ((((hashCode4 ^ i) * 1000003) ^ this.uid.hashCode()) * 1000003) ^ this.value;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_RelatedData$Builder */
    /* compiled from: $$AutoValue_RelatedData */
    static final class Builder extends RelatedData.Builder {
        private String deprecatedUserAvatar;
        private String deprecatedUserName;
        private String displayUserName;
        private String id;
        private String uid;
        private UserInfo userInfo;
        private Integer value;

        Builder() {
        }

        Builder(RelatedData relatedData) {
            this.deprecatedUserAvatar = relatedData.getDeprecatedUserAvatar();
            this.userInfo = relatedData.getUserInfo();
            this.deprecatedUserName = relatedData.getDeprecatedUserName();
            this.displayUserName = relatedData.getDisplayUserName();
            this.id = relatedData.getId();
            this.uid = relatedData.getUid();
            this.value = Integer.valueOf(relatedData.getValue());
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public RelatedData.Builder setDeprecatedUserAvatar(String str) {
            this.deprecatedUserAvatar = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public RelatedData.Builder setUserInfo(UserInfo userInfo2) {
            this.userInfo = userInfo2;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public RelatedData.Builder setDeprecatedUserName(String str) {
            this.deprecatedUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public RelatedData.Builder setDisplayUserName(String str) {
            this.displayUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.RelatedData.Builder
        public RelatedData.Builder setId(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public RelatedData.Builder setUid(String str) {
            this.uid = str;
            return this;
        }

        @Override // com.coolapk.market.model.RelatedData.Builder
        public RelatedData.Builder setValue(int i) {
            this.value = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.RelatedData.Builder
        public RelatedData build() {
            String str = "";
            if (this.uid == null) {
                str = str + " uid";
            }
            if (this.value == null) {
                str = str + " value";
            }
            if (str.isEmpty()) {
                return new AutoValue_RelatedData(this.deprecatedUserAvatar, this.userInfo, this.deprecatedUserName, this.displayUserName, this.id, this.uid, this.value.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
