package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.mm.opensdk.utils.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public final class e {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0113 A[SYNTHETIC, Splitter:B:102:0x0113] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0130 A[SYNTHETIC, Splitter:B:111:0x0130] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0137 A[SYNTHETIC, Splitter:B:115:0x0137] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x013e A[SYNTHETIC, Splitter:B:119:0x013e] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0146 A[SYNTHETIC, Splitter:B:126:0x0146] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x014d A[SYNTHETIC, Splitter:B:130:0x014d] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0154 A[SYNTHETIC, Splitter:B:134:0x0154] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00da A[SYNTHETIC, Splitter:B:77:0x00da] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e1 A[SYNTHETIC, Splitter:B:81:0x00e1] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00e8 A[SYNTHETIC, Splitter:B:85:0x00e8] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0105 A[SYNTHETIC, Splitter:B:94:0x0105] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x010c A[SYNTHETIC, Splitter:B:98:0x010c] */
    public static byte[] a(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        Throwable th;
        HttpURLConnection httpURLConnection;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream3;
        InputStream inputStream2;
        MalformedURLException e;
        ByteArrayOutputStream byteArrayOutputStream4;
        InputStream inputStream3;
        IOException e2;
        ByteArrayOutputStream byteArrayOutputStream5;
        Exception e3;
        HttpURLConnection httpURLConnection2 = null;
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.SDK.NetUtil", "httpGet, url is null");
            return null;
        }
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection == null) {
                try {
                    Log.e("MicroMsg.SDK.NetUtil", "open connection failed.");
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused) {
                        }
                    }
                    return null;
                } catch (MalformedURLException e4) {
                    e = e4;
                    inputStream2 = null;
                    byteArrayOutputStream3 = inputStream2;
                    Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e.getMessage());
                    if (httpURLConnection != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    if (byteArrayOutputStream3 != 0) {
                    }
                    return null;
                } catch (IOException e5) {
                    e2 = e5;
                    inputStream3 = null;
                    byteArrayOutputStream4 = inputStream3;
                    Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e2.getMessage());
                    if (httpURLConnection != null) {
                    }
                    if (inputStream3 != null) {
                    }
                    if (byteArrayOutputStream4 != 0) {
                    }
                    return null;
                } catch (Exception e6) {
                    e3 = e6;
                    inputStream = null;
                    byteArrayOutputStream5 = inputStream;
                    try {
                        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e3.getMessage());
                        if (httpURLConnection != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (byteArrayOutputStream5 != 0) {
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream2 = byteArrayOutputStream5;
                        httpURLConnection2 = httpURLConnection;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        if (httpURLConnection2 != null) {
                            try {
                                httpURLConnection2.disconnect();
                            } catch (Throwable unused2) {
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused3) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable unused4) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    byteArrayOutputStream2 = null;
                    httpURLConnection2 = httpURLConnection;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (httpURLConnection2 != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    throw th;
                }
            } else {
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(60000);
                httpURLConnection.setReadTimeout(60000);
                if (httpURLConnection.getResponseCode() >= 300) {
                    Log.e("MicroMsg.SDK.NetUtil", "httpURLConnectionGet 300");
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused5) {
                        }
                    }
                    return null;
                }
                InputStream inputStream4 = httpURLConnection.getInputStream();
                try {
                    ByteArrayOutputStream byteArrayOutputStream6 = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream4.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream6.write(bArr, 0, read);
                        }
                        byte[] byteArray = byteArrayOutputStream6.toByteArray();
                        Log.d("MicroMsg.SDK.NetUtil", "httpGet end");
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable unused6) {
                            }
                        }
                        if (inputStream4 != null) {
                            try {
                                inputStream4.close();
                            } catch (Throwable unused7) {
                            }
                        }
                        try {
                            byteArrayOutputStream6.close();
                        } catch (Throwable unused8) {
                        }
                        return byteArray;
                    } catch (MalformedURLException e7) {
                        inputStream2 = inputStream4;
                        e = e7;
                        byteArrayOutputStream3 = byteArrayOutputStream6;
                        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e.getMessage());
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable unused9) {
                            }
                        }
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Throwable unused10) {
                            }
                        }
                        if (byteArrayOutputStream3 != 0) {
                            try {
                                byteArrayOutputStream3.close();
                            } catch (Throwable unused11) {
                            }
                        }
                        return null;
                    } catch (IOException e8) {
                        inputStream3 = inputStream4;
                        e2 = e8;
                        byteArrayOutputStream4 = byteArrayOutputStream6;
                        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e2.getMessage());
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable unused12) {
                            }
                        }
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (Throwable unused13) {
                            }
                        }
                        if (byteArrayOutputStream4 != 0) {
                            try {
                                byteArrayOutputStream4.close();
                            } catch (Throwable unused14) {
                            }
                        }
                        return null;
                    } catch (Exception e9) {
                        inputStream = inputStream4;
                        e3 = e9;
                        byteArrayOutputStream5 = byteArrayOutputStream6;
                        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e3.getMessage());
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable unused15) {
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused16) {
                            }
                        }
                        if (byteArrayOutputStream5 != 0) {
                            try {
                                byteArrayOutputStream5.close();
                            } catch (Throwable unused17) {
                            }
                        }
                        return null;
                    } catch (Throwable th4) {
                        th = th4;
                        httpURLConnection2 = httpURLConnection;
                        byteArrayOutputStream = byteArrayOutputStream6;
                        inputStream = inputStream4;
                        if (httpURLConnection2 != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (MalformedURLException e10) {
                    byteArrayOutputStream3 = 0;
                    inputStream2 = inputStream4;
                    e = e10;
                    Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e.getMessage());
                    if (httpURLConnection != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    if (byteArrayOutputStream3 != 0) {
                    }
                    return null;
                } catch (IOException e11) {
                    byteArrayOutputStream4 = 0;
                    inputStream3 = inputStream4;
                    e2 = e11;
                    Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e2.getMessage());
                    if (httpURLConnection != null) {
                    }
                    if (inputStream3 != null) {
                    }
                    if (byteArrayOutputStream4 != 0) {
                    }
                    return null;
                } catch (Exception e12) {
                    byteArrayOutputStream5 = 0;
                    inputStream = inputStream4;
                    e3 = e12;
                    Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e3.getMessage());
                    if (httpURLConnection != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (byteArrayOutputStream5 != 0) {
                    }
                    return null;
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayOutputStream2 = null;
                    inputStream = inputStream4;
                    httpURLConnection2 = httpURLConnection;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (httpURLConnection2 != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    throw th;
                }
            }
        } catch (MalformedURLException e13) {
            e = e13;
            httpURLConnection = null;
            inputStream2 = null;
            byteArrayOutputStream3 = inputStream2;
            Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e.getMessage());
            if (httpURLConnection != null) {
            }
            if (inputStream2 != null) {
            }
            if (byteArrayOutputStream3 != 0) {
            }
            return null;
        } catch (IOException e14) {
            e2 = e14;
            httpURLConnection = null;
            inputStream3 = null;
            byteArrayOutputStream4 = inputStream3;
            Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e2.getMessage());
            if (httpURLConnection != null) {
            }
            if (inputStream3 != null) {
            }
            if (byteArrayOutputStream4 != 0) {
            }
            return null;
        } catch (Exception e15) {
            e3 = e15;
            httpURLConnection = null;
            inputStream = null;
            byteArrayOutputStream5 = inputStream;
            Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e3.getMessage());
            if (httpURLConnection != null) {
            }
            if (inputStream != null) {
            }
            if (byteArrayOutputStream5 != 0) {
            }
            return null;
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
            byteArrayOutputStream = null;
            if (httpURLConnection2 != null) {
            }
            if (inputStream != null) {
            }
            if (byteArrayOutputStream != null) {
            }
            throw th;
        }
    }
}
