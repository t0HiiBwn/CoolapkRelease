package com.pgl.sys.ces.out;

import android.content.Context;
import com.pgl.sys.ces.b;

public class StcSDKLiteFactory {
    private static ISdkLite a;

    public static ISdkLite getInstance() {
        return a;
    }

    @Deprecated
    public static ISdkLite getSDK(Context context, String str) {
        if (a == null) {
            synchronized (StcSDKLiteFactory.class) {
                if (a == null) {
                    a = b.a(context, str, 255, null);
                }
            }
        }
        return a;
    }

    public static ISdkLite getSDK(Context context, String str, int i) {
        if (a == null) {
            synchronized (StcSDKLiteFactory.class) {
                if (a == null) {
                    a = b.a(context, str, i, null);
                }
            }
        }
        return a;
    }

    public static ISdkLite getSDK(Context context, String str, int i, ISdkInfo iSdkInfo) {
        if (a == null) {
            synchronized (StcSDKLiteFactory.class) {
                if (a == null) {
                    a = b.a(context, str, i, iSdkInfo);
                }
            }
        }
        return a;
    }
}
