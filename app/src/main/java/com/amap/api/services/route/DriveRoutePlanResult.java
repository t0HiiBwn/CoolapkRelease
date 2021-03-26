package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

public class DriveRoutePlanResult extends RoutePlanResult implements Parcelable {
    public static final Parcelable.Creator<DriveRoutePlanResult> CREATOR = new Parcelable.Creator<DriveRoutePlanResult>() {
        /* class com.amap.api.services.route.DriveRoutePlanResult.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DriveRoutePlanResult[] newArray(int i) {
            return new DriveRoutePlanResult[i];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRoutePlanResult createFromParcel(Parcel parcel) {
            return new DriveRoutePlanResult(parcel);
        }
    };
    private List<DrivePlanPath> a = new ArrayList();
    private List<TimeInfo> b = new ArrayList();
    private RouteSearch.DrivePlanQuery c;

    @Override // com.amap.api.services.route.RoutePlanResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<DrivePlanPath> getPaths() {
        return this.a;
    }

    public void setPaths(List<DrivePlanPath> list) {
        this.a = list;
    }

    public List<TimeInfo> getTimeInfos() {
        return this.b;
    }

    public void setTimeInfos(List<TimeInfo> list) {
        this.b = list;
    }

    public void setDrivePlanQuery(RouteSearch.DrivePlanQuery drivePlanQuery) {
        this.c = drivePlanQuery;
        RouteSearch.FromAndTo fromAndTo = drivePlanQuery.getFromAndTo();
        if (fromAndTo != null) {
            setStartPos(fromAndTo.getFrom());
            setTargetPos(fromAndTo.getTo());
        }
    }

    @Override // com.amap.api.services.route.RoutePlanResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.a);
        parcel.writeTypedList(this.b);
        parcel.writeParcelable(this.c, i);
    }

    public DriveRoutePlanResult(Parcel parcel) {
        super(parcel);
        this.a = parcel.createTypedArrayList(DrivePlanPath.CREATOR);
        this.b = parcel.createTypedArrayList(TimeInfo.CREATOR);
        this.c = (RouteSearch.DrivePlanQuery) parcel.readParcelable(RouteSearch.DrivePlanQuery.class.getClassLoader());
    }

    public DriveRoutePlanResult() {
    }
}
