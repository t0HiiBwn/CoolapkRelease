package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.os.Environment;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import java.io.File;
import java.io.FileInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: UTDIdTracker */
public class l extends a {
    private static final String a = "utdid";
    private static final String b = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final Pattern c = Pattern.compile("UTDID\">([^<]+)");
    private Context d;

    public l(Context context) {
        super("utdid");
        this.d = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            if (FieldManager.allow("header_tracking_utdid")) {
                return (String) Class.forName("com.ut.device.UTDevice").getMethod("getUtdid", Context.class).invoke(null, this.d);
            }
            return null;
        } catch (Exception unused) {
            if (FieldManager.allow("header_tracking_utdid")) {
                return g();
            }
            return null;
        }
    }

    private String g() {
        File h = h();
        if (h != null && h.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(h);
                try {
                    return b(HelperUtils.readStreamToString(fileInputStream));
                } finally {
                    HelperUtils.safeClose(fileInputStream);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private String b(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = c.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private File h() {
        if (DeviceConfig.checkPermission(this.d, "android.permission.WRITE_EXTERNAL_STORAGE") && Environment.getExternalStorageState().equals("mounted")) {
            try {
                return new File(Environment.getExternalStorageDirectory().getCanonicalPath(), ".UTSystemConfig/Global/Alvin2.xml");
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
