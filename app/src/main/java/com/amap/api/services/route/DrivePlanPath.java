package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class DrivePlanPath implements Parcelable {
    public static final Parcelable.Creator<DrivePlanPath> CREATOR = new Parcelable.Creator<DrivePlanPath>() {
        /* class com.amap.api.services.route.DrivePlanPath.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrivePlanPath[] newArray(int i) {
            return null;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrivePlanPath createFromParcel(Parcel parcel) {
            return new DrivePlanPath(parcel);
        }
    };
    float a;
    int b;
    private List<DrivePlanStep> c = new ArrayList();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.a;
    }

    public void setDistance(float f) {
        this.a = f;
    }

    public float getTrafficLights() {
        return (float) this.b;
    }

    public void setTrafficLights(int i) {
        this.b = i;
    }

    public List<DrivePlanStep> getSteps() {
        return this.c;
    }

    public void setSteps(List<DrivePlanStep> list) {
        this.c = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.a);
        parcel.writeInt(this.b);
        parcel.writeTypedList(this.c);
    }

    public DrivePlanPath(Parcel parcel) {
        this.a = parcel.readFloat();
        this.b = parcel.readInt();
        this.c = parcel.createTypedArrayList(DrivePlanStep.CREATOR);
    }

    public DrivePlanPath() {
    }
}
