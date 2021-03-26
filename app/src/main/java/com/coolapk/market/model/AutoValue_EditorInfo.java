package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_EditorInfo extends C$AutoValue_EditorInfo {
    public static final Parcelable.Creator<AutoValue_EditorInfo> CREATOR = new Parcelable.Creator<AutoValue_EditorInfo>() {
        /* class com.coolapk.market.model.AutoValue_EditorInfo.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_EditorInfo createFromParcel(Parcel parcel) {
            return new AutoValue_EditorInfo(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_EditorInfo[] newArray(int i) {
            return new AutoValue_EditorInfo[i];
        }
    };

    AutoValue_EditorInfo(String str, int i, int i2) {
        super(str, i, i2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (getEditorLevel() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getEditorLevel());
        }
        parcel.writeInt(getNewSubmitNum());
        parcel.writeInt(getNewFollowNum());
    }
}
