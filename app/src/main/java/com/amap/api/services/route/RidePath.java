package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class RidePath extends Path implements Parcelable {
    public static final Parcelable.Creator<RidePath> CREATOR = new Parcelable.Creator<RidePath>() {
        /* class com.amap.api.services.route.RidePath.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RidePath[] newArray(int i) {
            return null;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RidePath createFromParcel(Parcel parcel) {
            return new RidePath(parcel);
        }
    };
    private List<RideStep> a = new ArrayList();

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<RideStep> getSteps() {
        return this.a;
    }

    public void setSteps(List<RideStep> list) {
        this.a = list;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.a);
    }

    public RidePath(Parcel parcel) {
        super(parcel);
        this.a = parcel.createTypedArrayList(RideStep.CREATOR);
    }

    public RidePath() {
    }
}
