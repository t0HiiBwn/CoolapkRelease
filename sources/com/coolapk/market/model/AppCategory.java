package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_AppCategory;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.util.List;

public abstract class AppCategory implements Entity {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract String getApkType();

    @Override // com.coolapk.market.model.Entity
    public abstract String getDescription();

    @Override // com.coolapk.market.model.Entity
    public abstract String getId();

    public abstract String getKeywords();

    @Override // com.coolapk.market.model.Entity
    public abstract String getLogo();

    public abstract List<String> getTagList();

    @Override // com.coolapk.market.model.Entity
    public abstract String getTitle();

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public boolean isGameType() {
        return getApkType().equals("2");
    }

    public boolean isAppType() {
        return getApkType().equals("1");
    }

    public static TypeAdapter<AppCategory> typeAdapter(Gson gson) {
        return new C$AutoValue_AppCategory.GsonTypeAdapter(gson);
    }

    public static AppCategory create(String str, String str2, List<String> list, String str3) {
        return new AutoValue_AppCategory("", "", null, null, null, null, null, null, null, null, null, str, str2, null, null, null, list, str3);
    }
}
