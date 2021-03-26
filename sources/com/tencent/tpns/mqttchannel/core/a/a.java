package com.tencent.tpns.mqttchannel.core.a;

import com.tencent.tpns.mqttchannel.core.common.b.b;
import com.tencent.tpns.mqttchannel.services.BaseMqttClientService;

/* compiled from: ProGuard */
public class a extends b.a {
    private BaseMqttClientService a;

    public a(BaseMqttClientService baseMqttClientService) {
        this.a = baseMqttClientService;
    }

    @Override // com.tencent.tpns.mqttchannel.core.common.b.b
    public void a(boolean z) {
        this.a.onConnectComplete(z);
    }

    @Override // com.tencent.tpns.mqttchannel.core.common.b.b
    public void a() {
        this.a.onConnectionLost();
    }

    @Override // com.tencent.tpns.mqttchannel.core.common.b.b
    public void b() {
        this.a.onHeartBeat();
    }

    @Override // com.tencent.tpns.mqttchannel.core.common.b.b
    public void a(com.tencent.tpns.mqttchannel.core.common.a.a aVar) {
        this.a.onMessageArrived(aVar.b(), aVar.c());
    }
}
