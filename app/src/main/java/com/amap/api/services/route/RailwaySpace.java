package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

public class RailwaySpace implements Parcelable {
    public static final Parcelable.Creator<RailwaySpace> CREATOR = new Parcelable.Creator<RailwaySpace>() {
        /* class com.amap.api.services.route.RailwaySpace.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RailwaySpace[] newArray(int i) {
            return new RailwaySpace[i];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RailwaySpace createFromParcel(Parcel parcel) {
            return new RailwaySpace(parcel);
        }
    };
    private String a;
    private float b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RailwaySpace(String str, float f) {
        this.a = str;
        this.b = f;
    }

    public String getCode() {
        return this.a;
    }

    public float getCost() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeFloat(this.b);
    }

    protected RailwaySpace(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readFloat();
    }
}
