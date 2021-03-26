package com.tencent.av;

public class PingResult {
    int receivePkg;
    ServerInfo server;
    int totalPkg;
    int useTime;

    public ServerInfo getServer() {
        return this.server;
    }

    public void setServer(ServerInfo serverInfo) {
        this.server = serverInfo;
    }

    public int getUseTime() {
        return this.useTime;
    }

    public void setUseTime(int i) {
        this.useTime = i;
    }

    public int getTotalPkg() {
        return this.totalPkg;
    }

    public void setTotalPkg(int i) {
        this.totalPkg = i;
    }

    public int getReceivePkg() {
        return this.receivePkg;
    }

    public void setReceivePkg(int i) {
        this.receivePkg = i;
    }
}
