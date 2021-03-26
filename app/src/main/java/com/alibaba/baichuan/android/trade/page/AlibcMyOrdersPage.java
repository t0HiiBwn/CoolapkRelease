package com.alibaba.baichuan.android.trade.page;

import android.text.TextUtils;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeTaokeParam;
import com.alibaba.baichuan.trade.biz.core.usertracker.UserTrackerConstants;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;

public class AlibcMyOrdersPage extends AlibcBasePage {
    public static final String[] ORDER_TYPE = {"all", "waitPay", "waitSend", "waitConfirm", "waitRate"};
    public static final String TAB_CODE = "?tabCode=%s";
    int b;
    boolean c;

    public AlibcMyOrdersPage(int i, boolean z) {
        this.b = i;
        this.c = z;
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public boolean checkParams() {
        int i = this.b;
        return i >= 0 && i <= 4;
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public String genOpenUrl() {
        String str;
        if (this.a != null && !TextUtils.isEmpty(this.a)) {
            return this.a;
        }
        String str2 = AlibcContext.MY_ORDERS_URL;
        int indexOf = str2.indexOf(63);
        if (indexOf > 0) {
            str2 = str2.substring(0, indexOf);
        }
        String str3 = str2 + "?tabCode=%s";
        int i = this.b;
        if (i < 0 || i >= 5) {
            str = str3.substring(0, str3.indexOf("?"));
        } else if (!this.c) {
            str = String.format(str3 + "&condition={\"extra\":{\"attributes\":{\"ttid\":\"%s\"}}}", ORDER_TYPE[this.b], AlibcTradeCommon.getAppKey());
        } else {
            str = String.format(str3, ORDER_TYPE[i]);
        }
        this.a = str;
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
        String str2 = str + "?tabCode=%s";
        int i = this.b;
        if (i < 0 || i >= 5) {
            return str2.substring(0, str2.indexOf("?"));
        }
        if (this.c) {
            return String.format(str2, ORDER_TYPE[i]);
        }
        return String.format(str2 + "&condition={\"extra\":{\"attributes\":{\"ttid\":\"%s\"}}}", ORDER_TYPE[this.b], AlibcTradeCommon.getAppKey());
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public String getApi() {
        return UserTrackerConstants.E_SHOWORDER;
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public String getPerformancePageType() {
        return "myOrder";
    }

    @Override // com.alibaba.baichuan.android.trade.page.AlibcBasePage
    public String getUsabilityPageType() {
        return "03";
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
