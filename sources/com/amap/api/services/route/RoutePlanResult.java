package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public class RoutePlanResult implements Parcelable {
    public static final Parcelable.Creator<RoutePlanResult> CREATOR = new Parcelable.Creator<RoutePlanResult>() {
        /* class com.amap.api.services.route.RoutePlanResult.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RoutePlanResult[] newArray(int i) {
            return new RoutePlanResult[i];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RoutePlanResult createFromParcel(Parcel parcel) {
            return new RoutePlanResult(parcel);
        }
    };
    private LatLonPoint a;
    private LatLonPoint b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getStartPos() {
        return this.a;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.a = latLonPoint;
    }

    public LatLonPoint getTargetPos() {
        return this.b;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.b = latLonPoint;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeParcelable(this.b, i);
    }

    public RoutePlanResult(Parcel parcel) {
        this.a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    public RoutePlanResult() {
    }
}
