package com.kepler.sdk;

import android.content.Context;
import android.os.Environment;
import com.kepler.jd.login.KeplerApiManager;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

public class y {
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044 A[SYNTHETIC, Splitter:B:23:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004f A[SYNTHETIC, Splitter:B:30:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005a A[SYNTHETIC, Splitter:B:37:0x005a] */
    public static String a(File file) {
        Throwable th;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                String format = String.format("%032x", new BigInteger(1, instance.digest()));
                try {
                    fileInputStream2.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return format;
            } catch (Exception unused) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                return "";
            } catch (Error unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                return "";
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                throw th;
            }
        } catch (Exception unused3) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return "";
        } catch (Error unused4) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            return "";
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static File a() {
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                if (!Environment.getExternalStorageDirectory().exists() || !Environment.getExternalStorageDirectory().canWrite()) {
                    Context applicatonContext = KeplerApiManager.getWebViewService().getApplicatonContext();
                    if (applicatonContext != null) {
                        return applicatonContext.getCacheDir();
                    }
                    return Environment.getDataDirectory();
                }
            }
            Context applicatonContext2 = KeplerApiManager.getWebViewService().getApplicatonContext();
            if (applicatonContext2 != null) {
                return applicatonContext2.getExternalCacheDir();
            }
            return Environment.getExternalStorageDirectory();
        } catch (Exception unused) {
            return null;
        }
    }

    public static File b() {
        try {
            File file = new File(a(), "com.jd.jdsdk");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, ".nomedia");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            return file;
        } catch (Exception unused) {
            return null;
        }
    }

    public static File c() {
        try {
            File file = new File(b(), "module");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void b(File file) {
        if (file != null && file != null) {
            try {
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
            } catch (Exception unused) {
            }
        }
    }
}
