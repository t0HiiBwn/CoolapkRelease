package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class TimeInfosElement implements Parcelable {
    public static final Parcelable.Creator<TimeInfosElement> CREATOR = new Parcelable.Creator<TimeInfosElement>() {
        /* class com.amap.api.services.route.TimeInfosElement.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TimeInfosElement[] newArray(int i) {
            return null;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TimeInfosElement createFromParcel(Parcel parcel) {
            return new TimeInfosElement(parcel);
        }
    };
    int a;
    float b;
    float c;
    int d;
    private List<TMC> e = new ArrayList();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPathindex() {
        return this.a;
    }

    public void setPathindex(int i) {
        this.a = i;
    }

    public float getDuration() {
        return this.b;
    }

    public void setDuration(float f) {
        this.b = f;
    }

    public float getTolls() {
        return this.c;
    }

    public void setTolls(float f) {
        this.c = f;
    }

    public int getRestriction() {
        return this.d;
    }

    public void setRestriction(int i) {
        this.d = i;
    }

    public void setTMCs(List<TMC> list) {
        this.e = list;
    }

    public List<TMC> getTMCs() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeFloat(this.b);
        parcel.writeFloat(this.c);
        parcel.writeInt(this.d);
        parcel.writeTypedList(this.e);
    }

    public TimeInfosElement(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readFloat();
        this.c = parcel.readFloat();
        this.d = parcel.readInt();
        this.e = parcel.createTypedArrayList(TMC.CREATOR);
    }

    public TimeInfosElement() {
    }
}
