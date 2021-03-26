package com.ss.android.socialbase.downloader.e;

import com.ss.android.socialbase.downloader.f.a;
import com.ss.android.socialbase.downloader.i.e;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: SyncStreamReader */
public class c implements b {
    private final InputStream a;
    private final a b;

    @Override // com.ss.android.socialbase.downloader.e.b
    public void a(a aVar) {
    }

    public c(InputStream inputStream, int i) {
        this.a = inputStream;
        this.b = new a(i);
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public a a() throws IOException {
        a aVar = this.b;
        aVar.c = this.a.read(aVar.a);
        return this.b;
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public void b() {
        e.a(this.a);
    }
}
