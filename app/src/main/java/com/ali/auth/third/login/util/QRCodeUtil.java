package com.ali.auth.third.login.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.HashMap;

public class QRCodeUtil {
    private static Class a;
    private static Method b;
    private static Method c;
    private static Object d;
    private static Object e;

    static {
        try {
            d = a("com.google.zxing.BarcodeFormat", "QR_CODE");
            e = a("com.google.zxing.EncodeHintType", "MARGIN");
            a = Class.forName("com.google.zxing.qrcode.QRCodeWriter");
            b = Class.forName("com.google.zxing.common.BitMatrix").getMethod("get", Integer.TYPE, Integer.TYPE);
            Method[] declaredMethods = a.getDeclaredMethods();
            for (Method method : declaredMethods) {
                if (method.getName().equals("encode") && method.getParameterTypes().length == 5) {
                    c = method;
                    return;
                }
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private static Object a(String str, String str2) {
        Method method = Enum.class.getMethod("name", new Class[0]);
        Object[] enumConstants = Class.forName(str).getEnumConstants();
        for (Object obj : enumConstants) {
            if (str2.equals(method.invoke(obj, new Object[0]))) {
                return obj;
            }
        }
        return null;
    }

    public static Bitmap createQRCodeBitmap(String str, int i, int i2, String str2) {
        return createQRCodeBitmap(str, i, i2, "UTF-8", str2, "0", -16777216, -1);
    }

    public static Bitmap createQRCodeBitmap(String str, int i, int i2, String str2, String str3, String str4, int i3, int i4) {
        if (TextUtils.isEmpty(str) || i < 0 || i2 < 0) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put(e, str4);
            }
            Object invoke = c.invoke(a.newInstance(), str, d, Integer.valueOf(i), Integer.valueOf(i2), hashMap);
            int[] iArr = new int[(i * i2)];
            for (int i5 = 0; i5 < i2; i5++) {
                for (int i6 = 0; i6 < i; i6++) {
                    if (((Boolean) b.invoke(invoke, Integer.valueOf(i6), Integer.valueOf(i5))).booleanValue()) {
                        iArr[(i5 * i) + i6] = i3;
                    } else {
                        iArr[(i5 * i) + i6] = i4;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
            return createBitmap;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
