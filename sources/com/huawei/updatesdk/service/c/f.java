package com.huawei.updatesdk.service.c;

import com.huawei.updatesdk.a.a.b.a.a.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class f {
    public static boolean a(File file, File file2) {
        boolean z = false;
        if (!file.renameTo(file2)) {
            if (!b(file, file2)) {
                a.d("PkgManageUtils", "can not copy the file to new Path");
                return false;
            }
            z = true;
        }
        if (z && !file.delete()) {
            a.d("PkgManageUtils", "can not delete old file");
        }
        return true;
    }

    private static boolean a(InputStream inputStream, File file) {
        String str = "";
        try {
            String str2 = "PkgManageUtils";
            if (file.exists() && !file.delete()) {
                a.b("PkgManageUtils", "destFile delete error.");
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read >= 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException e) {
                        }
                    }
                }
                try {
                    return true;
                } catch (IOException e2) {
                    return true;
                }
            } finally {
                try {
                    fileOutputStream.flush();
                } catch (IOException e) {
                    a.a(str2, str, e);
                }
                try {
                    fileOutputStream.getFD().sync();
                } catch (IOException e3) {
                    a.a(str2, str, e3);
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                    a.a(str2, str, e2);
                }
            }
        } catch (IOException unused) {
            return false;
        }
    }

    private static boolean b(File file, File file2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                return a(fileInputStream, file2);
            } finally {
                fileInputStream.close();
            }
        } catch (IOException unused) {
            a.d("PkgManageUtils", "copyFile IOException");
            return false;
        }
    }
}
