package com.ss.android.socialbase.downloader.network.a;

import com.ss.android.socialbase.downloader.model.c;
import com.ss.android.socialbase.downloader.network.i;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: FakeDownloadHttpConnection */
public class d implements i {
    protected final Object a;
    private final List<c> b;
    private i c;
    private boolean d;
    private long e;
    private InputStream f;

    public boolean a(int i) {
        return i >= 200 && i < 300;
    }

    public void e() throws InterruptedException {
        synchronized (this.a) {
            if (this.d && this.c == null) {
                this.a.wait();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.i
    public InputStream a() throws IOException {
        InputStream inputStream = this.f;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.network.i
    public void d() {
        i iVar = this.c;
        if (iVar != null) {
            iVar.d();
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public String a(String str) {
        i iVar = this.c;
        if (iVar != null) {
            return iVar.a(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public int b() throws IOException {
        i iVar = this.c;
        if (iVar != null) {
            return iVar.b();
        }
        return 0;
    }

    public List<c> f() {
        return this.b;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public void c() {
        i iVar = this.c;
        if (iVar != null) {
            iVar.c();
        }
    }

    public boolean g() {
        try {
            i iVar = this.c;
            return iVar != null && a(iVar.b());
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean h() {
        return System.currentTimeMillis() - this.e < b.a;
    }
}
