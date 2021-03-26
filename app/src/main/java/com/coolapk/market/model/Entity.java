package com.coolapk.market.model;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public interface Entity extends Parcelable {
    @SerializedName("dateline")
    Long getDateline();

    @SerializedName("description")
    String getDescription();

    @SerializedName("entityFixed")
    Integer getEntityFixed();

    @SerializedName("entityId")
    String getEntityId();

    @SerializedName("entityTemplate")
    String getEntityTemplate();

    @SerializedName("entityType")
    String getEntityType();

    int getEntityTypeId();

    @SerializedName("entityTypeName")
    String getEntityTypeName();

    @SerializedName("extraData")
    String getExtraData();

    @SerializedName("id")
    String getId();

    @SerializedName("lastupdate")
    Long getLastUpdate();

    @SerializedName("logo")
    String getLogo();

    @SerializedName("pic")
    String getPic();

    @SerializedName("subTitle")
    String getSubTitle();

    @SerializedName("title")
    String getTitle();

    @SerializedName("url")
    String getUrl();
}
