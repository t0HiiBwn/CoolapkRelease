package com.ss.android.socialbase.downloader.model;

import com.ss.android.socialbase.downloader.exception.BaseException;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: RandomAccessOutputStream */
public class e implements Closeable {
    private BufferedOutputStream a;
    private FileDescriptor b;
    private RandomAccessFile c;

    public e(File file, int i) throws BaseException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.c = randomAccessFile;
            this.b = randomAccessFile.getFD();
            if (i > 0) {
                if (i < 8192) {
                    i = 8192;
                } else if (i > 131072) {
                    i = 131072;
                }
                this.a = new BufferedOutputStream(new FileOutputStream(this.c.getFD()), i);
                return;
            }
            this.a = new BufferedOutputStream(new FileOutputStream(this.c.getFD()));
        } catch (IOException e) {
            throw new BaseException(1039, e);
        }
    }

    public void a(byte[] bArr, int i, int i2) throws IOException {
        this.a.write(bArr, i, i2);
    }

    public void a() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.a;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        FileDescriptor fileDescriptor = this.b;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void b() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.a;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
    }

    public void c() throws IOException {
        FileDescriptor fileDescriptor = this.b;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        com.ss.android.socialbase.downloader.i.e.a(this.c, this.a);
    }

    public void a(long j) throws IOException {
        this.c.seek(j);
    }

    public void b(long j) throws IOException {
        this.c.setLength(j);
    }
}
