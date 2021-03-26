package com.blankj.utilcode.util;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ConvertUtils {
    private static final int BUFFER_SIZE = 8192;
    private static final char[] HEX_DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] HEX_DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static double byte2MemorySize(long j, int i) {
        if (j < 0) {
            return -1.0d;
        }
        return ((double) j) / ((double) i);
    }

    public static long memorySize2Byte(long j, int i) {
        if (j < 0) {
            return -1;
        }
        return j * ((long) i);
    }

    public static long timeSpan2Millis(long j, int i) {
        return j * ((long) i);
    }

    private ConvertUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String int2HexString(int i) {
        return Integer.toHexString(i);
    }

    public static int hexString2Int(String str) {
        return Integer.parseInt(str, 16);
    }

    public static String bytes2Bits(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            for (int i = 7; i >= 0; i--) {
                sb.append(((b >> i) & 1) == 0 ? '0' : '1');
            }
        }
        return sb.toString();
    }

    public static byte[] bits2Bytes(String str) {
        int length = str.length() % 8;
        int length2 = str.length() / 8;
        if (length != 0) {
            while (length < 8) {
                str = "0" + str;
                length++;
            }
            length2++;
        }
        byte[] bArr = new byte[length2];
        for (int i = 0; i < length2; i++) {
            for (int i2 = 0; i2 < 8; i2++) {
                bArr[i] = (byte) (bArr[i] << 1);
                bArr[i] = (byte) (bArr[i] | (str.charAt((i * 8) + i2) - '0'));
            }
        }
        return bArr;
    }

    public static char[] bytes2Chars(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return null;
        }
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        return cArr;
    }

    public static byte[] chars2Bytes(char[] cArr) {
        if (cArr == null || cArr.length <= 0) {
            return null;
        }
        int length = cArr.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) cArr[i];
        }
        return bArr;
    }

    public static String bytes2HexString(byte[] bArr) {
        return bytes2HexString(bArr, true);
    }

    public static String bytes2HexString(byte[] bArr, boolean z) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = z ? HEX_DIGITS_UPPER : HEX_DIGITS_LOWER;
        int length = bArr.length;
        if (length <= 0) {
            return "";
        }
        char[] cArr2 = new char[(length << 1)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr2[i] = cArr[(bArr[i2] >> 4) & 15];
            i = i3 + 1;
            cArr2[i3] = cArr[bArr[i2] & 15];
        }
        return new String(cArr2);
    }

    public static byte[] hexString2Bytes(String str) {
        if (UtilsBridge.isSpace(str)) {
            return new byte[0];
        }
        int length = str.length();
        if (length % 2 != 0) {
            str = "0" + str;
            length++;
        }
        char[] charArray = str.toUpperCase().toCharArray();
        byte[] bArr = new byte[(length >> 1)];
        for (int i = 0; i < length; i += 2) {
            bArr[i >> 1] = (byte) ((hex2Dec(charArray[i]) << 4) | hex2Dec(charArray[i + 1]));
        }
        return bArr;
    }

    private static int hex2Dec(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'A' && c <= 'F') {
            return (c - 'A') + 10;
        }
        throw new IllegalArgumentException();
    }

    public static String bytes2String(byte[] bArr) {
        return bytes2String(bArr, "");
    }

    public static String bytes2String(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, getSafeCharset(str));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new String(bArr);
        }
    }

    public static byte[] string2Bytes(String str) {
        return string2Bytes(str, "");
    }

    public static byte[] string2Bytes(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(getSafeCharset(str2));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str.getBytes();
        }
    }

    public static JSONObject bytes2JSONObject(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new JSONObject(new String(bArr));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] jsonObject2Bytes(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString().getBytes();
    }

    public static JSONArray bytes2JSONArray(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new JSONArray(new String(bArr));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] jsonArray2Bytes(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        return jSONArray.toString().getBytes();
    }

    public static <T> T bytes2Parcelable(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        T createFromParcel = creator.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    public static byte[] parcelable2Bytes(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0026 A[SYNTHETIC, Splitter:B:19:0x0026] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0033 A[SYNTHETIC, Splitter:B:27:0x0033] */
    public static Object bytes2Object(byte[] bArr) {
        Throwable th;
        Exception e;
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2 = null;
        if (bArr == null) {
            return null;
        }
        try {
            objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bArr));
            try {
                Object readObject = objectInputStream.readObject();
                try {
                    objectInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return readObject;
            } catch (Exception e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    objectInputStream2 = objectInputStream;
                    if (objectInputStream2 != null) {
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            objectInputStream = null;
            e.printStackTrace();
            if (objectInputStream != null) {
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (objectInputStream2 != null) {
                try {
                    objectInputStream2.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0029 A[SYNTHETIC, Splitter:B:19:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0036 A[SYNTHETIC, Splitter:B:27:0x0036] */
    public static byte[] serializable2Bytes(Serializable serializable) {
        Throwable th;
        Exception e;
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2 = null;
        if (serializable == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(serializable);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    objectOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return byteArray;
            } catch (Exception e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    objectOutputStream2 = objectOutputStream;
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            objectOutputStream = null;
            e.printStackTrace();
            if (objectOutputStream != null) {
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (objectOutputStream2 != null) {
            }
            throw th;
        }
    }

    public static Bitmap bytes2Bitmap(byte[] bArr) {
        return UtilsBridge.bytes2Bitmap(bArr);
    }

    public static byte[] bitmap2Bytes(Bitmap bitmap) {
        return UtilsBridge.bitmap2Bytes(bitmap);
    }

    public static byte[] bitmap2Bytes(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i) {
        return UtilsBridge.bitmap2Bytes(bitmap, compressFormat, i);
    }

    public static Drawable bytes2Drawable(byte[] bArr) {
        return UtilsBridge.bytes2Drawable(bArr);
    }

    public static byte[] drawable2Bytes(Drawable drawable) {
        return UtilsBridge.drawable2Bytes(drawable);
    }

    public static byte[] drawable2Bytes(Drawable drawable, Bitmap.CompressFormat compressFormat, int i) {
        return UtilsBridge.drawable2Bytes(drawable, compressFormat, i);
    }

    public static String byte2FitMemorySize(long j) {
        return byte2FitMemorySize(j, 3);
    }

    public static String byte2FitMemorySize(long j, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("precision shouldn't be less than zero!");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteSize shouldn't be less than zero!");
        } else if (j < 1024) {
            return String.format("%." + i + "fB", Double.valueOf((double) j));
        } else if (j < 1048576) {
            return String.format("%." + i + "fKB", Double.valueOf(((double) j) / 1024.0d));
        } else if (j < 1073741824) {
            return String.format("%." + i + "fMB", Double.valueOf(((double) j) / 1048576.0d));
        } else {
            return String.format("%." + i + "fGB", Double.valueOf(((double) j) / 1.073741824E9d));
        }
    }

    public static long millis2TimeSpan(long j, int i) {
        return j / ((long) i);
    }

    public static String millis2FitTimeSpan(long j, int i) {
        return UtilsBridge.millis2FitTimeSpan(j, i);
    }

    public static ByteArrayOutputStream input2OutputStream(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr, 0, 8192);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    try {
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            inputStream.close();
            return byteArrayOutputStream;
        } catch (IOException e2) {
            e2.printStackTrace();
            try {
                inputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            return null;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }

    public static ByteArrayInputStream output2InputStream(OutputStream outputStream) {
        if (outputStream == null) {
            return null;
        }
        return new ByteArrayInputStream(((ByteArrayOutputStream) outputStream).toByteArray());
    }

    public static byte[] inputStream2Bytes(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        return input2OutputStream(inputStream).toByteArray();
    }

    public static InputStream bytes2InputStream(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        return new ByteArrayInputStream(bArr);
    }

    public static byte[] outputStream2Bytes(OutputStream outputStream) {
        if (outputStream == null) {
            return null;
        }
        return ((ByteArrayOutputStream) outputStream).toByteArray();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0023 A[SYNTHETIC, Splitter:B:20:0x0023] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0030 A[SYNTHETIC, Splitter:B:28:0x0030] */
    public static OutputStream bytes2OutputStream(byte[] bArr) {
        Throwable th;
        IOException e;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(bArr);
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return byteArrayOutputStream;
            } catch (IOException e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            byteArrayOutputStream = null;
            e.printStackTrace();
            if (byteArrayOutputStream != null) {
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static String inputStream2String(InputStream inputStream, String str) {
        if (inputStream == null) {
            return "";
        }
        try {
            ByteArrayOutputStream input2OutputStream = input2OutputStream(inputStream);
            if (input2OutputStream == null) {
                return "";
            }
            return input2OutputStream.toString(getSafeCharset(str));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static InputStream string2InputStream(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return new ByteArrayInputStream(str.getBytes(getSafeCharset(str2)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String outputStream2String(OutputStream outputStream, String str) {
        if (outputStream == null) {
            return "";
        }
        try {
            return new String(outputStream2Bytes(outputStream), getSafeCharset(str));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static OutputStream string2OutputStream(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return bytes2OutputStream(str.getBytes(getSafeCharset(str2)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> inputStream2Lines(InputStream inputStream) {
        return inputStream2Lines(inputStream, "");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0032 A[SYNTHETIC, Splitter:B:19:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x003f A[SYNTHETIC, Splitter:B:27:0x003f] */
    public static List<String> inputStream2Lines(InputStream inputStream, String str) {
        Throwable th;
        IOException e;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            ArrayList arrayList = new ArrayList();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, getSafeCharset(str)));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        arrayList.add(readLine);
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                        }
                        throw th;
                    }
                }
            }
            bufferedReader.close();
            return arrayList;
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
            e.printStackTrace();
            if (bufferedReader != null) {
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static Bitmap drawable2Bitmap(Drawable drawable) {
        return UtilsBridge.drawable2Bitmap(drawable);
    }

    public static Drawable bitmap2Drawable(Bitmap bitmap) {
        return UtilsBridge.bitmap2Drawable(bitmap);
    }

    public static Bitmap view2Bitmap(View view) {
        return UtilsBridge.view2Bitmap(view);
    }

    public static int dp2px(float f) {
        return UtilsBridge.dp2px(f);
    }

    public static int px2dp(float f) {
        return UtilsBridge.px2dp(f);
    }

    public static int sp2px(float f) {
        return UtilsBridge.sp2px(f);
    }

    public static int px2sp(float f) {
        return UtilsBridge.px2sp(f);
    }

    private static String getSafeCharset(String str) {
        return (UtilsBridge.isSpace(str) || !Charset.isSupported(str)) ? "UTF-8" : str;
    }
}
