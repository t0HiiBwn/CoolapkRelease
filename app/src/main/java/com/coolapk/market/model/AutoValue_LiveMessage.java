package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_LiveMessage extends C$AutoValue_LiveMessage {
    public static final Parcelable.Creator<AutoValue_LiveMessage> CREATOR = new Parcelable.Creator<AutoValue_LiveMessage>() {
        /* class com.coolapk.market.model.AutoValue_LiveMessage.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_LiveMessage createFromParcel(Parcel parcel) {
            return new AutoValue_LiveMessage(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), (User) parcel.readParcelable(User.class.getClassLoader()), (LiveMessage) parcel.readParcelable(LiveMessage.class.getClassLoader()), parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_LiveMessage[] newArray(int i) {
            return new AutoValue_LiveMessage[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_LiveMessage(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Long l2, Long l3, String str13, String str14, String str15, String str16, String str17, int i, User user, LiveMessage liveMessage, String str18, int i2) {
        super(str, str2, str3, str4, num, str5, str6, str7, str8, str9, str10, str11, str12, l2, l3, str13, str14, str15, str16, str17, i, user, liveMessage, str18, i2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (getEntityTypeName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getEntityTypeName());
        }
        parcel.writeString(getEntityType());
        if (getEntityTemplate() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getEntityTemplate());
        }
        if (getEntityId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getEntityId());
        }
        if (getEntityFixed() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(getEntityFixed().intValue());
        }
        if (getTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getTitle());
        }
        if (getUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUrl());
        }
        if (getDescription() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDescription());
        }
        if (getPic() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getPic());
        }
        if (getLogo() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLogo());
        }
        if (getSubTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getSubTitle());
        }
        if (getId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getId());
        }
        if (getExtraData() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExtraData());
        }
        if (getDateline() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeLong(getDateline().longValue());
        }
        if (getLastUpdate() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeLong(getLastUpdate().longValue());
        }
        parcel.writeString(getLiveId());
        parcel.writeString(getUid());
        parcel.writeString(getUserName());
        parcel.writeString(getMessage());
        parcel.writeString(getMessageSource());
        parcel.writeInt(getIsBroadcast());
        parcel.writeParcelable(getUserInfo(), i);
        parcel.writeParcelable(getSourceRow(), i);
        parcel.writeString(getDatelineFormat());
        parcel.writeInt(getIsRead());
    }
}
