package com.alibaba.baichuan.android.trade.page;

import android.text.TextUtils;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.trade.biz.applink.AlibcApplinkData;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeTaokeParam;
import com.alibaba.baichuan.trade.biz.core.usertracker.UserTrackerConstants;

public class AlibcShopPage extends AlibcBasePage {
    private String b;
    private String c;

    public AlibcShopPage(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.b = str;
        }
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public boolean checkParams() {
        String str = this.b;
        return str != null && !TextUtils.isEmpty(str);
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public String genOpenUrl() {
        String str = this.c;
        if (str != null && !TextUtils.isEmpty(str)) {
            return this.c;
        }
        String str2 = AlibcContext.TB_SHOP_URL;
        int indexOf = str2.indexOf(63);
        if (indexOf > 0) {
            str2 = str2.substring(0, indexOf);
        }
        String format = String.format(str2 + "?shop_id=%s", this.b);
        this.c = format;
        return format;
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
        return String.format(str + "?shop_id=%s", this.b);
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public String getApi() {
        return UserTrackerConstants.E_SHOWSHOP;
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public AlibcApplinkData getApplinkData() {
        return new AlibcApplinkData(2, this.b);
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public String getPerformancePageType() {
        return "shop";
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public String getUsabilityPageType() {
        return "02";
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public boolean needTaoke(AlibcTradeTaokeParam alibcTradeTaokeParam) {
        return alibcTradeTaokeParam != null && alibcTradeTaokeParam.isAdZoneIdExist();
    }
}
