package com.alibaba.alibclinkpartner.linkpartner;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.alibclinkpartner.linkpartner.param.ALPJumpFailedStrategy;
import com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPDetailParam;
import com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPShopParam;
import com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPTBJumpParam;
import com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPURIParam;
import com.alibaba.alibclinkpartner.smartlink.ALSLSmartLinkSDK;
import com.alibaba.alibclinkpartner.smartlink.callback.ALPSmartLinkCallback;
import com.alibaba.alibclinkpartner.smartlink.config.ALSLConfigration;
import com.alibaba.alibclinkpartner.smartlink.config.ALSLContext;
import com.alibaba.alibclinkpartner.smartlink.data.MatrixAppInfoDetail;
import com.alibaba.alibclinkpartner.smartlink.manager.ALSLAppCheckManager;

public class ALPTBLinkPartnerSDK extends b {
    public static volatile boolean isSupportJumpFailedOpenTaobao;

    public interface JumpIntentProcessor {
        boolean process(Intent intent, String str, String str2, Context context);
    }

    private static void a(ALPTBJumpParam aLPTBJumpParam) {
        String str;
        if (aLPTBJumpParam != null && !TextUtils.isEmpty(aLPTBJumpParam.linkKey)) {
            if (aLPTBJumpParam.linkKey.equals("taobao_scheme")) {
                str = "taobao";
            } else if (aLPTBJumpParam.linkKey.equals("tmall_scheme")) {
                str = "tmall";
            } else {
                return;
            }
            aLPTBJumpParam.linkKey = str;
        }
    }

    public static boolean isSupportLinkKey(String str) {
        MatrixAppInfoDetail matrixAppInfoDetail;
        if (!ALSLContext.instance().isInit() || str == null) {
            return false;
        }
        if (str.equals("taobao_scheme")) {
            str = "taobao";
        } else if (str.equals("tmall_scheme")) {
            str = "tmall";
        }
        return (ALSLConfigration.sMatrixAPPData == null || ALSLConfigration.sMatrixAPPData.appinfo == null || (matrixAppInfoDetail = ALSLConfigration.sMatrixAPPData.appinfo.get(str)) == null || !ALSLAppCheckManager.isAppCanOpen(ALSLContext.instance().mContext, matrixAppInfoDetail.packageName)) ? false : true;
    }

    @Deprecated
    public static void jumpDetail(Context context, ALPDetailParam aLPDetailParam, ALPJumpFailedStrategy aLPJumpFailedStrategy, ALPSmartLinkCallback aLPSmartLinkCallback) {
        a(aLPDetailParam);
        a.a(context, aLPDetailParam, aLPJumpFailedStrategy, aLPSmartLinkCallback);
    }

    @Deprecated
    public static void jumpShop(Context context, ALPShopParam aLPShopParam, ALPJumpFailedStrategy aLPJumpFailedStrategy, ALPSmartLinkCallback aLPSmartLinkCallback) {
        a(aLPShopParam);
        a.a(context, aLPShopParam, aLPJumpFailedStrategy, aLPSmartLinkCallback);
    }

    @Deprecated
    public static void jumpURI(Context context, ALPURIParam aLPURIParam, ALPJumpFailedStrategy aLPJumpFailedStrategy, ALPSmartLinkCallback aLPSmartLinkCallback) {
        a(aLPURIParam);
        a.a(context, aLPURIParam, aLPJumpFailedStrategy, aLPSmartLinkCallback);
    }

    public static void setDebugStatus(boolean z, boolean z2) {
        ALSLSmartLinkSDK.turnOnDebug(z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0007, code lost:
        if (r2 != 3) goto L_0x000e;
     */
    public static void setEnvironment(int i) {
        if (i != 1) {
            int i2 = 2;
            if (i != 2) {
                i2 = 3;
            }
            ALSLContext.setEnvironment(i2);
            return;
        }
        ALSLContext.setEnvironment(1);
    }

    public static void setSupportJumpFailedOpenTaobao(boolean z) {
        isSupportJumpFailedOpenTaobao = z;
    }

    public static int setTTID(String str) {
        if (!ALSLContext.instance().isInit()) {
            if (TextUtils.isEmpty(str)) {
                return 100213;
            }
        } else if (TextUtils.isEmpty(str)) {
            return 100213;
        }
        ALSLContext.instance().tempVal = str;
        return 100102;
    }
}
