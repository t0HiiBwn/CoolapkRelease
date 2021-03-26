package com.tencent.beacon.core.protocol.event;

import com.tencent.beacon.core.wup.JceStruct;
import com.tencent.beacon.core.wup.a;
import com.tencent.beacon.core.wup.b;
import java.util.ArrayList;
import java.util.Collection;

public final class EventRecordPackage extends JceStruct implements Cloneable {
    static ArrayList<EventRecord> cache_list;
    public ArrayList<EventRecord> list = null;

    @Override // com.tencent.beacon.core.wup.JceStruct
    public final void writeTo(b bVar) {
        bVar.a((Collection) this.list, 0);
    }

    @Override // com.tencent.beacon.core.wup.JceStruct
    public final void readFrom(a aVar) {
        if (cache_list == null) {
            cache_list = new ArrayList<>();
            cache_list.add(new EventRecord());
        }
        this.list = (ArrayList) aVar.a((a) cache_list, 0, true);
    }
}
