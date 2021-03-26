package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_Message extends C$AutoValue_Message {
    public static final Parcelable.Creator<AutoValue_Message> CREATOR = new Parcelable.Creator<AutoValue_Message>() {
        /* class com.coolapk.market.model.AutoValue_Message.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_Message createFromParcel(Parcel parcel) {
            return new AutoValue_Message(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() == 0 ? parcel.readString() : null, (UserInfo) parcel.readParcelable(UserInfo.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, (NotifyCount) parcel.readParcelable(NotifyCount.class.getClassLoader()), parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() == 0 ? parcel.readString() : null, (UserInfo) parcel.readParcelable(UserInfo.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_Message[] newArray(int i) {
            return new AutoValue_Message[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_Message(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l2, Long l3, String str11, UserInfo userInfo, String str12, String str13, String str14, String str15, String str16, String str17, String str18, int i, int i2, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, NotifyCount notifyCount, int i3, int i4, Integer num2, String str27, UserInfo userInfo2) {
        super(str, str2, str3, num, str4, str5, str6, str7, str8, str9, str10, l2, l3, str11, userInfo, str12, str13, str14, str15, str16, str17, str18, i, i2, str19, str20, str21, str22, str23, str24, str25, str26, notifyCount, i3, i4, num2, str27, userInfo2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (getEntityTypeName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getEntityTypeName());
        }
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
        if (getDeprecatedUserAvatar() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDeprecatedUserAvatar());
        }
        parcel.writeParcelable(getUserInfo(), i);
        if (getDeprecatedUserName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDeprecatedUserName());
        }
        if (getDisplayUserName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDisplayUserName());
        }
        parcel.writeString(getId());
        parcel.writeString(getUKey());
        parcel.writeString(getUid());
        parcel.writeString(getFromUid());
        parcel.writeString(getFromUserName());
        parcel.writeInt(getIsLast());
        parcel.writeInt(getIsNew());
        parcel.writeString(getMessage());
        if (getMessagePic() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getMessagePic());
        }
        if (getMessageExtra() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getMessageExtra());
        }
        if (getMessageCard() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getMessageCard());
        }
        parcel.writeString(getMessageUid());
        parcel.writeString(getMessageUserName());
        if (getFromUserAvatar() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getFromUserAvatar());
        }
        if (getMessageUserAvatar() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getMessageUserAvatar());
        }
        parcel.writeParcelable(getNotifyCount(), i);
        parcel.writeInt(getUnreadNum());
        parcel.writeInt(getIsTop());
        if (getIsLong() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(getIsLong().intValue());
        }
        if (getEntityType() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getEntityType());
        }
        parcel.writeParcelable(getMessageUserInfo(), i);
    }
}
