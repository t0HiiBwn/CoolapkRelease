package com.coolapk.market.model;

import android.text.TextUtils;
import com.coolapk.market.model.C$$AutoValue_AlbumItem;
import com.coolapk.market.model.C$AutoValue_AlbumItem;
import com.coolapk.market.util.CacheUrlUtils;
import com.coolapk.market.util.StringUtils;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.io.File;

public abstract class AlbumItem implements Entity {
    public static final int DOWNLOAD_URL_TYPE_APK = 0;
    public static final int DOWNLOAD_URL_TYPE_EXTRA = 2;
    private String apkUrlCache;
    private String apkUrlMd5Cache;
    private String extraUrlCache;
    private String extraUrlMd5Cache;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @SerializedName("albumid")
    public abstract String getAlbumId();

    @SerializedName("aid")
    public abstract String getApkId();

    @SerializedName("displayorder")
    public abstract int getDisplayOrder();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "albumItem";
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return 249142818;
    }

    public abstract String getExtraAnalysisData();

    public abstract String getNote();

    @SerializedName("apkname")
    public abstract String getPackageName();

    public abstract String getSourceName();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("title")
    public abstract String getTitle();

    @Override // com.coolapk.market.model.Entity
    public abstract String getUrl();

    @SerializedName("apkversioncode")
    public abstract int getVersionCode();

    @SerializedName("apkversionname")
    public abstract String getVersionName();

    public String getLogoUrl() {
        return getPic();
    }

    public boolean isHttpLogo() {
        return getLogoUrl().startsWith("http");
    }

    public String getDownloadUrl() {
        cacheUrl();
        return this.apkUrlCache;
    }

    public String getDownloadUrlMd5() {
        cacheUrl();
        return this.apkUrlMd5Cache;
    }

    private void cacheUrl() {
        if (this.apkUrlCache == null) {
            String apkDownloadUrl = CacheUrlUtils.getApkDownloadUrl(getPackageName(), getApkId(), getVersionCode(), false);
            this.apkUrlCache = apkDownloadUrl;
            this.apkUrlMd5Cache = StringUtils.toMd5(apkDownloadUrl);
        }
        if (this.extraUrlCache == null) {
            String apkDownloadUrl2 = CacheUrlUtils.getApkDownloadUrl(getPackageName(), getApkId(), getVersionCode(), true);
            this.extraUrlCache = apkDownloadUrl2;
            this.extraUrlMd5Cache = StringUtils.toMd5(apkDownloadUrl2);
        }
    }

    public String getDownloadUrl(int i) {
        cacheUrl();
        if (i != 2) {
            return this.apkUrlCache;
        }
        return this.extraUrlCache;
    }

    public String getDownloadUrlMd5(int i) {
        cacheUrl();
        if (i != 2) {
            return this.apkUrlMd5Cache;
        }
        return this.extraUrlMd5Cache;
    }

    public static TypeAdapter<AlbumItem> typeAdapter(Gson gson) {
        return new C$AutoValue_AlbumItem.GsonTypeAdapter(gson);
    }

    public static Builder newBuilder() {
        return new C$$AutoValue_AlbumItem.Builder();
    }

    public static Builder newBuilder(AlbumItem albumItem) {
        return new C$$AutoValue_AlbumItem.Builder(albumItem);
    }

    public static AlbumItem createNewAlbumItem(MobileApp mobileApp) {
        return newBuilder().setPackageName(mobileApp.getPackageName()).setTitle(mobileApp.getAppName()).setVersionCode(0).setDisplayOrder(1).build();
    }

    public static AlbumItem createAlbumItemBySapp(ServiceApp serviceApp) {
        return newBuilder().setPackageName(serviceApp.getPackageName()).setTitle(serviceApp.getAppName()).setVersionCode(0).setPic(serviceApp.getLogo()).setUrl(serviceApp.getApkUrl()).setDisplayOrder(1).build();
    }

    public File getLogoFile() {
        if (TextUtils.isEmpty(getLogoUrl())) {
            return null;
        }
        return new File(getLogoUrl());
    }

    public static Builder builder() {
        return new C$$AutoValue_AlbumItem.Builder();
    }

    public static abstract class Builder {
        public abstract AlbumItem build();

        public abstract Builder setAlbumId(String str);

        public abstract Builder setApkId(String str);

        public abstract Builder setDateline(Long l2);

        public abstract Builder setDescription(String str);

        public abstract Builder setDisplayOrder(int i);

        public abstract Builder setEntityFixed(Integer num);

        public abstract Builder setEntityId(String str);

        public abstract Builder setEntityTemplate(String str);

        public abstract Builder setEntityTypeName(String str);

        public abstract Builder setExtraAnalysisData(String str);

        public abstract Builder setExtraData(String str);

        public abstract Builder setId(String str);

        public abstract Builder setLastUpdate(Long l2);

        public abstract Builder setLogo(String str);

        public abstract Builder setNote(String str);

        public abstract Builder setPackageName(String str);

        public abstract Builder setPic(String str);

        public abstract Builder setSourceName(String str);

        public abstract Builder setSubTitle(String str);

        public abstract Builder setTitle(String str);

        public abstract Builder setUrl(String str);

        public abstract Builder setVersionCode(int i);

        public abstract Builder setVersionName(String str);

        public Builder setLogoUrl(String str) {
            setPic(str);
            return this;
        }
    }
}
