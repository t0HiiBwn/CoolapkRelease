package com.tencent.beacon.core.event;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.beacon.core.d.b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SensorReporter */
public final class n implements SensorEventListener, Runnable {
    private static Map<Integer, String> f;
    private long a = 0;
    private m b;
    private int c = 0;
    private long d = 0;
    private Context e;
    private SensorManager g;

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    static {
        HashMap hashMap = new HashMap();
        f = hashMap;
        hashMap.put(1, "A126");
        f.put(4, "A127");
        f.put(2, "A128");
    }

    public final void a(Context context) {
        if (d.a().n()) {
            this.e = context;
            int u = d.a().u();
            b.a("[sensor] startEvent consuming : %d", Integer.valueOf(u));
            this.d = d.a().s();
            com.tencent.beacon.core.a.b.a().a(111, this, 10000, (long) (u * 1000));
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        m mVar;
        if (this.c <= 0) {
            this.b = null;
            b.a("[sensor] unregisterSensorListener", new Object[0]);
            SensorManager sensorManager = this.g;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
                return;
            }
            return;
        }
        if (System.currentTimeMillis() - this.a >= this.d && (mVar = this.b) != null) {
            com.tencent.beacon.core.a.b.a().a(mVar);
            this.a = System.currentTimeMillis();
            this.b = null;
            int i = this.c - 1;
            this.c = i;
            b.a("[sensor] report sensor event and %d times left ", Integer.valueOf(i));
        }
        if (this.b == null) {
            this.b = new m();
        }
        this.b.a(f.get(Integer.valueOf(sensorEvent.sensor.getType())), sensorEvent.values);
    }

    public static void a() {
        com.tencent.beacon.core.a.b.a().a(111, true);
        b.a("[sensor] cancel next record", new Object[0]);
    }

    @Override // java.lang.Runnable
    public final void run() {
        SensorManager sensorManager = (SensorManager) this.e.getSystemService("sensor");
        this.g = sensorManager;
        if (sensorManager != null) {
            d a2 = d.a();
            int t = 1000000 / a2.t();
            if (a2.o()) {
                b.a("[sensor] AcceleEnable", new Object[0]);
                SensorManager sensorManager2 = this.g;
                sensorManager2.registerListener(this, sensorManager2.getDefaultSensor(1), t);
            }
            if (a2.p()) {
                b.a("[sensor] GyroEnable", new Object[0]);
                SensorManager sensorManager3 = this.g;
                sensorManager3.registerListener(this, sensorManager3.getDefaultSensor(4), t);
            }
            if (a2.q()) {
                b.a("[sensor] MagneticEnable", new Object[0]);
                SensorManager sensorManager4 = this.g;
                sensorManager4.registerListener(this, sensorManager4.getDefaultSensor(2), t);
            }
        }
        this.a = System.currentTimeMillis();
        this.c = d.a().r();
        b.a("[sensor] start a record", new Object[0]);
    }
}
