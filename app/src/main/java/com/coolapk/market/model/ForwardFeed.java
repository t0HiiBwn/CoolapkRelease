package com.coolapk.market.model;

import com.coolapk.market.model.C$AutoValue_ForwardFeed;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

public abstract class ForwardFeed implements Entity {
    @Override // com.coolapk.market.model.Entity
    public String getEntityType() {
        return "forwardFeed";
    }

    @Override // com.coolapk.market.model.Entity
    public abstract String getId();

    public abstract String getMessage();

    public abstract UserInfo getUserInfo();

    @Override // com.coolapk.market.model.Entity
    public int getEntityTypeId() {
        return getEntityType().hashCode();
    }

    public String getUserName() {
        if (getUserInfo() == null) {
            return null;
        }
        return getUserInfo().getUserName();
    }

    public String getUserAvatar() {
        if (getUserInfo() == null) {
            return null;
        }
        return getUserInfo().getUserAvatar();
    }

    public static TypeAdapter<ForwardFeed> typeAdapter(Gson gson) {
        return new C$AutoValue_ForwardFeed.GsonTypeAdapter(gson);
    }
}
