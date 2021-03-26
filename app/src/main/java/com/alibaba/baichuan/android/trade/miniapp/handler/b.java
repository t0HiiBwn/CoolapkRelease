package com.alibaba.baichuan.android.trade.miniapp.handler;

import android.content.Context;
import com.alibaba.baichuan.android.trade.miniapp.listener.UrlCallBack;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeContext;
import com.alibaba.baichuan.trade.biz.core.route.base.UrlRequest;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.util.Iterator;

public class b extends UrlHandler {
    private static final String c = "b";
    public e<UrlHandler> a = new e<>();
    private final Context b;

    public class a implements UrlCallBack {
        private final UrlRequest b;

        public a(UrlRequest urlRequest) {
            this.b = urlRequest;
        }

        @Override // com.alibaba.baichuan.android.trade.miniapp.listener.UrlCallBack
        public void a(int i) {
            if (i == 200) {
                String str = b.c;
                AlibcLogger.i(str, "handle success -- result code = " + i);
                return;
            }
            String str2 = b.c;
            AlibcLogger.e(str2, "handle fail -- result code = " + i);
        }

        @Override // com.alibaba.baichuan.android.trade.miniapp.listener.UrlCallBack
        public void a(boolean z, UrlRequest urlRequest) {
            a(400);
        }
    }

    public b(Context context) {
        this.b = context.getApplicationContext();
    }

    /* access modifiers changed from: private */
    public void a(final Iterator<UrlHandler> it2, UrlRequest urlRequest, final UrlCallBack urlCallBack, final AlibcTradeContext alibcTradeContext, final com.alibaba.baichuan.android.trade.miniapp.a aVar, boolean z) {
        if (it2.hasNext()) {
            it2.next().a(urlRequest, new UrlCallBack() {
                /* class com.alibaba.baichuan.android.trade.miniapp.handler.b.AnonymousClass1 */

                @Override // com.alibaba.baichuan.android.trade.miniapp.listener.UrlCallBack
                public void a(int i) {
                    urlCallBack.a(i);
                }

                @Override // com.alibaba.baichuan.android.trade.miniapp.listener.UrlCallBack
                public void a(boolean z, UrlRequest urlRequest) {
                    if (!z) {
                        b.this.a(new a());
                    }
                    b.this.a(it2, urlRequest, urlCallBack, alibcTradeContext, aVar, z);
                }
            }, alibcTradeContext, aVar, z);
        }
    }

    public b a(UrlHandler urlHandler) {
        return a(urlHandler, 0);
    }

    public b a(UrlHandler urlHandler, int i) {
        this.a.a(urlHandler, i);
        return this;
    }

    public void a(UrlRequest urlRequest, AlibcTradeContext alibcTradeContext, com.alibaba.baichuan.android.trade.miniapp.a aVar) {
        a(urlRequest, new a(urlRequest), alibcTradeContext, aVar, true);
    }

    @Override // com.alibaba.baichuan.android.trade.miniapp.handler.UrlHandler
    protected void handleInternal(UrlRequest urlRequest, UrlCallBack urlCallBack, AlibcTradeContext alibcTradeContext, com.alibaba.baichuan.android.trade.miniapp.a aVar) {
        a(this.a.iterator(), urlRequest, urlCallBack, alibcTradeContext, aVar, true);
    }

    @Override // com.alibaba.baichuan.android.trade.miniapp.handler.UrlHandler
    protected boolean shouldHandle(UrlRequest urlRequest, AlibcTradeContext alibcTradeContext, com.alibaba.baichuan.android.trade.miniapp.a aVar, boolean z) {
        return !this.a.isEmpty();
    }
}
