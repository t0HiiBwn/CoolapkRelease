package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import org.json.JSONObject;

public class UMSLEnvelopeBuild {
    private static final String TAG = "UMSLEnvelopeBuild";
    private static boolean isEncryptEnabled;
    public static Context mContext;
    public static String module;

    public static boolean isReadyBuildNew(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        return false;
    }

    public JSONObject buildSLEnvelope(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        return null;
    }

    public JSONObject buildSLBaseHeader(final Context context) {
        new Thread() {
            /* class com.umeng.commonsdk.stateless.UMSLEnvelopeBuild.AnonymousClass1 */

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    Looper.prepare();
                    Toast.makeText(context.getApplicationContext(), "基础组件库9.4.0版本仅支持6.2.0及更高版本推送SDK、7.1.0及更高版本分享SDK。", 1).show();
                    Looper.loop();
                } catch (Throwable unused) {
                }
            }
        }.start();
        Log.e("UMLog", "基础组件库9.4.0版本仅支持6.2.0及更高版本推送SDK、7.1.0及更高版本分享SDK。");
        return null;
    }

    public static void setEncryptEnabled(boolean z) {
        isEncryptEnabled = z;
    }
}
