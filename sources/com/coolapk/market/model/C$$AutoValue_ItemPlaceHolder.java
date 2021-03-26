package com.coolapk.market.model;

import com.coolapk.market.model.ItemPlaceHolder;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_ItemPlaceHolder  reason: invalid class name */
abstract class C$$AutoValue_ItemPlaceHolder extends ItemPlaceHolder {
    private final CollectionItem collectionItemInfo;
    private final Long dateline;
    private final String deprecatedUserAvatar;
    private final String deprecatedUserName;
    private final String description;
    private final String displayUserName;
    private final DyhModel dyhModel;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityTypeName;
    private final String extraData;
    private final String id;
    private final Long lastUpdate;
    private final String logo;
    private final String pic;
    private final String subTitle;
    private final String title;
    private final String uid;
    private final String url;
    private final UserInfo userInfo;

    C$$AutoValue_ItemPlaceHolder(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l2, Long l3, String str11, UserInfo userInfo2, String str12, String str13, String str14, String str15, DyhModel dyhModel2, CollectionItem collectionItem) {
        this.entityTypeName = str;
        this.entityTemplate = str2;
        this.entityId = str3;
        this.entityFixed = num;
        this.url = str4;
        this.description = str5;
        this.pic = str6;
        this.logo = str7;
        this.subTitle = str8;
        this.id = str9;
        this.extraData = str10;
        this.dateline = l2;
        this.lastUpdate = l3;
        this.deprecatedUserAvatar = str11;
        this.userInfo = userInfo2;
        Objects.requireNonNull(str12, "Null uid");
        this.uid = str12;
        this.deprecatedUserName = str13;
        this.displayUserName = str14;
        this.title = str15;
        this.dyhModel = dyhModel2;
        this.collectionItemInfo = collectionItem;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityTypeName")
    public String getEntityTypeName() {
        return this.entityTypeName;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityTemplate")
    public String getEntityTemplate() {
        return this.entityTemplate;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityId")
    public String getEntityId() {
        return this.entityId;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityFixed")
    public Integer getEntityFixed() {
        return this.entityFixed;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("url")
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("description")
    public String getDescription() {
        return this.description;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("pic")
    public String getPic() {
        return this.pic;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("logo")
    public String getLogo() {
        return this.logo;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("subTitle")
    public String getSubTitle() {
        return this.subTitle;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("id")
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("extraData")
    public String getExtraData() {
        return this.extraData;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("dateline")
    public Long getDateline() {
        return this.dateline;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("lastupdate")
    public Long getLastUpdate() {
        return this.lastUpdate;
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
    public String getUid() {
        return this.uid;
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

    @Override // com.coolapk.market.model.ItemPlaceHolder, com.coolapk.market.model.Entity
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.ItemPlaceHolder
    @SerializedName("dyh_info")
    public DyhModel getDyhModel() {
        return this.dyhModel;
    }

    @Override // com.coolapk.market.model.ItemPlaceHolder
    @SerializedName("collection_item_info")
    public CollectionItem getCollectionItemInfo() {
        return this.collectionItemInfo;
    }

    @Override // java.lang.Object
    public String toString() {
        return "ItemPlaceHolder{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", deprecatedUserAvatar=" + this.deprecatedUserAvatar + ", userInfo=" + this.userInfo + ", uid=" + this.uid + ", deprecatedUserName=" + this.deprecatedUserName + ", displayUserName=" + this.displayUserName + ", title=" + this.title + ", dyhModel=" + this.dyhModel + ", collectionItemInfo=" + this.collectionItemInfo + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        DyhModel dyhModel2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemPlaceHolder)) {
            return false;
        }
        ItemPlaceHolder itemPlaceHolder = (ItemPlaceHolder) obj;
        String str4 = this.entityTypeName;
        if (str4 != null ? str4.equals(itemPlaceHolder.getEntityTypeName()) : itemPlaceHolder.getEntityTypeName() == null) {
            String str5 = this.entityTemplate;
            if (str5 != null ? str5.equals(itemPlaceHolder.getEntityTemplate()) : itemPlaceHolder.getEntityTemplate() == null) {
                String str6 = this.entityId;
                if (str6 != null ? str6.equals(itemPlaceHolder.getEntityId()) : itemPlaceHolder.getEntityId() == null) {
                    Integer num = this.entityFixed;
                    if (num != null ? num.equals(itemPlaceHolder.getEntityFixed()) : itemPlaceHolder.getEntityFixed() == null) {
                        String str7 = this.url;
                        if (str7 != null ? str7.equals(itemPlaceHolder.getUrl()) : itemPlaceHolder.getUrl() == null) {
                            String str8 = this.description;
                            if (str8 != null ? str8.equals(itemPlaceHolder.getDescription()) : itemPlaceHolder.getDescription() == null) {
                                String str9 = this.pic;
                                if (str9 != null ? str9.equals(itemPlaceHolder.getPic()) : itemPlaceHolder.getPic() == null) {
                                    String str10 = this.logo;
                                    if (str10 != null ? str10.equals(itemPlaceHolder.getLogo()) : itemPlaceHolder.getLogo() == null) {
                                        String str11 = this.subTitle;
                                        if (str11 != null ? str11.equals(itemPlaceHolder.getSubTitle()) : itemPlaceHolder.getSubTitle() == null) {
                                            String str12 = this.id;
                                            if (str12 != null ? str12.equals(itemPlaceHolder.getId()) : itemPlaceHolder.getId() == null) {
                                                String str13 = this.extraData;
                                                if (str13 != null ? str13.equals(itemPlaceHolder.getExtraData()) : itemPlaceHolder.getExtraData() == null) {
                                                    Long l2 = this.dateline;
                                                    if (l2 != null ? l2.equals(itemPlaceHolder.getDateline()) : itemPlaceHolder.getDateline() == null) {
                                                        Long l3 = this.lastUpdate;
                                                        if (l3 != null ? l3.equals(itemPlaceHolder.getLastUpdate()) : itemPlaceHolder.getLastUpdate() == null) {
                                                            String str14 = this.deprecatedUserAvatar;
                                                            if (str14 != null ? str14.equals(itemPlaceHolder.getDeprecatedUserAvatar()) : itemPlaceHolder.getDeprecatedUserAvatar() == null) {
                                                                UserInfo userInfo2 = this.userInfo;
                                                                if (userInfo2 != null ? userInfo2.equals(itemPlaceHolder.getUserInfo()) : itemPlaceHolder.getUserInfo() == null) {
                                                                    if (this.uid.equals(itemPlaceHolder.getUid()) && ((str = this.deprecatedUserName) != null ? str.equals(itemPlaceHolder.getDeprecatedUserName()) : itemPlaceHolder.getDeprecatedUserName() == null) && ((str2 = this.displayUserName) != null ? str2.equals(itemPlaceHolder.getDisplayUserName()) : itemPlaceHolder.getDisplayUserName() == null) && ((str3 = this.title) != null ? str3.equals(itemPlaceHolder.getTitle()) : itemPlaceHolder.getTitle() == null) && ((dyhModel2 = this.dyhModel) != null ? dyhModel2.equals(itemPlaceHolder.getDyhModel()) : itemPlaceHolder.getDyhModel() == null)) {
                                                                        CollectionItem collectionItem = this.collectionItemInfo;
                                                                        if (collectionItem == null) {
                                                                            if (itemPlaceHolder.getCollectionItemInfo() == null) {
                                                                                return true;
                                                                            }
                                                                        } else if (collectionItem.equals(itemPlaceHolder.getCollectionItemInfo())) {
                                                                            return true;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
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
        String str = this.entityTypeName;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.entityTemplate;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.entityId;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        Integer num = this.entityFixed;
        int hashCode4 = (hashCode3 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str4 = this.url;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.description;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.pic;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.logo;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.subTitle;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.id;
        int hashCode10 = (hashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.extraData;
        int hashCode11 = (hashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        Long l2 = this.dateline;
        int hashCode12 = (hashCode11 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        Long l3 = this.lastUpdate;
        int hashCode13 = (hashCode12 ^ (l3 == null ? 0 : l3.hashCode())) * 1000003;
        String str11 = this.deprecatedUserAvatar;
        int hashCode14 = (hashCode13 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        UserInfo userInfo2 = this.userInfo;
        int hashCode15 = (((hashCode14 ^ (userInfo2 == null ? 0 : userInfo2.hashCode())) * 1000003) ^ this.uid.hashCode()) * 1000003;
        String str12 = this.deprecatedUserName;
        int hashCode16 = (hashCode15 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.displayUserName;
        int hashCode17 = (hashCode16 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.title;
        int hashCode18 = (hashCode17 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        DyhModel dyhModel2 = this.dyhModel;
        int hashCode19 = (hashCode18 ^ (dyhModel2 == null ? 0 : dyhModel2.hashCode())) * 1000003;
        CollectionItem collectionItem = this.collectionItemInfo;
        if (collectionItem != null) {
            i = collectionItem.hashCode();
        }
        return hashCode19 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_ItemPlaceHolder$Builder */
    /* compiled from: $$AutoValue_ItemPlaceHolder */
    static final class Builder extends ItemPlaceHolder.Builder {
        private CollectionItem collectionItemInfo;
        private Long dateline;
        private String deprecatedUserAvatar;
        private String deprecatedUserName;
        private String description;
        private String displayUserName;
        private DyhModel dyhModel;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
        private String entityTypeName;
        private String extraData;
        private String id;
        private Long lastUpdate;
        private String logo;
        private String pic;
        private String subTitle;
        private String title;
        private String uid;
        private String url;
        private UserInfo userInfo;

        Builder() {
        }

        Builder(ItemPlaceHolder itemPlaceHolder) {
            this.entityTypeName = itemPlaceHolder.getEntityTypeName();
            this.entityTemplate = itemPlaceHolder.getEntityTemplate();
            this.entityId = itemPlaceHolder.getEntityId();
            this.entityFixed = itemPlaceHolder.getEntityFixed();
            this.url = itemPlaceHolder.getUrl();
            this.description = itemPlaceHolder.getDescription();
            this.pic = itemPlaceHolder.getPic();
            this.logo = itemPlaceHolder.getLogo();
            this.subTitle = itemPlaceHolder.getSubTitle();
            this.id = itemPlaceHolder.getId();
            this.extraData = itemPlaceHolder.getExtraData();
            this.dateline = itemPlaceHolder.getDateline();
            this.lastUpdate = itemPlaceHolder.getLastUpdate();
            this.deprecatedUserAvatar = itemPlaceHolder.getDeprecatedUserAvatar();
            this.userInfo = itemPlaceHolder.getUserInfo();
            this.uid = itemPlaceHolder.getUid();
            this.deprecatedUserName = itemPlaceHolder.getDeprecatedUserName();
            this.displayUserName = itemPlaceHolder.getDisplayUserName();
            this.title = itemPlaceHolder.getTitle();
            this.dyhModel = itemPlaceHolder.getDyhModel();
            this.collectionItemInfo = itemPlaceHolder.getCollectionItemInfo();
        }

        @Override // com.coolapk.market.model.ItemPlaceHolder.Builder
        public ItemPlaceHolder.Builder entityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemPlaceHolder.Builder
        public ItemPlaceHolder.Builder entityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemPlaceHolder.Builder
        public ItemPlaceHolder.Builder entityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemPlaceHolder.Builder
        public ItemPlaceHolder.Builder entityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.ItemPlaceHolder.Builder
        public ItemPlaceHolder.Builder url(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemPlaceHolder.Builder
        public ItemPlaceHolder.Builder description(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemPlaceHolder.Builder
        public ItemPlaceHolder.Builder pic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemPlaceHolder.Builder
        public ItemPlaceHolder.Builder logo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemPlaceHolder.Builder
        public ItemPlaceHolder.Builder subTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemPlaceHolder.Builder
        public ItemPlaceHolder.Builder id(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemPlaceHolder.Builder
        public ItemPlaceHolder.Builder extraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemPlaceHolder.Builder
        public ItemPlaceHolder.Builder dateline(Long l2) {
            this.dateline = l2;
            return this;
        }

        @Override // com.coolapk.market.model.ItemPlaceHolder.Builder
        public ItemPlaceHolder.Builder lastUpdate(Long l2) {
            this.lastUpdate = l2;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public ItemPlaceHolder.Builder deprecatedUserAvatar(String str) {
            this.deprecatedUserAvatar = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public ItemPlaceHolder.Builder userInfo(UserInfo userInfo2) {
            this.userInfo = userInfo2;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public ItemPlaceHolder.Builder uid(String str) {
            this.uid = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public ItemPlaceHolder.Builder deprecatedUserName(String str) {
            this.deprecatedUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public ItemPlaceHolder.Builder displayUserName(String str) {
            this.displayUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemPlaceHolder.Builder
        public ItemPlaceHolder.Builder title(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.ItemPlaceHolder.Builder
        public ItemPlaceHolder.Builder dyhModel(DyhModel dyhModel2) {
            this.dyhModel = dyhModel2;
            return this;
        }

        @Override // com.coolapk.market.model.ItemPlaceHolder.Builder
        public ItemPlaceHolder.Builder collectionItemInfo(CollectionItem collectionItem) {
            this.collectionItemInfo = collectionItem;
            return this;
        }

        @Override // com.coolapk.market.model.ItemPlaceHolder.Builder
        public ItemPlaceHolder build() {
            String str = "";
            if (this.uid == null) {
                str = str + " uid";
            }
            if (str.isEmpty()) {
                return new AutoValue_ItemPlaceHolder(this.entityTypeName, this.entityTemplate, this.entityId, this.entityFixed, this.url, this.description, this.pic, this.logo, this.subTitle, this.id, this.extraData, this.dateline, this.lastUpdate, this.deprecatedUserAvatar, this.userInfo, this.uid, this.deprecatedUserName, this.displayUserName, this.title, this.dyhModel, this.collectionItemInfo);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
