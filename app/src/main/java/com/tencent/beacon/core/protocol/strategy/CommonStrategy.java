package com.tencent.beacon.core.protocol.strategy;

import com.tencent.beacon.core.wup.JceStruct;
import com.tencent.beacon.core.wup.a;
import com.tencent.beacon.core.wup.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class CommonStrategy extends JceStruct {
    static Map<String, String> cache_cloudParas;
    static ArrayList<ModuleStrategy> cache_moduleList;
    public Map<String, String> cloudParas = null;
    public ArrayList<ModuleStrategy> moduleList = null;
    public int queryInterval = 0;
    public String url = "";

    public CommonStrategy() {
    }

    public CommonStrategy(ArrayList<ModuleStrategy> arrayList, int i, String str, Map<String, String> map) {
        this.moduleList = arrayList;
        this.queryInterval = i;
        this.url = str;
        this.cloudParas = map;
    }

    @Override // com.tencent.beacon.core.wup.JceStruct
    public final void writeTo(b bVar) {
        bVar.a((Collection) this.moduleList, 0);
        bVar.a(this.queryInterval, 1);
        bVar.a(this.url, 2);
        Map<String, String> map = this.cloudParas;
        if (map != null) {
            bVar.a((Map) map, 3);
        }
    }

    @Override // com.tencent.beacon.core.wup.JceStruct
    public final void readFrom(a aVar) {
        if (cache_moduleList == null) {
            cache_moduleList = new ArrayList<>();
            cache_moduleList.add(new ModuleStrategy());
        }
        this.moduleList = (ArrayList) aVar.a((a) cache_moduleList, 0, true);
        this.queryInterval = aVar.a(this.queryInterval, 1, true);
        this.url = aVar.b(2, true);
        if (cache_cloudParas == null) {
            HashMap hashMap = new HashMap();
            cache_cloudParas = hashMap;
            hashMap.put("", "");
        }
        this.cloudParas = (Map) aVar.a((a) cache_cloudParas, 3, false);
    }
}
