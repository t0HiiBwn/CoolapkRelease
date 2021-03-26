package com.alibaba.baichuan.android.trade.miniapp.handler;

import android.content.Context;
import com.alibaba.baichuan.trade.biz.core.config.model.ActionDO;
import com.alibaba.baichuan.trade.biz.core.route.base.UrlRequest;
import java.util.List;

public class c extends b {
    private d b;
    private a c;
    private UrlRequest d;

    public c(Context context, UrlRequest urlRequest) {
        super(context);
        UrlHandler aVar;
        this.d = urlRequest;
        List<ActionDO> actionPriorityList = urlRequest.getActionPriorityList();
        if (actionPriorityList == null || actionPriorityList.size() == 0) {
            b();
            return;
        }
        for (ActionDO actionDO : actionPriorityList) {
            String openType = actionDO.getOpenType();
            if ("native".equals(openType)) {
                aVar = new d();
            } else if ("h5".equals(openType) || "miniapp".equals(openType)) {
                aVar = new a();
            }
            a(aVar);
        }
    }

    private void b() {
        this.b = new d();
        this.c = new a();
        a(this.b);
        a(this.c);
    }
}
