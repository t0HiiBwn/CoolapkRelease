package com.pgl.a.b;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipFile;

public class b {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void a(String str, int i) {
        c.a("android.os.FileUtils", str, Integer.valueOf(i), -1, -1);
    }

    public static void a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean a(String str) {
        return new File(str).mkdirs();
    }
}
