package com.ss.android.downloadlib.a.c;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: AidlMsg */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() {
        /* class com.ss.android.downloadlib.a.c.b.AnonymousClass1 */

        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* renamed from: a */
        public b[] newArray(int i) {
            return new b[i];
        }
    };
    public int a;
    public int b;
    public String c = "";
    public int d;
    public String e = "";
    public String f = "";

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        return "";
    }

    public b() {
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.d);
    }

    protected b(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.d = parcel.readInt();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (this.a == bVar.a && this.b == bVar.b) {
                String str = this.c;
                if (str != null) {
                    return str.equals(bVar.c);
                }
                if (bVar.c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = ((this.a * 31) + this.b) * 31;
        String str = this.c;
        return i + (str != null ? str.hashCode() : 0);
    }
}
