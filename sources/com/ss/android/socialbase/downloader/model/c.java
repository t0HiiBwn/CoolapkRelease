package com.ss.android.socialbase.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* compiled from: HttpHeader */
public class c implements Parcelable, Comparable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() {
        /* class com.ss.android.socialbase.downloader.model.c.AnonymousClass1 */

        /* renamed from: a */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        /* renamed from: a */
        public c[] newArray(int i) {
            return new c[i];
        }
    };
    private final String a;
    private final String b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public c(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    protected c(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (!(obj instanceof c)) {
            return 1;
        }
        c cVar = (c) obj;
        if (TextUtils.equals(this.a, cVar.a())) {
            return 0;
        }
        String str = this.a;
        if (str == null) {
            return -1;
        }
        int compareTo = str.compareTo(cVar.a());
        if (compareTo > 0) {
            return 1;
        }
        if (compareTo < 0) {
            return -1;
        }
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (!TextUtils.equals(this.a, cVar.a) || !TextUtils.equals(this.b, cVar.b)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }
}
