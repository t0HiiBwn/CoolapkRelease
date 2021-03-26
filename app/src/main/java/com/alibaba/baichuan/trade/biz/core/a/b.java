package com.alibaba.baichuan.trade.biz.core.a;

import com.alibaba.baichuan.trade.biz.core.jsbridge.plugin.AlibcPluginManager;

public class b {
    public static void a() {
        AlibcPluginManager.registerPlugin(a.a, a.class, true);
        AlibcPluginManager.registerPlugin("AliBCNetWork", d.class, true);
        AlibcPluginManager.registerPlugin("AliBCUserTrack", e.class, true);
        AlibcPluginManager.registerPlugin(c.b, c.class, true);
    }
}
