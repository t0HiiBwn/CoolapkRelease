package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

public class IndoorData implements Parcelable {
    public static final Parcelable.Creator<IndoorData> CREATOR = new Parcelable.Creator<IndoorData>() {
        /* class com.amap.api.services.poisearch.IndoorData.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ IndoorData[] newArray(int i) {
            return new IndoorData[i];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IndoorData createFromParcel(Parcel parcel) {
            return new IndoorData(parcel);
        }
    };
    private String a;
    private int b;
    private String c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IndoorData(String str, int i, String str2) {
        this.a = str;
        this.b = i;
        this.c = str2;
    }

    public String getPoiId() {
        return this.a;
    }

    public void setPoiId(String str) {
        this.a = str;
    }

    public int getFloor() {
        return this.b;
    }

    public void setFloor(int i) {
        this.b = i;
    }

    public String getFloorName() {
        return this.c;
    }

    public void setFloorName(String str) {
        this.c = str;
    }

    protected IndoorData(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
    }
}
