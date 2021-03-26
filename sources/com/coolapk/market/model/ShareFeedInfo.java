package com.coolapk.market.model;

import com.coolapk.market.model.C$$AutoValue_ShareFeedInfo;
import com.coolapk.market.model.C$AutoValue_ShareFeedInfo;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public abstract class ShareFeedInfo implements Entity {
    public static final int TYPE_LINK = 0;
    public static final int TYPE_MUSIC = 1;
    public static final int TYPE_VIDEO = 2;

    public static abstract class Builder {
        public abstract ShareFeedInfo build();

        public abstract Builder setDateline(Long l);

        public abstract Builder setDescription(String str);

        public abstract Builder setEntityFixed(Integer num);

        public abstract Builder setEntityId(String str);

        public abstract Builder setEntityTemplate(String str);

        public abstract Builder setEntityTypeName(String str);

        public abstract Builder setExtraData(String str);

        public abstract Builder setId(String str);

        public abstract Builder setImgList(List<String> list);

        public abstract Builder setIsDiscoveryApp(int i);

        public abstract Builder setLastUpdate(Long l);

        public abstract Builder setLogo(String str);

        public abstract Builder setMediaInfo(String str);

        public abstract Builder setMediaPic(String str);

        public abstract Builder setMediaType(int i);

        public abstract Builder setMediaUrl(String str);

        public abstract Builder setPackageName(String str);

        public abstract Builder setPic(String str);

        public abstract Builder setReference(String str);

        public abstract Builder setSourceName(String str);

        public abstract Builder setSubTitle(String str);

        public abstract Builder setTitle(String str);

        public abstract Builder setUrl(String str);
    }

    @Override // com.coolapk.market.model.Entity
    @SerializedName("description")
    public abstract String getDescription();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "shareUrl";
    }

    @SerializedName("imgList")
    public abstract List<String> getImgList();

    @SerializedName("is_share_app")
    public abstract int getIsDiscoveryApp();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("logo")
    public abstract String getLogo();

    @SerializedName("media_info")
    public abstract String getMediaInfo();

    @SerializedName("media_pic")
    public abstract String getMediaPic();

    @SerializedName("media_type")
    public abstract int getMediaType();

    @SerializedName("media_url")
    public abstract String getMediaUrl();

    @SerializedName("packageName")
    public abstract String getPackageName();

    @SerializedName("referer")
    public abstract String getReference();

    public abstract String getSourceName();

    @Override // com.coolapk.market.model.Entity
    public abstract String getTitle();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("url")
    public abstract String getUrl();

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public boolean isDiscovery() {
        return getIsDiscoveryApp() == 1;
    }

    public static TypeAdapter<ShareFeedInfo> typeAdapter(Gson gson) {
        return new C$AutoValue_ShareFeedInfo.GsonTypeAdapter(gson);
    }

    public static Builder newBuilder() {
        return new C$$AutoValue_ShareFeedInfo.Builder().setMediaType(0).setImgList(new ArrayList());
    }

    public static Builder newBuilder(ShareFeedInfo shareFeedInfo) {
        return new C$$AutoValue_ShareFeedInfo.Builder(shareFeedInfo);
    }
}
