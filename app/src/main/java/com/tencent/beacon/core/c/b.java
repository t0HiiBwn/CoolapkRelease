package com.tencent.beacon.core.c;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;

/* compiled from: BeaconHttpResponse */
public final class b {
    HttpResponse a = null;
    HttpPost b = null;

    public b(HttpResponse httpResponse, HttpPost httpPost) {
        this.a = httpResponse;
        this.b = httpPost;
    }
}
