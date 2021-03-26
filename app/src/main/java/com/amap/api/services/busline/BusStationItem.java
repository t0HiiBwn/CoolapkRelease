package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

public class BusStationItem implements Parcelable {
    public static final Parcelable.Creator<BusStationItem> CREATOR = new Parcelable.Creator<BusStationItem>() {
        /* class com.amap.api.services.busline.BusStationItem.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusStationItem[] newArray(int i) {
            return null;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusStationItem createFromParcel(Parcel parcel) {
            return new BusStationItem(parcel, (byte) 0);
        }
    };
    private String a;
    private String b;
    private LatLonPoint c;
    private String d;
    private String e;
    private List<BusLineItem> f;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ BusStationItem(Parcel parcel, byte b2) {
        this(parcel);
    }

    public BusStationItem() {
        this.f = new ArrayList();
    }

    public String getBusStationId() {
        return this.a;
    }

    public void setBusStationId(String str) {
        this.a = str;
    }

    public String getBusStationName() {
        return this.b;
    }

    public void setBusStationName(String str) {
        this.b = str;
    }

    public LatLonPoint getLatLonPoint() {
        return this.c;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.c = latLonPoint;
    }

    public String getCityCode() {
        return this.d;
    }

    public void setCityCode(String str) {
        this.d = str;
    }

    public String getAdCode() {
        return this.e;
    }

    public void setAdCode(String str) {
        this.e = str;
    }

    public List<BusLineItem> getBusLineItems() {
        return this.f;
    }

    public void setBusLineItems(List<BusLineItem> list) {
        this.f = list;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BusStationItem busStationItem = (BusStationItem) obj;
        String str = this.a;
        if (str == null) {
            if (busStationItem.a != null) {
                return false;
            }
        } else if (!str.equals(busStationItem.a)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i;
        String str = this.a;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        return i + 31;
    }

    @Override // java.lang.Object
    public String toString() {
        return "BusStationName: " + this.b + " LatLonPoint: " + this.c.toString() + " BusLines: " + a(this.f) + " CityCode: " + this.d + " AdCode: " + this.e;
    }

    private static String a(List<BusLineItem> list) {
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                stringBuffer.append(list.get(i).getBusLineName());
                if (i < list.size() - 1) {
                    stringBuffer.append("|");
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.a);
        parcel.writeValue(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeList(this.f);
    }

    private BusStationItem(Parcel parcel) {
        this.f = new ArrayList();
        this.b = parcel.readString();
        this.a = parcel.readString();
        this.c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readArrayList(BusLineItem.class.getClassLoader());
    }
}
