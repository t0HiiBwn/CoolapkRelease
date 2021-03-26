package com.blankj.utilcode.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ArrayUtils {
    public static final int INDEX_NOT_FOUND = -1;

    public interface Closure<E> {
        void execute(int i, E e);
    }

    private ArrayUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static <T> T[] newArray(T... tArr) {
        Objects.requireNonNull(tArr, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.newArray() marked by @androidx.annotation.NonNull");
        return tArr;
    }

    public static long[] newLongArray(long... jArr) {
        Objects.requireNonNull(jArr, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.newLongArray() marked by @androidx.annotation.NonNull");
        return jArr;
    }

    public static int[] newIntArray(int... iArr) {
        Objects.requireNonNull(iArr, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.newIntArray() marked by @androidx.annotation.NonNull");
        return iArr;
    }

    public static short[] newShortArray(short... sArr) {
        Objects.requireNonNull(sArr, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.newShortArray() marked by @androidx.annotation.NonNull");
        return sArr;
    }

    public static char[] newCharArray(char... cArr) {
        Objects.requireNonNull(cArr, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.newCharArray() marked by @androidx.annotation.NonNull");
        return cArr;
    }

    public static byte[] newByteArray(byte... bArr) {
        Objects.requireNonNull(bArr, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.newByteArray() marked by @androidx.annotation.NonNull");
        return bArr;
    }

    public static double[] newDoubleArray(double... dArr) {
        Objects.requireNonNull(dArr, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.newDoubleArray() marked by @androidx.annotation.NonNull");
        return dArr;
    }

    public static float[] newFloatArray(float... fArr) {
        Objects.requireNonNull(fArr, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.newFloatArray() marked by @androidx.annotation.NonNull");
        return fArr;
    }

    public static boolean[] newBooleanArray(boolean... zArr) {
        Objects.requireNonNull(zArr, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.newBooleanArray() marked by @androidx.annotation.NonNull");
        return zArr;
    }

    public static boolean isEmpty(Object obj) {
        return getLength(obj) == 0;
    }

    public static int getLength(Object obj) {
        if (obj == null) {
            return 0;
        }
        return Array.getLength(obj);
    }

    public static boolean isSameLength(Object obj, Object obj2) {
        return getLength(obj) == getLength(obj2);
    }

    public static Object get(Object obj, int i) {
        return get(obj, i, null);
    }

    public static Object get(Object obj, int i, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        try {
            return Array.get(obj, i);
        } catch (Exception unused) {
            return obj2;
        }
    }

    public static void set(Object obj, int i, Object obj2) {
        if (obj != null) {
            Array.set(obj, i, obj2);
        }
    }

    public static boolean equals(Object[] objArr, Object[] objArr2) {
        return Arrays.deepEquals(objArr, objArr2);
    }

    public static boolean equals(boolean[] zArr, boolean[] zArr2) {
        return Arrays.equals(zArr, zArr2);
    }

    public static boolean equals(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    public static boolean equals(char[] cArr, char[] cArr2) {
        return Arrays.equals(cArr, cArr2);
    }

    public static boolean equals(double[] dArr, double[] dArr2) {
        return Arrays.equals(dArr, dArr2);
    }

    public static boolean equals(float[] fArr, float[] fArr2) {
        return Arrays.equals(fArr, fArr2);
    }

    public static boolean equals(int[] iArr, int[] iArr2) {
        return Arrays.equals(iArr, iArr2);
    }

    public static boolean equals(short[] sArr, short[] sArr2) {
        return Arrays.equals(sArr, sArr2);
    }

    public static <T> void reverse(T[] tArr) {
        if (tArr != null) {
            int length = tArr.length - 1;
            for (int i = 0; length > i; i++) {
                T t = tArr[length];
                tArr[length] = tArr[i];
                tArr[i] = t;
                length--;
            }
        }
    }

    public static void reverse(long[] jArr) {
        if (jArr != null) {
            int length = jArr.length - 1;
            for (int i = 0; length > i; i++) {
                long j = jArr[length];
                jArr[length] = jArr[i];
                jArr[i] = j;
                length--;
            }
        }
    }

    public static void reverse(int[] iArr) {
        if (iArr != null) {
            int length = iArr.length - 1;
            for (int i = 0; length > i; i++) {
                int i2 = iArr[length];
                iArr[length] = iArr[i];
                iArr[i] = i2;
                length--;
            }
        }
    }

    public static void reverse(short[] sArr) {
        if (sArr != null) {
            int length = sArr.length - 1;
            for (int i = 0; length > i; i++) {
                short s = sArr[length];
                sArr[length] = sArr[i];
                sArr[i] = s;
                length--;
            }
        }
    }

    public static void reverse(char[] cArr) {
        if (cArr != null) {
            int length = cArr.length - 1;
            for (int i = 0; length > i; i++) {
                char c = cArr[length];
                cArr[length] = cArr[i];
                cArr[i] = c;
                length--;
            }
        }
    }

    public static void reverse(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length - 1;
            for (int i = 0; length > i; i++) {
                byte b = bArr[length];
                bArr[length] = bArr[i];
                bArr[i] = b;
                length--;
            }
        }
    }

    public static void reverse(double[] dArr) {
        if (dArr != null) {
            int length = dArr.length - 1;
            for (int i = 0; length > i; i++) {
                double d = dArr[length];
                dArr[length] = dArr[i];
                dArr[i] = d;
                length--;
            }
        }
    }

    public static void reverse(float[] fArr) {
        if (fArr != null) {
            int length = fArr.length - 1;
            for (int i = 0; length > i; i++) {
                float f = fArr[length];
                fArr[length] = fArr[i];
                fArr[i] = f;
                length--;
            }
        }
    }

    public static void reverse(boolean[] zArr) {
        if (zArr != null) {
            int length = zArr.length - 1;
            for (int i = 0; length > i; i++) {
                boolean z = zArr[length];
                zArr[length] = zArr[i];
                zArr[i] = z;
                length--;
            }
        }
    }

    public static <T> T[] copy(T[] tArr) {
        if (tArr == null) {
            return null;
        }
        return (T[]) subArray(tArr, 0, tArr.length);
    }

    public static long[] copy(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        return subArray(jArr, 0, jArr.length);
    }

    public static int[] copy(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        return subArray(iArr, 0, iArr.length);
    }

    public static short[] copy(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        return subArray(sArr, 0, sArr.length);
    }

    public static char[] copy(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return subArray(cArr, 0, cArr.length);
    }

    public static byte[] copy(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return subArray(bArr, 0, bArr.length);
    }

    public static double[] copy(double[] dArr) {
        if (dArr == null) {
            return null;
        }
        return subArray(dArr, 0, dArr.length);
    }

    public static float[] copy(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        return subArray(fArr, 0, fArr.length);
    }

    public static boolean[] copy(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        return subArray(zArr, 0, zArr.length);
    }

    private static Object realCopy(Object obj) {
        if (obj == null) {
            return null;
        }
        return realSubArray(obj, 0, getLength(obj));
    }

    public static <T> T[] subArray(T[] tArr, int i, int i2) {
        return (T[]) ((Object[]) realSubArray(tArr, i, i2));
    }

    public static long[] subArray(long[] jArr, int i, int i2) {
        return (long[]) realSubArray(jArr, i, i2);
    }

    public static int[] subArray(int[] iArr, int i, int i2) {
        return (int[]) realSubArray(iArr, i, i2);
    }

    public static short[] subArray(short[] sArr, int i, int i2) {
        return (short[]) realSubArray(sArr, i, i2);
    }

    public static char[] subArray(char[] cArr, int i, int i2) {
        return (char[]) realSubArray(cArr, i, i2);
    }

    public static byte[] subArray(byte[] bArr, int i, int i2) {
        return (byte[]) realSubArray(bArr, i, i2);
    }

    public static double[] subArray(double[] dArr, int i, int i2) {
        return (double[]) realSubArray(dArr, i, i2);
    }

    public static float[] subArray(float[] fArr, int i, int i2) {
        return (float[]) realSubArray(fArr, i, i2);
    }

    public static boolean[] subArray(boolean[] zArr, int i, int i2) {
        return (boolean[]) realSubArray(zArr, i, i2);
    }

    private static Object realSubArray(Object obj, int i, int i2) {
        if (obj == null) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        int length = getLength(obj);
        if (i2 > length) {
            i2 = length;
        }
        int i3 = i2 - i;
        Class<?> componentType = obj.getClass().getComponentType();
        if (i3 <= 0) {
            return Array.newInstance(componentType, 0);
        }
        Object newInstance = Array.newInstance(componentType, i3);
        System.arraycopy(obj, i, newInstance, 0, i3);
        return newInstance;
    }

    public static <T> T[] add(T[] tArr, T t) {
        T[] tArr2 = (T[]) ((Object[]) realAddOne(tArr, t, tArr != null ? tArr.getClass() : t != null ? t.getClass() : Object.class));
        Objects.requireNonNull(tArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return tArr2;
    }

    public static boolean[] add(boolean[] zArr, boolean z) {
        boolean[] zArr2 = (boolean[]) realAddOne(zArr, Boolean.valueOf(z), Boolean.TYPE);
        Objects.requireNonNull(zArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return zArr2;
    }

    public static byte[] add(byte[] bArr, byte b) {
        byte[] bArr2 = (byte[]) realAddOne(bArr, Byte.valueOf(b), Byte.TYPE);
        Objects.requireNonNull(bArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return bArr2;
    }

    public static char[] add(char[] cArr, char c) {
        char[] cArr2 = (char[]) realAddOne(cArr, Character.valueOf(c), Character.TYPE);
        Objects.requireNonNull(cArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return cArr2;
    }

    public static double[] add(double[] dArr, double d) {
        double[] dArr2 = (double[]) realAddOne(dArr, Double.valueOf(d), Double.TYPE);
        Objects.requireNonNull(dArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return dArr2;
    }

    public static float[] add(float[] fArr, float f) {
        float[] fArr2 = (float[]) realAddOne(fArr, Float.valueOf(f), Float.TYPE);
        Objects.requireNonNull(fArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return fArr2;
    }

    public static int[] add(int[] iArr, int i) {
        int[] iArr2 = (int[]) realAddOne(iArr, Integer.valueOf(i), Integer.TYPE);
        Objects.requireNonNull(iArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return iArr2;
    }

    public static long[] add(long[] jArr, long j) {
        long[] jArr2 = (long[]) realAddOne(jArr, Long.valueOf(j), Long.TYPE);
        Objects.requireNonNull(jArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return jArr2;
    }

    public static short[] add(short[] sArr, short s) {
        short[] sArr2 = (short[]) realAddOne(sArr, Short.valueOf(s), Short.TYPE);
        Objects.requireNonNull(sArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return sArr2;
    }

    private static Object realAddOne(Object obj, Object obj2, Class cls) {
        Object obj3;
        int i = 0;
        if (obj != null) {
            int length = getLength(obj);
            obj3 = Array.newInstance(obj.getClass().getComponentType(), length + 1);
            System.arraycopy(obj, 0, obj3, 0, length);
            i = length;
        } else {
            obj3 = Array.newInstance(cls, 1);
        }
        Array.set(obj3, i, obj2);
        Objects.requireNonNull(obj3, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.realAddOne() marked by @androidx.annotation.NonNull");
        return obj3;
    }

    public static <T> T[] add(T[] tArr, T[] tArr2) {
        return (T[]) ((Object[]) realAddArr(tArr, tArr2));
    }

    public static boolean[] add(boolean[] zArr, boolean[] zArr2) {
        return (boolean[]) realAddArr(zArr, zArr2);
    }

    public static char[] add(char[] cArr, char[] cArr2) {
        return (char[]) realAddArr(cArr, cArr2);
    }

    public static byte[] add(byte[] bArr, byte[] bArr2) {
        return (byte[]) realAddArr(bArr, bArr2);
    }

    public static short[] add(short[] sArr, short[] sArr2) {
        return (short[]) realAddArr(sArr, sArr2);
    }

    public static int[] add(int[] iArr, int[] iArr2) {
        return (int[]) realAddArr(iArr, iArr2);
    }

    public static long[] add(long[] jArr, long[] jArr2) {
        return (long[]) realAddArr(jArr, jArr2);
    }

    public static float[] add(float[] fArr, float[] fArr2) {
        return (float[]) realAddArr(fArr, fArr2);
    }

    public static double[] add(double[] dArr, double[] dArr2) {
        return (double[]) realAddArr(dArr, dArr2);
    }

    private static Object realAddArr(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return null;
        }
        if (obj == null) {
            return realCopy(obj2);
        }
        if (obj2 == null) {
            return realCopy(obj);
        }
        int length = getLength(obj);
        int length2 = getLength(obj2);
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), length + length2);
        System.arraycopy(obj, 0, newInstance, 0, length);
        System.arraycopy(obj2, 0, newInstance, length, length2);
        return newInstance;
    }

    public static <T> T[] add(T[] tArr, int i, T[] tArr2) {
        Class<?> cls;
        if (tArr != null) {
            cls = tArr.getClass().getComponentType();
        } else if (tArr2 == null) {
            return null;
        } else {
            cls = tArr2.getClass().getComponentType();
        }
        return (T[]) ((Object[]) realAddArr(tArr, i, tArr2, cls));
    }

    public static boolean[] add(boolean[] zArr, int i, boolean[] zArr2) {
        Object realAddArr = realAddArr(zArr, i, zArr2, Boolean.TYPE);
        if (realAddArr == null) {
            return null;
        }
        return (boolean[]) realAddArr;
    }

    public static char[] add(char[] cArr, int i, char[] cArr2) {
        Object realAddArr = realAddArr(cArr, i, cArr2, Character.TYPE);
        if (realAddArr == null) {
            return null;
        }
        return (char[]) realAddArr;
    }

    public static byte[] add(byte[] bArr, int i, byte[] bArr2) {
        Object realAddArr = realAddArr(bArr, i, bArr2, Byte.TYPE);
        if (realAddArr == null) {
            return null;
        }
        return (byte[]) realAddArr;
    }

    public static short[] add(short[] sArr, int i, short[] sArr2) {
        Object realAddArr = realAddArr(sArr, i, sArr2, Short.TYPE);
        if (realAddArr == null) {
            return null;
        }
        return (short[]) realAddArr;
    }

    public static int[] add(int[] iArr, int i, int[] iArr2) {
        Object realAddArr = realAddArr(iArr, i, iArr2, Integer.TYPE);
        if (realAddArr == null) {
            return null;
        }
        return (int[]) realAddArr;
    }

    public static long[] add(long[] jArr, int i, long[] jArr2) {
        Object realAddArr = realAddArr(jArr, i, jArr2, Long.TYPE);
        if (realAddArr == null) {
            return null;
        }
        return (long[]) realAddArr;
    }

    public static float[] add(float[] fArr, int i, float[] fArr2) {
        Object realAddArr = realAddArr(fArr, i, fArr2, Float.TYPE);
        if (realAddArr == null) {
            return null;
        }
        return (float[]) realAddArr;
    }

    public static double[] add(double[] dArr, int i, double[] dArr2) {
        Object realAddArr = realAddArr(dArr, i, dArr2, Double.TYPE);
        if (realAddArr == null) {
            return null;
        }
        return (double[]) realAddArr;
    }

    private static Object realAddArr(Object obj, int i, Object obj2, Class cls) {
        if (obj == null && obj2 == null) {
            return null;
        }
        int length = getLength(obj);
        int length2 = getLength(obj2);
        if (length == 0) {
            if (i == 0) {
                return realCopy(obj2);
            }
            throw new IndexOutOfBoundsException("Index: " + i + ", array1 Length: 0");
        } else if (length2 == 0) {
            return realCopy(obj);
        } else {
            if (i > length || i < 0) {
                throw new IndexOutOfBoundsException("Index: " + i + ", array1 Length: " + length);
            }
            Object newInstance = Array.newInstance(obj.getClass().getComponentType(), length + length2);
            if (i == length) {
                System.arraycopy(obj, 0, newInstance, 0, length);
                System.arraycopy(obj2, 0, newInstance, length, length2);
            } else if (i == 0) {
                System.arraycopy(obj2, 0, newInstance, 0, length2);
                System.arraycopy(obj, 0, newInstance, length2, length);
            } else {
                System.arraycopy(obj, 0, newInstance, 0, i);
                System.arraycopy(obj2, 0, newInstance, i, length2);
                System.arraycopy(obj, i, newInstance, length2 + i, length - i);
            }
            return newInstance;
        }
    }

    public static <T> T[] add(T[] tArr, int i, T t) {
        Class<?> cls;
        if (tArr != null) {
            cls = tArr.getClass().getComponentType();
        } else if (t == null) {
            return (T[]) new Object[]{null};
        } else {
            cls = t.getClass();
        }
        T[] tArr2 = (T[]) ((Object[]) realAdd(tArr, i, t, cls));
        Objects.requireNonNull(tArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return tArr2;
    }

    public static boolean[] add(boolean[] zArr, int i, boolean z) {
        boolean[] zArr2 = (boolean[]) realAdd(zArr, i, Boolean.valueOf(z), Boolean.TYPE);
        Objects.requireNonNull(zArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return zArr2;
    }

    public static char[] add(char[] cArr, int i, char c) {
        char[] cArr2 = (char[]) realAdd(cArr, i, Character.valueOf(c), Character.TYPE);
        Objects.requireNonNull(cArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return cArr2;
    }

    public static byte[] add(byte[] bArr, int i, byte b) {
        byte[] bArr2 = (byte[]) realAdd(bArr, i, Byte.valueOf(b), Byte.TYPE);
        Objects.requireNonNull(bArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return bArr2;
    }

    public static short[] add(short[] sArr, int i, short s) {
        short[] sArr2 = (short[]) realAdd(sArr, i, Short.valueOf(s), Short.TYPE);
        Objects.requireNonNull(sArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return sArr2;
    }

    public static int[] add(int[] iArr, int i, int i2) {
        int[] iArr2 = (int[]) realAdd(iArr, i, Integer.valueOf(i2), Integer.TYPE);
        Objects.requireNonNull(iArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return iArr2;
    }

    public static long[] add(long[] jArr, int i, long j) {
        long[] jArr2 = (long[]) realAdd(jArr, i, Long.valueOf(j), Long.TYPE);
        Objects.requireNonNull(jArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return jArr2;
    }

    public static float[] add(float[] fArr, int i, float f) {
        float[] fArr2 = (float[]) realAdd(fArr, i, Float.valueOf(f), Float.TYPE);
        Objects.requireNonNull(fArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return fArr2;
    }

    public static double[] add(double[] dArr, int i, double d) {
        double[] dArr2 = (double[]) realAdd(dArr, i, Double.valueOf(d), Double.TYPE);
        Objects.requireNonNull(dArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return dArr2;
    }

    private static Object realAdd(Object obj, int i, Object obj2, Class cls) {
        if (obj != null) {
            int length = Array.getLength(obj);
            if (i > length || i < 0) {
                throw new IndexOutOfBoundsException("Index: " + i + ", Length: " + length);
            }
            Object newInstance = Array.newInstance(cls, length + 1);
            System.arraycopy(obj, 0, newInstance, 0, i);
            Array.set(newInstance, i, obj2);
            if (i < length) {
                System.arraycopy(obj, i, newInstance, i + 1, length - i);
            }
            Objects.requireNonNull(newInstance, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.realAdd() marked by @androidx.annotation.NonNull");
            return newInstance;
        } else if (i == 0) {
            Object newInstance2 = Array.newInstance(cls, 1);
            Array.set(newInstance2, 0, obj2);
            Objects.requireNonNull(newInstance2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.realAdd() marked by @androidx.annotation.NonNull");
            return newInstance2;
        } else {
            throw new IndexOutOfBoundsException("Index: " + i + ", Length: 0");
        }
    }

    public static Object[] remove(Object[] objArr, int i) {
        if (objArr == null) {
            return null;
        }
        return (Object[]) remove((Object) objArr, i);
    }

    public static Object[] removeElement(Object[] objArr, Object obj) {
        int indexOf = indexOf(objArr, obj);
        if (indexOf == -1) {
            return copy(objArr);
        }
        return remove(objArr, indexOf);
    }

    public static boolean[] remove(boolean[] zArr, int i) {
        if (zArr == null) {
            return null;
        }
        return (boolean[]) remove((Object) zArr, i);
    }

    public static boolean[] removeElement(boolean[] zArr, boolean z) {
        int indexOf = indexOf(zArr, z);
        if (indexOf == -1) {
            return copy(zArr);
        }
        return remove(zArr, indexOf);
    }

    public static byte[] remove(byte[] bArr, int i) {
        if (bArr == null) {
            return null;
        }
        return (byte[]) remove((Object) bArr, i);
    }

    public static byte[] removeElement(byte[] bArr, byte b) {
        int indexOf = indexOf(bArr, b);
        if (indexOf == -1) {
            return copy(bArr);
        }
        return remove(bArr, indexOf);
    }

    public static char[] remove(char[] cArr, int i) {
        if (cArr == null) {
            return null;
        }
        return (char[]) remove((Object) cArr, i);
    }

    public static char[] removeElement(char[] cArr, char c) {
        int indexOf = indexOf(cArr, c);
        if (indexOf == -1) {
            return copy(cArr);
        }
        return remove(cArr, indexOf);
    }

    public static double[] remove(double[] dArr, int i) {
        if (dArr == null) {
            return null;
        }
        return (double[]) remove((Object) dArr, i);
    }

    public static double[] removeElement(double[] dArr, double d) {
        int indexOf = indexOf(dArr, d);
        if (indexOf == -1) {
            return copy(dArr);
        }
        return remove(dArr, indexOf);
    }

    public static float[] remove(float[] fArr, int i) {
        if (fArr == null) {
            return null;
        }
        return (float[]) remove((Object) fArr, i);
    }

    public static float[] removeElement(float[] fArr, float f) {
        int indexOf = indexOf(fArr, f);
        if (indexOf == -1) {
            return copy(fArr);
        }
        return remove(fArr, indexOf);
    }

    public static int[] remove(int[] iArr, int i) {
        if (iArr == null) {
            return null;
        }
        return (int[]) remove((Object) iArr, i);
    }

    public static int[] removeElement(int[] iArr, int i) {
        int indexOf = indexOf(iArr, i);
        if (indexOf == -1) {
            return copy(iArr);
        }
        return remove(iArr, indexOf);
    }

    public static long[] remove(long[] jArr, int i) {
        if (jArr == null) {
            return null;
        }
        return (long[]) remove((Object) jArr, i);
    }

    public static long[] removeElement(long[] jArr, long j) {
        int indexOf = indexOf(jArr, j);
        if (indexOf == -1) {
            return copy(jArr);
        }
        return remove(jArr, indexOf);
    }

    public static short[] remove(short[] sArr, int i) {
        if (sArr == null) {
            return null;
        }
        return (short[]) remove((Object) sArr, i);
    }

    public static short[] removeElement(short[] sArr, short s) {
        int indexOf = indexOf(sArr, s);
        if (indexOf == -1) {
            return copy(sArr);
        }
        return remove(sArr, indexOf);
    }

    private static Object remove(Object obj, int i) {
        Objects.requireNonNull(obj, "Argument 'array' of type Object (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        int length = getLength(obj);
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Length: " + length);
        }
        int i2 = length - 1;
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), i2);
        System.arraycopy(obj, 0, newInstance, 0, i);
        if (i < i2) {
            System.arraycopy(obj, i + 1, newInstance, i, (length - i) - 1);
        }
        Objects.requireNonNull(newInstance, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.remove() marked by @androidx.annotation.NonNull");
        return newInstance;
    }

    public static int indexOf(Object[] objArr, Object obj) {
        return indexOf(objArr, obj, 0);
    }

    public static int indexOf(Object[] objArr, Object obj, int i) {
        if (objArr == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        if (obj == null) {
            while (i < objArr.length) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
        } else {
            while (i < objArr.length) {
                if (obj.equals(objArr[i])) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public static int lastIndexOf(Object[] objArr, Object obj) {
        return lastIndexOf(objArr, obj, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(Object[] objArr, Object obj, int i) {
        if (objArr == null || i < 0) {
            return -1;
        }
        if (i >= objArr.length) {
            i = objArr.length - 1;
        }
        if (obj == null) {
            while (i >= 0) {
                if (objArr[i] == null) {
                    return i;
                }
                i--;
            }
        } else {
            while (i >= 0) {
                if (obj.equals(objArr[i])) {
                    return i;
                }
                i--;
            }
        }
        return -1;
    }

    public static boolean contains(Object[] objArr, Object obj) {
        return indexOf(objArr, obj) != -1;
    }

    public static int indexOf(long[] jArr, long j) {
        return indexOf(jArr, j, 0);
    }

    public static int indexOf(long[] jArr, long j, int i) {
        if (jArr == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < jArr.length) {
            if (j == jArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int lastIndexOf(long[] jArr, long j) {
        return lastIndexOf(jArr, j, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(long[] jArr, long j, int i) {
        if (jArr == null || i < 0) {
            return -1;
        }
        if (i >= jArr.length) {
            i = jArr.length - 1;
        }
        while (i >= 0) {
            if (j == jArr[i]) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static boolean contains(long[] jArr, long j) {
        return indexOf(jArr, j) != -1;
    }

    public static int indexOf(int[] iArr, int i) {
        return indexOf(iArr, i, 0);
    }

    public static int indexOf(int[] iArr, int i, int i2) {
        if (iArr == null) {
            return -1;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < iArr.length) {
            if (i == iArr[i2]) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int lastIndexOf(int[] iArr, int i) {
        return lastIndexOf(iArr, i, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(int[] iArr, int i, int i2) {
        if (iArr == null || i2 < 0) {
            return -1;
        }
        if (i2 >= iArr.length) {
            i2 = iArr.length - 1;
        }
        while (i2 >= 0) {
            if (i == iArr[i2]) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public static boolean contains(int[] iArr, int i) {
        return indexOf(iArr, i) != -1;
    }

    public static int indexOf(short[] sArr, short s) {
        return indexOf(sArr, s, 0);
    }

    public static int indexOf(short[] sArr, short s, int i) {
        if (sArr == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < sArr.length) {
            if (s == sArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int lastIndexOf(short[] sArr, short s) {
        return lastIndexOf(sArr, s, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(short[] sArr, short s, int i) {
        if (sArr == null || i < 0) {
            return -1;
        }
        if (i >= sArr.length) {
            i = sArr.length - 1;
        }
        while (i >= 0) {
            if (s == sArr[i]) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static boolean contains(short[] sArr, short s) {
        return indexOf(sArr, s) != -1;
    }

    public static int indexOf(char[] cArr, char c) {
        return indexOf(cArr, c, 0);
    }

    public static int indexOf(char[] cArr, char c, int i) {
        if (cArr == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < cArr.length) {
            if (c == cArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int lastIndexOf(char[] cArr, char c) {
        return lastIndexOf(cArr, c, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(char[] cArr, char c, int i) {
        if (cArr == null || i < 0) {
            return -1;
        }
        if (i >= cArr.length) {
            i = cArr.length - 1;
        }
        while (i >= 0) {
            if (c == cArr[i]) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static boolean contains(char[] cArr, char c) {
        return indexOf(cArr, c) != -1;
    }

    public static int indexOf(byte[] bArr, byte b) {
        return indexOf(bArr, b, 0);
    }

    public static int indexOf(byte[] bArr, byte b, int i) {
        if (bArr == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < bArr.length) {
            if (b == bArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int lastIndexOf(byte[] bArr, byte b) {
        return lastIndexOf(bArr, b, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(byte[] bArr, byte b, int i) {
        if (bArr == null || i < 0) {
            return -1;
        }
        if (i >= bArr.length) {
            i = bArr.length - 1;
        }
        while (i >= 0) {
            if (b == bArr[i]) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static boolean contains(byte[] bArr, byte b) {
        return indexOf(bArr, b) != -1;
    }

    public static int indexOf(double[] dArr, double d) {
        return indexOf(dArr, d, 0);
    }

    public static int indexOf(double[] dArr, double d, double d2) {
        return indexOf(dArr, d, 0, d2);
    }

    public static int indexOf(double[] dArr, double d, int i) {
        if (isEmpty(dArr)) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < dArr.length) {
            if (d == dArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int indexOf(double[] dArr, double d, int i, double d2) {
        if (isEmpty(dArr)) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        double d3 = d - d2;
        double d4 = d + d2;
        while (i < dArr.length) {
            if (dArr[i] >= d3 && dArr[i] <= d4) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int lastIndexOf(double[] dArr, double d) {
        return lastIndexOf(dArr, d, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(double[] dArr, double d, double d2) {
        return lastIndexOf(dArr, d, Integer.MAX_VALUE, d2);
    }

    public static int lastIndexOf(double[] dArr, double d, int i) {
        if (isEmpty(dArr) || i < 0) {
            return -1;
        }
        if (i >= dArr.length) {
            i = dArr.length - 1;
        }
        while (i >= 0) {
            if (d == dArr[i]) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static int lastIndexOf(double[] dArr, double d, int i, double d2) {
        if (isEmpty(dArr) || i < 0) {
            return -1;
        }
        if (i >= dArr.length) {
            i = dArr.length - 1;
        }
        double d3 = d - d2;
        double d4 = d + d2;
        while (i >= 0) {
            if (dArr[i] >= d3 && dArr[i] <= d4) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static boolean contains(double[] dArr, double d) {
        return indexOf(dArr, d) != -1;
    }

    public static boolean contains(double[] dArr, double d, double d2) {
        return indexOf(dArr, d, 0, d2) != -1;
    }

    public static int indexOf(float[] fArr, float f) {
        return indexOf(fArr, f, 0);
    }

    public static int indexOf(float[] fArr, float f, int i) {
        if (isEmpty(fArr)) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < fArr.length) {
            if (f == fArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int lastIndexOf(float[] fArr, float f) {
        return lastIndexOf(fArr, f, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(float[] fArr, float f, int i) {
        if (isEmpty(fArr) || i < 0) {
            return -1;
        }
        if (i >= fArr.length) {
            i = fArr.length - 1;
        }
        while (i >= 0) {
            if (f == fArr[i]) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static boolean contains(float[] fArr, float f) {
        return indexOf(fArr, f) != -1;
    }

    public static int indexOf(boolean[] zArr, boolean z) {
        return indexOf(zArr, z, 0);
    }

    public static int indexOf(boolean[] zArr, boolean z, int i) {
        if (isEmpty(zArr)) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < zArr.length) {
            if (z == zArr[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int lastIndexOf(boolean[] zArr, boolean z) {
        return lastIndexOf(zArr, z, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(boolean[] zArr, boolean z, int i) {
        if (isEmpty(zArr) || i < 0) {
            return -1;
        }
        if (i >= zArr.length) {
            i = zArr.length - 1;
        }
        while (i >= 0) {
            if (z == zArr[i]) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static boolean contains(boolean[] zArr, boolean z) {
        return indexOf(zArr, z) != -1;
    }

    public static char[] toPrimitive(Character[] chArr) {
        if (chArr == null) {
            return null;
        }
        if (chArr.length == 0) {
            return new char[0];
        }
        char[] cArr = new char[chArr.length];
        for (int i = 0; i < chArr.length; i++) {
            cArr[i] = chArr[i].charValue();
        }
        return cArr;
    }

    public static char[] toPrimitive(Character[] chArr, char c) {
        char c2;
        if (chArr == null) {
            return null;
        }
        if (chArr.length == 0) {
            return new char[0];
        }
        char[] cArr = new char[chArr.length];
        for (int i = 0; i < chArr.length; i++) {
            Character ch = chArr[i];
            if (ch == null) {
                c2 = c;
            } else {
                c2 = ch.charValue();
            }
            cArr[i] = c2;
        }
        return cArr;
    }

    public static Character[] toObject(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        if (cArr.length == 0) {
            return new Character[0];
        }
        Character[] chArr = new Character[cArr.length];
        for (int i = 0; i < cArr.length; i++) {
            chArr[i] = new Character(cArr[i]);
        }
        return chArr;
    }

    public static long[] toPrimitive(Long[] lArr) {
        if (lArr == null) {
            return null;
        }
        if (lArr.length == 0) {
            return new long[0];
        }
        long[] jArr = new long[lArr.length];
        for (int i = 0; i < lArr.length; i++) {
            jArr[i] = lArr[i].longValue();
        }
        return jArr;
    }

    public static long[] toPrimitive(Long[] lArr, long j) {
        long j2;
        if (lArr == null) {
            return null;
        }
        if (lArr.length == 0) {
            return new long[0];
        }
        long[] jArr = new long[lArr.length];
        for (int i = 0; i < lArr.length; i++) {
            Long l = lArr[i];
            if (l == null) {
                j2 = j;
            } else {
                j2 = l.longValue();
            }
            jArr[i] = j2;
        }
        return jArr;
    }

    public static Long[] toObject(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        if (jArr.length == 0) {
            return new Long[0];
        }
        Long[] lArr = new Long[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            lArr[i] = new Long(jArr[i]);
        }
        return lArr;
    }

    public static int[] toPrimitive(Integer[] numArr) {
        if (numArr == null) {
            return null;
        }
        if (numArr.length == 0) {
            return new int[0];
        }
        int[] iArr = new int[numArr.length];
        for (int i = 0; i < numArr.length; i++) {
            iArr[i] = numArr[i].intValue();
        }
        return iArr;
    }

    public static int[] toPrimitive(Integer[] numArr, int i) {
        int i2;
        if (numArr == null) {
            return null;
        }
        if (numArr.length == 0) {
            return new int[0];
        }
        int[] iArr = new int[numArr.length];
        for (int i3 = 0; i3 < numArr.length; i3++) {
            Integer num = numArr[i3];
            if (num == null) {
                i2 = i;
            } else {
                i2 = num.intValue();
            }
            iArr[i3] = i2;
        }
        return iArr;
    }

    public static Integer[] toObject(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        if (iArr.length == 0) {
            return new Integer[0];
        }
        Integer[] numArr = new Integer[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            numArr[i] = new Integer(iArr[i]);
        }
        return numArr;
    }

    public static short[] toPrimitive(Short[] shArr) {
        if (shArr == null) {
            return null;
        }
        if (shArr.length == 0) {
            return new short[0];
        }
        short[] sArr = new short[shArr.length];
        for (int i = 0; i < shArr.length; i++) {
            sArr[i] = shArr[i].shortValue();
        }
        return sArr;
    }

    public static short[] toPrimitive(Short[] shArr, short s) {
        short s2;
        if (shArr == null) {
            return null;
        }
        if (shArr.length == 0) {
            return new short[0];
        }
        short[] sArr = new short[shArr.length];
        for (int i = 0; i < shArr.length; i++) {
            Short sh = shArr[i];
            if (sh == null) {
                s2 = s;
            } else {
                s2 = sh.shortValue();
            }
            sArr[i] = s2;
        }
        return sArr;
    }

    public static Short[] toObject(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        if (sArr.length == 0) {
            return new Short[0];
        }
        Short[] shArr = new Short[sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            shArr[i] = new Short(sArr[i]);
        }
        return shArr;
    }

    public static byte[] toPrimitive(Byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = bArr[i].byteValue();
        }
        return bArr2;
    }

    public static byte[] toPrimitive(Byte[] bArr, byte b) {
        byte b2;
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            Byte b3 = bArr[i];
            if (b3 == null) {
                b2 = b;
            } else {
                b2 = b3.byteValue();
            }
            bArr2[i] = b2;
        }
        return bArr2;
    }

    public static Byte[] toObject(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return new Byte[0];
        }
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = new Byte(bArr[i]);
        }
        return bArr2;
    }

    public static double[] toPrimitive(Double[] dArr) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return new double[0];
        }
        double[] dArr2 = new double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = dArr[i].doubleValue();
        }
        return dArr2;
    }

    public static double[] toPrimitive(Double[] dArr, double d) {
        double d2;
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return new double[0];
        }
        double[] dArr2 = new double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            Double d3 = dArr[i];
            if (d3 == null) {
                d2 = d;
            } else {
                d2 = d3.doubleValue();
            }
            dArr2[i] = d2;
        }
        return dArr2;
    }

    public static Double[] toObject(double[] dArr) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return new Double[0];
        }
        Double[] dArr2 = new Double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = new Double(dArr[i]);
        }
        return dArr2;
    }

    public static float[] toPrimitive(Float[] fArr) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return new float[0];
        }
        float[] fArr2 = new float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = fArr[i].floatValue();
        }
        return fArr2;
    }

    public static float[] toPrimitive(Float[] fArr, float f) {
        float f2;
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return new float[0];
        }
        float[] fArr2 = new float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            Float f3 = fArr[i];
            if (f3 == null) {
                f2 = f;
            } else {
                f2 = f3.floatValue();
            }
            fArr2[i] = f2;
        }
        return fArr2;
    }

    public static Float[] toObject(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return new Float[0];
        }
        Float[] fArr2 = new Float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = new Float(fArr[i]);
        }
        return fArr2;
    }

    public static boolean[] toPrimitive(Boolean[] boolArr) {
        if (boolArr == null) {
            return null;
        }
        if (boolArr.length == 0) {
            return new boolean[0];
        }
        boolean[] zArr = new boolean[boolArr.length];
        for (int i = 0; i < boolArr.length; i++) {
            zArr[i] = boolArr[i].booleanValue();
        }
        return zArr;
    }

    public static boolean[] toPrimitive(Boolean[] boolArr, boolean z) {
        boolean z2;
        if (boolArr == null) {
            return null;
        }
        if (boolArr.length == 0) {
            return new boolean[0];
        }
        boolean[] zArr = new boolean[boolArr.length];
        for (int i = 0; i < boolArr.length; i++) {
            Boolean bool = boolArr[i];
            if (bool == null) {
                z2 = z;
            } else {
                z2 = bool.booleanValue();
            }
            zArr[i] = z2;
        }
        return zArr;
    }

    public static Boolean[] toObject(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        if (zArr.length == 0) {
            return new Boolean[0];
        }
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i = 0; i < zArr.length; i++) {
            boolArr[i] = zArr[i] ? Boolean.TRUE : Boolean.FALSE;
        }
        return boolArr;
    }

    public static <T> List<T> asList(T... tArr) {
        if (tArr == null || tArr.length == 0) {
            List<T> emptyList = Collections.emptyList();
            Objects.requireNonNull(emptyList, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.asList() marked by @androidx.annotation.NonNull");
            return emptyList;
        }
        List<T> asList = Arrays.asList(tArr);
        Objects.requireNonNull(asList, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.asList() marked by @androidx.annotation.NonNull");
        return asList;
    }

    public static <T> List<T> asUnmodifiableList(T... tArr) {
        List<T> unmodifiableList = Collections.unmodifiableList(asList(tArr));
        Objects.requireNonNull(unmodifiableList, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.asUnmodifiableList() marked by @androidx.annotation.NonNull");
        return unmodifiableList;
    }

    public static <T> List<T> asArrayList(T... tArr) {
        ArrayList arrayList = new ArrayList();
        if (!(tArr == null || tArr.length == 0)) {
            arrayList.addAll(Arrays.asList(tArr));
        }
        return arrayList;
    }

    public static <T> List<T> asLinkedList(T... tArr) {
        LinkedList linkedList = new LinkedList();
        if (!(tArr == null || tArr.length == 0)) {
            linkedList.addAll(Arrays.asList(tArr));
        }
        return linkedList;
    }

    public static <T> void sort(T[] tArr, Comparator<? super T> comparator) {
        if (tArr != null && tArr.length >= 2) {
            Arrays.sort(tArr, comparator);
        }
    }

    public static void sort(byte[] bArr) {
        if (bArr != null && bArr.length >= 2) {
            Arrays.sort(bArr);
        }
    }

    public static void sort(char[] cArr) {
        if (cArr != null && cArr.length >= 2) {
            Arrays.sort(cArr);
        }
    }

    public static void sort(double[] dArr) {
        if (dArr != null && dArr.length >= 2) {
            Arrays.sort(dArr);
        }
    }

    public static void sort(float[] fArr) {
        if (fArr != null && fArr.length >= 2) {
            Arrays.sort(fArr);
        }
    }

    public static void sort(int[] iArr) {
        if (iArr != null && iArr.length >= 2) {
            Arrays.sort(iArr);
        }
    }

    public static void sort(long[] jArr) {
        if (jArr != null && jArr.length >= 2) {
            Arrays.sort(jArr);
        }
    }

    public static void sort(short[] sArr) {
        if (sArr != null && sArr.length >= 2) {
            Arrays.sort(sArr);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.blankj.utilcode.util.ArrayUtils$Closure<E> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <E> void forAllDo(Object obj, Closure<E> closure) {
        if (obj != null && closure != 0) {
            int i = 0;
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                int length = objArr.length;
                while (i < length) {
                    closure.execute(i, objArr[i]);
                    i++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length2 = zArr.length;
                while (i < length2) {
                    closure.execute(i, zArr[i] ? Boolean.TRUE : Boolean.FALSE);
                    i++;
                }
            } else if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                int length3 = bArr.length;
                while (i < length3) {
                    closure.execute(i, Byte.valueOf(bArr[i]));
                    i++;
                }
            } else if (obj instanceof char[]) {
                char[] cArr = (char[]) obj;
                int length4 = cArr.length;
                while (i < length4) {
                    closure.execute(i, Character.valueOf(cArr[i]));
                    i++;
                }
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                int length5 = sArr.length;
                while (i < length5) {
                    closure.execute(i, Short.valueOf(sArr[i]));
                    i++;
                }
            } else if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                int length6 = iArr.length;
                while (i < length6) {
                    closure.execute(i, Integer.valueOf(iArr[i]));
                    i++;
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int length7 = jArr.length;
                while (i < length7) {
                    closure.execute(i, Long.valueOf(jArr[i]));
                    i++;
                }
            } else if (obj instanceof float[]) {
                float[] fArr = (float[]) obj;
                int length8 = fArr.length;
                while (i < length8) {
                    closure.execute(i, Float.valueOf(fArr[i]));
                    i++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length9 = dArr.length;
                while (i < length9) {
                    closure.execute(i, Double.valueOf(dArr[i]));
                    i++;
                }
            } else {
                throw new IllegalArgumentException("Not an array: " + obj.getClass());
            }
        }
    }

    public static String toString(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof Object[]) {
            String deepToString = Arrays.deepToString((Object[]) obj);
            Objects.requireNonNull(deepToString, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.toString() marked by @androidx.annotation.NonNull");
            return deepToString;
        } else if (obj instanceof boolean[]) {
            String arrays = Arrays.toString((boolean[]) obj);
            Objects.requireNonNull(arrays, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.toString() marked by @androidx.annotation.NonNull");
            return arrays;
        } else if (obj instanceof byte[]) {
            String arrays2 = Arrays.toString((byte[]) obj);
            Objects.requireNonNull(arrays2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.toString() marked by @androidx.annotation.NonNull");
            return arrays2;
        } else if (obj instanceof char[]) {
            String arrays3 = Arrays.toString((char[]) obj);
            Objects.requireNonNull(arrays3, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.toString() marked by @androidx.annotation.NonNull");
            return arrays3;
        } else if (obj instanceof double[]) {
            String arrays4 = Arrays.toString((double[]) obj);
            Objects.requireNonNull(arrays4, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.toString() marked by @androidx.annotation.NonNull");
            return arrays4;
        } else if (obj instanceof float[]) {
            String arrays5 = Arrays.toString((float[]) obj);
            Objects.requireNonNull(arrays5, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.toString() marked by @androidx.annotation.NonNull");
            return arrays5;
        } else if (obj instanceof int[]) {
            String arrays6 = Arrays.toString((int[]) obj);
            Objects.requireNonNull(arrays6, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.toString() marked by @androidx.annotation.NonNull");
            return arrays6;
        } else if (obj instanceof long[]) {
            String arrays7 = Arrays.toString((long[]) obj);
            Objects.requireNonNull(arrays7, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.toString() marked by @androidx.annotation.NonNull");
            return arrays7;
        } else if (obj instanceof short[]) {
            String arrays8 = Arrays.toString((short[]) obj);
            Objects.requireNonNull(arrays8, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.toString() marked by @androidx.annotation.NonNull");
            return arrays8;
        } else {
            throw new IllegalArgumentException("Array has incompatible type: " + obj.getClass());
        }
    }
}
