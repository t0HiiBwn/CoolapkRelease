package com.ss.android.ttmd5;

import java.io.IOException;

public interface IRandomAccess {
    void close() throws IOException;

    long length() throws IOException;

    int read(byte[] bArr, int i, int i2) throws IOException;

    void seek(long j, long j2) throws IOException;
}
