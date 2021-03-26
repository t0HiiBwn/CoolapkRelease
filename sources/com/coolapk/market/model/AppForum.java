package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_AppForum;
import com.coolapk.market.util.CacheUrlUtils;
import com.coolapk.market.util.StringUtils;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public abstract class AppForum implements Entity {
    public static final int DOWNLOAD_URL_TYPE_APK = 0;
    public static final int DOWNLOAD_URL_TYPE_EXTRA = 2;
    private String apkUrlCache;
    private String apkUrlMd5Cache;
    private String extraUrlCache;
    private String extraUrlMd5Cache;

    @SerializedName("apkname")
    public abstract String apkName();

    @SerializedName("apksize")
    public abstract String apkSize();

    @SerializedName("apktype")
    public abstract int apkType();

    @SerializedName("shorttitle")
    public abstract String appName();

    public abstract String appUrl();

    @SerializedName("comment_block_num")
    public abstract int commentBlockNum();

    public abstract String commentCount();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract String downCount();

    @SerializedName("extendfile")
    public abstract String extendFile();

    public abstract String extraAnalysisData();

    public abstract String followCount();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "appForum";
    }

    @Override // com.coolapk.market.model.Entity
    public String getEntityTypeName() {
        return "appForum";
    }

    @SerializedName("target_id")
    public abstract String getTargetId();

    public abstract String introduce();

    protected abstract int is_download_app();

    public abstract String packageName();

    public abstract List<String> screenList();

    @SerializedName("sdkversion")
    public abstract int supportAndroidVersion();

    public abstract List<String> thumbList();

    public abstract UserAction userAction();

    @SerializedName("apkversioncode")
    public abstract int versionCode();

    @SerializedName("apkversionname")
    public abstract String versionName();

    public static TypeAdapter<AppForum> typeAdapter(Gson gson) {
        return new C$AutoValue_AppForum.GsonTypeAdapter(gson).setDefaultVersionCode(0);
    }

    public String id() {
        return getId();
    }

    public String title() {
        return getTitle();
    }

    public String logo() {
        return getLogo();
    }

    public boolean isDownloadApp() {
        return is_download_app() == 1;
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
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

    private void cacheUrl() {
        if (this.apkUrlCache == null) {
            String apkDownloadUrl = CacheUrlUtils.getApkDownloadUrl(packageName(), id(), versionCode(), false);
            this.apkUrlCache = apkDownloadUrl;
            this.apkUrlMd5Cache = StringUtils.toMd5(apkDownloadUrl);
        }
        if (this.extraUrlCache == null) {
            String apkDownloadUrl2 = CacheUrlUtils.getApkDownloadUrl(packageName(), id(), versionCode(), true);
            this.extraUrlCache = apkDownloadUrl2;
            this.extraUrlMd5Cache = StringUtils.toMd5(apkDownloadUrl2);
        }
    }
}
