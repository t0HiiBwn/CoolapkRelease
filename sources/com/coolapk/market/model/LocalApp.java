package com.coolapk.market.model;

import android.text.TextUtils;
import com.coolapk.market.model.C$$AutoValue_LocalApp;
import com.coolapk.market.model.C$AutoValue_LocalApp;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.io.File;

public abstract class LocalApp implements Entity {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @SerializedName("aid")
    public abstract String getApkId();

    public abstract String getApkSize();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "backupApp";
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return 249142818;
    }

    @SerializedName("apkname")
    public abstract String getPackageName();

    @Override // com.coolapk.market.model.Entity
    @SerializedName("title")
    public abstract String getTitle();

    @Override // com.coolapk.market.model.Entity
    public abstract String getUrl();

    public String getLogoUrl() {
        return getPic();
    }

    public static TypeAdapter<LocalApp> typeAdapter(Gson gson) {
        return new C$AutoValue_LocalApp.GsonTypeAdapter(gson);
    }

    public static Builder newBuilder() {
        return new C$$AutoValue_LocalApp.Builder();
    }

    public static Builder newBuilder(LocalApp localApp) {
        return new C$$AutoValue_LocalApp.Builder(localApp);
    }

    public File getLogoFile() {
        if (TextUtils.isEmpty(getLogoUrl())) {
            return null;
        }
        return new File(getLogoUrl());
    }

    public static Builder builder() {
        return new C$$AutoValue_LocalApp.Builder();
    }

    public static abstract class Builder {
        public abstract LocalApp build();

        public abstract Builder setApkId(String str);

        public abstract Builder setApkSize(String str);

        public abstract Builder setDateline(Long l);

        public abstract Builder setDescription(String str);

        public abstract Builder setEntityFixed(Integer num);

        public abstract Builder setEntityId(String str);

        public abstract Builder setEntityTemplate(String str);

        public abstract Builder setEntityTypeName(String str);

        public abstract Builder setExtraData(String str);

        public abstract Builder setId(String str);

        public abstract Builder setLastUpdate(Long l);

        public abstract Builder setLogo(String str);

        public abstract Builder setPackageName(String str);

        public abstract Builder setPic(String str);

        public abstract Builder setSubTitle(String str);

        public abstract Builder setTitle(String str);

        public abstract Builder setUrl(String str);

        public Builder setLogoUrl(String str) {
            setPic(str);
            return this;
        }
    }
}
