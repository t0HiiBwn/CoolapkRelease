package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class jf extends ji {
    protected InputStream a = null;

    /* renamed from: a  reason: collision with other field name */
    protected OutputStream f883a = null;

    protected jf() {
    }

    public jf(OutputStream outputStream) {
        this.f883a = outputStream;
    }

    @Override // com.xiaomi.push.ji
    /* renamed from: a */
    public int mo561a(byte[] bArr, int i, int i2) {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            try {
                int read = inputStream.read(bArr, i, i2);
                if (read >= 0) {
                    return read;
                }
                throw new jj(4);
            } catch (IOException e) {
                throw new jj(0, e);
            }
        } else {
            throw new jj(1, "Cannot read from null inputStream");
        }
    }

    @Override // com.xiaomi.push.ji
    /* renamed from: a  reason: collision with other method in class */
    public void mo561a(byte[] bArr, int i, int i2) {
        OutputStream outputStream = this.f883a;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i, i2);
            } catch (IOException e) {
                throw new jj(0, e);
            }
        } else {
            throw new jj(1, "Cannot write to null outputStream");
        }
    }
}
