package com.alibaba.baichuan.android.trade.page;

import android.text.TextUtils;
import com.alibaba.baichuan.android.trade.usertracker.monitor.a;
import com.alibaba.baichuan.trade.biz.applink.AlibcApplinkData;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeContext;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeTaokeParam;
import com.alibaba.baichuan.trade.biz.core.route.base.UrlRequest;
import com.alibaba.baichuan.trade.biz.core.taoke.AlibcTaokeTraceCallback;
import com.alibaba.baichuan.trade.biz.core.usertracker.UserTrackerConstants;
import com.alibaba.baichuan.trade.biz.urlroute.AlibcUriContext;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.util.Map;

public class AlibcBasePage {
    public static final int NOT_REQUIRE = 0;
    public static final int REQUIRE_H5 = 2;
    public static final int REQUIRE_MINIAPP = 3;
    public static final int REQUIRE_NATIVE = 1;
    protected String a;

    public boolean checkParams() {
        return true;
    }

    public String genOpenUrl() {
        if (!TextUtils.isEmpty(this.a)) {
            return this.a;
        }
        return null;
    }

    public String genOpenUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return null;
    }

    public String getAddParamsUrl(String str, Map<String, String> map, a aVar) {
        AlibcLogger.d("AlibcBasePage", "首次进入加参，参数： urlParams = " + map + "  url=" + str);
        if (aVar != null) {
            aVar.g();
        }
        if (!AlibcUriContext.isTradeAddParamURL(str)) {
            if (aVar != null) {
                aVar.h();
            }
            return str;
        }
        String addParamsUrl = new AlibcUriContext(str).getAddParamsUrl(map);
        if (aVar != null) {
            aVar.h();
        }
        return addParamsUrl;
    }

    public String getAddParamsUrl(Map<String, String> map, a aVar) {
        return getAddParamsUrl(null, map, aVar);
    }

    public Map<String, String> getAdditionalHttpHeaders() {
        return null;
    }

    public String getApi() {
        return UserTrackerConstants.E_SHOW;
    }

    public AlibcApplinkData getApplinkData() {
        return new AlibcApplinkData(3, genOpenUrl());
    }

    public String getPerformancePageType() {
        return "url";
    }

    public String getUsabilityPageType() {
        return "07";
    }

    public boolean isBackWhenLoginFail() {
        return false;
    }

    public boolean needTaoke(AlibcTradeTaokeParam alibcTradeTaokeParam) {
        return false;
    }

    public int requireOpenType() {
        return 0;
    }

    public boolean supportAid() {
        return true;
    }

    public void taokeTraceAndGenUrl(AlibcTradeTaokeParam alibcTradeTaokeParam, UrlRequest urlRequest, AlibcTradeContext alibcTradeContext, AlibcTaokeTraceCallback alibcTaokeTraceCallback) {
    }
}
