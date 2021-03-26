package com.coolapk.market.model;

import com.coolapk.market.model.DeviceParams;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_DeviceParams  reason: invalid class name */
abstract class C$$AutoValue_DeviceParams extends DeviceParams {
    private final int checkBox;
    private final Long dateline;
    private final String description;
    private final Integer entityFixed;
    private final String entityId;
    private final String entityTemplate;
    private final String entityTypeName;
    private final String extraData;
    private final String id;
    private final String key;
    private final Long lastUpdate;
    private final String logo;
    private final List<String> option;
    private final String pic;
    private final String subTitle;
    private final String title;
    private final String url;

    C$$AutoValue_DeviceParams(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l2, Long l3, String str11, String str12, List<String> list, int i) {
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
        Objects.requireNonNull(str11, "Null title");
        this.title = str11;
        this.key = str12;
        this.option = list;
        this.checkBox = i;
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

    @Override // com.coolapk.market.model.DeviceParams, com.coolapk.market.model.Entity
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.DeviceParams
    public String getKey() {
        return this.key;
    }

    @Override // com.coolapk.market.model.DeviceParams
    public List<String> getOption() {
        return this.option;
    }

    @Override // com.coolapk.market.model.DeviceParams
    public int getCheckBox() {
        return this.checkBox;
    }

    @Override // java.lang.Object
    public String toString() {
        return "DeviceParams{entityTypeName=" + this.entityTypeName + ", entityTemplate=" + this.entityTemplate + ", entityId=" + this.entityId + ", entityFixed=" + this.entityFixed + ", url=" + this.url + ", description=" + this.description + ", pic=" + this.pic + ", logo=" + this.logo + ", subTitle=" + this.subTitle + ", id=" + this.id + ", extraData=" + this.extraData + ", dateline=" + this.dateline + ", lastUpdate=" + this.lastUpdate + ", title=" + this.title + ", key=" + this.key + ", option=" + this.option + ", checkBox=" + this.checkBox + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        List<String> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceParams)) {
            return false;
        }
        DeviceParams deviceParams = (DeviceParams) obj;
        String str2 = this.entityTypeName;
        if (str2 != null ? str2.equals(deviceParams.getEntityTypeName()) : deviceParams.getEntityTypeName() == null) {
            String str3 = this.entityTemplate;
            if (str3 != null ? str3.equals(deviceParams.getEntityTemplate()) : deviceParams.getEntityTemplate() == null) {
                String str4 = this.entityId;
                if (str4 != null ? str4.equals(deviceParams.getEntityId()) : deviceParams.getEntityId() == null) {
                    Integer num = this.entityFixed;
                    if (num != null ? num.equals(deviceParams.getEntityFixed()) : deviceParams.getEntityFixed() == null) {
                        String str5 = this.url;
                        if (str5 != null ? str5.equals(deviceParams.getUrl()) : deviceParams.getUrl() == null) {
                            String str6 = this.description;
                            if (str6 != null ? str6.equals(deviceParams.getDescription()) : deviceParams.getDescription() == null) {
                                String str7 = this.pic;
                                if (str7 != null ? str7.equals(deviceParams.getPic()) : deviceParams.getPic() == null) {
                                    String str8 = this.logo;
                                    if (str8 != null ? str8.equals(deviceParams.getLogo()) : deviceParams.getLogo() == null) {
                                        String str9 = this.subTitle;
                                        if (str9 != null ? str9.equals(deviceParams.getSubTitle()) : deviceParams.getSubTitle() == null) {
                                            String str10 = this.id;
                                            if (str10 != null ? str10.equals(deviceParams.getId()) : deviceParams.getId() == null) {
                                                String str11 = this.extraData;
                                                if (str11 != null ? str11.equals(deviceParams.getExtraData()) : deviceParams.getExtraData() == null) {
                                                    Long l2 = this.dateline;
                                                    if (l2 != null ? l2.equals(deviceParams.getDateline()) : deviceParams.getDateline() == null) {
                                                        Long l3 = this.lastUpdate;
                                                        if (l3 != null ? l3.equals(deviceParams.getLastUpdate()) : deviceParams.getLastUpdate() == null) {
                                                            if (this.title.equals(deviceParams.getTitle()) && ((str = this.key) != null ? str.equals(deviceParams.getKey()) : deviceParams.getKey() == null) && ((list = this.option) != null ? list.equals(deviceParams.getOption()) : deviceParams.getOption() == null) && this.checkBox == deviceParams.getCheckBox()) {
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
        int hashCode13 = (((hashCode12 ^ (l3 == null ? 0 : l3.hashCode())) * 1000003) ^ this.title.hashCode()) * 1000003;
        String str11 = this.key;
        int hashCode14 = (hashCode13 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        List<String> list = this.option;
        if (list != null) {
            i = list.hashCode();
        }
        return ((hashCode14 ^ i) * 1000003) ^ this.checkBox;
    }

    /* renamed from: com.coolapk.market.model.$$AutoValue_DeviceParams$Builder */
    /* compiled from: $$AutoValue_DeviceParams */
    static final class Builder extends DeviceParams.Builder {
        private Integer checkBox;
        private Long dateline;
        private String description;
        private Integer entityFixed;
        private String entityId;
        private String entityTemplate;
        private String entityTypeName;
        private String extraData;
        private String id;
        private String key;
        private Long lastUpdate;
        private String logo;
        private List<String> option;
        private String pic;
        private String subTitle;
        private String title;
        private String url;

        Builder() {
        }

        Builder(DeviceParams deviceParams) {
            this.entityTypeName = deviceParams.getEntityTypeName();
            this.entityTemplate = deviceParams.getEntityTemplate();
            this.entityId = deviceParams.getEntityId();
            this.entityFixed = deviceParams.getEntityFixed();
            this.url = deviceParams.getUrl();
            this.description = deviceParams.getDescription();
            this.pic = deviceParams.getPic();
            this.logo = deviceParams.getLogo();
            this.subTitle = deviceParams.getSubTitle();
            this.id = deviceParams.getId();
            this.extraData = deviceParams.getExtraData();
            this.dateline = deviceParams.getDateline();
            this.lastUpdate = deviceParams.getLastUpdate();
            this.title = deviceParams.getTitle();
            this.key = deviceParams.getKey();
            this.option = deviceParams.getOption();
            this.checkBox = Integer.valueOf(deviceParams.getCheckBox());
        }

        @Override // com.coolapk.market.model.DeviceParams.Builder
        public DeviceParams.Builder entityTypeName(String str) {
            this.entityTypeName = str;
            return this;
        }

        @Override // com.coolapk.market.model.DeviceParams.Builder
        public DeviceParams.Builder entityTemplate(String str) {
            this.entityTemplate = str;
            return this;
        }

        @Override // com.coolapk.market.model.DeviceParams.Builder
        public DeviceParams.Builder entityId(String str) {
            this.entityId = str;
            return this;
        }

        @Override // com.coolapk.market.model.DeviceParams.Builder
        public DeviceParams.Builder entityFixed(Integer num) {
            this.entityFixed = num;
            return this;
        }

        @Override // com.coolapk.market.model.DeviceParams.Builder
        public DeviceParams.Builder url(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.DeviceParams.Builder
        public DeviceParams.Builder description(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.DeviceParams.Builder
        public DeviceParams.Builder pic(String str) {
            this.pic = str;
            return this;
        }

        @Override // com.coolapk.market.model.DeviceParams.Builder
        public DeviceParams.Builder logo(String str) {
            this.logo = str;
            return this;
        }

        @Override // com.coolapk.market.model.DeviceParams.Builder
        public DeviceParams.Builder subTitle(String str) {
            this.subTitle = str;
            return this;
        }

        @Override // com.coolapk.market.model.DeviceParams.Builder
        public DeviceParams.Builder id(String str) {
            this.id = str;
            return this;
        }

        @Override // com.coolapk.market.model.DeviceParams.Builder
        public DeviceParams.Builder extraData(String str) {
            this.extraData = str;
            return this;
        }

        @Override // com.coolapk.market.model.DeviceParams.Builder
        public DeviceParams.Builder dateline(Long l2) {
            this.dateline = l2;
            return this;
        }

        @Override // com.coolapk.market.model.DeviceParams.Builder
        public DeviceParams.Builder lastUpdate(Long l2) {
            this.lastUpdate = l2;
            return this;
        }

        @Override // com.coolapk.market.model.DeviceParams.Builder
        public DeviceParams.Builder title(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.DeviceParams.Builder
        public DeviceParams.Builder key(String str) {
            this.key = str;
            return this;
        }

        @Override // com.coolapk.market.model.DeviceParams.Builder
        public DeviceParams.Builder option(List<String> list) {
            this.option = list;
            return this;
        }

        @Override // com.coolapk.market.model.DeviceParams.Builder
        public DeviceParams.Builder checkBox(int i) {
            this.checkBox = Integer.valueOf(i);
            return this;
        }

        @Override // com.coolapk.market.model.DeviceParams.Builder
        public DeviceParams build() {
            String str = "";
            if (this.title == null) {
                str = str + " title";
            }
            if (this.checkBox == null) {
                str = str + " checkBox";
            }
            if (str.isEmpty()) {
                return new AutoValue_DeviceParams(this.entityTypeName, this.entityTemplate, this.entityId, this.entityFixed, this.url, this.description, this.pic, this.logo, this.subTitle, this.id, this.extraData, this.dateline, this.lastUpdate, this.title, this.key, this.option, this.checkBox.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
