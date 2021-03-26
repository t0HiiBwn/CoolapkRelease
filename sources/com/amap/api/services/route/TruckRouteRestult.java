package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.RouteSearch;
import java.util.List;

public class TruckRouteRestult implements Parcelable {
    public static final Parcelable.Creator<TruckRouteRestult> CREATOR = new Parcelable.Creator<TruckRouteRestult>() {
        /* class com.amap.api.services.route.TruckRouteRestult.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TruckRouteRestult[] newArray(int i) {
            return new TruckRouteRestult[i];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckRouteRestult createFromParcel(Parcel parcel) {
            return new TruckRouteRestult(parcel);
        }
    };
    private RouteSearch.TruckRouteQuery a;
    private List<TruckPath> b;
    private LatLonPoint c;
    private LatLonPoint d;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TruckRouteRestult() {
    }

    protected TruckRouteRestult(Parcel parcel) {
        this.b = parcel.createTypedArrayList(TruckPath.CREATOR);
        this.c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    public void setTruckQuery(RouteSearch.TruckRouteQuery truckRouteQuery) {
        this.a = truckRouteQuery;
    }

    public void setPaths(List<TruckPath> list) {
        this.b = list;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.c = latLonPoint;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.d = latLonPoint;
    }

    public RouteSearch.TruckRouteQuery getTruckQuery() {
        return this.a;
    }

    public List<TruckPath> getPaths() {
        return this.b;
    }

    public LatLonPoint getStartPos() {
        return this.c;
    }

    public LatLonPoint getTargetPos() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.b);
        parcel.writeParcelable(this.c, i);
        parcel.writeParcelable(this.d, i);
    }
}
