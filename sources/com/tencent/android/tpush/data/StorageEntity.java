package com.tencent.android.tpush.data;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ProGuard */
public class StorageEntity implements Parcelable {
    public static final Parcelable.Creator<StorageEntity> CREATOR = new Parcelable.Creator<StorageEntity>() {
        /* class com.tencent.android.tpush.data.StorageEntity.AnonymousClass1 */

        /* renamed from: a */
        public StorageEntity createFromParcel(Parcel parcel) {
            return new StorageEntity(parcel);
        }

        /* renamed from: a */
        public StorageEntity[] newArray(int i) {
            return new StorageEntity[i];
        }
    };
    public String a = "";
    public int b = -1;
    public boolean c;
    public String d;
    public int e;
    public float f;
    public long g;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public StorageEntity() {
    }

    public StorageEntity(Parcel parcel) {
        a(parcel);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeByte(this.c ? (byte) 1 : 0);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeFloat(this.f);
        parcel.writeLong(this.g);
    }

    private void a(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readInt();
        boolean z = true;
        if (parcel.readByte() != 1) {
            z = false;
        }
        this.c = z;
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readFloat();
        this.g = parcel.readLong();
    }

    @Override // java.lang.Object
    public String toString() {
        return "StorageEntity[key:" + this.a + ",type:" + this.b + ",strValue:" + this.d + ",boolValue:" + this.c + ",intValue" + this.e + ",floatValue:" + this.f + ",longValue:" + this.g + "]";
    }
}
