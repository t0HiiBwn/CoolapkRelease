package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;

public final class Crossroad extends Road implements Parcelable {
    public static final Parcelable.Creator<Crossroad> CREATOR = new Parcelable.Creator<Crossroad>() {
        /* class com.amap.api.services.road.Crossroad.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Crossroad[] newArray(int i) {
            return null;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Crossroad createFromParcel(Parcel parcel) {
            return new Crossroad(parcel, (byte) 0);
        }
    };
    private float a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;

    @Override // com.amap.api.services.road.Road, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* synthetic */ Crossroad(Parcel parcel, byte b2) {
        this(parcel);
    }

    public Crossroad() {
    }

    public final float getDistance() {
        return this.a;
    }

    public final void setDistance(float f2) {
        this.a = f2;
    }

    public final String getDirection() {
        return this.b;
    }

    public final void setDirection(String str) {
        this.b = str;
    }

    public final String getFirstRoadId() {
        return this.c;
    }

    public final void setFirstRoadId(String str) {
        this.c = str;
    }

    public final String getFirstRoadName() {
        return this.d;
    }

    public final void setFirstRoadName(String str) {
        this.d = str;
    }

    public final String getSecondRoadId() {
        return this.e;
    }

    public final void setSecondRoadId(String str) {
        this.e = str;
    }

    public final String getSecondRoadName() {
        return this.f;
    }

    public final void setSecondRoadName(String str) {
        this.f = str;
    }

    @Override // com.amap.api.services.road.Road, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
    }

    private Crossroad(Parcel parcel) {
        super(parcel);
        this.a = parcel.readFloat();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
    }
}
