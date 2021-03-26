package com.ss.android.socialbase.downloader.exception;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.socialbase.downloader.i.e;

public class BaseException extends Exception implements Parcelable {
    public static final Parcelable.Creator<BaseException> CREATOR = new Parcelable.Creator<BaseException>() {
        /* class com.ss.android.socialbase.downloader.exception.BaseException.AnonymousClass1 */

        /* renamed from: a */
        public BaseException createFromParcel(Parcel parcel) {
            return new BaseException(parcel);
        }

        /* renamed from: a */
        public BaseException[] newArray(int i) {
            return new BaseException[i];
        }
    };
    private static final String TAG = "[d-ex]:";
    private int errorCode;
    private String errorMsg;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BaseException() {
    }

    public BaseException(int i, String str) {
        super("[d-ex]:" + str);
        this.errorMsg = "[d-ex]:" + str;
        this.errorCode = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public BaseException(int i, Throwable th) {
        this(i, e.i(th));
    }

    protected BaseException(Parcel parcel) {
        readFromParcel(parcel);
    }

    public void readFromParcel(Parcel parcel) {
        this.errorCode = parcel.readInt();
        this.errorMsg = parcel.readString();
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMsg;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.errorCode);
        parcel.writeString(this.errorMsg);
    }

    @Override // java.lang.Throwable, java.lang.Object
    public String toString() {
        return "BaseException{errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + "'}";
    }
}
