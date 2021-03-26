package com.ss.android.socialbase.downloader.impls;

import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.model.c;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.network.i;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: DefaultDownloadHttpService */
public class g implements IDownloadHttpService {
    private final com.ss.android.socialbase.downloader.i.g<String, OkHttpClient> a = new com.ss.android.socialbase.downloader.i.g<>(4, 8);

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
    public i downloadWithConnection(int i, String str, List<c> list) throws IOException {
        String str2;
        OkHttpClient okHttpClient;
        Request.Builder url = new Request.Builder().url(str);
        if (list == null || list.size() <= 0) {
            str2 = null;
        } else {
            str2 = null;
            for (c cVar : list) {
                String a2 = cVar.a();
                if (str2 != null || !"ss_d_request_host_ip_114".equals(a2)) {
                    url.addHeader(a2, e.g(cVar.b()));
                } else {
                    str2 = cVar.b();
                }
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            okHttpClient = a(str, str2);
        } else {
            okHttpClient = b.s();
        }
        if (okHttpClient != null) {
            Request build = url.build();
            final Call newCall = okHttpClient.newCall(build);
            final Response execute = newCall.execute();
            if (execute != null) {
                final String ipAddrStr = build.getIpAddrStr();
                final ResponseBody body = execute.body();
                if (body == null) {
                    return null;
                }
                InputStream byteStream = body.byteStream();
                String header = execute.header("Content-Encoding");
                final GZIPInputStream gZIPInputStream = (header == null || !"gzip".equalsIgnoreCase(header) || (byteStream instanceof GZIPInputStream)) ? byteStream : new GZIPInputStream(byteStream);
                return new com.ss.android.socialbase.downloader.network.e() {
                    /* class com.ss.android.socialbase.downloader.impls.g.AnonymousClass1 */

                    @Override // com.ss.android.socialbase.downloader.network.i
                    public InputStream a() throws IOException {
                        return gZIPInputStream;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.g
                    public String a(String str) {
                        return execute.header(str);
                    }

                    @Override // com.ss.android.socialbase.downloader.network.g
                    public int b() throws IOException {
                        return execute.code();
                    }

                    @Override // com.ss.android.socialbase.downloader.network.g
                    public void c() {
                        Call call = newCall;
                        if (call != null && !call.isCanceled()) {
                            newCall.cancel();
                        }
                    }

                    @Override // com.ss.android.socialbase.downloader.network.i
                    public void d() {
                        try {
                            ResponseBody responseBody = body;
                            if (responseBody != null) {
                                responseBody.close();
                            }
                            Call call = newCall;
                            if (call != null && !call.isCanceled()) {
                                newCall.cancel();
                            }
                        } catch (Throwable unused) {
                        }
                    }

                    @Override // com.ss.android.socialbase.downloader.network.a
                    public String e() {
                        return ipAddrStr;
                    }
                };
            }
            throw new IOException("can't get response");
        }
        throw new IOException("can't get httpClient");
    }

    private OkHttpClient a(String str, final String str2) {
        try {
            final String host = Uri.parse(str).getHost();
            if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(str2)) {
                String str3 = host + "_" + str2;
                synchronized (this.a) {
                    OkHttpClient okHttpClient = (OkHttpClient) this.a.get(str3);
                    if (okHttpClient != null) {
                        return okHttpClient;
                    }
                    OkHttpClient.Builder t = b.t();
                    t.dns(new Dns() {
                        /* class com.ss.android.socialbase.downloader.impls.g.AnonymousClass2 */
                    });
                    OkHttpClient build = t.build();
                    synchronized (this.a) {
                        this.a.put(str3, build);
                    }
                    return build;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return b.s();
    }
}
