package com.ss.android.downloadlib.a.a;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;

/* compiled from: MFIntent */
public class d extends Intent {
    public void a(Parcel parcel) {
    }

    public d(String str, Uri uri) {
        super(str, uri);
    }

    @Override // android.content.Intent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        a(parcel);
        super.writeToParcel(parcel, i);
    }
}
