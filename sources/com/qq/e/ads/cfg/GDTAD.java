package com.qq.e.ads.cfg;

import android.content.Context;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;

public class GDTAD {
    private static boolean a;
    private static InitListener b;
    private static PM.a.AbstractC0086a c = new PM.a.AbstractC0086a() {
        /* class com.qq.e.ads.cfg.GDTAD.AnonymousClass1 */

        @Override // com.qq.e.comm.managers.plugin.PM.a.AbstractC0086a
        public final void onLoadFail() {
            GDTLogger.w("Init fail", null);
        }

        @Override // com.qq.e.comm.managers.plugin.PM.a.AbstractC0086a
        public final void onLoadSuccess() {
            boolean unused = GDTAD.a = true;
            if (GDTAD.b != null) {
                GDTAD.b.onSuccess();
            }
        }
    };

    public interface InitListener {
        void onSuccess();
    }

    public static void initSDK(Context context, String str, InitListener initListener) {
        if (a) {
            GDTLogger.w("SDK已经被初始化过", null);
        } else if (context == null) {
            GDTLogger.e("Context参数不能为null");
        } else if (StringUtil.isEmpty(str)) {
            GDTLogger.e("AppId参数不能为空");
        } else {
            b = initListener;
            GDTADManager instance = GDTADManager.getInstance();
            instance.setPluginLoadListener(c);
            instance.initWith(context.getApplicationContext(), str);
        }
    }
}
