package com.qq.e.comm.net.rr;

import java.io.IOException;
import java.io.InputStream;

public interface Response {
    public static final int HTTP_NO_CONTENT = 204;
    public static final int HTTP_OK = 200;
    public static final int HTTP_UNKNOWN = 0;

    void close() throws IllegalStateException, IOException;

    byte[] getBytesContent() throws IllegalStateException, IOException;

    int getStatusCode();

    InputStream getStreamContent() throws IllegalStateException, IOException;

    String getStringContent() throws IllegalStateException, IOException;

    String getStringContent(String str) throws IllegalStateException, IOException;
}
