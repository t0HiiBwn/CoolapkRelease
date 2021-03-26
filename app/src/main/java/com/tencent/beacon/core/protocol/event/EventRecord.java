package com.tencent.beacon.core.protocol.event;

import com.tencent.beacon.core.wup.JceStruct;
import com.tencent.beacon.core.wup.a;
import com.tencent.beacon.core.wup.b;

public final class EventRecord extends JceStruct implements Cloneable {
    public String apn = "";
    public long cosumeTime = 0;
    public String eventName = "";
    public boolean eventResult = true;
    public long eventTime = 0;
    public int eventType = 0;
    public String eventValue = "";
    public long packageSize = 0;
    public String srcIp = "";

    @Override // com.tencent.beacon.core.wup.JceStruct
    public final void writeTo(b bVar) {
        bVar.a(this.apn, 0);
        bVar.a(this.srcIp, 1);
        bVar.a(this.eventName, 2);
        bVar.a(this.eventResult, 3);
        bVar.a(this.packageSize, 4);
        bVar.a(this.cosumeTime, 5);
        bVar.a(this.eventValue, 6);
        bVar.a(this.eventTime, 7);
        bVar.a(this.eventType, 8);
    }

    @Override // com.tencent.beacon.core.wup.JceStruct
    public final void readFrom(a aVar) {
        this.apn = aVar.b(0, true);
        this.srcIp = aVar.b(1, true);
        this.eventName = aVar.b(2, true);
        this.eventResult = aVar.a(3, true);
        this.packageSize = aVar.a(this.packageSize, 4, true);
        this.cosumeTime = aVar.a(this.cosumeTime, 5, true);
        this.eventValue = aVar.b(6, true);
        this.eventTime = aVar.a(this.eventTime, 7, true);
        this.eventType = aVar.a(this.eventType, 8, false);
    }
}
