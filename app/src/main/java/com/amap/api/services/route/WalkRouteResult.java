package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

public class WalkRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<WalkRouteResult> CREATOR = new Parcelable.Creator<WalkRouteResult>() {
        /* class com.amap.api.services.route.WalkRouteResult.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WalkRouteResult[] newArray(int i) {
            return new WalkRouteResult[i];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WalkRouteResult createFromParcel(Parcel parcel) {
            return new WalkRouteResult(parcel);
        }
    };
    private List<WalkPath> a = new ArrayList();
    private RouteSearch.WalkRouteQuery b;

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WalkPath> getPaths() {
        return this.a;
    }

    public void setPaths(List<WalkPath> list) {
        this.a = list;
    }

    public RouteSearch.WalkRouteQuery getWalkQuery() {
        return this.b;
    }

    public void setWalkQuery(RouteSearch.WalkRouteQuery walkRouteQuery) {
        this.b = walkRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.a);
        parcel.writeParcelable(this.b, i);
    }

    public WalkRouteResult(Parcel parcel) {
        super(parcel);
        this.a = parcel.createTypedArrayList(WalkPath.CREATOR);
        this.b = (RouteSearch.WalkRouteQuery) parcel.readParcelable(RouteSearch.WalkRouteQuery.class.getClassLoader());
    }

    public WalkRouteResult() {
    }
}
