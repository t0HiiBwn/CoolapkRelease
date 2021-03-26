package org.apache.commons.io.input;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import org.apache.commons.io.FileUtils;

public class Tailer implements Runnable {
    private static final int DEFAULT_BUFSIZE = 4096;
    private static final Charset DEFAULT_CHARSET = Charset.defaultCharset();
    private static final int DEFAULT_DELAY_MILLIS = 1000;
    private static final String RAF_MODE = "r";
    private final Charset cset;
    private final long delayMillis;
    private final boolean end;
    private final File file;
    private final byte[] inbuf;
    private final TailerListener listener;
    private final boolean reOpen;
    private volatile boolean run;

    public Tailer(File file2, TailerListener tailerListener) {
        this(file2, tailerListener, 1000);
    }

    public Tailer(File file2, TailerListener tailerListener, long j) {
        this(file2, tailerListener, j, false);
    }

    public Tailer(File file2, TailerListener tailerListener, long j, boolean z) {
        this(file2, tailerListener, j, z, 4096);
    }

    public Tailer(File file2, TailerListener tailerListener, long j, boolean z, boolean z2) {
        this(file2, tailerListener, j, z, z2, 4096);
    }

    public Tailer(File file2, TailerListener tailerListener, long j, boolean z, int i) {
        this(file2, tailerListener, j, z, false, i);
    }

    public Tailer(File file2, TailerListener tailerListener, long j, boolean z, boolean z2, int i) {
        this(file2, DEFAULT_CHARSET, tailerListener, j, z, z2, i);
    }

    public Tailer(File file2, Charset charset, TailerListener tailerListener, long j, boolean z, boolean z2, int i) {
        this.run = true;
        this.file = file2;
        this.delayMillis = j;
        this.end = z;
        this.inbuf = new byte[i];
        this.listener = tailerListener;
        tailerListener.init(this);
        this.reOpen = z2;
        this.cset = charset;
    }

    public static Tailer create(File file2, TailerListener tailerListener, long j, boolean z, int i) {
        return create(file2, tailerListener, j, z, false, i);
    }

    public static Tailer create(File file2, TailerListener tailerListener, long j, boolean z, boolean z2, int i) {
        return create(file2, DEFAULT_CHARSET, tailerListener, j, z, z2, i);
    }

    public static Tailer create(File file2, Charset charset, TailerListener tailerListener, long j, boolean z, boolean z2, int i) {
        Tailer tailer = new Tailer(file2, charset, tailerListener, j, z, z2, i);
        Thread thread = new Thread(tailer);
        thread.setDaemon(true);
        thread.start();
        return tailer;
    }

    public static Tailer create(File file2, TailerListener tailerListener, long j, boolean z) {
        return create(file2, tailerListener, j, z, 4096);
    }

    public static Tailer create(File file2, TailerListener tailerListener, long j, boolean z, boolean z2) {
        return create(file2, tailerListener, j, z, z2, 4096);
    }

    public static Tailer create(File file2, TailerListener tailerListener, long j) {
        return create(file2, tailerListener, j, false);
    }

    public static Tailer create(File file2, TailerListener tailerListener) {
        return create(file2, tailerListener, 1000, false);
    }

    public File getFile() {
        return this.file;
    }

    protected boolean getRun() {
        return this.run;
    }

    public long getDelay() {
        return this.delayMillis;
    }

