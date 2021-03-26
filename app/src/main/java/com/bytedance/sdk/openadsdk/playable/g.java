package com.bytedance.sdk.openadsdk.playable;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;

/* compiled from: SensorHub */
public class g {
    private static SensorManager a;

    private static int a(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3) {
            return i;
        }
        return 2;
    }

    private static SensorManager b(Context context) {
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    a = (SensorManager) context.getSystemService("sensor");
                }
            }
        }
        return a;
    }

    public static void a(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener != null && context != null) {
            try {
                SensorManager b = b(context);
                b.registerListener(sensorEventListener, b.getDefaultSensor(1), a(i));
            } catch (Throwable th) {
                d.a("SensorHub", "startListenAccelerometer error", th);
            }
        }
    }

    public static void b(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener != null && context != null) {
            try {
                SensorManager b = b(context);
                b.registerListener(sensorEventListener, b.getDefaultSensor(4), a(i));
            } catch (Throwable th) {
                d.a("SensorHub", "startListenGyroscope error", th);
            }
        }
    }

    public static void a(Context context, SensorEventListener sensorEventListener) {
        if (sensorEventListener != null && context != null) {
            try {
                b(context).unregisterListener(sensorEventListener);
            } catch (Throwable th) {
                d.a("SensorHub", "stopListen error", th);
            }
        }
    }

    public static void a(Context context) {
        if (context != null) {
            ((Vibrator) context.getSystemService("vibrator")).vibrate(300);
        }
    }
}
