package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

public class District implements Parcelable {
    public static final Parcelable.Creator<District> CREATOR = new Parcelable.Creator<District>() {
        /* class com.amap.api.services.route.District.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ District[] newArray(int i) {
            return null;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ District createFromParcel(Parcel parcel) {
            return new District(parcel);
        }
    };
    private String a;
    private String b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDistrictName() {
        return this.a;
    }

    public void setDistrictName(String str) {
        this.a = str;
    }

    public String getDistrictAdcode() {
        return this.b;
    }

    public void setDistrictAdcode(String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }

    public District(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }

    public District() {
    }
}
