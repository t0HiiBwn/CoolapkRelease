package com.qq.e.comm.net.rr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public abstract class AbstractResponse implements Response {
    private final HttpURLConnection a;
    private int b = 0;

    public AbstractResponse(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            this.a = httpURLConnection;
            try {
                this.b = httpURLConnection.getResponseCode();
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        } else {
            throw new AssertionError("AbstractResponse parameter is null");
        }
    }

    @Override // com.qq.e.comm.net.rr.Response
    public void close() throws IllegalStateException, IOException {
        this.a.disconnect();
    }

    @Override // com.qq.e.comm.net.rr.Response
    public byte[] getBytesContent() throws IllegalStateException, IOException {
        if (200 != getStatusCode()) {
            return null;
        }
        InputStream streamContent = getStreamContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = streamContent.read(bArr);
            if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                streamContent.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    @Override // com.qq.e.comm.net.rr.Response
    public int getStatusCode() {
        return this.b;
    }

    @Override // com.qq.e.comm.net.rr.Response
    public InputStream getStreamContent() throws IllegalStateException, IOException {
        return this.a.getInputStream();
    }

    @Override // com.qq.e.comm.net.rr.Response
    public String getStringContent() throws IOException {
        return getStringContent("UTF-8");
    }

    @Override // com.qq.e.comm.net.rr.Response
    public String getStringContent(String str) throws IOException {
        byte[] bytesContent = getBytesContent();
        String str2 = null;
        if (bytesContent == null) {
            return null;
        }
        if (bytesContent.length == 0) {
            return "";
        }
        try {
            str2 = this.a.getContentEncoding();
        } catch (Throwable unused) {
        }
        if (str2 != null) {
            str = str2;
        }
        return new String(bytesContent, str);
    }
}
