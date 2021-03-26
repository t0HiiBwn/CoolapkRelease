package com.qq.e.ads.hybrid;

import android.os.Parcel;
import android.os.Parcelable;

public class HybridADSetting implements Parcelable {
    public static final Parcelable.Creator<HybridADSetting> CREATOR = new Parcelable.Creator<HybridADSetting>() {
        /* class com.qq.e.ads.hybrid.HybridADSetting.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final HybridADSetting createFromParcel(Parcel parcel) {
            return new HybridADSetting(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final HybridADSetting[] newArray(int i) {
            return new HybridADSetting[i];
        }
    };
    public static final int TYPE_REWARD_VIDEO = 1;
    private int a = 1;
    private int b = 44;
    private int c = -1;
    private int d = -14013133;
    private int e = 16;
    private String f;
    private String g;
    private String h;
    private int i = -1776153;
    private int j = 16;

    public HybridADSetting() {
    }

    protected HybridADSetting(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
    }

    public HybridADSetting backButtonImage(String str) {
        this.g = str;
        return this;
    }

    public HybridADSetting backSeparatorLength(int i2) {
        this.j = i2;
        return this;
    }

    public HybridADSetting closeButtonImage(String str) {
        this.h = str;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBackButtonImage() {
        return this.g;
    }

    public int getBackSeparatorLength() {
        return this.j;
    }

    public String getCloseButtonImage() {
        return this.h;
    }

    public int getSeparatorColor() {
        return this.i;
    }

    public String getTitle() {
        return this.f;
    }

    public int getTitleBarColor() {
        return this.c;
    }

    public int getTitleBarHeight() {
        return this.b;
    }

    public int getTitleColor() {
        return this.d;
    }

    public int getTitleSize() {
        return this.e;
    }

    public int getType() {
        return this.a;
    }

    public HybridADSetting separatorColor(int i2) {
        this.i = i2;
        return this;
    }

    public HybridADSetting title(String str) {
        this.f = str;
        return this;
    }

    public HybridADSetting titleBarColor(int i2) {
        this.c = i2;
        return this;
    }

    public HybridADSetting titleBarHeight(int i2) {
        this.b = i2;
        return this;
    }

    public HybridADSetting titleColor(int i2) {
        this.d = i2;
        return this;
    }

    public HybridADSetting titleSize(int i2) {
        this.e = i2;
        return this;
    }

    public HybridADSetting type(int i2) {
        this.a = i2;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
    }
}
