package com.ali.auth.third.ui.iv;

import android.os.Parcel;
import android.os.Parcelable;

public class IVParam implements Parcelable {
    public static final Parcelable.Creator<IVParam> CREATOR = new Parcelable.Creator<IVParam>() {
        /* class com.ali.auth.third.ui.iv.IVParam.AnonymousClass1 */

        /* renamed from: a */
        public IVParam createFromParcel(Parcel parcel) {
            return new IVParam(parcel);
        }

        /* renamed from: a */
        public IVParam[] newArray(int i) {
            return new IVParam[i];
        }
    };
    public String checkCode;
    public String ivToken;
    public String locale;
    public String mobileNum;
    public String ncSessionId;
    public String ncSignature;
    public String ncToken;
    public String sessionId;
    public String validatorTag;

    public IVParam() {
    }

    protected IVParam(Parcel parcel) {
        this.checkCode = parcel.readString();
        this.ivToken = parcel.readString();
        this.validatorTag = parcel.readString();
        this.mobileNum = parcel.readString();
        this.sessionId = parcel.readString();
        this.ncSessionId = parcel.readString();
        this.ncToken = parcel.readString();
        this.ncSignature = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.checkCode);
        parcel.writeString(this.ivToken);
        parcel.writeString(this.validatorTag);
        parcel.writeString(this.mobileNum);
        parcel.writeString(this.sessionId);
        parcel.writeString(this.ncSessionId);
        parcel.writeString(this.ncToken);
        parcel.writeString(this.ncSignature);
    }
}
