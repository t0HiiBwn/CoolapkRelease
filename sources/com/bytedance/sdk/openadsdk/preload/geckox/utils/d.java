package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import android.os.Process;
import com.bytedance.sdk.openadsdk.preload.geckox.h.b;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: FileUtils */
public class d {
    public static boolean a(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        b.a("gecko-debug-tag", "delete file，pid:", Integer.valueOf(Process.myPid()), ", thread:", Thread.currentThread().toString(), ", file:" + file.getAbsolutePath());
        return d(file);
    }

    private static boolean d(File file) {
        boolean z;
        File[] listFiles;
        if (file == null || !file.exists()) {
            return true;
        }
        if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
            z = true;
        } else {
            z = true;
            for (File file2 : listFiles) {
                z = z && d(file2);
            }
        }
        if (!z || !file.delete()) {
            return false;
        }
        return true;
    }

    public static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read != -1) {
                bufferedOutputStream.write(bArr, 0, read);
            } else {
                bufferedOutputStream.flush();
                return;
            }
        }
    }

    public static List<File> b(File file) {
        if (file == null || !file.exists() || !file.isDirectory()) {
            return null;
        }
        List<File> asList = Arrays.asList(file.listFiles());
        Collections.sort(asList, new Comparator<File>() {
            /* class com.bytedance.sdk.openadsdk.preload.geckox.utils.d.AnonymousClass1 */

            /* renamed from: a */
            public int compare(File file, File file2) {
                return Long.compare(file.lastModified(), file2.lastModified());
            }
        });
        return asList;
    }

    public static boolean c(File file) {
        String[] list;
        if (file.isDirectory()) {
            for (String str : file.list()) {
                if (!c(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }
}
