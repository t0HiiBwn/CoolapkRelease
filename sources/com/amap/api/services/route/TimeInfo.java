package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class TimeInfo implements Parcelable {
    public static final Parcelable.Creator<TimeInfo> CREATOR = new Parcelable.Creator<TimeInfo>() {
        /* class com.amap.api.services.route.TimeInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TimeInfo[] newArray(int i) {
            return null;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TimeInfo createFromParcel(Parcel parcel) {
            return new TimeInfo(parcel);
        }
    };
    private long a;
    private List<TimeInfosElement> b = new ArrayList();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getStartTime() {
        return this.a;
    }

    public void setStartTime(long j) {
        this.a = j;
    }

    public List<TimeInfosElement> getElements() {
        return this.b;
    }

    public void setElements(List<TimeInfosElement> list) {
        this.b = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeTypedList(this.b);
    }

    public TimeInfo(Parcel parcel) {
        this.a = (long) parcel.readInt();
        this.b = parcel.createTypedArrayList(TimeInfosElement.CREATOR);
    }

    public TimeInfo() {
    }
}
