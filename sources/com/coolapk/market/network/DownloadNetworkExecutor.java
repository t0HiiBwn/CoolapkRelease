package com.coolapk.market.network;

import com.coolapk.market.download.DownloadResponse;
import com.coolapk.market.download.NetworkExecutor;
import okhttp3.Headers;
import okhttp3.Request;

public class DownloadNetworkExecutor implements NetworkExecutor {
    private final String[] extraHeaders;

    public DownloadNetworkExecutor(String[] strArr) {
        this.extraHeaders = strArr;
    }

    @Override // com.coolapk.market.download.NetworkExecutor
    public DownloadResponse execute(String str) throws Throwable {
        return new DownloadResponseImpl(HttpClientFactory.getInstance().getDownloadHttpClient().newCall(new Request.Builder().url(str).headers(Headers.of(this.extraHeaders)).build()).execute());
    }
}
