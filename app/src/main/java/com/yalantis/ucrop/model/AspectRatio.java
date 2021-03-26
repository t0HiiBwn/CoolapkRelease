package com.yalantis.ucrop.model;

import android.os.Parcel;
import android.os.Parcelable;

public class AspectRatio implements Parcelable {
    public static final Parcelable.Creator<AspectRatio> CREATOR = new Parcelable.Creator<AspectRatio>() {
        /* class com.yalantis.ucrop.model.AspectRatio.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AspectRatio createFromParcel(Parcel parcel) {
            return new AspectRatio(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AspectRatio[] newArray(int i) {
            return new AspectRatio[i];
        }
    };
    private final String mAspectRatioTitle;
    private final float mAspectRatioX;
    private final float mAspectRatioY;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AspectRatio(String str, float f, float f2) {
        this.mAspectRatioTitle = str;
        this.mAspectRatioX = f;
        this.mAspectRatioY = f2;
    }

    protected AspectRatio(Parcel parcel) {
        this.mAspectRatioTitle = parcel.readString();
        this.mAspectRatioX = parcel.readFloat();
        this.mAspectRatioY = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAspectRatioTitle);
        parcel.writeFloat(this.mAspectRatioX);
        parcel.writeFloat(this.mAspectRatioY);
    }

    public String getAspectRatioTitle() {
        return this.mAspectRatioTitle;
    }

    public float getAspectRatioX() {
        return this.mAspectRatioX;
    }

    public float getAspectRatioY() {
        return this.mAspectRatioY;
    }
}
