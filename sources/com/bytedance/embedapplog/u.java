package com.bytedance.embedapplog;

import android.os.Build;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import org.json.JSONObject;

abstract class u {
    boolean a;
    boolean b;
    boolean c;
    boolean d;

    protected abstract boolean a(JSONObject jSONObject);

    u(boolean z, boolean z2) {
        this.b = z;
        this.c = z2;
        this.d = false;
    }

    u(boolean z, boolean z2, boolean z3) {
        this.b = z;
        this.c = z2;
        this.d = z3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b3 A[Catch:{ all -> 0x00d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00cd A[SYNTHETIC, Splitter:B:54:0x00cd] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d4 A[SYNTHETIC, Splitter:B:58:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00db A[SYNTHETIC, Splitter:B:64:0x00db] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00e2 A[SYNTHETIC, Splitter:B:68:0x00e2] */
    String a(String str, String str2) {
        Throwable th;
        RandomAccessFile randomAccessFile;
        IOException e;
        byte[] bArr;
        int read;
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return str2;
        }
        String str3 = Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.snssdk.api.embed/cache";
        String str4 = str3 + "/" + str;
        FileLock fileLock = null;
        try {
            File file = new File(str3);
            if (!file.exists() && !file.mkdirs()) {
                return str2;
            }
            File file2 = new File(str4);
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rwd");
            try {
                fileLock = randomAccessFile2.getChannel().lock();
                if (file2.isFile() && (read = randomAccessFile2.read((bArr = new byte[129]), 0, 129)) > 0 && read < 129) {
                    String str5 = new String(bArr, 0, read, "UTF-8");
                    if (aa.d(str5)) {
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (Exception unused) {
                            }
                        }
                        try {
                            randomAccessFile2.close();
                        } catch (Exception unused2) {
                        }
                        return str5;
                    }
                }
                byte[] bytes = str2.getBytes("UTF-8");
                randomAccessFile2.setLength(0);
                randomAccessFile2.write(bytes);
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (Exception unused3) {
                    }
                }
                try {
                    randomAccessFile2.close();
                } catch (Exception unused4) {
                }
                return str2;
            } catch (IOException e2) {
                randomAccessFile = randomAccessFile2;
                e = e2;
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        if (k.b().a.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
                            bo.a(e);
                        } else {
                            throw new SecurityException(e);
                        }
                    }
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (Exception unused5) {
                        }
                    }
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception unused6) {
                        }
                    }
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (Exception unused7) {
                        }
                    }
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception unused8) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                randomAccessFile = randomAccessFile2;
                th = th3;
                if (fileLock != null) {
                }
                if (randomAccessFile != null) {
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            randomAccessFile = null;
            if (Build.VERSION.SDK_INT >= 23) {
            }
            if (fileLock != null) {
            }
            if (randomAccessFile != null) {
            }
            return str2;
        } catch (Throwable th4) {
            th = th4;
            randomAccessFile = null;
            if (fileLock != null) {
            }
            if (randomAccessFile != null) {
            }
            throw th;
        }
    }
}
