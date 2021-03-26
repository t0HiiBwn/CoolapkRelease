package com.bytedance.sdk.adnet.core;

import android.os.SystemClock;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.err.c;
import com.bytedance.sdk.adnet.err.d;
import com.bytedance.sdk.adnet.err.f;
import com.bytedance.sdk.adnet.err.g;
import com.bytedance.sdk.adnet.face.IHttpStack;
import com.bytedance.sdk.adnet.face.a;
import com.bytedance.sdk.adnet.face.b;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* compiled from: BasicNetwork */
public class a implements b {
    protected static final boolean a = o.a;
    protected final IHttpStack b;
    protected final b c;

    public a(IHttpStack iHttpStack) {
        this(iHttpStack, new b(4096));
    }

    public a(IHttpStack iHttpStack, b bVar) {
        this.b = iHttpStack;
        this.c = bVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0077, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0078, code lost:
        r14 = null;
        r2 = r11;
        r18 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c2, code lost:
        throw new java.io.IOException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00c3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00cd, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ce, code lost:
        r1 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00d0, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00d1, code lost:
        r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00d4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00d5, code lost:
        r18 = r1;
        r14 = null;
        r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00da, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00de, code lost:
        r2 = r11;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01ae A[SYNTHETIC, Splitter:B:112:0x01ae] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0177 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00d0 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x001b] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00da A[ExcHandler: MalformedURLException (e java.net.MalformedURLException), Splitter:B:5:0x001b] */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), SYNTHETIC, Splitter:B:5:0x001b] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ea A[SYNTHETIC, Splitter:B:68:0x00ea] */
    @Override // com.bytedance.sdk.adnet.face.b
    public i a(Request<?> request) throws VAdError {
        List<Header> list;
        byte[] bArr;
        IOException e;
        i iVar;
        HttpResponse performRequest;
        int statusCode;
        List<Header> headers;
        byte[] a2;
        List<Header> list2;
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            List<Header> emptyList = Collections.emptyList();
            HttpResponse httpResponse = null;
            try {
                performRequest = this.b.performRequest(request, a(request.getCacheEntry()));
                try {
                    statusCode = performRequest.getStatusCode();
                    headers = performRequest.getHeaders();
                } catch (SocketTimeoutException unused) {
                } catch (MalformedURLException e2) {
                } catch (IOException e3) {
                    e = e3;
                    list2 = headers;
                    list = list2;
                    httpResponse = performRequest;
                    bArr = a2;
                    if (httpResponse == null) {
                    }
                } catch (Throwable th) {
                }
            } catch (SocketTimeoutException unused2) {
                a("socket", request, new g());
                if (httpResponse != null) {
                    if (httpResponse.getContent() == null) {
                    }
                    httpResponse.getContent().close();
                }
            } catch (MalformedURLException e4) {
                MalformedURLException e5 = e4;
                throw new RuntimeException("Bad URL " + request.getUrl(), e5);
            } catch (IOException e6) {
                e = e6;
                list = emptyList;
                bArr = null;
                if (httpResponse == null) {
                    try {
                        int statusCode2 = httpResponse.getStatusCode();
                        o.c("Unexpected response code %d for %s", Integer.valueOf(statusCode2), request.getUrl());
                        if (bArr != null) {
                            iVar = new i(statusCode2, bArr, false, SystemClock.elapsedRealtime() - elapsedRealtime, list);
                            if (statusCode2 != 401) {
                                if (statusCode2 != 403) {
                                    if (statusCode2 >= 400) {
                                        if (statusCode2 <= 499) {
                                            throw new com.bytedance.sdk.adnet.err.b(iVar);
                                        }
                                    }
                                    if (statusCode2 < 500 || statusCode2 > 599) {
                                        throw new f(iVar);
                                    } else if (request.shouldRetryServerErrors()) {
                                        a("server", request, new f(iVar));
                                    } else {
                                        throw new f(iVar);
                                    }
                                }
                            }
                            a("auth", request, new com.bytedance.sdk.adnet.err.a(iVar));
                        } else {
                            a("network", request, new c());
                        }
                        if (httpResponse != null) {
                            try {
                                if (httpResponse.getContent() == null) {
                                }
                                httpResponse.getContent().close();
                            } catch (Throwable unused3) {
                            }
                        }
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        if (httpResponse != null) {
                            try {
                                if (httpResponse.getContent() != null) {
                                    httpResponse.getContent().close();
                                }
                            } catch (Throwable unused4) {
                            }
                        }
                        throw th3;
                    }
                } else {
                    throw new d(e);
                }
            }
            if (statusCode == 304) {
                a.C0035a cacheEntry = request.getCacheEntry();
                if (cacheEntry == null) {
                    i iVar2 = new i(304, (byte[]) null, true, SystemClock.elapsedRealtime() - elapsedRealtime, headers);
                    if (performRequest != null) {
                        try {
                            if (performRequest.getContent() != null) {
                                performRequest.getContent().close();
                            }
                        } catch (Throwable unused5) {
                        }
                    }
                    return iVar2;
                }
                i iVar3 = new i(304, cacheEntry.b, true, SystemClock.elapsedRealtime() - elapsedRealtime, a(headers, cacheEntry));
                if (performRequest != null) {
                    try {
                        if (performRequest.getContent() != null) {
                            performRequest.getContent().close();
                        }
                    } catch (Throwable unused6) {
                    }
                }
                return iVar3;
            }
            a2 = a(request, performRequest);
            a(SystemClock.elapsedRealtime() - elapsedRealtime, request, a2, statusCode);
            if (statusCode < 200 || statusCode > 299) {
                break;
            }
            list2 = headers;
            i iVar4 = new i(statusCode, a2, false, SystemClock.elapsedRealtime() - elapsedRealtime, list2);
            if (performRequest != null) {
                try {
                    if (performRequest.getContent() != null) {
                        performRequest.getContent().close();
                    }
                } catch (Throwable unused7) {
                }
            }
            return iVar4;
        }
        throw new f(iVar);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0022: APUT  (r0v2 java.lang.Object[]), (2 ??[int, float, short, byte, char]), (r5v0 java.lang.Object) */
    private void a(long j, Request<?> request, byte[] bArr, int i) {
        if (a || j > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Integer.valueOf(request.getRetryPolicy().b());
            o.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    private static void a(String str, Request<?> request, VAdError vAdError) throws VAdError {
        com.bytedance.sdk.adnet.face.d retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.a(vAdError);
            request.addMarker(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(timeoutMs)));
        } catch (VAdError e) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(timeoutMs)));
            throw e;
        }
    }

    private Map<String, String> a(a.C0035a aVar) {
        if (aVar == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        if (aVar.c != null) {
            hashMap.put("If-None-Match", aVar.c);
        }
        if (aVar.e > 0) {
            hashMap.put("If-Modified-Since", com.bytedance.sdk.adnet.d.b.a(aVar.e));
        }
        return hashMap;
    }

    protected byte[] a(Request<?> request, HttpResponse httpResponse) throws IOException, f {
        if (request instanceof com.bytedance.sdk.adnet.b.c) {
            return ((com.bytedance.sdk.adnet.b.c) request).a(httpResponse);
        }
        InputStream content = httpResponse.getContent();
        return content != null ? a(content, httpResponse.getContentLength()) : new byte[0];
    }

    private byte[] a(InputStream inputStream, int i) throws IOException, f {
        c cVar = new c(this.c, i);
        if (inputStream != null) {
            try {
                byte[] a2 = this.c.a(1024);
                while (true) {
                    int read = inputStream.read(a2);
                    if (read == -1) {
                        break;
                    }
                    cVar.write(a2, 0, read);
                }
                byte[] byteArray = cVar.toByteArray();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                        o.a("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.c.a(a2);
                cVar.close();
                return byteArray;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                        o.a("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.c.a((byte[]) null);
                cVar.close();
                throw th;
            }
        } else {
            throw new f();
        }
    }

    private static List<Header> a(List<Header> list, a.C0035a aVar) {
        ArrayList arrayList = new ArrayList();
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (list != null && !list.isEmpty()) {
            for (Header header : list) {
                treeSet.add(header.getName());
                arrayList.add(header);
            }
        }
        if (aVar != null) {
            if (aVar.i != null) {
                if (!aVar.i.isEmpty()) {
                    for (Header header2 : aVar.i) {
                        if (!treeSet.contains(header2.getName())) {
                            arrayList.add(header2);
                        }
                    }
                }
            } else if (!aVar.h.isEmpty()) {
                for (Map.Entry<String, String> entry : aVar.h.entrySet()) {
                    if (!treeSet.contains(entry.getKey())) {
                        arrayList.add(new Header(entry.getKey(), entry.getValue()));
                    }
                }
            }
        }
        return arrayList;
    }
}
