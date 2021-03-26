package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: TIOStreamTransport */
public class ct extends cv {
    protected InputStream a = null;
    protected OutputStream b = null;

    @Override // com.umeng.analytics.pro.cv
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.cv
    public void b() throws cw {
    }

    protected ct() {
    }

    public ct(InputStream inputStream) {
        this.a = inputStream;
    }

    public ct(OutputStream outputStream) {
        this.b = outputStream;
    }

    public ct(InputStream inputStream, OutputStream outputStream) {
        this.a = inputStream;
        this.b = outputStream;
    }

    @Override // com.umeng.analytics.pro.cv
    public void c() {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.a = null;
        }
        OutputStream outputStream = this.b;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.b = null;
        }
    }

    @Override // com.umeng.analytics.pro.cv
    public int a(byte[] bArr, int i, int i2) throws cw {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            try {
                int read = inputStream.read(bArr, i, i2);
                if (read >= 0) {
                    return read;
                }
                throw new cw(4);
            } catch (IOException e) {
                throw new cw(0, e);
            }
        } else {
            throw new cw(1, "Cannot read from null inputStream");
        }
    }

    @Override // com.umeng.analytics.pro.cv
    public void b(byte[] bArr, int i, int i2) throws cw {
        OutputStream outputStream = this.b;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i, i2);
            } catch (IOException e) {
                throw new cw(0, e);
            }
        } else {
            throw new cw(1, "Cannot write to null outputStream");
        }
    }

    @Override // com.umeng.analytics.pro.cv
    public void d() throws cw {
        OutputStream outputStream = this.b;
        if (outputStream != null) {
            try {
                outputStream.flush();
            } catch (IOException e) {
                throw new cw(0, e);
            }
        } else {
            throw new cw(1, "Cannot flush null outputStream");
        }
    }
}
