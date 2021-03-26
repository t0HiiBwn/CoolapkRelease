package com.tencent.open.web.security;

import com.tencent.open.a;
import com.tencent.open.a.f;

/* compiled from: ProGuard */
public class SecureJsInterface extends a.b {
    public static boolean isPWDEdit;
    private String a;

    @Override // com.tencent.open.a.b
    public boolean customCallback() {
        return true;
    }

    public void curPosFromJS(String str) {
        int i;
        f.b("openSDK_LOG.SecureJsInterface", "-->curPosFromJS: " + str);
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            f.b("openSDK_LOG.SecureJsInterface", "-->curPosFromJS number format exception.", e);
            i = -1;
        }
        if (i >= 0) {
            boolean z = a.c;
            if (!a.b) {
                String str2 = a.a;
                this.a = str2;
                JniInterface.insetTextToArray(i, str2, str2.length());
                f.a("openSDK_LOG.SecureJsInterface", "curPosFromJS mKey: " + this.a);
            } else if (Boolean.valueOf(JniInterface.BackSpaceChar(a.b, i)).booleanValue()) {
                a.b = false;
            }
        } else {
            throw new RuntimeException("position is illegal.");
        }
    }

    public void isPasswordEdit(String str) {
        int i;
        f.c("openSDK_LOG.SecureJsInterface", "-->is pswd edit, flag: " + str);
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {
            f.e("openSDK_LOG.SecureJsInterface", "-->is pswd edit exception: " + e.getMessage());
            i = -1;
        }
        if (i != 0 && i != 1) {
            throw new RuntimeException("is pswd edit flag is illegal.");
        } else if (i == 0) {
            isPWDEdit = false;
        } else if (i == 1) {
            isPWDEdit = true;
        }
    }

    public void clearAllEdit() {
        f.c("openSDK_LOG.SecureJsInterface", "-->clear all edit.");
        try {
            JniInterface.clearAllPWD();
        } catch (Exception e) {
            f.e("openSDK_LOG.SecureJsInterface", "-->clear all edit exception: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public String getMD5FromNative() {
        f.c("openSDK_LOG.SecureJsInterface", "-->get md5 form native");
        try {
            String pWDKeyToMD5 = JniInterface.getPWDKeyToMD5(null);
            f.a("openSDK_LOG.SecureJsInterface", "-->getMD5FromNative, MD5= " + pWDKeyToMD5);
            return pWDKeyToMD5;
        } catch (Exception e) {
            f.e("openSDK_LOG.SecureJsInterface", "-->get md5 form native exception: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
