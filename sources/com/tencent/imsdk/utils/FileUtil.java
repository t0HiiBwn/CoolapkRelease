package com.tencent.imsdk.utils;

import java.io.Closeable;
import java.io.IOException;

public class FileUtil {
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
