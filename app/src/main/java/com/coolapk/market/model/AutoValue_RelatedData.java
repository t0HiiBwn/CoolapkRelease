package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_RelatedData extends C$AutoValue_RelatedData {
    public static final Parcelable.Creator<AutoValue_RelatedData> CREATOR = new Parcelable.Creator<AutoValue_RelatedData>() {
        /* class com.coolapk.market.model.AutoValue_RelatedData.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_RelatedData createFromParcel(Parcel parcel) {
            return new AutoValue_RelatedData(parcel.readInt() == 0 ? parcel.readString() : null, (UserInfo) parcel.readParcelable(UserInfo.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_RelatedData[] newArray(int i) {
            return new AutoValue_RelatedData[i];
        }
    };

    AutoValue_RelatedData(String str, UserInfo userInfo, String str2, String str3, String str4, String str5, int i) {
        super(str, userInfo, str2, str3, str4, str5, i);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
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
        if (getId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getId());
        }
        parcel.writeString(getUid());
        parcel.writeInt(getValue());
    }
}
