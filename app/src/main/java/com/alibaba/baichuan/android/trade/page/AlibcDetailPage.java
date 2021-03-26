package com.alibaba.baichuan.android.trade.page;

import android.text.TextUtils;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.trade.biz.applink.AlibcApplinkData;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeContext;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeTaokeParam;
import com.alibaba.baichuan.trade.biz.core.route.base.UrlRequest;
import com.alibaba.baichuan.trade.biz.core.taoke.AlibcPidTaokeComponent;
import com.alibaba.baichuan.trade.biz.core.taoke.AlibcTaokeTraceCallback;
import com.alibaba.baichuan.trade.biz.core.usertracker.UserTrackerConstants;
import com.alibaba.baichuan.trade.common.adapter.security.AlibcSecurityGuard;
import java.util.HashMap;

public class AlibcDetailPage extends AlibcBasePage {
    private String b;

    public AlibcDetailPage(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.b = !str.matches("^\\d+$") ? String.valueOf(AlibcSecurityGuard.getInstance().analyzeItemId(str)) : str;
        }
    }

    protected String a() {
        return AlibcContext.SHOUTAO_ITEM_DETAIL_URL;
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public boolean checkParams() {
        String str = this.b;
        return str != null && !TextUtils.isEmpty(str);
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public String genOpenUrl() {
        if (this.a != null && !TextUtils.isEmpty(this.a)) {
            return this.a;
        }
        String a = a();
        if (!TextUtils.isEmpty(a)) {
            int indexOf = a.indexOf(63);
            if (indexOf > 0) {
                a = a.substring(0, indexOf);
            }
            this.a = String.format(a + "?id=%s", this.b);
        }
        return this.a;
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public String genOpenUrl(String str) {
        String str2;
        StringBuilder sb;
        if (TextUtils.isEmpty(str)) {
            return super.genOpenUrl(str);
        }
        if (str.indexOf("?") > 0) {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "&id=%s";
        } else {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "?id=%s";
        }
        sb.append(str2);
        return String.format(sb.toString(), this.b);
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public String getApi() {
        return UserTrackerConstants.E_SHOWITEMDETAIL;
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public AlibcApplinkData getApplinkData() {
        return new AlibcApplinkData(1, this.b);
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public String getPerformancePageType() {
        return "detail";
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public String getUsabilityPageType() {
        return "01";
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public boolean needTaoke(AlibcTradeTaokeParam alibcTradeTaokeParam) {
        return alibcTradeTaokeParam != null;
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public void taokeTraceAndGenUrl(AlibcTradeTaokeParam alibcTradeTaokeParam, UrlRequest urlRequest, AlibcTradeContext alibcTradeContext, AlibcTaokeTraceCallback alibcTaokeTraceCallback) {
        String str = this.b;
        if (str != null && !TextUtils.isEmpty(str)) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("itemId", this.b);
            if (alibcTaokeTraceCallback != null) {
                AlibcPidTaokeComponent.INSTANCE.genUrlAndTaokeTrace(hashMap, urlRequest.getUrl(), true, alibcTradeTaokeParam, getApi(), alibcTaokeTraceCallback);
            }
        }
    }
}
