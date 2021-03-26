package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.model.c;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.network.i;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* compiled from: LibUrlConnection4DZ */
public class f implements IDownloadHttpService {
    protected final WeakReference<Context> a;

    public f(Context context) {
        this.a = new WeakReference<>(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r4 = r5.getResponseCode();
     */
    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
    public i downloadWithConnection(int i, String str, List<c> list) throws IOException {
        final int responseCode;
        final HttpURLConnection a2 = a(str, list);
        if (a2 == null || responseCode < 200 || responseCode >= 300) {
            return null;
        }
        final Map<String, String> a3 = a(a2);
        InputStream inputStream = a2.getInputStream();
        String contentEncoding = a2.getContentEncoding();
        final GZIPInputStream gZIPInputStream = (TextUtils.isEmpty(contentEncoding) || !contentEncoding.contains("gzip")) ? inputStream : new GZIPInputStream(inputStream);
        return new i() {
            /* class com.bytedance.sdk.openadsdk.downloadnew.a.a.f.AnonymousClass1 */

            @Override // com.ss.android.socialbase.downloader.network.g
            public void c() {
            }

            @Override // com.ss.android.socialbase.downloader.network.i
            public InputStream a() {
                return gZIPInputStream;
            }

            @Override // com.ss.android.socialbase.downloader.network.g
            public String a(String str) {
                return (String) a3.get(str);
            }

            @Override // com.ss.android.socialbase.downloader.network.g
            public int b() {
                return responseCode;
            }

            @Override // com.ss.android.socialbase.downloader.network.i
            public void d() {
                try {
                    a2.disconnect();
                } catch (Exception unused) {
                }
            }
        };
    }

    private HttpURLConnection a(String str, List<c> list) {
        HttpURLConnection httpURLConnection = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setInstanceFollowRedirects(false);
                httpURLConnection2.setRequestProperty("accept", "*/*");
                httpURLConnection2.setRequestProperty("connection", "Keep-Alive");
                if (list != null && !list.isEmpty()) {
                    for (c cVar : list) {
                        httpURLConnection2.setRequestProperty(cVar.a(), cVar.b());
                    }
                }
                httpURLConnection2.connect();
                int responseCode = httpURLConnection2.getResponseCode();
                return ((responseCode < 200 || responseCode >= 300) && responseCode >= 300 && responseCode < 400) ? a(httpURLConnection2.getHeaderField("Location"), list) : httpURLConnection2;
            } catch (Exception unused) {
                httpURLConnection = httpURLConnection2;
                return httpURLConnection;
            }
        } catch (Exception unused2) {
            return httpURLConnection;
        }
    }

    private Map<String, String> a(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i = 0; i < size; i++) {
            hashMap.put(httpURLConnection.getHeaderFieldKey(i), httpURLConnection.getHeaderField(i));
        }
        return hashMap;
    }
}
