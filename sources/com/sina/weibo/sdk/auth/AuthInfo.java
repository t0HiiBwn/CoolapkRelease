package com.sina.weibo.sdk.auth;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.utils.Utility;
import java.io.Serializable;

public class AuthInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<AuthInfo> CREATOR = new Parcelable.Creator<AuthInfo>() {
        /* class com.sina.weibo.sdk.auth.AuthInfo.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AuthInfo createFromParcel(Parcel parcel) {
            return new AuthInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AuthInfo[] newArray(int i) {
            return new AuthInfo[i];
        }
    };
    private String mAppKey = "";
    private String mKeyHash = "";
    private String mPackageName = "";
    private String mRedirectUrl = "";
    private String mScope = "";

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AuthInfo(Context context, String str, String str2, String str3) {
        this.mAppKey = str;
        this.mRedirectUrl = str2;
        this.mScope = str3;
        String packageName = context.getPackageName();
        this.mPackageName = packageName;
        this.mKeyHash = Utility.getSign(context, packageName);
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getRedirectUrl() {
        return this.mRedirectUrl;
    }

    public String getScope() {
        return this.mScope;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public String getKeyHash() {
        return this.mKeyHash;
    }

    public Bundle getAuthBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", this.mAppKey);
        bundle.putString("redirectUri", this.mRedirectUrl);
        bundle.putString("scope", this.mScope);
        bundle.putString("packagename", this.mPackageName);
        bundle.putString("key_hash", this.mKeyHash);
        return bundle;
    }

    public static AuthInfo parseBundleData(Context context, Bundle bundle) {
        return new AuthInfo(context, bundle.getString("appKey"), bundle.getString("redirectUri"), bundle.getString("scope"));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAppKey);
        parcel.writeString(this.mRedirectUrl);
        parcel.writeString(this.mScope);
        parcel.writeString(this.mPackageName);
        parcel.writeString(this.mKeyHash);
    }

    protected AuthInfo(Parcel parcel) {
        this.mAppKey = parcel.readString();
        this.mRedirectUrl = parcel.readString();
        this.mScope = parcel.readString();
        this.mPackageName = parcel.readString();
        this.mKeyHash = parcel.readString();
    }
}
