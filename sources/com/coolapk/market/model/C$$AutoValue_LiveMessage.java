package com.coolapk.market.model;

import com.coolapk.market.model.LiveMessage;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_LiveMessage  reason: invalid class name */
abstract class C$$AutoValue_LiveMessage extends LiveMessage {
    private final Long dateline;
    private final String datelineFormat;
    private final String description;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityType;
    private final String entityTypeName;
    private final String extraData;
    private final String id;
    private final int isBroadcast;
    private final int isRead;
    private final Long lastUpdate;
    private final String liveId;
    private final String logo;
    private final String message;
    private final String messageSource;
    private final String pic;
    private final LiveMessage sourceRow;
    private final String subTitle;
    private final String title;
    private final String uid;
    private final String url;
    private final User userInfo;
    private final String userName;

    C$$AutoValue_LiveMessage(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Long l, Long l2, String str13, String str14, String str15, String str16, String str17, int i, User user, LiveMessage liveMessage, String str18, int i2) {
        this.entityTypeName = str;
        Objects.requireNonNull(str2, "Null entityType");
        this.entityType = str2;
        this.entityTemplate = str3;
        this.entityId = str4;
        this.entityFixed = num;
        this.title = str5;
        this.url = str6;
        this.description = str7;
        this.pic = str8;
        this.logo = str9;
        this.subTitle = str10;
        this.id = str11;
        this.extraData = str12;
        this.dateline = l;
        this.lastUpdate = l2;
        Objects.requireNonNull(str13, "Null liveId");
        this.liveId = str13;
        Objects.requireNonNull(str14, "Null uid");
        this.uid = str14;
        Objects.requireNonNull(str15, "Null userName");
        this.userName = str15;
        Objects.requireNonNull(str16, "Null message");
        this.message = str16;
        Objects.requireNonNull(str17, "Null messageSource");
        this.messageSource = str17;
        this.isBroadcast = i;
        this.userInfo = user;
        this.sourceRow = liveMessage;
        Objects.requireNonNull(str18, "Null datelineFormat");
        this.datelineFormat = str18;
        this.isRead = i2;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityTypeName")
    public String getEntityTypeName() {
        return this.entityTypeName;
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("entityType")
    public String getEntityType() {
        return this.entityType;
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

    @Override // com.coolapk.market.model.LiveMessage
    @SerializedName("live_id")
    public String getLiveId() {
        return this.liveId;
    }

    @Override // com.coolapk.market.model.LiveMessage
    public String getUid() {
        return this.uid;
    }

    @Override // com.coolapk.market.model.LiveMessage
    @SerializedName("username")
    public String getUserName() {
        return this.userName;
    }

    @Override // com.coolapk.market.model.LiveMessage
    public String getMessage() {
        return this.message;
    }

    @Override // com.coolapk.market.model.LiveMessage
    @SerializedName("message_source")
    public String getMessageSource() {
        return this.messageSource;
    }

    @Override // com.coolapk.market.model.LiveMessage
    @SerializedName("is_broadcast")
    public int getIsBroadcast() {
        return this.isBroadcast;
    }

    @Override // com.coolapk.market.model.LiveMessage
    public User getUserInfo() {
        return this.userInfo;
    }

    @Override // com.coolapk.market.model.LiveMessage
    public LiveMessage getSourceRow() {
        return this.sourceRow;
    }

    @Override // com.coolapk.market.model.LiveMessage
    @SerializedName("datelineFormat")
    public String getDatelineFormat() {
        return this.datelineFormat;
    }

    @Override // com.coolapk.market.model.LiveMessage
    @SerializedName("is_read")
    protected int getIsRead() {
        return this.isRead;
    }

    @Override // java.lang.Object
    public String toString() {
        return "LiveMessage{entityTypeName=" + this.entityTypeName + ", entityType=" + this.entityType + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", liveId=" + this.liveId + ", uid=" + this.uid + ", userName=" + this.userName + ", message=" + this.message + ", messageSource=" + this.messageSource + ", isBroadcast=" + this.isBroadcast + ", userInfo=" + this.userInfo + ", sourceRow=" + this.sourceRow + ", datelineFormat=" + this.datelineFormat + ", isRead=" + this.isRead + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        String str2;
        Integer num;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        Long l;
        Long l2;
        User user;
        LiveMessage liveMessage;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LiveMessage)) {
            return false;
        }
        LiveMessage liveMessage2 = (LiveMessage) obj;
        String str11 = this.entityTypeName;
        if (str11 != null ? str11.equals(liveMessage2.getEntityTypeName()) : liveMessage2.getEntityTypeName() == null) {
            if (this.entityType.equals(liveMessage2.getEntityType()) && ((str = this.entityTemplate) != null ? str.equals(liveMessage2.getEntityTemplate()) : liveMessage2.getEntityTemplate() == null) && ((str2 = this.entityId) != null ? str2.equals(liveMessage2.getEntityId()) : liveMessage2.getEntityId() == null) && ((num = this.entityFixed) != null ? num.equals(liveMessage2.getEntityFixed()) : liveMessage2.getEntityFixed() == null) && ((str3 = this.title) != null ? str3.equals(liveMessage2.getTitle()) : liveMessage2.getTitle() == null) && ((str4 = this.url) != null ? str4.equals(liveMessage2.getUrl()) : liveMessage2.getUrl() == null) && ((str5 = this.description) != null ? str5.equals(liveMessage2.getDescription()) : liveMessage2.getDescription() == null) && ((str6 = this.pic) != null ? str6.equals(liveMessage2.getPic()) : liveMessage2.getPic() == null) && ((str7 = this.logo) != null ? str7.equals(liveMessage2.getLogo()) : liveMessage2.getLogo() == null) && ((str8 = this.subTitle) != null ? str8.equals(liveMessage2.getSubTitle()) : liveMessage2.getSubTitle() == null) && ((str9 = this.id) != null ? str9.equals(liveMessage2.getId()) : liveMessage2.getId() == null) && ((str10 = this.extraData) != null ? str10.equals(liveMessage2.getExtraData()) : liveMessage2.getExtraData() == null) && ((l = this.dateline) != null ? l.equals(liveMessage2.getDateline()) : liveMessage2.getDateline() == null) && ((l2 = this.lastUpdate) != null ? l2.equals(liveMessage2.getLastUpdate()) : liveMessage2.getLastUpdate() == null) && this.liveId.equals(liveMessage2.getLiveId()) && this.uid.equals(liveMessage2.getUid()) && this.userName.equals(liveMessage2.getUserName()) && this.message.equals(liveMessage2.getMessage()) && this.messageSource.equals(liveMessage2.getMessageSource()) && this.isBroadcast == liveMessage2.getIsBroadcast() && ((user = this.userInfo) != null ? user.equals(liveMessage2.getUserInfo()) : liveMessage2.getUserInfo() == null) && ((liveMessage = this.sourceRow) != null ? liveMessage.equals(liveMessage2.getSourceRow()) : liveMessage2.getSourceRow() == null) && this.datelineFormat.equals(liveMessage2.getDatelineFormat()) && this.isRead == liveMessage2.getIsRead()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.entityTypeName;
        int i = 0;
        int hashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.entityType.hashCode()) * 1000003;
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
        String str10 = this.id;
        int hashCode11 = (hashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.extraData;
        int hashCode12 = (hashCode11 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        Long l = this.dateline;
        int hashCode13 = (hashCode12 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        Long l2 = this.lastUpdate;
        int hashCode14 = (((((((((((((hashCode13 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003) ^ this.liveId.hashCode()) * 1000003) ^ this.uid.hashCode()) * 1000003) ^ this.userName.hashCode()) * 1000003) ^ this.message.hashCode()) * 1000003) ^ this.messageSource.hashCode()) * 1000003) ^ this.isBroadcast) * 1000003;
        User user = this.userInfo;
        int hashCode15 = (hashCode14 ^ (user == null ? 0 : user.hashCode())) * 1000003;
        LiveMessage liveMessage = this.sourceRow;
        if (liveMessage != null) {
            i = liveMessage.hashCode();
        }
        return ((((hashCode15 ^ i) * 1000003) ^ this.datelineFormat.hashCode()) * 1000003) ^ this.isRead;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_LiveMessage$Builder */
    /* compiled from: $$AutoValue_LiveMessage */
    static final class Builder extends LiveMessage.Builder {
        private Long dateline;
        private String datelineFormat;
        private String description;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
        private String entityType;
        private String entityTypeName;
        private String extraData;
        private String id;
        private Integer isBroadcast;
        private Integer isRead;
        private Long lastUpdate;
        private String liveId;
        private String logo;
        private String message;
        private String messageSource;
        private String pic;
        private LiveMessage sourceRow;
        private String subTitle;
        private String title;
        private String uid;
        private String url;
        private User userInfo;
        private String userName;

        Builder() {
        }

        Builder(LiveMessage liveMessage) {
            this.entityTypeName = liveMessage.getEntityTypeName();
            this.entityType = liveMessage.getEntityType();
            this.entityTemplate = liveMessage.getEntityTemplate();
            this.entityId = liveMessage.getEntityId();
            this.entityFixed = liveMessage.getEntityFixed();
            this.title = liveMessage.getTitle();
            this.url = liveMessage.getUrl();
            this.description = liveMessage.getDescription();
            this.pic = liveMessage.getPic();
            this.logo = liveMessage.getLogo();
            this.subTitle = liveMessage.getSubTitle();
            this.id = liveMessage.getId();
            this.extraData = liveMessage.getExtraData();
            this.dateline = liveMessage.getDateline();
            this.lastUpdate = liveMessage.getLastUpdate();
            this.liveId = liveMessage.getLiveId();
            this.uid = liveMessage.getUid();
            this.userName = liveMessage.getUserName();
            this.message = liveMessage.getMessage();
            this.messageSource = liveMessage.getMessageSource();
            this.isBroadcast = Integer.valueOf(liveMessage.getIsBroadcast());
            this.userInfo = liveMessage.getUserInfo();
            this.sourceRow = liveMessage.getSourceRow();
            this.datelineFormat = liveMessage.getDatelineFormat();
            this.isRead = Integer.valueOf(liveMessage.getIsRead());
        }

        @Override // com.coolapk.market.model.LiveMessage.Builder
        public LiveMessage.Builder setEntityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.LiveMessage.Builder
        public LiveMessage.Builder setEntityType(String str) {
            this.entityType = str;
            return this;
        }

        @Override // com.coolapk.market.model.LiveMessage.Builder
        public LiveMessage.Builder setEntityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.LiveMessage.Builder
        public LiveMessage.Builder setEntityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.LiveMessage.Builder
        public LiveMessage.Builder setEntityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.LiveMessage.Builder
        public LiveMessage.Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.LiveMessage.Builder
        public LiveMessage.Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.LiveMessage.Builder
        public LiveMessage.Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.LiveMessage.Builder
        public LiveMessage.Builder setPic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.LiveMessage.Builder
        public LiveMessage.Builder setLogo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.LiveMessage.Builder
        public LiveMessage.Builder setSubTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.LiveMessage.Builder
        public LiveMessage.Builder setId(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.LiveMessage.Builder
        public LiveMessage.Builder setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.LiveMessage.Builder
        public LiveMessage.Builder setDateline(Long l) {
            this.dateline = l;
            return this;
        }

        @Override // com.coolapk.market.model.LiveMessage.Builder
        public LiveMessage.Builder setLastUpdate(Long l) {
            this.lastUpdate = l;
            return this;
        }

        @Override // com.coolapk.market.model.LiveMessage.Builder
        public LiveMessage.Builder setLiveId(String str) {
            this.liveId = str;
            return this;
        }

        @Override // com.coolapk.market.model.LiveMessage.Builder
        public LiveMessage.Builder setUid(String str) {
            this.uid = str;
            return this;
        }

        @Override // com.coolapk.market.model.LiveMessage.Builder
        public LiveMessage.Builder setUserName(String str) {
            this.userName = str;
            return this;
        }

        @Override // com.coolapk.market.model.LiveMessage.Builder
        public LiveMessage.Builder setMessage(String str) {
            this.message = str;
            return this;
        }

        @Override // com.coolapk.market.model.LiveMessage.Builder
        public LiveMessage.Builder setMessageSource(String str) {
            this.messageSource = str;
            return this;
        }

        @Override // com.coolapk.market.model.LiveMessage.Builder
        public LiveMessage.Builder setIsBroadcast(int i) {
            this.isBroadcast = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.LiveMessage.Builder
        public LiveMessage.Builder setUserInfo(User user) {
            this.userInfo = user;
            return this;
        }

        @Override // com.coolapk.market.model.LiveMessage.Builder
        public LiveMessage.Builder setSourceRow(LiveMessage liveMessage) {
            this.sourceRow = liveMessage;
            return this;
        }

        @Override // com.coolapk.market.model.LiveMessage.Builder
        public LiveMessage.Builder setDatelineFormat(String str) {
            this.datelineFormat = str;
            return this;
        }

        @Override // com.coolapk.market.model.LiveMessage.Builder
        public LiveMessage.Builder setIsRead(int i) {
            this.isRead = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.LiveMessage.Builder
        public LiveMessage build() {
            String str = "";
            if (this.entityType == null) {
                str = str + " entityType";
            }
            if (this.liveId == null) {
                str = str + " liveId";
            }
            if (this.uid == null) {
                str = str + " uid";
            }
            if (this.userName == null) {
                str = str + " userName";
            }
            if (this.message == null) {
                str = str + " message";
            }
            if (this.messageSource == null) {
                str = str + " messageSource";
            }
            if (this.isBroadcast == null) {
                str = str + " isBroadcast";
            }
            if (this.datelineFormat == null) {
                str = str + " datelineFormat";
            }
            if (this.isRead == null) {
                str = str + " isRead";
            }
            if (str.isEmpty()) {
                return new AutoValue_LiveMessage(this.entityTypeName, this.entityType, this.entityTemplate, this.entityId, this.entityFixed, this.title, this.url, this.description, this.pic, this.logo, this.subTitle, this.id, this.extraData, this.dateline, this.lastUpdate, this.liveId, this.uid, this.userName, this.message, this.messageSource, this.isBroadcast.intValue(), this.userInfo, this.sourceRow, this.datelineFormat, this.isRead.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
