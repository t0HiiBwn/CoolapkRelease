package com.bytedance.sdk.openadsdk.downloadnew.core;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.core.d.l;

/* compiled from: ITTDownloadAdapter */
public interface a {

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.core.a$a  reason: collision with other inner class name */
    /* compiled from: ITTDownloadAdapter */
    public interface AbstractC0050a {
        boolean a(int i, l lVar, String str, String str2, Object obj);
    }

    void a();

    void a(int i, AbstractC0050a aVar);

    void a(Activity activity);

    void a(View view);

    void a(TTAppDownloadListener tTAppDownloadListener);

    void a(TTAppDownloadListener tTAppDownloadListener, boolean z);

    boolean a(boolean z);

    void b();

    boolean b(boolean z);

    void c();

    void d();

    void e();

    void f();

    void g();

    boolean h();

    boolean i();

    boolean j();
}
