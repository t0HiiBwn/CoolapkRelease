package com.tencent.tpns.baseapi.base.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.tpns.baseapi.core.net.HttpRequestCallback;
import com.tencent.tpns.baseapi.core.net.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class CommonHelper {
    public static boolean jsonPut(JSONObject jSONObject, String str, Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            jSONObject.put(str, obj);
            return true;
        } catch (JSONException e) {
            Logger.e("CommonHelper", "unexpected for jsonPush:" + e.getMessage());
            return false;
        }
    }

    public static Object jsonGet(JSONObject jSONObject, String str, Object obj) {
        try {
            if (jSONObject.has(str)) {
                return jSONObject.get(str);
            }
        } catch (JSONException e) {
            Logger.e("CommonHelper", "unexpected for jsonGet:" + e.getMessage());
        }
        return obj;
    }

    public static Object getMetaData(Context context, String str, Object obj) {
        Object obj2;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (obj2 = applicationInfo.metaData.get(str)) == null) {
                return obj;
            }
            return obj2;
        } catch (Throwable unused) {
            Logger.e("CommonHelper", "unexpected for getMetaData:" + str);
        }
    }

    public static boolean safeClose(Closeable closeable) {
        if (closeable == null) {
            return false;
        }
        try {
            closeable.close();
            return true;
        } catch (Throwable th) {
            Logger.e("CommonHelper", "unexpected for safeClose:" + th.getMessage());
            return false;
        }
    }

    public static boolean checkManifestIfComponentConfiged(Context context, String str) {
        try {
            context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), str), 0);
            return true;
        } catch (Throwable th) {
            Logger.e("CommonHelper", "CommonHelper -> checkManifestIfComponentConfiged", th);
            return false;
        }
    }

    public static boolean isIPValid(String str) {
        if (str == null || str.length() < 7 || str.length() > 15 || "".equals(str)) {
            return false;
        }
        return Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(str).find();
    }

    public static String getOfflineMsg(Context context, String str, String str2, HttpRequestCallback httpRequestCallback) {
        try {
            if (CloudManager.getInstance(context).isCloudRefuse()) {
                Logger.i("CommonHelper", "getOfflineMsg refused by cloud");
                return "";
            }
            return a.a(context).a(str, a.a(str), str2, httpRequestCallback);
        } catch (Throwable th) {
            Logger.w("CommonHelper", "unexpected for getOfflineMsg, exception:", th);
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x003a A[SYNTHETIC, Splitter:B:24:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0041 A[SYNTHETIC, Splitter:B:28:0x0041] */
    public static byte[] encodeGZipContent(byte[] bArr) {
        Object th;
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(bArr);
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable unused2) {
                    }
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        Logger.e("CommonHelper", "encode gzip content failed, error " + th);
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (Throwable unused3) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable unused4) {
                            }
                        }
                        return null;
                    } catch (Throwable unused5) {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                gZIPOutputStream = null;
                Logger.e("CommonHelper", "encode gzip content failed, error " + th);
                if (gZIPOutputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                return null;
            }
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            gZIPOutputStream = null;
            Logger.e("CommonHelper", "encode gzip content failed, error " + th);
            if (gZIPOutputStream != null) {
            }
            if (byteArrayOutputStream != null) {
            }
            return null;
        }
        throw th;
        if (byteArrayOutputStream != null) {
            byteArrayOutputStream.close();
        }
        throw th;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.zip.GZIPInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: java.util.zip.GZIPInputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0055 A[SYNTHETIC, Splitter:B:35:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x005c A[SYNTHETIC, Splitter:B:39:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0063 A[SYNTHETIC, Splitter:B:43:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0078 A[SYNTHETIC, Splitter:B:57:0x0078] */
    public static byte[] decodeGZipContent(byte[] bArr) {
        Object th;
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                GZIPInputStream gZIPInputStream2 = new GZIPInputStream(byteArrayInputStream);
                try {
                    byte[] bArr2 = new byte[4096];
                    byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
                    while (true) {
                        try {
                            int read = gZIPInputStream2.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr2, 0, read);
                        } catch (Throwable th2) {
                            th = th2;
                            gZIPInputStream = gZIPInputStream2;
                            try {
                                Logger.e("CommonHelper", "decode gzip content failed, error " + th);
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Throwable unused) {
                                    }
                                }
                                if (gZIPInputStream != 0) {
                                    try {
                                        gZIPInputStream.close();
                                    } catch (Throwable unused2) {
                                    }
                                }
                                if (byteArrayInputStream != null) {
                                    try {
                                        byteArrayInputStream.close();
                                    } catch (Throwable unused3) {
                                    }
                                }
                                return null;
                            } catch (Throwable unused4) {
                            }
                        }
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable unused5) {
                    }
                    try {
                        gZIPInputStream2.close();
                    } catch (Throwable unused6) {
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable unused7) {
                    }
                    return byteArray;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                    gZIPInputStream = gZIPInputStream2;
                    Logger.e("CommonHelper", "decode gzip content failed, error " + th);
                    if (byteArrayOutputStream != null) {
                    }
                    if (gZIPInputStream != 0) {
                    }
                    if (byteArrayInputStream != null) {
                    }
                    return null;
                }
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream2 = null;
                byteArrayOutputStream = byteArrayOutputStream2;
                gZIPInputStream = byteArrayOutputStream2;
                Logger.e("CommonHelper", "decode gzip content failed, error " + th);
                if (byteArrayOutputStream != null) {
                }
                if (gZIPInputStream != 0) {
                }
                if (byteArrayInputStream != null) {
                }
                return null;
            }
        } catch (Throwable th5) {
            th = th5;
            byteArrayInputStream = null;
            byteArrayOutputStream2 = null;
            byteArrayOutputStream = byteArrayOutputStream2;
            gZIPInputStream = byteArrayOutputStream2;
            Logger.e("CommonHelper", "decode gzip content failed, error " + th);
            if (byteArrayOutputStream != null) {
            }
            if (gZIPInputStream != 0) {
            }
            if (byteArrayInputStream != null) {
            }
            return null;
        }
        if (byteArrayInputStream != null) {
            byteArrayInputStream.close();
        }
        throw th;
        throw th;
        if (gZIPInputStream != 0) {
            gZIPInputStream.close();
        }
        if (byteArrayInputStream != null) {
        }
        throw th;
    }
}
