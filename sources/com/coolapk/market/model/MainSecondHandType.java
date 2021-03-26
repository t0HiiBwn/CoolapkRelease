package com.coolapk.market.model;

import android.text.TextUtils;
import com.coolapk.market.model.C$$AutoValue_MainSecondHandType;
import com.coolapk.market.model.C$AutoValue_MainSecondHandType;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

public abstract class MainSecondHandType implements Entity {

    public static abstract class Builder {
        public abstract MainSecondHandType build();

        public abstract Builder setConfigType(int i);

        public abstract Builder setDateline(Long l);

        public abstract Builder setDescription(String str);

        public abstract Builder setEntityFixed(Integer num);

        public abstract Builder setEntityId(String str);

        public abstract Builder setEntityTemplate(String str);

        public abstract Builder setEntityType(String str);

        public abstract Builder setEntityTypeName(String str);

        public abstract Builder setExtraData(String str);

        public abstract Builder setId(String str);

        public abstract Builder setLastUpdate(Long l);

        public abstract Builder setLogo(String str);

        public abstract Builder setPic(String str);

        public abstract Builder setSecondHandFeedNum(String str);

        public abstract Builder setSubTitle(String str);

        public abstract Builder setTitle(String str);

        public abstract Builder setUrl(String str);
    }

    @SerializedName("is_config")
    public abstract int getConfigType();

    @SerializedName("sale_num")
    public abstract String getSecondHandFeedNum();

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public String getSecondHandNumText() {
        if (TextUtils.equals(getSecondHandFeedNum(), "0") || TextUtils.isEmpty(getSecondHandFeedNum())) {
            return getTitle();
        }
        return getTitle() + "(" + getSecondHandFeedNum() + ")";
    }

    public static TypeAdapter<MainSecondHandType> typeAdapter(Gson gson) {
        return new C$AutoValue_MainSecondHandType.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new C$$AutoValue_MainSecondHandType.Builder();
    }
}
