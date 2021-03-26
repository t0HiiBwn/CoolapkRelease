package com.amap.api.services.help;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public class Tip implements Parcelable {
    public static final Parcelable.Creator<Tip> CREATOR = new Parcelable.Creator<Tip>() {
        /* class com.amap.api.services.help.Tip.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Tip[] newArray(int i) {
            return null;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Tip createFromParcel(Parcel parcel) {
            return new Tip(parcel, (byte) 0);
        }
    };
    private String a;
    private LatLonPoint b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ Tip(Parcel parcel, byte b2) {
        this(parcel);
    }

    public Tip() {
        this.h = "";
    }

    public String getPoiID() {
        return this.a;
    }

    public void setID(String str) {
        this.a = str;
    }

    public LatLonPoint getPoint() {
        return this.b;
    }

    public void setPostion(LatLonPoint latLonPoint) {
        this.b = latLonPoint;
    }

    public String getName() {
        return this.c;
    }

    public void setName(String str) {
        this.c = str;
    }

    public String getDistrict() {
        return this.d;
    }

    public void setDistrict(String str) {
        this.d = str;
    }

    public String getAdcode() {
        return this.e;
    }

    public void setAdcode(String str) {
        this.e = str;
    }

    public String getAddress() {
        return this.f;
    }

    public void setAddress(String str) {
        this.f = str;
    }

    public void setTypeCode(String str) {
        this.g = str;
    }

    public String getTypeCode() {
        return this.g;
    }

    @Override // java.lang.Object
    public String toString() {
        return "name:" + this.c + " district:" + this.d + " adcode:" + this.e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeString(this.e);
        parcel.writeString(this.d);
        parcel.writeString(this.a);
        parcel.writeValue(this.b);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
    }

    private Tip(Parcel parcel) {
        this.h = "";
        this.c = parcel.readString();
        this.e = parcel.readString();
        this.d = parcel.readString();
        this.a = parcel.readString();
        this.b = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
    }
}
