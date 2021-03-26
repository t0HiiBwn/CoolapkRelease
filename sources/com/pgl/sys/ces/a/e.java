package com.pgl.sys.ces.a;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class e {
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ed, code lost:
        if (r8.length() == 0) goto L_0x00ef;
     */
    public static synchronized String a(Context context) {
        String str;
        synchronized (e.class) {
            try {
                String str2 = context.getFilesDir().getAbsolutePath() + "/cid";
                if (new File(str2).exists()) {
                    a("chmod 777 " + str2);
                    String a = a(str2);
                    a("chmod 600 " + str2);
                    if (a != null && a.length() > 0) {
                        return a;
                    }
                }
                InputStream open = context.getResources().getAssets().open("cid");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = open.read(bArr, 0, 4096);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                FileOutputStream fileOutputStream = new FileOutputStream(str2);
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                fileOutputStream.close();
                a("chmod 777 " + str2);
                str = a(str2);
                if (str == null || str.length() == 0) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(str2, "rw");
                    randomAccessFile.seek(16);
                    randomAccessFile.write(new byte[]{2});
                    randomAccessFile.close();
                    str = a(str2);
                }
                a("chmod 600 " + str2);
            } catch (Throwable unused) {
                str = "0[<!>]EXCEPTION[<!>]";
            }
            if (str != null) {
            }
            str = "0[<!>]ERROR[<!>]";
            return str;
        }
    }

    private static String a(BufferedInputStream bufferedInputStream) {
        int read;
        if (bufferedInputStream == null) {
            return "";
        }
        byte[] bArr = new byte[4096];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    sb.append(new String(bArr, 0, read));
                    continue;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (read >= 4096);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0046, code lost:
        if (r1 == null) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0048, code lost:
        r1.destroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0079, code lost:
        if (r1 != null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x007c, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0067 A[SYNTHETIC, Splitter:B:36:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0071 A[SYNTHETIC, Splitter:B:41:0x0071] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0081 A[SYNTHETIC, Splitter:B:50:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x008b A[SYNTHETIC, Splitter:B:55:0x008b] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0095  */
    private static String a(String str) {
        Throwable th;
        BufferedInputStream bufferedInputStream;
        Process process;
        BufferedInputStream bufferedInputStream2;
        BufferedOutputStream bufferedOutputStream;
        Exception e;
        BufferedInputStream bufferedInputStream3;
        BufferedOutputStream bufferedOutputStream2 = null;
        r0 = null;
        String str2 = null;
        bufferedOutputStream2 = null;
        try {
            process = Runtime.getRuntime().exec("sh");
            try {
                bufferedOutputStream = new BufferedOutputStream(process.getOutputStream());
            } catch (Exception e2) {
                e = e2;
                bufferedOutputStream = null;
                bufferedInputStream3 = bufferedOutputStream;
                try {
                    e.printStackTrace();
                    if (bufferedOutputStream != null) {
                    }
                    if (bufferedInputStream3 != null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = bufferedInputStream3;
                    bufferedOutputStream2 = bufferedOutputStream;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedOutputStream2 != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    if (process != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                if (process != null) {
                    process.destroy();
                }
                throw th;
            }
            try {
                BufferedInputStream bufferedInputStream4 = new BufferedInputStream(process.getInputStream());
                try {
                    bufferedOutputStream.write(str.getBytes());
                    bufferedOutputStream.write(10);
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    process.waitFor();
                    str2 = a(bufferedInputStream4);
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    try {
                        bufferedInputStream4.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                } catch (Exception e7) {
                    e = e7;
                    bufferedInputStream3 = bufferedInputStream4;
                    e.printStackTrace();
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    if (bufferedInputStream3 != null) {
                        try {
                            bufferedInputStream3.close();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                    }
                }
            } catch (Exception e10) {
                e = e10;
                bufferedInputStream3 = null;
                e.printStackTrace();
                if (bufferedOutputStream != null) {
                }
                if (bufferedInputStream3 != null) {
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream2 = null;
                bufferedOutputStream2 = bufferedOutputStream;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedOutputStream2 != null) {
                }
                if (bufferedInputStream != null) {
                }
                if (process != null) {
                }
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            process = null;
            bufferedOutputStream = null;
            bufferedInputStream3 = bufferedOutputStream;
            e.printStackTrace();
            if (bufferedOutputStream != null) {
            }
            if (bufferedInputStream3 != null) {
            }
        } catch (Throwable th5) {
            th = th5;
            process = null;
            bufferedInputStream = null;
            if (bufferedOutputStream2 != null) {
            }
            if (bufferedInputStream != null) {
            }
            if (process != null) {
            }
            throw th;
        }
    }
}
