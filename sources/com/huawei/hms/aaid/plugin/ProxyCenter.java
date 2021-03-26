package com.huawei.hms.aaid.plugin;

public class ProxyCenter {
    private PushProxy proxy;

    static class a {
        private static ProxyCenter a = new ProxyCenter();
    }

    public static ProxyCenter getInstance() {
        return a.a;
    }

    public PushProxy getProxy() {
        return this.proxy;
    }

    public void register(PushProxy pushProxy) {
        this.proxy = pushProxy;
    }
}
