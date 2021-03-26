package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.location.DPoint;
import java.util.List;

public class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = new Parcelable.Creator<DistrictItem>() {
        /* class com.amap.api.fence.DistrictItem.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictItem createFromParcel(Parcel parcel) {
            return new DistrictItem(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DistrictItem[] newArray(int i) {
            return new DistrictItem[i];
        }
    };
    private String a = "";
    private String b = null;
    private String c = null;
    private List<DPoint> d = null;

    public DistrictItem() {
    }

    protected DistrictItem(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.createTypedArrayList(DPoint.CREATOR);
    }

    public static Parcelable.Creator<DistrictItem> getCreator() {
        return CREATOR;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.c;
    }

    public String getCitycode() {
        return this.b;
    }

    public String getDistrictName() {
        return this.a;
    }

    public List<DPoint> getPolyline() {
        return this.d;
    }

    public void setAdcode(String str) {
        this.c = str;
    }

    public void setCitycode(String str) {
        this.b = str;
    }

    public void setDistrictName(String str) {
        this.a = str;
    }

    public void setPolyline(List<DPoint> list) {
        this.d = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeTypedList(this.d);
    }
}
