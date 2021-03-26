package com.coolapk.market.model;

import com.coolapk.market.model.DyhModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_DyhModel  reason: invalid class name */
abstract class C$$AutoValue_DyhModel extends DyhModel {
    private final String author;
    private final Long dateline;
    private final String deprecatedUserAvatar;
    private final String deprecatedUserName;
    private final String description;
    private final String displayUserName;
    private final EditorInfo editorInfo;
    private final List<String> editors;
    private final List<DyhArticle> entities;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityTypeName;
    private final String extraData;
    private final int followNum;
    private final String fromInfo;
    private final int hasTab;
    private final String id;
    private final String keywords;
    private final Long lastUpdate;
    private final int likeNum;
    private final String logo;
    private final int newsNum;
    private final String pic;
    private final int recommend;
    private final int status;
    private final String statusText;
    private final String subTitle;
    private final String title;
    private final String uid;
    private final Unread unread;
    private final String url;
    private final UserAction userAction;
    private final UserInfo userInfo;

    C$$AutoValue_DyhModel(String str, String str2, Integer num, String str3, String str4, String str5, String str6, Long l2, Long l3, String str7, UserInfo userInfo2, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, EditorInfo editorInfo2, String str17, String str18, int i, int i2, int i3, int i4, List<String> list, int i5, int i6, String str19, List<DyhArticle> list2, UserAction userAction2, Unread unread2) {
        this.entityTemplate = str;
        this.entityId = str2;
        this.entityFixed = num;
        this.url = str3;
        this.pic = str4;
        this.subTitle = str5;
        this.extraData = str6;
        this.dateline = l2;
        this.lastUpdate = l3;
        this.deprecatedUserAvatar = str7;
        this.userInfo = userInfo2;
        this.deprecatedUserName = str8;
        this.displayUserName = str9;
        this.entityTypeName = str10;
        this.id = str11;
        this.uid = str12;
        this.description = str13;
        this.author = str14;
        this.fromInfo = str15;
        this.title = str16;
        this.editorInfo = editorInfo2;
        this.logo = str17;
        this.keywords = str18;
        this.hasTab = i;
        this.likeNum = i2;
        this.newsNum = i3;
        this.recommend = i4;
        Objects.requireNonNull(list, "Null editors");
        this.editors = list;
        this.followNum = i5;
        this.status = i6;
        this.statusText = str19;
        this.entities = list2;
        this.userAction = userAction2;
        this.unread = unread2;
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
    @SerializedName("pic")
    public String getPic() {
        return this.pic;
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

    @Override // com.coolapk.market.model.DyhModel, com.coolapk.market.model.Entity
    public String getEntityTypeName() {
        return this.entityTypeName;
    }

    @Override // com.coolapk.market.model.DyhModel, com.coolapk.market.model.Entity
    @SerializedName("id")
    public String getId() {
        return this.id;
    }

    @Override // com.coolapk.market.model.DyhModel, com.coolapk.market.model.IUser
    @SerializedName("uid")
    public String getUid() {
        return this.uid;
    }

    @Override // com.coolapk.market.model.DyhModel, com.coolapk.market.model.Entity
    @SerializedName("description")
    public String getDescription() {
        return this.description;
    }

    @Override // com.coolapk.market.model.DyhModel
    public String getAuthor() {
        return this.author;
    }

    @Override // com.coolapk.market.model.DyhModel
    @SerializedName("fromInfo")
    public String getFromInfo() {
        return this.fromInfo;
    }

    @Override // com.coolapk.market.model.DyhModel, com.coolapk.market.model.Entity
    @SerializedName("title")
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.DyhModel
    public EditorInfo getEditorInfo() {
        return this.editorInfo;
    }

    @Override // com.coolapk.market.model.DyhModel, com.coolapk.market.model.Entity
    @SerializedName("logo")
    public String getLogo() {
        return this.logo;
    }

    @Override // com.coolapk.market.model.DyhModel
    @SerializedName("keywords")
    public String getKeywords() {
        return this.keywords;
    }

    @Override // com.coolapk.market.model.DyhModel
    @SerializedName("is_open_discuss")
    public int getHasTab() {
        return this.hasTab;
    }

    @Override // com.coolapk.market.model.DyhModel
    @SerializedName("likenum")
    public int getLikeNum() {
        return this.likeNum;
    }

    @Override // com.coolapk.market.model.DyhModel
    @SerializedName("newsnum")
    public int getNewsNum() {
        return this.newsNum;
    }

    @Override // com.coolapk.market.model.DyhModel
    public int getRecommend() {
        return this.recommend;
    }

    @Override // com.coolapk.market.model.DyhModel
    @SerializedName("uniteEditor")
    public List<String> getEditors() {
        return this.editors;
    }

    @Override // com.coolapk.market.model.DyhModel
    @SerializedName("follownum")
    public int getFollowNum() {
        return this.followNum;
    }

    @Override // com.coolapk.market.model.DyhModel
    public int getStatus() {
        return this.status;
    }

    @Override // com.coolapk.market.model.DyhModel
    public String getStatusText() {
        return this.statusText;
    }

    @Override // com.coolapk.market.model.DyhModel
    public List<DyhArticle> getEntities() {
        return this.entities;
    }

    @Override // com.coolapk.market.model.DyhModel
    public UserAction getUserAction() {
        return this.userAction;
    }

    @Override // com.coolapk.market.model.DyhModel
    public Unread getUnread() {
        return this.unread;
    }

    @Override // java.lang.Object
    public String toString() {
        return "DyhModel{entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", url=" + this.url + ", pic=" + this.pic + ", subTitle=" + this.subTitle + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", deprecatedUserAvatar=" + this.deprecatedUserAvatar + ", userInfo=" + this.userInfo + ", deprecatedUserName=" + this.deprecatedUserName + ", displayUserName=" + this.displayUserName + ", entityTypeName=" + this.entityTypeName + ", id=" + this.id + ", uid=" + this.uid + ", description=" + this.description + ", author=" + this.author + ", fromInfo=" + this.fromInfo + ", title=" + this.title + ", editorInfo=" + this.editorInfo + ", logo=" + this.logo + ", keywords=" + this.keywords + ", hasTab=" + this.hasTab + ", likeNum=" + this.likeNum + ", newsNum=" + this.newsNum + ", recommend=" + this.recommend + ", editors=" + this.editors + ", followNum=" + this.followNum + ", status=" + this.status + ", statusText=" + this.statusText + ", entities=" + this.entities + ", userAction=" + this.userAction + ", unread=" + this.unread + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        List<DyhArticle> list;
        UserAction userAction2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DyhModel)) {
            return false;
        }
        DyhModel dyhModel = (DyhModel) obj;
        String str2 = this.entityTemplate;
        if (str2 != null ? str2.equals(dyhModel.getEntityTemplate()) : dyhModel.getEntityTemplate() == null) {
            String str3 = this.entityId;
            if (str3 != null ? str3.equals(dyhModel.getEntityId()) : dyhModel.getEntityId() == null) {
                Integer num = this.entityFixed;
                if (num != null ? num.equals(dyhModel.getEntityFixed()) : dyhModel.getEntityFixed() == null) {
                    String str4 = this.url;
                    if (str4 != null ? str4.equals(dyhModel.getUrl()) : dyhModel.getUrl() == null) {
                        String str5 = this.pic;
                        if (str5 != null ? str5.equals(dyhModel.getPic()) : dyhModel.getPic() == null) {
                            String str6 = this.subTitle;
                            if (str6 != null ? str6.equals(dyhModel.getSubTitle()) : dyhModel.getSubTitle() == null) {
                                String str7 = this.extraData;
                                if (str7 != null ? str7.equals(dyhModel.getExtraData()) : dyhModel.getExtraData() == null) {
                                    Long l2 = this.dateline;
                                    if (l2 != null ? l2.equals(dyhModel.getDateline()) : dyhModel.getDateline() == null) {
                                        Long l3 = this.lastUpdate;
                                        if (l3 != null ? l3.equals(dyhModel.getLastUpdate()) : dyhModel.getLastUpdate() == null) {
                                            String str8 = this.deprecatedUserAvatar;
                                            if (str8 != null ? str8.equals(dyhModel.getDeprecatedUserAvatar()) : dyhModel.getDeprecatedUserAvatar() == null) {
                                                UserInfo userInfo2 = this.userInfo;
                                                if (userInfo2 != null ? userInfo2.equals(dyhModel.getUserInfo()) : dyhModel.getUserInfo() == null) {
                                                    String str9 = this.deprecatedUserName;
                                                    if (str9 != null ? str9.equals(dyhModel.getDeprecatedUserName()) : dyhModel.getDeprecatedUserName() == null) {
                                                        String str10 = this.displayUserName;
                                                        if (str10 != null ? str10.equals(dyhModel.getDisplayUserName()) : dyhModel.getDisplayUserName() == null) {
                                                            String str11 = this.entityTypeName;
                                                            if (str11 != null ? str11.equals(dyhModel.getEntityTypeName()) : dyhModel.getEntityTypeName() == null) {
                                                                String str12 = this.id;
                                                                if (str12 != null ? str12.equals(dyhModel.getId()) : dyhModel.getId() == null) {
                                                                    String str13 = this.uid;
                                                                    if (str13 != null ? str13.equals(dyhModel.getUid()) : dyhModel.getUid() == null) {
                                                                        String str14 = this.description;
                                                                        if (str14 != null ? str14.equals(dyhModel.getDescription()) : dyhModel.getDescription() == null) {
                                                                            String str15 = this.author;
                                                                            if (str15 != null ? str15.equals(dyhModel.getAuthor()) : dyhModel.getAuthor() == null) {
                                                                                String str16 = this.fromInfo;
                                                                                if (str16 != null ? str16.equals(dyhModel.getFromInfo()) : dyhModel.getFromInfo() == null) {
                                                                                    String str17 = this.title;
                                                                                    if (str17 != null ? str17.equals(dyhModel.getTitle()) : dyhModel.getTitle() == null) {
                                                                                        EditorInfo editorInfo2 = this.editorInfo;
                                                                                        if (editorInfo2 != null ? editorInfo2.equals(dyhModel.getEditorInfo()) : dyhModel.getEditorInfo() == null) {
                                                                                            String str18 = this.logo;
                                                                                            if (str18 != null ? str18.equals(dyhModel.getLogo()) : dyhModel.getLogo() == null) {
                                                                                                String str19 = this.keywords;
                                                                                                if (str19 != null ? str19.equals(dyhModel.getKeywords()) : dyhModel.getKeywords() == null) {
                                                                                                    if (this.hasTab == dyhModel.getHasTab() && this.likeNum == dyhModel.getLikeNum() && this.newsNum == dyhModel.getNewsNum() && this.recommend == dyhModel.getRecommend() && this.editors.equals(dyhModel.getEditors()) && this.followNum == dyhModel.getFollowNum() && this.status == dyhModel.getStatus() && ((str = this.statusText) != null ? str.equals(dyhModel.getStatusText()) : dyhModel.getStatusText() == null) && ((list = this.entities) != null ? list.equals(dyhModel.getEntities()) : dyhModel.getEntities() == null) && ((userAction2 = this.userAction) != null ? userAction2.equals(dyhModel.getUserAction()) : dyhModel.getUserAction() == null)) {
                                                                                                        Unread unread2 = this.unread;
                                                                                                        if (unread2 == null) {
                                                                                                            if (dyhModel.getUnread() == null) {
                                                                                                                return true;
                                                                                                            }
                                                                                                        } else if (unread2.equals(dyhModel.getUnread())) {
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
        String str = this.entityTemplate;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.entityId;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        Integer num = this.entityFixed;
        int hashCode3 = (hashCode2 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str3 = this.url;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.pic;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.subTitle;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.extraData;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        Long l2 = this.dateline;
        int hashCode8 = (hashCode7 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        Long l3 = this.lastUpdate;
        int hashCode9 = (hashCode8 ^ (l3 == null ? 0 : l3.hashCode())) * 1000003;
        String str7 = this.deprecatedUserAvatar;
        int hashCode10 = (hashCode9 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        UserInfo userInfo2 = this.userInfo;
        int hashCode11 = (hashCode10 ^ (userInfo2 == null ? 0 : userInfo2.hashCode())) * 1000003;
        String str8 = this.deprecatedUserName;
        int hashCode12 = (hashCode11 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.displayUserName;
        int hashCode13 = (hashCode12 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.entityTypeName;
        int hashCode14 = (hashCode13 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.id;
        int hashCode15 = (hashCode14 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.uid;
        int hashCode16 = (hashCode15 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        String str13 = this.description;
        int hashCode17 = (hashCode16 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.author;
        int hashCode18 = (hashCode17 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        String str15 = this.fromInfo;
        int hashCode19 = (hashCode18 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
        String str16 = this.title;
        int hashCode20 = (hashCode19 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003;
        EditorInfo editorInfo2 = this.editorInfo;
        int hashCode21 = (hashCode20 ^ (editorInfo2 == null ? 0 : editorInfo2.hashCode())) * 1000003;
        String str17 = this.logo;
        int hashCode22 = (hashCode21 ^ (str17 == null ? 0 : str17.hashCode())) * 1000003;
        String str18 = this.keywords;
        int hashCode23 = (((((((((((((((hashCode22 ^ (str18 == null ? 0 : str18.hashCode())) * 1000003) ^ this.hasTab) * 1000003) ^ this.likeNum) * 1000003) ^ this.newsNum) * 1000003) ^ this.recommend) * 1000003) ^ this.editors.hashCode()) * 1000003) ^ this.followNum) * 1000003) ^ this.status) * 1000003;
        String str19 = this.statusText;
        int hashCode24 = (hashCode23 ^ (str19 == null ? 0 : str19.hashCode())) * 1000003;
        List<DyhArticle> list = this.entities;
        int hashCode25 = (hashCode24 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        UserAction userAction2 = this.userAction;
        int hashCode26 = (hashCode25 ^ (userAction2 == null ? 0 : userAction2.hashCode())) * 1000003;
        Unread unread2 = this.unread;
        if (unread2 != null) {
            i = unread2.hashCode();
        }
        return hashCode26 ^ i;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_DyhModel$Builder */
    /* compiled from: $$AutoValue_DyhModel */
    static final class Builder extends DyhModel.Builder {
        private String author;
        private Long dateline;
        private String deprecatedUserAvatar;
        private String deprecatedUserName;
        private String description;
        private String displayUserName;
        private EditorInfo editorInfo;
        private List<String> editors;
        private List<DyhArticle> entities;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
        private String entityTypeName;
        private String extraData;
        private Integer followNum;
        private String fromInfo;
        private Integer hasTab;
        private String id;
        private String keywords;
        private Long lastUpdate;
        private Integer likeNum;
        private String logo;
        private Integer newsNum;
        private String pic;
        private Integer recommend;
        private Integer status;
        private String statusText;
        private String subTitle;
        private String title;
        private String uid;
        private Unread unread;
        private String url;
        private UserAction userAction;
        private UserInfo userInfo;

        Builder() {
        }

        Builder(DyhModel dyhModel) {
            this.entityTemplate = dyhModel.getEntityTemplate();
            this.entityId = dyhModel.getEntityId();
            this.entityFixed = dyhModel.getEntityFixed();
            this.url = dyhModel.getUrl();
            this.pic = dyhModel.getPic();
            this.subTitle = dyhModel.getSubTitle();
            this.extraData = dyhModel.getExtraData();
            this.dateline = dyhModel.getDateline();
            this.lastUpdate = dyhModel.getLastUpdate();
            this.deprecatedUserAvatar = dyhModel.getDeprecatedUserAvatar();
            this.userInfo = dyhModel.getUserInfo();
            this.deprecatedUserName = dyhModel.getDeprecatedUserName();
            this.displayUserName = dyhModel.getDisplayUserName();
            this.entityTypeName = dyhModel.getEntityTypeName();
            this.id = dyhModel.getId();
            this.uid = dyhModel.getUid();
            this.description = dyhModel.getDescription();
            this.author = dyhModel.getAuthor();
            this.fromInfo = dyhModel.getFromInfo();
            this.title = dyhModel.getTitle();
            this.editorInfo = dyhModel.getEditorInfo();
            this.logo = dyhModel.getLogo();
            this.keywords = dyhModel.getKeywords();
            this.hasTab = Integer.valueOf(dyhModel.getHasTab());
            this.likeNum = Integer.valueOf(dyhModel.getLikeNum());
            this.newsNum = Integer.valueOf(dyhModel.getNewsNum());
            this.recommend = Integer.valueOf(dyhModel.getRecommend());
            this.editors = dyhModel.getEditors();
            this.followNum = Integer.valueOf(dyhModel.getFollowNum());
            this.status = Integer.valueOf(dyhModel.getStatus());
            this.statusText = dyhModel.getStatusText();
            this.entities = dyhModel.getEntities();
            this.userAction = dyhModel.getUserAction();
            this.unread = dyhModel.getUnread();
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder entityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder entityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder entityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder url(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder pic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder subTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder extraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder dateline(Long l2) {
            this.dateline = l2;
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder lastUpdate(Long l2) {
            this.lastUpdate = l2;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public DyhModel.Builder deprecatedUserAvatar(String str) {
            this.deprecatedUserAvatar = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public DyhModel.Builder userInfo(UserInfo userInfo2) {
            this.userInfo = userInfo2;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public DyhModel.Builder deprecatedUserName(String str) {
            this.deprecatedUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public DyhModel.Builder displayUserName(String str) {
            this.displayUserName = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder entityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder id(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.IUser.BuilderM2
        public DyhModel.Builder uid(String str) {
            this.uid = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder description(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder author(String str) {
            this.author = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder fromInfo(String str) {
            this.fromInfo = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder title(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder editorInfo(EditorInfo editorInfo2) {
            this.editorInfo = editorInfo2;
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder logo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder keywords(String str) {
            this.keywords = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder hasTab(int i) {
            this.hasTab = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder likeNum(int i) {
            this.likeNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder newsNum(int i) {
            this.newsNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder recommend(int i) {
            this.recommend = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder editors(List<String> list) {
            this.editors = list;
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder followNum(int i) {
            this.followNum = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder status(int i) {
            this.status = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder statusText(String str) {
            this.statusText = str;
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder entities(List<DyhArticle> list) {
            this.entities = list;
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder userAction(UserAction userAction2) {
            this.userAction = userAction2;
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel.Builder unread(Unread unread2) {
            this.unread = unread2;
            return this;
        }

        @Override // com.coolapk.market.model.DyhModel.Builder
        public DyhModel build() {
            String str = "";
            if (this.hasTab == null) {
                str = str + " hasTab";
            }
            if (this.likeNum == null) {
                str = str + " likeNum";
            }
            if (this.newsNum == null) {
                str = str + " newsNum";
            }
            if (this.recommend == null) {
                str = str + " recommend";
            }
            if (this.editors == null) {
                str = str + " editors";
            }
            if (this.followNum == null) {
                str = str + " followNum";
            }
            if (this.status == null) {
                str = str + " status";
            }
            if (str.isEmpty()) {
                return new AutoValue_DyhModel(this.entityTemplate, this.entityId, this.entityFixed, this.url, this.pic, this.subTitle, this.extraData, this.dateline, this.lastUpdate, this.deprecatedUserAvatar, this.userInfo, this.deprecatedUserName, this.displayUserName, this.entityTypeName, this.id, this.uid, this.description, this.author, this.fromInfo, this.title, this.editorInfo, this.logo, this.keywords, this.hasTab.intValue(), this.likeNum.intValue(), this.newsNum.intValue(), this.recommend.intValue(), this.editors, this.followNum.intValue(), this.status.intValue(), this.statusText, this.entities, this.userAction, this.unread);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
