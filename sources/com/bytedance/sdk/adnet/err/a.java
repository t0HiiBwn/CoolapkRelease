package com.bytedance.sdk.adnet.err;

import android.content.Intent;
import com.bytedance.sdk.adnet.core.i;

/* compiled from: AuthFailureError */
public class a extends VAdError {
    private Intent a;

    public a() {
    }

    public a(i iVar) {
        super(iVar);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (this.a != null) {
            return "User needs to (re)enter credentials.";
        }
        return super.getMessage();
    }
}
