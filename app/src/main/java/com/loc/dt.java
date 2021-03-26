package com.loc;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;

/* compiled from: AmapSensorManager */
public final class dt implements SensorEventListener {
    SensorManager a = null;
    Sensor b = null;
    Sensor c = null;
    Sensor d = null;
    public boolean e = false;
    public double f = 0.0d;
    public float g = 0.0f;
    Handler h = new Handler();
    double i = 0.0d;
    double j = 0.0d;
    double k = 0.0d;

    /* renamed from: l  reason: collision with root package name */
    double f1366l = 0.0d;
    double[] m = new double[3];
    volatile double n = 0.0d;
    long o = 0;
    long p = 0;
    final int q = 100;
    final int r = 30;
    private Context s = null;
    private float t = 1013.25f;
    private float u = 0.0f;

    public dt(Context context) {
        try {
            this.s = context;
            if (this.a == null) {
                this.a = (SensorManager) context.getSystemService("sensor");
            }
            try {
                this.b = this.a.getDefaultSensor(6);
            } catch (Throwable unused) {
            }
            try {
                this.c = this.a.getDefaultSensor(11);
            } catch (Throwable unused2) {
            }
            try {
                this.d = this.a.getDefaultSensor(1);
            } catch (Throwable unused3) {
            }
        } catch (Throwable th) {
            ej.a(th, "AMapSensorManager", "<init>");
        }
    }

    public final void a() {
        SensorManager sensorManager = this.a;
        if (sensorManager != null && !this.e) {
            this.e = true;
            try {
                Sensor sensor = this.b;
                if (sensor != null) {
                    sensorManager.registerListener(this, sensor, 3, this.h);
                }
            } catch (Throwable th) {
                ej.a(th, "AMapSensorManager", "registerListener mPressure");
            }
            try {
                Sensor sensor2 = this.c;
                if (sensor2 != null) {
                    this.a.registerListener(this, sensor2, 3, this.h);
                }
            } catch (Throwable th2) {
                ej.a(th2, "AMapSensorManager", "registerListener mRotationVector");
            }
            try {
                Sensor sensor3 = this.d;
                if (sensor3 != null) {
                    this.a.registerListener(this, sensor3, 3, this.h);
                }
            } catch (Throwable th3) {
                ej.a(th3, "AMapSensorManager", "registerListener mAcceleroMeterVector");
            }
        }
    }

    public final void b() {
        SensorManager sensorManager = this.a;
        if (sensorManager != null && this.e) {
            this.e = false;
            try {
                Sensor sensor = this.b;
                if (sensor != null) {
                    sensorManager.unregisterListener(this, sensor);
                }
            } catch (Throwable unused) {
            }
            try {
                Sensor sensor2 = this.c;
                if (sensor2 != null) {
                    this.a.unregisterListener(this, sensor2);
                }
            } catch (Throwable unused2) {
            }
            try {
                Sensor sensor3 = this.d;
                if (sensor3 != null) {
                    this.a.unregisterListener(this, sensor3);
                }
            } catch (Throwable unused3) {
            }
        }
    }

    public final float c() {
        return this.u;
    }

    public final double d() {
        return this.f1366l;
    }

    public final void e() {
        try {
            b();
            this.b = null;
            this.c = null;
            this.a = null;
            this.d = null;
            this.e = false;
        } catch (Throwable th) {
            ej.a(th, "AMapSensorManager", "destroy");
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr;
        if (sensorEvent != null) {
            try {
                int type = sensorEvent.sensor.getType();
                if (type != 1) {
                    if (type == 6) {
                        try {
                            if (this.b != null) {
                                float[] fArr2 = (float[]) sensorEvent.values.clone();
                                if (fArr2 != null) {
                                    this.g = fArr2[0];
                                }
                                if (fArr2 != null) {
                                    this.f = (double) ep.a(SensorManager.getAltitude(this.t, fArr2[0]));
                                }
                            }
                        } catch (Throwable unused) {
                        }
                    } else if (type == 11) {
                        try {
                            if (this.c != null && (fArr = (float[]) sensorEvent.values.clone()) != null) {
                                float[] fArr3 = new float[9];
                                SensorManager.getRotationMatrixFromVector(fArr3, fArr);
                                float[] fArr4 = new float[3];
                                SensorManager.getOrientation(fArr3, fArr4);
                                float degrees = (float) Math.toDegrees((double) fArr4[0]);
                                this.u = degrees;
                                if (degrees <= 0.0f) {
                                    degrees += 360.0f;
                                }
                                this.u = (float) Math.floor((double) degrees);
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                } else if (this.d != null) {
                    float[] fArr5 = (float[]) sensorEvent.values.clone();
                    double[] dArr = this.m;
                    dArr[0] = (dArr[0] * 0.800000011920929d) + ((double) (fArr5[0] * 0.19999999f));
                    dArr[1] = (dArr[1] * 0.800000011920929d) + ((double) (fArr5[1] * 0.19999999f));
                    dArr[2] = (dArr[2] * 0.800000011920929d) + ((double) (fArr5[2] * 0.19999999f));
                    this.i = ((double) fArr5[0]) - dArr[0];
                    this.j = ((double) fArr5[1]) - dArr[1];
                    this.k = ((double) fArr5[2]) - dArr[2];
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.o >= 100) {
                        double d2 = this.i;
                        double d3 = this.j;
                        double d4 = (d2 * d2) + (d3 * d3);
                        double d5 = this.k;
                        double sqrt = Math.sqrt(d4 + (d5 * d5));
                        this.p++;
                        this.o = currentTimeMillis;
                        this.n += sqrt;
                        if (this.p >= 30) {
                            this.f1366l = this.n / ((double) this.p);
                            this.n = 0.0d;
                            this.p = 0;
                        }
                    }
                }
            } catch (Throwable unused3) {
            }
        }
    }
}
