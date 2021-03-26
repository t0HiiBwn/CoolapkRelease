package com.tencent.tpns.baseapi.base.security;

import android.content.Context;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.io.File;

/* compiled from: ProGuard */
public class Security {
    private static final String TAG = "Security";
    private static boolean loadedTpnsSecuritySo = false;
    public static final String tpnsSecurityLibFullName = "libxgVipSecurity.so";
    private static final String tpnsSecurityLibName = "xgVipSecurity";

    public static native byte[] doDecryptSrvData(byte[] bArr);

    public static native byte[] doEncryptSrvData(byte[] bArr);

    public static native String generateLocalSocketServieNameNative(Object obj);

    public static native String getBusinessDeviceIdNative(Object obj);

    public static native String getEncryptAPKSignatureNative(Object obj);

    public static native byte[] oiSymmetryDecrypt2Byte(byte[] bArr);

    public static native byte[] oiSymmetryEncrypt2Byte(String str);

    static {
        try {
            System.loadLibrary("xgVipSecurity");
            loadedTpnsSecuritySo = true;
        } catch (Throwable th) {
            TBaseLogger.e("Security", "can not load library,error:", th);
            loadedTpnsSecuritySo = false;
        }
    }

    public static boolean checkTpnsSecurityLibSo(Context context) {
        if (loadedTpnsSecuritySo) {
            return true;
        }
        if (context != null) {
            String str = "";
            try {
                str = context.getDir("lib", 0).getParentFile().getAbsolutePath() + File.separator + "lib" + File.separator + "libxgVipSecurity.so";
                System.load(str);
                loadedTpnsSecuritySo = true;
            } catch (Throwable th) {
                loadedTpnsSecuritySo = false;
                TBaseLogger.e("Security", "can not load library from " + str + ",error:" + th);
            }
        }
        return loadedTpnsSecuritySo;
    }

    private static String toCharsString(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length * 2)];
        for (int i = 0; i < length; i++) {
            byte b = bArr[i];
            int i2 = (b >> 4) & 15;
            int i3 = i * 2;
            cArr[i3] = (char) (i2 >= 10 ? (i2 + 97) - 10 : i2 + 48);
            int i4 = b & 15;
            cArr[i3 + 1] = (char) (i4 >= 10 ? (i4 + 97) - 10 : i4 + 48);
        }
        return new String(cArr);
    }

    public static byte[] encryptSrvData(byte[] bArr) {
        TBaseLogger.ii("Security", "---encrypt---");
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    byte[] doEncryptSrvData = doEncryptSrvData(bArr);
                    if (doEncryptSrvData != null) {
                        return doEncryptSrvData;
                    }
                    TBaseLogger.ee("Security", ">> encryptSrvData: encrypt failed!");
                    return null;
                }
            } catch (Throwable th) {
                TBaseLogger.e("Security", ">> encryptSrvData: throwable", th);
                return null;
            }
        }
        TBaseLogger.ee("Security", ">> encryptSrvData: input text is empty");
        return null;
    }

    public static byte[] decryptSrvData(byte[] bArr) {
        TBaseLogger.ii("Security", "---decrypt---");
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    byte[] doDecryptSrvData = doDecryptSrvData(bArr);
                    if (doDecryptSrvData != null) {
                        return doDecryptSrvData;
                    }
                    TBaseLogger.ee("Security", ">> decryptSrvData: decrypt failed!");
                    return null;
                }
            } catch (Throwable th) {
                TBaseLogger.e("Security", ">> decryptSrvData: throwable", th);
                return null;
            }
        }
        TBaseLogger.ee("Security", ">> decryptSrvData: encData is empty");
        return null;
    }
}
