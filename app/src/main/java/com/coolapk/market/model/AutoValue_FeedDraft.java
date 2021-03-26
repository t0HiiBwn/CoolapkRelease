package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

final class AutoValue_FeedDraft extends C$AutoValue_FeedDraft {
    public static final Parcelable.Creator<AutoValue_FeedDraft> CREATOR = new Parcelable.Creator<AutoValue_FeedDraft>() {
        /* class com.coolapk.market.model.AutoValue_FeedDraft.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_FeedDraft createFromParcel(Parcel parcel) {
            return new AutoValue_FeedDraft(parcel.readString(), parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readArrayList(ImageUrl.class.getClassLoader()), parcel.readInt() == 0 ? parcel.readString() : null);
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_FeedDraft[] newArray(int i) {
            return new AutoValue_FeedDraft[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_FeedDraft(String str, String str2, String str3, List<ImageUrl> list, String str4) {
        super(str, str2, str3, list, str4);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getType());
        if (getExtraId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExtraId());
        }
        if (getExtraData() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExtraData());
        }
        parcel.writeList(getImageUriList());
        if (getMessage() == null) {
            parcel.writeInt(1);
            return;
        }
        parcel.writeInt(0);
        parcel.writeString(getMessage());
    }
}
