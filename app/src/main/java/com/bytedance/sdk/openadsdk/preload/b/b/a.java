package com.bytedance.sdk.openadsdk.preload.b.b;

import com.bytedance.sdk.openadsdk.preload.b.b;
import com.bytedance.sdk.openadsdk.preload.b.d;

/* compiled from: EventListener */
public abstract class a {
    public <T> void a(b<T> bVar, d dVar) {
    }

    public <T> void a(b<T> bVar, d dVar, Throwable th) {
    }

    public <T> void b(b<T> bVar, d dVar) {
    }

    public <T> void b(b<T> bVar, d dVar, Throwable th) {
    }

    public <T> void c(b<T> bVar, d dVar) {
    }

    public <T> void f(b<T> bVar, d dVar, Throwable th) {
    }

    public final void d(b bVar, d dVar) {
        c(bVar, dVar);
    }

    public final void e(b bVar, d dVar) {
        b(bVar, dVar);
    }

    public final void f(b bVar, d dVar) {
        a(bVar, dVar);
    }

    public final void c(b bVar, d dVar, Throwable th) {
        a(bVar, dVar, th);
    }

    public final void d(b bVar, d dVar, Throwable th) {
        f(bVar, dVar, th);
    }

    public final void e(b bVar, d dVar, Throwable th) {
        b(bVar, dVar, th);
    }
}
