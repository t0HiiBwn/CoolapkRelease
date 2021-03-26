package com.huawei.hms.common.webserverpic;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: WebServerPicCreator */
public final class a implements Parcelable.Creator<WebServerPic> {
    /* renamed from: a */
    public WebServerPic createFromParcel(Parcel parcel) {
        return new WebServerPic((Uri) parcel.readParcelable(Uri.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }

    /* renamed from: a */
    public WebServerPic[] newArray(int i) {
        return new WebServerPic[i];
    }
}
