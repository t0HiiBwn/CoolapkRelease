package com.facebook.stetho.inspector.network;

import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.Util;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.GZIPInputStream;

class GunzippingOutputStream extends FilterOutputStream {
    private static final ExecutorService sExecutor = Executors.newCachedThreadPool();
    private final Future<Void> mCopyFuture;

    public static GunzippingOutputStream create(OutputStream outputStream) throws IOException {
        PipedInputStream pipedInputStream = new PipedInputStream();
        return new GunzippingOutputStream(new PipedOutputStream(pipedInputStream), sExecutor.submit(new GunzippingCallable(pipedInputStream, outputStream)));
    }

    private GunzippingOutputStream(OutputStream outputStream, Future<Void> future) throws IOException {
        super(outputStream);
        this.mCopyFuture = future;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            super.close();
            try {
            } catch (IOException e) {
                throw e;
            }
        } finally {
            try {
                getAndRethrow(this.mCopyFuture);
            } catch (IOException unused) {
            }
        }
    }

    private static <T> T getAndRethrow(Future<T> future) throws IOException {
        while (true) {
            try {
                return future.get();
            } catch (InterruptedException unused) {
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                ExceptionUtil.propagateIfInstanceOf(cause, IOException.class);
                ExceptionUtil.propagate(cause);
            }
        }
    }

    private static class GunzippingCallable implements Callable<Void> {
        private final InputStream mIn;
        private final OutputStream mOut;

        public GunzippingCallable(InputStream inputStream, OutputStream outputStream) {
            this.mIn = inputStream;
            this.mOut = outputStream;
        }

        /* JADX INFO: finally extract failed */
        @Override // java.util.concurrent.Callable
        public Void call() throws IOException {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(this.mIn);
            try {
                Util.copy(gZIPInputStream, this.mOut, new byte[1024]);
                gZIPInputStream.close();
                this.mOut.close();
                return null;
            } catch (Throwable th) {
                gZIPInputStream.close();
                this.mOut.close();
                throw th;
            }
        }
    }
}
