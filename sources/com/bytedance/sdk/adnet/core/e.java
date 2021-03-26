package com.bytedance.sdk.adnet.core;

import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.d;

/* compiled from: DefaultRetryPolicy */
public class e implements d {
    private int a;
    private int b;
    private int c;
    private final float d;

    public e() {
        this(2500, 1, 1.0f);
    }

    public e a(int i) {
        this.a = i;
        return this;
    }

    public e b(int i) {
        this.c = i;
        return this;
    }

    public e(int i, int i2, float f) {
        this.a = i;
        this.c = i2;
        this.d = f;
    }

    @Override // com.bytedance.sdk.adnet.face.d
    public int a() {
        return this.a;
    }

    @Override // com.bytedance.sdk.adnet.face.d
    public int b() {
        return this.b;
    }

    @Override // com.bytedance.sdk.adnet.face.d
    public void a(VAdError vAdError) throws VAdError {
        this.b++;
        int i = this.a;
        this.a = i + ((int) (((float) i) * this.d));
        if (!c()) {
            throw vAdError;
        }
    }

    protected boolean c() {
        return this.b <= this.c;
    }
}
