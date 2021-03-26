package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Okio */
public final class l {
    static final Logger a = Logger.getLogger(l.class.getName());

    private l() {
    }

    public static e a(s sVar) {
        return new n(sVar);
    }

    public static d a(r rVar) {
        return new m(rVar);
    }

    private static r a(final OutputStream outputStream, final t tVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (tVar != null) {
            return new r() {
                /* class com.bytedance.sdk.a.a.l.AnonymousClass1 */

                @Override // com.bytedance.sdk.a.a.r
                public void a_(c cVar, long j) throws IOException {
                    u.a(cVar.b, 0, j);
                    while (j > 0) {
                        tVar.g();
                        o oVar = cVar.a;
                        int min = (int) Math.min(j, (long) (oVar.c - oVar.b));
                        outputStream.write(oVar.a, oVar.b, min);
                        oVar.b += min;
                        long j2 = (long) min;
                        j -= j2;
                        cVar.b -= j2;
                        if (oVar.b == oVar.c) {
                            cVar.a = oVar.b();
                            p.a(oVar);
                        }
                    }
                }

                @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
                public void flush() throws IOException {
                    outputStream.flush();
                }

                @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    outputStream.close();
                }

                @Override // com.bytedance.sdk.a.a.r
                public t a() {
                    return tVar;
                }

                @Override // java.lang.Object
                public String toString() {
                    return "sink(" + outputStream + ")";
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static r a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getOutputStream() != null) {
            a c = c(socket);
            return c.a(a(socket.getOutputStream(), c));
        } else {
            throw new IOException("socket's output stream == null");
        }
    }

    public static s a(InputStream inputStream) {
        return a(inputStream, new t());
    }

    private static s a(final InputStream inputStream, final t tVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (tVar != null) {
            return new s() {
                /* class com.bytedance.sdk.a.a.l.AnonymousClass2 */

                @Override // com.bytedance.sdk.a.a.s
                public long a(c cVar, long j) throws IOException {
                    int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                    if (i < 0) {
                        throw new IllegalArgumentException("byteCount < 0: " + j);
                    } else if (i == 0) {
                        return 0;
                    } else {
                        try {
                            tVar.g();
                            o e = cVar.e(1);
                            int read = inputStream.read(e.a, e.c, (int) Math.min(j, (long) (8192 - e.c)));
                            if (read == -1) {
                                return -1;
                            }
                            e.c += read;
                            long j2 = (long) read;
                            cVar.b += j2;
                            return j2;
                        } catch (AssertionError e2) {
                            if (l.a(e2)) {
                                throw new IOException(e2);
                            }
                            throw e2;
                        }
                    }
                }

                @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    inputStream.close();
                }

                @Override // com.bytedance.sdk.a.a.s
                public t a() {
                    return tVar;
                }

                @Override // java.lang.Object
                public String toString() {
                    return "source(" + inputStream + ")";
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static s b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getInputStream() != null) {
            a c = c(socket);
            return c.a(a(socket.getInputStream(), c));
        } else {
            throw new IOException("socket's input stream == null");
        }
    }

    private static a c(final Socket socket) {
        return new a() {
            /* class com.bytedance.sdk.a.a.l.AnonymousClass3 */

            @Override // com.bytedance.sdk.a.a.a
            protected IOException b(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            @Override // com.bytedance.sdk.a.a.a
            protected void a_() {
                try {
                    socket.close();
                } catch (Exception e) {
                    Logger logger = l.a;
                    Level level = Level.WARNING;
                    logger.log(level, "Failed to close timed out socket " + socket, (Throwable) e);
                } catch (AssertionError e2) {
                    if (l.a(e2)) {
                        Logger logger2 = l.a;
                        Level level2 = Level.WARNING;
                        logger2.log(level2, "Failed to close timed out socket " + socket, (Throwable) e2);
                        return;
                    }
                    throw e2;
                }
            }
        };
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
