package com.pgl.sys.ces.b;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public final class b implements SensorEventListener {
    private static b f;
    private SensorManager a = null;
    private int b;
    private int c = 0;
    private float[] d = new float[3];
    private List<String> e = new ArrayList();

    private b(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            try {
                this.a = (SensorManager) applicationContext.getSystemService("sensor");
            } catch (Throwable unused) {
            }
        }
    }

    public static b a(Context context) {
        if (f == null) {
            synchronized (b.class) {
                if (f == null) {
                    f = new b(context);
                }
            }
        }
        return f;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    private synchronized void d() {
        SensorManager sensorManager = this.a;
        if (sensorManager != null) {
            if (this.b == 0) {
                if (!this.a.registerListener(this, sensorManager.getDefaultSensor(1), 3)) {
                    return;
                }
            }
            this.b++;
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    private synchronized void e() {
        SensorManager sensorManager = this.a;
        if (sensorManager != null) {
            int i = this.b - 1;
            this.b = i;
            if (i == 0) {
                sensorManager.unregisterListener(this);
            }
        }
    }

    public String a() {
        StringBuilder sb;
        String str = null;
        try {
            d();
            synchronized (this) {
                int i = 0;
                while (this.c == 0 && i < 10) {
                    i++;
                    wait(100);
                }
            }
            try {
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                sb = new StringBuilder();
                sb.append(decimalFormat.format((double) this.d[0]));
                sb.append(",");
                sb.append(decimalFormat.format((double) this.d[1]));
                sb.append(",");
                sb.append(decimalFormat.format((double) this.d[2]));
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            DecimalFormat decimalFormat2 = new DecimalFormat("0.0");
            sb = new StringBuilder();
            sb.append(decimalFormat2.format((double) this.d[0]));
            sb.append(",");
            sb.append(decimalFormat2.format((double) this.d[1]));
            sb.append(",");
            sb.append(decimalFormat2.format((double) this.d[2]));
        }
        str = sb.toString();
        e();
        this.c = 0;
        return str;
    }

    public void b() {
        String a2 = a();
        if (a2 != null) {
            this.e.add(a2);
            try {
                int size = this.e.size();
                if (size > 20) {
                    ArrayList arrayList = new ArrayList(this.e.subList(size - 10, size));
                    this.e.clear();
                    this.e = arrayList;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized String c() {
        String str = "";
        int size = this.e.size();
        if (size <= 0) {
            return str;
        }
        if (size == 1) {
            return this.e.get(0);
        }
        try {
            List<String> list = this.e;
            int i = size - 10;
            if (i <= 0) {
                i = 0;
            }
            List<String> subList = list.subList(i, size);
            for (int i2 = 0; i2 < subList.size(); i2++) {
                str = str + subList.get(i2) + "|";
            }
            str = str.substring(0, str.length() - 1);
        } catch (Throwable unused) {
        }
        return str;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        this.d = sensorEvent.values;
        this.c = 1;
    }
}
