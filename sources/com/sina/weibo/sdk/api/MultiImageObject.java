package com.sina.weibo.sdk.api;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public class MultiImageObject extends BaseMediaObject {
    public static final Parcelable.Creator<MultiImageObject> CREATOR = new Parcelable.Creator<MultiImageObject>() {
        /* class com.sina.weibo.sdk.api.MultiImageObject.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public MultiImageObject createFromParcel(Parcel parcel) {
            return new MultiImageObject(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public MultiImageObject[] newArray(int i) {
            return new MultiImageObject[i];
        }
    };
    public ArrayList<Uri> imageList;

    @Override // com.sina.weibo.sdk.api.BaseMediaObject, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public int getObjType() {
        return 0;
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    protected BaseMediaObject toExtraMediaObject(String str) {
        return null;
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    protected String toExtraMediaString() {
        return null;
    }

    public void setImageList(ArrayList<Uri> arrayList) {
        this.imageList = arrayList;
    }

    public ArrayList<Uri> getImageList() {
        return this.imageList;
    }

    public MultiImageObject() {
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.imageList);
    }

    protected MultiImageObject(Parcel parcel) {
        super(parcel);
        this.imageList = parcel.createTypedArrayList(Uri.CREATOR);
    }
}
