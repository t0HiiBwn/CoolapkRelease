package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.i.a;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.model.c;
import com.ss.android.socialbase.downloader.network.g;
import com.ss.android.socialbase.downloader.network.h;
import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: DefaultDownloadHeadHttpService */
public class f implements h {
    @Override // com.ss.android.socialbase.downloader.network.h
    public g a(String str, List<c> list) throws IOException {
        OkHttpClient s = b.s();
        if (s != null) {
            Request.Builder head = new Request.Builder().url(str).head();
            if (list != null && list.size() > 0) {
                for (c cVar : list) {
                    head.addHeader(cVar.a(), e.g(cVar.b()));
                }
            }
            final Call newCall = s.newCall(head.build());
            final Response execute = newCall.execute();
            if (execute != null) {
                if (a.a(2097152)) {
                    execute.close();
                }
                return new g() {
                    /* class com.ss.android.socialbase.downloader.impls.f.AnonymousClass1 */

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
                };
            }
            throw new IOException("can't get response");
        }
        throw new IOException("can't get httpClient");
    }
}
