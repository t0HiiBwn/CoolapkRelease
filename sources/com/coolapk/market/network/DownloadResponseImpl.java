package com.coolapk.market.network;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.coolapk.market.download.DownloadResponse;
import com.coolapk.market.util.CacheUrlUtils;
import java.io.InputStream;
import okhttp3.HttpUrl;
import okhttp3.Response;

public class DownloadResponseImpl implements DownloadResponse {
    private String extension;
    private final String redirectUrl;
    private final Response response;

    public DownloadResponseImpl(Response response2) {
        this.response = response2;
        HttpUrl url = response2.request().url();
        if (url != null) {
            String url2 = url.url().toString();
            this.redirectUrl = url2;
            this.extension = MimeTypeMap.getFileExtensionFromUrl(url2);
            return;
        }
        this.redirectUrl = null;
        this.extension = null;
    }

    @Override // com.coolapk.market.download.DownloadResponse
    public boolean isSuccessful() {
        return this.response.isSuccessful();
    }

    @Override // com.coolapk.market.download.DownloadResponse
    public String getHeader(String str) {
        return this.response.header(str);
    }

    @Override // com.coolapk.market.download.DownloadResponse
    public String getFileName() {
        String header = this.response.header("Content-disposition");
        if (!TextUtils.isEmpty(header) && header.startsWith("attachment")) {
            String[] split = header.split(";");
            for (int i = 1; i < split.length; i++) {
                String trim = split[i].trim();
                if (!TextUtils.isEmpty(trim) && trim.startsWith("filename=")) {
                    return trim.substring(9);
                }
            }
        }
        if (!TextUtils.isEmpty(this.extension)) {
            return CacheUrlUtils.getLastPathSegment(this.redirectUrl);
        }
        return null;
    }

    @Override // com.coolapk.market.download.DownloadResponse
    public String getFileExtension() {
        if (TextUtils.isEmpty(this.extension)) {
            String header = this.response.header("Content-Type");
            if (!TextUtils.isEmpty(header)) {
                this.extension = MimeTypeMap.getSingleton().getExtensionFromMimeType(header);
            }
        }
        return this.extension;
    }

    @Override // com.coolapk.market.download.DownloadResponse
    public long getContentLength() {
        return this.response.body().contentLength();
    }

    @Override // com.coolapk.market.download.DownloadResponse
    public InputStream getByteStream() {
        return this.response.body().byteStream();
    }

    @Override // com.coolapk.market.download.DownloadResponse
    public void close() {
        this.response.body().close();
    }

    @Override // com.coolapk.market.download.DownloadResponse
    public int getCode() {
        return this.response.code();
    }

    @Override // com.coolapk.market.download.DownloadResponse
    public String getMessage() {
        return this.response.message();
    }

    @Override // com.coolapk.market.download.DownloadResponse
    public String getUrl() {
        return this.redirectUrl;
    }
}
