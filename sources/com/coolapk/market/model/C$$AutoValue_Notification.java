package com.coolapk.market.model;

import com.coolapk.market.model.Notification;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_Notification  reason: invalid class name */
abstract class C$$AutoValue_Notification extends Notification {
    private final Long dateline;
    private final String description;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityType;
    private final String entityTypeName;
    private final String extraData;
    private final String fromUid;
    private final String fromUserAvatar;
    private final UserInfo fromUserInfo;
    private final String fromUserName;
    private final String id;
    private final int isNew;
    private final Long lastUpdate;
    private final String logo;
    private final String note;
    private final NotifyCount notifyCount;
    private final String pic;
    private final String slug;
    private final String subTitle;
    private final String title;
    private final String type;
    private final String uid;
    private final String url;

    C$$AutoValue_Notification(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l2, Long l3, String str11, String str12, String str13, String str14, String str15, String str16, String str17, int i, String str18, UserInfo userInfo, NotifyCount notifyCount2, String str19) {
        this.entityTypeName = str;
        this.entityTemplate = str2;
        this.entityId = str3;
        this.entityFixed = num;
        this.title = str4;
        this.url = str5;
        this.description = str6;
        this.pic = str7;
        this.logo = str8;
        this.subTitle = str9;
        this.extraData = str10;
        this.dateline = l2;
        this.lastUpdate = l3;
        this.id = str11;
        this.uid = str12;
        this.fromUid = str13;
        Objects.requireNonNull(str14, "Null fromUserName");
        this.fromUserName = str14;
        this.fromUserAvatar = str15;
        this.type = str16;
        this.slug = str17;
        this.isNew = i;
        this.note = str18;
        this.fromUserInfo = userInfo;
        this.notifyCount = notifyCount2;
        this.entityType = str19;
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
    @SerializedName("title")
    public String getTitle() {
        return this.title;
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

    @Override // com.coolapk.market.model.Notification, com.coolapk.market.model.Entity
    @SerializedName("id")
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.Notification
    @SerializedName("uid")
    public String getUid() {
        return this.uid;
    }

    @Override // com.coolapk.market.model.Notification
    @SerializedName("fromuid")
    public String getFromUid() {
        return this.fromUid;
    }

    @Override // com.coolapk.market.model.Notification
    @SerializedName("fromusername")
    public String getFromUserName() {
        return this.fromUserName;
    }

    @Override // com.coolapk.market.model.Notification
    @SerializedName("fromUserAvatar")
    public String getFromUserAvatar() {
        return this.fromUserAvatar;
    }

    @Override // com.coolapk.market.model.Notification
    @SerializedName("type")
    public String getType() {
        return this.type;
    }

    @Override // com.coolapk.market.model.Notification
    @SerializedName("slug")
    public String getSlug() {
        return this.slug;
    }

    @Override // com.coolapk.market.model.Notification
    @SerializedName("isnew")
    public int getIsNew() {
        return this.isNew;
    }

    @Override // com.coolapk.market.model.Notification
    @SerializedName("note")
    public String getNote() {
        return this.note;
    }

    @Override // com.coolapk.market.model.Notification
    @SerializedName("fromUserInfo")
    public UserInfo getFromUserInfo() {
        return this.fromUserInfo;
    }

    @Override // com.coolapk.market.model.Notification
    @SerializedName("notifyCount")
    public NotifyCount getNotifyCount() {
        return this.notifyCount;
    }

    @Override // com.coolapk.market.model.Notification, com.coolapk.market.model.Entity
    @SerializedName("entityType")
    public String getEntityType() {
        return this.entityType;
    }

    @Override // java.lang.Object
    public String toString() {
        return "Notification{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", id=" + this.id + ", uid=" + this.uid + ", fromUid=" + this.fromUid + ", fromUserName=" + this.fromUserName + ", fromUserAvatar=" + this.fromUserAvatar + ", type=" + this.type + ", slug=" + this.slug + ", isNew=" + this.isNew + ", note=" + this.note + ", fromUserInfo=" + this.fromUserInfo + ", notifyCount=" + this.notifyCount + ", entityType=" + this.entityType + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        UserInfo userInfo;
        NotifyCount notifyCount2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Notification)) {
            return false;
        }
        Notification notification = (Notification) obj;
        String str5 = this.entityTypeName;
        if (str5 != null ? str5.equals(notification.getEntityTypeName()) : notification.getEntityTypeName() == null) {
            String str6 = this.entityTemplate;
            if (str6 != null ? str6.equals(notification.getEntityTemplate()) : notification.getEntityTemplate() == null) {
                String str7 = this.entityId;
                if (str7 != null ? str7.equals(notification.getEntityId()) : notification.getEntityId() == null) {
                    Integer num = this.entityFixed;
                    if (num != null ? num.equals(notification.getEntityFixed()) : notification.getEntityFixed() == null) {
                        String str8 = this.title;
                        if (str8 != null ? str8.equals(notification.getTitle()) : notification.getTitle() == null) {
                            String str9 = this.url;
                            if (str9 != null ? str9.equals(notification.getUrl()) : notification.getUrl() == null) {
                                String str10 = this.description;
                                if (str10 != null ? str10.equals(notification.getDescription()) : notification.getDescription() == null) {
                                    String str11 = this.pic;
                                    if (str11 != null ? str11.equals(notification.getPic()) : notification.getPic() == null) {
                                        String str12 = this.logo;
                                        if (str12 != null ? str12.equals(notification.getLogo()) : notification.getLogo() == null) {
                                            String str13 = this.subTitle;
                                            if (str13 != null ? str13.equals(notification.getSubTitle()) : notification.getSubTitle() == null) {
                                                String str14 = this.extraData;
                                                if (str14 != null ? str14.equals(notification.getExtraData()) : notification.getExtraData() == null) {
                                                    Long l2 = this.dateline;
                                                    if (l2 != null ? l2.equals(notification.getDateline()) : notification.getDateline() == null) {
                                                        Long l3 = this.lastUpdate;
                                                        if (l3 != null ? l3.equals(notification.getLastUpdate()) : notification.getLastUpdate() == null) {
                                                            String str15 = this.id;
                                                            if (str15 != null ? str15.equals(notification.getId()) : notification.getId() == null) {
                                                                String str16 = this.uid;
                                                                if (str16 != null ? str16.equals(notification.getUid()) : notification.getUid() == null) {
                                                                    String str17 = this.fromUid;
                                                                    if (str17 != null ? str17.equals(notification.getFromUid()) : notification.getFromUid() == null) {
                                                                        if (this.fromUserName.equals(notification.getFromUserName()) && ((str = this.fromUserAvatar) != null ? str.equals(notification.getFromUserAvatar()) : notification.getFromUserAvatar() == null) && ((str2 = this.type) != null ? str2.equals(notification.getType()) : notification.getType() == null) && ((str3 = this.slug) != null ? str3.equals(notification.getSlug()) : notification.getSlug() == null) && this.isNew == notification.getIsNew() && ((str4 = this.note) != null ? str4.equals(notification.getNote()) : notification.getNote() == null) && ((userInfo = this.fromUserInfo) != null ? userInfo.equals(notification.getFromUserInfo()) : notification.getFromUserInfo() == null) && ((notifyCount2 = this.notifyCount) != null ? notifyCount2.equals(notification.getNotifyCount()) : notification.getNotifyCount() == null)) {
                                                                            String str18 = this.entityType;
                                                                            if (str18 == null) {
                                                                                if (notification.getEntityType() == null) {
                                                                                    return true;
                                                                                }
                                                                            } else if (str18.equals(notification.getEntityType())) {
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
        String str4 = this.title;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.url;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.description;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.pic;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.logo;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.subTitle;
        int hashCode10 = (hashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.extraData;
        int hashCode11 = (hashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        Long l2 = this.dateline;
        int hashCode12 = (hashCode11 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        Long l3 = this.lastUpdate;
        int hashCode13 = (hashCode12 ^ (l3 == null ? 0 : l3.hashCode())) * 1000003;
        String str11 = this.id;
        int hashCode14 = (hashCode13 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.uid;
        int hashCode15 = (hashCode14 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.fromUid;
        int hashCode16 = (((hashCode15 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003) ^ this.fromUserName.hashCode()) * 1000003;
        String str14 = this.fromUserAvatar;
        int hashCode17 = (hashCode16 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        String str15 = this.type;
        int hashCode18 = (hashCode17 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
        String str16 = this.slug;
        int hashCode19 = (((hashCode18 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003) ^ this.isNew) * 1000003;
        String str17 = this.note;
        int hashCode20 = (hashCode19 ^ (str17 == null ? 0 : str17.hashCode())) * 1000003;
        UserInfo userInfo = this.fromUserInfo;
        int hashCode21 = (hashCode20 ^ (userInfo == null ? 0 : userInfo.hashCode())) * 1000003;
        NotifyCount notifyCount2 = this.notifyCount;
        int hashCode22 = (hashCode21 ^ (notifyCount2 == null ? 0 : notifyCount2.hashCode())) * 1000003;
        String str18 = this.entityType;
        if (str18 != null) {
            i = str18.hashCode();
        }
        return hashCode22 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_Notification$Builder */
    /* compiled from: $$AutoValue_Notification */
    static final class Builder extends Notification.Builder {
        private Long dateline;
        private String description;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
        private String entityType;
        private String entityTypeName;
        private String extraData;
        private String fromUid;
        private String fromUserAvatar;
        private UserInfo fromUserInfo;
        private String fromUserName;
        private String id;
        private Integer isNew;
        private Long lastUpdate;
        private String logo;
        private String note;
        private NotifyCount notifyCount;
        private String pic;
        private String slug;
        private String subTitle;
        private String title;
        private String type;
        private String uid;
        private String url;

        Builder() {
        }

        Builder(Notification notification) {
            this.entityTypeName = notification.getEntityTypeName();
            this.entityTemplate = notification.getEntityTemplate();
            this.entityId = notification.getEntityId();
            this.entityFixed = notification.getEntityFixed();
            this.title = notification.getTitle();
            this.url = notification.getUrl();
            this.description = notification.getDescription();
            this.pic = notification.getPic();
            this.logo = notification.getLogo();
            this.subTitle = notification.getSubTitle();
            this.extraData = notification.getExtraData();
            this.dateline = notification.getDateline();
            this.lastUpdate = notification.getLastUpdate();
            this.id = notification.getId();
            this.uid = notification.getUid();
            this.fromUid = notification.getFromUid();
            this.fromUserName = notification.getFromUserName();
            this.fromUserAvatar = notification.getFromUserAvatar();
            this.type = notification.getType();
            this.slug = notification.getSlug();
            this.isNew = Integer.valueOf(notification.getIsNew());
            this.note = notification.getNote();
            this.fromUserInfo = notification.getFromUserInfo();
            this.notifyCount = notification.getNotifyCount();
            this.entityType = notification.getEntityType();
        }

        @Override // com.coolapk.market.model.Notification.Builder
        public Notification.Builder setEntityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.Notification.Builder
        public Notification.Builder setEntityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.Notification.Builder
        public Notification.Builder setEntityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.Notification.Builder
        public Notification.Builder setEntityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.Notification.Builder
        public Notification.Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.Notification.Builder
        public Notification.Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.Notification.Builder
        public Notification.Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.Notification.Builder
        public Notification.Builder setPic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.Notification.Builder
        public Notification.Builder setLogo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.Notification.Builder
        public Notification.Builder setSubTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.Notification.Builder
        public Notification.Builder setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.Notification.Builder
        public Notification.Builder setDateline(Long l2) {
            this.dateline = l2;
            return this;
        }

        @Override // com.coolapk.market.model.Notification.Builder
        public Notification.Builder setLastUpdate(Long l2) {
            this.lastUpdate = l2;
            return this;
        }

        @Override // com.coolapk.market.model.Notification.Builder
        public Notification.Builder setId(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.Notification.Builder
        public Notification.Builder setUid(String str) {
            this.uid = str;
            return this;
        }

        @Override // com.coolapk.market.model.Notification.Builder
        public Notification.Builder setFromUid(String str) {
            this.fromUid = str;
            return this;
        }

        @Override // com.coolapk.market.model.Notification.Builder
        public Notification.Builder setFromUserName(String str) {
            this.fromUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.Notification.Builder
        public Notification.Builder setFromUserAvatar(String str) {
            this.fromUserAvatar = str;
            return this;
        }

        @Override // com.coolapk.market.model.Notification.Builder
        public Notification.Builder setType(String str) {
            this.type = str;
            return this;
        }

        @Override // com.coolapk.market.model.Notification.Builder
        public Notification.Builder setSlug(String str) {
            this.slug = str;
            return this;
        }

        @Override // com.coolapk.market.model.Notification.Builder
        public Notification.Builder setIsNew(int i) {
            this.isNew = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Notification.Builder
        public Notification.Builder setNote(String str) {
            this.note = str;
            return this;
        }

        @Override // com.coolapk.market.model.Notification.Builder
        public Notification.Builder setFromUserInfo(UserInfo userInfo) {
            this.fromUserInfo = userInfo;
            return this;
        }

        @Override // com.coolapk.market.model.Notification.Builder
        public Notification.Builder setNotifyCount(NotifyCount notifyCount2) {
            this.notifyCount = notifyCount2;
            return this;
        }

        @Override // com.coolapk.market.model.Notification.Builder
        public Notification.Builder setEntityType(String str) {
            this.entityType = str;
            return this;
        }

        @Override // com.coolapk.market.model.Notification.Builder
        public Notification build() {
            String str = "";
            if (this.fromUserName == null) {
                str = str + " fromUserName";
            }
            if (this.isNew == null) {
                str = str + " isNew";
            }
            if (str.isEmpty()) {
                return new AutoValue_Notification(this.entityTypeName, this.entityTemplate, this.entityId, this.entityFixed, this.title, this.url, this.description, this.pic, this.logo, this.subTitle, this.extraData, this.dateline, this.lastUpdate, this.id, this.uid, this.fromUid, this.fromUserName, this.fromUserAvatar, this.type, this.slug, this.isNew.intValue(), this.note, this.fromUserInfo, this.notifyCount, this.entityType);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
