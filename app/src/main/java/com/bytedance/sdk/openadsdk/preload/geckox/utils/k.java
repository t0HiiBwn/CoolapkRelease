package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ResVersionUtils */
public class k {
    public static Long a(File file) {
        Long l2 = null;
        if (file == null) {
            return null;
        }
        File[] listFiles = file.listFiles(new FileFilter() {
            /* class com.bytedance.sdk.openadsdk.preload.geckox.utils.k.AnonymousClass1 */

            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file.isDirectory();
            }
        });
        if (!(listFiles == null || listFiles.length == 0)) {
            for (File file2 : listFiles) {
                try {
                    long longValue = Long.valueOf(file2.getName()).longValue();
                    if (l2 == null) {
                        l2 = Long.valueOf(longValue);
                    } else if (longValue > l2.longValue()) {
                        l2 = Long.valueOf(longValue);
                    }
                } catch (Exception unused) {
                }
            }
        }
        return l2;
    }

    public static List<Long> b(File file) {
        ArrayList arrayList = null;
        if (file == null) {
            return null;
        }
        File[] listFiles = file.listFiles(new FileFilter() {
            /* class com.bytedance.sdk.openadsdk.preload.geckox.utils.k.AnonymousClass2 */

            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file.isDirectory();
            }
        });
        if (!(listFiles == null || listFiles.length == 0)) {
            arrayList = new ArrayList();
            for (File file2 : listFiles) {
                try {
                    arrayList.add(Long.valueOf(Long.valueOf(file2.getName()).longValue()));
                } catch (Exception unused) {
                }
            }
        }
        return arrayList;
    }
}
