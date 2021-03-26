package com.coolapk.market.util.uri;

import android.content.Context;
import android.net.Uri;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeResult;
import com.coolapk.market.AppHolder;
import com.coolapk.market.util.LogUtils;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"com/coolapk/market/util/uri/TaoBaoAction$takeAction$1", "Lcom/alibaba/baichuan/android/trade/callback/AlibcTradeCallback;", "onFailure", "", "code", "", "msg", "", "onTradeSuccess", "p0", "Lcom/alibaba/baichuan/trade/biz/context/AlibcTradeResult;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TaoBaoAction.kt */
public final class TaoBaoAction$takeAction$1 implements AlibcTradeCallback {
    final /* synthetic */ Context $context;
    final /* synthetic */ Uri $uri;

    TaoBaoAction$takeAction$1(Context context, Uri uri) {
        this.$context = context;
        this.$uri = uri;
    }

    @Override // com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback
    public void onTradeSuccess(AlibcTradeResult alibcTradeResult) {
        LogUtils.d("TAOBAO_ACTION 调用成功 " + alibcTradeResult, new Object[0]);
    }

    @Override // com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback
    public void onFailure(int i, String str) {
        LogUtils.d("TAOBAO_ACTION 调用失败  code=" + i + ", msg=" + str, new Object[0]);
        AppHolder.getMainThreadHandler().post(new TaoBaoAction$takeAction$1$onFailure$1(this));
    }
}
