package com.alibaba.baichuan.trade.common.adapter.mtop.a;

import com.alibaba.baichuan.trade.common.Environment;
import com.alibaba.baichuan.trade.common.adapter.mtop.AlibcNetWork;
import com.alibaba.baichuan.trade.common.adapter.mtop.NetworkClient;
import com.alibaba.baichuan.trade.common.adapter.mtop.NetworkRequest;
import com.alibaba.baichuan.trade.common.adapter.mtop.NetworkResponse;

public class a implements AlibcNetWork {
    @Override // com.alibaba.baichuan.trade.common.adapter.mtop.AlibcNetWork
    public void changeEnvMode(Environment environment) {
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.mtop.AlibcNetWork
    public int init() {
        return 1;
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.mtop.NetworkClient
    public NetworkResponse sendRequest(NetworkRequest networkRequest) {
        return null;
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.mtop.NetworkClient
    public boolean sendRequest(NetworkClient.JSNetworkRequestListener jSNetworkRequestListener, NetworkRequest networkRequest) {
        return false;
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.mtop.NetworkClient
    public boolean sendRequest(NetworkClient.NetworkRequestListener networkRequestListener, NetworkRequest networkRequest) {
        return false;
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.mtop.AlibcNetWork
    public void setTTID(String str) {
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.mtop.AlibcNetWork
    public void turnOffDebug() {
    }

    @Override // com.alibaba.baichuan.trade.common.adapter.mtop.AlibcNetWork
    public void turnOnDebug() {
    }
}
