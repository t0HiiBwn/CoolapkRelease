package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

public class AutoCloseInputStream extends ProxyInputStream {
    public AutoCloseInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() throws IOException {
        this.in.close();
        this.in = new ClosedInputStream();
    }

    @Override // org.apache.commons.io.input.ProxyInputStream
    protected void afterRead(int i) throws IOException {
        if (i == -1) {
            close();
        }
    }

    @Override // java.lang.Object
    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }
}
