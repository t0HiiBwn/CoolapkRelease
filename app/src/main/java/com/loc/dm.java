package com.loc;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: AMapLocationStaticsEntity */
public final class dm implements Parcelable {
    public static final Parcelable.Creator<dm> CREATOR = new Parcelable.Creator<dm>() {
        /* class com.loc.dm.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ dm createFromParcel(Parcel parcel) {
            dm dmVar = new dm();
            dmVar.c(parcel.readString());
            dmVar.d(parcel.readString());
            dmVar.e(parcel.readString());
            dmVar.f(parcel.readString());
            dmVar.b(parcel.readString());
            dmVar.c(parcel.readLong());
            dmVar.d(parcel.readLong());
            dmVar.a(parcel.readLong());
            dmVar.b(parcel.readLong());
            dmVar.a(parcel.readString());
            return dmVar;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ dm[] newArray(int i) {
            return new dm[i];
        }
    };
    private long a = 0;
    private long b = 0;
    private long c = 0;
    private long d = 0;
    private String e;
    private String f;
    private String g = "first";
    private String h = "";
    private String i = "";
    private String j = null;

    public final long a() {
        long j2 = this.d;
        long j3 = this.c;
        if (j2 - j3 <= 0) {
            return 0;
        }
        return j2 - j3;
    }

    public final void a(long j2) {
        this.c = j2;
    }

    public final void a(String str) {
        this.i = str;
    }

    public final String b() {
        return this.i;
    }

    public final void b(long j2) {
        this.d = j2;
    }

    public final void b(String str) {
        this.j = str;
    }

    public final String c() {
        return this.j;
    }

    public final void c(long j2) {
        this.a = j2;
    }

    public final void c(String str) {
        this.e = str;
    }

    public final String d() {
        return this.e;
    }

    public final void d(long j2) {
        this.b = j2;
    }

    public final void d(String str) {
        this.f = str;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f;
    }

    public final void e(String str) {
        this.g = str;
    }

    public final String f() {
        return this.g;
    }

    public final void f(String str) {
        this.h = str;
    }

    public final String g() {
        return this.h;
    }

    public final long h() {
        long j2 = this.b;
        long j3 = this.a;
        if (j2 <= j3) {
            return 0;
        }
        return j2 - j3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        try {
            parcel.writeString(this.e);
            parcel.writeString(this.f);
            parcel.writeString(this.g);
            parcel.writeString(this.h);
            parcel.writeString(this.j);
            parcel.writeLong(this.a);
            parcel.writeLong(this.b);
            parcel.writeLong(this.c);
            parcel.writeLong(this.d);
            parcel.writeString(this.i);
        } catch (Throwable unused) {
        }
    }
}
