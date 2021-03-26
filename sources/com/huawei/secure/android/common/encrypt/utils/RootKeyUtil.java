package com.huawei.secure.android.common.encrypt.utils;

import android.os.Build;

public class RootKeyUtil {
    private static final String TAG = "RootKeyUtil";
    private byte[] S = null;

    private RootKeyUtil() {
    }

    public static RootKeyUtil newInstance(String str, String str2, String str3, String str4) {
        RootKeyUtil rootKeyUtil = new RootKeyUtil();
        rootKeyUtil.a(str, str2, str3, str4);
        return rootKeyUtil;
    }

    public static RootKeyUtil newInstance(String str, String str2, String str3, byte[] bArr) {
        RootKeyUtil rootKeyUtil = new RootKeyUtil();
        rootKeyUtil.a(str, str2, str3, bArr);
        return rootKeyUtil;
    }

    private void a(String str, String str2, String str3, String str4) {
        a(str, str2, str3, HexUtil.hexStr2ByteArray(str4));
    }

    public byte[] getRootKey() {
        return (byte[]) this.S.clone();
    }

    public String getRootKeyHex() {
        return HexUtil.byteArray2HexStr(this.S);
    }

    private void a(String str, String str2, String str3, byte[] bArr) {
        if (Build.VERSION.SDK_INT < 26) {
            b.d(TAG, "initRootKey: sha1");
            this.S = BaseKeyUtil.exportRootKey(str, str2, str3, bArr, false);
            return;
        }
        b.d(TAG, "initRootKey: sha256");
        this.S = BaseKeyUtil.exportRootKey(str, str2, str3, bArr, true);
    }
}
