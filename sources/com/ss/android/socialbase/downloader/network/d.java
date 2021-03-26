package com.ss.android.socialbase.downloader.network;

/* compiled from: ExponentialGeometricAverage */
class d {
    private final double a;
    private final int b;
    private double c = -1.0d;
    private int d;

    public d(double d2) {
        int i;
        this.a = d2;
        if (d2 == 0.0d) {
            i = Integer.MAX_VALUE;
        } else {
            i = (int) Math.ceil(1.0d / d2);
        }
        this.b = i;
    }

    public void a(double d2) {
        double d3 = 1.0d - this.a;
        int i = this.d;
        if (i > this.b) {
            this.c = Math.exp((d3 * Math.log(this.c)) + (this.a * Math.log(d2)));
        } else if (i > 0) {
            double d4 = (d3 * ((double) i)) / (((double) i) + 1.0d);
            this.c = Math.exp((d4 * Math.log(this.c)) + ((1.0d - d4) * Math.log(d2)));
        } else {
            this.c = d2;
        }
        this.d++;
    }

    public double a() {
        return this.c;
    }
}
