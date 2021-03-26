package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_Unread extends C$AutoValue_Unread {
    public static final Parcelable.Creator<AutoValue_Unread> CREATOR = new Parcelable.Creator<AutoValue_Unread>() {
        /* class com.coolapk.market.model.AutoValue_Unread.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_Unread createFromParcel(Parcel parcel) {
            return new AutoValue_Unread(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_Unread[] newArray(int i) {
            return new AutoValue_Unread[i];
        }
    };

    AutoValue_Unread(String str, int i) {
        super(str, i);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (getUnreadTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUnreadTitle());
        }
        parcel.writeInt(getUnreadNum());
    }
}
