package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamEncoder implements Encoder<InputStream> {
    private static final String TAG = "StreamEncoder";
    private final ArrayPool byteArrayPool;

    public StreamEncoder(ArrayPool arrayPool) {
        this.byteArrayPool = arrayPool;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0038 A[Catch:{ all -> 0x002e }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004a A[SYNTHETIC, Splitter:B:28:0x004a] */
    public boolean encode(InputStream inputStream, File file, Options options) {
        Throwable th;
        IOException e;
        byte[] bArr = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        boolean z = false;
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    try {
                        if (Log.isLoggable("StreamEncoder", 3)) {
                        }
                        if (fileOutputStream != null) {
                        }
                        this.byteArrayPool.put(bArr);
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        this.byteArrayPool.put(bArr);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                    }
                    this.byteArrayPool.put(bArr);
                    throw th;
                }
            }
            fileOutputStream2.close();
            z = true;
            try {
                fileOutputStream2.close();
            } catch (IOException unused2) {
            }
        } catch (IOException e3) {
            e = e3;
            if (Log.isLoggable("StreamEncoder", 3)) {
                Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            this.byteArrayPool.put(bArr);
            return z;
        }
        this.byteArrayPool.put(bArr);
        return z;
    }
}
