package com.tencent.android.tpns.mqtt.internal;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileLock {
    private RandomAccessFile file;
    private Object fileLock;
    private File lockFile;

    public FileLock(File file2, String str) throws Exception {
        this.lockFile = new File(file2, str);
        if (ExceptionHelper.isClassAvailable("java.nio.channels.FileLock")) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.lockFile, "rw");
                this.file = randomAccessFile;
                Object invoke = randomAccessFile.getClass().getMethod("getChannel", new Class[0]).invoke(this.file, new Object[0]);
                this.fileLock = invoke.getClass().getMethod("tryLock", new Class[0]).invoke(invoke, new Object[0]);
            } catch (NoSuchMethodException unused) {
                this.fileLock = null;
            } catch (IllegalArgumentException unused2) {
                this.fileLock = null;
            } catch (IllegalAccessException unused3) {
                this.fileLock = null;
            }
            if (this.fileLock == null) {
                release();
                throw new Exception("Problem obtaining file lock");
            }
        }
    }

    public void release() {
        try {
            Object obj = this.fileLock;
            if (obj != null) {
                obj.getClass().getMethod("release", new Class[0]).invoke(this.fileLock, new Object[0]);
                this.fileLock = null;
            }
        } catch (Throwable unused) {
        }
        RandomAccessFile randomAccessFile = this.file;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
            this.file = null;
        }
        File file2 = this.lockFile;
        if (file2 != null && file2.exists()) {
            this.lockFile.delete();
        }
        this.lockFile = null;
    }
}
