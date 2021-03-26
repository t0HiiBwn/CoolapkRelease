package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

public class PoiItemExtension implements Parcelable {
    public static final Parcelable.Creator<PoiItemExtension> CREATOR = new Parcelable.Creator<PoiItemExtension>() {
        /* class com.amap.api.services.poisearch.PoiItemExtension.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PoiItemExtension[] newArray(int i) {
            return new PoiItemExtension[i];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItemExtension createFromParcel(Parcel parcel) {
            return new PoiItemExtension(parcel);
        }
    };
    private String a;
    private String b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PoiItemExtension(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String getOpentime() {
        return this.a;
    }

    public String getmRating() {
        return this.b;
    }

    protected PoiItemExtension(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }
}
