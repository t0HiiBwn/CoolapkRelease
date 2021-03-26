package com.huawei.hms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.util.a;
import java.util.ArrayList;
import java.util.Iterator;

public final class SafeParcelableSerializer {
    public static <S extends SafeParcelable> byte[] serializeToBytes(S s) {
        Parcel obtain = Parcel.obtain();
        s.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public static <S extends SafeParcelable> S deserializeFromBytes(byte[] bArr, Parcelable.Creator<S> creator) {
        Preconditions.checkNotNull(creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        S createFromParcel = creator.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    public static <S extends SafeParcelable> void serializeIterableToBundle(Iterable<S> iterable, Bundle bundle, String str) {
        ArrayList arrayList = new ArrayList();
        for (S s : iterable) {
            arrayList.add(serializeToBytes(s));
        }
        bundle.putSerializable(str, arrayList);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.util.ArrayList<S extends com.huawei.hms.common.internal.safeparcel.SafeParcelable> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <S extends SafeParcelable> ArrayList<S> deserializeIterableFromBundle(Bundle bundle, String str, Parcelable.Creator<S> creator) {
        ArrayList arrayList = (ArrayList) bundle.getSerializable(str);
        if (arrayList == null) {
            return null;
        }
        ArrayList<S> arrayList2 = (ArrayList<S>) new ArrayList(arrayList.size());
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(deserializeFromBytes((byte[]) it2.next(), creator));
        }
        return arrayList2;
    }

    public static <S extends SafeParcelable> String serializeToString(S s) {
        return a.a(serializeToBytes(s));
    }

    public static <S extends SafeParcelable> S deserializeFromString(String str, Parcelable.Creator<S> creator) {
        return (S) deserializeFromBytes(a.a(str), creator);
    }

    public static <S extends SafeParcelable> void serializeToIntentExtra(S s, Intent intent, String str) {
        intent.putExtra(str, serializeToBytes(s));
    }

    public static <S extends SafeParcelable> S deserializeFromIntentExtra(Intent intent, String str, Parcelable.Creator<S> creator) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            return null;
        }
        return (S) deserializeFromBytes(byteArrayExtra, creator);
    }

    public static <S extends SafeParcelable> void serializeIterableToIntentExtra(Iterable<S> iterable, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        for (S s : iterable) {
            arrayList.add(serializeToBytes(s));
        }
        intent.putExtra(str, arrayList);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.util.ArrayList<S extends com.huawei.hms.common.internal.safeparcel.SafeParcelable> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <S extends SafeParcelable> ArrayList<S> deserializeIterableFromIntentExtra(Intent intent, String str, Parcelable.Creator<S> creator) {
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra(str);
        if (arrayList == null) {
            return null;
        }
        ArrayList<S> arrayList2 = (ArrayList<S>) new ArrayList(arrayList.size());
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(deserializeFromBytes((byte[]) it2.next(), creator));
        }
        return arrayList2;
    }
}
