package com.coolapk.market.model;

import com.coolapk.market.model.Message;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_Message  reason: invalid class name */
abstract class C$$AutoValue_Message extends Message {
    private final String UKey;
    private final Long dateline;
    private final String deprecatedUserAvatar;
    private final String deprecatedUserName;
    private final String description;
    private final String displayUserName;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityType;
    private final String entityTypeName;
    private final String extraData;
    private final String fromUid;
    private final String fromUserAvatar;
    private final String fromUserName;
    private final String id;
    private final int isLast;
    private final Integer isLong;
    private final int isNew;
    private final int isTop;
    private final Long lastUpdate;
    private final String logo;
    private final String message;
    private final String messageCard;
    private final String messageExtra;
    private final String messagePic;
    private final String messageUid;
    private final String messageUserAvatar;
    private final UserInfo messageUserInfo;
    private final String messageUserName;
    private final NotifyCount notifyCount;
    private final String pic;
    private final String subTitle;
    private final String title;
    private final String uid;
    private final int unreadNum;
    private final String url;
    private final UserInfo userInfo;

    C$$AutoValue_Message(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l2, Long l3, String str11, UserInfo userInfo2, String str12, String str13, String str14, String str15, String str16, String str17, String str18, int i, int i2, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, NotifyCount notifyCount2, int i3, int i4, Integer num2, String str27, UserInfo userInfo3) {
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
        this.deprecatedUserAvatar = str11;
        this.userInfo = userInfo2;
        this.deprecatedUserName = str12;
        this.displayUserName = str13;
        Objects.requireNonNull(str14, "Null id");
        this.id = str14;
        Objects.requireNonNull(str15, "Null UKey");
        this.UKey = str15;
        Objects.requireNonNull(str16, "Null uid");
        this.uid = str16;
        Objects.requireNonNull(str17, "Null fromUid");
        this.fromUid = str17;
        Objects.requireNonNull(str18, "Null fromUserName");
        this.fromUserName = str18;
        this.isLast = i;
        this.isNew = i2;
        Objects.requireNonNull(str19, "Null message");
        this.message = str19;
        this.messagePic = str20;
        this.messageExtra = str21;
        this.messageCard = str22;
        Objects.requireNonNull(str23, "Null messageUid");
        this.messageUid = str23;
        Objects.requireNonNull(str24, "Null messageUserName");
        this.messageUserName = str24;
        this.fromUserAvatar = str25;
        this.messageUserAvatar = str26;
        this.notifyCount = notifyCount2;
        this.unreadNum = i3;
        this.isTop = i4;
        this.isLong = num2;
        this.entityType = str27;
        this.messageUserInfo = userInfo3;
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

    @Override // com.coolapk.market.model.Message, com.coolapk.market.model.Entity
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.Message
    @SerializedName("ukey")
    public String getUKey() {
        return this.UKey;
    }

    @Override // com.coolapk.market.model.Message, com.coolapk.market.model.IUser
    public String getUid() {
        return this.uid;
    }

    @Override // com.coolapk.market.model.Message
    @SerializedName("fromuid")
    public String getFromUid() {
        return this.fromUid;
    }

    @Override // com.coolapk.market.model.Message
    @SerializedName("fromusername")
    public String getFromUserName() {
        return this.fromUserName;
    }

    @Override // com.coolapk.market.model.Message
    @SerializedName("islast")
    public int getIsLast() {
        return this.isLast;
    }

    @Override // com.coolapk.market.model.Message
    @SerializedName("isnew")
    public int getIsNew() {
        return this.isNew;
    }

    @Override // com.coolapk.market.model.Message
    public String getMessage() {
        return this.message;
    }

    @Override // com.coolapk.market.model.Message
    @SerializedName("message_pic")
    public String getMessagePic() {
        return this.messagePic;
    }

    @Override // com.coolapk.market.model.Message
    @SerializedName("message_extra")
    public String getMessageExtra() {
        return this.messageExtra;
    }

    @Override // com.coolapk.market.model.Message
    @SerializedName("message_card")
    public String getMessageCard() {
        return this.messageCard;
    }

    @Override // com.coolapk.market.model.Message
    public String getMessageUid() {
        return this.messageUid;
    }

    @Override // com.coolapk.market.model.Message
    @SerializedName("messageUsername")
    public String getMessageUserName() {
        return this.messageUserName;
    }

    @Override // com.coolapk.market.model.Message
    public String getFromUserAvatar() {
        return this.fromUserAvatar;
    }

    @Override // com.coolapk.market.model.Message
    public String getMessageUserAvatar() {
        return this.messageUserAvatar;
    }

    @Override // com.coolapk.market.model.Message
    public NotifyCount getNotifyCount() {
        return this.notifyCount;
    }

    @Override // com.coolapk.market.model.Message
    public int getUnreadNum() {
        return this.unreadNum;
    }

    @Override // com.coolapk.market.model.Message
    @SerializedName("is_top")
    public int getIsTop() {
        return this.isTop;
    }

    @Override // com.coolapk.market.model.Message
    @SerializedName("isLong")
    public Integer getIsLong() {
        return this.isLong;
    }

    @Override // com.coolapk.market.model.Message, com.coolapk.market.model.Entity
    public String getEntityType() {
        return this.entityType;
    }

    @Override // com.coolapk.market.model.Message
    public UserInfo getMessageUserInfo() {
        return this.messageUserInfo;
    }

    @Override // java.lang.Object
    public String toString() {
        return "Message{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", deprecatedUserAvatar=" + this.deprecatedUserAvatar + ", userInfo=" + this.userInfo + ", deprecatedUserName=" + this.deprecatedUserName + ", displayUserName=" + this.displayUserName + ", id=" + this.id + ", UKey=" + this.UKey + ", uid=" + this.uid + ", fromUid=" + this.fromUid + ", fromUserName=" + this.fromUserName + ", isLast=" + this.isLast + ", isNew=" + this.isNew + ", message=" + this.message + ", messagePic=" + this.messagePic + ", messageExtra=" + this.messageExtra + ", messageCard=" + this.messageCard + ", messageUid=" + this.messageUid + ", messageUserName=" + this.messageUserName + ", fromUserAvatar=" + this.fromUserAvatar + ", messageUserAvatar=" + this.messageUserAvatar + ", notifyCount=" + this.notifyCount + ", unreadNum=" + this.unreadNum + ", isTop=" + this.isTop + ", isLong=" + this.isLong + ", entityType=" + this.entityType + ", messageUserInfo=" + this.messageUserInfo + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        NotifyCount notifyCount2;
        Integer num;
        String str6;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message2 = (Message) obj;
        String str7 = this.entityTypeName;
        if (str7 != null ? str7.equals(message2.getEntityTypeName()) : message2.getEntityTypeName() == null) {
            String str8 = this.entityTemplate;
            if (str8 != null ? str8.equals(message2.getEntityTemplate()) : message2.getEntityTemplate() == null) {
                String str9 = this.entityId;
                if (str9 != null ? str9.equals(message2.getEntityId()) : message2.getEntityId() == null) {
                    Integer num2 = this.entityFixed;
                    if (num2 != null ? num2.equals(message2.getEntityFixed()) : message2.getEntityFixed() == null) {
                        String str10 = this.title;
                        if (str10 != null ? str10.equals(message2.getTitle()) : message2.getTitle() == null) {
                            String str11 = this.url;
                            if (str11 != null ? str11.equals(message2.getUrl()) : message2.getUrl() == null) {
                                String str12 = this.description;
                                if (str12 != null ? str12.equals(message2.getDescription()) : message2.getDescription() == null) {
                                    String str13 = this.pic;
                                    if (str13 != null ? str13.equals(message2.getPic()) : message2.getPic() == null) {
                                        String str14 = this.logo;
                                        if (str14 != null ? str14.equals(message2.getLogo()) : message2.getLogo() == null) {
                                            String str15 = this.subTitle;
                                            if (str15 != null ? str15.equals(message2.getSubTitle()) : message2.getSubTitle() == null) {
                                                String str16 = this.extraData;
                                                if (str16 != null ? str16.equals(message2.getExtraData()) : message2.getExtraData() == null) {
                                                    Long l2 = this.dateline;
                                                    if (l2 != null ? l2.equals(message2.getDateline()) : message2.getDateline() == null) {
                                                        Long l3 = this.lastUpdate;
                                                        if (l3 != null ? l3.equals(message2.getLastUpdate()) : message2.getLastUpdate() == null) {
                                                            String str17 = this.deprecatedUserAvatar;
                                                            if (str17 != null ? str17.equals(message2.getDeprecatedUserAvatar()) : message2.getDeprecatedUserAvatar() == null) {
                                                                UserInfo userInfo2 = this.userInfo;
                                                                if (userInfo2 != null ? userInfo2.equals(message2.getUserInfo()) : message2.getUserInfo() == null) {
                                                                    String str18 = this.deprecatedUserName;
                                                                    if (str18 != null ? str18.equals(message2.getDeprecatedUserName()) : message2.getDeprecatedUserName() == null) {
                                                                        String str19 = this.displayUserName;
                                                                        if (str19 != null ? str19.equals(message2.getDisplayUserName()) : message2.getDisplayUserName() == null) {
                                                                            if (this.id.equals(message2.getId()) && this.UKey.equals(message2.getUKey()) && this.uid.equals(message2.getUid()) && this.fromUid.equals(message2.getFromUid()) && this.fromUserName.equals(message2.getFromUserName()) && this.isLast == message2.getIsLast() && this.isNew == message2.getIsNew() && this.message.equals(message2.getMessage()) && ((str = this.messagePic) != null ? str.equals(message2.getMessagePic()) : message2.getMessagePic() == null) && ((str2 = this.messageExtra) != null ? str2.equals(message2.getMessageExtra()) : message2.getMessageExtra() == null) && ((str3 = this.messageCard) != null ? str3.equals(message2.getMessageCard()) : message2.getMessageCard() == null) && this.messageUid.equals(message2.getMessageUid()) && this.messageUserName.equals(message2.getMessageUserName()) && ((str4 = this.fromUserAvatar) != null ? str4.equals(message2.getFromUserAvatar()) : message2.getFromUserAvatar() == null) && ((str5 = this.messageUserAvatar) != null ? str5.equals(message2.getMessageUserAvatar()) : message2.getMessageUserAvatar() == null) && ((notifyCount2 = this.notifyCount) != null ? notifyCount2.equals(message2.getNotifyCount()) : message2.getNotifyCount() == null) && this.unreadNum == message2.getUnreadNum() && this.isTop == message2.getIsTop() && ((num = this.isLong) != null ? num.equals(message2.getIsLong()) : message2.getIsLong() == null) && ((str6 = this.entityType) != null ? str6.equals(message2.getEntityType()) : message2.getEntityType() == null)) {
                                                                                UserInfo userInfo3 = this.messageUserInfo;
                                                                                if (userInfo3 == null) {
                                                                                    if (message2.getMessageUserInfo() == null) {
                                                                                        return true;
                                                                                    }
                                                                                } else if (userInfo3.equals(message2.getMessageUserInfo())) {
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
        String str11 = this.deprecatedUserAvatar;
        int hashCode14 = (hashCode13 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        UserInfo userInfo2 = this.userInfo;
        int hashCode15 = (hashCode14 ^ (userInfo2 == null ? 0 : userInfo2.hashCode())) * 1000003;
        String str12 = this.deprecatedUserName;
        int hashCode16 = (hashCode15 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.displayUserName;
        int hashCode17 = (((((((((((((((((hashCode16 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003) ^ this.id.hashCode()) * 1000003) ^ this.UKey.hashCode()) * 1000003) ^ this.uid.hashCode()) * 1000003) ^ this.fromUid.hashCode()) * 1000003) ^ this.fromUserName.hashCode()) * 1000003) ^ this.isLast) * 1000003) ^ this.isNew) * 1000003) ^ this.message.hashCode()) * 1000003;
        String str14 = this.messagePic;
        int hashCode18 = (hashCode17 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        String str15 = this.messageExtra;
        int hashCode19 = (hashCode18 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
        String str16 = this.messageCard;
        int hashCode20 = (((((hashCode19 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003) ^ this.messageUid.hashCode()) * 1000003) ^ this.messageUserName.hashCode()) * 1000003;
        String str17 = this.fromUserAvatar;
        int hashCode21 = (hashCode20 ^ (str17 == null ? 0 : str17.hashCode())) * 1000003;
        String str18 = this.messageUserAvatar;
        int hashCode22 = (hashCode21 ^ (str18 == null ? 0 : str18.hashCode())) * 1000003;
        NotifyCount notifyCount2 = this.notifyCount;
        int hashCode23 = (((((hashCode22 ^ (notifyCount2 == null ? 0 : notifyCount2.hashCode())) * 1000003) ^ this.unreadNum) * 1000003) ^ this.isTop) * 1000003;
        Integer num2 = this.isLong;
        int hashCode24 = (hashCode23 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        String str19 = this.entityType;
        int hashCode25 = (hashCode24 ^ (str19 == null ? 0 : str19.hashCode())) * 1000003;
        UserInfo userInfo3 = this.messageUserInfo;
        if (userInfo3 != null) {
            i = userInfo3.hashCode();
        }
        return hashCode25 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_Message$Builder */
    /* compiled from: $$AutoValue_Message */
    static final class Builder extends Message.Builder {
        private String UKey;
        private Long dateline;
        private String deprecatedUserAvatar;
        private String deprecatedUserName;
        private String description;
        private String displayUserName;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
        private String entityType;
        private String entityTypeName;
        private String extraData;
        private String fromUid;
        private String fromUserAvatar;
        private String fromUserName;
        private String id;
        private Integer isLast;
        private Integer isLong;
        private Integer isNew;
        private Integer isTop;
        private Long lastUpdate;
        private String logo;
        private String message;
        private String messageCard;
        private String messageExtra;
        private String messagePic;
        private String messageUid;
        private String messageUserAvatar;
        private UserInfo messageUserInfo;
        private String messageUserName;
        private NotifyCount notifyCount;
        private String pic;
        private String subTitle;
        private String title;
        private String uid;
        private Integer unreadNum;
        private String url;
        private UserInfo userInfo;

        Builder() {
        }

        Builder(Message message2) {
            this.entityTypeName = message2.getEntityTypeName();
            this.entityTemplate = message2.getEntityTemplate();
            this.entityId = message2.getEntityId();
            this.entityFixed = message2.getEntityFixed();
            this.title = message2.getTitle();
            this.url = message2.getUrl();
            this.description = message2.getDescription();
            this.pic = message2.getPic();
            this.logo = message2.getLogo();
            this.subTitle = message2.getSubTitle();
            this.extraData = message2.getExtraData();
            this.dateline = message2.getDateline();
            this.lastUpdate = message2.getLastUpdate();
            this.deprecatedUserAvatar = message2.getDeprecatedUserAvatar();
            this.userInfo = message2.getUserInfo();
            this.deprecatedUserName = message2.getDeprecatedUserName();
            this.displayUserName = message2.getDisplayUserName();
            this.id = message2.getId();
            this.UKey = message2.getUKey();
            this.uid = message2.getUid();
            this.fromUid = message2.getFromUid();
            this.fromUserName = message2.getFromUserName();
            this.isLast = Integer.valueOf(message2.getIsLast());
            this.isNew = Integer.valueOf(message2.getIsNew());
            this.message = message2.getMessage();
            this.messagePic = message2.getMessagePic();
            this.messageExtra = message2.getMessageExtra();
            this.messageCard = message2.getMessageCard();
            this.messageUid = message2.getMessageUid();
            this.messageUserName = message2.getMessageUserName();
            this.fromUserAvatar = message2.getFromUserAvatar();
            this.messageUserAvatar = message2.getMessageUserAvatar();
            this.notifyCount = message2.getNotifyCount();
            this.unreadNum = Integer.valueOf(message2.getUnreadNum());
            this.isTop = Integer.valueOf(message2.getIsTop());
            this.isLong = message2.getIsLong();
            this.entityType = message2.getEntityType();
            this.messageUserInfo = message2.getMessageUserInfo();
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setEntityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setEntityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setEntityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setEntityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setPic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setLogo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setSubTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setDateline(Long l2) {
            this.dateline = l2;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setLastUpdate(Long l2) {
            this.lastUpdate = l2;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public Message.Builder setDeprecatedUserAvatar(String str) {
            this.deprecatedUserAvatar = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public Message.Builder setUserInfo(UserInfo userInfo2) {
            this.userInfo = userInfo2;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public Message.Builder setDeprecatedUserName(String str) {
            this.deprecatedUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM1
        public Message.Builder setDisplayUserName(String str) {
            this.displayUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setId(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setUKey(String str) {
            this.UKey = str;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder, com.coolapk.market.model.IUser.BuilderM1
        public Message.Builder setUid(String str) {
            this.uid = str;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setFromUid(String str) {
            this.fromUid = str;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setFromUserName(String str) {
            this.fromUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setIsLast(int i) {
            this.isLast = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setIsNew(int i) {
            this.isNew = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setMessage(String str) {
            this.message = str;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setMessagePic(String str) {
            this.messagePic = str;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setMessageExtra(String str) {
            this.messageExtra = str;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setMessageCard(String str) {
            this.messageCard = str;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setMessageUid(String str) {
            this.messageUid = str;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setMessageUserName(String str) {
            this.messageUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setFromUserAvatar(String str) {
            this.fromUserAvatar = str;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setMessageUserAvatar(String str) {
            this.messageUserAvatar = str;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setNotifyCount(NotifyCount notifyCount2) {
            this.notifyCount = notifyCount2;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setUnreadNum(int i) {
            this.unreadNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setIsTop(int i) {
            this.isTop = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setIsLong(Integer num) {
            this.isLong = num;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setEntityType(String str) {
            this.entityType = str;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message.Builder setMessageUserInfo(UserInfo userInfo2) {
            this.messageUserInfo = userInfo2;
            return this;
        }

        @Override // com.coolapk.market.model.Message.Builder
        public Message build() {
            String str = "";
            if (this.id == null) {
                str = str + " id";
            }
            if (this.UKey == null) {
                str = str + " UKey";
            }
            if (this.uid == null) {
                str = str + " uid";
            }
            if (this.fromUid == null) {
                str = str + " fromUid";
            }
            if (this.fromUserName == null) {
                str = str + " fromUserName";
            }
            if (this.isLast == null) {
                str = str + " isLast";
            }
            if (this.isNew == null) {
                str = str + " isNew";
            }
            if (this.message == null) {
                str = str + " message";
            }
            if (this.messageUid == null) {
                str = str + " messageUid";
            }
            if (this.messageUserName == null) {
                str = str + " messageUserName";
            }
            if (this.unreadNum == null) {
                str = str + " unreadNum";
            }
            if (this.isTop == null) {
                str = str + " isTop";
            }
            if (str.isEmpty()) {
                return new AutoValue_Message(this.entityTypeName, this.entityTemplate, this.entityId, this.entityFixed, this.title, this.url, this.description, this.pic, this.logo, this.subTitle, this.extraData, this.dateline, this.lastUpdate, this.deprecatedUserAvatar, this.userInfo, this.deprecatedUserName, this.displayUserName, this.id, this.UKey, this.uid, this.fromUid, this.fromUserName, this.isLast.intValue(), this.isNew.intValue(), this.message, this.messagePic, this.messageExtra, this.messageCard, this.messageUid, this.messageUserName, this.fromUserAvatar, this.messageUserAvatar, this.notifyCount, this.unreadNum.intValue(), this.isTop.intValue(), this.isLong, this.entityType, this.messageUserInfo);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