    /* JADX WARNING: Removed duplicated region for block: B:83:0x00f1 A[SYNTHETIC, Splitter:B:83:0x00f1] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0117 A[SYNTHETIC, Splitter:B:96:0x0117] */
    @Override // java.lang.Runnable
    public void run() {
        Throwable th;
        InterruptedException e;
        Exception e2;
        RandomAccessFile randomAccessFile;
        long readLines;
        long lastModified;
        Throwable th2;
        RandomAccessFile randomAccessFile2 = null;
        long j = 0;
        long j2 = 0;
        while (getRun() && randomAccessFile2 == null) {
            try {
                try {
                    randomAccessFile2 = new RandomAccessFile(this.file, "r");
                } catch (FileNotFoundException unused) {
                    this.listener.fileNotFound();
                }
                if (randomAccessFile2 == null) {
                    Thread.sleep(this.delayMillis);
                } else {
                    j2 = this.end ? this.file.length() : 0;
                    j = this.file.lastModified();
                    randomAccessFile2.seek(j2);
                }
            } catch (InterruptedException e3) {
                e = e3;
                Thread.currentThread().interrupt();
                this.listener.handle(e);
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e4) {
                        e = e4;
                    }
                }
                stop();
            } catch (Exception e5) {
                e2 = e5;
                try {
                    this.listener.handle(e2);
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (IOException e6) {
                            e = e6;
                        }
                    }
                    stop();
                } catch (Throwable th3) {
                    th = th3;
                    if (randomAccessFile2 != null) {
                    }
                    stop();
                    throw th;
                }
            }
        }
        while (getRun()) {
            boolean isFileNewer = FileUtils.isFileNewer(this.file, j);
            int i = (this.file.length() > j2 ? 1 : (this.file.length() == j2 ? 0 : -1));
            if (i < 0) {
                this.listener.fileRotated();
                try {
                    randomAccessFile = new RandomAccessFile(this.file, "r");
                    try {
                        readLines(randomAccessFile2);
                    } catch (IOException e7) {
                        this.listener.handle(e7);
                    } catch (Throwable th4) {
                        th2 = th4;
                        try {
                            throw th2;
                        } catch (FileNotFoundException unused2) {
                            randomAccessFile2 = randomAccessFile;
                            this.listener.fileNotFound();
                            Thread.sleep(this.delayMillis);
                        } catch (Throwable th5) {
                            th2.addSuppressed(th5);
                        }
                    }
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (FileNotFoundException unused3) {
                            j2 = 0;
                        }
                    }
                    j2 = 0;
                } catch (Throwable th6) {
                    th2 = th6;
                    randomAccessFile = randomAccessFile2;
                    throw th2;
                }
            } else {
                if (i > 0) {
                    readLines = readLines(randomAccessFile2);
                    lastModified = this.file.lastModified();
                } else {
                    if (isFileNewer) {
                        randomAccessFile2.seek(0);
                        readLines = readLines(randomAccessFile2);
                        lastModified = this.file.lastModified();
                    }
                    if (this.reOpen && randomAccessFile2 != null) {
                        randomAccessFile2.close();
                    }
                    Thread.sleep(this.delayMillis);
                    if (getRun() && this.reOpen) {
                        randomAccessFile = new RandomAccessFile(this.file, "r");
                        randomAccessFile.seek(j2);
                    }
                }
                j = lastModified;
                j2 = readLines;
                randomAccessFile2.close();
                Thread.sleep(this.delayMillis);
                randomAccessFile = new RandomAccessFile(this.file, "r");
                try {
                    randomAccessFile.seek(j2);
                } catch (InterruptedException e8) {
                    e = e8;
                    randomAccessFile2 = randomAccessFile;
                } catch (Exception e9) {
                    e2 = e9;
                    randomAccessFile2 = randomAccessFile;
                    this.listener.handle(e2);
                    if (randomAccessFile2 != null) {
                    }
                    stop();
                } catch (Throwable th7) {
                    th = th7;
                    randomAccessFile2 = randomAccessFile;
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (IOException e10) {
                            this.listener.handle(e10);
                        }
                    }
                    stop();
                    throw th;
                }
            }
            randomAccessFile2 = randomAccessFile;
        }
        if (randomAccessFile2 != null) {
            try {
                randomAccessFile2.close();
            } catch (IOException e11) {
                e = e11;
            }
        }
        stop();
        throw th;
        this.listener.handle(e);
        stop();
    }

    public void stop() {
        this.run = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0085, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008b, code lost:
        r14.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008e, code lost:
        throw r1;
     */
    private long readLines(RandomAccessFile randomAccessFile) throws IOException {
        int read;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(64);
        long filePointer = randomAccessFile.getFilePointer();
        long j = filePointer;
        boolean z = false;
        while (getRun() && (read = randomAccessFile.read(this.inbuf)) != -1) {
            for (int i = 0; i < read; i++) {
                byte b = this.inbuf[i];
                if (b == 10) {
                    this.listener.handle(new String(byteArrayOutputStream.toByteArray(), this.cset));
                    byteArrayOutputStream.reset();
                    filePointer = ((long) i) + j + 1;
                    z = false;
                } else if (b != 13) {
                    if (z) {
                        this.listener.handle(new String(byteArrayOutputStream.toByteArray(), this.cset));
                        byteArrayOutputStream.reset();
                        filePointer = ((long) i) + j + 1;
                        z = false;
                    }
                    byteArrayOutputStream.write(b);
                } else {
                    if (z) {
                        byteArrayOutputStream.write(13);
                    }
                    z = true;
                }
            }
            j = randomAccessFile.getFilePointer();
        }
        randomAccessFile.seek(filePointer);
        TailerListener tailerListener = this.listener;
        if (tailerListener instanceof TailerListenerAdapter) {
            ((TailerListenerAdapter) tailerListener).endOfFileReached();
        }
        byteArrayOutputStream.close();
        return filePointer;
    }
}
