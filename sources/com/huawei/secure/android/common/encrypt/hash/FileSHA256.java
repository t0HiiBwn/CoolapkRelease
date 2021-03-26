package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.a;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class FileSHA256 {
    private static final String TAG = "FileSHA256";
    private static final String i = "";
    private static final int p = 8192;
    private static final String q = "SHA-256";
    private static final String[] r = {"SHA-256", "SHA-384", "SHA-512"};

    public static String fileSHA256Encrypt(File file) {
        return fileSHAEncrypt(file, "SHA-256");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0039 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:9:0x001f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static String fileSHAEncrypt(File file, String str) {
        Throwable th;
        NoSuchAlgorithmException e;
        IOException e2;
        ?? r1 = "";
        if (TextUtils.isEmpty(str) || !d(str)) {
            b.f(TAG, "algorithm is empty or not safe");
            return r1;
        } else if (!a(file)) {
            b.f(TAG, "file is not valid");
            return r1;
        } else {
            String str2 = null;
            str2 = null;
            InputStream inputStream = null;
            str2 = null;
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                r1 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    boolean z = false;
                    while (true) {
                        int read = r1.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                        z = true;
                    }
                    if (z) {
                        str2 = HexUtil.byteArray2HexStr(instance.digest());
                    }
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                    r1 = r1;
                    b.f(TAG, "NoSuchAlgorithmException" + e.getMessage());
                    a.a((InputStream) r1);
                    return str2;
                } catch (IOException e4) {
                    e2 = e4;
                    r1 = r1;
                    b.f(TAG, "IOException" + e2.getMessage());
                    a.a((InputStream) r1);
                    return str2;
                }
            } catch (NoSuchAlgorithmException e5) {
                e = e5;
                r1 = 0;
                b.f(TAG, "NoSuchAlgorithmException" + e.getMessage());
                a.a((InputStream) r1);
                return str2;
            } catch (IOException e6) {
                e2 = e6;
                r1 = 0;
                b.f(TAG, "IOException" + e2.getMessage());
                a.a((InputStream) r1);
                return str2;
            } catch (Throwable th2) {
                th = th2;
                inputStream = r1;
                a.a(inputStream);
                throw th;
            }
            a.a((InputStream) r1);
            return str2;
        }
    }

    public static String inputStreamSHA256Encrypt(InputStream inputStream) {
        return inputStream == null ? "" : inputStreamSHAEncrypt(inputStream, "SHA-256");
    }

    public static String inputStreamSHAEncrypt(InputStream inputStream, String str) {
        if (inputStream == null) {
            return "";
        }
        byte[] bArr = new byte[8192];
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            while (true) {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    return HexUtil.byteArray2HexStr(instance.digest());
                }
                if (read > 0) {
                    instance.update(bArr, 0, read);
                }
            }
        } catch (IOException | NoSuchAlgorithmException unused) {
            b.f(TAG, "inputstraem exception");
            return "";
        } finally {
            a.a(inputStream);
        }
    }

    public static boolean validateFileSHA256(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(fileSHA256Encrypt(file));
    }

    public static boolean validateFileSHA(File file, String str, String str2) {
        if (!TextUtils.isEmpty(str) && d(str2)) {
            return str.equals(fileSHAEncrypt(file, str2));
        }
        b.f(TAG, "hash value is null || algorithm is illegal");
        return false;
    }

    public static boolean validateInputStreamSHA256(InputStream inputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(inputStreamSHA256Encrypt(inputStream));
    }

    public static boolean validateInputStreamSHA(InputStream inputStream, String str, String str2) {
        if (!TextUtils.isEmpty(str) && d(str2)) {
            return str.equals(inputStreamSHAEncrypt(inputStream, str2));
        }
        b.f(TAG, "hash value is null || algorithm is illegal");
        return false;
    }

    private static boolean a(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    private static boolean d(String str) {
        for (String str2 : r) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
