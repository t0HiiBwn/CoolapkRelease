package com.coolapk.market.model;

import android.text.TextUtils;
import com.coolapk.market.model.C$AutoValue_UserHistory;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

public abstract class UserHistory implements Entity {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.coolapk.market.model.Entity
    public abstract String getDescription();

    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "history";
    }

    @Override // com.coolapk.market.model.Entity
    public abstract String getEntityTypeName();

    public abstract String getHistoryType();

    @Override // com.coolapk.market.model.Entity
    public abstract String getId();

    @Override // com.coolapk.market.model.Entity
    public abstract String getLogo();

    @Override // com.coolapk.market.model.Entity
    public abstract String getTitle();

    public abstract String getTypeName();

    @Override // com.coolapk.market.model.Entity
    public abstract String getUrl();

    public static TypeAdapter<UserHistory> typeAdapter(Gson gson) {
        return new C$AutoValue_UserHistory.GsonTypeAdapter(gson);
    }

    public String getContent() {
        return TextUtils.isEmpty(getDescription()) ? "" : getDescription().replace("\n", " ");
    }

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }
}
