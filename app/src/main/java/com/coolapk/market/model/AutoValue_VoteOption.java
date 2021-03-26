package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_VoteOption extends C$AutoValue_VoteOption {
    public static final Parcelable.Creator<AutoValue_VoteOption> CREATOR = new Parcelable.Creator<AutoValue_VoteOption>() {
        /* class com.coolapk.market.model.AutoValue_VoteOption.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_VoteOption createFromParcel(Parcel parcel) {
            return new AutoValue_VoteOption(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt(), parcel.readInt() == 0 ? parcel.readString() : null);
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_VoteOption[] newArray(int i) {
            return new AutoValue_VoteOption[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_VoteOption(String str, int i, String str2, String str3, int i2, int i3, String str4) {
        super(str, i, str2, str3, i2, i3, str4);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (getColor() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getColor());
        }
        parcel.writeInt(getOrder());
        parcel.writeString(getId());
        if (getTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getTitle());
        }
        parcel.writeInt(getTotalCommentNum());
        parcel.writeInt(getTotalSelectNum());
        if (getVoteId() == null) {
            parcel.writeInt(1);
            return;
        }
        parcel.writeInt(0);
        parcel.writeString(getVoteId());
    }
}
