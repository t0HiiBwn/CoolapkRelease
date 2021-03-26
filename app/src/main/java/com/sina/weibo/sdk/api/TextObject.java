package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.utils.LogUtil;

public class TextObject extends BaseMediaObject {
    public static final Parcelable.Creator<TextObject> CREATOR = new Parcelable.Creator<TextObject>() {
        /* class com.sina.weibo.sdk.api.TextObject.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public TextObject createFromParcel(Parcel parcel) {
            return new TextObject(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TextObject[] newArray(int i) {
            return new TextObject[i];
        }
    };
    public String text;

    @Override // com.sina.weibo.sdk.api.BaseMediaObject, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public int getObjType() {
        return 1;
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    protected BaseMediaObject toExtraMediaObject(String str) {
        return this;
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    protected String toExtraMediaString() {
        return "";
    }

    public TextObject() {
    }

    public TextObject(Parcel parcel) {
        this.text = parcel.readString();
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.text);
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public boolean checkArgs() {
        String str = this.text;
        if (str != null && str.length() != 0 && this.text.length() <= 1024) {
            return true;
        }
        LogUtil.e("Weibo.TextObject", "checkArgs fail, text is invalid");
        return false;
    }
}
