package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.os.AsyncTask;
import com.huawei.secure.android.common.ssl.util.BksUtil;
import com.huawei.secure.android.common.ssl.util.c;
import com.huawei.secure.android.common.ssl.util.e;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Objects;

public class SSFSecureX509SingleInstance {
    private static volatile SecureX509TrustManager B = null;
    private static final String TAG = "SSFSecureX509SingleInstance";

    private SSFSecureX509SingleInstance() {
    }

    public static SecureX509TrustManager getInstance(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        Objects.requireNonNull(context, "context is null");
        c.setContext(context);
        if (B == null) {
            synchronized (SSFSecureX509SingleInstance.class) {
                if (B == null) {
                    InputStream filesBksIS = BksUtil.getFilesBksIS(context);
                    if (filesBksIS == null) {
                        g.c(TAG, "get assets bks");
                        filesBksIS = context.getAssets().open("hmsrootcas.bks");
                    } else {
                        g.c(TAG, "get files bks");
                    }
                    B = new SecureX509TrustManager(filesBksIS, "", true);
                    if (!(B == null || B.getAcceptedIssuers() == null)) {
                        String str = TAG;
                        g.c(str, "first load , ca size is : " + B.getAcceptedIssuers().length);
                    }
                    new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, context);
                }
            }
        }
        return B;
    }

    public static void updateBks(InputStream inputStream) {
        String str = TAG;
        g.c(str, "update bks");
        if (inputStream != null && B != null) {
            B = new SecureX509TrustManager(inputStream, "", true);
            SSFCompatiableSystemCA.a(B);
            SASFCompatiableSystemCA.a(B);
            if (B != null && B.getAcceptedIssuers() != null) {
                g.b(str, "after updata bks , ca size is : " + B.getAcceptedIssuers().length);
            }
        }
    }
}
