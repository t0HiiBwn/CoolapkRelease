package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

final class AutoValue_VideoUrls extends C$AutoValue_VideoUrls {
    public static final Parcelable.Creator<AutoValue_VideoUrls> CREATOR = new Parcelable.Creator<AutoValue_VideoUrls>() {
        /* class com.coolapk.market.model.AutoValue_VideoUrls.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_VideoUrls createFromParcel(Parcel parcel) {
            return new AutoValue_VideoUrls(parcel.readArrayList(String.class.getClassLoader()), parcel.readArrayList(Integer.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_VideoUrls[] newArray(int i) {
            return new AutoValue_VideoUrls[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_VideoUrls(List<String> list, List<Integer> list2) {
        super(list, list2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(getUrlList());
        parcel.writeList(getDurationList());
    }
}
