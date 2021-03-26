package com.alibaba.alibclinkpartner.linkpartner;

import android.content.Context;
import com.alibaba.alibclinkpartner.linkpartner.param.ALPJumpFailedStrategy;
import com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPDetailParam;
import com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPShopParam;
import com.alibaba.alibclinkpartner.linkpartner.param.jump.ALPTBJumpParam;
import com.alibaba.alibclinkpartner.smartlink.ALSLSmartLinkSDK;
import com.alibaba.alibclinkpartner.smartlink.callback.ALPSmartLinkCallback;
import com.alibaba.alibclinkpartner.smartlink.config.ALSLUri;

public class a {
    public static void a(Context context, ALPTBJumpParam aLPTBJumpParam, ALPJumpFailedStrategy aLPJumpFailedStrategy, ALPSmartLinkCallback aLPSmartLinkCallback) {
        ALSLUri.ALSLdegradeType aLSLdegradeType;
        ALSLUri aLSLUri = new ALSLUri();
        aLSLUri.url = aLPTBJumpParam.getBackUpH5Url();
        aLSLUri.module = aLPTBJumpParam.getModule();
        aLSLUri.target = aLPTBJumpParam.linkKey;
        aLSLUri.degradeH5Url = aLPTBJumpParam.h5Url;
        aLSLUri.backUrl = aLPTBJumpParam.backUrl;
        aLSLUri.packageName = aLPTBJumpParam.packageName;
        aLSLUri.intentProcessor = aLPTBJumpParam.intentProcessor;
        aLSLUri.extraParam.putAll(aLPTBJumpParam.extraParams);
        aLSLUri.extraParam.put("visa", aLPTBJumpParam.visa);
        aLSLUri.bcFlSrc = aLPTBJumpParam.bcFlSrc;
        if (aLPTBJumpParam != null && (aLPTBJumpParam instanceof ALPDetailParam)) {
            aLSLUri.extraParam.put("itemId", ((ALPDetailParam) aLPTBJumpParam).itemID);
        }
        if (aLPTBJumpParam != null && (aLPTBJumpParam instanceof ALPShopParam)) {
            aLSLUri.extraParam.put("shopId", ((ALPShopParam) aLPTBJumpParam).shopID);
        }
        if (aLPJumpFailedStrategy != null) {
            if (aLPJumpFailedStrategy.mode == 5) {
                aLSLdegradeType = ALSLUri.ALSLdegradeType.NONE;
            } else if (aLPJumpFailedStrategy.mode == 4 || aLPJumpFailedStrategy.mode == 6) {
                aLSLdegradeType = ALSLUri.ALSLdegradeType.H5;
            } else if (aLPJumpFailedStrategy.mode == 3) {
                aLSLdegradeType = ALSLUri.ALSLdegradeType.Download;
            }
            aLSLUri.degradeType = aLSLdegradeType;
        }
        ALSLSmartLinkSDK.openUrl(context, aLSLUri, aLPSmartLinkCallback);
    }
}
