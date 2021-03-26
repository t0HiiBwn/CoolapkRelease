package com.alibaba.baichuan.android.trade.page;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeContext;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeTaokeParam;
import com.alibaba.baichuan.trade.biz.core.route.base.UrlRequest;
import com.alibaba.baichuan.trade.biz.core.taoke.AlibcPidTaokeComponent;
import com.alibaba.baichuan.trade.biz.core.taoke.AlibcTaokeTraceCallback;
import com.alibaba.baichuan.trade.biz.core.usertracker.UserTrackerConstants;
import com.alibaba.baichuan.trade.common.adapter.security.AlibcSecurityGuard;
import java.util.HashMap;

public class AlibcAddCartPage extends AlibcBasePage {
    private String b;

    public AlibcAddCartPage(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.b = !str.matches("^\\d+$") ? String.valueOf(AlibcSecurityGuard.getInstance().analyzeItemId(str)) : str;
        }
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
        String str = AlibcContext.TB_ITEM_DETAIL_URL;
        int indexOf = str.indexOf(63);
        if (indexOf > 0) {
            str = str.substring(0, indexOf);
        }
        this.a = Uri.parse(String.format(str + "?id=%s", String.valueOf(this.b))).buildUpon().appendQueryParameter("action_tae", "cart").appendQueryParameter("from_tae", "true").fragment("sku").build().toString();
        return this.a;
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public String genOpenUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return super.genOpenUrl(str);
        }
        int indexOf = str.indexOf(63);
        if (indexOf > 0) {
            str = str.substring(0, indexOf);
        }
        return Uri.parse(String.format(str + "?id=%s", String.valueOf(this.b))).buildUpon().appendQueryParameter("action_tae", "cart").appendQueryParameter("from_tae", "true").fragment("sku").build().toString();
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public String getApi() {
        return UserTrackerConstants.E_ADDITEM2CART;
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public String getPerformancePageType() {
        return "addCart";
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public String getUsabilityPageType() {
        return "04";
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public boolean needTaoke(AlibcTradeTaokeParam alibcTradeTaokeParam) {
        return alibcTradeTaokeParam != null && alibcTradeTaokeParam.isPidExist();
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public int requireOpenType() {
        return 2;
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public boolean supportAid() {
        return false;
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public void taokeTraceAndGenUrl(AlibcTradeTaokeParam alibcTradeTaokeParam, UrlRequest urlRequest, AlibcTradeContext alibcTradeContext, AlibcTaokeTraceCallback alibcTaokeTraceCallback) {
        String str = this.b;
        if (str != null && !TextUtils.isEmpty(str)) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("itemId", this.b);
            AlibcPidTaokeComponent.INSTANCE.genUrlAndTaokeTrace(hashMap, urlRequest.getUrl(), false, alibcTradeTaokeParam, getApi(), alibcTaokeTraceCallback);
        }
    }
}
