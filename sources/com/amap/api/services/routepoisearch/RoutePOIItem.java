package com.amap.api.services.routepoisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public class RoutePOIItem implements Parcelable {
    public static final Parcelable.Creator<RoutePOIItem> CREATOR = new Parcelable.Creator<RoutePOIItem>() {
        /* class com.amap.api.services.routepoisearch.RoutePOIItem.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RoutePOIItem[] newArray(int i) {
            return new RoutePOIItem[i];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RoutePOIItem createFromParcel(Parcel parcel) {
            return new RoutePOIItem(parcel);
        }
    };
    private String a;
    private String b;
    private LatLonPoint c;
    private float d;
    private float e;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RoutePOIItem() {
    }

    public String getID() {
        return this.a;
    }

    public void setID(String str) {
        this.a = str;
    }

    public String getTitle() {
        return this.b;
    }

    public void setTitle(String str) {
        this.b = str;
    }

    public LatLonPoint getPoint() {
        return this.c;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.c = latLonPoint;
    }

    public float getDistance() {
        return this.d;
    }

    public void setDistance(float f) {
        this.d = f;
    }

    public float getDuration() {
        return this.e;
    }

    public void setDuration(float f) {
        this.e = f;
    }

    protected RoutePOIItem(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.d = parcel.readFloat();
        this.e = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeParcelable(this.c, i);
        parcel.writeFloat(this.d);
        parcel.writeFloat(this.e);
    }
}
