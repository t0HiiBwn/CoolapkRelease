package com.qq.e.comm;

import android.content.Context;
import android.content.Intent;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.util.GDTLogger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class a {
    public static boolean a(Context context) {
        try {
            return b(context) && a(context, new Class[]{Class.forName(CustomPkgConstants.getADActivityName())}) && a(context, new Class[]{Class.forName(CustomPkgConstants.getPortraitADActivityName())}) && a(context, new Class[]{Class.forName(CustomPkgConstants.getLandscapeADActivityName())}) && b(context, new Class[]{Class.forName(CustomPkgConstants.getDownLoadServiceName())});
        } catch (Throwable th) {
            GDTLogger.e("Exception While check SDK Env", th);
            return false;
        }
    }

    private static boolean a(Context context, Class<?>... clsArr) {
        for (int i = 0; i <= 0; i++) {
            try {
                Intent intent = new Intent();
                intent.setClass(context, clsArr[0]);
                if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                    GDTLogger.e(String.format("Activity[%s] is required in AndroidManifest.xml", clsArr[0].getName()));
                    return false;
                }
            } catch (Throwable th) {
                GDTLogger.e("Exception while checking required activities", th);
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003d A[SYNTHETIC, Splitter:B:25:0x003d] */
    public static byte[] a(byte[] bArr) {
        Throwable th;
        Exception e;
        GZIPOutputStream gZIPOutputStream;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream2 = null;
        byte[] bArr2 = null;
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                bArr2 = byteArrayOutputStream.toByteArray();
                try {
                    gZIPOutputStream.close();
                    byteArrayOutputStream.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    if (gZIPOutputStream != null) {
                    }
                    byteArrayOutputStream.close();
                    return bArr2;
                } catch (Throwable th2) {
                    th = th2;
                    gZIPOutputStream2 = gZIPOutputStream;
                    if (gZIPOutputStream2 != null) {
                        try {
                            gZIPOutputStream2.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            throw th;
                        }
                    }
                    byteArrayOutputStream.close();
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            gZIPOutputStream = null;
            e.printStackTrace();
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
            }
            byteArrayOutputStream.close();
            return bArr2;
        } catch (Throwable th3) {
            th = th3;
            if (gZIPOutputStream2 != null) {
            }
            byteArrayOutputStream.close();
            throw th;
        }
        return bArr2;
    }

    private static boolean b(Context context) {
        String[] strArr = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE"};
        for (int i = 0; i < 3; i++) {
            try {
                String str = strArr[i];
                if (context.checkCallingOrSelfPermission(str) == -1) {
                    GDTLogger.e(String.format("Permission %s is required in AndroidManifest.xml", str));
                    return false;
                }
            } catch (Throwable th) {
                GDTLogger.e("Check required Permissions error", th);
                return false;
            }
        }
        return true;
    }

    private static boolean b(Context context, Class<?>... clsArr) {
        for (int i = 0; i <= 0; i++) {
            try {
                Class<?> cls = clsArr[0];
                Intent intent = new Intent();
                intent.setClass(context, cls);
                if (context.getPackageManager().resolveService(intent, 65536) == null) {
                    GDTLogger.e(String.format("Service[%s] is required in AndroidManifest.xml", cls.getName()));
                    return false;
                }
            } catch (Throwable th) {
                GDTLogger.e("Exception while checking required services", th);
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0055 A[SYNTHETIC, Splitter:B:28:0x0055] */
    public static byte[] b(byte[] bArr) {
        Throwable th;
        GZIPInputStream gZIPInputStream;
        Exception e;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[1024];
        byte[] bArr3 = null;
        GZIPInputStream gZIPInputStream2 = null;
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            while (true) {
                try {
                    int read = gZIPInputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        if (gZIPInputStream != null) {
                            gZIPInputStream.close();
                        }
                        byteArrayInputStream.close();
                        byteArrayOutputStream.close();
                        return bArr3;
                    } catch (Throwable th2) {
                        th = th2;
                        gZIPInputStream2 = gZIPInputStream;
                        if (gZIPInputStream2 != null) {
                            try {
                                gZIPInputStream2.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                throw th;
                            }
                        }
                        byteArrayInputStream.close();
                        byteArrayOutputStream.close();
                        throw th;
                    }
                }
            }
            byteArrayOutputStream.flush();
            bArr3 = byteArrayOutputStream.toByteArray();
            try {
                gZIPInputStream.close();
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        } catch (Exception e5) {
            e = e5;
            gZIPInputStream = null;
            e.printStackTrace();
            if (gZIPInputStream != null) {
            }
            byteArrayInputStream.close();
            byteArrayOutputStream.close();
            return bArr3;
        } catch (Throwable th3) {
            th = th3;
            if (gZIPInputStream2 != null) {
            }
            byteArrayInputStream.close();
            byteArrayOutputStream.close();
            throw th;
        }
        return bArr3;
    }
}
