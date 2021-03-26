package com.ss.android.downloadlib.a.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.appdownloader.f.b;
import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: AutoParcelable */
public abstract class a implements Parcelable {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private static int a(Parcel parcel, int i) {
        parcel.writeInt(i | -65536);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void a(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(i | -65536);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt(i | (i2 << 16));
    }

    private static void b(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    private static void a(a aVar, Parcel parcel, Class cls) {
        TypeVariable<Class<?>>[] typeParameters = aVar.getClass().getTypeParameters();
        int a = a(parcel, 0);
        ArrayList arrayList = new ArrayList();
        if (typeParameters.length > 0) {
            JSONObject i = k.i();
            arrayList.add(b.a(i.optString("aw"), i.optString("s")));
        }
        parcel.writeStringArray((String[]) arrayList.toArray(new String[typeParameters.length]));
        b(parcel, a);
    }

    public static void a(Parcel parcel, Field field, int i, String str, int i2, boolean z) {
        int a = a(parcel, i);
        parcel.writeString(str);
        b(parcel, a);
    }

    public static void a(Parcel parcel, Field field, int i, Integer num, int i2, boolean z) {
        if (num != null) {
            a(parcel, i, 4);
            parcel.writeInt(num.intValue());
        }
    }

    public static void a(Parcel parcel, Field field, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int a = a(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            b(parcel, a);
        } else if (z) {
            a(parcel, i, 0);
        }
    }

    public static void a(Parcel parcel, Field field, int i, Object obj, int i2, boolean z) {
        if (field.getType() == String.class) {
            a(parcel, field, i, (String) obj, i2, z);
        } else if (field.getType() == Integer.class || field.getType() == Integer.TYPE) {
            a(parcel, field, i, (Integer) obj, i2, z);
        } else if (Parcelable.class.isAssignableFrom(field.getType())) {
            a(parcel, field, i, (Parcelable) obj, i2, z);
        }
    }

    private static void a(a aVar, Parcel parcel, Field field, int i) throws IllegalAccessException {
        int b = ((h) field.getAnnotation(h.class)).b();
        boolean a = ((h) field.getAnnotation(h.class)).a();
        boolean isAccessible = field.isAccessible();
        field.setAccessible(true);
        a(parcel, field, b, field.get(aVar), i, a);
        field.setAccessible(isAccessible);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Class<?> cls = getClass();
        int a = a(parcel, 20293);
        a(this, parcel, cls);
        while (cls != null) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (field.isAnnotationPresent(h.class)) {
                    try {
                        a(this, parcel, field, i);
                    } catch (Throwable unused) {
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        b(parcel, a);
    }
}
