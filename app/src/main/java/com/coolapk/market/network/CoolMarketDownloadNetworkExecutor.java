package com.coolapk.market.network;

import android.text.TextUtils;
import com.coolapk.market.download.DownloadResponse;
import com.coolapk.market.download.HttpException;
import com.coolapk.market.download.NetworkExecutor;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.util.UrlEncodedQueryString;
import java.net.URI;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Request;

public class CoolMarketDownloadNetworkExecutor implements NetworkExecutor {
    private final String[] extraHeaders;

    public CoolMarketDownloadNetworkExecutor(String[] strArr) {
        this.extraHeaders = strArr;
    }

    @Override // com.coolapk.market.download.NetworkExecutor
    public DownloadResponse execute(String str) throws Throwable {
        URI create = URI.create(str);
        UrlEncodedQueryString parse = UrlEncodedQueryString.parse(create);
        String str2 = parse.get("pn");
        String str3 = parse.get("resume_on_error");
        String str4 = parse.get("extra_analysis_data");
        boolean z = !Boolean.parseBoolean(str3);
        parse.remove("resume_on_error");
        parse.remove("extra_analysis_data");
        String uri = parse.apply(create).toString();
        MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(str2);
        boolean z2 = false;
        if (mobileAppExistFast != null) {
            z2 = mobileAppExistFast.isExist();
        }
        DownloadResponseImpl downloadResponseImpl = new DownloadResponseImpl(HttpClientFactory.getInstance().getCoolMarketDownloadHttpClient().newCall(new Request.Builder().url(uri).headers(Headers.of(this.extraHeaders)).post(new FormBody.Builder().add("nd", z2 ? "0" : "1").add("extraAnalysisData", str4).build()).build()).execute());
        if (z) {
            checkHijack(str2, uri, downloadResponseImpl);
        }
        return downloadResponseImpl;
    }

    private void checkHijack(String str, String str2, DownloadResponseImpl downloadResponseImpl) throws HttpException {
        Result<String> result;
        if (!TextUtils.isEmpty(downloadResponseImpl.getUrl())) {
            String url = downloadResponseImpl.getUrl();
            String fileExtension = downloadResponseImpl.getFileExtension();
            if (TextUtils.equals("html", fileExtension) || TextUtils.equals("htm", fileExtension)) {
                throw new HttpException(downloadResponseImpl);
            }
            try {
                result = DataManager.getInstance().verifyDownloadUrl(str, str2, url).toBlocking().first();
            } catch (Exception e) {
                e.printStackTrace();
                result = null;
            }
            if (result != null && result.isSuccess() && TextUtils.isEmpty(result.getData())) {
                DataManager.getInstance().saveLog("download", "The hijack\n" + url, null);
                throw new HttpException(downloadResponseImpl);
            }
        }
    }
}
