package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class in extends iq {
    protected InputStream a = null;
    protected OutputStream b = null;

    protected in() {
    }

    public in(OutputStream outputStream) {
        this.b = outputStream;
    }

    @Override // com.xiaomi.push.iq
    public int a(byte[] bArr, int i, int i2) {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            try {
                int read = inputStream.read(bArr, i, i2);
                if (read >= 0) {
                    return read;
                }
                throw new ir(4);
            } catch (IOException e) {
                throw new ir(0, e);
            }
        } else {
            throw new ir(1, "Cannot read from null inputStream");
        }
    }

    @Override // com.xiaomi.push.iq
    public void b(byte[] bArr, int i, int i2) {
        OutputStream outputStream = this.b;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i, i2);
            } catch (IOException e) {
                throw new ir(0, e);
            }
        } else {
            throw new ir(1, "Cannot write to null outputStream");
        }
    }
}
