package com.alibaba.baichuan.trade.common.adapter.ut.impl;

import com.alibaba.baichuan.trade.common.adapter.ut.AlibcBaseUserTracker;
import com.alibaba.baichuan.trade.common.adapter.ut.a.a;
import java.util.Map;

public class AplusUserTracker extends AlibcBaseUserTracker {
    public static SpmTranslator translator = new SpmTranslator();

    @Override // com.alibaba.baichuan.trade.common.adapter.ut.AlibcBaseUserTracker
    public boolean init() {
        return true;
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.ut.AlibcBaseUserTracker
    public void sendCustomHit(String str, String str2, long j, Map<String, String> map) {
        a a = a.a();
        SpmTranslator spmTranslator = translator;
        a.a(spmTranslator == null ? "" : spmTranslator.getSpm(str)).b("mini").a(j).b().c(str2).a(map).c();
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.ut.AlibcBaseUserTracker
    public void sendCustomHit(String str, String str2, Map<String, String> map) {
        sendCustomHit(str, str2, 60, map);
    }
}
