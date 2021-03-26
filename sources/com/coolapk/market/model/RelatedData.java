package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$$AutoValue_RelatedData;
import com.coolapk.market.model.C$AutoValue_RelatedData;
import com.coolapk.market.model.IUser;
import com.coolapk.market.util.UserUtils;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

public abstract class RelatedData implements Parcelable, IUser {

    public static abstract class Builder implements IUser.BuilderM1<Builder> {
        public abstract RelatedData build();

        public abstract Builder setId(String str);

        public abstract Builder setValue(int i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract String getId();

    @Override // com.coolapk.market.model.IUser
    public abstract String getUid();

    public abstract int getValue();

    public String getUserAvatar() {
        String userAvatar = IUser.IUserGetter.getUserAvatar(this);
        return userAvatar != null ? userAvatar : UserUtils.getAvatarUrl(getUid());
    }

    public String getUserName() {
        return IUser.IUserGetter.getUserName(this);
    }

    public static TypeAdapter<RelatedData> typeAdapter(Gson gson) {
        return new C$AutoValue_RelatedData.GsonTypeAdapter(gson);
    }

    public static Builder newBuilder() {
        return new C$$AutoValue_RelatedData.Builder();
    }

    public static Builder newBuilder(RelatedData relatedData) {
        return new C$$AutoValue_RelatedData.Builder(relatedData);
    }
}
