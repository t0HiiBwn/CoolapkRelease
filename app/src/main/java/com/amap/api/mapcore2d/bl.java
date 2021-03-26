package com.amap.api.mapcore2d;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.WindowManager;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.Marker;

/* compiled from: SensorEventHelper */
public class bl implements SensorEventListener {
    private SensorManager a;
    private Sensor b;
    private long c = 0;
    private final int d = 100;
    private float e;
    private Context f;
    private y g;
    private Marker h;
    private boolean i = true;

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public bl(Context context, y yVar) {
        this.f = context.getApplicationContext();
        this.g = yVar;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.a = sensorManager;
            this.b = sensorManager.getDefaultSensor(3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a() {
        Sensor sensor;
        SensorManager sensorManager = this.a;
        if (sensorManager != null && (sensor = this.b) != null) {
            sensorManager.registerListener(this, sensor, 3);
        }
    }

    public void b() {
        Sensor sensor;
        SensorManager sensorManager = this.a;
        if (sensorManager != null && (sensor = this.b) != null) {
            sensorManager.unregisterListener(this, sensor);
        }
    }

    public void a(Marker marker) {
        this.h = marker;
    }

    public void a(boolean z) {
        this.i = z;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (System.currentTimeMillis() - this.c >= 100) {
                if (sensorEvent.sensor.getType() == 3) {
                    float a2 = (sensorEvent.values[0] + ((float) a(this.f))) % 360.0f;
                    if (a2 > 180.0f) {
                        a2 -= 360.0f;
                    } else if (a2 < -180.0f) {
                        a2 += 360.0f;
                    }
                    if (Math.abs(this.e - a2) >= 3.0f) {
                        if (Float.isNaN(a2)) {
                            a2 = 0.0f;
                        }
                        this.e = a2;
                        Marker marker = this.h;
                        if (marker != null) {
                            try {
                                if (this.i) {
                                    CameraPosition cameraPosition = this.g.getCameraPosition();
                                    this.g.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(cameraPosition.target, cameraPosition.zoom, cameraPosition.tilt, this.e)));
                                    this.h.setRotateAngle(-this.e);
                                } else {
                                    marker.setRotateAngle(360.0f - a2);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                        this.c = System.currentTimeMillis();
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static int a(Context context) {
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation == 1) {
            return 90;
        }
        if (rotation != 2) {
            return rotation != 3 ? 0 : -90;
        }
        return 180;
    }
}
