package com.tencent.beacon.core.event;

import android.util.Base64;
import com.tencent.beacon.event.UserAction;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: SensorEventData */
public final class m implements Runnable {
    private Map<String, List<Float>> a = new HashMap();

    private static String a(List<Float> list) {
        ByteBuffer allocate = ByteBuffer.allocate(list.size() << 2);
        for (Float f : list) {
            allocate.putFloat(f.floatValue());
        }
        return Base64.encodeToString(allocate.array(), 0);
    }

    public final void a(String str, float[] fArr) {
        List<Float> list = this.a.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.a.put(str, list);
        }
        for (float f : fArr) {
            list.add(Float.valueOf(f));
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<Float>> entry : this.a.entrySet()) {
            String replace = a(entry.getValue()).replace("=", "%3D").replace("/", "%2F").replace("+", "%2B").replace("\n", "");
            String key = entry.getKey();
            hashMap.put(key, replace + ";");
        }
        UserAction.onUserAction("rqd_sensor", true, -1, -1, hashMap, true, true);
    }
}
