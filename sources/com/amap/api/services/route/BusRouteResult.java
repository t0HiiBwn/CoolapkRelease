package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

public class BusRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<BusRouteResult> CREATOR = new Parcelable.Creator<BusRouteResult>() {
        /* class com.amap.api.services.route.BusRouteResult.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusRouteResult[] newArray(int i) {
            return new BusRouteResult[i];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusRouteResult createFromParcel(Parcel parcel) {
            return new BusRouteResult(parcel);
        }
    };
    private float a;
    private List<BusPath> b = new ArrayList();
    private RouteSearch.BusRouteQuery c;

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getTaxiCost() {
        return this.a;
    }

    public void setTaxiCost(float f) {
        this.a = f;
    }

    public List<BusPath> getPaths() {
        return this.b;
    }

    public void setPaths(List<BusPath> list) {
        this.b = list;
    }

    public RouteSearch.BusRouteQuery getBusQuery() {
        return this.c;
    }

    public void setBusQuery(RouteSearch.BusRouteQuery busRouteQuery) {
        this.c = busRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.a);
        parcel.writeTypedList(this.b);
        parcel.writeParcelable(this.c, i);
    }

    public BusRouteResult(Parcel parcel) {
        super(parcel);
        this.a = parcel.readFloat();
        this.b = parcel.createTypedArrayList(BusPath.CREATOR);
        this.c = (RouteSearch.BusRouteQuery) parcel.readParcelable(RouteSearch.BusRouteQuery.class.getClassLoader());
    }

    public BusRouteResult() {
    }
}
