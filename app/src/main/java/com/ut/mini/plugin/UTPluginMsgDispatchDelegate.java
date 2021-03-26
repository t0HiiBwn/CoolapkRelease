package com.ut.mini.plugin;

public abstract class UTPluginMsgDispatchDelegate {
    private Object g = null;

    public boolean isMatchPlugin(UTPlugin uTPlugin) {
        return true;
    }

    public final Object getMsgObj() {
        return this.g;
    }

    public UTPluginMsgDispatchDelegate(Object obj) {
        this.g = obj;
    }

    public Object getDispatchObject(UTPlugin uTPlugin) {
        return this.g;
    }
}
