package com.huawei.hms.stats;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Map;
import javax.net.SocketFactory;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;

public abstract class ai {

    private static class a extends Exception {
        a(String str) {
            super(str);
        }
    }

    public static aj a(String str, byte[] bArr, Map<String, String> map) {
        return a(str, bArr, map, "POST");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x00fc  */
    public static aj a(String str, byte[] bArr, Map<String, String> map, String str2) {
        OutputStream outputStream;
        Throwable th;
        HttpURLConnection httpURLConnection;
        BufferedOutputStream bufferedOutputStream;
        if (TextUtils.isEmpty(str)) {
            return new aj(-100, "");
        }
        int i = -102;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            httpURLConnection = a(str, bArr.length, map, str2);
            if (httpURLConnection == null) {
                try {
                    aj ajVar = new aj(-101, "");
                    ba.a((Closeable) null);
                    ba.a((Closeable) null);
                    if (httpURLConnection != null) {
                        ba.a(httpURLConnection);
                    }
                    return ajVar;
                } catch (a unused) {
                    outputStream = null;
                    af.c("HttpClient", "PostRequest(byte[]): No ssl socket factory set!");
                    aj ajVar2 = new aj(-101, "");
                    ba.a((Closeable) bufferedOutputStream2);
                    ba.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return ajVar2;
                } catch (SecurityException unused2) {
                    outputStream = null;
                    af.c("HttpClient", "SecurityException with HttpClient. Please check INTERNET permission.");
                    aj ajVar3 = new aj(i, "");
                    ba.a((Closeable) bufferedOutputStream2);
                    ba.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return ajVar3;
                } catch (SSLPeerUnverifiedException unused3) {
                    outputStream = null;
                    af.c("HttpClient", "Certificate has not been verified,Request is restricted!");
                    aj ajVar4 = new aj(i, "");
                    ba.a((Closeable) bufferedOutputStream2);
                    ba.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return ajVar4;
                } catch (SSLHandshakeException unused4) {
                    outputStream = null;
                    af.c("HttpClient", "Chain validation failed,Certificate expired");
                    aj ajVar5 = new aj(i, "");
                    ba.a((Closeable) bufferedOutputStream2);
                    ba.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return ajVar5;
                } catch (ConnectException unused5) {
                    outputStream = null;
                    af.c("HttpClient", "Network is unreachable or Connection refused");
                    aj ajVar6 = new aj(i, "");
                    ba.a((Closeable) bufferedOutputStream2);
                    ba.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return ajVar6;
                } catch (UnknownHostException unused6) {
                    outputStream = null;
                    af.c("HttpClient", "No address associated with hostname or No network");
                    aj ajVar7 = new aj(i, "");
                    ba.a((Closeable) bufferedOutputStream2);
                    ba.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return ajVar7;
                } catch (IOException unused7) {
                    outputStream = null;
                    try {
                        af.c("HttpClient", "events PostRequest(byte[]): IOException occurred.");
                        aj ajVar8 = new aj(i, "");
                        ba.a((Closeable) bufferedOutputStream2);
                        ba.a((Closeable) outputStream);
                        if (httpURLConnection != null) {
                        }
                        return ajVar8;
                    } catch (Throwable th2) {
                        th = th2;
                        ba.a((Closeable) bufferedOutputStream2);
                        ba.a((Closeable) outputStream);
                        if (httpURLConnection != null) {
                            ba.a(httpURLConnection);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = null;
                    ba.a((Closeable) bufferedOutputStream2);
                    ba.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    throw th;
                }
            } else {
                outputStream = httpURLConnection.getOutputStream();
                try {
                    bufferedOutputStream = new BufferedOutputStream(outputStream);
                } catch (a unused8) {
                    af.c("HttpClient", "PostRequest(byte[]): No ssl socket factory set!");
                    aj ajVar2 = new aj(-101, "");
                    ba.a((Closeable) bufferedOutputStream2);
                    ba.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return ajVar2;
                } catch (SecurityException unused9) {
                    af.c("HttpClient", "SecurityException with HttpClient. Please check INTERNET permission.");
                    aj ajVar3 = new aj(i, "");
                    ba.a((Closeable) bufferedOutputStream2);
                    ba.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return ajVar3;
                } catch (SSLPeerUnverifiedException unused10) {
                    af.c("HttpClient", "Certificate has not been verified,Request is restricted!");
                    aj ajVar4 = new aj(i, "");
                    ba.a((Closeable) bufferedOutputStream2);
                    ba.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return ajVar4;
                } catch (SSLHandshakeException unused11) {
                    af.c("HttpClient", "Chain validation failed,Certificate expired");
                    aj ajVar5 = new aj(i, "");
                    ba.a((Closeable) bufferedOutputStream2);
                    ba.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return ajVar5;
                } catch (ConnectException unused12) {
                    af.c("HttpClient", "Network is unreachable or Connection refused");
                    aj ajVar6 = new aj(i, "");
                    ba.a((Closeable) bufferedOutputStream2);
                    ba.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return ajVar6;
                } catch (UnknownHostException unused13) {
                    af.c("HttpClient", "No address associated with hostname or No network");
                    aj ajVar7 = new aj(i, "");
                    ba.a((Closeable) bufferedOutputStream2);
                    ba.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return ajVar7;
                } catch (IOException unused14) {
                    af.c("HttpClient", "events PostRequest(byte[]): IOException occurred.");
                    aj ajVar8 = new aj(i, "");
                    ba.a((Closeable) bufferedOutputStream2);
                    ba.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return ajVar8;
                }
                try {
                    bufferedOutputStream.write(bArr);
                    bufferedOutputStream.flush();
                    i = httpURLConnection.getResponseCode();
                    aj ajVar9 = new aj(i, b(httpURLConnection));
                    ba.a((Closeable) bufferedOutputStream);
                    ba.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                        ba.a(httpURLConnection);
                    }
                    return ajVar9;
                } catch (a unused15) {
                    bufferedOutputStream2 = bufferedOutputStream;
                    af.c("HttpClient", "PostRequest(byte[]): No ssl socket factory set!");
                    aj ajVar2 = new aj(-101, "");
                    ba.a((Closeable) bufferedOutputStream2);
                    ba.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return ajVar2;
                } catch (SecurityException unused16) {
                    bufferedOutputStream2 = bufferedOutputStream;
                    af.c("HttpClient", "SecurityException with HttpClient. Please check INTERNET permission.");
                    aj ajVar3 = new aj(i, "");
                    ba.a((Closeable) bufferedOutputStream2);
                    ba.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return ajVar3;
                } catch (SSLPeerUnverifiedException unused17) {
                    bufferedOutputStream2 = bufferedOutputStream;
                    af.c("HttpClient", "Certificate has not been verified,Request is restricted!");
                    aj ajVar4 = new aj(i, "");
                    ba.a((Closeable) bufferedOutputStream2);
                    ba.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return ajVar4;
                } catch (SSLHandshakeException unused18) {
                    bufferedOutputStream2 = bufferedOutputStream;
                    af.c("HttpClient", "Chain validation failed,Certificate expired");
                    aj ajVar5 = new aj(i, "");
                    ba.a((Closeable) bufferedOutputStream2);
                    ba.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return ajVar5;
                } catch (ConnectException unused19) {
                    bufferedOutputStream2 = bufferedOutputStream;
                    af.c("HttpClient", "Network is unreachable or Connection refused");
                    aj ajVar6 = new aj(i, "");
                    ba.a((Closeable) bufferedOutputStream2);
                    ba.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return ajVar6;
                } catch (UnknownHostException unused20) {
                    bufferedOutputStream2 = bufferedOutputStream;
                    af.c("HttpClient", "No address associated with hostname or No network");
                    aj ajVar7 = new aj(i, "");
                    ba.a((Closeable) bufferedOutputStream2);
                    ba.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return ajVar7;
                } catch (IOException unused21) {
                    bufferedOutputStream2 = bufferedOutputStream;
                    af.c("HttpClient", "events PostRequest(byte[]): IOException occurred.");
                    aj ajVar8 = new aj(i, "");
                    ba.a((Closeable) bufferedOutputStream2);
                    ba.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    return ajVar8;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedOutputStream2 = bufferedOutputStream;
                    ba.a((Closeable) bufferedOutputStream2);
                    ba.a((Closeable) outputStream);
                    if (httpURLConnection != null) {
                    }
                    throw th;
                }
            }
        } catch (a unused22) {
            httpURLConnection = null;
            outputStream = null;
            af.c("HttpClient", "PostRequest(byte[]): No ssl socket factory set!");
            aj ajVar2 = new aj(-101, "");
            ba.a((Closeable) bufferedOutputStream2);
            ba.a((Closeable) outputStream);
            if (httpURLConnection != null) {
                ba.a(httpURLConnection);
            }
            return ajVar2;
        } catch (SecurityException unused23) {
            httpURLConnection = null;
            outputStream = null;
            af.c("HttpClient", "SecurityException with HttpClient. Please check INTERNET permission.");
            aj ajVar3 = new aj(i, "");
            ba.a((Closeable) bufferedOutputStream2);
            ba.a((Closeable) outputStream);
            if (httpURLConnection != null) {
                ba.a(httpURLConnection);
            }
            return ajVar3;
        } catch (SSLPeerUnverifiedException unused24) {
            httpURLConnection = null;
            outputStream = null;
            af.c("HttpClient", "Certificate has not been verified,Request is restricted!");
            aj ajVar4 = new aj(i, "");
            ba.a((Closeable) bufferedOutputStream2);
            ba.a((Closeable) outputStream);
            if (httpURLConnection != null) {
                ba.a(httpURLConnection);
            }
            return ajVar4;
        } catch (SSLHandshakeException unused25) {
            httpURLConnection = null;
            outputStream = null;
            af.c("HttpClient", "Chain validation failed,Certificate expired");
            aj ajVar5 = new aj(i, "");
            ba.a((Closeable) bufferedOutputStream2);
            ba.a((Closeable) outputStream);
            if (httpURLConnection != null) {
                ba.a(httpURLConnection);
            }
            return ajVar5;
        } catch (ConnectException unused26) {
            httpURLConnection = null;
            outputStream = null;
            af.c("HttpClient", "Network is unreachable or Connection refused");
            aj ajVar6 = new aj(i, "");
            ba.a((Closeable) bufferedOutputStream2);
            ba.a((Closeable) outputStream);
            if (httpURLConnection != null) {
                ba.a(httpURLConnection);
            }
            return ajVar6;
        } catch (UnknownHostException unused27) {
            httpURLConnection = null;
            outputStream = null;
            af.c("HttpClient", "No address associated with hostname or No network");
            aj ajVar7 = new aj(i, "");
            ba.a((Closeable) bufferedOutputStream2);
            ba.a((Closeable) outputStream);
            if (httpURLConnection != null) {
                ba.a(httpURLConnection);
            }
            return ajVar7;
        } catch (IOException unused28) {
            httpURLConnection = null;
            outputStream = null;
            af.c("HttpClient", "events PostRequest(byte[]): IOException occurred.");
            aj ajVar8 = new aj(i, "");
            ba.a((Closeable) bufferedOutputStream2);
            ba.a((Closeable) outputStream);
            if (httpURLConnection != null) {
                ba.a(httpURLConnection);
            }
            return ajVar8;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            outputStream = null;
            ba.a((Closeable) bufferedOutputStream2);
            ba.a((Closeable) outputStream);
            if (httpURLConnection != null) {
            }
            throw th;
        }
    }

    private static HttpURLConnection a(String str, int i, Map<String, String> map, String str2) {
        if (TextUtils.isEmpty(str)) {
            af.d("HttpClient", "CreateConnection: invalid urlPath.");
            return null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        a(httpURLConnection);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(i));
        httpURLConnection.setRequestProperty("Connection", "close");
        if (map != null && map.size() >= 1) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && !TextUtils.isEmpty(key)) {
                    httpURLConnection.setRequestProperty(key, entry.getValue());
                }
            }
        }
        return httpURLConnection;
    }

    private static void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            SocketFactory a2 = ah.a(b.j());
            if (a2 == null || !(a2 instanceof SSLSocketFactory)) {
                throw new a("No ssl socket factory set");
            }
            httpsURLConnection.setSSLSocketFactory((SSLSocketFactory) a2);
            httpsURLConnection.setHostnameVerifier(new StrictHostnameVerifier());
        }
    }

    /* JADX INFO: finally extract failed */
    private static String b(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            String a2 = ba.a(inputStream);
            ba.a((Closeable) inputStream);
            return a2;
        } catch (IOException unused) {
            int responseCode = httpURLConnection.getResponseCode();
            af.c("HttpClient", "When Response Content From Connection inputStream operation exception! " + responseCode);
            ba.a((Closeable) inputStream);
            return "";
        } catch (Throwable th) {
            ba.a((Closeable) inputStream);
            throw th;
        }
    }
}
