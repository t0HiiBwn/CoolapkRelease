package com.alibaba.baichuan.trade.biz.core.route;

import android.text.TextUtils;
import com.alibaba.baichuan.trade.biz.core.config.model.ConfigDO;
import com.alibaba.baichuan.trade.biz.core.route.base.ConfigParse;
import com.alibaba.baichuan.trade.biz.core.route.base.UrlRequest;
import com.alibaba.baichuan.trade.biz.core.route.base.UrlTypeUtil;
import com.alibaba.baichuan.trade.biz.core.route.callback.ParseCallback;
import com.alibaba.baichuan.trade.biz.core.route.callback.RequestBuildCallback;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.util.HashMap;

public class d implements ConfigParse {
    private ConfigParse a;

    @Override // com.alibaba.baichuan.trade.biz.core.route.base.ConfigParse
    public UrlRequest handleParse(ConfigDO configDO, UrlRequest urlRequest, RequestBuildCallback requestBuildCallback, ParseCallback parseCallback) {
        int i;
        String url = urlRequest.getUrl();
        if (url == null || url.length() == 0) {
            requestBuildCallback.onBuildFail(1600);
            return null;
        }
        if (configDO != null) {
            String verifyUrlType = UrlTypeUtil.verifyUrlType(url, configDO);
            HashMap<String, Object> fields = urlRequest.getFields();
            if (TextUtils.isEmpty(verifyUrlType)) {
                verifyUrlType = "h5";
            }
            fields.put("urlType", verifyUrlType);
            ConfigParse configParse = this.a;
            if (configParse != null) {
                configParse.handleParse(configDO, urlRequest, requestBuildCallback, parseCallback);
                return urlRequest;
            }
            i = 2000;
        } else {
            AlibcLogger.i("UrlTypeConfigParseImpl", "配置数据获取为空");
            i = 1100;
        }
        requestBuildCallback.onBuildFail(i);
        return null;
    }

    @Override // com.alibaba.baichuan.trade.biz.core.route.base.ConfigParse
    public void setSuccessor(ConfigParse configParse) {
        this.a = configParse;
    }
}
