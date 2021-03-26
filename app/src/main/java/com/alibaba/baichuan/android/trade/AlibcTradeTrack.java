package com.alibaba.baichuan.android.trade;

import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders;

public class AlibcTradeTrack {
    public static final String AlibcTradeEventId_ContentClick = "BAICHUAN_CONTENT_CLICK";
    public static final String AlibcTradeEventId_Exposure = "BAICHUAN_EXPOSURE";

    public static class a {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        private String f;
    }

    public static void addTraceLog(String str, a aVar) {
        UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder(str);
        uTCustomHitBuilder.setEventPage(aVar.d);
        uTCustomHitBuilder.setProperty("scm", aVar.a);
        uTCustomHitBuilder.setProperty("pvid", aVar.b);
        uTCustomHitBuilder.setProperty("puid", aVar.c);
        uTCustomHitBuilder.setProperty("pguid", aVar.f);
        uTCustomHitBuilder.setProperty("page", aVar.d);
        uTCustomHitBuilder.setProperty("label", aVar.e);
        UTAnalytics.getInstance().getDefaultTracker().send(uTCustomHitBuilder.build());
    }
}
