package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$AutoValue_FileDetail;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class FileDetail implements Parcelable {
    public abstract Long dateline();

    @SerializedName("file_ext")
    public abstract String fileExt();

    @SerializedName("file_md5")
    public abstract String fileMd5();

    @SerializedName("file_size")
    public abstract String fileSize();

    @SerializedName("first_uid")
    public abstract String firstUid();

    public abstract String id();

    @SerializedName("is_banned")
    public abstract int isBanned();

    @SerializedName("is_block")
    public abstract int isBlock();

    @SerializedName("is_forbid")
    public abstract int isForbid();

    @SerializedName("last_uid")
    public abstract String lastUid();

    @SerializedName("last_update_time")
    public abstract Long lastUpdateTime();

    @SerializedName("spam_status")
    public abstract int spamStatus();

    @SerializedName("upload_count")
    public abstract int uploadCount();

    @SerializedName("upload_dir")
    public abstract String uploadDir();

    @SerializedName("upload_type")
    public abstract String uploadType();

    public abstract String url();

    @SerializedName("url_md5")
    public abstract String urlMd5();

    public static TypeAdapter<FileDetail> typeAdapter(Gson gson) {
        return new C$AutoValue_FileDetail.GsonTypeAdapter(gson);
    }
}
