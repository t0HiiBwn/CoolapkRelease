package com.sina.weibo.sdk.api;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class VideoSourceObject extends BaseMediaObject {
    public static final Parcelable.Creator<VideoSourceObject> CREATOR = new Parcelable.Creator<VideoSourceObject>() {
        /* class com.sina.weibo.sdk.api.VideoSourceObject.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public VideoSourceObject createFromParcel(Parcel parcel) {
            return new VideoSourceObject(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public VideoSourceObject[] newArray(int i) {
            return new VideoSourceObject[i];
        }
    };
    public Uri coverPath;
    public long during;
    public Uri videoPath;

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

    public VideoSourceObject() {
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.coverPath, i);
        parcel.writeParcelable(this.videoPath, i);
        parcel.writeLong(this.during);
    }

    protected VideoSourceObject(Parcel parcel) {
        super(parcel);
        this.coverPath = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.videoPath = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.during = parcel.readLong();
    }
}
