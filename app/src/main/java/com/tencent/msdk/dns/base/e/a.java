package com.tencent.msdk.dns.base.e;

import android.text.TextUtils;
import com.tencent.msdk.dns.base.log.b;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

/* compiled from: CommonUtils */
public final class a {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            b.b("Close %s", closeable);
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean a(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static boolean a(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static String a(Object obj) {
        return obj == null ? "null" : obj.toString();
    }

    public static <E> String b(Collection<E> collection) {
        StringBuilder sb = new StringBuilder("[");
        if (!a((Collection<?>) collection)) {
            for (E e : collection) {
                sb.append(a((Object) e));
                sb.append(", ");
            }
            sb.setLength(sb.length() - 2);
        }
        sb.append(']');
        return sb.toString();
    }

    public static String a(String[] strArr, String str) {
        if (a((Object[]) strArr) || TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArr) {
            sb.append(str2);
            sb.append(str);
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }
}
