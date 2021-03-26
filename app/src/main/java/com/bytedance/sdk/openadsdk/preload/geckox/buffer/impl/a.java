package com.bytedance.sdk.openadsdk.preload.geckox.buffer.impl;

import android.content.Context;
import com.bytedance.sdk.openadsdk.preload.geckox.h.b;
import java.io.File;
import java.io.IOException;

/* compiled from: BufferPolicy */
public class a {
    public static com.bytedance.sdk.openadsdk.preload.geckox.buffer.a a(Context context, File file, long j) throws IOException {
        com.bytedance.sdk.openadsdk.preload.geckox.buffer.a b = b(context, file, j);
        b.a("gecko-debug-tag", "buffer type:" + b.getClass());
        return b;
    }

    private static com.bytedance.sdk.openadsdk.preload.geckox.buffer.a b(Context context, File file, long j) throws IOException {
        if (j <= 0) {
            try {
                return new b(file);
            } catch (Exception e) {
                throw new IOException("create FileBuffer failed! file:" + file.getAbsolutePath() + " caused by:" + e.getMessage(), e);
            }
        } else {
            try {
                return new MMapBuffer(j, file);
            } catch (Exception e2) {
                b.a("gecko-debug-tag", "mmap failed:", e2);
                try {
                    return new c(j, file);
                } catch (Exception e3) {
                    throw new RuntimeException("create random access file failed! file:" + file.getAbsolutePath() + " caused by:" + e3.getMessage(), e3);
                }
            }
        }
    }
}
