package com.ss.android.socialbase.downloader.f;

import org.json.JSONObject;

/* compiled from: SegmentStrategy */
public class n {
    private final JSONObject a;
    private int b;

    private n(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public void a(int i) {
        this.b = b(i);
    }

    public int a() {
        return this.b;
    }

    private int o() {
        return this.a.optInt("url_balance", 2);
    }

    public boolean b() {
        return o() > 0;
    }

    public boolean c() {
        return o() == 1;
    }

    public int d() {
        return this.a.optInt("buffer_count", 512);
    }

    public int e() {
        return this.a.optInt("buffer_size", 8192);
    }

    public boolean f() {
        return this.a.optInt("segment_mode", 1) == 0;
    }

    public long g() {
        long optInt = ((long) this.a.optInt("segment_min_kb", 512)) * 1024;
        if (optInt < 65536) {
            return 65536;
        }
        return optInt;
    }

    public long h() {
        long optInt = ((long) this.a.optInt("segment_max_kb", 0)) * 1048576;
        if (optInt < g()) {
            return -1;
        }
        return optInt;
    }

    public long i() {
        long optInt = (long) this.a.optInt("connect_timeout", -1);
        if (optInt >= 2000) {
            return optInt;
        }
        return -1;
    }

    public long j() {
        long optInt = (long) this.a.optInt("read_timeout", -1);
        if (optInt >= 4000) {
            return optInt;
        }
        return -1;
    }

    public int k() {
        return this.a.optInt("ip_strategy", 0);
    }

    private int b(int i) {
        int optInt = this.a.optInt("thread_count", 4);
        if (optInt > 16) {
            optInt = 16;
        }
        if (optInt > 0) {
            return o() == 1 ? Math.min(optInt, i) : optInt;
        }
        if (o() > 0) {
            return i;
        }
        return 1;
    }

    public float l() {
        return (float) this.a.optDouble("main_ratio", 0.0d);
    }

    public boolean m() {
        return this.a.optInt("ratio_segment", 0) == 1;
    }

    public float n() {
        return Math.min(Math.max(0.0f, (float) this.a.optDouble("poor_speed_ratio", 0.0d)), 1.0f);
    }

    public static n a(JSONObject jSONObject) {
        return new n(jSONObject);
    }
}
