package com.coolapk.market.download;

import java.io.InputStream;

public interface DownloadResponse {
    void close();

    InputStream getByteStream();

    int getCode();

    long getContentLength();

    String getFileExtension();

    String getFileName();

    String getHeader(String str);

    String getMessage();

    String getUrl();

    boolean isSuccessful();
}
