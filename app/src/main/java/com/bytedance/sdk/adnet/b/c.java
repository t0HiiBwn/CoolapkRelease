package com.bytedance.sdk.adnet.b;

import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.Header;
import com.bytedance.sdk.adnet.core.HttpResponse;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.e;
import com.bytedance.sdk.adnet.core.i;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.adnet.d.b;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.err.f;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* compiled from: FileRequest */
public class c extends Request<File> {
    private File c;
    private File d;
    private final Object e = new Object();
    private m.a<File> f;

    /* compiled from: FileRequest */
    public interface a extends m.a<File> {
        void a(long j, long j2);
    }

    public c(String str, String str2, m.a<File> aVar) {
        super(str2, aVar);
        this.f = aVar;
        this.c = new File(str);
        this.d = new File(str + ".tmp");
        try {
            File file = this.c;
            if (!(file == null || file.getParentFile() == null || this.c.getParentFile().exists())) {
                this.c.getParentFile().mkdirs();
            }
        } catch (Throwable unused) {
        }
        setRetryPolicy(new e(25000, 1, 1.0f));
        setShouldCache(false);
    }

    public File f() {
        return this.c;
    }

    public File g() {
        return this.d;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.e) {
            this.f = null;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
        HashMap hashMap = new HashMap();
        hashMap.put("Range", "bytes=" + this.d.length() + "-");
        hashMap.put("Accept-Encoding", "identity");
        return hashMap;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    protected m<File> a(i iVar) {
        if (isCanceled()) {
            h();
            return m.a(new VAdError("Request was Canceled!"));
        } else if (!this.d.canRead() || this.d.length() <= 0) {
            h();
            return m.a(new VAdError("Download temporary file was invalid!"));
        } else if (this.d.renameTo(this.c)) {
            return m.a((Object) null, b.a(iVar));
        } else {
            h();
            return m.a(new VAdError("Can't rename the download temporary file!"));
        }
    }

    private void h() {
        try {
            this.c.delete();
        } catch (Throwable unused) {
        }
        try {
            this.c.delete();
        } catch (Throwable unused2) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x0142 A[SYNTHETIC, Splitter:B:69:0x0142] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x014d A[SYNTHETIC, Splitter:B:74:0x014d] */
    public byte[] a(HttpResponse httpResponse) throws IOException, f {
        RandomAccessFile randomAccessFile;
        InputStream inputStream;
        int i;
        int i2;
        int i3;
        long contentLength = (long) httpResponse.getContentLength();
        if (contentLength <= 0) {
            o.b("Response doesn't present Content-Length!", new Object[0]);
        }
        long length = g().length();
        boolean c2 = c(httpResponse);
        if (c2) {
            contentLength += length;
            String a2 = a(httpResponse, "Content-Range");
            if (!TextUtils.isEmpty(a2)) {
                String str = "bytes " + length + "-" + (contentLength - 1);
                if (TextUtils.indexOf(a2, str) == -1) {
                    throw new IllegalStateException("The Content-Range Header is invalid Assume[" + str + "] vs Real[" + a2 + "], please remove the temporary file [" + g() + "].");
                }
            }
        }
        if (contentLength <= 0 || f().length() != contentLength) {
            if (f() != null && f().exists()) {
                f().delete();
            }
            try {
                randomAccessFile = new RandomAccessFile(g(), "rw");
                if (c2) {
                    try {
                        randomAccessFile.seek(length);
                    } catch (Throwable unused) {
                    }
                } else {
                    randomAccessFile.setLength(0);
                    length = 0;
                }
            } catch (Throwable unused2) {
                randomAccessFile = null;
            }
            try {
                inputStream = httpResponse.getContent();
                try {
                    if (b(httpResponse) && !(inputStream instanceof GZIPInputStream)) {
                        inputStream = new GZIPInputStream(inputStream);
                    }
                    byte[] bArr = new byte[1024];
                    a(length, contentLength);
                    do {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        randomAccessFile.write(bArr, 0, read);
                        length += (long) read;
                        a(length, contentLength);
                    } while (!isCanceled());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused3) {
                            i3 = 0;
                            o.a("Error occured when calling InputStream.close", new Object[0]);
                        }
                    }
                    i3 = 0;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused4) {
                            o.a("Error occured when calling consumingContent", new Object[i3]);
                        }
                    }
                    try {
                        randomAccessFile.close();
                    } catch (Throwable unused5) {
                        o.a("Error occured when calling tmpFile.close", new Object[i3]);
                    }
                } catch (Throwable unused6) {
                    i = 0;
                    try {
                        o.a("Error occured when FileRequest.parseHttpResponse", new Object[i]);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused7) {
                                o.a("Error occured when calling InputStream.close", new Object[i]);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused8) {
                                o.a("Error occured when calling consumingContent", new Object[i]);
                            }
                        }
                        try {
                            randomAccessFile.close();
                        } catch (Throwable unused9) {
                            o.a("Error occured when calling tmpFile.close", new Object[i]);
                        }
                        return null;
                    } catch (Throwable unused10) {
                        o.a("Error occured when calling tmpFile.close", new Object[i2]);
                    }
                }
            } catch (Throwable unused11) {
                i = 0;
                inputStream = null;
                o.a("Error occured when FileRequest.parseHttpResponse", new Object[i]);
                if (inputStream != null) {
                }
                if (inputStream != null) {
                }
                randomAccessFile.close();
                return null;
            }
            return null;
        }
        f().renameTo(g());
        a(contentLength, contentLength);
        return null;
        throw th;
        randomAccessFile.close();
        throw th;
        if (inputStream != null) {
            inputStream.close();
        }
        randomAccessFile.close();
        throw th;
    }

    private boolean b(HttpResponse httpResponse) {
        return TextUtils.equals(a(httpResponse, "Content-Encoding"), "gzip");
    }

    private boolean c(HttpResponse httpResponse) {
        if (TextUtils.equals(a(httpResponse, "Accept-Ranges"), "bytes")) {
            return true;
        }
        String a2 = a(httpResponse, "Content-Range");
        if (a2 == null || !a2.startsWith("bytes")) {
            return false;
        }
        return true;
    }

    private String a(HttpResponse httpResponse, String str) {
        if (httpResponse == null || httpResponse.getHeaders() == null || httpResponse.getHeaders().isEmpty()) {
            return null;
        }
        for (Header header : httpResponse.getHeaders()) {
            if (header != null && TextUtils.equals(header.getName(), str)) {
                return header.getValue();
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    protected void a(m<File> mVar) {
        m.a<File> aVar;
        synchronized (this.e) {
            aVar = this.f;
        }
        if (aVar != null) {
            aVar.a(m.a(this.c, mVar.b));
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    protected void a(long j, long j2) {
        m.a<File> aVar;
        synchronized (this.e) {
            aVar = this.f;
        }
        if (aVar instanceof a) {
            ((a) aVar).a(j, j2);
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public Request.b getPriority() {
        return Request.b.LOW;
    }
}
