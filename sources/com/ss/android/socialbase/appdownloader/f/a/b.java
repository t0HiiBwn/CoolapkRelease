package com.ss.android.socialbase.appdownloader.f.a;

import java.io.IOException;

/* compiled from: ChunkUtil */
public class b {
    public static final void a(d dVar, int i) throws IOException {
        int b = dVar.b();
        if (b != i) {
            throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i) + ", read 0x" + Integer.toHexString(b) + ".");
        }
    }
}
