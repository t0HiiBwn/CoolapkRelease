package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public class CloudItemDetail extends CloudItem implements Parcelable {
    public static final Parcelable.Creator<CloudItemDetail> CREATOR = new Parcelable.Creator<CloudItemDetail>() {
        /* class com.amap.api.services.cloud.CloudItemDetail.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CloudItemDetail[] newArray(int i) {
            return new CloudItemDetail[i];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CloudItemDetail createFromParcel(Parcel parcel) {
            return new CloudItemDetail(parcel);
        }
    };

    @Override // com.amap.api.services.cloud.CloudItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CloudItemDetail(String str, LatLonPoint latLonPoint, String str2, String str3) {
        super(str, latLonPoint, str2, str3);
    }

    protected CloudItemDetail(Parcel parcel) {
        super(parcel);
    }

    @Override // com.amap.api.services.cloud.CloudItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
