package com.alibaba.baichuan.android.trade.page;

import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeTaokeParam;
import com.alibaba.baichuan.trade.biz.core.usertracker.UserTrackerConstants;

public class AlibcMyCartsPage extends AlibcBasePage {
    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public String genOpenUrl() {
        return AlibcContext.SHOW_CART_URL;
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public String genOpenUrl(String str) {
        return super.genOpenUrl(str);
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public String getApi() {
        return UserTrackerConstants.E_SHOWCART;
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public String getPerformancePageType() {
        return "myCart";
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public String getUsabilityPageType() {
        return "05";
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public boolean isBackWhenLoginFail() {
        return true;
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public boolean needTaoke(AlibcTradeTaokeParam alibcTradeTaokeParam) {
        return false;
    }
}
